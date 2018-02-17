package com.simplemobiletools.gallery.activities;

import com.simplemobiletools.gallery.models.Medium;
import java.util.ArrayList;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class MediaActivity$getMedia$1 extends C0037g implements C0029b<ArrayList<Medium>, C0055f> {
    final /* synthetic */ MediaActivity this$0;

    MediaActivity$getMedia$1(MediaActivity mediaActivity) {
        this.this$0 = mediaActivity;
        super(1);
    }

    public final void invoke(ArrayList<Medium> arrayList) {
        C0036f.m62b(arrayList, "it");
        this.this$0.gotMedia(arrayList);
    }
}
