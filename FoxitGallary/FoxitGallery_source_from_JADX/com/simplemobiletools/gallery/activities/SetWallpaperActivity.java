package com.simplemobiletools.gallery.activities;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.gallery.C1333R;
import com.theartofdev.edmodo.cropper.CropImageView;
import com.theartofdev.edmodo.cropper.CropImageView.C1335d;
import com.theartofdev.edmodo.cropper.CropImageView.C1347a;
import com.theartofdev.edmodo.cropper.CropImageView.C1349c;
import java.util.HashMap;
import p000a.p005e.p007b.C0036f;

public final class SetWallpaperActivity extends SimpleActivity implements C1335d {
    private final int PICK_IMAGE;
    private HashMap _$_findViewCache;
    public Uri uri;
    public WallpaperManager wallpaperManager;

    public SetWallpaperActivity() {
        this.PICK_IMAGE = 1;
    }

    private final void handleImage(Intent intent) {
        Object data = intent.getData();
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
        data = WallpaperManager.getInstance(getApplicationContext());
        C0036f.m59a(data, "WallpaperManager.getInstance(applicationContext)");
        this.wallpaperManager = data;
        CropImageView cropImageView = (CropImageView) _$_findCachedViewById(C1333R.id.crop_image_view);
        cropImageView.setGuidelines(C1349c.OFF);
        cropImageView.setOnCropImageCompleteListener(this);
        cropImageView.setImageUriAsync(intent.getData());
        WallpaperManager wallpaperManager = this.wallpaperManager;
        if (wallpaperManager == null) {
            C0036f.m63b("wallpaperManager");
        }
        int desiredMinimumWidth = wallpaperManager.getDesiredMinimumWidth();
        WallpaperManager wallpaperManager2 = this.wallpaperManager;
        if (wallpaperManager2 == null) {
            C0036f.m63b("wallpaperManager");
        }
        cropImageView.m6358a(desiredMinimumWidth, wallpaperManager2.getDesiredMinimumHeight());
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

    public final Uri getUri() {
        Uri uri = this.uri;
        if (uri == null) {
            C0036f.m63b("uri");
        }
        return uri;
    }

    public final WallpaperManager getWallpaperManager() {
        WallpaperManager wallpaperManager = this.wallpaperManager;
        if (wallpaperManager == null) {
            C0036f.m63b("wallpaperManager");
        }
        return wallpaperManager;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == this.PICK_IMAGE) {
            if (i2 != -1 || intent == null) {
                finish();
            } else {
                handleImage(intent);
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C1333R.layout.activity_set_wallpaper);
        if (getIntent().getData() == null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setAction("android.intent.action.PICK");
            intent.setType("image/*");
            startActivityForResult(intent, this.PICK_IMAGE);
            return;
        }
        Object intent2 = getIntent();
        C0036f.m59a(intent2, "intent");
        handleImage(intent2);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C1333R.menu.menu_set_wallpaper, menu);
        return true;
    }

    public void onCropImageComplete(CropImageView cropImageView, C1347a c1347a) {
        C0036f.m62b(c1347a, "result");
        if (c1347a.m6340b() == null) {
            ContextKt.toast$default((Context) this, (int) C1333R.string.setting_wallpaper, 0, 2, null);
            new Thread(new SetWallpaperActivity$onCropImageComplete$1(this, c1347a)).start();
            return;
        }
        ContextKt.toast$default((Context) this, getString(C1333R.string.image_editing_failed) + ": " + c1347a.m6340b().getMessage(), 0, 2, null);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0036f.m62b(menuItem, "item");
        switch (menuItem.getItemId()) {
            case C1333R.id.rotate /*2131624219*/:
                ((CropImageView) _$_findCachedViewById(C1333R.id.crop_image_view)).m6357a(90);
                return true;
            case C1333R.id.save /*2131624230*/:
                ((CropImageView) _$_findCachedViewById(C1333R.id.crop_image_view)).getCroppedImageAsync();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public final void setUri(Uri uri) {
        C0036f.m62b(uri, "<set-?>");
        this.uri = uri;
    }

    public final void setWallpaperManager(WallpaperManager wallpaperManager) {
        C0036f.m62b(wallpaperManager, "<set-?>");
        this.wallpaperManager = wallpaperManager;
    }
}
