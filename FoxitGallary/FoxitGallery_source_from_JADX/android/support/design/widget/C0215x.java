package android.support.design.widget;

import android.os.Build.VERSION;
import android.support.design.widget.C0202q.C0199b;

/* renamed from: android.support.design.widget.x */
class C0215x {
    static final C0199b f469a;

    /* renamed from: android.support.design.widget.x.1 */
    static class C02141 implements C0199b {
        C02141() {
        }

        public C0202q m788a() {
            return new C0202q(VERSION.SDK_INT >= 12 ? new C0206s() : new C0204r());
        }
    }

    static {
        f469a = new C02141();
    }

    static C0202q m789a() {
        return f469a.m729a();
    }
}
