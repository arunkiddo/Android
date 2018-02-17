package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v7.p018d.p019a.C0188a;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.reflect.Field;

public class an extends ListView {
    private static final int[] f2232g;
    final Rect f2233a;
    int f2234b;
    int f2235c;
    int f2236d;
    int f2237e;
    protected int f2238f;
    private Field f2239h;
    private C0906a f2240i;

    /* renamed from: android.support.v7.widget.an.a */
    private static class C0906a extends C0188a {
        private boolean f2265a;

        public C0906a(Drawable drawable) {
            super(drawable);
            this.f2265a = true;
        }

        void m4646a(boolean z) {
            this.f2265a = z;
        }

        public void draw(Canvas canvas) {
            if (this.f2265a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f2265a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f2265a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            return this.f2265a ? super.setState(iArr) : false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            return this.f2265a ? super.setVisible(z, z2) : false;
        }
    }

    static {
        f2232g = new int[]{0};
    }

    public an(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2233a = new Rect();
        this.f2234b = 0;
        this.f2235c = 0;
        this.f2236d = 0;
        this.f2237e = 0;
        try {
            this.f2239h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f2239h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public int m4629a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        listPaddingBottom += listPaddingTop;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int i6 = 0;
        View view = null;
        int i7 = 0;
        int count = adapter.getCount();
        int i8 = 0;
        while (i8 < count) {
            View view2;
            listPaddingTop = adapter.getItemViewType(i8);
            if (listPaddingTop != i7) {
                int i9 = listPaddingTop;
                view2 = null;
                i7 = i9;
            } else {
                view2 = view;
            }
            view = adapter.getView(i8, view2, this);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            listPaddingTop = (i8 > 0 ? listPaddingBottom + dividerHeight : listPaddingBottom) + view.getMeasuredHeight();
            if (listPaddingTop >= i4) {
                return (i5 < 0 || i8 <= i5 || i6 <= 0 || listPaddingTop == i4) ? i4 : i6;
            } else {
                if (i5 >= 0 && i8 >= i5) {
                    i6 = listPaddingTop;
                }
                i8++;
                listPaddingBottom = listPaddingTop;
            }
        }
        return listPaddingBottom;
    }

    protected void m4630a(int i, View view) {
        boolean z = true;
        Drawable selector = getSelector();
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m4635b(i, view);
        if (z2) {
            Rect rect = this.f2233a;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0326a.m1259a(selector, exactCenterX, exactCenterY);
        }
    }

    protected void m4631a(int i, View view, float f, float f2) {
        m4630a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0326a.m1259a(selector, f, f2);
        }
    }

    protected void m4632a(Canvas canvas) {
        if (!this.f2233a.isEmpty()) {
            Drawable selector = getSelector();
            if (selector != null) {
                selector.setBounds(this.f2233a);
                selector.draw(canvas);
            }
        }
    }

    protected boolean m4633a() {
        return false;
    }

    protected void m4634b() {
        Drawable selector = getSelector();
        if (selector != null && m4636c()) {
            selector.setState(getDrawableState());
        }
    }

    protected void m4635b(int i, View view) {
        Rect rect = this.f2233a;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f2234b;
        rect.top -= this.f2235c;
        rect.right += this.f2236d;
        rect.bottom += this.f2237e;
        try {
            boolean z = this.f2239h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f2239h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    protected boolean m4636c() {
        return m4633a() && isPressed();
    }

    protected void dispatchDraw(Canvas canvas) {
        m4632a(canvas);
        super.dispatchDraw(canvas);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        setSelectorEnabled(true);
        m4634b();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case C1373c.View_android_theme /*0*/:
                this.f2238f = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setSelector(Drawable drawable) {
        this.f2240i = drawable != null ? new C0906a(drawable) : null;
        super.setSelector(this.f2240i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f2234b = rect.left;
        this.f2235c = rect.top;
        this.f2236d = rect.right;
        this.f2237e = rect.bottom;
    }

    protected void setSelectorEnabled(boolean z) {
        if (this.f2240i != null) {
            this.f2240i.m4646a(z);
        }
    }
}
