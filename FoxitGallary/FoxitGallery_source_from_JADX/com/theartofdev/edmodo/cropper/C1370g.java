package com.theartofdev.edmodo.cropper;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

/* renamed from: com.theartofdev.edmodo.cropper.g */
final class C1370g {
    private static final Matrix f3607a;
    private final float f3608b;
    private final float f3609c;
    private final float f3610d;
    private final float f3611e;
    private final C1369a f3612f;
    private final PointF f3613g;

    /* renamed from: com.theartofdev.edmodo.cropper.g.1 */
    static /* synthetic */ class C13681 {
        static final /* synthetic */ int[] f3596a;

        static {
            f3596a = new int[C1369a.values().length];
            try {
                f3596a[C1369a.TOP_LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3596a[C1369a.TOP_RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3596a[C1369a.BOTTOM_LEFT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3596a[C1369a.BOTTOM_RIGHT.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f3596a[C1369a.LEFT.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f3596a[C1369a.TOP.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f3596a[C1369a.RIGHT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f3596a[C1369a.BOTTOM.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f3596a[C1369a.CENTER.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* renamed from: com.theartofdev.edmodo.cropper.g.a */
    public enum C1369a {
        TOP_LEFT,
        TOP_RIGHT,
        BOTTOM_LEFT,
        BOTTOM_RIGHT,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        CENTER
    }

    static {
        f3607a = new Matrix();
    }

    public C1370g(C1369a c1369a, C1367f c1367f, float f, float f2) {
        this.f3613g = new PointF();
        this.f3612f = c1369a;
        this.f3608b = c1367f.m6435b();
        this.f3609c = c1367f.m6436c();
        this.f3610d = c1367f.m6437d();
        this.f3611e = c1367f.m6438e();
        m6444a(c1367f.m6430a(), f, f2);
    }

    private static float m6442a(float f, float f2, float f3, float f4) {
        return (f3 - f) / (f4 - f2);
    }

    private void m6443a(RectF rectF, float f) {
        rectF.left = rectF.right - (rectF.height() * f);
    }

    private void m6444a(RectF rectF, float f, float f2) {
        float f3;
        float f4 = 0.0f;
        switch (C13681.f3596a[this.f3612f.ordinal()]) {
            case C1373c.View_android_focusable /*1*/:
                f3 = rectF.left - f;
                f4 = rectF.top - f2;
                break;
            case C1373c.View_paddingStart /*2*/:
                f3 = rectF.right - f;
                f4 = rectF.top - f2;
                break;
            case C1373c.View_paddingEnd /*3*/:
                f3 = rectF.left - f;
                f4 = rectF.bottom - f2;
                break;
            case C1373c.View_theme /*4*/:
                f3 = rectF.right - f;
                f4 = rectF.bottom - f2;
                break;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                f3 = rectF.left - f;
                break;
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                f3 = 0.0f;
                f4 = rectF.top - f2;
                break;
            case C1373c.Toolbar_contentInsetLeft /*7*/:
                f3 = rectF.right - f;
                break;
            case C1373c.Toolbar_contentInsetRight /*8*/:
                f3 = 0.0f;
                f4 = rectF.bottom - f2;
                break;
            case C1373c.Toolbar_contentInsetStartWithNavigation /*9*/:
                f3 = rectF.centerX() - f;
                f4 = rectF.centerY() - f2;
                break;
            default:
                f3 = 0.0f;
                break;
        }
        this.f3613g.x = f3;
        this.f3613g.y = f4;
    }

    private void m6445a(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        float centerX = f - rectF.centerX();
        float centerY = f2 - rectF.centerY();
        if (rectF.left + centerX < 0.0f || rectF.right + centerX > ((float) i) || rectF.left + centerX < rectF2.left || rectF.right + centerX > rectF2.right) {
            centerX /= 1.05f;
            PointF pointF = this.f3613g;
            pointF.x -= centerX / 2.0f;
        }
        if (rectF.top + centerY < 0.0f || rectF.bottom + centerY > ((float) i2) || rectF.top + centerY < rectF2.top || rectF.bottom + centerY > rectF2.bottom) {
            centerY /= 1.05f;
            pointF = this.f3613g;
            pointF.y -= centerY / 2.0f;
        }
        rectF.offset(centerX, centerY);
        m6449a(rectF, rectF2, f3);
    }

    private void m6446a(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, float f4) {
        switch (C13681.f3596a[this.f3612f.ordinal()]) {
            case C1373c.View_android_focusable /*1*/:
                if (C1370g.m6442a(f, f2, rectF.right, rectF.bottom) < f4) {
                    m6452b(rectF, f2, rectF2, f3, f4, true, false);
                    m6443a(rectF, f4);
                    return;
                }
                m6447a(rectF, f, rectF2, f3, f4, true, false);
                m6450b(rectF, f4);
            case C1373c.View_paddingStart /*2*/:
                if (C1370g.m6442a(rectF.left, f2, f, rectF.bottom) < f4) {
                    m6452b(rectF, f2, rectF2, f3, f4, false, true);
                    m6455c(rectF, f4);
                    return;
                }
                m6448a(rectF, f, rectF2, i, f3, f4, true, false);
                m6450b(rectF, f4);
            case C1373c.View_paddingEnd /*3*/:
                if (C1370g.m6442a(f, rectF.top, rectF.right, f2) < f4) {
                    m6453b(rectF, f2, rectF2, i2, f3, f4, true, false);
                    m6443a(rectF, f4);
                    return;
                }
                m6447a(rectF, f, rectF2, f3, f4, false, true);
                m6457d(rectF, f4);
            case C1373c.View_theme /*4*/:
                if (C1370g.m6442a(rectF.left, rectF.top, f, f2) < f4) {
                    m6453b(rectF, f2, rectF2, i2, f3, f4, false, true);
                    m6455c(rectF, f4);
                    return;
                }
                m6448a(rectF, f, rectF2, i, f3, f4, false, true);
                m6457d(rectF, f4);
            case C1373c.Toolbar_contentInsetStart /*5*/:
                m6447a(rectF, f, rectF2, f3, f4, true, true);
                m6456c(rectF, rectF2, f4);
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                m6452b(rectF, f2, rectF2, f3, f4, true, true);
                m6454b(rectF, rectF2, f4);
            case C1373c.Toolbar_contentInsetLeft /*7*/:
                m6448a(rectF, f, rectF2, i, f3, f4, true, true);
                m6456c(rectF, rectF2, f4);
            case C1373c.Toolbar_contentInsetRight /*8*/:
                m6453b(rectF, f2, rectF2, i2, f3, f4, true, true);
                m6454b(rectF, rectF2, f4);
            default:
        }
    }

    private void m6447a(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            PointF pointF = this.f3613g;
            pointF.x -= f / 1.1f;
        }
        if (f < rectF2.left) {
            pointF = this.f3613g;
            pointF.x -= (f - rectF2.left) / 2.0f;
        }
        if (f - rectF2.left < f2) {
            f = rectF2.left;
        }
        if (rectF.right - f < this.f3608b) {
            f = rectF.right - this.f3608b;
        }
        if (rectF.right - f > this.f3610d) {
            f = rectF.right - this.f3610d;
        }
        float f4 = f - rectF2.left < f2 ? rectF2.left : f;
        if (f3 > 0.0f) {
            float f5 = (rectF.right - f4) / f3;
            if (f5 < this.f3609c) {
                f4 = Math.max(rectF2.left, rectF.right - (this.f3609c * f3));
                f5 = (rectF.right - f4) / f3;
            }
            if (f5 > this.f3611e) {
                f4 = Math.max(rectF2.left, rectF.right - (this.f3611e * f3));
                f5 = (rectF.right - f4) / f3;
            }
            if (z && z2) {
                f4 = Math.max(f4, Math.max(rectF2.left, rectF.right - (rectF2.height() * f3)));
            } else {
                if (z && rectF.bottom - r0 < rectF2.top) {
                    f4 = Math.max(rectF2.left, rectF.right - ((rectF.bottom - rectF2.top) * f3));
                    f5 = (rectF.right - f4) / f3;
                }
                if (z2 && r0 + rectF.top > rectF2.bottom) {
                    f4 = Math.max(f4, Math.max(rectF2.left, rectF.right - ((rectF2.bottom - rectF.top) * f3)));
                }
            }
        }
        rectF.left = f4;
    }

    private void m6448a(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        if (f > ((float) i)) {
            f = ((float) i) + ((f - ((float) i)) / 1.05f);
            PointF pointF = this.f3613g;
            pointF.x -= (f - ((float) i)) / 1.1f;
        }
        if (f > rectF2.right) {
            pointF = this.f3613g;
            pointF.x -= (f - rectF2.right) / 2.0f;
        }
        if (rectF2.right - f < f2) {
            f = rectF2.right;
        }
        if (f - rectF.left < this.f3608b) {
            f = rectF.left + this.f3608b;
        }
        if (f - rectF.left > this.f3610d) {
            f = rectF.left + this.f3610d;
        }
        float f4 = rectF2.right - f < f2 ? rectF2.right : f;
        if (f3 > 0.0f) {
            float f5 = (f4 - rectF.left) / f3;
            if (f5 < this.f3609c) {
                f4 = Math.min(rectF2.right, rectF.left + (this.f3609c * f3));
                f5 = (f4 - rectF.left) / f3;
            }
            if (f5 > this.f3611e) {
                f4 = Math.min(rectF2.right, rectF.left + (this.f3611e * f3));
                f5 = (f4 - rectF.left) / f3;
            }
            if (z && z2) {
                f4 = Math.min(f4, Math.min(rectF2.right, rectF.left + (rectF2.height() * f3)));
            } else {
                if (z && rectF.bottom - r0 < rectF2.top) {
                    f4 = Math.min(rectF2.right, rectF.left + ((rectF.bottom - rectF2.top) * f3));
                    f5 = (f4 - rectF.left) / f3;
                }
                if (z2 && r0 + rectF.top > rectF2.bottom) {
                    f4 = Math.min(f4, Math.min(rectF2.right, rectF.left + ((rectF2.bottom - rectF.top) * f3)));
                }
            }
        }
        rectF.right = f4;
    }

    private void m6449a(RectF rectF, RectF rectF2, float f) {
        if (rectF.left < rectF2.left + f) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.top < rectF2.top + f) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.right > rectF2.right - f) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
        if (rectF.bottom > rectF2.bottom - f) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }

    private void m6450b(RectF rectF, float f) {
        rectF.top = rectF.bottom - (rectF.width() / f);
    }

    private void m6451b(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3) {
        switch (C13681.f3596a[this.f3612f.ordinal()]) {
            case C1373c.View_android_focusable /*1*/:
                m6452b(rectF, f2, rectF2, f3, 0.0f, false, false);
                m6447a(rectF, f, rectF2, f3, 0.0f, false, false);
            case C1373c.View_paddingStart /*2*/:
                m6452b(rectF, f2, rectF2, f3, 0.0f, false, false);
                m6448a(rectF, f, rectF2, i, f3, 0.0f, false, false);
            case C1373c.View_paddingEnd /*3*/:
                m6453b(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                m6447a(rectF, f, rectF2, f3, 0.0f, false, false);
            case C1373c.View_theme /*4*/:
                m6453b(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
                m6448a(rectF, f, rectF2, i, f3, 0.0f, false, false);
            case C1373c.Toolbar_contentInsetStart /*5*/:
                m6447a(rectF, f, rectF2, f3, 0.0f, false, false);
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                m6452b(rectF, f2, rectF2, f3, 0.0f, false, false);
            case C1373c.Toolbar_contentInsetLeft /*7*/:
                m6448a(rectF, f, rectF2, i, f3, 0.0f, false, false);
            case C1373c.Toolbar_contentInsetRight /*8*/:
                m6453b(rectF, f2, rectF2, i2, f3, 0.0f, false, false);
            default:
        }
    }

    private void m6452b(RectF rectF, float f, RectF rectF2, float f2, float f3, boolean z, boolean z2) {
        if (f < 0.0f) {
            f /= 1.05f;
            PointF pointF = this.f3613g;
            pointF.y -= f / 1.1f;
        }
        if (f < rectF2.top) {
            pointF = this.f3613g;
            pointF.y -= (f - rectF2.top) / 2.0f;
        }
        if (f - rectF2.top < f2) {
            f = rectF2.top;
        }
        if (rectF.bottom - f < this.f3609c) {
            f = rectF.bottom - this.f3609c;
        }
        if (rectF.bottom - f > this.f3611e) {
            f = rectF.bottom - this.f3611e;
        }
        float f4 = f - rectF2.top < f2 ? rectF2.top : f;
        if (f3 > 0.0f) {
            float f5 = (rectF.bottom - f4) * f3;
            if (f5 < this.f3608b) {
                f4 = Math.max(rectF2.top, rectF.bottom - (this.f3608b / f3));
                f5 = (rectF.bottom - f4) * f3;
            }
            if (f5 > this.f3610d) {
                f4 = Math.max(rectF2.top, rectF.bottom - (this.f3610d / f3));
                f5 = (rectF.bottom - f4) * f3;
            }
            if (z && z2) {
                f4 = Math.max(f4, Math.max(rectF2.top, rectF.bottom - (rectF2.width() / f3)));
            } else {
                if (z && rectF.right - r0 < rectF2.left) {
                    f4 = Math.max(rectF2.top, rectF.bottom - ((rectF.right - rectF2.left) / f3));
                    f5 = (rectF.bottom - f4) * f3;
                }
                if (z2 && r0 + rectF.left > rectF2.right) {
                    f4 = Math.max(f4, Math.max(rectF2.top, rectF.bottom - ((rectF2.right - rectF.left) / f3)));
                }
            }
        }
        rectF.top = f4;
    }

    private void m6453b(RectF rectF, float f, RectF rectF2, int i, float f2, float f3, boolean z, boolean z2) {
        if (f > ((float) i)) {
            f = ((float) i) + ((f - ((float) i)) / 1.05f);
            PointF pointF = this.f3613g;
            pointF.y -= (f - ((float) i)) / 1.1f;
        }
        if (f > rectF2.bottom) {
            pointF = this.f3613g;
            pointF.y -= (f - rectF2.bottom) / 2.0f;
        }
        if (rectF2.bottom - f < f2) {
            f = rectF2.bottom;
        }
        if (f - rectF.top < this.f3609c) {
            f = rectF.top + this.f3609c;
        }
        if (f - rectF.top > this.f3611e) {
            f = rectF.top + this.f3611e;
        }
        float f4 = rectF2.bottom - f < f2 ? rectF2.bottom : f;
        if (f3 > 0.0f) {
            float f5 = (f4 - rectF.top) * f3;
            if (f5 < this.f3608b) {
                f4 = Math.min(rectF2.bottom, rectF.top + (this.f3608b / f3));
                f5 = (f4 - rectF.top) * f3;
            }
            if (f5 > this.f3610d) {
                f4 = Math.min(rectF2.bottom, rectF.top + (this.f3610d / f3));
                f5 = (f4 - rectF.top) * f3;
            }
            if (z && z2) {
                f4 = Math.min(f4, Math.min(rectF2.bottom, rectF.top + (rectF2.width() / f3)));
            } else {
                if (z && rectF.right - r0 < rectF2.left) {
                    f4 = Math.min(rectF2.bottom, rectF.top + ((rectF.right - rectF2.left) / f3));
                    f5 = (f4 - rectF.top) * f3;
                }
                if (z2 && r0 + rectF.left > rectF2.right) {
                    f4 = Math.min(f4, Math.min(rectF2.bottom, rectF.top + ((rectF2.right - rectF.left) / f3)));
                }
            }
        }
        rectF.bottom = f4;
    }

    private void m6454b(RectF rectF, RectF rectF2, float f) {
        rectF.inset((rectF.width() - (rectF.height() * f)) / 2.0f, 0.0f);
        if (rectF.left < rectF2.left) {
            rectF.offset(rectF2.left - rectF.left, 0.0f);
        }
        if (rectF.right > rectF2.right) {
            rectF.offset(rectF2.right - rectF.right, 0.0f);
        }
    }

    private void m6455c(RectF rectF, float f) {
        rectF.right = rectF.left + (rectF.height() * f);
    }

    private void m6456c(RectF rectF, RectF rectF2, float f) {
        rectF.inset(0.0f, (rectF.height() - (rectF.width() / f)) / 2.0f);
        if (rectF.top < rectF2.top) {
            rectF.offset(0.0f, rectF2.top - rectF.top);
        }
        if (rectF.bottom > rectF2.bottom) {
            rectF.offset(0.0f, rectF2.bottom - rectF.bottom);
        }
    }

    private void m6457d(RectF rectF, float f) {
        rectF.bottom = rectF.top + (rectF.width() / f);
    }

    public void m6458a(RectF rectF, float f, float f2, RectF rectF2, int i, int i2, float f3, boolean z, float f4) {
        float f5 = f + this.f3613g.x;
        float f6 = f2 + this.f3613g.y;
        if (this.f3612f == C1369a.CENTER) {
            m6445a(rectF, f5, f6, rectF2, i, i2, f3);
        } else if (z) {
            m6446a(rectF, f5, f6, rectF2, i, i2, f3, f4);
        } else {
            m6451b(rectF, f5, f6, rectF2, i, i2, f3);
        }
    }
}
