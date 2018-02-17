package com.p045c.p046a.p047a;

import com.simplemobiletools.gallery.BuildConfig;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.c.a.a.a */
public final class C0984a implements Closeable {
    final ThreadPoolExecutor f2552a;
    private final File f2553b;
    private final File f2554c;
    private final File f2555d;
    private final File f2556e;
    private final int f2557f;
    private long f2558g;
    private final int f2559h;
    private long f2560i;
    private Writer f2561j;
    private final LinkedHashMap<String, C0982b> f2562k;
    private int f2563l;
    private long f2564m;
    private final Callable<Void> f2565n;

    /* renamed from: com.c.a.a.a.1 */
    class C09801 implements Callable<Void> {
        final /* synthetic */ C0984a f2534a;

        C09801(C0984a c0984a) {
            this.f2534a = c0984a;
        }

        public Void m5060a() {
            synchronized (this.f2534a) {
                if (this.f2534a.f2561j == null) {
                } else {
                    this.f2534a.m5101g();
                    if (this.f2534a.m5098e()) {
                        this.f2534a.m5094d();
                        this.f2534a.f2563l = 0;
                    }
                }
            }
            return null;
        }

        public /* synthetic */ Object call() {
            return m5060a();
        }
    }

    /* renamed from: com.c.a.a.a.a */
    public final class C0981a {
        final /* synthetic */ C0984a f2535a;
        private final C0982b f2536b;
        private final boolean[] f2537c;
        private boolean f2538d;

        private C0981a(C0984a c0984a, C0982b c0982b) {
            this.f2535a = c0984a;
            this.f2536b = c0982b;
            this.f2537c = c0982b.f2544f ? null : new boolean[c0984a.f2559h];
        }

        public File m5063a(int i) {
            File b;
            synchronized (this.f2535a) {
                if (this.f2536b.f2545g != this) {
                    throw new IllegalStateException();
                }
                if (!this.f2536b.f2544f) {
                    this.f2537c[i] = true;
                }
                b = this.f2536b.m5080b(i);
                if (!this.f2535a.f2553b.exists()) {
                    this.f2535a.f2553b.mkdirs();
                }
            }
            return b;
        }

        public void m5064a() {
            this.f2535a.m5086a(this, true);
            this.f2538d = true;
        }

        public void m5065b() {
            this.f2535a.m5086a(this, false);
        }

        public void m5066c() {
            if (!this.f2538d) {
                try {
                    m5065b();
                } catch (IOException e) {
                }
            }
        }
    }

    /* renamed from: com.c.a.a.a.b */
    private final class C0982b {
        File[] f2539a;
        File[] f2540b;
        final /* synthetic */ C0984a f2541c;
        private final String f2542d;
        private final long[] f2543e;
        private boolean f2544f;
        private C0981a f2545g;
        private long f2546h;

        private C0982b(C0984a c0984a, String str) {
            this.f2541c = c0984a;
            this.f2542d = str;
            this.f2543e = new long[c0984a.f2559h];
            this.f2539a = new File[c0984a.f2559h];
            this.f2540b = new File[c0984a.f2559h];
            StringBuilder append = new StringBuilder(str).append('.');
            int length = append.length();
            for (int i = 0; i < c0984a.f2559h; i++) {
                append.append(i);
                this.f2539a[i] = new File(c0984a.f2553b, append.toString());
                append.append(".tmp");
                this.f2540b[i] = new File(c0984a.f2553b, append.toString());
                append.setLength(length);
            }
        }

        private void m5071a(String[] strArr) {
            if (strArr.length != this.f2541c.f2559h) {
                throw m5073b(strArr);
            }
            int i = 0;
            while (i < strArr.length) {
                try {
                    this.f2543e[i] = Long.parseLong(strArr[i]);
                    i++;
                } catch (NumberFormatException e) {
                    throw m5073b(strArr);
                }
            }
        }

