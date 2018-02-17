package com.simplemobiletools.gallery.activities;

import com.simplemobiletools.gallery.models.Medium;
import java.util.ArrayList;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;

final class ViewPagerActivity$reloadViewPager$1 extends C0037g implements C0029b<ArrayList<Medium>, C0055f> {
    final /* synthetic */ ViewPagerActivity this$0;

    ViewPagerActivity$reloadViewPager$1(ViewPagerActivity viewPagerActivity) {
        this.this$0 = viewPagerActivity;
        super(1);
    }

    public final void invoke(ArrayList<Medium> arrayList) {
        C0036f.m62b(arrayList, "it");
        this.this$0.mMedia = arrayList;
        if (!this.this$0.isDirEmpty()) {
            if (this.this$0.mPos == -1) {
                this.this$0.mPos = this.this$0.getProperPosition();
            } else {
                this.this$0.mPos = Math.min(this.this$0.mPos, this.this$0.mMedia.size() - 1);
            }
            this.this$0.updateActionbarTitle();
            this.this$0.updatePagerItems();
            this.this$0.invalidateOptionsMenu();
        }
    }
}
