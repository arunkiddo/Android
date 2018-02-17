package android.support.v7.p033a;

import android.app.UiModeManager;
import android.content.Context;
import android.support.v7.p033a.C0679k.C0673a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

/* renamed from: android.support.v7.a.l */
class C0680l extends C0679k {
    private final UiModeManager f1233r;

    /* renamed from: android.support.v7.a.l.a */
    class C0674a extends C0673a {
        final /* synthetic */ C0680l f1202d;

        C0674a(C0680l c0680l, Callback callback) {
            this.f1202d = c0680l;
            super(c0680l, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            if (this.f1202d.m3025o()) {
                switch (i) {
                    case C1373c.View_android_theme /*0*/:
                        return m2943a(callback);
                }
            }
            return super.onWindowStartingActionMode(callback, i);
        }
    }

    C0680l(Context context, Window window, C0663f c0663f) {
        super(context, window, c0663f);
        this.f1233r = (UiModeManager) context.getSystemService("uimode");
    }

    Callback m3026a(Callback callback) {
        return new C0674a(this, callback);
    }

    int m3027d(int i) {
        return (i == 0 && this.f1233r.getNightMode() == 0) ? -1 : super.m3023d(i);
    }
}
