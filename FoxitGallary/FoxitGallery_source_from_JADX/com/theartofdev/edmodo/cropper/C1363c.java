package com.theartofdev.edmodo.cropper;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.util.Log;
import android.util.Pair;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import com.theartofdev.edmodo.cropper.CropImageView.C1353h;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

/* renamed from: com.theartofdev.edmodo.cropper.c */
final class C1363c {
    static final Rect f3523a;
    static final RectF f3524b;
    static final RectF f3525c;
    static final float[] f3526d;
    static final float[] f3527e;
    static int f3528f;
    static Pair<String, WeakReference<Bitmap>> f3529g;

    /* renamed from: com.theartofdev.edmodo.cropper.c.a */
    public static final class C1361a {
        public final Bitmap f3519a;
        public final int f3520b;

        public C1361a(Bitmap bitmap, int i) {
            this.f3519a = bitmap;
            this.f3520b = i;
        }
    }

    /* renamed from: com.theartofdev.edmodo.cropper.c.b */
    public static final class C1362b {
        public final Bitmap f3521a;
        public final int f3522b;

        C1362b(Bitmap bitmap, int i) {
            this.f3521a = bitmap;
            this.f3522b = i;
        }
    }

    static {
        f3523a = new Rect();
        f3524b = new RectF();
        f3525c = new RectF();
        f3526d = new float[6];
        f3527e = new float[6];
    }

