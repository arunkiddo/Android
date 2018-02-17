package com.p045c.p046a.p050d.p059c;

import android.content.Context;
import com.p045c.p046a.p050d.p051a.C1000c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.c.a.d.c.c */
public class C1126c {
    private static final C1095l f2904c;
    private final Map<Class, Map<Class, C1093m>> f2905a;
    private final Map<Class, Map<Class, C1095l>> f2906b;
    private final Context f2907d;

    /* renamed from: com.c.a.d.c.c.1 */
    static class C11251 implements C1095l {
        C11251() {
        }

        public C1000c m5576a(Object obj, int i, int i2) {
            throw new NoSuchMethodError("This should never be called!");
        }

        public String toString() {
            return "NULL_MODEL_LOADER";
        }
    }

    static {
        f2904c = new C11251();
    }

    public C1126c(Context context) {
        this.f2905a = new HashMap();
        this.f2906b = new HashMap();
        this.f2907d = context.getApplicationContext();
    }

    private <T, Y> void m5577a(Class<T> cls, Class<Y> cls2, C1095l<T, Y> c1095l) {
        Map map = (Map) this.f2906b.get(cls);
        if (map == null) {
            map = new HashMap();
            this.f2906b.put(cls, map);
        }
        map.put(cls2, c1095l);
    }

    private <T, Y> void m5578b(Class<T> cls, Class<Y> cls2) {
        m5577a((Class) cls, (Class) cls2, f2904c);
    }

    private <T, Y> C1095l<T, Y> m5579c(Class<T> cls, Class<Y> cls2) {
        Map map = (Map) this.f2906b.get(cls);
        return map != null ? (C1095l) map.get(cls2) : null;
    }

    private <T, Y> C1093m<T, Y> m5580d(Class<T> cls, Class<Y> cls2) {
        Map map = (Map) this.f2905a.get(cls);
        C1093m<T, Y> c1093m = map != null ? (C1093m) map.get(cls2) : null;
        if (c1093m != null) {
            return c1093m;
        }
        C1093m<T, Y> c1093m2 = c1093m;
        for (Class cls3 : this.f2905a.keySet()) {
            if (cls3.isAssignableFrom(cls)) {
                map = (Map) this.f2905a.get(cls3);
                if (map != null) {
                    c1093m = (C1093m) map.get(cls2);
                    if (c1093m != null) {
                        return c1093m;
                    }
                    c1093m2 = c1093m;
                }
            }
            c1093m = c1093m2;
            c1093m2 = c1093m;
        }
        return c1093m2;
    }

    public synchronized <T, Y> C1095l<T, Y> m5581a(Class<T> cls, Class<Y> cls2) {
        C1095l<T, Y> c;
        c = m5579c(cls, cls2);
        if (c == null) {
            C1093m d = m5580d(cls, cls2);
            if (d != null) {
                C1095l a = d.m5527a(this.f2907d, this);
                m5577a((Class) cls, (Class) cls2, a);
            } else {
                m5578b(cls, cls2);
            }
        } else if (f2904c.equals(c)) {
            c = null;
        }
        return c;
    }

    public synchronized <T, Y> C1093m<T, Y> m5582a(Class<T> cls, Class<Y> cls2, C1093m<T, Y> c1093m) {
        C1093m<T, Y> c1093m2;
        this.f2906b.clear();
        Map map = (Map) this.f2905a.get(cls);
        if (map == null) {
            map = new HashMap();
            this.f2905a.put(cls, map);
        }
        c1093m2 = (C1093m) map.put(cls2, c1093m);
        if (c1093m2 != null) {
            for (Map containsValue : this.f2905a.values()) {
                if (containsValue.containsValue(c1093m2)) {
                    c1093m2 = null;
                    break;
                }
            }
        }
        return c1093m2;
    }
}
