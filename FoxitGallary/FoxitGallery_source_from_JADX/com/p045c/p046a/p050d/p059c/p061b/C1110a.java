package com.p045c.p046a.p050d.p059c.p061b;

import android.content.Context;
import com.p045c.p046a.p050d.p051a.C1000c;
import com.p045c.p046a.p050d.p051a.C1009f;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1126c;
import com.p045c.p046a.p050d.p059c.C1127d;
import com.p045c.p046a.p050d.p059c.C1140k;
import java.io.InputStream;

/* renamed from: com.c.a.d.c.b.a */
public class C1110a implements C1095l<C1127d, InputStream> {
    private final C1140k<C1127d, C1127d> f2901a;

    /* renamed from: com.c.a.d.c.b.a.a */
    public static class C1109a implements C1093m<C1127d, InputStream> {
        private final C1140k<C1127d, C1127d> f2900a;

        public C1109a() {
            this.f2900a = new C1140k(500);
        }

        public C1095l<C1127d, InputStream> m5554a(Context context, C1126c c1126c) {
            return new C1110a(this.f2900a);
        }

        public void m5555a() {
        }
    }

    public C1110a() {
        this(null);
    }

    public C1110a(C1140k<C1127d, C1127d> c1140k) {
        this.f2901a = c1140k;
    }

    public C1000c<InputStream> m5556a(C1127d c1127d, int i, int i2) {
        if (this.f2901a != null) {
            C1127d c1127d2 = (C1127d) this.f2901a.m5611a(c1127d, 0, 0);
            if (c1127d2 == null) {
                this.f2901a.m5612a(c1127d, 0, 0, c1127d);
            } else {
                c1127d = c1127d2;
            }
        }
        return new C1009f(c1127d);
    }
}
