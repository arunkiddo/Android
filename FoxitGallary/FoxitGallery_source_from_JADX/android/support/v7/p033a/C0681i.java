package android.support.v7.p033a;

import android.content.Context;
import android.support.v7.p033a.C0677m.C0697d;
import android.support.v7.p033a.C0680l.C0674a;
import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import android.view.Window.Callback;
import java.util.List;

/* renamed from: android.support.v7.a.i */
class C0681i extends C0680l {

    /* renamed from: android.support.v7.a.i.a */
    class C0675a extends C0674a {
        final /* synthetic */ C0681i f1203b;

        C0675a(C0681i c0681i, Callback callback) {
            this.f1203b = c0681i;
            super(c0681i, callback);
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i) {
            C0697d a = this.f1203b.m2983a(0, true);
            if (a == null || a.f1263j == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, a.f1263j, i);
            }
        }
    }

    C0681i(Context context, Window window, C0663f c0663f) {
        super(context, window, c0663f);
    }

    Callback m3028a(Callback callback) {
        return new C0675a(this, callback);
    }
}
