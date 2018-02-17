package com.simplemobiletools.gallery.adapters;

import android.view.View;
import android.view.View.OnClickListener;
import com.p040a.p041a.p042a.C0966b;
import com.simplemobiletools.gallery.adapters.MediaAdapter.ViewHolder;
import com.simplemobiletools.gallery.models.Medium;

final class MediaAdapter$ViewHolder$bindView$1 implements OnClickListener {
    final /* synthetic */ Medium $medium;
    final /* synthetic */ C0966b $multiSelector;
    final /* synthetic */ int $pos;
    final /* synthetic */ ViewHolder this$0;

    MediaAdapter$ViewHolder$bindView$1(ViewHolder viewHolder, C0966b c0966b, Medium medium, int i) {
        this.this$0 = viewHolder;
        this.$multiSelector = c0966b;
        this.$medium = medium;
        this.$pos = i;
    }

    public final void onClick(View view) {
        this.this$0.viewClicked(this.$multiSelector, this.$medium, this.$pos);
    }
}
