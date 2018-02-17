package android.support.v4.p022c;

import android.content.Context;
import android.os.Process;
import android.support.v4.p021b.C0254g;

/* renamed from: android.support.v4.c.i */
public final class C0317i {
    public static int m1202a(Context context, String str) {
        return C0317i.m1203a(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }

    public static int m1203a(Context context, String str, int i, int i2, String str2) {
        if (context.checkPermission(str, i, i2) == -1) {
            return -1;
        }
        String a = C0254g.m929a(str);
        if (a == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return C0254g.m928a(context, a, str2) != 0 ? -2 : 0;
    }
}
