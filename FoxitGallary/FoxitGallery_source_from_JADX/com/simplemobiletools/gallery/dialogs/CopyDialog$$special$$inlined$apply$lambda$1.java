package com.simplemobiletools.gallery.dialogs;

import android.app.AlertDialog;
import android.support.v4.p030j.C0391h;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.simplemobiletools.filepicker.asynctasks.CopyMoveTask;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.activities.SimpleActivity;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.helpers.Config.Companion;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0042h.C0041d;
import p000a.p011i.C0078o;

final class CopyDialog$$special$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ C0041d $destinationPath$inlined;
    final /* synthetic */ String $sourcePath$inlined;
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ AlertDialog receiver$0;
    final /* synthetic */ CopyDialog this$0;

    CopyDialog$$special$$inlined$apply$lambda$1(AlertDialog alertDialog, CopyDialog copyDialog, C0041d c0041d, View view, String str) {
        this.receiver$0 = alertDialog;
        this.this$0 = copyDialog;
        this.$destinationPath$inlined = c0041d;
        this.$view$inlined = view;
        this.$sourcePath$inlined = str;
    }

    public final void onClick(View view) {
        if (!C0036f.m61a((String) this.$destinationPath$inlined.f13a, this.receiver$0.getContext().getResources().getString(C1333R.string.select_destination))) {
            if (!(((CharSequence) ((String) this.$destinationPath$inlined.f13a)).length() == 0)) {
                if (C0036f.m61a(C0078o.m118a(((TextView) this.$view$inlined.findViewById(C1333R.id.source)).getText(), '/'), C0078o.m121a((String) this.$destinationPath$inlined.f13a, '/'))) {
                    ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.source_and_destination_same, 0, 2, null);
                    return;
                }
                File file = new File((String) this.$destinationPath$inlined.f13a);
                if (!file.exists()) {
                    ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.invalid_destination, 0, 2, null);
                    return;
                } else if (this.this$0.getFiles().size() == 1 && new File((String) this.$destinationPath$inlined.f13a, ((File) this.this$0.getFiles().get(0)).getName()).exists()) {
                    ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.already_exists, 0, 2, null);
                    return;
                } else if (!this.this$0.getActivity().isShowingPermDialog(file)) {
                    Companion companion = Config.Companion;
                    Object context = this.receiver$0.getContext();
                    C0036f.m59a(context, "context");
                    Config newInstance = companion.newInstance(context);
                    if (((RadioGroup) this.$view$inlined.findViewById(C1333R.id.dialog_radio_group)).getCheckedRadioButtonId() == C1333R.id.dialog_radio_copy) {
                        ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.copying, 0, 2, null);
                        C0391h c0391h = new C0391h(this.this$0.getFiles(), file);
                        context = this.receiver$0.getContext();
                        C0036f.m59a(context, "context");
                        new CopyMoveTask(context, false, newInstance.getTreeUri(), true, this.this$0.getCopyMoveListener()).execute(new C0391h[]{c0391h});
                        this.receiver$0.dismiss();
                        return;
                    } else if (ContextKt.isPathOnSD(this.receiver$0.getContext(), this.$sourcePath$inlined) || ContextKt.isPathOnSD(this.receiver$0.getContext(), (String) this.$destinationPath$inlined.f13a)) {
                        SimpleActivity activity = this.this$0.getActivity();
                        Object obj = (File) this.this$0.getFiles().get(0);
                        C0036f.m59a(obj, "files[0]");
                        if (!activity.isShowingPermDialog(obj)) {
                            ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.moving, 0, 2, null);
                            C0391h c0391h2 = new C0391h(this.this$0.getFiles(), file);
                            Object context2 = this.receiver$0.getContext();
                            C0036f.m59a(context2, "context");
                            new CopyMoveTask(context2, true, newInstance.getTreeUri(), true, this.this$0.getCopyMoveListener()).execute(new C0391h[]{c0391h2});
                            this.receiver$0.dismiss();
                            return;
                        }
                        return;
                    } else {
                        ArrayList arrayList = new ArrayList(this.this$0.getFiles().size() * 2);
                        arrayList.addAll(this.this$0.getFiles());
                        Iterator it = this.this$0.getFiles().iterator();
                        while (it.hasNext()) {
                            File file2 = (File) it.next();
                            File file3 = new File(file, file2.getName());
                            if (file2.renameTo(file3)) {
                                arrayList.add(file3);
                            }
                        }
                        ContextKt.scanFiles(this.receiver$0.getContext(), arrayList, new CopyDialog$$special$$inlined$apply$lambda$lambda$1(this, arrayList));
                        return;
                    }
                } else {
                    return;
                }
            }
        }
        ContextKt.toast$default(this.receiver$0.getContext(), (int) C1333R.string.please_select_destination, 0, 2, null);
    }
}
