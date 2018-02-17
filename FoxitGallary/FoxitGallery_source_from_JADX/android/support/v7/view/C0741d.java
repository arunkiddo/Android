package android.support.v7.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources.Theme;
import android.support.v7.p034b.C0730a.C0728i;
import android.view.LayoutInflater;

/* renamed from: android.support.v7.view.d */
public class C0741d extends ContextWrapper {
    private int f1365a;
    private Theme f1366b;
    private LayoutInflater f1367c;

    public C0741d(Context context, int i) {
        super(context);
        this.f1365a = i;
    }

    public C0741d(Context context, Theme theme) {
        super(context);
        this.f1366b = theme;
    }

    private void m3222b() {
        boolean z = this.f1366b == null;
        if (z) {
            this.f1366b = getResources().newTheme();
            Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f1366b.setTo(theme);
            }
        }
        m3224a(this.f1366b, this.f1365a, z);
    }

    public int m3223a() {
        return this.f1365a;
    }

    protected void m3224a(Theme theme, int i, boolean z) {
        theme.applyStyle(i, true);
    }

    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f1367c == null) {
            this.f1367c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f1367c;
    }

    public Theme getTheme() {
        if (this.f1366b != null) {
            return this.f1366b;
        }
        if (this.f1365a == 0) {
            this.f1365a = C0728i.Theme_AppCompat_Light;
        }
        m3222b();
        return this.f1366b;
    }

    public void setTheme(int i) {
        if (this.f1365a != i) {
            this.f1365a = i;
            m3222b();
        }
    }
}
