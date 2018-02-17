package com.p045c.p046a.p050d.p062d.p070e;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p059c.C1132g;
import com.p045c.p046a.p050d.p062d.p063a.C1145c;
import com.p045c.p046a.p050d.p062d.p063a.C1166l;
import com.p045c.p046a.p050d.p062d.p063a.C1166l.C1163a;
import com.p045c.p046a.p050d.p062d.p063a.C1170o;
import com.p045c.p046a.p050d.p062d.p067d.C1189b;
import com.p045c.p046a.p055j.C1289a;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.e.c */
public class C1215c implements C1155e<C1132g, C1211a> {
    private static final C1214b f3072a;
    private static final C1213a f3073b;
    private final C1155e<C1132g, Bitmap> f3074c;
    private final C1155e<InputStream, C1189b> f3075d;
    private final C1023c f3076e;
    private final C1214b f3077f;
    private final C1213a f3078g;
    private String f3079h;

    /* renamed from: com.c.a.d.d.e.c.a */
    static class C1213a {
        C1213a() {
        }

        public InputStream m5820a(InputStream inputStream, byte[] bArr) {
            return new C1170o(inputStream, bArr);
        }
    }

    /* renamed from: com.c.a.d.d.e.c.b */
    static class C1214b {
        C1214b() {
        }

        public C1163a m5821a(InputStream inputStream) {
            return new C1166l(inputStream).m5692b();
        }
    }

    static {
        f3072a = new C1214b();
        f3073b = new C1213a();
    }

    public C1215c(C1155e<C1132g, Bitmap> c1155e, C1155e<InputStream, C1189b> c1155e2, C1023c c1023c) {
        this(c1155e, c1155e2, c1023c, f3072a, f3073b);
    }

    C1215c(C1155e<C1132g, Bitmap> c1155e, C1155e<InputStream, C1189b> c1155e2, C1023c c1023c, C1214b c1214b, C1213a c1213a) {
        this.f3074c = c1155e;
        this.f3075d = c1155e2;
        this.f3076e = c1023c;
        this.f3077f = c1214b;
        this.f3078g = c1213a;
    }

    private C1211a m5822a(C1132g c1132g, int i, int i2, byte[] bArr) {
        return c1132g.m5596a() != null ? m5825b(c1132g, i, i2, bArr) : m5824b(c1132g, i, i2);
    }

    private C1211a m5823a(InputStream inputStream, int i, int i2) {
        C1084k a = this.f3075d.m5658a(inputStream, i, i2);
        if (a == null) {
            return null;
        }
        C1189b c1189b = (C1189b) a.m5505b();
        return c1189b.m5758e() > 1 ? new C1211a(null, a) : new C1211a(new C1145c(c1189b.m5754b(), this.f3076e), null);
    }

    private C1211a m5824b(C1132g c1132g, int i, int i2) {
        C1084k a = this.f3074c.m5658a(c1132g, i, i2);
        return a != null ? new C1211a(a, null) : null;
    }

    private C1211a m5825b(C1132g c1132g, int i, int i2, byte[] bArr) {
        InputStream a = this.f3078g.m5820a(c1132g.m5596a(), bArr);
        a.mark(2048);
        C1163a a2 = this.f3077f.m5821a(a);
        a.reset();
        C1211a c1211a = null;
        if (a2 == C1163a.GIF) {
            c1211a = m5823a(a, i, i2);
        }
        return c1211a == null ? m5824b(new C1132g(a, c1132g.m5597b()), i, i2) : c1211a;
    }

    public C1084k<C1211a> m5826a(C1132g c1132g, int i, int i2) {
        C1289a a = C1289a.m6092a();
        byte[] b = a.m6094b();
        try {
            C1211a a2 = m5822a(c1132g, i, i2, b);
            return a2 != null ? new C1212b(a2) : null;
        } finally {
            a.m6093a(b);
        }
    }

    public String m5828a() {
        if (this.f3079h == null) {
            this.f3079h = this.f3075d.m5659a() + this.f3074c.m5659a();
        }
        return this.f3079h;
    }
}
