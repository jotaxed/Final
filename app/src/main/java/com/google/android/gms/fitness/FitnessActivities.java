package com.google.android.gms.fitness;

import android.util.SparseArray;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.location.LocationRequest;

public class FitnessActivities {
    public static final String AEROBICS = "aerobics";
    public static final String BADMINTON = "badminton";
    public static final String BASEBALL = "baseball";
    public static final String BASKETBALL = "basketball";
    public static final String BIATHLON = "biathlon";
    public static final String BIKING = "biking";
    public static final String BIKING_HAND = "biking.hand";
    public static final String BIKING_MOUNTAIN = "biking.mountain";
    public static final String BIKING_ROAD = "biking.road";
    public static final String BIKING_SPINNING = "biking.spinning";
    public static final String BIKING_STATIONARY = "biking.stationary";
    public static final String BIKING_UTILITY = "biking.utility";
    public static final String BOXING = "boxing";
    public static final String CALISTHENICS = "calisthenics";
    public static final String CIRCUIT_TRAINING = "circuit_training";
    public static final String CRICKET = "cricket";
    public static final String CURLING = "curling";
    public static final String DANCING = "dancing";
    public static final String DIVING = "diving";
    public static final String ELLIPTICAL = "elliptical";
    public static final String ERGOMETER = "ergometer";
    public static final String EXTRA_STATUS = "actionStatus";
    public static final String FENCING = "fencing";
    public static final String FOOTBALL_AMERICAN = "football.american";
    public static final String FOOTBALL_AUSTRALIAN = "football.australian";
    public static final String FOOTBALL_SOCCER = "football.soccer";
    public static final String FRISBEE_DISC = "frisbee_disc";
    public static final String GARDENING = "gardening";
    public static final String GOLF = "golf";
    public static final String GYMNASTICS = "gymnastics";
    public static final String HANDBALL = "handball";
    public static final String HIKING = "hiking";
    public static final String HOCKEY = "hockey";
    public static final String HORSEBACK_RIDING = "horseback_riding";
    public static final String HOUSEWORK = "housework";
    public static final String ICE_SKATING = "ice_skating";
    public static final String IN_VEHICLE = "in_vehicle";
    public static final String JUMP_ROPE = "jump_rope";
    public static final String KAYAKING = "kayaking";
    public static final String KETTLEBELL_TRAINING = "kettlebell_training";
    public static final String KICKBOXING = "kickboxing";
    public static final String KICK_SCOOTER = "kick_scooter";
    public static final String KITESURFING = "kitesurfing";
    public static final String MARTIAL_ARTS = "martial_arts";
    public static final String MEDITATION = "meditation";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.activity/";
    public static final String MIXED_MARTIAL_ARTS = "martial_arts.mixed";
    public static final String ON_FOOT = "on_foot";
    public static final String OTHER = "other";
    public static final String P90X = "p90x";
    public static final String PARAGLIDING = "paragliding";
    public static final String PILATES = "pilates";
    public static final String POLO = "polo";
    public static final String RACQUETBALL = "racquetball";
    public static final String ROCK_CLIMBING = "rock_climbing";
    public static final String ROWING = "rowing";
    public static final String ROWING_MACHINE = "rowing.machine";
    public static final String RUGBY = "rugby";
    public static final String RUNNING = "running";
    public static final String RUNNING_JOGGING = "running.jogging";
    public static final String RUNNING_SAND = "running.sand";
    public static final String RUNNING_TREADMILL = "running.treadmill";
    public static final String SAILING = "sailing";
    public static final String SCUBA_DIVING = "scuba_diving";
    public static final String SKATEBOARDING = "skateboarding";
    public static final String SKATING = "skating";
    public static final String SKATING_CROSS = "skating.cross";
    public static final String SKATING_INDOOR = "skating.indoor";
    public static final String SKATING_INLINE = "skating.inline";
    public static final String SKIING = "skiing";
    public static final String SKIING_BACK_COUNTRY = "skiing.back_country";
    public static final String SKIING_CROSS_COUNTRY = "skiing.cross_country";
    public static final String SKIING_DOWNHILL = "skiing.downhill";
    public static final String SKIING_KITE = "skiing.kite";
    public static final String SKIING_ROLLER = "skiing.roller";
    public static final String SLEDDING = "sledding";
    public static final String SLEEP = "sleep";
    public static final String SNOWBOARDING = "snowboarding";
    public static final String SNOWMOBILE = "snowmobile";
    public static final String SNOWSHOEING = "snowshoeing";
    public static final String SQUASH = "squash";
    public static final String STAIR_CLIMBING = "stair_climbing";
    public static final String STAIR_CLIMBING_MACHINE = "stair_climbing.machine";
    public static final String STANDUP_PADDLEBOARDING = "standup_paddleboarding";
    public static final String STATUS_ACTIVE = "ActiveActionStatus";
    public static final String STATUS_COMPLETED = "CompletedActionStatus";
    public static final String STILL = "still";
    public static final String STRENGTH_TRAINING = "strength_training";
    public static final String SURFING = "surfing";
    public static final String SWIMMING = "swimming";
    public static final String SWIMMING_OPEN_WATER = "swimming.open_water";
    public static final String SWIMMING_POOL = "swimming.pool";
    public static final String TABLE_TENNIS = "table_tennis";
    public static final String TEAM_SPORTS = "team_sports";
    public static final String TENNIS = "tennis";
    public static final String TILTING = "tilting";
    private static final SparseArray<String> TL = new SparseArray(109);
    public static final String TREADMILL = "treadmill";
    public static final String UNKNOWN = "unknown";
    public static final String VOLLEYBALL = "volleyball";
    public static final String VOLLEYBALL_BEACH = "volleyball.beach";
    public static final String VOLLEYBALL_INDOOR = "volleyball.indoor";
    public static final String WAKEBOARDING = "wakeboarding";
    public static final String WALKING = "walking";
    public static final String WALKING_FITNESS = "walking.fitness";
    public static final String WALKING_NORDIC = "walking.nordic";
    public static final String WALKING_TREADMILL = "walking.treadmill";
    public static final String WATER_POLO = "water_polo";
    public static final String WEIGHTLIFTING = "weightlifting";
    public static final String WHEELCHAIR = "wheelchair";
    public static final String WINDSURFING = "windsurfing";
    public static final String YOGA = "yoga";
    public static final String ZUMBA = "zumba";

