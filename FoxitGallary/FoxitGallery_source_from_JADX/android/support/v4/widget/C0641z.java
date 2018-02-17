package android.support.v4.widget;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.TextView;

/* renamed from: android.support.v4.widget.z */
public final class C0641z {
    static final C0635f f1070a;

    /* renamed from: android.support.v4.widget.z.f */
    interface C0635f {
        void m2805a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4);
    }

    /* renamed from: android.support.v4.widget.z.b */
    static class C0636b implements C0635f {
        C0636b() {
        }

        public void m2806a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            textView.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: android.support.v4.widget.z.e */
    static class C0637e extends C0636b {
        C0637e() {
        }
    }

    /* renamed from: android.support.v4.widget.z.c */
    static class C0638c extends C0637e {
        C0638c() {
        }

        public void m2807a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            aa.m2536a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: android.support.v4.widget.z.d */
    static class C0639d extends C0638c {
        C0639d() {
        }

        public void m2808a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
            ab.m2537a(textView, drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: android.support.v4.widget.z.a */
    static class C0640a extends C0639d {
        C0640a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1070a = new C0640a();
        } else if (i >= 18) {
            f1070a = new C0639d();
        } else if (i >= 17) {
            f1070a = new C0638c();
        } else if (i >= 16) {
            f1070a = new C0637e();
        } else {
            f1070a = new C0636b();
        }
    }

    public static void m2809a(TextView textView, Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        f1070a.m2805a(textView, drawable, drawable2, drawable3, drawable4);
    }
}
