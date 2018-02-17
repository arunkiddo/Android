package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.C0716b.C0694a;
import android.support.v7.view.menu.C0769h;
import android.support.v7.view.menu.C0769h.C0676a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.view.e */
public class C0742e extends C0716b implements C0676a {
    private Context f1368a;
    private ActionBarContextView f1369b;
    private C0694a f1370c;
    private WeakReference<View> f1371d;
    private boolean f1372e;
    private boolean f1373f;
    private C0769h f1374g;

    public C0742e(Context context, ActionBarContextView actionBarContextView, C0694a c0694a, boolean z) {
        this.f1368a = context;
        this.f1369b = actionBarContextView;
        this.f1370c = c0694a;
        this.f1374g = new C0769h(actionBarContextView.getContext()).m3427a(1);
        this.f1374g.m3435a((C0676a) this);
        this.f1373f = z;
    }

    public MenuInflater m3225a() {
        return new C0747g(this.f1369b.getContext());
    }

    public void m3226a(int i) {
        m3234b(this.f1368a.getString(i));
    }

    public void m3227a(C0769h c0769h) {
        m3236d();
        this.f1369b.m3581a();
    }

    public void m3228a(View view) {
        this.f1369b.setCustomView(view);
        this.f1371d = view != null ? new WeakReference(view) : null;
    }

    public void m3229a(CharSequence charSequence) {
        this.f1369b.setSubtitle(charSequence);
    }

    public void m3230a(boolean z) {
        super.m3112a(z);
        this.f1369b.setTitleOptional(z);
    }

    public boolean m3231a(C0769h c0769h, MenuItem menuItem) {
        return this.f1370c.onActionItemClicked(this, menuItem);
    }

    public Menu m3232b() {
        return this.f1374g;
    }

    public void m3233b(int i) {
        m3229a(this.f1368a.getString(i));
    }

    public void m3234b(CharSequence charSequence) {
        this.f1369b.setTitle(charSequence);
    }

    public void m3235c() {
        if (!this.f1372e) {
            this.f1372e = true;
            this.f1369b.sendAccessibilityEvent(32);
            this.f1370c.onDestroyActionMode(this);
        }
    }

    public void m3236d() {
        this.f1370c.onPrepareActionMode(this, this.f1374g);
    }

    public CharSequence m3237f() {
        return this.f1369b.getTitle();
    }

    public CharSequence m3238g() {
        return this.f1369b.getSubtitle();
    }

    public boolean m3239h() {
        return this.f1369b.m3584d();
    }

    public View m3240i() {
        return this.f1371d != null ? (View) this.f1371d.get() : null;
    }
}
