package com.p045c.p046a.p050d.p062d.p067d;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.p045c.p046a.C0988e;
import com.p045c.p046a.C1288i;
import com.p045c.p046a.p048b.C0991a;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.C1056b;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p062d.C1176a;
import com.p045c.p046a.p058h.p069b.C1197g;
import com.p045c.p046a.p058h.p073a.C1261c;
import java.security.MessageDigest;
import java.util.UUID;

/* renamed from: com.c.a.d.d.d.f */
class C1201f {
    private final C1188b f3045a;
    private final C0991a f3046b;
    private final Handler f3047c;
    private boolean f3048d;
    private boolean f3049e;
    private C0988e<C0991a, C0991a, Bitmap, Bitmap> f3050f;
    private C1198a f3051g;
    private boolean f3052h;

    /* renamed from: com.c.a.d.d.d.f.b */
    public interface C1188b {
        void m5747b(int i);
    }

    /* renamed from: com.c.a.d.d.d.f.a */
    static class C1198a extends C1197g<Bitmap> {
        private final Handler f3039a;
        private final int f3040b;
        private final long f3041c;
        private Bitmap f3042d;

        public C1198a(Handler handler, int i, long j) {
            this.f3039a = handler;
            this.f3040b = i;
            this.f3041c = j;
        }

        public Bitmap m5769a() {
            return this.f3042d;
        }

        public void m5770a(Bitmap bitmap, C1261c<? super Bitmap> c1261c) {
            this.f3042d = bitmap;
            this.f3039a.sendMessageAtTime(this.f3039a.obtainMessage(1, this), this.f3041c);
        }

        public /* synthetic */ void onResourceReady(Object obj, C1261c c1261c) {
            m5770a((Bitmap) obj, c1261c);
        }
    }

    /* renamed from: com.c.a.d.d.d.f.c */
    private class C1199c implements Callback {
        final /* synthetic */ C1201f f3043a;

        private C1199c(C1201f c1201f) {
            this.f3043a = c1201f;
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                this.f3043a.m5775a((C1198a) message.obj);
                return true;
            }
            if (message.what == 2) {
                C1288i.m6075a((C1198a) message.obj);
            }
            return false;
        }
    }

    /* renamed from: com.c.a.d.d.d.f.d */
    static class C1200d implements C1081c {
        private final UUID f3044a;

        public C1200d() {
            this(UUID.randomUUID());
        }

        C1200d(UUID uuid) {
            this.f3044a = uuid;
        }

        public void m5771a(MessageDigest messageDigest) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public boolean equals(Object obj) {
            return obj instanceof C1200d ? ((C1200d) obj).f3044a.equals(this.f3044a) : false;
        }

        public int hashCode() {
            return this.f3044a.hashCode();
        }
    }

    public C1201f(Context context, C1188b c1188b, C0991a c0991a, int i, int i2) {
        this(c1188b, c0991a, null, C1201f.m5772a(context, c0991a, i, i2, C1288i.m6073a(context).m6079a()));
    }

    C1201f(C1188b c1188b, C0991a c0991a, Handler handler, C0988e<C0991a, C0991a, Bitmap, Bitmap> c0988e) {
        this.f3048d = false;
        this.f3049e = false;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new C1199c());
        }
        this.f3045a = c1188b;
        this.f3046b = c0991a;
        this.f3047c = handler;
        this.f3050f = c0988e;
    }

    private static C0988e<C0991a, C0991a, Bitmap, Bitmap> m5772a(Context context, C0991a c0991a, int i, int i2, C1023c c1023c) {
        C1155e c1204h = new C1204h(c1023c);
        C1095l c1203g = new C1203g();
        return C1288i.m6077b(context).m6138a(c1203g, C0991a.class).m6123a((Object) c0991a).m6120a(Bitmap.class).m5121b(C1176a.m5721b()).m5129d(c1204h).m5124b(true).m5120b(C1056b.NONE).m5119b(i, i2);
    }

    private void m5773e() {
        if (this.f3048d && !this.f3049e) {
            this.f3049e = true;
            this.f3046b.m5173a();
            this.f3050f.m5122b(new C1200d()).m5118a(new C1198a(this.f3047c, this.f3046b.m5177d(), SystemClock.uptimeMillis() + ((long) this.f3046b.m5175b())));
        }
    }

    public void m5774a() {
        if (!this.f3048d) {
            this.f3048d = true;
            this.f3052h = false;
            m5773e();
        }
    }

    void m5775a(C1198a c1198a) {
        if (this.f3052h) {
            this.f3047c.obtainMessage(2, c1198a).sendToTarget();
            return;
        }
        C1198a c1198a2 = this.f3051g;
        this.f3051g = c1198a;
        this.f3045a.m5747b(c1198a.f3040b);
        if (c1198a2 != null) {
            this.f3047c.obtainMessage(2, c1198a2).sendToTarget();
        }
        this.f3049e = false;
        m5773e();
    }

    public void m5776a(C1146g<Bitmap> c1146g) {
        if (c1146g == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.f3050f = this.f3050f.m5125b(c1146g);
    }

    public void m5777b() {
        this.f3048d = false;
    }

    public void m5778c() {
        m5777b();
        if (this.f3051g != null) {
            C1288i.m6075a(this.f3051g);
            this.f3051g = null;
        }
        this.f3052h = true;
    }

    public Bitmap m5779d() {
        return this.f3051g != null ? this.f3051g.m5769a() : null;
    }
}
