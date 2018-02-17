package com.theartofdev.edmodo.cropper;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.theartofdev.edmodo.cropper.C1358a.C1357a;
import com.theartofdev.edmodo.cropper.C1360b.C1359a;
import com.theartofdev.edmodo.cropper.C1374h.C1371a;
import com.theartofdev.edmodo.cropper.C1374h.C1372b;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import com.theartofdev.edmodo.cropper.CropOverlayView.C1345a;
import java.lang.ref.WeakReference;
import java.util.UUID;

public class CropImageView extends FrameLayout {
    private RectF f3427A;
    private boolean f3428B;
    private WeakReference<C1360b> f3429C;
    private WeakReference<C1358a> f3430D;
    private final ImageView f3431a;
    private final CropOverlayView f3432b;
    private final Matrix f3433c;
    private final Matrix f3434d;
    private final ProgressBar f3435e;
    private final float[] f3436f;
    private C1364d f3437g;
    private Bitmap f3438h;
    private int f3439i;
    private int f3440j;
    private int f3441k;
    private int f3442l;
    private C1354i f3443m;
    private boolean f3444n;
    private boolean f3445o;
    private boolean f3446p;
    private int f3447q;
    private C1352g f3448r;
    private C1335d f3449s;
    @Deprecated
    private C1350e f3450t;
    @Deprecated
    private C1351f f3451u;
    private Uri f3452v;
    private int f3453w;
    private float f3454x;
    private float f3455y;
    private float f3456z;

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.d */
    public interface C1335d {
        void onCropImageComplete(CropImageView cropImageView, C1347a c1347a);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.1 */
    class C13461 implements C1345a {
        final /* synthetic */ CropImageView f3401a;

        C13461(CropImageView cropImageView) {
            this.f3401a = cropImageView;
        }

        public void m6338a(boolean z) {
            this.f3401a.m6352a(z, true);
        }
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.a */
    public static class C1347a {
        private final Bitmap f3402a;
        private final Uri f3403b;
        private final Exception f3404c;
        private final float[] f3405d;
        private final Rect f3406e;
        private final int f3407f;
        private final int f3408g;

        C1347a(Bitmap bitmap, Uri uri, Exception exception, float[] fArr, Rect rect, int i, int i2) {
            this.f3402a = bitmap;
            this.f3403b = uri;
            this.f3404c = exception;
            this.f3405d = fArr;
            this.f3406e = rect;
            this.f3407f = i;
            this.f3408g = i2;
        }

        public Bitmap m6339a() {
            return this.f3402a;
        }

        public Exception m6340b() {
            return this.f3404c;
        }
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.b */
    public enum C1348b {
        RECTANGLE,
        OVAL
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.c */
    public enum C1349c {
        OFF,
        ON_TOUCH,
        ON
    }

    @Deprecated
    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.e */
    public interface C1350e {
        void m6341a(CropImageView cropImageView, Bitmap bitmap, Exception exception);
    }

    @Deprecated
    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.f */
    public interface C1351f {
        void m6342a(CropImageView cropImageView, Uri uri, Exception exception);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.g */
    public interface C1352g {
        void m6343a(CropImageView cropImageView, Uri uri, Exception exception);
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.h */
    public enum C1353h {
        NONE,
        SAMPLING,
        RESIZE_INSIDE,
        RESIZE_FIT,
        RESIZE_EXACT
    }

    /* renamed from: com.theartofdev.edmodo.cropper.CropImageView.i */
    public enum C1354i {
        FIT_CENTER,
        CENTER,
        CENTER_CROP,
        CENTER_INSIDE
    }

    public CropImageView(Context context) {
        this(context, null);
    }

