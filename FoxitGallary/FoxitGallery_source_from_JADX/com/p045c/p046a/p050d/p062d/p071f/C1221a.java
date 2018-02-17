package com.p045c.p046a.p050d.p062d.p071f;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p062d.p063a.C1160j;
import com.p045c.p046a.p050d.p062d.p065b.C1159b;
import com.p045c.p046a.p050d.p062d.p070e.C1211a;

/* renamed from: com.c.a.d.d.f.a */
public class C1221a implements C1220c<C1211a, C1159b> {
    private final C1220c<Bitmap, C1160j> f3090a;

    public C1221a(C1220c<Bitmap, C1160j> c1220c) {
        this.f3090a = c1220c;
    }

    public C1084k<C1159b> m5843a(C1084k<C1211a> c1084k) {
        C1211a c1211a = (C1211a) c1084k.m5505b();
        C1084k b = c1211a.m5814b();
        return b != null ? this.f3090a.m5841a(b) : c1211a.m5815c();
    }

    public String m5844a() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }
}
