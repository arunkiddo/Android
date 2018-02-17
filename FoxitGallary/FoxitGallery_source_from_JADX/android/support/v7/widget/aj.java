package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0844n;
import android.support.v7.widget.RecyclerView.C0850s;
import android.view.View;

class aj {
    boolean f2248a;
    int f2249b;
    int f2250c;
    int f2251d;
    int f2252e;
    int f2253f;
    int f2254g;
    boolean f2255h;
    boolean f2256i;

    aj() {
        this.f2248a = true;
        this.f2253f = 0;
        this.f2254g = 0;
    }

    View m4642a(C0844n c0844n) {
        View c = c0844n.m4164c(this.f2250c);
        this.f2250c += this.f2251d;
        return c;
    }

    boolean m4643a(C0850s c0850s) {
        return this.f2250c >= 0 && this.f2250c < c0850s.m4222e();
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f2249b + ", mCurrentPosition=" + this.f2250c + ", mItemDirection=" + this.f2251d + ", mLayoutDirection=" + this.f2252e + ", mStartLine=" + this.f2253f + ", mEndLine=" + this.f2254g + '}';
    }
}