    public CropImageView(Context context, AttributeSet attributeSet) {
        C1366e c1366e;
        super(context, attributeSet);
        this.f3433c = new Matrix();
        this.f3434d = new Matrix();
        this.f3436f = new float[8];
        this.f3444n = true;
        this.f3445o = true;
        this.f3446p = true;
        this.f3453w = 1;
        this.f3454x = 1.0f;
        Intent intent = context instanceof Activity ? ((Activity) context).getIntent() : null;
        C1366e c1366e2 = intent != null ? (C1366e) intent.getParcelableExtra("CROP_IMAGE_EXTRA_OPTIONS") : null;
        if (c1366e2 == null) {
            c1366e2 = new C1366e();
            if (attributeSet != null) {
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1373c.CropImageView, 0, 0);
                try {
                    c1366e2.f3569l = obtainStyledAttributes.getBoolean(C1373c.CropImageView_cropFixAspectRatio, c1366e2.f3569l);
                    c1366e2.f3570m = obtainStyledAttributes.getInteger(C1373c.CropImageView_cropAspectRatioX, c1366e2.f3570m);
                    c1366e2.f3571n = obtainStyledAttributes.getInteger(C1373c.CropImageView_cropAspectRatioY, c1366e2.f3571n);
                    c1366e2.f3562e = C1354i.values()[obtainStyledAttributes.getInt(C1373c.CropImageView_cropScaleType, c1366e2.f3562e.ordinal())];
                    c1366e2.f3565h = obtainStyledAttributes.getBoolean(C1373c.CropImageView_cropAutoZoomEnabled, c1366e2.f3565h);
                    c1366e2.f3566i = obtainStyledAttributes.getBoolean(C1373c.CropImageView_cropMultiTouchEnabled, c1366e2.f3566i);
                    c1366e2.f3567j = obtainStyledAttributes.getInteger(C1373c.CropImageView_cropMaxZoom, c1366e2.f3567j);
                    c1366e2.f3558a = C1348b.values()[obtainStyledAttributes.getInt(C1373c.CropImageView_cropShape, c1366e2.f3558a.ordinal())];
                    c1366e2.f3561d = C1349c.values()[obtainStyledAttributes.getInt(C1373c.CropImageView_cropGuidelines, c1366e2.f3561d.ordinal())];
                    c1366e2.f3559b = obtainStyledAttributes.getDimension(C1373c.CropImageView_cropSnapRadius, c1366e2.f3559b);
                    c1366e2.f3560c = obtainStyledAttributes.getDimension(C1373c.CropImageView_cropTouchRadius, c1366e2.f3560c);
                    c1366e2.f3568k = obtainStyledAttributes.getFloat(C1373c.CropImageView_cropInitialCropWindowPaddingRatio, c1366e2.f3568k);
                    c1366e2.f3572o = obtainStyledAttributes.getDimension(C1373c.CropImageView_cropBorderLineThickness, c1366e2.f3572o);
                    c1366e2.f3573p = obtainStyledAttributes.getInteger(C1373c.CropImageView_cropBorderLineColor, c1366e2.f3573p);
                    c1366e2.f3574q = obtainStyledAttributes.getDimension(C1373c.CropImageView_cropBorderCornerThickness, c1366e2.f3574q);
                    c1366e2.f3575r = obtainStyledAttributes.getDimension(C1373c.CropImageView_cropBorderCornerOffset, c1366e2.f3575r);
                    c1366e2.f3576s = obtainStyledAttributes.getDimension(C1373c.CropImageView_cropBorderCornerLength, c1366e2.f3576s);
                    c1366e2.f3577t = obtainStyledAttributes.getInteger(C1373c.CropImageView_cropBorderCornerColor, c1366e2.f3577t);
                    c1366e2.f3578u = obtainStyledAttributes.getDimension(C1373c.CropImageView_cropGuidelinesThickness, c1366e2.f3578u);
                    c1366e2.f3579v = obtainStyledAttributes.getInteger(C1373c.CropImageView_cropGuidelinesColor, c1366e2.f3579v);
                    c1366e2.f3580w = obtainStyledAttributes.getInteger(C1373c.CropImageView_cropBackgroundColor, c1366e2.f3580w);
                    c1366e2.f3563f = obtainStyledAttributes.getBoolean(C1373c.CropImageView_cropShowCropOverlay, this.f3444n);
                    c1366e2.f3564g = obtainStyledAttributes.getBoolean(C1373c.CropImageView_cropShowProgressBar, this.f3445o);
                    c1366e2.f3574q = obtainStyledAttributes.getDimension(C1373c.CropImageView_cropBorderCornerThickness, c1366e2.f3574q);
                    c1366e2.f3581x = (int) obtainStyledAttributes.getDimension(C1373c.CropImageView_cropMinCropWindowWidth, (float) c1366e2.f3581x);
                    c1366e2.f3582y = (int) obtainStyledAttributes.getDimension(C1373c.CropImageView_cropMinCropWindowHeight, (float) c1366e2.f3582y);
                    c1366e2.f3583z = (int) obtainStyledAttributes.getFloat(C1373c.CropImageView_cropMinCropResultWidthPX, (float) c1366e2.f3583z);
                    c1366e2.f3541A = (int) obtainStyledAttributes.getFloat(C1373c.CropImageView_cropMinCropResultHeightPX, (float) c1366e2.f3541A);
                    c1366e2.f3542B = (int) obtainStyledAttributes.getFloat(C1373c.CropImageView_cropMaxCropResultWidthPX, (float) c1366e2.f3542B);
                    c1366e2.f3543C = (int) obtainStyledAttributes.getFloat(C1373c.CropImageView_cropMaxCropResultHeightPX, (float) c1366e2.f3543C);
                    if (obtainStyledAttributes.hasValue(C1373c.CropImageView_cropAspectRatioX) && obtainStyledAttributes.hasValue(C1373c.CropImageView_cropAspectRatioX) && !obtainStyledAttributes.hasValue(C1373c.CropImageView_cropFixAspectRatio)) {
                        c1366e2.f3569l = true;
                    }
                    obtainStyledAttributes.recycle();
                    c1366e = c1366e2;
                } catch (Throwable th) {
                    obtainStyledAttributes.recycle();
                }
            } else {
                c1366e = c1366e2;
            }
        } else {
            c1366e = c1366e2;
        }
        c1366e.m6422a();
        this.f3443m = c1366e.f3562e;
        this.f3446p = c1366e.f3565h;
        this.f3447q = c1366e.f3567j;
        this.f3444n = c1366e.f3563f;
        this.f3445o = c1366e.f3564g;
        View inflate = LayoutInflater.from(context).inflate(C1372b.crop_image_view, this, true);
        this.f3431a = (ImageView) inflate.findViewById(C1371a.ImageView_image);
        this.f3431a.setScaleType(ScaleType.MATRIX);
        this.f3432b = (CropOverlayView) inflate.findViewById(C1371a.CropOverlayView);
        this.f3432b.setCropWindowChangeListener(new C13461(this));
        this.f3432b.setInitialAttributeValues(c1366e);
        this.f3435e = (ProgressBar) inflate.findViewById(C1371a.CropProgressBar);
        m6355d();
    }

