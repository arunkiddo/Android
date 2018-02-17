package com.p045c.p046a.p050d.p052b.p054a;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.p045c.p046a.p055j.C1296h;

/* renamed from: com.c.a.d.b.a.a */
class C1022a implements C1021g {
    private final C1020b f2737a;
    private final C1026e<C1018a, Bitmap> f2738b;

    /* renamed from: com.c.a.d.b.a.a.a */
    static class C1018a implements C1017h {
        private final C1020b f2732a;
        private int f2733b;
        private int f2734c;
        private Config f2735d;

        public C1018a(C1020b c1020b) {
            this.f2732a = c1020b;
        }

        public void m5316a() {
            this.f2732a.m5318a(this);
        }

        public void m5317a(int i, int i2, Config config) {
            this.f2733b = i;
            this.f2734c = i2;
            this.f2735d = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1018a)) {
                return false;
            }
            C1018a c1018a = (C1018a) obj;
            return this.f2733b == c1018a.f2733b && this.f2734c == c1018a.f2734c && this.f2735d == c1018a.f2735d;
        }

        public int hashCode() {
            return (this.f2735d != null ? this.f2735d.hashCode() : 0) + (((this.f2733b * 31) + this.f2734c) * 31);
        }

        public String toString() {
            return C1022a.m5331d(this.f2733b, this.f2734c, this.f2735d);
        }
    }

    /* renamed from: com.c.a.d.b.a.a.b */
    static class C1020b extends C1019b<C1018a> {
        C1020b() {
        }

        protected C1018a m5321a() {
            return new C1018a(this);
        }

        public C1018a m5322a(int i, int i2, Config config) {
            C1018a c1018a = (C1018a) m5320c();
            c1018a.m5317a(i, i2, config);
            return c1018a;
        }

        protected /* synthetic */ C1017h m5323b() {
            return m5321a();
        }
    }

    C1022a() {
        this.f2737a = new C1020b();
        this.f2738b = new C1026e();
    }

    private static String m5331d(int i, int i2, Config config) {
        return "[" + i + "x" + i2 + "], " + config;
    }

    private static String m5332d(Bitmap bitmap) {
        return C1022a.m5331d(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
    }

    public Bitmap m5333a() {
        return (Bitmap) this.f2738b.m5357a();
    }

    public Bitmap m5334a(int i, int i2, Config config) {
        return (Bitmap) this.f2738b.m5358a(this.f2737a.m5322a(i, i2, config));
    }

    public void m5335a(Bitmap bitmap) {
        this.f2738b.m5359a(this.f2737a.m5322a(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig()), bitmap);
    }

    public String m5336b(int i, int i2, Config config) {
        return C1022a.m5331d(i, i2, config);
    }

    public String m5337b(Bitmap bitmap) {
        return C1022a.m5332d(bitmap);
    }

    public int m5338c(Bitmap bitmap) {
        return C1296h.m6108a(bitmap);
    }

    public String toString() {
        return "AttributeStrategy:\n  " + this.f2738b;
    }
}
