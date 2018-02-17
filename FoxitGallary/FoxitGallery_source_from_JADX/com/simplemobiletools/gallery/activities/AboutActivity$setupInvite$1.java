package com.simplemobiletools.gallery.activities;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.simplemobiletools.gallery.C1333R;
import java.util.Arrays;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0045k;

final class AboutActivity$setupInvite$1 implements OnClickListener {
    final /* synthetic */ AboutActivity this$0;

    AboutActivity$setupInvite$1(AboutActivity aboutActivity) {
        this.this$0 = aboutActivity;
    }

    public final void onClick(View view) {
        C0045k c0045k = C0045k.f16a;
        Object string = this.this$0.getString(C1333R.string.share_text);
        C0036f.m59a(string, "getString(R.string.share_text)");
        Object[] objArr = new Object[]{this.this$0.getString(C1333R.string.app_name), this.this$0.getStoreUrl()};
        string = String.format(string, Arrays.copyOf(objArr, objArr.length));
        C0036f.m59a(string, "java.lang.String.format(format, *args)");
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.SUBJECT", this.this$0.getString(C1333R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", string);
        intent.setType("text/plain");
        this.this$0.startActivity(Intent.createChooser(intent, this.this$0.getString(C1333R.string.invite_via)));
    }
}
