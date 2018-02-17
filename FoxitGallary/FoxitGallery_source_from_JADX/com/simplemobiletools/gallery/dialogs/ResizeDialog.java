package com.simplemobiletools.gallery.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Point;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.activities.SimpleActivity;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;

public final class ResizeDialog {
    private final SimpleActivity activity;
    private final C0029b<Point, C0055f> callback;
    private final Point size;

    /* renamed from: com.simplemobiletools.gallery.dialogs.ResizeDialog.1 */
    public static final class C13431 implements TextWatcher {
        final /* synthetic */ EditText $heightView;
        final /* synthetic */ float $ratio;
        final /* synthetic */ View $view;
        final /* synthetic */ EditText $widthView;
        final /* synthetic */ ResizeDialog this$0;

        C13431(ResizeDialog resizeDialog, EditText editText, View view, EditText editText2, float f) {
            this.this$0 = resizeDialog;
            this.$widthView = editText;
            this.$view = view;
            this.$heightView = editText2;
            this.$ratio = f;
        }

        public void afterTextChanged(Editable editable) {
            if (this.$widthView.hasFocus()) {
                int i;
                ResizeDialog resizeDialog = this.this$0;
                Object obj = this.$widthView;
                C0036f.m59a(obj, "widthView");
                int viewValue = resizeDialog.getViewValue(obj);
                if (viewValue > this.this$0.getSize().x) {
                    this.$widthView.setText(String.valueOf(this.this$0.getSize().x));
                    i = this.this$0.getSize().x;
                } else {
                    i = viewValue;
                }
                if (((CheckBox) this.$view.findViewById(C1333R.id.keep_aspect_ratio)).isChecked()) {
                    this.$heightView.setText(String.valueOf((int) (((float) i) / this.$ratio)));
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: com.simplemobiletools.gallery.dialogs.ResizeDialog.2 */
    public static final class C13442 implements TextWatcher {
        final /* synthetic */ EditText $heightView;
        final /* synthetic */ float $ratio;
        final /* synthetic */ View $view;
        final /* synthetic */ EditText $widthView;
        final /* synthetic */ ResizeDialog this$0;

        C13442(ResizeDialog resizeDialog, EditText editText, View view, EditText editText2, float f) {
            this.this$0 = resizeDialog;
            this.$heightView = editText;
            this.$view = view;
            this.$widthView = editText2;
            this.$ratio = f;
        }

        public void afterTextChanged(Editable editable) {
            if (this.$heightView.hasFocus()) {
                int i;
                ResizeDialog resizeDialog = this.this$0;
                Object obj = this.$heightView;
                C0036f.m59a(obj, "heightView");
                int viewValue = resizeDialog.getViewValue(obj);
                if (viewValue > this.this$0.getSize().y) {
                    this.$heightView.setText(String.valueOf(this.this$0.getSize().y));
                    i = this.this$0.getSize().y;
                } else {
                    i = viewValue;
                }
                if (((CheckBox) this.$view.findViewById(C1333R.id.keep_aspect_ratio)).isChecked()) {
                    this.$widthView.setText(String.valueOf((int) (((float) i) * this.$ratio)));
                }
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public ResizeDialog(SimpleActivity simpleActivity, Point point, C0029b<? super Point, C0055f> c0029b) {
        C0036f.m62b(simpleActivity, "activity");
        C0036f.m62b(point, "size");
        C0036f.m62b(c0029b, "callback");
        this.activity = simpleActivity;
        this.size = point;
        this.callback = c0029b;
        View inflate = LayoutInflater.from(this.activity).inflate(C1333R.layout.resize_image, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(C1333R.id.image_width);
        EditText editText2 = (EditText) inflate.findViewById(C1333R.id.image_height);
        editText.setText(String.valueOf(this.size.x));
        editText2.setText(String.valueOf(this.size.y));
        float f = ((float) this.size.x) / ((float) this.size.y);
        editText.addTextChangedListener(new C13431(this, editText, inflate, editText2, f));
        editText2.addTextChangedListener(new C13442(this, editText2, inflate, editText, f));
        AlertDialog create = new Builder(this.activity).setTitle(this.activity.getResources().getString(C1333R.string.resize_and_save)).setView(inflate).setPositiveButton(C1333R.string.ok, (OnClickListener) null).setNegativeButton(C1333R.string.cancel, (OnClickListener) null).create();
        Window window = create.getWindow();
        if (window == null) {
            C0036f.m58a();
        }
        window.setSoftInputMode(5);
        create.setCanceledOnTouchOutside(true);
        create.show();
        create.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new ResizeDialog$$special$$inlined$apply$lambda$1(create, this, editText, editText2));
    }

    public final SimpleActivity getActivity() {
        return this.activity;
    }

    public final C0029b<Point, C0055f> getCallback() {
        return this.callback;
    }

    public final Point getSize() {
        return this.size;
    }

    public final int getViewValue(android.widget.EditText r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.dialogs.ResizeDialog.getViewValue(android.widget.EditText):int
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
        r2 = 0;
        r0 = "view";
        p000a.p005e.p007b.C0036f.m62b(r4, r0);
        r1 = com.simplemobiletools.filepicker.extensions.EditTextKt.getValue(r4);
        r0 = r1;
        r0 = (java.lang.CharSequence) r0;
        r0 = r0.length();
        if (r0 != 0) goto L_0x0019;
    L_0x0014:
        r0 = 1;
        if (r0 == 0) goto L_0x001b;
    L_0x0017:
        r0 = r2;
        return r0;
    L_0x0019:
        r0 = r2;
        goto L_0x0015;
        r0 = java.lang.Integer.parseInt(r1);
        goto L_0x0018;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.dialogs.ResizeDialog.getViewValue(android.widget.EditText):int");
    }
}
