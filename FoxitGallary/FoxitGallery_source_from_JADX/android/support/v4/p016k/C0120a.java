package android.support.v4.p016k;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p017g.C0118e;
import android.support.v4.p017g.C0356d;

/* renamed from: android.support.v4.k.a */
public abstract class C0120a implements Parcelable {
    public static final Creator<C0120a> CREATOR;
    public static final C0120a f174d;
    private final Parcelable f175a;

    /* renamed from: android.support.v4.k.a.1 */
    static class C03961 extends C0120a {
        C03961() {
            super();
        }
    }

    /* renamed from: android.support.v4.k.a.2 */
    static class C03972 implements C0118e<C0120a> {
        C03972() {
        }

        public C0120a m1472a(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return C0120a.f174d;
            }
            throw new IllegalStateException("superState must be null");
        }

        public C0120a[] m1473a(int i) {
            return new C0120a[i];
        }

        public /* synthetic */ Object m1474b(Parcel parcel, ClassLoader classLoader) {
            return m1472a(parcel, classLoader);
        }

        public /* synthetic */ Object[] m1475b(int i) {
            return m1473a(i);
        }
    }

    static {
        f174d = new C03961();
        CREATOR = C0356d.m1329a(new C03972());
    }

    private C0120a() {
        this.f175a = null;
    }

    protected C0120a(Parcel parcel, ClassLoader classLoader) {
        Parcelable readParcelable = parcel.readParcelable(classLoader);
        if (readParcelable == null) {
            readParcelable = f174d;
        }
        this.f175a = readParcelable;
    }

    protected C0120a(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == f174d) {
            parcelable = null;
        }
        this.f175a = parcelable;
    }

    public final Parcelable m249a() {
        return this.f175a;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f175a, i);
    }
}
