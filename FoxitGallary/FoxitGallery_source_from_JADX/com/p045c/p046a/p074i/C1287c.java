package com.p045c.p046a.p074i;

import com.p045c.p046a.p050d.C1081c;
import java.security.MessageDigest;

/* renamed from: com.c.a.i.c */
public class C1287c implements C1081c {
    private final String f3222a;

    public C1287c(String str) {
        if (str == null) {
            throw new NullPointerException("Signature cannot be null!");
        }
        this.f3222a = str;
    }

    public void m6070a(MessageDigest messageDigest) {
        messageDigest.update(this.f3222a.getBytes("UTF-8"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f3222a.equals(((C1287c) obj).f3222a);
    }

    public int hashCode() {
        return this.f3222a.hashCode();
    }

    public String toString() {
        return "StringSignature{signature='" + this.f3222a + '\'' + '}';
    }
}
