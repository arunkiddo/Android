package com.simplemobiletools.gallery.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.simplemobiletools.filepicker.asynctasks.CopyMoveTask.CopyMoveListener;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.BuildConfig;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.activities.SimpleActivity;
import java.io.File;
import java.util.ArrayList;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;
import p000a.p005e.p007b.C0042h.C0041d;
import p000a.p011i.C0078o;

public final class CopyDialog {
    private final SimpleActivity activity;
    private final CopyMoveListener copyMoveListener;
    private final ArrayList<File> files;

    /* renamed from: com.simplemobiletools.gallery.dialogs.CopyDialog.1 */
    static final class C13401 implements OnClickListener {
        final /* synthetic */ C0041d $destinationPath;
        final /* synthetic */ View $view;
        final /* synthetic */ CopyDialog this$0;

        /* renamed from: com.simplemobiletools.gallery.dialogs.CopyDialog.1.1 */
        static final class C13391 extends C0037g implements C0029b<String, C0055f> {
            final /* synthetic */ C13401 this$0;

            C13391(C13401 c13401) {
                this.this$0 = c13401;
                super(1);
            }

            public final void invoke(String str) {
                C0036f.m62b(str, "it");
                this.this$0.$destinationPath.f13a = str;
                ((TextView) this.this$0.$view.findViewById(C1333R.id.destination)).setText(ContextKt.humanizePath(this.this$0.this$0.getActivity(), str));
            }
        }

        C13401(CopyDialog copyDialog, C0041d c0041d, View view) {
            this.this$0 = copyDialog;
            this.$destinationPath = c0041d;
            this.$view = view;
        }

        public final void onClick(View view) {
            PickAlbumDialog pickAlbumDialog = new PickAlbumDialog(this.this$0.getActivity(), new C13391(this));
        }
    }

    public CopyDialog(SimpleActivity simpleActivity, ArrayList<File> arrayList, CopyMoveListener copyMoveListener) {
        C0036f.m62b(simpleActivity, "activity");
        C0036f.m62b(arrayList, "files");
        C0036f.m62b(copyMoveListener, "copyMoveListener");
        this.activity = simpleActivity;
        this.files = arrayList;
        this.copyMoveListener = copyMoveListener;
        View inflate = LayoutInflater.from(this.activity).inflate(C1333R.layout.dialog_copy_move, (ViewGroup) null);
        String a = C0078o.m121a(((File) this.files.get(0)).getParent(), '/');
        C0041d c0041d = new C0041d();
        c0041d.f13a = BuildConfig.FLAVOR;
        ((TextView) inflate.findViewById(C1333R.id.source)).setText(ContextKt.humanizePath(this.activity, a));
        ((TextView) inflate.findViewById(C1333R.id.destination)).setOnClickListener(new C13401(this, c0041d, inflate));
        AlertDialog create = new Builder(this.activity).setTitle(this.activity.getResources().getString(this.files.size() == 1 ? C1333R.string.copy_item : C1333R.string.copy_items)).setView(inflate).setPositiveButton(C1333R.string.ok, (DialogInterface.OnClickListener) null).setNegativeButton(C1333R.string.cancel, (DialogInterface.OnClickListener) null).create();
        Window window = create.getWindow();
        if (window == null) {
            C0036f.m58a();
        }
        window.setSoftInputMode(5);
        create.setCanceledOnTouchOutside(true);
        create.show();
        create.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new CopyDialog$$special$$inlined$apply$lambda$1(create, this, c0041d, inflate, a));
    }

    public final SimpleActivity getActivity() {
        return this.activity;
    }

    public final CopyMoveListener getCopyMoveListener() {
        return this.copyMoveListener;
    }

    public final ArrayList<File> getFiles() {
        return this.files;
    }
}
