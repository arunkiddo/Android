package com.p045c.p046a.p058h;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.p045c.p046a.C1298k;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.p051a.C1000c;
import com.p045c.p046a.p050d.p052b.C1056b;
import com.p045c.p046a.p050d.p052b.C1073c;
import com.p045c.p046a.p050d.p052b.C1073c.C1059c;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import com.p045c.p046a.p055j.C1292d;
import com.p045c.p046a.p055j.C1296h;
import com.p045c.p046a.p058h.p069b.C1195j;
import com.p045c.p046a.p058h.p069b.C1269h;
import com.p045c.p046a.p058h.p073a.C1259d;
import com.p045c.p046a.p064g.C1250f;
import com.simplemobiletools.gallery.BuildConfig;
import java.util.Queue;

/* renamed from: com.c.a.h.a */
public final class C1270a<A, T, Z, R> implements C1268b, C1269h, C1078e {
    private static final Queue<C1270a<?, ?, ?, ?>> f3169a;
    private C1084k<?> f3170A;
    private C1059c f3171B;
    private long f3172C;
    private C1256a f3173D;
    private final String f3174b;
    private C1081c f3175c;
    private Drawable f3176d;
    private int f3177e;
    private int f3178f;
    private int f3179g;
    private Context f3180h;
    private C1146g<Z> f3181i;
    private C1250f<A, T, Z, R> f3182j;
    private C1281c f3183k;
    private A f3184l;
    private Class<R> f3185m;
    private boolean f3186n;
    private C1298k f3187o;
    private C1195j<R> f3188p;
    private C1282d<? super A, R> f3189q;
    private float f3190r;
    private C1073c f3191s;
    private C1259d<R> f3192t;
    private int f3193u;
    private int f3194v;
    private C1056b f3195w;
    private Drawable f3196x;
    private Drawable f3197y;
    private boolean f3198z;

    /* renamed from: com.c.a.h.a.a */
    private enum C1256a {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    static {
        f3169a = C1296h.m6112a(0);
    }

    private C1270a() {
        this.f3174b = String.valueOf(hashCode());
    }

