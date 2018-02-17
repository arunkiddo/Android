package android.support.v7.p033a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.C0716b;
import android.support.v7.view.C0716b.C0694a;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;

/* renamed from: android.support.v7.a.a */
public abstract class C0645a {

    /* renamed from: android.support.v7.a.a.a */
    public static class C0642a extends MarginLayoutParams {
        public int f1071a;

        public C0642a(int i, int i2) {
            super(i, i2);
            this.f1071a = 0;
            this.f1071a = 8388627;
        }

        public C0642a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1071a = 0;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0729j.ActionBarLayout);
            this.f1071a = obtainStyledAttributes.getInt(C0729j.ActionBarLayout_android_layout_gravity, 0);
            obtainStyledAttributes.recycle();
        }

        public C0642a(C0642a c0642a) {
            super(c0642a);
            this.f1071a = 0;
            this.f1071a = c0642a.f1071a;
        }

        public C0642a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1071a = 0;
        }
    }

    /* renamed from: android.support.v7.a.a.b */
    public interface C0643b {
        void m2810a(boolean z);
    }

    @Deprecated
    /* renamed from: android.support.v7.a.a.c */
    public static abstract class C0644c {
        public abstract Drawable m2811a();

        public abstract CharSequence m2812b();

        public abstract View m2813c();

        public abstract void m2814d();

        public abstract CharSequence m2815e();
    }

    public abstract int m2816a();

    public C0716b m2817a(C0694a c0694a) {
        return null;
    }

    public void m2818a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public void m2819a(Configuration configuration) {
    }

    public void m2820a(CharSequence charSequence) {
    }

    public abstract void m2821a(boolean z);

    public boolean m2822a(int i, KeyEvent keyEvent) {
        return false;
    }

    public abstract void m2823b();

    public void m2824b(boolean z) {
    }

    public abstract void m2825c();

    public void m2826c(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    public void m2827d(boolean z) {
    }

    public abstract boolean m2828d();

    public Context m2829e() {
        return null;
    }

    public void m2830e(boolean z) {
    }

    public int m2831f() {
        return 0;
    }

    public void m2832f(boolean z) {
    }

    public boolean m2833g() {
        return false;
    }

    public boolean m2834h() {
        return false;
    }

    boolean m2835i() {
        return false;
    }

    void m2836j() {
    }
}
