package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.view.MotionEvent;

/* renamed from: android.support.v4.k.t */
public final class C0560t {
    static final C0554f f855a;

    /* renamed from: android.support.v4.k.t.f */
    interface C0554f {
        int m2371a(MotionEvent motionEvent);

        int m2372a(MotionEvent motionEvent, int i);

        int m2373b(MotionEvent motionEvent);

        int m2374b(MotionEvent motionEvent, int i);

        float m2375c(MotionEvent motionEvent, int i);

        float m2376d(MotionEvent motionEvent, int i);

        float m2377e(MotionEvent motionEvent, int i);
    }

    /* renamed from: android.support.v4.k.t.a */
    static class C0555a implements C0554f {
        C0555a() {
        }

        public int m2378a(MotionEvent motionEvent) {
            return 1;
        }

        public int m2379a(MotionEvent motionEvent, int i) {
            return i == 0 ? 0 : -1;
        }

        public int m2380b(MotionEvent motionEvent) {
            return 0;
        }

        public int m2381b(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return 0;
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float m2382c(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getX();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float m2383d(MotionEvent motionEvent, int i) {
            if (i == 0) {
                return motionEvent.getY();
            }
            throw new IndexOutOfBoundsException("Pre-Eclair does not support multiple pointers");
        }

        public float m2384e(MotionEvent motionEvent, int i) {
            return 0.0f;
        }
    }

    /* renamed from: android.support.v4.k.t.b */
    static class C0556b extends C0555a {
        C0556b() {
        }

        public int m2385a(MotionEvent motionEvent) {
            return C0561u.m2401a(motionEvent);
        }

        public int m2386a(MotionEvent motionEvent, int i) {
            return C0561u.m2402a(motionEvent, i);
        }

        public int m2387b(MotionEvent motionEvent, int i) {
            return C0561u.m2403b(motionEvent, i);
        }

        public float m2388c(MotionEvent motionEvent, int i) {
            return C0561u.m2404c(motionEvent, i);
        }

        public float m2389d(MotionEvent motionEvent, int i) {
            return C0561u.m2405d(motionEvent, i);
        }
    }

    /* renamed from: android.support.v4.k.t.c */
    static class C0557c extends C0556b {
        C0557c() {
        }

        public int m2390b(MotionEvent motionEvent) {
            return C0562v.m2406a(motionEvent);
        }
    }

    /* renamed from: android.support.v4.k.t.d */
    static class C0558d extends C0557c {
        C0558d() {
        }

        public float m2391e(MotionEvent motionEvent, int i) {
            return C0563w.m2407a(motionEvent, i);
        }
    }

    /* renamed from: android.support.v4.k.t.e */
    private static class C0559e extends C0558d {
        private C0559e() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f855a = new C0559e();
        } else if (VERSION.SDK_INT >= 12) {
            f855a = new C0558d();
        } else if (VERSION.SDK_INT >= 9) {
            f855a = new C0557c();
        } else if (VERSION.SDK_INT >= 5) {
            f855a = new C0556b();
        } else {
            f855a = new C0555a();
        }
    }

    public static int m2392a(MotionEvent motionEvent) {
        return motionEvent.getAction() & 255;
    }

    public static int m2393a(MotionEvent motionEvent, int i) {
        return f855a.m2372a(motionEvent, i);
    }

    public static int m2394b(MotionEvent motionEvent) {
        return (motionEvent.getAction() & 65280) >> 8;
    }

    public static int m2395b(MotionEvent motionEvent, int i) {
        return f855a.m2374b(motionEvent, i);
    }

    public static float m2396c(MotionEvent motionEvent, int i) {
        return f855a.m2375c(motionEvent, i);
    }

    public static int m2397c(MotionEvent motionEvent) {
        return f855a.m2371a(motionEvent);
    }

    public static float m2398d(MotionEvent motionEvent, int i) {
        return f855a.m2376d(motionEvent, i);
    }

    public static int m2399d(MotionEvent motionEvent) {
        return f855a.m2373b(motionEvent);
    }

    public static float m2400e(MotionEvent motionEvent, int i) {
        return f855a.m2377e(motionEvent, i);
    }
}
