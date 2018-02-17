package com.simplemobiletools.filepicker.extensions;

import android.media.MediaScannerConnection.OnScanCompletedListener;
import android.net.Uri;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p007b.C0042h.C0039b;

final class ContextKt$rescanPaths$1 implements OnScanCompletedListener {
    final /* synthetic */ C0028a $action;
    final /* synthetic */ C0039b $cnt;

    ContextKt$rescanPaths$1(C0039b c0039b, C0028a c0028a) {
        this.$cnt = c0039b;
        this.$action = c0028a;
    }

    public final void onScanCompleted(String str, Uri uri) {
        C0039b c0039b = this.$cnt;
        c0039b.f11a--;
        if (c0039b.f11a == 0) {
            this.$action.invoke();
        }
    }
}
