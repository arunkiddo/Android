package com.simplemobiletools.gallery.activities;

import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.C1333R;
import p000a.C0055f;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p007b.C0037g;

final class EditActivity$saveBitmapToFile$1 extends C0037g implements C0028a<C0055f> {
    final /* synthetic */ EditActivity this$0;

    /* renamed from: com.simplemobiletools.gallery.activities.EditActivity.saveBitmapToFile.1.1 */
    static final class C13341 implements Runnable {
        final /* synthetic */ EditActivity$saveBitmapToFile$1 this$0;

        C13341(EditActivity$saveBitmapToFile$1 editActivity$saveBitmapToFile$1) {
            this.this$0 = editActivity$saveBitmapToFile$1;
        }

        public final void run() {
            ContextKt.toast$default(this.this$0.this$0, (int) C1333R.string.file_saved, 0, 2, null);
        }
    }

    EditActivity$saveBitmapToFile$1(EditActivity editActivity) {
        this.this$0 = editActivity;
        super(0);
    }

    public final void invoke() {
        this.this$0.setResult(-1, this.this$0.getIntent());
        this.this$0.runOnUiThread(new C13341(this));
        this.this$0.finish();
    }
}
