package com.simplemobiletools.gallery.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.p016k.ac;
import android.support.v4.p016k.aw.C0476f;
import android.support.v4.p028h.C0361a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import com.simplemobiletools.filepicker.dialogs.ConfirmationDialog;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.StringKt;
import com.simplemobiletools.fileproperties.dialogs.PropertiesDialog;
import com.simplemobiletools.gallery.BuildConfig;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.adapters.MyPagerAdapter;
import com.simplemobiletools.gallery.asynctasks.GetMediaAsynctask;
import com.simplemobiletools.gallery.dialogs.CopyDialog;
import com.simplemobiletools.gallery.dialogs.RenameFileDialog;
import com.simplemobiletools.gallery.extensions.ActivityKt;
import com.simplemobiletools.gallery.fragments.ViewPagerFragment.FragmentClickListener;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import com.simplemobiletools.gallery.models.Medium;
import com.simplemobiletools.gallery.views.MyViewPager;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0077n;

public final class ViewPagerActivity extends SimpleActivity implements C0476f, OnSystemUiVisibilityChangeListener, FragmentClickListener {
    private HashMap _$_findViewCache;
    private String mDirectory;
    private boolean mIsFullScreen;
    private ArrayList<Medium> mMedia;
    private String mPath;
    private int mPos;
    private boolean mShowAll;

    public ViewPagerActivity() {
        this.mMedia = new ArrayList();
        this.mPath = BuildConfig.FLAVOR;
        this.mDirectory = BuildConfig.FLAVOR;
        this.mPos = -1;
    }

    private final void askConfirmDelete() {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog(this, null, 0, 0, 0, new ViewPagerActivity$askConfirmDelete$1(this), 30, null);
    }

    private final void deleteDirectoryIfEmpty() {
        File file = new File(this.mDirectory);
        if (file.isDirectory()) {
            if ((((Object[]) file.listFiles()).length == 0 ? 1 : null) != null) {
                file.delete();
            }
        }
        ContextKt.scanPath(this, this.mDirectory, ViewPagerActivity$deleteDirectoryIfEmpty$1.INSTANCE);
    }

    private final void deleteFile() {
        File file = new File(((Medium) this.mMedia.get(this.mPos)).getPath());
        if (!isShowingPermDialog(file)) {
            if (!ContextKt.needsStupidWritePermissions(this, this.mPath)) {
                file.delete();
            } else if (!isShowingPermDialog(file)) {
                C0361a fileDocument = ContextKt.getFileDocument(this, this.mPath, getMConfig().getTreeUri());
                if (C0077n.m104b(fileDocument.m1336a().toString(), StringKt.getFilenameFromPath(file.getAbsolutePath()), false, 2, null) && !fileDocument.m1341c()) {
                    fileDocument.m1344e();
                }
            }
            if (ContextKt.deleteFromMediaStore(this, file)) {
                reloadViewPager();
            } else {
                ContextKt.scanFile(this, file, new ViewPagerActivity$deleteFile$1(this));
            }
        }
    }

