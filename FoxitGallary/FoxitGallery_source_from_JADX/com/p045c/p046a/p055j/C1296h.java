package com.p045c.p046a.p055j;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.os.Looper;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* renamed from: com.c.a.j.h */
public final class C1296h {
    private static final char[] f3250a;
    private static final char[] f3251b;
    private static final char[] f3252c;

    /* renamed from: com.c.a.j.h.1 */
    static /* synthetic */ class C12951 {
        static final /* synthetic */ int[] f3249a;

        static {
            f3249a = new int[Config.values().length];
            try {
                f3249a[Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3249a[Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3249a[Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3249a[Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    static {
        f3250a = "0123456789abcdef".toCharArray();
        f3251b = new char[64];
        f3252c = new char[40];
    }

    public static int m6106a(int i, int i2, Config config) {
        return (i * i2) * C1296h.m6107a(config);
    }

    private static int m6107a(Config config) {
        if (config == null) {
            config = Config.ARGB_8888;
        }
        switch (C12951.f3249a[config.ordinal()]) {
            case C1373c.View_android_focusable /*1*/:
                return 1;
            case C1373c.View_paddingStart /*2*/:
            case C1373c.View_paddingEnd /*3*/:
                return 2;
            default:
                return 4;
        }
    }

    @TargetApi(19)
    public static int m6108a(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 19) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (NullPointerException e) {
            }
        }
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    public static String m6109a(byte[] bArr) {
        String a;
        synchronized (f3251b) {
            a = C1296h.m6110a(bArr, f3251b);
        }
        return a;
    }

    private static String m6110a(byte[] bArr, char[] cArr) {
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr[i * 2] = f3250a[i2 >>> 4];
            cArr[(i * 2) + 1] = f3250a[i2 & 15];
        }
        return new String(cArr);
    }

    public static <T> List<T> m6111a(Collection<T> collection) {
        List<T> arrayList = new ArrayList(collection.size());
        for (T add : collection) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static <T> Queue<T> m6112a(int i) {
        return new ArrayDeque(i);
    }

    public static void m6113a() {
        if (!C1296h.m6115b()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean m6114a(int i, int i2) {
        return C1296h.m6116b(i) && C1296h.m6116b(i2);
    }

    public static boolean m6115b() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean m6116b(int i) {
        return i > 0 || i == Integer.MIN_VALUE;
    }

    public static boolean m6117c() {
        return !C1296h.m6115b();
    }
}
