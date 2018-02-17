package com.p045c.p046a.p050d.p062d.p070e;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p062d.p067d.C1189b;
import com.p045c.p046a.p050d.p062d.p067d.C1192e;

/* renamed from: com.c.a.d.d.e.f */
public class C1218f implements C1146g<C1211a> {
    private final C1146g<Bitmap> f3084a;
    private final C1146g<C1189b> f3085b;

    public C1218f(C1023c c1023c, C1146g<Bitmap> c1146g) {
        this((C1146g) c1146g, new C1192e(c1146g, c1023c));
    }

    C1218f(C1146g<Bitmap> c1146g, C1146g<C1189b> c1146g2) {
        this.f3084a = c1146g;
        this.f3085b = c1146g2;
    }

    public C1084k<C1211a> m5835a(C1084k<C1211a> c1084k, int i, int i2) {
        C1084k b = ((C1211a) c1084k.m5505b()).m5814b();
        C1084k c = ((C1211a) c1084k.m5505b()).m5815c();
        if (b != null && this.f3084a != null) {
            C1084k a = this.f3084a.m5626a(b, i, i2);
            return !b.equals(a) ? new C1212b(new C1211a(a, ((C1211a) c1084k.m5505b()).m5815c())) : c1084k;
        } else if (c == null || this.f3085b == null) {
            return c1084k;
        } else {
            b = this.f3085b.m5626a(c, i, i2);
            return !c.equals(b) ? new C1212b(new C1211a(((C1211a) c1084k.m5505b()).m5814b(), b)) : c1084k;
        }
    }

    public String m5836a() {
        return this.f3084a.m5627a();
    }
}
