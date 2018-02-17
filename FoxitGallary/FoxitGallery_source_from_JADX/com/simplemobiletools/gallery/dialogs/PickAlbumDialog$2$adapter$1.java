package com.simplemobiletools.gallery.dialogs;

import com.simplemobiletools.gallery.dialogs.PickAlbumDialog.C13422;
import com.simplemobiletools.gallery.models.Directory;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class PickAlbumDialog$2$adapter$1 extends C0037g implements C0029b<Directory, C0055f> {
    final /* synthetic */ C13422 this$0;

    PickAlbumDialog$2$adapter$1(C13422 c13422) {
        this.this$0 = c13422;
        super(1);
    }

    public final void invoke(Directory directory) {
        C0036f.m62b(directory, "it");
        this.this$0.this$0.getCallback().invoke(directory.getPath());
        this.this$0.this$0.getDialog().dismiss();
    }
}
