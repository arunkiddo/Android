package com.p045c.p046a.p050d.p052b.p053b;

import com.p045c.p046a.p050d.p052b.p053b.C1037a.C1036a;
import java.io.File;

/* renamed from: com.c.a.d.b.b.d */
public class C1044d implements C1036a {
    private final int f2785a;
    private final C1043a f2786b;

    /* renamed from: com.c.a.d.b.b.d.a */
    public interface C1043a {
        File m5418a();
    }

    public C1044d(C1043a c1043a, int i) {
        this.f2785a = i;
        this.f2786b = c1043a;
    }

    public C1037a m5419a() {
        File a = this.f2786b.m5418a();
        return a == null ? null : (a.mkdirs() || (a.exists() && a.isDirectory())) ? C1045e.m5421a(a, this.f2785a) : null;
    }
}
