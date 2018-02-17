package p000a.p008f;

import p000a.p001a.C0015p;

/* renamed from: a.f.b */
public final class C0049b extends C0015p {
    private int f21a;
    private final int f22b;
    private boolean f23c;
    private final int f24d;

    public C0049b(int i, int i2, int i3) {
        boolean z = true;
        this.f24d = i3;
        this.f21a = i;
        this.f22b = i2;
        if (this.f24d > 0) {
            if (i > i2) {
                z = false;
            }
        } else if (i < i2) {
            z = false;
        }
        this.f23c = z;
    }

    public int m73b() {
        int i = this.f21a;
        if (i == this.f22b) {
            this.f23c = false;
        } else {
            this.f21a += this.f24d;
        }
        return i;
    }

    public boolean hasNext() {
        return this.f23c;
    }

    public void remove() {
        throw new UnsupportedOperationException("Mutating immutable collection");
    }
}
