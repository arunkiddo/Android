package com.simplemobiletools.gallery.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

final class AboutActivity$setupGPlus$1 implements OnClickListener {
    final /* synthetic */ AboutActivity this$0;

    AboutActivity$setupGPlus$1(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    public final void onClick(View view) {
        this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://plus.google.com/communities/104880861558693868382")));
    }
}
