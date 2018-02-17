package com.simplemobiletools.gallery.dialogs;

import java.util.ArrayList;
import p000a.C0055f;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p007b.C0037g;

final class CopyDialog$$special$$inlined$apply$lambda$lambda$1 extends C0037g implements C0028a<C0055f> {
    final /* synthetic */ ArrayList $updatedFiles;
    final /* synthetic */ CopyDialog$$special$$inlined$apply$lambda$1 this$0;

    CopyDialog$$special$$inlined$apply$lambda$lambda$1(CopyDialog$$special$$inlined$apply$lambda$1 copyDialog$$special$$inlined$apply$lambda$1, ArrayList arrayList) {
        this.this$0 = copyDialog$$special$$inlined$apply$lambda$1;
        this.$updatedFiles = arrayList;
        super(0);
    }

    public final void invoke() {
        this.this$0.this$0.getActivity().runOnUiThread(new CopyDialog$$special$$inlined$apply$lambda$lambda$lambda$1(this));
    }
}
