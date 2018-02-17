package com.p045c.p046a.p050d.p062d.p066c;

import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.c.c */
public class C1182c<T> implements C1155e<File, T> {
    private static final C1181a f3005a;
    private C1155e<InputStream, T> f3006b;
    private final C1181a f3007c;

    /* renamed from: com.c.a.d.d.c.c.a */
    static class C1181a {
        C1181a() {
        }

        public InputStream m5734a(File file) {
            return new FileInputStream(file);
        }
    }

    static {
        f3005a = new C1181a();
    }

    public C1182c(C1155e<InputStream, T> c1155e) {
        this(c1155e, f3005a);
    }

    C1182c(C1155e<InputStream, T> c1155e, C1181a c1181a) {
        this.f3006b = c1155e;
        this.f3007c = c1181a;
    }

    public C1084k<T> m5735a(File file, int i, int i2) {
        InputStream inputStream = null;
        try {
            inputStream = this.f3007c.m5734a(file);
            C1084k<T> a = this.f3006b.m5658a(inputStream, i, i2);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                }
            }
            return a;
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    public String m5737a() {
        return BuildConfig.FLAVOR;
    }
}