        private IOException m5073b(String[] strArr) {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        public File m5078a(int i) {
            return this.f2539a[i];
        }

        public String m5079a() {
            StringBuilder stringBuilder = new StringBuilder();
            for (long append : this.f2543e) {
                stringBuilder.append(' ').append(append);
            }
            return stringBuilder.toString();
        }

        public File m5080b(int i) {
            return this.f2540b[i];
        }
    }

    /* renamed from: com.c.a.a.a.c */
    public final class C0983c {
        final /* synthetic */ C0984a f2547a;
        private final String f2548b;
        private final long f2549c;
        private final long[] f2550d;
        private final File[] f2551e;

        private C0983c(C0984a c0984a, String str, long j, File[] fileArr, long[] jArr) {
            this.f2547a = c0984a;
            this.f2548b = str;
            this.f2549c = j;
            this.f2551e = fileArr;
            this.f2550d = jArr;
        }

        public File m5081a(int i) {
            return this.f2551e[i];
        }
    }

    private C0984a(File file, int i, int i2, long j) {
        this.f2560i = 0;
        this.f2562k = new LinkedHashMap(0, 0.75f, true);
        this.f2564m = 0;
        this.f2552a = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
        this.f2565n = new C09801(this);
        this.f2553b = file;
        this.f2557f = i;
        this.f2554c = new File(file, "journal");
        this.f2555d = new File(file, "journal.tmp");
        this.f2556e = new File(file, "journal.bkp");
        this.f2559h = i2;
        this.f2558g = j;
    }

    private synchronized C0981a m5083a(String str, long j) {
        C0981a c0981a;
        m5100f();
        C0982b c0982b = (C0982b) this.f2562k.get(str);
        if (j == -1 || (c0982b != null && c0982b.f2546h == j)) {
            C0982b c0982b2;
            if (c0982b == null) {
                c0982b = new C0982b(str, null);
                this.f2562k.put(str, c0982b);
                c0982b2 = c0982b;
            } else if (c0982b.f2545g != null) {
                c0981a = null;
            } else {
                c0982b2 = c0982b;
            }
            c0981a = new C0981a(c0982b2, null);
            c0982b2.f2545g = c0981a;
            this.f2561j.append("DIRTY");
            this.f2561j.append(' ');
            this.f2561j.append(str);
            this.f2561j.append('\n');
            this.f2561j.flush();
        } else {
            c0981a = null;
        }
        return c0981a;
    }

