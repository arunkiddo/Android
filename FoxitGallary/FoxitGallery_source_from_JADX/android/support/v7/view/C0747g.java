package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.p016k.C0518e;
import android.support.v4.p016k.C0550q;
import android.support.v4.p024e.p025a.C0347a;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.menu.C0772j;
import android.support.v7.view.menu.C0777k;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.view.g */
public class C0747g extends MenuInflater {
    private static final Class<?>[] f1410a;
    private static final Class<?>[] f1411b;
    private final Object[] f1412c;
    private final Object[] f1413d;
    private Context f1414e;
    private Object f1415f;

    /* renamed from: android.support.v7.view.g.a */
    private static class C0745a implements OnMenuItemClickListener {
        private static final Class<?>[] f1381a;
        private Object f1382b;
        private Method f1383c;

        static {
            f1381a = new Class[]{MenuItem.class};
        }

        public C0745a(Object obj, String str) {
            this.f1382b = obj;
            Class cls = obj.getClass();
            try {
                this.f1383c = cls.getMethod(str, f1381a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1383c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1383c.invoke(this.f1382b, new Object[]{menuItem})).booleanValue();
                }
                this.f1383c.invoke(this.f1382b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* renamed from: android.support.v7.view.g.b */
    private class C0746b {
        final /* synthetic */ C0747g f1384a;
        private Menu f1385b;
        private int f1386c;
        private int f1387d;
        private int f1388e;
        private int f1389f;
        private boolean f1390g;
        private boolean f1391h;
        private boolean f1392i;
        private int f1393j;
        private int f1394k;
        private CharSequence f1395l;
        private CharSequence f1396m;
        private int f1397n;
        private char f1398o;
        private char f1399p;
        private int f1400q;
        private boolean f1401r;
        private boolean f1402s;
        private boolean f1403t;
        private int f1404u;
        private int f1405v;
        private String f1406w;
        private String f1407x;
        private String f1408y;
        private C0518e f1409z;

        public C0746b(C0747g c0747g, Menu menu) {
            this.f1384a = c0747g;
            this.f1385b = menu;
            m3247a();
        }

        private char m3243a(String str) {
            return str == null ? '\u0000' : str.charAt(0);
        }

        private <T> T m3245a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.f1384a.f1414e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }

        private void m3246a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f1401r).setVisible(this.f1402s).setEnabled(this.f1403t).setCheckable(this.f1400q >= 1).setTitleCondensed(this.f1396m).setIcon(this.f1397n).setAlphabeticShortcut(this.f1398o).setNumericShortcut(this.f1399p);
            if (this.f1404u >= 0) {
                C0550q.m2361a(menuItem, this.f1404u);
            }
            if (this.f1408y != null) {
                if (this.f1384a.f1414e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0745a(this.f1384a.m3259c(), this.f1408y));
            }
            if (menuItem instanceof C0772j) {
                C0772j c0772j = (C0772j) menuItem;
            }
            if (this.f1400q >= 2) {
                if (menuItem instanceof C0772j) {
                    ((C0772j) menuItem).m3487a(true);
                } else if (menuItem instanceof C0777k) {
                    ((C0777k) menuItem).m3516a(true);
                }
            }
            if (this.f1406w != null) {
                C0550q.m2359a(menuItem, (View) m3245a(this.f1406w, C0747g.f1410a, this.f1384a.f1412c));
            } else {
                z = false;
            }
            if (this.f1405v > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    C0550q.m2362b(menuItem, this.f1405v);
                }
            }
            if (this.f1409z != null) {
                C0550q.m2358a(menuItem, this.f1409z);
            }
        }

        public void m3247a() {
            this.f1386c = 0;
            this.f1387d = 0;
            this.f1388e = 0;
            this.f1389f = 0;
            this.f1390g = true;
            this.f1391h = true;
        }

