package android.support.design.widget;

import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.q */
class C0202q {
    private final C0201c f444a;

    /* renamed from: android.support.design.widget.q.a */
    interface C0115a {
        void m240a(C0202q c0202q);
    }

    /* renamed from: android.support.design.widget.q.1 */
    class C01981 implements C0197b {
        final /* synthetic */ C0115a f442a;
        final /* synthetic */ C0202q f443b;

        C01981(C0202q c0202q, C0115a c0115a) {
            this.f443b = c0202q;
            this.f442a = c0115a;
        }

        public void m728a() {
            this.f442a.m240a(this.f443b);
        }
    }

    /* renamed from: android.support.design.widget.q.b */
    interface C0199b {
        C0202q m729a();
    }

    /* renamed from: android.support.design.widget.q.c */
    static abstract class C0201c {

        /* renamed from: android.support.design.widget.q.c.b */
        interface C0197b {
            void m727a();
        }

        /* renamed from: android.support.design.widget.q.c.a */
        interface C0200a {
            void m730a();

            void m731b();

            void m732c();
        }

        C0201c() {
        }

        abstract void m733a();

        abstract void m734a(float f, float f2);

        abstract void m735a(int i, int i2);

        abstract void m736a(long j);

        abstract void m737a(C0197b c0197b);

        abstract void m738a(Interpolator interpolator);

        abstract boolean m739b();

        abstract int m740c();

        abstract float m741d();

        abstract void m742e();
    }

    C0202q(C0201c c0201c) {
        this.f444a = c0201c;
    }

    public void m743a() {
        this.f444a.m733a();
    }

    public void m744a(float f, float f2) {
        this.f444a.m734a(f, f2);
    }

    public void m745a(int i, int i2) {
        this.f444a.m735a(i, i2);
    }

    public void m746a(long j) {
        this.f444a.m736a(j);
    }

    public void m747a(C0115a c0115a) {
        if (c0115a != null) {
            this.f444a.m737a(new C01981(this, c0115a));
        } else {
            this.f444a.m737a(null);
        }
    }

    public void m748a(Interpolator interpolator) {
        this.f444a.m738a(interpolator);
    }

    public boolean m749b() {
        return this.f444a.m739b();
    }

    public int m750c() {
        return this.f444a.m740c();
    }

    public float m751d() {
        return this.f444a.m741d();
    }

    public void m752e() {
        this.f444a.m742e();
    }
}
