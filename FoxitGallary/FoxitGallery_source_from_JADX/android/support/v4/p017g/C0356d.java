package android.support.v4.p017g;

import android.os.Build.VERSION;
import android.os.Parcel;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.g.d */
public final class C0356d {

    /* renamed from: android.support.v4.g.d.a */
    static class C0355a<T> implements Creator<T> {
        final C0118e<T> f697a;

        public C0355a(C0118e<T> c0118e) {
            this.f697a = c0118e;
        }

        public T createFromParcel(Parcel parcel) {
            return this.f697a.m243b(parcel, null);
        }

        public T[] newArray(int i) {
            return this.f697a.m244b(i);
        }
    }

    public static <T> Creator<T> m1329a(C0118e<T> c0118e) {
        return VERSION.SDK_INT >= 13 ? C0358g.m1330a(c0118e) : new C0355a(c0118e);
    }
}
