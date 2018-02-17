package com.p045c.p046a.p050d.p062d.p070e;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p062d.p067d.C1189b;
import java.io.OutputStream;

/* renamed from: com.c.a.d.d.e.d */
public class C1216d implements C1143f<C1211a> {
    private final C1143f<Bitmap> f3080a;
    private final C1143f<C1189b> f3081b;
    private String f3082c;

    public C1216d(C1143f<Bitmap> c1143f, C1143f<C1189b> c1143f2) {
        this.f3080a = c1143f;
        this.f3081b = c1143f2;
    }

    public String m5829a() {
        if (this.f3082c == null) {
            this.f3082c = this.f3080a.m5525a() + this.f3081b.m5525a();
        }
        return this.f3082c;
    }

    public boolean m5830a(C1084k<C1211a> c1084k, OutputStream outputStream) {
        C1211a c1211a = (C1211a) c1084k.m5505b();
        C1084k b = c1211a.m5814b();
        return b != null ? this.f3080a.m5526a(b, outputStream) : this.f3081b.m5526a(c1211a.m5815c(), outputStream);
    }
}
