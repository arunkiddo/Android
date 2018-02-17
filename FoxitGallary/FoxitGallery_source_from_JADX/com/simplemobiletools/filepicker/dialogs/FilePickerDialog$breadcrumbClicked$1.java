package com.simplemobiletools.filepicker.dialogs;

import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class FilePickerDialog$breadcrumbClicked$1 extends C0037g implements C0029b<String, C0055f> {
    final /* synthetic */ FilePickerDialog this$0;

    FilePickerDialog$breadcrumbClicked$1(FilePickerDialog filePickerDialog) {
        this.this$0 = filePickerDialog;
        super(1);
    }

    public final void invoke(String str) {
        C0036f.m62b(str, "it");
        this.this$0.setCurrPath(str);
        this.this$0.updateItems();
    }
}
