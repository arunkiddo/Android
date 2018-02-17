package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.p016k.C0522f;
import android.support.v4.p016k.ah;
import android.support.v7.p034b.C0730a.C0723d;
import android.support.v7.view.menu.C0755o.C0691a;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: android.support.v7.view.menu.n */
public class C0781n {
    private final Context f1612a;
    private final C0769h f1613b;
    private final boolean f1614c;
    private final int f1615d;
    private final int f1616e;
    private View f1617f;
    private int f1618g;
    private boolean f1619h;
    private C0691a f1620i;
    private C0764m f1621j;
    private OnDismissListener f1622k;
    private final OnDismissListener f1623l;

    /* renamed from: android.support.v7.view.menu.n.1 */
    class C07801 implements OnDismissListener {
        final /* synthetic */ C0781n f1611a;

        C07801(C0781n c0781n) {
            this.f1611a = c0781n;
        }

        public void onDismiss() {
            this.f1611a.m3534e();
        }
    }

    public C0781n(Context context, C0769h c0769h, View view, boolean z, int i) {
        this(context, c0769h, view, z, i, 0);
    }

    public C0781n(Context context, C0769h c0769h, View view, boolean z, int i, int i2) {
        this.f1618g = 8388611;
        this.f1623l = new C07801(this);
        this.f1612a = context;
        this.f1613b = c0769h;
        this.f1617f = view;
        this.f1614c = z;
        this.f1615d = i;
        this.f1616e = i2;
    }

    private void m3522a(int i, int i2, boolean z, boolean z2) {
        C0764m b = m3531b();
        b.m3371c(z2);
        if (z) {
            if ((C0522f.m2290a(this.f1618g, ah.m1941h(this.f1617f)) & 7) == 5) {
                i -= this.f1617f.getWidth();
            }
            b.m3368b(i);
            b.m3370c(i2);
            int i3 = (int) ((this.f1612a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.m3362a(new Rect(i - i3, i2 - i3, i + i3, i3 + i2));
        }
        b.m3353a();
    }

    private C0764m m3523g() {
        Display defaultDisplay = ((WindowManager) this.f1612a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else if (VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.set(defaultDisplay.getWidth(), defaultDisplay.getHeight());
        }
        C0764m c0765e = (Math.min(point.x, point.y) >= this.f1612a.getResources().getDimensionPixelSize(C0723d.abc_cascading_menus_min_smallest_width) ? 1 : null) != null ? new C0765e(this.f1612a, this.f1617f, this.f1615d, this.f1616e, this.f1614c) : new C0785t(this.f1612a, this.f1613b, this.f1617f, this.f1615d, this.f1616e, this.f1614c);
        c0765e.m3363a(this.f1613b);
        c0765e.m3365a(this.f1623l);
        c0765e.m3364a(this.f1617f);
        c0765e.m3320a(this.f1620i);
        c0765e.m3366a(this.f1619h);
        c0765e.m3360a(this.f1618g);
        return c0765e;
    }

    public void m3524a() {
        if (!m3532c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public void m3525a(int i) {
        this.f1618g = i;
    }

    public void m3526a(C0691a c0691a) {
        this.f1620i = c0691a;
        if (this.f1621j != null) {
            this.f1621j.m3320a(c0691a);
        }
    }

    public void m3527a(View view) {
        this.f1617f = view;
    }

    public void m3528a(OnDismissListener onDismissListener) {
        this.f1622k = onDismissListener;
    }

    public void m3529a(boolean z) {
        this.f1619h = z;
        if (this.f1621j != null) {
            this.f1621j.m3366a(z);
        }
    }

    public boolean m3530a(int i, int i2) {
        if (m3535f()) {
            return true;
        }
        if (this.f1617f == null) {
            return false;
        }
        m3522a(i, i2, true, true);
        return true;
    }

    public C0764m m3531b() {
        if (this.f1621j == null) {
            this.f1621j = m3523g();
        }
        return this.f1621j;
    }

    public boolean m3532c() {
        if (m3535f()) {
            return true;
        }
        if (this.f1617f == null) {
            return false;
        }
        m3522a(0, 0, false, false);
        return true;
    }

    public void m3533d() {
        if (m3535f()) {
            this.f1621j.m3354c();
        }
    }

    protected void m3534e() {
        this.f1621j = null;
        if (this.f1622k != null) {
            this.f1622k.onDismiss();
        }
    }

    public boolean m3535f() {
        return this.f1621j != null && this.f1621j.m3355d();
    }
}
