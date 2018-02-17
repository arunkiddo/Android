package com.p045c.p046a.p050d.p062d.p063a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import android.util.Log;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p062d.p063a.C1166l.C1163a;
import com.p045c.p046a.p055j.C1293f;
import com.p045c.p046a.p055j.C1296h;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

/* renamed from: com.c.a.d.d.a.f */
public abstract class C1149f implements C1142a<InputStream> {
    public static final C1149f f2944a;
    public static final C1149f f2945b;
    public static final C1149f f2946c;
    private static final Set<C1163a> f2947d;
    private static final Queue<Options> f2948e;

    /* renamed from: com.c.a.d.d.a.f.1 */
    static class C11501 extends C1149f {
        C11501() {
        }

        protected int m5644a(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }

        public String m5645a() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }
    }

    /* renamed from: com.c.a.d.d.a.f.2 */
    static class C11512 extends C1149f {
        C11512() {
        }

        protected int m5646a(int i, int i2, int i3, int i4) {
            int i5 = 1;
            int ceil = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            int max = Math.max(1, Integer.highestOneBit(ceil));
            if (max >= ceil) {
                i5 = 0;
            }
            return max << i5;
        }

        public String m5647a() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }
    }

    /* renamed from: com.c.a.d.d.a.f.3 */
    static class C11523 extends C1149f {
        C11523() {
        }

        protected int m5648a(int i, int i2, int i3, int i4) {
            return 0;
        }

        public String m5649a() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }
    }

    static {
        f2947d = EnumSet.of(C1163a.JPEG, C1163a.PNG_A, C1163a.PNG);
        f2948e = C1296h.m6112a(0);
        f2944a = new C11501();
        f2945b = new C11512();
        f2946c = new C11523();
    }

    private int m5632a(int i, int i2, int i3, int i4, int i5) {
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        int a = (i == 90 || i == 270) ? m5641a(i3, i2, i4, i5) : m5641a(i2, i3, i4, i5);
        return Math.max(1, a == 0 ? 0 : Integer.highestOneBit(a));
    }

    private static android.graphics.Bitmap.Config m5633a(java.io.InputStream r6, com.p045c.p046a.p050d.C1012a r7) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0071 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r5 = 5;
        r0 = com.p045c.p046a.p050d.C1012a.ALWAYS_ARGB_8888;
        if (r7 == r0) goto L_0x000f;
    L_0x0005:
        r0 = com.p045c.p046a.p050d.C1012a.PREFER_ARGB_8888;
        if (r7 == r0) goto L_0x000f;
    L_0x0009:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 != r1) goto L_0x0012;
    L_0x000f:
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
    L_0x0011:
        return r0;
    L_0x0012:
        r1 = 0;
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r6.mark(r0);
        r0 = new com.c.a.d.d.a.l;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r0.<init>(r6);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r0 = r0.m5691a();	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r6.reset();	 Catch:{ IOException -> 0x0029 }
    L_0x0024:
        if (r0 == 0) goto L_0x0089;
    L_0x0026:
        r0 = android.graphics.Bitmap.Config.ARGB_8888;
        goto L_0x0011;
    L_0x0029:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0024;
    L_0x0032:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x0024;
    L_0x003a:
        r0 = move-exception;
        r2 = "Downsampler";	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = 5;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r2 = android.util.Log.isLoggable(r2, r3);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        if (r2 == 0) goto L_0x005c;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
    L_0x0044:
        r2 = "Downsampler";	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3.<init>();	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r4 = "Cannot determine whether the image has alpha or not from header for format ";	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = r3.append(r4);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = r3.append(r7);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        r3 = r3.toString();	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
        android.util.Log.w(r2, r3, r0);	 Catch:{ IOException -> 0x003a, all -> 0x0073 }
    L_0x005c:
        r6.reset();
        r0 = r1;
        goto L_0x0024;
    L_0x0061:
        r0 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0071;
    L_0x006a:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r0);
    L_0x0071:
        r0 = r1;
        goto L_0x0024;
    L_0x0073:
        r0 = move-exception;
        r6.reset();	 Catch:{ IOException -> 0x0078 }
    L_0x0077:
        throw r0;
    L_0x0078:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r5);
        if (r2 == 0) goto L_0x0077;
    L_0x0081:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x0077;
    L_0x0089:
        r0 = android.graphics.Bitmap.Config.RGB_565;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.d.d.a.f.a(java.io.InputStream, com.c.a.d.a):android.graphics.Bitmap$Config");
    }

    private Bitmap m5634a(C1293f c1293f, C1170o c1170o, Options options, C1023c c1023c, int i, int i2, int i3, C1012a c1012a) {
        Config a = C1149f.m5633a((InputStream) c1293f, c1012a);
        options.inSampleSize = i3;
        options.inPreferredConfig = a;
        if ((options.inSampleSize == 1 || 19 <= VERSION.SDK_INT) && C1149f.m5637a((InputStream) c1293f)) {
            C1149f.m5636a(options, c1023c.m5343b((int) Math.ceil(((double) i) / ((double) i3)), (int) Math.ceil(((double) i2) / ((double) i3)), a));
        }
        return C1149f.m5638b(c1293f, c1170o, options);
    }

    private static void m5635a(Options options) {
        C1149f.m5640b(options);
        synchronized (f2948e) {
            f2948e.offer(options);
        }
    }

    @TargetApi(11)
    private static void m5636a(Options options, Bitmap bitmap) {
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    private static boolean m5637a(java.io.InputStream r4) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x0046 in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r3 = 5;
        r0 = 19;
        r1 = android.os.Build.VERSION.SDK_INT;
        if (r0 > r1) goto L_0x0009;
    L_0x0007:
        r0 = 1;
    L_0x0008:
        return r0;
    L_0x0009:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r4.mark(r0);
        r0 = new com.c.a.d.d.a.l;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r0.<init>(r4);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r0 = r0.m5692b();	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r1 = f2947d;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r0 = r1.contains(r0);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r4.reset();	 Catch:{ IOException -> 0x0021 }
        goto L_0x0008;
    L_0x0021:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x0008;
    L_0x002a:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x0008;
    L_0x0032:
        r0 = move-exception;
        r1 = "Downsampler";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2 = 5;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r1 = android.util.Log.isLoggable(r1, r2);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        if (r1 == 0) goto L_0x0043;	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
    L_0x003c:
        r1 = "Downsampler";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        r2 = "Cannot determine the image type from header";	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
        android.util.Log.w(r1, r2, r0);	 Catch:{ IOException -> 0x0032, all -> 0x0059 }
    L_0x0043:
        r4.reset();
    L_0x0046:
        r0 = 0;
        goto L_0x0008;
    L_0x0048:
        r0 = move-exception;
        r1 = "Downsampler";
        r1 = android.util.Log.isLoggable(r1, r3);
        if (r1 == 0) goto L_0x0046;
    L_0x0051:
        r1 = "Downsampler";
        r2 = "Cannot reset the input stream";
        android.util.Log.w(r1, r2, r0);
        goto L_0x0046;
    L_0x0059:
        r0 = move-exception;
        r4.reset();	 Catch:{ IOException -> 0x005e }
    L_0x005d:
        throw r0;
    L_0x005e:
        r1 = move-exception;
        r2 = "Downsampler";
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x005d;
    L_0x0067:
        r2 = "Downsampler";
        r3 = "Cannot reset the input stream";
        android.util.Log.w(r2, r3, r1);
        goto L_0x005d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.d.d.a.f.a(java.io.InputStream):boolean");
    }

    private static Bitmap m5638b(C1293f c1293f, C1170o c1170o, Options options) {
        if (options.inJustDecodeBounds) {
            c1293f.mark(5242880);
        } else {
            c1170o.m5703a();
        }
        Bitmap decodeStream = BitmapFactory.decodeStream(c1293f, null, options);
        try {
            if (options.inJustDecodeBounds) {
                c1293f.reset();
            }
        } catch (Throwable e) {
            if (Log.isLoggable("Downsampler", 6)) {
                Log.e("Downsampler", "Exception loading inDecodeBounds=" + options.inJustDecodeBounds + " sample=" + options.inSampleSize, e);
            }
        }
        return decodeStream;
    }

    @TargetApi(11)
    private static synchronized Options m5639b() {
        Options options;
        synchronized (C1149f.class) {
            synchronized (f2948e) {
                options = (Options) f2948e.poll();
            }
            if (options == null) {
                options = new Options();
                C1149f.m5640b(options);
            }
        }
        return options;
    }

    @TargetApi(11)
    private static void m5640b(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }

    protected abstract int m5641a(int i, int i2, int i3, int i4);

    public android.graphics.Bitmap m5642a(java.io.InputStream r21, com.p045c.p046a.p050d.p052b.p054a.C1023c r22, int r23, int r24, com.p045c.p046a.p050d.C1012a r25) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find block by offset: 0x00be in list []
	at jadx.core.utils.BlockUtils.getBlockByOffset(BlockUtils.java:42)
	at jadx.core.dex.instructions.IfNode.initBlocks(IfNode.java:58)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.initBlocksInIfNodes(BlockFinish.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockFinish.visit(BlockFinish.java:33)
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
        r20 = this;
        r16 = com.p045c.p046a.p055j.C1289a.m6092a();
        r17 = r16.m6094b();
        r18 = r16.m6094b();
        r9 = com.p045c.p046a.p050d.p062d.p063a.C1149f.m5639b();
        r8 = new com.c.a.d.d.a.o;
        r0 = r21;
        r1 = r18;
        r8.<init>(r0, r1);
        r19 = com.p045c.p046a.p055j.C1291c.m6097a(r8);
        r10 = new com.c.a.j.f;
        r0 = r19;
        r10.<init>(r0);
        r2 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r0 = r19;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r0.mark(r2);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = 0;
        r2 = new com.c.a.d.d.a.l;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r0 = r19;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r2 = r2.m5693c();	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r19.reset();	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r15 = r2;
    L_0x003b:
        r0 = r17;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r9.inTempStorage = r0;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r0 = r20;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = r0.m5643a(r10, r8, r9);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = 0;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = r2[r3];	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = 1;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = r2[r3];	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = com.p045c.p046a.p050d.p062d.p063a.C1173r.m5711a(r15);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = r20;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r6 = r23;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r7 = r24;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r13 = r2.m5632a(r3, r4, r5, r6, r7);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r6 = r20;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r7 = r10;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r10 = r22;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r11 = r4;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r12 = r5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r14 = r25;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3 = r6.m5634a(r7, r8, r9, r10, r11, r12, r13, r14);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = r19.m6098a();	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r2 == 0) goto L_0x00d8;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x006c:
        r3 = new java.lang.RuntimeException;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        throw r3;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x0072:
        r2 = move-exception;
        r16.m6093a(r17);
        r0 = r16;
        r1 = r18;
        r0.m6093a(r1);
        r19.m6099b();
        com.p045c.p046a.p050d.p062d.p063a.C1149f.m5635a(r9);
        throw r2;
    L_0x0084:
        r3 = move-exception;
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = 5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 == 0) goto L_0x0095;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x008e:
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = "Cannot reset the input stream";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        android.util.Log.w(r4, r5, r3);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x0095:
        r15 = r2;
        goto L_0x003b;
    L_0x0097:
        r2 = move-exception;
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r5 = 5;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        if (r4 == 0) goto L_0x00a8;	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
    L_0x00a1:
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        r5 = "Cannot determine the image orientation from header";	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
        android.util.Log.w(r4, r5, r2);	 Catch:{ IOException -> 0x0097, all -> 0x00c1 }
    L_0x00a8:
        r19.reset();
        r15 = r3;
        goto L_0x003b;
    L_0x00ad:
        r2 = move-exception;
        r4 = "Downsampler";
        r5 = 5;
        r4 = android.util.Log.isLoggable(r4, r5);
        if (r4 == 0) goto L_0x00be;
    L_0x00b7:
        r4 = "Downsampler";
        r5 = "Cannot reset the input stream";
        android.util.Log.w(r4, r5, r2);
    L_0x00be:
        r15 = r3;
        goto L_0x003b;
    L_0x00c1:
        r2 = move-exception;
        r19.reset();	 Catch:{ IOException -> 0x00c6 }
    L_0x00c5:
        throw r2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00c6:
        r3 = move-exception;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = 5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = android.util.Log.isLoggable(r4, r5);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 == 0) goto L_0x00c5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00d0:
        r4 = "Downsampler";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r5 = "Cannot reset the input stream";	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        android.util.Log.w(r4, r5, r3);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        goto L_0x00c5;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00d8:
        r2 = 0;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r3 == 0) goto L_0x00f2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00db:
        r0 = r22;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r2 = com.p045c.p046a.p050d.p062d.p063a.C1173r.m5714a(r3, r0, r15);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = r3.equals(r2);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 != 0) goto L_0x00f2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00e7:
        r0 = r22;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        r4 = r0.m5342a(r3);	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
        if (r4 != 0) goto L_0x00f2;	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00ef:
        r3.recycle();	 Catch:{ IOException -> 0x0084, all -> 0x0072 }
    L_0x00f2:
        r16.m6093a(r17);
        r0 = r16;
        r1 = r18;
        r0.m6093a(r1);
        r19.m6099b();
        com.p045c.p046a.p050d.p062d.p063a.C1149f.m5635a(r9);
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.c.a.d.d.a.f.a(java.io.InputStream, com.c.a.d.b.a.c, int, int, com.c.a.d.a):android.graphics.Bitmap");
    }

    public int[] m5643a(C1293f c1293f, C1170o c1170o, Options options) {
        options.inJustDecodeBounds = true;
        C1149f.m5638b(c1293f, c1170o, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }
}
