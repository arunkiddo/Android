package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

/* renamed from: android.support.v4.widget.c */
public final class C0590c {
    private static final C0586c f1000a;

    /* renamed from: android.support.v4.widget.c.c */
    interface C0586c {
        Drawable m2577a(CompoundButton compoundButton);

        void m2578a(CompoundButton compoundButton, ColorStateList colorStateList);

        void m2579a(CompoundButton compoundButton, Mode mode);
    }

    /* renamed from: android.support.v4.widget.c.b */
    static class C0587b implements C0586c {
        C0587b() {
        }

        public Drawable m2580a(CompoundButton compoundButton) {
            return C0592e.m2590a(compoundButton);
        }

        public void m2581a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0592e.m2591a(compoundButton, colorStateList);
        }

        public void m2582a(CompoundButton compoundButton, Mode mode) {
            C0592e.m2592a(compoundButton, mode);
        }
    }

    /* renamed from: android.support.v4.widget.c.d */
    static class C0588d extends C0587b {
        C0588d() {
        }

        public void m2583a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0593f.m2593a(compoundButton, colorStateList);
        }

        public void m2584a(CompoundButton compoundButton, Mode mode) {
            C0593f.m2594a(compoundButton, mode);
        }
    }

    /* renamed from: android.support.v4.widget.c.a */
    static class C0589a extends C0588d {
        C0589a() {
        }

        public Drawable m2585a(CompoundButton compoundButton) {
            return C0591d.m2589a(compoundButton);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1000a = new C0589a();
        } else if (i >= 21) {
            f1000a = new C0588d();
        } else {
            f1000a = new C0587b();
        }
    }

    public static Drawable m2586a(CompoundButton compoundButton) {
        return f1000a.m2577a(compoundButton);
    }

    public static void m2587a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1000a.m2578a(compoundButton, colorStateList);
    }

    public static void m2588a(CompoundButton compoundButton, Mode mode) {
        f1000a.m2579a(compoundButton, mode);
    }
}
