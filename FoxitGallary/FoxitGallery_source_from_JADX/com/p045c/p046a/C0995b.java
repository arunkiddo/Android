package com.p045c.p046a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.C1305l.C1303c;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1131f;
import com.p045c.p046a.p050d.p059c.C1132g;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import com.p045c.p046a.p064g.C1254e;
import java.io.InputStream;

/* renamed from: com.c.a.b */
public class C0995b<ModelType> extends C0989a<ModelType, Bitmap> {
    private final C1095l<ModelType, InputStream> f2653g;
    private final C1095l<ModelType, ParcelFileDescriptor> f2654h;
    private final C1288i f2655i;
    private final C1303c f2656j;

    C0995b(C0988e<ModelType, ?, ?, ?> c0988e, C1095l<ModelType, InputStream> c1095l, C1095l<ModelType, ParcelFileDescriptor> c1095l2, C1303c c1303c) {
        super(C0995b.m5200a(c0988e.f2579c, c1095l, c1095l2, Bitmap.class, null), Bitmap.class, c0988e);
        this.f2653g = c1095l;
        this.f2654h = c1095l2;
        this.f2655i = c0988e.f2579c;
        this.f2656j = c1303c;
    }

    private static <A, R> C1254e<A, C1132g, Bitmap, R> m5200a(C1288i c1288i, C1095l<A, InputStream> c1095l, C1095l<A, ParcelFileDescriptor> c1095l2, Class<R> cls, C1220c<Bitmap, R> c1220c) {
        if (c1095l == null && c1095l2 == null) {
            return null;
        }
        C1220c a;
        if (c1220c == null) {
            a = c1288i.m6080a(Bitmap.class, (Class) cls);
        }
        return new C1254e(new C1131f(c1095l, c1095l2), a, c1288i.m6085b(C1132g.class, Bitmap.class));
    }
}
