package com.p045c.p046a.p050d.p052b.p053b;

import android.annotation.SuppressLint;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p053b.C1049h.C1051a;
import com.p045c.p046a.p055j.C1048e;

/* renamed from: com.c.a.d.b.b.g */
public class C1050g extends C1048e<C1081c, C1084k<?>> implements C1049h {
    private C1051a f2799a;

    public C1050g(int i) {
        super(i);
    }

    protected int m5440a(C1084k<?> c1084k) {
        return c1084k.m5506c();
    }

    public /* synthetic */ C1084k m5442a(C1081c c1081c) {
        return (C1084k) super.m5434c(c1081c);
    }

    @SuppressLint({"InlinedApi"})
    public void m5443a(int i) {
        if (i >= 60) {
            m5428a();
        } else if (i >= 40) {
            m5433b(m5430b() / 2);
        }
    }

    public void m5444a(C1051a c1051a) {
        this.f2799a = c1051a;
    }

    protected void m5445a(C1081c c1081c, C1084k<?> c1084k) {
        if (this.f2799a != null) {
            this.f2799a.m5448b(c1084k);
        }
    }

    public /* bridge */ /* synthetic */ C1084k m5447b(C1081c c1081c, C1084k c1084k) {
        return (C1084k) super.m5432b(c1081c, c1084k);
    }
}
