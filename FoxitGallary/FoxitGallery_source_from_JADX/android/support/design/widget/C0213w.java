package android.support.design.widget;

import android.support.v4.p016k.ah;
import android.view.View;

/* renamed from: android.support.design.widget.w */
class C0213w {
    private final View f464a;
    private int f465b;
    private int f466c;
    private int f467d;
    private int f468e;

    public C0213w(View view) {
        this.f464a = view;
    }

    private void m783c() {
        ah.m1936e(this.f464a, this.f467d - (this.f464a.getTop() - this.f465b));
        ah.m1939f(this.f464a, this.f468e - (this.f464a.getLeft() - this.f466c));
    }

    public void m784a() {
        this.f465b = this.f464a.getTop();
        this.f466c = this.f464a.getLeft();
        m783c();
    }

    public boolean m785a(int i) {
        if (this.f467d == i) {
            return false;
        }
        this.f467d = i;
        m783c();
        return true;
    }

    public int m786b() {
        return this.f467d;
    }

    public boolean m787b(int i) {
        if (this.f468e == i) {
            return false;
        }
        this.f468e = i;
        m783c();
        return true;
    }
}
