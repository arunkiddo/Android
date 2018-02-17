package com.simplemobiletools.gallery.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.StringKt;
import com.simplemobiletools.gallery.C1333R;
import java.io.File;
import p000a.C0027d;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0042h.C0041d;
import p000a.p011i.C0078o;

public final class SaveAsDialog {
    private final Activity activity;
    private final C0029b<String, C0055f> callback;
    private final String path;

    public SaveAsDialog(Activity activity, String str, C0029b<? super String, C0055f> c0029b) {
        Object substring;
        C0036f.m62b(activity, "activity");
        C0036f.m62b(str, "path");
        C0036f.m62b(c0029b, "callback");
        this.activity = activity;
        this.path = str;
        this.callback = c0029b;
        C0041d c0041d = new C0041d();
        c0041d.f13a = C0078o.m121a(new File(this.path).getParent(), '/');
        View inflate = LayoutInflater.from(this.activity).inflate(C1333R.layout.dialog_save_as, (ViewGroup) null);
        View view = inflate;
        ((TextView) view.findViewById(C1333R.id.file_path)).setText(ContextKt.humanizePath(this.activity, (String) c0041d.f13a));
        String filenameFromPath = StringKt.getFilenameFromPath(this.path);
        int b = C0078o.m130b((CharSequence) filenameFromPath, ".", 0, false, 6, null);
        if (b <= 0) {
            String str2 = filenameFromPath;
        } else if (filenameFromPath == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        } else {
            Object substring2 = filenameFromPath.substring(0, b);
            C0036f.m59a(substring2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            int i = b + 1;
            if (filenameFromPath == null) {
                throw new C0027d("null cannot be cast to non-null type java.lang.String");
            }
            substring = filenameFromPath.substring(i);
            C0036f.m59a(substring, "(this as java.lang.String).substring(startIndex)");
            ((EditText) inflate.findViewById(C1333R.id.file_extension)).setText((CharSequence) substring);
            substring = substring2;
        }
        ((EditText) view.findViewById(C1333R.id.file_name)).setText((CharSequence) substring);
        ((TextView) view.findViewById(C1333R.id.file_path)).setOnClickListener(new SaveAsDialog$$special$$inlined$apply$lambda$1(view, this, c0041d, inflate));
        AlertDialog create = new Builder(this.activity).setTitle(this.activity.getResources().getString(C1333R.string.save_as)).setView(inflate).setPositiveButton(C1333R.string.ok, (OnClickListener) null).setNegativeButton(C1333R.string.cancel, (OnClickListener) null).create();
        Window window = create.getWindow();
        if (window == null) {
            C0036f.m58a();
        }
        window.setSoftInputMode(5);
        create.setCanceledOnTouchOutside(true);
        create.show();
        create.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new SaveAsDialog$$special$$inlined$apply$lambda$2(create, this, inflate, c0041d));
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final C0029b<String, C0055f> getCallback() {
        return this.callback;
    }

    public final String getPath() {
        return this.path;
    }
}
