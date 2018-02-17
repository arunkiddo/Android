package com.p045c.p046a.p050d.p062d.p071f;

import android.content.res.Resources;
import android.graphics.Bitmap;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p062d.p063a.C1160j;
import com.p045c.p046a.p050d.p062d.p063a.C1162k;

/* renamed from: com.c.a.d.d.f.b */
public class C1222b implements C1220c<Bitmap, C1160j> {
    private final Resources f3091a;
    private final C1023c f3092b;

    public C1222b(Resources resources, C1023c c1023c) {
        this.f3091a = resources;
        this.f3092b = c1023c;
    }

    public C1084k<C1160j> m5845a(C1084k<Bitmap> c1084k) {
        return new C1162k(new C1160j(this.f3091a, (Bitmap) c1084k.m5505b()), this.f3092b);
    }

    public String m5846a() {
        return "GlideBitmapDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
