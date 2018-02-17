package com.simplemobiletools.gallery.adapters;

import android.support.v7.view.C0716b;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.p040a.p041a.p042a.C0965a;
import com.p040a.p041a.p042a.C0966b;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
import p000a.p005e.p007b.C0036f;

public final class DirectoryAdapter$multiSelectorMode$1 extends C0965a {
    final /* synthetic */ DirectoryAdapter this$0;

    DirectoryAdapter$multiSelectorMode$1(DirectoryAdapter directoryAdapter, C0966b c0966b) {
        this.this$0 = directoryAdapter;
        super(c0966b);
    }

    public final void checkHideBtnVisibility(android.view.Menu r1, java.util.List<java.lang.Integer> r2) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter$multiSelectorMode$1.checkHideBtnVisibility(android.view.Menu, java.util.List):void
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
        r2 = 1;
        r3 = 0;
        r0 = "menu";
        p000a.p005e.p007b.C0036f.m62b(r9, r0);
        r0 = "positions";
        p000a.p005e.p007b.C0036f.m62b(r10, r0);
        r4 = new a.e.b.h$b;
        r4.<init>();
        r4.f11a = r3;
        r5 = new a.e.b.h$b;
        r5.<init>();
        r5.f11a = r3;
        r10 = (java.lang.Iterable) r10;
        r0 = new java.util.ArrayList;
        r1 = 10;
        r1 = p000a.p001a.C0007i.m15a(r10, r1);
        r0.<init>(r1);
        r0 = (java.util.Collection) r0;
        r6 = r10.iterator();
    L_0x002f:
        r1 = r6.hasNext();
        if (r1 == 0) goto L_0x0053;
    L_0x0035:
        r1 = r6.next();
        r1 = (java.lang.Number) r1;
        r1 = r1.intValue();
        r7 = r8.this$0;
        r7 = r7.getDirs();
        r1 = r7.get(r1);
        r1 = (com.simplemobiletools.gallery.models.Directory) r1;
        r1 = r1.getPath();
        r0.add(r1);
        goto L_0x002f;
    L_0x0053:
        r0 = (java.util.List) r0;
        r0 = (java.lang.Iterable) r0;
        r1 = r0.iterator();
    L_0x005c:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0083;
    L_0x0062:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r6 = r8.this$0;
        r6 = r6.getConfig();
        r0 = r6.getIsFolderHidden(r0);
        if (r0 == 0) goto L_0x007c;
    L_0x0074:
        r0 = r4.f11a;
        r0 = r0 + 1;
        r4.f11a = r0;
        goto L_0x005c;
    L_0x007c:
        r0 = r5.f11a;
        r0 = r0 + 1;
        r5.f11a = r0;
        goto L_0x007a;
    L_0x0083:
        r0 = 2131624208; // 0x7f0e0110 float:1.887559E38 double:1.053162291E-314;
        r1 = r9.findItem(r0);
        r0 = r5.f11a;
        if (r0 <= 0) goto L_0x00a1;
        r0 = r2;
        r1.setVisible(r0);
        r0 = 2131624209; // 0x7f0e0111 float:1.8875591E38 double:1.0531622915E-314;
        r0 = r9.findItem(r0);
        r1 = r4.f11a;
        if (r1 <= 0) goto L_0x00a3;
        r0.setVisible(r2);
        return;
        r0 = r3;
        goto L_0x008f;
        r2 = r3;
        goto L_0x009d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter$multiSelectorMode$1.checkHideBtnVisibility(android.view.Menu, java.util.List):void");
    }

    public final void checkPinBtnVisibility(android.view.Menu r1, java.util.List<java.lang.Integer> r2) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter$multiSelectorMode$1.checkPinBtnVisibility(android.view.Menu, java.util.List):void
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
        r2 = 1;
        r3 = 0;
        r0 = "menu";
        p000a.p005e.p007b.C0036f.m62b(r10, r0);
        r0 = "positions";
        p000a.p005e.p007b.C0036f.m62b(r11, r0);
        r0 = r9.this$0;
        r0 = r0.getConfig();
        r4 = r0.getPinnedFolders();
        r5 = new a.e.b.h$b;
        r5.<init>();
        r5.f11a = r3;
        r6 = new a.e.b.h$b;
        r6.<init>();
        r6.f11a = r3;
        r11 = (java.lang.Iterable) r11;
        r0 = new java.util.ArrayList;
        r1 = 10;
        r1 = p000a.p001a.C0007i.m15a(r11, r1);
        r0.<init>(r1);
        r0 = (java.util.Collection) r0;
        r7 = r11.iterator();
    L_0x0039:
        r1 = r7.hasNext();
        if (r1 == 0) goto L_0x005d;
    L_0x003f:
        r1 = r7.next();
        r1 = (java.lang.Number) r1;
        r1 = r1.intValue();
        r8 = r9.this$0;
        r8 = r8.getDirs();
        r1 = r8.get(r1);
        r1 = (com.simplemobiletools.gallery.models.Directory) r1;
        r1 = r1.getPath();
        r0.add(r1);
        goto L_0x0039;
    L_0x005d:
        r0 = (java.util.List) r0;
        r0 = (java.lang.Iterable) r0;
        r1 = r0.iterator();
    L_0x0066:
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0087;
    L_0x006c:
        r0 = r1.next();
        r0 = (java.lang.String) r0;
        r0 = r4.contains(r0);
        if (r0 == 0) goto L_0x0080;
    L_0x0078:
        r0 = r5.f11a;
        r0 = r0 + 1;
        r5.f11a = r0;
        goto L_0x0066;
    L_0x0080:
        r0 = r6.f11a;
        r0 = r0 + 1;
        r6.f11a = r0;
        goto L_0x007e;
    L_0x0087:
        r0 = 2131624205; // 0x7f0e010d float:1.8875583E38 double:1.0531622895E-314;
        r1 = r10.findItem(r0);
        r0 = r6.f11a;
        if (r0 <= 0) goto L_0x00a5;
        r0 = r2;
        r1.setVisible(r0);
        r0 = 2131624206; // 0x7f0e010e float:1.8875585E38 double:1.05316229E-314;
        r0 = r10.findItem(r0);
        r1 = r5.f11a;
        if (r1 <= 0) goto L_0x00a7;
        r0.setVisible(r2);
        return;
        r0 = r3;
        goto L_0x0093;
        r2 = r3;
        goto L_0x00a1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter$multiSelectorMode$1.checkPinBtnVisibility(android.view.Menu, java.util.List):void");
    }

    public boolean onActionItemClicked(C0716b c0716b, MenuItem menuItem) {
        C0036f.m62b(c0716b, "mode");
        C0036f.m62b(menuItem, "item");
        switch (menuItem.getItemId()) {
            case C1333R.id.cab_properties /*2131624204*/:
                this.this$0.showProperties();
                return true;
            case C1333R.id.cab_pin /*2131624205*/:
                this.this$0.pinFolder();
                c0716b.m3116c();
                return true;
            case C1333R.id.cab_unpin /*2131624206*/:
                this.this$0.unpinFolder();
                c0716b.m3116c();
                return true;
            case C1333R.id.cab_rename /*2131624207*/:
                this.this$0.renameDir();
                return true;
            case C1333R.id.cab_hide /*2131624208*/:
                this.this$0.hideFolders();
                c0716b.m3116c();
                return true;
            case C1333R.id.cab_unhide /*2131624209*/:
                this.this$0.unhideFolders();
                c0716b.m3116c();
                return true;
            case C1333R.id.cab_copy_move /*2131624210*/:
                this.this$0.displayCopyDialog();
                return true;
            case C1333R.id.cab_delete /*2131624211*/:
                this.this$0.askConfirmDelete();
                return true;
            default:
                return false;
        }
    }

    public boolean onCreateActionMode(C0716b c0716b, Menu menu) {
        super.onCreateActionMode(c0716b, menu);
        DirectoryAdapter.Companion.setActMode(c0716b);
        this.this$0.getActivity().getMenuInflater().inflate(C1333R.menu.cab_directories, menu);
        return true;
    }

    public void onDestroyActionMode(C0716b c0716b) {
        super.onDestroyActionMode(c0716b);
        for (View toggleItemSelection$default : this.this$0.getViews()) {
            Companion.toggleItemSelection$default(DirectoryAdapter.Companion, toggleItemSelection$default, false, 0, 4, null);
        }
        DirectoryAdapter.Companion.getMarkedItems().clear();
    }

    public boolean onPrepareActionMode(C0716b c0716b, Menu menu) {
        C0036f.m62b(menu, "menu");
        Object c = getMultiSelector().m5050c();
        menu.findItem(C1333R.id.cab_rename).setVisible(c.size() <= 1);
        C0036f.m59a(c, "positions");
        checkHideBtnVisibility(menu, c);
        C0036f.m59a(c, "positions");
        checkPinBtnVisibility(menu, c);
        return true;
    }
}
