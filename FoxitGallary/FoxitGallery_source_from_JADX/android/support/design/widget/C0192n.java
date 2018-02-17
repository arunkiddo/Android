package android.support.design.widget;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.ref.WeakReference;

/* renamed from: android.support.design.widget.n */
class C0192n {
    private static C0192n f428a;
    private final Object f429b;
    private final Handler f430c;
    private C0191b f431d;
    private C0191b f432e;

    /* renamed from: android.support.design.widget.n.a */
    interface C0154a {
        void m544a();

        void m545a(int i);
    }

    /* renamed from: android.support.design.widget.n.1 */
    class C01901 implements Callback {
        final /* synthetic */ C0192n f425a;

        C01901(C0192n c0192n) {
            this.f425a = c0192n;
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case C1373c.View_android_theme /*0*/:
                    this.f425a.m705b((C0191b) message.obj);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.design.widget.n.b */
    private static class C0191b {
        private final WeakReference<C0154a> f426a;
        private int f427b;

        C0191b(int i, C0154a c0154a) {
            this.f426a = new WeakReference(c0154a);
            this.f427b = i;
        }

        boolean m699a(C0154a c0154a) {
            return c0154a != null && this.f426a.get() == c0154a;
        }
    }

    private C0192n() {
        this.f429b = new Object();
        this.f430c = new Handler(Looper.getMainLooper(), new C01901(this));
    }

    static C0192n m700a() {
        if (f428a == null) {
            f428a = new C0192n();
        }
        return f428a;
    }

    private void m701a(C0191b c0191b) {
        if (c0191b.f427b != -2) {
            int i = 2750;
            if (c0191b.f427b > 0) {
                i = c0191b.f427b;
            } else if (c0191b.f427b == -1) {
                i = 1500;
            }
            this.f430c.removeCallbacksAndMessages(c0191b);
            this.f430c.sendMessageDelayed(Message.obtain(this.f430c, 0, c0191b), (long) i);
        }
    }

    private boolean m703a(C0191b c0191b, int i) {
        C0154a c0154a = (C0154a) c0191b.f426a.get();
        if (c0154a == null) {
            return false;
        }
        this.f430c.removeCallbacksAndMessages(c0191b);
        c0154a.m545a(i);
        return true;
    }

    private void m704b() {
        if (this.f432e != null) {
            this.f431d = this.f432e;
            this.f432e = null;
            C0154a c0154a = (C0154a) this.f431d.f426a.get();
            if (c0154a != null) {
                c0154a.m544a();
            } else {
                this.f431d = null;
            }
        }
    }

    private void m705b(C0191b c0191b) {
        synchronized (this.f429b) {
            if (this.f431d == c0191b || this.f432e == c0191b) {
                m703a(c0191b, 2);
            }
        }
    }

    private boolean m706g(C0154a c0154a) {
        return this.f431d != null && this.f431d.m699a(c0154a);
    }

    private boolean m707h(C0154a c0154a) {
        return this.f432e != null && this.f432e.m699a(c0154a);
    }

    public void m708a(int i, C0154a c0154a) {
        synchronized (this.f429b) {
            if (m706g(c0154a)) {
                this.f431d.f427b = i;
                this.f430c.removeCallbacksAndMessages(this.f431d);
                m701a(this.f431d);
                return;
            }
            if (m707h(c0154a)) {
                this.f432e.f427b = i;
            } else {
                this.f432e = new C0191b(i, c0154a);
            }
            if (this.f431d == null || !m703a(this.f431d, 4)) {
                this.f431d = null;
                m704b();
                return;
            }
        }
    }

    public void m709a(C0154a c0154a) {
        synchronized (this.f429b) {
            if (m706g(c0154a)) {
                this.f431d = null;
                if (this.f432e != null) {
                    m704b();
                }
            }
        }
    }

    public void m710a(C0154a c0154a, int i) {
        synchronized (this.f429b) {
            if (m706g(c0154a)) {
                m703a(this.f431d, i);
            } else if (m707h(c0154a)) {
                m703a(this.f432e, i);
            }
        }
    }

    public void m711b(C0154a c0154a) {
        synchronized (this.f429b) {
            if (m706g(c0154a)) {
                m701a(this.f431d);
            }
        }
    }

    public void m712c(C0154a c0154a) {
        synchronized (this.f429b) {
            if (m706g(c0154a)) {
                this.f430c.removeCallbacksAndMessages(this.f431d);
            }
        }
    }

    public void m713d(C0154a c0154a) {
        synchronized (this.f429b) {
            if (m706g(c0154a)) {
                m701a(this.f431d);
            }
        }
    }

    public boolean m714e(C0154a c0154a) {
        boolean g;
        synchronized (this.f429b) {
            g = m706g(c0154a);
        }
        return g;
    }

    public boolean m715f(C0154a c0154a) {
        boolean z;
        synchronized (this.f429b) {
            z = m706g(c0154a) || m707h(c0154a);
        }
        return z;
    }
}
