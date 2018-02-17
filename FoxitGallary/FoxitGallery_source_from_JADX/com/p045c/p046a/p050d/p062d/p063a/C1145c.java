package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p055j.C1296h;

/* renamed from: com.c.a.d.d.a.c */
public class C1145c implements C1084k<Bitmap> {
    private final Bitmap f2941a;
    private final C1023c f2942b;

    public C1145c(Bitmap bitmap, C1023c c1023c) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (c1023c == null) {
            throw new NullPointerException("BitmapPool must not be null");
        } else {
            this.f2941a = bitmap;
            this.f2942b = c1023c;
        }
    }

    public static C1145c m5621a(Bitmap bitmap, C1023c c1023c) {
        return bitmap == null ? null : new C1145c(bitmap, c1023c);
    }

    public Bitmap m5622a() {
        return this.f2941a;
    }

    public /* synthetic */ Object m5623b() {
        return m5622a();
    }

    public int m5624c() {
        return C1296h.m6108a(this.f2941a);
    }

    public void m5625d() {
        if (!this.f2942b.m5342a(this.f2941a)) {
            this.f2941a.recycle();
        }
    }
}
