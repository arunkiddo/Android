package com.davemorrissey.labs.subscaleview.p075a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import java.io.InputStream;
import java.util.List;

/* renamed from: com.davemorrissey.labs.subscaleview.a.f */
public class C1323f implements C1321d {
    private BitmapRegionDecoder f3387a;
    private final Object f3388b;

    public C1323f() {
        this.f3388b = new Object();
    }

    public Bitmap m6317a(Rect rect, int i) {
        Bitmap decodeRegion;
        synchronized (this.f3388b) {
            Options options = new Options();
            options.inSampleSize = i;
            options.inPreferredConfig = Config.RGB_565;
            decodeRegion = this.f3387a.decodeRegion(rect, options);
            if (decodeRegion == null) {
                throw new RuntimeException("Skia image decoder returned null bitmap - image format may not be supported");
            }
        }
        return decodeRegion;
    }

    public Point m6318a(Context context, Uri uri) {
        String uri2 = uri.toString();
        if (uri2.startsWith("android.resource://")) {
            int identifier;
            String authority = uri.getAuthority();
            Resources resources = context.getPackageName().equals(authority) ? context.getResources() : context.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            int size = pathSegments.size();
            if (size == 2 && ((String) pathSegments.get(0)).equals("drawable")) {
                identifier = resources.getIdentifier((String) pathSegments.get(1), "drawable", authority);
            } else if (size == 1 && TextUtils.isDigitsOnly((CharSequence) pathSegments.get(0))) {
                try {
                    identifier = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    identifier = 0;
                }
            } else {
                identifier = 0;
            }
            this.f3387a = BitmapRegionDecoder.newInstance(context.getResources().openRawResource(identifier), false);
        } else if (uri2.startsWith("file:///android_asset/")) {
            this.f3387a = BitmapRegionDecoder.newInstance(context.getAssets().open(uri2.substring("file:///android_asset/".length()), 1), false);
        } else if (uri2.startsWith("file://")) {
            this.f3387a = BitmapRegionDecoder.newInstance(uri2.substring("file://".length()), false);
        } else {
            InputStream inputStream = null;
            try {
                inputStream = context.getContentResolver().openInputStream(uri);
                this.f3387a = BitmapRegionDecoder.newInstance(inputStream, false);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e2) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e3) {
                    }
                }
            }
        }
        return new Point(this.f3387a.getWidth(), this.f3387a.getHeight());
    }

    public boolean m6319a() {
        return (this.f3387a == null || this.f3387a.isRecycled()) ? false : true;
    }

    public void m6320b() {
        this.f3387a.recycle();
    }
}
