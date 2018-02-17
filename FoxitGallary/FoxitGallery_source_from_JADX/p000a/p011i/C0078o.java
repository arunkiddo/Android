package p000a.p011i;

import com.simplemobiletools.gallery.BuildConfig;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0019b;
import p000a.C0021c;
import p000a.C0027d;
import p000a.p001a.C0003e;
import p000a.p001a.C0007i;
import p000a.p005e.p006a.C0030c;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0037g;
import p000a.p008f.C0048a;
import p000a.p008f.C0051c;
import p000a.p008f.C0053f;
import p000a.p010h.C0057a;
import p000a.p010h.C0059d;

/* renamed from: a.i.o */
class C0078o extends C0077n {

    /* renamed from: a.i.o.a */
    static final class C0081a extends C0037g implements C0030c<CharSequence, Integer, C0019b<? extends Integer, ? extends Integer>> {
        final /* synthetic */ List f53a;
        final /* synthetic */ boolean f54b;

        C0081a(List list, boolean z) {
            this.f53a = list;
            this.f54b = z;
            super(2);
        }

        public final C0019b<Integer, Integer> m137a(CharSequence charSequence, int i) {
            C0036f.m62b(charSequence, "$receiver");
            C0019b a = C0078o.m132b(charSequence, (Collection) this.f53a, i, this.f54b, false);
            if (a == null) {
                return null;
            }
            a = a;
            return C0021c.m50a(a.m43a(), Integer.valueOf(((String) a.m44b()).length()));
        }

        public /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m137a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    public static final int m105a(CharSequence charSequence, char c, int i, boolean z) {
        C0036f.m62b(charSequence, "$receiver");
        if (z || !(charSequence instanceof String)) {
            return C0078o.m111a(charSequence, new char[]{c}, i, z);
        }
        String str = (String) charSequence;
        if (str != null) {
            return str.indexOf(c, i);
        }
        throw new C0027d("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ int m106a(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C0078o.m105a(charSequence, c, i, z);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final int m107a(java.lang.CharSequence r8, java.lang.CharSequence r9, int r10, int r11, boolean r12, boolean r13) {
        /*
        r1 = 0;
        if (r13 != 0) goto L_0x0040;
    L_0x0003:
        r2 = p000a.p008f.C0053f.m79b(r10, r1);
        r0 = new a.f.c;
        r3 = r8.length();
        r3 = p000a.p008f.C0053f.m80c(r11, r3);
        r0.<init>(r2, r3);
        r0 = (p000a.p008f.C0048a) r0;
    L_0x0016:
        r2 = r8 instanceof java.lang.String;
        if (r2 == 0) goto L_0x0059;
    L_0x001a:
        r2 = r9 instanceof java.lang.String;
        if (r2 == 0) goto L_0x0059;
    L_0x001e:
        r3 = r0.m68a();
        r6 = r0.m69b();
        r7 = r0.m70c();
        if (r7 <= 0) goto L_0x0051;
    L_0x002c:
        if (r3 > r6) goto L_0x0053;
    L_0x002e:
        r0 = r9;
        r0 = (java.lang.String) r0;
        r2 = r8;
        r2 = (java.lang.String) r2;
        r4 = r9.length();
        r5 = r12;
        r0 = p000a.p011i.C0077n.m100a(r0, r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0055;
    L_0x003f:
        return r3;
    L_0x0040:
        r0 = p000a.p011i.C0078o.m136c(r8);
        r0 = p000a.p008f.C0053f.m80c(r10, r0);
        r2 = p000a.p008f.C0053f.m79b(r11, r1);
        r0 = p000a.p008f.C0053f.m77a(r0, r2);
        goto L_0x0016;
    L_0x0051:
        if (r3 >= r6) goto L_0x002e;
    L_0x0053:
        r3 = -1;
        goto L_0x003f;
    L_0x0055:
        if (r3 == r6) goto L_0x0053;
    L_0x0057:
        r3 = r3 + r7;
        goto L_0x002e;
    L_0x0059:
        r3 = r0.m68a();
        r6 = r0.m69b();
        r7 = r0.m70c();
        if (r7 <= 0) goto L_0x007a;
    L_0x0067:
        if (r3 > r6) goto L_0x0053;
    L_0x0069:
        r4 = r9.length();
        r0 = r9;
        r2 = r8;
        r5 = r12;
        r0 = p000a.p011i.C0078o.m126a(r0, r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x003f;
    L_0x0076:
        if (r3 == r6) goto L_0x0053;
    L_0x0078:
        r3 = r3 + r7;
        goto L_0x0069;
    L_0x007a:
        if (r3 < r6) goto L_0x0053;
    L_0x007c:
        goto L_0x0069;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.o.a(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean, boolean):int");
    }

    static /* synthetic */ int m108a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf$StringsKt__StringsKt");
        }
        return C0078o.m107a(charSequence, charSequence2, i, i2, z, (i3 & 16) != 0 ? false : z2);
    }

