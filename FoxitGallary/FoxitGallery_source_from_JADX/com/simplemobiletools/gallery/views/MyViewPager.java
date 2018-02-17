package com.simplemobiletools.gallery.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.p043b.p044a.C0979b;
import java.util.HashMap;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;

public final class MyViewPager extends C0979b {
    private HashMap _$_findViewCache;

    public MyViewPager(Context context) {
        C0036f.m62b(context, "context");
        super(context);
    }

    public MyViewPager(Context context, AttributeSet attributeSet) {
        C0036f.m62b(context, "context");
        C0036f.m62b(attributeSet, "attrs");
        super(context, attributeSet);
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

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        C0036f.m62b(motionEvent, "ev");
        try {
            return super.onInterceptTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            Throwable th = e;
            if (th == null) {
                throw new C0027d("null cannot be cast to non-null type java.lang.Throwable");
            }
            th.printStackTrace();
            return false;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0036f.m62b(motionEvent, "ev");
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException e) {
            Throwable th = e;
            if (th == null) {
                throw new C0027d("null cannot be cast to non-null type java.lang.Throwable");
            }
            th.printStackTrace();
            return false;
        }
    }
}
