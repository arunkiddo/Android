package android.support.design.widget;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

@TargetApi(21)
/* renamed from: android.support.design.widget.h */
class C0185h extends C0183f {
    private final Interpolator f402m;
    private InsetDrawable f403n;

    C0185h(C0150z c0150z, C0148m c0148m) {
        super(c0150z, c0148m);
        this.f402m = c0150z.isInEditMode() ? null : AnimationUtils.loadInterpolator(this.k.getContext(), 17563661);
    }

    public float m673a() {
        return this.k.getElevation();
    }

    public void m674a(float f) {
        this.k.setElevation(f);
        if (this.l.m516b()) {
            m650g();
        }
    }

    void m675a(int i) {
        if (this.c instanceof RippleDrawable) {
            ((RippleDrawable) this.c).setColor(ColorStateList.valueOf(i));
        } else {
            super.m658a(i);
        }
    }

    void m676a(Rect rect) {
        if (this.l.m516b()) {
            float a = this.l.m513a();
            float a2 = m673a() + this.g;
            int ceil = (int) Math.ceil((double) C0189l.m689b(a2, a, false));
            int ceil2 = (int) Math.ceil((double) C0189l.m686a(a2, a, false));
            rect.set(ceil, ceil2, ceil, ceil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    void m677a(int[] iArr) {
    }

    void m678b() {
    }

    void m679b(Rect rect) {
        if (this.l.m516b()) {
            this.f403n = new InsetDrawable(this.c, rect.left, rect.top, rect.right, rect.bottom);
            this.l.m515a(this.f403n);
            return;
        }
        this.l.m515a(this.c);
    }

    void m680c() {
        m650g();
    }

    boolean m681d() {
        return false;
    }
}