    private final void displayCopyDialog() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(getCurrentFile());
        CopyDialog copyDialog = new CopyDialog(this, arrayList, new ViewPagerActivity$displayCopyDialog$1(this));
    }

    private final File getCurrentFile() {
        Medium currentMedium = getCurrentMedium();
        if (currentMedium == null) {
            C0036f.m58a();
        }
        return new File(currentMedium.getPath());
    }

    private final Medium getCurrentMedium() {
        return this.mMedia.isEmpty() ? (Medium) null : (Medium) this.mMedia.get(Math.min(this.mPos, this.mMedia.size() - 1));
    }

    private final int getProperPosition() {
        this.mPos = 0;
        Iterator it = this.mMedia.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (C0036f.m61a(((Medium) it.next()).getPath(), this.mPath)) {
                return i;
            }
            i++;
        }
        return this.mPos;
    }

    private final boolean isDirEmpty() {
        if (this.mMedia.size() > 0) {
            return false;
        }
        deleteDirectoryIfEmpty();
        finish();
        return true;
    }

    private final void reloadViewPager() {
        Object applicationContext = getApplicationContext();
        C0036f.m59a(applicationContext, "applicationContext");
        new GetMediaAsynctask(applicationContext, this.mDirectory, false, false, this.mShowAll, new ViewPagerActivity$reloadViewPager$1(this)).execute(new Void[0]);
    }

    private final void renameFile() {
        RenameFileDialog renameFileDialog = new RenameFileDialog(this, getCurrentFile(), new ViewPagerActivity$renameFile$1(this));
    }

    private final void showProperties() {
        Context context = this;
        String absolutePath = getCurrentFile().getAbsolutePath();
        C0036f.m59a((Object) absolutePath, "getCurrentFile().absolutePath");
        PropertiesDialog propertiesDialog = new PropertiesDialog(context, absolutePath, false);
    }

    private final void updateActionbarTitle() {
        runOnUiThread(new ViewPagerActivity$updateActionbarTitle$1(this));
    }

    private final void updatePagerItems() {
        Object supportFragmentManager = getSupportFragmentManager();
        C0036f.m59a(supportFragmentManager, "supportFragmentManager");
        MyViewPager myViewPager = (MyViewPager) _$_findCachedViewById(C1333R.id.view_pager);
        myViewPager.setAdapter(new MyPagerAdapter(this, supportFragmentManager, this.mMedia));
        myViewPager.setCurrentItem(this.mPos);
        myViewPager.addOnPageChangeListener(this);
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

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == ConstantsKt.getREQUEST_EDIT_IMAGE()) {
            if (i2 == -1 && intent != null) {
                this.mPos = -1;
                reloadViewPager();
            }
        } else if (i == ConstantsKt.getREQUEST_SET_WALLPAPER() && i2 == -1) {
            ContextKt.toast$default((Context) this, (int) C1333R.string.wallpaper_set_successfully, 0, 2, null);
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onConfigurationChanged(Configuration configuration) {
        C0036f.m62b(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        ac adapter = ((MyViewPager) _$_findCachedViewById(C1333R.id.view_pager)).getAdapter();
        if (adapter == null) {
            throw new C0027d("null cannot be cast to non-null type com.simplemobiletools.gallery.adapters.MyPagerAdapter");
        }
        ((MyPagerAdapter) adapter).updateItems(this.mPos);
    }

    protected void onCreate(android.os.Bundle r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.ViewPagerActivity.onCreate(android.os.Bundle):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 7 more
*/
        /*
        r0 = this;
        r9 = 1;
        r10 = 0;
        r8 = 0;
        super.onCreate(r12);
        r1 = 2130968607; // 0x7f04001f float:1.7545872E38 double:1.052838381E-314;
        r11.setContentView(r1);
        r1 = com.simplemobiletools.filepicker.extensions.ContextKt.hasStoragePermission(r11);
        if (r1 != 0) goto L_0x0016;
    L_0x0012:
        r11.finish();
        return;
    L_0x0016:
        r1 = r11.getIntent();
        r2 = r1.getData();
        if (r2 == 0) goto L_0x0081;
    L_0x0020:
        r7 = r8;
        r7 = (android.database.Cursor) r7;
        r1 = 1;
        r1 = new java.lang.String[r1];	 Catch:{ all -> 0x0079 }
        r3 = 0;	 Catch:{ all -> 0x0079 }
        r4 = android.provider.MediaStore.Images.Media.DATA;	 Catch:{ all -> 0x0079 }
        r1[r3] = r4;	 Catch:{ all -> 0x0079 }
        r1 = (java.lang.Object[]) r1;	 Catch:{ all -> 0x0079 }
        r0 = r1;	 Catch:{ all -> 0x0079 }
        r0 = (java.lang.String[]) r0;	 Catch:{ all -> 0x0079 }
        r3 = r0;	 Catch:{ all -> 0x0079 }
        r1 = r11.getContentResolver();	 Catch:{ all -> 0x0079 }
        r4 = 0;	 Catch:{ all -> 0x0079 }
        r4 = (java.lang.String) r4;	 Catch:{ all -> 0x0079 }
        r5 = 0;	 Catch:{ all -> 0x0079 }
        r5 = (java.lang.String[]) r5;	 Catch:{ all -> 0x0079 }
        r6 = 0;	 Catch:{ all -> 0x0079 }
        r6 = (java.lang.String) r6;	 Catch:{ all -> 0x0079 }
        r7 = r1.query(r2, r3, r4, r5, r6);	 Catch:{ all -> 0x0079 }
        if (r7 == 0) goto L_0x005a;	 Catch:{ all -> 0x0079 }
    L_0x0046:
        r1 = android.provider.MediaStore.Images.Media.DATA;	 Catch:{ all -> 0x0079 }
        r1 = r7.getColumnIndexOrThrow(r1);	 Catch:{ all -> 0x0079 }
        r7.moveToFirst();	 Catch:{ all -> 0x0079 }
        r1 = r7.getString(r1);	 Catch:{ all -> 0x0079 }
        r2 = "cursor.getString(dataIndex)";	 Catch:{ all -> 0x0079 }
        p000a.p005e.p007b.C0036f.m59a(r1, r2);	 Catch:{ all -> 0x0079 }
        r11.mPath = r1;	 Catch:{ all -> 0x0079 }
    L_0x005a:
        if (r7 == 0) goto L_0x005f;
    L_0x005c:
        r7.close();
        r1 = r11.mPath;
        r1 = (java.lang.CharSequence) r1;
        r1 = r1.length();
        if (r1 != 0) goto L_0x009f;
        r1 = r9;
        if (r1 == 0) goto L_0x00a1;
        r1 = 2131099817; // 0x7f0600a9 float:1.7811998E38 double:1.0529032074E-314;
        r2 = 2;
        com.simplemobiletools.filepicker.extensions.ContextKt.toast$default(r11, r1, r10, r2, r8);
        r11.finish();
        goto L_0x0015;
    L_0x0079:
        r1 = move-exception;
        if (r7 == 0) goto L_0x007f;
        r7.close();
        throw r1;
    L_0x0081:
        r1 = r11.getIntent();
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getMEDIUM();
        r1 = r1.getStringExtra(r2);
        r2 = "intent.getStringExtra(MEDIUM)";
        p000a.p005e.p007b.C0036f.m59a(r1, r2);
        r11.mPath = r1;
        r1 = r11.getMConfig();
        r1 = r1.getShowAll();
        r11.mShowAll = r1;
        goto L_0x0060;
        r1 = r10;
        goto L_0x006c;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r11.mMedia = r1;
        r11.showSystemUI();
        r1 = new java.io.File;
        r2 = r11.mPath;
        r1.<init>(r2);
        r1 = r1.getParent();
        r2 = "File(mPath).parent";
        p000a.p005e.p007b.C0036f.m59a(r1, r2);
        r11.mDirectory = r1;
        r1 = r11.mPath;
        r1 = com.simplemobiletools.filepicker.extensions.StringKt.getFilenameFromPath(r1);
        r1 = (java.lang.CharSequence) r1;
        r11.setTitle(r1);
        r1 = r11.getWindow();
        r2 = r1.getDecorView();
        r1 = r11;
        r1 = (android.view.View.OnSystemUiVisibilityChangeListener) r1;
        r2.setOnSystemUiVisibilityChangeListener(r1);
        r11.reloadViewPager();
        r2 = r11.mPath;
        r1 = com.simplemobiletools.gallery.activities.ViewPagerActivity$onCreate$1.INSTANCE;
        r1 = (p000a.p005e.p006a.C0028a) r1;
        com.simplemobiletools.filepicker.extensions.ContextKt.scanPath(r11, r2, r1);
        goto L_0x0015;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.ViewPagerActivity.onCreate(android.os.Bundle):void");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        Object obj = null;
        C0036f.m62b(menu, "menu");
        getMenuInflater().inflate(C1333R.menu.viewpager_menu, menu);
        MenuItem findItem = menu.findItem(C1333R.id.menu_set_as_wallpaper);
        Medium currentMedium = getCurrentMedium();
        findItem.setVisible(C0036f.m61a(currentMedium != null ? Boolean.valueOf(currentMedium.isImage()) : null, Boolean.valueOf(true)));
        MenuItem findItem2 = menu.findItem(C1333R.id.menu_edit);
        Medium currentMedium2 = getCurrentMedium();
        if (currentMedium2 != null) {
            obj = Boolean.valueOf(currentMedium2.isImage());
        }
        findItem2.setVisible(C0036f.m61a(obj, Boolean.valueOf(true)));
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0036f.m62b(menuItem, "item");
        switch (menuItem.getItemId()) {
            case C1333R.id.menu_share /*2131624231*/:
                Medium currentMedium = getCurrentMedium();
                if (currentMedium == null) {
                    C0036f.m58a();
                }
                ActivityKt.shareMedium(this, currentMedium);
                return true;
            case C1333R.id.menu_edit /*2131624232*/:
                ActivityKt.openEditor(this, getCurrentFile());
                return true;
            case C1333R.id.menu_set_as_wallpaper /*2131624233*/:
                ActivityKt.setAsWallpaper(this, getCurrentFile());
                return true;
            case C1333R.id.menu_open_with /*2131624234*/:
                ActivityKt.openWith(this, getCurrentFile());
                return true;
            case C1333R.id.menu_copy_move /*2131624235*/:
                displayCopyDialog();
                return true;
            case C1333R.id.menu_delete /*2131624236*/:
                askConfirmDelete();
                return true;
            case C1333R.id.menu_rename /*2131624237*/:
                renameFile();
                return true;
            case C1333R.id.menu_properties /*2131624238*/:
                showProperties();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onPageScrollStateChanged(int i) {
        if (i == 1) {
            ac adapter = ((MyViewPager) _$_findCachedViewById(C1333R.id.view_pager)).getAdapter();
            if (adapter == null) {
                throw new C0027d("null cannot be cast to non-null type com.simplemobiletools.gallery.adapters.MyPagerAdapter");
            }
            ((MyPagerAdapter) adapter).itemDragged(this.mPos);
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        this.mPos = i;
        updateActionbarTitle();
        supportInvalidateOptionsMenu();
    }

    protected void onResume() {
        super.onResume();
        if (!ContextKt.hasStoragePermission(this)) {
            finish();
        }
    }

    public void onSystemUiVisibilityChange(int r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.ViewPagerActivity.onSystemUiVisibilityChange(int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 7 more
*/
        /*
        r0 = this;
        r0 = com.simplemobiletools.gallery.C1333R.id.view_pager;
        r0 = r4._$_findCachedViewById(r0);
        r0 = (com.simplemobiletools.gallery.views.MyViewPager) r0;
        r1 = r0.getAdapter();
        if (r1 == 0) goto L_0x0033;
    L_0x000f:
        r0 = r1;
        r0 = (android.support.v4.p016k.ac) r0;
        r2 = r5 & 4;
        if (r2 != 0) goto L_0x001c;
        r2 = 0;
        r4.mIsFullScreen = r2;
        r4.showSystemUI();
        if (r0 != 0) goto L_0x0026;
        r0 = new a.d;
        r1 = "null cannot be cast to non-null type com.simplemobiletools.gallery.adapters.MyPagerAdapter";
        r0.<init>(r1);
        throw r0;
        r0 = (com.simplemobiletools.gallery.adapters.MyPagerAdapter) r0;
        r2 = r4.mIsFullScreen;
        r3 = r4.mPos;
        r0.updateUiVisibility(r2, r3);
        r1 = (android.support.v4.p016k.ac) r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.ViewPagerActivity.onSystemUiVisibilityChange(int):void");
    }
}
