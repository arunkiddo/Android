package com.simplemobiletools.gallery.activities;

import android.os.Bundle;
import android.view.View;
import java.util.HashMap;

public final class PhotoActivity extends PhotoVideoActivity {
    private HashMap _$_findViewCache;

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

    public void onCreate(Bundle bundle) {
        PhotoVideoActivity.Companion.setMIsVideo(false);
        super.onCreate(bundle);
    }
}
