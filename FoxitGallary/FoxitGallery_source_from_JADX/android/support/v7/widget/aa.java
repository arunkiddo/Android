package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.ae;
import android.util.AttributeSet;
import android.widget.TextView;

public class aa extends TextView implements ae {
    private C0951m f1435a;
    private C0941h f1436b;
    private C0963y f1437c;

    public aa(Context context) {
        this(context, null);
    }

    public aa(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public aa(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        this.f1435a = C0951m.m4995a();
        this.f1436b = new C0941h(this, this.f1435a);
        this.f1436b.m4971a(attributeSet, i);
        this.f1437c = C0963y.m5035a((TextView) this);
        this.f1437c.m5039a(attributeSet, i);
        this.f1437c.m5036a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1436b != null) {
            this.f1436b.m4974c();
        }
        if (this.f1437c != null) {
            this.f1437c.m5036a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1436b != null ? this.f1436b.m4966a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1436b != null ? this.f1436b.m4972b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1436b != null) {
            this.f1436b.m4970a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1436b != null) {
            this.f1436b.m4967a(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1436b != null) {
            this.f1436b.m4968a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1436b != null) {
            this.f1436b.m4969a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1437c != null) {
            this.f1437c.m5037a(context, i);
        }
    }
}
