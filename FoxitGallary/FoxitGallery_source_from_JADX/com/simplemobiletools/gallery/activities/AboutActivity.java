package com.simplemobiletools.gallery.activities;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.simplemobiletools.gallery.BuildConfig;
import com.simplemobiletools.gallery.C1333R;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0045k;

public final class AboutActivity extends SimpleActivity {
    private HashMap _$_findViewCache;

    private final String getStoreUrl() {
        return "https://play.google.com/store/apps/details?id=" + getPackageName();
    }

    private final void setupCopyright() {
        String str = BuildConfig.VERSION_NAME;
        int i = Calendar.getInstance().get(1);
        C0045k c0045k = C0045k.f16a;
        Object string = getString(C1333R.string.copyright);
        C0036f.m59a(string, "getString(R.string.copyright)");
        Object[] objArr = new Object[]{str, Integer.valueOf(i)};
        Object format = String.format(string, Arrays.copyOf(objArr, objArr.length));
        C0036f.m59a(format, "java.lang.String.format(format, *args)");
        ((TextView) _$_findCachedViewById(C1333R.id.about_copyright)).setText((CharSequence) format);
    }

    private final void setupEmail() {
        String string = getString(C1333R.string.email);
        ((TextView) _$_findCachedViewById(C1333R.id.about_email)).setText(Html.fromHtml("<a href=" + "\"" + "mailto:" + string + "?subject=" + getString(C1333R.string.app_name) + "\"" + ">" + string + "</a>"));
        ((TextView) _$_findCachedViewById(C1333R.id.about_email)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void setupMoreApps() {
        ((TextView) _$_findCachedViewById(C1333R.id.about_more_apps)).setOnClickListener(new AboutActivity$setupMoreApps$1(this));
    }

    private final void setupRateUs() {
        if (getMConfig().isFirstRun()) {
            ((TextView) _$_findCachedViewById(C1333R.id.about_rate_us)).setVisibility(8);
        } else {
            ((TextView) _$_findCachedViewById(C1333R.id.about_rate_us)).setOnClickListener(new AboutActivity$setupRateUs$1(this));
        }
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1333R.layout.activity_about);
        setupEmail();
        setupMoreApps();
        setupRateUs();
        setupInvite();
        setupLicense();
        setupDonate();
        setupFacebook();
        setupGPlus();
        setupCopyright();
    }

    public final void setupDonate() {
        ((TextView) _$_findCachedViewById(C1333R.id.about_donate)).setOnClickListener(new AboutActivity$setupDonate$1(this));
    }

    public final void setupFacebook() {
        ((ImageView) _$_findCachedViewById(C1333R.id.about_facebook)).setOnClickListener(new AboutActivity$setupFacebook$1(this));
    }

    public final void setupGPlus() {
        ((ImageView) _$_findCachedViewById(C1333R.id.about_gplus)).setOnClickListener(new AboutActivity$setupGPlus$1(this));
    }

    public final void setupInvite() {
        ((TextView) _$_findCachedViewById(C1333R.id.about_invite)).setOnClickListener(new AboutActivity$setupInvite$1(this));
    }

    public final void setupLicense() {
        ((TextView) _$_findCachedViewById(C1333R.id.about_license)).setOnClickListener(new AboutActivity$setupLicense$1(this));
    }
}
