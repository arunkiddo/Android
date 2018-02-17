package com.simplemobiletools.gallery.activities;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.BuildConfig;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.dialogs.ResizeDialog;
import com.simplemobiletools.gallery.dialogs.SaveAsDialog;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.theartofdev.edmodo.cropper.CropImageView.C1335d;
import com.theartofdev.edmodo.cropper.CropImageView.C1347a;
import com.theartofdev.edmodo.cropper.CropImageView.C1349c;
import java.io.File;
import java.util.HashMap;
import p000a.C0027d;
import p000a.p004d.C0025e;
import p000a.p005e.p007b.C0036f;

public final class EditActivity extends SimpleActivity implements C1335d {
    private final String TAG;
    private HashMap _$_findViewCache;
    private int resizeHeight;
    private int resizeWidth;
    public Uri uri;

    public EditActivity() {
        Object simpleName = EditActivity.class.getSimpleName();
        C0036f.m59a(simpleName, "EditActivity::class.java.simpleName");
        this.TAG = simpleName;
    }

    private final Point getAreaSize() {
        Rect cropRect = ((CropImageView) _$_findCachedViewById(C1333R.id.crop_image_view)).getCropRect();
        int rotatedDegrees = ((CropImageView) _$_findCachedViewById(C1333R.id.crop_image_view)).getRotatedDegrees();
        return (rotatedDegrees == 0 || rotatedDegrees == 180) ? new Point(cropRect.width(), cropRect.height()) : new Point(cropRect.height(), cropRect.width());
    }

