package android.support.v7.widget;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.v4.p022c.C0225a;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: android.support.v7.widget.p */
public class C0954p {
    private final ImageView f2489a;
    private final C0951m f2490b;

    public C0954p(ImageView imageView, C0951m c0951m) {
        this.f2489a = imageView;
        this.f2490b = c0951m;
    }

    public void m5017a(int i) {
        if (i != 0) {
            Drawable a = this.f2490b != null ? this.f2490b.m5013a(this.f2489a.getContext(), i) : C0225a.m808a(this.f2489a.getContext(), i);
            if (a != null) {
                af.m4626b(a);
            }
            this.f2489a.setImageDrawable(a);
            return;
        }
        this.f2489a.setImageDrawable(null);
    }

    public void m5018a(AttributeSet attributeSet, int i) {
        bf bfVar = null;
        try {
            Drawable drawable = this.f2489a.getDrawable();
            if (drawable == null) {
                bfVar = bf.m4774a(this.f2489a.getContext(), attributeSet, C0729j.AppCompatImageView, i, 0);
                int g = bfVar.m4790g(C0729j.AppCompatImageView_srcCompat, -1);
                if (g != -1) {
                    drawable = this.f2490b.m5013a(this.f2489a.getContext(), g);
                    if (drawable != null) {
                        this.f2489a.setImageDrawable(drawable);
                    }
                }
            }
            if (drawable != null) {
                af.m4626b(drawable);
            }
            if (bfVar != null) {
                bfVar.m4778a();
            }
        } catch (Throwable th) {
            if (bfVar != null) {
                bfVar.m4778a();
            }
        }
    }

    boolean m5019a() {
        return VERSION.SDK_INT < 21 || !(this.f2489a.getBackground() instanceof RippleDrawable);
    }
}
