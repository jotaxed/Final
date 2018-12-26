package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public class d {
    public static boolean a(int i, DriveId driveId) {
        return driveId != null || bi(i);
    }

    public static boolean bi(int i) {
        return (2 & ((long) (1 << i))) != 0;
    }
}
