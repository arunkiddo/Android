package android.support.v7.p033a;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.p033a.C0647b.C0646a;
import android.support.v7.view.C0670i;
import android.support.v7.view.C0716b;
import android.support.v7.view.C0716b.C0694a;
import android.support.v7.view.C0747g;
import android.support.v7.view.menu.C0769h;
import android.support.v7.widget.bf;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.Window;
import android.view.Window.Callback;

/* renamed from: android.support.v7.a.h */
abstract class C0672h extends C0667g {
    private static final int[] f1186m;
    final Context f1187a;
    final Window f1188b;
    final Callback f1189c;
    final Callback f1190d;
    final C0663f f1191e;
    C0645a f1192f;
    MenuInflater f1193g;
    boolean f1194h;
    boolean f1195i;
    boolean f1196j;
    boolean f1197k;
    boolean f1198l;
    private CharSequence f1199n;
    private boolean f1200o;

    /* renamed from: android.support.v7.a.h.a */
    private class C0669a implements C0646a {
        final /* synthetic */ C0672h f1183a;

        private C0669a(C0672h c0672h) {
            this.f1183a = c0672h;
        }
    }

    /* renamed from: android.support.v7.a.h.b */
    class C0671b extends C0670i {
        final /* synthetic */ C0672h f1185a;

        C0671b(C0672h c0672h, Callback callback) {
            this.f1185a = c0672h;
            super(callback);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1185a.m2927a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || this.f1185a.m2926a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i, Menu menu) {
            return (i != 0 || (menu instanceof C0769h)) ? super.onCreatePanelMenu(i, menu) : false;
        }

        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            this.f1185a.m2931b(i, menu);
            return true;
        }

        public void onPanelClosed(int i, Menu menu) {
            super.onPanelClosed(i, menu);
            this.f1185a.m2924a(i, menu);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            C0769h c0769h = menu instanceof C0769h ? (C0769h) menu : null;
            if (i == 0 && c0769h == null) {
                return false;
            }
            if (c0769h != null) {
                c0769h.m3452c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (c0769h == null) {
                return onPreparePanel;
            }
            c0769h.m3452c(false);
            return onPreparePanel;
        }
    }

    static {
        f1186m = new int[]{16842836};
    }

    C0672h(Context context, Window window, C0663f c0663f) {
        this.f1187a = context;
        this.f1188b = window;
        this.f1191e = c0663f;
        this.f1189c = this.f1188b.getCallback();
        if (this.f1189c instanceof C0671b) {
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        this.f1190d = m2923a(this.f1189c);
        this.f1188b.setCallback(this.f1190d);
        bf a = bf.m4773a(context, null, f1186m);
        Drawable b = a.m4781b(0);
        if (b != null) {
            this.f1188b.setBackgroundDrawable(b);
        }
        a.m4778a();
    }

    public C0645a m2922a() {
        m2936l();
        return this.f1192f;
    }

    Callback m2923a(Callback callback) {
        return new C0671b(this, callback);
    }

    abstract void m2924a(int i, Menu menu);

    public final void m2925a(CharSequence charSequence) {
        this.f1199n = charSequence;
        m2930b(charSequence);
    }

    abstract boolean m2926a(int i, KeyEvent keyEvent);

    abstract boolean m2927a(KeyEvent keyEvent);

    abstract C0716b m2928b(C0694a c0694a);

    public MenuInflater m2929b() {
        if (this.f1193g == null) {
            m2936l();
            this.f1193g = new C0747g(this.f1192f != null ? this.f1192f.m2829e() : this.f1187a);
        }
        return this.f1193g;
    }

    abstract void m2930b(CharSequence charSequence);

    abstract boolean m2931b(int i, Menu menu);

    public void m2932c(Bundle bundle) {
    }

    public void m2933f() {
        this.f1200o = true;
    }

    public final C0646a m2934g() {
        return new C0669a();
    }

    public boolean m2935i() {
        return false;
    }

    abstract void m2936l();

    final C0645a m2937m() {
        return this.f1192f;
    }

    final Context m2938n() {
        Context context = null;
        C0645a a = m2922a();
        if (a != null) {
            context = a.m2829e();
        }
        return context == null ? this.f1187a : context;
    }

    public boolean m2939o() {
        return false;
    }

    final boolean m2940p() {
        return this.f1200o;
    }

    final Callback m2941q() {
        return this.f1188b.getCallback();
    }

    final CharSequence m2942r() {
        return this.f1189c instanceof Activity ? ((Activity) this.f1189c).getTitle() : this.f1199n;
    }
}
