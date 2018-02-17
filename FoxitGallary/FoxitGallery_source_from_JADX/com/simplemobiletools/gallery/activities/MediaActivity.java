package com.simplemobiletools.gallery.activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.p021b.C0279p;
import android.support.v4.p028h.C0361a;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.C0812h;
import android.support.v7.widget.RecyclerView.C0829a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.p045c.p046a.C1288i;
import com.p045c.p046a.p058h.p069b.C1195j;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.FileKt;
import com.simplemobiletools.filepicker.extensions.StringKt;
import com.simplemobiletools.gallery.BuildConfig;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.adapters.MediaAdapter;
import com.simplemobiletools.gallery.adapters.MediaAdapter.MediaOperationsListener;
import com.simplemobiletools.gallery.asynctasks.GetMediaAsynctask;
import com.simplemobiletools.gallery.dialogs.ChangeSortingDialog;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import com.simplemobiletools.gallery.models.Medium;
import com.simplemobiletools.gallery.views.MyScalableRecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0077n;

public final class MediaActivity extends SimpleActivity implements MediaOperationsListener {
    public static final Companion Companion;
    private static final String TAG;
    private static boolean mIsGetAnyIntent;
    private static boolean mIsGetImageIntent;
    private static boolean mIsGetVideoIntent;
    private static boolean mIsGettingMedia;
    private static ArrayList<Medium> mMedia;
    private static String mPath;
    private static boolean mShowAll;
    private HashMap _$_findViewCache;

    public static final class Companion {
        private Companion() {
        }

        private final boolean getMIsGetAnyIntent() {
            return MediaActivity.mIsGetAnyIntent;
        }

        private final boolean getMIsGetImageIntent() {
            return MediaActivity.mIsGetImageIntent;
        }

        private final boolean getMIsGetVideoIntent() {
            return MediaActivity.mIsGetVideoIntent;
        }

        private final boolean getMIsGettingMedia() {
            return MediaActivity.mIsGettingMedia;
        }

        private final ArrayList<Medium> getMMedia() {
            return MediaActivity.mMedia;
        }

        private final String getMPath() {
            return MediaActivity.mPath;
        }

        private final boolean getMShowAll() {
            return MediaActivity.mShowAll;
        }

        private final String getTAG() {
            return MediaActivity.TAG;
        }

        private final void setMIsGetAnyIntent(boolean z) {
            MediaActivity.mIsGetAnyIntent = z;
        }

        private final void setMIsGetImageIntent(boolean z) {
            MediaActivity.mIsGetImageIntent = z;
        }

        private final void setMIsGetVideoIntent(boolean z) {
            MediaActivity.mIsGetVideoIntent = z;
        }

        private final void setMIsGettingMedia(boolean z) {
            MediaActivity.mIsGettingMedia = z;
        }

        private final void setMMedia(ArrayList<Medium> arrayList) {
            MediaActivity.mMedia = arrayList;
        }

        private final void setMPath(String str) {
            MediaActivity.mPath = str;
        }

        private final void setMShowAll(boolean z) {
            MediaActivity.mShowAll = z;
        }
    }

    static {
        Companion = new Companion();
        TAG = MediaActivity.class.getSimpleName();
        mMedia = new ArrayList();
        mPath = BuildConfig.FLAVOR;
    }

    private final void deleteDirectoryIfEmpty() {
        File file = new File(Companion.getMPath());
        if (file.isDirectory()) {
            if ((((Object[]) file.listFiles()).length == 0 ? 1 : null) != null) {
                file.delete();
            }
        }
    }

    private final void getMedia() {
        if (!Companion.getMIsGettingMedia()) {
            Companion.setMIsGettingMedia(true);
            Object applicationContext = getApplicationContext();
            C0036f.m59a(applicationContext, "applicationContext");
            new GetMediaAsynctask(applicationContext, Companion.getMPath(), Companion.getMIsGetVideoIntent(), Companion.getMIsGetImageIntent(), Companion.getMShowAll(), new MediaActivity$getMedia$1(this)).execute(new Void[0]);
        }
    }

