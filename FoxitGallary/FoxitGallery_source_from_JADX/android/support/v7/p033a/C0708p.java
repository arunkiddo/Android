package android.support.v7.p033a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.support.v4.p016k.ah;
import android.support.v7.p033a.C0645a.C0643b;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.p034b.C0730a.C0728i;
import android.support.v7.view.C0670i;
import android.support.v7.view.menu.C0755o.C0691a;
import android.support.v7.view.menu.C0767f;
import android.support.v7.view.menu.C0769h;
import android.support.v7.view.menu.C0769h.C0676a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.Toolbar.C0702c;
import android.support.v7.widget.ad;
import android.support.v7.widget.bg;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window.Callback;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.ArrayList;

/* renamed from: android.support.v7.a.p */
class C0708p extends C0645a {
    private ad f1290a;
    private boolean f1291b;
    private Callback f1292c;
    private boolean f1293d;
    private boolean f1294e;
    private ArrayList<C0643b> f1295f;
    private C0767f f1296g;
    private final Runnable f1297h;
    private final C0702c f1298i;

    /* renamed from: android.support.v7.a.p.1 */
    class C07011 implements Runnable {
        final /* synthetic */ C0708p f1283a;

        C07011(C0708p c0708p) {
            this.f1283a = c0708p;
        }

        public void run() {
            this.f1283a.m3096l();
        }
    }

    /* renamed from: android.support.v7.a.p.2 */
    class C07032 implements C0702c {
        final /* synthetic */ C0708p f1284a;

        C07032(C0708p c0708p) {
            this.f1284a = c0708p;
        }

        public boolean m3061a(MenuItem menuItem) {
            return this.f1284a.f1292c.onMenuItemSelected(0, menuItem);
        }
    }

    /* renamed from: android.support.v7.a.p.a */
    private final class C0704a implements C0691a {
        final /* synthetic */ C0708p f1285a;
        private boolean f1286b;

        private C0704a(C0708p c0708p) {
            this.f1285a = c0708p;
        }

        public void m3062a(C0769h c0769h, boolean z) {
            if (!this.f1286b) {
                this.f1286b = true;
                this.f1285a.f1290a.m4549n();
                if (this.f1285a.f1292c != null) {
                    this.f1285a.f1292c.onPanelClosed(C1373c.AppCompatTheme_ratingBarStyle, c0769h);
                }
                this.f1286b = false;
            }
        }

        public boolean m3063a(C0769h c0769h) {
            if (this.f1285a.f1292c == null) {
                return false;
            }
            this.f1285a.f1292c.onMenuOpened(C1373c.AppCompatTheme_ratingBarStyle, c0769h);
            return true;
        }
    }

    /* renamed from: android.support.v7.a.p.b */
    private final class C0705b implements C0676a {
        final /* synthetic */ C0708p f1287a;

        private C0705b(C0708p c0708p) {
            this.f1287a = c0708p;
        }

        public void m3064a(C0769h c0769h) {
            if (this.f1287a.f1292c == null) {
                return;
            }
            if (this.f1287a.f1290a.m4544i()) {
                this.f1287a.f1292c.onPanelClosed(C1373c.AppCompatTheme_ratingBarStyle, c0769h);
            } else if (this.f1287a.f1292c.onPreparePanel(0, null, c0769h)) {
                this.f1287a.f1292c.onMenuOpened(C1373c.AppCompatTheme_ratingBarStyle, c0769h);
            }
        }

        public boolean m3065a(C0769h c0769h, MenuItem menuItem) {
            return false;
        }
    }

    /* renamed from: android.support.v7.a.p.c */
    private final class C0706c implements C0691a {
        final /* synthetic */ C0708p f1288a;

        private C0706c(C0708p c0708p) {
            this.f1288a = c0708p;
        }

        public void m3066a(C0769h c0769h, boolean z) {
            if (this.f1288a.f1292c != null) {
                this.f1288a.f1292c.onPanelClosed(0, c0769h);
            }
        }

