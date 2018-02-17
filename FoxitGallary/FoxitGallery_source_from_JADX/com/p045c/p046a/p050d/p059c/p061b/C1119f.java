package com.p045c.p046a.p050d.p059c.p061b;

import android.content.Context;
import android.net.Uri;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1103p;
import com.p045c.p046a.p050d.p059c.C1126c;
import java.io.InputStream;

/* renamed from: com.c.a.d.c.b.f */
public class C1119f extends C1103p<InputStream> implements C1112d<String> {

    /* renamed from: com.c.a.d.c.b.f.a */
    public static class C1118a implements C1093m<String, InputStream> {
        public C1095l<String, InputStream> m5566a(Context context, C1126c c1126c) {
            return new C1119f(c1126c.m5581a(Uri.class, InputStream.class));
        }

        public void m5567a() {
        }
    }

    public C1119f(C1095l<Uri, InputStream> c1095l) {
        super(c1095l);
    }
}
