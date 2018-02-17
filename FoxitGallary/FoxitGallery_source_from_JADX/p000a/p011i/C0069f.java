package p000a.p011i;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;
import java.util.regex.Pattern;
import p000a.p001a.C0009k;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0071g.C0070a;

/* renamed from: a.i.f */
public final class C0069f {
    public static final C0068a f39a;
    private final Set<C0072h> f40b;
    private final Pattern f41c;

    /* renamed from: a.i.f.a */
    public static final class C0068a {
        private C0068a() {
        }
    }

    static {
        f39a = new C0068a();
    }

    public C0069f(String str) {
        C0036f.m62b(str, "pattern");
        Pattern compile = Pattern.compile(str);
        C0036f.m59a((Object) compile, "Pattern.compile(pattern)");
        this(compile);
    }

    public C0069f(Pattern pattern) {
        C0036f.m62b(pattern, "nativePattern");
        this.f41c = pattern;
        int flags = this.f41c.flags();
        EnumSet allOf = EnumSet.allOf(C0072h.class);
        C0009k.m17a((Iterable) allOf, (C0029b) new C0070a(flags));
        Object unmodifiableSet = Collections.unmodifiableSet(allOf);
        C0036f.m59a(unmodifiableSet, "Collections.unmodifiable\u2026 == it.value }\n        })");
        this.f40b = unmodifiableSet;
    }

    public final java.util.List<java.lang.String> m94a(java.lang.CharSequence r1, int r2) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: a.i.f.a(java.lang.CharSequence, int):java.util.List<java.lang.String>
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
        r0 = this;
        r0 = "input";
        p000a.p005e.p007b.C0036f.m62b(r3, r0);
        if (r4 < 0) goto L_0x0030;
    L_0x0007:
        r0 = 1;
        if (r0 != 0) goto L_0x0032;
    L_0x000b:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Limit must be non-negative, but was ";
        r0 = r0.append(r1);
        r0 = r0.append(r4);
        r1 = ".";
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = new java.lang.IllegalArgumentException;
        r1 = r1.toString();
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x0030:
        r0 = 0;
        goto L_0x0008;
    L_0x0032:
        r0 = r2.f41c;
        if (r4 != 0) goto L_0x0037;
        r4 = -1;
        r0 = r0.split(r3, r4);
        r0 = (java.lang.Object[]) r0;
        r0 = p000a.p001a.C0003e.m2a(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.f.a(java.lang.CharSequence, int):java.util.List<java.lang.String>");
    }

    public String toString() {
        Object pattern = this.f41c.toString();
        C0036f.m59a(pattern, "nativePattern.toString()");
        return pattern;
    }
}