    private static int m6344a(int i, int i2, int i3) {
        return i == 1073741824 ? i2 : i == Integer.MIN_VALUE ? Math.min(i3, i2) : i3;
    }

    private void m6345a() {
        if (this.f3438h != null && (this.f3442l > 0 || this.f3452v != null)) {
            this.f3438h.recycle();
        }
        this.f3438h = null;
        this.f3442l = 0;
        this.f3452v = null;
        this.f3453w = 1;
        this.f3439i = 0;
        this.f3454x = 1.0f;
        this.f3455y = 0.0f;
        this.f3456z = 0.0f;
        this.f3433c.reset();
        this.f3431a.setImageBitmap(null);
        m6354c();
    }

    private void m6346a(float f, float f2, boolean z, boolean z2) {
        float f3 = 0.0f;
        if (this.f3438h != null && f > 0.0f && f2 > 0.0f) {
            this.f3433c.invert(this.f3434d);
            RectF cropWindowRect = this.f3432b.getCropWindowRect();
            this.f3434d.mapRect(cropWindowRect);
            this.f3433c.reset();
            this.f3433c.postTranslate((f - ((float) this.f3438h.getWidth())) / 2.0f, (f2 - ((float) this.f3438h.getHeight())) / 2.0f);
            m6353b();
            if (this.f3439i > 0) {
                this.f3433c.postRotate((float) this.f3439i, C1363c.m6416g(this.f3436f), C1363c.m6417h(this.f3436f));
                m6353b();
            }
            float min = Math.min(f / C1363c.m6414e(this.f3436f), f2 / C1363c.m6415f(this.f3436f));
            if (this.f3443m == C1354i.FIT_CENTER || ((this.f3443m == C1354i.CENTER_INSIDE && min < 1.0f) || (min > 1.0f && this.f3446p))) {
                this.f3433c.postScale(min, min, C1363c.m6416g(this.f3436f), C1363c.m6417h(this.f3436f));
                m6353b();
            }
            this.f3433c.postScale(this.f3454x, this.f3454x, C1363c.m6416g(this.f3436f), C1363c.m6417h(this.f3436f));
            m6353b();
            this.f3433c.mapRect(cropWindowRect);
            if (z) {
                this.f3455y = f > C1363c.m6414e(this.f3436f) ? 0.0f : Math.max(Math.min((f / 2.0f) - cropWindowRect.centerX(), -C1363c.m6389a(this.f3436f)), ((float) getWidth()) - C1363c.m6412c(this.f3436f)) / this.f3454x;
                if (f2 <= C1363c.m6415f(this.f3436f)) {
                    f3 = Math.max(Math.min((f2 / 2.0f) - cropWindowRect.centerY(), -C1363c.m6411b(this.f3436f)), ((float) getHeight()) - C1363c.m6413d(this.f3436f)) / this.f3454x;
                }
                this.f3456z = f3;
            } else {
                this.f3455y = Math.min(Math.max(this.f3455y * this.f3454x, -cropWindowRect.left), (-cropWindowRect.right) + f) / this.f3454x;
                this.f3456z = Math.min(Math.max(this.f3456z * this.f3454x, -cropWindowRect.top), (-cropWindowRect.bottom) + f2) / this.f3454x;
            }
            this.f3433c.postTranslate(this.f3455y * this.f3454x, this.f3456z * this.f3454x);
            cropWindowRect.offset(this.f3455y * this.f3454x, this.f3456z * this.f3454x);
            this.f3432b.setCropWindowRect(cropWindowRect);
            m6353b();
            if (z2) {
                this.f3437g.m6419b(this.f3436f, this.f3433c);
                this.f3431a.startAnimation(this.f3437g);
            } else {
                this.f3431a.setImageMatrix(this.f3433c);
            }
            m6351a(false);
        }
    }

