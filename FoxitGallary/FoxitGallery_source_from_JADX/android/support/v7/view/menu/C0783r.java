package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.p024e.p025a.C0347a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

/* renamed from: android.support.v7.view.menu.r */
class C0783r extends C0758c<C0347a> implements Menu {
    C0783r(Context context, C0347a c0347a) {
        super(context, c0347a);
    }

    public MenuItem add(int i) {
        return m3343a(((C0347a) this.b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m3343a(((C0347a) this.b).add(i, i2, i3, i4));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m3343a(((C0347a) this.b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(CharSequence charSequence) {
        return m3343a(((C0347a) this.b).add(charSequence));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((C0347a) this.b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m3343a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public SubMenu addSubMenu(int i) {
        return m3344a(((C0347a) this.b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m3344a(((C0347a) this.b).addSubMenu(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m3344a(((C0347a) this.b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m3344a(((C0347a) this.b).addSubMenu(charSequence));
    }

    public void clear() {
        m3345a();
        ((C0347a) this.b).clear();
    }

    public void close() {
        ((C0347a) this.b).close();
    }

    public MenuItem findItem(int i) {
        return m3343a(((C0347a) this.b).findItem(i));
    }

    public MenuItem getItem(int i) {
        return m3343a(((C0347a) this.b).getItem(i));
    }

    public boolean hasVisibleItems() {
        return ((C0347a) this.b).hasVisibleItems();
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((C0347a) this.b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((C0347a) this.b).performIdentifierAction(i, i2);
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((C0347a) this.b).performShortcut(i, keyEvent, i2);
    }

    public void removeGroup(int i) {
        m3346a(i);
        ((C0347a) this.b).removeGroup(i);
    }

    public void removeItem(int i) {
        m3347b(i);
        ((C0347a) this.b).removeItem(i);
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((C0347a) this.b).setGroupCheckable(i, z, z2);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((C0347a) this.b).setGroupEnabled(i, z);
    }

    public void setGroupVisible(int i, boolean z) {
        ((C0347a) this.b).setGroupVisible(i, z);
    }

    public void setQwertyMode(boolean z) {
        ((C0347a) this.b).setQwertyMode(z);
    }

    public int size() {
        return ((C0347a) this.b).size();
    }
}
