package com.simplemobiletools.gallery.activities;

import android.graphics.Point;
import com.simplemobiletools.gallery.C1333R;
import com.theartofdev.edmodo.cropper.CropImageView;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class EditActivity$resizeImage$1 extends C0037g implements C0029b<Point, C0055f> {
    final /* synthetic */ EditActivity this$0;

    EditActivity$resizeImage$1(EditActivity editActivity) {
        this.this$0 = editActivity;
        super(1);
    }

    public final void invoke(Point point) {
        C0036f.m62b(point, "it");
        this.this$0.setResizeWidth(point.x);
        this.this$0.setResizeHeight(point.y);
        ((CropImageView) this.this$0._$_findCachedViewById(C1333R.id.crop_image_view)).getCroppedImageAsync();
    }
}
