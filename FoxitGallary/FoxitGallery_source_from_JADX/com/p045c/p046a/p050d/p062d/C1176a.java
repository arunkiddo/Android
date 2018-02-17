package com.p045c.p046a.p050d.p062d;

import com.p045c.p046a.p050d.C1092b;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.OutputStream;

/* renamed from: com.c.a.d.d.a */
public class C1176a<T> implements C1092b<T> {
    private static final C1176a<?> f3002a;

    static {
        f3002a = new C1176a();
    }

    public static <T> C1092b<T> m5721b() {
        return f3002a;
    }

    public String m5722a() {
        return BuildConfig.FLAVOR;
    }

    public boolean m5723a(T t, OutputStream outputStream) {
        return false;
    }
}
