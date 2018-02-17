package com.simplemobiletools.gallery.extensions;

import android.view.View;
import p000a.p005e.p007b.C0036f;

public final class ViewKt {
    public static final void beVisibleIf(View view, boolean z) {
        C0036f.m62b(view, "$receiver");
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }
}
