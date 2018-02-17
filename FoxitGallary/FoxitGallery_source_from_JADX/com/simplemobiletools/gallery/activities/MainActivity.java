package com.simplemobiletools.gallery.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.support.design.widget.Snackbar;
import android.support.v4.p021b.C0226a;
import android.support.v4.p028h.C0361a;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView.C0812h;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.FileKt;
import com.simplemobiletools.filepicker.extensions.StringKt;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.adapters.DirectoryAdapter;
import com.simplemobiletools.gallery.adapters.DirectoryAdapter.DirOperationsListener;
import com.simplemobiletools.gallery.asynctasks.GetDirectoriesAsynctask;
import com.simplemobiletools.gallery.dialogs.ChangeSortingDialog;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import com.simplemobiletools.gallery.models.Directory;
import com.simplemobiletools.gallery.views.MyScalableRecyclerView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0077n;

public final class MainActivity extends SimpleActivity implements DirOperationsListener {
    public static final Companion Companion;
    private static final int PICK_MEDIA;
    private static final int PICK_WALLPAPER;
    private static final int STORAGE_PERMISSION;
    public static ArrayList<Directory> mDirs;
    private static boolean mIsGetAnyContentIntent;
    private static boolean mIsGetImageContentIntent;
    private static boolean mIsGetVideoContentIntent;
    private static boolean mIsGettingDirs;
    private static boolean mIsPickImageIntent;
    private static boolean mIsPickVideoIntent;
    private static boolean mIsSetWallpaperIntent;
    private static boolean mIsThirdPartyIntent;
    private static Snackbar mSnackbar;
    public static ArrayList<String> mToBeDeleted;
    private HashMap _$_findViewCache;
    private final OnClickListener undoDeletion;

    public static final class Companion {
        private Companion() {
        }

        private final boolean getMIsGetAnyContentIntent() {
            return MainActivity.mIsGetAnyContentIntent;
        }

        private final boolean getMIsGetImageContentIntent() {
            return MainActivity.mIsGetImageContentIntent;
        }

        private final boolean getMIsGetVideoContentIntent() {
            return MainActivity.mIsGetVideoContentIntent;
        }

        private final boolean getMIsGettingDirs() {
            return MainActivity.mIsGettingDirs;
        }

        private final boolean getMIsPickImageIntent() {
            return MainActivity.mIsPickImageIntent;
        }

        private final boolean getMIsPickVideoIntent() {
            return MainActivity.mIsPickVideoIntent;
        }

        private final boolean getMIsSetWallpaperIntent() {
            return MainActivity.mIsSetWallpaperIntent;
        }

        private final boolean getMIsThirdPartyIntent() {
            return MainActivity.mIsThirdPartyIntent;
        }

        private final Snackbar getMSnackbar() {
            return MainActivity.mSnackbar;
        }

        private final int getPICK_MEDIA() {
            return MainActivity.PICK_MEDIA;
        }

        private final int getPICK_WALLPAPER() {
            return MainActivity.PICK_WALLPAPER;
        }

        private final int getSTORAGE_PERMISSION() {
            return MainActivity.STORAGE_PERMISSION;
        }

        private final void setMIsGetAnyContentIntent(boolean z) {
            MainActivity.mIsGetAnyContentIntent = z;
        }

        private final void setMIsGetImageContentIntent(boolean z) {
            MainActivity.mIsGetImageContentIntent = z;
        }

        private final void setMIsGetVideoContentIntent(boolean z) {
            MainActivity.mIsGetVideoContentIntent = z;
        }

        private final void setMIsGettingDirs(boolean z) {
            MainActivity.mIsGettingDirs = z;
        }

        private final void setMIsPickImageIntent(boolean z) {
            MainActivity.mIsPickImageIntent = z;
        }

        private final void setMIsPickVideoIntent(boolean z) {
            MainActivity.mIsPickVideoIntent = z;
        }

