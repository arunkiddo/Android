package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p016k.C0513c.C0497a;
import android.support.v4.p016k.C0515d.C0502a;
import android.support.v4.p016k.p031a.C0416c;
import android.support.v4.p016k.p031a.C0430h;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* renamed from: android.support.v4.k.b */
public class C0473b {
    private static final C0499b f805b;
    private static final Object f806c;
    final Object f807a;

    /* renamed from: android.support.v4.k.b.b */
    interface C0499b {
        C0430h m2181a(Object obj, View view);

        Object m2182a();

        Object m2183a(C0473b c0473b);

        void m2184a(Object obj, View view, int i);

        void m2185a(Object obj, View view, C0416c c0416c);

        boolean m2186a(Object obj, View view, int i, Bundle bundle);

        boolean m2187a(Object obj, View view, AccessibilityEvent accessibilityEvent);

        boolean m2188a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m2189b(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void m2190c(Object obj, View view, AccessibilityEvent accessibilityEvent);

        void m2191d(Object obj, View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.k.b.d */
    static class C0500d implements C0499b {
        C0500d() {
        }

        public C0430h m2192a(Object obj, View view) {
            return null;
        }

        public Object m2193a() {
            return null;
        }

        public Object m2194a(C0473b c0473b) {
            return null;
        }

        public void m2195a(Object obj, View view, int i) {
        }

        public void m2196a(Object obj, View view, C0416c c0416c) {
        }

        public boolean m2197a(Object obj, View view, int i, Bundle bundle) {
            return false;
        }

        public boolean m2198a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return false;
        }

        public boolean m2199a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return true;
        }

        public void m2200b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void m2201c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }

        public void m2202d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        }
    }

    /* renamed from: android.support.v4.k.b.a */
    static class C0501a extends C0500d {

        /* renamed from: android.support.v4.k.b.a.1 */
        class C04981 implements C0497a {
            final /* synthetic */ C0473b f826a;
            final /* synthetic */ C0501a f827b;

            C04981(C0501a c0501a, C0473b c0473b) {
                this.f827b = c0501a;
                this.f826a = c0473b;
            }

            public void m2174a(View view, int i) {
                this.f826a.m2055a(view, i);
            }

            public void m2175a(View view, Object obj) {
                this.f826a.m2056a(view, new C0416c(obj));
            }

            public boolean m2176a(View view, AccessibilityEvent accessibilityEvent) {
                return this.f826a.m2060b(view, accessibilityEvent);
            }

            public boolean m2177a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.f826a.m2059a(viewGroup, view, accessibilityEvent);
            }

            public void m2178b(View view, AccessibilityEvent accessibilityEvent) {
                this.f826a.m2062d(view, accessibilityEvent);
            }

            public void m2179c(View view, AccessibilityEvent accessibilityEvent) {
                this.f826a.m2061c(view, accessibilityEvent);
            }

            public void m2180d(View view, AccessibilityEvent accessibilityEvent) {
                this.f826a.m2057a(view, accessibilityEvent);
            }
        }

        C0501a() {
        }

        public Object m2203a() {
            return C0513c.m2259a();
        }

        public Object m2204a(C0473b c0473b) {
            return C0513c.m2260a(new C04981(this, c0473b));
        }

        public void m2205a(Object obj, View view, int i) {
            C0513c.m2261a(obj, view, i);
        }

        public void m2206a(Object obj, View view, C0416c c0416c) {
            C0513c.m2262a(obj, view, c0416c.m1569a());
        }

        public boolean m2207a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            return C0513c.m2263a(obj, view, accessibilityEvent);
        }

        public boolean m2208a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return C0513c.m2264a(obj, viewGroup, view, accessibilityEvent);
        }

        public void m2209b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0513c.m2265b(obj, view, accessibilityEvent);
        }

        public void m2210c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0513c.m2266c(obj, view, accessibilityEvent);
        }

        public void m2211d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
            C0513c.m2267d(obj, view, accessibilityEvent);
        }
    }

    /* renamed from: android.support.v4.k.b.c */
    static class C0504c extends C0501a {

        /* renamed from: android.support.v4.k.b.c.1 */
        class C05031 implements C0502a {
            final /* synthetic */ C0473b f828a;
            final /* synthetic */ C0504c f829b;

            C05031(C0504c c0504c, C0473b c0473b) {
                this.f829b = c0504c;
                this.f828a = c0473b;
            }

            public Object m2221a(View view) {
                C0430h a = this.f828a.m2053a(view);
                return a != null ? a.m1639a() : null;
            }

            public void m2222a(View view, int i) {
                this.f828a.m2055a(view, i);
            }

            public void m2223a(View view, Object obj) {
                this.f828a.m2056a(view, new C0416c(obj));
            }

            public boolean m2224a(View view, int i, Bundle bundle) {
                return this.f828a.m2058a(view, i, bundle);
            }

            public boolean m2225a(View view, AccessibilityEvent accessibilityEvent) {
                return this.f828a.m2060b(view, accessibilityEvent);
            }

            public boolean m2226a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
                return this.f828a.m2059a(viewGroup, view, accessibilityEvent);
            }

            public void m2227b(View view, AccessibilityEvent accessibilityEvent) {
                this.f828a.m2062d(view, accessibilityEvent);
            }

            public void m2228c(View view, AccessibilityEvent accessibilityEvent) {
                this.f828a.m2061c(view, accessibilityEvent);
            }

            public void m2229d(View view, AccessibilityEvent accessibilityEvent) {
                this.f828a.m2057a(view, accessibilityEvent);
            }
        }

        C0504c() {
        }

        public C0430h m2230a(Object obj, View view) {
            Object a = C0515d.m2269a(obj, view);
            return a != null ? new C0430h(a) : null;
        }

        public Object m2231a(C0473b c0473b) {
            return C0515d.m2268a(new C05031(this, c0473b));
        }

        public boolean m2232a(Object obj, View view, int i, Bundle bundle) {
            return C0515d.m2270a(obj, view, i, bundle);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f805b = new C0504c();
        } else if (VERSION.SDK_INT >= 14) {
            f805b = new C0501a();
        } else {
            f805b = new C0500d();
        }
        f806c = f805b.m2182a();
    }

    public C0473b() {
        this.f807a = f805b.m2183a(this);
    }

    public C0430h m2053a(View view) {
        return f805b.m2181a(f806c, view);
    }

    Object m2054a() {
        return this.f807a;
    }

    public void m2055a(View view, int i) {
        f805b.m2184a(f806c, view, i);
    }

    public void m2056a(View view, C0416c c0416c) {
        f805b.m2185a(f806c, view, c0416c);
    }

    public void m2057a(View view, AccessibilityEvent accessibilityEvent) {
        f805b.m2191d(f806c, view, accessibilityEvent);
    }

    public boolean m2058a(View view, int i, Bundle bundle) {
        return f805b.m2186a(f806c, view, i, bundle);
    }

    public boolean m2059a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return f805b.m2188a(f806c, viewGroup, view, accessibilityEvent);
    }

    public boolean m2060b(View view, AccessibilityEvent accessibilityEvent) {
        return f805b.m2187a(f806c, view, accessibilityEvent);
    }

    public void m2061c(View view, AccessibilityEvent accessibilityEvent) {
        f805b.m2190c(f806c, view, accessibilityEvent);
    }

    public void m2062d(View view, AccessibilityEvent accessibilityEvent) {
        f805b.m2189b(f806c, view, accessibilityEvent);
    }
}
