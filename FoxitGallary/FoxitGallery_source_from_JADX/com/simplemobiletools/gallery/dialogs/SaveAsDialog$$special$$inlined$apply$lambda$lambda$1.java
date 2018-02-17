package com.simplemobiletools.gallery.dialogs;

import android.widget.TextView;
import com.simplemobiletools.filepicker.dialogs.FilePickerDialog.FilePickerResult;
import com.simplemobiletools.filepicker.dialogs.FilePickerDialog.OnFilePickerListener;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.C1333R;

public final class SaveAsDialog$$special$$inlined$apply$lambda$lambda$1 implements OnFilePickerListener {
    final /* synthetic */ SaveAsDialog$$special$$inlined$apply$lambda$1 this$0;

    SaveAsDialog$$special$$inlined$apply$lambda$lambda$1(SaveAsDialog$$special$$inlined$apply$lambda$1 saveAsDialog$$special$$inlined$apply$lambda$1) {
        this.this$0 = saveAsDialog$$special$$inlined$apply$lambda$1;
    }

    public void onFail(FilePickerResult filePickerResult) {
    }

    public void onSuccess(String str) {
        ((TextView) this.this$0.receiver$0.findViewById(C1333R.id.file_path)).setText(ContextKt.humanizePath(this.this$0.this$0.getActivity(), str));
        this.this$0.$realPath$inlined.f13a = str;
    }
}
