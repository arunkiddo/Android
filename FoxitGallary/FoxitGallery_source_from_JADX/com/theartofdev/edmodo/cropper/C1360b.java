package com.theartofdev.edmodo.cropper;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import com.theartofdev.edmodo.cropper.C1363c.C1361a;
import com.theartofdev.edmodo.cropper.C1363c.C1362b;
import java.lang.ref.WeakReference;

/* renamed from: com.theartofdev.edmodo.cropper.b */
final class C1360b extends AsyncTask<Void, Void, C1359a> {
    private final WeakReference<CropImageView> f3514a;
    private final Uri f3515b;
    private final Context f3516c;
    private final int f3517d;
    private final int f3518e;

    /* renamed from: com.theartofdev.edmodo.cropper.b.a */
    public static final class C1359a {
        public final Uri f3509a;
        public final Bitmap f3510b;
        public final int f3511c;
        public final int f3512d;
        public final Exception f3513e;

        C1359a(Uri uri, Bitmap bitmap, int i, int i2) {
            this.f3509a = uri;
            this.f3510b = bitmap;
            this.f3511c = i;
            this.f3512d = i2;
            this.f3513e = null;
        }

        C1359a(Uri uri, Exception exception) {
            this.f3509a = uri;
            this.f3510b = null;
            this.f3511c = 0;
            this.f3512d = 0;
            this.f3513e = exception;
        }
    }

    public C1360b(CropImageView cropImageView, Uri uri) {
        this.f3515b = uri;
        this.f3514a = new WeakReference(cropImageView);
        this.f3516c = cropImageView.getContext();
        DisplayMetrics displayMetrics = cropImageView.getResources().getDisplayMetrics();
        double d = displayMetrics.density > 1.0f ? (double) (1.0f / displayMetrics.density) : 1.0d;
        this.f3517d = (int) (((double) displayMetrics.widthPixels) * d);
        this.f3518e = (int) (d * ((double) displayMetrics.heightPixels));
    }

    public Uri m6386a() {
        return this.f3515b;
    }

    protected C1359a m6387a(Void... voidArr) {
        try {
            if (!isCancelled()) {
                C1361a a = C1363c.m6400a(this.f3516c, this.f3515b, this.f3517d, this.f3518e);
                if (!isCancelled()) {
                    C1362b a2 = C1363c.m6405a(a.f3519a, this.f3516c, this.f3515b);
                    return new C1359a(this.f3515b, a2.f3521a, a.f3520b, a2.f3522b);
                }
            }
            return null;
        } catch (Exception e) {
            return new C1359a(this.f3515b, e);
        }
    }

    protected void m6388a(C1359a c1359a) {
        if (c1359a != null) {
            Object obj = null;
            if (!isCancelled()) {
                CropImageView cropImageView = (CropImageView) this.f3514a.get();
                if (cropImageView != null) {
                    obj = 1;
                    cropImageView.m6361a(c1359a);
                }
            }
            if (obj == null && c1359a.f3510b != null) {
                c1359a.f3510b.recycle();
            }
        }
    }

    protected /* synthetic */ Object doInBackground(Object[] objArr) {
        return m6387a((Void[]) objArr);
    }

    protected /* synthetic */ void onPostExecute(Object obj) {
        m6388a((C1359a) obj);
    }
}
