package com.simplemobiletools.filepicker.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.simplemobiletools.filepicker.C1328R;
import com.simplemobiletools.gallery.BuildConfig;
import p000a.C0055f;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p007b.C0034d;
import p000a.p005e.p007b.C0036f;

public final class ConfirmationDialog {
    private final C0028a<C0055f> callback;
    private AlertDialog dialog;

    public ConfirmationDialog(Context context, String str, int i, int i2, int i3, C0028a<C0055f> c0028a) {
        C0036f.m62b(context, "context");
        C0036f.m62b(str, "message");
        C0036f.m62b(c0028a, "callback");
        this.callback = c0028a;
        Builder positiveButton = new Builder(context).setPositiveButton(i2, new ConfirmationDialog$builder$1(this));
        if (((CharSequence) str).length() == 0) {
            positiveButton.setMessage(i);
        } else {
            positiveButton.setMessage(str);
        }
        if (i3 != 0) {
            positiveButton.setNegativeButton(i3, (OnClickListener) null);
        }
        this.dialog = positiveButton.create();
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

    public /* synthetic */ ConfirmationDialog(Context context, String str, int i, int i2, int i3, C0028a c0028a, int i4, C0034d c0034d) {
        this(context, (i4 & 2) != 0 ? BuildConfig.FLAVOR : str, (i4 & 4) != 0 ? C1328R.string.smtfp_proceed_with_deletion : i, (i4 & 8) != 0 ? C1328R.string.smtfp_yes : i2, (i4 & 16) != 0 ? C1328R.string.smtfp_no : i3, c0028a);
    }

    private final void dialogConfirmed() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.filepicker.dialogs.ConfirmationDialog.dialogConfirmed():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 7 more
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
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.filepicker.dialogs.ConfirmationDialog.dialogConfirmed():void");
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
