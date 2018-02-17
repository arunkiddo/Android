package android.support.v4.p021b;

import android.content.Context;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.b.g */
public final class C0254g {
    private static final C0252b f531a;

    /* renamed from: android.support.v4.b.g.b */
    private static class C0252b {
        private C0252b() {
        }

        public int m924a(Context context, String str, String str2) {
            return 1;
        }

        public String m925a(String str) {
            return null;
        }
    }

    /* renamed from: android.support.v4.b.g.a */
    private static class C0253a extends C0252b {
        private C0253a() {
            super();
        }

        public int m926a(Context context, String str, String str2) {
            return C0255h.m930a(context, str, str2);
        }

        public String m927a(String str) {
            return C0255h.m931a(str);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f531a = new C0253a();
        } else {
            f531a = new C0252b();
        }
    }

    public static int m928a(Context context, String str, String str2) {
        return f531a.m924a(context, str, str2);
    }

    public static String m929a(String str) {
        return f531a.m925a(str);
    }
}
