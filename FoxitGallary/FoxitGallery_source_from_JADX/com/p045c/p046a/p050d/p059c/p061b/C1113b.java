package com.p045c.p046a.p050d.p059c.p061b;

import android.content.Context;
import com.p045c.p046a.p050d.p051a.C1000c;
import com.p045c.p046a.p050d.p051a.C1002b;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1126c;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.InputStream;

/* renamed from: com.c.a.d.c.b.b */
public class C1113b implements C1112d<byte[]> {
    private final String f2902a;

    /* renamed from: com.c.a.d.c.b.b.a */
    public static class C1111a implements C1093m<byte[], InputStream> {
        public C1095l<byte[], InputStream> m5558a(Context context, C1126c c1126c) {
            return new C1113b();
        }

        public void m5559a() {
        }
    }

    public C1113b() {
        this(BuildConfig.FLAVOR);
    }

    @Deprecated
    public C1113b(String str) {
        this.f2902a = str;
    }

    public C1000c<InputStream> m5561a(byte[] bArr, int i, int i2) {
        return new C1002b(bArr, this.f2902a);
    }
}