    private final void handleZooming() {
        C0812h layoutManager = ((MyScalableRecyclerView) _$_findCachedViewById(C1333R.id.media_grid)).getLayoutManager();
        if (layoutManager == null) {
            throw new C0027d("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        gridLayoutManager.m3972a(getMConfig().getMediaColumnCnt());
        MyScalableRecyclerView.Companion.setMListener(new MediaActivity$handleZooming$1(this, gridLayoutManager));
    }

    private final void hideFolder() {
        getMConfig().addHiddenFolder(Companion.getMPath());
        if (getMConfig().getShowHiddenFolders()) {
            invalidateOptionsMenu();
        } else {
            finish();
        }
    }

    private final void initializeGallery() {
        if (!isDirEmpty()) {
            MediaAdapter mediaAdapter = new MediaAdapter(this, Companion.getMMedia(), this, new MediaActivity$initializeGallery$adapter$1(this));
            C0829a adapter = ((MyScalableRecyclerView) _$_findCachedViewById(C1333R.id.media_grid)).getAdapter();
            if (adapter == null) {
                ((MyScalableRecyclerView) _$_findCachedViewById(C1333R.id.media_grid)).setAdapter(mediaAdapter);
            } else if (adapter == null) {
                throw new C0027d("null cannot be cast to non-null type com.simplemobiletools.gallery.adapters.MediaAdapter");
            } else {
                ((MediaAdapter) adapter).updateMedia(Companion.getMMedia());
            }
        }
    }

    private final boolean isDirEmpty() {
        if (Companion.getMMedia().size() > 0) {
            return false;
        }
        deleteDirectoryIfEmpty();
        finish();
        return true;
    }

    private final boolean isSetWallpaperIntent() {
        return getIntent().getBooleanExtra(ConstantsKt.getSET_WALLPAPER_INTENT(), false);
    }

    private final void showSortingDialog() {
        ChangeSortingDialog changeSortingDialog = new ChangeSortingDialog(this, false, new MediaActivity$showSortingDialog$1(this));
    }

    private final void switchToFolderView() {
        getMConfig().setShowAll(false);
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private final void toggleFilenameVisibility() {
        getMConfig().setDisplayFileNames(!getMConfig().getDisplayFileNames());
        if (((MyScalableRecyclerView) _$_findCachedViewById(C1333R.id.media_grid)).getAdapter() != null) {
            C0829a adapter = ((MyScalableRecyclerView) _$_findCachedViewById(C1333R.id.media_grid)).getAdapter();
            if (adapter == null) {
                throw new C0027d("null cannot be cast to non-null type com.simplemobiletools.gallery.adapters.MediaAdapter");
            }
            ((MediaAdapter) adapter).updateDisplayFilenames(getMConfig().getDisplayFileNames());
        }
    }

    private final void tryloadGallery() {
        if (ContextKt.hasStoragePermission(this)) {
            setTitle(Companion.getMShowAll() ? getResources().getString(C1333R.string.all_folders) : com.simplemobiletools.gallery.extensions.ContextKt.getHumanizedFilename(this, Companion.getMPath()));
            getMedia();
            handleZooming();
            return;
        }
        finish();
    }

    private final void unhideFolder() {
        getMConfig().removeHiddenFolder(Companion.getMPath());
        invalidateOptionsMenu();
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

    public void deleteFiles(ArrayList<File> arrayList) {
        C0036f.m62b(arrayList, "files");
        Collection arrayList2 = new ArrayList();
        for (Object next : arrayList) {
            Object next2;
            File file = (File) next2;
            boolean z = file.exists() && FileKt.isImageVideoGif(file);
            if (z) {
                arrayList2.add(next2);
            }
        }
        for (File file2 : (List) arrayList2) {
            next2 = file2.getAbsolutePath();
            C0036f.m59a(next2, "it.absolutePath");
            if (!ContextKt.needsStupidWritePermissions(this, next2)) {
                file2.delete();
            } else if (!isShowingPermDialog(file2)) {
                next2 = file2.getAbsolutePath();
                C0036f.m59a(next2, "it.absolutePath");
                C0361a fileDocument = ContextKt.getFileDocument(this, next2, getMConfig().getTreeUri());
                if (C0077n.m104b(fileDocument.m1336a().toString(), StringKt.getFilenameFromPath(file2.getAbsolutePath()), false, 2, null) && !fileDocument.m1341c()) {
                    fileDocument.m1344e();
                }
            } else {
                return;
            }
            ContextKt.deleteFromMediaStore(this, file2);
        }
        if (Companion.getMMedia().isEmpty()) {
            finish();
        }
    }

    public final void gotMedia(ArrayList<Medium> arrayList) {
        C0036f.m62b(arrayList, "media");
        Companion.setMIsGettingMedia(false);
        ((SwipeRefreshLayout) _$_findCachedViewById(C1333R.id.media_holder)).setRefreshing(false);
        if (!C0036f.m61a(arrayList.toString(), Companion.getMMedia().toString())) {
            Companion.setMMedia(arrayList);
            initializeGallery();
        }
    }

    public final void itemClicked(String str) {
        C0036f.m62b(str, "path");
        if (isSetWallpaperIntent()) {
            ContextKt.toast$default((Context) this, (int) C1333R.string.setting_wallpaper, 0, 2, null);
            int wallpaperDesiredMinimumWidth = getWallpaperDesiredMinimumWidth();
            int wallpaperDesiredMinimumHeight = getWallpaperDesiredMinimumHeight();
            C1288i.m6074a((C0279p) this).m6135a(new File(str)).m5855h().m5135a((int) (((float) wallpaperDesiredMinimumWidth) * (((float) wallpaperDesiredMinimumWidth) / ((float) wallpaperDesiredMinimumHeight))), wallpaperDesiredMinimumHeight).m5146b().m5118a((C1195j) new MediaActivity$itemClicked$1(this));
        } else if (Companion.getMIsGetImageIntent() || Companion.getMIsGetVideoIntent() || Companion.getMIsGetAnyIntent()) {
            r0 = new Intent();
            r0.setData(Uri.parse(str));
            setResult(-1, r0);
            finish();
        } else {
            r0 = new Intent(this, ViewPagerActivity.class);
            r0.putExtra(ConstantsKt.getMEDIUM(), str);
            r0.putExtra(ConstantsKt.getSHOW_ALL(), Companion.getMShowAll());
            startActivity(r0);
        }
    }

    protected void onCreate(android.os.Bundle r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.MediaActivity.onCreate(android.os.Bundle):void
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
        r3 = 0;
        super.onCreate(r5);
        r0 = 2130968606; // 0x7f04001e float:1.754587E38 double:1.0528383806E-314;
        r4.setContentView(r0);
        r0 = r4.getIntent();
        r0 = (android.content.Intent) r0;
        r1 = Companion;
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getGET_IMAGE_INTENT();
        r2 = r0.getBooleanExtra(r2, r3);
        r1.setMIsGetImageIntent(r2);
        r1 = Companion;
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getGET_VIDEO_INTENT();
        r2 = r0.getBooleanExtra(r2, r3);
        r1.setMIsGetVideoIntent(r2);
        r1 = Companion;
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getGET_ANY_INTENT();
        r0 = r0.getBooleanExtra(r2, r3);
        r1.setMIsGetAnyIntent(r0);
        r0 = com.simplemobiletools.gallery.C1333R.id.media_holder;
        r0 = r4._$_findCachedViewById(r0);
        r0 = (android.support.v4.widget.SwipeRefreshLayout) r0;
        r1 = new com.simplemobiletools.gallery.activities.MediaActivity$onCreate$2;
        r1.<init>(r4);
        r1 = (android.support.v4.widget.SwipeRefreshLayout.C0577a) r1;
        r0.setOnRefreshListener(r1);
        r0 = Companion;
        r1 = r4.getIntent();
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getDIRECTORY();
        r1 = r1.getStringExtra(r2);
        r2 = "intent.getStringExtra(DIRECTORY)";
        p000a.p005e.p007b.C0036f.m59a(r1, r2);
        r0.setMPath(r1);
        r0 = Companion;
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0.setMMedia(r1);
        r0 = Companion;
        r1 = r4.getMConfig();
        r1 = r1.getShowAll();
        r0.setMShowAll(r1);
        r0 = Companion;
        r0 = r0.getMShowAll();
        if (r0 == 0) goto L_0x008b;
    L_0x0081:
        r0 = r4.getSupportActionBar();
        if (r0 == 0) goto L_0x008a;
    L_0x0087:
        r0.m2821a(r3);
    L_0x008b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.MediaActivity.onCreate(android.os.Bundle):void");
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        boolean z = false;
        C0036f.m62b(menu, "menu");
        getMenuInflater().inflate(C1333R.menu.menu_media, menu);
        boolean isFolderHidden = getMConfig().getIsFolderHidden(Companion.getMPath());
        MenuItem findItem = menu.findItem(C1333R.id.hide_folder);
        boolean z2 = (isFolderHidden || Companion.getMShowAll()) ? false : true;
        findItem.setVisible(z2);
        MenuItem findItem2 = menu.findItem(C1333R.id.unhide_folder);
        if (isFolderHidden && !Companion.getMShowAll()) {
            z = true;
        }
        findItem2.setVisible(z);
        menu.findItem(C1333R.id.folder_view).setVisible(Companion.getMShowAll());
        menu.findItem(C1333R.id.open_camera).setVisible(Companion.getMShowAll());
        menu.findItem(C1333R.id.settings).setVisible(Companion.getMShowAll());
        menu.findItem(C1333R.id.about).setVisible(Companion.getMShowAll());
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0036f.m62b(menuItem, "item");
        switch (menuItem.getItemId()) {
            case C1333R.id.sort /*2131624221*/:
                showSortingDialog();
                return true;
            case C1333R.id.open_camera /*2131624222*/:
                launchCamera();
                return true;
            case C1333R.id.settings /*2131624224*/:
                launchSettings();
                return true;
            case C1333R.id.about /*2131624225*/:
                launchAbout();
                return true;
            case C1333R.id.toggle_filename /*2131624226*/:
                toggleFilenameVisibility();
                return true;
            case C1333R.id.folder_view /*2131624227*/:
                switchToFolderView();
                return true;
            case C1333R.id.hide_folder /*2131624228*/:
                hideFolder();
                return true;
            case C1333R.id.unhide_folder /*2131624229*/:
                unhideFolder();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onResume() {
        super.onResume();
        tryloadGallery();
    }

    public void refreshItems() {
        getMedia();
    }
}
