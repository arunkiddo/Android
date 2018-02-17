package android.support.v4.widget;

import android.widget.ListView;

/* renamed from: android.support.v4.widget.l */
public class C0607l extends C0581a {
    private final ListView f1017a;

    public C0607l(ListView listView) {
        super(listView);
        this.f1017a = listView;
    }

    public void m2654a(int i, int i2) {
        C0608m.m2657a(this.f1017a, i2);
    }

    public boolean m2655e(int i) {
        return false;
    }

    public boolean m2656f(int i) {
        ListView listView = this.f1017a;
        int count = listView.getCount();
        if (count == 0) {
            return false;
        }
        int childCount = listView.getChildCount();
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        int i2 = firstVisiblePosition + childCount;
        if (i > 0) {
            if (i2 >= count && listView.getChildAt(childCount - 1).getBottom() <= listView.getHeight()) {
                return false;
            }
        } else if (i >= 0) {
            return false;
        } else {
            if (firstVisiblePosition <= 0 && listView.getChildAt(0).getTop() >= 0) {
                return false;
            }
        }
        return true;
    }
}
