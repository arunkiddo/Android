package com.p045c.p046a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.widget.ImageView;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1056b;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p059c.C1132g;
import com.p045c.p046a.p050d.p062d.p063a.C1147d;
import com.p045c.p046a.p050d.p062d.p063a.C1149f;
import com.p045c.p046a.p050d.p062d.p063a.C1156h;
import com.p045c.p046a.p050d.p062d.p063a.C1167m;
import com.p045c.p046a.p050d.p062d.p063a.C1172q;
import com.p045c.p046a.p050d.p062d.p063a.C1175s;
import com.p045c.p046a.p050d.p062d.p066c.C1182c;
import com.p045c.p046a.p058h.p069b.C1195j;
import com.p045c.p046a.p064g.C1250f;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.c.a.a */
public class C0989a<ModelType, TranscodeType> extends C0988e<ModelType, C1132g, Bitmap, TranscodeType> {
    private final C1023c f2603g;
    private C1149f f2604h;
    private C1012a f2605i;
    private C1155e<InputStream, Bitmap> f2606j;
    private C1155e<ParcelFileDescriptor, Bitmap> f2607k;

    C0989a(C1250f<ModelType, C1132g, Bitmap, TranscodeType> c1250f, Class<TranscodeType> cls, C0988e<ModelType, ?, ?, ?> c0988e) {
        super(c1250f, cls, c0988e);
        this.f2604h = C1149f.f2944a;
        this.f2603g = c0988e.f2579c.m6079a();
        this.f2605i = c0988e.f2579c.m6090g();
        this.f2606j = new C1172q(this.f2603g, this.f2605i);
        this.f2607k = new C1156h(this.f2603g, this.f2605i);
    }

    public C0989a<ModelType, TranscodeType> m5133a() {
        return m5143a(this.c.m6086c());
    }

    public C0989a<ModelType, TranscodeType> m5134a(int i) {
        super.m5128d(i);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5135a(int i, int i2) {
        super.m5119b(i, i2);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5136a(C1012a c1012a) {
        this.f2605i = c1012a;
        this.f2606j = new C1172q(this.f2604h, this.f2603g, c1012a);
        this.f2607k = new C1156h(new C1175s(), this.f2603g, c1012a);
        super.m5127c(new C1182c(new C1172q(this.f2604h, this.f2603g, c1012a)));
        super.m5129d(new C1167m(this.f2606j, this.f2607k));
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5137a(C1056b c1056b) {
        super.m5120b(c1056b);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5138a(C1092b<C1132g> c1092b) {
        super.m5121b((C1092b) c1092b);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5139a(C1081c c1081c) {
        super.m5122b(c1081c);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5140a(C1155e<C1132g, Bitmap> c1155e) {
        super.m5129d((C1155e) c1155e);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5141a(ModelType modelType) {
        super.m5123b((Object) modelType);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5142a(boolean z) {
        super.m5124b(z);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5143a(C1147d... c1147dArr) {
        super.m5125b((C1146g[]) c1147dArr);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5144a(C1146g<Bitmap>... c1146gArr) {
        super.m5125b((C1146g[]) c1146gArr);
        return this;
    }

    public C1195j<TranscodeType> m5145a(ImageView imageView) {
        return super.m5117a(imageView);
    }

    public C0989a<ModelType, TranscodeType> m5146b() {
        return m5143a(this.c.m6087d());
    }

    public C0989a<ModelType, TranscodeType> m5147b(int i) {
        super.m5126c(i);
        return this;
    }

    public C0989a<ModelType, TranscodeType> m5148b(C1155e<File, Bitmap> c1155e) {
        super.m5127c((C1155e) c1155e);
        return this;
    }

    public /* synthetic */ C0988e m5149b(int i, int i2) {
        return m5135a(i, i2);
    }

    public /* synthetic */ C0988e m5150b(C1056b c1056b) {
        return m5137a(c1056b);
    }

    public /* synthetic */ C0988e m5151b(C1092b c1092b) {
        return m5138a(c1092b);
    }

    public /* synthetic */ C0988e m5152b(C1081c c1081c) {
        return m5139a(c1081c);
    }

    public /* synthetic */ C0988e m5153b(Object obj) {
        return m5141a(obj);
    }

    public /* synthetic */ C0988e m5154b(boolean z) {
        return m5142a(z);
    }

    public /* synthetic */ C0988e m5155b(C1146g[] c1146gArr) {
        return m5144a(c1146gArr);
    }

    public C0989a<ModelType, TranscodeType> m5156c() {
        return (C0989a) super.m5132f();
    }

    public /* synthetic */ C0988e m5157c(int i) {
        return m5147b(i);
    }

    public /* synthetic */ C0988e m5158c(C1155e c1155e) {
        return m5148b(c1155e);
    }

    public /* synthetic */ Object clone() {
        return m5156c();
    }

    public /* synthetic */ C0988e m5159d(int i) {
        return m5134a(i);
    }

    public /* synthetic */ C0988e m5160d(C1155e c1155e) {
        return m5140a(c1155e);
    }

    void m5161d() {
        m5146b();
    }

    void m5162e() {
        m5133a();
    }

    public /* synthetic */ C0988e m5163f() {
        return m5156c();
    }
}
