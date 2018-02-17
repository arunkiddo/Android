package com.p045c.p046a;

import android.content.Context;
import android.os.Build.VERSION;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.p052b.C1073c;
import com.p045c.p046a.p050d.p052b.p053b.C1037a.C1036a;
import com.p045c.p046a.p050d.p052b.p053b.C1047f;
import com.p045c.p046a.p050d.p052b.p053b.C1049h;
import com.p045c.p046a.p050d.p052b.p053b.C1050g;
import com.p045c.p046a.p050d.p052b.p053b.C1054i;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p052b.p054a.C1024d;
import com.p045c.p046a.p050d.p052b.p054a.C1030f;
import com.p045c.p046a.p050d.p052b.p056c.C1069a;
import java.util.concurrent.ExecutorService;

/* renamed from: com.c.a.j */
public class C1297j {
    private final Context f3253a;
    private C1073c f3254b;
    private C1023c f3255c;
    private C1049h f3256d;
    private ExecutorService f3257e;
    private ExecutorService f3258f;
    private C1012a f3259g;
    private C1036a f3260h;

    public C1297j(Context context) {
        this.f3253a = context.getApplicationContext();
    }

    C1288i m6118a() {
        if (this.f3257e == null) {
            this.f3257e = new C1069a(Math.max(1, Runtime.getRuntime().availableProcessors()));
        }
        if (this.f3258f == null) {
            this.f3258f = new C1069a(1);
        }
        C1054i c1054i = new C1054i(this.f3253a);
        if (this.f3255c == null) {
            if (VERSION.SDK_INT >= 11) {
                this.f3255c = new C1030f(c1054i.m5457b());
            } else {
                this.f3255c = new C1024d();
            }
        }
        if (this.f3256d == null) {
            this.f3256d = new C1050g(c1054i.m5456a());
        }
        if (this.f3260h == null) {
            this.f3260h = new C1047f(this.f3253a);
        }
        if (this.f3254b == null) {
            this.f3254b = new C1073c(this.f3256d, this.f3260h, this.f3258f, this.f3257e);
        }
        if (this.f3259g == null) {
            this.f3259g = C1012a.f2727d;
        }
        return new C1288i(this.f3254b, this.f3256d, this.f3255c, this.f3253a, this.f3259g);
    }
}
