package com.simplemobiletools.gallery.activities;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.extensions.ActivityKt;
import com.simplemobiletools.gallery.fragments.ViewPagerFragment;
import com.simplemobiletools.gallery.fragments.ViewPagerFragment.FragmentClickListener;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import com.simplemobiletools.gallery.models.Medium;
import java.io.File;
import java.util.HashMap;
import p000a.p005e.p007b.C0036f;

public class PhotoVideoActivity extends SimpleActivity implements FragmentClickListener {
    public static final Companion Companion;
    private static boolean mIsVideo;
    private HashMap _$_findViewCache;
    public ViewPagerFragment mFragment;
    private boolean mIsFullScreen;
    private Medium mMedium;
    public Uri mUri;

    public static final class Companion {
        private Companion() {
        }

        public final boolean getMIsVideo() {
            return PhotoVideoActivity.mIsVideo;
        }

        public final void setMIsVideo(boolean z) {
            PhotoVideoActivity.mIsVideo = z;
        }
    }

    static {
        Companion = new Companion();
    }

    private final void sendViewPagerIntent(String str) {
        Intent intent = new Intent(this, ViewPagerActivity.class);
        intent.putExtra(ConstantsKt.getMEDIUM(), str);
        startActivity(intent);
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

    public void fragmentClicked() {
        this.mIsFullScreen = !this.mIsFullScreen;
        if (this.mIsFullScreen) {
            hideSystemUI();
        } else {
            showSystemUI();
        }
    }

    public final ViewPagerFragment getMFragment() {
        ViewPagerFragment viewPagerFragment = this.mFragment;
        if (viewPagerFragment == null) {
            C0036f.m63b("mFragment");
        }
        return viewPagerFragment;
    }

    public final Uri getMUri() {
        Uri uri = this.mUri;
        if (uri == null) {
            C0036f.m63b("mUri");
        }
        return uri;
    }

    public void onConfigurationChanged(Configuration configuration) {
        C0036f.m62b(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        ViewPagerFragment viewPagerFragment = this.mFragment;
        if (viewPagerFragment == null) {
            C0036f.m63b("mFragment");
        }
        viewPagerFragment.updateItem();
    }

    public void onCreate(android.os.Bundle r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.PhotoVideoActivity.onCreate(android.os.Bundle):void
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
        r4 = 0;
        r11 = 1;
        r12 = 0;
        r10 = 0;
        super.onCreate(r15);
        r0 = 2130968630; // 0x7f040036 float:1.754592E38 double:1.0528383924E-314;
        r14.setContentView(r0);
        r0 = r14.getIntent();
        r0 = r0.getData();
        if (r0 == 0) goto L_0x0047;
    L_0x0018:
        r14.mUri = r0;
        r0 = r14.mUri;
        if (r0 != 0) goto L_0x0023;
    L_0x001e:
        r1 = "mUri";
        p000a.p005e.p007b.C0036f.m63b(r1);
    L_0x0023:
        r0 = r0.getScheme();
        r1 = "file";
        r0 = p000a.p005e.p007b.C0036f.m61a(r0, r1);
        if (r0 == 0) goto L_0x0048;
    L_0x002f:
        r0 = r14.mUri;
        if (r0 != 0) goto L_0x0038;
    L_0x0033:
        r1 = "mUri";
        p000a.p005e.p007b.C0036f.m63b(r1);
    L_0x0038:
        r0 = r0.getPath();
        r1 = "mUri.path";
        p000a.p005e.p007b.C0036f.m59a(r0, r1);
        r14.sendViewPagerIntent(r0);
        r14.finish();
    L_0x0047:
        return;
    L_0x0048:
        r0 = r14.getApplicationContext();
        r1 = r14.mUri;
        if (r1 != 0) goto L_0x0055;
    L_0x0050:
        r2 = "mUri";
        p000a.p005e.p007b.C0036f.m63b(r2);
    L_0x0055:
        r1 = com.simplemobiletools.gallery.extensions.ContextKt.getRealPathFromURI(r0, r1);
        if (r1 == 0) goto L_0x006f;
    L_0x005b:
        r0 = r1;
        r0 = (java.lang.CharSequence) r0;
        r0 = r0.length();
        if (r0 <= 0) goto L_0x0072;
    L_0x0065:
        r0 = r11;
    L_0x0066:
        if (r0 == 0) goto L_0x0074;
    L_0x0068:
        r14.sendViewPagerIntent(r1);
        r14.finish();
        goto L_0x0047;
    L_0x006f:
        r1 = "";
        goto L_0x005b;
    L_0x0072:
        r0 = r12;
        goto L_0x0066;
    L_0x0074:
        r13 = new android.os.Bundle;
        r13.<init>();
        r6 = new java.io.File;
        r0 = r14.mUri;
        if (r0 != 0) goto L_0x0084;
    L_0x007f:
        r1 = "mUri";
        p000a.p005e.p007b.C0036f.m63b(r1);
    L_0x0084:
        r0 = r0.toString();
        r6.<init>(r0);
        r0 = new com.simplemobiletools.gallery.models.Medium;
        r1 = r6.getName();
        r2 = "file.name";
        p000a.p005e.p007b.C0036f.m59a(r1, r2);
        r2 = r14.mUri;
        if (r2 != 0) goto L_0x009f;
    L_0x009a:
        r3 = "mUri";
        p000a.p005e.p007b.C0036f.m63b(r3);
    L_0x009f:
        r2 = r2.toString();
        r3 = "mUri.toString()";
        p000a.p005e.p007b.C0036f.m59a(r2, r3);
        r3 = Companion;
        r3 = r3.getMIsVideo();
        r8 = r6.length();
        r6 = r4;
        r0.<init>(r1, r2, r3, r4, r6, r8);
        r14.mMedium = r0;
        r1 = com.simplemobiletools.gallery.helpers.ConstantsKt.getMEDIUM();
        r0 = r14.mMedium;
        r0 = (java.io.Serializable) r0;
        r13.putSerializable(r1, r0);
        if (r15 != 0) goto L_0x010e;
    L_0x00c5:
        r0 = Companion;
        r0 = r0.getMIsVideo();
        if (r0 == 0) goto L_0x0156;
    L_0x00cd:
        r0 = new com.simplemobiletools.gallery.fragments.VideoFragment;
        r0.<init>();
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment) r0;
        r14.mFragment = r0;
        r1 = r14.mFragment;
        if (r1 != 0) goto L_0x00df;
    L_0x00da:
        r0 = "mFragment";
        p000a.p005e.p007b.C0036f.m63b(r0);
    L_0x00df:
        r0 = r14;
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment.FragmentClickListener) r0;
        r1.setListener(r0);
        r0 = r14.mFragment;
        if (r0 != 0) goto L_0x00ee;
    L_0x00e9:
        r1 = "mFragment";
        p000a.p005e.p007b.C0036f.m63b(r1);
    L_0x00ee:
        r0.setArguments(r13);
        r0 = r14.getSupportFragmentManager();
        r1 = r0.m1076a();
        r2 = 2131624091; // 0x7f0e009b float:1.8875352E38 double:1.053162233E-314;
        r0 = r14.mFragment;
        if (r0 != 0) goto L_0x0105;
    L_0x0100:
        r3 = "mFragment";
        p000a.p005e.p007b.C0036f.m63b(r3);
    L_0x0105:
        r0 = (android.support.v4.p021b.C0274o) r0;
        r0 = r1.m937b(r2, r0);
        r0.m936b();
    L_0x010e:
        r0 = new java.lang.String[r11];
        r1 = android.provider.MediaStore.Images.Media.TITLE;
        r0[r12] = r1;
        r0 = (java.lang.Object[]) r0;
        r2 = r0;
        r2 = (java.lang.String[]) r2;
        r0 = r14.getContentResolver();
        r1 = r14.mUri;
        if (r1 != 0) goto L_0x0127;
    L_0x0122:
        r3 = "mUri";
        p000a.p005e.p007b.C0036f.m63b(r3);
    L_0x0127:
        r3 = r10;
        r3 = (java.lang.String) r3;
        r4 = r10;
        r4 = (java.lang.String[]) r4;
        r5 = r10;
        r5 = (java.lang.String) r5;
        r1 = r0.query(r1, r2, r3, r4, r5);
        if (r1 == 0) goto L_0x014e;
    L_0x0136:
        r0 = r1.getCount();
        if (r0 == 0) goto L_0x014e;
    L_0x013c:
        r0 = android.provider.MediaStore.Images.Media.TITLE;
        r0 = r1.getColumnIndexOrThrow(r0);
        r1.moveToFirst();
        r0 = r1.getString(r0);
        r0 = (java.lang.CharSequence) r0;
        r14.setTitle(r0);
    L_0x014e:
        if (r1 == 0) goto L_0x0153;
    L_0x0150:
        r1.close();
        goto L_0x0047;
    L_0x0156:
        r0 = new com.simplemobiletools.gallery.fragments.PhotoFragment;
        r0.<init>();
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment) r0;
        goto L_0x00d4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.PhotoVideoActivity.onCreate(android.os.Bundle):void");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Object obj = null;
        C0036f.m62b(menu, "menu");
        getMenuInflater().inflate(C1333R.menu.photo_video_menu, menu);
        MenuItem findItem = menu.findItem(C1333R.id.menu_set_as_wallpaper);
        Medium medium = this.mMedium;
        findItem.setVisible(C0036f.m61a(medium != null ? Boolean.valueOf(medium.isImage()) : null, Boolean.valueOf(true)));
        MenuItem findItem2 = menu.findItem(C1333R.id.menu_edit);
        Medium medium2 = this.mMedium;
        if (medium2 != null) {
            obj = Boolean.valueOf(medium2.isImage());
        }
        findItem2.setVisible(C0036f.m61a(obj, Boolean.valueOf(true)));
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0036f.m62b(menuItem, "item");
        Medium medium;
        switch (menuItem.getItemId()) {
            case C1333R.id.menu_share /*2131624231*/:
                Medium medium2 = this.mMedium;
                if (medium2 == null) {
                    C0036f.m58a();
                }
                ActivityKt.shareMedium(this, medium2);
                return true;
            case C1333R.id.menu_edit /*2131624232*/:
                medium = this.mMedium;
                if (medium == null) {
                    C0036f.m58a();
                }
                ActivityKt.openEditor(this, new File(medium.getPath()));
                return true;
            case C1333R.id.menu_set_as_wallpaper /*2131624233*/:
                medium = this.mMedium;
                if (medium == null) {
                    C0036f.m58a();
                }
                ActivityKt.setAsWallpaper(this, new File(medium.getPath()));
                return true;
            case C1333R.id.menu_open_with /*2131624234*/:
                medium = this.mMedium;
                if (medium == null) {
                    C0036f.m58a();
                }
                ActivityKt.openWith(this, new File(medium.getPath()));
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public final void setMFragment(ViewPagerFragment viewPagerFragment) {
        C0036f.m62b(viewPagerFragment, "<set-?>");
        this.mFragment = viewPagerFragment;
    }

    public final void setMUri(Uri uri) {
        C0036f.m62b(uri, "<set-?>");
        this.mUri = uri;
    }
}
