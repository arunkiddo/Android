package com.simplemobiletools.gallery.activities;

import com.simplemobiletools.gallery.models.Medium;
import java.io.File;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class ViewPagerActivity$renameFile$1 extends C0037g implements C0029b<File, C0055f> {
    final /* synthetic */ ViewPagerActivity this$0;

    ViewPagerActivity$renameFile$1(ViewPagerActivity viewPagerActivity) {
        this.this$0 = viewPagerActivity;
        super(1);
    }

    public final void invoke(File file) {
        C0036f.m62b(file, "it");
        Medium medium = (Medium) this.this$0.mMedia.get(this.this$0.mPos);
        Object absolutePath = file.getAbsolutePath();
        C0036f.m59a(absolutePath, "it.absolutePath");
        medium.setPath(absolutePath);
        this.this$0.updateActionbarTitle();
    }
}