        private final void setMIsSetWallpaperIntent(boolean z) {
            MainActivity.mIsSetWallpaperIntent = z;
        }

        private final void setMIsThirdPartyIntent(boolean z) {
            MainActivity.mIsThirdPartyIntent = z;
        }

        private final void setMSnackbar(Snackbar snackbar) {
            MainActivity.mSnackbar = snackbar;
        }

        public final ArrayList<Directory> getMDirs() {
            ArrayList<Directory> arrayList = MainActivity.mDirs;
            if (arrayList == null) {
                C0036f.m63b("mDirs");
            }
            return arrayList;
        }

        public final ArrayList<String> getMToBeDeleted() {
            ArrayList<String> arrayList = MainActivity.mToBeDeleted;
            if (arrayList == null) {
                C0036f.m63b("mToBeDeleted");
            }
            return arrayList;
        }

        public final void setMDirs(ArrayList<Directory> arrayList) {
            C0036f.m62b(arrayList, "<set-?>");
            MainActivity.mDirs = arrayList;
        }

        public final void setMToBeDeleted(ArrayList<String> arrayList) {
            C0036f.m62b(arrayList, "<set-?>");
            MainActivity.mToBeDeleted = arrayList;
        }
    }

    static {
        Companion = new Companion();
        STORAGE_PERMISSION = STORAGE_PERMISSION;
        PICK_MEDIA = PICK_MEDIA;
        PICK_WALLPAPER = PICK_WALLPAPER;
    }

    public MainActivity() {
        this.undoDeletion = new MainActivity$undoDeletion$1(this);
    }

    private final void deleteDirs() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.MainActivity.deleteDirs():void
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
        r0 = Companion;
        r0 = r0.getMToBeDeleted();
        r0 = r0.isEmpty();
        if (r0 == 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r0 = Companion;
        r0 = r0.getMSnackbar();
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        r0.m609b();
        r4 = new java.util.ArrayList;
        r4.<init>();
        r0 = Companion;
        r0 = r0.getMToBeDeleted();
        r5 = r0.iterator();
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x0081;
        r0 = r5.next();
        r0 = (java.lang.String) r0;
        r6 = new java.io.File;
        r6.<init>(r0);
        r0 = r6.exists();
        if (r0 == 0) goto L_0x0029;
        r0 = r6.listFiles();
        r0 = (java.lang.Object[]) r0;
        r2 = r3;
        r1 = r0.length;
        if (r2 >= r1) goto L_0x006b;
        r1 = r0[r2];
        r1 = (java.io.File) r1;
        r7 = r1.isFile();
        if (r7 == 0) goto L_0x0066;
        r7 = com.simplemobiletools.filepicker.extensions.FileKt.isImageVideoGif(r1);
        if (r7 == 0) goto L_0x0066;
        r4.add(r1);
        r7 = "it";
        p000a.p005e.p007b.C0036f.m59a(r1, r7);
        r8.deleteItem(r1);
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x0048;
        r4.add(r6);
        r0 = r6.listFiles();
        r0 = (java.lang.Object[]) r0;
        r0 = r0.length;
        if (r0 != 0) goto L_0x007f;
        r0 = 1;
        if (r0 == 0) goto L_0x0029;
        r8.deleteItem(r6);
        goto L_0x0029;
        r0 = r3;
        goto L_0x0079;
        r0 = com.simplemobiletools.gallery.activities.MainActivity$deleteDirs$2.INSTANCE;
        r0 = (p000a.p005e.p006a.C0028a) r0;
        com.simplemobiletools.filepicker.extensions.ContextKt.scanFiles(r8, r4, r0);
        r0 = Companion;
        r0 = r0.getMToBeDeleted();
        r0.clear();
        goto L_0x000d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.MainActivity.deleteDirs():void");
    }

