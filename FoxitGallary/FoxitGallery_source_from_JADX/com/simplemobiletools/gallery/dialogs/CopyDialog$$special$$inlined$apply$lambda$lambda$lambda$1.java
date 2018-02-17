package com.simplemobiletools.gallery.dialogs;

final class CopyDialog$$special$$inlined$apply$lambda$lambda$lambda$1 implements Runnable {
    final /* synthetic */ CopyDialog$$special$$inlined$apply$lambda$lambda$1 this$0;

    CopyDialog$$special$$inlined$apply$lambda$lambda$lambda$1(CopyDialog$$special$$inlined$apply$lambda$lambda$1 copyDialog$$special$$inlined$apply$lambda$lambda$1) {
        this.this$0 = copyDialog$$special$$inlined$apply$lambda$lambda$1;
    }

    public final void run() {
        this.this$0.this$0.this$0.getCopyMoveListener().copySucceeded(true, this.this$0.this$0.this$0.getFiles().size() * 2 == this.this$0.$updatedFiles.size());
        this.this$0.this$0.receiver$0.dismiss();
    }
}
