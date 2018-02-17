package com.simplemobiletools.gallery.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

final class AboutActivity$setupRateUs$1 implements OnClickListener {
    final /* synthetic */ AboutActivity this$0;

    AboutActivity$setupRateUs$1(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    public final void onClick(View view) {
        try {
            this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + this.this$0.getPackageName())));
        } catch (ActivityNotFoundException e) {
            this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(this.this$0.getStoreUrl())));
        }
    }
}
