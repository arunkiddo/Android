package android.support.design.widget;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.support.v7.p018d.p019a.C0188a;

/* renamed from: android.support.design.widget.l */
class C0189l extends C0188a {
    static final double f408a;
    final Paint f409b;
    final Paint f410c;
    final RectF f411d;
    float f412e;
    Path f413f;
    float f414g;
    float f415h;
    float f416i;
    float f417j;
    private boolean f418k;
    private final int f419l;
    private final int f420m;
    private final int f421n;
    private boolean f422o;
    private float f423p;
    private boolean f424q;

    static {
        f408a = Math.cos(Math.toRadians(45.0d));
    }

    public static float m686a(float f, float f2, boolean z) {
        return z ? (float) (((double) (1.5f * f)) + ((1.0d - f408a) * ((double) f2))) : 1.5f * f;
    }

    private void m687a(Canvas canvas) {
        int save = canvas.save();
        canvas.rotate(this.f423p, this.f411d.centerX(), this.f411d.centerY());
        float f = (-this.f412e) - this.f416i;
        float f2 = this.f412e;
        Object obj = this.f411d.width() - (2.0f * f2) > 0.0f ? 1 : null;
        Object obj2 = this.f411d.height() - (2.0f * f2) > 0.0f ? 1 : null;
        float f3 = f2 / ((this.f417j - (this.f417j * 0.5f)) + f2);
        float f4 = f2 / ((this.f417j - (this.f417j * 0.25f)) + f2);
        float f5 = f2 / (f2 + (this.f417j - (this.f417j * 1.0f)));
        int save2 = canvas.save();
        canvas.translate(this.f411d.left + f2, this.f411d.top + f2);
        canvas.scale(f3, f4);
        canvas.drawPath(this.f413f, this.f409b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f411d.width() - (2.0f * f2), -this.f412e, this.f410c);
        }
        canvas.restoreToCount(save2);
        save2 = canvas.save();
        canvas.translate(this.f411d.right - f2, this.f411d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f413f, this.f409b);
        if (obj != null) {
            canvas.scale(1.0f / f3, 1.0f);
            canvas.drawRect(0.0f, f, this.f411d.width() - (2.0f * f2), this.f416i + (-this.f412e), this.f410c);
        }
        canvas.restoreToCount(save2);
        int save3 = canvas.save();
        canvas.translate(this.f411d.left + f2, this.f411d.bottom - f2);
        canvas.scale(f3, f5);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f413f, this.f409b);
        if (obj2 != null) {
            canvas.scale(1.0f / f5, 1.0f);
            canvas.drawRect(0.0f, f, this.f411d.height() - (2.0f * f2), -this.f412e, this.f410c);
        }
        canvas.restoreToCount(save3);
        save3 = canvas.save();
        canvas.translate(this.f411d.right - f2, this.f411d.top + f2);
        canvas.scale(f3, f4);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f413f, this.f409b);
        if (obj2 != null) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f, this.f411d.height() - (2.0f * f2), -this.f412e, this.f410c);
        }
        canvas.restoreToCount(save3);
        canvas.restoreToCount(save);
    }

    private void m688a(Rect rect) {
        float f = this.f415h * 1.5f;
        this.f411d.set(((float) rect.left) + this.f415h, ((float) rect.top) + f, ((float) rect.right) - this.f415h, ((float) rect.bottom) - f);
        m685b().setBounds((int) this.f411d.left, (int) this.f411d.top, (int) this.f411d.right, (int) this.f411d.bottom);
        m691c();
    }

    public static float m689b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f408a) * ((double) f2))) : f;
    }

    private static int m690c(float f) {
        int round = Math.round(f);
        return round % 2 == 1 ? round - 1 : round;
    }

    private void m691c() {
        RectF rectF = new RectF(-this.f412e, -this.f412e, this.f412e, this.f412e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f416i, -this.f416i);
        if (this.f413f == null) {
            this.f413f = new Path();
        } else {
            this.f413f.reset();
        }
        this.f413f.setFillType(FillType.EVEN_ODD);
        this.f413f.moveTo(-this.f412e, 0.0f);
        this.f413f.rLineTo(-this.f416i, 0.0f);
        this.f413f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f413f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f413f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f412e / f;
            float f3 = f2 + ((1.0f - f2) / 2.0f);
            float[] fArr = new float[]{0.0f, f2, f3, 1.0f};
            f2 = 0.0f;
            this.f409b.setShader(new RadialGradient(0.0f, f2, f, new int[]{0, this.f419l, this.f420m, this.f421n}, fArr, TileMode.CLAMP));
        }
        f = 0.0f;
        this.f410c.setShader(new LinearGradient(0.0f, rectF.top, f, rectF2.top, new int[]{this.f419l, this.f420m, this.f421n}, new float[]{0.0f, 0.5f, 1.0f}, TileMode.CLAMP));
        this.f410c.setAntiAlias(false);
    }

    public float m692a() {
        return this.f417j;
    }

    final void m693a(float f) {
        if (this.f423p != f) {
            this.f423p = f;
            invalidateSelf();
        }
    }

    void m694a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float c = (float) C0189l.m690c(f);
        float c2 = (float) C0189l.m690c(f2);
        if (c > c2) {
            if (!this.f424q) {
                this.f424q = true;
            }
            c = c2;
        }
        if (this.f417j != c || this.f415h != c2) {
            this.f417j = c;
            this.f415h = c2;
            this.f416i = (float) Math.round(c * 1.5f);
            this.f414g = c2;
            this.f418k = true;
            invalidateSelf();
        }
    }

    public void m695b(float f) {
        m694a(f, this.f415h);
    }

    public void draw(Canvas canvas) {
        if (this.f418k) {
            m688a(getBounds());
            this.f418k = false;
        }
        m687a(canvas);
        super.draw(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        int ceil = (int) Math.ceil((double) C0189l.m686a(this.f415h, this.f412e, this.f422o));
        int ceil2 = (int) Math.ceil((double) C0189l.m689b(this.f415h, this.f412e, this.f422o));
        rect.set(ceil2, ceil, ceil2, ceil);
        return true;
    }

    protected void onBoundsChange(Rect rect) {
        this.f418k = true;
    }

    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f409b.setAlpha(i);
        this.f410c.setAlpha(i);
    }
}
