package com.simplemobiletools.filepicker.extensions;

import android.content.Context;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0077n;
import p000a.p011i.C0078o;

public final class StringKt {
    public static final String getBasePath(String str, Context context) {
        C0036f.m62b(str, "$receiver");
        C0036f.m62b(context, "context");
        if (C0077n.m102a(str, ContextKt.getInternalStoragePath(context), false, 2, null)) {
            return ContextKt.getInternalStoragePath(context);
        }
        return ((((CharSequence) ContextKt.getSDCardPath(context)).length() == 0) || !C0077n.m102a(str, ContextKt.getSDCardPath(context), false, 2, null)) ? "/" : ContextKt.getSDCardPath(context);
    }

    public static final String getFilenameExtension(String str) {
        C0036f.m62b(str, "$receiver");
        int b = C0078o.m130b((CharSequence) str, ".", 0, false, 6, null) + 1;
        if (str == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object substring = str.substring(b);
        C0036f.m59a(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final String getFilenameFromPath(String str) {
        C0036f.m62b(str, "$receiver");
        int b = C0078o.m130b((CharSequence) str, "/", 0, false, 6, null) + 1;
        if (str == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object substring = str.substring(b);
        C0036f.m59a(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final boolean isAValidFilename(java.lang.String r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.filepicker.extensions.StringKt.isAValidFilename(java.lang.String):boolean
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 7 more
*/
        /*
        r2 = 0;
        r0 = "$receiver";
        p000a.p005e.p007b.C0036f.m62b(r7, r0);
        r0 = 14;
        r3 = new char[r0];
        r3 = {47, 10, 13, 9, 0, 96, 63, 42, 92, 60, 62, 124, 34, 58};
        r1 = r2;
        r0 = r3.length;
        if (r1 >= r0) goto L_0x0025;
    L_0x0012:
        r4 = r3[r1];
        r0 = r7;
        r0 = (java.lang.CharSequence) r0;
        r5 = 2;
        r6 = 0;
        r0 = p000a.p011i.C0078o.m135b(r0, r4, r2, r5, r6);
        if (r0 == 0) goto L_0x0020;
    L_0x001f:
        return r2;
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x000f;
    L_0x0025:
        r2 = 1;
        goto L_0x001f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.filepicker.extensions.StringKt.isAValidFilename(java.lang.String):boolean");
    }
}
