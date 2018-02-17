package com.p045c.p046a.p064g;

import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import java.io.File;

/* renamed from: com.c.a.g.a */
public class C1251a<A, T, Z, R> implements C1250f<A, T, Z, R>, Cloneable {
    private final C1250f<A, T, Z, R> f3136a;
    private C1155e<File, Z> f3137b;
    private C1155e<T, Z> f3138c;
    private C1143f<Z> f3139d;
    private C1220c<Z, R> f3140e;
    private C1092b<T> f3141f;

    public C1251a(C1250f<A, T, Z, R> c1250f) {
        this.f3136a = c1250f;
    }

    public C1155e<File, Z> m5907a() {
        return this.f3137b != null ? this.f3137b : this.f3136a.m5650a();
    }

    public void m5908a(C1092b<T> c1092b) {
        this.f3141f = c1092b;
    }

    public void m5909a(C1155e<File, Z> c1155e) {
        this.f3137b = c1155e;
    }

    public C1155e<T, Z> m5910b() {
        return this.f3138c != null ? this.f3138c : this.f3136a.m5651b();
    }

    public void m5911b(C1155e<T, Z> c1155e) {
        this.f3138c = c1155e;
    }

    public C1092b<T> m5912c() {
        return this.f3141f != null ? this.f3141f : this.f3136a.m5652c();
    }

    public /* synthetic */ Object clone() {
        return m5916g();
    }

    public C1143f<Z> m5913d() {
        return this.f3139d != null ? this.f3139d : this.f3136a.m5653d();
    }

    public C1095l<A, T> m5914e() {
        return this.f3136a.m5905e();
    }

    public C1220c<Z, R> m5915f() {
        return this.f3140e != null ? this.f3140e : this.f3136a.m5906f();
    }

    public C1251a<A, T, Z, R> m5916g() {
        try {
            return (C1251a) super.clone();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
