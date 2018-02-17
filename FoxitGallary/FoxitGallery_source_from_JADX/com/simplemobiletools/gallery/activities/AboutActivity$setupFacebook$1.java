package com.simplemobiletools.gallery.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

final class AboutActivity$setupFacebook$1 implements OnClickListener {
    final /* synthetic */ AboutActivity this$0;

    AboutActivity$setupFacebook$1(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    public final void onClick(View view) {
        String str = "https://www.facebook.com/simplemobiletools";
        try {
            this.this$0.getPackageManager().getPackageInfo("com.facebook.katana", 0);
            str = "fb://page/150270895341774";
        } catch (Exception e) {
        }
        this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
    }
}
