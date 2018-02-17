package p000a.p001a;

import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.a.h */
class C0006h {
    public static final <T> ArrayList<T> m9a(T... tArr) {
        C0036f.m62b(tArr, "elements");
        return tArr.length == 0 ? new ArrayList() : new ArrayList(new C0000a(tArr, true));
    }

    public static final <T> List<T> m10a() {
        return C0014o.f3a;
    }

    public static final <T> List<T> m11a(T t) {
        Object singletonList = Collections.singletonList(t);
        C0036f.m59a(singletonList, "Collections.singletonList(element)");
        return singletonList;
    }

    public static final <T> List<T> m12a(List<? extends T> list) {
        C0036f.m62b(list, "$receiver");
        switch (list.size()) {
            case C1373c.View_android_theme /*0*/:
                return C0006h.m10a();
            case C1373c.View_android_focusable /*1*/:
                return C0006h.m11a(list.get(0));
            default:
                return list;
        }
    }

    private static final <T> Object[] m14b(T[] tArr, boolean z) {
        if (!z || !C0036f.m61a(tArr.getClass(), (Object) Object[].class)) {
            Object copyOf = Arrays.copyOf(tArr, tArr.length, Object[].class);
            C0036f.m59a(copyOf, "Arrays.copyOf(this, this\u2026 Array<Any?>::class.java)");
            return copyOf;
        } else if (tArr != null) {
            return (Object[]) tArr;
        } else {
            throw new C0027d("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
    }
}
