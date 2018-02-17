package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout.C0122b;
import android.util.AttributeSet;
import android.view.View;

/* renamed from: android.support.design.widget.v */
class C0123v<V extends View> extends C0122b<V> {
    private C0213w f179a;
    private int f180b;
    private int f181c;

    public C0123v() {
        this.f180b = 0;
        this.f181c = 0;
    }

    public C0123v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f180b = 0;
        this.f181c = 0;
    }

    public boolean m270a(int i) {
        if (this.f179a != null) {
            return this.f179a.m785a(i);
        }
        this.f180b = i;
        return false;
    }

    public boolean m271a(CoordinatorLayout coordinatorLayout, V v, int i) {
        m273b(coordinatorLayout, v, i);
        if (this.f179a == null) {
            this.f179a = new C0213w(v);
        }
        this.f179a.m784a();
        if (this.f180b != 0) {
            this.f179a.m785a(this.f180b);
            this.f180b = 0;
        }
        if (this.f181c != 0) {
            this.f179a.m787b(this.f181c);
            this.f181c = 0;
        }
        return true;
    }

    public int m272b() {
        return this.f179a != null ? this.f179a.m786b() : 0;
    }

    protected void m273b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m476a((View) v, i);
    }
}
