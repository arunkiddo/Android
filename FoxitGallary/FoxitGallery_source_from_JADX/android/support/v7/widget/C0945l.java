package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.widget.C0590c;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* renamed from: android.support.v7.widget.l */
class C0945l {
    private final CompoundButton f2461a;
    private final C0951m f2462b;
    private ColorStateList f2463c;
    private Mode f2464d;
    private boolean f2465e;
    private boolean f2466f;
    private boolean f2467g;

    C0945l(CompoundButton compoundButton, C0951m c0951m) {
        this.f2463c = null;
        this.f2464d = null;
        this.f2465e = false;
        this.f2466f = false;
        this.f2461a = compoundButton;
        this.f2462b = c0951m;
    }

    int m4975a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0590c.m2586a(this.f2461a);
        return a != null ? i + a.getIntrinsicWidth() : i;
    }

    ColorStateList m4976a() {
        return this.f2463c;
    }

    void m4977a(ColorStateList colorStateList) {
        this.f2463c = colorStateList;
        this.f2465e = true;
        m4982d();
    }

    void m4978a(Mode mode) {
        this.f2464d = mode;
        this.f2466f = true;
        m4982d();
    }

    void m4979a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f2461a.getContext().obtainStyledAttributes(attributeSet, C0729j.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0729j.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C0729j.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f2461a.setButtonDrawable(this.f2462b.m5013a(this.f2461a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C0729j.CompoundButton_buttonTint)) {
                C0590c.m2587a(this.f2461a, obtainStyledAttributes.getColorStateList(C0729j.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0729j.CompoundButton_buttonTintMode)) {
                C0590c.m2588a(this.f2461a, af.m4624a(obtainStyledAttributes.getInt(C0729j.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    Mode m4980b() {
        return this.f2464d;
    }

    void m4981c() {
        if (this.f2467g) {
            this.f2467g = false;
            return;
        }
        this.f2467g = true;
        m4982d();
    }

    void m4982d() {
        Drawable a = C0590c.m2586a(this.f2461a);
        if (a == null) {
            return;
        }
        if (this.f2465e || this.f2466f) {
            a = C0326a.m1272f(a).mutate();
            if (this.f2465e) {
                C0326a.m1262a(a, this.f2463c);
            }
            if (this.f2466f) {
                C0326a.m1265a(a, this.f2464d);
            }
            if (a.isStateful()) {
                a.setState(this.f2461a.getDrawableState());
            }
            this.f2461a.setButtonDrawable(a);
        }
    }
}
