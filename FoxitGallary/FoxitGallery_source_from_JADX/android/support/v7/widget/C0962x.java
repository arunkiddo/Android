package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.p016k.ah;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.x */
class C0962x extends C0958t {
    private final SeekBar f2510b;
    private Drawable f2511c;
    private ColorStateList f2512d;
    private Mode f2513e;
    private boolean f2514f;
    private boolean f2515g;

    C0962x(SeekBar seekBar, C0951m c0951m) {
        super(seekBar, c0951m);
        this.f2512d = null;
        this.f2513e = null;
        this.f2514f = false;
        this.f2515g = false;
        this.f2510b = seekBar;
    }

    private void m5028d() {
        if (this.f2511c == null) {
            return;
        }
        if (this.f2514f || this.f2515g) {
            this.f2511c = C0326a.m1272f(this.f2511c.mutate());
            if (this.f2514f) {
                C0326a.m1262a(this.f2511c, this.f2512d);
            }
            if (this.f2515g) {
                C0326a.m1265a(this.f2511c, this.f2513e);
            }
            if (this.f2511c.isStateful()) {
                this.f2511c.setState(this.f2510b.getDrawableState());
            }
        }
    }

    void m5029a(Canvas canvas) {
        int i = 1;
        if (this.f2511c != null) {
            int max = this.f2510b.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f2511c.getIntrinsicWidth();
                int intrinsicHeight = this.f2511c.getIntrinsicHeight();
                intrinsicWidth = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                if (intrinsicHeight >= 0) {
                    i = intrinsicHeight / 2;
                }
                this.f2511c.setBounds(-intrinsicWidth, -i, intrinsicWidth, i);
                float width = ((float) ((this.f2510b.getWidth() - this.f2510b.getPaddingLeft()) - this.f2510b.getPaddingRight())) / ((float) max);
                intrinsicHeight = canvas.save();
                canvas.translate((float) this.f2510b.getPaddingLeft(), (float) (this.f2510b.getHeight() / 2));
                for (i = 0; i <= max; i++) {
                    this.f2511c.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(intrinsicHeight);
            }
        }
    }

    void m5030a(Drawable drawable) {
        if (this.f2511c != null) {
            this.f2511c.setCallback(null);
        }
        this.f2511c = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f2510b);
            C0326a.m1268b(drawable, ah.m1941h(this.f2510b));
            if (drawable.isStateful()) {
                drawable.setState(this.f2510b.getDrawableState());
            }
            m5028d();
        }
        this.f2510b.invalidate();
    }

    void m5031a(AttributeSet attributeSet, int i) {
        super.m5027a(attributeSet, i);
        bf a = bf.m4774a(this.f2510b.getContext(), attributeSet, C0729j.AppCompatSeekBar, i, 0);
        Drawable b = a.m4781b(C0729j.AppCompatSeekBar_android_thumb);
        if (b != null) {
            this.f2510b.setThumb(b);
        }
        m5030a(a.m4777a(C0729j.AppCompatSeekBar_tickMark));
        if (a.m4791g(C0729j.AppCompatSeekBar_tickMarkTintMode)) {
            this.f2513e = af.m4624a(a.m4776a(C0729j.AppCompatSeekBar_tickMarkTintMode, -1), this.f2513e);
            this.f2515g = true;
        }
        if (a.m4791g(C0729j.AppCompatSeekBar_tickMarkTint)) {
            this.f2512d = a.m4787e(C0729j.AppCompatSeekBar_tickMarkTint);
            this.f2514f = true;
        }
        a.m4778a();
        m5028d();
    }

    void m5032b() {
        if (this.f2511c != null) {
            this.f2511c.jumpToCurrentState();
        }
    }

    void m5033c() {
        Drawable drawable = this.f2511c;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f2510b.getDrawableState())) {
            this.f2510b.invalidateDrawable(drawable);
        }
    }
}
