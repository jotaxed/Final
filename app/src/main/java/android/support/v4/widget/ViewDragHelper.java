package android.support.v4.widget;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.VelocityTrackerCompat;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.google.android.gms.cast.TextTrackStyle;
import java.util.Arrays;

public class ViewDragHelper {
    private static final int BASE_SETTLE_DURATION = 256;
    public static final int DIRECTION_ALL = 3;
    public static final int DIRECTION_HORIZONTAL = 1;
    public static final int DIRECTION_VERTICAL = 2;
    public static final int EDGE_ALL = 15;
    public static final int EDGE_BOTTOM = 8;
    public static final int EDGE_LEFT = 1;
    public static final int EDGE_RIGHT = 2;
    private static final int EDGE_SIZE = 20;
    public static final int EDGE_TOP = 4;
    public static final int INVALID_POINTER = -1;
    private static final int MAX_SETTLE_DURATION = 600;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_IDLE = 0;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "ViewDragHelper";
    private static final Interpolator sInterpolator = new Interpolator() {
        public float getInterpolation(float t) {
            t -= TextTrackStyle.DEFAULT_FONT_SCALE;
            return ((((t * t) * t) * t) * t) + TextTrackStyle.DEFAULT_FONT_SCALE;
        }
    };
    private int mActivePointerId = -1;
    private final Callback mCallback;
    private View mCapturedView;
    private int mDragState;
    private int[] mEdgeDragsInProgress;
    private int[] mEdgeDragsLocked;
    private int mEdgeSize;
    private int[] mInitialEdgesTouched;
    private float[] mInitialMotionX;
    private float[] mInitialMotionY;
    private float[] mLastMotionX;
    private float[] mLastMotionY;
    private float mMaxVelocity;
    private float mMinVelocity;
    private final ViewGroup mParentView;
    private int mPointersDown;
    private boolean mReleaseInProgress;
    private ScrollerCompat mScroller;
    private final Runnable mSetIdleRunnable = new Runnable() {
        public void run() {
            ViewDragHelper.this.setDragState(0);
        }
    };
    private int mTouchSlop;
    private int mTrackingEdges;
    private VelocityTracker mVelocityTracker;

    public static abstract class Callback {
        public abstract boolean tryCaptureView(View view, int i);

        public void onViewDragStateChanged(int state) {
        }

        public void onViewPositionChanged(View changedView, int left, int top, int dx, int dy) {
        }

        public void onViewCaptured(View capturedChild, int activePointerId) {
        }

        public void onViewReleased(View releasedChild, float xvel, float yvel) {
        }

        public void onEdgeTouched(int edgeFlags, int pointerId) {
        }

        public boolean onEdgeLock(int edgeFlags) {
            return false;
        }

        public void onEdgeDragStarted(int edgeFlags, int pointerId) {
        }

        public int getOrderedChildIndex(int index) {
            return index;
        }

        public int getViewHorizontalDragRange(View child) {
            return 0;
        }

        public int getViewVerticalDragRange(View child) {
            return 0;
        }