    private void m6347a(Bitmap bitmap, int i) {
        m6348a(bitmap, i, null, 1, 0);
    }

    private void m6348a(Bitmap bitmap, int i, Uri uri, int i2, int i3) {
        if (this.f3438h == null || !this.f3438h.equals(bitmap)) {
            this.f3431a.clearAnimation();
            m6345a();
            this.f3438h = bitmap;
            this.f3431a.setImageBitmap(this.f3438h);
            this.f3452v = uri;
            this.f3442l = i;
            this.f3453w = i2;
            this.f3439i = i3;
            m6346a((float) getWidth(), (float) getHeight(), true, false);
            if (this.f3432b != null) {
                this.f3432b.m6382b();
                m6354c();
            }
        }
    }

    private void m6349a(Bitmap bitmap, Uri uri, int i, int i2) {
        m6348a(bitmap, 0, uri, i, i2);
    }

    private void m6351a(boolean z) {
        if (!(this.f3438h == null || z)) {
            this.f3432b.m6379a((float) getWidth(), (float) getHeight(), ((float) (this.f3438h.getWidth() * this.f3453w)) / C1363c.m6414e(this.f3436f), ((float) (this.f3438h.getHeight() * this.f3453w)) / C1363c.m6415f(this.f3436f));
        }
        this.f3432b.m6380a(z ? null : this.f3436f, getWidth(), getHeight());
    }

    private void m6352a(boolean z, boolean z2) {
        int width = getWidth();
        int height = getHeight();
        if (this.f3438h != null && width > 0 && height > 0) {
            RectF cropWindowRect = this.f3432b.getCropWindowRect();
            if (z) {
                if (cropWindowRect.left < 0.0f || cropWindowRect.top < 0.0f || cropWindowRect.right > ((float) width) || cropWindowRect.bottom > ((float) height)) {
                    m6346a((float) width, (float) height, false, false);
                }
            } else if (this.f3446p || this.f3454x > 1.0f) {
                float min = (this.f3454x >= ((float) this.f3447q) || cropWindowRect.width() >= ((float) width) * 0.5f || cropWindowRect.height() >= ((float) height) * 0.5f) ? 0.0f : Math.min((float) this.f3447q, Math.min(((float) width) / ((cropWindowRect.width() / this.f3454x) / 0.64f), ((float) height) / ((cropWindowRect.height() / this.f3454x) / 0.64f)));
                if (this.f3454x > 1.0f && (cropWindowRect.width() > ((float) width) * 0.65f || cropWindowRect.height() > ((float) height) * 0.65f)) {
                    min = Math.max(1.0f, Math.min(((float) width) / ((cropWindowRect.width() / this.f3454x) / 0.51f), ((float) height) / ((cropWindowRect.height() / this.f3454x) / 0.51f)));
                }
                if (!this.f3446p) {
                    min = 1.0f;
                }
                if (min > 0.0f && min != this.f3454x) {
                    if (z2) {
                        if (this.f3437g == null) {
                            this.f3437g = new C1364d(this.f3431a, this.f3432b);
                        }
                        this.f3437g.m6418a(this.f3436f, this.f3433c);
                    }
                    this.f3454x = min;
                    m6346a((float) width, (float) height, true, z2);
                }
            }
        }
    }

    private void m6353b() {
        this.f3436f[0] = 0.0f;
        this.f3436f[1] = 0.0f;
        this.f3436f[2] = (float) this.f3438h.getWidth();
        this.f3436f[3] = 0.0f;
        this.f3436f[4] = (float) this.f3438h.getWidth();
        this.f3436f[5] = (float) this.f3438h.getHeight();
        this.f3436f[6] = 0.0f;
        this.f3436f[7] = (float) this.f3438h.getHeight();
        this.f3433c.mapPoints(this.f3436f);
    }

