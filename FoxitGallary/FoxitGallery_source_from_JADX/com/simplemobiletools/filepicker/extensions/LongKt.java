package com.simplemobiletools.filepicker.extensions;

import java.text.DecimalFormat;

public final class LongKt {
    public static final String formatSize(long j) {
        if (j <= ((long) null)) {
            return "0 B";
        }
        int log10 = (int) (Math.log10((double) j) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(((double) j) / Math.pow(1024.0d, (double) log10)) + " " + ((String[]) ((Object[]) new String[]{"B", "kB", "MB", "GB", "TB"}))[log10];
    }
}