    public static <A, T, Z, R> C1270a<A, T, Z, R> m5989a(C1250f<A, T, Z, R> c1250f, A a, C1081c c1081c, Context context, C1298k c1298k, C1195j<R> c1195j, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, C1282d<? super A, R> c1282d, C1281c c1281c, C1073c c1073c, C1146g<Z> c1146g, Class<R> cls, boolean z, C1259d<R> c1259d, int i4, int i5, C1056b c1056b) {
        C1270a<A, T, Z, R> c1270a = (C1270a) f3169a.poll();
        if (c1270a == null) {
            c1270a = new C1270a();
        }
        c1270a.m5994b(c1250f, a, c1081c, context, c1298k, c1195j, f, drawable, i, drawable2, i2, drawable3, i3, c1282d, c1281c, c1073c, c1146g, cls, z, c1259d, i4, i5, c1056b);
        return c1270a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5990a(com.p045c.p046a.p050d.p052b.C1084k<?> r7, R r8) {
        /*
        r6 = this;
        r5 = r6.m6001p();
        r0 = com.p045c.p046a.p058h.C1270a.C1256a.COMPLETE;
        r6.f3173D = r0;
        r6.f3170A = r7;
        r0 = r6.f3189q;
        if (r0 == 0) goto L_0x001d;
    L_0x000e:
        r0 = r6.f3189q;
        r2 = r6.f3184l;
        r3 = r6.f3188p;
        r4 = r6.f3198z;
        r1 = r8;
        r0 = r0.m6048a(r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x002a;
    L_0x001d:
        r0 = r6.f3192t;
        r1 = r6.f3198z;
        r0 = r0.m5963a(r1, r5);
        r1 = r6.f3188p;
        r1.onResourceReady(r8, r0);
    L_0x002a:
        r6.m6002q();
        r0 = "GenericRequest";
        r1 = 2;
        r0 = android.util.Log.isLoggable(r0, r1);
        if (r0 == 0) goto L_0x0070;
    L_0x0036:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Resource ready in ";
        r0 = r0.append(r1);
        r2 = r6.f3172C;
        r2 = com.p045c.p046a.p055j.C1292d.m6101a(r2);
        r0 = r0.append(r2);
        r1 = " size: ";
        r0 = r0.append(r1);
        r1 = r7.m5506c();
        r2 = (double) r1;
        r4 = 4517110426252607488; // 0x3eb0000000000000 float:0.0 double:9.5367431640625E-7;
        r2 = r2 * r4;
        r0 = r0.append(r2);
        r1 = " fromCache: ";
        r0 = r0.append(r1);
        r1 = r6.f3198z;
        r0 = r0.append(r1);
        r0 = r0.toString();
        r6.m5991a(r0);
    L_0x0070:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.h.a.a(com.c.a.d.b.k, java.lang.Object):void");
    }

    private void m5991a(String str) {
        Log.v("GenericRequest", str + " this: " + this.f3174b);
    }

    private static void m5992a(String str, Object obj, String str2) {
        if (obj == null) {
            StringBuilder stringBuilder = new StringBuilder(str);
            stringBuilder.append(" must not be null");
            if (str2 != null) {
                stringBuilder.append(", ");
                stringBuilder.append(str2);
            }
            throw new NullPointerException(stringBuilder.toString());
        }
    }

    private void m5993b(C1084k c1084k) {
        this.f3191s.m5480a(c1084k);
        this.f3170A = null;
    }

    private void m5994b(C1250f<A, T, Z, R> c1250f, A a, C1081c c1081c, Context context, C1298k c1298k, C1195j<R> c1195j, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, C1282d<? super A, R> c1282d, C1281c c1281c, C1073c c1073c, C1146g<Z> c1146g, Class<R> cls, boolean z, C1259d<R> c1259d, int i4, int i5, C1056b c1056b) {
        this.f3182j = c1250f;
        this.f3184l = a;
        this.f3175c = c1081c;
        this.f3176d = drawable3;
        this.f3177e = i3;
        this.f3180h = context.getApplicationContext();
        this.f3187o = c1298k;
        this.f3188p = c1195j;
        this.f3190r = f;
        this.f3196x = drawable;
        this.f3178f = i;
        this.f3197y = drawable2;
        this.f3179g = i2;
        this.f3189q = c1282d;
        this.f3183k = c1281c;
        this.f3191s = c1073c;
        this.f3181i = c1146g;
        this.f3185m = cls;
        this.f3186n = z;
        this.f3192t = c1259d;
        this.f3193u = i4;
        this.f3194v = i5;
        this.f3195w = c1056b;
        this.f3173D = C1256a.PENDING;
        if (a != null) {
            C1270a.m5992a("ModelLoader", c1250f.m5905e(), "try .using(ModelLoader)");
            C1270a.m5992a("Transcoder", c1250f.m5906f(), "try .as*(Class).transcode(ResourceTranscoder)");
            C1270a.m5992a("Transformation", c1146g, "try .transform(UnitTransformation.get())");
            if (c1056b.m5459a()) {
                C1270a.m5992a("SourceEncoder", c1250f.m5652c(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                C1270a.m5992a("SourceDecoder", c1250f.m5651b(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (c1056b.m5459a() || c1056b.m5460b()) {
                C1270a.m5992a("CacheDecoder", c1250f.m5650a(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (c1056b.m5460b()) {
                C1270a.m5992a("Encoder", c1250f.m5653d(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private void m5995b(Exception exception) {
        if (m6000o()) {
            Drawable k = this.f3184l == null ? m5996k() : null;
            if (k == null) {
                k = m5997l();
            }
            if (k == null) {
                k = m5998m();
            }
            this.f3188p.onLoadFailed(exception, k);
        }
    }

    private Drawable m5996k() {
        if (this.f3176d == null && this.f3177e > 0) {
            this.f3176d = this.f3180h.getResources().getDrawable(this.f3177e);
        }
        return this.f3176d;
    }

    private Drawable m5997l() {
        if (this.f3197y == null && this.f3179g > 0) {
            this.f3197y = this.f3180h.getResources().getDrawable(this.f3179g);
        }
        return this.f3197y;
    }

    private Drawable m5998m() {
        if (this.f3196x == null && this.f3178f > 0) {
            this.f3196x = this.f3180h.getResources().getDrawable(this.f3178f);
        }
        return this.f3196x;
    }

    private boolean m5999n() {
        return this.f3183k == null || this.f3183k.m6043a(this);
    }

    private boolean m6000o() {
        return this.f3183k == null || this.f3183k.m6044b(this);
    }

    private boolean m6001p() {
        return this.f3183k == null || !this.f3183k.m6046c();
    }

    private void m6002q() {
        if (this.f3183k != null) {
            this.f3183k.m6045c(this);
        }
    }

    public void m6003a() {
        this.f3182j = null;
        this.f3184l = null;
        this.f3180h = null;
        this.f3188p = null;
        this.f3196x = null;
        this.f3197y = null;
        this.f3176d = null;
        this.f3189q = null;
        this.f3183k = null;
        this.f3181i = null;
        this.f3192t = null;
        this.f3198z = false;
        this.f3171B = null;
        f3169a.offer(this);
    }

    public void m6004a(int i, int i2) {
        if (Log.isLoggable("GenericRequest", 2)) {
            m5991a("Got onSizeReady in " + C1292d.m6101a(this.f3172C));
        }
        if (this.f3173D == C1256a.WAITING_FOR_SIZE) {
            this.f3173D = C1256a.RUNNING;
            int round = Math.round(this.f3190r * ((float) i));
            int round2 = Math.round(this.f3190r * ((float) i2));
            C1000c a = this.f3182j.m5905e().m5531a(this.f3184l, round, round2);
            if (a == null) {
                m6006a(new Exception("Failed to load model: '" + this.f3184l + "'"));
                return;
            }
            C1220c f = this.f3182j.m5906f();
            if (Log.isLoggable("GenericRequest", 2)) {
                m5991a("finished setup for calling load in " + C1292d.m6101a(this.f3172C));
            }
            this.f3198z = true;
            this.f3171B = this.f3191s.m5478a(this.f3175c, round, round2, a, this.f3182j, this.f3181i, f, this.f3187o, this.f3186n, this.f3195w, this);
            this.f3198z = this.f3170A != null;
            if (Log.isLoggable("GenericRequest", 2)) {
                m5991a("finished onSizeReady in " + C1292d.m6101a(this.f3172C));
            }
        }
    }

    public void m6005a(C1084k<?> c1084k) {
        if (c1084k == null) {
            m6006a(new Exception("Expected to receive a Resource<R> with an object of " + this.f3185m + " inside, but instead got null."));
            return;
        }
        Object b = c1084k.m5505b();
        if (b == null || !this.f3185m.isAssignableFrom(b.getClass())) {
            m5993b((C1084k) c1084k);
            m6006a(new Exception("Expected to receive an object of " + this.f3185m + " but instead got " + (b != null ? b.getClass() : BuildConfig.FLAVOR) + "{" + b + "}" + " inside Resource{" + c1084k + "}." + (b != null ? BuildConfig.FLAVOR : " To indicate failure return a null Resource object, rather than a Resource object containing null data.")));
        } else if (m5999n()) {
            m5990a((C1084k) c1084k, b);
        } else {
            m5993b((C1084k) c1084k);
            this.f3173D = C1256a.COMPLETE;
        }
    }

    public void m6006a(Exception exception) {
        if (Log.isLoggable("GenericRequest", 3)) {
            Log.d("GenericRequest", "load failed", exception);
        }
        this.f3173D = C1256a.FAILED;
        if (this.f3189q == null || !this.f3189q.m6047a(exception, this.f3184l, this.f3188p, m6001p())) {
            m5995b(exception);
        }
    }

    public void m6007b() {
        this.f3172C = C1292d.m6102a();
        if (this.f3184l == null) {
            m6006a(null);
            return;
        }
        this.f3173D = C1256a.WAITING_FOR_SIZE;
        if (C1296h.m6114a(this.f3193u, this.f3194v)) {
            m6004a(this.f3193u, this.f3194v);
        } else {
            this.f3188p.getSize(this);
        }
        if (!(m6012g() || m6015j() || !m6000o())) {
            this.f3188p.onLoadStarted(m5998m());
        }
        if (Log.isLoggable("GenericRequest", 2)) {
            m5991a("finished run method in " + C1292d.m6101a(this.f3172C));
        }
    }

    void m6008c() {
        this.f3173D = C1256a.CANCELLED;
        if (this.f3171B != null) {
            this.f3171B.m5463a();
            this.f3171B = null;
        }
    }

    public void m6009d() {
        C1296h.m6113a();
        if (this.f3173D != C1256a.CLEARED) {
            m6008c();
            if (this.f3170A != null) {
                m5993b(this.f3170A);
            }
            if (m6000o()) {
                this.f3188p.onLoadCleared(m5998m());
            }
            this.f3173D = C1256a.CLEARED;
        }
    }

    public void m6010e() {
        m6009d();
        this.f3173D = C1256a.PAUSED;
    }

    public boolean m6011f() {
        return this.f3173D == C1256a.RUNNING || this.f3173D == C1256a.WAITING_FOR_SIZE;
    }

    public boolean m6012g() {
        return this.f3173D == C1256a.COMPLETE;
    }

    public boolean m6013h() {
        return m6012g();
    }

    public boolean m6014i() {
        return this.f3173D == C1256a.CANCELLED || this.f3173D == C1256a.CLEARED;
    }

    public boolean m6015j() {
        return this.f3173D == C1256a.FAILED;
    }
}
