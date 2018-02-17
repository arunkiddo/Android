package com.simplemobiletools.gallery.adapters;

import android.support.v7.view.C0716b;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.p040a.p041a.p042a.C0965a;
import com.p040a.p041a.p042a.C0966b;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.adapters.MediaAdapter.Companion;
import p000a.p005e.p007b.C0036f;

public final class MediaAdapter$multiSelectorMode$1 extends C0965a {
    final /* synthetic */ MediaAdapter this$0;

    MediaAdapter$multiSelectorMode$1(MediaAdapter mediaAdapter, C0966b c0966b) {
        this.this$0 = mediaAdapter;
        super(c0966b);
    }

    public boolean onActionItemClicked(C0716b c0716b, MenuItem menuItem) {
        C0036f.m62b(c0716b, "mode");
        C0036f.m62b(menuItem, "item");
        switch (menuItem.getItemId()) {
            case C1333R.id.cab_properties /*2131624204*/:
                this.this$0.showProperties();
                return true;
            case C1333R.id.cab_rename /*2131624207*/:
                this.this$0.renameFile();
                return true;
            case C1333R.id.cab_copy_move /*2131624210*/:
                this.this$0.displayCopyDialog();
                return true;
            case C1333R.id.cab_delete /*2131624211*/:
                this.this$0.askConfirmDelete();
                return true;
            case C1333R.id.cab_share /*2131624212*/:
                this.this$0.shareMedia();
                return true;
            case C1333R.id.cab_edit /*2131624213*/:
                this.this$0.editFile();
                return true;
            case C1333R.id.cab_select_all /*2131624214*/:
                this.this$0.selectAll();
                return true;
            default:
                return false;
        }
    }

    public boolean onCreateActionMode(C0716b c0716b, Menu menu) {
        super.onCreateActionMode(c0716b, menu);
        MediaAdapter.Companion.setActMode(c0716b);
        this.this$0.getActivity().getMenuInflater().inflate(C1333R.menu.cab_media, menu);
        return true;
    }

    public void onDestroyActionMode(C0716b c0716b) {
        super.onDestroyActionMode(c0716b);
        for (View toggleItemSelection$default : this.this$0.getViews()) {
            Companion.toggleItemSelection$default(MediaAdapter.Companion, toggleItemSelection$default, false, 0, 4, null);
        }
        MediaAdapter.Companion.getMarkedItems().clear();
    }

    public boolean onPrepareActionMode(C0716b c0716b, Menu menu) {
        boolean z = false;
        C0036f.m62b(menu, "menu");
        menu.findItem(C1333R.id.cab_rename).setVisible(getMultiSelector().m5050c().size() <= 1);
        MenuItem findItem = menu.findItem(C1333R.id.cab_edit);
        if (getMultiSelector().m5050c().size() <= 1) {
            z = true;
        }
        findItem.setVisible(z);
        return true;
    }
}
