package com.p045c.p046a.p058h.p073a;

import android.view.View;
import android.view.animation.Animation;
import com.p045c.p046a.p058h.p073a.C1261c.C1263a;

/* renamed from: com.c.a.h.a.f */
public class C1266f<R> implements C1261c<R> {
    private final C1257a f3166a;

    /* renamed from: com.c.a.h.a.f.a */
    interface C1257a {
        Animation m5961a();
    }

    C1266f(C1257a c1257a) {
        this.f3166a = c1257a;
    }

    public boolean m5978a(R r, C1263a c1263a) {
        View a = c1263a.m5970a();
        if (a != null) {
            a.clearAnimation();
            a.startAnimation(this.f3166a.m5961a());
        }
        return false;
    }
}
