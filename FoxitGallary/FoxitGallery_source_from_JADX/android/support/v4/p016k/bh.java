package android.support.v4.p016k;

import android.view.WindowInsets;

/* renamed from: android.support.v4.k.bh */
class bh extends bg {
    private final WindowInsets f841a;

    bh(WindowInsets windowInsets) {
        this.f841a = windowInsets;
    }

    public int m2252a() {
        return this.f841a.getSystemWindowInsetLeft();
    }

    public bg m2253a(int i, int i2, int i3, int i4) {
        return new bh(this.f841a.replaceSystemWindowInsets(i, i2, i3, i4));
    }

    public int m2254b() {
        return this.f841a.getSystemWindowInsetTop();
    }

    public int m2255c() {
        return this.f841a.getSystemWindowInsetRight();
    }

    public int m2256d() {
        return this.f841a.getSystemWindowInsetBottom();
    }

    public boolean m2257e() {
        return this.f841a.isConsumed();
    }

    WindowInsets m2258f() {
        return this.f841a;
    }
}
