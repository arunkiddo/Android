package com.simplemobiletools.gallery.dialogs;

import android.app.AlertDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.EditTextKt;
import com.simplemobiletools.filepicker.extensions.StringKt;
import com.simplemobiletools.gallery.C1333R;
import java.io.File;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0042h.C0041d;

final class SaveAsDialog$$special$$inlined$apply$lambda$2 implements OnClickListener {
    final /* synthetic */ C0041d $realPath$inlined;
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ AlertDialog receiver$0;
    final /* synthetic */ SaveAsDialog this$0;

    SaveAsDialog$$special$$inlined$apply$lambda$2(AlertDialog alertDialog, SaveAsDialog saveAsDialog, View view, C0041d c0041d) {
        this.receiver$0 = alertDialog;
        this.this$0 = saveAsDialog;
        this.$view$inlined = view;
        this.$realPath$inlined = c0041d;
    }

    public final void onClick(View view) {
        String value = EditTextKt.getValue((EditText) this.$view$inlined.findViewById(C1333R.id.file_name));
        String value2 = EditTextKt.getValue((EditText) this.$view$inlined.findViewById(C1333R.id.file_extension));
        if ((((CharSequence) value).length() == 0 ? 1 : 0) != 0) {
            ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.filename_cannot_be_empty, 0, 2, null);
            return;
        }
        if ((((CharSequence) value2).length() == 0 ? 1 : 0) != 0) {
            ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.extension_cannot_be_empty, 0, 2, null);
            return;
        }
        File file = new File((String) this.$realPath$inlined.f13a, value + "." + value2);
        if (StringKt.isAValidFilename(file.getName())) {
            C0029b callback = this.this$0.getCallback();
            Object absolutePath = file.getAbsolutePath();
            C0036f.m59a(absolutePath, "newFile.absolutePath");
            callback.invoke(absolutePath);
            this.receiver$0.dismiss();
            return;
        }
        ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.filename_invalid_characters, 0, 2, null);
    }
}
