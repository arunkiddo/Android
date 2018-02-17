package p000a.p002b;

import java.util.Arrays;
import java.util.Comparator;
import p000a.C0027d;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.b.a */
public final class C0018a {

    /* renamed from: a.b.a.a */
    public static final class C0017a implements Comparator<T> {
        final /* synthetic */ C0029b[] f4a;

        C0017a(C0029b[] c0029bArr) {
            this.f4a = c0029bArr;
        }

        public int compare(T t, T t2) {
            C0029b[] c0029bArr = this.f4a;
            return C0018a.m41a(t, t2, (C0029b[]) Arrays.copyOf(c0029bArr, c0029bArr.length));
        }
    }

    public static final <T extends Comparable<?>> int m40a(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        if (t != null) {
            return ((Comparable) t).compareTo(t2);
        }
        throw new C0027d("null cannot be cast to non-null type kotlin.Comparable<kotlin.Any>");
    }

    public static final <T> int m41a(T r1, T r2, p000a.p005e.p006a.C0029b<? super T, ? extends java.lang.Comparable<?>>... r3) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: a.b.a.a(java.lang.Object, java.lang.Object, a.e.a.b[]):int
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:357)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 5 more
*/
        /*
        r3 = 0;
        r0 = "selectors";
        p000a.p005e.p007b.C0036f.m62b(r6, r0);
        r0 = r6;
        r0 = (java.lang.Object[]) r0;
        r0 = r0.length;
        if (r0 <= 0) goto L_0x001f;
    L_0x000c:
        r0 = 1;
        if (r0 != 0) goto L_0x0021;
    L_0x0011:
        r1 = "Failed requirement.";
        r0 = new java.lang.IllegalArgumentException;
        r1 = r1.toString();
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x001f:
        r0 = r3;
        goto L_0x000d;
    L_0x0021:
        r2 = r3;
        r0 = r6.length;
        if (r2 >= r0) goto L_0x003a;
        r1 = r6[r2];
        r0 = r1.invoke(r4);
        r0 = (java.lang.Comparable) r0;
        r1 = r1.invoke(r5);
        r1 = (java.lang.Comparable) r1;
        r0 = p000a.p002b.C0018a.m40a(r0, r1);
        if (r0 == 0) goto L_0x003b;
        r3 = r0;
        return r3;
        r0 = r2 + 1;
        r2 = r0;
        goto L_0x0022;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.a.a(java.lang.Object, java.lang.Object, a.e.a.b[]):int");
    }

    public static final <T> Comparator<T> m42a(C0029b<? super T, ? extends Comparable<?>>... c0029bArr) {
        C0036f.m62b(c0029bArr, "selectors");
        return new C0017a(c0029bArr);
    }
}
