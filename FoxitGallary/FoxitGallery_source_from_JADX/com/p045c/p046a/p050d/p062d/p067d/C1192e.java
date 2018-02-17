package com.p045c.p046a.p050d.p062d.p067d;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p062d.p063a.C1145c;

/* renamed from: com.c.a.d.d.d.e */
public class C1192e implements C1146g<C1189b> {
    private final C1146g<Bitmap> f3037a;
    private final C1023c f3038b;

    public C1192e(C1146g<Bitmap> c1146g, C1023c c1023c) {
        this.f3037a = c1146g;
        this.f3038b = c1023c;
    }

    public C1084k<C1189b> m5766a(C1084k<C1189b> c1084k, int i, int i2) {
        C1189b c1189b = (C1189b) c1084k.m5505b();
        Bitmap b = ((C1189b) c1084k.m5505b()).m5754b();
        Bitmap bitmap = (Bitmap) this.f3037a.m5626a(new C1145c(b, this.f3038b), i, i2).m5505b();
        return !bitmap.equals(b) ? new C1191d(new C1189b(c1189b, bitmap, this.f3037a)) : c1084k;
    }

    public String m5767a() {
        return this.f3037a.m5627a();
    }
}
