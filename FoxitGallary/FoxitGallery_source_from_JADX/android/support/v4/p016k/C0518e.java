package android.support.v4.p016k;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v4.k.e */
public abstract class C0518e {
    private final Context f844a;
    private C0516a f845b;
    private C0517b f846c;

    /* renamed from: android.support.v4.k.e.a */
    public interface C0516a {
        void m2271a(boolean z);
    }

    /* renamed from: android.support.v4.k.e.b */
    public interface C0517b {
        void m2272a(boolean z);
    }

    public C0518e(Context context) {
        this.f844a = context;
    }

    public abstract View m2273a();

    public View m2274a(MenuItem menuItem) {
        return m2273a();
    }

    public void m2275a(C0516a c0516a) {
        this.f845b = c0516a;
    }

    public void m2276a(C0517b c0517b) {
        if (!(this.f846c == null || c0517b == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f846c = c0517b;
    }

    public void m2277a(SubMenu subMenu) {
    }

    public void m2278a(boolean z) {
        if (this.f845b != null) {
            this.f845b.m2271a(z);
        }
    }

    public boolean m2279b() {
        return false;
    }

    public boolean m2280c() {
        return true;
    }

    public boolean m2281d() {
        return false;
    }

    public boolean m2282e() {
        return false;
    }

    public void m2283f() {
        this.f846c = null;
        this.f845b = null;
    }
}
