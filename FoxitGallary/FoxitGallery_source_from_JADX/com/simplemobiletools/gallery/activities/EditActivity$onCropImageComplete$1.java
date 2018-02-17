package com.simplemobiletools.gallery.activities;

import com.theartofdev.edmodo.cropper.CropImageView.C1347a;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class EditActivity$onCropImageComplete$1 extends C0037g implements C0029b<String, C0055f> {
    final /* synthetic */ C1347a $result;
    final /* synthetic */ EditActivity this$0;

    EditActivity$onCropImageComplete$1(EditActivity editActivity, C1347a c1347a) {
        this.this$0 = editActivity;
        this.$result = c1347a;
        super(1);
    }

    public final void invoke(String str) {
        C0036f.m62b(str, "it");
        EditActivity editActivity = this.this$0;
        Object a = this.$result.m6339a();
        C0036f.m59a(a, "result.bitmap");
        editActivity.saveBitmapToFile(a, str);
    }
}