    private void m6354c() {
        if (this.f3432b != null) {
            CropOverlayView cropOverlayView = this.f3432b;
            int i = (!this.f3444n || this.f3438h == null) ? 4 : 0;
            cropOverlayView.setVisibility(i);
        }
    }

    private void m6355d() {
        int i = 0;
        int i2 = (!this.f3445o || ((this.f3438h != null || this.f3429C == null) && this.f3430D == null)) ? 0 : 1;
        ProgressBar progressBar = this.f3435e;
        if (i2 == 0) {
            i = 4;
        }
        progressBar.setVisibility(i);
    }

    private void setBitmap(Bitmap bitmap) {
        m6348a(bitmap, 0, null, 1, 0);
    }

    public Bitmap m6356a(int i, int i2, C1353h c1353h) {
        if (this.f3438h == null) {
            return null;
        }
        this.f3431a.clearAnimation();
        int i3 = c1353h != C1353h.NONE ? i : 0;
        int i4 = c1353h != C1353h.NONE ? i2 : 0;
        Bitmap a = (this.f3452v == null || (this.f3453w <= 1 && c1353h != C1353h.SAMPLING)) ? C1363c.m6396a(this.f3438h, getCropPoints(), this.f3439i, this.f3432b.m6383c(), this.f3432b.getAspectRatioX(), this.f3432b.getAspectRatioY()) : C1363c.m6402a(getContext(), this.f3452v, getCropPoints(), this.f3439i, this.f3438h.getWidth() * this.f3453w, this.f3438h.getHeight() * this.f3453w, this.f3432b.m6383c(), this.f3432b.getAspectRatioX(), this.f3432b.getAspectRatioY(), i3, i4).f3519a;
        return C1363c.m6395a(a, i3, i4, c1353h);
    }

    public void m6357a(int i) {
        if (this.f3438h != null) {
            Object obj = ((this.f3432b.m6383c() || i <= 45 || i >= 135) && (i <= 215 || i >= 305)) ? null : 1;
            C1363c.f3525c.set(this.f3432b.getCropWindowRect());
            float height = (obj != null ? C1363c.f3525c.height() : C1363c.f3525c.width()) / 2.0f;
            float width = (obj != null ? C1363c.f3525c.width() : C1363c.f3525c.height()) / 2.0f;
            this.f3433c.invert(this.f3434d);
            C1363c.f3526d[0] = C1363c.f3525c.centerX();
            C1363c.f3526d[1] = C1363c.f3525c.centerY();
            C1363c.f3526d[2] = 0.0f;
            C1363c.f3526d[3] = 0.0f;
            C1363c.f3526d[4] = 1.0f;
            C1363c.f3526d[5] = 0.0f;
            this.f3434d.mapPoints(C1363c.f3526d);
            this.f3439i += i;
            this.f3439i = this.f3439i >= 0 ? this.f3439i % 360 : (this.f3439i % 360) + 360;
            m6346a((float) getWidth(), (float) getHeight(), true, false);
            this.f3433c.mapPoints(C1363c.f3527e, C1363c.f3526d);
            this.f3454x = (float) (((double) this.f3454x) / Math.sqrt(Math.pow((double) (C1363c.f3527e[4] - C1363c.f3527e[2]), 2.0d) + Math.pow((double) (C1363c.f3527e[5] - C1363c.f3527e[3]), 2.0d)));
            this.f3454x = Math.max(this.f3454x, 1.0f);
            m6346a((float) getWidth(), (float) getHeight(), true, false);
            this.f3433c.mapPoints(C1363c.f3527e, C1363c.f3526d);
            double sqrt = Math.sqrt(Math.pow((double) (C1363c.f3527e[4] - C1363c.f3527e[2]), 2.0d) + Math.pow((double) (C1363c.f3527e[5] - C1363c.f3527e[3]), 2.0d));
            float f = (float) (((double) height) * sqrt);
            height = (float) (((double) width) * sqrt);
            C1363c.f3525c.set(C1363c.f3527e[0] - f, C1363c.f3527e[1] - height, f + C1363c.f3527e[0], height + C1363c.f3527e[1]);
            this.f3432b.m6382b();
            this.f3432b.setCropWindowRect(C1363c.f3525c);
            m6346a((float) getWidth(), (float) getHeight(), true, false);
            m6352a(false, false);
            this.f3432b.m6378a();
        }
    }

    public void m6358a(int i, int i2) {
        this.f3432b.setAspectRatioX(i);
        this.f3432b.setAspectRatioY(i2);
        setFixedAspectRatio(true);
    }

