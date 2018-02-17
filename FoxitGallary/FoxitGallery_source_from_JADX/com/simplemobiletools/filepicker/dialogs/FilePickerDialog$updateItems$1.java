package com.simplemobiletools.filepicker.dialogs;

import com.simplemobiletools.filepicker.models.FileDirItem;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class FilePickerDialog$updateItems$1 extends C0037g implements C0029b<FileDirItem, Boolean> {
    public static final FilePickerDialog$updateItems$1 INSTANCE;

    static {
        INSTANCE = new FilePickerDialog$updateItems$1();
    }

    FilePickerDialog$updateItems$1() {
        super(1);
    }

    public /* synthetic */ Object invoke(Object obj) {
        return Boolean.valueOf(invoke((FileDirItem) obj));
    }

    public final boolean invoke(FileDirItem fileDirItem) {
        C0036f.m62b(fileDirItem, "it");
        return !fileDirItem.isDirectory();
    }
}
