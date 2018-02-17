package com.simplemobiletools.gallery.fragments;

import android.view.View;
import android.view.View.OnClickListener;
import com.davemorrissey.labs.subscaleview.C1324a;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.simplemobiletools.gallery.models.Medium;
import java.util.HashMap;
import p000a.p005e.p007b.C0036f;

public final class PhotoFragment extends ViewPagerFragment implements OnClickListener {
    private HashMap _$_findViewCache;
    public Medium medium;
    public SubsamplingScaleImageView subsamplingView;

    private final void photoClicked() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.fragments.PhotoFragment.photoClicked():void
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
        r0 = r2.getListener();
        if (r0 != 0) goto L_0x0019;
    L_0x0006:
        r0 = r2.getActivity();
        if (r0 != 0) goto L_0x0014;
    L_0x000c:
        r0 = new a.d;
        r1 = "null cannot be cast to non-null type com.simplemobiletools.gallery.fragments.ViewPagerFragment.FragmentClickListener";
        r0.<init>(r1);
        throw r0;
    L_0x0014:
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment.FragmentClickListener) r0;
        r2.setListener(r0);
    L_0x0019:
        r0 = r2.getListener();
        if (r0 == 0) goto L_0x0022;
    L_0x001f:
        r0.fragmentClicked();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.fragments.PhotoFragment.photoClicked():void");
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = getView();
        if (view == null) {
            return null;
        }
        view = view.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    public final Medium getMedium() {
        Medium medium = this.medium;
        if (medium == null) {
            C0036f.m63b("medium");
        }
        return medium;
    }

    public final SubsamplingScaleImageView getSubsamplingView() {
        SubsamplingScaleImageView subsamplingScaleImageView = this.subsamplingView;
        if (subsamplingScaleImageView == null) {
            C0036f.m63b("subsamplingView");
        }
        return subsamplingScaleImageView;
    }

    public void itemDragged() {
    }

    public void onClick(View view) {
        C0036f.m62b(view, "v");
        photoClicked();
    }

    public android.view.View onCreateView(android.view.LayoutInflater r1, android.view.ViewGroup r2, android.os.Bundle r3) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.fragments.PhotoFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View
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
        r5 = 0;
        r0 = "inflater";
        p000a.p005e.p007b.C0036f.m62b(r7, r0);
        r0 = 2130968639; // 0x7f04003f float:1.7545937E38 double:1.052838397E-314;
        r1 = r7.inflate(r0, r8, r5);
        r0 = r6.getArguments();
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getMEDIUM();
        r0 = r0.getSerializable(r2);
        if (r0 != 0) goto L_0x0023;
    L_0x001b:
        r0 = new a.d;
        r1 = "null cannot be cast to non-null type com.simplemobiletools.gallery.models.Medium";
        r0.<init>(r1);
        throw r0;
    L_0x0023:
        r0 = (com.simplemobiletools.gallery.models.Medium) r0;
        r6.medium = r0;
        r0 = r6.medium;
        if (r0 != 0) goto L_0x0030;
    L_0x002b:
        r2 = "medium";
        p000a.p005e.p007b.C0036f.m63b(r2);
    L_0x0030:
        r0 = r0.getPath();
        r2 = "content://";
        r3 = 2;
        r4 = 0;
        r0 = p000a.p011i.C0077n.m102a(r0, r2, r5, r3, r4);
        if (r0 == 0) goto L_0x006a;
    L_0x003e:
        r2 = r6.medium;
        if (r2 != 0) goto L_0x0047;
    L_0x0042:
        r0 = "medium";
        p000a.p005e.p007b.C0036f.m63b(r0);
    L_0x0047:
        r0 = r6.getContext();
        r3 = r6.medium;
        if (r3 != 0) goto L_0x0054;
    L_0x004f:
        r4 = "medium";
        p000a.p005e.p007b.C0036f.m63b(r4);
    L_0x0054:
        r3 = r3.getPath();
        r3 = android.net.Uri.parse(r3);
        r4 = "Uri.parse(medium.path)";
        p000a.p005e.p007b.C0036f.m59a(r3, r4);
        r0 = com.simplemobiletools.gallery.extensions.ContextKt.getRealPathFromURI(r0, r3);
        if (r0 == 0) goto L_0x00d7;
    L_0x0067:
        r2.setPath(r0);
    L_0x006a:
        r0 = com.simplemobiletools.gallery.C1333R.id.photo_view;
        r0 = r1.findViewById(r0);
        r0 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView) r0;
        r2 = "view.photo_view";
        p000a.p005e.p007b.C0036f.m59a(r0, r2);
        r6.subsamplingView = r0;
        r0 = r6.medium;
        if (r0 != 0) goto L_0x0082;
    L_0x007d:
        r2 = "medium";
        p000a.p005e.p007b.C0036f.m63b(r2);
    L_0x0082:
        r0 = r0.isGif();
        if (r0 == 0) goto L_0x00da;
    L_0x0088:
        r0 = r6.subsamplingView;
        if (r0 != 0) goto L_0x0091;
    L_0x008c:
        r2 = "subsamplingView";
        p000a.p005e.p007b.C0036f.m63b(r2);
    L_0x0091:
        r2 = 8;
        r0.setVisibility(r2);
        r0 = com.simplemobiletools.gallery.C1333R.id.gif_view;
        r0 = r1.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r0 = (android.widget.ImageView) r0;
        r0.setVisibility(r5);
        r2 = r0.getContext();
        r2 = com.p045c.p046a.C1288i.m6077b(r2);
        r3 = r6.medium;
        if (r3 != 0) goto L_0x00b5;
    L_0x00b0:
        r4 = "medium";
        p000a.p005e.p007b.C0036f.m63b(r4);
    L_0x00b5:
        r3 = r3.getPath();
        r2 = r2.m6137a(r3);
        r2 = r2.m5856i();
        r3 = com.p045c.p046a.p050d.p052b.C1056b.NONE;
        r2 = r2.m5934a(r3);
        r2.m5117a(r0);
        r6 = (android.view.View.OnClickListener) r6;
        r0.setOnClickListener(r6);
        r0 = "view";
        p000a.p005e.p007b.C0036f.m59a(r1, r0);
        return r1;
    L_0x00d7:
        r0 = "";
        goto L_0x0067;
    L_0x00da:
        r0 = r6.subsamplingView;
        if (r0 != 0) goto L_0x00e3;
    L_0x00de:
        r2 = "subsamplingView";
        p000a.p005e.p007b.C0036f.m63b(r2);
        r0 = (com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView) r0;
        r2 = 1067030938; // 0x3f99999a float:1.2 double:5.271833295E-315;
        r0.setDoubleTapZoomScale(r2);
        r2 = -1;
        r0.setOrientation(r2);
        r2 = r6.medium;
        if (r2 != 0) goto L_0x00f9;
        r3 = "medium";
        p000a.p005e.p007b.C0036f.m63b(r3);
        r2 = r2.getPath();
        r2 = com.davemorrissey.labs.subscaleview.C1324a.m6323b(r2);
        r0.setImage(r2);
        r2 = 1082130432; // 0x40800000 float:4.0 double:5.34643471E-315;
        r0.setMaxScale(r2);
        r2 = 100;
        r0.setMinimumTileDpi(r2);
        r6 = (android.view.View.OnClickListener) r6;
        r0.setOnClickListener(r6);
        goto L_0x00d1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.fragments.PhotoFragment.onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle):android.view.View");
    }

    public void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setMedium(Medium medium) {
        C0036f.m62b(medium, "<set-?>");
        this.medium = medium;
    }

    public final void setSubsamplingView(SubsamplingScaleImageView subsamplingScaleImageView) {
        C0036f.m62b(subsamplingScaleImageView, "<set-?>");
        this.subsamplingView = subsamplingScaleImageView;
    }

    public void systemUiVisibilityChanged(boolean z) {
    }

    public void updateItem() {
        SubsamplingScaleImageView subsamplingScaleImageView = this.subsamplingView;
        if (subsamplingScaleImageView == null) {
            C0036f.m63b("subsamplingView");
        }
        Medium medium = this.medium;
        if (medium == null) {
            C0036f.m63b("medium");
        }
        subsamplingScaleImageView.setImage(C1324a.m6323b(medium.getPath()));
    }
}
