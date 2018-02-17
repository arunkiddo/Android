package com.simplemobiletools.gallery.adapters;

import android.os.Bundle;
import android.support.v4.p021b.C0274o;
import android.support.v4.p021b.C0282t;
import android.support.v4.p021b.C0295y;
import android.util.SparseArray;
import com.simplemobiletools.gallery.activities.ViewPagerActivity;
import com.simplemobiletools.gallery.fragments.PhotoFragment;
import com.simplemobiletools.gallery.fragments.VideoFragment;
import com.simplemobiletools.gallery.fragments.ViewPagerFragment;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import com.simplemobiletools.gallery.models.Medium;
import java.util.List;
import p000a.p005e.p007b.C0036f;

public final class MyPagerAdapter extends C0295y {
    private final ViewPagerActivity activity;
    private final SparseArray<ViewPagerFragment> mFragments;
    private final List<Medium> media;

    public MyPagerAdapter(ViewPagerActivity viewPagerActivity, C0282t c0282t, List<Medium> list) {
        C0036f.m62b(viewPagerActivity, "activity");
        C0036f.m62b(c0282t, "fm");
        C0036f.m62b(list, "media");
        super(c0282t);
        this.activity = viewPagerActivity;
        this.media = list;
        this.mFragments = new SparseArray();
    }

    public final ViewPagerActivity getActivity() {
        return this.activity;
    }

    public int getCount() {
        return this.media.size();
    }

    public C0274o getItem(int i) {
        Medium medium = (Medium) this.media.get(i);
        Bundle bundle = new Bundle();
        bundle.putSerializable(ConstantsKt.getMEDIUM(), medium);
        ViewPagerFragment videoFragment = medium.isVideo() ? new VideoFragment() : new PhotoFragment();
        this.mFragments.put(i, videoFragment);
        videoFragment.setArguments(bundle);
        videoFragment.setListener(this.activity);
        return videoFragment;
    }

    public int getItemPosition(Object obj) {
        return -2;
    }

    public final List<Medium> getMedia() {
        return this.media;
    }

    public final void itemDragged(int r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.MyPagerAdapter.itemDragged(int):void
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
        r0 = r1.mFragments;
        r0 = r0.get(r2);
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment) r0;
        if (r0 == 0) goto L_0x000d;
    L_0x000a:
        r0.itemDragged();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.MyPagerAdapter.itemDragged(int):void");
    }

    public final void updateItems(int r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.MyPagerAdapter.updateItems(int):void
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
        r1 = -1;
        r0 = new a.f.c;
        r2 = 1;
        r0.<init>(r1, r2);
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r2 = 10;
        r2 = p000a.p001a.C0007i.m15a(r0, r2);
        r1.<init>(r2);
        r1 = (java.util.Collection) r1;
        r2 = r0.iterator();
    L_0x001c:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0036;
    L_0x0022:
        r0 = r2;
        r0 = (p000a.p001a.C0015p) r0;
        r0 = r0.m39b();
        r3 = r4.mFragments;
        r0 = r0 + r5;
        r0 = r3.get(r0);
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment) r0;
        r1.add(r0);
        goto L_0x001c;
    L_0x0036:
        r1 = (java.util.List) r1;
        r1 = (java.lang.Iterable) r1;
        r1 = r1.iterator();
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0053;
    L_0x0045:
        r0 = r1.next();
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment) r0;
        if (r0 == 0) goto L_0x0050;
    L_0x004d:
        r0.updateItem();
        goto L_0x003f;
    L_0x0053:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.MyPagerAdapter.updateItems(int):void");
    }

    public final void updateUiVisibility(boolean r1, int r2) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.MyPagerAdapter.updateUiVisibility(boolean, int):void
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
        r1 = -1;
        r0 = new a.f.c;
        r2 = 1;
        r0.<init>(r1, r2);
        r0 = (java.lang.Iterable) r0;
        r1 = new java.util.ArrayList;
        r2 = 10;
        r2 = p000a.p001a.C0007i.m15a(r0, r2);
        r1.<init>(r2);
        r1 = (java.util.Collection) r1;
        r2 = r0.iterator();
    L_0x001c:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x0036;
    L_0x0022:
        r0 = r2;
        r0 = (p000a.p001a.C0015p) r0;
        r0 = r0.m39b();
        r3 = r4.mFragments;
        r0 = r0 + r6;
        r0 = r3.get(r0);
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment) r0;
        r1.add(r0);
        goto L_0x001c;
    L_0x0036:
        r1 = (java.util.List) r1;
        r1 = (java.lang.Iterable) r1;
        r1 = r1.iterator();
        r0 = r1.hasNext();
        if (r0 == 0) goto L_0x0053;
    L_0x0045:
        r0 = r1.next();
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment) r0;
        if (r0 == 0) goto L_0x0050;
    L_0x004d:
        r0.systemUiVisibilityChanged(r5);
        goto L_0x003f;
    L_0x0053:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.MyPagerAdapter.updateUiVisibility(boolean, int):void");
    }
}
