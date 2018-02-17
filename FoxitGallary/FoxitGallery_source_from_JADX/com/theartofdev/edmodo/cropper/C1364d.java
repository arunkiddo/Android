package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.ImageView;

/* renamed from: com.theartofdev.edmodo.cropper.d */
final class C1364d extends Animation implements AnimationListener {
    private final ImageView f3530a;
    private final CropOverlayView f3531b;
    private final float[] f3532c;
    private final float[] f3533d;
    private final RectF f3534e;
    private final RectF f3535f;
    private final float[] f3536g;
    private final float[] f3537h;
    private final RectF f3538i;
    private final float[] f3539j;
    private final float[] f3540k;

    public C1364d(ImageView imageView, CropOverlayView cropOverlayView) {
        this.f3532c = new float[8];
        this.f3533d = new float[8];
        this.f3534e = new RectF();
        this.f3535f = new RectF();
        this.f3536g = new float[9];
        this.f3537h = new float[9];
        this.f3538i = new RectF();
        this.f3539j = new float[8];
        this.f3540k = new float[9];
        this.f3530a = imageView;
        this.f3531b = cropOverlayView;
        setDuration(300);
        setFillAfter(true);
        setInterpolator(new AccelerateDecelerateInterpolator());
        setAnimationListener(this);
    }

    public void m6418a(float[] fArr, Matrix matrix) {
        reset();
        System.arraycopy(fArr, 0, this.f3532c, 0, 8);
        this.f3534e.set(this.f3531b.getCropWindowRect());
        matrix.getValues(this.f3536g);
    }

    protected void applyTransformation(float f, Transformation transformation) {
        int i = 0;
        this.f3538i.left = this.f3534e.left + ((this.f3535f.left - this.f3534e.left) * f);
        this.f3538i.top = this.f3534e.top + ((this.f3535f.top - this.f3534e.top) * f);
        this.f3538i.right = this.f3534e.right + ((this.f3535f.right - this.f3534e.right) * f);
        this.f3538i.bottom = this.f3534e.bottom + ((this.f3535f.bottom - this.f3534e.bottom) * f);
        this.f3531b.setCropWindowRect(this.f3538i);
        for (int i2 = 0; i2 < this.f3539j.length; i2++) {
            this.f3539j[i2] = this.f3532c[i2] + ((this.f3533d[i2] - this.f3532c[i2]) * f);
        }
        this.f3531b.m6380a(this.f3539j, this.f3530a.getWidth(), this.f3530a.getHeight());
        while (i < this.f3540k.length) {
            this.f3540k[i] = this.f3536g[i] + ((this.f3537h[i] - this.f3536g[i]) * f);
            i++;
        }
        Matrix imageMatrix = this.f3530a.getImageMatrix();
        imageMatrix.setValues(this.f3540k);
        this.f3530a.setImageMatrix(imageMatrix);
        this.f3530a.invalidate();
        this.f3531b.invalidate();
    }

    public void m6419b(float[] fArr, Matrix matrix) {
        System.arraycopy(fArr, 0, this.f3533d, 0, 8);
        this.f3535f.set(this.f3531b.getCropWindowRect());
        matrix.getValues(this.f3537h);
    }

    public void onAnimationEnd(Animation animation) {
        this.f3530a.clearAnimation();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
    }
}