    private final CompressFormat getCompressionFormat(File file) {
        String a = C0025e.m51a(file);
        if (a == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = a.toLowerCase();
        C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        switch (toLowerCase.hashCode()) {
            case 111145:
                if (toLowerCase.equals("png")) {
                    return CompressFormat.PNG;
                }
                break;
            case 3645340:
                if (toLowerCase.equals("webp")) {
                    return CompressFormat.WEBP;
                }
                break;
        }
        return CompressFormat.JPEG;
    }

    private final void resizeImage() {
        ResizeDialog resizeDialog = new ResizeDialog(this, getAreaSize(), new EditActivity$resizeImage$1(this));
    }

    private final void saveBitmapToFile(android.graphics.Bitmap r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.activities.EditActivity.saveBitmapToFile(android.graphics.Bitmap, java.lang.String):void
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
        r1 = 0;
        r3 = new java.io.File;
        r3.<init>(r9);
        r1 = (java.io.OutputStream) r1;
        r2 = com.simplemobiletools.filepicker.extensions.ContextKt.needsStupidWritePermissions(r7, r9);	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        if (r2 == 0) goto L_0x0098;	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
    L_0x000f:
        r2 = r7.isShowingPermDialog(r3);	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        if (r2 == 0) goto L_0x0037;
    L_0x0016:
        if (r1 == 0) goto L_0x001b;
    L_0x0018:
        r1.close();	 Catch:{ IOException -> 0x001d }
        return;
    L_0x001d:
        r1 = move-exception;
        r2 = r7.TAG;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "FileOutputStream closing failed ";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        android.util.Log.e(r2, r1);
        goto L_0x001c;
    L_0x0037:
        r2 = r7.getMConfig();	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r2 = r2.getTreeUri();	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r2 = com.simplemobiletools.filepicker.extensions.ContextKt.getFileDocument(r7, r9, r2);	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r4 = r3.exists();	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        if (r4 != 0) goto L_0x0058;	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r4 = "";	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r5 = r3.getName();	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r2 = r2.m1338a(r4, r5);	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r4 = "document.createFile(\"\", file.name)";	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        p000a.p005e.p007b.C0036f.m59a(r2, r4);	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r4 = r7.getContentResolver();	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r2 = r2.m1336a();	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r2 = r4.openOutputStream(r2);	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r1 = r7.resizeWidth;	 Catch:{ Exception -> 0x00ad }
        if (r1 <= 0) goto L_0x00a3;	 Catch:{ Exception -> 0x00ad }
        r1 = r7.resizeHeight;	 Catch:{ Exception -> 0x00ad }
        if (r1 <= 0) goto L_0x00a3;	 Catch:{ Exception -> 0x00ad }
        r1 = r7.resizeWidth;	 Catch:{ Exception -> 0x00ad }
        r4 = r7.resizeHeight;	 Catch:{ Exception -> 0x00ad }
        r5 = 0;	 Catch:{ Exception -> 0x00ad }
        r1 = android.graphics.Bitmap.createScaledBitmap(r8, r1, r4, r5);	 Catch:{ Exception -> 0x00ad }
        r3 = r7.getCompressionFormat(r3);	 Catch:{ Exception -> 0x00ad }
        r4 = 90;	 Catch:{ Exception -> 0x00ad }
        r1.compress(r3, r4, r2);	 Catch:{ Exception -> 0x00ad }
        r1 = -1;	 Catch:{ Exception -> 0x00ad }
        r3 = r7.getIntent();	 Catch:{ Exception -> 0x00ad }
        r7.setResult(r1, r3);	 Catch:{ Exception -> 0x00ad }
        if (r2 == 0) goto L_0x008c;
        r2.close();	 Catch:{ IOException -> 0x00e4 }
        r1 = new com.simplemobiletools.gallery.activities.EditActivity$saveBitmapToFile$1;
        r1.<init>(r7);
        r1 = (p000a.p005e.p006a.C0028a) r1;
        com.simplemobiletools.filepicker.extensions.ContextKt.scanPath(r7, r9, r1);
        goto L_0x001c;
    L_0x0098:
        r2 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r0 = r2;	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r0 = (java.io.OutputStream) r0;	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r1 = r0;	 Catch:{ Exception -> 0x0141, all -> 0x0119 }
        r2 = r1;
        goto L_0x0064;
        r1 = r7.getCompressionFormat(r3);	 Catch:{ Exception -> 0x00ad }
        r3 = 90;	 Catch:{ Exception -> 0x00ad }
        r8.compress(r1, r3, r2);	 Catch:{ Exception -> 0x00ad }
        goto L_0x007e;
    L_0x00ad:
        r1 = move-exception;
        r3 = r7.TAG;	 Catch:{ all -> 0x013f }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x013f }
        r4.<init>();	 Catch:{ all -> 0x013f }
        r5 = "Crop compressing failed ";	 Catch:{ all -> 0x013f }
        r4 = r4.append(r5);	 Catch:{ all -> 0x013f }
        r4 = r4.append(r9);	 Catch:{ all -> 0x013f }
        r5 = " ";	 Catch:{ all -> 0x013f }
        r4 = r4.append(r5);	 Catch:{ all -> 0x013f }
        r1 = r4.append(r1);	 Catch:{ all -> 0x013f }
        r1 = r1.toString();	 Catch:{ all -> 0x013f }
        android.util.Log.e(r3, r1);	 Catch:{ all -> 0x013f }
        r1 = 2131099715; // 0x7f060043 float:1.7811791E38 double:1.052903157E-314;	 Catch:{ all -> 0x013f }
        r3 = 0;	 Catch:{ all -> 0x013f }
        r4 = 2;	 Catch:{ all -> 0x013f }
        r5 = 0;	 Catch:{ all -> 0x013f }
        com.simplemobiletools.filepicker.extensions.ContextKt.toast$default(r7, r1, r3, r4, r5);	 Catch:{ all -> 0x013f }
        r7.finish();	 Catch:{ all -> 0x013f }
        if (r2 == 0) goto L_0x00e2;
        r2.close();	 Catch:{ IOException -> 0x00fe }
        goto L_0x008d;
    L_0x00e4:
        r1 = move-exception;
        r2 = r7.TAG;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "FileOutputStream closing failed ";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        android.util.Log.e(r2, r1);
        goto L_0x008d;
    L_0x00fe:
        r1 = move-exception;
        r2 = r7.TAG;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "FileOutputStream closing failed ";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        android.util.Log.e(r2, r1);
        goto L_0x008d;
    L_0x0119:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        if (r2 == 0) goto L_0x0123;
        r2.close();	 Catch:{ IOException -> 0x0125 }
        throw r1;
    L_0x0125:
        r2 = move-exception;
        r3 = r7.TAG;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "FileOutputStream closing failed ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r2 = r2.toString();
        android.util.Log.e(r3, r2);
        goto L_0x0124;
    L_0x013f:
        r1 = move-exception;
        goto L_0x011d;
    L_0x0141:
        r2 = move-exception;
        r6 = r2;
        r2 = r1;
        r1 = r6;
        goto L_0x00ae;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.activities.EditActivity.saveBitmapToFile(android.graphics.Bitmap, java.lang.String):void");
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

    public final int getResizeHeight() {
        return this.resizeHeight;
    }

    public final int getResizeWidth() {
        return this.resizeWidth;
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final Uri getUri() {
        Uri uri = this.uri;
        if (uri == null) {
            C0036f.m63b("uri");
        }
        return uri;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1333R.layout.activity_edit);
        if (getIntent().getData() == null) {
            ContextKt.toast$default((Context) this, (int) C1333R.string.invalid_image_path, 0, 2, null);
            finish();
            return;
        }
        Object data = getIntent().getData();
        C0036f.m59a(data, "intent.data");
        this.uri = data;
        Uri uri = this.uri;
        if (uri == null) {
            C0036f.m63b("uri");
        }
        if ((C0036f.m61a(uri.getScheme(), (Object) "file") ^ 1) != 0) {
            uri = this.uri;
            if (uri == null) {
                C0036f.m63b("uri");
            }
            if ((C0036f.m61a(uri.getScheme(), (Object) "content") ^ 1) != 0) {
                ContextKt.toast$default((Context) this, (int) C1333R.string.unknown_file_location, 0, 2, null);
                finish();
                return;
            }
        }
        CropImageView cropImageView = (CropImageView) _$_findCachedViewById(C1333R.id.crop_image_view);
        cropImageView.setGuidelines(C1349c.OFF);
        cropImageView.setOnCropImageCompleteListener(this);
        cropImageView.setImageUriAsync(getIntent().getData());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1333R.menu.menu_editor, menu);
        return true;
    }

