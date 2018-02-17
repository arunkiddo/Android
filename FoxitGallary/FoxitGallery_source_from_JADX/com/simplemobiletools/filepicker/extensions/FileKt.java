package com.simplemobiletools.filepicker.extensions;

import android.media.MediaMetadataRetriever;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.File;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0077n;

public final class FileKt {
    public static final String getMimeType(File file, String str) {
        C0036f.m62b(file, "$receiver");
        C0036f.m62b(str, "default");
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(file.getPath());
            String extractMetadata = mediaMetadataRetriever.extractMetadata(12);
            C0036f.m59a((Object) extractMetadata, "retriever.extractMetadat\u2026er.METADATA_KEY_MIMETYPE)");
            return extractMetadata;
        } catch (Exception e) {
            return str;
        }
    }

    public static /* synthetic */ String getMimeType$default(File file, String str, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMimeType");
        }
        if ((i & 1) != 0) {
            str = BuildConfig.FLAVOR;
        }
        return getMimeType(file, str);
    }

    public static final boolean isAudioSlow(File file) {
        C0036f.m62b(file, "$receiver");
        return C0077n.m102a(getMimeType$default(file, null, 1, null), "audio", false, 2, null);
    }

    public static final boolean isGif(File file) {
        C0036f.m62b(file, "$receiver");
        String name = file.getName();
        if (name == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = name.toLowerCase();
        C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        return C0077n.m104b(toLowerCase, ".gif", false, 2, null);
    }

    public static final boolean isImageFast(File file) {
        C0036f.m62b(file, "$receiver");
        String[] strArr = (String[]) ((Object[]) new String[]{"jpg", "png", "jpeg", "bmp", "webp", "tiff"});
        String name = file.getName();
        if (name == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = name.toLowerCase();
        C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        Object[] objArr = (Object[]) strArr;
        for (Object obj : objArr) {
            if (C0077n.m104b(toLowerCase, (String) obj, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isImageSlow(File file) {
        C0036f.m62b(file, "$receiver");
        return isImageFast(file) || C0077n.m102a(getMimeType$default(file, null, 1, null), "image", false, 2, null);
    }

    public static final boolean isImageVideoGif(File file) {
        C0036f.m62b(file, "$receiver");
        return isImageFast(file) || isVideoFast(file) || isGif(file);
    }

    public static final boolean isVideoFast(File file) {
        C0036f.m62b(file, "$receiver");
        String[] strArr = (String[]) ((Object[]) new String[]{"gifv", "webm", "mkv", "flv", "vob", "avi", "wmv", "mp4", "ogv", "qt", "m4p", "mpg", "m4v", "mp2", "mpeg", "3gp"});
        String name = file.getName();
        if (name == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object toLowerCase = name.toLowerCase();
        C0036f.m59a(toLowerCase, "(this as java.lang.String).toLowerCase()");
        Object[] objArr = (Object[]) strArr;
        for (Object obj : objArr) {
            if (C0077n.m104b(toLowerCase, (String) obj, false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isVideoSlow(File file) {
        C0036f.m62b(file, "$receiver");
        return isVideoFast(file) || C0077n.m102a(getMimeType$default(file, null, 1, null), "video", false, 2, null);
    }
}
