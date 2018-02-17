package com.p045c.p046a.p050d.p059c.p061b;

import android.content.Context;
import android.net.Uri;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1100n;
import com.p045c.p046a.p050d.p059c.C1126c;
import java.io.InputStream;

/* renamed from: com.c.a.d.c.b.e */
public class C1117e extends C1100n<InputStream> implements C1112d<Integer> {

    /* renamed from: com.c.a.d.c.b.e.a */
    public static class C1116a implements C1093m<Integer, InputStream> {
        public C1095l<Integer, InputStream> m5564a(Context context, C1126c c1126c) {
            return new C1117e(context, c1126c.m5581a(Uri.class, InputStream.class));
        }

        public void m5565a() {
        }
    }

    public C1117e(Context context, C1095l<Uri, InputStream> c1095l) {
        super(context, (C1095l) c1095l);
    }
}
