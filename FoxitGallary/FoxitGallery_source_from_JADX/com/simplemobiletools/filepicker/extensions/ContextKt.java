package com.simplemobiletools.filepicker.extensions;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.MediaStore.Files;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.support.v4.p022c.C0225a;
import android.support.v4.p028h.C0361a;
import android.widget.Toast;
import com.simplemobiletools.filepicker.C1328R;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import p000a.C0027d;
import p000a.C0055f;
import p000a.p001a.C0006h;
import p000a.p005e.p006a.C0028a;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0042h.C0039b;
import p000a.p011i.C0077n;
import p000a.p011i.C0078o;

public final class ContextKt {
    public static final boolean deleteFromMediaStore(Context context, File file) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(file, "file");
        return context.getContentResolver().delete(getFileUri(context, file), new StringBuilder().append("_data").append(" = '").append(file.getAbsolutePath()).append("'").toString(), (String[]) null) == 1;
    }

    public static final C0361a getFileDocument(Context context, String str, String str2) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(str, "path");
        C0036f.m62b(str2, "treeUri");
        int length = getSDCardPath(context).length() + 1;
        if (str == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object substring = str.substring(length);
        C0036f.m59a(substring, "(this as java.lang.String).substring(startIndex)");
        C0361a a = C0361a.m1335a(context, Uri.parse(str2));
        C0361a c0361a = a;
        for (String b : C0078o.m123a((CharSequence) substring, new String[]{"/"}, false, 0, 6, null)) {
            C0361a b2 = c0361a.m1339b(b);
            if (b2 == null) {
                b2 = c0361a;
            }
            c0361a = b2;
        }
        C0036f.m59a((Object) c0361a, "document");
        return c0361a;
    }

    public static final Uri getFileUri(Context context, File file) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(file, "file");
        if (FileKt.isImageSlow(file)) {
            Object obj = Media.EXTERNAL_CONTENT_URI;
            C0036f.m59a(obj, "MediaStore.Images.Media.EXTERNAL_CONTENT_URI");
            return obj;
        }
        obj = FileKt.isVideoSlow(file) ? Video.Media.EXTERNAL_CONTENT_URI : Files.getContentUri("external");
        C0036f.m59a(obj, "if (file.isVideoSlow()) \u2026tentUri(\"external\")\n    }");
        return obj;
    }

    public static final String getHumanReadablePath(Context context, String str) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(str, "path");
        int i = C0036f.m61a((Object) str, (Object) "/") ? C1328R.string.smtfp_root : C0036f.m61a((Object) str, getInternalStoragePath(context)) ? C1328R.string.smtfp_internal : C1328R.string.smtfp_sd_card;
        Object string = context.getString(i);
        C0036f.m59a(string, "getString(when (path) {\n\u2026ring.smtfp_sd_card\n    })");
        return string;
    }

    public static final String getInternalStoragePath(Context context) {
        C0036f.m62b(context, "$receiver");
        return C0078o.m121a(Environment.getExternalStorageDirectory().toString(), '/');
    }

    public static final ArrayList<String> getPaths(File file) {
        C0036f.m62b(file, "file");
        ArrayList<String> arrayList = new ArrayList();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null) {
                return arrayList;
            }
            for (Object obj : listFiles) {
                C0036f.m59a(obj, "curFile");
                arrayList.addAll(getPaths(obj));
            }
        } else {
            arrayList.add(file.getAbsolutePath());
        }
        return arrayList;
    }

    @TargetApi(21)
    public static final String getSDCardPath(Context context) {
        int i = 0;
        C0036f.m62b(context, "$receiver");
        if (VERSION.SDK_INT < 21) {
            return BuildConfig.FLAVOR;
        }
        File[] listFiles = new File("/storage").listFiles();
        while (i < listFiles.length) {
            File file = listFiles[i];
            try {
                if (Environment.isExternalStorageRemovable(file)) {
                    return C0078o.m121a(file.getAbsolutePath(), '/');
                }
                i++;
            } catch (Exception e) {
            }
        }
        return BuildConfig.FLAVOR;
    }

    public static final boolean hasStoragePermission(Context context) {
        C0036f.m62b(context, "$receiver");
        return C0225a.m807a(context, "android.permission.WRITE_EXTERNAL_STORAGE") == 0;
    }

    public static final String humanizePath(Context context, String str) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(str, "path");
        Object basePath = StringKt.getBasePath(str, context);
        if (C0036f.m61a(basePath, (Object) "/")) {
            return getHumanReadablePath(context, basePath) + str;
        }
        return C0077n.m99a(str, (String) basePath, getHumanReadablePath(context, basePath), false, 4, null);
    }

    public static final boolean isAStorageRootFolder(Context context, String str) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(str, "path");
        Object a = C0078o.m121a(str, '/');
        return (((CharSequence) a).length() == 0 ? 1 : 0) != 0 || C0036f.m61a(a, getInternalStoragePath(context)) || C0036f.m61a(a, getSDCardPath(context));
    }

    public static final boolean isKitkatPlus(Context context) {
        C0036f.m62b(context, "$receiver");
        return VERSION.SDK_INT >= 19;
    }

    public static final boolean isPathOnSD(Context context, String str) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(str, "path");
        return (((CharSequence) getSDCardPath(context)).length() > 0) && C0077n.m102a(str, getSDCardPath(context), false, 2, null);
    }

    public static final boolean needsStupidWritePermissions(Context context, String str) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(str, "path");
        if (isPathOnSD(context, str) && isKitkatPlus(context)) {
            if ((((CharSequence) getSDCardPath(context)).length() == 0 ? 1 : null) == null) {
                return true;
            }
        }
        return false;
    }

    public static final void rescanPaths(Context context, ArrayList<String> arrayList, C0028a<C0055f> c0028a) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(arrayList, "paths");
        C0036f.m62b(c0028a, "action");
        C0039b c0039b = new C0039b();
        c0039b.f11a = arrayList.size();
        Collection collection = arrayList;
        if (collection == null) {
            throw new C0027d("null cannot be cast to non-null type java.util.Collection<T>");
        }
        collection = collection;
        Object[] toArray = collection.toArray(new String[collection.size()]);
        if (toArray == null) {
            throw new C0027d("null cannot be cast to non-null type kotlin.Array<T>");
        }
        MediaScannerConnection.scanFile(context, (String[]) toArray, (String[]) null, new ContextKt$rescanPaths$1(c0039b, c0028a));
    }

    public static final void scanFile(Context context, File file, C0028a<C0055f> c0028a) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(file, "file");
        C0036f.m62b(c0028a, "action");
        scanFiles(context, C0006h.m9a((Object[]) new File[]{file}), c0028a);
    }

    public static final void scanFiles(Context context, ArrayList<File> arrayList, C0028a<C0055f> c0028a) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(arrayList, "files");
        C0036f.m62b(c0028a, "action");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Object obj = (File) it.next();
            C0036f.m59a(obj, "file");
            arrayList2.addAll(getPaths(obj));
        }
        rescanPaths(context, arrayList2, c0028a);
    }

    public static final void scanPath(Context context, String str, C0028a<C0055f> c0028a) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(str, "path");
        C0036f.m62b(c0028a, "action");
        scanPaths(context, C0006h.m9a((Object[]) new String[]{str}), c0028a);
    }

    public static final void scanPaths(Context context, ArrayList<String> arrayList, C0028a<C0055f> c0028a) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(arrayList, "paths");
        C0036f.m62b(c0028a, "action");
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.addAll(getPaths(new File((String) it.next())));
        }
        rescanPaths(context, arrayList2, c0028a);
    }

    public static final void toast(Context context, int i, int i2) {
        C0036f.m62b(context, "$receiver");
        Toast.makeText(context, i, i2).show();
    }

    public static final void toast(Context context, String str, int i) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(str, "msg");
        Toast.makeText(context, str, i).show();
    }

    public static /* synthetic */ void toast$default(Context context, int i, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toast");
        }
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        toast(context, i, i2);
    }

    public static /* synthetic */ void toast$default(Context context, String str, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toast");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        toast(context, str, i);
    }

    public static final boolean updateInMediaStore(Context context, File file, File file2) {
        C0036f.m62b(context, "$receiver");
        C0036f.m62b(file, "oldFile");
        C0036f.m62b(file2, "newFile");
        ContentValues contentValues = new ContentValues();
        ContentValues contentValues2 = contentValues;
        contentValues2.put("_data", file2.getAbsolutePath());
        contentValues2.put("_display_name", file2.getName());
        contentValues2.put("title", file2.getName());
        return context.getContentResolver().update(getFileUri(context, file), (ContentValues) contentValues, new StringBuilder().append("_data").append(" = '").append(file.getAbsolutePath()).append("'").toString(), (String[]) null) == 1;
    }
}
