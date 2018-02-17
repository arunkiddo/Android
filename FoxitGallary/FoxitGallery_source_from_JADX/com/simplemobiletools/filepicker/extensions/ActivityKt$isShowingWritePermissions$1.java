package com.simplemobiletools.filepicker.extensions;

import android.app.Activity;
import android.content.Intent;
import p000a.C0055f;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p007b.C0037g;

final class ActivityKt$isShowingWritePermissions$1 extends C0037g implements C0028a<C0055f> {
    final /* synthetic */ int $requestCode;
    final /* synthetic */ Activity receiver$0;

    ActivityKt$isShowingWritePermissions$1(Activity activity, int i) {
        this.receiver$0 = activity;
        this.$requestCode = i;
        super(0);
    }

    public final void invoke() {
        this.receiver$0.startActivityForResult(new Intent("android.intent.action.OPEN_DOCUMENT_TREE"), this.$requestCode);
    }
}
