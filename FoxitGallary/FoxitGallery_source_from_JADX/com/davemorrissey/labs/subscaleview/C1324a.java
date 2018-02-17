package com.davemorrissey.labs.subscaleview;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/* renamed from: com.davemorrissey.labs.subscaleview.a */
public final class C1324a {
    private final Uri f3389a;
    private final Bitmap f3390b;
    private final Integer f3391c;
    private boolean f3392d;
    private int f3393e;
    private int f3394f;
    private Rect f3395g;
    private boolean f3396h;

    private C1324a(int i) {
        this.f3390b = null;
        this.f3389a = null;
        this.f3391c = Integer.valueOf(i);
        this.f3392d = true;
    }

    private C1324a(Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith("file:///") && !new File(uri2.substring("file:///".length() - 1)).exists()) {
            try {
                uri = Uri.parse(URLDecoder.decode(uri2, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
            }
        }
        this.f3390b = null;
        this.f3389a = uri;
        this.f3391c = null;
        this.f3392d = true;
    }

    public static C1324a m6321a(int i) {
        return new C1324a(i);
    }

    public static C1324a m6322a(String str) {
        if (str != null) {
            return C1324a.m6323b("file:///android_asset/" + str);
        }
        throw new NullPointerException("Asset name must not be null");
    }

    public static C1324a m6323b(String str) {
        if (str == null) {
            throw new NullPointerException("Uri must not be null");
        }
        if (!str.contains("://")) {
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            str = "file:///" + str;
        }
        return new C1324a(Uri.parse(str));
    }

    public C1324a m6324a() {
        return m6325a(true);
    }

    public C1324a m6325a(boolean z) {
        this.f3392d = z;
        return this;
    }

    protected final Uri m6326b() {
        return this.f3389a;
    }

    protected final Bitmap m6327c() {
        return this.f3390b;
    }

    protected final Integer m6328d() {
        return this.f3391c;
    }

    protected final boolean m6329e() {
        return this.f3392d;
    }

    protected final int m6330f() {
        return this.f3393e;
    }

    protected final int m6331g() {
        return this.f3394f;
    }

    protected final Rect m6332h() {
        return this.f3395g;
    }

    protected final boolean m6333i() {
        return this.f3396h;
    }
}
