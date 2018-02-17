package com.simplemobiletools.gallery.views;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.ScaleGestureDetector.SimpleOnScaleGestureListener;
import android.view.View;
import java.util.HashMap;
import p000a.p005e.p007b.C0036f;

public final class MyScalableRecyclerView extends RecyclerView {
    public static final Companion Companion;
    private static float mCurrScaleFactor;
    private static ZoomListener mListener;
    private HashMap _$_findViewCache;
    private ScaleGestureDetector mScaleDetector;

    public interface ZoomListener {
        void zoomIn();

        void zoomOut();
    }

    public static final class Companion {
        private Companion() {
        }

        public final float getMCurrScaleFactor() {
            return MyScalableRecyclerView.mCurrScaleFactor;
        }

        public final ZoomListener getMListener() {
            return MyScalableRecyclerView.mListener;
        }

        public final void setMCurrScaleFactor(float f) {
            MyScalableRecyclerView.mCurrScaleFactor = f;
        }

        public final void setMListener(ZoomListener zoomListener) {
            MyScalableRecyclerView.mListener = zoomListener;
        }
    }

    public static final class GestureListener extends SimpleOnScaleGestureListener {
        private final float ZOOM_IN_THRESHOLD;
        private final float ZOOM_OUT_THRESHOLD;

        public GestureListener() {
            this.ZOOM_IN_THRESHOLD = -0.7f;
            this.ZOOM_OUT_THRESHOLD = 0.3f;
        }

        public final float getZOOM_IN_THRESHOLD() {
            return this.ZOOM_IN_THRESHOLD;
        }

        public final float getZOOM_OUT_THRESHOLD() {
            return this.ZOOM_OUT_THRESHOLD;
        }

        public boolean onScale(android.view.ScaleGestureDetector r1) {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.views.MyScalableRecyclerView.GestureListener.onScale(android.view.ScaleGestureDetector):boolean
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:263)
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
	... 8 more
*/
            /*
            r0 = this;
            r2 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
            r0 = "detector";
            p000a.p005e.p007b.C0036f.m62b(r4, r0);
            r0 = com.simplemobiletools.gallery.views.MyScalableRecyclerView.Companion;
            r0 = r0.getMCurrScaleFactor();
            r1 = r4.getScaleFactor();
            r0 = r0 - r1;
            r1 = r3.ZOOM_IN_THRESHOLD;
            r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r1 >= 0) goto L_0x0039;
        L_0x0018:
            r1 = com.simplemobiletools.gallery.views.MyScalableRecyclerView.Companion;
            r1 = r1.getMCurrScaleFactor();
            r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1));
            if (r1 != 0) goto L_0x0039;
        L_0x0022:
            r0 = com.simplemobiletools.gallery.views.MyScalableRecyclerView.Companion;
            r0 = r0.getMListener();
            if (r0 == 0) goto L_0x002d;
        L_0x002a:
            r0.zoomIn();
            r0 = com.simplemobiletools.gallery.views.MyScalableRecyclerView.Companion;
            r1 = r4.getScaleFactor();
            r0.setMCurrScaleFactor(r1);
            r0 = 0;
            return r0;
        L_0x0039:
            r1 = r3.ZOOM_OUT_THRESHOLD;
            r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1));
            if (r0 <= 0) goto L_0x0037;
            r0 = com.simplemobiletools.gallery.views.MyScalableRecyclerView.Companion;
            r0 = r0.getMCurrScaleFactor();
            r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
            if (r0 != 0) goto L_0x0037;
            r0 = com.simplemobiletools.gallery.views.MyScalableRecyclerView.Companion;
            r0 = r0.getMListener();
            if (r0 == 0) goto L_0x0054;
            r0.zoomOut();
            r0 = com.simplemobiletools.gallery.views.MyScalableRecyclerView.Companion;
            r1 = r4.getScaleFactor();
            r0.setMCurrScaleFactor(r1);
            goto L_0x0037;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.views.MyScalableRecyclerView.GestureListener.onScale(android.view.ScaleGestureDetector):boolean");
        }
    }

    static {
        Companion = new Companion();
        mCurrScaleFactor = 1.0f;
    }

    public MyScalableRecyclerView(Context context) {
        C0036f.m62b(context, "context");
        super(context);
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new GestureListener());
    }

    public MyScalableRecyclerView(Context context, AttributeSet attributeSet) {
        C0036f.m62b(context, "context");
        C0036f.m62b(attributeSet, "attrs");
        super(context, attributeSet);
        this.mScaleDetector = new ScaleGestureDetector(getContext(), new GestureListener());
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
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        C0036f.m62b(motionEvent, "ev");
        super.dispatchTouchEvent(motionEvent);
        if (motionEvent.getAction() == 1) {
            Companion.setMCurrScaleFactor(1.0f);
        }
        return this.mScaleDetector.onTouchEvent(motionEvent);
    }

    public final ScaleGestureDetector getMScaleDetector() {
        return this.mScaleDetector;
    }

    public final void setMScaleDetector(ScaleGestureDetector scaleGestureDetector) {
        C0036f.m62b(scaleGestureDetector, "<set-?>");
        this.mScaleDetector = scaleGestureDetector;
    }
}
