package com.simplemobiletools.gallery.activities;

import com.simplemobiletools.gallery.models.Medium;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class MediaActivity$initializeGallery$adapter$1 extends C0037g implements C0029b<Medium, C0055f> {
    final /* synthetic */ MediaActivity this$0;

    MediaActivity$initializeGallery$adapter$1(MediaActivity mediaActivity) {
        this.this$0 = mediaActivity;
        super(1);
    }

    public final void invoke(Medium medium) {
        C0036f.m62b(medium, "it");
        this.this$0.itemClicked(medium.getPath());
    }
}
