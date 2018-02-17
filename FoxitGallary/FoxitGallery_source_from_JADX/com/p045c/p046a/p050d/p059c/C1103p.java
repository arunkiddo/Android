package com.p045c.p046a.p050d.p059c;

import android.net.Uri;
import android.text.TextUtils;
import com.p045c.p046a.p050d.p051a.C1000c;
import java.io.File;

/* renamed from: com.c.a.d.c.p */
public class C1103p<T> implements C1095l<String, T> {
    private final C1095l<Uri, T> f2896a;

    public C1103p(C1095l<Uri, T> c1095l) {
        this.f2896a = c1095l;
    }

    private static Uri m5540a(String str) {
        return Uri.fromFile(new File(str));
    }

    public C1000c<T> m5542a(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Object a;
        if (str.startsWith("/")) {
            a = C1103p.m5540a(str);
        } else {
            a = Uri.parse(str);
            if (a.getScheme() == null) {
                a = C1103p.m5540a(str);
            }
        }
        return this.f2896a.m5531a(a, i, i2);
    }
}
