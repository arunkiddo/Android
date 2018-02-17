package com.simplemobiletools.filepicker.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.LayoutParams;
import com.simplemobiletools.filepicker.C1328R;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.StringKt;
import p000a.C0027d;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;

public final class StoragePickerDialog {
    private final C0029b<String, C0055f> callback;
    private final Context context;
    private AlertDialog mDialog;

    public StoragePickerDialog(Context context, String str, C0029b<? super String, C0055f> c0029b) {
        C0036f.m62b(context, "context");
        C0036f.m62b(str, "currPath");
        C0036f.m62b(c0029b, "callback");
        this.context = context;
        this.callback = c0029b;
        LayoutInflater from = LayoutInflater.from(this.context);
        Resources resources = this.context.getResources();
        Object basePath = StringKt.getBasePath(str, this.context);
        LayoutParams layoutParams = new LayoutParams(-1, -2);
        View inflate = from.inflate(C1328R.layout.smtfp_radio_group, (ViewGroup) null);
        if (inflate == null) {
            throw new C0027d("null cannot be cast to non-null type android.widget.RadioGroup");
        }
        RadioGroup radioGroup = (RadioGroup) inflate;
        View inflate2 = from.inflate(C1328R.layout.smtfp_radio_button, (ViewGroup) null);
        if (inflate2 == null) {
            throw new C0027d("null cannot be cast to non-null type android.widget.RadioButton");
        }
        RadioButton radioButton = (RadioButton) inflate2;
        RadioButton radioButton2 = radioButton;
        radioButton2.setText(resources.getString(C1328R.string.smtfp_internal));
        radioButton2.setChecked(C0036f.m61a(basePath, ContextKt.getInternalStoragePath(radioButton2.getContext())));
        radioButton2.setOnClickListener(new StoragePickerDialog$$special$$inlined$apply$lambda$1(this, resources, basePath));
        radioGroup.addView(radioButton, layoutParams);
        if (isSDCardAvailable()) {
            inflate2 = from.inflate(C1328R.layout.smtfp_radio_button, (ViewGroup) null);
            if (inflate2 == null) {
                throw new C0027d("null cannot be cast to non-null type android.widget.RadioButton");
            }
            radioButton = (RadioButton) inflate2;
            radioButton2 = radioButton;
            radioButton2.setText(resources.getString(C1328R.string.smtfp_sd_card));
            radioButton2.setChecked(C0036f.m61a(basePath, ContextKt.getSDCardPath(radioButton2.getContext())));
            radioButton2.setOnClickListener(new StoragePickerDialog$$special$$inlined$apply$lambda$2(this, resources, basePath));
            radioGroup.addView(radioButton, layoutParams);
        }
        View inflate3 = from.inflate(C1328R.layout.smtfp_radio_button, (ViewGroup) null);
        if (inflate3 == null) {
            throw new C0027d("null cannot be cast to non-null type android.widget.RadioButton");
        }
        RadioButton radioButton3 = (RadioButton) inflate3;
        radioButton = radioButton3;
        radioButton.setText(resources.getString(C1328R.string.smtfp_root));
        radioButton.setChecked(C0036f.m61a(basePath, (Object) "/"));
        radioButton.setOnClickListener(new StoragePickerDialog$$special$$inlined$apply$lambda$3(this, resources, basePath));
        radioGroup.addView(radioButton3, layoutParams);
        this.mDialog = new Builder(this.context).setTitle(resources.getString(C1328R.string.smtfp_select_storage)).setView(radioGroup).create();
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog == null) {
            C0036f.m58a();
        }
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog = this.mDialog;
        if (alertDialog == null) {
            C0036f.m58a();
        }
        alertDialog.show();
    }

    private final void internalPicked() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.filepicker.dialogs.StoragePickerDialog.internalPicked():void
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
        r0 = r2.mDialog;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0.dismiss();
        r0 = r2.callback;
        r1 = r2.context;
        r1 = com.simplemobiletools.filepicker.extensions.ContextKt.getInternalStoragePath(r1);
        r0.invoke(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.filepicker.dialogs.StoragePickerDialog.internalPicked():void");
    }

    private final boolean isSDCardAvailable() {
        if (VERSION.SDK_INT >= 21 && C0036f.m61a(Environment.getExternalStorageState(), (Object) "mounted")) {
            if ((((CharSequence) ContextKt.getSDCardPath(this.context)).length() == 0 ? 1 : null) == null) {
                return true;
            }
        }
        return false;
    }

    private final void rootPicked() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.filepicker.dialogs.StoragePickerDialog.rootPicked():void
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
        r0 = r2.mDialog;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0.dismiss();
        r0 = r2.callback;
        r1 = "/";
        r0.invoke(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.filepicker.dialogs.StoragePickerDialog.rootPicked():void");
    }

    private final void sdPicked() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.filepicker.dialogs.StoragePickerDialog.sdPicked():void
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
        r0 = r2.mDialog;
        if (r0 == 0) goto L_0x0007;
    L_0x0004:
        r0.dismiss();
        r0 = r2.callback;
        r1 = r2.context;
        r1 = com.simplemobiletools.filepicker.extensions.ContextKt.getSDCardPath(r1);
        r0.invoke(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.filepicker.dialogs.StoragePickerDialog.sdPicked():void");
    }

    public final C0029b<String, C0055f> getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    public final AlertDialog getMDialog() {
        return this.mDialog;
    }

    public final void setMDialog(AlertDialog alertDialog) {
        this.mDialog = alertDialog;
    }
}
