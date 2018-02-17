package android.support.v7.view;

import android.support.v4.p016k.az;
import android.support.v4.p016k.bd;
import android.support.v4.p016k.be;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v7.view.h */
public class C0749h {
    private final ArrayList<az> f1419a;
    private long f1420b;
    private Interpolator f1421c;
    private bd f1422d;
    private boolean f1423e;
    private final be f1424f;

    /* renamed from: android.support.v7.view.h.1 */
    class C07481 extends be {
        final /* synthetic */ C0749h f1416a;
        private boolean f1417b;
        private int f1418c;

        C07481(C0749h c0749h) {
            this.f1416a = c0749h;
            this.f1417b = false;
            this.f1418c = 0;
        }

        void m3262a() {
            this.f1418c = 0;
            this.f1417b = false;
            this.f1416a.m3268c();
        }

        public void m3263a(View view) {
            if (!this.f1417b) {
                this.f1417b = true;
                if (this.f1416a.f1422d != null) {
                    this.f1416a.f1422d.m536a(null);
                }
            }
        }

        public void m3264b(View view) {
            int i = this.f1418c + 1;
            this.f1418c = i;
            if (i == this.f1416a.f1419a.size()) {
                if (this.f1416a.f1422d != null) {
                    this.f1416a.f1422d.m537b(null);
                }
                m3262a();
            }
        }
    }

    public C0749h() {
        this.f1420b = -1;
        this.f1424f = new C07481(this);
        this.f1419a = new ArrayList();
    }

    private void m3268c() {
        this.f1423e = false;
    }

    public C0749h m3269a(long j) {
        if (!this.f1423e) {
            this.f1420b = j;
        }
        return this;
    }

    public C0749h m3270a(az azVar) {
        if (!this.f1423e) {
            this.f1419a.add(azVar);
        }
        return this;
    }

    public C0749h m3271a(az azVar, az azVar2) {
        this.f1419a.add(azVar);
        azVar2.m2163b(azVar.m2156a());
        this.f1419a.add(azVar2);
        return this;
    }

    public C0749h m3272a(bd bdVar) {
        if (!this.f1423e) {
            this.f1422d = bdVar;
        }
        return this;
    }

    public C0749h m3273a(Interpolator interpolator) {
        if (!this.f1423e) {
            this.f1421c = interpolator;
        }
        return this;
    }

    public void m3274a() {
        if (!this.f1423e) {
            Iterator it = this.f1419a.iterator();
            while (it.hasNext()) {
                az azVar = (az) it.next();
                if (this.f1420b >= 0) {
                    azVar.m2158a(this.f1420b);
                }
                if (this.f1421c != null) {
                    azVar.m2161a(this.f1421c);
                }
                if (this.f1422d != null) {
                    azVar.m2159a(this.f1424f);
                }
                azVar.m2166c();
            }
            this.f1423e = true;
        }
    }

    public void m3275b() {
        if (this.f1423e) {
            Iterator it = this.f1419a.iterator();
            while (it.hasNext()) {
                ((az) it.next()).m2164b();
            }
            this.f1423e = false;
        }
    }
}
