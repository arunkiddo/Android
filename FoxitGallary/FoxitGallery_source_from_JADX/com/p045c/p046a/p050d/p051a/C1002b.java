package com.p045c.p046a.p050d.p051a;

import com.p045c.p046a.C1298k;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* renamed from: com.c.a.d.a.b */
public class C1002b implements C1000c<InputStream> {
    private final byte[] f2713a;
    private final String f2714b;

    public C1002b(byte[] bArr, String str) {
        this.f2713a = bArr;
        this.f2714b = str;
    }

    public /* synthetic */ Object m5275a(C1298k c1298k) {
        return m5277b(c1298k);
    }

    public void m5276a() {
    }

    public InputStream m5277b(C1298k c1298k) {
        return new ByteArrayInputStream(this.f2713a);
    }

    public String m5278b() {
        return this.f2714b;
    }

    public void m5279c() {
    }
}
