package android.support.v4.p030j;

/* renamed from: android.support.v4.j.h */
public class C0391h<F, S> {
    public final F f752a;
    public final S f753b;

    public C0391h(F f, S s) {
        this.f752a = f;
        this.f753b = s;
    }

    private static boolean m1454a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0391h)) {
            return false;
        }
        C0391h c0391h = (C0391h) obj;
        return C0391h.m1454a(c0391h.f752a, this.f752a) && C0391h.m1454a(c0391h.f753b, this.f753b);
    }

    public int hashCode() {
        int i = 0;
        int hashCode = this.f752a == null ? 0 : this.f752a.hashCode();
        if (this.f753b != null) {
            i = this.f753b.hashCode();
        }
        return hashCode ^ i;
    }
}
