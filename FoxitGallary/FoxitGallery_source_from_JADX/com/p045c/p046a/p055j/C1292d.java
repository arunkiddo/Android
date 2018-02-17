package com.p045c.p046a.p055j;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.SystemClock;

/* renamed from: com.c.a.j.d */
public final class C1292d {
    private static final double f3245a;

    static {
        double d = 1.0d;
        if (17 <= VERSION.SDK_INT) {
            d = 1.0d / Math.pow(10.0d, 6.0d);
        }
        f3245a = d;
    }

    public static double m6101a(long j) {
        return ((double) (C1292d.m6102a() - j)) * f3245a;
    }

    @TargetApi(17)
    public static long m6102a() {
        return 17 <= VERSION.SDK_INT ? SystemClock.elapsedRealtimeNanos() : System.currentTimeMillis();
    }
}
