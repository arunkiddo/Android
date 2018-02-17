package android.support.v4.p016k;

import android.os.Build.VERSION;
import android.support.v4.p024e.p025a.C0348b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v4.k.q */
public final class C0550q {
    static final C0545d f854a;

    /* renamed from: android.support.v4.k.q.d */
    interface C0545d {
        MenuItem m2336a(MenuItem menuItem, View view);

        View m2337a(MenuItem menuItem);

        void m2338a(MenuItem menuItem, int i);

        MenuItem m2339b(MenuItem menuItem, int i);

        boolean m2340b(MenuItem menuItem);

        boolean m2341c(MenuItem menuItem);
    }

    /* renamed from: android.support.v4.k.q.a */
    static class C0546a implements C0545d {
        C0546a() {
        }

        public MenuItem m2342a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public View m2343a(MenuItem menuItem) {
            return null;
        }

        public void m2344a(MenuItem menuItem, int i) {
        }

        public MenuItem m2345b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public boolean m2346b(MenuItem menuItem) {
            return false;
        }

        public boolean m2347c(MenuItem menuItem) {
            return false;
        }
    }

    /* renamed from: android.support.v4.k.q.b */
    static class C0547b implements C0545d {
        C0547b() {
        }

        public MenuItem m2348a(MenuItem menuItem, View view) {
            return C0551r.m2365a(menuItem, view);
        }

        public View m2349a(MenuItem menuItem) {
            return C0551r.m2366a(menuItem);
        }

        public void m2350a(MenuItem menuItem, int i) {
            C0551r.m2367a(menuItem, i);
        }

        public MenuItem m2351b(MenuItem menuItem, int i) {
            return C0551r.m2368b(menuItem, i);
        }

        public boolean m2352b(MenuItem menuItem) {
            return false;
        }

        public boolean m2353c(MenuItem menuItem) {
            return false;
        }
    }

    /* renamed from: android.support.v4.k.q.c */
    static class C0548c extends C0547b {
        C0548c() {
        }

        public boolean m2354b(MenuItem menuItem) {
            return C0552s.m2369a(menuItem);
        }

        public boolean m2355c(MenuItem menuItem) {
            return C0552s.m2370b(menuItem);
        }
    }

    /* renamed from: android.support.v4.k.q.e */
    public interface C0549e {
        boolean m2356a(MenuItem menuItem);

        boolean m2357b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f854a = new C0548c();
        } else if (i >= 11) {
            f854a = new C0547b();
        } else {
            f854a = new C0546a();
        }
    }

    public static MenuItem m2358a(MenuItem menuItem, C0518e c0518e) {
        if (menuItem instanceof C0348b) {
            return ((C0348b) menuItem).m1321a(c0518e);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static MenuItem m2359a(MenuItem menuItem, View view) {
        return menuItem instanceof C0348b ? ((C0348b) menuItem).setActionView(view) : f854a.m2336a(menuItem, view);
    }

    public static View m2360a(MenuItem menuItem) {
        return menuItem instanceof C0348b ? ((C0348b) menuItem).getActionView() : f854a.m2337a(menuItem);
    }

    public static void m2361a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0348b) {
            ((C0348b) menuItem).setShowAsAction(i);
        } else {
            f854a.m2338a(menuItem, i);
        }
    }

    public static MenuItem m2362b(MenuItem menuItem, int i) {
        return menuItem instanceof C0348b ? ((C0348b) menuItem).setActionView(i) : f854a.m2339b(menuItem, i);
    }

    public static boolean m2363b(MenuItem menuItem) {
        return menuItem instanceof C0348b ? ((C0348b) menuItem).expandActionView() : f854a.m2340b(menuItem);
    }

    public static boolean m2364c(MenuItem menuItem) {
        return menuItem instanceof C0348b ? ((C0348b) menuItem).isActionViewExpanded() : f854a.m2341c(menuItem);
    }
}
