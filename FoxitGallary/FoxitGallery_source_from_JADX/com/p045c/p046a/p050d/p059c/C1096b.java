package com.p045c.p046a.p050d.p059c;

import android.net.Uri;
import com.p045c.p046a.p050d.p051a.C1000c;
import java.io.File;

/* renamed from: com.c.a.d.c.b */
public class C1096b<T> implements C1095l<File, T> {
    private final C1095l<Uri, T> f2893a;

    public C1096b(C1095l<Uri, T> c1095l) {
        this.f2893a = c1095l;
    }

    public C1000c<T> m5532a(File file, int i, int i2) {
        return this.f2893a.m5531a(Uri.fromFile(file), i, i2);
    }
}
