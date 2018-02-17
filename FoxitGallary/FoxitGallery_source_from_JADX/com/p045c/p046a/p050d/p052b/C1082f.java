package com.p045c.p046a.p050d.p052b;

import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import com.simplemobiletools.gallery.BuildConfig;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* renamed from: com.c.a.d.b.f */
class C1082f implements C1081c {
    private final String f2862a;
    private final int f2863b;
    private final int f2864c;
    private final C1155e f2865d;
    private final C1155e f2866e;
    private final C1146g f2867f;
    private final C1143f f2868g;
    private final C1220c f2869h;
    private final C1092b f2870i;
    private final C1081c f2871j;
    private String f2872k;
    private int f2873l;
    private C1081c f2874m;

    public C1082f(String str, C1081c c1081c, int i, int i2, C1155e c1155e, C1155e c1155e2, C1146g c1146g, C1143f c1143f, C1220c c1220c, C1092b c1092b) {
        this.f2862a = str;
        this.f2871j = c1081c;
        this.f2863b = i;
        this.f2864c = i2;
        this.f2865d = c1155e;
        this.f2866e = c1155e2;
        this.f2867f = c1146g;
        this.f2868g = c1143f;
        this.f2869h = c1220c;
        this.f2870i = c1092b;
    }

    public C1081c m5502a() {
        if (this.f2874m == null) {
            this.f2874m = new C1088j(this.f2862a, this.f2871j);
        }
        return this.f2874m;
    }

    public void m5503a(MessageDigest messageDigest) {
        byte[] array = ByteBuffer.allocate(8).putInt(this.f2863b).putInt(this.f2864c).array();
        this.f2871j.m5501a(messageDigest);
        messageDigest.update(this.f2862a.getBytes("UTF-8"));
        messageDigest.update(array);
        messageDigest.update((this.f2865d != null ? this.f2865d.m5659a() : BuildConfig.FLAVOR).getBytes("UTF-8"));
        messageDigest.update((this.f2866e != null ? this.f2866e.m5659a() : BuildConfig.FLAVOR).getBytes("UTF-8"));
        messageDigest.update((this.f2867f != null ? this.f2867f.m5627a() : BuildConfig.FLAVOR).getBytes("UTF-8"));
        messageDigest.update((this.f2868g != null ? this.f2868g.m5525a() : BuildConfig.FLAVOR).getBytes("UTF-8"));
        messageDigest.update((this.f2870i != null ? this.f2870i.m5525a() : BuildConfig.FLAVOR).getBytes("UTF-8"));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1082f c1082f = (C1082f) obj;
        if (!this.f2862a.equals(c1082f.f2862a) || !this.f2871j.equals(c1082f.f2871j) || this.f2864c != c1082f.f2864c || this.f2863b != c1082f.f2863b) {
            return false;
        }
        if (((this.f2867f == null ? 1 : 0) ^ (c1082f.f2867f == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2867f != null && !this.f2867f.m5627a().equals(c1082f.f2867f.m5627a())) {
            return false;
        }
        if (((this.f2866e == null ? 1 : 0) ^ (c1082f.f2866e == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2866e != null && !this.f2866e.m5659a().equals(c1082f.f2866e.m5659a())) {
            return false;
        }
        if (((this.f2865d == null ? 1 : 0) ^ (c1082f.f2865d == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2865d != null && !this.f2865d.m5659a().equals(c1082f.f2865d.m5659a())) {
            return false;
        }
        if (((this.f2868g == null ? 1 : 0) ^ (c1082f.f2868g == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2868g != null && !this.f2868g.m5525a().equals(c1082f.f2868g.m5525a())) {
            return false;
        }
        if (((this.f2869h == null ? 1 : 0) ^ (c1082f.f2869h == null ? 1 : 0)) != 0) {
            return false;
        }
        if (this.f2869h != null && !this.f2869h.m5842a().equals(c1082f.f2869h.m5842a())) {
            return false;
        }
        return ((this.f2870i == null ? 1 : 0) ^ (c1082f.f2870i == null ? 1 : 0)) == 0 ? this.f2870i == null || this.f2870i.m5525a().equals(c1082f.f2870i.m5525a()) : false;
    }

    public int hashCode() {
        int i = 0;
        if (this.f2873l == 0) {
            this.f2873l = this.f2862a.hashCode();
            this.f2873l = (this.f2873l * 31) + this.f2871j.hashCode();
            this.f2873l = (this.f2873l * 31) + this.f2863b;
            this.f2873l = (this.f2873l * 31) + this.f2864c;
            this.f2873l = (this.f2865d != null ? this.f2865d.m5659a().hashCode() : 0) + (this.f2873l * 31);
            this.f2873l = (this.f2866e != null ? this.f2866e.m5659a().hashCode() : 0) + (this.f2873l * 31);
            this.f2873l = (this.f2867f != null ? this.f2867f.m5627a().hashCode() : 0) + (this.f2873l * 31);
            this.f2873l = (this.f2868g != null ? this.f2868g.m5525a().hashCode() : 0) + (this.f2873l * 31);
            this.f2873l = (this.f2869h != null ? this.f2869h.m5842a().hashCode() : 0) + (this.f2873l * 31);
            int i2 = this.f2873l * 31;
            if (this.f2870i != null) {
                i = this.f2870i.m5525a().hashCode();
            }
            this.f2873l = i2 + i;
        }
        return this.f2873l;
    }

    public String toString() {
        if (this.f2872k == null) {
            this.f2872k = "EngineKey{" + this.f2862a + '+' + this.f2871j + "+[" + this.f2863b + 'x' + this.f2864c + "]+" + '\'' + (this.f2865d != null ? this.f2865d.m5659a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2866e != null ? this.f2866e.m5659a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2867f != null ? this.f2867f.m5627a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2868g != null ? this.f2868g.m5525a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2869h != null ? this.f2869h.m5842a() : BuildConfig.FLAVOR) + '\'' + '+' + '\'' + (this.f2870i != null ? this.f2870i.m5525a() : BuildConfig.FLAVOR) + '\'' + '}';
        }
        return this.f2872k;
    }
}
