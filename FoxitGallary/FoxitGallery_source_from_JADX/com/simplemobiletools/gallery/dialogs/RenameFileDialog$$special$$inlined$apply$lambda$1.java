package com.simplemobiletools.gallery.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v4.p028h.C0361a;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.EditTextKt;
import com.simplemobiletools.filepicker.extensions.StringKt;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.helpers.Config.Companion;
import java.io.File;
import p000a.p005e.p007b.C0036f;

final class RenameFileDialog$$special$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ AlertDialog receiver$0;
    final /* synthetic */ RenameFileDialog this$0;

    RenameFileDialog$$special$$inlined$apply$lambda$1(AlertDialog alertDialog, RenameFileDialog renameFileDialog, View view) {
        this.receiver$0 = alertDialog;
        this.this$0 = renameFileDialog;
        this.$view$inlined = view;
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
        File file = new File(this.this$0.getFile().getParent(), value + "." + value2);
        if (StringKt.isAValidFilename(file.getName())) {
            Context context = this.receiver$0.getContext();
            Object absolutePath = this.this$0.getFile().getAbsolutePath();
            C0036f.m59a(absolutePath, "file.absolutePath");
            if (ContextKt.needsStupidWritePermissions(context, absolutePath)) {
                if (!this.this$0.getActivity().isShowingPermDialog(this.this$0.getFile())) {
                    context = this.receiver$0.getContext();
                    absolutePath = this.this$0.getFile().getAbsolutePath();
                    C0036f.m59a(absolutePath, "file.absolutePath");
                    Companion companion = Config.Companion;
                    Object context2 = this.receiver$0.getContext();
                    C0036f.m59a(context2, "context");
                    C0361a fileDocument = ContextKt.getFileDocument(context, absolutePath, companion.newInstance(context2).getTreeUri());
                    if (fileDocument.m1343d()) {
                        fileDocument.m1342c(file.getName());
                    }
                    this.this$0.sendSuccess(this.this$0.getFile(), file);
                    this.receiver$0.dismiss();
                    return;
                }
                return;
            } else if (this.this$0.getFile().renameTo(file)) {
                this.this$0.sendSuccess(this.this$0.getFile(), file);
                this.receiver$0.dismiss();
                return;
            } else {
                ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.rename_file_error, 0, 2, null);
                return;
            }
        }
        ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.invalid_name, 0, 2, null);
    }
}
