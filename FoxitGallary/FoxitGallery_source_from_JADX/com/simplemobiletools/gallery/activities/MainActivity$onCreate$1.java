package com.simplemobiletools.gallery.activities;

import android.support.v4.widget.SwipeRefreshLayout.C0577a;

final class MainActivity$onCreate$1 implements C0577a {
    final /* synthetic */ MainActivity this$0;

    MainActivity$onCreate$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void onRefresh() {
        this.this$0.getDirectories();
    }
}
