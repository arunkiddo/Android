package com.p045c.p046a;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p055j.C1296h;
import com.p045c.p046a.p068e.C1194h;
import com.p045c.p046a.p068e.C1228g;
import com.p045c.p046a.p068e.C1232c.C1231a;
import com.p045c.p046a.p068e.C1233d;
import com.p045c.p046a.p068e.C1236l;
import com.p045c.p046a.p068e.C1243m;
import com.p045c.p046a.p074i.C1285a;
import java.io.File;

/* renamed from: com.c.a.l */
public class C1305l implements C1194h {
    private final Context f3278a;
    private final C1228g f3279b;
    private final C1236l f3280c;
    private final C1243m f3281d;
    private final C1288i f3282e;
    private final C1303c f3283f;
    private C1300a f3284g;

    /* renamed from: com.c.a.l.1 */
    class C12991 implements Runnable {
        final /* synthetic */ C1228g f3267a;
        final /* synthetic */ C1305l f3268b;

        C12991(C1305l c1305l, C1228g c1228g) {
            this.f3268b = c1305l;
            this.f3267a = c1228g;
        }

        public void run() {
            this.f3267a.m5857a(this.f3268b);
        }
    }

    /* renamed from: com.c.a.l.a */
    public interface C1300a {
        <T> void m6119a(C0988e<T, ?, ?, ?> c0988e);
    }

    /* renamed from: com.c.a.l.b */
    public final class C1302b<A, T> {
        final /* synthetic */ C1305l f3273a;
        private final C1095l<A, T> f3274b;
        private final Class<T> f3275c;

        /* renamed from: com.c.a.l.b.a */
        public final class C1301a {
            final /* synthetic */ C1302b f3269a;
            private final A f3270b;
            private final Class<A> f3271c;
            private final boolean f3272d;

            C1301a(C1302b c1302b, A a) {
                this.f3269a = c1302b;
                this.f3272d = true;
                this.f3270b = a;
                this.f3271c = C1305l.m6130b((Object) a);
            }

            public <Z> C1249f<A, T, Z> m6120a(Class<Z> cls) {
                C1249f<A, T, Z> c1249f = (C1249f) this.f3269a.f3273a.f3283f.m6124a(new C1249f(this.f3269a.f3273a.f3278a, this.f3269a.f3273a.f3282e, this.f3271c, this.f3269a.f3274b, this.f3269a.f3275c, cls, this.f3269a.f3273a.f3281d, this.f3269a.f3273a.f3279b, this.f3269a.f3273a.f3283f));
                if (this.f3272d) {
                    c1249f.m5123b(this.f3270b);
                }
                return c1249f;
            }
        }

        C1302b(C1305l c1305l, C1095l<A, T> c1095l, Class<T> cls) {
            this.f3273a = c1305l;
            this.f3274b = c1095l;
            this.f3275c = cls;
        }

        public C1301a m6123a(A a) {
            return new C1301a(this, a);
        }
    }

    /* renamed from: com.c.a.l.c */
    class C1303c {
        final /* synthetic */ C1305l f3276a;

        C1303c(C1305l c1305l) {
            this.f3276a = c1305l;
        }

        public <A, X extends C0988e<A, ?, ?, ?>> X m6124a(X x) {
            if (this.f3276a.f3284g != null) {
                this.f3276a.f3284g.m6119a(x);
            }
            return x;
        }
    }

    /* renamed from: com.c.a.l.d */
    private static class C1304d implements C1231a {
        private final C1243m f3277a;

        public C1304d(C1243m c1243m) {
            this.f3277a = c1243m;
        }

        public void m6125a(boolean z) {
            if (z) {
                this.f3277a.m5893d();
            }
        }
    }

    public C1305l(Context context, C1228g c1228g, C1236l c1236l) {
        this(context, c1228g, c1236l, new C1243m(), new C1233d());
    }

    C1305l(Context context, C1228g c1228g, C1236l c1236l, C1243m c1243m, C1233d c1233d) {
        this.f3278a = context.getApplicationContext();
        this.f3279b = c1228g;
        this.f3280c = c1236l;
        this.f3281d = c1243m;
        this.f3282e = C1288i.m6073a(context);
        this.f3283f = new C1303c(this);
        C1194h a = c1233d.m5864a(context, new C1304d(c1243m));
        if (C1296h.m6117c()) {
            new Handler(Looper.getMainLooper()).post(new C12991(this, c1228g));
        } else {
            c1228g.m5857a(this);
        }
        c1228g.m5857a(a);
    }

    private <T> C1226d<T> m6127a(Class<T> cls) {
        C1095l a = C1288i.m6071a((Class) cls, this.f3278a);
        C1095l b = C1288i.m6076b((Class) cls, this.f3278a);
        if (cls != null && a == null && b == null) {
            throw new IllegalArgumentException("Unknown type " + cls + ". You must provide a Model of a type for" + " which there is a registered ModelLoader, if you are using a custom model, you must first call" + " Glide#register with a ModelLoaderFactory for your custom model class");
        }
        return (C1226d) this.f3283f.m6124a(new C1226d(cls, a, b, this.f3278a, this.f3282e, this.f3281d, this.f3279b, this.f3283f));
    }

    private static <T> Class<T> m6130b(T t) {
        return t != null ? t.getClass() : null;
    }

    public C1226d<File> m6135a(File file) {
        return (C1226d) m6144e().m5242a((Object) file);
    }

    public C1226d<Integer> m6136a(Integer num) {
        return (C1226d) m6145f().m5242a((Object) num);
    }

    public C1226d<String> m6137a(String str) {
        return (C1226d) m6143d().m5242a((Object) str);
    }

    public <A, T> C1302b<A, T> m6138a(C1095l<A, T> c1095l, Class<T> cls) {
        return new C1302b(this, c1095l, cls);
    }

    public void m6139a() {
        this.f3282e.m6091h();
    }

    public void m6140a(int i) {
        this.f3282e.m6082a(i);
    }

    public void m6141b() {
        C1296h.m6113a();
        this.f3281d.m5888a();
    }

    public void m6142c() {
        C1296h.m6113a();
        this.f3281d.m5890b();
    }

    public C1226d<String> m6143d() {
        return m6127a(String.class);
    }

    public C1226d<File> m6144e() {
        return m6127a(File.class);
    }

    public C1226d<Integer> m6145f() {
        return (C1226d) m6127a(Integer.class).m5240a(C1285a.m6066a(this.f3278a));
    }

    public void onDestroy() {
        this.f3281d.m5892c();
    }

    public void onStart() {
        m6142c();
    }

    public void onStop() {
        m6141b();
    }
}
