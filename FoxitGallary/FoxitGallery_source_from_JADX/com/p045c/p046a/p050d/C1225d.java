package com.p045c.p046a.p050d;

import com.p045c.p046a.p050d.p052b.C1084k;
import java.util.Arrays;
import java.util.Collection;

/* renamed from: com.c.a.d.d */
public class C1225d<T> implements C1146g<T> {
    private final Collection<? extends C1146g<T>> f3096a;
    private String f3097b;

    @SafeVarargs
    public C1225d(C1146g<T>... c1146gArr) {
        if (c1146gArr.length < 1) {
            throw new IllegalArgumentException("MultiTransformation must contain at least one Transformation");
        }
        this.f3096a = Arrays.asList(c1146gArr);
    }

    public C1084k<T> m5852a(C1084k<T> c1084k, int i, int i2) {
        C1084k<T> c1084k2 = c1084k;
        for (C1146g a : this.f3096a) {
            C1084k<T> a2 = a.m5626a(c1084k2, i, i2);
            if (!(c1084k2 == null || c1084k2.equals(c1084k) || c1084k2.equals(a2))) {
                c1084k2.m5507d();
            }
            c1084k2 = a2;
        }
        return c1084k2;
    }

    public String m5853a() {
        if (this.f3097b == null) {
            StringBuilder stringBuilder = new StringBuilder();
            for (C1146g a : this.f3096a) {
                stringBuilder.append(a.m5627a());
            }
            this.f3097b = stringBuilder.toString();
        }
        return this.f3097b;
    }
}
