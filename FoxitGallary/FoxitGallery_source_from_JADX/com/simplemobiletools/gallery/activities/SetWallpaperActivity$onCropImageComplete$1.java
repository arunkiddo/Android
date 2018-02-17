package com.simplemobiletools.gallery.activities;

import android.graphics.Bitmap;
import com.theartofdev.edmodo.cropper.CropImageView.C1347a;

final class SetWallpaperActivity$onCropImageComplete$1 implements Runnable {
    final /* synthetic */ C1347a $result;
    final /* synthetic */ SetWallpaperActivity this$0;

    SetWallpaperActivity$onCropImageComplete$1(SetWallpaperActivity setWallpaperActivity, C1347a c1347a) {
        this.this$0 = setWallpaperActivity;
        this.$result = c1347a;
    }

    public final void run() {
        Bitmap a = this.$result.m6339a();
        int desiredMinimumHeight = this.this$0.getWallpaperManager().getDesiredMinimumHeight();
        this.this$0.getWallpaperManager().setBitmap(Bitmap.createScaledBitmap(a, (int) ((((float) desiredMinimumHeight) / ((float) a.getHeight())) * ((float) a.getWidth())), desiredMinimumHeight, true));
        this.this$0.setResult(-1);
        this.this$0.finish();
    }
}
