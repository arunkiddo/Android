package com.p045c.p046a.p050d.p052b.p053b;

import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p055j.C1048e;
import com.p045c.p046a.p055j.C1296h;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.c.a.d.b.b.j */
class C1055j {
    private final C1048e<C1081c, String> f2804a;

    C1055j() {
        this.f2804a = new C1048e(1000);
    }

    public String m5458a(C1081c c1081c) {
        String str;
        synchronized (this.f2804a) {
            str = (String) this.f2804a.m5431b((Object) c1081c);
        }
        if (str == null) {
            try {
                MessageDigest instance = MessageDigest.getInstance("SHA-256");
                c1081c.m5501a(instance);
                str = C1296h.m6109a(instance.digest());
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e2) {
                e2.printStackTrace();
            }
            synchronized (this.f2804a) {
                this.f2804a.m5432b(c1081c, str);
            }
        }
        return str;
    }
}
