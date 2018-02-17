package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p034b.C0730a.C0723d;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.view.menu.C0755o.C0691a;
import android.support.v7.widget.ap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

/* renamed from: android.support.v7.view.menu.t */
final class C0785t extends C0764m implements C0755o, OnKeyListener, OnItemClickListener, OnDismissListener {
    private final Context f1625a;
    private final C0769h f1626b;
    private final C0768g f1627c;
    private final boolean f1628d;
    private final int f1629e;
    private final int f1630f;
    private final int f1631g;
    private final ap f1632h;
    private final OnGlobalLayoutListener f1633i;
    private OnDismissListener f1634j;
    private View f1635k;
    private View f1636l;
    private C0691a f1637m;
    private ViewTreeObserver f1638n;
    private boolean f1639o;
    private boolean f1640p;
    private int f1641q;
    private int f1642r;
    private boolean f1643s;

    /* renamed from: android.support.v7.view.menu.t.1 */
    class C07841 implements OnGlobalLayoutListener {
        final /* synthetic */ C0785t f1624a;

        C07841(C0785t c0785t) {
            this.f1624a = c0785t;
        }

        public void onGlobalLayout() {
            if (this.f1624a.m3557d() && !this.f1624a.f1632h.m3701g()) {
                View b = this.f1624a.f1636l;
                if (b == null || !b.isShown()) {
                    this.f1624a.m3554c();
                } else {
                    this.f1624a.f1632h.m3683a();
                }
            }
        }
    }

    public C0785t(Context context, C0769h c0769h, View view, int i, int i2, boolean z) {
        this.f1633i = new C07841(this);
        this.f1642r = 0;
        this.f1625a = context;
        this.f1626b = c0769h;
        this.f1628d = z;
        this.f1627c = new C0768g(c0769h, LayoutInflater.from(context), this.f1628d);
        this.f1630f = i;
        this.f1631g = i2;
        Resources resources = context.getResources();
        this.f1629e = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0723d.abc_config_prefDialogWidth));
        this.f1635k = view;
        this.f1632h = new ap(this.f1625a, null, this.f1630f, this.f1631g);
        c0769h.m3438a((C0755o) this, context);
    }

    private boolean m3541g() {
        if (m3557d()) {
            return true;
        }
        if (this.f1639o || this.f1635k == null) {
            return false;
        }
        this.f1636l = this.f1635k;
        this.f1632h.m3690a((OnDismissListener) this);
        this.f1632h.m3688a((OnItemClickListener) this);
        this.f1632h.m3691a(true);
        View view = this.f1636l;
        boolean z = this.f1638n == null;
        this.f1638n = view.getViewTreeObserver();
        if (z) {
            this.f1638n.addOnGlobalLayoutListener(this.f1633i);
        }
        this.f1632h.m3687a(view);
        this.f1632h.m3698e(this.f1642r);
        if (!this.f1640p) {
            this.f1641q = C0764m.m3357a(this.f1627c, null, this.f1625a, this.f1629e);
            this.f1640p = true;
        }
        this.f1632h.m3700g(this.f1641q);
        this.f1632h.m3703h(2);
        this.f1632h.m3685a(m3372f());
        this.f1632h.m3683a();
        ViewGroup e = this.f1632h.m3697e();
        e.setOnKeyListener(this);
        if (this.f1643s && this.f1626b.m3467m() != null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(this.f1625a).inflate(C0726g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            if (textView != null) {
                textView.setText(this.f1626b.m3467m());
            }
            frameLayout.setEnabled(false);
            e.addHeaderView(frameLayout, null, false);
        }
        this.f1632h.m3689a(this.f1627c);
        this.f1632h.m3683a();
        return true;
    }

    public void m3542a() {
        if (!m3541g()) {
            throw new IllegalStateException("StandardMenuPopup cannot be used without an anchor");
        }
    }

    public void m3543a(int i) {
        this.f1642r = i;
    }

    public void m3544a(C0769h c0769h) {
    }

    public void m3545a(C0769h c0769h, boolean z) {
        if (c0769h == this.f1626b) {
            m3554c();
            if (this.f1637m != null) {
                this.f1637m.m3040a(c0769h, z);
            }
        }
    }

    public void m3546a(C0691a c0691a) {
        this.f1637m = c0691a;
    }

    public void m3547a(View view) {
        this.f1635k = view;
    }

    public void m3548a(OnDismissListener onDismissListener) {
        this.f1634j = onDismissListener;
    }

    public void m3549a(boolean z) {
        this.f1627c.m3416a(z);
    }

    public boolean m3550a(C0786u c0786u) {
        if (c0786u.hasVisibleItems()) {
            C0781n c0781n = new C0781n(this.f1625a, c0786u, this.f1636l, this.f1628d, this.f1630f, this.f1631g);
            c0781n.m3526a(this.f1637m);
            c0781n.m3529a(C0764m.m3359b((C0769h) c0786u));
            c0781n.m3528a(this.f1634j);
            this.f1634j = null;
            this.f1626b.m3441a(false);
            if (c0781n.m3530a(this.f1632h.m3706j(), this.f1632h.m3707k())) {
                if (this.f1637m != null) {
                    this.f1637m.m3041a(c0786u);
                }
                return true;
            }
        }
        return false;
    }

    public void m3551b(int i) {
        this.f1632h.m3694c(i);
    }

    public void m3552b(boolean z) {
        this.f1640p = false;
        if (this.f1627c != null) {
            this.f1627c.notifyDataSetChanged();
        }
    }

    public boolean m3553b() {
        return false;
    }

    public void m3554c() {
        if (m3557d()) {
            this.f1632h.m3693c();
        }
    }

    public void m3555c(int i) {
        this.f1632h.m3695d(i);
    }

    public void m3556c(boolean z) {
        this.f1643s = z;
    }

    public boolean m3557d() {
        return !this.f1639o && this.f1632h.m3696d();
    }

    public ListView m3558e() {
        return this.f1632h.m3697e();
    }

    public void onDismiss() {
        this.f1639o = true;
        this.f1626b.close();
        if (this.f1638n != null) {
            if (!this.f1638n.isAlive()) {
                this.f1638n = this.f1636l.getViewTreeObserver();
            }
            this.f1638n.removeGlobalOnLayoutListener(this.f1633i);
            this.f1638n = null;
        }
        if (this.f1634j != null) {
            this.f1634j.onDismiss();
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m3554c();
        return true;
    }
}
