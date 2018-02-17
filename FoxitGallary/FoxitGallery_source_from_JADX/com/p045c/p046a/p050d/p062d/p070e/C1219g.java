package com.p045c.p046a.p050d.p062d.p070e;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p059c.C1132g;
import com.p045c.p046a.p050d.p062d.p066c.C1182c;
import com.p045c.p046a.p050d.p062d.p067d.C1189b;
import com.p045c.p046a.p064g.C1153b;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.e.g */
public class C1219g implements C1153b<C1132g, C1211a> {
    private final C1155e<File, C1211a> f3086a;
    private final C1155e<C1132g, C1211a> f3087b;
    private final C1143f<C1211a> f3088c;
    private final C1092b<C1132g> f3089d;

    public C1219g(C1153b<C1132g, Bitmap> c1153b, C1153b<InputStream, C1189b> c1153b2, C1023c c1023c) {
        C1155e c1215c = new C1215c(c1153b.m5651b(), c1153b2.m5651b(), c1023c);
        this.f3086a = new C1182c(new C1217e(c1215c));
        this.f3087b = c1215c;
        this.f3088c = new C1216d(c1153b.m5653d(), c1153b2.m5653d());
        this.f3089d = c1153b.m5652c();
    }

    public C1155e<File, C1211a> m5837a() {
        return this.f3086a;
    }

    public C1155e<C1132g, C1211a> m5838b() {
        return this.f3087b;
    }

    public C1092b<C1132g> m5839c() {
        return this.f3089d;
    }

    public C1143f<C1211a> m5840d() {
        return this.f3088c;
    }
}
