package com.simplemobiletools.gallery.extensions;

import android.database.Cursor;
import p000a.p005e.p007b.C0036f;

public final class CursorKt {
    public static final long getLongValue(Cursor cursor, String str) {
        C0036f.m62b(cursor, "$receiver");
        C0036f.m62b(str, "key");
        return cursor.getLong(cursor.getColumnIndex(str));
    }

    public static final String getStringValue(Cursor cursor, String str) {
        C0036f.m62b(cursor, "$receiver");
        C0036f.m62b(str, "key");
        return cursor.getString(cursor.getColumnIndex(str));
    }
}
