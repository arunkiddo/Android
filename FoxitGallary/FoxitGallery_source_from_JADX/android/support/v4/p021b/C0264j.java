package android.support.v4.p021b;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p021b.C0262i.C0259a;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.b.j */
final class C0264j implements Parcelable {
    public static final Creator<C0264j> CREATOR;
    final int[] f585a;
    final int f586b;
    final int f587c;
    final String f588d;
    final int f589e;
    final int f590f;
    final CharSequence f591g;
    final int f592h;
    final CharSequence f593i;
    final ArrayList<String> f594j;
    final ArrayList<String> f595k;

    /* renamed from: android.support.v4.b.j.1 */
    static class C02631 implements Creator<C0264j> {
        C02631() {
        }

        public C0264j m984a(Parcel parcel) {
            return new C0264j(parcel);
        }

        public C0264j[] m985a(int i) {
            return new C0264j[i];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m984a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m985a(i);
        }
    }

    static {
        CREATOR = new C02631();
    }

    public C0264j(Parcel parcel) {
        this.f585a = parcel.createIntArray();
        this.f586b = parcel.readInt();
        this.f587c = parcel.readInt();
        this.f588d = parcel.readString();
        this.f589e = parcel.readInt();
        this.f590f = parcel.readInt();
        this.f591g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f592h = parcel.readInt();
        this.f593i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f594j = parcel.createStringArrayList();
        this.f595k = parcel.createStringArrayList();
    }

    public C0264j(C0262i c0262i) {
        int i = 0;
        for (C0259a c0259a = c0262i.f565c; c0259a != null; c0259a = c0259a.f549a) {
            if (c0259a.f557i != null) {
                i += c0259a.f557i.size();
            }
        }
        this.f585a = new int[(i + (c0262i.f567e * 7))];
        if (c0262i.f574l) {
            i = 0;
            for (C0259a c0259a2 = c0262i.f565c; c0259a2 != null; c0259a2 = c0259a2.f549a) {
                int i2 = i + 1;
                this.f585a[i] = c0259a2.f551c;
                int i3 = i2 + 1;
                this.f585a[i2] = c0259a2.f552d != null ? c0259a2.f552d.mIndex : -1;
                int i4 = i3 + 1;
                this.f585a[i3] = c0259a2.f553e;
                i2 = i4 + 1;
                this.f585a[i4] = c0259a2.f554f;
                i4 = i2 + 1;
                this.f585a[i2] = c0259a2.f555g;
                i2 = i4 + 1;
                this.f585a[i4] = c0259a2.f556h;
                if (c0259a2.f557i != null) {
                    int size = c0259a2.f557i.size();
                    i4 = i2 + 1;
                    this.f585a[i2] = size;
                    i2 = 0;
                    while (i2 < size) {
                        i3 = i4 + 1;
                        this.f585a[i4] = ((C0274o) c0259a2.f557i.get(i2)).mIndex;
                        i2++;
                        i4 = i3;
                    }
                    i = i4;
                } else {
                    i = i2 + 1;
                    this.f585a[i2] = 0;
                }
            }
            this.f586b = c0262i.f572j;
            this.f587c = c0262i.f573k;
            this.f588d = c0262i.f576n;
            this.f589e = c0262i.f578p;
            this.f590f = c0262i.f579q;
            this.f591g = c0262i.f580r;
            this.f592h = c0262i.f581s;
            this.f593i = c0262i.f582t;
            this.f594j = c0262i.f583u;
            this.f595k = c0262i.f584v;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public C0262i m986a(C0289u c0289u) {
        C0262i c0262i = new C0262i(c0289u);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f585a.length) {
            C0259a c0259a = new C0259a();
            int i3 = i2 + 1;
            c0259a.f551c = this.f585a[i2];
            if (C0289u.f626a) {
                Log.v("FragmentManager", "Instantiate " + c0262i + " op #" + i + " base fragment #" + this.f585a[i3]);
            }
            int i4 = i3 + 1;
            i2 = this.f585a[i3];
            if (i2 >= 0) {
                c0259a.f552d = (C0274o) c0289u.f632f.get(i2);
            } else {
                c0259a.f552d = null;
            }
            i3 = i4 + 1;
            c0259a.f553e = this.f585a[i4];
            i4 = i3 + 1;
            c0259a.f554f = this.f585a[i3];
            i3 = i4 + 1;
            c0259a.f555g = this.f585a[i4];
            int i5 = i3 + 1;
            c0259a.f556h = this.f585a[i3];
            i4 = i5 + 1;
            int i6 = this.f585a[i5];
            if (i6 > 0) {
                c0259a.f557i = new ArrayList(i6);
                i3 = 0;
                while (i3 < i6) {
                    if (C0289u.f626a) {
                        Log.v("FragmentManager", "Instantiate " + c0262i + " set remove fragment #" + this.f585a[i4]);
                    }
                    i5 = i4 + 1;
                    c0259a.f557i.add((C0274o) c0289u.f632f.get(this.f585a[i4]));
                    i3++;
                    i4 = i5;
                }
            }
            c0262i.f568f = c0259a.f553e;
            c0262i.f569g = c0259a.f554f;
            c0262i.f570h = c0259a.f555g;
            c0262i.f571i = c0259a.f556h;
            c0262i.m975a(c0259a);
            i++;
            i2 = i4;
        }
        c0262i.f572j = this.f586b;
        c0262i.f573k = this.f587c;
        c0262i.f576n = this.f588d;
        c0262i.f578p = this.f589e;
        c0262i.f574l = true;
        c0262i.f579q = this.f590f;
        c0262i.f580r = this.f591g;
        c0262i.f581s = this.f592h;
        c0262i.f582t = this.f593i;
        c0262i.f583u = this.f594j;
        c0262i.f584v = this.f595k;
        c0262i.m974a(1);
        return c0262i;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f585a);
        parcel.writeInt(this.f586b);
        parcel.writeInt(this.f587c);
        parcel.writeString(this.f588d);
        parcel.writeInt(this.f589e);
        parcel.writeInt(this.f590f);
        TextUtils.writeToParcel(this.f591g, parcel, 0);
        parcel.writeInt(this.f592h);
        TextUtils.writeToParcel(this.f593i, parcel, 0);
        parcel.writeStringList(this.f594j);
        parcel.writeStringList(this.f595k);
    }
}
