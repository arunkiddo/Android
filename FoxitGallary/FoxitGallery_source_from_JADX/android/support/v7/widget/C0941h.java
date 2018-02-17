package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p016k.ah;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.v7.widget.h */
class C0941h {
    private final View f2448a;
    private final C0951m f2449b;
    private bd f2450c;
    private bd f2451d;
    private bd f2452e;

    C0941h(View view, C0951m c0951m) {
        this.f2448a = view;
        this.f2449b = c0951m;
    }

    private boolean m4965b(Drawable drawable) {
        if (this.f2452e == null) {
            this.f2452e = new bd();
        }
        bd bdVar = this.f2452e;
        bdVar.m4771a();
        ColorStateList z = ah.m1959z(this.f2448a);
        if (z != null) {
            bdVar.f2345d = true;
            bdVar.f2342a = z;
        }
        Mode A = ah.m1898A(this.f2448a);
        if (A != null) {
            bdVar.f2344c = true;
            bdVar.f2343b = A;
        }
        if (!bdVar.f2345d && !bdVar.f2344c) {
            return false;
        }
        C0951m.m4998a(drawable, bdVar, this.f2448a.getDrawableState());
        return true;
    }

    ColorStateList m4966a() {
        return this.f2451d != null ? this.f2451d.f2342a : null;
    }

    void m4967a(int i) {
        m4973b(this.f2449b != null ? this.f2449b.m5016b(this.f2448a.getContext(), i) : null);
    }

    void m4968a(ColorStateList colorStateList) {
        if (this.f2451d == null) {
            this.f2451d = new bd();
        }
        this.f2451d.f2342a = colorStateList;
        this.f2451d.f2345d = true;
        m4974c();
    }

    void m4969a(Mode mode) {
        if (this.f2451d == null) {
            this.f2451d = new bd();
        }
        this.f2451d.f2343b = mode;
        this.f2451d.f2344c = true;
        m4974c();
    }

    void m4970a(Drawable drawable) {
        m4973b(null);
    }

    void m4971a(AttributeSet attributeSet, int i) {
        bf a = bf.m4774a(this.f2448a.getContext(), attributeSet, C0729j.ViewBackgroundHelper, i, 0);
        try {
            if (a.m4791g(C0729j.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.f2449b.m5016b(this.f2448a.getContext(), a.m4790g(C0729j.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    m4973b(b);
                }
            }
            if (a.m4791g(C0729j.ViewBackgroundHelper_backgroundTint)) {
                ah.m1913a(this.f2448a, a.m4787e(C0729j.ViewBackgroundHelper_backgroundTint));
            }
            if (a.m4791g(C0729j.ViewBackgroundHelper_backgroundTintMode)) {
                ah.m1914a(this.f2448a, af.m4624a(a.m4776a(C0729j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            a.m4778a();
        } catch (Throwable th) {
            a.m4778a();
        }
    }

    Mode m4972b() {
        return this.f2451d != null ? this.f2451d.f2343b : null;
    }

    void m4973b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2450c == null) {
                this.f2450c = new bd();
            }
            this.f2450c.f2342a = colorStateList;
            this.f2450c.f2345d = true;
        } else {
            this.f2450c = null;
        }
        m4974c();
    }

    void m4974c() {
        Drawable background = this.f2448a.getBackground();
        if (background == null) {
            return;
        }
        if (VERSION.SDK_INT != 21 || !m4965b(background)) {
            if (this.f2451d != null) {
                C0951m.m4998a(background, this.f2451d, this.f2448a.getDrawableState());
            } else if (this.f2450c != null) {
                C0951m.m4998a(background, this.f2450c, this.f2448a.getDrawableState());
            }
        }
    }
}
