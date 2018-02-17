package android.support.v4.p014d.p015a;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p014d.p015a.C0337j.C0335a;

/* renamed from: android.support.v4.d.a.m */
class C0343m extends C0341l {

    /* renamed from: android.support.v4.d.a.m.a */
    private static class C0342a extends C0335a {
        C0342a(C0335a c0335a, Resources resources) {
            super(c0335a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0343m(this, resources);
        }
    }

    C0343m(Drawable drawable) {
        super(drawable);
    }

    C0343m(C0335a c0335a, Resources resources) {
        super(c0335a, resources);
    }

    C0335a m1314b() {
        return new C0342a(this.b, null);
    }

    public boolean isAutoMirrored() {
        return this.c.isAutoMirrored();
    }

    public void setAutoMirrored(boolean z) {
        this.c.setAutoMirrored(z);
    }
}
