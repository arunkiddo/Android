package android.support.v7.p033a;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p016k.C0528h;
import android.support.v4.p021b.C0226a;
import android.support.v4.p021b.C0279p;
import android.support.v4.p021b.ad;
import android.support.v4.p021b.ai;
import android.support.v4.p021b.ai.C0240a;
import android.support.v7.p033a.C0647b.C0646a;
import android.support.v7.view.C0716b;
import android.support.v7.view.C0716b.C0694a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.bh;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: android.support.v7.a.e */
public class C0666e extends C0279p implements C0240a, C0663f {
    private C0667g mDelegate;
    private boolean mEatKeyUpEvent;
    private Resources mResources;
    private int mThemeId;

    public C0666e() {
        this.mThemeId = 0;
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        getDelegate().m2912b(view, layoutParams);
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (C0528h.m2308b(keyEvent) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                C0645a supportActionBar = getSupportActionBar();
                if (supportActionBar != null && supportActionBar.m2828d() && supportActionBar.m2835i()) {
                    this.mEatKeyUpEvent = true;
                    return true;
                }
            } else if (action == 1 && this.mEatKeyUpEvent) {
                this.mEatKeyUpEvent = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public View findViewById(int i) {
        return getDelegate().m2902a(i);
    }

    public C0667g getDelegate() {
        if (this.mDelegate == null) {
            this.mDelegate = C0667g.m2895a((Activity) this, (C0663f) this);
        }
        return this.mDelegate;
    }

    public C0646a getDrawerToggleDelegate() {
        return getDelegate().m2919g();
    }

    public MenuInflater getMenuInflater() {
        return getDelegate().m2909b();
    }

    public Resources getResources() {
        if (this.mResources == null && bh.m4843a()) {
            this.mResources = new bh(this, super.getResources());
        }
        return this.mResources == null ? super.getResources() : this.mResources;
    }

    public C0645a getSupportActionBar() {
        return getDelegate().m2900a();
    }

    public Intent getSupportParentActivityIntent() {
        return ad.m885a(this);
    }

    public void invalidateOptionsMenu() {
        getDelegate().m2917e();
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        getDelegate().m2903a(configuration);
        if (this.mResources != null) {
            this.mResources.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    public void onContentChanged() {
        onSupportContentChanged();
    }

    protected void onCreate(Bundle bundle) {
        C0667g delegate = getDelegate();
        delegate.m2920h();
        delegate.m2904a(bundle);
        if (delegate.m2921i() && this.mThemeId != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.mThemeId, false);
            } else {
                setTheme(this.mThemeId);
            }
        }
        super.onCreate(bundle);
    }

    public void onCreateSupportNavigateUpTaskStack(ai aiVar) {
        aiVar.m904a((Activity) this);
    }

    protected void onDestroy() {
        super.onDestroy();
        getDelegate().m2918f();
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0645a supportActionBar = getSupportActionBar();
        return (menuItem.getItemId() != 16908332 || supportActionBar == null || (supportActionBar.m2816a() & 4) == 0) ? false : onSupportNavigateUp();
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        getDelegate().m2911b(bundle);
    }

    protected void onPostResume() {
        super.onPostResume();
        getDelegate().m2916d();
    }

    public void onPrepareSupportNavigateUpTaskStack(ai aiVar) {
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        getDelegate().m2914c(bundle);
    }

    protected void onStop() {
        super.onStop();
        getDelegate().m2913c();
    }

    public void onSupportActionModeFinished(C0716b c0716b) {
    }

    public void onSupportActionModeStarted(C0716b c0716b) {
    }

    @Deprecated
    public void onSupportContentChanged() {
    }

    public boolean onSupportNavigateUp() {
        Intent supportParentActivityIntent = getSupportParentActivityIntent();
        if (supportParentActivityIntent == null) {
            return false;
        }
        if (supportShouldUpRecreateTask(supportParentActivityIntent)) {
            ai a = ai.m903a((Context) this);
            onCreateSupportNavigateUpTaskStack(a);
            onPrepareSupportNavigateUpTaskStack(a);
            a.m907a();
            try {
                C0226a.m812a((Activity) this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            supportNavigateUpTo(supportParentActivityIntent);
        }
        return true;
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        getDelegate().m2908a(charSequence);
    }

    public C0716b onWindowStartingSupportActionMode(C0694a c0694a) {
        return null;
    }

    public void setContentView(int i) {
        getDelegate().m2910b(i);
    }

    public void setContentView(View view) {
        getDelegate().m2906a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        getDelegate().m2907a(view, layoutParams);
    }

    public void setSupportActionBar(Toolbar toolbar) {
        getDelegate().m2905a(toolbar);
    }

    @Deprecated
    public void setSupportProgress(int i) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminate(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarIndeterminateVisibility(boolean z) {
    }

    @Deprecated
    public void setSupportProgressBarVisibility(boolean z) {
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.mThemeId = i;
    }

    public C0716b startSupportActionMode(C0694a c0694a) {
        return getDelegate().m2901a(c0694a);
    }

    public void supportInvalidateOptionsMenu() {
        getDelegate().m2917e();
    }

    public void supportNavigateUpTo(Intent intent) {
        ad.m890b((Activity) this, intent);
    }

    public boolean supportRequestWindowFeature(int i) {
        return getDelegate().m2915c(i);
    }

    public boolean supportShouldUpRecreateTask(Intent intent) {
        return ad.m887a((Activity) this, intent);
    }
}
