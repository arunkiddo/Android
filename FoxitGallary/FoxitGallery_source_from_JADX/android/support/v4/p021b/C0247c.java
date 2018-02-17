package android.support.v4.p021b;

import android.app.Activity;

/* renamed from: android.support.v4.b.c */
class C0247c {

    /* renamed from: android.support.v4.b.c.a */
    public interface C0246a {
        void validateRequestPermissionsRequestCode(int i);
    }

    public static void m917a(Activity activity, String[] strArr, int i) {
        if (activity instanceof C0246a) {
            ((C0246a) activity).validateRequestPermissionsRequestCode(i);
        }
        activity.requestPermissions(strArr, i);
    }

    public static boolean m918a(Activity activity, String str) {
        return activity.shouldShowRequestPermissionRationale(str);
    }
}
