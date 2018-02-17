package android.support.design.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.p014d.C0346a;

/* renamed from: android.support.design.widget.b */
class C0171b extends Drawable {
    final Paint f354a;
    final Rect f355b;
    final RectF f356c;
    float f357d;
    private int f358e;
    private int f359f;
    private int f360g;
    private int f361h;
    private ColorStateList f362i;
    private int f363j;
    private boolean f364k;
    private float f365l;

    private Shader m625a() {
        Rect rect = this.f355b;
        copyBounds(rect);
        float height = this.f357d / ((float) rect.height());
        return new LinearGradient(0.0f, (float) rect.top, 0.0f, (float) rect.bottom, new int[]{C0346a.m1317a(this.f358e, this.f363j), C0346a.m1317a(this.f359f, this.f363j), C0346a.m1317a(C0346a.m1319b(this.f359f, 0), this.f363j), C0346a.m1317a(C0346a.m1319b(this.f361h, 0), this.f363j), C0346a.m1317a(this.f361h, this.f363j), C0346a.m1317a(this.f360g, this.f363j)}, new float[]{0.0f, height, 0.5f, 0.5f, 1.0f - height, 1.0f}, TileMode.CLAMP);
    }

    final void m626a(float f) {
        if (f != this.f365l) {
            this.f365l = f;
            invalidateSelf();
        }
    }

    void m627a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f363j = colorStateList.getColorForState(getState(), this.f363j);
        }
        this.f362i = colorStateList;
        this.f364k = true;
        invalidateSelf();
    }

    public void draw(Canvas canvas) {
        if (this.f364k) {
            this.f354a.setShader(m625a());
            this.f364k = false;
        }
        float strokeWidth = this.f354a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f356c;
        copyBounds(this.f355b);
        rectF.set(this.f355b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f365l, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f354a);
        canvas.restore();
    }

    public int getOpacity() {
        return this.f357d > 0.0f ? -3 : -2;
    }

    public boolean getPadding(Rect rect) {
        int round = Math.round(this.f357d);
        rect.set(round, round, round, round);
        return true;
    }

    public boolean isStateful() {
        return (this.f362i != null && this.f362i.isStateful()) || super.isStateful();
    }

    protected void onBoundsChange(Rect rect) {
        this.f364k = true;
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.f362i != null) {
            int colorForState = this.f362i.getColorForState(iArr, this.f363j);
            if (colorForState != this.f363j) {
                this.f364k = true;
                this.f363j = colorForState;
            }
        }
        if (this.f364k) {
            invalidateSelf();
        }
        return this.f364k;
    }

    public void setAlpha(int i) {
        this.f354a.setAlpha(i);
        invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f354a.setColorFilter(colorFilter);
        invalidateSelf();
    }
}
