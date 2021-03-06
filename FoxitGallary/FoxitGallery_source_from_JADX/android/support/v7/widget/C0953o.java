package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.ae;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.AttributeSet;
import android.widget.ImageButton;

/* renamed from: android.support.v7.widget.o */
public class C0953o extends ImageButton implements ae {
    private C0941h f2487a;
    private C0954p f2488b;

    public C0953o(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.imageButtonStyle);
    }

    public C0953o(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        C0951m a = C0951m.m4995a();
        this.f2487a = new C0941h(this, a);
        this.f2487a.m4971a(attributeSet, i);
        this.f2488b = new C0954p(this, a);
        this.f2488b.m5018a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2487a != null) {
            this.f2487a.m4974c();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2487a != null ? this.f2487a.m4966a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2487a != null ? this.f2487a.m4972b() : null;
    }

    public boolean hasOverlappingRendering() {
        return this.f2488b.m5019a() && super.hasOverlappingRendering();
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2487a != null) {
            this.f2487a.m4970a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2487a != null) {
            this.f2487a.m4967a(i);
        }
    }

    public void setImageResource(int i) {
        this.f2488b.m5017a(i);
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2487a != null) {
            this.f2487a.m4968a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2487a != null) {
            this.f2487a.m4969a(mode);
        }
    }
}
