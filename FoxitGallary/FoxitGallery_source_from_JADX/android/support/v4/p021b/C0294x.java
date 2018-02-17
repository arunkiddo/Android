package android.support.v4.p021b;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.Log;

/* renamed from: android.support.v4.b.x */
final class C0294x implements Parcelable {
    public static final Creator<C0294x> CREATOR;
    final String f657a;
    final int f658b;
    final boolean f659c;
    final int f660d;
    final int f661e;
    final String f662f;
    final boolean f663g;
    final boolean f664h;
    final Bundle f665i;
    final boolean f666j;
    Bundle f667k;
    C0274o f668l;

    /* renamed from: android.support.v4.b.x.1 */
    static class C02931 implements Creator<C0294x> {
        C02931() {
        }

        public C0294x m1158a(Parcel parcel) {
            return new C0294x(parcel);
        }

        public C0294x[] m1159a(int i) {
            return new C0294x[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1158a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1159a(i);
        }
    }

    static {
        CREATOR = new C02931();
    }

    public C0294x(Parcel parcel) {
        boolean z = true;
        this.f657a = parcel.readString();
        this.f658b = parcel.readInt();
        this.f659c = parcel.readInt() != 0;
        this.f660d = parcel.readInt();
        this.f661e = parcel.readInt();
        this.f662f = parcel.readString();
        this.f663g = parcel.readInt() != 0;
        this.f664h = parcel.readInt() != 0;
        this.f665i = parcel.readBundle();
        if (parcel.readInt() == 0) {
            z = false;
        }
        this.f666j = z;
        this.f667k = parcel.readBundle();
    }

    public C0294x(C0274o c0274o) {
        this.f657a = c0274o.getClass().getName();
        this.f658b = c0274o.mIndex;
        this.f659c = c0274o.mFromLayout;
        this.f660d = c0274o.mFragmentId;
        this.f661e = c0274o.mContainerId;
        this.f662f = c0274o.mTag;
        this.f663g = c0274o.mRetainInstance;
        this.f664h = c0274o.mDetached;
        this.f665i = c0274o.mArguments;
        this.f666j = c0274o.mHidden;
    }

    public C0274o m1160a(C0276s c0276s, C0274o c0274o, C0290v c0290v) {
        if (this.f668l == null) {
            Context i = c0276s.m1013i();
            if (this.f665i != null) {
                this.f665i.setClassLoader(i.getClassLoader());
            }
            this.f668l = C0274o.instantiate(i, this.f657a, this.f665i);
            if (this.f667k != null) {
                this.f667k.setClassLoader(i.getClassLoader());
                this.f668l.mSavedFragmentState = this.f667k;
            }
            this.f668l.setIndex(this.f658b, c0274o);
            this.f668l.mFromLayout = this.f659c;
            this.f668l.mRestored = true;
            this.f668l.mFragmentId = this.f660d;
            this.f668l.mContainerId = this.f661e;
            this.f668l.mTag = this.f662f;
            this.f668l.mRetainInstance = this.f663g;
            this.f668l.mDetached = this.f664h;
            this.f668l.mHidden = this.f666j;
            this.f668l.mFragmentManager = c0276s.f602d;
            if (C0289u.f626a) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f668l);
            }
        }
        this.f668l.mChildNonConfig = c0290v;
        return this.f668l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.f657a);
        parcel.writeInt(this.f658b);
        parcel.writeInt(this.f659c ? 1 : 0);
        parcel.writeInt(this.f660d);
        parcel.writeInt(this.f661e);
        parcel.writeString(this.f662f);
        parcel.writeInt(this.f663g ? 1 : 0);
        parcel.writeInt(this.f664h ? 1 : 0);
        parcel.writeBundle(this.f665i);
        if (!this.f666j) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.f667k);
    }
}
