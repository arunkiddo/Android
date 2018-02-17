package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p016k.C0518e;
import android.support.v4.p016k.C0518e.C0517b;
import android.support.v4.p016k.C0550q.C0549e;
import android.support.v4.p024e.p025a.C0348b;
import android.support.v7.view.menu.C0114p.C0112a;
import android.support.v7.widget.C0951m;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;
import com.simplemobiletools.gallery.BuildConfig;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

/* renamed from: android.support.v7.view.menu.j */
public final class C0772j implements C0348b {
    private static String f1577w;
    private static String f1578x;
    private static String f1579y;
    private static String f1580z;
    private final int f1581a;
    private final int f1582b;
    private final int f1583c;
    private final int f1584d;
    private CharSequence f1585e;
    private CharSequence f1586f;
    private Intent f1587g;
    private char f1588h;
    private char f1589i;
    private Drawable f1590j;
    private int f1591k;
    private C0769h f1592l;
    private C0786u f1593m;
    private Runnable f1594n;
    private OnMenuItemClickListener f1595o;
    private int f1596p;
    private int f1597q;
    private View f1598r;
    private C0518e f1599s;
    private C0549e f1600t;
    private boolean f1601u;
    private ContextMenuInfo f1602v;

    /* renamed from: android.support.v7.view.menu.j.1 */
    class C07711 implements C0517b {
        final /* synthetic */ C0772j f1576a;

        C07711(C0772j c0772j) {
            this.f1576a = c0772j;
        }

        public void m3477a(boolean z) {
            this.f1576a.f1592l.m3436a(this.f1576a);
        }
    }

    C0772j(C0769h c0769h, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1591k = 0;
        this.f1596p = 16;
        this.f1597q = 0;
        this.f1601u = false;
        this.f1592l = c0769h;
        this.f1581a = i2;
        this.f1582b = i;
        this.f1583c = i3;
        this.f1584d = i4;
        this.f1585e = charSequence;
        this.f1597q = i5;
    }

