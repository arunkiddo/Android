package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

/* renamed from: android.support.v7.view.b */
public abstract class C0716b {
    private Object f1315a;
    private boolean f1316b;

    /* renamed from: android.support.v7.view.b.a */
    public interface C0694a {
        boolean onActionItemClicked(C0716b c0716b, MenuItem menuItem);

        boolean onCreateActionMode(C0716b c0716b, Menu menu);

        void onDestroyActionMode(C0716b c0716b);

        boolean onPrepareActionMode(C0716b c0716b, Menu menu);
    }

    public abstract MenuInflater m3107a();

    public abstract void m3108a(int i);

    public abstract void m3109a(View view);

    public abstract void m3110a(CharSequence charSequence);

    public void m3111a(Object obj) {
        this.f1315a = obj;
    }

    public void m3112a(boolean z) {
        this.f1316b = z;
    }

    public abstract Menu m3113b();

    public abstract void m3114b(int i);

    public abstract void m3115b(CharSequence charSequence);

    public abstract void m3116c();

    public abstract void m3117d();

    public abstract CharSequence m3118f();

    public abstract CharSequence m3119g();

    public boolean m3120h() {
        return false;
    }

    public abstract View m3121i();

    public Object m3122j() {
        return this.f1315a;
    }

    public boolean m3123k() {
        return this.f1316b;
    }
}
