package com.simplemobiletools.filepicker.dialogs;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

final class StoragePickerDialog$$special$$inlined$apply$lambda$3 implements OnClickListener {
    final /* synthetic */ String $basePath$inlined;
    final /* synthetic */ Resources $resources$inlined;
    final /* synthetic */ StoragePickerDialog this$0;

    StoragePickerDialog$$special$$inlined$apply$lambda$3(StoragePickerDialog storagePickerDialog, Resources resources, String str) {
        this.this$0 = storagePickerDialog;
        this.$resources$inlined = resources;
        this.$basePath$inlined = str;
    }

    public final void onClick(View view) {
        this.this$0.rootPicked();
    }
}
