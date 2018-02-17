package com.simplemobiletools.gallery.adapters;

import android.content.Context;
import com.simplemobiletools.filepicker.asynctasks.CopyMoveTask.CopyMoveListener;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.C1333R;

public final class DirectoryAdapter$displayCopyDialog$2 implements CopyMoveListener {
    final /* synthetic */ DirectoryAdapter this$0;

    DirectoryAdapter$displayCopyDialog$2(DirectoryAdapter directoryAdapter) {
        this.this$0 = directoryAdapter;
    }

    public void copyFailed() {
        ContextKt.toast$default((Context) this.this$0.getActivity(), (int) C1333R.string.copy_move_failed, 0, 2, null);
    }

    public void copySucceeded(boolean r1, boolean r2) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter$displayCopyDialog$2.copySucceeded(boolean, boolean):void
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
        r4 = 0;
        r3 = 2;
        r2 = 0;
        if (r6 == 0) goto L_0x0032;
    L_0x0005:
        r0 = r5.this$0;
        r0 = r0.getActivity();
        r0 = (android.content.Context) r0;
        if (r7 == 0) goto L_0x002e;
    L_0x000f:
        r1 = 2131099730; // 0x7f060052 float:1.7811821E38 double:1.0529031645E-314;
        com.simplemobiletools.filepicker.extensions.ContextKt.toast$default(r0, r1, r2, r3, r4);
        r0 = r5.this$0;
        r0 = r0.getListener();
        if (r0 == 0) goto L_0x0020;
    L_0x001d:
        r0.refreshItems();
        r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
        r0 = r0.getActMode();
        if (r0 == 0) goto L_0x002c;
        r0.m3116c();
        return;
    L_0x002e:
        r1 = 2131099731; // 0x7f060053 float:1.7811823E38 double:1.052903165E-314;
        goto L_0x0012;
    L_0x0032:
        r0 = r5.this$0;
        r0 = r0.getActivity();
        r0 = (android.content.Context) r0;
        if (r7 == 0) goto L_0x0043;
        r1 = 2131099685; // 0x7f060025 float:1.781173E38 double:1.052903142E-314;
        com.simplemobiletools.filepicker.extensions.ContextKt.toast$default(r0, r1, r2, r3, r4);
        goto L_0x0015;
        r1 = 2131099686; // 0x7f060026 float:1.7811732E38 double:1.0529031427E-314;
        goto L_0x003f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter$displayCopyDialog$2.copySucceeded(boolean, boolean):void");
    }
}
