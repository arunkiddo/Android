package com.simplemobiletools.gallery.activities;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.View.OnClickListener;
import com.simplemobiletools.gallery.C1333R;

final class SettingsActivity$setupShowHiddenFolders$1 implements OnClickListener {
    final /* synthetic */ SettingsActivity this$0;

    SettingsActivity$setupShowHiddenFolders$1(SettingsActivity settingsActivity) {
        this.this$0 = settingsActivity;
    }

    public final void onClick(View view) {
        ((SwitchCompat) this.this$0._$_findCachedViewById(C1333R.id.settings_show_hidden_folders)).toggle();
        this.this$0.getMConfig().setShowHiddenFolders(((SwitchCompat) this.this$0._$_findCachedViewById(C1333R.id.settings_show_hidden_folders)).isChecked());
    }
}
