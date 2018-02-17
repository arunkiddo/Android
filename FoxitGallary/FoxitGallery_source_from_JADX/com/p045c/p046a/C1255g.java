package com.p045c.p046a;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1056b;
import com.p045c.p046a.p050d.p062d.p063a.C1147d;
import com.p045c.p046a.p050d.p062d.p067d.C1189b;
import com.p045c.p046a.p050d.p062d.p067d.C1192e;
import com.p045c.p046a.p058h.p073a.C1260a;
import com.p045c.p046a.p064g.C1250f;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.c.a.g */
public class C1255g<ModelType> extends C0988e<ModelType, InputStream, C1189b, C1189b> {
    C1255g(C1250f<ModelType, InputStream, C1189b, C1189b> c1250f, Class<C1189b> cls, C0988e<ModelType, ?, ?, ?> c0988e) {
        super(c1250f, cls, c0988e);
    }

    private C1192e[] m5930c(C1146g<Bitmap>[] c1146gArr) {
        C1192e[] c1192eArr = new C1192e[c1146gArr.length];
        for (int i = 0; i < c1146gArr.length; i++) {
            c1192eArr[i] = new C1192e(c1146gArr[i], this.c.m6079a());
        }
        return c1192eArr;
    }

    public C1255g<ModelType> m5931a() {
        return m5940a(this.c.m6086c());
    }

    public C1255g<ModelType> m5932a(int i) {
        super.m5128d(i);
        return this;
    }

    public C1255g<ModelType> m5933a(int i, int i2) {
        super.m5119b(i, i2);
        return this;
    }

    public C1255g<ModelType> m5934a(C1056b c1056b) {
        super.m5120b(c1056b);
        return this;
    }

    public C1255g<ModelType> m5935a(C1092b<InputStream> c1092b) {
        super.m5121b((C1092b) c1092b);
        return this;
    }

    public C1255g<ModelType> m5936a(C1081c c1081c) {
        super.m5122b(c1081c);
        return this;
    }

    public C1255g<ModelType> m5937a(C1155e<InputStream, C1189b> c1155e) {
        super.m5129d((C1155e) c1155e);
        return this;
    }

    public C1255g<ModelType> m5938a(ModelType modelType) {
        super.m5123b((Object) modelType);
        return this;
    }

    public C1255g<ModelType> m5939a(boolean z) {
        super.m5124b(z);
        return this;
    }

    public C1255g<ModelType> m5940a(C1147d... c1147dArr) {
        return m5941a(m5930c((C1146g[]) c1147dArr));
    }

    public C1255g<ModelType> m5941a(C1146g<C1189b>... c1146gArr) {
        super.m5125b((C1146g[]) c1146gArr);
        return this;
    }

    public /* synthetic */ C0988e m5942b(int i, int i2) {
        return m5933a(i, i2);
    }

    public /* synthetic */ C0988e m5943b(C1056b c1056b) {
        return m5934a(c1056b);
    }

    public /* synthetic */ C0988e m5944b(C1092b c1092b) {
        return m5935a(c1092b);
    }

    public /* synthetic */ C0988e m5945b(C1081c c1081c) {
        return m5936a(c1081c);
    }

    public /* synthetic */ C0988e m5946b(Object obj) {
        return m5938a(obj);
    }

    public /* synthetic */ C0988e m5947b(boolean z) {
        return m5939a(z);
    }

    public /* synthetic */ C0988e m5948b(C1146g[] c1146gArr) {
        return m5941a(c1146gArr);
    }

    public C1255g<ModelType> m5949b() {
        return m5940a(this.c.m6087d());
    }

    public C1255g<ModelType> m5950b(int i) {
        super.m5126c(i);
        return this;
    }

    public C1255g<ModelType> m5951b(C1155e<File, C1189b> c1155e) {
        super.m5127c((C1155e) c1155e);
        return this;
    }

    public /* synthetic */ C0988e m5952c(int i) {
        return m5950b(i);
    }

    public /* synthetic */ C0988e m5953c(C1155e c1155e) {
        return m5951b(c1155e);
    }

    public C1255g<ModelType> m5954c() {
        super.m5116a(new C1260a());
        return this;
    }

    public /* synthetic */ Object clone() {
        return m5960g();
    }

    public /* synthetic */ C0988e m5955d(int i) {
        return m5932a(i);
    }

    public /* synthetic */ C0988e m5956d(C1155e c1155e) {
        return m5937a(c1155e);
    }

    void m5957d() {
        m5949b();
    }

    void m5958e() {
        m5931a();
    }

    public /* synthetic */ C0988e m5959f() {
        return m5960g();
    }

    public C1255g<ModelType> m5960g() {
        return (C1255g) super.m5132f();
    }
}
