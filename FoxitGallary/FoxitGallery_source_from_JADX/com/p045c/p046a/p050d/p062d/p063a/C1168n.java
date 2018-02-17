package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p059c.C1132g;
import com.p045c.p046a.p050d.p059c.C1133h;
import com.p045c.p046a.p064g.C1153b;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.a.n */
public class C1168n implements C1153b<C1132g, Bitmap> {
    private final C1167m f2982a;
    private final C1155e<File, Bitmap> f2983b;
    private final C1143f<Bitmap> f2984c;
    private final C1133h f2985d;

    public C1168n(C1153b<InputStream, Bitmap> c1153b, C1153b<ParcelFileDescriptor, Bitmap> c1153b2) {
        this.f2984c = c1153b.m5653d();
        this.f2985d = new C1133h(c1153b.m5652c(), c1153b2.m5652c());
        this.f2983b = c1153b.m5650a();
        this.f2982a = new C1167m(c1153b.m5651b(), c1153b2.m5651b());
    }

    public C1155e<File, Bitmap> m5697a() {
        return this.f2983b;
    }

    public C1155e<C1132g, Bitmap> m5698b() {
        return this.f2982a;
    }

    public C1092b<C1132g> m5699c() {
        return this.f2985d;
    }

    public C1143f<Bitmap> m5700d() {
        return this.f2984c;
    }
}
