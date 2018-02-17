package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.ae;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.n */
public class C0952n extends EditText implements ae {
    private C0951m f2484a;
    private C0941h f2485b;
    private C0963y f2486c;

    public C0952n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.editTextStyle);
    }

    public C0952n(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        this.f2484a = C0951m.m4995a();
        this.f2485b = new C0941h(this, this.f2484a);
        this.f2485b.m4971a(attributeSet, i);
        this.f2486c = C0963y.m5035a((TextView) this);
        this.f2486c.m5039a(attributeSet, i);
        this.f2486c.m5036a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2485b != null) {
            this.f2485b.m4974c();
        }
        if (this.f2486c != null) {
            this.f2486c.m5036a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2485b != null ? this.f2485b.m4966a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2485b != null ? this.f2485b.m4972b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2485b != null) {
            this.f2485b.m4970a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2485b != null) {
            this.f2485b.m4967a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2485b != null) {
            this.f2485b.m4968a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2485b != null) {
            this.f2485b.m4969a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2486c != null) {
            this.f2486c.m5037a(context, i);
        }
    }
}
