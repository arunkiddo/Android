package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.C0518e;
import android.support.v4.p016k.C0550q.C0549e;
import android.support.v4.p022c.C0225a;
import android.support.v4.p024e.p025a.C0348b;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

/* renamed from: android.support.v7.view.menu.a */
public class C0754a implements C0348b {
    private final int f1467a;
    private final int f1468b;
    private final int f1469c;
    private final int f1470d;
    private CharSequence f1471e;
    private CharSequence f1472f;
    private Intent f1473g;
    private char f1474h;
    private char f1475i;
    private Drawable f1476j;
    private int f1477k;
    private Context f1478l;
    private OnMenuItemClickListener f1479m;
    private int f1480n;

    public C0754a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1477k = 0;
        this.f1480n = 16;
        this.f1478l = context;
        this.f1467a = i2;
        this.f1468b = i;
        this.f1469c = i3;
        this.f1470d = i4;
        this.f1471e = charSequence;
    }

    public C0348b m3312a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0348b m3313a(C0518e c0518e) {
        throw new UnsupportedOperationException();
    }

    public C0348b m3314a(C0549e c0549e) {
        return this;
    }

    public C0348b m3315a(View view) {
        throw new UnsupportedOperationException();
    }

    public C0518e m3316a() {
        return null;
    }

    public C0348b m3317b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean expandActionView() {
        return false;
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public char getAlphabeticShortcut() {
        return this.f1475i;
    }

    public int getGroupId() {
        return this.f1468b;
    }

    public Drawable getIcon() {
        return this.f1476j;
    }

    public Intent getIntent() {
        return this.f1473g;
    }

    public int getItemId() {
        return this.f1467a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f1474h;
    }

    public int getOrder() {
        return this.f1470d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1471e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1472f != null ? this.f1472f : this.f1471e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1480n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1480n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1480n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1480n & 8) == 0;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3312a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3315a(view);
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1475i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1480n = (z ? 1 : 0) | (this.f1480n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1480n = (z ? 2 : 0) | (this.f1480n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1480n = (z ? 16 : 0) | (this.f1480n & -17);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1477k = i;
        this.f1476j = C0225a.m808a(this.f1478l, i);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1476j = drawable;
        this.f1477k = 0;
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1473g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1474h = c;
        return this;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1479m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1474h = c;
        this.f1475i = c2;
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3317b(i);
    }

    public MenuItem setTitle(int i) {
        this.f1471e = this.f1478l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1471e = charSequence;
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1472f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f1480n = (z ? 0 : 8) | (this.f1480n & 8);
        return this;
    }
}
