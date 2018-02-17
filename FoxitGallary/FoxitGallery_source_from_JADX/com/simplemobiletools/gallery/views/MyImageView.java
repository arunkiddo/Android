package com.simplemobiletools.gallery.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import java.util.HashMap;
import p000a.p005e.p007b.C0036f;

public final class MyImageView extends ImageView {
    private HashMap _$_findViewCache;

    public MyImageView(Context context) {
        C0036f.m62b(context, "context");
        super(context);
    }

    public MyImageView(Context context, AttributeSet attributeSet) {
        C0036f.m62b(context, "context");
        C0036f.m62b(attributeSet, "attrs");
        super(context, attributeSet);
    }

    public MyImageView(Context context, AttributeSet attributeSet, int i) {
        C0036f.m62b(context, "context");
        C0036f.m62b(attributeSet, "attrs");
        super(context, attributeSet, i);
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

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
