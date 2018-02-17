package com.simplemobiletools.gallery.activities;

import android.os.Bundle;
import android.support.v4.p021b.ai;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.RelativeLayout;
import com.simplemobiletools.gallery.C1333R;
import java.util.HashMap;

public final class SettingsActivity extends SimpleActivity {
    private HashMap _$_findViewCache;

    private final void restartActivity() {
        ai.m903a(getApplicationContext()).m909b(getIntent()).m907a();
    }

    private final void setupAutoplayVideos() {
        ((RelativeLayout) _$_findCachedViewById(C1333R.id.settings_autoplay_videos_holder)).setOnClickListener(new SettingsActivity$setupAutoplayVideos$1(this));
    }

    private final void setupDarkTheme() {
        ((SwitchCompat) _$_findCachedViewById(C1333R.id.settings_dark_theme)).setChecked(getMConfig().isDarkTheme());
        ((RelativeLayout) _$_findCachedViewById(C1333R.id.settings_dark_theme_holder)).setOnClickListener(new SettingsActivity$setupDarkTheme$1(this));
    }

    private final void setupSameSorting() {
        ((SwitchCompat) _$_findCachedViewById(C1333R.id.settings_same_sorting)).setChecked(getMConfig().isSameSorting());
        ((RelativeLayout) _$_findCachedViewById(C1333R.id.settings_same_sorting_holder)).setOnClickListener(new SettingsActivity$setupSameSorting$1(this));
    }

    private final void setupShowHiddenFolders() {
        ((SwitchCompat) _$_findCachedViewById(C1333R.id.settings_show_hidden_folders)).setChecked(getMConfig().getShowHiddenFolders());
        ((RelativeLayout) _$_findCachedViewById(C1333R.id.settings_show_hidden_folders_holder)).setOnClickListener(new SettingsActivity$setupShowHiddenFolders$1(this));
    }

    private final void setupShowMedia() {
        ((AppCompatSpinner) _$_findCachedViewById(C1333R.id.settings_show_media)).setSelection(getMConfig().getShowMedia());
        ((AppCompatSpinner) _$_findCachedViewById(C1333R.id.settings_show_media)).setOnItemSelectedListener(new SettingsActivity$setupShowMedia$1(this));
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
        setContentView((int) C1333R.layout.activity_settings);
        setupDarkTheme();
        setupSameSorting();
        setupShowHiddenFolders();
        setupAutoplayVideos();
        setupShowMedia();
    }
}
