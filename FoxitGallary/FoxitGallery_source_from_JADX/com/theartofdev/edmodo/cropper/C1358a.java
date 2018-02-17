package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.net.Uri;
import android.os.AsyncTask;
import com.theartofdev.edmodo.cropper.C1363c.C1361a;
import com.theartofdev.edmodo.cropper.CropImageView.C1353h;
import java.lang.ref.WeakReference;

/* renamed from: com.theartofdev.edmodo.cropper.a */
final class C1358a extends AsyncTask<Void, Void, C1357a> {
    private final WeakReference<CropImageView> f3492a;
    private final Bitmap f3493b;
    private final Uri f3494c;
    private final Context f3495d;
    private final float[] f3496e;
    private final int f3497f;
    private final int f3498g;
    private final int f3499h;
    private final boolean f3500i;
    private final int f3501j;
    private final int f3502k;
    private final int f3503l;
    private final int f3504m;
    private final C1353h f3505n;
    private final Uri f3506o;
    private final CompressFormat f3507p;
    private final int f3508q;

    /* renamed from: com.theartofdev.edmodo.cropper.a.a */
    public static final class C1357a {
        public final Bitmap f3487a;
        public final Uri f3488b;
        public final Exception f3489c;
        public final boolean f3490d;
        public final int f3491e;

        C1357a(Bitmap bitmap, int i) {
            this.f3487a = bitmap;
            this.f3488b = null;
            this.f3489c = null;
            this.f3490d = false;
            this.f3491e = i;
        }

        C1357a(Uri uri, int i) {
            this.f3487a = null;
            this.f3488b = uri;
            this.f3489c = null;
            this.f3490d = true;
            this.f3491e = i;
        }

        C1357a(Exception exception, boolean z) {
            this.f3487a = null;
            this.f3488b = null;
            this.f3489c = exception;
            this.f3490d = z;
            this.f3491e = 1;
        }
    }

    public C1358a(CropImageView cropImageView, Bitmap bitmap, float[] fArr, int i, boolean z, int i2, int i3, int i4, int i5, C1353h c1353h, Uri uri, CompressFormat compressFormat, int i6) {
        this.f3492a = new WeakReference(cropImageView);
        this.f3495d = cropImageView.getContext();
        this.f3493b = bitmap;
        this.f3496e = fArr;
        this.f3494c = null;
        this.f3497f = i;
        this.f3500i = z;
        this.f3501j = i2;
        this.f3502k = i3;
        this.f3503l = i4;
        this.f3504m = i5;
        this.f3505n = c1353h;
        this.f3506o = uri;
        this.f3507p = compressFormat;
        this.f3508q = i6;
        this.f3498g = 0;
        this.f3499h = 0;
    }

    public C1358a(CropImageView cropImageView, Uri uri, float[] fArr, int i, int i2, int i3, boolean z, int i4, int i5, int i6, int i7, C1353h c1353h, Uri uri2, CompressFormat compressFormat, int i8) {
        this.f3492a = new WeakReference(cropImageView);
        this.f3495d = cropImageView.getContext();
        this.f3494c = uri;
        this.f3496e = fArr;
        this.f3497f = i;
        this.f3500i = z;
        this.f3501j = i4;
        this.f3502k = i5;
        this.f3498g = i2;
        this.f3499h = i3;
        this.f3503l = i6;
        this.f3504m = i7;
        this.f3505n = c1353h;
        this.f3506o = uri2;
        this.f3507p = compressFormat;
        this.f3508q = i8;
        this.f3493b = null;
    }

    protected C1357a m6384a(Void... voidArr) {
        Bitmap bitmap = null;
        try {
            if (isCancelled()) {
                return null;
            }
            int i;
            if (this.f3494c != null) {
                C1361a a = C1363c.m6402a(this.f3495d, this.f3494c, this.f3496e, this.f3497f, this.f3498g, this.f3499h, this.f3500i, this.f3501j, this.f3502k, this.f3503l, this.f3504m);
                Bitmap bitmap2 = a.f3519a;
                int i2 = a.f3520b;
                bitmap = bitmap2;
                i = i2;
            } else if (this.f3493b != null) {
                bitmap = C1363c.m6396a(this.f3493b, this.f3496e, this.f3497f, this.f3500i, this.f3501j, this.f3502k);
                i = 1;
            } else {
                i = 1;
            }
            Bitmap a2 = C1363c.m6395a(bitmap, this.f3503l, this.f3504m, this.f3505n);
            if (this.f3506o == null) {
                return new C1357a(a2, i);
            }
            C1363c.m6408a(this.f3495d, a2, this.f3506o, this.f3507p, this.f3508q);
            if (a2 != null) {
                a2.recycle();
            }
            return new C1357a(this.f3506o, i);
        } catch (Exception e) {
            return new C1357a(e, this.f3506o != null);
        }
    }

    protected void m6385a(C1357a c1357a) {
        if (c1357a != null) {
            Object obj = null;
            if (!isCancelled()) {
                CropImageView cropImageView = (CropImageView) this.f3492a.get();
                if (cropImageView != null) {
                    obj = 1;
                    cropImageView.m6360a(c1357a);
                }
            }
            if (obj == null && c1357a.f3487a != null) {
                c1357a.f3487a.recycle();
            }
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m6384a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m6385a((C1357a) obj);
    }
}
