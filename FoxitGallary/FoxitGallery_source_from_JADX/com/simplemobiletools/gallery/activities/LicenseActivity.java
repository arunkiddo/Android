package com.simplemobiletools.gallery.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.simplemobiletools.gallery.C1333R;
import java.util.HashMap;

public final class LicenseActivity extends SimpleActivity {
    private HashMap _$_findViewCache;

    private final void openUrl(int i) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(getResources().getString(i))));
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

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1333R.layout.activity_license);
        ((TextView) _$_findCachedViewById(C1333R.id.license_kotlin_title)).setOnClickListener(new LicenseActivity$onCreate$1(this));
        ((TextView) _$_findCachedViewById(C1333R.id.license_subsampling_title)).setOnClickListener(new LicenseActivity$onCreate$2(this));
        ((TextView) _$_findCachedViewById(C1333R.id.license_glide_title)).setOnClickListener(new LicenseActivity$onCreate$3(this));
        ((TextView) _$_findCachedViewById(C1333R.id.license_cropper_title)).setOnClickListener(new LicenseActivity$onCreate$4(this));
        ((TextView) _$_findCachedViewById(C1333R.id.license_multiselect_title)).setOnClickListener(new LicenseActivity$onCreate$5(this));
        ((TextView) _$_findCachedViewById(C1333R.id.license_rtl_viewpager_title)).setOnClickListener(new LicenseActivity$onCreate$6(this));
        ((TextView) _$_findCachedViewById(C1333R.id.license_filepicker_title)).setOnClickListener(new LicenseActivity$onCreate$7(this));
        ((TextView) _$_findCachedViewById(C1333R.id.license_fileproperties_title)).setOnClickListener(new LicenseActivity$onCreate$8(this));
    }
}
