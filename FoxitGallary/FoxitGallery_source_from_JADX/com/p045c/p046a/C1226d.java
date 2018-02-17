package com.p045c.p046a;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.C1305l.C1303c;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1131f;
import com.p045c.p046a.p050d.p059c.C1132g;
import com.p045c.p046a.p050d.p062d.p065b.C1159b;
import com.p045c.p046a.p050d.p062d.p070e.C1211a;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import com.p045c.p046a.p064g.C1254e;
import com.p045c.p046a.p068e.C1228g;
import com.p045c.p046a.p068e.C1243m;
import java.io.InputStream;

/* renamed from: com.c.a.d */
public class C1226d<ModelType> extends C0999c<ModelType> {
    private final C1095l<ModelType, InputStream> f3098g;
    private final C1095l<ModelType, ParcelFileDescriptor> f3099h;
    private final C1303c f3100i;

    C1226d(Class<ModelType> cls, C1095l<ModelType, InputStream> c1095l, C1095l<ModelType, ParcelFileDescriptor> c1095l2, Context context, C1288i c1288i, C1243m c1243m, C1228g c1228g, C1303c c1303c) {
        super(context, cls, C1226d.m5854a(c1288i, c1095l, c1095l2, C1211a.class, C1159b.class, null), c1288i, c1243m, c1228g);
        this.f3098g = c1095l;
        this.f3099h = c1095l2;
        this.f3100i = c1303c;
    }

    private static <A, Z, R> C1254e<A, C1132g, Z, R> m5854a(C1288i c1288i, C1095l<A, InputStream> c1095l, C1095l<A, ParcelFileDescriptor> c1095l2, Class<Z> cls, Class<R> cls2, C1220c<Z, R> c1220c) {
        if (c1095l == null && c1095l2 == null) {
            return null;
        }
        C1220c a;
        if (c1220c == null) {
            a = c1288i.m6080a((Class) cls, (Class) cls2);
        }
        return new C1254e(new C1131f(c1095l, c1095l2), a, c1288i.m6085b(C1132g.class, (Class) cls));
    }

    public C0995b<ModelType> m5855h() {
        return (C0995b) this.f3100i.m6124a(new C0995b(this, this.f3098g, this.f3099h, this.f3100i));
    }

    public C1284h<ModelType> m5856i() {
        return (C1284h) this.f3100i.m6124a(new C1284h(this, this.f3098g, this.f3100i));
    }
}
