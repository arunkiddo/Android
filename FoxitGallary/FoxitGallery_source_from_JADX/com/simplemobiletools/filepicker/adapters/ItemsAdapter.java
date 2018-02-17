package com.simplemobiletools.filepicker.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView.C0829a;
import android.support.v7.widget.RecyclerView.C0853v;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.p045c.p046a.C1288i;
import com.p045c.p046a.p050d.p052b.C1056b;
import com.simplemobiletools.filepicker.C1328R;
import com.simplemobiletools.filepicker.extensions.FileKt;
import com.simplemobiletools.filepicker.extensions.LongKt;
import com.simplemobiletools.filepicker.models.FileDirItem;
import java.io.File;
import java.util.List;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;

public final class ItemsAdapter extends C0829a<ViewHolder> {
    private final Context context;
    private final C0029b<FileDirItem, C0055f> itemClick;
    private final List<FileDirItem> mItems;

    public static final class ViewHolder extends C0853v {
        private final Context context;
        private final C0029b<FileDirItem, C0055f> itemClick;

        public ViewHolder(Context context, View view, C0029b<? super FileDirItem, C0055f> c0029b) {
            C0036f.m62b(context, "context");
            C0036f.m62b(view, "view");
            C0036f.m62b(c0029b, "itemClick");
            super(view);
            this.context = context;
            this.itemClick = c0029b;
        }

        private final C1056b getCacheStrategy(FileDirItem fileDirItem) {
            return FileKt.isGif(new File(fileDirItem.getPath())) ? C1056b.NONE : C1056b.RESULT;
        }

        private final String getChildrenCnt(FileDirItem fileDirItem) {
            int children = fileDirItem.getChildren();
            Object quantityString = this.context.getResources().getQuantityString(C1328R.plurals.smtfp_items, children, new Object[]{Integer.valueOf(children)});
            C0036f.m59a(quantityString, "context.resources.getQua\u2026tems, children, children)");
            return quantityString;
        }

        public final void bindView(FileDirItem fileDirItem) {
            C0036f.m62b(fileDirItem, "fileDirItem");
            ((TextView) this.itemView.findViewById(C1328R.id.item_name)).setText(fileDirItem.getName());
            if (fileDirItem.isDirectory()) {
                C1288i.m6077b(this.context).m6136a(Integer.valueOf(C1328R.mipmap.smtfp_directory)).m5238a(getCacheStrategy(fileDirItem)).m5235a().m5256c().m5245a((ImageView) this.itemView.findViewById(C1328R.id.item_icon));
                ((TextView) this.itemView.findViewById(C1328R.id.item_details)).setText(getChildrenCnt(fileDirItem));
            } else {
                C1288i.m6077b(this.context).m6137a(fileDirItem.getPath()).m5238a(getCacheStrategy(fileDirItem)).m5247b(C1328R.mipmap.smtfp_file).m5235a().m5256c().m5245a((ImageView) this.itemView.findViewById(C1328R.id.item_icon));
                ((TextView) this.itemView.findViewById(C1328R.id.item_details)).setText(LongKt.formatSize(fileDirItem.getSize()));
            }
            this.itemView.setOnClickListener(new ItemsAdapter$ViewHolder$bindView$1(this, fileDirItem));
        }

        public final Context getContext() {
            return this.context;
        }

        public final C0029b<FileDirItem, C0055f> getItemClick() {
            return this.itemClick;
        }
    }

    public ItemsAdapter(Context context, List<FileDirItem> list, C0029b<? super FileDirItem, C0055f> c0029b) {
        C0036f.m62b(context, "context");
        C0036f.m62b(list, "mItems");
        C0036f.m62b(c0029b, "itemClick");
        this.context = context;
        this.mItems = list;
        this.itemClick = c0029b;
    }

    public final Context getContext() {
        return this.context;
    }

    public final C0029b<FileDirItem, C0055f> getItemClick() {
        return this.itemClick;
    }

    public int getItemCount() {
        return this.mItems.size();
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0036f.m62b(viewHolder, "holder");
        viewHolder.bindView((FileDirItem) this.mItems.get(i));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Object inflate = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null).inflate(C1328R.layout.smtfp_list_item, viewGroup, false);
        Context context = this.context;
        C0036f.m59a(inflate, "view");
        return new ViewHolder(context, inflate, this.itemClick);
    }
}