    public void m6359a(int i, int i2, C1353h c1353h, Uri uri, CompressFormat compressFormat, int i3) {
        if (this.f3438h != null) {
            this.f3431a.clearAnimation();
            C1358a c1358a = this.f3430D != null ? (C1358a) this.f3430D.get() : null;
            if (c1358a != null) {
                c1358a.cancel(true);
            }
            int i4 = c1353h != C1353h.NONE ? i : 0;
            int i5 = c1353h != C1353h.NONE ? i2 : 0;
            int width = this.f3438h.getWidth() * this.f3453w;
            int height = this.f3438h.getHeight() * this.f3453w;
            if (this.f3452v == null || (this.f3453w <= 1 && c1353h != C1353h.SAMPLING)) {
                this.f3430D = new WeakReference(new C1358a(this, this.f3438h, getCropPoints(), this.f3439i, this.f3432b.m6383c(), this.f3432b.getAspectRatioX(), this.f3432b.getAspectRatioY(), i4, i5, c1353h, uri, compressFormat, i3));
            } else {
                this.f3430D = new WeakReference(new C1358a(this, this.f3452v, getCropPoints(), this.f3439i, width, height, this.f3432b.m6383c(), this.f3432b.getAspectRatioX(), this.f3432b.getAspectRatioY(), i4, i5, c1353h, uri, compressFormat, i3));
            }
            ((C1358a) this.f3430D.get()).execute(new Void[0]);
            m6355d();
        }
    }

    void m6360a(C1357a c1357a) {
        this.f3430D = null;
        m6355d();
        C1335d c1335d = this.f3449s;
        if (c1335d != null) {
            c1335d.onCropImageComplete(this, new C1347a(c1357a.f3487a, c1357a.f3488b, c1357a.f3489c, getCropPoints(), getCropRect(), getRotatedDegrees(), c1357a.f3491e));
        }
        if (c1357a.f3490d) {
            C1351f c1351f = this.f3451u;
            if (c1351f != null) {
                c1351f.m6342a(this, c1357a.f3488b, c1357a.f3489c);
                return;
            }
            return;
        }
        C1350e c1350e = this.f3450t;
        if (c1350e != null) {
            c1350e.m6341a(this, c1357a.f3487a, c1357a.f3489c);
        }
    }

    void m6361a(C1359a c1359a) {
        this.f3429C = null;
        m6355d();
        if (c1359a.f3513e == null) {
            m6349a(c1359a.f3510b, c1359a.f3509a, c1359a.f3511c, c1359a.f3512d);
        }
        C1352g c1352g = this.f3448r;
        if (c1352g != null) {
            c1352g.m6343a(this, c1359a.f3509a, c1359a.f3513e);
        }
    }

    public void m6362b(int i, int i2, C1353h c1353h) {
        if (this.f3449s == null && this.f3450t == null) {
            throw new IllegalArgumentException("mOnCropImageCompleteListener is not set");
        }
        m6359a(i, i2, c1353h, null, null, 0);
    }

    public Pair<Integer, Integer> getAspectRatio() {
        return new Pair(Integer.valueOf(this.f3432b.getAspectRatioX()), Integer.valueOf(this.f3432b.getAspectRatioY()));
    }

    public float[] getCropPoints() {
        int i = 0;
        RectF cropWindowRect = this.f3432b.getCropWindowRect();
        float[] fArr = new float[]{cropWindowRect.left, cropWindowRect.top, cropWindowRect.right, cropWindowRect.top, cropWindowRect.right, cropWindowRect.bottom, cropWindowRect.left, cropWindowRect.bottom};
        this.f3433c.invert(this.f3434d);
        this.f3434d.mapPoints(fArr);
        while (i < fArr.length) {
            fArr[i] = fArr[i] * ((float) this.f3453w);
            i++;
        }
        return fArr;
    }

    public Rect getCropRect() {
        return this.f3438h != null ? C1363c.m6399a(getCropPoints(), this.f3438h.getWidth() * this.f3453w, this.f3438h.getHeight() * this.f3453w, this.f3432b.m6383c(), this.f3432b.getAspectRatioX(), this.f3432b.getAspectRatioY()) : null;
    }

    public C1348b getCropShape() {
        return this.f3432b.getCropShape();
    }

    public Bitmap getCroppedImage() {
        return m6356a(0, 0, C1353h.NONE);
    }

    public void getCroppedImageAsync() {
        m6362b(0, 0, C1353h.NONE);
    }

    public C1349c getGuidelines() {
        return this.f3432b.getGuidelines();
    }

    public int getImageResource() {
        return this.f3442l;
    }

    public Uri getImageUri() {
        return this.f3452v;
    }

    public int getMaxZoom() {
        return this.f3447q;
    }

