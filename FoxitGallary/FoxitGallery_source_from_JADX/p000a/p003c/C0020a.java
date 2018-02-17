package p000a.p003c;

/* renamed from: a.c.a */
public final class C0020a {
    private static final int m47a(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }

    public static final int m48a(int i, int i2, int i3) {
        if (i3 > 0) {
            return i2 - C0020a.m49b(i2, i, i3);
        }
        if (i3 < 0) {
            return C0020a.m49b(i, i2, -i3) + i2;
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int m49b(int i, int i2, int i3) {
        return C0020a.m47a(C0020a.m47a(i, i3) - C0020a.m47a(i2, i3), i3);
    }
}
