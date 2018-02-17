package com.theartofdev.edmodo.cropper;

import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.simplemobiletools.gallery.BuildConfig;
import com.theartofdev.edmodo.cropper.CropImageView.C1348b;
import com.theartofdev.edmodo.cropper.CropImageView.C1349c;
import com.theartofdev.edmodo.cropper.CropImageView.C1353h;
import com.theartofdev.edmodo.cropper.CropImageView.C1354i;

/* renamed from: com.theartofdev.edmodo.cropper.e */
public class C1366e implements Parcelable {
    public static final Creator<C1366e> CREATOR;
    public int f3541A;
    public int f3542B;
    public int f3543C;
    public String f3544D;
    public int f3545E;
    public Uri f3546F;
    public CompressFormat f3547G;
    public int f3548H;
    public int f3549I;
    public int f3550J;
    public C1353h f3551K;
    public boolean f3552L;
    public Rect f3553M;
    public int f3554N;
    public boolean f3555O;
    public boolean f3556P;
    public int f3557Q;
    public C1348b f3558a;
    public float f3559b;
    public float f3560c;
    public C1349c f3561d;
    public C1354i f3562e;
    public boolean f3563f;
    public boolean f3564g;
    public boolean f3565h;
    public boolean f3566i;
    public int f3567j;
    public float f3568k;
    public boolean f3569l;
    public int f3570m;
    public int f3571n;
    public float f3572o;
    public int f3573p;
    public float f3574q;
    public float f3575r;
    public float f3576s;
    public int f3577t;
    public float f3578u;
    public int f3579v;
    public int f3580w;
    public int f3581x;
    public int f3582y;
    public int f3583z;

    /* renamed from: com.theartofdev.edmodo.cropper.e.1 */
    static class C13651 implements Creator<C1366e> {
        C13651() {
        }

        public C1366e m6420a(Parcel parcel) {
            return new C1366e(parcel);
        }

        public C1366e[] m6421a(int i) {
            return new C1366e[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m6420a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m6421a(i);
        }
    }

    static {
        CREATOR = new C13651();
    }

    public C1366e() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        this.f3558a = C1348b.RECTANGLE;
        this.f3559b = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f3560c = TypedValue.applyDimension(1, 24.0f, displayMetrics);
        this.f3561d = C1349c.ON_TOUCH;
        this.f3562e = C1354i.FIT_CENTER;
        this.f3563f = true;
        this.f3564g = true;
        this.f3565h = true;
        this.f3566i = false;
        this.f3567j = 4;
        this.f3568k = 0.1f;
        this.f3569l = false;
        this.f3570m = 1;
        this.f3571n = 1;
        this.f3572o = TypedValue.applyDimension(1, 3.0f, displayMetrics);
        this.f3573p = Color.argb(170, 255, 255, 255);
        this.f3574q = TypedValue.applyDimension(1, 2.0f, displayMetrics);
        this.f3575r = TypedValue.applyDimension(1, 5.0f, displayMetrics);
        this.f3576s = TypedValue.applyDimension(1, 14.0f, displayMetrics);
        this.f3577t = -1;
        this.f3578u = TypedValue.applyDimension(1, 1.0f, displayMetrics);
        this.f3579v = Color.argb(170, 255, 255, 255);
        this.f3580w = Color.argb(119, 0, 0, 0);
        this.f3581x = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f3582y = (int) TypedValue.applyDimension(1, 42.0f, displayMetrics);
        this.f3583z = 40;
        this.f3541A = 40;
        this.f3542B = 99999;
        this.f3543C = 99999;
        this.f3544D = BuildConfig.FLAVOR;
        this.f3545E = 0;
        this.f3546F = Uri.EMPTY;
        this.f3547G = CompressFormat.JPEG;
        this.f3548H = 90;
        this.f3549I = 0;
        this.f3550J = 0;
        this.f3551K = C1353h.NONE;
        this.f3552L = false;
        this.f3553M = null;
        this.f3554N = -1;
        this.f3555O = true;
        this.f3556P = false;
        this.f3557Q = 90;
    }

    protected C1366e(Parcel parcel) {
        boolean z = true;
        this.f3558a = C1348b.values()[parcel.readInt()];
        this.f3559b = parcel.readFloat();
        this.f3560c = parcel.readFloat();
        this.f3561d = C1349c.values()[parcel.readInt()];
        this.f3562e = C1354i.values()[parcel.readInt()];
        this.f3563f = parcel.readByte() != null;
        this.f3564g = parcel.readByte() != null;
        this.f3565h = parcel.readByte() != null;
        this.f3566i = parcel.readByte() != null;
        this.f3567j = parcel.readInt();
        this.f3568k = parcel.readFloat();
        this.f3569l = parcel.readByte() != null;
        this.f3570m = parcel.readInt();
        this.f3571n = parcel.readInt();
        this.f3572o = parcel.readFloat();
        this.f3573p = parcel.readInt();
        this.f3574q = parcel.readFloat();
        this.f3575r = parcel.readFloat();
        this.f3576s = parcel.readFloat();
        this.f3577t = parcel.readInt();
        this.f3578u = parcel.readFloat();
        this.f3579v = parcel.readInt();
        this.f3580w = parcel.readInt();
        this.f3581x = parcel.readInt();
        this.f3582y = parcel.readInt();
        this.f3583z = parcel.readInt();
        this.f3541A = parcel.readInt();
        this.f3542B = parcel.readInt();
        this.f3543C = parcel.readInt();
        this.f3544D = parcel.readString();
        this.f3545E = parcel.readInt();
        this.f3546F = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        this.f3547G = CompressFormat.valueOf(parcel.readString());
        this.f3548H = parcel.readInt();
        this.f3549I = parcel.readInt();
        this.f3550J = parcel.readInt();
        this.f3551K = C1353h.values()[parcel.readInt()];
        this.f3552L = parcel.readByte() != null;
        this.f3553M = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.f3554N = parcel.readInt();
        this.f3555O = parcel.readByte() != null;
        if (parcel.readByte() == null) {
            z = false;
        }
        this.f3556P = z;
        this.f3557Q = parcel.readInt();
    }

