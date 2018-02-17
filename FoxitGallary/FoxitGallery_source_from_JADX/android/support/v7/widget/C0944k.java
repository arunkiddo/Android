package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.k */
public class C0944k extends CheckedTextView {
    private static final int[] f2458a;
    private C0951m f2459b;
    private C0963y f2460c;

    static {
        f2458a = new int[]{16843016};
    }

    public C0944k(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0944k(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        this.f2460c = C0963y.m5035a((TextView) this);
        this.f2460c.m5039a(attributeSet, i);
        this.f2460c.m5036a();
        this.f2459b = C0951m.m4995a();
        bf a = bf.m4774a(getContext(), attributeSet, f2458a, i, 0);
        setCheckMarkDrawable(a.m4777a(0));
        a.m4778a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2460c != null) {
            this.f2460c.m5036a();
        }
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f2459b != null) {
            setCheckMarkDrawable(this.f2459b.m5013a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2460c != null) {
            this.f2460c.m5037a(context, i);
        }
    }
}
