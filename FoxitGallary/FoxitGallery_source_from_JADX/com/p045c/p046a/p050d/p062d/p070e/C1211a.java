package com.p045c.p046a.p050d.p062d.p070e;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p062d.p067d.C1189b;

/* renamed from: com.c.a.d.d.e.a */
public class C1211a {
    private final C1084k<C1189b> f3069a;
    private final C1084k<Bitmap> f3070b;

    public C1211a(C1084k<Bitmap> c1084k, C1084k<C1189b> c1084k2) {
        if (c1084k != null && c1084k2 != null) {
            throw new IllegalArgumentException("Can only contain either a bitmap resource or a gif resource, not both");
        } else if (c1084k == null && c1084k2 == null) {
            throw new IllegalArgumentException("Must contain either a bitmap resource or a gif resource");
        } else {
            this.f3070b = c1084k;
            this.f3069a = c1084k2;
        }
    }

    public int m5813a() {
        return this.f3070b != null ? this.f3070b.m5506c() : this.f3069a.m5506c();
    }

    public C1084k<Bitmap> m5814b() {
        return this.f3070b;
    }

    public C1084k<C1189b> m5815c() {
        return this.f3069a;
    }
}
