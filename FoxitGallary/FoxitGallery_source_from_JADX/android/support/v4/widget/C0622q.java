package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.p016k.C0522f;
import android.support.v4.p016k.ah;
import android.view.View;
import android.widget.PopupWindow;

/* renamed from: android.support.v4.widget.q */
public final class C0622q {
    static final C0616f f1061a;

    /* renamed from: android.support.v4.widget.q.f */
    interface C0616f {
        void m2712a(PopupWindow popupWindow, int i);

        void m2713a(PopupWindow popupWindow, View view, int i, int i2, int i3);

        void m2714a(PopupWindow popupWindow, boolean z);
    }

    /* renamed from: android.support.v4.widget.q.c */
    static class C0617c implements C0616f {
        C0617c() {
        }

        public void m2715a(PopupWindow popupWindow, int i) {
        }

        public void m2716a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            if ((C0522f.m2290a(i3, ah.m1941h(view)) & 7) == 5) {
                i -= popupWindow.getWidth() - view.getWidth();
            }
            popupWindow.showAsDropDown(view, i, i2);
        }

        public void m2717a(PopupWindow popupWindow, boolean z) {
        }
    }

    /* renamed from: android.support.v4.widget.q.d */
    static class C0618d extends C0617c {
        C0618d() {
        }

        public void m2718a(PopupWindow popupWindow, int i) {
            C0625t.m2729a(popupWindow, i);
        }
    }

    /* renamed from: android.support.v4.widget.q.e */
    static class C0619e extends C0618d {
        C0619e() {
        }

        public void m2719a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            C0626u.m2730a(popupWindow, view, i, i2, i3);
        }
    }

    /* renamed from: android.support.v4.widget.q.a */
    static class C0620a extends C0619e {
        C0620a() {
        }

        public void m2720a(PopupWindow popupWindow, boolean z) {
            C0623r.m2726a(popupWindow, z);
        }
    }

    /* renamed from: android.support.v4.widget.q.b */
    static class C0621b extends C0620a {
        C0621b() {
        }

        public void m2721a(PopupWindow popupWindow, int i) {
            C0624s.m2727a(popupWindow, i);
        }

        public void m2722a(PopupWindow popupWindow, boolean z) {
            C0624s.m2728a(popupWindow, z);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1061a = new C0621b();
        } else if (i >= 21) {
            f1061a = new C0620a();
        } else if (i >= 19) {
            f1061a = new C0619e();
        } else if (i >= 9) {
            f1061a = new C0618d();
        } else {
            f1061a = new C0617c();
        }
    }

    public static void m2723a(PopupWindow popupWindow, int i) {
        f1061a.m2712a(popupWindow, i);
    }

    public static void m2724a(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        f1061a.m2713a(popupWindow, view, i, i2, i3);
    }

    public static void m2725a(PopupWindow popupWindow, boolean z) {
        f1061a.m2714a(popupWindow, z);
    }
}
