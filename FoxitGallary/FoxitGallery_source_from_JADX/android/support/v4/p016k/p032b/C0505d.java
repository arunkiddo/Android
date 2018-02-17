package android.support.v4.p016k.p032b;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.k.b.d */
abstract class C0505d implements Interpolator {
    private final float[] f830a;
    private final float f831b;

    public C0505d(float[] fArr) {
        this.f830a = fArr;
        this.f831b = 1.0f / ((float) (this.f830a.length - 1));
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f830a.length - 1)) * f), this.f830a.length - 2);
        float f2 = (f - (((float) min) * this.f831b)) / this.f831b;
        return ((this.f830a[min + 1] - this.f830a[min]) * f2) + this.f830a[min];
    }
}
