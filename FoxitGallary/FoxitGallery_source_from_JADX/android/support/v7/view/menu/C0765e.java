package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p016k.C0522f;
import android.support.v4.p016k.ah;
import android.support.v7.p034b.C0730a.C0723d;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.view.menu.C0755o.C0691a;
import android.support.v7.widget.ao;
import android.support.v7.widget.ap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* renamed from: android.support.v7.view.menu.e */
final class C0765e extends C0764m implements C0755o, OnKeyListener, OnDismissListener {
    private final Context f1505a;
    private final int f1506b;
    private final int f1507c;
    private final int f1508d;
    private final boolean f1509e;
    private final Handler f1510f;
    private final List<C0769h> f1511g;
    private final List<C0762a> f1512h;
    private final OnGlobalLayoutListener f1513i;
    private final ao f1514j;
    private int f1515k;
    private int f1516l;
    private View f1517m;
    private View f1518n;
    private int f1519o;
    private boolean f1520p;
    private boolean f1521q;
    private int f1522r;
    private int f1523s;
    private boolean f1524t;
    private boolean f1525u;
    private C0691a f1526v;
    private ViewTreeObserver f1527w;
    private OnDismissListener f1528x;
    private boolean f1529y;

    /* renamed from: android.support.v7.view.menu.e.1 */
    class C07591 implements OnGlobalLayoutListener {
        final /* synthetic */ C0765e f1495a;

        C07591(C0765e c0765e) {
            this.f1495a = c0765e;
        }

        public void onGlobalLayout() {
            if (this.f1495a.m3399d() && this.f1495a.f1512h.size() > 0 && !((C0762a) this.f1495a.f1512h.get(0)).f1501a.m3701g()) {
                View b = this.f1495a.f1518n;
                if (b == null || !b.isShown()) {
                    this.f1495a.m3396c();
                    return;
                }
                for (C0762a c0762a : this.f1495a.f1512h) {
                    c0762a.f1501a.m3683a();
                }
            }
        }
    }

    /* renamed from: android.support.v7.view.menu.e.2 */
    class C07612 implements ao {
        final /* synthetic */ C0765e f1500a;

        /* renamed from: android.support.v7.view.menu.e.2.1 */
        class C07601 implements Runnable {
            final /* synthetic */ C0762a f1496a;
            final /* synthetic */ MenuItem f1497b;
            final /* synthetic */ C0769h f1498c;
            final /* synthetic */ C07612 f1499d;

            C07601(C07612 c07612, C0762a c0762a, MenuItem menuItem, C0769h c0769h) {
                this.f1499d = c07612;
                this.f1496a = c0762a;
                this.f1497b = menuItem;
                this.f1498c = c0769h;
            }

            public void run() {
                if (this.f1496a != null) {
                    this.f1499d.f1500a.f1529y = true;
                    this.f1496a.f1502b.m3441a(false);
                    this.f1499d.f1500a.f1529y = false;
                }
                if (this.f1497b.isEnabled() && this.f1497b.hasSubMenu()) {
                    this.f1498c.m3443a(this.f1497b, 0);
                }
            }
        }

        C07612(C0765e c0765e) {
            this.f1500a = c0765e;
        }

        public void m3350a(C0769h c0769h, MenuItem menuItem) {
            this.f1500a.f1510f.removeCallbacksAndMessages(c0769h);
        }