    public C0348b m3479a(int i) {
        Context e = this.f1592l.m3458e();
        m3482a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public C0348b m3480a(C0518e c0518e) {
        if (this.f1599s != null) {
            this.f1599s.m2283f();
        }
        this.f1598r = null;
        this.f1599s = c0518e;
        this.f1592l.m3449b(true);
        if (this.f1599s != null) {
            this.f1599s.m2276a(new C07711(this));
        }
        return this;
    }

    public C0348b m3481a(C0549e c0549e) {
        this.f1600t = c0549e;
        return this;
    }

    public C0348b m3482a(View view) {
        this.f1598r = view;
        this.f1599s = null;
        if (view != null && view.getId() == -1 && this.f1581a > 0) {
            view.setId(this.f1581a);
        }
        this.f1592l.m3447b(this);
        return this;
    }

    public C0518e m3483a() {
        return this.f1599s;
    }

    CharSequence m3484a(C0112a c0112a) {
        return (c0112a == null || !c0112a.m234a()) ? getTitle() : getTitleCondensed();
    }

    public void m3485a(C0786u c0786u) {
        this.f1593m = c0786u;
        c0786u.setHeaderTitle(getTitle());
    }

    void m3486a(ContextMenuInfo contextMenuInfo) {
        this.f1602v = contextMenuInfo;
    }

    public void m3487a(boolean z) {
        this.f1596p = (z ? 4 : 0) | (this.f1596p & -5);
    }

    public C0348b m3488b(int i) {
        setShowAsAction(i);
        return this;
    }

    void m3489b(boolean z) {
        int i = this.f1596p;
        this.f1596p = (z ? 2 : 0) | (this.f1596p & -3);
        if (i != this.f1596p) {
            this.f1592l.m3449b(false);
        }
    }

    public boolean m3490b() {
        if ((this.f1595o != null && this.f1595o.onMenuItemClick(this)) || this.f1592l.m3442a(this.f1592l.m3470p(), (MenuItem) this)) {
            return true;
        }
        if (this.f1594n != null) {
            this.f1594n.run();
            return true;
        }
        if (this.f1587g != null) {
            try {
                this.f1592l.m3458e().startActivity(this.f1587g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        return this.f1599s != null && this.f1599s.m2281d();
    }

    public int m3491c() {
        return this.f1584d;
    }

    boolean m3492c(boolean z) {
        int i = this.f1596p;
        this.f1596p = (z ? 0 : 8) | (this.f1596p & -9);
        return i != this.f1596p;
    }

    public boolean collapseActionView() {
        return (this.f1597q & 8) == 0 ? false : this.f1598r == null ? true : (this.f1600t == null || this.f1600t.m2357b(this)) ? this.f1592l.m3457d(this) : false;
    }

    char m3493d() {
        return this.f1592l.m3450b() ? this.f1589i : this.f1588h;
    }

    public void m3494d(boolean z) {
        if (z) {
            this.f1596p |= 32;
        } else {
            this.f1596p &= -33;
        }
    }

    String m3495e() {
        char d = m3493d();
        if (d == '\u0000') {
            return BuildConfig.FLAVOR;
        }
        StringBuilder stringBuilder = new StringBuilder(f1577w);
        switch (d) {
            case C1373c.Toolbar_contentInsetRight /*8*/:
                stringBuilder.append(f1579y);
                break;
            case C1373c.Toolbar_contentInsetEndWithActions /*10*/:
                stringBuilder.append(f1578x);
                break;
            case C1373c.AppCompatTheme_actionModeCutDrawable /*32*/:
                stringBuilder.append(f1580z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    public void m3496e(boolean z) {
        this.f1601u = z;
        this.f1592l.m3449b(false);
    }

    public boolean expandActionView() {
        return !m3505n() ? false : (this.f1600t == null || this.f1600t.m2356a(this)) ? this.f1592l.m3454c(this) : false;
    }

    boolean m3497f() {
        return this.f1592l.m3453c() && m3493d() != '\u0000';
    }

    public boolean m3498g() {
        return (this.f1596p & 4) != 0;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public View getActionView() {
        if (this.f1598r != null) {
            return this.f1598r;
        }
        if (this.f1599s == null) {
            return null;
        }
        this.f1598r = this.f1599s.m2274a((MenuItem) this);
        return this.f1598r;
    }

    public char getAlphabeticShortcut() {
        return this.f1589i;
    }

    public int getGroupId() {
        return this.f1582b;
    }

    public Drawable getIcon() {
        if (this.f1590j != null) {
            return this.f1590j;
        }
        if (this.f1591k == 0) {
            return null;
        }
        Drawable a = C0951m.m4995a().m5013a(this.f1592l.m3458e(), this.f1591k);
        this.f1591k = 0;
        this.f1590j = a;
        return a;
    }

    public Intent getIntent() {
        return this.f1587g;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1581a;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1602v;
    }

    public char getNumericShortcut() {
        return this.f1588h;
    }

    public int getOrder() {
        return this.f1583c;
    }

    public SubMenu getSubMenu() {
        return this.f1593m;
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1585e;
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1586f != null ? this.f1586f : this.f1585e;
        return (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) ? charSequence : charSequence.toString();
    }

    public void m3499h() {
        this.f1592l.m3447b(this);
    }

    public boolean hasSubMenu() {
        return this.f1593m != null;
    }

    public boolean m3500i() {
        return this.f1592l.m3471q();
    }

    public boolean isActionViewExpanded() {
        return this.f1601u;
    }

    public boolean isCheckable() {
        return (this.f1596p & 1) == 1;
    }

    public boolean isChecked() {
        return (this.f1596p & 2) == 2;
    }

    public boolean isEnabled() {
        return (this.f1596p & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1599s == null || !this.f1599s.m2279b()) ? (this.f1596p & 8) == 0 : (this.f1596p & 8) == 0 && this.f1599s.m2280c();
    }

    public boolean m3501j() {
        return (this.f1596p & 32) == 32;
    }

    public boolean m3502k() {
        return (this.f1597q & 1) == 1;
    }

    public boolean m3503l() {
        return (this.f1597q & 2) == 2;
    }

    public boolean m3504m() {
        return (this.f1597q & 4) == 4;
    }

    public boolean m3505n() {
        if ((this.f1597q & 8) == 0) {
            return false;
        }
        if (this.f1598r == null && this.f1599s != null) {
            this.f1598r = this.f1599s.m2274a((MenuItem) this);
        }
        return this.f1598r != null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3479a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3482a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1589i != c) {
            this.f1589i = Character.toLowerCase(c);
            this.f1592l.m3449b(false);
        }
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1596p;
        this.f1596p = (z ? 1 : 0) | (this.f1596p & -2);
        if (i != this.f1596p) {
            this.f1592l.m3449b(false);
        }
        return this;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1596p & 4) != 0) {
            this.f1592l.m3439a((MenuItem) this);
        } else {
            m3489b(z);
        }
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1596p |= 16;
        } else {
            this.f1596p &= -17;
        }
        this.f1592l.m3449b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1590j = null;
        this.f1591k = i;
        this.f1592l.m3449b(false);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1591k = 0;
        this.f1590j = drawable;
        this.f1592l.m3449b(false);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1587g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1588h != c) {
            this.f1588h = c;
            this.f1592l.m3449b(false);
        }
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1595o = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1588h = c;
        this.f1589i = Character.toLowerCase(c2);
        this.f1592l.m3449b(false);
        return this;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case C1373c.View_android_theme /*0*/:
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingStart /*2*/:
                this.f1597q = i;
                this.f1592l.m3447b(this);
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3488b(i);
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f1592l.m3458e().getString(i));
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1585e = charSequence;
        this.f1592l.m3449b(false);
        if (this.f1593m != null) {
            this.f1593m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1586f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1585e;
        }
        this.f1592l.m3449b(false);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        if (m3492c(z)) {
            this.f1592l.m3436a(this);
        }
        return this;
    }

    public String toString() {
        return this.f1585e != null ? this.f1585e.toString() : null;
    }
}
