package com.p045c.p046a.p050d.p052b.p053b;

import android.util.Log;
import com.p045c.p046a.p047a.C0984a;
import com.p045c.p046a.p047a.C0984a.C0981a;
import com.p045c.p046a.p047a.C0984a.C0983c;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.p052b.p053b.C1037a.C1015b;
import java.io.File;

/* renamed from: com.c.a.d.b.b.e */
public class C1045e implements C1037a {
    private static C1045e f2787a;
    private final C1042c f2788b;
    private final C1055j f2789c;
    private final File f2790d;
    private final int f2791e;
    private C0984a f2792f;

    static {
        f2787a = null;
    }

    protected C1045e(File file, int i) {
        this.f2788b = new C1042c();
        this.f2790d = file;
        this.f2791e = i;
        this.f2789c = new C1055j();
    }

    private synchronized C0984a m5420a() {
        if (this.f2792f == null) {
            this.f2792f = C0984a.m5084a(this.f2790d, 1, 1, (long) this.f2791e);
        }
        return this.f2792f;
    }

    public static synchronized C1037a m5421a(File file, int i) {
        C1037a c1037a;
        synchronized (C1045e.class) {
            if (f2787a == null) {
                f2787a = new C1045e(file, i);
            }
            c1037a = f2787a;
        }
        return c1037a;
    }

    public File m5422a(C1081c c1081c) {
        File file = null;
        try {
            C0983c a = m5420a().m5102a(this.f2789c.m5458a(c1081c));
            if (a != null) {
                file = a.m5081a(0);
            }
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
            }
        }
        return file;
    }

    public void m5423a(C1081c c1081c, C1015b c1015b) {
        C0981a b;
        String a = this.f2789c.m5458a(c1081c);
        this.f2788b.m5416a(c1081c);
        try {
            b = m5420a().m5104b(a);
            if (b != null) {
                if (c1015b.m5313a(b.m5063a(0))) {
                    b.m5064a();
                }
                b.m5066c();
            }
            this.f2788b.m5417b(c1081c);
        } catch (Throwable e) {
            try {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
                this.f2788b.m5417b(c1081c);
            } catch (Throwable th) {
                this.f2788b.m5417b(c1081c);
            }
        } catch (Throwable th2) {
            b.m5066c();
        }
    }

    public void m5424b(C1081c c1081c) {
        try {
            m5420a().m5105c(this.f2789c.m5458a(c1081c));
        } catch (Throwable e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to delete from disk cache", e);
            }
        }
    }
}
