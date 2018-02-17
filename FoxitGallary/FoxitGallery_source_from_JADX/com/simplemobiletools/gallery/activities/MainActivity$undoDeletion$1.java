package com.simplemobiletools.gallery.activities;

import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.View.OnClickListener;
import p000a.p005e.p007b.C0036f;

final class MainActivity$undoDeletion$1 implements OnClickListener {
    final /* synthetic */ MainActivity this$0;

    MainActivity$undoDeletion$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final void onClick(View view) {
        Snackbar access$getMSnackbar$p = MainActivity.Companion.getMSnackbar();
        if (access$getMSnackbar$p == null) {
            C0036f.m58a();
        }
        access$getMSnackbar$p.m609b();
        MainActivity.Companion.getMToBeDeleted().clear();
        this.this$0.getDirectories();
    }
}
