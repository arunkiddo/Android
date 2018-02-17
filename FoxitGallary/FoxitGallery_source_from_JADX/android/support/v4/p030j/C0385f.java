package android.support.v4.p030j;

import java.util.LinkedHashMap;

/* renamed from: android.support.v4.j.f */
public class C0385f<K, V> {
    private final LinkedHashMap<K, V> f732a;
    private int f733b;
    private int f734c;
    private int f735d;
    private int f736e;
    private int f737f;
    private int f738g;
    private int f739h;

    public C0385f(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f734c = i;
        this.f732a = new LinkedHashMap(0, 0.75f, true);
    }

    private int m1445c(K k, V v) {
        int b = m1450b(k, v);
        if (b >= 0) {
            return b;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    public final V m1446a(K k) {
        if (k == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            V v = this.f732a.get(k);
            if (v != null) {
                this.f738g++;
                return v;
            }
            this.f739h++;
            V b = m1451b(k);
            if (b == null) {
                return null;
            }
            synchronized (this) {
                this.f736e++;
                v = this.f732a.put(k, b);
                if (v != null) {
                    this.f732a.put(k, v);
                } else {
                    this.f733b += m1445c(k, b);
                }
            }
            if (v != null) {
                m1449a(false, k, b, v);
                return v;
            }
            m1448a(this.f734c);
            return b;
        }
    }

    public final V m1447a(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.f735d++;
            this.f733b += m1445c(k, v);
            put = this.f732a.put(k, v);
            if (put != null) {
                this.f733b -= m1445c(k, put);
            }
        }
        if (put != null) {
            m1449a(false, k, put, v);
        }
        m1448a(this.f734c);
        return put;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void m1448a(int r5) {
        /*
        r4 = this;
    L_0x0000:
        monitor-enter(r4);
        r0 = r4.f733b;	 Catch:{ all -> 0x0032 }
        if (r0 < 0) goto L_0x0011;
    L_0x0005:
        r0 = r4.f732a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x000d:
        r0 = r4.f733b;	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0035;
    L_0x0011:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0032 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r1.<init>();	 Catch:{ all -> 0x0032 }
        r2 = r4.getClass();	 Catch:{ all -> 0x0032 }
        r2 = r2.getName();	 Catch:{ all -> 0x0032 }
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r2 = ".sizeOf() is reporting inconsistent results!";
        r1 = r1.append(r2);	 Catch:{ all -> 0x0032 }
        r1 = r1.toString();	 Catch:{ all -> 0x0032 }
        r0.<init>(r1);	 Catch:{ all -> 0x0032 }
        throw r0;	 Catch:{ all -> 0x0032 }
    L_0x0032:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        throw r0;
    L_0x0035:
        r0 = r4.f733b;	 Catch:{ all -> 0x0032 }
        if (r0 <= r5) goto L_0x0041;
    L_0x0039:
        r0 = r4.f732a;	 Catch:{ all -> 0x0032 }
        r0 = r0.isEmpty();	 Catch:{ all -> 0x0032 }
        if (r0 == 0) goto L_0x0043;
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        return;
    L_0x0043:
        r0 = r4.f732a;	 Catch:{ all -> 0x0032 }
        r0 = r0.entrySet();	 Catch:{ all -> 0x0032 }
        r0 = r0.iterator();	 Catch:{ all -> 0x0032 }
        r0 = r0.next();	 Catch:{ all -> 0x0032 }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ all -> 0x0032 }
        r1 = r0.getKey();	 Catch:{ all -> 0x0032 }
        r0 = r0.getValue();	 Catch:{ all -> 0x0032 }
        r2 = r4.f732a;	 Catch:{ all -> 0x0032 }
        r2.remove(r1);	 Catch:{ all -> 0x0032 }
        r2 = r4.f733b;	 Catch:{ all -> 0x0032 }
        r3 = r4.m1445c(r1, r0);	 Catch:{ all -> 0x0032 }
        r2 = r2 - r3;
        r4.f733b = r2;	 Catch:{ all -> 0x0032 }
        r2 = r4.f737f;	 Catch:{ all -> 0x0032 }
        r2 = r2 + 1;
        r4.f737f = r2;	 Catch:{ all -> 0x0032 }
        monitor-exit(r4);	 Catch:{ all -> 0x0032 }
        r2 = 1;
        r3 = 0;
        r4.m1449a(r2, r1, r0, r3);
        goto L_0x0000;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.j.f.a(int):void");
    }

    protected void m1449a(boolean z, K k, V v, V v2) {
    }

    protected int m1450b(K k, V v) {
        return 1;
    }

    protected V m1451b(K k) {
        return null;
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f738g + this.f739h;
            if (i2 != 0) {
                i = (this.f738g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f734c), Integer.valueOf(this.f738g), Integer.valueOf(this.f739h), Integer.valueOf(i)});
        }
        return format;
    }
}
