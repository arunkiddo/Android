package com.p045c.p046a.p058h.p073a;

import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.p045c.p046a.p058h.p073a.C1266f.C1257a;

/* renamed from: com.c.a.h.a.a */
public class C1260a<T extends Drawable> implements C1259d<T> {
    private final C1267g<T> f3158a;
    private final int f3159b;
    private C1262b<T> f3160c;
    private C1262b<T> f3161d;

    /* renamed from: com.c.a.h.a.a.a */
    private static class C1258a implements C1257a {
        private final int f3157a;

        C1258a(int i) {
            this.f3157a = i;
        }

        public Animation m5962a() {
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration((long) this.f3157a);
            return alphaAnimation;
        }
    }

    public C1260a() {
        this(300);
    }

    public C1260a(int i) {
        this(new C1267g(new C1258a(i)), i);
    }

    C1260a(C1267g<T> c1267g, int i) {
        this.f3158a = c1267g;
        this.f3159b = i;
    }

    private C1261c<T> m5964a() {
        if (this.f3160c == null) {
            this.f3160c = new C1262b(this.f3158a.m5979a(false, true), this.f3159b);
        }
        return this.f3160c;
    }

    private C1261c<T> m5965b() {
        if (this.f3161d == null) {
            this.f3161d = new C1262b(this.f3158a.m5979a(false, false), this.f3159b);
        }
        return this.f3161d;
    }

    public C1261c<T> m5966a(boolean z, boolean z2) {
        return z ? C1265e.m5975b() : z2 ? m5964a() : m5965b();
    }
}
