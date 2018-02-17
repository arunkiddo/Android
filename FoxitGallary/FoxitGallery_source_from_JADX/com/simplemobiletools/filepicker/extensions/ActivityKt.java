package com.simplemobiletools.filepicker.extensions;

import android.app.Activity;
import android.content.Context;
import com.simplemobiletools.filepicker.dialogs.WritePermissionDialog;
import java.io.File;
import p000a.p005e.p007b.C0036f;

public final class ActivityKt {
    public static final boolean isShowingWritePermissions(Activity activity, File file, String str, int i) {
        C0036f.m62b(activity, "$receiver");
        C0036f.m62b(file, "file");
        C0036f.m62b(str, "treeUri");
        Context context = activity;
        Object absolutePath = file.getAbsolutePath();
        C0036f.m59a(absolutePath, "file.absolutePath");
        if (ContextKt.needsStupidWritePermissions(context, absolutePath)) {
            if ((((CharSequence) str).length() == 0 ? 1 : null) != null) {
                WritePermissionDialog writePermissionDialog = new WritePermissionDialog(activity, new ActivityKt$isShowingWritePermissions$1(activity, i));
                return true;
            }
        }
        return false;
    }
}
