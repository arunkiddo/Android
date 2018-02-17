package com.simplemobiletools.gallery.adapters;

import java.io.File;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0037g;

final class MediaAdapter$renameFile$1 extends C0037g implements C0029b<File, C0055f> {
    final /* synthetic */ MediaAdapter this$0;

    /* renamed from: com.simplemobiletools.gallery.adapters.MediaAdapter.renameFile.1.1 */
    static final class C13381 implements Runnable {
        public static final C13381 INSTANCE;

        static {
            INSTANCE = new C13381();
        }

        C13381() {
        }

        public final void run() {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.MediaAdapter.renameFile.1.1.run():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:263)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 6 more
*/
            /*
            r0 = this;
            r0 = com.simplemobiletools.gallery.adapters.MediaAdapter.Companion;
            r0 = r0.getActMode();
            if (r0 == 0) goto L_0x000b;
        L_0x0008:
            r0.m3116c();
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.MediaAdapter.renameFile.1.1.run():void");
        }
    }

    MediaAdapter$renameFile$1(MediaAdapter mediaAdapter) {
        this.this$0 = mediaAdapter;
        super(1);
    }

    public final void invoke(java.io.File r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.MediaAdapter$renameFile$1.invoke(java.io.File):void
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
        r0 = this;
        r0 = "it";
        p000a.p005e.p007b.C0036f.m62b(r3, r0);
        r0 = r2.this$0;
        r0 = r0.getListener();
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        r0.refreshItems();
        r0 = r2.this$0;
        r1 = r0.getActivity();
        r0 = com.simplemobiletools.gallery.adapters.MediaAdapter$renameFile$1.C13381.INSTANCE;
        r0 = (java.lang.Runnable) r0;
        r1.runOnUiThread(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.MediaAdapter$renameFile$1.invoke(java.io.File):void");
    }
}
