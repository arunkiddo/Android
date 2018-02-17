package p000a.p005e.p007b;

import p000a.p009g.C0056a;

/* renamed from: a.e.b.i */
public class C0043i {
    private static final C0044j f14a;
    private static final C0056a[] f15b;

    static {
        C0044j c0044j;
        try {
            c0044j = (C0044j) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException e) {
            c0044j = null;
        } catch (ClassNotFoundException e2) {
            c0044j = null;
        } catch (InstantiationException e3) {
            c0044j = null;
        } catch (IllegalAccessException e4) {
            c0044j = null;
        }
        if (c0044j == null) {
            c0044j = new C0044j();
        }
        f14a = c0044j;
        f15b = new C0056a[0];
    }

    public static String m65a(C0037g c0037g) {
        return f14a.m66a(c0037g);
    }
}
