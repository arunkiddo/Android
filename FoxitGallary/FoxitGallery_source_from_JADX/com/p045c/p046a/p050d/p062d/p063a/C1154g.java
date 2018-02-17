package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p062d.C1176a;
import com.p045c.p046a.p050d.p062d.p066c.C1182c;
import com.p045c.p046a.p064g.C1153b;
import java.io.File;

/* renamed from: com.c.a.d.d.a.g */
public class C1154g implements C1153b<ParcelFileDescriptor, Bitmap> {
    private final C1155e<File, Bitmap> f2949a;
    private final C1156h f2950b;
    private final C1144b f2951c;
    private final C1092b<ParcelFileDescriptor> f2952d;

    public C1154g(C1023c c1023c, C1012a c1012a) {
        this.f2949a = new C1182c(new C1172q(c1023c, c1012a));
        this.f2950b = new C1156h(c1023c, c1012a);
        this.f2951c = new C1144b();
        this.f2952d = C1176a.m5721b();
    }

    public C1155e<File, Bitmap> m5654a() {
        return this.f2949a;
    }

    public C1155e<ParcelFileDescriptor, Bitmap> m5655b() {
        return this.f2950b;
    }

    public C1092b<ParcelFileDescriptor> m5656c() {
        return this.f2952d;
    }

    public C1143f<Bitmap> m5657d() {
        return this.f2951c;
    }
}
