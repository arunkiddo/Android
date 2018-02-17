package com.simplemobiletools.filepicker.dialogs;

import com.simplemobiletools.filepicker.models.FileDirItem;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class FilePickerDialog$updateItems$adapter$1 extends C0037g implements C0029b<FileDirItem, C0055f> {
    final /* synthetic */ FilePickerDialog this$0;

    FilePickerDialog$updateItems$adapter$1(FilePickerDialog filePickerDialog) {
        this.this$0 = filePickerDialog;
        super(1);
    }

    public final void invoke(FileDirItem fileDirItem) {
        C0036f.m62b(fileDirItem, "it");
        if (fileDirItem.isDirectory()) {
            this.this$0.setCurrPath(fileDirItem.getPath());
            this.this$0.updateItems();
        } else if (this.this$0.getPickFile()) {
            this.this$0.setCurrPath(fileDirItem.getPath());
            this.this$0.verifyPath();
        }
    }
}
