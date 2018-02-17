package com.simplemobiletools.gallery.extensions;

import android.content.Context;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0078o;

public final class ContextKt {
    public static final String getHumanizedFilename(Context context, String str) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(str, "path");
        String humanizePath = com.simplemobiletools.filepicker.extensions.ContextKt.humanizePath(context, str);
        int b = C0078o.m130b((CharSequence) humanizePath, "/", 0, false, 6, null) + 1;
        if (humanizePath == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object substring = humanizePath.substring(b);
        C0036f.m59a(substring, "(this as java.lang.String).substring(startIndex)");
        return substring;
    }

    public static final java.lang.String getRealPathFromURI(android.content.Context r1, android.net.Uri r2) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.extensions.ContextKt.getRealPathFromURI(android.content.Context, android.net.Uri):java.lang.String
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
        r1 = 0;
        r2 = "$receiver";
        p000a.p005e.p007b.C0036f.m62b(r8, r2);
        r2 = "uri";
        p000a.p005e.p007b.C0036f.m62b(r9, r2);
        r7 = r1;
        r7 = (android.database.Cursor) r7;
        r1 = 1;
        r1 = new java.lang.String[r1];	 Catch:{ all -> 0x0053 }
        r2 = 0;	 Catch:{ all -> 0x0053 }
        r3 = android.provider.MediaStore.Images.Media.DATA;	 Catch:{ all -> 0x0053 }
        r1[r2] = r3;	 Catch:{ all -> 0x0053 }
        r1 = (java.lang.Object[]) r1;	 Catch:{ all -> 0x0053 }
        r0 = r1;	 Catch:{ all -> 0x0053 }
        r0 = (java.lang.String[]) r0;	 Catch:{ all -> 0x0053 }
        r3 = r0;	 Catch:{ all -> 0x0053 }
        r1 = r8.getContentResolver();	 Catch:{ all -> 0x0053 }
        r4 = 0;	 Catch:{ all -> 0x0053 }
        r4 = (java.lang.String) r4;	 Catch:{ all -> 0x0053 }
        r5 = 0;	 Catch:{ all -> 0x0053 }
        r5 = (java.lang.String[]) r5;	 Catch:{ all -> 0x0053 }
        r6 = 0;	 Catch:{ all -> 0x0053 }
        r6 = (java.lang.String) r6;	 Catch:{ all -> 0x0053 }
        r2 = r9;	 Catch:{ all -> 0x0053 }
        r7 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x0053 }
        if (r7 == 0) goto L_0x0049;	 Catch:{ all -> 0x0053 }
    L_0x0032:
        r1 = r7.moveToFirst();	 Catch:{ all -> 0x0053 }
        if (r1 == 0) goto L_0x0049;	 Catch:{ all -> 0x0053 }
    L_0x0038:
        r1 = android.provider.MediaStore.Images.Media.DATA;	 Catch:{ all -> 0x0053 }
        r1 = r7.getColumnIndexOrThrow(r1);	 Catch:{ all -> 0x0053 }
        r1 = r7.getString(r1);	 Catch:{ all -> 0x0053 }
        if (r7 == 0) goto L_0x0047;
    L_0x0044:
        r7.close();
        return r1;
    L_0x0049:
        r1 = 0;
        r1 = (java.lang.String) r1;	 Catch:{ all -> 0x0053 }
        if (r7 == 0) goto L_0x0051;
        r7.close();
        goto L_0x0048;
    L_0x0053:
        r1 = move-exception;
        if (r7 == 0) goto L_0x0059;
        r7.close();
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.extensions.ContextKt.getRealPathFromURI(android.content.Context, android.net.Uri):java.lang.String");
    }
}
