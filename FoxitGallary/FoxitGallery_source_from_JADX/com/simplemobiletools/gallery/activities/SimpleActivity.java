package com.simplemobiletools.gallery.activities;

import android.annotation.TargetApi;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.p033a.C0666e;
import android.view.MenuItem;
import android.view.View;
import com.simplemobiletools.filepicker.extensions.ActivityKt;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.helpers.Config.Companion;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import java.io.File;
import java.util.HashMap;
import p000a.p005e.p007b.C0036f;

public class SimpleActivity extends C0666e {
    private HashMap _$_findViewCache;
    public Config mConfig;

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

    public final Config getMConfig() {
        Config config = this.mConfig;
        if (config == null) {
            C0036f.m63b("mConfig");
        }
        return config;
    }

    public final void hideSystemUI() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.SimpleActivity.hideSystemUI():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 5 more
*/
        /*
        r0 = this;
        r0 = r2.getSupportActionBar();
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r0.m2825c();
        r0 = r2.getWindow();
        r0 = r0.getDecorView();
        r1 = 3847; // 0xf07 float:5.391E-42 double:1.9007E-320;
        r0.setSystemUiVisibility(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.SimpleActivity.hideSystemUI():void");
    }

    public final boolean isShowingPermDialog(File file) {
        C0036f.m62b(file, "file");
        Config config = this.mConfig;
        if (config == null) {
            C0036f.m63b("mConfig");
        }
        return ActivityKt.isShowingWritePermissions(this, file, config.getTreeUri(), ConstantsKt.getOPEN_DOCUMENT_TREE());
    }

    public final void launchAbout() {
        startActivity(new Intent(getApplicationContext(), AboutActivity.class));
    }

    public final void launchCamera() {
        startActivity(new Intent("android.media.action.STILL_IMAGE_CAMERA"));
    }

    public final void launchSettings() {
        startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == ConstantsKt.getOPEN_DOCUMENT_TREE() && i2 == -1 && intent != null) {
            saveTreeUri(intent);
        }
    }

    protected void onCreate(Bundle bundle) {
        Companion companion = Config.Companion;
        Object applicationContext = getApplicationContext();
        C0036f.m59a(applicationContext, "applicationContext");
        this.mConfig = companion.newInstance(applicationContext);
        Config config = this.mConfig;
        if (config == null) {
            C0036f.m63b("mConfig");
        }
        int i = config.isDarkTheme() ? C1333R.style.AppTheme_Dark : C1333R.style.AppTheme;
        if ((this instanceof ViewPagerActivity) || (this instanceof PhotoActivity) || (this instanceof VideoActivity)) {
            config = this.mConfig;
            if (config == null) {
                C0036f.m63b("mConfig");
            }
            i = config.isDarkTheme() ? C1333R.style.FullScreenTheme_Dark : C1333R.style.FullScreenTheme;
        }
        setTheme(i);
        super.onCreate(bundle);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0036f.m62b(menuItem, "item");
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    @TargetApi(19)
    public final void saveTreeUri(Intent intent) {
        C0036f.m62b(intent, "resultData");
        Uri data = intent.getData();
        Config config = this.mConfig;
        if (config == null) {
            C0036f.m63b("mConfig");
        }
        Object uri = data.toString();
        C0036f.m59a(uri, "treeUri.toString()");
        config.setTreeUri(uri);
        getContentResolver().takePersistableUriPermission(data, 3);
    }

    public final void setMConfig(Config config) {
        C0036f.m62b(config, "<set-?>");
        this.mConfig = config;
    }

    public final void showSystemUI() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.SimpleActivity.showSystemUI():void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 5 more
*/
        /*
        r0 = this;
        r0 = r2.getSupportActionBar();
        if (r0 == 0) goto L_0x0009;
    L_0x0006:
        r0.m2823b();
        r0 = r2.getWindow();
        r0 = r0.getDecorView();
        r1 = 1792; // 0x700 float:2.511E-42 double:8.854E-321;
        r0.setSystemUiVisibility(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.SimpleActivity.showSystemUI():void");
    }
}
