package com.simplemobiletools.gallery.adapters;

import com.simplemobiletools.filepicker.extensions.ContextKt;
import java.util.ArrayList;
import p000a.C0055f;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class DirectoryAdapter$renameDir$1 extends C0037g implements C0029b<ArrayList<String>, C0055f> {
    final /* synthetic */ DirectoryAdapter this$0;

    /* renamed from: com.simplemobiletools.gallery.adapters.DirectoryAdapter.renameDir.1.1 */
    static final class C13371 extends C0037g implements C0028a<C0055f> {
        final /* synthetic */ DirectoryAdapter$renameDir$1 this$0;

        /* renamed from: com.simplemobiletools.gallery.adapters.DirectoryAdapter.renameDir.1.1.1 */
        static final class C13361 implements Runnable {
            final /* synthetic */ C13371 this$0;

            C13361(C13371 c13371) {
                this.this$0 = c13371;
            }

            public final void run() {
                /* JADX: method processing error */
/*
                Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter.renameDir.1.1.1.run():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:263)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:263)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
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
                r0 = this;
                r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
                r0 = r0.getActMode();
                if (r0 == 0) goto L_0x000b;
            L_0x0008:
                r0.m3116c();
                r0 = r5.this$0;
                r0 = r0.this$0;
                r0 = r0.this$0;
                r0 = r0.getListener();
                if (r0 == 0) goto L_0x001b;
                r0.refreshItems();
                r0 = r5.this$0;
                r0 = r0.this$0;
                r0 = r0.this$0;
                r0 = r0.getActivity();
                r0 = (android.content.Context) r0;
                r1 = 2131099755; // 0x7f06006b float:1.7811872E38 double:1.052903177E-314;
                r2 = 0;
                r3 = 2;
                r4 = 0;
                com.simplemobiletools.filepicker.extensions.ContextKt.toast$default(r0, r1, r2, r3, r4);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter.renameDir.1.1.1.run():void");
            }
        }

        C13371(DirectoryAdapter$renameDir$1 directoryAdapter$renameDir$1) {
            this.this$0 = directoryAdapter$renameDir$1;
            super(0);
        }

        public final void invoke() {
            this.this$0.this$0.getActivity().runOnUiThread(new C13361(this));
        }
    }

    DirectoryAdapter$renameDir$1(DirectoryAdapter directoryAdapter) {
        this.this$0 = directoryAdapter;
        super(1);
    }

    public final void invoke(ArrayList<String> arrayList) {
        C0036f.m62b(arrayList, "it");
        ContextKt.scanPaths(this.this$0.getActivity(), arrayList, new C13371(this));
    }
}