    public static float m6389a(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    private static int m6390a() {
        int i = 0;
        try {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
            egl10.eglInitialize(eglGetDisplay, new int[2]);
            int[] iArr = new int[1];
            egl10.eglGetConfigs(eglGetDisplay, null, 0, iArr);
            EGLConfig[] eGLConfigArr = new EGLConfig[iArr[0]];
            egl10.eglGetConfigs(eglGetDisplay, eGLConfigArr, iArr[0], iArr);
            int[] iArr2 = new int[1];
            for (int i2 = 0; i2 < iArr[0]; i2++) {
                egl10.eglGetConfigAttrib(eglGetDisplay, eGLConfigArr[i2], 12332, iArr2);
                if (i < iArr2[0]) {
                    i = iArr2[0];
                }
            }
            egl10.eglTerminate(eglGetDisplay);
            return Math.max(i, 2048);
        } catch (Exception e) {
            return 2048;
        }
    }

    private static int m6391a(int i, int i2) {
        int i3 = 1;
        if (f3528f == 0) {
            f3528f = C1363c.m6390a();
        }
        if (f3528f > 0) {
            while (true) {
                if (i2 / i3 <= f3528f && i / i3 <= f3528f) {
                    break;
                }
                i3 *= 2;
            }
        }
        return i3;
    }

    private static int m6392a(int i, int i2, int i3, int i4) {
        int i5 = 1;
        if (i2 > i4 || i > i3) {
            while ((i2 / 2) / i5 > i4 && (i / 2) / i5 > i3) {
                i5 *= 2;
            }
        }
        return i5;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Bitmap m6393a(android.content.ContentResolver r4, android.net.Uri r5, android.graphics.BitmapFactory.Options r6) {
        /*
    L_0x0000:
        r0 = 0;
        r0 = r4.openInputStream(r5);	 Catch:{ OutOfMemoryError -> 0x000f, all -> 0x0038 }
        r1 = f3523a;	 Catch:{ OutOfMemoryError -> 0x000f }
        r1 = android.graphics.BitmapFactory.decodeStream(r0, r1, r6);	 Catch:{ OutOfMemoryError -> 0x000f }
        com.theartofdev.edmodo.cropper.C1363c.m6410a(r0);
        return r1;
    L_0x000f:
        r1 = move-exception;
        r1 = r6.inSampleSize;	 Catch:{ all -> 0x0040 }
        r1 = r1 * 2;
        r6.inSampleSize = r1;	 Catch:{ all -> 0x0040 }
        com.theartofdev.edmodo.cropper.C1363c.m6410a(r0);
        r0 = r6.inSampleSize;
        r1 = 512; // 0x200 float:7.175E-43 double:2.53E-321;
        if (r0 <= r1) goto L_0x0000;
    L_0x001f:
        r0 = new java.lang.RuntimeException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Failed to decode image: ";
        r1 = r1.append(r2);
        r1 = r1.append(r5);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0038:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
    L_0x003c:
        com.theartofdev.edmodo.cropper.C1363c.m6410a(r1);
        throw r0;
    L_0x0040:
        r1 = move-exception;
        r3 = r1;
        r1 = r0;
        r0 = r3;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.c.a(android.content.ContentResolver, android.net.Uri, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    private static Bitmap m6394a(Bitmap bitmap, int i) {
        if (i <= 0) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static Bitmap m6395a(Bitmap bitmap, int i, int i2, C1353h c1353h) {
        if (i <= 0 || i2 <= 0) {
            return bitmap;
        }
        try {
            if (c1353h != C1353h.RESIZE_FIT && c1353h != C1353h.RESIZE_INSIDE && c1353h != C1353h.RESIZE_EXACT) {
                return bitmap;
            }
            Bitmap bitmap2 = null;
            if (c1353h == C1353h.RESIZE_EXACT) {
                bitmap2 = Bitmap.createScaledBitmap(bitmap, i, i2, false);
            } else {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                float max = Math.max(((float) width) / ((float) i), ((float) height) / ((float) i2));
                if (max > 1.0f || c1353h == C1353h.RESIZE_FIT) {
                    bitmap2 = Bitmap.createScaledBitmap(bitmap, (int) (((float) width) / max), (int) (((float) height) / max), false);
                }
            }
            if (bitmap2 == null) {
                return bitmap;
            }
            if (bitmap2 != bitmap) {
                bitmap.recycle();
            }
            return bitmap2;
        } catch (Throwable e) {
            Log.w("AIC", "Failed to resize cropped image, return bitmap before resize", e);
            return bitmap;
        }
    }

    public static Bitmap m6396a(Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3) {
        Rect a = C1363c.m6399a(fArr, bitmap.getWidth(), bitmap.getHeight(), z, i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate((float) i, (float) (bitmap.getWidth() / 2), (float) (bitmap.getHeight() / 2));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, a.left, a.top, a.width(), a.height(), matrix, true);
        if (createBitmap == bitmap) {
            createBitmap = bitmap.copy(bitmap.getConfig(), false);
        }
        return i % 90 != 0 ? C1363c.m6397a(createBitmap, fArr, a, i, z, i2, i3) : createBitmap;
    }

    private static Bitmap m6397a(Bitmap bitmap, float[] fArr, Rect rect, int i, boolean z, int i2, int i3) {
        if (i % 90 == 0) {
            return bitmap;
        }
        int abs;
        int i4;
        double toRadians = Math.toRadians((double) i);
        int i5 = (i < 90 || (i > 180 && i < 270)) ? rect.left : rect.right;
        int i6 = 0;
        while (i6 < fArr.length) {
            if (fArr[i6] >= ((float) (i5 - 1)) && fArr[i6] <= ((float) (i5 + 1))) {
                int abs2 = (int) Math.abs(Math.sin(toRadians) * ((double) (((float) rect.bottom) - fArr[i6 + 1])));
                abs = (int) Math.abs(Math.cos(toRadians) * ((double) (fArr[i6 + 1] - ((float) rect.top))));
                i5 = (int) Math.abs(((double) (((float) rect.bottom) - fArr[i6 + 1])) / Math.cos(toRadians));
                i6 = (int) Math.abs(((double) (fArr[i6 + 1] - ((float) rect.top))) / Math.sin(toRadians));
                i4 = abs;
                abs = abs2;
                break;
            }
            i6 += 2;
        }
        i5 = 0;
        i6 = 0;
        i4 = 0;
        abs = 0;
        rect.set(abs, i4, i6 + abs, i5 + i4);
        if (z) {
            C1363c.m6409a(rect, i2, i3);
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, rect.left, rect.top, rect.width(), rect.height());
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    private static Options m6398a(ContentResolver contentResolver, Uri uri) {
        Closeable closeable = null;
        try {
            closeable = contentResolver.openInputStream(uri);
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(closeable, f3523a, options);
            options.inJustDecodeBounds = false;
            return options;
        } finally {
            C1363c.m6410a(closeable);
        }
    }

    public static Rect m6399a(float[] fArr, int i, int i2, boolean z, int i3, int i4) {
        Rect rect = new Rect(Math.round(Math.max(0.0f, C1363c.m6389a(fArr))), Math.round(Math.max(0.0f, C1363c.m6411b(fArr))), Math.round(Math.min((float) i, C1363c.m6412c(fArr))), Math.round(Math.min((float) i2, C1363c.m6413d(fArr))));
        if (z) {
            C1363c.m6409a(rect, i3, i4);
        }
        return rect;
    }

    public static C1361a m6400a(Context context, Uri uri, int i, int i2) {
        try {
            ContentResolver contentResolver = context.getContentResolver();
            Options a = C1363c.m6398a(contentResolver, uri);
            a.inSampleSize = Math.max(C1363c.m6392a(a.outWidth, a.outHeight, i, i2), C1363c.m6391a(a.outWidth, a.outHeight));
            return new C1361a(C1363c.m6393a(contentResolver, uri, a), a.inSampleSize);
        } catch (Throwable e) {
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e.getMessage(), e);
        }
    }

    private static C1361a m6401a(Context context, Uri uri, Rect rect, int i, int i2, int i3) {
        Throwable e;
        Closeable closeable = null;
        BitmapRegionDecoder newInstance;
        try {
            Options options = new Options();
            options.inSampleSize = C1363c.m6392a(rect.width(), rect.height(), i, i2) * i3;
            Closeable openInputStream = context.getContentResolver().openInputStream(uri);
            try {
                newInstance = BitmapRegionDecoder.newInstance(openInputStream, false);
                do {
                    try {
                        C1361a c1361a = new C1361a(newInstance.decodeRegion(rect, options), options.inSampleSize);
                        C1363c.m6410a(openInputStream);
                        if (newInstance == null) {
                            return c1361a;
                        }
                        newInstance.recycle();
                        return c1361a;
                    } catch (OutOfMemoryError e2) {
                        try {
                            options.inSampleSize *= 2;
                            if (options.inSampleSize > 512) {
                                C1363c.m6410a(openInputStream);
                                if (newInstance != null) {
                                    newInstance.recycle();
                                }
                                return new C1361a(null, 1);
                            }
                        } catch (Exception e3) {
                            e = e3;
                            closeable = openInputStream;
                        } catch (Throwable th) {
                            e = th;
                            closeable = openInputStream;
                        }
                    }
                } while (options.inSampleSize > 512);
                C1363c.m6410a(openInputStream);
                if (newInstance != null) {
                    newInstance.recycle();
                }
                return new C1361a(null, 1);
            } catch (Exception e4) {
                e = e4;
                newInstance = null;
                closeable = openInputStream;
                try {
                    throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e.getMessage(), e);
                } catch (Throwable th2) {
                    e = th2;
                    C1363c.m6410a(closeable);
                    if (newInstance != null) {
                        newInstance.recycle();
                    }
                    throw e;
                }
            } catch (Throwable th3) {
                e = th3;
                newInstance = null;
                closeable = openInputStream;
                C1363c.m6410a(closeable);
                if (newInstance != null) {
                    newInstance.recycle();
                }
                throw e;
            }
        } catch (Exception e5) {
            e = e5;
            newInstance = null;
            throw new RuntimeException("Failed to load sampled bitmap: " + uri + "\r\n" + e.getMessage(), e);
        } catch (Throwable th4) {
            e = th4;
            newInstance = null;
            C1363c.m6410a(closeable);
            if (newInstance != null) {
                newInstance.recycle();
            }
            throw e;
        }
    }

    public static C1361a m6402a(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7) {
        int i8 = 1;
        do {
            try {
                return C1363c.m6403a(context, uri, fArr, i, i2, i3, z, i4, i5, i6, i7, i8);
            } catch (Throwable e) {
                i8 *= 2;
                if (i8 > 16) {
                    throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + "\r\n" + e.getMessage(), e);
                }
            }
        } while (i8 > 16);
        throw new RuntimeException("Failed to handle OOM by sampling (" + i8 + "): " + uri + "\r\n" + e.getMessage(), e);
    }

    private static C1361a m6403a(Context context, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, int i8) {
        Bitmap bitmap;
        Bitmap bitmap2;
        Rect a = C1363c.m6399a(fArr, i2, i3, z, i4, i5);
        int width = i6 > 0 ? i6 : a.width();
        int height = i7 > 0 ? i7 : a.height();
        int i9 = 1;
        try {
            C1361a a2 = C1363c.m6401a(context, uri, a, width, height, i8);
            bitmap = a2.f3519a;
            try {
                i9 = a2.f3520b;
                bitmap2 = bitmap;
            } catch (Exception e) {
                bitmap2 = bitmap;
                if (bitmap2 != null) {
                    return C1363c.m6404a(context, uri, fArr, i, z, i4, i5, i8, a, width, height);
                }
                try {
                    bitmap = C1363c.m6394a(bitmap2, i);
                    try {
                        if (i % 90 != 0) {
                            bitmap = C1363c.m6397a(bitmap, fArr, a, i, z, i4, i5);
                        }
                        return new C1361a(bitmap, i9);
                    } catch (OutOfMemoryError e2) {
                        OutOfMemoryError outOfMemoryError = e2;
                        bitmap2 = bitmap;
                        r1 = outOfMemoryError;
                        if (bitmap2 != null) {
                            bitmap2.recycle();
                        }
                        throw r1;
                    }
                } catch (OutOfMemoryError e3) {
                    OutOfMemoryError outOfMemoryError2;
                    outOfMemoryError2 = e3;
                    if (bitmap2 != null) {
                        bitmap2.recycle();
                    }
                    throw outOfMemoryError2;
                }
            }
        } catch (Exception e4) {
            bitmap = null;
            bitmap2 = bitmap;
            if (bitmap2 != null) {
                return C1363c.m6404a(context, uri, fArr, i, z, i4, i5, i8, a, width, height);
            }
            bitmap = C1363c.m6394a(bitmap2, i);
            if (i % 90 != 0) {
                bitmap = C1363c.m6397a(bitmap, fArr, a, i, z, i4, i5);
            }
            return new C1361a(bitmap, i9);
        }
        if (bitmap2 != null) {
            return C1363c.m6404a(context, uri, fArr, i, z, i4, i5, i8, a, width, height);
        }
        bitmap = C1363c.m6394a(bitmap2, i);
        if (i % 90 != 0) {
            bitmap = C1363c.m6397a(bitmap, fArr, a, i, z, i4, i5);
        }
        return new C1361a(bitmap, i9);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.theartofdev.edmodo.cropper.C1363c.C1361a m6404a(android.content.Context r10, android.net.Uri r11, float[] r12, int r13, boolean r14, int r15, int r16, int r17, android.graphics.Rect r18, int r19, int r20) {
        /*
        r8 = 0;
        r5 = new android.graphics.BitmapFactory$Options;	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
        r5.<init>();	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
        r2 = r18.width();	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
        r3 = r18.height();	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
        r0 = r19;
        r1 = r20;
        r2 = com.theartofdev.edmodo.cropper.C1363c.m6392a(r2, r3, r0, r1);	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
        r9 = r17 * r2;
        r5.inSampleSize = r9;	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
        r2 = r10.getContentResolver();	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
        r2 = com.theartofdev.edmodo.cropper.C1363c.m6393a(r2, r11, r5);	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
        if (r2 == 0) goto L_0x008c;
    L_0x0024:
        r3 = r12.length;	 Catch:{ all -> 0x0051 }
        r3 = new float[r3];	 Catch:{ all -> 0x0051 }
        r4 = 0;
        r6 = 0;
        r7 = r12.length;	 Catch:{ all -> 0x0051 }
        java.lang.System.arraycopy(r12, r4, r3, r6, r7);	 Catch:{ all -> 0x0051 }
        r4 = 0;
    L_0x002e:
        r6 = r3.length;	 Catch:{ all -> 0x0051 }
        if (r4 >= r6) goto L_0x003c;
    L_0x0031:
        r6 = r3[r4];	 Catch:{ all -> 0x0051 }
        r7 = r5.inSampleSize;	 Catch:{ all -> 0x0051 }
        r7 = (float) r7;	 Catch:{ all -> 0x0051 }
        r6 = r6 / r7;
        r3[r4] = r6;	 Catch:{ all -> 0x0051 }
        r4 = r4 + 1;
        goto L_0x002e;
    L_0x003c:
        r4 = r13;
        r5 = r14;
        r6 = r15;
        r7 = r16;
        r3 = com.theartofdev.edmodo.cropper.C1363c.m6396a(r2, r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0051 }
        if (r3 == r2) goto L_0x008a;
    L_0x0047:
        r2.recycle();	 Catch:{ OutOfMemoryError -> 0x0087, Exception -> 0x005f }
        r2 = r3;
    L_0x004b:
        r3 = new com.theartofdev.edmodo.cropper.c$a;
        r3.<init>(r2, r9);
        return r3;
    L_0x0051:
        r3 = move-exception;
        if (r2 == 0) goto L_0x0057;
    L_0x0054:
        r2.recycle();	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
    L_0x0057:
        throw r3;	 Catch:{ OutOfMemoryError -> 0x0058, Exception -> 0x005f }
    L_0x0058:
        r2 = move-exception;
    L_0x0059:
        if (r8 == 0) goto L_0x005e;
    L_0x005b:
        r8.recycle();
    L_0x005e:
        throw r2;
    L_0x005f:
        r2 = move-exception;
        r3 = new java.lang.RuntimeException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "Failed to load sampled bitmap: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = "\r\n";
        r4 = r4.append(r5);
        r5 = r2.getMessage();
        r4 = r4.append(r5);
        r4 = r4.toString();
        r3.<init>(r4, r2);
        throw r3;
    L_0x0087:
        r2 = move-exception;
        r8 = r3;
        goto L_0x0059;
    L_0x008a:
        r2 = r3;
        goto L_0x004b;
    L_0x008c:
        r2 = r8;
        goto L_0x004b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.theartofdev.edmodo.cropper.c.a(android.content.Context, android.net.Uri, float[], int, boolean, int, int, int, android.graphics.Rect, int, int):com.theartofdev.edmodo.cropper.c$a");
    }

    public static C1362b m6405a(Bitmap bitmap, Context context, Uri uri) {
        try {
            File a = C1363c.m6407a(context, uri);
            if (a.exists()) {
                return C1363c.m6406a(bitmap, new ExifInterface(a.getAbsolutePath()));
            }
        } catch (Exception e) {
        }
        return new C1362b(bitmap, 0);
    }

    public static C1362b m6406a(Bitmap bitmap, ExifInterface exifInterface) {
        int i;
        switch (exifInterface.getAttributeInt("Orientation", 1)) {
            case C1373c.View_paddingEnd /*3*/:
                i = 180;
                break;
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                i = 90;
                break;
            case C1373c.Toolbar_contentInsetRight /*8*/:
                i = 270;
                break;
            default:
                i = 0;
                break;
        }
        return new C1362b(bitmap, i);
    }

    private static File m6407a(Context context, Uri uri) {
        File file;
        Cursor cursor;
        Throwable th;
        File file2 = new File(uri.getPath());
        if (file2.exists()) {
            return file2;
        }
        Cursor query;
        try {
            query = context.getContentResolver().query(uri, new String[]{"_data"}, null, null, null);
            try {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                query.moveToFirst();
                file = new File(query.getString(columnIndexOrThrow));
                if (query != null) {
                    query.close();
                }
            } catch (Exception e) {
                cursor = query;
                if (cursor == null) {
                    file = file2;
                } else {
                    cursor.close();
                    file = file2;
                }
                return file;
            } catch (Throwable th2) {
                th = th2;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
        } catch (Exception e2) {
            cursor = null;
            if (cursor == null) {
                cursor.close();
                file = file2;
            } else {
                file = file2;
            }
            return file;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
                query.close();
            }
            throw th;
        }
        return file;
    }

    public static void m6408a(Context context, Bitmap bitmap, Uri uri, CompressFormat compressFormat, int i) {
        Closeable closeable = null;
        try {
            closeable = context.getContentResolver().openOutputStream(uri);
            bitmap.compress(compressFormat, i, closeable);
        } finally {
            C1363c.m6410a(closeable);
        }
    }

    public static void m6409a(Rect rect, int i, int i2) {
        if (i == i2 && rect.width() != rect.height()) {
            if (rect.height() > rect.width()) {
                rect.bottom -= rect.height() - rect.width();
            } else {
                rect.right -= rect.width() - rect.height();
            }
        }
    }

    private static void m6410a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
            }
        }
    }

    public static float m6411b(float[] fArr) {
        return Math.min(Math.min(Math.min(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    public static float m6412c(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[0], fArr[2]), fArr[4]), fArr[6]);
    }

    public static float m6413d(float[] fArr) {
        return Math.max(Math.max(Math.max(fArr[1], fArr[3]), fArr[5]), fArr[7]);
    }

    public static float m6414e(float[] fArr) {
        return C1363c.m6412c(fArr) - C1363c.m6389a(fArr);
    }

    public static float m6415f(float[] fArr) {
        return C1363c.m6413d(fArr) - C1363c.m6411b(fArr);
    }

    public static float m6416g(float[] fArr) {
        return (C1363c.m6412c(fArr) + C1363c.m6389a(fArr)) / 2.0f;
    }

    public static float m6417h(float[] fArr) {
        return (C1363c.m6413d(fArr) + C1363c.m6411b(fArr)) / 2.0f;
    }
}
