package com.simplemobiletools.gallery.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.C1333R;
import p000a.p005e.p007b.C0036f;

final class ResizeDialog$$special$$inlined$apply$lambda$1 implements OnClickListener {
    final /* synthetic */ EditText $heightView$inlined;
    final /* synthetic */ EditText $widthView$inlined;
    final /* synthetic */ AlertDialog receiver$0;
    final /* synthetic */ ResizeDialog this$0;

    ResizeDialog$$special$$inlined$apply$lambda$1(AlertDialog alertDialog, ResizeDialog resizeDialog, EditText editText, EditText editText2) {
        this.receiver$0 = alertDialog;
        this.this$0 = resizeDialog;
        this.$widthView$inlined = editText;
        this.$heightView$inlined = editText2;
    }

    public final void onClick(View view) {
        ResizeDialog resizeDialog = this.this$0;
        Object obj = this.$widthView$inlined;
        C0036f.m59a(obj, "widthView");
        int viewValue = resizeDialog.getViewValue(obj);
        ResizeDialog resizeDialog2 = this.this$0;
        Object obj2 = this.$heightView$inlined;
        C0036f.m59a(obj2, "heightView");
        int viewValue2 = resizeDialog2.getViewValue(obj2);
        if (viewValue <= 0 || viewValue2 <= 0) {
            ContextKt.toast$default((Context) this.this$0.getActivity(), (int) C1333R.string.invalid_values, 0, 2, null);
            return;
        }
        resizeDialog2 = this.this$0;
        obj2 = this.$widthView$inlined;
        C0036f.m59a(obj2, "widthView");
        viewValue2 = resizeDialog2.getViewValue(obj2);
        ResizeDialog resizeDialog3 = this.this$0;
        Object obj3 = this.$heightView$inlined;
        C0036f.m59a(obj3, "heightView");
        this.this$0.getCallback().invoke(new Point(viewValue2, resizeDialog3.getViewValue(obj3)));
        this.receiver$0.dismiss();
    }
}
