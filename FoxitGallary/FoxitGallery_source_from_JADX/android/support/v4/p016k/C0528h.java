package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.view.KeyEvent;

/* renamed from: android.support.v4.k.h */
public final class C0528h {
    static final C0524d f848a;

    /* renamed from: android.support.v4.k.h.d */
    interface C0524d {
        boolean m2294a(int i, int i2);

        boolean m2295a(KeyEvent keyEvent);

        boolean m2296b(int i);
    }

    /* renamed from: android.support.v4.k.h.a */
    static class C0525a implements C0524d {
        C0525a() {
        }

        private static int m2297a(int i, int i2, int i3, int i4, int i5) {
            Object obj = 1;
            Object obj2 = (i2 & i3) != 0 ? 1 : null;
            int i6 = i4 | i5;
            if ((i2 & i6) == 0) {
                obj = null;
            }
            if (obj2 == null) {
                return obj != null ? i & (i3 ^ -1) : i;
            } else {
                if (obj == null) {
                    return i & (i6 ^ -1);
                }
                throw new IllegalArgumentException("bad arguments");
            }
        }

        public int m2298a(int i) {
            int i2 = (i & 192) != 0 ? i | 1 : i;
            if ((i2 & 48) != 0) {
                i2 |= 2;
            }
            return i2 & 247;
        }

        public boolean m2299a(int i, int i2) {
            return C0525a.m2297a(C0525a.m2297a(m2298a(i) & 247, i2, 1, 64, 128), i2, 2, 16, 32) == i2;
        }

        public boolean m2300a(KeyEvent keyEvent) {
            return false;
        }

        public boolean m2301b(int i) {
            return (m2298a(i) & 247) == 0;
        }
    }

    /* renamed from: android.support.v4.k.h.b */
    static class C0526b extends C0525a {
        C0526b() {
        }
    }

    /* renamed from: android.support.v4.k.h.c */
    static class C0527c extends C0526b {
        C0527c() {
        }

        public int m2302a(int i) {
            return C0529i.m2309a(i);
        }

        public boolean m2303a(int i, int i2) {
            return C0529i.m2310a(i, i2);
        }

        public boolean m2304a(KeyEvent keyEvent) {
            return C0529i.m2311a(keyEvent);
        }

        public boolean m2305b(int i) {
            return C0529i.m2312b(i);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f848a = new C0527c();
        } else {
            f848a = new C0525a();
        }
    }

    public static boolean m2306a(KeyEvent keyEvent) {
        return f848a.m2296b(keyEvent.getMetaState());
    }

    public static boolean m2307a(KeyEvent keyEvent, int i) {
        return f848a.m2294a(keyEvent.getMetaState(), i);
    }

    public static boolean m2308b(KeyEvent keyEvent) {
        return f848a.m2295a(keyEvent);
    }
}