    static {
        TL.put(9, AEROBICS);
        TL.put(10, BADMINTON);
        TL.put(11, BASEBALL);
        TL.put(12, BASKETBALL);
        TL.put(13, BIATHLON);
        TL.put(1, BIKING);
        TL.put(14, BIKING_HAND);
        TL.put(15, BIKING_MOUNTAIN);
        TL.put(16, BIKING_ROAD);
        TL.put(17, BIKING_SPINNING);
        TL.put(18, BIKING_STATIONARY);
        TL.put(19, BIKING_UTILITY);
        TL.put(20, BOXING);
        TL.put(21, CALISTHENICS);
        TL.put(22, CIRCUIT_TRAINING);
        TL.put(23, CRICKET);
        TL.put(106, CURLING);
        TL.put(24, DANCING);
        TL.put(102, DIVING);
        TL.put(25, ELLIPTICAL);
        TL.put(Quests.SELECT_RECENTLY_FAILED, ERGOMETER);
        TL.put(6, "exiting_vehicle");
        TL.put(26, FENCING);
        TL.put(27, FOOTBALL_AMERICAN);
        TL.put(28, FOOTBALL_AUSTRALIAN);
        TL.put(29, FOOTBALL_SOCCER);
        TL.put(30, FRISBEE_DISC);
        TL.put(31, GARDENING);
        TL.put(32, GOLF);
        TL.put(33, GYMNASTICS);
        TL.put(34, HANDBALL);
        TL.put(35, HIKING);
        TL.put(36, HOCKEY);
        TL.put(37, HORSEBACK_RIDING);
        TL.put(38, HOUSEWORK);
        TL.put(LocationRequest.PRIORITY_LOW_POWER, ICE_SKATING);
        TL.put(0, IN_VEHICLE);
        TL.put(39, JUMP_ROPE);
        TL.put(40, KAYAKING);
        TL.put(41, KETTLEBELL_TRAINING);
        TL.put(107, KICK_SCOOTER);
        TL.put(42, KICKBOXING);
        TL.put(43, KITESURFING);
        TL.put(44, MARTIAL_ARTS);
        TL.put(45, MEDITATION);
        TL.put(46, MIXED_MARTIAL_ARTS);
        TL.put(2, ON_FOOT);
        TL.put(108, OTHER);
        TL.put(47, P90X);
        TL.put(48, PARAGLIDING);
        TL.put(49, PILATES);
        TL.put(50, POLO);
        TL.put(51, RACQUETBALL);
        TL.put(52, ROCK_CLIMBING);
        TL.put(53, ROWING);
        TL.put(54, ROWING_MACHINE);
        TL.put(55, RUGBY);
        TL.put(8, RUNNING);
        TL.put(56, RUNNING_JOGGING);
        TL.put(57, RUNNING_SAND);
        TL.put(58, RUNNING_TREADMILL);
        TL.put(59, SAILING);
        TL.put(60, SCUBA_DIVING);
        TL.put(61, SKATEBOARDING);
        TL.put(62, SKATING);
        TL.put(63, SKATING_CROSS);
        TL.put(LocationRequest.PRIORITY_NO_POWER, SKATING_INDOOR);
        TL.put(64, SKATING_INLINE);
        TL.put(65, SKIING);
        TL.put(66, SKIING_BACK_COUNTRY);
        TL.put(67, SKIING_CROSS_COUNTRY);
        TL.put(68, SKIING_DOWNHILL);
        TL.put(69, SKIING_KITE);
        TL.put(70, SKIING_ROLLER);
        TL.put(71, SLEDDING);
        TL.put(72, SLEEP);
        TL.put(73, SNOWBOARDING);
        TL.put(74, SNOWMOBILE);
        TL.put(75, SNOWSHOEING);
        TL.put(76, SQUASH);
        TL.put(77, STAIR_CLIMBING);
        TL.put(78, STAIR_CLIMBING_MACHINE);
        TL.put(79, STANDUP_PADDLEBOARDING);
        TL.put(3, STILL);
        TL.put(80, STRENGTH_TRAINING);
        TL.put(81, SURFING);
        TL.put(82, SWIMMING);
        TL.put(83, SWIMMING_POOL);
        TL.put(84, SWIMMING_OPEN_WATER);
        TL.put(85, TABLE_TENNIS);
        TL.put(86, TEAM_SPORTS);
        TL.put(87, TENNIS);
        TL.put(5, TILTING);
        TL.put(88, TREADMILL);
        TL.put(4, UNKNOWN);
        TL.put(89, VOLLEYBALL);
        TL.put(90, VOLLEYBALL_BEACH);
        TL.put(91, VOLLEYBALL_INDOOR);
        TL.put(92, WAKEBOARDING);
        TL.put(7, WALKING);
        TL.put(93, WALKING_FITNESS);
        TL.put(94, WALKING_NORDIC);
        TL.put(95, WALKING_TREADMILL);
        TL.put(96, WATER_POLO);
        TL.put(97, WEIGHTLIFTING);
        TL.put(98, WHEELCHAIR);
        TL.put(99, WINDSURFING);
        TL.put(100, YOGA);
        TL.put(Quests.SELECT_COMPLETED_UNCLAIMED, ZUMBA);
    }

    FitnessActivities() {
    }

    public static int bs(String str) {
        int indexOfValue = TL.indexOfValue(str);
        if (indexOfValue < 0) {
            return 4;
        }
        indexOfValue = TL.keyAt(indexOfValue);
        return indexOfValue <= 108 ? indexOfValue : 4;
    }

    public static String getMimeType(String activity) {
        return MIME_TYPE_PREFIX + activity;
    }

    public static String getName(int activity) {
        String str = (String) TL.get(activity);
        if (str != null) {
            return str;
        }
        throw new IllegalArgumentException("Unknown activity " + activity);
    }

    @Deprecated
    public static String getValue(DataPoint dataPoint) {
        return dataPoint.getValue(Field.FIELD_ACTIVITY).asActivity();
    }

    @Deprecated
    public static void setValue(DataPoint dataPoint, String activity) {
        dataPoint.getValue(Field.FIELD_ACTIVITY).setActivity(activity);
    }
}
