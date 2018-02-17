package com.p045c.p046a;

import com.p045c.p046a.C1305l.C1303c;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p062d.p067d.C1189b;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import com.p045c.p046a.p064g.C1254e;
import java.io.InputStream;

/* renamed from: com.c.a.h */
public class C1284h<ModelType> extends C1255g<ModelType> {
    private final C1095l<ModelType, InputStream> f3218g;
    private final C1303c f3219h;

    C1284h(C0988e<ModelType, ?, ?, ?> c0988e, C1095l<ModelType, InputStream> c1095l, C1303c c1303c) {
        super(C1284h.m6065a(c0988e.f2579c, c1095l, C1189b.class, null), C1189b.class, c0988e);
        this.f3218g = c1095l;
        this.f3219h = c1303c;
        m5954c();
    }

    private static <A, R> C1254e<A, InputStream, C1189b, R> m6065a(C1288i c1288i, C1095l<A, InputStream> c1095l, Class<R> cls, C1220c<C1189b, R> c1220c) {
        if (c1095l == null) {
            return null;
        }
        C1220c a;
        if (c1220c == null) {
            a = c1288i.m6080a(C1189b.class, (Class) cls);
        }
        return new C1254e(c1095l, a, c1288i.m6085b(InputStream.class, C1189b.class));
    }
}
