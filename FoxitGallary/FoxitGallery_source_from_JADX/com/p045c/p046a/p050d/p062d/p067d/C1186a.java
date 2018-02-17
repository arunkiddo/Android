package com.p045c.p046a.p050d.p062d.p067d;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.p045c.p046a.p048b.C0991a.C0990a;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;

/* renamed from: com.c.a.d.d.d.a */
class C1186a implements C0990a {
    private final C1023c f3011a;

    public C1186a(C1023c c1023c) {
        this.f3011a = c1023c;
    }

    public Bitmap m5745a(int i, int i2, Config config) {
        return this.f3011a.m5343b(i, i2, config);
    }

    public void m5746a(Bitmap bitmap) {
        if (!this.f3011a.m5342a(bitmap)) {
            bitmap.recycle();
        }
    }
}
