package com.simplemobiletools.filepicker.dialogs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

final class FilePickerDialog$builder$2 implements OnCancelListener {
    final /* synthetic */ FilePickerDialog this$0;

    FilePickerDialog$builder$2(FilePickerDialog filePickerDialog) {
        this.this$0 = filePickerDialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.this$0.dialogDismissed();
    }
}
