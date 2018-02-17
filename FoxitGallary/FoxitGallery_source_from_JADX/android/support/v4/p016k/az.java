package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.view.View;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.k.az */
public final class az {
    static final C0489g f821a;
    private WeakReference<View> f822b;
    private Runnable f823c;
    private Runnable f824d;
    private int f825e;

    /* renamed from: android.support.v4.k.az.g */
    interface C0489g {
        long m2109a(az azVar, View view);

        void m2110a(az azVar, View view, float f);

        void m2111a(az azVar, View view, long j);

        void m2112a(az azVar, View view, bd bdVar);

        void m2113a(az azVar, View view, bf bfVar);

        void m2114a(az azVar, View view, Interpolator interpolator);

        void m2115b(az azVar, View view);

        void m2116b(az azVar, View view, float f);

        void m2117b(az azVar, View view, long j);

        void m2118c(az azVar, View view);

        void m2119c(az azVar, View view, float f);
    }

    /* renamed from: android.support.v4.k.az.a */
    static class C0490a implements C0489g {
        WeakHashMap<View, Runnable> f817a;

        /* renamed from: android.support.v4.k.az.a.a */
        class C0488a implements Runnable {
            WeakReference<View> f814a;
            az f815b;
            final /* synthetic */ C0490a f816c;

            private C0488a(C0490a c0490a, az azVar, View view) {
                this.f816c = c0490a;
                this.f814a = new WeakReference(view);
                this.f815b = azVar;
            }

            public void run() {
                View view = (View) this.f814a.get();
                if (view != null) {
                    this.f816c.m2122d(this.f815b, view);
                }
            }
        }

        C0490a() {
            this.f817a = null;
        }

        private void m2121a(View view) {
            if (this.f817a != null) {
                Runnable runnable = (Runnable) this.f817a.get(view);
                if (runnable != null) {
                    view.removeCallbacks(runnable);
                }
            }
        }

        private void m2122d(az azVar, View view) {
            Object tag = view.getTag(2113929216);
            bd bdVar = tag instanceof bd ? (bd) tag : null;
            Runnable a = azVar.f823c;
            Runnable b = azVar.f824d;
            azVar.f823c = null;
            azVar.f824d = null;
            if (a != null) {
                a.run();
            }
            if (bdVar != null) {
                bdVar.m536a(view);
                bdVar.m537b(view);
            }
            if (b != null) {
                b.run();
            }
            if (this.f817a != null) {
                this.f817a.remove(view);
            }
        }

        private void m2123e(az azVar, View view) {
            Runnable runnable = this.f817a != null ? (Runnable) this.f817a.get(view) : null;
            if (runnable == null) {
                runnable = new C0488a(azVar, view, null);
                if (this.f817a == null) {
                    this.f817a = new WeakHashMap();
                }
                this.f817a.put(view, runnable);
            }
            view.removeCallbacks(runnable);
            view.post(runnable);
        }

        public long m2124a(az azVar, View view) {
            return 0;
        }

        public void m2125a(az azVar, View view, float f) {
            m2123e(azVar, view);
        }

        public void m2126a(az azVar, View view, long j) {
        }

        public void m2127a(az azVar, View view, bd bdVar) {
            view.setTag(2113929216, bdVar);
        }

        public void m2128a(az azVar, View view, bf bfVar) {
        }

        public void m2129a(az azVar, View view, Interpolator interpolator) {
        }

        public void m2130b(az azVar, View view) {
            m2123e(azVar, view);
        }

        public void m2131b(az azVar, View view, float f) {
            m2123e(azVar, view);
        }

        public void m2132b(az azVar, View view, long j) {
        }

        public void m2133c(az azVar, View view) {
            m2121a(view);
            m2122d(azVar, view);
        }

        public void m2134c(az azVar, View view, float f) {
            m2123e(azVar, view);
        }
    }

    /* renamed from: android.support.v4.k.az.b */
    static class C0492b extends C0490a {
        WeakHashMap<View, Integer> f820b;

        /* renamed from: android.support.v4.k.az.b.a */
        static class C0491a implements bd {
            az f818a;
            boolean f819b;

            C0491a(az azVar) {
                this.f818a = azVar;
            }

            public void m2135a(View view) {
                this.f819b = false;
                if (this.f818a.f825e >= 0) {
                    ah.m1912a(view, 2, null);
                }
                if (this.f818a.f823c != null) {
                    Runnable a = this.f818a.f823c;
                    this.f818a.f823c = null;
                    a.run();
                }
                Object tag = view.getTag(2113929216);
                bd bdVar = tag instanceof bd ? (bd) tag : null;
                if (bdVar != null) {
                    bdVar.m536a(view);
                }
            }

