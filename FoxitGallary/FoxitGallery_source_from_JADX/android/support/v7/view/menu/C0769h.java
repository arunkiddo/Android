package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.p016k.C0518e;
import android.support.v4.p016k.C0550q;
import android.support.v4.p022c.C0225a;
import android.support.v4.p024e.p025a.C0347a;
import android.support.v7.p034b.C0730a.C0721b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: android.support.v7.view.menu.h */
public class C0769h implements C0347a {
    private static final int[] f1547d;
    CharSequence f1548a;
    Drawable f1549b;
    View f1550c;
    private final Context f1551e;
    private final Resources f1552f;
    private boolean f1553g;
    private boolean f1554h;
    private C0676a f1555i;
    private ArrayList<C0772j> f1556j;
    private ArrayList<C0772j> f1557k;
    private boolean f1558l;
    private ArrayList<C0772j> f1559m;
    private ArrayList<C0772j> f1560n;
    private boolean f1561o;
    private int f1562p;
    private ContextMenuInfo f1563q;
    private boolean f1564r;
    private boolean f1565s;
    private boolean f1566t;
    private boolean f1567u;
    private ArrayList<C0772j> f1568v;
    private CopyOnWriteArrayList<WeakReference<C0755o>> f1569w;
    private C0772j f1570x;
    private boolean f1571y;

    /* renamed from: android.support.v7.view.menu.h.a */
    public interface C0676a {
        void m2944a(C0769h c0769h);

        boolean m2945a(C0769h c0769h, MenuItem menuItem);
    }

    /* renamed from: android.support.v7.view.menu.h.b */
    public interface C0753b {
        boolean m3303a(C0772j c0772j);
    }

    static {
        f1547d = new int[]{1, 4, 5, 3, 2, 0};
    }

    public C0769h(Context context) {
        this.f1562p = 0;
        this.f1564r = false;
        this.f1565s = false;
        this.f1566t = false;
        this.f1567u = false;
        this.f1568v = new ArrayList();
        this.f1569w = new CopyOnWriteArrayList();
        this.f1551e = context;
        this.f1552f = context.getResources();
        this.f1556j = new ArrayList();
        this.f1557k = new ArrayList();
        this.f1558l = true;
        this.f1559m = new ArrayList();
        this.f1560n = new ArrayList();
        this.f1561o = true;
        m3424e(true);
    }

