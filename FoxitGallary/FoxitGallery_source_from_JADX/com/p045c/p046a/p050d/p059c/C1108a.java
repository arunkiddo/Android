package com.p045c.p046a.p050d.p059c;

import android.net.Uri;

/* renamed from: com.c.a.d.c.a */
final class C1108a {
    private static final int f2899a;

    static {
        f2899a = "file:///android_asset/".length();
    }

    public static boolean m5552a(Uri uri) {
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    public static String m5553b(Uri uri) {
        return uri.toString().substring(f2899a);
    }
}