    public static C0984a m5084a(File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0");
        } else {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    C0984a.m5089a(file2, file3, false);
                }
            }
            C0984a c0984a = new C0984a(file, i, i2, j);
            if (c0984a.f2554c.exists()) {
                try {
                    c0984a.m5090b();
                    c0984a.m5092c();
                    return c0984a;
                } catch (IOException e) {
                    System.out.println("DiskLruCache " + file + " is corrupt: " + e.getMessage() + ", removing");
                    c0984a.m5103a();
                }
            }
            file.mkdirs();
            c0984a = new C0984a(file, i, i2, j);
            c0984a.m5094d();
            return c0984a;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void m5086a(com.p045c.p046a.p047a.C0984a.C0981a r11, boolean r12) {
        /*
        r10 = this;
        r0 = 0;
        monitor-enter(r10);
        r2 = r11.f2536b;	 Catch:{ all -> 0x0012 }
        r1 = r2.f2545g;	 Catch:{ all -> 0x0012 }
        if (r1 == r11) goto L_0x0015;
    L_0x000c:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0012 }
        r0.<init>();	 Catch:{ all -> 0x0012 }
        throw r0;	 Catch:{ all -> 0x0012 }
    L_0x0012:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
    L_0x0015:
        if (r12 == 0) goto L_0x0058;
    L_0x0017:
        r1 = r2.f2544f;	 Catch:{ all -> 0x0012 }
        if (r1 != 0) goto L_0x0058;
    L_0x001d:
        r1 = r0;
    L_0x001e:
        r3 = r10.f2559h;	 Catch:{ all -> 0x0012 }
        if (r1 >= r3) goto L_0x0058;
    L_0x0022:
        r3 = r11.f2537c;	 Catch:{ all -> 0x0012 }
        r3 = r3[r1];	 Catch:{ all -> 0x0012 }
        if (r3 != 0) goto L_0x0046;
    L_0x002a:
        r11.m5065b();	 Catch:{ all -> 0x0012 }
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0012 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0012 }
        r2.<init>();	 Catch:{ all -> 0x0012 }
        r3 = "Newly created entry didn't create value for index ";
        r2 = r2.append(r3);	 Catch:{ all -> 0x0012 }
        r1 = r2.append(r1);	 Catch:{ all -> 0x0012 }
        r1 = r1.toString();	 Catch:{ all -> 0x0012 }
        r0.<init>(r1);	 Catch:{ all -> 0x0012 }
        throw r0;	 Catch:{ all -> 0x0012 }
    L_0x0046:
        r3 = r2.m5080b(r1);	 Catch:{ all -> 0x0012 }
        r3 = r3.exists();	 Catch:{ all -> 0x0012 }
        if (r3 != 0) goto L_0x0055;
    L_0x0050:
        r11.m5065b();	 Catch:{ all -> 0x0012 }
    L_0x0053:
        monitor-exit(r10);
        return;
    L_0x0055:
        r1 = r1 + 1;
        goto L_0x001e;
    L_0x0058:
        r1 = r10.f2559h;	 Catch:{ all -> 0x0012 }
        if (r0 >= r1) goto L_0x008d;
    L_0x005c:
        r1 = r2.m5080b(r0);	 Catch:{ all -> 0x0012 }
        if (r12 == 0) goto L_0x0089;
    L_0x0062:
        r3 = r1.exists();	 Catch:{ all -> 0x0012 }
        if (r3 == 0) goto L_0x0086;
    L_0x0068:
        r3 = r2.m5078a(r0);	 Catch:{ all -> 0x0012 }
        r1.renameTo(r3);	 Catch:{ all -> 0x0012 }
        r1 = r2.f2543e;	 Catch:{ all -> 0x0012 }
        r4 = r1[r0];	 Catch:{ all -> 0x0012 }
        r6 = r3.length();	 Catch:{ all -> 0x0012 }
        r1 = r2.f2543e;	 Catch:{ all -> 0x0012 }
        r1[r0] = r6;	 Catch:{ all -> 0x0012 }
        r8 = r10.f2560i;	 Catch:{ all -> 0x0012 }
        r4 = r8 - r4;
        r4 = r4 + r6;
        r10.f2560i = r4;	 Catch:{ all -> 0x0012 }
    L_0x0086:
        r0 = r0 + 1;
        goto L_0x0058;
    L_0x0089:
        com.p045c.p046a.p047a.C0984a.m5088a(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0086;
    L_0x008d:
        r0 = r10.f2563l;	 Catch:{ all -> 0x0012 }
        r0 = r0 + 1;
        r10.f2563l = r0;	 Catch:{ all -> 0x0012 }
        r0 = 0;
        r2.f2545g = r0;	 Catch:{ all -> 0x0012 }
        r0 = r2.f2544f;	 Catch:{ all -> 0x0012 }
        r0 = r0 | r12;
        if (r0 == 0) goto L_0x00f1;
    L_0x009e:
        r0 = 1;
        r2.f2544f = r0;	 Catch:{ all -> 0x0012 }
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r1 = "CLEAN";
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r1 = 32;
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r1 = r2.f2542d;	 Catch:{ all -> 0x0012 }
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r1 = r2.m5079a();	 Catch:{ all -> 0x0012 }
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r1 = 10;
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        if (r12 == 0) goto L_0x00d5;
    L_0x00cb:
        r0 = r10.f2564m;	 Catch:{ all -> 0x0012 }
        r4 = 1;
        r4 = r4 + r0;
        r10.f2564m = r4;	 Catch:{ all -> 0x0012 }
        r2.f2546h = r0;	 Catch:{ all -> 0x0012 }
    L_0x00d5:
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r0.flush();	 Catch:{ all -> 0x0012 }
        r0 = r10.f2560i;	 Catch:{ all -> 0x0012 }
        r2 = r10.f2558g;	 Catch:{ all -> 0x0012 }
        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r0 > 0) goto L_0x00e8;
    L_0x00e2:
        r0 = r10.m5098e();	 Catch:{ all -> 0x0012 }
        if (r0 == 0) goto L_0x0053;
    L_0x00e8:
        r0 = r10.f2552a;	 Catch:{ all -> 0x0012 }
        r1 = r10.f2565n;	 Catch:{ all -> 0x0012 }
        r0.submit(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x0053;
    L_0x00f1:
        r0 = r10.f2562k;	 Catch:{ all -> 0x0012 }
        r1 = r2.f2542d;	 Catch:{ all -> 0x0012 }
        r0.remove(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r1 = "REMOVE";
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r1 = 32;
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r1 = r2.f2542d;	 Catch:{ all -> 0x0012 }
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        r0 = r10.f2561j;	 Catch:{ all -> 0x0012 }
        r1 = 10;
        r0.append(r1);	 Catch:{ all -> 0x0012 }
        goto L_0x00d5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.a.a(com.c.a.a.a$a, boolean):void");
    }

    private static void m5088a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    private static void m5089a(File file, File file2, boolean z) {
        if (z) {
            C0984a.m5088a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    private void m5090b() {
        Closeable c0986b = new C0986b(new FileInputStream(this.f2554c), C0987c.f2572a);
        int i;
        try {
            String a = c0986b.m5108a();
            String a2 = c0986b.m5108a();
            String a3 = c0986b.m5108a();
            String a4 = c0986b.m5108a();
            String a5 = c0986b.m5108a();
            if ("libcore.io.DiskLruCache".equals(a) && "1".equals(a2) && Integer.toString(this.f2557f).equals(a3) && Integer.toString(this.f2559h).equals(a4) && BuildConfig.FLAVOR.equals(a5)) {
                i = 0;
                while (true) {
                    m5096d(c0986b.m5108a());
                    i++;
                }
            } else {
                throw new IOException("unexpected journal header: [" + a + ", " + a2 + ", " + a4 + ", " + a5 + "]");
            }
        } catch (EOFException e) {
            this.f2563l = i - this.f2562k.size();
            if (c0986b.m5109b()) {
                m5094d();
            } else {
                this.f2561j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2554c, true), C0987c.f2572a));
            }
            C0987c.m5110a(c0986b);
        } catch (Throwable th) {
            C0987c.m5110a(c0986b);
        }
    }

    private void m5092c() {
        C0984a.m5088a(this.f2555d);
        Iterator it = this.f2562k.values().iterator();
        while (it.hasNext()) {
            C0982b c0982b = (C0982b) it.next();
            int i;
            if (c0982b.f2545g == null) {
                for (i = 0; i < this.f2559h; i++) {
                    this.f2560i += c0982b.f2543e[i];
                }
            } else {
                c0982b.f2545g = null;
                for (i = 0; i < this.f2559h; i++) {
                    C0984a.m5088a(c0982b.m5078a(i));
                    C0984a.m5088a(c0982b.m5080b(i));
                }
                it.remove();
            }
        }
    }

    private synchronized void m5094d() {
        if (this.f2561j != null) {
            this.f2561j.close();
        }
        Writer bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2555d), C0987c.f2572a));
        try {
            bufferedWriter.write("libcore.io.DiskLruCache");
            bufferedWriter.write("\n");
            bufferedWriter.write("1");
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2557f));
            bufferedWriter.write("\n");
            bufferedWriter.write(Integer.toString(this.f2559h));
            bufferedWriter.write("\n");
            bufferedWriter.write("\n");
            for (C0982b c0982b : this.f2562k.values()) {
                if (c0982b.f2545g != null) {
                    bufferedWriter.write("DIRTY " + c0982b.f2542d + '\n');
                } else {
                    bufferedWriter.write("CLEAN " + c0982b.f2542d + c0982b.m5079a() + '\n');
                }
            }
            bufferedWriter.close();
            if (this.f2554c.exists()) {
                C0984a.m5089a(this.f2554c, this.f2556e, true);
            }
            C0984a.m5089a(this.f2555d, this.f2554c, false);
            this.f2556e.delete();
            this.f2561j = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f2554c, true), C0987c.f2572a));
        } catch (Throwable th) {
            bufferedWriter.close();
        }
    }

    private void m5096d(String str) {
        int indexOf = str.indexOf(32);
        if (indexOf == -1) {
            throw new IOException("unexpected journal line: " + str);
        }
        String str2;
        int i = indexOf + 1;
        int indexOf2 = str.indexOf(32, i);
        if (indexOf2 == -1) {
            String substring = str.substring(i);
            if (indexOf == "REMOVE".length() && str.startsWith("REMOVE")) {
                this.f2562k.remove(substring);
                return;
            }
            str2 = substring;
        } else {
            str2 = str.substring(i, indexOf2);
        }
        C0982b c0982b = (C0982b) this.f2562k.get(str2);
        if (c0982b == null) {
            c0982b = new C0982b(str2, null);
            this.f2562k.put(str2, c0982b);
        }
        if (indexOf2 != -1 && indexOf == "CLEAN".length() && str.startsWith("CLEAN")) {
            String[] split = str.substring(indexOf2 + 1).split(" ");
            c0982b.f2544f = true;
            c0982b.f2545g = null;
            c0982b.m5071a(split);
        } else if (indexOf2 == -1 && indexOf == "DIRTY".length() && str.startsWith("DIRTY")) {
            c0982b.f2545g = new C0981a(c0982b, null);
        } else if (indexOf2 != -1 || indexOf != "READ".length() || !str.startsWith("READ")) {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    private boolean m5098e() {
        return this.f2563l >= 2000 && this.f2563l >= this.f2562k.size();
    }

    private void m5100f() {
        if (this.f2561j == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    private void m5101g() {
        while (this.f2560i > this.f2558g) {
            m5105c((String) ((Entry) this.f2562k.entrySet().iterator().next()).getKey());
        }
    }

    public synchronized C0983c m5102a(String str) {
        C0983c c0983c = null;
        synchronized (this) {
            m5100f();
            C0982b c0982b = (C0982b) this.f2562k.get(str);
            if (c0982b != null) {
                if (c0982b.f2544f) {
                    for (File exists : c0982b.f2539a) {
                        if (!exists.exists()) {
                            break;
                        }
                    }
                    this.f2563l++;
                    this.f2561j.append("READ");
                    this.f2561j.append(' ');
                    this.f2561j.append(str);
                    this.f2561j.append('\n');
                    if (m5098e()) {
                        this.f2552a.submit(this.f2565n);
                    }
                    c0983c = new C0983c(str, c0982b.f2546h, c0982b.f2539a, c0982b.f2543e, null);
                }
            }
        }
        return c0983c;
    }

    public void m5103a() {
        close();
        C0987c.m5111a(this.f2553b);
    }

    public C0981a m5104b(String str) {
        return m5083a(str, -1);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean m5105c(java.lang.String r7) {
        /*
        r6 = this;
        r1 = 0;
        monitor-enter(r6);
        r6.m5100f();	 Catch:{ all -> 0x005a }
        r0 = r6.f2562k;	 Catch:{ all -> 0x005a }
        r0 = r0.get(r7);	 Catch:{ all -> 0x005a }
        r0 = (com.p045c.p046a.p047a.C0984a.C0982b) r0;	 Catch:{ all -> 0x005a }
        if (r0 == 0) goto L_0x0015;
    L_0x000f:
        r2 = r0.f2545g;	 Catch:{ all -> 0x005a }
        if (r2 == 0) goto L_0x002d;
    L_0x0015:
        r0 = r1;
    L_0x0016:
        monitor-exit(r6);
        return r0;
    L_0x0018:
        r2 = r6.f2560i;	 Catch:{ all -> 0x005a }
        r4 = r0.f2543e;	 Catch:{ all -> 0x005a }
        r4 = r4[r1];	 Catch:{ all -> 0x005a }
        r2 = r2 - r4;
        r6.f2560i = r2;	 Catch:{ all -> 0x005a }
        r2 = r0.f2543e;	 Catch:{ all -> 0x005a }
        r4 = 0;
        r2[r1] = r4;	 Catch:{ all -> 0x005a }
        r1 = r1 + 1;
    L_0x002d:
        r2 = r6.f2559h;	 Catch:{ all -> 0x005a }
        if (r1 >= r2) goto L_0x005d;
    L_0x0031:
        r2 = r0.m5078a(r1);	 Catch:{ all -> 0x005a }
        r3 = r2.exists();	 Catch:{ all -> 0x005a }
        if (r3 == 0) goto L_0x0018;
    L_0x003b:
        r3 = r2.delete();	 Catch:{ all -> 0x005a }
        if (r3 != 0) goto L_0x0018;
    L_0x0041:
        r0 = new java.io.IOException;	 Catch:{ all -> 0x005a }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x005a }
        r1.<init>();	 Catch:{ all -> 0x005a }
        r3 = "failed to delete ";
        r1 = r1.append(r3);	 Catch:{ all -> 0x005a }
        r1 = r1.append(r2);	 Catch:{ all -> 0x005a }
        r1 = r1.toString();	 Catch:{ all -> 0x005a }
        r0.<init>(r1);	 Catch:{ all -> 0x005a }
        throw r0;	 Catch:{ all -> 0x005a }
    L_0x005a:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x005d:
        r0 = r6.f2563l;	 Catch:{ all -> 0x005a }
        r0 = r0 + 1;
        r6.f2563l = r0;	 Catch:{ all -> 0x005a }
        r0 = r6.f2561j;	 Catch:{ all -> 0x005a }
        r1 = "REMOVE";
        r0.append(r1);	 Catch:{ all -> 0x005a }
        r0 = r6.f2561j;	 Catch:{ all -> 0x005a }
        r1 = 32;
        r0.append(r1);	 Catch:{ all -> 0x005a }
        r0 = r6.f2561j;	 Catch:{ all -> 0x005a }
        r0.append(r7);	 Catch:{ all -> 0x005a }
        r0 = r6.f2561j;	 Catch:{ all -> 0x005a }
        r1 = 10;
        r0.append(r1);	 Catch:{ all -> 0x005a }
        r0 = r6.f2562k;	 Catch:{ all -> 0x005a }
        r0.remove(r7);	 Catch:{ all -> 0x005a }
        r0 = r6.m5098e();	 Catch:{ all -> 0x005a }
        if (r0 == 0) goto L_0x008f;
    L_0x0088:
        r0 = r6.f2552a;	 Catch:{ all -> 0x005a }
        r1 = r6.f2565n;	 Catch:{ all -> 0x005a }
        r0.submit(r1);	 Catch:{ all -> 0x005a }
    L_0x008f:
        r0 = 1;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.a.a.c(java.lang.String):boolean");
    }

    public synchronized void close() {
        if (this.f2561j != null) {
            Iterator it = new ArrayList(this.f2562k.values()).iterator();
            while (it.hasNext()) {
                C0982b c0982b = (C0982b) it.next();
                if (c0982b.f2545g != null) {
                    c0982b.f2545g.m5065b();
                }
            }
            m5101g();
            this.f2561j.close();
            this.f2561j = null;
        }
    }
}
