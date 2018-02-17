package com.simplemobiletools.gallery.adapters;

import android.view.View.OnLongClickListener;
import com.p040a.p041a.p042a.C0965a;
import com.p040a.p041a.p042a.C0966b;
import com.simplemobiletools.gallery.activities.SimpleActivity;
import com.simplemobiletools.gallery.adapters.DirectoryAdapter.ViewHolder;

final class DirectoryAdapter$ViewHolder$bindView$2 implements OnLongClickListener {
    final /* synthetic */ SimpleActivity $activity;
    final /* synthetic */ C0966b $multiSelector;
    final /* synthetic */ C0965a $multiSelectorCallback;
    final /* synthetic */ int $pos;
    final /* synthetic */ ViewHolder this$0;

    DirectoryAdapter$ViewHolder$bindView$2(ViewHolder viewHolder, C0966b c0966b, SimpleActivity simpleActivity, C0965a c0965a, int i) {
        this.this$0 = viewHolder;
        this.$multiSelector = c0966b;
        this.$activity = simpleActivity;
        this.$multiSelectorCallback = c0965a;
        this.$pos = i;
    }

    public final boolean onLongClick(android.view.View r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter$ViewHolder$bindView$2.onLongClick(android.view.View):boolean
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
        r3 = 1;
        r0 = r4.$multiSelector;
        r0 = r0.m5048a();
        if (r0 != 0) goto L_0x0052;
    L_0x0009:
        r1 = r4.$activity;
        r0 = r4.$multiSelectorCallback;
        r0 = (android.support.v7.view.C0716b.C0694a) r0;
        r1.startSupportActionMode(r0);
        r1 = r4.$multiSelector;
        r0 = r4.this$0;
        r0 = (com.p040a.p041a.p042a.C0967e) r0;
        r1.m5046a(r0, r3);
        r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
        r1 = r0.getActMode();
        if (r1 == 0) goto L_0x0036;
    L_0x0023:
        r0 = r4.$multiSelector;
        r0 = r0.m5050c();
        r0 = r0.size();
        r0 = java.lang.String.valueOf(r0);
        r0 = (java.lang.CharSequence) r0;
        r1.m3115b(r0);
    L_0x0036:
        r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
        r1 = r4.this$0;
        r1 = r1.itemView;
        r2 = "itemView";
        p000a.p005e.p007b.C0036f.m59a(r1, r2);
        r2 = r4.$pos;
        r0.toggleItemSelection(r1, r3, r2);
        r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
        r0 = r0.getActMode();
        if (r0 == 0) goto L_0x0051;
    L_0x004e:
        r0.m3117d();
    L_0x0052:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter$ViewHolder$bindView$2.onLongClick(android.view.View):boolean");
    }
}
