package com.simplemobiletools.gallery.activities;

import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.simplemobiletools.gallery.C1333R;

public final class SettingsActivity$setupShowMedia$1 implements OnItemSelectedListener {
    final /* synthetic */ SettingsActivity this$0;

    SettingsActivity$setupShowMedia$1(SettingsActivity settingsActivity) {
        this.this$0 = settingsActivity;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        this.this$0.getMConfig().setShowMedia(((AppCompatSpinner) this.this$0._$_findCachedViewById(C1333R.id.settings_show_media)).getSelectedItemPosition());
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
