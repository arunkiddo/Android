package com.p045c.p046a.p050d.p062d.p066c;

import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p059c.C1141o;
import com.p045c.p046a.p050d.p062d.C1177b;
import com.p045c.p046a.p064g.C1153b;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.c.d */
public class C1185d implements C1153b<InputStream, File> {
    private static final C1184a f3008a;
    private final C1155e<File, File> f3009b;
    private final C1092b<InputStream> f3010c;

    /* renamed from: com.c.a.d.d.c.d.a */
    private static class C1184a implements C1155e<InputStream, File> {
        private C1184a() {
        }

        public C1084k<File> m5738a(InputStream inputStream, int i, int i2) {
            throw new Error("You cannot decode a File from an InputStream by default, try either #diskCacheStratey(DiskCacheStrategy.SOURCE) to avoid this call or #decoder(ResourceDecoder) to replace this Decoder");
        }

        public String m5740a() {
            return BuildConfig.FLAVOR;
        }
    }

    static {
        f3008a = new C1184a();
    }

    public C1185d() {
        this.f3009b = new C1178a();
        this.f3010c = new C1141o();
    }

    public C1155e<File, File> m5741a() {
        return this.f3009b;
    }

    public C1155e<InputStream, File> m5742b() {
        return f3008a;
    }

    public C1092b<InputStream> m5743c() {
        return this.f3010c;
    }

    public C1143f<File> m5744d() {
        return C1177b.m5724b();
    }
}
