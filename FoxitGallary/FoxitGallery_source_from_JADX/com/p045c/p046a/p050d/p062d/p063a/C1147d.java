package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p055j.C1296h;

/* renamed from: com.c.a.d.d.a.d */
public abstract class C1147d implements C1146g<Bitmap> {
    private C1023c f2943a;

    public C1147d(C1023c c1023c) {
        this.f2943a = c1023c;
    }

    protected abstract Bitmap m5628a(C1023c c1023c, Bitmap bitmap, int i, int i2);

    public final C1084k<Bitmap> m5629a(C1084k<Bitmap> c1084k, int i, int i2) {
        if (C1296h.m6114a(i, i2)) {
            Bitmap bitmap = (Bitmap) c1084k.m5505b();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            Bitmap a = m5628a(this.f2943a, bitmap, i, i2);
            return bitmap.equals(a) ? c1084k : C1145c.m5621a(a, this.f2943a);
        } else {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
    }
}
