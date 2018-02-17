package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.ae;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.g */
public class C0854g extends AutoCompleteTextView implements ae {
    private static final int[] f1957a;
    private C0951m f1958b;
    private C0941h f1959c;
    private C0963y f1960d;

    static {
        f1957a = new int[]{16843126};
    }

    public C0854g(Context context) {
        this(context, null);
    }

    public C0854g(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.autoCompleteTextViewStyle);
    }

    public C0854g(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        this.f1958b = C0951m.m4995a();
        bf a = bf.m4774a(getContext(), attributeSet, f1957a, i, 0);
        if (a.m4791g(0)) {
            setDropDownBackgroundDrawable(a.m4777a(0));
        }
        a.m4778a();
        this.f1959c = new C0941h(this, this.f1958b);
        this.f1959c.m4971a(attributeSet, i);
        this.f1960d = C0963y.m5035a((TextView) this);
        this.f1960d.m5039a(attributeSet, i);
        this.f1960d.m5036a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1959c != null) {
            this.f1959c.m4974c();
        }
        if (this.f1960d != null) {
            this.f1960d.m5036a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1959c != null ? this.f1959c.m4966a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1959c != null ? this.f1959c.m4972b() : null;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1959c != null) {
            this.f1959c.m4970a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1959c != null) {
            this.f1959c.m4967a(i);
        }
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1958b != null) {
            setDropDownBackgroundDrawable(this.f1958b.m5013a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1959c != null) {
            this.f1959c.m4968a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1959c != null) {
            this.f1959c.m4969a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1960d != null) {
            this.f1960d.m5037a(context, i);
        }
    }
}
