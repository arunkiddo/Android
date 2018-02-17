package com.simplemobiletools.gallery.activities;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

final class MainActivity$gotDirectories$1 implements OnTouchListener {
    final /* synthetic */ MainActivity this$0;

    MainActivity$gotDirectories$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.this$0.checkDelete();
        return false;
    }
}
