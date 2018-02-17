package android.support.v4.widget;

import android.view.View;
import android.widget.ListView;

/* renamed from: android.support.v4.widget.n */
class C0609n {
    static void m2658a(ListView listView, int i) {
        int firstVisiblePosition = listView.getFirstVisiblePosition();
        if (firstVisiblePosition != -1) {
            View childAt = listView.getChildAt(0);
            if (childAt != null) {
                listView.setSelectionFromTop(firstVisiblePosition, childAt.getTop() - i);
            }
        }
    }
}
