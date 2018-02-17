package com.simplemobiletools.filepicker.dialogs;

import com.simplemobiletools.filepicker.models.FileDirItem;
import p000a.C0027d;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class FilePickerDialog$updateItems$2 extends C0037g implements C0029b<FileDirItem, String> {
    public static final FilePickerDialog$updateItems$2 INSTANCE;

    static {
        INSTANCE = new FilePickerDialog$updateItems$2();
    }

    FilePickerDialog$updateItems$2() {
        super(1);
    }

    public final String invoke(FileDirItem fileDirItem) {
        C0036f.m62b(fileDirItem, "it");
        String name = fileDirItem.getName();
        if (name == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = name.toLowerCase();
        C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        return toLowerCase;
    }
}
