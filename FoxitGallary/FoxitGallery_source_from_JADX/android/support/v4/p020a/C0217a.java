package android.support.v4.p020a;

import android.os.Build.VERSION;
import android.view.View;

/* renamed from: android.support.v4.a.a */
public final class C0217a {
    private static final C0218b f471a;

    static {
        if (VERSION.SDK_INT >= 12) {
            f471a = new C0220d();
        } else {
            f471a = new C0219c();
        }
    }

    public static void m791a(View view) {
        f471a.m792a(view);
    }
}
