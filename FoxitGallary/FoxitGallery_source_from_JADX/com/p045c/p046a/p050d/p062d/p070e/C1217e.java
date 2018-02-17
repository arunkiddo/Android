package com.p045c.p046a.p050d.p062d.p070e;

import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p059c.C1132g;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.e.e */
public class C1217e implements C1155e<InputStream, C1211a> {
    private final C1155e<C1132g, C1211a> f3083a;

    public C1217e(C1155e<C1132g, C1211a> c1155e) {
        this.f3083a = c1155e;
    }

    public C1084k<C1211a> m5832a(InputStream inputStream, int i, int i2) {
        return this.f3083a.m5658a(new C1132g(inputStream, null), i, i2);
    }

    public String m5834a() {
        return this.f3083a.m5659a();
    }
}
