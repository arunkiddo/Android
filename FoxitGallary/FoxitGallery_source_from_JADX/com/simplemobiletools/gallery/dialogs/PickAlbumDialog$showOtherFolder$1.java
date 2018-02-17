package com.simplemobiletools.gallery.dialogs;

import com.simplemobiletools.filepicker.dialogs.FilePickerDialog.FilePickerResult;
import com.simplemobiletools.filepicker.dialogs.FilePickerDialog.OnFilePickerListener;
import p000a.p005e.p007b.C0036f;

public final class PickAlbumDialog$showOtherFolder$1 implements OnFilePickerListener {
    final /* synthetic */ PickAlbumDialog this$0;

    PickAlbumDialog$showOtherFolder$1(PickAlbumDialog pickAlbumDialog) {
        this.this$0 = pickAlbumDialog;
    }

    public void onFail(FilePickerResult filePickerResult) {
        C0036f.m62b(filePickerResult, "error");
    }

    public void onSuccess(String str) {
        C0036f.m62b(str, "pickedPath");
        this.this$0.getCallback().invoke(str);
    }
}