            public void m2136b(View view) {
                if (this.f818a.f825e >= 0) {
                    ah.m1912a(view, this.f818a.f825e, null);
                    this.f818a.f825e = -1;
                }
                if (VERSION.SDK_INT >= 16 || !this.f819b) {
                    if (this.f818a.f824d != null) {
                        Runnable b = this.f818a.f824d;
                        this.f818a.f824d = null;
                        b.run();
                    }
                    Object tag = view.getTag(2113929216);
                    bd bdVar = tag instanceof bd ? (bd) tag : null;
                    if (bdVar != null) {
                        bdVar.m537b(view);
                    }
                    this.f819b = true;
                }
            }

            public void m2137c(View view) {
                Object tag = view.getTag(2113929216);
                bd bdVar = tag instanceof bd ? (bd) tag : null;
                if (bdVar != null) {
                    bdVar.m538c(view);
                }
            }
        }

        C0492b() {
            this.f820b = null;
        }

        public long m2138a(az azVar, View view) {
            return ba.m2233a(view);
        }

        public void m2139a(az azVar, View view, float f) {
            ba.m2234a(view, f);
        }

        public void m2140a(az azVar, View view, long j) {
            ba.m2235a(view, j);
        }

        public void m2141a(az azVar, View view, bd bdVar) {
            view.setTag(2113929216, bdVar);
            ba.m2236a(view, new C0491a(azVar));
        }

        public void m2142a(az azVar, View view, Interpolator interpolator) {
            ba.m2237a(view, interpolator);
        }

        public void m2143b(az azVar, View view) {
            ba.m2238b(view);
        }

        public void m2144b(az azVar, View view, float f) {
            ba.m2239b(view, f);
        }

        public void m2145b(az azVar, View view, long j) {
            ba.m2240b(view, j);
        }

        public void m2146c(az azVar, View view) {
            ba.m2241c(view);
        }

        public void m2147c(az azVar, View view, float f) {
            ba.m2242c(view, f);
        }
    }

    /* renamed from: android.support.v4.k.az.d */
    static class C0493d extends C0492b {
        C0493d() {
        }

        public void m2148a(az azVar, View view, bd bdVar) {
            bb.m2243a(view, bdVar);
        }
    }

    /* renamed from: android.support.v4.k.az.c */
    static class C0494c extends C0493d {
        C0494c() {
        }
    }

    /* renamed from: android.support.v4.k.az.e */
    static class C0495e extends C0494c {
        C0495e() {
        }

        public void m2149a(az azVar, View view, bf bfVar) {
            bc.m2244a(view, bfVar);
        }
    }

    /* renamed from: android.support.v4.k.az.f */
    static class C0496f extends C0495e {
        C0496f() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f821a = new C0496f();
        } else if (i >= 19) {
            f821a = new C0495e();
        } else if (i >= 18) {
            f821a = new C0494c();
        } else if (i >= 16) {
            f821a = new C0493d();
        } else if (i >= 14) {
            f821a = new C0492b();
        } else {
            f821a = new C0490a();
        }
    }

    az(View view) {
        this.f823c = null;
        this.f824d = null;
        this.f825e = -1;
        this.f822b = new WeakReference(view);
    }

    public long m2156a() {
        View view = (View) this.f822b.get();
        return view != null ? f821a.m2109a(this, view) : 0;
    }

    public az m2157a(float f) {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2110a(this, view, f);
        }
        return this;
    }

    public az m2158a(long j) {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2111a(this, view, j);
        }
        return this;
    }

    public az m2159a(bd bdVar) {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2112a(this, view, bdVar);
        }
        return this;
    }

    public az m2160a(bf bfVar) {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2113a(this, view, bfVar);
        }
        return this;
    }

    public az m2161a(Interpolator interpolator) {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2114a(this, view, interpolator);
        }
        return this;
    }

    public az m2162b(float f) {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2116b(this, view, f);
        }
        return this;
    }

    public az m2163b(long j) {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2117b(this, view, j);
        }
        return this;
    }

    public void m2164b() {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2115b(this, view);
        }
    }

    public az m2165c(float f) {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2119c(this, view, f);
        }
        return this;
    }

    public void m2166c() {
        View view = (View) this.f822b.get();
        if (view != null) {
            f821a.m2118c(this, view);
        }
    }
}