    public void m6422a() {
        if (this.f3567j < 0) {
            throw new IllegalArgumentException("Cannot set max zoom to a number < 1");
        } else if (this.f3560c < 0.0f) {
            throw new IllegalArgumentException("Cannot set touch radius value to a number <= 0 ");
        } else if (this.f3568k < 0.0f || ((double) this.f3568k) >= 0.5d) {
            throw new IllegalArgumentException("Cannot set initial crop window padding value to a number < 0 or >= 0.5");
        } else if (this.f3570m <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f3571n <= 0) {
            throw new IllegalArgumentException("Cannot set aspect ratio value to a number less than or equal to 0.");
        } else if (this.f3572o < 0.0f) {
            throw new IllegalArgumentException("Cannot set line thickness value to a number less than 0.");
        } else if (this.f3574q < 0.0f) {
            throw new IllegalArgumentException("Cannot set corner thickness value to a number less than 0.");
        } else if (this.f3578u < 0.0f) {
            throw new IllegalArgumentException("Cannot set guidelines thickness value to a number less than 0.");
        } else if (this.f3582y < 0) {
            throw new IllegalArgumentException("Cannot set min crop window height value to a number < 0 ");
        } else if (this.f3583z < 0) {
            throw new IllegalArgumentException("Cannot set min crop result width value to a number < 0 ");
        } else if (this.f3541A < 0) {
            throw new IllegalArgumentException("Cannot set min crop result height value to a number < 0 ");
        } else if (this.f3542B < this.f3583z) {
            throw new IllegalArgumentException("Cannot set max crop result width to smaller value than min crop result width");
        } else if (this.f3543C < this.f3541A) {
            throw new IllegalArgumentException("Cannot set max crop result height to smaller value than min crop result height");
        } else if (this.f3549I < 0) {
            throw new IllegalArgumentException("Cannot set request width value to a number < 0 ");
        } else if (this.f3550J < 0) {
            throw new IllegalArgumentException("Cannot set request height value to a number < 0 ");
        } else if (this.f3557Q < 0 || this.f3557Q > 360) {
            throw new IllegalArgumentException("Cannot set rotation degrees value to a number < 0 or > 360");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.f3558a.ordinal());
        parcel.writeFloat(this.f3559b);
        parcel.writeFloat(this.f3560c);
        parcel.writeInt(this.f3561d.ordinal());
        parcel.writeInt(this.f3562e.ordinal());
        parcel.writeByte((byte) (this.f3563f ? 1 : 0));
        parcel.writeByte((byte) (this.f3564g ? 1 : 0));
        parcel.writeByte((byte) (this.f3565h ? 1 : 0));
        parcel.writeByte((byte) (this.f3566i ? 1 : 0));
        parcel.writeInt(this.f3567j);
        parcel.writeFloat(this.f3568k);
        parcel.writeByte((byte) (this.f3569l ? 1 : 0));
        parcel.writeInt(this.f3570m);
        parcel.writeInt(this.f3571n);
        parcel.writeFloat(this.f3572o);
        parcel.writeInt(this.f3573p);
        parcel.writeFloat(this.f3574q);
        parcel.writeFloat(this.f3575r);
        parcel.writeFloat(this.f3576s);
        parcel.writeInt(this.f3577t);
        parcel.writeFloat(this.f3578u);
        parcel.writeInt(this.f3579v);
        parcel.writeInt(this.f3580w);
        parcel.writeInt(this.f3581x);
        parcel.writeInt(this.f3582y);
        parcel.writeInt(this.f3583z);
        parcel.writeInt(this.f3541A);
        parcel.writeInt(this.f3542B);
        parcel.writeInt(this.f3543C);
        parcel.writeString(this.f3544D);
        parcel.writeInt(this.f3545E);
        parcel.writeParcelable(this.f3546F, i);
        parcel.writeString(this.f3547G.name());
        parcel.writeInt(this.f3548H);
        parcel.writeInt(this.f3549I);
        parcel.writeInt(this.f3550J);
        parcel.writeInt(this.f3551K.ordinal());
        parcel.writeInt(this.f3552L ? 1 : 0);
        parcel.writeParcelable(this.f3553M, i);
        parcel.writeInt(this.f3554N);
        parcel.writeByte((byte) (this.f3555O ? 1 : 0));
        if (!this.f3556P) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeInt(this.f3557Q);
    }
}
