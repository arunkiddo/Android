package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: android.support.design.widget.g */
abstract class C0179g {
    static final int[] f376h;
    static final int[] f377i;
    static final int[] f378j;
    private final Rect f379a;
    Drawable f380b;
    Drawable f381c;
    C0171b f382d;
    Drawable f383e;
    float f384f;
    float f385g;
    final C0150z f386k;
    final C0148m f387l;
    private OnPreDrawListener f388m;

    /* renamed from: android.support.design.widget.g.a */
    interface C0144a {
        void m494a();

        void m495b();
    }

    /* renamed from: android.support.design.widget.g.1 */
    class C01841 implements OnPreDrawListener {
        final /* synthetic */ C0179g f401a;

        C01841(C0179g c0179g) {
            this.f401a = c0179g;
        }

        public boolean onPreDraw() {
            this.f401a.m648e();
            return true;
        }
    }

    static {
        f376h = new int[]{16842919, 16842910};
        f377i = new int[]{16842908, 16842910};
        f378j = new int[0];
    }

    C0179g(C0150z c0150z, C0148m c0148m) {
        this.f379a = new Rect();
        this.f386k = c0150z;
        this.f387l = c0148m;
    }

    private void m633j() {
        if (this.f388m == null) {
            this.f388m = new C01841(this);
        }
    }

    abstract float m634a();

    abstract void m635a(float f);

    abstract void m636a(int i);

    abstract void m637a(ColorStateList colorStateList);

    abstract void m638a(Mode mode);

    abstract void m639a(Rect rect);

    abstract void m640a(C0144a c0144a, boolean z);

    abstract void m641a(int[] iArr);

    abstract void m642b();

    final void m643b(float f) {
        if (this.f384f != f) {
            this.f384f = f;
            m635a(f);
        }
    }

    void m644b(Rect rect) {
    }

    abstract void m645b(C0144a c0144a, boolean z);

    abstract void m646c();

    boolean m647d() {
        return false;
    }

    void m648e() {
    }

    final Drawable m649f() {
        return this.f383e;
    }

    final void m650g() {
        Rect rect = this.f379a;
        m639a(rect);
        m644b(rect);
        this.f387l.m514a(rect.left, rect.top, rect.right, rect.bottom);
    }

    void m651h() {
        if (m647d()) {
            m633j();
            this.f386k.getViewTreeObserver().addOnPreDrawListener(this.f388m);
        }
    }

    void m652i() {
        if (this.f388m != null) {
            this.f386k.getViewTreeObserver().removeOnPreDrawListener(this.f388m);
            this.f388m = null;
        }
    }
}
