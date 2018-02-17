package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p024e.p025a.C0347a;
import android.support.v4.p024e.p025a.C0348b;
import android.support.v4.p030j.C0379j;
import android.support.v7.view.C0716b.C0694a;
import android.support.v7.view.menu.C0782q;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
/* renamed from: android.support.v7.view.f */
public class C0744f extends ActionMode {
    final Context f1379a;
    final C0716b f1380b;

    /* renamed from: android.support.v7.view.f.a */
    public static class C0743a implements C0694a {
        final Callback f1375a;
        final Context f1376b;
        final ArrayList<C0744f> f1377c;
        final C0379j<Menu, Menu> f1378d;

        public C0743a(Context context, Callback callback) {
            this.f1376b = context;
            this.f1375a = callback;
            this.f1377c = new ArrayList();
            this.f1378d = new C0379j();
        }

        private Menu m3241a(Menu menu) {
            Menu menu2 = (Menu) this.f1378d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = C0782q.m3536a(this.f1376b, (C0347a) menu);
            this.f1378d.put(menu, menu2);
            return menu2;
        }

        public ActionMode m3242a(C0716b c0716b) {
            int size = this.f1377c.size();
            for (int i = 0; i < size; i++) {
                C0744f c0744f = (C0744f) this.f1377c.get(i);
                if (c0744f != null && c0744f.f1380b == c0716b) {
                    return c0744f;
                }
            }
            ActionMode c0744f2 = new C0744f(this.f1376b, c0716b);
            this.f1377c.add(c0744f2);
            return c0744f2;
        }

        public boolean onActionItemClicked(C0716b c0716b, MenuItem menuItem) {
            return this.f1375a.onActionItemClicked(m3242a(c0716b), C0782q.m3537a(this.f1376b, (C0348b) menuItem));
        }

        public boolean onCreateActionMode(C0716b c0716b, Menu menu) {
            return this.f1375a.onCreateActionMode(m3242a(c0716b), m3241a(menu));
        }

        public void onDestroyActionMode(C0716b c0716b) {
            this.f1375a.onDestroyActionMode(m3242a(c0716b));
        }

        public boolean onPrepareActionMode(C0716b c0716b, Menu menu) {
            return this.f1375a.onPrepareActionMode(m3242a(c0716b), m3241a(menu));
        }
    }

    public C0744f(Context context, C0716b c0716b) {
        this.f1379a = context;
        this.f1380b = c0716b;
    }

    public void finish() {
        this.f1380b.m3116c();
    }

    public View getCustomView() {
        return this.f1380b.m3121i();
    }

    public Menu getMenu() {
        return C0782q.m3536a(this.f1379a, (C0347a) this.f1380b.m3113b());
    }

    public MenuInflater getMenuInflater() {
        return this.f1380b.m3107a();
    }

    public CharSequence getSubtitle() {
        return this.f1380b.m3119g();
    }

    public Object getTag() {
        return this.f1380b.m3122j();
    }

    public CharSequence getTitle() {
        return this.f1380b.m3118f();
    }

    public boolean getTitleOptionalHint() {
        return this.f1380b.m3123k();
    }

    public void invalidate() {
        this.f1380b.m3117d();
    }

    public boolean isTitleOptional() {
        return this.f1380b.m3120h();
    }

    public void setCustomView(View view) {
        this.f1380b.m3109a(view);
    }

    public void setSubtitle(int i) {
        this.f1380b.m3114b(i);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1380b.m3110a(charSequence);
    }

    public void setTag(Object obj) {
        this.f1380b.m3111a(obj);
    }

    public void setTitle(int i) {
        this.f1380b.m3108a(i);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1380b.m3115b(charSequence);
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1380b.m3112a(z);
    }
}
