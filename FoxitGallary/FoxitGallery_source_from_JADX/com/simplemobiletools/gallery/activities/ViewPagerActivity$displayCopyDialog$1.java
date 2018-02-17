package com.simplemobiletools.gallery.activities;

import com.simplemobiletools.filepicker.asynctasks.CopyMoveTask.CopyMoveListener;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.C1333R;

public final class ViewPagerActivity$displayCopyDialog$1 implements CopyMoveListener {
    final /* synthetic */ ViewPagerActivity this$0;

    ViewPagerActivity$displayCopyDialog$1(ViewPagerActivity viewPagerActivity) {
        this.this$0 = viewPagerActivity;
    }

    public void copyFailed() {
        ContextKt.toast$default(this.this$0, (int) C1333R.string.copy_move_failed, 0, 2, null);
    }

    public void copySucceeded(boolean z, boolean z2) {
        if (z) {
            this.this$0.reloadViewPager();
            ContextKt.toast$default(this.this$0, z2 ? C1333R.string.moving_success : C1333R.string.moving_success_partial, 0, 2, null);
            return;
        }
        ContextKt.toast$default(this.this$0, z2 ? C1333R.string.copying_success : C1333R.string.copying_success_partial, 0, 2, null);
    }
}
