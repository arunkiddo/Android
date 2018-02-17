package com.p045c.p046a.p050d.p052b;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.p045c.p046a.p055j.C1296h;

/* renamed from: com.c.a.d.b.l */
class C1091l {
    private boolean f2891a;
    private final Handler f2892b;

    /* renamed from: com.c.a.d.b.l.a */
    private static class C1090a implements Callback {
        private C1090a() {
        }

        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((C1084k) message.obj).m5507d();
            return true;
        }
    }

    C1091l() {
        this.f2892b = new Handler(Looper.getMainLooper(), new C1090a());
    }

    public void m5524a(C1084k<?> c1084k) {
        C1296h.m6113a();
        if (this.f2891a) {
            this.f2892b.obtainMessage(1, c1084k).sendToTarget();
            return;
        }
        this.f2891a = true;
        c1084k.m5507d();
        this.f2891a = false;
    }
}
