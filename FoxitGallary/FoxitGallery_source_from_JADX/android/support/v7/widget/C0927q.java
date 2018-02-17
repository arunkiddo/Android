package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.ae;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.q */
public class C0927q extends ImageView implements ae {
    private C0941h f2386a;
    private C0954p f2387b;

    public C0927q(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0927q(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        C0951m a = C0951m.m4995a();
        this.f2386a = new C0941h(this, a);
        this.f2386a.m4971a(attributeSet, i);
        this.f2387b = new C0954p(this, a);
        this.f2387b.m5018a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2386a != null) {
            this.f2386a.m4974c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2386a != null ? this.f2386a.m4966a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2386a != null ? this.f2386a.m4972b() : null;
    }

    public boolean hasOverlappingRendering() {
        return this.f2387b.m5019a() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2386a != null) {
            this.f2386a.m4970a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2386a != null) {
            this.f2386a.m4967a(i);
        }
    }

    public void setImageResource(int i) {
        this.f2387b.m5017a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2386a != null) {
            this.f2386a.m4968a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2386a != null) {
            this.f2386a.m4969a(mode);
        }
    }
}
