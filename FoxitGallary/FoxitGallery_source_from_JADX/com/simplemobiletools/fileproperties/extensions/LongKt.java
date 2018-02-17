package com.simplemobiletools.fileproperties.extensions;

import android.text.format.DateFormat;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Locale;

public final class LongKt {
    public static final String formatLastModified(long j) {
        Calendar instance = Calendar.getInstance(Locale.ENGLISH);
        instance.setTimeInMillis(j);
        return DateFormat.format("dd.MM.yyyy HH:mm", instance).toString();
    }

    public static final String formatSize(long j) {
        if (j <= ((long) null)) {
            return "0 B";
        }
        int log10 = (int) (Math.log10((double) j) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(((double) j) / Math.pow(1024.0d, (double) log10)) + " " + ((String[]) ((Object[]) new String[]{"B", "kB", "MB", "GB", "TB"}))[log10];
    }
}
