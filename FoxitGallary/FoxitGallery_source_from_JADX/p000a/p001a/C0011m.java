package p000a.p001a;

import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.a.m */
class C0011m extends C0010l {
    public static final <T> T m20a(Iterable<? extends T> iterable) {
        C0036f.m62b(iterable, "$receiver");
        if (iterable instanceof List) {
            return C0011m.m26c((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T, C extends Collection<? super T>> C m21a(Iterable<? extends T> iterable, C c) {
        C0036f.m62b(iterable, "$receiver");
        C0036f.m62b(c, "destination");
        for (Object add : iterable) {
            c.add(add);
        }
        return c;
    }

    public static final <T> List<T> m22a(Iterable<? extends T> iterable, Comparator<? super T> comparator) {
        C0036f.m62b(iterable, "$receiver");
        C0036f.m62b(comparator, "comparator");
        if (!(iterable instanceof Collection)) {
            List d = C0011m.m29d((Iterable) iterable);
            C0009k.m16a(d, (Comparator) comparator);
            return d;
        } else if (((Collection) iterable).size() <= 1) {
            return C0011m.m27c((Iterable) iterable);
        } else {
            Collection collection = (Collection) iterable;
            if (collection == null) {
                throw new C0027d("null cannot be cast to non-null type java.util.Collection<T>");
            }
            collection = collection;
            Object[] toArray = collection.toArray(new Object[collection.size()]);
            if (toArray == null) {
                throw new C0027d("null cannot be cast to non-null type kotlin.Array<T>");
            }
            toArray = toArray;
            if (toArray == null) {
                throw new C0027d("null cannot be cast to non-null type kotlin.Array<T>");
            }
            toArray = toArray;
            C0003e.m3a(toArray, (Comparator) comparator);
            return C0003e.m2a(toArray);
        }
    }

    public static final <T> List<T> m23a(Collection<? extends T> collection) {
        C0036f.m62b(collection, "$receiver");
        return new ArrayList(collection);
    }

    public static final <T> T m24b(Iterable<? extends T> iterable) {
        C0036f.m62b(iterable, "$receiver");
        if (iterable instanceof List) {
            return C0011m.m28d((List) iterable);
        }
        Iterator it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            if (!it.hasNext()) {
                return next;
            }
            throw new IllegalArgumentException("Collection has more than one element.");
        }
        throw new NoSuchElementException("Collection is empty.");
    }

    public static final <T> java.util.List<T> m25b(java.lang.Iterable<? extends T> r1, int r2) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: a.a.m.b(java.lang.Iterable, int):java.util.List<T>
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
        r2 = 1;
        r1 = 0;
        r0 = "$receiver";
        p000a.p005e.p007b.C0036f.m62b(r5, r0);
        if (r6 < 0) goto L_0x0032;
    L_0x0009:
        r0 = r2;
        if (r0 != 0) goto L_0x0034;
    L_0x000d:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Requested element count ";
        r0 = r0.append(r1);
        r0 = r0.append(r6);
        r1 = " is less than zero.";
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = new java.lang.IllegalArgumentException;
        r1 = r1.toString();
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x0032:
        r0 = r1;
        goto L_0x000a;
    L_0x0034:
        if (r6 != 0) goto L_0x003b;
        r0 = p000a.p001a.C0006h.m10a();
        return r0;
        r0 = r5 instanceof java.util.Collection;
        if (r0 == 0) goto L_0x0058;
        r0 = r5;
        r0 = (java.util.Collection) r0;
        r0 = r0.size();
        if (r6 < r0) goto L_0x004d;
        r0 = p000a.p001a.C0011m.m27c(r5);
        goto L_0x003a;
        if (r6 != r2) goto L_0x0058;
        r0 = p000a.p001a.C0011m.m20a(r5);
        r0 = p000a.p001a.C0006h.m11a(r0);
        goto L_0x003a;
        r0 = new java.util.ArrayList;
        r0.<init>(r6);
        r3 = r5.iterator();
        r2 = r3.hasNext();
        if (r2 == 0) goto L_0x006f;
        r4 = r3.next();
        r2 = r1 + 1;
        if (r1 != r6) goto L_0x0076;
        r0 = (java.util.List) r0;
        r0 = p000a.p001a.C0006h.m12a(r0);
        goto L_0x003a;
        r0.add(r4);
        r1 = r2;
        goto L_0x0061;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.a.m.b(java.lang.Iterable, int):java.util.List<T>");
    }

    public static final <T> T m26c(List<? extends T> list) {
        C0036f.m62b(list, "$receiver");
        if (!list.isEmpty()) {
            return list.get(0);
        }
        throw new NoSuchElementException("List is empty.");
    }

    public static final <T> List<T> m27c(Iterable<? extends T> iterable) {
        C0036f.m62b(iterable, "$receiver");
        if (!(iterable instanceof Collection)) {
            return C0006h.m12a(C0011m.m29d((Iterable) iterable));
        }
        switch (((Collection) iterable).size()) {
            case C1373c.View_android_theme /*0*/:
                return C0006h.m10a();
            case C1373c.View_android_focusable /*1*/:
                return C0006h.m11a(iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next());
            default:
                return C0011m.m23a((Collection) iterable);
        }
    }

    public static final <T> T m28d(List<? extends T> list) {
        C0036f.m62b(list, "$receiver");
        switch (list.size()) {
            case C1373c.View_android_theme /*0*/:
                throw new NoSuchElementException("List is empty.");
            case C1373c.View_android_focusable /*1*/:
                return list.get(0);
            default:
                throw new IllegalArgumentException("List has more than one element.");
        }
    }

    public static final <T> List<T> m29d(Iterable<? extends T> iterable) {
        C0036f.m62b(iterable, "$receiver");
        return iterable instanceof Collection ? C0011m.m23a((Collection) iterable) : (List) C0011m.m21a((Iterable) iterable, (Collection) new ArrayList());
    }

    public static final <T> void m30e(List<T> list) {
        C0036f.m62b(list, "$receiver");
        Collections.reverse(list);
    }
}