        public void m3248a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.f1384a.f1414e.obtainStyledAttributes(attributeSet, C0729j.MenuGroup);
            this.f1386c = obtainStyledAttributes.getResourceId(C0729j.MenuGroup_android_id, 0);
            this.f1387d = obtainStyledAttributes.getInt(C0729j.MenuGroup_android_menuCategory, 0);
            this.f1388e = obtainStyledAttributes.getInt(C0729j.MenuGroup_android_orderInCategory, 0);
            this.f1389f = obtainStyledAttributes.getInt(C0729j.MenuGroup_android_checkableBehavior, 0);
            this.f1390g = obtainStyledAttributes.getBoolean(C0729j.MenuGroup_android_visible, true);
            this.f1391h = obtainStyledAttributes.getBoolean(C0729j.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void m3249b() {
            this.f1392i = true;
            m3246a(this.f1385b.add(this.f1386c, this.f1393j, this.f1394k, this.f1395l));
        }

        public void m3250b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.f1384a.f1414e.obtainStyledAttributes(attributeSet, C0729j.MenuItem);
            this.f1393j = obtainStyledAttributes.getResourceId(C0729j.MenuItem_android_id, 0);
            this.f1394k = (obtainStyledAttributes.getInt(C0729j.MenuItem_android_menuCategory, this.f1387d) & -65536) | (obtainStyledAttributes.getInt(C0729j.MenuItem_android_orderInCategory, this.f1388e) & 65535);
            this.f1395l = obtainStyledAttributes.getText(C0729j.MenuItem_android_title);
            this.f1396m = obtainStyledAttributes.getText(C0729j.MenuItem_android_titleCondensed);
            this.f1397n = obtainStyledAttributes.getResourceId(C0729j.MenuItem_android_icon, 0);
            this.f1398o = m3243a(obtainStyledAttributes.getString(C0729j.MenuItem_android_alphabeticShortcut));
            this.f1399p = m3243a(obtainStyledAttributes.getString(C0729j.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C0729j.MenuItem_android_checkable)) {
                this.f1400q = obtainStyledAttributes.getBoolean(C0729j.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1400q = this.f1389f;
            }
            this.f1401r = obtainStyledAttributes.getBoolean(C0729j.MenuItem_android_checked, false);
            this.f1402s = obtainStyledAttributes.getBoolean(C0729j.MenuItem_android_visible, this.f1390g);
            this.f1403t = obtainStyledAttributes.getBoolean(C0729j.MenuItem_android_enabled, this.f1391h);
            this.f1404u = obtainStyledAttributes.getInt(C0729j.MenuItem_showAsAction, -1);
            this.f1408y = obtainStyledAttributes.getString(C0729j.MenuItem_android_onClick);
            this.f1405v = obtainStyledAttributes.getResourceId(C0729j.MenuItem_actionLayout, 0);
            this.f1406w = obtainStyledAttributes.getString(C0729j.MenuItem_actionViewClass);
            this.f1407x = obtainStyledAttributes.getString(C0729j.MenuItem_actionProviderClass);
            if (this.f1407x == null) {
                z = false;
            }
            if (z && this.f1405v == 0 && this.f1406w == null) {
                this.f1409z = (C0518e) m3245a(this.f1407x, C0747g.f1411b, this.f1384a.f1413d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1409z = null;
            }
            obtainStyledAttributes.recycle();
            this.f1392i = false;
        }

        public SubMenu m3251c() {
            this.f1392i = true;
            SubMenu addSubMenu = this.f1385b.addSubMenu(this.f1386c, this.f1393j, this.f1394k, this.f1395l);
            m3246a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean m3252d() {
            return this.f1392i;
        }
    }

    static {
        f1410a = new Class[]{Context.class};
        f1411b = f1410a;
    }

    public C0747g(Context context) {
        super(context);
        this.f1414e = context;
        this.f1412c = new Object[]{context};
        this.f1413d = this.f1412c;
    }

    private Object m3254a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? m3254a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3255a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.g$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00e1;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d9;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.m3248a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.m3250b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.m3251c();
        r10.m3255a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.m3247a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00cd;
    L_0x00ab:
        r3 = r7.m3252d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.f1409z;
        if (r3 == 0) goto L_0x00c7;
    L_0x00b7:
        r3 = r7.f1409z;
        r3 = r3.m2282e();
        if (r3 == 0) goto L_0x00c7;
    L_0x00c1:
        r7.m3251c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c7:
        r7.m3249b();
        r3 = r5;
        goto L_0x0029;
    L_0x00cd:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d5:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d9:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    private Object m3259c() {
        if (this.f1415f == null) {
            this.f1415f = m3254a(this.f1414e);
        }
        return this.f1415f;
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof C0347a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.f1414e.getResources().getLayout(i);
                m3255a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }
}
