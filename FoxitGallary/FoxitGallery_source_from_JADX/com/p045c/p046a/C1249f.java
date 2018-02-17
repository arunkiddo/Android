package com.p045c.p046a;

import android.content.Context;
import com.p045c.p046a.C1305l.C1303c;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import com.p045c.p046a.p050d.p062d.p071f.C1224e;
import com.p045c.p046a.p064g.C1250f;
import com.p045c.p046a.p064g.C1254e;
import com.p045c.p046a.p068e.C1228g;
import com.p045c.p046a.p068e.C1243m;

/* renamed from: com.c.a.f */
public class C1249f<ModelType, DataType, ResourceType> extends C0988e<ModelType, DataType, ResourceType, ResourceType> {
    private final C1095l<ModelType, DataType> f3132g;
    private final Class<DataType> f3133h;
    private final Class<ResourceType> f3134i;
    private final C1303c f3135j;

    C1249f(Context context, C1288i c1288i, Class<ModelType> cls, C1095l<ModelType, DataType> c1095l, Class<DataType> cls2, Class<ResourceType> cls3, C1243m c1243m, C1228g c1228g, C1303c c1303c) {
        super(context, cls, C1249f.m5904a(c1288i, c1095l, cls2, cls3, C1224e.m5849b()), cls3, c1288i, c1243m, c1228g);
        this.f3132g = c1095l;
        this.f3133h = cls2;
        this.f3134i = cls3;
        this.f3135j = c1303c;
    }

    private static <A, T, Z, R> C1250f<A, T, Z, R> m5904a(C1288i c1288i, C1095l<A, T> c1095l, Class<T> cls, Class<Z> cls2, C1220c<Z, R> c1220c) {
        return new C1254e(c1095l, c1220c, c1288i.m6085b((Class) cls, (Class) cls2));
    }
}
