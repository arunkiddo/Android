package com.theartofdev.edmodo.cropper;

import android.graphics.RectF;
import com.theartofdev.edmodo.cropper.C1370g.C1369a;
import com.theartofdev.edmodo.cropper.CropImageView.C1348b;

/* renamed from: com.theartofdev.edmodo.cropper.f */
final class C1367f {
    private final RectF f3584a;
    private final RectF f3585b;
    private float f3586c;
    private float f3587d;
    private float f3588e;
    private float f3589f;
    private float f3590g;
    private float f3591h;
    private float f3592i;
    private float f3593j;
    private float f3594k;
    private float f3595l;

    C1367f() {
        this.f3584a = new RectF();
        this.f3585b = new RectF();
        this.f3594k = 1.0f;
        this.f3595l = 1.0f;
    }

    private C1369a m6423a(float f, float f2) {
        float width = this.f3584a.width() / 6.0f;
        float height = this.f3584a.height() / 6.0f;
        float f3 = this.f3584a.top + height;
        height = (height * 5.0f) + this.f3584a.top;
        return f < this.f3584a.left + width ? f2 < f3 ? C1369a.TOP_LEFT : f2 < height ? C1369a.LEFT : C1369a.BOTTOM_LEFT : f < (width * 5.0f) + this.f3584a.left ? f2 < f3 ? C1369a.TOP : f2 < height ? C1369a.CENTER : C1369a.BOTTOM : f2 < f3 ? C1369a.TOP_RIGHT : f2 < height ? C1369a.RIGHT : C1369a.BOTTOM_RIGHT;
    }

    private C1369a m6424a(float f, float f2, float f3) {
        if (C1367f.m6425a(f, f2, this.f3584a.left, this.f3584a.top, f3)) {
            return C1369a.TOP_LEFT;
        }
        if (C1367f.m6425a(f, f2, this.f3584a.right, this.f3584a.top, f3)) {
            return C1369a.TOP_RIGHT;
        }
        if (C1367f.m6425a(f, f2, this.f3584a.left, this.f3584a.bottom, f3)) {
            return C1369a.BOTTOM_LEFT;
        }
        if (C1367f.m6425a(f, f2, this.f3584a.right, this.f3584a.bottom, f3)) {
            return C1369a.BOTTOM_RIGHT;
        }
        if (C1367f.m6428c(f, f2, this.f3584a.left, this.f3584a.top, this.f3584a.right, this.f3584a.bottom) && m6429i()) {
            return C1369a.CENTER;
        }
        if (C1367f.m6426a(f, f2, this.f3584a.left, this.f3584a.right, this.f3584a.top, f3)) {
            return C1369a.TOP;
        }
        if (C1367f.m6426a(f, f2, this.f3584a.left, this.f3584a.right, this.f3584a.bottom, f3)) {
            return C1369a.BOTTOM;
        }
        if (C1367f.m6427b(f, f2, this.f3584a.left, this.f3584a.top, this.f3584a.bottom, f3)) {
            return C1369a.LEFT;
        }
        if (C1367f.m6427b(f, f2, this.f3584a.right, this.f3584a.top, this.f3584a.bottom, f3)) {
            return C1369a.RIGHT;
        }
        return (!C1367f.m6428c(f, f2, this.f3584a.left, this.f3584a.top, this.f3584a.right, this.f3584a.bottom) || m6429i()) ? null : C1369a.CENTER;
    }

    private static boolean m6425a(float f, float f2, float f3, float f4, float f5) {
        return Math.abs(f - f3) <= f5 && Math.abs(f2 - f4) <= f5;
    }

    private static boolean m6426a(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f4 && Math.abs(f2 - f5) <= f6;
    }

    private static boolean m6427b(float f, float f2, float f3, float f4, float f5, float f6) {
        return Math.abs(f - f3) <= f6 && f2 > f4 && f2 < f5;
    }

    private static boolean m6428c(float f, float f2, float f3, float f4, float f5, float f6) {
        return f > f3 && f < f5 && f2 > f4 && f2 < f6;
    }

    private boolean m6429i() {
        return !m6441h();
    }

    public RectF m6430a() {
        this.f3585b.set(this.f3584a);
        return this.f3585b;
    }

    public C1370g m6431a(float f, float f2, float f3, C1348b c1348b) {
        C1369a a = c1348b == C1348b.OVAL ? m6423a(f, f2) : m6424a(f, f2, f3);
        return a != null ? new C1370g(a, this, f, f2) : null;
    }

    public void m6432a(float f, float f2, float f3, float f4) {
        this.f3588e = f;
        this.f3589f = f2;
        this.f3594k = f3;
        this.f3595l = f4;
    }

    public void m6433a(RectF rectF) {
        this.f3584a.set(rectF);
    }

    public void m6434a(C1366e c1366e) {
        this.f3586c = (float) c1366e.f3581x;
        this.f3587d = (float) c1366e.f3582y;
        this.f3590g = (float) c1366e.f3583z;
        this.f3591h = (float) c1366e.f3541A;
        this.f3592i = (float) c1366e.f3542B;
        this.f3593j = (float) c1366e.f3543C;
    }

    public float m6435b() {
        return Math.max(this.f3586c, this.f3590g / this.f3594k);
    }

    public float m6436c() {
        return Math.max(this.f3587d, this.f3591h / this.f3595l);
    }

    public float m6437d() {
        return Math.min(this.f3588e, this.f3592i / this.f3594k);
    }

    public float m6438e() {
        return Math.min(this.f3589f, this.f3593j / this.f3595l);
    }

    public float m6439f() {
        return this.f3594k;
    }

    public float m6440g() {
        return this.f3595l;
    }

    public boolean m6441h() {
        return this.f3584a.width() >= 100.0f && this.f3584a.height() >= 100.0f;
    }
}
