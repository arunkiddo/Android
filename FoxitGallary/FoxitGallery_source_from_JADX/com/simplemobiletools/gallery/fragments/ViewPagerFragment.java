package com.simplemobiletools.gallery.fragments;

import android.support.v4.p021b.C0274o;
import android.view.View;
import java.util.HashMap;

public abstract class ViewPagerFragment extends C0274o {
    private HashMap _$_findViewCache;
    private FragmentClickListener listener;

    public interface FragmentClickListener {
        void fragmentClicked();
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

    public final FragmentClickListener getListener() {
        return this.listener;
    }

    public abstract void itemDragged();

    public void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public final void setListener(FragmentClickListener fragmentClickListener) {
        this.listener = fragmentClickListener;
    }

    public abstract void systemUiVisibilityChanged(boolean z);

    public abstract void updateItem();
}