    private static int m3418a(ArrayList<C0772j> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0772j) arrayList.get(size)).m3491c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    private C0772j m3419a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0772j(this, i, i2, i3, i4, charSequence, i5);
    }

    private void m3420a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m3455d();
        if (view != null) {
            this.f1550c = view;
            this.f1548a = null;
            this.f1549b = null;
        } else {
            if (i > 0) {
                this.f1548a = d.getText(i);
            } else if (charSequence != null) {
                this.f1548a = charSequence;
            }
            if (i2 > 0) {
                this.f1549b = C0225a.m808a(m3458e(), i2);
            } else if (drawable != null) {
                this.f1549b = drawable;
            }
            this.f1550c = null;
        }
        m3449b(false);
    }

    private void m3421a(int i, boolean z) {
        if (i >= 0 && i < this.f1556j.size()) {
            this.f1556j.remove(i);
            if (z) {
                m3449b(true);
            }
        }
    }

    private boolean m3422a(C0786u c0786u, C0755o c0755o) {
        boolean z = false;
        if (this.f1569w.isEmpty()) {
            return false;
        }
        if (c0755o != null) {
            z = c0755o.m3322a(c0786u);
        }
        Iterator it = this.f1569w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0755o c0755o2 = (C0755o) weakReference.get();
            if (c0755o2 == null) {
                this.f1569w.remove(weakReference);
                z = z2;
            } else {
                z = !z2 ? c0755o2.m3322a(c0786u) : z2;
            }
            z2 = z;
        }
        return z2;
    }

    private void m3423d(boolean z) {
        if (!this.f1569w.isEmpty()) {
            m3461g();
            Iterator it = this.f1569w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0755o c0755o = (C0755o) weakReference.get();
                if (c0755o == null) {
                    this.f1569w.remove(weakReference);
                } else {
                    c0755o.m3323b(z);
                }
            }
            m3462h();
        }
    }

    private void m3424e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f1552f.getConfiguration().keyboard != 1 && this.f1552f.getBoolean(C0721b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f1554h = z2;
    }

    private static int m3425f(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1547d.length) {
            return (f1547d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public int m3426a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0772j) this.f1556j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public C0769h m3427a(int i) {
        this.f1562p = i;
        return this;
    }

    protected C0769h m3428a(Drawable drawable) {
        m3420a(0, null, 0, drawable, null);
        return this;
    }

    protected C0769h m3429a(View view) {
        m3420a(0, null, 0, null, view);
        return this;
    }

    protected C0769h m3430a(CharSequence charSequence) {
        m3420a(0, charSequence, 0, null, null);
        return this;
    }

    C0772j m3431a(int i, KeyEvent keyEvent) {
        List list = this.f1568v;
        list.clear();
        m3440a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0772j) list.get(0);
        }
        boolean b = m3450b();
        for (int i2 = 0; i2 < size; i2++) {
            C0772j c0772j = (C0772j) list.get(i2);
            char alphabeticShortcut = b ? c0772j.getAlphabeticShortcut() : c0772j.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0772j;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0772j;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0772j;
            }
        }
        return null;
    }

    protected MenuItem m3432a(int i, int i2, int i3, CharSequence charSequence) {
        int f = C0769h.m3425f(i3);
        MenuItem a = m3419a(i, i2, i3, f, charSequence, this.f1562p);
        if (this.f1563q != null) {
            a.m3486a(this.f1563q);
        }
        this.f1556j.add(C0769h.m3418a(this.f1556j, f), a);
        m3449b(true);
        return a;
    }

    protected String m3433a() {
        return "android:menu:actionviewstates";
    }

    public void m3434a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = C0550q.m2360a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (C0550q.m2364c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((C0786u) item.getSubMenu()).m3434a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(m3433a(), sparseArray);
        }
    }

    public void m3435a(C0676a c0676a) {
        this.f1555i = c0676a;
    }

    void m3436a(C0772j c0772j) {
        this.f1558l = true;
        m3449b(true);
    }

    public void m3437a(C0755o c0755o) {
        m3438a(c0755o, this.f1551e);
    }

    public void m3438a(C0755o c0755o, Context context) {
        this.f1569w.add(new WeakReference(c0755o));
        c0755o.m3318a(context, this);
        this.f1561o = true;
    }

    void m3439a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1556j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0772j) this.f1556j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m3498g() && menuItem2.isCheckable()) {
                menuItem2.m3489b(menuItem2 == menuItem);
            }
        }
    }

    void m3440a(List<C0772j> list, int i, KeyEvent keyEvent) {
        boolean b = m3450b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1556j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0772j c0772j = (C0772j) this.f1556j.get(i2);
                if (c0772j.hasSubMenu()) {
                    ((C0769h) c0772j.getSubMenu()).m3440a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0772j.getAlphabeticShortcut() : c0772j.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0772j.isEnabled())) {
                    list.add(c0772j);
                }
            }
        }
    }

    public final void m3441a(boolean z) {
        if (!this.f1567u) {
            this.f1567u = true;
            Iterator it = this.f1569w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0755o c0755o = (C0755o) weakReference.get();
                if (c0755o == null) {
                    this.f1569w.remove(weakReference);
                } else {
                    c0755o.m3319a(this, z);
                }
            }
            this.f1567u = false;
        }
    }

    boolean m3442a(C0769h c0769h, MenuItem menuItem) {
        return this.f1555i != null && this.f1555i.m2945a(c0769h, menuItem);
    }

    public boolean m3443a(MenuItem menuItem, int i) {
        return m3444a(menuItem, null, i);
    }

    public boolean m3444a(MenuItem menuItem, C0755o c0755o, int i) {
        C0772j c0772j = (C0772j) menuItem;
        if (c0772j == null || !c0772j.isEnabled()) {
            return false;
        }
        boolean b = c0772j.m3490b();
        C0518e a = c0772j.m3483a();
        boolean z = a != null && a.m2282e();
        boolean expandActionView;
        if (c0772j.m3505n()) {
            expandActionView = c0772j.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m3441a(true);
            return expandActionView;
        } else if (c0772j.hasSubMenu() || z) {
            if (!c0772j.hasSubMenu()) {
                c0772j.m3485a(new C0786u(m3458e(), this, c0772j));
            }
            C0786u c0786u = (C0786u) c0772j.getSubMenu();
            if (z) {
                a.m2277a((SubMenu) c0786u);
            }
            expandActionView = m3422a(c0786u, c0755o) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m3441a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m3441a(true);
            }
            return b;
        }
    }

    public MenuItem add(int i) {
        return m3432a(0, 0, 0, this.f1552f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m3432a(i, i2, i3, this.f1552f.getString(i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m3432a(i, i2, i3, charSequence);
    }

    public MenuItem add(CharSequence charSequence) {
        return m3432a(0, 0, 0, charSequence);
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1551e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            Intent intent2 = new Intent(resolveInfo.specificIndex < 0 ? intent : intentArr[resolveInfo.specificIndex]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent3;
            }
        }
        return size;
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1552f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1552f.getString(i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0772j c0772j = (C0772j) m3432a(i, i2, i3, charSequence);
        C0786u c0786u = new C0786u(this.f1551e, this, c0772j);
        c0772j.m3485a(c0786u);
        return c0786u;
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public int m3445b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0772j) this.f1556j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public void m3446b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(m3433a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = C0550q.m2360a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C0786u) item.getSubMenu()).m3446b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    C0550q.m2363b(item);
                }
            }
        }
    }

    void m3447b(C0772j c0772j) {
        this.f1561o = true;
        m3449b(true);
    }

    public void m3448b(C0755o c0755o) {
        Iterator it = this.f1569w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0755o c0755o2 = (C0755o) weakReference.get();
            if (c0755o2 == null || c0755o2 == c0755o) {
                this.f1569w.remove(weakReference);
            }
        }
    }

    public void m3449b(boolean z) {
        if (this.f1564r) {
            this.f1565s = true;
            return;
        }
        if (z) {
            this.f1558l = true;
            this.f1561o = true;
        }
        m3423d(z);
    }

    boolean m3450b() {
        return this.f1553g;
    }

    public int m3451c(int i) {
        return m3426a(i, 0);
    }

    public void m3452c(boolean z) {
        this.f1571y = z;
    }

    public boolean m3453c() {
        return this.f1554h;
    }

    public boolean m3454c(C0772j c0772j) {
        boolean z = false;
        if (!this.f1569w.isEmpty()) {
            m3461g();
            Iterator it = this.f1569w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0755o c0755o = (C0755o) weakReference.get();
                if (c0755o == null) {
                    this.f1569w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0755o.m3321a(this, c0772j);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3462h();
            if (z) {
                this.f1570x = c0772j;
            }
        }
        return z;
    }

    public void clear() {
        if (this.f1570x != null) {
            m3457d(this.f1570x);
        }
        this.f1556j.clear();
        m3449b(true);
    }

    public void clearHeader() {
        this.f1549b = null;
        this.f1548a = null;
        this.f1550c = null;
        m3449b(false);
    }

    public void close() {
        m3441a(true);
    }

    Resources m3455d() {
        return this.f1552f;
    }

    protected C0769h m3456d(int i) {
        m3420a(i, null, 0, null, null);
        return this;
    }

    public boolean m3457d(C0772j c0772j) {
        boolean z = false;
        if (!this.f1569w.isEmpty() && this.f1570x == c0772j) {
            m3461g();
            Iterator it = this.f1569w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0755o c0755o = (C0755o) weakReference.get();
                if (c0755o == null) {
                    this.f1569w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0755o.m3325b(this, c0772j);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3462h();
            if (z) {
                this.f1570x = null;
            }
        }
        return z;
    }

    public Context m3458e() {
        return this.f1551e;
    }

    protected C0769h m3459e(int i) {
        m3420a(0, null, i, null, null);
        return this;
    }

    public void m3460f() {
        if (this.f1555i != null) {
            this.f1555i.m2944a(this);
        }
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0772j c0772j = (C0772j) this.f1556j.get(i2);
            if (c0772j.getItemId() == i) {
                return c0772j;
            }
            if (c0772j.hasSubMenu()) {
                MenuItem findItem = c0772j.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public void m3461g() {
        if (!this.f1564r) {
            this.f1564r = true;
            this.f1565s = false;
        }
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1556j.get(i);
    }

    public void m3462h() {
        this.f1564r = false;
        if (this.f1565s) {
            this.f1565s = false;
            m3449b(true);
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1571y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0772j) this.f1556j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<C0772j> m3463i() {
        if (!this.f1558l) {
            return this.f1557k;
        }
        this.f1557k.clear();
        int size = this.f1556j.size();
        for (int i = 0; i < size; i++) {
            C0772j c0772j = (C0772j) this.f1556j.get(i);
            if (c0772j.isVisible()) {
                this.f1557k.add(c0772j);
            }
        }
        this.f1558l = false;
        this.f1561o = true;
        return this.f1557k;
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3431a(i, keyEvent) != null;
    }

    public void m3464j() {
        ArrayList i = m3463i();
        if (this.f1561o) {
            Iterator it = this.f1569w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0755o c0755o = (C0755o) weakReference.get();
                if (c0755o == null) {
                    this.f1569w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0755o.m3324b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f1559m.clear();
                this.f1560n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0772j c0772j = (C0772j) i.get(i4);
                    if (c0772j.m3501j()) {
                        this.f1559m.add(c0772j);
                    } else {
                        this.f1560n.add(c0772j);
                    }
                }
            } else {
                this.f1559m.clear();
                this.f1560n.clear();
                this.f1560n.addAll(m3463i());
            }
            this.f1561o = false;
        }
    }

    public ArrayList<C0772j> m3465k() {
        m3464j();
        return this.f1559m;
    }

    public ArrayList<C0772j> m3466l() {
        m3464j();
        return this.f1560n;
    }

    public CharSequence m3467m() {
        return this.f1548a;
    }

    public Drawable m3468n() {
        return this.f1549b;
    }

    public View m3469o() {
        return this.f1550c;
    }

    public C0769h m3470p() {
        return this;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m3443a(findItem(i), i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m3431a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m3443a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m3441a(true);
        }
        return z;
    }

    boolean m3471q() {
        return this.f1566t;
    }

    public C0772j m3472r() {
        return this.f1570x;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void removeGroup(int r6) {
        /*
        r5 = this;
        r1 = 0;
        r3 = r5.m3451c(r6);
        if (r3 < 0) goto L_0x002b;
    L_0x0007:
        r0 = r5.f1556j;
        r0 = r0.size();
        r4 = r0 - r3;
        r0 = r1;
    L_0x0010:
        r2 = r0 + 1;
        if (r0 >= r4) goto L_0x0027;
    L_0x0014:
        r0 = r5.f1556j;
        r0 = r0.get(r3);
        r0 = (android.support.v7.view.menu.C0772j) r0;
        r0 = r0.getGroupId();
        if (r0 != r6) goto L_0x0027;
    L_0x0022:
        r5.m3421a(r3, r1);
        r0 = r2;
        goto L_0x0010;
    L_0x0027:
        r0 = 1;
        r5.m3449b(r0);
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.menu.h.removeGroup(int):void");
    }

    public void removeItem(int i) {
        m3421a(m3445b(i), true);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1556j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0772j c0772j = (C0772j) this.f1556j.get(i2);
            if (c0772j.getGroupId() == i) {
                c0772j.m3487a(z2);
                c0772j.setCheckable(z);
            }
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1556j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0772j c0772j = (C0772j) this.f1556j.get(i2);
            if (c0772j.getGroupId() == i) {
                c0772j.setEnabled(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1556j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            C0772j c0772j = (C0772j) this.f1556j.get(i2);
            boolean z3 = (c0772j.getGroupId() == i && c0772j.m3492c(z)) ? true : z2;
            i2++;
            z2 = z3;
        }
        if (z2) {
            m3449b(true);
        }
    }

    public void setQwertyMode(boolean z) {
        this.f1553g = z;
        m3449b(false);
    }

    public int size() {
        return this.f1556j.size();
    }
}
