package android.support.design.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.design.widget.t */
class C0211t {
    private static final C0208a f460a;

    /* renamed from: android.support.design.widget.t.a */
    private interface C0208a {
        void m776a(ViewGroup viewGroup, View view, Rect rect);
    }

    /* renamed from: android.support.design.widget.t.b */
    private static class C0209b implements C0208a {
        private C0209b() {
        }

        public void m777a(ViewGroup viewGroup, View view, Rect rect) {
            viewGroup.offsetDescendantRectToMyCoords(view, rect);
            rect.offset(view.getScrollX(), view.getScrollY());
        }
    }

    /* renamed from: android.support.design.widget.t.c */
    private static class C0210c implements C0208a {
        private C0210c() {
        }

        public void m778a(ViewGroup viewGroup, View view, Rect rect) {
            C0212u.m781a(viewGroup, view, rect);
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f460a = new C0210c();
        } else {
            f460a = new C0209b();
        }
    }

    static void m779a(ViewGroup viewGroup, View view, Rect rect) {
        f460a.m776a(viewGroup, view, rect);
    }

    static void m780b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        C0211t.m779a(viewGroup, view, rect);
    }
}
