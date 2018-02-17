package com.simplemobiletools.gallery.activities;

import com.simplemobiletools.gallery.models.Directory;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class MainActivity$gotDirectories$adapter$1 extends C0037g implements C0029b<Directory, C0055f> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$gotDirectories$adapter$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
        super(1);
    }

    public final void invoke(Directory directory) {
        C0036f.m62b(directory, "it");
        this.this$0.itemClicked(directory.getPath());
    }
}
