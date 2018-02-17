package com.p045c.p046a.p050d.p062d.p067d;

import android.graphics.Bitmap;
import android.util.Log;
import com.p045c.p046a.p048b.C0991a;
import com.p045c.p046a.p048b.C0991a.C0990a;
import com.p045c.p046a.p048b.C0993c;
import com.p045c.p046a.p048b.C0994d;
import com.p045c.p046a.p049c.C0996a;
import com.p045c.p046a.p050d.C1143f;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.p052b.C1084k;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p062d.p063a.C1145c;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.OutputStream;

/* renamed from: com.c.a.d.d.d.j */
public class C1209j implements C1143f<C1189b> {
    private static final C1208a f3064a;
    private final C0990a f3065b;
    private final C1023c f3066c;
    private final C1208a f3067d;

    /* renamed from: com.c.a.d.d.d.j.a */
    static class C1208a {
        C1208a() {
        }

        public C0991a m5800a(C0990a c0990a) {
            return new C0991a(c0990a);
        }

        public C0994d m5801a() {
            return new C0994d();
        }

        public C1084k<Bitmap> m5802a(Bitmap bitmap, C1023c c1023c) {
            return new C1145c(bitmap, c1023c);
        }

        public C0996a m5803b() {
            return new C0996a();
        }
    }

    static {
        f3064a = new C1208a();
    }

    public C1209j(C1023c c1023c) {
        this(c1023c, f3064a);
    }

    C1209j(C1023c c1023c, C1208a c1208a) {
        this.f3066c = c1023c;
        this.f3065b = new C1186a(c1023c);
        this.f3067d = c1208a;
    }

    private C0991a m5804a(byte[] bArr) {
        C0994d a = this.f3067d.m5801a();
        a.m5197a(bArr);
        C0993c b = a.m5199b();
        C0991a a2 = this.f3067d.m5800a(this.f3065b);
        a2.m5174a(b, bArr);
        a2.m5173a();
        return a2;
    }

    private C1084k<Bitmap> m5805a(Bitmap bitmap, C1146g<Bitmap> c1146g, C1189b c1189b) {
        C1084k a = this.f3067d.m5802a(bitmap, this.f3066c);
        C1084k<Bitmap> a2 = c1146g.m5626a(a, c1189b.getIntrinsicWidth(), c1189b.getIntrinsicHeight());
        if (!a.equals(a2)) {
            a.m5507d();
        }
        return a2;
    }

    private boolean m5806a(byte[] bArr, OutputStream outputStream) {
        try {
            outputStream.write(bArr);
            return true;
        } catch (Throwable e) {
            if (Log.isLoggable("GifEncoder", 3)) {
                Log.d("GifEncoder", "Failed to write data to output stream in GifResourceEncoder", e);
            }
            return false;
        }
    }

    public String m5807a() {
        return BuildConfig.FLAVOR;
    }

    public boolean m5808a(com.p045c.p046a.p050d.p052b.C1084k<com.p045c.p046a.p050d.p062d.p067d.C1189b> r11, java.io.OutputStream r12) {
        /* JADX: method processing error */
/*
        Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
*/
        /*
        r10 = this;
        r3 = 0;
        r4 = com.p045c.p046a.p055j.C1292d.m6102a();
        r0 = r11.m5505b();
        r0 = (com.p045c.p046a.p050d.p062d.p067d.C1189b) r0;
        r6 = r0.m5756c();
        r1 = r6 instanceof com.p045c.p046a.p050d.p062d.C1210d;
        if (r1 == 0) goto L_0x001c;
    L_0x0013:
        r0 = r0.m5757d();
        r3 = r10.m5806a(r0, r12);
    L_0x001b:
        return r3;
    L_0x001c:
        r1 = r0.m5757d();
        r7 = r10.m5804a(r1);
        r1 = r10.f3067d;
        r8 = r1.m5803b();
        r1 = r8.m5216a(r12);
        if (r1 == 0) goto L_0x001b;
    L_0x0030:
        r2 = r3;
    L_0x0031:
        r1 = r7.m5176c();
        if (r2 >= r1) goto L_0x0069;
    L_0x0037:
        r1 = r7.m5179f();
        r9 = r10.m5805a(r1, r6, r0);
        r1 = r9.m5505b();	 Catch:{ all -> 0x0064 }
        r1 = (android.graphics.Bitmap) r1;	 Catch:{ all -> 0x0064 }
        r1 = r8.m5215a(r1);	 Catch:{ all -> 0x0064 }
        if (r1 != 0) goto L_0x004f;
    L_0x004b:
        r9.m5507d();
        goto L_0x001b;
    L_0x004f:
        r1 = r7.m5177d();	 Catch:{ all -> 0x0064 }
        r1 = r7.m5172a(r1);	 Catch:{ all -> 0x0064 }
        r8.m5212a(r1);	 Catch:{ all -> 0x0064 }
        r7.m5173a();	 Catch:{ all -> 0x0064 }
        r9.m5507d();
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0031;
    L_0x0064:
        r0 = move-exception;
        r9.m5507d();
        throw r0;
    L_0x0069:
        r3 = r8.m5214a();
        r1 = "GifEncoder";
        r2 = 2;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x001b;
    L_0x0076:
        r1 = "GifEncoder";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r6 = "Encoded gif with ";
        r2 = r2.append(r6);
        r6 = r7.m5176c();
        r2 = r2.append(r6);
        r6 = " frames and ";
        r2 = r2.append(r6);
        r0 = r0.m5757d();
        r0 = r0.length;
        r0 = r2.append(r0);
        r2 = " bytes in ";
        r0 = r0.append(r2);
        r4 = com.p045c.p046a.p055j.C1292d.m6101a(r4);
        r0 = r0.append(r4);
        r2 = " ms";
        r0 = r0.append(r2);
        r0 = r0.toString();
        android.util.Log.v(r1, r0);
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.d.d.d.j.a(com.c.a.d.b.k, java.io.OutputStream):boolean");
    }
}
