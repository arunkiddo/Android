package com.p045c.p046a.p050d.p062d.p067d;

import android.content.Context;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p059c.C1141o;
import com.p045c.p046a.p050d.p062d.p066c.C1182c;
import com.p045c.p046a.p064g.C1153b;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.d.c */
public class C1190c implements C1153b<InputStream, C1189b> {
    private final C1207i f3033a;
    private final C1209j f3034b;
    private final C1141o f3035c;
    private final C1182c<C1189b> f3036d;

    public C1190c(Context context, C1023c c1023c) {
        this.f3033a = new C1207i(context, c1023c);
        this.f3036d = new C1182c(this.f3033a);
        this.f3034b = new C1209j(c1023c);
        this.f3035c = new C1141o();
    }

    public C1155e<File, C1189b> m5760a() {
        return this.f3036d;
    }

    public C1155e<InputStream, C1189b> m5761b() {
        return this.f3033a;
    }

    public C1092b<InputStream> m5762c() {
        return this.f3035c;
    }

    public C1143f<C1189b> m5763d() {
        return this.f3034b;
    }
}
