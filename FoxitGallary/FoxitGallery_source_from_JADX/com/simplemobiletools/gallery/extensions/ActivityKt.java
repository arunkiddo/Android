package com.simplemobiletools.gallery.extensions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.ViewConfiguration;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.FileKt;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import com.simplemobiletools.gallery.models.Medium;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.p001a.C0007i;
import p000a.p005e.p007b.C0036f;

public final class ActivityKt {
    public static final boolean hasNavBar(Activity activity) {
        C0036f.m62b(activity, "$receiver");
        if (VERSION.SDK_INT >= 17) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            int i2 = displayMetrics.widthPixels;
            DisplayMetrics displayMetrics2 = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics2);
            return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
        } else {
            return (ViewConfiguration.get((Context) activity).hasPermanentMenuKey() || KeyCharacterMap.deviceHasKey(4)) ? false : true;
        }
    }

    public static final void openEditor(Activity activity, File file) {
        C0036f.m62b(activity, "$receiver");
        C0036f.m62b(file, "file");
        Intent intent = new Intent("android.intent.action.EDIT");
        intent.setDataAndType(Uri.fromFile(file), "image/*");
        Intent createChooser = Intent.createChooser(intent, activity.getString(C1333R.string.edit_image_with));
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(createChooser, ConstantsKt.getREQUEST_EDIT_IMAGE());
        } else {
            ContextKt.toast$default((Context) activity, (int) C1333R.string.no_editor_found, 0, 2, null);
        }
    }

    public static final void openWith(Activity activity, File file) {
        C0036f.m62b(activity, "$receiver");
        C0036f.m62b(file, "file");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(file), FileKt.getMimeType(file, "image/jpeg"));
        Intent createChooser = Intent.createChooser(intent, activity.getString(C1333R.string.open_with));
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivity(createChooser);
        } else {
            ContextKt.toast$default((Context) activity, (int) C1333R.string.no_app_found, 0, 2, null);
        }
    }

    public static final void setAsWallpaper(Activity activity, File file) {
        C0036f.m62b(activity, "$receiver");
        C0036f.m62b(file, "file");
        Intent intent = new Intent("android.intent.action.ATTACH_DATA");
        intent.setDataAndType(Uri.fromFile(file), FileKt.getMimeType(file, "image/jpeg"));
        Intent createChooser = Intent.createChooser(intent, activity.getString(C1333R.string.set_as_wallpaper_with));
        if (intent.resolveActivity(activity.getPackageManager()) != null) {
            activity.startActivityForResult(createChooser, ConstantsKt.getREQUEST_SET_WALLPAPER());
        } else {
            ContextKt.toast$default((Context) activity, (int) C1333R.string.no_wallpaper_setter_found, 0, 2, null);
        }
    }

    public static final void shareMedia(Activity activity, List<Medium> list) {
        C0036f.m62b(activity, "$receiver");
        C0036f.m62b(list, "media");
        String string = activity.getResources().getString(C1333R.string.share_via);
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND_MULTIPLE");
        intent.setType("image/* video/*");
        ArrayList arrayList = new ArrayList(list.size());
        Iterable<Medium> iterable = list;
        Collection arrayList2 = new ArrayList(C0007i.m15a(iterable, 10));
        for (Medium path : iterable) {
            arrayList2.add(new File(path.getPath()));
        }
        for (File fromFile : (List) arrayList2) {
            arrayList2 = arrayList;
            Object fromFile2 = Uri.fromFile(fromFile);
            C0036f.m59a(fromFile2, "Uri.fromFile(it)");
            arrayList2.add(fromFile2);
        }
        arrayList2 = arrayList;
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        activity.startActivity(Intent.createChooser(intent, string));
    }

    public static final void shareMedium(Activity activity, Medium medium) {
        C0036f.m62b(activity, "$receiver");
        C0036f.m62b(medium, "medium");
        String string = activity.getResources().getString(C1333R.string.share_via);
        Uri fromFile = Uri.fromFile(new File(medium.getPath()));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", fromFile);
        intent.setType(medium.getMimeType());
        activity.startActivity(Intent.createChooser(intent, string));
    }
}
