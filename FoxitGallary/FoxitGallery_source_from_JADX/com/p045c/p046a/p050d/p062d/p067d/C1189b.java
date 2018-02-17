package com.p045c.p046a.p050d.p062d.p067d;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.Gravity;
import com.p045c.p046a.p048b.C0991a;
import com.p045c.p046a.p048b.C0991a.C0990a;
import com.p045c.p046a.p048b.C0993c;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p062d.p065b.C1159b;
import com.p045c.p046a.p050d.p062d.p067d.C1201f.C1188b;

/* renamed from: com.c.a.d.d.d.b */
public class C1189b extends C1159b implements C1188b {
    private final Paint f3021a;
    private final Rect f3022b;
    private final C1187a f3023c;
    private final C0991a f3024d;
    private final C1201f f3025e;
    private boolean f3026f;
    private boolean f3027g;
    private boolean f3028h;
    private boolean f3029i;
    private int f3030j;
    private int f3031k;
    private boolean f3032l;

    /* renamed from: com.c.a.d.d.d.b.a */
    static class C1187a extends ConstantState {
        C0993c f3012a;
        byte[] f3013b;
        Context f3014c;
        C1146g<Bitmap> f3015d;
        int f3016e;
        int f3017f;
        C0990a f3018g;
        C1023c f3019h;
        Bitmap f3020i;

        public C1187a(C0993c c0993c, byte[] bArr, Context context, C1146g<Bitmap> c1146g, int i, int i2, C0990a c0990a, C1023c c1023c, Bitmap bitmap) {
            if (bitmap == null) {
                throw new NullPointerException("The first frame of the GIF must not be null");
            }
            this.f3012a = c0993c;
            this.f3013b = bArr;
            this.f3019h = c1023c;
            this.f3020i = bitmap;
            this.f3014c = context.getApplicationContext();
            this.f3015d = c1146g;
            this.f3016e = i;
            this.f3017f = i2;
            this.f3018g = c0990a;
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return new C1189b(this);
        }

        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public C1189b(Context context, C0990a c0990a, C1023c c1023c, C1146g<Bitmap> c1146g, int i, int i2, C0993c c0993c, byte[] bArr, Bitmap bitmap) {
        this(new C1187a(c0993c, bArr, context, c1146g, i, i2, c0990a, c1023c, bitmap));
    }

    C1189b(C1187a c1187a) {
        this.f3022b = new Rect();
        this.f3029i = true;
        this.f3031k = -1;
        if (c1187a == null) {
            throw new NullPointerException("GifState must not be null");
        }
        this.f3023c = c1187a;
        this.f3024d = new C0991a(c1187a.f3018g);
        this.f3021a = new Paint();
        this.f3024d.m5174a(c1187a.f3012a, c1187a.f3013b);
        this.f3025e = new C1201f(c1187a.f3014c, this, this.f3024d, c1187a.f3016e, c1187a.f3017f);
        this.f3025e.m5776a(c1187a.f3015d);
    }

    public C1189b(C1189b c1189b, Bitmap bitmap, C1146g<Bitmap> c1146g) {
        this(new C1187a(c1189b.f3023c.f3012a, c1189b.f3023c.f3013b, c1189b.f3023c.f3014c, c1146g, c1189b.f3023c.f3016e, c1189b.f3023c.f3017f, c1189b.f3023c.f3018g, c1189b.f3023c.f3019h, bitmap));
    }

    private void m5748g() {
        this.f3030j = 0;
    }

    private void m5749h() {
        this.f3025e.m5778c();
        invalidateSelf();
    }

    private void m5750i() {
        if (this.f3024d.m5176c() == 1) {
            invalidateSelf();
        } else if (!this.f3026f) {
            this.f3026f = true;
            this.f3025e.m5774a();
            invalidateSelf();
        }
    }

    private void m5751j() {
        this.f3026f = false;
        this.f3025e.m5777b();
    }

    public void m5752a(int i) {
        if (i <= 0 && i != -1 && i != 0) {
            throw new IllegalArgumentException("Loop count must be greater than 0, or equal to GlideDrawable.LOOP_FOREVER, or equal to GlideDrawable.LOOP_INTRINSIC");
        } else if (i == 0) {
            this.f3031k = this.f3024d.m5178e();
        } else {
            this.f3031k = i;
        }
    }

    public boolean m5753a() {
        return true;
    }

    public Bitmap m5754b() {
        return this.f3023c.f3020i;
    }

    @TargetApi(11)
    public void m5755b(int i) {
        if (VERSION.SDK_INT < 11 || getCallback() != null) {
            invalidateSelf();
            if (i == this.f3024d.m5176c() - 1) {
                this.f3030j++;
            }
            if (this.f3031k != -1 && this.f3030j >= this.f3031k) {
                stop();
                return;
            }
            return;
        }
        stop();
        m5749h();
    }

    public C1146g<Bitmap> m5756c() {
        return this.f3023c.f3015d;
    }

    public byte[] m5757d() {
        return this.f3023c.f3013b;
    }

    public void draw(Canvas canvas) {
        if (!this.f3028h) {
            if (this.f3032l) {
                Gravity.apply(119, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), this.f3022b);
                this.f3032l = false;
            }
            Bitmap d = this.f3025e.m5779d();
            if (d == null) {
                d = this.f3023c.f3020i;
            }
            canvas.drawBitmap(d, null, this.f3022b, this.f3021a);
        }
    }

    public int m5758e() {
        return this.f3024d.m5176c();
    }

    public void m5759f() {
        this.f3028h = true;
        this.f3023c.f3019h.m5342a(this.f3023c.f3020i);
        this.f3025e.m5778c();
        this.f3025e.m5777b();
    }

    public ConstantState getConstantState() {
        return this.f3023c;
    }

    public int getIntrinsicHeight() {
        return this.f3023c.f3020i.getHeight();
    }

    public int getIntrinsicWidth() {
        return this.f3023c.f3020i.getWidth();
    }

    public int getOpacity() {
        return -2;
    }

    public boolean isRunning() {
        return this.f3026f;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f3032l = true;
    }

    public void setAlpha(int i) {
        this.f3021a.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3021a.setColorFilter(colorFilter);
    }

    public boolean setVisible(boolean z, boolean z2) {
        this.f3029i = z;
        if (!z) {
            m5751j();
        } else if (this.f3027g) {
            m5750i();
        }
        return super.setVisible(z, z2);
    }

    public void start() {
        this.f3027g = true;
        m5748g();
        if (this.f3029i) {
            m5750i();
        }
    }

    public void stop() {
        this.f3027g = false;
        m5751j();
        if (VERSION.SDK_INT < 11) {
            m5749h();
        }
    }
}