    private final void deleteItem(File file) {
        Object absolutePath = file.getAbsolutePath();
        C0036f.m59a(absolutePath, "file.absolutePath");
        if (!ContextKt.needsStupidWritePermissions(this, absolutePath)) {
            file.delete();
        } else if (!isShowingPermDialog(file)) {
            absolutePath = file.getAbsolutePath();
            C0036f.m59a(absolutePath, "file.absolutePath");
            C0361a fileDocument = ContextKt.getFileDocument(this, absolutePath, getMConfig().getTreeUri());
            if (C0077n.m104b(fileDocument.m1336a().toString(), StringKt.getFilenameFromPath(file.getAbsolutePath()), false, PICK_MEDIA, null) && !fileDocument.m1341c()) {
                fileDocument.m1344e();
            }
        }
    }

    private final void getDirectories() {
        boolean z = true;
        if (!Companion.getMIsGettingDirs()) {
            Companion.setMIsGettingDirs(true);
            Object applicationContext = getApplicationContext();
            C0036f.m59a(applicationContext, "applicationContext");
            boolean z2 = Companion.getMIsPickVideoIntent() || Companion.getMIsGetVideoContentIntent();
            if (!(Companion.getMIsPickImageIntent() || Companion.getMIsGetImageContentIntent())) {
                z = false;
            }
            new GetDirectoriesAsynctask(applicationContext, z2, z, Companion.getMToBeDeleted(), new MainActivity$getDirectories$1(this)).execute(new Void[0]);
        }
    }

