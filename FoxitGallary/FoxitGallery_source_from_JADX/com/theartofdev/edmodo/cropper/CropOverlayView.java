package com.theartofdev.edmodo.cropper;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import com.theartofdev.edmodo.cropper.CropImageView.C1348b;
import com.theartofdev.edmodo.cropper.CropImageView.C1349c;
import java.util.Arrays;

public class CropOverlayView extends View {
    private final Rect f3458A;
    private boolean f3459B;
    private Integer f3460C;
    private ScaleGestureDetector f3461a;
    private boolean f3462b;
    private final C1367f f3463c;
    private C1345a f3464d;
    private final RectF f3465e;
    private Paint f3466f;
    private Paint f3467g;
    private Paint f3468h;
    private Paint f3469i;
    private Path f3470j;
    private final float[] f3471k;
    private final RectF f3472l;
    private int f3473m;
    private int f3474n;
    private float f3475o;
    private float f3476p;
    private float f3477q;
    private float f3478r;
    private float f3479s;
    private C1370g f3480t;
    private boolean f3481u;
    private int f3482v;
    private int f3483w;
    private float f3484x;
    private C1349c f3485y;
    private C1348b f3486z;

    /* renamed from: com.theartofdev.edmodo.cropper.CropOverlayView.a */
    public interface C1345a {
        void m6337a(boolean z);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropOverlayView.b */
    private class C1356b extends SimpleOnScaleGestureListener {
        final /* synthetic */ CropOverlayView f3457a;

        private C1356b(CropOverlayView cropOverlayView) {
            this.f3457a = cropOverlayView;
        }

        @TargetApi(11)
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            RectF a = this.f3457a.f3463c.m6430a();
            float focusX = scaleGestureDetector.getFocusX();
            float focusY = scaleGestureDetector.getFocusY();
            float currentSpanY = scaleGestureDetector.getCurrentSpanY() / 2.0f;
            float currentSpanX = scaleGestureDetector.getCurrentSpanX() / 2.0f;
            float f = focusY - currentSpanY;
            float f2 = focusX - currentSpanX;
            focusX += currentSpanX;
            focusY += currentSpanY;
            if (f2 < focusX && f <= focusY && f2 >= 0.0f && focusX <= this.f3457a.f3463c.m6437d() && f >= 0.0f && focusY <= this.f3457a.f3463c.m6438e()) {
                a.set(f2, f, focusX, focusY);
                this.f3457a.f3463c.m6433a(a);
                this.f3457a.invalidate();
            }
            return true;
        }
    }

    public CropOverlayView(Context context) {
        this(context, null);
    }

