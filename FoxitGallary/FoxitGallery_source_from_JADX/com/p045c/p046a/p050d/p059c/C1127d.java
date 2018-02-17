package com.p045c.p046a.p050d.p059c;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;

/* renamed from: com.c.a.d.c.d */
public class C1127d {
    private final URL f2908a;
    private final C1128e f2909b;
    private final String f2910c;
    private String f2911d;
    private URL f2912e;

    public C1127d(String str) {
        this(str, C1128e.f2914b);
    }

    public C1127d(String str, C1128e c1128e) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        } else if (c1128e == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.f2910c = str;
            this.f2908a = null;
            this.f2909b = c1128e;
        }
    }

    public C1127d(URL url) {
        this(url, C1128e.f2914b);
    }

    public C1127d(URL url, C1128e c1128e) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        } else if (c1128e == null) {
            throw new IllegalArgumentException("Headers must not be null");
        } else {
            this.f2908a = url;
            this.f2910c = null;
            this.f2909b = c1128e;
        }
    }

    private URL m5583d() {
        if (this.f2912e == null) {
            this.f2912e = new URL(m5584e());
        }
        return this.f2912e;
    }

    private String m5584e() {
        if (TextUtils.isEmpty(this.f2911d)) {
            String str = this.f2910c;
            if (TextUtils.isEmpty(str)) {
                str = this.f2908a.toString();
            }
            this.f2911d = Uri.encode(str, "@#&=*+-_.,:!?()/~'%");
        }
        return this.f2911d;
    }

    public URL m5585a() {
        return m5583d();
    }

    public Map<String, String> m5586b() {
        return this.f2909b.m5588a();
    }

    public String m5587c() {
        return this.f2910c != null ? this.f2910c : this.f2908a.toString();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1127d)) {
            return false;
        }
        C1127d c1127d = (C1127d) obj;
        return m5587c().equals(c1127d.m5587c()) && this.f2909b.equals(c1127d.f2909b);
    }

    public int hashCode() {
        return (m5587c().hashCode() * 31) + this.f2909b.hashCode();
    }

    public String toString() {
        return m5587c() + '\n' + this.f2909b.toString();
    }
}
