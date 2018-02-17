package com.p045c.p046a.p050d.p062d.p063a;

import android.graphics.Bitmap;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p059c.C1141o;
import com.p045c.p046a.p050d.p062d.p066c.C1182c;
import com.p045c.p046a.p064g.C1153b;
import java.io.File;
import java.io.InputStream;

/* renamed from: com.c.a.d.d.a.p */
public class C1171p implements C1153b<InputStream, Bitmap> {
    private final C1172q f2991a;
    private final C1144b f2992b;
    private final C1141o f2993c;
    private final C1182c<Bitmap> f2994d;

    public C1171p(C1023c c1023c, C1012a c1012a) {
        this.f2993c = new C1141o();
        this.f2991a = new C1172q(c1023c, c1012a);
        this.f2992b = new C1144b();
        this.f2994d = new C1182c(this.f2991a);
    }

    public C1155e<File, Bitmap> m5704a() {
        return this.f2994d;
    }

    public C1155e<InputStream, Bitmap> m5705b() {
        return this.f2991a;
    }

    public C1092b<InputStream> m5706c() {
        return this.f2993c;
    }

    public C1143f<Bitmap> m5707d() {
        return this.f2992b;
    }
}
