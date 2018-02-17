package com.simplemobiletools.filepicker.dialogs;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.simplemobiletools.filepicker.C1328R;
import com.simplemobiletools.filepicker.views.Breadcrumbs;

final class FilePickerDialog$builder$3 implements OnKeyListener {
    final /* synthetic */ FilePickerDialog this$0;

    FilePickerDialog$builder$3(FilePickerDialog filePickerDialog) {
        this.this$0 = filePickerDialog;
    }

    public final boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() == 1 && i == 4) {
            Breadcrumbs breadcrumbs = (Breadcrumbs) this.this$0.getMDialogView().findViewById(C1328R.id.directory_picker_breadcrumbs);
            if (breadcrumbs.getChildCount() > 1) {
                breadcrumbs.removeBreadcrumb();
                this.this$0.setCurrPath(breadcrumbs.getLastItem().getPath());
                this.this$0.updateItems();
            } else {
                this.this$0.getMDialog().dismiss();
                this.this$0.dialogDismissed();
            }
        }
        return true;
    }
}
