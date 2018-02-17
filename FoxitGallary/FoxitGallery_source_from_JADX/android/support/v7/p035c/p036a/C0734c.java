package android.support.v7.p035c.p036a;

import java.lang.reflect.Array;

/* renamed from: android.support.v7.c.a.c */
final class C0734c {
    static final /* synthetic */ boolean f1362a;

    static {
        f1362a = !C0734c.class.desiredAssertionStatus();
    }

    private C0734c() {
    }

    public static int m3208a(int i) {
        return i <= 4 ? 8 : i * 2;
    }

    public static int[] m3209a(int[] iArr, int i, int i2) {
        if (f1362a || i <= iArr.length) {
            if (i + 1 > iArr.length) {
                Object obj = new int[C0734c.m3208a(i)];
                System.arraycopy(iArr, 0, obj, 0, i);
                iArr = obj;
            }
            iArr[i] = i2;
            return iArr;
        }
        throw new AssertionError();
    }

    public static <T> T[] m3210a(T[] tArr, int i, T t) {
        if (f1362a || i <= tArr.length) {
            T[] tArr2;
            if (i + 1 > tArr.length) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), C0734c.m3208a(i));
                System.arraycopy(tArr, 0, tArr2, 0, i);
            } else {
                tArr2 = tArr;
            }
            tArr2[i] = t;
            return tArr2;
        }
        throw new AssertionError();
    }
}
