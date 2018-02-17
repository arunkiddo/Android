package com.p045c.p046a.p050d.p062d.p063a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.Log;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

/* renamed from: com.c.a.d.d.a.r */
public final class C1173r {
    public static int m5711a(int i) {
        switch (i) {
            case C1373c.View_paddingEnd /*3*/:
            case C1373c.View_theme /*4*/:
                return 180;
            case C1373c.Toolbar_contentInsetStart /*5*/:
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                return 90;
            case C1373c.Toolbar_contentInsetLeft /*7*/:
            case C1373c.Toolbar_contentInsetRight /*8*/:
                return 270;
            default:
                return 0;
        }
    }

    private static Config m5712a(Bitmap bitmap) {
        return bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888;
    }

    public static Bitmap m5713a(Bitmap bitmap, Bitmap bitmap2, int i, int i2) {
        float f = 0.0f;
        if (bitmap2 == null) {
            return null;
        }
        if (bitmap2.getWidth() == i && bitmap2.getHeight() == i2) {
            return bitmap2;
        }
        float height;
        float width;
        Matrix matrix = new Matrix();
        if (bitmap2.getWidth() * i2 > bitmap2.getHeight() * i) {
            height = ((float) i2) / ((float) bitmap2.getHeight());
            width = (((float) i) - (((float) bitmap2.getWidth()) * height)) * 0.5f;
        } else {
            height = ((float) i) / ((float) bitmap2.getWidth());
            width = 0.0f;
            f = (((float) i2) - (((float) bitmap2.getHeight()) * height)) * 0.5f;
        }
        matrix.setScale(height, height);
        matrix.postTranslate((float) ((int) (width + 0.5f)), (float) ((int) (f + 0.5f)));
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(i, i2, C1173r.m5712a(bitmap2));
        }
        C1173r.m5717a(bitmap2, bitmap);
        new Canvas(bitmap).drawBitmap(bitmap2, matrix, new Paint(6));
        return bitmap;
    }

    public static Bitmap m5714a(Bitmap bitmap, C1023c c1023c, int i) {
        Matrix matrix = new Matrix();
        C1173r.m5716a(i, matrix);
        if (matrix.isIdentity()) {
            return bitmap;
        }
        RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
        matrix.mapRect(rectF);
        int round = Math.round(rectF.width());
        int round2 = Math.round(rectF.height());
        Config a = C1173r.m5712a(bitmap);
        Bitmap a2 = c1023c.m5339a(round, round2, a);
        if (a2 == null) {
            a2 = Bitmap.createBitmap(round, round2, a);
        }
        matrix.postTranslate(-rectF.left, -rectF.top);
        new Canvas(a2).drawBitmap(bitmap, matrix, new Paint(6));
        return a2;
    }

    public static Bitmap m5715a(Bitmap bitmap, C1023c c1023c, int i, int i2) {
        if (bitmap.getWidth() != i || bitmap.getHeight() != i2) {
            float min = Math.min(((float) i) / ((float) bitmap.getWidth()), ((float) i2) / ((float) bitmap.getHeight()));
            int width = (int) (((float) bitmap.getWidth()) * min);
            int height = (int) (((float) bitmap.getHeight()) * min);
            if (bitmap.getWidth() != width || bitmap.getHeight() != height) {
                Config a = C1173r.m5712a(bitmap);
                Bitmap a2 = c1023c.m5339a(width, height, a);
                if (a2 == null) {
                    a2 = Bitmap.createBitmap(width, height, a);
                }
                C1173r.m5717a(bitmap, a2);
                if (Log.isLoggable("TransformationUtils", 2)) {
                    Log.v("TransformationUtils", "request: " + i + "x" + i2);
                    Log.v("TransformationUtils", "toFit:   " + bitmap.getWidth() + "x" + bitmap.getHeight());
                    Log.v("TransformationUtils", "toReuse: " + a2.getWidth() + "x" + a2.getHeight());
                    Log.v("TransformationUtils", "minPct:   " + min);
                }
                Canvas canvas = new Canvas(a2);
                Matrix matrix = new Matrix();
                matrix.setScale(min, min);
                canvas.drawBitmap(bitmap, matrix, new Paint(6));
                return a2;
            } else if (!Log.isLoggable("TransformationUtils", 2)) {
                return bitmap;
            } else {
                Log.v("TransformationUtils", "adjusted target size matches input, returning input");
                return bitmap;
            }
        } else if (!Log.isLoggable("TransformationUtils", 2)) {
            return bitmap;
        } else {
            Log.v("TransformationUtils", "requested target size matches input, returning input");
            return bitmap;
        }
    }

    static void m5716a(int i, Matrix matrix) {
        switch (i) {
            case C1373c.View_paddingStart /*2*/:
                matrix.setScale(-1.0f, 1.0f);
            case C1373c.View_paddingEnd /*3*/:
                matrix.setRotate(180.0f);
            case C1373c.View_theme /*4*/:
                matrix.setRotate(180.0f);
                matrix.postScale(-1.0f, 1.0f);
            case C1373c.Toolbar_contentInsetStart /*5*/:
                matrix.setRotate(90.0f);
                matrix.postScale(-1.0f, 1.0f);
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                matrix.setRotate(90.0f);
            case C1373c.Toolbar_contentInsetLeft /*7*/:
                matrix.setRotate(-90.0f);
                matrix.postScale(-1.0f, 1.0f);
            case C1373c.Toolbar_contentInsetRight /*8*/:
                matrix.setRotate(-90.0f);
            default:
        }
    }

    @TargetApi(12)
    public static void m5717a(Bitmap bitmap, Bitmap bitmap2) {
        if (VERSION.SDK_INT >= 12 && bitmap2 != null) {
            bitmap2.setHasAlpha(bitmap.hasAlpha());
        }
    }
}
