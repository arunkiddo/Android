package android.support.v4.p022c;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.c.f */
public final class C0314f {
    private static final C0310a f670a;

    /* renamed from: android.support.v4.c.f.a */
    interface C0310a {
        Intent m1185a(ComponentName componentName);
    }

    /* renamed from: android.support.v4.c.f.b */
    static class C0311b implements C0310a {
        C0311b() {
        }

        public Intent m1186a(ComponentName componentName) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.setComponent(componentName);
            intent.addCategory("android.intent.category.LAUNCHER");
            return intent;
        }
    }

    /* renamed from: android.support.v4.c.f.c */
    static class C0312c extends C0311b {
        C0312c() {
        }

        public Intent m1187a(ComponentName componentName) {
            return C0315g.m1189a(componentName);
        }
    }

    /* renamed from: android.support.v4.c.f.d */
    static class C0313d extends C0312c {
        C0313d() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 15) {
            f670a = new C0313d();
        } else if (i >= 11) {
            f670a = new C0312c();
        } else {
            f670a = new C0311b();
        }
    }

    public static Intent m1188a(ComponentName componentName) {
        return f670a.m1185a(componentName);
    }
}