        public int clampViewPositionHorizontal(View child, int left, int dx) {
            return 0;
        }

        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }
    }

    public static ViewDragHelper create(ViewGroup forParent, Callback cb) {
        return new ViewDragHelper(forParent.getContext(), forParent, cb);
    }

    public static ViewDragHelper create(ViewGroup forParent, float sensitivity, Callback cb) {
        ViewDragHelper helper = create(forParent, cb);
        helper.mTouchSlop = (int) (((float) helper.mTouchSlop) * (TextTrackStyle.DEFAULT_FONT_SCALE / sensitivity));
        return helper;
    }

    private ViewDragHelper(Context context, ViewGroup forParent, Callback cb) {
        if (forParent == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (cb == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.mParentView = forParent;
            this.mCallback = cb;
            ViewConfiguration vc = ViewConfiguration.get(context);
            this.mEdgeSize = (int) ((20.0f * context.getResources().getDisplayMetrics().density) + 0.5f);
            this.mTouchSlop = vc.getScaledTouchSlop();
            this.mMaxVelocity = (float) vc.getScaledMaximumFlingVelocity();
            this.mMinVelocity = (float) vc.getScaledMinimumFlingVelocity();
            this.mScroller = ScrollerCompat.create(context, sInterpolator);
        }
    }

    public void setMinVelocity(float minVel) {
        this.mMinVelocity = minVel;
    }

    public float getMinVelocity() {
        return this.mMinVelocity;
    }

    public int getViewDragState() {
        return this.mDragState;
    }

    public void setEdgeTrackingEnabled(int edgeFlags) {
        this.mTrackingEdges = edgeFlags;
    }

    public int getEdgeSize() {
        return this.mEdgeSize;
    }

    public void captureChildView(View childView, int activePointerId) {
        if (childView.getParent() != this.mParentView) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.mParentView + ")");
        }
        this.mCapturedView = childView;
        this.mActivePointerId = activePointerId;
        this.mCallback.onViewCaptured(childView, activePointerId);
        setDragState(1);
    }

    public View getCapturedView() {
        return this.mCapturedView;
    }

    public int getActivePointerId() {
        return this.mActivePointerId;
    }

    public int getTouchSlop() {
        return this.mTouchSlop;
    }

    public void cancel() {
        this.mActivePointerId = -1;
        clearMotionHistory();
        if (this.mVelocityTracker != null) {
            this.mVelocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    public void abort() {
        cancel();
        if (this.mDragState == 2) {
            int oldX = this.mScroller.getCurrX();
            int oldY = this.mScroller.getCurrY();
            this.mScroller.abortAnimation();
            int newX = this.mScroller.getCurrX();
            int newY = this.mScroller.getCurrY();
            this.mCallback.onViewPositionChanged(this.mCapturedView, newX, newY, newX - oldX, newY - oldY);
        }
        setDragState(0);
    }

    public boolean smoothSlideViewTo(View child, int finalLeft, int finalTop) {
        this.mCapturedView = child;
        this.mActivePointerId = -1;
        return forceSettleCapturedViewAt(finalLeft, finalTop, 0, 0);
    }

    public boolean settleCapturedViewAt(int finalLeft, int finalTop) {
        if (this.mReleaseInProgress) {
            return forceSettleCapturedViewAt(finalLeft, finalTop, (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    private boolean forceSettleCapturedViewAt(int finalLeft, int finalTop, int xvel, int yvel) {
        int startLeft = this.mCapturedView.getLeft();
        int startTop = this.mCapturedView.getTop();
        int dx = finalLeft - startLeft;
        int dy = finalTop - startTop;
        if (dx == 0 && dy == 0) {
            this.mScroller.abortAnimation();
            setDragState(0);
            return false;
        }
        this.mScroller.startScroll(startLeft, startTop, dx, dy, computeSettleDuration(this.mCapturedView, dx, dy, xvel, yvel));
        setDragState(2);
        return true;
    }

    private int computeSettleDuration(View child, int dx, int dy, int xvel, int yvel) {
        xvel = clampMag(xvel, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        yvel = clampMag(yvel, (int) this.mMinVelocity, (int) this.mMaxVelocity);
        int absDx = Math.abs(dx);
        int absDy = Math.abs(dy);
        int absXVel = Math.abs(xvel);
        int absYVel = Math.abs(yvel);
        int addedVel = absXVel + absYVel;
        int addedDistance = absDx + absDy;
        return (int) ((((float) computeAxisDuration(dx, xvel, this.mCallback.getViewHorizontalDragRange(child))) * (xvel != 0 ? ((float) absXVel) / ((float) addedVel) : ((float) absDx) / ((float) addedDistance))) + (((float) computeAxisDuration(dy, yvel, this.mCallback.getViewVerticalDragRange(child))) * (yvel != 0 ? ((float) absYVel) / ((float) addedVel) : ((float) absDy) / ((float) addedDistance))));
    }

    private int computeAxisDuration(int delta, int velocity, int motionRange) {
        if (delta == 0) {
            return 0;
        }
        int duration;
        int width = this.mParentView.getWidth();
        int halfWidth = width / 2;
        float distance = ((float) halfWidth) + (((float) halfWidth) * distanceInfluenceForSnapDuration(Math.min(TextTrackStyle.DEFAULT_FONT_SCALE, ((float) Math.abs(delta)) / ((float) width))));
        velocity = Math.abs(velocity);
        if (velocity > 0) {
            duration = Math.round(1000.0f * Math.abs(distance / ((float) velocity))) * 4;
        } else {
            duration = (int) (((((float) Math.abs(delta)) / ((float) motionRange)) + TextTrackStyle.DEFAULT_FONT_SCALE) * 256.0f);
        }
        return Math.min(duration, MAX_SETTLE_DURATION);
    }

    private int clampMag(int value, int absMin, int absMax) {
        int absValue = Math.abs(value);
        if (absValue < absMin) {
            return 0;
        }
        if (absValue <= absMax) {
            return value;
        }
        if (value <= 0) {
            return -absMax;
        }
        return absMax;
    }

    private float clampMag(float value, float absMin, float absMax) {
        float absValue = Math.abs(value);
        if (absValue < absMin) {
            return 0.0f;
        }
        if (absValue <= absMax) {
            return value;
        }
        if (value <= 0.0f) {
            return -absMax;
        }
        return absMax;
    }

    private float distanceInfluenceForSnapDuration(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    public void flingCapturedView(int minLeft, int minTop, int maxLeft, int maxTop) {
        if (this.mReleaseInProgress) {
            this.mScroller.fling(this.mCapturedView.getLeft(), this.mCapturedView.getTop(), (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), minLeft, maxLeft, minTop, maxTop);
            setDragState(2);
            return;
        }
        throw new IllegalStateException("Cannot flingCapturedView outside of a call to Callback#onViewReleased");
    }

    public boolean continueSettling(boolean deferCallbacks) {
        if (this.mDragState == 2) {
            boolean keepGoing = this.mScroller.computeScrollOffset();
            int x = this.mScroller.getCurrX();
            int y = this.mScroller.getCurrY();
            int dx = x - this.mCapturedView.getLeft();
            int dy = y - this.mCapturedView.getTop();
            if (dx != 0) {
                this.mCapturedView.offsetLeftAndRight(dx);
            }
            if (dy != 0) {
                this.mCapturedView.offsetTopAndBottom(dy);
            }
            if (!(dx == 0 && dy == 0)) {
                this.mCallback.onViewPositionChanged(this.mCapturedView, x, y, dx, dy);
            }
            if (keepGoing && x == this.mScroller.getFinalX() && y == this.mScroller.getFinalY()) {
                this.mScroller.abortAnimation();
                keepGoing = this.mScroller.isFinished();
            }
            if (!keepGoing) {
                if (deferCallbacks) {
                    this.mParentView.post(this.mSetIdleRunnable);
                } else {
                    setDragState(0);
                }
            }
        }
        return this.mDragState == 2;
    }

    private void dispatchViewReleased(float xvel, float yvel) {
        this.mReleaseInProgress = true;
        this.mCallback.onViewReleased(this.mCapturedView, xvel, yvel);
        this.mReleaseInProgress = false;
        if (this.mDragState == 1) {
            setDragState(0);
        }
    }

    private void clearMotionHistory() {
        if (this.mInitialMotionX != null) {
            Arrays.fill(this.mInitialMotionX, 0.0f);
            Arrays.fill(this.mInitialMotionY, 0.0f);
            Arrays.fill(this.mLastMotionX, 0.0f);
            Arrays.fill(this.mLastMotionY, 0.0f);
            Arrays.fill(this.mInitialEdgesTouched, 0);
            Arrays.fill(this.mEdgeDragsInProgress, 0);
            Arrays.fill(this.mEdgeDragsLocked, 0);
            this.mPointersDown = 0;
        }
    }

    private void clearMotionHistory(int pointerId) {
        if (this.mInitialMotionX != null) {
            this.mInitialMotionX[pointerId] = 0.0f;
            this.mInitialMotionY[pointerId] = 0.0f;
            this.mLastMotionX[pointerId] = 0.0f;
            this.mLastMotionY[pointerId] = 0.0f;
            this.mInitialEdgesTouched[pointerId] = 0;
            this.mEdgeDragsInProgress[pointerId] = 0;
            this.mEdgeDragsLocked[pointerId] = 0;
            this.mPointersDown &= (1 << pointerId) ^ -1;
        }
    }

    private void ensureMotionHistorySizeForId(int pointerId) {
        if (this.mInitialMotionX == null || this.mInitialMotionX.length <= pointerId) {
            float[] imx = new float[(pointerId + 1)];
            float[] imy = new float[(pointerId + 1)];
            float[] lmx = new float[(pointerId + 1)];
            float[] lmy = new float[(pointerId + 1)];
            int[] iit = new int[(pointerId + 1)];
            int[] edip = new int[(pointerId + 1)];
            int[] edl = new int[(pointerId + 1)];
            if (this.mInitialMotionX != null) {
                System.arraycopy(this.mInitialMotionX, 0, imx, 0, this.mInitialMotionX.length);
                System.arraycopy(this.mInitialMotionY, 0, imy, 0, this.mInitialMotionY.length);
                System.arraycopy(this.mLastMotionX, 0, lmx, 0, this.mLastMotionX.length);
                System.arraycopy(this.mLastMotionY, 0, lmy, 0, this.mLastMotionY.length);
                System.arraycopy(this.mInitialEdgesTouched, 0, iit, 0, this.mInitialEdgesTouched.length);
                System.arraycopy(this.mEdgeDragsInProgress, 0, edip, 0, this.mEdgeDragsInProgress.length);
                System.arraycopy(this.mEdgeDragsLocked, 0, edl, 0, this.mEdgeDragsLocked.length);
            }
            this.mInitialMotionX = imx;
            this.mInitialMotionY = imy;
            this.mLastMotionX = lmx;
            this.mLastMotionY = lmy;
            this.mInitialEdgesTouched = iit;
            this.mEdgeDragsInProgress = edip;
            this.mEdgeDragsLocked = edl;
        }
    }

    private void saveInitialMotion(float x, float y, int pointerId) {
        ensureMotionHistorySizeForId(pointerId);
        float[] fArr = this.mInitialMotionX;
        this.mLastMotionX[pointerId] = x;
        fArr[pointerId] = x;
        fArr = this.mInitialMotionY;
        this.mLastMotionY[pointerId] = y;
        fArr[pointerId] = y;
        this.mInitialEdgesTouched[pointerId] = getEdgesTouched((int) x, (int) y);
        this.mPointersDown |= 1 << pointerId;
    }

    private void saveLastMotion(MotionEvent ev) {
        int pointerCount = MotionEventCompat.getPointerCount(ev);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(ev, i);
            float x = MotionEventCompat.getX(ev, i);
            float y = MotionEventCompat.getY(ev, i);
            this.mLastMotionX[pointerId] = x;
            this.mLastMotionY[pointerId] = y;
        }
    }

    public boolean isPointerDown(int pointerId) {
        return (this.mPointersDown & (1 << pointerId)) != 0;
    }

    void setDragState(int state) {
        if (this.mDragState != state) {
            this.mDragState = state;
            this.mCallback.onViewDragStateChanged(state);
            if (state == 0) {
                this.mCapturedView = null;
            }
        }
    }

    boolean tryCaptureViewForDrag(View toCapture, int pointerId) {
        if (toCapture == this.mCapturedView && this.mActivePointerId == pointerId) {
            return true;
        }
        if (toCapture == null || !this.mCallback.tryCaptureView(toCapture, pointerId)) {
            return false;
        }
        this.mActivePointerId = pointerId;
        captureChildView(toCapture, pointerId);
        return true;
    }

    protected boolean canScroll(View v, boolean checkV, int dx, int dy, int x, int y) {
        if (v instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) v;
            int scrollX = v.getScrollX();
            int scrollY = v.getScrollY();
            for (int i = group.getChildCount() - 1; i >= 0; i--) {
                View child = group.getChildAt(i);
                if (x + scrollX >= child.getLeft() && x + scrollX < child.getRight() && y + scrollY >= child.getTop() && y + scrollY < child.getBottom()) {
                    if (canScroll(child, true, dx, dy, (x + scrollX) - child.getLeft(), (y + scrollY) - child.getTop())) {
                        return true;
                    }
                }
            }
        }
        return checkV && (ViewCompat.canScrollHorizontally(v, -dx) || ViewCompat.canScrollVertically(v, -dy));
    }

    public boolean shouldInterceptTouchEvent(MotionEvent ev) {
        int action = MotionEventCompat.getActionMasked(ev);
        int actionIndex = MotionEventCompat.getActionIndex(ev);
        if (action == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(ev);
        float x;
        float y;
        int pointerId;
        View toCapture;
        int edgesTouched;
        switch (action) {
            case 0:
                x = ev.getX();
                y = ev.getY();
                pointerId = MotionEventCompat.getPointerId(ev, 0);
                saveInitialMotion(x, y, pointerId);
                toCapture = findTopChildUnder((int) x, (int) y);
                if (toCapture == this.mCapturedView && this.mDragState == 2) {
                    tryCaptureViewForDrag(toCapture, pointerId);
                }
                edgesTouched = this.mInitialEdgesTouched[pointerId];
                if ((this.mTrackingEdges & edgesTouched) != 0) {
                    this.mCallback.onEdgeTouched(this.mTrackingEdges & edgesTouched, pointerId);
                    break;
                }
                break;
            case 1:
            case 3:
                cancel();
                break;
            case 2:
                int pointerCount = MotionEventCompat.getPointerCount(ev);
                int i = 0;
                while (i < pointerCount) {
                    pointerId = MotionEventCompat.getPointerId(ev, i);
                    x = MotionEventCompat.getX(ev, i);
                    y = MotionEventCompat.getY(ev, i);
                    float dx = x - this.mInitialMotionX[pointerId];
                    float dy = y - this.mInitialMotionY[pointerId];
                    reportNewEdgeDrags(dx, dy, pointerId);
                    if (this.mDragState != 1) {
                        toCapture = findTopChildUnder((int) x, (int) y);
                        if (toCapture == null || !checkTouchSlop(toCapture, dx, dy) || !tryCaptureViewForDrag(toCapture, pointerId)) {
                            i++;
                        }
                    }
                    saveLastMotion(ev);
                    break;
                }
                saveLastMotion(ev);
                break;
            case 5:
                pointerId = MotionEventCompat.getPointerId(ev, actionIndex);
                x = MotionEventCompat.getX(ev, actionIndex);
                y = MotionEventCompat.getY(ev, actionIndex);
                saveInitialMotion(x, y, pointerId);
                if (this.mDragState != 0) {
                    if (this.mDragState == 2) {
                        toCapture = findTopChildUnder((int) x, (int) y);
                        if (toCapture == this.mCapturedView) {
                            tryCaptureViewForDrag(toCapture, pointerId);
                            break;
                        }
                    }
                }
                edgesTouched = this.mInitialEdgesTouched[pointerId];
                if ((this.mTrackingEdges & edgesTouched) != 0) {
                    this.mCallback.onEdgeTouched(this.mTrackingEdges & edgesTouched, pointerId);
                    break;
                }
                break;
            case 6:
                clearMotionHistory(MotionEventCompat.getPointerId(ev, actionIndex));
                break;
        }
        if (this.mDragState == 1) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processTouchEvent(android.view.MotionEvent r22) {
        /*
        r21 = this;
        r3 = android.support.v4.view.MotionEventCompat.getActionMasked(r22);
        r4 = android.support.v4.view.MotionEventCompat.getActionIndex(r22);
        if (r3 != 0) goto L_0x000d;
    L_0x000a:
        r21.cancel();
    L_0x000d:
        r0 = r21;
        r0 = r0.mVelocityTracker;
        r19 = r0;
        if (r19 != 0) goto L_0x001f;
    L_0x0015:
        r19 = android.view.VelocityTracker.obtain();
        r0 = r19;
        r1 = r21;
        r1.mVelocityTracker = r0;
    L_0x001f:
        r0 = r21;
        r0 = r0.mVelocityTracker;
        r19 = r0;
        r0 = r19;
        r1 = r22;
        r0.addMovement(r1);
        switch(r3) {
            case 0: goto L_0x0030;
            case 1: goto L_0x0287;
            case 2: goto L_0x011a;
            case 3: goto L_0x029d;
            case 4: goto L_0x002f;
            case 5: goto L_0x008e;
            case 6: goto L_0x01fe;
            default: goto L_0x002f;
        };
    L_0x002f:
        return;
    L_0x0030:
        r17 = r22.getX();
        r18 = r22.getY();
        r19 = 0;
        r0 = r22;
        r1 = r19;
        r15 = android.support.v4.view.MotionEventCompat.getPointerId(r0, r1);
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r16 = r0.findTopChildUnder(r1, r2);
        r0 = r21;
        r1 = r17;
        r2 = r18;
        r0.saveInitialMotion(r1, r2, r15);
        r0 = r21;
        r1 = r16;
        r0.tryCaptureViewForDrag(r1, r15);
        r0 = r21;
        r0 = r0.mInitialEdgesTouched;
        r19 = r0;
        r7 = r19[r15];
        r0 = r21;
        r0 = r0.mTrackingEdges;
        r19 = r0;
        r19 = r19 & r7;
        if (r19 == 0) goto L_0x002f;
    L_0x0078:
        r0 = r21;
        r0 = r0.mCallback;
        r19 = r0;
        r0 = r21;
        r0 = r0.mTrackingEdges;
        r20 = r0;
        r20 = r20 & r7;
        r0 = r19;
        r1 = r20;
        r0.onEdgeTouched(r1, r15);
        goto L_0x002f;
    L_0x008e:
        r0 = r22;
        r15 = android.support.v4.view.MotionEventCompat.getPointerId(r0, r4);
        r0 = r22;
        r17 = android.support.v4.view.MotionEventCompat.getX(r0, r4);
        r0 = r22;
        r18 = android.support.v4.view.MotionEventCompat.getY(r0, r4);
        r0 = r21;
        r1 = r17;
        r2 = r18;
        r0.saveInitialMotion(r1, r2, r15);
        r0 = r21;
        r0 = r0.mDragState;
        r19 = r0;
        if (r19 != 0) goto L_0x00f5;
    L_0x00b1:
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r16 = r0.findTopChildUnder(r1, r2);
        r0 = r21;
        r1 = r16;
        r0.tryCaptureViewForDrag(r1, r15);
        r0 = r21;
        r0 = r0.mInitialEdgesTouched;
        r19 = r0;
        r7 = r19[r15];
        r0 = r21;
        r0 = r0.mTrackingEdges;
        r19 = r0;
        r19 = r19 & r7;
        if (r19 == 0) goto L_0x002f;
    L_0x00de:
        r0 = r21;
        r0 = r0.mCallback;
        r19 = r0;
        r0 = r21;
        r0 = r0.mTrackingEdges;
        r20 = r0;
        r20 = r20 & r7;
        r0 = r19;
        r1 = r20;
        r0.onEdgeTouched(r1, r15);
        goto L_0x002f;
    L_0x00f5:
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r19 = r0.isCapturedViewUnder(r1, r2);
        if (r19 == 0) goto L_0x002f;
    L_0x010b:
        r0 = r21;
        r0 = r0.mCapturedView;
        r19 = r0;
        r0 = r21;
        r1 = r19;
        r0.tryCaptureViewForDrag(r1, r15);
        goto L_0x002f;
    L_0x011a:
        r0 = r21;
        r0 = r0.mDragState;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x018e;
    L_0x0128:
        r0 = r21;
        r0 = r0.mActivePointerId;
        r19 = r0;
        r0 = r22;
        r1 = r19;
        r12 = android.support.v4.view.MotionEventCompat.findPointerIndex(r0, r1);
        r0 = r22;
        r17 = android.support.v4.view.MotionEventCompat.getX(r0, r12);
        r0 = r22;
        r18 = android.support.v4.view.MotionEventCompat.getY(r0, r12);
        r0 = r21;
        r0 = r0.mLastMotionX;
        r19 = r0;
        r0 = r21;
        r0 = r0.mActivePointerId;
        r20 = r0;
        r19 = r19[r20];
        r19 = r17 - r19;
        r0 = r19;
        r10 = (int) r0;
        r0 = r21;
        r0 = r0.mLastMotionY;
        r19 = r0;
        r0 = r21;
        r0 = r0.mActivePointerId;
        r20 = r0;
        r19 = r19[r20];
        r19 = r18 - r19;
        r0 = r19;
        r11 = (int) r0;
        r0 = r21;
        r0 = r0.mCapturedView;
        r19 = r0;
        r19 = r19.getLeft();
        r19 = r19 + r10;
        r0 = r21;
        r0 = r0.mCapturedView;
        r20 = r0;
        r20 = r20.getTop();
        r20 = r20 + r11;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r0.dragTo(r1, r2, r10, r11);
        r21.saveLastMotion(r22);
        goto L_0x002f;
    L_0x018e:
        r14 = android.support.v4.view.MotionEventCompat.getPointerCount(r22);
        r8 = 0;
    L_0x0193:
        if (r8 >= r14) goto L_0x01ce;
    L_0x0195:
        r0 = r22;
        r15 = android.support.v4.view.MotionEventCompat.getPointerId(r0, r8);
        r0 = r22;
        r17 = android.support.v4.view.MotionEventCompat.getX(r0, r8);
        r0 = r22;
        r18 = android.support.v4.view.MotionEventCompat.getY(r0, r8);
        r0 = r21;
        r0 = r0.mInitialMotionX;
        r19 = r0;
        r19 = r19[r15];
        r5 = r17 - r19;
        r0 = r21;
        r0 = r0.mInitialMotionY;
        r19 = r0;
        r19 = r19[r15];
        r6 = r18 - r19;
        r0 = r21;
        r0.reportNewEdgeDrags(r5, r6, r15);
        r0 = r21;
        r0 = r0.mDragState;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x01d3;
    L_0x01ce:
        r21.saveLastMotion(r22);
        goto L_0x002f;
    L_0x01d3:
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r16 = r0.findTopChildUnder(r1, r2);
        r0 = r21;
        r1 = r16;
        r19 = r0.checkTouchSlop(r1, r5, r6);
        if (r19 == 0) goto L_0x01fb;
    L_0x01f1:
        r0 = r21;
        r1 = r16;
        r19 = r0.tryCaptureViewForDrag(r1, r15);
        if (r19 != 0) goto L_0x01ce;
    L_0x01fb:
        r8 = r8 + 1;
        goto L_0x0193;
    L_0x01fe:
        r0 = r22;
        r15 = android.support.v4.view.MotionEventCompat.getPointerId(r0, r4);
        r0 = r21;
        r0 = r0.mDragState;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x0280;
    L_0x0212:
        r0 = r21;
        r0 = r0.mActivePointerId;
        r19 = r0;
        r0 = r19;
        if (r15 != r0) goto L_0x0280;
    L_0x021c:
        r13 = -1;
        r14 = android.support.v4.view.MotionEventCompat.getPointerCount(r22);
        r8 = 0;
    L_0x0222:
        if (r8 >= r14) goto L_0x0277;
    L_0x0224:
        r0 = r22;
        r9 = android.support.v4.view.MotionEventCompat.getPointerId(r0, r8);
        r0 = r21;
        r0 = r0.mActivePointerId;
        r19 = r0;
        r0 = r19;
        if (r9 != r0) goto L_0x0237;
    L_0x0234:
        r8 = r8 + 1;
        goto L_0x0222;
    L_0x0237:
        r0 = r22;
        r17 = android.support.v4.view.MotionEventCompat.getX(r0, r8);
        r0 = r22;
        r18 = android.support.v4.view.MotionEventCompat.getY(r0, r8);
        r0 = r17;
        r0 = (int) r0;
        r19 = r0;
        r0 = r18;
        r0 = (int) r0;
        r20 = r0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r19 = r0.findTopChildUnder(r1, r2);
        r0 = r21;
        r0 = r0.mCapturedView;
        r20 = r0;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x0234;
    L_0x0263:
        r0 = r21;
        r0 = r0.mCapturedView;
        r19 = r0;
        r0 = r21;
        r1 = r19;
        r19 = r0.tryCaptureViewForDrag(r1, r9);
        if (r19 == 0) goto L_0x0234;
    L_0x0273:
        r0 = r21;
        r13 = r0.mActivePointerId;
    L_0x0277:
        r19 = -1;
        r0 = r19;
        if (r13 != r0) goto L_0x0280;
    L_0x027d:
        r21.releaseViewForPointerUp();
    L_0x0280:
        r0 = r21;
        r0.clearMotionHistory(r15);
        goto L_0x002f;
    L_0x0287:
        r0 = r21;
        r0 = r0.mDragState;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x0298;
    L_0x0295:
        r21.releaseViewForPointerUp();
    L_0x0298:
        r21.cancel();
        goto L_0x002f;
    L_0x029d:
        r0 = r21;
        r0 = r0.mDragState;
        r19 = r0;
        r20 = 1;
        r0 = r19;
        r1 = r20;
        if (r0 != r1) goto L_0x02b8;
    L_0x02ab:
        r19 = 0;
        r20 = 0;
        r0 = r21;
        r1 = r19;
        r2 = r20;
        r0.dispatchViewReleased(r1, r2);
    L_0x02b8:
        r21.cancel();
        goto L_0x002f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ViewDragHelper.processTouchEvent(android.view.MotionEvent):void");
    }

    private void reportNewEdgeDrags(float dx, float dy, int pointerId) {
        int dragsStarted = 0;
        if (checkNewEdgeDrag(dx, dy, pointerId, 1)) {
            dragsStarted = 0 | 1;
        }
        if (checkNewEdgeDrag(dy, dx, pointerId, 4)) {
            dragsStarted |= 4;
        }
        if (checkNewEdgeDrag(dx, dy, pointerId, 2)) {
            dragsStarted |= 2;
        }
        if (checkNewEdgeDrag(dy, dx, pointerId, 8)) {
            dragsStarted |= 8;
        }
        if (dragsStarted != 0) {
            int[] iArr = this.mEdgeDragsInProgress;
            iArr[pointerId] = iArr[pointerId] | dragsStarted;
            this.mCallback.onEdgeDragStarted(dragsStarted, pointerId);
        }
    }

    private boolean checkNewEdgeDrag(float delta, float odelta, int pointerId, int edge) {
        float absDelta = Math.abs(delta);
        float absODelta = Math.abs(odelta);
        if ((this.mInitialEdgesTouched[pointerId] & edge) != edge || (this.mTrackingEdges & edge) == 0 || (this.mEdgeDragsLocked[pointerId] & edge) == edge || (this.mEdgeDragsInProgress[pointerId] & edge) == edge) {
            return false;
        }
        if (absDelta <= ((float) this.mTouchSlop) && absODelta <= ((float) this.mTouchSlop)) {
            return false;
        }
        if (absDelta < 0.5f * absODelta && this.mCallback.onEdgeLock(edge)) {
            int[] iArr = this.mEdgeDragsLocked;
            iArr[pointerId] = iArr[pointerId] | edge;
            return false;
        } else if ((this.mEdgeDragsInProgress[pointerId] & edge) != 0 || absDelta <= ((float) this.mTouchSlop)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean checkTouchSlop(View child, float dx, float dy) {
        if (child == null) {
            return false;
        }
        boolean checkHorizontal;
        boolean checkVertical;
        if (this.mCallback.getViewHorizontalDragRange(child) > 0) {
            checkHorizontal = true;
        } else {
            checkHorizontal = false;
        }
        if (this.mCallback.getViewVerticalDragRange(child) > 0) {
            checkVertical = true;
        } else {
            checkVertical = false;
        }
        if (checkHorizontal && checkVertical) {
            if ((dx * dx) + (dy * dy) <= ((float) (this.mTouchSlop * this.mTouchSlop))) {
                return false;
            }
            return true;
        } else if (checkHorizontal) {
            if (Math.abs(dx) <= ((float) this.mTouchSlop)) {
                return false;
            }
            return true;
        } else if (!checkVertical) {
            return false;
        } else {
            if (Math.abs(dy) <= ((float) this.mTouchSlop)) {
                return false;
            }
            return true;
        }
    }

    public boolean checkTouchSlop(int directions) {
        int count = this.mInitialMotionX.length;
        for (int i = 0; i < count; i++) {
            if (checkTouchSlop(directions, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkTouchSlop(int directions, int pointerId) {
        if (!isPointerDown(pointerId)) {
            return false;
        }
        boolean checkHorizontal;
        boolean checkVertical;
        if ((directions & 1) == 1) {
            checkHorizontal = true;
        } else {
            checkHorizontal = false;
        }
        if ((directions & 2) == 2) {
            checkVertical = true;
        } else {
            checkVertical = false;
        }
        float dx = this.mLastMotionX[pointerId] - this.mInitialMotionX[pointerId];
        float dy = this.mLastMotionY[pointerId] - this.mInitialMotionY[pointerId];
        if (checkHorizontal && checkVertical) {
            if ((dx * dx) + (dy * dy) <= ((float) (this.mTouchSlop * this.mTouchSlop))) {
                return false;
            }
            return true;
        } else if (checkHorizontal) {
            if (Math.abs(dx) <= ((float) this.mTouchSlop)) {
                return false;
            }
            return true;
        } else if (!checkVertical) {
            return false;
        } else {
            if (Math.abs(dy) <= ((float) this.mTouchSlop)) {
                return false;
            }
            return true;
        }
    }

    public boolean isEdgeTouched(int edges) {
        int count = this.mInitialEdgesTouched.length;
        for (int i = 0; i < count; i++) {
            if (isEdgeTouched(edges, i)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEdgeTouched(int edges, int pointerId) {
        return isPointerDown(pointerId) && (this.mInitialEdgesTouched[pointerId] & edges) != 0;
    }

    private void releaseViewForPointerUp() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaxVelocity);
        dispatchViewReleased(clampMag(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity), clampMag(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.mMinVelocity, this.mMaxVelocity));
    }

    private void dragTo(int left, int top, int dx, int dy) {
        int clampedX = left;
        int clampedY = top;
        int oldLeft = this.mCapturedView.getLeft();
        int oldTop = this.mCapturedView.getTop();
        if (dx != 0) {
            clampedX = this.mCallback.clampViewPositionHorizontal(this.mCapturedView, left, dx);
            this.mCapturedView.offsetLeftAndRight(clampedX - oldLeft);
        }
        if (dy != 0) {
            clampedY = this.mCallback.clampViewPositionVertical(this.mCapturedView, top, dy);
            this.mCapturedView.offsetTopAndBottom(clampedY - oldTop);
        }
        if (dx != 0 || dy != 0) {
            this.mCallback.onViewPositionChanged(this.mCapturedView, clampedX, clampedY, clampedX - oldLeft, clampedY - oldTop);
        }
    }

    public boolean isCapturedViewUnder(int x, int y) {
        return isViewUnder(this.mCapturedView, x, y);
    }

    public boolean isViewUnder(View view, int x, int y) {
        if (view != null && x >= view.getLeft() && x < view.getRight() && y >= view.getTop() && y < view.getBottom()) {
            return true;
        }
        return false;
    }

    public View findTopChildUnder(int x, int y) {
        for (int i = this.mParentView.getChildCount() - 1; i >= 0; i--) {
            View child = this.mParentView.getChildAt(this.mCallback.getOrderedChildIndex(i));
            if (x >= child.getLeft() && x < child.getRight() && y >= child.getTop() && y < child.getBottom()) {
                return child;
            }
        }
        return null;
    }

    private int getEdgesTouched(int x, int y) {
        int result = 0;
        if (x < this.mParentView.getLeft() + this.mEdgeSize) {
            result = 0 | 1;
        }
        if (y < this.mParentView.getTop() + this.mEdgeSize) {
            result |= 4;
        }
        if (x > this.mParentView.getRight() - this.mEdgeSize) {
            result |= 2;
        }
        if (y > this.mParentView.getBottom() - this.mEdgeSize) {
            return result | 8;
        }
        return result;
    }
}
