package com.p045c.p046a.p068e;

import com.p045c.p046a.p055j.C1296h;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* renamed from: com.c.a.e.a */
class C1229a implements C1228g {
    private final Set<C1194h> f3102a;
    private boolean f3103b;
    private boolean f3104c;

    C1229a() {
        this.f3102a = Collections.newSetFromMap(new WeakHashMap());
    }

    void m5858a() {
        this.f3103b = true;
        for (C1194h onStart : C1296h.m6111a(this.f3102a)) {
            onStart.onStart();
        }
    }

    public void m5859a(C1194h c1194h) {
        this.f3102a.add(c1194h);
        if (this.f3104c) {
            c1194h.onDestroy();
        } else if (this.f3103b) {
            c1194h.onStart();
        } else {
            c1194h.onStop();
        }
    }

    void m5860b() {
        this.f3103b = false;
        for (C1194h onStop : C1296h.m6111a(this.f3102a)) {
            onStop.onStop();
        }
    }

    void m5861c() {
        this.f3104c = true;
        for (C1194h onDestroy : C1296h.m6111a(this.f3102a)) {
            onDestroy.onDestroy();
        }
    }
}
