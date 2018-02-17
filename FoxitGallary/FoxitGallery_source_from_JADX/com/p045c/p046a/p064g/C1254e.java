package com.p045c.p046a.p064g;

import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import java.io.File;

/* renamed from: com.c.a.g.e */
public class C1254e<A, T, Z, R> implements C1250f<A, T, Z, R> {
    private final C1095l<A, T> f3145a;
    private final C1220c<Z, R> f3146b;
    private final C1153b<T, Z> f3147c;

    public C1254e(C1095l<A, T> c1095l, C1220c<Z, R> c1220c, C1153b<T, Z> c1153b) {
        if (c1095l == null) {
            throw new NullPointerException("ModelLoader must not be null");
        }
        this.f3145a = c1095l;
        if (c1220c == null) {
            throw new NullPointerException("Transcoder must not be null");
        }
        this.f3146b = c1220c;
        if (c1153b == null) {
            throw new NullPointerException("DataLoadProvider must not be null");
        }
        this.f3147c = c1153b;
    }

    public C1155e<File, Z> m5924a() {
        return this.f3147c.m5650a();
    }

    public C1155e<T, Z> m5925b() {
        return this.f3147c.m5651b();
    }

    public C1092b<T> m5926c() {
        return this.f3147c.m5652c();
    }

    public C1143f<Z> m5927d() {
        return this.f3147c.m5653d();
    }

    public C1095l<A, T> m5928e() {
        return this.f3145a;
    }

    public C1220c<Z, R> m5929f() {
        return this.f3146b;
    }
}
