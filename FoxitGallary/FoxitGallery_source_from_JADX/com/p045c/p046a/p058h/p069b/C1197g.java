package com.p045c.p046a.p058h.p069b;

import com.p045c.p046a.p055j.C1296h;

/* renamed from: com.c.a.h.b.g */
public abstract class C1197g<Z> extends C1196a<Z> {
    private final int height;
    private final int width;

    public C1197g() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public C1197g(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    public final void getSize(C1269h c1269h) {
        if (C1296h.m6114a(this.width, this.height)) {
            c1269h.m5988a(this.width, this.height);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor" + " or call override()");
    }
}