    public int getRotatedDegrees() {
        return this.f3439i;
    }

    public C1354i getScaleType() {
        return this.f3443m;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3440j <= 0 || this.f3441k <= 0) {
            m6351a(true);
            return;
        }
        LayoutParams layoutParams = getLayoutParams();
        layoutParams.width = this.f3440j;
        layoutParams.height = this.f3441k;
        setLayoutParams(layoutParams);
        if (this.f3438h != null) {
            m6346a((float) (i3 - i), (float) (i4 - i2), true, false);
            if (this.f3427A != null) {
                this.f3433c.mapRect(this.f3427A);
                this.f3432b.setCropWindowRect(this.f3427A);
                m6352a(false, false);
                this.f3432b.m6378a();
                this.f3427A = null;
                return;
            } else if (this.f3428B) {
                this.f3428B = false;
                m6352a(false, false);
                return;
            } else {
                return;
            }
        }
        m6351a(true);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size2 = MeasureSpec.getSize(i2);
        if (this.f3438h != null) {
            int width;
            int height;
            if (size2 == 0) {
                size2 = this.f3438h.getHeight();
            }
            double d = Double.POSITIVE_INFINITY;
            double d2 = Double.POSITIVE_INFINITY;
            if (size < this.f3438h.getWidth()) {
                d = ((double) size) / ((double) this.f3438h.getWidth());
            }
            if (size2 < this.f3438h.getHeight()) {
                d2 = ((double) size2) / ((double) this.f3438h.getHeight());
            }
            if (d == Double.POSITIVE_INFINITY && d2 == Double.POSITIVE_INFINITY) {
                width = this.f3438h.getWidth();
                height = this.f3438h.getHeight();
            } else if (d <= d2) {
                height = (int) (d * ((double) this.f3438h.getHeight()));
                width = size;
            } else {
                width = (int) (((double) this.f3438h.getWidth()) * d2);
                height = size2;
            }
            width = m6344a(mode, size, width);
            size2 = m6344a(mode2, size2, height);
            this.f3440j = width;
            this.f3441k = size2;
            setMeasuredDimension(this.f3440j, this.f3441k);
            return;
        }
        setMeasuredDimension(size, size2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (this.f3429C == null && this.f3452v == null && this.f3438h == null && this.f3442l == 0) {
                Uri uri = (Uri) bundle.getParcelable("LOADED_IMAGE_URI");
                if (uri != null) {
                    String string = bundle.getString("LOADED_IMAGE_STATE_BITMAP_KEY");
                    if (string != null) {
                        Bitmap bitmap = (C1363c.f3529g == null || !((String) C1363c.f3529g.first).equals(string)) ? null : (Bitmap) ((WeakReference) C1363c.f3529g.second).get();
                        if (!(bitmap == null || bitmap.isRecycled())) {
                            C1363c.f3529g = null;
                            m6349a(bitmap, uri, bundle.getInt("LOADED_SAMPLE_SIZE"), 0);
                        }
                    }
                    if (this.f3452v == null) {
                        setImageUriAsync(uri);
                    }
                } else {
                    int i = bundle.getInt("LOADED_IMAGE_RESOURCE");
                    if (i > 0) {
                        setImageResource(i);
                    } else {
                        Bitmap bitmap2 = (Bitmap) bundle.getParcelable("SET_BITMAP");
                        if (bitmap2 != null) {
                            setBitmap(bitmap2);
                        } else {
                            uri = (Uri) bundle.getParcelable("LOADING_IMAGE_URI");
                            if (uri != null) {
                                setImageUriAsync(uri);
                            }
                        }
                    }
                }
                this.f3439i = bundle.getInt("DEGREES_ROTATED");
                this.f3432b.setInitialCropWindowRect((Rect) bundle.getParcelable("INITIAL_CROP_RECT"));
                this.f3427A = (RectF) bundle.getParcelable("CROP_WINDOW_RECT");
                this.f3432b.setCropShape(C1348b.valueOf(bundle.getString("CROP_SHAPE")));
                this.f3446p = bundle.getBoolean("CROP_AUTO_ZOOM_ENABLED");
                this.f3447q = bundle.getInt("CROP_MAX_ZOOM");
            }
            super.onRestoreInstanceState(bundle.getParcelable("instanceState"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public Parcelable onSaveInstanceState() {
        Parcelable bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putParcelable("LOADED_IMAGE_URI", this.f3452v);
        bundle.putInt("LOADED_IMAGE_RESOURCE", this.f3442l);
        if (this.f3452v == null && this.f3442l < 1) {
            bundle.putParcelable("SET_BITMAP", this.f3438h);
        }
        if (!(this.f3452v == null || this.f3438h == null)) {
            String uuid = UUID.randomUUID().toString();
            C1363c.f3529g = new Pair(uuid, new WeakReference(this.f3438h));
            bundle.putString("LOADED_IMAGE_STATE_BITMAP_KEY", uuid);
        }
        if (this.f3429C != null) {
            C1360b c1360b = (C1360b) this.f3429C.get();
            if (c1360b != null) {
                bundle.putParcelable("LOADING_IMAGE_URI", c1360b.m6386a());
            }
        }
        bundle.putInt("LOADED_SAMPLE_SIZE", this.f3453w);
        bundle.putInt("DEGREES_ROTATED", this.f3439i);
        bundle.putParcelable("INITIAL_CROP_RECT", this.f3432b.getInitialCropWindowRect());
        C1363c.f3525c.set(this.f3432b.getCropWindowRect());
        this.f3433c.invert(this.f3434d);
        this.f3434d.mapRect(C1363c.f3525c);
        bundle.putParcelable("CROP_WINDOW_RECT", C1363c.f3525c);
        bundle.putString("CROP_SHAPE", this.f3432b.getCropShape().name());
        bundle.putBoolean("CROP_AUTO_ZOOM_ENABLED", this.f3446p);
        bundle.putInt("CROP_MAX_ZOOM", this.f3447q);
        return bundle;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        boolean z = i3 > 0 && i4 > 0;
        this.f3428B = z;
    }

    public void setAutoZoomEnabled(boolean z) {
        if (this.f3446p != z) {
            this.f3446p = z;
            m6352a(false, false);
            this.f3432b.invalidate();
        }
    }

    public void setCropRect(Rect rect) {
        this.f3432b.setInitialCropWindowRect(rect);
    }

    public void setCropShape(C1348b c1348b) {
        this.f3432b.setCropShape(c1348b);
    }

    public void setFixedAspectRatio(boolean z) {
        this.f3432b.setFixedAspectRatio(z);
    }

    public void setGuidelines(C1349c c1349c) {
        this.f3432b.setGuidelines(c1349c);
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f3432b.setInitialCropWindowRect(null);
        setBitmap(bitmap);
    }

    public void setImageResource(int i) {
        if (i != 0) {
            this.f3432b.setInitialCropWindowRect(null);
            m6347a(BitmapFactory.decodeResource(getResources(), i), i);
        }
    }

    public void setImageUriAsync(Uri uri) {
        if (uri != null) {
            C1360b c1360b = this.f3429C != null ? (C1360b) this.f3429C.get() : null;
            if (c1360b != null) {
                c1360b.cancel(true);
            }
            m6345a();
            this.f3432b.setInitialCropWindowRect(null);
            this.f3429C = new WeakReference(new C1360b(this, uri));
            ((C1360b) this.f3429C.get()).execute(new Void[0]);
            m6355d();
        }
    }

    public void setMaxZoom(int i) {
        if (this.f3447q != i && i > 0) {
            this.f3447q = i;
            m6352a(false, false);
            this.f3432b.invalidate();
        }
    }

    public void setMultiTouchEnabled(boolean z) {
        if (this.f3432b.m6381a(z)) {
            m6352a(false, false);
            this.f3432b.invalidate();
        }
    }

    public void setOnCropImageCompleteListener(C1335d c1335d) {
        this.f3449s = c1335d;
    }

    @Deprecated
    public void setOnGetCroppedImageCompleteListener(C1350e c1350e) {
        this.f3450t = c1350e;
    }

    @Deprecated
    public void setOnSaveCroppedImageCompleteListener(C1351f c1351f) {
        this.f3451u = c1351f;
    }

    public void setOnSetImageUriCompleteListener(C1352g c1352g) {
        this.f3448r = c1352g;
    }

    public void setRotatedDegrees(int i) {
        if (this.f3439i != i) {
            m6357a(i - this.f3439i);
        }
    }

    public void setScaleType(C1354i c1354i) {
        if (c1354i != this.f3443m) {
            this.f3443m = c1354i;
            this.f3454x = 1.0f;
            this.f3456z = 0.0f;
            this.f3455y = 0.0f;
            this.f3432b.m6382b();
            requestLayout();
        }
    }

    public void setShowCropOverlay(boolean z) {
        if (this.f3444n != z) {
            this.f3444n = z;
            m6354c();
        }
    }

    public void setShowProgressBar(boolean z) {
        if (this.f3445o != z) {
            this.f3445o = z;
            m6355d();
        }
    }

    public void setSnapRadius(float f) {
        if (f >= 0.0f) {
            this.f3432b.setSnapRadius(f);
        }
    }
}
