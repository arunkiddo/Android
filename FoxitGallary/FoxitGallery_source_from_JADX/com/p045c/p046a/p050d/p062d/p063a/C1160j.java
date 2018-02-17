package com.p045c.p046a.p050d.p062d.p063a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.view.Gravity;
import com.p045c.p046a.p050d.p062d.p065b.C1159b;

/* renamed from: com.c.a.d.d.a.j */
public class C1160j extends C1159b {
    private final Rect f2960a;
    private int f2961b;
    private int f2962c;
    private boolean f2963d;
    private boolean f2964e;
    private C1158a f2965f;

    /* renamed from: com.c.a.d.d.a.j.a */
    static class C1158a extends ConstantState {
        private static final Paint f2956d;
        final Bitmap f2957a;
        int f2958b;
        Paint f2959c;

        static {
            f2956d = new Paint(6);
        }

        public C1158a(Bitmap bitmap) {
            this.f2959c = f2956d;
            this.f2957a = bitmap;
        }

        C1158a(C1158a c1158a) {
            this(c1158a.f2957a);
            this.f2958b = c1158a.f2958b;
        }

        void m5665a() {
            if (f2956d == this.f2959c) {
                this.f2959c = new Paint(6);
            }
        }

        void m5666a(int i) {
            m5665a();
            this.f2959c.setAlpha(i);
        }

        void m5667a(ColorFilter colorFilter) {
            m5665a();
            this.f2959c.setColorFilter(colorFilter);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new C1160j(null, this);
        }

        public Drawable newDrawable(Resources resources) {
            return new C1160j(resources, this);
        }
    }

    public C1160j(Resources resources, Bitmap bitmap) {
        this(resources, new C1158a(bitmap));
    }

    C1160j(Resources resources, C1158a c1158a) {
        this.f2960a = new Rect();
        if (c1158a == null) {
            throw new NullPointerException("BitmapState must not be null");
        }
        int i;
        this.f2965f = c1158a;
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
            if (i == 0) {
                i = 160;
            }
            c1158a.f2958b = i;
        } else {
            i = c1158a.f2958b;
        }
        this.f2961b = c1158a.f2957a.getScaledWidth(i);
        this.f2962c = c1158a.f2957a.getScaledHeight(i);
    }

    public void m5670a(int i) {
    }

    public boolean m5671a() {
        return false;
    }

    public Bitmap m5672b() {
        return this.f2965f.f2957a;
    }

    public void draw(Canvas canvas) {
        if (this.f2963d) {
            Gravity.apply(119, this.f2961b, this.f2962c, getBounds(), this.f2960a);
            this.f2963d = false;
        }
        canvas.drawBitmap(this.f2965f.f2957a, null, this.f2960a, this.f2965f.f2959c);
    }

    public ConstantState getConstantState() {
        return this.f2965f;
    }

    public int getIntrinsicHeight() {
        return this.f2962c;
    }

    public int getIntrinsicWidth() {
        return this.f2961b;
    }

    public int getOpacity() {
        Bitmap bitmap = this.f2965f.f2957a;
        return (bitmap == null || bitmap.hasAlpha() || this.f2965f.f2959c.getAlpha() < 255) ? -3 : -1;
    }

    public boolean isRunning() {
        return false;
    }

    public Drawable mutate() {
        if (!this.f2964e && super.mutate() == this) {
            this.f2965f = new C1158a(this.f2965f);
            this.f2964e = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f2963d = true;
    }

    public void setAlpha(int i) {
        if (this.f2965f.f2959c.getAlpha() != i) {
            this.f2965f.m5666a(i);
            invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f2965f.m5667a(colorFilter);
        invalidateSelf();
    }

    public void start() {
    }

    public void stop() {
    }
}
