package com.simplemobiletools.gallery.activities;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.util.Log;
import com.p045c.p046a.p058h.p069b.C1197g;
import com.p045c.p046a.p058h.p073a.C1261c;
import java.io.IOException;

public final class MediaActivity$itemClicked$1 extends C1197g<Bitmap> {
    final /* synthetic */ MediaActivity this$0;

    MediaActivity$itemClicked$1(MediaActivity mediaActivity) {
        this.this$0 = mediaActivity;
    }

    public void onResourceReady(Bitmap bitmap, C1261c<? super Bitmap> c1261c) {
        try {
            WallpaperManager.getInstance(this.this$0.getApplicationContext()).setBitmap(bitmap);
            this.this$0.setResult(-1);
        } catch (IOException e) {
            Log.e(MediaActivity.Companion.getTAG(), "item click " + e);
        }
        this.this$0.finish();
    }
}
