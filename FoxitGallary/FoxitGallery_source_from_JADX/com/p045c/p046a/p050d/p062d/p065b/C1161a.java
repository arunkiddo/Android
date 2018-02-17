package com.p045c.p046a.p050d.p062d.p065b;

import android.graphics.drawable.Drawable;
import com.p045c.p046a.p050d.p052b.C1084k;

/* renamed from: com.c.a.d.d.b.a */
public abstract class C1161a<T extends Drawable> implements C1084k<T> {
    protected final T f2966a;

    public C1161a(T t) {
        if (t == null) {
            throw new NullPointerException("Drawable must not be null!");
        }
        this.f2966a = t;
    }

    public final T m5673a() {
        return this.f2966a.getConstantState().newDrawable();
    }

    public /* synthetic */ Object m5674b() {
        return m5673a();
    }
}
