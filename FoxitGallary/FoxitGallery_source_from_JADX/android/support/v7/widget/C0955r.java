package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.ae;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.AttributeSet;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.r */
public class C0955r extends MultiAutoCompleteTextView implements ae {
    private static final int[] f2491a;
    private C0951m f2492b;
    private C0941h f2493c;
    private C0963y f2494d;

    static {
        f2491a = new int[]{16843126};
    }

    public C0955r(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.autoCompleteTextViewStyle);
    }

    public C0955r(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        this.f2492b = C0951m.m4995a();
        bf a = bf.m4774a(getContext(), attributeSet, f2491a, i, 0);
        if (a.m4791g(0)) {
            setDropDownBackgroundDrawable(a.m4777a(0));
        }
        a.m4778a();
        this.f2493c = new C0941h(this, this.f2492b);
        this.f2493c.m4971a(attributeSet, i);
        this.f2494d = C0963y.m5035a((TextView) this);
        this.f2494d.m5039a(attributeSet, i);
        this.f2494d.m5036a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2493c != null) {
            this.f2493c.m4974c();
        }
        if (this.f2494d != null) {
            this.f2494d.m5036a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2493c != null ? this.f2493c.m4966a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2493c != null ? this.f2493c.m4972b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2493c != null) {
            this.f2493c.m4970a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2493c != null) {
            this.f2493c.m4967a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f2492b != null) {
            setDropDownBackgroundDrawable(this.f2492b.m5013a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2493c != null) {
            this.f2493c.m4968a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2493c != null) {
            this.f2493c.m4969a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2494d != null) {
            this.f2494d.m5037a(context, i);
        }
    }
}
