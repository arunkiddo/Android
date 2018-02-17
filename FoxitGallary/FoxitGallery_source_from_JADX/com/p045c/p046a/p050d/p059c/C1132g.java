package com.p045c.p046a.p050d.p059c;

import android.os.ParcelFileDescriptor;
import java.io.InputStream;

/* renamed from: com.c.a.d.c.g */
public class C1132g {
    private final InputStream f2919a;
    private final ParcelFileDescriptor f2920b;

    public C1132g(InputStream inputStream, ParcelFileDescriptor parcelFileDescriptor) {
        this.f2919a = inputStream;
        this.f2920b = parcelFileDescriptor;
    }

    public InputStream m5596a() {
        return this.f2919a;
    }

    public ParcelFileDescriptor m5597b() {
        return this.f2920b;
    }
}
