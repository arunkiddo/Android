package android.support.v4.p014d.p015a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p014d.p015a.C0337j.C0335a;

/* renamed from: android.support.v4.d.a.l */
class C0341l extends C0337j {

    /* renamed from: android.support.v4.d.a.l.a */
    private static class C0340a extends C0335a {
        C0340a(C0335a c0335a, Resources resources) {
            super(c0335a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0341l(this, resources);
        }
    }

    C0341l(Drawable drawable) {
        super(drawable);
    }

    C0341l(C0335a c0335a, Resources resources) {
        super(c0335a, resources);
    }

    C0335a m1313b() {
        return new C0340a(this.b, null);
    }

    public void jumpToCurrentState() {
        this.c.jumpToCurrentState();
    }
}
