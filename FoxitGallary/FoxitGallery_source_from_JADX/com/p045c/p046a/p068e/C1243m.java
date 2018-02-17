package com.p045c.p046a.p068e;

import com.p045c.p046a.p055j.C1296h;
import com.p045c.p046a.p058h.C1268b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.c.a.e.m */
public class C1243m {
    private final Set<C1268b> f3122a;
    private final List<C1268b> f3123b;
    private boolean f3124c;

    public C1243m() {
        this.f3122a = Collections.newSetFromMap(new WeakHashMap());
        this.f3123b = new ArrayList();
    }

    public void m5888a() {
        this.f3124c = true;
        for (C1268b c1268b : C1296h.m6111a(this.f3122a)) {
            if (c1268b.m5984f()) {
                c1268b.m5983e();
                this.f3123b.add(c1268b);
            }
        }
    }

    public void m5889a(C1268b c1268b) {
        this.f3122a.add(c1268b);
        if (this.f3124c) {
            this.f3123b.add(c1268b);
        } else {
            c1268b.m5981b();
        }
    }

    public void m5890b() {
        this.f3124c = false;
        for (C1268b c1268b : C1296h.m6111a(this.f3122a)) {
            if (!(c1268b.m5985g() || c1268b.m5987i() || c1268b.m5984f())) {
                c1268b.m5981b();
            }
        }
        this.f3123b.clear();
    }

    public void m5891b(C1268b c1268b) {
        this.f3122a.remove(c1268b);
        this.f3123b.remove(c1268b);
    }

    public void m5892c() {
        for (C1268b d : C1296h.m6111a(this.f3122a)) {
            d.m5982d();
        }
        this.f3123b.clear();
    }

    public void m5893d() {
        for (C1268b c1268b : C1296h.m6111a(this.f3122a)) {
            if (!(c1268b.m5985g() || c1268b.m5987i())) {
                c1268b.m5983e();
                if (this.f3124c) {
                    this.f3123b.add(c1268b);
                } else {
                    c1268b.m5981b();
                }
            }
        }
    }
}
