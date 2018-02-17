package com.p045c.p046a.p050d.p052b.p054a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.c.a.d.b.a.f */
public class C1030f implements C1023c {
    private static final Config f2745a;
    private final C1021g f2746b;
    private final Set<Config> f2747c;
    private final int f2748d;
    private final C1028a f2749e;
    private int f2750f;
    private int f2751g;
    private int f2752h;
    private int f2753i;
    private int f2754j;
    private int f2755k;

    /* renamed from: com.c.a.d.b.a.f.a */
    private interface C1028a {
        void m5360a(Bitmap bitmap);

        void m5361b(Bitmap bitmap);
    }

    /* renamed from: com.c.a.d.b.a.f.b */
    private static class C1029b implements C1028a {
        private C1029b() {
        }

        public void m5362a(Bitmap bitmap) {
        }

        public void m5363b(Bitmap bitmap) {
        }
    }

    static {
        f2745a = Config.ARGB_8888;
    }

    public C1030f(int i) {
        this(i, C1030f.m5368e(), C1030f.m5369f());
    }

    C1030f(int i, C1021g c1021g, Set<Config> set) {
        this.f2748d = i;
        this.f2750f = i;
        this.f2746b = c1021g;
        this.f2747c = set;
        this.f2749e = new C1029b();
    }

    private void m5364b() {
        m5365b(this.f2750f);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m5365b(int r5) {
        /*
        r4 = this;
        monitor-enter(r4);
    L_0x0001:
        r0 = r4.f2751g;	 Catch:{ all -> 0x0069 }
        if (r0 <= r5) goto L_0x0023;
    L_0x0005:
        r0 = r4.f2746b;	 Catch:{ all -> 0x0069 }
        r0 = r0.m5324a();	 Catch:{ all -> 0x0069 }
        if (r0 != 0) goto L_0x0025;
    L_0x000d:
        r0 = "LruBitmapPool";
        r1 = 5;
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x0069 }
        if (r0 == 0) goto L_0x0020;
    L_0x0016:
        r0 = "LruBitmapPool";
        r1 = "Size mismatch, resetting";
        android.util.Log.w(r0, r1);	 Catch:{ all -> 0x0069 }
        r4.m5367d();	 Catch:{ all -> 0x0069 }
    L_0x0020:
        r0 = 0;
        r4.f2751g = r0;	 Catch:{ all -> 0x0069 }
    L_0x0023:
        monitor-exit(r4);
        return;
    L_0x0025:
        r1 = r4.f2749e;	 Catch:{ all -> 0x0069 }
        r1.m5361b(r0);	 Catch:{ all -> 0x0069 }
        r1 = r4.f2751g;	 Catch:{ all -> 0x0069 }
        r2 = r4.f2746b;	 Catch:{ all -> 0x0069 }
        r2 = r2.m5329c(r0);	 Catch:{ all -> 0x0069 }
        r1 = r1 - r2;
        r4.f2751g = r1;	 Catch:{ all -> 0x0069 }
        r0.recycle();	 Catch:{ all -> 0x0069 }
        r1 = r4.f2755k;	 Catch:{ all -> 0x0069 }
        r1 = r1 + 1;
        r4.f2755k = r1;	 Catch:{ all -> 0x0069 }
        r1 = "LruBitmapPool";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);	 Catch:{ all -> 0x0069 }
        if (r1 == 0) goto L_0x0065;
    L_0x0047:
        r1 = "LruBitmapPool";
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0069 }
        r2.<init>();	 Catch:{ all -> 0x0069 }
        r3 = "Evicting bitmap=";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0069 }
        r3 = r4.f2746b;	 Catch:{ all -> 0x0069 }
        r0 = r3.m5328b(r0);	 Catch:{ all -> 0x0069 }
        r0 = r2.append(r0);	 Catch:{ all -> 0x0069 }
        r0 = r0.toString();	 Catch:{ all -> 0x0069 }
        android.util.Log.d(r1, r0);	 Catch:{ all -> 0x0069 }
    L_0x0065:
        r4.m5366c();	 Catch:{ all -> 0x0069 }
        goto L_0x0001;
    L_0x0069:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.d.b.a.f.b(int):void");
    }

    private void m5366c() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            m5367d();
        }
    }

    private void m5367d() {
        Log.v("LruBitmapPool", "Hits=" + this.f2752h + ", misses=" + this.f2753i + ", puts=" + this.f2754j + ", evictions=" + this.f2755k + ", currentSize=" + this.f2751g + ", maxSize=" + this.f2750f + "\nStrategy=" + this.f2746b);
    }

    private static C1021g m5368e() {
        return VERSION.SDK_INT >= 19 ? new C1034i() : new C1022a();
    }

    private static Set<Config> m5369f() {
        Set hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    public synchronized Bitmap m5370a(int i, int i2, Config config) {
        Bitmap b;
        b = m5374b(i, i2, config);
        if (b != null) {
            b.eraseColor(0);
        }
        return b;
    }

    public void m5371a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        m5365b(0);
    }

    @SuppressLint({"InlinedApi"})
    public void m5372a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i >= 60) {
            m5371a();
        } else if (i >= 40) {
            m5365b(this.f2750f / 2);
        }
    }

    public synchronized boolean m5373a(Bitmap bitmap) {
        boolean z;
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmap.isMutable() && this.f2746b.m5329c(bitmap) <= this.f2750f && this.f2747c.contains(bitmap.getConfig())) {
            int c = this.f2746b.m5329c(bitmap);
            this.f2746b.m5326a(bitmap);
            this.f2749e.m5360a(bitmap);
            this.f2754j++;
            this.f2751g = c + this.f2751g;
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Put bitmap in pool=" + this.f2746b.m5328b(bitmap));
            }
            m5366c();
            m5364b();
            z = true;
        } else {
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.f2746b.m5328b(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f2747c.contains(bitmap.getConfig()));
            }
            z = false;
        }
        return z;
    }

    @TargetApi(12)
    public synchronized Bitmap m5374b(int i, int i2, Config config) {
        Bitmap a;
        a = this.f2746b.m5325a(i, i2, config != null ? config : f2745a);
        if (a == null) {
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Missing bitmap=" + this.f2746b.m5327b(i, i2, config));
            }
            this.f2753i++;
        } else {
            this.f2752h++;
            this.f2751g -= this.f2746b.m5329c(a);
            this.f2749e.m5361b(a);
            if (VERSION.SDK_INT >= 12) {
                a.setHasAlpha(true);
            }
        }
        if (Log.isLoggable("LruBitmapPool", 2)) {
            Log.v("LruBitmapPool", "Get bitmap=" + this.f2746b.m5327b(i, i2, config));
        }
        m5366c();
        return a;
    }
}
