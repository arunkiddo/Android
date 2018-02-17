package com.davemorrissey.labs.subscaleview.p075a;

/* renamed from: com.davemorrissey.labs.subscaleview.a.a */
public class C1319a<T> implements C1318b<T> {
    private Class<? extends T> f3386a;

    public C1319a(Class<? extends T> cls) {
        this.f3386a = cls;
    }

    public T m6310a() {
        return this.f3386a.newInstance();
    }
}
