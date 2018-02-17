package android.support.v4.p021b;

import android.app.AppOpsManager;
import android.content.Context;

/* renamed from: android.support.v4.b.h */
class C0255h {
    public static int m930a(Context context, String str, String str2) {
        return ((AppOpsManager) context.getSystemService(AppOpsManager.class)).noteProxyOp(str, str2);
    }

    public static String m931a(String str) {
        return AppOpsManager.permissionToOp(str);
    }
}
