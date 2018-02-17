package com.simplemobiletools.gallery.activities;

import android.support.v7.widget.GridLayoutManager;
import com.simplemobiletools.gallery.views.MyScalableRecyclerView.ZoomListener;

public final class MainActivity$handleZooming$1 implements ZoomListener {
    final /* synthetic */ GridLayoutManager $layoutManager;
    final /* synthetic */ MainActivity this$0;

    MainActivity$handleZooming$1(MainActivity mainActivity, GridLayoutManager gridLayoutManager) {
        this.this$0 = mainActivity;
        this.$layoutManager = gridLayoutManager;
    }

    public void zoomIn() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.MainActivity$handleZooming$1.zoomIn():void
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
        r0 = r3.$layoutManager;
        r0 = r0.m3984b();
        r1 = 1;
        if (r0 <= r1) goto L_0x002d;
    L_0x0009:
        r0 = r3.this$0;
        r0 = r0.getMConfig();
        r1 = r3.$layoutManager;
        r2 = r1.m3984b();
        r2 = r2 + -1;
        r1.m3972a(r2);
        r1 = r1.m3984b();
        r0.setDirColumnCnt(r1);
        r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
        r0 = r0.getActMode();
        if (r0 == 0) goto L_0x002c;
    L_0x0029:
        r0.m3116c();
    L_0x002d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.MainActivity$handleZooming$1.zoomIn():void");
    }

    public void zoomOut() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.MainActivity$handleZooming$1.zoomOut():void
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
        r0 = r3.$layoutManager;
        r0 = r0.m3984b();
        r1 = 10;
        if (r0 >= r1) goto L_0x002e;
    L_0x000a:
        r0 = r3.this$0;
        r0 = r0.getMConfig();
        r1 = r3.$layoutManager;
        r2 = r1.m3984b();
        r2 = r2 + 1;
        r1.m3972a(r2);
        r1 = r1.m3984b();
        r0.setDirColumnCnt(r1);
        r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
        r0 = r0.getActMode();
        if (r0 == 0) goto L_0x002d;
    L_0x002a:
        r0.m3116c();
    L_0x002e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.MainActivity$handleZooming$1.zoomOut():void");
    }
}