        public boolean m3067a(C0769h c0769h) {
            if (c0769h == null && this.f1288a.f1292c != null) {
                this.f1288a.f1292c.onMenuOpened(0, c0769h);
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.a.p.d */
    private class C0707d extends C0670i {
        final /* synthetic */ C0708p f1289a;

        public C0707d(C0708p c0708p, Callback callback) {
            this.f1289a = c0708p;
            super(callback);
        }

        public View onCreatePanelView(int i) {
            switch (i) {
                case C1373c.View_android_theme /*0*/:
                    Menu r = this.f1289a.f1290a.m4553r();
                    if (onPreparePanel(i, null, r) && onMenuOpened(i, r)) {
                        return this.f1289a.m3069a(r);
                    }
            }
            return super.onCreatePanelView(i);
        }

        public boolean onPreparePanel(int i, View view, Menu menu) {
            boolean onPreparePanel = super.onPreparePanel(i, view, menu);
            if (onPreparePanel && !this.f1289a.f1291b) {
                this.f1289a.f1290a.m4548m();
                this.f1289a.f1291b = true;
            }
            return onPreparePanel;
        }
    }

    public C0708p(Toolbar toolbar, CharSequence charSequence, Callback callback) {
        this.f1295f = new ArrayList();
        this.f1297h = new C07011(this);
        this.f1298i = new C07032(this);
        this.f1290a = new bg(toolbar, false);
        this.f1292c = new C0707d(this, callback);
        this.f1290a.m4530a(this.f1292c);
        toolbar.setOnMenuItemClickListener(this.f1298i);
        this.f1290a.m4531a(charSequence);
    }

    private View m3069a(Menu menu) {
        m3072b(menu);
        return (menu == null || this.f1296g == null || this.f1296g.m3405a().getCount() <= 0) ? null : (View) this.f1296g.m3404a(this.f1290a.m4524a());
    }

    private void m3072b(Menu menu) {
        if (this.f1296g == null && (menu instanceof C0769h)) {
            C0769h c0769h = (C0769h) menu;
            Context b = this.f1290a.m4533b();
            TypedValue typedValue = new TypedValue();
            Theme newTheme = b.getResources().newTheme();
            newTheme.setTo(b.getTheme());
            newTheme.resolveAttribute(C0720a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0720a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0728i.Theme_AppCompat_CompactMenu, true);
            }
            Context contextThemeWrapper = new ContextThemeWrapper(b, 0);
            contextThemeWrapper.getTheme().setTo(newTheme);
            this.f1296g = new C0767f(contextThemeWrapper, C0726g.abc_list_menu_item_layout);
            this.f1296g.m3408a(new C0706c());
            c0769h.m3437a(this.f1296g);
        }
    }

    private Menu m3075m() {
        if (!this.f1293d) {
            this.f1290a.m4527a(new C0704a(), new C0705b());
            this.f1293d = true;
        }
        return this.f1290a.m4553r();
    }

    public int m3076a() {
        return this.f1290a.m4550o();
    }

    public void m3077a(float f) {
        ah.m1938f(this.f1290a.m4524a(), f);
    }

    public void m3078a(int i, int i2) {
        this.f1290a.m4536c((this.f1290a.m4550o() & (i2 ^ -1)) | (i & i2));
    }

    public void m3079a(Configuration configuration) {
        super.m2819a(configuration);
    }

    public void m3080a(CharSequence charSequence) {
        this.f1290a.m4531a(charSequence);
    }

    public void m3081a(boolean z) {
        m3078a(z ? 4 : 0, 4);
    }

    public boolean m3082a(int i, KeyEvent keyEvent) {
        Menu m = m3075m();
        if (m != null) {
            m.setQwertyMode(KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1);
            m.performShortcut(i, keyEvent, 0);
        }
        return true;
    }

    public void m3083b() {
        this.f1290a.m4539d(0);
    }

    public void m3084b(boolean z) {
    }

    public void m3085c() {
        this.f1290a.m4539d(8);
    }

    public void m3086d(boolean z) {
    }

    public boolean m3087d() {
        return this.f1290a.m4552q() == 0;
    }

    public Context m3088e() {
        return this.f1290a.m4533b();
    }

    public void m3089e(boolean z) {
    }

    public void m3090f(boolean z) {
        if (z != this.f1294e) {
            this.f1294e = z;
            int size = this.f1295f.size();
            for (int i = 0; i < size; i++) {
                ((C0643b) this.f1295f.get(i)).m2810a(z);
            }
        }
    }

    public boolean m3091g() {
        this.f1290a.m4524a().removeCallbacks(this.f1297h);
        ah.m1917a(this.f1290a.m4524a(), this.f1297h);
        return true;
    }

    public boolean m3092h() {
        if (!this.f1290a.m4537c()) {
            return false;
        }
        this.f1290a.m4538d();
        return true;
    }

    public boolean m3093i() {
        ViewGroup a = this.f1290a.m4524a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    void m3094j() {
        this.f1290a.m4524a().removeCallbacks(this.f1297h);
    }

    public Callback m3095k() {
        return this.f1292c;
    }

    void m3096l() {
        Menu m = m3075m();
        C0769h c0769h = m instanceof C0769h ? (C0769h) m : null;
        if (c0769h != null) {
            c0769h.m3461g();
        }
        try {
            m.clear();
            if (!(this.f1292c.onCreatePanelMenu(0, m) && this.f1292c.onPreparePanel(0, null, m))) {
                m.clear();
            }
            if (c0769h != null) {
                c0769h.m3462h();
            }
        } catch (Throwable th) {
            if (c0769h != null) {
                c0769h.m3462h();
            }
        }
    }
}
