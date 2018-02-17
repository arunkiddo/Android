package com.simplemobiletools.filepicker.dialogs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class FilePickerDialog$builder$1 implements OnClickListener {
    final /* synthetic */ FilePickerDialog this$0;

    FilePickerDialog$builder$1(FilePickerDialog filePickerDialog) {
        this.this$0 = filePickerDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.dialogDismissed();
    }
}
