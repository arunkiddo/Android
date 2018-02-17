package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;

/* renamed from: com.c.a.d.d.a.s */
public class C1175s implements C1142a<ParcelFileDescriptor> {
    private static final C1174a f2999a;
    private C1174a f3000b;
    private int f3001c;

    /* renamed from: com.c.a.d.d.a.s.a */
    static class C1174a {
        C1174a() {
        }

        public MediaMetadataRetriever m5718a() {
            return new MediaMetadataRetriever();
        }
    }

    static {
        f2999a = new C1174a();
    }

    public C1175s() {
        this(f2999a, -1);
    }

    C1175s(C1174a c1174a, int i) {
        this.f3000b = c1174a;
        this.f3001c = i;
    }

    public Bitmap m5719a(ParcelFileDescriptor parcelFileDescriptor, C1023c c1023c, int i, int i2, C1012a c1012a) {
        MediaMetadataRetriever a = this.f3000b.m5718a();
        a.setDataSource(parcelFileDescriptor.getFileDescriptor());
        Bitmap frameAtTime = this.f3001c >= 0 ? a.getFrameAtTime((long) this.f3001c) : a.getFrameAtTime();
        a.release();
        parcelFileDescriptor.close();
        return frameAtTime;
    }

    public String m5720a() {
        return "VideoBitmapDecoder.com.bumptech.glide.load.resource.bitmap";
    }
}
