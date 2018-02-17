package com.p045c.p046a.p050d.p059c.p061b;

import android.content.Context;
import android.net.Uri;
import com.p045c.p046a.p050d.p051a.C1000c;
import com.p045c.p046a.p050d.p051a.C1010h;
import com.p045c.p046a.p050d.p051a.C1011i;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1106q;
import com.p045c.p046a.p050d.p059c.C1126c;
import com.p045c.p046a.p050d.p059c.C1127d;
import java.io.InputStream;

/* renamed from: com.c.a.d.c.b.g */
public class C1121g extends C1106q<InputStream> implements C1112d<Uri> {

    /* renamed from: com.c.a.d.c.b.g.a */
    public static class C1120a implements C1093m<Uri, InputStream> {
        public C1095l<Uri, InputStream> m5568a(Context context, C1126c c1126c) {
            return new C1121g(context, c1126c.m5581a(C1127d.class, InputStream.class));
        }

        public void m5569a() {
        }
    }

    public C1121g(Context context, C1095l<C1127d, InputStream> c1095l) {
        super(context, c1095l);
    }

    protected C1000c<InputStream> m5570a(Context context, Uri uri) {
        return new C1011i(context, uri);
    }

    protected C1000c<InputStream> m5571a(Context context, String str) {
        return new C1010h(context.getApplicationContext().getAssets(), str);
    }
}
