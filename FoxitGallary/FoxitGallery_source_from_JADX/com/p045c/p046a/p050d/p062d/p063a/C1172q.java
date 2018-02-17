package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.a.q */
public class C1172q implements C1155e<InputStream, Bitmap> {
    private final C1149f f2995a;
    private C1023c f2996b;
    private C1012a f2997c;
    private String f2998d;

    public C1172q(C1023c c1023c, C1012a c1012a) {
        this(C1149f.f2944a, c1023c, c1012a);
    }

    public C1172q(C1149f c1149f, C1023c c1023c, C1012a c1012a) {
        this.f2995a = c1149f;
        this.f2996b = c1023c;
        this.f2997c = c1012a;
    }

    public C1084k<Bitmap> m5708a(InputStream inputStream, int i, int i2) {
        return C1145c.m5621a(this.f2995a.m5642a(inputStream, this.f2996b, i, i2, this.f2997c), this.f2996b);
    }

    public String m5710a() {
        if (this.f2998d == null) {
            this.f2998d = "StreamBitmapDecoder.com.bumptech.glide.load.resource.bitmap" + this.f2995a.m5616a() + this.f2997c.name();
        }
        return this.f2998d;
    }
}
