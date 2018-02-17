package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.z */
class C0964z extends C0963y {
    private bd f2521b;
    private bd f2522c;

    C0964z(TextView textView) {
        super(textView);
    }

    void m5041a() {
        super.m5036a();
        if (this.f2521b != null || this.f2522c != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m5038a(compoundDrawablesRelative[0], this.f2521b);
            m5038a(compoundDrawablesRelative[2], this.f2522c);
        }
    }

    void m5042a(AttributeSet attributeSet, int i) {
        super.m5039a(attributeSet, i);
        Context context = this.a.getContext();
        C0951m a = C0951m.m4995a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0729j.AppCompatTextHelper, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f2521b = C0963y.m5034a(context, a, obtainStyledAttributes.getResourceId(C0729j.AppCompatTextHelper_android_drawableStart, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2522c = C0963y.m5034a(context, a, obtainStyledAttributes.getResourceId(C0729j.AppCompatTextHelper_android_drawableEnd, 0));
        }
        obtainStyledAttributes.recycle();
    }
}
