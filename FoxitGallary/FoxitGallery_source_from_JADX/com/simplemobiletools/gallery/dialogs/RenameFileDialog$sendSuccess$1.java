package com.simplemobiletools.gallery.dialogs;

import java.io.File;
import p000a.C0055f;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p007b.C0037g;

final class RenameFileDialog$sendSuccess$1 extends C0037g implements C0028a<C0055f> {
    final /* synthetic */ File $newFile;
    final /* synthetic */ RenameFileDialog this$0;

    RenameFileDialog$sendSuccess$1(RenameFileDialog renameFileDialog, File file) {
        this.this$0 = renameFileDialog;
        this.$newFile = file;
        super(0);
    }

    public final void invoke() {
        this.this$0.getCallback().invoke(this.$newFile);
    }
}
