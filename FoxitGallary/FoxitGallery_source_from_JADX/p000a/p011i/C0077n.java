package p000a.p011i;

import p000a.C0027d;
import p000a.p005e.p007b.C0036f;

/* renamed from: a.i.n */
class C0077n extends C0076m {
    public static final String m98a(String str, String str2, String str3, boolean z) {
        C0036f.m62b(str, "$receiver");
        C0036f.m62b(str2, "oldValue");
        C0036f.m62b(str3, "newValue");
        int a = C0078o.m110a((CharSequence) str, str2, 0, z, 2, null);
        if (a < 0) {
            return str;
        }
        int length = str2.length() + a;
        if (str != null) {
            return C0078o.m117a((CharSequence) str, a, length, (CharSequence) str3).toString();
        }
        throw new C0027d("null cannot be cast to non-null type kotlin.CharSequence");
    }

    public static /* synthetic */ String m99a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: replaceFirst");
        }
        if ((i & 4) != 0) {
            z = false;
        }
        return C0077n.m98a(str, str2, str3, z);
    }

    public static final boolean m100a(String str, int i, String str2, int i2, int i3, boolean z) {
        C0036f.m62b(str, "$receiver");
        C0036f.m62b(str2, "other");
        if (z) {
            if (str != null) {
                return str.regionMatches(z, i, str2, i2, i3);
            }
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        } else if (str != null) {
            return str.regionMatches(i, str2, i2, i3);
        } else {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static final boolean m101a(String str, String str2, boolean z) {
        C0036f.m62b(str, "$receiver");
        C0036f.m62b(str2, "prefix");
        if (z) {
            return C0077n.m100a(str, 0, str2, 0, str2.length(), z);
        } else if (str != null) {
            return str.startsWith(str2);
        } else {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static /* synthetic */ boolean m102a(String str, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startsWith");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return C0077n.m101a(str, str2, z);
    }

    public static final boolean m103b(String str, String str2, boolean z) {
        C0036f.m62b(str, "$receiver");
        C0036f.m62b(str2, "suffix");
        if (z) {
            return C0077n.m100a(str, str.length() - str2.length(), str2, 0, str2.length(), true);
        } else if (str != null) {
            return str.endsWith(str2);
        } else {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
    }

    public static /* synthetic */ boolean m104b(String str, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: endsWith");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return C0077n.m103b(str, str2, z);
    }
}
