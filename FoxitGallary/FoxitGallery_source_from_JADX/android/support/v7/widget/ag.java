package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.az;
import android.support.v4.widget.C0607l;
import android.support.v7.p034b.C0730a.C0720a;
import android.view.MotionEvent;
import android.view.View;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

class ag extends an {
    private boolean f2241g;
    private boolean f2242h;
    private boolean f2243i;
    private az f2244j;
    private C0607l f2245k;

    public ag(Context context, boolean z) {
        super(context, null, C0720a.dropDownListViewStyle);
        this.f2242h = z;
        setCacheColorHint(0);
    }

    private void m4637a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    private void m4638a(View view, int i, float f, float f2) {
        this.f2243i = true;
        if (VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        if (this.f != -1) {
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                childAt.setPressed(false);
            }
        }
        this.f = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m4631a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    private void m4639d() {
        this.f2243i = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        if (this.f2244j != null) {
            this.f2244j.m2164b();
            this.f2244j = null;
        }
    }

    protected boolean m4640a() {
        return this.f2243i || super.m4633a();
    }

    public boolean m4641a(MotionEvent motionEvent, int i) {
        boolean z;
        boolean z2;
        int a = C0560t.m2392a(motionEvent);
        switch (a) {
            case C1373c.View_android_focusable /*1*/:
                z = false;
                break;
            case C1373c.View_paddingStart /*2*/:
                z = true;
                break;
            case C1373c.View_paddingEnd /*3*/:
                z = false;
                z2 = false;
                break;
            default:
                z = false;
                z2 = true;
                break;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i);
        if (findPointerIndex < 0) {
            z = false;
            z2 = false;
        } else {
            int x = (int) motionEvent.getX(findPointerIndex);
            findPointerIndex = (int) motionEvent.getY(findPointerIndex);
            int pointToPosition = pointToPosition(x, findPointerIndex);
            if (pointToPosition == -1) {
                z2 = z;
                z = true;
            } else {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                m4638a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                if (a == 1) {
                    m4637a(childAt, pointToPosition);
                }
                z = false;
                z2 = true;
            }
        }
        if (!z2 || r0) {
            m4639d();
        }
        if (z2) {
            if (this.f2245k == null) {
                this.f2245k = new C0607l(this);
            }
            this.f2245k.m2525a(true);
            this.f2245k.onTouch(this, motionEvent);
        } else if (this.f2245k != null) {
            this.f2245k.m2525a(false);
        }
        return z2;
    }

    public boolean hasFocus() {
        return this.f2242h || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f2242h || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f2242h || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f2242h && this.f2241g) || super.isInTouchMode();
    }

    void setListSelectionHidden(boolean z) {
        this.f2241g = z;
    }
}
