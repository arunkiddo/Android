package com.simplemobiletools.filepicker.dialogs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class ConfirmationDialog$builder$1 implements OnClickListener {
    final /* synthetic */ ConfirmationDialog this$0;

    ConfirmationDialog$builder$1(ConfirmationDialog confirmationDialog) {
        this.this$0 = confirmationDialog;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.this$0.dialogConfirmed();
    }
}
