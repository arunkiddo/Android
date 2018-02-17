package android.support.v4.p028h;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.h.a */
public abstract class C0361a {
    private final C0361a f699a;

    C0361a(C0361a c0361a) {
        this.f699a = c0361a;
    }

    public static C0361a m1335a(Context context, Uri uri) {
        return VERSION.SDK_INT >= 21 ? new C0364d(null, context, C0363c.m1357a(uri)) : null;
    }

    public abstract Uri m1336a();

    public abstract C0361a m1337a(String str);

    public abstract C0361a m1338a(String str, String str2);

    public C0361a m1339b(String str) {
        for (C0361a c0361a : m1345f()) {
            if (str.equals(c0361a.m1340b())) {
                return c0361a;
            }
        }
        return null;
    }

    public abstract String m1340b();

    public abstract boolean m1341c();

    public abstract boolean m1342c(String str);

    public abstract boolean m1343d();

    public abstract boolean m1344e();

    public abstract C0361a[] m1345f();
}
