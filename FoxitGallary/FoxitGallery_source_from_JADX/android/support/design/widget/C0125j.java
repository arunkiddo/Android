package android.support.design.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.design.widget.CoordinatorLayout.C0138e;
import android.support.v4.p016k.C0522f;
import android.support.v4.p016k.ah;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import java.util.List;

/* renamed from: android.support.design.widget.j */
abstract class C0125j extends C0123v<View> {
    private final Rect f198a;
    private final Rect f199b;
    private int f200c;
    private int f201d;

    public C0125j() {
        this.f198a = new Rect();
        this.f199b = new Rect();
        this.f200c = 0;
    }

    public C0125j(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f198a = new Rect();
        this.f199b = new Rect();
        this.f200c = 0;
    }

    private static int m326c(int i) {
        return i == 0 ? 8388659 : i;
    }

    float m327a(View view) {
        return 1.0f;
    }

    final int m328a() {
        return this.f200c;
    }

    abstract View m329a(List<View> list);

    public boolean m330a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
        int i5 = view.getLayoutParams().height;
        if (i5 == -1 || i5 == -2) {
            View a = m329a(coordinatorLayout.m492d(view));
            if (a != null) {
                if (ah.m1955v(a) && !ah.m1955v(view)) {
                    ah.m1919a(view, true);
                    if (ah.m1955v(view)) {
                        view.requestLayout();
                        return true;
                    }
                }
                int size = MeasureSpec.getSize(i3);
                if (size == 0) {
                    size = coordinatorLayout.getHeight();
                }
                coordinatorLayout.m477a(view, i, i2, MeasureSpec.makeMeasureSpec(m331b(a) + (size - a.getMeasuredHeight()), i5 == -1 ? 1073741824 : Integer.MIN_VALUE), i4);
                return true;
            }
        }
        return false;
    }

    int m331b(View view) {
        return view.getMeasuredHeight();
    }

    public final void m332b(int i) {
        this.f201d = i;
    }

    protected void m333b(CoordinatorLayout coordinatorLayout, View view, int i) {
        View a = m329a(coordinatorLayout.m492d(view));
        if (a != null) {
            C0138e c0138e = (C0138e) view.getLayoutParams();
            Rect rect = this.f198a;
            rect.set(coordinatorLayout.getPaddingLeft() + c0138e.leftMargin, a.getBottom() + c0138e.topMargin, (coordinatorLayout.getWidth() - coordinatorLayout.getPaddingRight()) - c0138e.rightMargin, ((coordinatorLayout.getHeight() + a.getBottom()) - coordinatorLayout.getPaddingBottom()) - c0138e.bottomMargin);
            Rect rect2 = this.f199b;
            C0522f.m2291a(C0125j.m326c(c0138e.f244c), view.getMeasuredWidth(), view.getMeasuredHeight(), rect, rect2, i);
            int c = m334c(a);
            view.layout(rect2.left, rect2.top - c, rect2.right, rect2.bottom - c);
            this.f200c = rect2.top - a.getBottom();
            return;
        }
        super.m273b(coordinatorLayout, view, i);
        this.f200c = 0;
    }

    final int m334c(View view) {
        return this.f201d == 0 ? 0 : C0187k.m683a(Math.round(m327a(view) * ((float) this.f201d)), 0, this.f201d);
    }
}
