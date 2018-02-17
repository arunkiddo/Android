package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {
    private int f2170a;
    private int f2171b;
    private WeakReference<View> f2172c;
    private LayoutInflater f2173d;
    private C0881a f2174e;

    /* renamed from: android.support.v7.widget.ViewStubCompat.a */
    public interface C0881a {
        void m4489a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2170a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0729j.ViewStubCompat, i, 0);
        this.f2171b = obtainStyledAttributes.getResourceId(C0729j.ViewStubCompat_android_inflatedId, -1);
        this.f2170a = obtainStyledAttributes.getResourceId(C0729j.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0729j.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    public View m4490a() {
        ViewParent parent = getParent();
        if (parent == null || !(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f2170a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            View inflate = (this.f2173d != null ? this.f2173d : LayoutInflater.from(getContext())).inflate(this.f2170a, viewGroup, false);
            if (this.f2171b != -1) {
                inflate.setId(this.f2171b);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f2172c = new WeakReference(inflate);
            if (this.f2174e != null) {
                this.f2174e.m4489a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    protected void dispatchDraw(Canvas canvas) {
    }

    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f2171b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f2173d;
    }

    public int getLayoutResource() {
        return this.f2170a;
    }

    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f2171b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f2173d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f2170a = i;
    }

    public void setOnInflateListener(C0881a c0881a) {
        this.f2174e = c0881a;
    }

    public void setVisibility(int i) {
        if (this.f2172c != null) {
            View view = (View) this.f2172c.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            m4490a();
        }
    }
}
