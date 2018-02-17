package com.p045c.p046a.p050d.p059c.p061b;

import android.content.Context;
import android.net.Uri;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1096b;
import com.p045c.p046a.p050d.p059c.C1126c;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.c.a.d.c.b.c */
public class C1115c extends C1096b<InputStream> implements C1112d<File> {

    /* renamed from: com.c.a.d.c.b.c.a */
    public static class C1114a implements C1093m<File, InputStream> {
        public C1095l<File, InputStream> m5562a(Context context, C1126c c1126c) {
            return new C1115c(c1126c.m5581a(Uri.class, InputStream.class));
        }

        public void m5563a() {
        }
    }

    public C1115c(C1095l<Uri, InputStream> c1095l) {
        super(c1095l);
    }
}
