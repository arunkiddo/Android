package com.simplemobiletools.gallery.activities;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;

final class AboutActivity$setupMoreApps$1 implements OnClickListener {
    final /* synthetic */ AboutActivity this$0;

    AboutActivity$setupMoreApps$1(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    public final void onClick(View view) {
        this.this$0.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/dev?id=9070296388022589266")));
    }
}
