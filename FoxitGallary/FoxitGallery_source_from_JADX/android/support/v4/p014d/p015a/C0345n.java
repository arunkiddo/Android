package android.support.v4.p014d.p015a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.support.v4.p014d.p015a.C0337j.C0335a;

/* renamed from: android.support.v4.d.a.n */
class C0345n extends C0343m {

    /* renamed from: android.support.v4.d.a.n.a */
    private static class C0344a extends C0335a {
        C0344a(C0335a c0335a, Resources resources) {
            super(c0335a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0345n(this, resources);
        }
    }

    C0345n(Drawable drawable) {
        super(drawable);
    }

    C0345n(C0335a c0335a, Resources resources) {
        super(c0335a, resources);
    }

    C0335a m1315b() {
        return new C0344a(this.b, null);
    }

    protected boolean m1316c() {
        if (VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.c;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable);
    }

    public Rect getDirtyBounds() {
        return this.c.getDirtyBounds();
    }

    public void getOutline(Outline outline) {
        this.c.getOutline(outline);
    }

    public void setHotspot(float f, float f2) {
        this.c.setHotspot(f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.c.setHotspotBounds(i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        if (!super.setState(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    public void setTint(int i) {
        if (m1316c()) {
            super.setTint(i);
        } else {
            this.c.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (m1316c()) {
            super.setTintList(colorStateList);
        } else {
            this.c.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (m1316c()) {
            super.setTintMode(mode);
        } else {
            this.c.setTintMode(mode);
        }
    }
}
