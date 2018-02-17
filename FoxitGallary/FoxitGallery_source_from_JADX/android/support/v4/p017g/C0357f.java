package android.support.v4.p017g;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

/* renamed from: android.support.v4.g.f */
class C0357f<T> implements ClassLoaderCreator<T> {
    private final C0118e<T> f698a;

    public C0357f(C0118e<T> c0118e) {
        this.f698a = c0118e;
    }

    public T createFromParcel(Parcel parcel) {
        return this.f698a.m243b(parcel, null);
    }

    public T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.f698a.m243b(parcel, classLoader);
    }

    public T[] newArray(int i) {
        return this.f698a.m244b(i);
    }
}
