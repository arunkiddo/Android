package p000a.p008f;

import java.util.Iterator;
import p000a.p001a.C0015p;
import p000a.p003c.C0020a;

/* renamed from: a.f.a */
public class C0048a implements Iterable<Integer> {
    public static final C0047a f17a;
    private final int f18b;
    private final int f19c;
    private final int f20d;

    /* renamed from: a.f.a.a */
    public static final class C0047a {
        private C0047a() {
        }

        public final C0048a m67a(int i, int i2, int i3) {
            return new C0048a(i, i2, i3);
        }
    }

    static {
        f17a = new C0047a();
    }

    public C0048a(int i, int i2, int i3) {
        if (i3 == 0) {
            throw new IllegalArgumentException("Step must be non-zero");
        }
        this.f18b = i;
        this.f19c = C0020a.m48a(i, i2, i3);
        this.f20d = i3;
    }

    public final int m68a() {
        return this.f18b;
    }

    public final int m69b() {
        return this.f19c;
    }

    public final int m70c() {
        return this.f20d;
    }

    public C0015p m71d() {
        return new C0049b(this.f18b, this.f19c, this.f20d);
    }

    public boolean m72e() {
        return this.f20d > 0 ? this.f18b > this.f19c : this.f18b < this.f19c;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0048a) && ((m72e() && ((C0048a) obj).m72e()) || (this.f18b == ((C0048a) obj).f18b && this.f19c == ((C0048a) obj).f19c && this.f20d == ((C0048a) obj).f20d));
    }

    public int hashCode() {
        return m72e() ? -1 : (((this.f18b * 31) + this.f19c) * 31) + this.f20d;
    }

    public /* synthetic */ Iterator iterator() {
        return m71d();
    }

    public String toString() {
        return this.f20d > 0 ? this.f18b + ".." + this.f19c + " step " + this.f20d : this.f18b + " downTo " + this.f19c + " step " + (-this.f20d);
    }
}
