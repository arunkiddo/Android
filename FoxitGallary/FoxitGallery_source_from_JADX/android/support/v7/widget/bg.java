package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.az;
import android.support.v4.p016k.be;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0724e;
import android.support.v7.p034b.C0730a.C0725f;
import android.support.v7.p034b.C0730a.C0727h;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.menu.C0754a;
import android.support.v7.view.menu.C0755o.C0691a;
import android.support.v7.view.menu.C0769h;
import android.support.v7.view.menu.C0769h.C0676a;
import android.support.v7.widget.Toolbar.C0878b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class bg implements ad {
    private Toolbar f2354a;
    private int f2355b;
    private View f2356c;
    private View f2357d;
    private Drawable f2358e;
    private Drawable f2359f;
    private Drawable f2360g;
    private boolean f2361h;
    private CharSequence f2362i;
    private CharSequence f2363j;
    private CharSequence f2364k;
    private Callback f2365l;
    private boolean f2366m;
    private C0931d f2367n;
    private int f2368o;
    private final C0951m f2369p;
    private int f2370q;
    private Drawable f2371r;

    /* renamed from: android.support.v7.widget.bg.1 */
    class C09181 implements OnClickListener {
        final C0754a f2349a;
        final /* synthetic */ bg f2350b;

        C09181(bg bgVar) {
            this.f2350b = bgVar;
            this.f2349a = new C0754a(this.f2350b.f2354a.getContext(), 0, 16908332, 0, 0, this.f2350b.f2362i);
        }

        public void onClick(View view) {
            if (this.f2350b.f2365l != null && this.f2350b.f2366m) {
                this.f2350b.f2365l.onMenuItemSelected(0, this.f2349a);
            }
        }
    }

    /* renamed from: android.support.v7.widget.bg.2 */
    class C09192 extends be {
        final /* synthetic */ int f2351a;
        final /* synthetic */ bg f2352b;
        private boolean f2353c;

        C09192(bg bgVar, int i) {
            this.f2352b = bgVar;
            this.f2351a = i;
            this.f2353c = false;
        }

        public void m4792a(View view) {
            this.f2352b.f2354a.setVisibility(0);
        }

        public void m4793b(View view) {
            if (!this.f2353c) {
                this.f2352b.f2354a.setVisibility(this.f2351a);
            }
        }

        public void m4794c(View view) {
            this.f2353c = true;
        }
    }

    public bg(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0727h.abc_action_bar_up_description, C0724e.abc_ic_ab_back_material);
    }

    public bg(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2368o = 0;
        this.f2370q = 0;
        this.f2354a = toolbar;
        this.f2362i = toolbar.getTitle();
        this.f2363j = toolbar.getSubtitle();
        this.f2361h = this.f2362i != null;
        this.f2360g = toolbar.getNavigationIcon();
        bf a = bf.m4774a(toolbar.getContext(), null, C0729j.ActionBar, C0720a.actionBarStyle, 0);
        this.f2371r = a.m4777a(C0729j.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence c = a.m4783c(C0729j.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                m4818b(c);
            }
            c = a.m4783c(C0729j.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m4822c(c);
            }
            Drawable a2 = a.m4777a(C0729j.ActionBar_logo);
            if (a2 != null) {
                m4817b(a2);
            }
            a2 = a.m4777a(C0729j.ActionBar_icon);
            if (a2 != null) {
                m4807a(a2);
            }
            if (this.f2360g == null && this.f2371r != null) {
                m4821c(this.f2371r);
            }
            m4820c(a.m4776a(C0729j.ActionBar_displayOptions, 0));
            int g = a.m4790g(C0729j.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m4811a(LayoutInflater.from(this.f2354a.getContext()).inflate(g, this.f2354a, false));
                m4820c(this.f2355b | 16);
            }
            g = a.m4788f(C0729j.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f2354a.getLayoutParams();
                layoutParams.height = g;
                this.f2354a.setLayoutParams(layoutParams);
            }
            g = a.m4784d(C0729j.ActionBar_contentInsetStart, -1);
            int d = a.m4784d(C0729j.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f2354a.m4473a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m4790g(C0729j.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f2354a.m4474a(this.f2354a.getContext(), g);
            }
            g = a.m4790g(C0729j.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f2354a.m4478b(this.f2354a.getContext(), g);
            }
            int g2 = a.m4790g(C0729j.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f2354a.setPopupTheme(g2);
            }
        } else {
            this.f2355b = m4800s();
        }
        a.m4778a();
        this.f2369p = C0951m.m4995a();
        m4828e(i);
        this.f2364k = this.f2354a.getNavigationContentDescription();
        this.f2354a.setNavigationOnClickListener(new C09181(this));
    }

    private void m4799e(CharSequence charSequence) {
        this.f2362i = charSequence;
        if ((this.f2355b & 8) != 0) {
            this.f2354a.setTitle(charSequence);
        }
    }

    private int m4800s() {
        if (this.f2354a.getNavigationIcon() == null) {
            return 11;
        }
        this.f2371r = this.f2354a.getNavigationIcon();
        return 15;
    }

    private void m4801t() {
        Drawable drawable = null;
        if ((this.f2355b & 2) != 0) {
            drawable = (this.f2355b & 1) != 0 ? this.f2359f != null ? this.f2359f : this.f2358e : this.f2358e;
        }
        this.f2354a.setLogo(drawable);
    }

    private void m4802u() {
        if ((this.f2355b & 4) != 0) {
            this.f2354a.setNavigationIcon(this.f2360g != null ? this.f2360g : this.f2371r);
        } else {
            this.f2354a.setNavigationIcon(null);
        }
    }

    private void m4803v() {
        if ((this.f2355b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2364k)) {
            this.f2354a.setNavigationContentDescription(this.f2370q);
        } else {
            this.f2354a.setNavigationContentDescription(this.f2364k);
        }
    }

    public az m4804a(int i, long j) {
        return ah.m1951r(this.f2354a).m2157a(i == 0 ? 1.0f : 0.0f).m2158a(j).m2159a(new C09192(this, i));
    }

    public ViewGroup m4805a() {
        return this.f2354a;
    }

    public void m4806a(int i) {
        m4807a(i != 0 ? this.f2369p.m5013a(m4815b(), i) : null);
    }

    public void m4807a(Drawable drawable) {
        this.f2358e = drawable;
        m4801t();
    }

    public void m4808a(C0691a c0691a, C0676a c0676a) {
        this.f2354a.m4476a(c0691a, c0676a);
    }

    public void m4809a(ax axVar) {
        if (this.f2356c != null && this.f2356c.getParent() == this.f2354a) {
            this.f2354a.removeView(this.f2356c);
        }
        this.f2356c = axVar;
        if (axVar != null && this.f2368o == 2) {
            this.f2354a.addView(this.f2356c, 0);
            C0878b c0878b = (C0878b) this.f2356c.getLayoutParams();
            c0878b.width = -2;
            c0878b.height = -2;
            c0878b.a = 8388691;
            axVar.setAllowCollapse(true);
        }
    }

    public void m4810a(Menu menu, C0691a c0691a) {
        if (this.f2367n == null) {
            this.f2367n = new C0931d(this.f2354a.getContext());
            this.f2367n.m3329a(C0725f.action_menu_presenter);
        }
        this.f2367n.m3333a(c0691a);
        this.f2354a.m4475a((C0769h) menu, this.f2367n);
    }

    public void m4811a(View view) {
        if (!(this.f2357d == null || (this.f2355b & 16) == 0)) {
            this.f2354a.removeView(this.f2357d);
        }
        this.f2357d = view;
        if (view != null && (this.f2355b & 16) != 0) {
            this.f2354a.addView(this.f2357d);
        }
    }

    public void m4812a(Callback callback) {
        this.f2365l = callback;
    }

    public void m4813a(CharSequence charSequence) {
        if (!this.f2361h) {
            m4799e(charSequence);
        }
    }

    public void m4814a(boolean z) {
        this.f2354a.setCollapsible(z);
    }

    public Context m4815b() {
        return this.f2354a.getContext();
    }

    public void m4816b(int i) {
        m4817b(i != 0 ? this.f2369p.m5013a(m4815b(), i) : null);
    }

    public void m4817b(Drawable drawable) {
        this.f2359f = drawable;
        m4801t();
    }

    public void m4818b(CharSequence charSequence) {
        this.f2361h = true;
        m4799e(charSequence);
    }

    public void m4819b(boolean z) {
    }

    public void m4820c(int i) {
        int i2 = this.f2355b ^ i;
        this.f2355b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m4803v();
                }
                m4802u();
            }
            if ((i2 & 3) != 0) {
                m4801t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2354a.setTitle(this.f2362i);
                    this.f2354a.setSubtitle(this.f2363j);
                } else {
                    this.f2354a.setTitle(null);
                    this.f2354a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f2357d != null) {
                if ((i & 16) != 0) {
                    this.f2354a.addView(this.f2357d);
                } else {
                    this.f2354a.removeView(this.f2357d);
                }
            }
        }
    }

    public void m4821c(Drawable drawable) {
        this.f2360g = drawable;
        m4802u();
    }

    public void m4822c(CharSequence charSequence) {
        this.f2363j = charSequence;
        if ((this.f2355b & 8) != 0) {
            this.f2354a.setSubtitle(charSequence);
        }
    }

    public boolean m4823c() {
        return this.f2354a.m4484g();
    }

    public void m4824d() {
        this.f2354a.m4485h();
    }

    public void m4825d(int i) {
        this.f2354a.setVisibility(i);
    }

    public void m4826d(CharSequence charSequence) {
        this.f2364k = charSequence;
        m4803v();
    }

    public CharSequence m4827e() {
        return this.f2354a.getTitle();
    }

    public void m4828e(int i) {
        if (i != this.f2370q) {
            this.f2370q = i;
            if (TextUtils.isEmpty(this.f2354a.getNavigationContentDescription())) {
                m4830f(this.f2370q);
            }
        }
    }

    public void m4829f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void m4830f(int i) {
        m4826d(i == 0 ? null : m4815b().getString(i));
    }

    public void m4831g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public boolean m4832h() {
        return this.f2354a.m4477a();
    }

    public boolean m4833i() {
        return this.f2354a.m4479b();
    }

    public boolean m4834j() {
        return this.f2354a.m4480c();
    }

    public boolean m4835k() {
        return this.f2354a.m4481d();
    }

    public boolean m4836l() {
        return this.f2354a.m4482e();
    }

    public void m4837m() {
        this.f2366m = true;
    }

    public void m4838n() {
        this.f2354a.m4483f();
    }

    public int m4839o() {
        return this.f2355b;
    }

    public int m4840p() {
        return this.f2368o;
    }

    public int m4841q() {
        return this.f2354a.getVisibility();
    }

    public Menu m4842r() {
        return this.f2354a.getMenu();
    }
}
