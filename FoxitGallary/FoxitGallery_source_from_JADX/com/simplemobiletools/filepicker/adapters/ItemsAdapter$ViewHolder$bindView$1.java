package com.simplemobiletools.filepicker.adapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.simplemobiletools.filepicker.adapters.ItemsAdapter.ViewHolder;
import com.simplemobiletools.filepicker.models.FileDirItem;

final class ItemsAdapter$ViewHolder$bindView$1 implements OnClickListener {
    final /* synthetic */ FileDirItem $fileDirItem;
    final /* synthetic */ ViewHolder this$0;

    ItemsAdapter$ViewHolder$bindView$1(ViewHolder viewHolder, FileDirItem fileDirItem) {
        this.this$0 = viewHolder;
        this.$fileDirItem = fileDirItem;
    }

    public final void onClick(View view) {
        this.this$0.getItemClick().invoke(this.$fileDirItem);
    }
}
