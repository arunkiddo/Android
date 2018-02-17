package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.p038f.C0737a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.y */
class C0963y {
    final TextView f2516a;
    private bd f2517b;
    private bd f2518c;
    private bd f2519d;
    private bd f2520e;

    C0963y(TextView textView) {
        this.f2516a = textView;
    }

    protected static bd m5034a(Context context, C0951m c0951m, int i) {
        ColorStateList b = c0951m.m5016b(context, i);
        if (b == null) {
            return null;
        }
        bd bdVar = new bd();
        bdVar.f2345d = true;
        bdVar.f2342a = b;
        return bdVar;
    }

    static C0963y m5035a(TextView textView) {
        return VERSION.SDK_INT >= 17 ? new C0964z(textView) : new C0963y(textView);
    }

    void m5036a() {
        if (this.f2517b != null || this.f2518c != null || this.f2519d != null || this.f2520e != null) {
            Drawable[] compoundDrawables = this.f2516a.getCompoundDrawables();
            m5038a(compoundDrawables[0], this.f2517b);
            m5038a(compoundDrawables[1], this.f2518c);
            m5038a(compoundDrawables[2], this.f2519d);
            m5038a(compoundDrawables[3], this.f2520e);
        }
    }

    void m5037a(Context context, int i) {
        bf a = bf.m4772a(context, i, C0729j.TextAppearance);
        if (a.m4791g(C0729j.TextAppearance_textAllCaps)) {
            m5040a(a.m4779a(C0729j.TextAppearance_textAllCaps, false));
        }
        if (VERSION.SDK_INT < 23 && a.m4791g(C0729j.TextAppearance_android_textColor)) {
            ColorStateList e = a.m4787e(C0729j.TextAppearance_android_textColor);
            if (e != null) {
                this.f2516a.setTextColor(e);
            }
        }
        a.m4778a();
    }

    final void m5038a(Drawable drawable, bd bdVar) {
        if (drawable != null && bdVar != null) {
            C0951m.m4998a(drawable, bdVar, this.f2516a.getDrawableState());
        }
    }

    void m5039a(AttributeSet attributeSet, int i) {
        boolean z;
        Context context = this.f2516a.getContext();
        C0951m a = C0951m.m4995a();
        bf a2 = bf.m4774a(context, attributeSet, C0729j.AppCompatTextHelper, i, 0);
        int g = a2.m4790g(C0729j.AppCompatTextHelper_android_textAppearance, -1);
        if (a2.m4791g(1)) {
            this.f2517b = C0963y.m5034a(context, a, a2.m4790g(C0729j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a2.m4791g(2)) {
            this.f2518c = C0963y.m5034a(context, a, a2.m4790g(C0729j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a2.m4791g(3)) {
            this.f2519d = C0963y.m5034a(context, a, a2.m4790g(C0729j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a2.m4791g(4)) {
            this.f2520e = C0963y.m5034a(context, a, a2.m4790g(C0729j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        a2.m4778a();
        boolean z2 = this.f2516a.getTransformationMethod() instanceof PasswordTransformationMethod;
        ColorStateList colorStateList = null;
        boolean z3;
        if (g != -1) {
            bf a3 = bf.m4772a(context, g, C0729j.TextAppearance);
            if (z2 || !a3.m4791g(C0729j.TextAppearance_textAllCaps)) {
                z3 = false;
                z = false;
            } else {
                z = a3.m4779a(C0729j.TextAppearance_textAllCaps, false);
                int i2 = 1;
            }
            if (VERSION.SDK_INT < 23 && a3.m4791g(C0729j.TextAppearance_android_textColor)) {
                colorStateList = a3.m4787e(C0729j.TextAppearance_android_textColor);
            }
            a3.m4778a();
        } else {
            z3 = false;
            z = false;
        }
        bf a4 = bf.m4774a(context, attributeSet, C0729j.TextAppearance, i, 0);
        if (!z2 && a4.m4791g(C0729j.TextAppearance_textAllCaps)) {
            z = a4.m4779a(C0729j.TextAppearance_textAllCaps, false);
            i2 = 1;
        }
        if (VERSION.SDK_INT < 23 && a4.m4791g(C0729j.TextAppearance_android_textColor)) {
            colorStateList = a4.m4787e(C0729j.TextAppearance_android_textColor);
        }
        a4.m4778a();
        if (colorStateList != null) {
            this.f2516a.setTextColor(colorStateList);
        }
        if (!z2 && r0 != 0) {
            m5040a(z);
        }
    }

    void m5040a(boolean z) {
        this.f2516a.setTransformationMethod(z ? new C0737a(this.f2516a.getContext()) : null);
    }
}