    public CropOverlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3463c = new C1367f();
        this.f3465e = new RectF();
        this.f3470j = new Path();
        this.f3471k = new float[8];
        this.f3472l = new RectF();
        this.f3484x = ((float) this.f3482v) / ((float) this.f3483w);
        this.f3458A = new Rect();
    }

    private static Paint m6363a(float f, int i) {
        if (f <= 0.0f) {
            return null;
        }
        Paint paint = new Paint();
        paint.setColor(i);
        paint.setStrokeWidth(f);
        paint.setStyle(Style.STROKE);
        paint.setAntiAlias(true);
        return paint;
    }

    private static Paint m6364a(int i) {
        Paint paint = new Paint();
        paint.setColor(i);
        return paint;
    }

    private void m6366a(float f, float f2) {
        this.f3480t = this.f3463c.m6431a(f, f2, this.f3478r, this.f3486z);
        if (this.f3480t != null) {
            invalidate();
        }
    }

    private void m6367a(Canvas canvas) {
        RectF a = this.f3463c.m6430a();
        float max = Math.max(C1363c.m6389a(this.f3471k), 0.0f);
        float max2 = Math.max(C1363c.m6411b(this.f3471k), 0.0f);
        float min = Math.min(C1363c.m6412c(this.f3471k), (float) getWidth());
        float min2 = Math.min(C1363c.m6413d(this.f3471k), (float) getHeight());
        if (this.f3486z != C1348b.RECTANGLE) {
            this.f3470j.reset();
            if (VERSION.SDK_INT < 11 || VERSION.SDK_INT > 17 || this.f3486z != C1348b.OVAL) {
                this.f3465e.set(a.left, a.top, a.right, a.bottom);
            } else {
                this.f3465e.set(a.left + 2.0f, a.top + 2.0f, a.right - 2.0f, a.bottom - 2.0f);
            }
            this.f3470j.addOval(this.f3465e, Direction.CW);
            canvas.save();
            canvas.clipPath(this.f3470j, Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.f3469i);
            canvas.restore();
        } else if (!m6377f() || VERSION.SDK_INT <= 17) {
            canvas.drawRect(max, max2, min, a.top, this.f3469i);
            canvas.drawRect(max, a.bottom, min, min2, this.f3469i);
            canvas.drawRect(max, a.top, a.left, a.bottom, this.f3469i);
            canvas.drawRect(a.right, a.top, min, a.bottom, this.f3469i);
        } else {
            this.f3470j.reset();
            this.f3470j.moveTo(this.f3471k[0], this.f3471k[1]);
            this.f3470j.lineTo(this.f3471k[2], this.f3471k[3]);
            this.f3470j.lineTo(this.f3471k[4], this.f3471k[5]);
            this.f3470j.lineTo(this.f3471k[6], this.f3471k[7]);
            this.f3470j.close();
            canvas.save();
            canvas.clipPath(this.f3470j, Op.INTERSECT);
            canvas.clipRect(a, Op.XOR);
            canvas.drawRect(max, max2, min, min2, this.f3469i);
            canvas.restore();
        }
    }

    private void m6368a(RectF rectF) {
        if (rectF.width() < this.f3463c.m6435b()) {
            float b = (this.f3463c.m6435b() - rectF.width()) / 2.0f;
            rectF.left -= b;
            rectF.right = b + rectF.right;
        }
        if (rectF.height() < this.f3463c.m6436c()) {
            b = (this.f3463c.m6436c() - rectF.height()) / 2.0f;
            rectF.top -= b;
            rectF.bottom = b + rectF.bottom;
        }
        if (rectF.width() > this.f3463c.m6437d()) {
            b = (rectF.width() - this.f3463c.m6437d()) / 2.0f;
            rectF.left += b;
            rectF.right -= b;
        }
        if (rectF.height() > this.f3463c.m6438e()) {
            b = (rectF.height() - this.f3463c.m6438e()) / 2.0f;
            rectF.top += b;
            rectF.bottom -= b;
        }
        m6372b(rectF);
        if (this.f3472l.width() > 0.0f && this.f3472l.height() > 0.0f) {
            b = Math.max(this.f3472l.left, 0.0f);
            float max = Math.max(this.f3472l.top, 0.0f);
            float min = Math.min(this.f3472l.right, (float) getWidth());
            float min2 = Math.min(this.f3472l.bottom, (float) getHeight());
            if (rectF.left < b) {
                rectF.left = b;
            }
            if (rectF.top < max) {
                rectF.top = max;
            }
            if (rectF.right > min) {
                rectF.right = min;
            }
            if (rectF.bottom > min2) {
                rectF.bottom = min2;
            }
        }
        if (this.f3481u && ((double) Math.abs(rectF.width() - (rectF.height() * this.f3484x))) > 0.1d) {
            if (rectF.width() > rectF.height() * this.f3484x) {
                b = Math.abs((rectF.height() * this.f3484x) - rectF.width()) / 2.0f;
                rectF.left += b;
                rectF.right -= b;
                return;
            }
            b = Math.abs((rectF.width() / this.f3484x) - rectF.height()) / 2.0f;
            rectF.top += b;
            rectF.bottom -= b;
        }
    }

    private void m6369b(float f, float f2) {
        if (this.f3480t != null) {
            float f3 = this.f3479s;
            RectF a = this.f3463c.m6430a();
            if (m6372b(a)) {
                f3 = 0.0f;
            }
            this.f3480t.m6458a(a, f, f2, this.f3472l, this.f3473m, this.f3474n, f3, this.f3481u, this.f3484x);
            this.f3463c.m6433a(a);
            m6371b(true);
            invalidate();
        }
    }

    private void m6370b(Canvas canvas) {
        if (this.f3468h != null) {
            float strokeWidth = this.f3466f != null ? this.f3466f.getStrokeWidth() : 0.0f;
            RectF a = this.f3463c.m6430a();
            a.inset(strokeWidth, strokeWidth);
            float width = a.width() / 3.0f;
            float height = a.height() / 3.0f;
            float width2;
            float f;
            if (this.f3486z == C1348b.OVAL) {
                width2 = (a.width() / 2.0f) - strokeWidth;
                float height2 = (a.height() / 2.0f) - strokeWidth;
                f = a.left + width;
                float f2 = a.right - width;
                float sin = (float) (Math.sin(Math.acos((double) ((width2 - width) / width2))) * ((double) height2));
                canvas.drawLine(f, (a.top + height2) - sin, f, (a.bottom - height2) + sin, this.f3468h);
                canvas.drawLine(f2, (a.top + height2) - sin, f2, (a.bottom - height2) + sin, this.f3468h);
                width = a.top + height;
                f2 = a.bottom - height;
                height = (float) (((double) width2) * Math.cos(Math.asin((double) ((height2 - height) / height2))));
                canvas.drawLine((a.left + width2) - height, width, (a.right - width2) + height, width, this.f3468h);
                canvas.drawLine((a.left + width2) - height, f2, (a.right - width2) + height, f2, this.f3468h);
                return;
            }
            f = a.left + width;
            width2 = a.right - width;
            canvas.drawLine(f, a.top, f, a.bottom, this.f3468h);
            canvas.drawLine(width2, a.top, width2, a.bottom, this.f3468h);
            width = a.top + height;
            height = a.bottom - height;
            canvas.drawLine(a.left, width, a.right, width, this.f3468h);
            canvas.drawLine(a.left, height, a.right, height, this.f3468h);
        }
    }

    private void m6371b(boolean z) {
        try {
            if (this.f3464d != null) {
                this.f3464d.m6337a(z);
            }
        } catch (Throwable e) {
            Log.e("AIC", "Exception in crop window changed", e);
        }
    }

    private boolean m6372b(RectF rectF) {
        float a = C1363c.m6389a(this.f3471k);
        float b = C1363c.m6411b(this.f3471k);
        float c = C1363c.m6412c(this.f3471k);
        float d = C1363c.m6413d(this.f3471k);
        if (m6377f()) {
            float f = this.f3471k[0];
            float f2 = this.f3471k[1];
            float f3 = this.f3471k[4];
            float f4 = this.f3471k[5];
            float f5 = this.f3471k[6];
            float f6 = this.f3471k[7];
            if (this.f3471k[7] < this.f3471k[1]) {
                if (this.f3471k[1] < this.f3471k[3]) {
                    f = this.f3471k[6];
                    f2 = this.f3471k[7];
                    f3 = this.f3471k[2];
                    f4 = this.f3471k[3];
                    f5 = this.f3471k[4];
                    f6 = this.f3471k[5];
                } else {
                    f = this.f3471k[4];
                    f2 = this.f3471k[5];
                    f3 = this.f3471k[0];
                    f4 = this.f3471k[1];
                    f5 = this.f3471k[2];
                    f6 = this.f3471k[3];
                }
            } else if (this.f3471k[1] > this.f3471k[3]) {
                f = this.f3471k[2];
                f2 = this.f3471k[3];
                f3 = this.f3471k[6];
                f4 = this.f3471k[7];
                f5 = this.f3471k[0];
                f6 = this.f3471k[1];
            }
            float f7 = (f6 - f2) / (f5 - f);
            float f8 = -1.0f / f7;
            float f9 = f2 - (f7 * f);
            f2 -= f8 * f;
            f = f4 - (f7 * f3);
            f4 -= f8 * f3;
            f3 = (rectF.centerY() - rectF.top) / (rectF.centerX() - rectF.left);
            float f10 = -f3;
            float f11 = rectF.top - (rectF.left * f3);
            float f12 = rectF.top - (rectF.right * f10);
            f5 = Math.max(a, (f11 - f9) / (f7 - f3) < rectF.right ? (f11 - f9) / (f7 - f3) : a);
            f5 = Math.max(f5, (f11 - f2) / (f8 - f3) < rectF.right ? (f11 - f2) / (f8 - f3) : f5);
            a = Math.max(f5, (f12 - f4) / (f8 - f10) < rectF.right ? (f12 - f4) / (f8 - f10) : f5);
            f5 = Math.min(c, (f12 - f2) / (f8 - f10) > rectF.left ? (f12 - f2) / (f8 - f10) : c);
            f5 = Math.min(f5, (f12 - f) / (f7 - f10) > rectF.left ? (f12 - f) / (f7 - f10) : f5);
            f6 = Math.min(f5, (f11 - f) / (f7 - f3) > rectF.left ? (f11 - f) / (f7 - f3) : f5);
            f5 = Math.max(b, Math.max((f7 * a) + f9, (f8 * f6) + f2));
            f4 = Math.min(d, Math.min(f4 + (f8 * a), (f7 * f6) + f));
            this.f3472l.left = a;
            this.f3472l.top = f5;
            this.f3472l.right = f6;
            this.f3472l.bottom = f4;
            return true;
        }
        this.f3472l.set(a, b, c, d);
        return false;
    }

    private void m6373c(Canvas canvas) {
        if (this.f3466f != null) {
            float strokeWidth = this.f3466f.getStrokeWidth();
            RectF a = this.f3463c.m6430a();
            a.inset(strokeWidth / 2.0f, strokeWidth / 2.0f);
            if (this.f3486z == C1348b.RECTANGLE) {
                canvas.drawRect(a, this.f3466f);
            } else {
                canvas.drawOval(a, this.f3466f);
            }
        }
    }

    private void m6374d() {
        float max = Math.max(C1363c.m6389a(this.f3471k), 0.0f);
        float max2 = Math.max(C1363c.m6411b(this.f3471k), 0.0f);
        float min = Math.min(C1363c.m6412c(this.f3471k), (float) getWidth());
        float min2 = Math.min(C1363c.m6413d(this.f3471k), (float) getHeight());
        if (min > max && min2 > max2) {
            RectF rectF = new RectF();
            this.f3459B = true;
            float f = this.f3477q * (min - max);
            float f2 = this.f3477q * (min2 - max2);
            if (this.f3458A.width() > 0 && this.f3458A.height() > 0) {
                rectF.left = (((float) this.f3458A.left) / this.f3463c.m6439f()) + max;
                rectF.top = (((float) this.f3458A.top) / this.f3463c.m6440g()) + max2;
                rectF.right = rectF.left + (((float) this.f3458A.width()) / this.f3463c.m6439f());
                rectF.bottom = rectF.top + (((float) this.f3458A.height()) / this.f3463c.m6440g());
                rectF.left = Math.max(max, rectF.left);
                rectF.top = Math.max(max2, rectF.top);
                rectF.right = Math.min(min, rectF.right);
                rectF.bottom = Math.min(min2, rectF.bottom);
            } else if (!this.f3481u || min <= max || min2 <= max2) {
                rectF.left = max + f;
                rectF.top = max2 + f2;
                rectF.right = min - f;
                rectF.bottom = min2 - f2;
            } else if ((min - max) / (min2 - max2) > this.f3484x) {
                rectF.top = max2 + f2;
                rectF.bottom = min2 - f2;
                max = ((float) getWidth()) / 2.0f;
                this.f3484x = ((float) this.f3482v) / ((float) this.f3483w);
                max2 = Math.max(this.f3463c.m6435b(), rectF.height() * this.f3484x) / 2.0f;
                rectF.left = max - max2;
                rectF.right = max + max2;
            } else {
                rectF.left = max + f;
                rectF.right = min - f;
                max = ((float) getHeight()) / 2.0f;
                max2 = Math.max(this.f3463c.m6436c(), rectF.width() / this.f3484x) / 2.0f;
                rectF.top = max - max2;
                rectF.bottom = max + max2;
            }
            m6368a(rectF);
            this.f3463c.m6433a(rectF);
        }
    }

    private void m6375d(Canvas canvas) {
        if (this.f3467g != null) {
            float strokeWidth = this.f3466f != null ? this.f3466f.getStrokeWidth() : 0.0f;
            float strokeWidth2 = this.f3467g.getStrokeWidth();
            float f = (strokeWidth2 / 2.0f) + this.f3475o;
            RectF a = this.f3463c.m6430a();
            a.inset(f, f);
            float f2 = (strokeWidth2 - strokeWidth) / 2.0f;
            float f3 = (strokeWidth2 / 2.0f) + f2;
            canvas.drawLine(a.left - f2, a.top - f3, a.left - f2, this.f3476p + a.top, this.f3467g);
            canvas.drawLine(a.left - f3, a.top - f2, this.f3476p + a.left, a.top - f2, this.f3467g);
            canvas.drawLine(a.right + f2, a.top - f3, a.right + f2, this.f3476p + a.top, this.f3467g);
            canvas.drawLine(a.right + f3, a.top - f2, a.right - this.f3476p, a.top - f2, this.f3467g);
            canvas.drawLine(a.left - f2, a.bottom + f3, a.left - f2, a.bottom - this.f3476p, this.f3467g);
            canvas.drawLine(a.left - f3, a.bottom + f2, this.f3476p + a.left, a.bottom + f2, this.f3467g);
            canvas.drawLine(a.right + f2, a.bottom + f3, a.right + f2, a.bottom - this.f3476p, this.f3467g);
            canvas.drawLine(a.right + f3, a.bottom + f2, a.right - this.f3476p, a.bottom + f2, this.f3467g);
        }
    }

    private void m6376e() {
        if (this.f3480t != null) {
            this.f3480t = null;
            m6371b(false);
            invalidate();
        }
    }

    private boolean m6377f() {
        return (this.f3471k[0] == this.f3471k[6] || this.f3471k[1] == this.f3471k[7]) ? false : true;
    }

    public void m6378a() {
        RectF cropWindowRect = getCropWindowRect();
        m6368a(cropWindowRect);
        this.f3463c.m6433a(cropWindowRect);
    }

    public void m6379a(float f, float f2, float f3, float f4) {
        this.f3463c.m6432a(f, f2, f3, f4);
    }

    public void m6380a(float[] fArr, int i, int i2) {
        if (fArr == null || !Arrays.equals(this.f3471k, fArr)) {
            if (fArr == null) {
                Arrays.fill(this.f3471k, 0.0f);
            } else {
                System.arraycopy(fArr, 0, this.f3471k, 0, fArr.length);
            }
            this.f3473m = i;
            this.f3474n = i2;
            RectF a = this.f3463c.m6430a();
            if (a.width() == 0.0f || a.height() == 0.0f) {
                m6374d();
            }
        }
    }

    public boolean m6381a(boolean z) {
        if (VERSION.SDK_INT < 11 || this.f3462b == z) {
            return false;
        }
        this.f3462b = z;
        if (this.f3462b && this.f3461a == null) {
            this.f3461a = new ScaleGestureDetector(getContext(), new C1356b());
        }
        return true;
    }

    public void m6382b() {
        if (this.f3459B) {
            setCropWindowRect(C1363c.f3524b);
            m6374d();
            invalidate();
        }
    }

    public boolean m6383c() {
        return this.f3481u;
    }

    public int getAspectRatioX() {
        return this.f3482v;
    }

    public int getAspectRatioY() {
        return this.f3483w;
    }

    public C1348b getCropShape() {
        return this.f3486z;
    }

    public RectF getCropWindowRect() {
        return this.f3463c.m6430a();
    }

    public C1349c getGuidelines() {
        return this.f3485y;
    }

    public Rect getInitialCropWindowRect() {
        return this.f3458A;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m6367a(canvas);
        if (this.f3463c.m6441h()) {
            if (this.f3485y == C1349c.ON) {
                m6370b(canvas);
            } else if (this.f3485y == C1349c.ON_TOUCH && this.f3480t != null) {
                m6370b(canvas);
            }
        }
        m6373c(canvas);
        m6375d(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        if (this.f3462b) {
            this.f3461a.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case C1373c.View_android_theme /*0*/:
                m6366a(motionEvent.getX(), motionEvent.getY());
                return true;
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
                getParent().requestDisallowInterceptTouchEvent(false);
                m6376e();
                return true;
            case C1373c.View_paddingStart /*2*/:
                m6369b(motionEvent.getX(), motionEvent.getY());
                getParent().requestDisallowInterceptTouchEvent(true);
                return true;
            default:
                return false;
        }
    }

    public void setAspectRatioX(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f3482v != i) {
            this.f3482v = i;
            this.f3484x = ((float) this.f3482v) / ((float) this.f3483w);
            if (this.f3459B) {
                m6374d();
                invalidate();
            }
        }
    }

    public void setAspectRatioY(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f3483w != i) {
            this.f3483w = i;
            this.f3484x = ((float) this.f3482v) / ((float) this.f3483w);
            if (this.f3459B) {
                m6374d();
                invalidate();
            }
        }
    }

    public void setCropShape(C1348b c1348b) {
        if (this.f3486z != c1348b) {
            this.f3486z = c1348b;
            if (VERSION.SDK_INT >= 11 && VERSION.SDK_INT <= 17) {
                if (this.f3486z == C1348b.OVAL) {
                    this.f3460C = Integer.valueOf(getLayerType());
                    if (this.f3460C.intValue() != 1) {
                        setLayerType(1, null);
                    } else {
                        this.f3460C = null;
                    }
                } else if (this.f3460C != null) {
                    setLayerType(this.f3460C.intValue(), null);
                    this.f3460C = null;
                }
            }
            invalidate();
        }
    }

    public void setCropWindowChangeListener(C1345a c1345a) {
        this.f3464d = c1345a;
    }

    public void setCropWindowRect(RectF rectF) {
        this.f3463c.m6433a(rectF);
    }

    public void setFixedAspectRatio(boolean z) {
        if (this.f3481u != z) {
            this.f3481u = z;
            if (this.f3459B) {
                m6374d();
                invalidate();
            }
        }
    }

    public void setGuidelines(C1349c c1349c) {
        if (this.f3485y != c1349c) {
            this.f3485y = c1349c;
            if (this.f3459B) {
                invalidate();
            }
        }
    }

    public void setInitialAttributeValues(C1366e c1366e) {
        this.f3463c.m6434a(c1366e);
        setCropShape(c1366e.f3558a);
        setSnapRadius(c1366e.f3559b);
        setGuidelines(c1366e.f3561d);
        setFixedAspectRatio(c1366e.f3569l);
        setAspectRatioX(c1366e.f3570m);
        setAspectRatioY(c1366e.f3571n);
        m6381a(c1366e.f3566i);
        this.f3478r = c1366e.f3560c;
        this.f3477q = c1366e.f3568k;
        this.f3466f = m6363a(c1366e.f3572o, c1366e.f3573p);
        this.f3475o = c1366e.f3575r;
        this.f3476p = c1366e.f3576s;
        this.f3467g = m6363a(c1366e.f3574q, c1366e.f3577t);
        this.f3468h = m6363a(c1366e.f3578u, c1366e.f3579v);
        this.f3469i = m6364a(c1366e.f3580w);
    }

    public void setInitialCropWindowRect(Rect rect) {
        Rect rect2 = this.f3458A;
        if (rect == null) {
            rect = C1363c.f3523a;
        }
        rect2.set(rect);
        if (this.f3459B) {
            m6374d();
            invalidate();
            m6371b(false);
        }
    }

    public void setSnapRadius(float f) {
        this.f3479s = f;
    }
}
