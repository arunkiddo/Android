package android.support.v4.p021b;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;

/* renamed from: android.support.v4.b.ae */
class ae {
    public static Intent m891a(Activity activity) {
        return activity.getParentActivityIntent();
    }

    public static String m892a(ActivityInfo activityInfo) {
        return activityInfo.parentActivityName;
    }

    public static boolean m893a(Activity activity, Intent intent) {
        return activity.shouldUpRecreateTask(intent);
    }

    public static void m894b(Activity activity, Intent intent) {
        activity.navigateUpTo(intent);
    }
}