        public void m3351b(C0769h c0769h, MenuItem menuItem) {
            int i;
            this.f1500a.f1510f.removeCallbacksAndMessages(null);
            int size = this.f1500a.f1512h.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (c0769h == ((C0762a) this.f1500a.f1512h.get(i2)).f1502b) {
                    i = i2;
                    break;
                }
            }
            i = -1;
            if (i != -1) {
                i++;
                this.f1500a.f1510f.postAtTime(new C07601(this, i < this.f1500a.f1512h.size() ? (C0762a) this.f1500a.f1512h.get(i) : null, menuItem, c0769h), c0769h, SystemClock.uptimeMillis() + 200);
            }
        }
    }

    /* renamed from: android.support.v7.view.menu.e.a */
    private static class C0762a {
        public final ap f1501a;
        public final C0769h f1502b;
        public final int f1503c;

        public C0762a(ap apVar, C0769h c0769h, int i) {
            this.f1501a = apVar;
            this.f1502b = c0769h;
            this.f1503c = i;
        }

        public ListView m3352a() {
            return this.f1501a.m3697e();
        }
    }

    public C0765e(Context context, View view, int i, int i2, boolean z) {
        this.f1511g = new LinkedList();
        this.f1512h = new ArrayList();
        this.f1513i = new C07591(this);
        this.f1514j = new C07612(this);
        this.f1515k = 0;
        this.f1516l = 0;
        this.f1505a = context;
        this.f1517m = view;
        this.f1507c = i;
        this.f1508d = i2;
        this.f1509e = z;
        this.f1524t = false;
        this.f1519o = m3383h();
        Resources resources = context.getResources();
        this.f1506b = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0723d.abc_config_prefDialogWidth));
        this.f1510f = new Handler();
    }

    private MenuItem m3373a(C0769h c0769h, C0769h c0769h2) {
        int size = c0769h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0769h.getItem(i);
            if (item.hasSubMenu() && c0769h2 == item.getSubMenu()) {
                return item;
            }
        }
        return null;
    }

    private View m3374a(C0762a c0762a, C0769h c0769h) {
        int i = 0;
        MenuItem a = m3373a(c0762a.f1502b, c0769h);
        if (a == null) {
            return null;
        }
        int headersCount;
        C0768g c0768g;
        int i2;
        ListView a2 = c0762a.m3352a();
        ListAdapter adapter = a2.getAdapter();
        if (adapter instanceof HeaderViewListAdapter) {
            HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
            headersCount = headerViewListAdapter.getHeadersCount();
            c0768g = (C0768g) headerViewListAdapter.getWrappedAdapter();
        } else {
            c0768g = (C0768g) adapter;
            headersCount = 0;
        }
        int count = c0768g.getCount();
        while (i < count) {
            if (a == c0768g.m3415a(i)) {
                i2 = i;
                break;
            }
            i++;
        }
        i2 = -1;
        if (i2 == -1) {
            return null;
        }
        i2 = (i2 + headersCount) - a2.getFirstVisiblePosition();
        return (i2 < 0 || i2 >= a2.getChildCount()) ? null : a2.getChildAt(i2);
    }

    private void m3379c(C0769h c0769h) {
        View a;
        C0762a c0762a;
        LayoutInflater from = LayoutInflater.from(this.f1505a);
        Object c0768g = new C0768g(c0769h, from, this.f1509e);
        if (!m3399d() && this.f1524t) {
            c0768g.m3416a(true);
        } else if (m3399d()) {
            c0768g.m3416a(C0764m.m3359b(c0769h));
        }
        int a2 = C0764m.m3357a(c0768g, null, this.f1505a, this.f1506b);
        ap g = m3382g();
        g.m3689a((ListAdapter) c0768g);
        g.m3699f(a2);
        g.m3698e(this.f1516l);
        if (this.f1512h.size() > 0) {
            C0762a c0762a2 = (C0762a) this.f1512h.get(this.f1512h.size() - 1);
            a = m3374a(c0762a2, c0769h);
            c0762a = c0762a2;
        } else {
            a = null;
            c0762a = null;
        }
        if (a != null) {
            g.m4654b(false);
            g.m4651a(null);
            int d = m3380d(a2);
            boolean z = d == 1;
            this.f1519o = d;
            int[] iArr = new int[2];
            a.getLocationInWindow(iArr);
            int j = c0762a.f1501a.m3706j() + iArr[0];
            int k = iArr[1] + c0762a.f1501a.m3707k();
            int width = (this.f1516l & 5) == 5 ? z ? j + a2 : j - a.getWidth() : z ? a.getWidth() + j : j - a2;
            g.m3694c(width);
            g.m3695d(k);
        } else {
            if (this.f1520p) {
                g.m3694c(this.f1522r);
            }
            if (this.f1521q) {
                g.m3695d(this.f1523s);
            }
            g.m3685a(m3372f());
        }
        this.f1512h.add(new C0762a(g, c0769h, this.f1519o));
        g.m3683a();
        if (c0762a == null && this.f1525u && c0769h.m3467m() != null) {
            ViewGroup e = g.m3697e();
            FrameLayout frameLayout = (FrameLayout) from.inflate(C0726g.abc_popup_menu_header_item_layout, e, false);
            TextView textView = (TextView) frameLayout.findViewById(16908310);
            frameLayout.setEnabled(false);
            textView.setText(c0769h.m3467m());
            e.addHeaderView(frameLayout, null, false);
            g.m3683a();
        }
    }

    private int m3380d(int i) {
        ListView a = ((C0762a) this.f1512h.get(this.f1512h.size() - 1)).m3352a();
        int[] iArr = new int[2];
        a.getLocationOnScreen(iArr);
        Rect rect = new Rect();
        this.f1518n.getWindowVisibleDisplayFrame(rect);
        if (this.f1519o != 1) {
            return iArr[0] - i < 0 ? 1 : 0;
        } else {
            return (a.getWidth() + iArr[0]) + i > rect.right ? 0 : 1;
        }
    }

    private int m3381d(C0769h c0769h) {
        int size = this.f1512h.size();
        for (int i = 0; i < size; i++) {
            if (c0769h == ((C0762a) this.f1512h.get(i)).f1502b) {
                return i;
            }
        }
        return -1;
    }

    private ap m3382g() {
        ap apVar = new ap(this.f1505a, null, this.f1507c, this.f1508d);
        apVar.m4650a(this.f1514j);
        apVar.m3688a((OnItemClickListener) this);
        apVar.m3690a((OnDismissListener) this);
        apVar.m3687a(this.f1517m);
        apVar.m3698e(this.f1516l);
        apVar.m3691a(true);
        return apVar;
    }

    private int m3383h() {
        return ah.m1941h(this.f1517m) == 1 ? 0 : 1;
    }

    public void m3384a() {
        if (!m3399d()) {
            for (C0769h c : this.f1511g) {
                m3379c(c);
            }
            this.f1511g.clear();
            this.f1518n = this.f1517m;
            if (this.f1518n != null) {
                Object obj = this.f1527w == null ? 1 : null;
                this.f1527w = this.f1518n.getViewTreeObserver();
                if (obj != null) {
                    this.f1527w.addOnGlobalLayoutListener(this.f1513i);
                }
            }
        }
    }

    public void m3385a(int i) {
        if (this.f1515k != i) {
            this.f1515k = i;
            this.f1516l = C0522f.m2290a(i, ah.m1941h(this.f1517m));
        }
    }

    public void m3386a(C0769h c0769h) {
        c0769h.m3438a((C0755o) this, this.f1505a);
        if (m3399d()) {
            m3379c(c0769h);
        } else {
            this.f1511g.add(c0769h);
        }
    }

    public void m3387a(C0769h c0769h, boolean z) {
        int d = m3381d(c0769h);
        if (d >= 0) {
            int i = d + 1;
            if (i < this.f1512h.size()) {
                ((C0762a) this.f1512h.get(i)).f1502b.m3441a(false);
            }
            C0762a c0762a = (C0762a) this.f1512h.remove(d);
            c0762a.f1502b.m3448b((C0755o) this);
            if (this.f1529y) {
                c0762a.f1501a.m4653b(null);
                c0762a.f1501a.m3692b(0);
            }
            c0762a.f1501a.m3693c();
            d = this.f1512h.size();
            if (d > 0) {
                this.f1519o = ((C0762a) this.f1512h.get(d - 1)).f1503c;
            } else {
                this.f1519o = m3383h();
            }
            if (d == 0) {
                m3396c();
                if (this.f1526v != null) {
                    this.f1526v.m3040a(c0769h, true);
                }
                if (this.f1527w != null) {
                    if (this.f1527w.isAlive()) {
                        this.f1527w.removeGlobalOnLayoutListener(this.f1513i);
                    }
                    this.f1527w = null;
                }
                this.f1528x.onDismiss();
            } else if (z) {
                ((C0762a) this.f1512h.get(0)).f1502b.m3441a(false);
            }
        }
    }

    public void m3388a(C0691a c0691a) {
        this.f1526v = c0691a;
    }

    public void m3389a(View view) {
        if (this.f1517m != view) {
            this.f1517m = view;
            this.f1516l = C0522f.m2290a(this.f1515k, ah.m1941h(this.f1517m));
        }
    }

    public void m3390a(OnDismissListener onDismissListener) {
        this.f1528x = onDismissListener;
    }

    public void m3391a(boolean z) {
        this.f1524t = z;
    }

    public boolean m3392a(C0786u c0786u) {
        for (C0762a c0762a : this.f1512h) {
            if (c0786u == c0762a.f1502b) {
                c0762a.m3352a().requestFocus();
                return true;
            }
        }
        if (!c0786u.hasVisibleItems()) {
            return false;
        }
        m3386a((C0769h) c0786u);
        if (this.f1526v != null) {
            this.f1526v.m3041a(c0786u);
        }
        return true;
    }

    public void m3393b(int i) {
        this.f1520p = true;
        this.f1522r = i;
    }

    public void m3394b(boolean z) {
        for (C0762a a : this.f1512h) {
            C0764m.m3358a(a.m3352a().getAdapter()).notifyDataSetChanged();
        }
    }

    public boolean m3395b() {
        return false;
    }

    public void m3396c() {
        int size = this.f1512h.size();
        if (size > 0) {
            C0762a[] c0762aArr = (C0762a[]) this.f1512h.toArray(new C0762a[size]);
            for (size--; size >= 0; size--) {
                C0762a c0762a = c0762aArr[size];
                if (c0762a.f1501a.m3696d()) {
                    c0762a.f1501a.m3693c();
                }
            }
        }
    }

    public void m3397c(int i) {
        this.f1521q = true;
        this.f1523s = i;
    }

    public void m3398c(boolean z) {
        this.f1525u = z;
    }

    public boolean m3399d() {
        return this.f1512h.size() > 0 && ((C0762a) this.f1512h.get(0)).f1501a.m3696d();
    }

    public ListView m3400e() {
        return this.f1512h.isEmpty() ? null : ((C0762a) this.f1512h.get(this.f1512h.size() - 1)).m3352a();
    }

    public void onDismiss() {
        C0762a c0762a;
        int size = this.f1512h.size();
        for (int i = 0; i < size; i++) {
            c0762a = (C0762a) this.f1512h.get(i);
            if (!c0762a.f1501a.m3696d()) {
                break;
            }
        }
        c0762a = null;
        if (c0762a != null) {
            c0762a.f1502b.m3441a(false);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m3396c();
        return true;
    }
}
