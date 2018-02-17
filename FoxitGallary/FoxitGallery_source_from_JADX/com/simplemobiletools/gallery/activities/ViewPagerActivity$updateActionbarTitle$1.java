package com.simplemobiletools.gallery.activities;

import com.simplemobiletools.filepicker.extensions.StringKt;
import com.simplemobiletools.gallery.models.Medium;

final class ViewPagerActivity$updateActionbarTitle$1 implements Runnable {
    final /* synthetic */ ViewPagerActivity this$0;

    ViewPagerActivity$updateActionbarTitle$1(ViewPagerActivity viewPagerActivity) {
        this.this$0 = viewPagerActivity;
    }

    public final void run() {
        this.this$0.setTitle(StringKt.getFilenameFromPath(((Medium) this.this$0.mMedia.get(this.this$0.mPos)).getPath()));
    }
}
