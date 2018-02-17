package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0769h.C0753b;
import android.support.v7.widget.bf;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0753b, C0114p, OnItemClickListener {
    private static final int[] f1449a;
    private C0769h f1450b;
    private int f1451c;

    static {
        f1449a = new int[]{16842964, 16843049};
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        bf a = bf.m4774a(context, attributeSet, f1449a, i, 0);
        if (a.m4791g(0)) {
            setBackgroundDrawable(a.m4777a(0));
        }
        if (a.m4791g(1)) {
            setDivider(a.m4777a(1));
        }
        a.m4778a();
    }

    public void m3304a(C0769h c0769h) {
        this.f1450b = c0769h;
    }

    public boolean m3305a(C0772j c0772j) {
        return this.f1450b.m3443a((MenuItem) c0772j, 0);
    }

    public int getWindowAnimations() {
        return this.f1451c;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        m3305a((C0772j) getAdapter().getItem(i));
    }
}
