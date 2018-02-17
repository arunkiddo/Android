package android.support.v7.p033a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.az;
import android.support.v4.p016k.bd;
import android.support.v4.p016k.be;
import android.support.v4.p016k.bf;
import android.support.v7.p033a.C0645a.C0643b;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0725f;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.C0716b;
import android.support.v7.view.C0716b.C0694a;
import android.support.v7.view.C0739a;
import android.support.v7.view.C0747g;
import android.support.v7.view.C0749h;
import android.support.v7.view.menu.C0769h;
import android.support.v7.view.menu.C0769h.C0676a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.C0718a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ad;
import android.support.v7.widget.ax;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: android.support.v7.a.s */
public class C0719s extends C0645a implements C0718a {
    static final /* synthetic */ boolean f1322h;
    private static final Interpolator f1323i;
    private static final Interpolator f1324j;
    private static final boolean f1325k;
    private boolean f1326A;
    private int f1327B;
    private boolean f1328C;
    private boolean f1329D;
    private boolean f1330E;
    private boolean f1331F;
    private boolean f1332G;
    private C0749h f1333H;
    private boolean f1334I;
    C0717a f1335a;
    C0716b f1336b;
    C0694a f1337c;
    boolean f1338d;
    final bd f1339e;
    final bd f1340f;
    final bf f1341g;
    private Context f1342l;
    private Context f1343m;
    private Activity f1344n;
    private Dialog f1345o;
    private ActionBarOverlayLayout f1346p;
    private ActionBarContainer f1347q;
    private ad f1348r;
    private ActionBarContextView f1349s;
    private View f1350t;
    private ax f1351u;
    private ArrayList<Object> f1352v;
    private int f1353w;
    private boolean f1354x;
    private boolean f1355y;
    private ArrayList<C0643b> f1356z;

    /* renamed from: android.support.v7.a.s.1 */
    class C07131 extends be {
        final /* synthetic */ C0719s f1312a;

        C07131(C0719s c0719s) {
            this.f1312a = c0719s;
        }

        public void m3104b(View view) {
            if (this.f1312a.f1328C && this.f1312a.f1350t != null) {
                ah.m1923b(this.f1312a.f1350t, 0.0f);
                ah.m1923b(this.f1312a.f1347q, 0.0f);
            }
            this.f1312a.f1347q.setVisibility(8);
            this.f1312a.f1347q.setTransitioning(false);
            this.f1312a.f1333H = null;
            this.f1312a.m3190k();
            if (this.f1312a.f1346p != null) {
                ah.m1954u(this.f1312a.f1346p);
            }
        }
    }

    /* renamed from: android.support.v7.a.s.2 */
    class C07142 extends be {
        final /* synthetic */ C0719s f1313a;

        C07142(C0719s c0719s) {
            this.f1313a = c0719s;
        }

        public void m3105b(View view) {
            this.f1313a.f1333H = null;
            this.f1313a.f1347q.requestLayout();
        }
    }

    /* renamed from: android.support.v7.a.s.3 */
    class C07153 implements bf {
        final /* synthetic */ C0719s f1314a;

        C07153(C0719s c0719s) {
            this.f1314a = c0719s;
        }

        public void m3106a(View view) {
            ((View) this.f1314a.f1347q.getParent()).invalidate();
        }
    }

    /* renamed from: android.support.v7.a.s.a */
    public class C0717a extends C0716b implements C0676a {
        final /* synthetic */ C0719s f1317a;
        private final Context f1318b;
        private final C0769h f1319c;
        private C0694a f1320d;
        private WeakReference<View> f1321e;

        public C0717a(C0719s c0719s, Context context, C0694a c0694a) {
            this.f1317a = c0719s;
            this.f1318b = context;
            this.f1320d = c0694a;
            this.f1319c = new C0769h(context).m3427a(1);
            this.f1319c.m3435a((C0676a) this);
        }

        public MenuInflater m3124a() {
            return new C0747g(this.f1318b);
        }

        public void m3125a(int i) {
            m3133b(this.f1317a.f1342l.getResources().getString(i));
        }

        public void m3126a(C0769h c0769h) {
            if (this.f1320d != null) {
                m3135d();
                this.f1317a.f1349s.m3581a();
            }
        }

        public void m3127a(View view) {
            this.f1317a.f1349s.setCustomView(view);
            this.f1321e = new WeakReference(view);
        }

        public void m3128a(CharSequence charSequence) {
            this.f1317a.f1349s.setSubtitle(charSequence);
        }

