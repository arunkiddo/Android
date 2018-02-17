package com.simplemobiletools.gallery.dialogs;

import android.view.View;
import android.view.View.OnClickListener;
import com.simplemobiletools.filepicker.dialogs.FilePickerDialog;
import p000a.p005e.p007b.C0042h.C0041d;

final class SaveAsDialog$$special$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ C0041d $realPath$inlined;
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ View receiver$0;
    final /* synthetic */ SaveAsDialog this$0;

    SaveAsDialog$$special$$inlined$apply$lambda$1(View view, SaveAsDialog saveAsDialog, C0041d c0041d, View view2) {
        this.receiver$0 = view;
        this.this$0 = saveAsDialog;
        this.$realPath$inlined = c0041d;
        this.$view$inlined = view2;
    }

    public final void onClick(View view) {
        FilePickerDialog filePickerDialog = new FilePickerDialog(this.this$0.getActivity(), (String) this.$realPath$inlined.f13a, false, false, new SaveAsDialog$$special$$inlined$apply$lambda$lambda$1(this));
    }
}