    public void onCropImageComplete(CropImageView cropImageView, C1347a c1347a) {
        C0036f.m62b(cropImageView, "view");
        C0036f.m62b(c1347a, "result");
        if (c1347a.m6340b() == null) {
            Uri uri = this.uri;
            if (uri == null) {
                C0036f.m63b("uri");
            }
            Uri uri2;
            if (C0036f.m61a(uri.getScheme(), (Object) "file")) {
                Activity activity = this;
                uri2 = this.uri;
                if (uri2 == null) {
                    C0036f.m63b("uri");
                }
                Object path = uri2.getPath();
                C0036f.m59a(path, "uri.path");
                SaveAsDialog saveAsDialog = new SaveAsDialog(activity, path, new EditActivity$onCropImageComplete$1(this, c1347a));
                return;
            }
            uri = this.uri;
            if (uri == null) {
                C0036f.m63b("uri");
            }
            if (C0036f.m61a(uri.getScheme(), (Object) "content")) {
                Context applicationContext = getApplicationContext();
                uri2 = this.uri;
                if (uri2 == null) {
                    C0036f.m63b("uri");
                }
                String realPathFromURI = com.simplemobiletools.gallery.extensions.ContextKt.getRealPathFromURI(applicationContext, uri2);
                if (realPathFromURI == null) {
                    realPathFromURI = BuildConfig.FLAVOR;
                }
                if ((((CharSequence) realPathFromURI).length() == 0 ? 1 : 0) == 0) {
                    SaveAsDialog saveAsDialog2 = new SaveAsDialog(this, realPathFromURI, new EditActivity$onCropImageComplete$2(this, c1347a));
                    return;
                }
                ContextKt.toast$default((Context) this, (int) C1333R.string.image_editing_failed, 0, 2, null);
                finish();
                return;
            }
            ContextKt.toast$default((Context) this, (int) C1333R.string.unknown_file_location, 0, 2, null);
            finish();
            return;
        }
        ContextKt.toast$default((Context) this, getString(C1333R.string.image_editing_failed) + ": " + c1347a.m6340b().getMessage(), 0, 2, null);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0036f.m62b(menuItem, "item");
        switch (menuItem.getItemId()) {
            case C1333R.id.save_as /*2131624218*/:
                ((CropImageView) _$_findCachedViewById(C1333R.id.crop_image_view)).getCroppedImageAsync();
                return true;
            case C1333R.id.rotate /*2131624219*/:
                ((CropImageView) _$_findCachedViewById(C1333R.id.crop_image_view)).m6357a(90);
                return true;
            case C1333R.id.resize /*2131624220*/:
                resizeImage();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public final void setResizeHeight(int i) {
        this.resizeHeight = i;
    }

    public final void setResizeWidth(int i) {
        this.resizeWidth = i;
    }

    public final void setUri(Uri uri) {
        C0036f.m62b(uri, "<set-?>");
        this.uri = uri;
    }
}
