package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;

/* renamed from: com.c.a.d.d.a.h */
public class C1156h implements C1155e<ParcelFileDescriptor, Bitmap> {
    private final C1175s f2953a;
    private final C1023c f2954b;
    private C1012a f2955c;

    public C1156h(C1023c c1023c, C1012a c1012a) {
        this(new C1175s(), c1023c, c1012a);
    }

    public C1156h(C1175s c1175s, C1023c c1023c, C1012a c1012a) {
        this.f2953a = c1175s;
        this.f2954b = c1023c;
        this.f2955c = c1012a;
    }

    public C1084k<Bitmap> m5660a(ParcelFileDescriptor parcelFileDescriptor, int i, int i2) {
        return C1145c.m5621a(this.f2953a.m5719a(parcelFileDescriptor, this.f2954b, i, i2, this.f2955c), this.f2954b);
    }

    public String m5662a() {
        return "FileDescriptorBitmapDecoder.com.bumptech.glide.load.data.bitmap";
    }
}
