package p000a.p005e.p007b;

import java.util.Arrays;
import java.util.List;
import p000a.C0016a;
import p000a.C0046e;

/* renamed from: a.e.b.f */
public class C0036f {
    private C0036f() {
    }

    private static <T extends Throwable> T m56a(T t) {
        return C0036f.m57a((Throwable) t, C0036f.class.getName());
    }

    static <T extends Throwable> T m57a(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        List subList = Arrays.asList(stackTrace).subList(i + 1, length);
        t.setStackTrace((StackTraceElement[]) subList.toArray(new StackTraceElement[subList.size()]));
        return t;
    }

    public static void m58a() {
        throw ((C0016a) C0036f.m56a(new C0016a()));
    }

    public static void m59a(Object obj, String str) {
        if (obj == null) {
            throw ((IllegalStateException) C0036f.m56a(new IllegalStateException(str + " must not be null")));
        }
    }

    public static void m60a(String str) {
        throw ((C0046e) C0036f.m56a(new C0046e(str)));
    }

    public static boolean m61a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void m62b(Object obj, String str) {
        if (obj == null) {
            C0036f.m64c(str);
        }
    }

    public static void m63b(String str) {
        C0036f.m60a("lateinit property " + str + " has not been initialized");
    }

    private static void m64c(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        String className = stackTraceElement.getClassName();
        throw ((IllegalArgumentException) C0036f.m56a(new IllegalArgumentException("Parameter specified as non-null is null: method " + className + "." + stackTraceElement.getMethodName() + ", parameter " + str)));
    }
}
