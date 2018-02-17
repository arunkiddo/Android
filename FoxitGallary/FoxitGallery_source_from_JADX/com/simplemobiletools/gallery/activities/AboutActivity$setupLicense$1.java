package com.simplemobiletools.gallery.activities;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class AboutActivity$setupLicense$1 implements OnClickListener {
    final /* synthetic */ AboutActivity this$0;

    AboutActivity$setupLicense$1(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    public final void onClick(View view) {
        this.this$0.startActivity(new Intent(this.this$0.getApplicationContext(), LicenseActivity.class));
    }
}
