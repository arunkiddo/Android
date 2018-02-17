package com.simplemobiletools.filepicker.models;

import p000a.C0027d;
import p000a.p005e.p007b.C0036f;

public final class FileDirItem implements Comparable<FileDirItem> {
    private final int children;
    private final boolean isDirectory;
    private final String name;
    private final String path;
    private final long size;

    public FileDirItem(String str, String str2, boolean z, int i, long j) {
        C0036f.m62b(str, "path");
        C0036f.m62b(str2, "name");
        this.path = str;
        this.name = str2;
        this.isDirectory = z;
        this.children = i;
        this.size = j;
    }

    public int compareTo(FileDirItem fileDirItem) {
        C0036f.m62b(fileDirItem, "other");
        if (this.isDirectory && !fileDirItem.isDirectory) {
            return -1;
        }
        if (!this.isDirectory && fileDirItem.isDirectory) {
            return 1;
        }
        String str = this.name;
        if (str == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = str.toLowerCase();
        C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        str = fileDirItem.name;
        if (str == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase2 = str.toLowerCase();
        C0036f.m59a(toLowerCase2, "(this as java.lang.String).toLowerCase()");
        return toLowerCase.compareTo(toLowerCase2);
    }

    public final int getChildren() {
        return this.children;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPath() {
        return this.path;
    }

    public final long getSize() {
        return this.size;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public String toString() {
        return "FileDirItem{path=" + this.path + ", name=" + this.name + ", isDirectory=" + this.isDirectory + ", children=" + this.children + ", size=" + this.size + "}";
    }
}
