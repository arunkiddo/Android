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
import java.util.ArrayList;
import p000a.p005e.p007b.C0036f;

final class RenameDirectoryDialog$$special$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ AlertDialog receiver$0;
    final /* synthetic */ RenameDirectoryDialog this$0;

    RenameDirectoryDialog$$special$$inlined$apply$lambda$1(AlertDialog alertDialog, RenameDirectoryDialog renameDirectoryDialog, View view) {
        this.receiver$0 = alertDialog;
        this.this$0 = renameDirectoryDialog;
        this.$view$inlined = view;
    }

    public final void onClick(View view) {
        String value = EditTextKt.getValue((EditText) this.$view$inlined.findViewById(C1333R.id.directory_name));
        if ((((CharSequence) value).length() == 0 ? 1 : 0) != 0) {
            ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.rename_folder_empty, 0, 2, null);
        } else if (StringKt.isAValidFilename(value)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.this$0.getDir().getAbsolutePath());
            File file = new File(this.this$0.getDir().getParent(), value);
            if (file.exists()) {
                ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.rename_folder_exists, 0, 2, null);
                return;
            }
            Context context = this.receiver$0.getContext();
            Object absolutePath = this.this$0.getDir().getAbsolutePath();
            C0036f.m59a(absolutePath, "dir.absolutePath");
            if (ContextKt.needsStupidWritePermissions(context, absolutePath)) {
                if (!this.this$0.getActivity().isShowingPermDialog(this.this$0.getDir())) {
                    Context context2 = this.receiver$0.getContext();
                    Object absolutePath2 = this.this$0.getDir().getAbsolutePath();
                    C0036f.m59a(absolutePath2, "dir.absolutePath");
                    Companion companion = Config.Companion;
                    Object context3 = this.receiver$0.getContext();
                    C0036f.m59a(context3, "context");
                    C0361a fileDocument = ContextKt.getFileDocument(context2, absolutePath2, companion.newInstance(context3).getTreeUri());
                    if (fileDocument.m1343d()) {
                        fileDocument.m1342c(value);
                    }
                    this.this$0.sendSuccess(arrayList, file);
                    this.receiver$0.dismiss();
                }
            } else if (this.this$0.getDir().renameTo(file)) {
                this.this$0.sendSuccess(arrayList, file);
                this.receiver$0.dismiss();
            } else {
                ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.rename_folder_error, 0, 2, null);
            }
        } else {
            ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.invalid_name, 0, 2, null);
        }
    }
}