    public static final int m109a(CharSequence charSequence, String str, int i, boolean z) {
        C0036f.m62b(charSequence, "$receiver");
        C0036f.m62b(str, "string");
        if (z || !(charSequence instanceof String)) {
            return C0078o.m108a(charSequence, str, i, charSequence.length(), z, false, 16, null);
        }
        String str2 = (String) charSequence;
        if (str2 != null) {
            return str2.indexOf(str, i);
        }
        throw new C0027d("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ int m110a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
        }
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C0078o.m109a(charSequence, str, i, z);
    }

    public static final int m111a(CharSequence charSequence, char[] cArr, int i, boolean z) {
        C0036f.m62b(charSequence, "$receiver");
        C0036f.m62b(cArr, "chars");
        C0019b a = C0078o.m113a(charSequence, cArr, i, z, false);
        if (a != null) {
            Integer num = (Integer) a.m43a();
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    private static final C0019b<Integer, Character> m113a(CharSequence charSequence, char[] cArr, int i, boolean z, boolean z2) {
        int lastIndexOf;
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            char a = C0003e.m1a(cArr);
            String str;
            if (z2) {
                str = (String) charSequence;
                if (str == null) {
                    throw new C0027d("null cannot be cast to non-null type java.lang.String");
                }
                lastIndexOf = str.lastIndexOf(a, i);
            } else {
                str = (String) charSequence;
                if (str == null) {
                    throw new C0027d("null cannot be cast to non-null type java.lang.String");
                }
                lastIndexOf = str.indexOf(a, i);
            }
            return lastIndexOf < 0 ? (C0019b) null : C0021c.m50a(Integer.valueOf(lastIndexOf), Character.valueOf(a));
        } else {
            C0048a c0051c = !z2 ? new C0051c(Math.max(i, 0), C0078o.m136c(charSequence)) : C0053f.m77a(Math.min(i, C0078o.m136c(charSequence)), 0);
            int a2 = c0051c.m68a();
            int b = c0051c.m69b();
            int c = c0051c.m70c();
            if (c > 0) {
                if (a2 <= b) {
                    lastIndexOf = a2;
                }
                return (C0019b) null;
            }
            if (a2 >= b) {
                lastIndexOf = a2;
            }
            return (C0019b) null;
            while (true) {
                char charAt = charSequence.charAt(lastIndexOf);
                int length = cArr.length - 1;
                if (0 <= length) {
                    a2 = 0;
                    while (!C0063c.m84a(cArr[a2], charAt, z)) {
                        if (a2 != length) {
                            a2++;
                        }
                    }
                    if (a2 < 0) {
                        if (lastIndexOf != b) {
                            break;
                        }
                        lastIndexOf += c;
                    } else {
                        return C0021c.m50a(Integer.valueOf(lastIndexOf), Character.valueOf(cArr[a2]));
                    }
                }
                a2 = -1;
                break;
                if (a2 < 0) {
                    return C0021c.m50a(Integer.valueOf(lastIndexOf), Character.valueOf(cArr[a2]));
                }
                if (lastIndexOf != b) {
                    break;
                }
                lastIndexOf += c;
            }
            return (C0019b) null;
        }
    }

    private static final p000a.p010h.C0057a<p000a.p008f.C0051c> m114a(java.lang.CharSequence r1, java.lang.String[] r2, int r3, boolean r4, int r5) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: a.i.o.a(java.lang.CharSequence, java.lang.String[], int, boolean, int):a.h.a<a.f.c>
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:357)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 5 more
*/
        /*
        if (r7 < 0) goto L_0x002b;
    L_0x0002:
        r0 = 1;
        if (r0 != 0) goto L_0x002d;
    L_0x0006:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = "Limit must be non-negative, but was ";
        r0 = r0.append(r1);
        r0 = r0.append(r7);
        r1 = ".";
        r0 = r0.append(r1);
        r1 = r0.toString();
        r0 = new java.lang.IllegalArgumentException;
        r1 = r1.toString();
        r0.<init>(r1);
        r0 = (java.lang.Throwable) r0;
        throw r0;
    L_0x002b:
        r0 = 0;
        goto L_0x0003;
    L_0x002d:
        r4 = (java.lang.Object[]) r4;
        r2 = p000a.p001a.C0003e.m2a(r4);
        r1 = new a.i.d;
        r0 = new a.i.o$a;
        r0.<init>(r2, r6);
        r0 = (p000a.p005e.p006a.C0030c) r0;
        r1.<init>(r3, r5, r7, r0);
        r0 = r1;
        r0 = (p000a.p010h.C0057a) r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.o.a(java.lang.CharSequence, java.lang.String[], int, boolean, int):a.h.a<a.f.c>");
    }

    static /* synthetic */ C0057a m115a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rangesDelimitedBy$StringsKt__StringsKt");
        }
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return C0078o.m114a(charSequence, strArr, i, z, i2);
    }

    public static final CharSequence m116a(CharSequence charSequence) {
        Object obj = null;
        C0036f.m62b(charSequence, "$receiver");
        int length = charSequence.length() - 1;
        int i = 0;
        while (i <= length) {
            Object obj2;
            boolean a = C0062b.m83a(charSequence.charAt(obj == null ? i : length));
            if (obj == null) {
                if (a) {
                    i++;
                    obj2 = obj;
                } else {
                    obj2 = 1;
                }
            } else if (!a) {
                break;
            } else {
                length--;
                obj2 = obj;
            }
            obj = obj2;
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final CharSequence m117a(CharSequence charSequence, int i, int i2, CharSequence charSequence2) {
        C0036f.m62b(charSequence, "$receiver");
        C0036f.m62b(charSequence2, "replacement");
        if (i2 < i) {
            throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(charSequence, 0, i);
        stringBuilder.append(charSequence2);
        stringBuilder.append(charSequence, i2, charSequence.length());
        return stringBuilder;
    }

    public static final CharSequence m118a(CharSequence charSequence, char... cArr) {
        C0036f.m62b(charSequence, "$receiver");
        C0036f.m62b(cArr, "chars");
        C0048a a = C0053f.m78a(C0078o.m133b(charSequence));
        int a2 = a.m68a();
        int b = a.m69b();
        int c = a.m70c();
        if (c <= 0 ? a2 >= b : a2 <= b) {
            while (C0003e.m4a(cArr, charSequence.charAt(a2))) {
                if (a2 != b) {
                    a2 += c;
                }
            }
            return charSequence.subSequence(0, a2 + 1).toString();
        }
        return BuildConfig.FLAVOR;
    }

    public static final String m119a(CharSequence charSequence, C0051c c0051c) {
        C0036f.m62b(charSequence, "$receiver");
        C0036f.m62b(c0051c, "range");
        return charSequence.subSequence(c0051c.m75f().intValue(), c0051c.m76g().intValue() + 1).toString();
    }

    public static final String m120a(String str, char c, String str2) {
        C0036f.m62b(str, "$receiver");
        C0036f.m62b(str2, "missingDelimiterValue");
        int b = C0078o.m128b((CharSequence) str, c, 0, false, 6, null);
        if (b == -1) {
            return str2;
        }
        b++;
        int length = str.length();
        if (str == null) {
            throw new C0027d("null cannot be cast to non-null type java.lang.String");
        }
        Object substring = str.substring(b, length);
        C0036f.m59a(substring, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return substring;
    }

    public static final String m121a(String str, char... cArr) {
        C0036f.m62b(str, "$receiver");
        C0036f.m62b(cArr, "chars");
        if (str == null) {
            throw new C0027d("null cannot be cast to non-null type kotlin.CharSequence");
        }
        Object obj;
        CharSequence charSequence = str;
        C0048a a = C0053f.m78a(C0078o.m133b(charSequence));
        int a2 = a.m68a();
        int b = a.m69b();
        int c = a.m70c();
        if (c <= 0 ? a2 >= b : a2 <= b) {
            while (C0003e.m4a(cArr, charSequence.charAt(a2))) {
                if (a2 != b) {
                    a2 += c;
                }
            }
            obj = charSequence.subSequence(0, a2 + 1).toString();
            return obj.toString();
        }
        CharSequence charSequence2 = BuildConfig.FLAVOR;
        break;
        return obj.toString();
    }

    public static final List<String> m122a(CharSequence charSequence, String[] strArr, boolean z, int i) {
        C0036f.m62b(charSequence, "$receiver");
        C0036f.m62b(strArr, "delimiters");
        Iterable<C0051c> a = C0059d.m82a(C0078o.m115a(charSequence, strArr, 0, z, i, 2, null));
        Collection arrayList = new ArrayList(C0007i.m15a(a, 10));
        for (C0051c a2 : a) {
            arrayList.add(C0078o.m119a(charSequence, a2));
        }
        return (List) arrayList;
    }

    public static /* synthetic */ List m123a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: split");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return C0078o.m122a(charSequence, strArr, z, i);
    }

    public static final boolean m124a(CharSequence charSequence, char c, boolean z) {
        C0036f.m62b(charSequence, "$receiver");
        return charSequence.length() > 0 && C0063c.m84a(charSequence.charAt(C0078o.m136c(charSequence)), c, z);
    }

    public static /* synthetic */ boolean m125a(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: endsWith");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return C0078o.m124a(charSequence, c, z);
    }

    public static final boolean m126a(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        C0036f.m62b(charSequence, "$receiver");
        C0036f.m62b(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        int i4 = i3 - 1;
        if (0 <= i4) {
            int i5 = 0;
            while (C0063c.m84a(charSequence.charAt(i + i5), charSequence2.charAt(i2 + i5), z)) {
                if (i5 != i4) {
                    i5++;
                }
            }
            return false;
        }
        return true;
    }

    public static final int m127b(CharSequence charSequence, char c, int i, boolean z) {
        C0036f.m62b(charSequence, "$receiver");
        if (z || !(charSequence instanceof String)) {
            return C0078o.m131b(charSequence, new char[]{c}, i, z);
        }
        String str = (String) charSequence;
        if (str != null) {
            return str.lastIndexOf(c, i);
        }
        throw new C0027d("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ int m128b(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = C0078o.m136c(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C0078o.m127b(charSequence, c, i, z);
    }

    public static final int m129b(CharSequence charSequence, String str, int i, boolean z) {
        C0036f.m62b(charSequence, "$receiver");
        C0036f.m62b(str, "string");
        if (z || !(charSequence instanceof String)) {
            return C0078o.m107a(charSequence, (CharSequence) str, i, 0, z, true);
        }
        String str2 = (String) charSequence;
        if (str2 != null) {
            return str2.lastIndexOf(str, i);
        }
        throw new C0027d("null cannot be cast to non-null type java.lang.String");
    }

    public static /* synthetic */ int m130b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
        }
        if ((i2 & 2) != 0) {
            i = C0078o.m136c(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return C0078o.m129b(charSequence, str, i, z);
    }

    public static final int m131b(CharSequence charSequence, char[] cArr, int i, boolean z) {
        C0036f.m62b(charSequence, "$receiver");
        C0036f.m62b(cArr, "chars");
        C0019b a = C0078o.m113a(charSequence, cArr, i, z, true);
        if (a != null) {
            Integer num = (Integer) a.m43a();
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final p000a.C0019b<java.lang.Integer, java.lang.String> m132b(java.lang.CharSequence r10, java.util.Collection<java.lang.String> r11, int r12, boolean r13, boolean r14) {
        /*
        if (r13 != 0) goto L_0x0035;
    L_0x0002:
        r0 = r11.size();
        r1 = 1;
        if (r0 != r1) goto L_0x0035;
    L_0x0009:
        r11 = (java.lang.Iterable) r11;
        r1 = p000a.p001a.C0011m.m24b(r11);
        r1 = (java.lang.String) r1;
        if (r14 != 0) goto L_0x0022;
    L_0x0013:
        r3 = 0;
        r4 = 4;
        r5 = 0;
        r0 = r10;
        r2 = r12;
        r0 = p000a.p011i.C0078o.m110a(r0, r1, r2, r3, r4, r5);
    L_0x001c:
        if (r0 >= 0) goto L_0x002c;
    L_0x001e:
        r0 = 0;
        r0 = (p000a.C0019b) r0;
    L_0x0021:
        return r0;
    L_0x0022:
        r3 = 0;
        r4 = 4;
        r5 = 0;
        r0 = r10;
        r2 = r12;
        r0 = p000a.p011i.C0078o.m130b(r0, r1, r2, r3, r4, r5);
        goto L_0x001c;
    L_0x002c:
        r0 = java.lang.Integer.valueOf(r0);
        r0 = p000a.C0021c.m50a(r0, r1);
        goto L_0x0021;
    L_0x0035:
        if (r14 != 0) goto L_0x008d;
    L_0x0037:
        r0 = 0;
        r1 = p000a.p008f.C0053f.m79b(r12, r0);
        r0 = new a.f.c;
        r2 = r10.length();
        r0.<init>(r1, r2);
        r0 = (p000a.p008f.C0048a) r0;
    L_0x0047:
        r1 = r10 instanceof java.lang.String;
        if (r1 == 0) goto L_0x00a7;
    L_0x004b:
        r3 = r0.m68a();
        r7 = r0.m69b();
        r8 = r0.m70c();
        if (r8 <= 0) goto L_0x009b;
    L_0x0059:
        if (r3 > r7) goto L_0x009d;
    L_0x005b:
        r0 = r11;
        r0 = (java.lang.Iterable) r0;
        r9 = r0.iterator();
    L_0x0063:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x00a1;
    L_0x0069:
        r6 = r9.next();
        r0 = r6;
        r0 = (java.lang.String) r0;
        r1 = 0;
        r2 = r10;
        r2 = (java.lang.String) r2;
        r4 = r0.length();
        r5 = r13;
        r0 = p000a.p011i.C0077n.m100a(r0, r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x0063;
    L_0x007f:
        r0 = r6;
    L_0x0080:
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x00a3;
    L_0x0084:
        r1 = java.lang.Integer.valueOf(r3);
        r0 = p000a.C0021c.m50a(r1, r0);
        goto L_0x0021;
    L_0x008d:
        r0 = p000a.p011i.C0078o.m136c(r10);
        r0 = p000a.p008f.C0053f.m80c(r12, r0);
        r1 = 0;
        r0 = p000a.p008f.C0053f.m77a(r0, r1);
        goto L_0x0047;
    L_0x009b:
        if (r3 >= r7) goto L_0x005b;
    L_0x009d:
        r0 = 0;
        r0 = (p000a.C0019b) r0;
        goto L_0x0021;
    L_0x00a1:
        r0 = 0;
        goto L_0x0080;
    L_0x00a3:
        if (r3 == r7) goto L_0x009d;
    L_0x00a5:
        r3 = r3 + r8;
        goto L_0x005b;
    L_0x00a7:
        r3 = r0.m68a();
        r7 = r0.m69b();
        r8 = r0.m70c();
        if (r8 <= 0) goto L_0x00eb;
    L_0x00b5:
        if (r3 > r7) goto L_0x009d;
    L_0x00b7:
        r0 = r11;
        r0 = (java.lang.Iterable) r0;
        r9 = r0.iterator();
    L_0x00bf:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x00ee;
    L_0x00c5:
        r6 = r9.next();
        r2 = r6;
        r2 = (java.lang.String) r2;
        r0 = r2;
        r0 = (java.lang.CharSequence) r0;
        r1 = 0;
        r4 = r2.length();
        r2 = r10;
        r5 = r13;
        r0 = p000a.p011i.C0078o.m126a(r0, r1, r2, r3, r4, r5);
        if (r0 == 0) goto L_0x00bf;
    L_0x00dc:
        r0 = r6;
    L_0x00dd:
        r0 = (java.lang.String) r0;
        if (r0 == 0) goto L_0x00f0;
    L_0x00e1:
        r1 = java.lang.Integer.valueOf(r3);
        r0 = p000a.C0021c.m50a(r1, r0);
        goto L_0x0021;
    L_0x00eb:
        if (r3 < r7) goto L_0x009d;
    L_0x00ed:
        goto L_0x00b7;
    L_0x00ee:
        r0 = 0;
        goto L_0x00dd;
    L_0x00f0:
        if (r3 == r7) goto L_0x009d;
    L_0x00f2:
        r3 = r3 + r8;
        goto L_0x00b7;
        */
        throw new UnsupportedOperationException("Method not decompiled: a.i.o.b(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):a.b<java.lang.Integer, java.lang.String>");
    }

    public static final C0051c m133b(CharSequence charSequence) {
        C0036f.m62b(charSequence, "$receiver");
        return new C0051c(0, charSequence.length() - 1);
    }

    public static final boolean m134b(CharSequence charSequence, char c, boolean z) {
        C0036f.m62b(charSequence, "$receiver");
        return C0078o.m106a(charSequence, c, 0, z, 2, null) >= 0;
    }

    public static /* synthetic */ boolean m135b(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: contains");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return C0078o.m134b(charSequence, c, z);
    }

    public static final int m136c(CharSequence charSequence) {
        C0036f.m62b(charSequence, "$receiver");
        return charSequence.length() - 1;
    }
}
