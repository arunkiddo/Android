package com.p045c.p046a.p058h.p073a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import com.p045c.p046a.p058h.p073a.C1261c.C1263a;

/* renamed from: com.c.a.h.a.b */
public class C1262b<T extends Drawable> implements C1261c<T> {
    private final C1261c<T> f3162a;
    private final int f3163b;

    public C1262b(C1261c<T> c1261c, int i) {
        this.f3162a = c1261c;
        this.f3163b = i;
    }

    public boolean m5968a(T t, C1263a c1263a) {
        if (c1263a.m5972b() != null) {
            Drawable transitionDrawable = new TransitionDrawable(new Drawable[]{c1263a.m5972b(), t});
            transitionDrawable.setCrossFadeEnabled(true);
            transitionDrawable.startTransition(this.f3163b);
            c1263a.m5971a(transitionDrawable);
            return true;
        }
        this.f3162a.m5967a(t, c1263a);
        return false;
    }
}
