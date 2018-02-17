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
import java.util.ArrayList;
import java.util.Collection;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;

public final class RenameDirectoryDialog {
    private final SimpleActivity activity;
    private final C0029b<ArrayList<String>, C0055f> callback;
    private final File dir;

    public RenameDirectoryDialog(SimpleActivity simpleActivity, File file, C0029b<? super ArrayList<String>, C0055f> c0029b) {
        C0036f.m62b(simpleActivity, "activity");
        C0036f.m62b(file, "dir");
        C0036f.m62b(c0029b, "callback");
        this.activity = simpleActivity;
        this.dir = file;
        this.callback = c0029b;
        View inflate = LayoutInflater.from(this.activity).inflate(C1333R.layout.rename_directory, (ViewGroup) null);
        ((EditText) inflate.findViewById(C1333R.id.directory_name)).setText(this.dir.getName());
        TextView textView = (TextView) inflate.findViewById(C1333R.id.directory_path);
        StringBuilder stringBuilder = new StringBuilder();
        Context context = this.activity;
        Object parent = this.dir.getParent();
        C0036f.m59a(parent, "dir.parent");
        textView.setText(stringBuilder.append(ContextKt.humanizePath(context, parent)).append("/").toString());
        AlertDialog create = new Builder(this.activity).setTitle(this.activity.getResources().getString(C1333R.string.rename_folder)).setView(inflate).setPositiveButton(C1333R.string.ok, (OnClickListener) null).setNegativeButton(C1333R.string.cancel, (OnClickListener) null).create();
        Window window = create.getWindow();
        if (window == null) {
            C0036f.m58a();
        }
        window.setSoftInputMode(5);
        create.setCanceledOnTouchOutside(true);
        create.show();
        create.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new RenameDirectoryDialog$$special$$inlined$apply$lambda$1(create, this, inflate));
    }

    private final void sendSuccess(ArrayList<String> arrayList, File file) {
        ContextKt.toast$default((Context) this.activity, (int) C1333R.string.renaming_folder, 0, 2, null);
        Object[] objArr = (Object[]) (file.isDirectory() ? file.listFiles() : (File[]) ((Object[]) new File[0]));
        for (Object obj : objArr) {
            Collection collection = arrayList;
            Object obj2 = ((File) obj2).getAbsolutePath();
            C0036f.m59a(obj2, "it.absolutePath");
            collection.add(obj2);
        }
        Collection collection2 = arrayList;
        arrayList.add(file.getAbsolutePath());
        this.callback.invoke(arrayList);
    }

    public final SimpleActivity getActivity() {
        return this.activity;
    }

    public final C0029b<ArrayList<String>, C0055f> getCallback() {
        return this.callback;
    }

    public final File getDir() {
        return this.dir;
    }
}
