package android.support.v4.p014d;

import android.graphics.Color;

/* renamed from: android.support.v4.d.a */
public final class C0346a {
    private static final ThreadLocal<double[]> f695a;

    static {
        f695a = new ThreadLocal();
    }

    public static int m1317a(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int c = C0346a.m1320c(alpha2, alpha);
        return Color.argb(c, C0346a.m1318a(Color.red(i), alpha2, Color.red(i2), alpha, c), C0346a.m1318a(Color.green(i), alpha2, Color.green(i2), alpha, c), C0346a.m1318a(Color.blue(i), alpha2, Color.blue(i2), alpha, c));
    }

    private static int m1318a(int i, int i2, int i3, int i4, int i5) {
        return i5 == 0 ? 0 : (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    public static int m1319b(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    private static int m1320c(int i, int i2) {
        return 255 - (((255 - i2) * (255 - i)) / 255);
    }
}