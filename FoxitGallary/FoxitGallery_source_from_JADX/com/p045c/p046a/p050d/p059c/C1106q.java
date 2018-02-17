package com.p045c.p046a.p050d.p059c;

import android.content.Context;
import android.net.Uri;
import com.p045c.p046a.p050d.p051a.C1000c;

/* renamed from: com.c.a.d.c.q */
public abstract class C1106q<T> implements C1095l<Uri, T> {
    private final Context f2897a;
    private final C1095l<C1127d, T> f2898b;

    public C1106q(Context context, C1095l<C1127d, T> c1095l) {
        this.f2897a = context;
        this.f2898b = c1095l;
    }

    private static boolean m5545a(String str) {
        return "file".equals(str) || "content".equals(str) || "android.resource".equals(str);
    }

    protected abstract C1000c<T> m5546a(Context context, Uri uri);

    protected abstract C1000c<T> m5547a(Context context, String str);

    public final C1000c<T> m5548a(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (!C1106q.m5545a(scheme)) {
            return this.f2898b != null ? ("http".equals(scheme) || "https".equals(scheme)) ? this.f2898b.m5531a(new C1127d(uri.toString()), i, i2) : null : null;
        } else {
            if (!C1108a.m5552a(uri)) {
                return m5546a(this.f2897a, uri);
            }
            return m5547a(this.f2897a, C1108a.m5553b(uri));
        }
    }
}