        public void m3129a(boolean z) {
            super.m3112a(z);
            this.f1317a.f1349s.setTitleOptional(z);
        }

        public boolean m3130a(C0769h c0769h, MenuItem menuItem) {
            return this.f1320d != null ? this.f1320d.onActionItemClicked(this, menuItem) : false;
        }

        public Menu m3131b() {
            return this.f1319c;
        }

        public void m3132b(int i) {
            m3128a(this.f1317a.f1342l.getResources().getString(i));
        }

        public void m3133b(CharSequence charSequence) {
            this.f1317a.f1349s.setTitle(charSequence);
        }

        public void m3134c() {
            if (this.f1317a.f1335a == this) {
                if (C0719s.m3153b(this.f1317a.f1329D, this.f1317a.f1330E, false)) {
                    this.f1320d.onDestroyActionMode(this);
                } else {
                    this.f1317a.f1336b = this;
                    this.f1317a.f1337c = this.f1320d;
                }
                this.f1320d = null;
                this.f1317a.m3189j(false);
                this.f1317a.f1349s.m3582b();
                this.f1317a.f1348r.m4524a().sendAccessibilityEvent(32);
                this.f1317a.f1346p.setHideOnContentScrollEnabled(this.f1317a.f1338d);
                this.f1317a.f1335a = null;
            }
        }

        public void m3135d() {
            if (this.f1317a.f1335a == this) {
                this.f1319c.m3461g();
                try {
                    this.f1320d.onPrepareActionMode(this, this.f1319c);
                } finally {
                    this.f1319c.m3462h();
                }
            }
        }

        public boolean m3136e() {
            this.f1319c.m3461g();
            try {
                boolean onCreateActionMode = this.f1320d.onCreateActionMode(this, this.f1319c);
                return onCreateActionMode;
            } finally {
                this.f1319c.m3462h();
            }
        }

        public CharSequence m3137f() {
            return this.f1317a.f1349s.getTitle();
        }

        public CharSequence m3138g() {
            return this.f1317a.f1349s.getSubtitle();
        }

        public boolean m3139h() {
            return this.f1317a.f1349s.m3584d();
        }

        public View m3140i() {
            return this.f1321e != null ? (View) this.f1321e.get() : null;
        }
    }

    static {
        boolean z = true;
        f1322h = !C0719s.class.desiredAssertionStatus();
        f1323i = new AccelerateInterpolator();
        f1324j = new DecelerateInterpolator();
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f1325k = z;
    }

    public C0719s(Activity activity, boolean z) {
        this.f1352v = new ArrayList();
        this.f1353w = -1;
        this.f1356z = new ArrayList();
        this.f1327B = 0;
        this.f1328C = true;
        this.f1332G = true;
        this.f1339e = new C07131(this);
        this.f1340f = new C07142(this);
        this.f1341g = new C07153(this);
        this.f1344n = activity;
        View decorView = activity.getWindow().getDecorView();
        m3148a(decorView);
        if (!z) {
            this.f1350t = decorView.findViewById(16908290);
        }
    }

    public C0719s(Dialog dialog) {
        this.f1352v = new ArrayList();
        this.f1353w = -1;
        this.f1356z = new ArrayList();
        this.f1327B = 0;
        this.f1328C = true;
        this.f1332G = true;
        this.f1339e = new C07131(this);
        this.f1340f = new C07142(this);
        this.f1341g = new C07153(this);
        this.f1345o = dialog;
        m3148a(dialog.getWindow().getDecorView());
    }

