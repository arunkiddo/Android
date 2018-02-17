package android.support.v4.p021b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

/* renamed from: android.support.v4.b.w */
final class C0292w implements Parcelable {
    public static final Creator<C0292w> CREATOR;
    C0294x[] f654a;
    int[] f655b;
    C0264j[] f656c;

    /* renamed from: android.support.v4.b.w.1 */
    static class C02911 implements Creator<C0292w> {
        C02911() {
        }

        public C0292w m1156a(Parcel parcel) {
            return new C0292w(parcel);
        }

        public C0292w[] m1157a(int i) {
            return new C0292w[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1156a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1157a(i);
        }
    }

    static {
        CREATOR = new C02911();
    }

    public C0292w(Parcel parcel) {
        this.f654a = (C0294x[]) parcel.createTypedArray(C0294x.CREATOR);
        this.f655b = parcel.createIntArray();
        this.f656c = (C0264j[]) parcel.createTypedArray(C0264j.CREATOR);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedArray(this.f654a, i);
        parcel.writeIntArray(this.f655b);
        parcel.writeTypedArray(this.f656c, i);
    }
}
