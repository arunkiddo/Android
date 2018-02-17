package com.simplemobiletools.gallery.models;

import com.simplemobiletools.gallery.helpers.ConstantsKt;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;

public final class Directory implements Comparable<Directory> {
    public static final Companion Companion;
    private static int sorting;
    private final long date_modified;
    private final long date_taken;
    private int mediaCnt;
    private final String name;
    private final String path;
    private long size;
    private final String thumbnail;

    public static final class Companion {
        private Companion() {
        }

        public final int getSorting() {
            return Directory.sorting;
        }

        public final void setSorting(int i) {
            Directory.sorting = i;
        }
    }

    static {
        Companion = new Companion();
    }

    public Directory(String str, String str2, String str3, int i, long j, long j2, long j3) {
        C0036f.m62b(str, "path");
        C0036f.m62b(str2, "thumbnail");
        C0036f.m62b(str3, "name");
        this.path = str;
        this.thumbnail = str2;
        this.name = str3;
        this.mediaCnt = i;
        this.date_modified = j;
        this.date_taken = j2;
        this.size = j3;
    }

    public final void addSize(long j) {
        this.size += j;
    }

    public int compareTo(Directory directory) {
        int i = 0;
        C0036f.m62b(directory, "other");
        if ((Companion.getSorting() & ConstantsKt.getSORT_BY_NAME()) != 0) {
            String str = this.name;
            if (str == null) {
                throw new C0027d("null cannot be cast to non-null type java.lang.String");
            }
            Object toLowerCase = str.toLowerCase();
            C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
            str = directory.name;
            if (str == null) {
                throw new C0027d("null cannot be cast to non-null type java.lang.String");
            }
            Object toLowerCase2 = str.toLowerCase();
            C0036f.m59a(toLowerCase2, "(this as java.lang.String).toLowerCase()");
            i = toLowerCase.compareTo(toLowerCase2);
        } else if ((Companion.getSorting() & ConstantsKt.getSORT_BY_SIZE()) != 0) {
            if (this.size != directory.size) {
                i = this.size > directory.size ? 1 : -1;
            }
        } else if ((Companion.getSorting() & ConstantsKt.getSORT_BY_DATE_MODIFIED()) != 0) {
            if (this.date_modified != directory.date_modified) {
                i = this.date_modified > directory.date_modified ? 1 : -1;
            }
        } else if (this.date_taken != directory.date_taken) {
            i = this.date_taken > directory.date_taken ? 1 : -1;
        }
        return (Companion.getSorting() & ConstantsKt.getSORT_DESCENDING()) != 0 ? i * -1 : i;
    }

    public final long getDate_modified() {
        return this.date_modified;
    }

    public final long getDate_taken() {
        return this.date_taken;
    }

    public final int getMediaCnt() {
        return this.mediaCnt;
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

    public final String getThumbnail() {
        return this.thumbnail;
    }

    public final void setMediaCnt(int i) {
        this.mediaCnt = i;
    }

    public final void setSize(long j) {
        this.size = j;
    }

    public String toString() {
        return ("Directory {path=" + this.path + ", thumbnail=" + this.thumbnail + ", name=" + this.name + ", mediaCnt=" + this.mediaCnt + ", date_modified=" + this.date_modified + ", ") + ("date_taken=" + this.date_taken + ", size " + this.size + "}");
    }
}
