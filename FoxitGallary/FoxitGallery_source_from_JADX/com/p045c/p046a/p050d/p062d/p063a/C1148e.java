package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;

/* renamed from: com.c.a.d.d.a.e */
public class C1148e extends C1147d {
    public C1148e(C1023c c1023c) {
        super(c1023c);
    }

    protected Bitmap m5630a(C1023c c1023c, Bitmap bitmap, int i, int i2) {
        Bitmap a = c1023c.m5339a(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        Bitmap a2 = C1173r.m5713a(a, bitmap, i, i2);
        if (!(a == null || a == a2 || c1023c.m5342a(a))) {
            a.recycle();
        }
        return a2;
    }

    public String m5631a() {
        return "CenterCrop.com.bumptech.glide.load.resource.bitmap";
    }
}
