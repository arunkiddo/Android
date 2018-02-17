package com.simplemobiletools.gallery.models;

import com.simplemobiletools.gallery.helpers.ConstantsKt;
import java.io.Serializable;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0077n;

public final class Medium implements Serializable, Comparable<Medium> {
    public static final Companion Companion;
    private static final long serialVersionUID;
    private static int sorting;
    private final long date_modified;
    private final long date_taken;
    private final boolean isVideo;
    private final String name;
    private String path;
    private final long size;

    public static final class Companion {
        private Companion() {
        }

        private final long getSerialVersionUID() {
            return Medium.serialVersionUID;
        }

        public final int getSorting() {
            return Medium.sorting;
        }

        public final void setSorting(int i) {
            Medium.sorting = i;
        }
    }

    static {
        Companion = new Companion();
        serialVersionUID = serialVersionUID;
    }

    public Medium(String str, String str2, boolean z, long j, long j2, long j3) {
        C0036f.m62b(str, "name");
        C0036f.m62b(str2, "path");
        this.name = str;
        this.path = str2;
        this.isVideo = z;
        this.date_modified = j;
        this.date_taken = j2;
        this.size = j3;
    }

    public int compareTo(Medium medium) {
        int i = 0;
        C0036f.m62b(medium, "other");
        if ((Companion.getSorting() & ConstantsKt.getSORT_BY_NAME()) != 0) {
            String str = this.name;
            if (str == null) {
                throw new C0027d("null cannot be cast to non-null type java.lang.String");
            }
            Object toLowerCase = str.toLowerCase();
            C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
            str = medium.name;
            if (str == null) {
                throw new C0027d("null cannot be cast to non-null type java.lang.String");
            }
            Object toLowerCase2 = str.toLowerCase();
            C0036f.m59a(toLowerCase2, "(this as java.lang.String).toLowerCase()");
            i = toLowerCase.compareTo(toLowerCase2);
        } else if ((Companion.getSorting() & ConstantsKt.getSORT_BY_SIZE()) != 0) {
            if (this.size != medium.size) {
                i = this.size > medium.size ? 1 : -1;
            }
        } else if ((Companion.getSorting() & ConstantsKt.getSORT_BY_DATE_MODIFIED()) != 0) {
            if (this.date_modified != medium.date_modified) {
                i = this.date_modified > medium.date_modified ? 1 : -1;
            }
        } else if (this.date_taken != medium.date_taken) {
            i = this.date_taken > medium.date_taken ? 1 : -1;
        }
        return (Companion.getSorting() & ConstantsKt.getSORT_DESCENDING()) != 0 ? i * -1 : i;
    }

    public final long getDate_modified() {
        return this.date_modified;
    }

    public final long getDate_taken() {
        return this.date_taken;
    }

    public final String getMimeType() {
        return this.isVideo ? "video/*" : "image/*";
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

    public final boolean isGif() {
        String str = this.path;
        if (str == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = str.toLowerCase();
        C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        return C0077n.m104b(toLowerCase, ".gif", false, 2, null);
    }

    public final boolean isImage() {
        return (isGif() || this.isVideo) ? false : true;
    }

    public final boolean isPng() {
        String str = this.path;
        if (str == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = str.toLowerCase();
        C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        return C0077n.m104b(toLowerCase, ".png", false, 2, null);
    }

    public final boolean isVideo() {
        return this.isVideo;
    }

    public final void setPath(String str) {
        C0036f.m62b(str, "<set-?>");
        this.path = str;
    }

    public String toString() {
        return "Medium {name=" + this.name + ", path=" + this.path + ", isVideo=" + this.isVideo + ", date_modified=" + this.date_modified + ", date_taken=" + this.date_taken + ", size=" + this.size + "}";
    }
}
