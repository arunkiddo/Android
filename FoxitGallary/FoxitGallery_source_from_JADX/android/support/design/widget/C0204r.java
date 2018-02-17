package android.support.design.widget;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.support.design.widget.C0202q.C0201c;
import android.support.design.widget.C0202q.C0201c.C0197b;
import android.support.design.widget.C0202q.C0201c.C0200a;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

/* renamed from: android.support.design.widget.r */
class C0204r extends C0201c {
    private static final Handler f446a;
    private long f447b;
    private boolean f448c;
    private final int[] f449d;
    private final float[] f450e;
    private long f451f;
    private Interpolator f452g;
    private C0200a f453h;
    private C0197b f454i;
    private float f455j;
    private final Runnable f456k;

    /* renamed from: android.support.design.widget.r.1 */
    class C02031 implements Runnable {
        final /* synthetic */ C0204r f445a;

        C02031(C0204r c0204r) {
            this.f445a = c0204r;
        }

        public void run() {
            this.f445a.m754g();
        }
    }

    static {
        f446a = new Handler(Looper.getMainLooper());
    }

    C0204r() {
        this.f449d = new int[2];
        this.f450e = new float[2];
        this.f451f = 200;
        this.f456k = new C02031(this);
    }

    private void m754g() {
        if (this.f448c) {
            float a = C0187k.m682a(((float) (SystemClock.uptimeMillis() - this.f447b)) / ((float) this.f451f), 0.0f, 1.0f);
            if (this.f452g != null) {
                a = this.f452g.getInterpolation(a);
            }
            this.f455j = a;
            if (this.f454i != null) {
                this.f454i.m727a();
            }
            if (SystemClock.uptimeMillis() >= this.f447b + this.f451f) {
                this.f448c = false;
                if (this.f453h != null) {
                    this.f453h.m731b();
                }
            }
        }
        if (this.f448c) {
            f446a.postDelayed(this.f456k, 10);
        }
    }

    public void m755a() {
        if (!this.f448c) {
            if (this.f452g == null) {
                this.f452g = new AccelerateDecelerateInterpolator();
            }
            this.f447b = SystemClock.uptimeMillis();
            this.f448c = true;
            this.f455j = 0.0f;
            if (this.f453h != null) {
                this.f453h.m730a();
            }
            f446a.postDelayed(this.f456k, 10);
        }
    }

    public void m756a(float f, float f2) {
        this.f450e[0] = f;
        this.f450e[1] = f2;
    }

    public void m757a(int i, int i2) {
        this.f449d[0] = i;
        this.f449d[1] = i2;
    }

    public void m758a(long j) {
        this.f451f = j;
    }

    public void m759a(C0197b c0197b) {
        this.f454i = c0197b;
    }

    public void m760a(Interpolator interpolator) {
        this.f452g = interpolator;
    }

    public boolean m761b() {
        return this.f448c;
    }

    public int m762c() {
        return C0170a.m624a(this.f449d[0], this.f449d[1], m765f());
    }

    public float m763d() {
        return C0170a.m623a(this.f450e[0], this.f450e[1], m765f());
    }

    public void m764e() {
        this.f448c = false;
        f446a.removeCallbacks(this.f456k);
        if (this.f453h != null) {
            this.f453h.m732c();
            this.f453h.m731b();
        }
    }

    public float m765f() {
        return this.f455j;
    }
}
