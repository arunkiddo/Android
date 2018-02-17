package android.support.v4.p028h;

import android.content.Context;
import android.net.Uri;

/* renamed from: android.support.v4.h.d */
class C0364d extends C0361a {
    private Context f700a;
    private Uri f701b;

    C0364d(C0361a c0361a, Context context, Uri uri) {
        super(c0361a);
        this.f700a = context;
        this.f701b = uri;
    }

    public Uri m1361a() {
        return this.f701b;
    }

    public C0361a m1362a(String str) {
        Uri a = C0363c.m1355a(this.f700a, this.f701b, str);
        return a != null ? new C0364d(this, this.f700a, a) : null;
    }

    public C0361a m1363a(String str, String str2) {
        Uri a = C0363c.m1356a(this.f700a, this.f701b, str, str2);
        return a != null ? new C0364d(this, this.f700a, a) : null;
    }

    public String m1364b() {
        return C0362b.m1348a(this.f700a, this.f701b);
    }

    public boolean m1365c() {
        return C0362b.m1351b(this.f700a, this.f701b);
    }

    public boolean m1366c(String str) {
        Uri b = C0363c.m1360b(this.f700a, this.f701b, str);
        if (b == null) {
            return false;
        }
        this.f701b = b;
        return true;
    }

    public boolean m1367d() {
        return C0362b.m1352c(this.f700a, this.f701b);
    }

    public boolean m1368e() {
        return C0362b.m1353d(this.f700a, this.f701b);
    }

    public C0361a[] m1369f() {
        Uri[] a = C0363c.m1359a(this.f700a, this.f701b);
        C0361a[] c0361aArr = new C0361a[a.length];
        for (int i = 0; i < a.length; i++) {
            c0361aArr[i] = new C0364d(this, this.f700a, a[i]);
        }
        return c0361aArr;
    }
}