    private void m3148a(View view) {
        this.f1346p = (ActionBarOverlayLayout) view.findViewById(C0725f.decor_content_parent);
        if (this.f1346p != null) {
            this.f1346p.setActionBarVisibilityCallback(this);
        }
        this.f1348r = m3151b(view.findViewById(C0725f.action_bar));
        this.f1349s = (ActionBarContextView) view.findViewById(C0725f.action_context_bar);
        this.f1347q = (ActionBarContainer) view.findViewById(C0725f.action_bar_container);
        if (this.f1348r == null || this.f1349s == null || this.f1347q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1342l = this.f1348r.m4533b();
        boolean z = (this.f1348r.m4550o() & 4) != 0;
        if (z) {
            this.f1354x = true;
        }
        C0739a a = C0739a.m3212a(this.f1342l);
        z = a.m3218f() || z;
        m3175b(z);
        m3161k(a.m3216d());
        TypedArray obtainStyledAttributes = this.f1342l.obtainStyledAttributes(null, C0729j.ActionBar, C0720a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0729j.ActionBar_hideOnContentScroll, false)) {
            m3177c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0729j.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            m3168a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private ad m3151b(View view) {
        if (view instanceof ad) {
            return (ad) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    private static boolean m3153b(boolean z, boolean z2, boolean z3) {
        return z3 ? true : (z || z2) ? false : true;
    }

    private void m3161k(boolean z) {
        boolean z2 = true;
        this.f1326A = z;
        if (this.f1326A) {
            this.f1347q.setTabContainer(null);
            this.f1348r.m4528a(this.f1351u);
        } else {
            this.f1348r.m4528a(null);
            this.f1347q.setTabContainer(this.f1351u);
        }
        boolean z3 = m3191l() == 2;
        if (this.f1351u != null) {
            if (z3) {
                this.f1351u.setVisibility(0);
                if (this.f1346p != null) {
                    ah.m1954u(this.f1346p);
                }
            } else {
                this.f1351u.setVisibility(8);
            }
        }
        ad adVar = this.f1348r;
        boolean z4 = !this.f1326A && z3;
        adVar.m4532a(z4);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1346p;
        if (this.f1326A || !z3) {
            z2 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z2);
    }

    private void m3162l(boolean z) {
        if (C0719s.m3153b(this.f1329D, this.f1330E, this.f1331F)) {
            if (!this.f1332G) {
                this.f1332G = true;
                m3185h(z);
            }
        } else if (this.f1332G) {
            this.f1332G = false;
            m3187i(z);
        }
    }

    private void m3163r() {
        if (!this.f1331F) {
            this.f1331F = true;
            if (this.f1346p != null) {
                this.f1346p.setShowingForActionMode(true);
            }
            m3162l(false);
        }
    }

    private void m3164s() {
        if (this.f1331F) {
            this.f1331F = false;
            if (this.f1346p != null) {
                this.f1346p.setShowingForActionMode(false);
            }
            m3162l(false);
        }
    }

    private boolean m3165t() {
        return ah.m1901D(this.f1347q);
    }

    public int m3166a() {
        return this.f1348r.m4550o();
    }

    public C0716b m3167a(C0694a c0694a) {
        if (this.f1335a != null) {
            this.f1335a.m3134c();
        }
        this.f1346p.setHideOnContentScrollEnabled(false);
        this.f1349s.m3583c();
        C0716b c0717a = new C0717a(this, this.f1349s.getContext(), c0694a);
        if (!c0717a.m3136e()) {
            return null;
        }
        this.f1335a = c0717a;
        c0717a.m3135d();
        this.f1349s.m3580a(c0717a);
        m3189j(true);
        this.f1349s.sendAccessibilityEvent(32);
        return c0717a;
    }

    public void m3168a(float f) {
        ah.m1938f(this.f1347q, f);
    }

    public void m3169a(int i) {
        this.f1327B = i;
    }

    public void m3170a(int i, int i2) {
        int o = this.f1348r.m4550o();
        if ((i2 & 4) != 0) {
            this.f1354x = true;
        }
        this.f1348r.m4536c((o & (i2 ^ -1)) | (i & i2));
    }

    public void m3171a(Configuration configuration) {
        m3161k(C0739a.m3212a(this.f1342l).m3216d());
    }

    public void m3172a(CharSequence charSequence) {
        this.f1348r.m4531a(charSequence);
    }

    public void m3173a(boolean z) {
        m3170a(z ? 4 : 0, 4);
    }

    public void m3174b() {
        if (this.f1329D) {
            this.f1329D = false;
            m3162l(false);
        }
    }

    public void m3175b(boolean z) {
        this.f1348r.m4535b(z);
    }

    public void m3176c() {
        if (!this.f1329D) {
            this.f1329D = true;
            m3162l(false);
        }
    }

    public void m3177c(boolean z) {
        if (!z || this.f1346p.m3613a()) {
            this.f1338d = z;
            this.f1346p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public void m3178d(boolean z) {
        if (!this.f1354x) {
            m3173a(z);
        }
    }

    public boolean m3179d() {
        int m = m3192m();
        return this.f1332G && (m == 0 || m3182f() < m);
    }

    public Context m3180e() {
        if (this.f1343m == null) {
            TypedValue typedValue = new TypedValue();
            this.f1342l.getTheme().resolveAttribute(C0720a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1343m = new ContextThemeWrapper(this.f1342l, i);
            } else {
                this.f1343m = this.f1342l;
            }
        }
        return this.f1343m;
    }

    public void m3181e(boolean z) {
        this.f1334I = z;
        if (!z && this.f1333H != null) {
            this.f1333H.m3275b();
        }
    }

    public int m3182f() {
        return this.f1346p.getActionBarHideOffset();
    }

    public void m3183f(boolean z) {
        if (z != this.f1355y) {
            this.f1355y = z;
            int size = this.f1356z.size();
            for (int i = 0; i < size; i++) {
                ((C0643b) this.f1356z.get(i)).m2810a(z);
            }
        }
    }

    public void m3184g(boolean z) {
        this.f1328C = z;
    }

    public void m3185h(boolean z) {
        if (this.f1333H != null) {
            this.f1333H.m3275b();
        }
        this.f1347q.setVisibility(0);
        if (this.f1327B == 0 && f1325k && (this.f1334I || z)) {
            ah.m1923b(this.f1347q, 0.0f);
            float f = (float) (-this.f1347q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1347q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ah.m1923b(this.f1347q, f);
            C0749h c0749h = new C0749h();
            az c = ah.m1951r(this.f1347q).m2165c(0.0f);
            c.m2160a(this.f1341g);
            c0749h.m3270a(c);
            if (this.f1328C && this.f1350t != null) {
                ah.m1923b(this.f1350t, f);
                c0749h.m3270a(ah.m1951r(this.f1350t).m2165c(0.0f));
            }
            c0749h.m3273a(f1324j);
            c0749h.m3269a(250);
            c0749h.m3272a(this.f1340f);
            this.f1333H = c0749h;
            c0749h.m3274a();
        } else {
            ah.m1927c(this.f1347q, 1.0f);
            ah.m1923b(this.f1347q, 0.0f);
            if (this.f1328C && this.f1350t != null) {
                ah.m1923b(this.f1350t, 0.0f);
            }
            this.f1340f.m537b(null);
        }
        if (this.f1346p != null) {
            ah.m1954u(this.f1346p);
        }
    }

    public boolean m3186h() {
        if (this.f1348r == null || !this.f1348r.m4537c()) {
            return false;
        }
        this.f1348r.m4538d();
        return true;
    }

    public void m3187i(boolean z) {
        if (this.f1333H != null) {
            this.f1333H.m3275b();
        }
        if (this.f1327B == 0 && f1325k && (this.f1334I || z)) {
            ah.m1927c(this.f1347q, 1.0f);
            this.f1347q.setTransitioning(true);
            C0749h c0749h = new C0749h();
            float f = (float) (-this.f1347q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1347q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            az c = ah.m1951r(this.f1347q).m2165c(f);
            c.m2160a(this.f1341g);
            c0749h.m3270a(c);
            if (this.f1328C && this.f1350t != null) {
                c0749h.m3270a(ah.m1951r(this.f1350t).m2165c(f));
            }
            c0749h.m3273a(f1323i);
            c0749h.m3269a(250);
            c0749h.m3272a(this.f1339e);
            this.f1333H = c0749h;
            c0749h.m3274a();
            return;
        }
        this.f1339e.m537b(null);
    }

    public boolean m3188i() {
        ViewGroup a = this.f1348r.m4524a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void m3189j(boolean z) {
        if (z) {
            m3163r();
        } else {
            m3164s();
        }
        if (m3165t()) {
            az a;
            az a2;
            if (z) {
                a = this.f1348r.m4523a(4, 100);
                a2 = this.f1349s.m3579a(0, 200);
            } else {
                a2 = this.f1348r.m4523a(0, 200);
                a = this.f1349s.m3579a(8, 100);
            }
            C0749h c0749h = new C0749h();
            c0749h.m3271a(a, a2);
            c0749h.m3274a();
        } else if (z) {
            this.f1348r.m4539d(4);
            this.f1349s.setVisibility(0);
        } else {
            this.f1348r.m4539d(0);
            this.f1349s.setVisibility(8);
        }
    }

    void m3190k() {
        if (this.f1337c != null) {
            this.f1337c.onDestroyActionMode(this.f1336b);
            this.f1336b = null;
            this.f1337c = null;
        }
    }

    public int m3191l() {
        return this.f1348r.m4551p();
    }

    public int m3192m() {
        return this.f1347q.getHeight();
    }

    public void m3193n() {
        if (this.f1330E) {
            this.f1330E = false;
            m3162l(true);
        }
    }

    public void m3194o() {
        if (!this.f1330E) {
            this.f1330E = true;
            m3162l(true);
        }
    }

    public void m3195p() {
        if (this.f1333H != null) {
            this.f1333H.m3275b();
            this.f1333H = null;
        }
    }

    public void m3196q() {
    }
}
