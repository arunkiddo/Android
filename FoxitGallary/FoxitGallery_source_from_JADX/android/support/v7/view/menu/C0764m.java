package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;

/* renamed from: android.support.v7.view.menu.m */
abstract class C0764m implements C0755o, C0763s, OnItemClickListener {
    private Rect f1504a;

    C0764m() {
    }

    protected static int m3357a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i2 = 0;
        int i3 = 0;
        View view = null;
        int i4 = 0;
        ViewGroup viewGroup2 = viewGroup;
        while (i2 < count) {
            int itemViewType = listAdapter.getItemViewType(i2);
            if (itemViewType != i3) {
                i3 = itemViewType;
                view = null;
            }
            ViewGroup frameLayout = viewGroup2 == null ? new FrameLayout(context) : viewGroup2;
            view = listAdapter.getView(i2, view, frameLayout);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth <= i4) {
                measuredWidth = i4;
            }
            i2++;
            i4 = measuredWidth;
            viewGroup2 = frameLayout;
        }
        return i4;
    }

    protected static C0768g m3358a(ListAdapter listAdapter) {
        return listAdapter instanceof HeaderViewListAdapter ? (C0768g) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter() : (C0768g) listAdapter;
    }

    protected static boolean m3359b(C0769h c0769h) {
        int size = c0769h.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = c0769h.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void m3360a(int i);

    public void m3361a(Context context, C0769h c0769h) {
    }

    public void m3362a(Rect rect) {
        this.f1504a = rect;
    }

    public abstract void m3363a(C0769h c0769h);

    public abstract void m3364a(View view);

    public abstract void m3365a(OnDismissListener onDismissListener);

    public abstract void m3366a(boolean z);

    public boolean m3367a(C0769h c0769h, C0772j c0772j) {
        return false;
    }

    public abstract void m3368b(int i);

    public boolean m3369b(C0769h c0769h, C0772j c0772j) {
        return false;
    }

    public abstract void m3370c(int i);

    public abstract void m3371c(boolean z);

    public Rect m3372f() {
        return this.f1504a;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        C0764m.m3358a(listAdapter).f1542b.m3443a((MenuItem) listAdapter.getItem(i), 0);
    }
}
