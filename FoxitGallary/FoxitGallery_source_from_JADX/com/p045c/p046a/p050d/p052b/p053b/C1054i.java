package com.p045c.p046a.p050d.p052b.p053b;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

/* renamed from: com.c.a.d.b.b.i */
public class C1054i {
    private final int f2801a;
    private final int f2802b;
    private final Context f2803c;

    /* renamed from: com.c.a.d.b.b.i.b */
    interface C1052b {
        int m5449a();

        int m5450b();
    }

    /* renamed from: com.c.a.d.b.b.i.a */
    private static class C1053a implements C1052b {
        private final DisplayMetrics f2800a;

        public C1053a(DisplayMetrics displayMetrics) {
            this.f2800a = displayMetrics;
        }

        public int m5451a() {
            return this.f2800a.widthPixels;
        }

        public int m5452b() {
            return this.f2800a.heightPixels;
        }
    }

    public C1054i(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new C1053a(context.getResources().getDisplayMetrics()));
    }

    C1054i(Context context, ActivityManager activityManager, C1052b c1052b) {
        this.f2803c = context;
        int a = C1054i.m5453a(activityManager);
        int a2 = (c1052b.m5449a() * c1052b.m5450b()) * 4;
        int i = a2 * 4;
        a2 *= 2;
        if (a2 + i <= a) {
            this.f2802b = a2;
            this.f2801a = i;
        } else {
            int round = Math.round(((float) a) / 6.0f);
            this.f2802b = round * 2;
            this.f2801a = round * 4;
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            Log.d("MemorySizeCalculator", "Calculated memory cache size: " + m5454a(this.f2802b) + " pool size: " + m5454a(this.f2801a) + " memory class limited? " + (a2 + i > a) + " max size: " + m5454a(a) + " memoryClass: " + activityManager.getMemoryClass() + " isLowMemoryDevice: " + C1054i.m5455b(activityManager));
        }
    }

    private static int m5453a(ActivityManager activityManager) {
        return Math.round((C1054i.m5455b(activityManager) ? 0.33f : 0.4f) * ((float) ((activityManager.getMemoryClass() * 1024) * 1024)));
    }

    private String m5454a(int i) {
        return Formatter.formatFileSize(this.f2803c, (long) i);
    }

    @TargetApi(19)
    private static boolean m5455b(ActivityManager activityManager) {
        return VERSION.SDK_INT >= 19 ? activityManager.isLowRamDevice() : VERSION.SDK_INT < 11;
    }

    public int m5456a() {
        return this.f2802b;
    }

    public int m5457b() {
        return this.f2801a;
    }
}
