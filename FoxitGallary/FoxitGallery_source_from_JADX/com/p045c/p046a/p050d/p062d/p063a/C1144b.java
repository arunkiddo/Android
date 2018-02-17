package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p055j.C1292d;
import com.p045c.p046a.p055j.C1296h;
import java.io.OutputStream;

/* renamed from: com.c.a.d.d.a.b */
public class C1144b implements C1143f<Bitmap> {
    private CompressFormat f2939a;
    private int f2940b;

    public C1144b() {
        this(null, 90);
    }

    public C1144b(CompressFormat compressFormat, int i) {
        this.f2939a = compressFormat;
        this.f2940b = i;
    }

    private CompressFormat m5617a(Bitmap bitmap) {
        return this.f2939a != null ? this.f2939a : bitmap.hasAlpha() ? CompressFormat.PNG : CompressFormat.JPEG;
    }

    public String m5618a() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    public boolean m5619a(C1084k<Bitmap> c1084k, OutputStream outputStream) {
        Bitmap bitmap = (Bitmap) c1084k.m5505b();
        long a = C1292d.m6102a();
        CompressFormat a2 = m5617a(bitmap);
        bitmap.compress(a2, this.f2940b, outputStream);
        if (Log.isLoggable("BitmapEncoder", 2)) {
            Log.v("BitmapEncoder", "Compressed with type: " + a2 + " of size " + C1296h.m6108a(bitmap) + " in " + C1292d.m6101a(a));
        }
        return true;
    }
}
