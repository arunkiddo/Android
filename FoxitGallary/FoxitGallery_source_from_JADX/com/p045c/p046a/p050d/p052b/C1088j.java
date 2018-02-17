package com.p045c.p046a.p050d.p052b;

import com.p045c.p046a.p050d.C1081c;
import java.security.MessageDigest;

/* renamed from: com.c.a.d.b.j */
class C1088j implements C1081c {
    private final String f2889a;
    private final C1081c f2890b;

    public C1088j(String str, C1081c c1081c) {
        this.f2889a = str;
        this.f2890b = c1081c;
    }

    public void m5523a(MessageDigest messageDigest) {
        messageDigest.update(this.f2889a.getBytes("UTF-8"));
        this.f2890b.m5501a(messageDigest);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1088j c1088j = (C1088j) obj;
        return !this.f2889a.equals(c1088j.f2889a) ? false : this.f2890b.equals(c1088j.f2890b);
    }

    public int hashCode() {
        return (this.f2889a.hashCode() * 31) + this.f2890b.hashCode();
    }
}
