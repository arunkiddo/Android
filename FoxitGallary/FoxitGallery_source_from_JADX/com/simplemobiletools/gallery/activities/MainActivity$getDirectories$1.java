package com.simplemobiletools.gallery.activities;

import com.simplemobiletools.gallery.models.Directory;
import java.util.ArrayList;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class MainActivity$getDirectories$1 extends C0037g implements C0029b<ArrayList<Directory>, C0055f> {
    final /* synthetic */ MainActivity this$0;

    MainActivity$getDirectories$1(MainActivity mainActivity) {
        this.this$0 = mainActivity;
        super(1);
    }

    public final void invoke(ArrayList<Directory> arrayList) {
        C0036f.m62b(arrayList, "it");
        this.this$0.gotDirectories(arrayList);
    }
}
