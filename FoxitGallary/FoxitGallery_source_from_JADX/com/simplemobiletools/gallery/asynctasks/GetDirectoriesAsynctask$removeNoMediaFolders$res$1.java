package com.simplemobiletools.gallery.asynctasks;

import java.io.File;
import java.io.FilenameFilter;
import p000a.p005e.p007b.C0036f;

final class GetDirectoriesAsynctask$removeNoMediaFolders$res$1 implements FilenameFilter {
    public static final GetDirectoriesAsynctask$removeNoMediaFolders$res$1 INSTANCE;

    static {
        INSTANCE = new GetDirectoriesAsynctask$removeNoMediaFolders$res$1();
    }

    GetDirectoriesAsynctask$removeNoMediaFolders$res$1() {
    }

    public final boolean accept(File file, String str) {
        return C0036f.m61a((Object) str, (Object) ".nomedia");
    }
}
