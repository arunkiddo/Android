package com.simplemobiletools.gallery.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Environment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.simplemobiletools.filepicker.dialogs.FilePickerDialog;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.activities.SimpleActivity;
import com.simplemobiletools.gallery.adapters.DirectoryAdapter;
import com.simplemobiletools.gallery.adapters.DirectoryAdapter.DirOperationsListener;
import com.simplemobiletools.gallery.asynctasks.GetDirectoriesAsynctask;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.models.Directory;
import java.util.ArrayList;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

public final class PickAlbumDialog {
    private final SimpleActivity activity;
    private final C0029b<String, C0055f> callback;
    private AlertDialog dialog;
    private RecyclerView directoriesGrid;

    /* renamed from: com.simplemobiletools.gallery.dialogs.PickAlbumDialog.1 */
    static final class C13411 implements OnClickListener {
        final /* synthetic */ PickAlbumDialog this$0;

        C13411(PickAlbumDialog pickAlbumDialog) {
            this.this$0 = pickAlbumDialog;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.this$0.showOtherFolder();
        }
    }

    /* renamed from: com.simplemobiletools.gallery.dialogs.PickAlbumDialog.2 */
    static final class C13422 extends C0037g implements C0029b<ArrayList<Directory>, C0055f> {
        final /* synthetic */ PickAlbumDialog this$0;

        C13422(PickAlbumDialog pickAlbumDialog) {
            this.this$0 = pickAlbumDialog;
            super(1);
        }

        public final void invoke(ArrayList<Directory> arrayList) {
            C0036f.m62b(arrayList, "it");
            this.this$0.getDirectoriesGrid().setAdapter(new DirectoryAdapter(this.this$0.getActivity(), arrayList, (DirOperationsListener) null, new PickAlbumDialog$2$adapter$1(this)));
        }
    }

    public PickAlbumDialog(SimpleActivity simpleActivity, C0029b<? super String, C0055f> c0029b) {
        C0036f.m62b(simpleActivity, "activity");
        C0036f.m62b(c0029b, "callback");
        this.activity = simpleActivity;
        this.callback = c0029b;
        View inflate = LayoutInflater.from(this.activity).inflate(C1333R.layout.dialog_album_picker, (ViewGroup) null);
        Object obj = (RecyclerView) inflate.findViewById(C1333R.id.directories_grid);
        C0036f.m59a(obj, "view.directories_grid");
        this.directoriesGrid = obj;
        obj = new Builder(this.activity).setTitle(this.activity.getResources().getString(C1333R.string.select_destination)).setView(inflate).setNeutralButton(C1333R.string.other_folder, new C13411(this)).setPositiveButton(C1333R.string.ok, (OnClickListener) null).create();
        C0036f.m59a(obj, "AlertDialog.Builder(acti\u2026                .create()");
        this.dialog = obj;
        this.dialog.setCanceledOnTouchOutside(true);
        this.dialog.show();
        new GetDirectoriesAsynctask(this.activity, false, false, new ArrayList(), new C13422(this)).execute(new Void[0]);
    }

    public final SimpleActivity getActivity() {
        return this.activity;
    }

    public final C0029b<String, C0055f> getCallback() {
        return this.callback;
    }

    public final AlertDialog getDialog() {
        return this.dialog;
    }

    public final RecyclerView getDirectoriesGrid() {
        return this.directoriesGrid;
    }

    public final void setDialog(AlertDialog alertDialog) {
        C0036f.m62b(alertDialog, "<set-?>");
        this.dialog = alertDialog;
    }

    public final void setDirectoriesGrid(RecyclerView recyclerView) {
        C0036f.m62b(recyclerView, "<set-?>");
        this.directoriesGrid = recyclerView;
    }

    public final void showOtherFolder() {
        Object file = Environment.getExternalStorageDirectory().toString();
        boolean showHiddenFolders = Config.Companion.newInstance(this.activity).getShowHiddenFolders();
        Context context = this.activity;
        C0036f.m59a(file, "initialPath");
        FilePickerDialog filePickerDialog = new FilePickerDialog(context, file, false, showHiddenFolders, new PickAlbumDialog$showOtherFolder$1(this));
    }
}
