package com.p045c.p046a.p074i;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.p045c.p046a.p050d.C1081c;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.c.a.i.a */
public final class C1285a {
    private static final ConcurrentHashMap<String, C1081c> f3220a;

    static {
        f3220a = new ConcurrentHashMap();
    }

    public static C1081c m6066a(Context context) {
        String packageName = context.getPackageName();
        C1081c c1081c = (C1081c) f3220a.get(packageName);
        if (c1081c != null) {
            return c1081c;
        }
        C1081c b = C1285a.m6067b(context);
        c1081c = (C1081c) f3220a.putIfAbsent(packageName, b);
        return c1081c == null ? b : c1081c;
    }

    private static C1081c m6067b(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            packageInfo = null;
        }
        return new C1287c(packageInfo != null ? String.valueOf(packageInfo.versionCode) : UUID.randomUUID().toString());
    }
}
