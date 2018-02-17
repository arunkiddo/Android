package com.simplemobiletools.fileproperties.extensions;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.media.MediaMetadataRetriever;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0045k;

public final class FileKt {
    public static final String getAlbum(File file) {
        C0036f.m62b(file, "$receiver");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(file.getPath());
        return mediaMetadataRetriever.extractMetadata(1);
    }

    public static final String getArtist(File file) {
        C0036f.m62b(file, "$receiver");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(file.getPath());
        return mediaMetadataRetriever.extractMetadata(2);
    }

    public static final String getDuration(File file) {
        C0036f.m62b(file, "$receiver");
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        mediaMetadataRetriever.setDataSource(file.getPath());
        return getFormattedDuration((int) (Long.parseLong(mediaMetadataRetriever.extractMetadata(9)) / ((long) 1000)));
    }

    private static final String getFormattedDuration(int i) {
        Object obj;
        Object format;
        StringBuilder stringBuilder = new StringBuilder(8);
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = (i % 3600) % 60;
        if (i > 3600) {
            C0045k c0045k = C0045k.f16a;
            obj = Locale.getDefault();
            C0036f.m59a(obj, "Locale.getDefault()");
            Object[] objArr = new Object[]{Integer.valueOf(i2)};
            format = String.format(obj, "%02d", Arrays.copyOf(objArr, objArr.length));
            C0036f.m59a(format, "java.lang.String.format(locale, format, *args)");
            stringBuilder.append(format).append(":");
        }
        C0045k c0045k2 = C0045k.f16a;
        obj = Locale.getDefault();
        C0036f.m59a(obj, "Locale.getDefault()");
        Object[] objArr2 = new Object[]{Integer.valueOf(i3)};
        format = String.format(obj, "%02d", Arrays.copyOf(objArr2, objArr2.length));
        C0036f.m59a(format, "java.lang.String.format(locale, format, *args)");
        stringBuilder.append(format);
        StringBuilder append = stringBuilder.append(":");
        c0045k2 = C0045k.f16a;
        obj = Locale.getDefault();
        C0036f.m59a(obj, "Locale.getDefault()");
        objArr2 = new Object[]{Integer.valueOf(i4)};
        format = String.format(obj, "%02d", Arrays.copyOf(objArr2, objArr2.length));
        C0036f.m59a(format, "java.lang.String.format(locale, format, *args)");
        append.append(format);
        format = stringBuilder.toString();
        C0036f.m59a(format, "sb.toString()");
        return format;
    }

    public static final String getImageResolution(File file) {
        C0036f.m62b(file, "$receiver");
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(file.getPath(), options);
        int i = options.outWidth;
        int i2 = options.outHeight;
        return i + " x " + i2 + " " + getMPx(i, i2);
    }

    public static final String getMPx(int i, int i2) {
        return "(" + (((float) Math.round((((float) (i * i2)) / ((float) 1000000)) * ((float) 10))) / ((float) 10)) + "MP)";
    }

    public static final String getVideoResolution(File file) {
        C0036f.m62b(file, "$receiver");
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(file.getPath());
            int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            return parseInt + " x " + parseInt2 + " " + getMPx(parseInt, parseInt2);
        } catch (Exception e) {
            return BuildConfig.FLAVOR;
        }
    }
}
