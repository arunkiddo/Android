package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p059c.C1132g;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.a.m */
public class C1167m implements C1155e<C1132g, Bitmap> {
    private final C1155e<InputStream, Bitmap> f2980a;
    private final C1155e<ParcelFileDescriptor, Bitmap> f2981b;

    public C1167m(C1155e<InputStream, Bitmap> c1155e, C1155e<ParcelFileDescriptor, Bitmap> c1155e2) {
        this.f2980a = c1155e;
        this.f2981b = c1155e2;
    }

    public C1084k<Bitmap> m5694a(C1132g c1132g, int i, int i2) {
        C1084k<Bitmap> a;
        InputStream a2 = c1132g.m5596a();
        if (a2 != null) {
            try {
                a = this.f2980a.m5658a(a2, i, i2);
            } catch (Throwable e) {
                if (Log.isLoggable("ImageVideoDecoder", 2)) {
                    Log.v("ImageVideoDecoder", "Failed to load image from stream, trying FileDescriptor", e);
                }
            }
            if (a == null) {
                return a;
            }
            ParcelFileDescriptor b = c1132g.m5597b();
            return b == null ? this.f2981b.m5658a(b, i, i2) : a;
        }
        a = null;
        if (a == null) {
            return a;
        }
        ParcelFileDescriptor b2 = c1132g.m5597b();
        if (b2 == null) {
        }
    }

    public String m5696a() {
        return "ImageVideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
