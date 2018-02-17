package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.C0518e;
import android.support.v4.p016k.C0550q.C0549e;
import android.support.v4.p024e.p025a.C0348b;
import android.support.v7.view.C0740c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
/* renamed from: android.support.v7.view.menu.k */
public class C0777k extends C0758c<C0348b> implements MenuItem {
    private Method f1608c;

    /* renamed from: android.support.v7.view.menu.k.a */
    class C0773a extends C0518e {
        final ActionProvider f1603a;
        final /* synthetic */ C0777k f1604b;

        public C0773a(C0777k c0777k, Context context, ActionProvider actionProvider) {
            this.f1604b = c0777k;
            super(context);
            this.f1603a = actionProvider;
        }

        public View m3506a() {
            return this.f1603a.onCreateActionView();
        }

        public void m3507a(SubMenu subMenu) {
            this.f1603a.onPrepareSubMenu(this.f1604b.m3344a(subMenu));
        }

        public boolean m3508d() {
            return this.f1603a.onPerformDefaultAction();
        }

        public boolean m3509e() {
            return this.f1603a.hasSubMenu();
        }
    }

    /* renamed from: android.support.v7.view.menu.k.b */
    static class C0774b extends FrameLayout implements C0740c {
        final CollapsibleActionView f1605a;

        C0774b(View view) {
            super(view.getContext());
            this.f1605a = (CollapsibleActionView) view;
            addView(view);
        }

        public void m3510a() {
            this.f1605a.onActionViewExpanded();
        }

        public void m3511b() {
            this.f1605a.onActionViewCollapsed();
        }

        View m3512c() {
            return (View) this.f1605a;
        }
    }

    /* renamed from: android.support.v7.view.menu.k.c */
    private class C0775c extends C0757d<OnActionExpandListener> implements C0549e {
        final /* synthetic */ C0777k f1606a;

        C0775c(C0777k c0777k, OnActionExpandListener onActionExpandListener) {
            this.f1606a = c0777k;
            super(onActionExpandListener);
        }

        public boolean m3513a(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f1606a.m3343a(menuItem));
        }

        public boolean m3514b(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f1606a.m3343a(menuItem));
        }
    }

    /* renamed from: android.support.v7.view.menu.k.d */
    private class C0776d extends C0757d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ C0777k f1607a;

        C0776d(C0777k c0777k, OnMenuItemClickListener onMenuItemClickListener) {
            this.f1607a = c0777k;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f1607a.m3343a(menuItem));
        }
    }

    C0777k(Context context, C0348b c0348b) {
        super(context, c0348b);
    }

    C0773a m3515a(ActionProvider actionProvider) {
        return new C0773a(this, this.a, actionProvider);
    }

    public void m3516a(boolean z) {
        try {
            if (this.f1608c == null) {
                this.f1608c = ((C0348b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1608c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    public boolean collapseActionView() {
        return ((C0348b) this.b).collapseActionView();
    }

    public boolean expandActionView() {
        return ((C0348b) this.b).expandActionView();
    }

    public ActionProvider getActionProvider() {
        C0518e a = ((C0348b) this.b).m1323a();
        return a instanceof C0773a ? ((C0773a) a).f1603a : null;
    }

    public View getActionView() {
        View actionView = ((C0348b) this.b).getActionView();
        return actionView instanceof C0774b ? ((C0774b) actionView).m3512c() : actionView;
    }

    public char getAlphabeticShortcut() {
        return ((C0348b) this.b).getAlphabeticShortcut();
    }

    public int getGroupId() {
        return ((C0348b) this.b).getGroupId();
    }

    public Drawable getIcon() {
        return ((C0348b) this.b).getIcon();
    }

    public Intent getIntent() {
        return ((C0348b) this.b).getIntent();
    }

    public int getItemId() {
        return ((C0348b) this.b).getItemId();
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0348b) this.b).getMenuInfo();
    }

    public char getNumericShortcut() {
        return ((C0348b) this.b).getNumericShortcut();
    }

    public int getOrder() {
        return ((C0348b) this.b).getOrder();
    }

    public SubMenu getSubMenu() {
        return m3344a(((C0348b) this.b).getSubMenu());
    }

    public CharSequence getTitle() {
        return ((C0348b) this.b).getTitle();
    }

    public CharSequence getTitleCondensed() {
        return ((C0348b) this.b).getTitleCondensed();
    }

    public boolean hasSubMenu() {
        return ((C0348b) this.b).hasSubMenu();
    }

    public boolean isActionViewExpanded() {
        return ((C0348b) this.b).isActionViewExpanded();
    }

    public boolean isCheckable() {
        return ((C0348b) this.b).isCheckable();
    }

    public boolean isChecked() {
        return ((C0348b) this.b).isChecked();
    }

    public boolean isEnabled() {
        return ((C0348b) this.b).isEnabled();
    }

    public boolean isVisible() {
        return ((C0348b) this.b).isVisible();
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0348b) this.b).m1321a(actionProvider != null ? m3515a(actionProvider) : null);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0348b) this.b).setActionView(i);
        View actionView = ((C0348b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0348b) this.b).setActionView(new C0774b(actionView));
        }
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0774b(view);
        }
        ((C0348b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0348b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        ((C0348b) this.b).setCheckable(z);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        ((C0348b) this.b).setChecked(z);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        ((C0348b) this.b).setEnabled(z);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0348b) this.b).setIcon(i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0348b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        ((C0348b) this.b).setIntent(intent);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0348b) this.b).setNumericShortcut(c);
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0348b) this.b).m1322a(onActionExpandListener != null ? new C0775c(this, onActionExpandListener) : null);
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0348b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0776d(this, onMenuItemClickListener) : null);
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0348b) this.b).setShortcut(c, c2);
        return this;
    }

    public void setShowAsAction(int i) {
        ((C0348b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0348b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0348b) this.b).setTitle(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0348b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0348b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public MenuItem setVisible(boolean z) {
        return ((C0348b) this.b).setVisible(z);
    }
}
