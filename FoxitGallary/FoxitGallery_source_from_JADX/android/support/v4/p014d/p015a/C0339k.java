package android.support.v4.p014d.p015a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.support.v4.p014d.p015a.C0337j.C0335a;

/* renamed from: android.support.v4.d.a.k */
class C0339k extends C0337j {

    /* renamed from: android.support.v4.d.a.k.a */
    private static class C0338a extends C0335a {
        C0338a(C0335a c0335a, Resources resources) {
            super(c0335a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0339k(this, resources);
        }
    }

    C0339k(Drawable drawable) {
        super(drawable);
    }

    C0339k(C0335a c0335a, Resources resources) {
        super(c0335a, resources);
    }

    protected Drawable m1311a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable(resources);
    }

    C0335a m1312b() {
        return new C0338a(this.b, null);
    }
}
