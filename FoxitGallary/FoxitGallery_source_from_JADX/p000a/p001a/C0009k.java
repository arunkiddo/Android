package p000a.p001a;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.a.k */
class C0009k extends C0008j {
    public static final <T> void m16a(List<T> list, Comparator<? super T> comparator) {
        C0036f.m62b(list, "$receiver");
        C0036f.m62b(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }

    public static final <T> boolean m17a(Iterable<? extends T> iterable, C0029b<? super T, Boolean> c0029b) {
        C0036f.m62b(iterable, "$receiver");
        C0036f.m62b(c0029b, "predicate");
        return C0009k.m18a(iterable, c0029b, false);
    }

    private static final <T> boolean m18a(java.lang.Iterable<? extends T> r1, p000a.p005e.p006a.C0029b<? super T, java.lang.Boolean> r2, boolean r3) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: a.a.k.a(java.lang.Iterable, a.e.a.b, boolean):boolean
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 5 more
*/
        /*
        r2 = new a.e.b.h$a;
        r2.<init>();
        r0 = 0;
        r2.f10a = r0;
        r0 = r3.iterator();
        r0 = (java.util.Iterator) r0;
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x002c;
    L_0x0015:
        r1 = r0.next();
        r1 = r4.invoke(r1);
        r1 = (java.lang.Boolean) r1;
        r1 = r1.booleanValue();
        if (r1 != r5) goto L_0x000f;
        r0.remove();
        r1 = 1;
        r2.f10a = r1;
        goto L_0x000f;
        r0 = r2.f10a;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.k.a(java.lang.Iterable, a.e.a.b, boolean):boolean");
    }

    public static final <T extends Comparable<? super T>> void m19b(List<T> list) {
        C0036f.m62b(list, "$receiver");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }
}
