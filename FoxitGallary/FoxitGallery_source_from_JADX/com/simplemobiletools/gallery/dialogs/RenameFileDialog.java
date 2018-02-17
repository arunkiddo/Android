package com.simplemobiletools.gallery.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.activities.SimpleActivity;
import java.io.File;
import p000a.C0027d;
import p000a.C0055f;
import p000a.p001a.C0006h;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0078o;

public final class RenameFileDialog {
    private final SimpleActivity activity;
    private final C0029b<File, C0055f> callback;
    private final File file;

    public RenameFileDialog(SimpleActivity simpleActivity, File file, C0029b<? super File, C0055f> c0029b) {
        Object substring;
        C0036f.m62b(simpleActivity, "activity");
        C0036f.m62b(file, "file");
        C0036f.m62b(c0029b, "callback");
        this.activity = simpleActivity;
        this.file = file;
        this.callback = c0029b;
        View inflate = LayoutInflater.from(this.activity).inflate(C1333R.layout.rename_file, (ViewGroup) null);
        String name = this.file.getName();
        int b = C0078o.m130b((CharSequence) name, ".", 0, false, 6, null);
        if (b <= 0) {
            String str = name;
        } else if (name == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        } else {
            Object substring2 = name.substring(0, b);
            C0036f.m59a(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            int i = b + 1;
            if (name == null) {
                throw new C0027d("null cannot be cast to non-null type java.lang.String");
            }
            substring = name.substring(i);
            C0036f.m59a(substring, "(this as java.lang.String).substring(startIndex)");
            ((EditText) inflate.findViewById(C1333R.id.file_extension)).setText((CharSequence) substring);
            substring = substring2;
        }
        ((EditText) inflate.findViewById(C1333R.id.file_name)).setText((CharSequence) substring);
        TextView textView = (TextView) inflate.findViewById(C1333R.id.file_path);
        StringBuilder stringBuilder = new StringBuilder();
        Context context = this.activity;
        Object parent = this.file.getParent();
        C0036f.m59a(parent, "file.parent");
        textView.setText(stringBuilder.append(ContextKt.humanizePath(context, parent)).append("/").toString());
        AlertDialog create = new Builder(this.activity).setTitle(this.activity.getResources().getString(C1333R.string.rename_file)).setView(inflate).setPositiveButton(C1333R.string.ok, (OnClickListener) null).setNegativeButton(C1333R.string.cancel, (OnClickListener) null).create();
        Window window = create.getWindow();
        if (window == null) {
            C0036f.m58a();
        }
        window.setSoftInputMode(5);
        create.setCanceledOnTouchOutside(true);
        create.show();
        create.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new RenameFileDialog$$special$$inlined$apply$lambda$1(create, this, inflate));
    }

    private final void sendSuccess(File file, File file2) {
        if (ContextKt.updateInMediaStore(this.activity, file, file2)) {
            this.callback.invoke(file2);
            return;
        }
        ContextKt.scanFiles(this.activity, C0006h.m9a((Object[]) new File[]{file, file2}), new RenameFileDialog$sendSuccess$1(this, file2));
    }

    public final SimpleActivity getActivity() {
        return this.activity;
    }

    public final C0029b<File, C0055f> getCallback() {
        return this.callback;
    }

    public final File getFile() {
        return this.file;
    }
}
