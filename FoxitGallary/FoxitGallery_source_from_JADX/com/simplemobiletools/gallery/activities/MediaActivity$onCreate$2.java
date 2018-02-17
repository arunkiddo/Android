package com.simplemobiletools.gallery.activities;

import android.support.v4.widget.SwipeRefreshLayout.C0577a;

final class MediaActivity$onCreate$2 implements C0577a {
    final /* synthetic */ MediaActivity this$0;

    MediaActivity$onCreate$2(MediaActivity mediaActivity) {
        this.this$0 = mediaActivity;
    }

    public final void onRefresh() {
        this.this$0.getMedia();
    }
}
