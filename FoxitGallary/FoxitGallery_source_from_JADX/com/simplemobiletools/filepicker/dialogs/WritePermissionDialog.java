package com.simplemobiletools.filepicker.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.simplemobiletools.filepicker.C1328R;
import p000a.C0055f;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p007b.C0036f;

public final class WritePermissionDialog {
    private final C0028a<C0055f> callback;
    private AlertDialog dialog;

    /* renamed from: com.simplemobiletools.filepicker.dialogs.WritePermissionDialog.1 */
    static final class C13311 implements OnClickListener {
        final /* synthetic */ WritePermissionDialog this$0;

        C13311(WritePermissionDialog writePermissionDialog) {
            this.this$0 = writePermissionDialog;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            this.this$0.dialogConfirmed();
        }
    }

    public WritePermissionDialog(Context context, C0028a<C0055f> c0028a) {
        C0036f.m62b(context, "context");
        C0036f.m62b(c0028a, "callback");
        this.callback = c0028a;
        this.dialog = new Builder(context).setTitle(context.getResources().getString(C1328R.string.smtfp_confirm_storage_access_title)).setView(LayoutInflater.from(context).inflate(C1328R.layout.smtfp_dialog_write_permission, (ViewGroup) null)).setPositiveButton(C1328R.string.smtfp_ok, new C13311(this)).create();
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null) {
            C0036f.m58a();
        }
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog = this.dialog;
        if (alertDialog == null) {
            C0036f.m58a();
        }
        alertDialog.show();
    }

    private final void dialogConfirmed() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.filepicker.dialogs.WritePermissionDialog.dialogConfirmed():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 5 more
*/
        /*
        r0 = this;
        r0 = r1.dialog;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0.dismiss();
        r0 = r1.callback;
        r0.invoke();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.filepicker.dialogs.WritePermissionDialog.dialogConfirmed():void");
    }

    public final C0028a<C0055f> getCallback() {
        return this.callback;
    }

    public final AlertDialog getDialog() {
        return this.dialog;
    }

    public final void setDialog(AlertDialog alertDialog) {
        this.dialog = alertDialog;
    }
}