    private final void handleZooming() {
        C0812h layoutManager = ((MyScalableRecyclerView) _$_findCachedViewById(C1333R.id.directories_grid)).getLayoutManager();
        if (layoutManager == null) {
            throw new C0027d("null cannot be cast to non-null type android.support.v7.widget.GridLayoutManager");
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        gridLayoutManager.m3972a(getMConfig().getDirColumnCnt());
        MyScalableRecyclerView.Companion.setMListener(new MainActivity$handleZooming$1(this, gridLayoutManager));
    }

    private final boolean hasImageContentData(Intent intent) {
        return C0036f.m61a(intent.getData(), Media.EXTERNAL_CONTENT_URI);
    }

    private final boolean hasVideoContentData(Intent intent) {
        return C0036f.m61a(intent.getData(), Video.Media.EXTERNAL_CONTENT_URI);
    }

    private final boolean isGetAnyContentIntent(Intent intent) {
        return isGetContentIntent(intent) && C0036f.m61a(intent.getType(), (Object) "*/*");
    }

    private final boolean isGetContentIntent(Intent intent) {
        return C0036f.m61a(intent.getAction(), (Object) "android.intent.action.GET_CONTENT") && intent.getType() != null;
    }

    private final boolean isGetImageContentIntent(Intent intent) {
        return isGetContentIntent(intent) ? C0077n.m102a(intent.getType(), "image/", false, PICK_MEDIA, null) || C0036f.m61a(intent.getType(), (Object) "vnd.android.cursor.dir/image") : false;
    }

    private final boolean isGetVideoContentIntent(Intent intent) {
        return isGetContentIntent(intent) ? C0077n.m102a(intent.getType(), "video/", false, PICK_MEDIA, null) || C0036f.m61a(intent.getType(), (Object) "vnd.android.cursor.dir/video") : false;
    }

    private final boolean isImageType(Intent intent) {
        Object obj = null;
        String type = intent.getType();
        if (type != null) {
            obj = Boolean.valueOf(C0077n.m102a(type, "image/", false, PICK_MEDIA, null));
        }
        return C0036f.m61a(obj, Boolean.valueOf(true)) || C0036f.m61a(intent.getType(), (Object) "vnd.android.cursor.dir/image");
    }

    private final boolean isPickImageIntent(Intent intent) {
        return isPickIntent(intent) && (hasImageContentData(intent) || isImageType(intent));
    }

    private final boolean isPickIntent(Intent intent) {
        return C0036f.m61a(intent.getAction(), (Object) "android.intent.action.PICK");
    }

    private final boolean isPickVideoIntent(Intent intent) {
        return isPickIntent(intent) && (hasVideoContentData(intent) || isVideoType(intent));
    }

    private final boolean isSetWallpaperIntent(Intent intent) {
        return C0036f.m61a(intent != null ? intent.getAction() : null, (Object) "android.intent.action.SET_WALLPAPER");
    }

    private final boolean isVideoType(Intent intent) {
        Object obj = null;
        String type = intent.getType();
        if (type != null) {
            obj = Boolean.valueOf(C0077n.m102a(type, "video/", false, PICK_MEDIA, null));
        }
        return C0036f.m61a(obj, Boolean.valueOf(true)) || C0036f.m61a(intent.getType(), (Object) "vnd.android.cursor.dir/video");
    }

    private final void notifyDeletion(int r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.MainActivity.notifyDeletion(int):void
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
        r2 = r5.getResources();
        r0 = 2131165184; // 0x7f070000 float:1.7944578E38 double:1.052935503E-314;
        r1 = 1;
        r1 = new java.lang.Object[r1];
        r3 = 0;
        r4 = java.lang.Integer.valueOf(r6);
        r1[r3] = r4;
        r1 = r2.getQuantityString(r0, r6, r1);
        r3 = Companion;
        r0 = com.simplemobiletools.gallery.C1333R.id.coordinator_layout;
        r0 = r5._$_findCachedViewById(r0);
        r0 = (android.support.design.widget.CoordinatorLayout) r0;
        r1 = (java.lang.CharSequence) r1;
        r4 = -2;
        r0 = android.support.design.widget.Snackbar.m588a(r0, r1, r4);
        r3.setMSnackbar(r0);
        r0 = Companion;
        r0 = r0.getMSnackbar();
        if (r0 != 0) goto L_0x0033;
    L_0x0030:
        p000a.p005e.p007b.C0036f.m58a();
        r0 = (android.support.design.widget.Snackbar) r0;
        r1 = 2131099815; // 0x7f0600a7 float:1.7811994E38 double:1.0529032065E-314;
        r1 = r2.getString(r1);
        r1 = (java.lang.CharSequence) r1;
        r2 = r5.undoDeletion;
        r0.m606a(r1, r2);
        r1 = -1;
        r0.m604a(r1);
        r0.m607a();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.MainActivity.notifyDeletion(int):void");
    }

    private final void showAllMedia() {
        getMConfig().setShowAll(true);
        Intent intent = new Intent(this, MediaActivity.class);
        intent.putExtra(ConstantsKt.getDIRECTORY(), "/");
        startActivity(intent);
        finish();
    }

    private final void showSortingDialog() {
        ChangeSortingDialog changeSortingDialog = new ChangeSortingDialog(this, true, new MainActivity$showSortingDialog$1(this));
    }

    private final void tryloadGallery() {
        if (ContextKt.hasStoragePermission(this)) {
            if (getMConfig().getShowAll()) {
                showAllMedia();
            } else {
                getDirectories();
            }
            handleZooming();
            return;
        }
        Activity activity = this;
        String[] strArr = new String[STORAGE_PERMISSION];
        strArr[0] = "android.permission.WRITE_EXTERNAL_STORAGE";
        C0226a.m816a(activity, (String[]) ((Object[]) strArr), Companion.getSTORAGE_PERMISSION());
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

    public final void checkDelete() {
        Snackbar access$getMSnackbar$p = Companion.getMSnackbar();
        if (C0036f.m61a(access$getMSnackbar$p != null ? Boolean.valueOf(access$getMSnackbar$p.m611c()) : null, Boolean.valueOf(true))) {
            deleteDirs();
        }
    }

    public final void gotDirectories(ArrayList<Directory> arrayList) {
        C0036f.m62b(arrayList, "dirs");
        ((SwipeRefreshLayout) _$_findCachedViewById(C1333R.id.directories_holder)).setRefreshing(false);
        Companion.setMIsGettingDirs(false);
        if (!C0036f.m61a(arrayList.toString(), Companion.getMDirs().toString())) {
            Companion.setMDirs(arrayList);
            ((MyScalableRecyclerView) _$_findCachedViewById(C1333R.id.directories_grid)).setAdapter(new DirectoryAdapter(this, Companion.getMDirs(), this, new MainActivity$gotDirectories$adapter$1(this)));
            ((MyScalableRecyclerView) _$_findCachedViewById(C1333R.id.directories_grid)).setOnTouchListener(new MainActivity$gotDirectories$1(this));
        }
    }

    public final void itemClicked(java.lang.String r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.MainActivity.itemClicked(java.lang.String):void
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
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:357)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 7 more
*/
        /*
        r0 = this;
        r2 = 0;
        r3 = 1;
        r0 = "path";
        p000a.p005e.p007b.C0036f.m62b(r6, r0);
        r1 = new android.content.Intent;
        r0 = r5;
        r0 = (android.content.Context) r0;
        r4 = com.simplemobiletools.gallery.activities.MediaActivity.class;
        r1.<init>(r0, r4);
        r0 = r1;
        r0 = (android.content.Intent) r0;
        r1 = com.simplemobiletools.gallery.helpers.ConstantsKt.getDIRECTORY();
        r0.putExtra(r1, r6);
        r1 = Companion;
        r1 = r1.getMIsSetWallpaperIntent();
        if (r1 == 0) goto L_0x0037;
    L_0x0024:
        r1 = com.simplemobiletools.gallery.helpers.ConstantsKt.getSET_WALLPAPER_INTENT();
        r0.putExtra(r1, r3);
        r1 = Companion;
        r1 = r1.getPICK_WALLPAPER();
        r5.startActivityForResult(r0, r1);
        return;
    L_0x0037:
        r4 = com.simplemobiletools.gallery.helpers.ConstantsKt.getGET_IMAGE_INTENT();
        r1 = Companion;
        r1 = r1.getMIsPickImageIntent();
        if (r1 != 0) goto L_0x004b;
    L_0x0043:
        r1 = Companion;
        r1 = r1.getMIsGetImageContentIntent();
        if (r1 == 0) goto L_0x007e;
    L_0x004b:
        r1 = r3;
        r0.putExtra(r4, r1);
        r1 = com.simplemobiletools.gallery.helpers.ConstantsKt.getGET_VIDEO_INTENT();
        r4 = Companion;
        r4 = r4.getMIsPickVideoIntent();
        if (r4 != 0) goto L_0x0063;
    L_0x005b:
        r4 = Companion;
        r4 = r4.getMIsGetVideoContentIntent();
        if (r4 == 0) goto L_0x0064;
    L_0x0063:
        r2 = r3;
    L_0x0064:
        r0.putExtra(r1, r2);
        r1 = com.simplemobiletools.gallery.helpers.ConstantsKt.getGET_ANY_INTENT();
        r2 = Companion;
        r2 = r2.getMIsGetAnyContentIntent();
        r0.putExtra(r1, r2);
        r1 = Companion;
        r1 = r1.getPICK_MEDIA();
        r5.startActivityForResult(r0, r1);
        goto L_0x0034;
    L_0x007e:
        r1 = r2;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.MainActivity.itemClicked(java.lang.String):void");
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            if (i == Companion.getPICK_MEDIA() && intent != null) {
                Intent intent2 = new Intent();
                String path = intent.getData().getPath();
                Uri fromFile = Uri.fromFile(new File(path));
                if (Companion.getMIsGetImageContentIntent() || Companion.getMIsGetVideoContentIntent() || Companion.getMIsGetAnyContentIntent()) {
                    intent2.setDataAndTypeAndNormalize(fromFile, FileKt.getMimeType(new File(path), "image/jpeg"));
                    intent2.setFlags(PICK_WALLPAPER);
                } else if (Companion.getMIsPickImageIntent() || Companion.getMIsPickVideoIntent()) {
                    intent2.setData(fromFile);
                    intent2.setFlags(STORAGE_PERMISSION);
                }
                setResult(-1, intent2);
                finish();
            } else if (i == Companion.getPICK_WALLPAPER()) {
                setResult(-1);
                finish();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1333R.layout.activity_main);
        Companion companion = Companion;
        Object intent = getIntent();
        C0036f.m59a(intent, "intent");
        companion.setMIsPickImageIntent(isPickImageIntent(intent));
        companion = Companion;
        intent = getIntent();
        C0036f.m59a(intent, "intent");
        companion.setMIsPickVideoIntent(isPickVideoIntent(intent));
        companion = Companion;
        intent = getIntent();
        C0036f.m59a(intent, "intent");
        companion.setMIsGetImageContentIntent(isGetImageContentIntent(intent));
        companion = Companion;
        intent = getIntent();
        C0036f.m59a(intent, "intent");
        companion.setMIsGetVideoContentIntent(isGetVideoContentIntent(intent));
        companion = Companion;
        intent = getIntent();
        C0036f.m59a(intent, "intent");
        companion.setMIsGetAnyContentIntent(isGetAnyContentIntent(intent));
        Companion.setMIsSetWallpaperIntent(isSetWallpaperIntent(getIntent()));
        Companion companion2 = Companion;
        boolean z = Companion.getMIsPickImageIntent() || Companion.getMIsPickVideoIntent() || Companion.getMIsGetImageContentIntent() || Companion.getMIsGetVideoContentIntent() || Companion.getMIsGetAnyContentIntent() || Companion.getMIsSetWallpaperIntent();
        companion2.setMIsThirdPartyIntent(z);
        Companion.setMToBeDeleted(new ArrayList());
        ((SwipeRefreshLayout) _$_findCachedViewById(C1333R.id.directories_holder)).setOnRefreshListener(new MainActivity$onCreate$1(this));
        Companion.setMDirs(new ArrayList());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        C0036f.m62b(menu, "menu");
        if (Companion.getMIsThirdPartyIntent()) {
            return false;
        }
        getMenuInflater().inflate(C1333R.menu.menu_main, menu);
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        getMConfig().setFirstRun(false);
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
            case C1333R.id.show_all /*2131624223*/:
                showAllMedia();
                return true;
            case C1333R.id.settings /*2131624224*/:
                launchSettings();
                return true;
            case C1333R.id.about /*2131624225*/:
                launchAbout();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    protected void onPause() {
        super.onPause();
        deleteDirs();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = STORAGE_PERMISSION;
        C0036f.m62b(strArr, "permissions");
        C0036f.m62b(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == Companion.getSTORAGE_PERMISSION()) {
            if ((iArr.length == 0 ? STORAGE_PERMISSION : 0) != 0) {
                i2 = 0;
            }
            if (i2 == 0 || iArr[0] != 0) {
                ContextKt.toast$default((Context) this, (int) C1333R.string.no_permissions, 0, (int) PICK_MEDIA, null);
                finish();
                return;
            }
            getDirectories();
        }
    }

    protected void onResume() {
        super.onResume();
        tryloadGallery();
    }

    public void prepareForDeleting(ArrayList<String> arrayList) {
        C0036f.m62b(arrayList, "paths");
        ContextKt.toast$default((Context) this, (int) C1333R.string.deleting, 0, (int) PICK_MEDIA, null);
        Companion.setMToBeDeleted(arrayList);
        int size = Companion.getMToBeDeleted().size();
        if (!isShowingPermDialog(new File((String) Companion.getMToBeDeleted().get(0)))) {
            notifyDeletion(size);
        }
    }

    public void refreshItems() {
        getDirectories();
    }
}
