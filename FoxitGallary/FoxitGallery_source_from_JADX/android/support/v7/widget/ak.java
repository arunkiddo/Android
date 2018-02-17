package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p016k.C0522f;
import android.support.v4.p016k.ah;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public class ak extends ViewGroup {
    private boolean f144a;
    private int f145b;
    private int f146c;
    private int f147d;
    private int f148e;
    private int f149f;
    private float f150g;
    private boolean f151h;
    private int[] f152i;
    private int[] f153j;
    private Drawable f154k;
    private int f155l;
    private int f156m;
    private int f157n;
    private int f158o;

    /* renamed from: android.support.v7.widget.ak.a */
    public static class C0796a extends MarginLayoutParams {
        public float f1709g;
        public int f1710h;

        public C0796a(int i, int i2) {
            super(i, i2);
            this.f1710h = -1;
            this.f1709g = 0.0f;
        }

        public C0796a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1710h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0729j.LinearLayoutCompat_Layout);
            this.f1709g = obtainStyledAttributes.getFloat(C0729j.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1710h = obtainStyledAttributes.getInt(C0729j.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public C0796a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1710h = -1;
        }
    }

    public ak(Context context) {
        this(context, null);
    }

    public ak(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ak(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f144a = true;
        this.f145b = -1;
        this.f146c = 0;
        this.f148e = 8388659;
        bf a = bf.m4774a(context, attributeSet, C0729j.LinearLayoutCompat, i, 0);
        int a2 = a.m4776a(C0729j.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m4776a(C0729j.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m4779a(C0729j.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f150g = a.m4775a(C0729j.LinearLayoutCompat_android_weightSum, -1.0f);
        this.f145b = a.m4776a(C0729j.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f151h = a.m4779a(C0729j.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m4777a(C0729j.LinearLayoutCompat_divider));
        this.f157n = a.m4776a(C0729j.LinearLayoutCompat_showDividers, 0);
        this.f158o = a.m4786e(C0729j.LinearLayoutCompat_dividerPadding, 0);
        a.m4778a();
    }

    private void m212a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private void m213c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m225b(i3);
            if (b.getVisibility() != 8) {
                C0796a c0796a = (C0796a) b.getLayoutParams();
                if (c0796a.width == -1) {
                    int i4 = c0796a.height;
                    c0796a.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    c0796a.height = i4;
                }
            }
        }
    }

    private void m214d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m225b(i3);
            if (b.getVisibility() != 8) {
                C0796a c0796a = (C0796a) b.getLayoutParams();
                if (c0796a.height == -1) {
                    int i4 = c0796a.width;
                    c0796a.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    c0796a.width = i4;
                }
            }
        }
    }

    int m215a(View view) {
        return 0;
    }

    int m216a(View view, int i) {
        return 0;
    }

    void m217a(int i, int i2) {
        int i3;
        int i4;
        int i5;
        View b;
        this.f149f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        int i10 = this.f145b;
        boolean z = this.f151h;
        int i11 = Integer.MIN_VALUE;
        int i12 = 0;
        while (i12 < virtualChildCount) {
            Object obj4;
            Object obj5;
            int i13;
            View b2 = m225b(i12);
            if (b2 == null) {
                this.f149f += m231d(i12);
                i3 = i11;
                obj4 = obj3;
                obj5 = obj;
                i4 = i7;
                i13 = i6;
            } else if (b2.getVisibility() == 8) {
                i12 += m216a(b2, i12);
                i3 = i11;
                obj4 = obj3;
                obj5 = obj;
                i4 = i7;
                i13 = i6;
            } else {
                if (m230c(i12)) {
                    this.f149f += this.f156m;
                }
                C0796a c0796a = (C0796a) b2.getLayoutParams();
                float f2 = f + c0796a.f1709g;
                if (mode2 == 1073741824 && c0796a.height == 0 && c0796a.f1709g > 0.0f) {
                    i3 = this.f149f;
                    this.f149f = Math.max(i3, (c0796a.topMargin + i3) + c0796a.bottomMargin);
                    obj3 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0796a.height == 0 && c0796a.f1709g > 0.0f) {
                        i3 = 0;
                        c0796a.height = -2;
                    }
                    int i14 = i3;
                    m221a(b2, i12, i, 0, i2, f2 == 0.0f ? this.f149f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        c0796a.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f149f;
                    this.f149f = Math.max(i15, (((i15 + i3) + c0796a.topMargin) + c0796a.bottomMargin) + m222b(b2));
                    if (z) {
                        i11 = Math.max(i3, i11);
                    }
                }
                if (i10 >= 0 && i10 == i12 + 1) {
                    this.f146c = this.f149f;
                }
                if (i12 >= i10 || c0796a.f1709g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || c0796a.width != -1) {
                        obj6 = obj2;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i4 = c0796a.rightMargin + c0796a.leftMargin;
                    i13 = b2.getMeasuredWidth() + i4;
                    i6 = Math.max(i6, i13);
                    int a = bj.m4865a(i7, ah.m1943j(b2));
                    obj5 = (obj == null || c0796a.width != -1) ? null : 1;
                    if (c0796a.f1709g > 0.0f) {
                        i3 = Math.max(i9, obj7 != null ? i4 : i13);
                        i4 = i8;
                    } else {
                        if (obj7 == null) {
                            i4 = i13;
                        }
                        i4 = Math.max(i8, i4);
                        i3 = i9;
                    }
                    i12 += m216a(b2, i12);
                    obj4 = obj3;
                    i9 = i3;
                    i8 = i4;
                    i13 = i6;
                    i3 = i11;
                    i4 = a;
                    obj2 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i12++;
            i11 = i3;
            obj3 = obj4;
            obj = obj5;
            i7 = i4;
            i6 = i13;
        }
        if (this.f149f > 0 && m230c(virtualChildCount)) {
            this.f149f += this.f156m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f149f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                b = m225b(i5);
                if (b == null) {
                    this.f149f += m231d(i5);
                    i3 = i5;
                } else if (b.getVisibility() == 8) {
                    i3 = m216a(b, i5) + i5;
                } else {
                    C0796a c0796a2 = (C0796a) b.getLayoutParams();
                    int i16 = this.f149f;
                    this.f149f = Math.max(i16, (c0796a2.bottomMargin + ((i16 + i11) + c0796a2.topMargin)) + m222b(b));
                    i3 = i5;
                }
                i5 = i3 + 1;
            }
        }
        this.f149f += getPaddingTop() + getPaddingBottom();
        int a2 = ah.m1906a(Math.max(this.f149f, getSuggestedMinimumHeight()), i2, 0);
        i5 = (16777215 & a2) - this.f149f;
        int i17;
        if (obj3 != null || (i5 != 0 && f > 0.0f)) {
            if (this.f150g > 0.0f) {
                f = this.f150g;
            }
            this.f149f = 0;
            i11 = 0;
            float f3 = f;
            Object obj8 = obj;
            i17 = i8;
            i16 = i7;
            i9 = i6;
            i15 = i5;
            while (i11 < virtualChildCount) {
                View b3 = m225b(i11);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i5 = i16;
                    i4 = i9;
                    obj5 = obj8;
                } else {
                    float f4;
                    float f5;
                    c0796a2 = (C0796a) b3.getLayoutParams();
                    float f6 = c0796a2.f1709g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i5;
                        i4 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + c0796a2.leftMargin) + c0796a2.rightMargin, c0796a2.width);
                        if (c0796a2.height == 0 && mode2 == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        } else {
                            i5 += b3.getMeasuredHeight();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(i4, MeasureSpec.makeMeasureSpec(i5, 1073741824));
                        }
                        f4 = f3;
                        i12 = i15;
                        i15 = bj.m4865a(i16, ah.m1943j(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i12 = i15;
                        i15 = i16;
                    }
                    i16 = c0796a2.leftMargin + c0796a2.rightMargin;
                    i4 = b3.getMeasuredWidth() + i16;
                    i9 = Math.max(i9, i4);
                    Object obj9 = (mode == 1073741824 || c0796a2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i4;
                    }
                    i4 = Math.max(i17, i16);
                    obj5 = (obj8 == null || c0796a2.width != -1) ? null : 1;
                    i13 = this.f149f;
                    this.f149f = Math.max(i13, (c0796a2.bottomMargin + ((b3.getMeasuredHeight() + i13) + c0796a2.topMargin)) + m222b(b3));
                    i3 = i4;
                    i4 = i9;
                    f4 = f5;
                    i5 = i15;
                    i15 = i12;
                    f3 = f4;
                }
                i11++;
                i17 = i3;
                i9 = i4;
                obj8 = obj5;
                i16 = i5;
            }
            this.f149f += getPaddingTop() + getPaddingBottom();
            obj = obj8;
            i3 = i17;
            i7 = i16;
            i5 = i9;
        } else {
            i17 = Math.max(i8, i9);
            if (z && mode2 != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    b = m225b(i5);
                    if (!(b == null || b.getVisibility() == 8 || ((C0796a) b.getLayoutParams()).f1709g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i11, 1073741824));
                    }
                }
            }
            i3 = i17;
            i5 = i6;
        }
        if (obj != null || mode == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension(ah.m1906a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i7), a2);
        if (obj2 != null) {
            m213c(virtualChildCount, i2);
        }
    }

    void m218a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f148e & 8388615;
        switch (this.f148e & C1373c.AppCompatTheme_spinnerStyle) {
            case C1373c.Toolbar_titleMarginEnd /*16*/:
                i5 = getPaddingTop() + (((i4 - i2) - this.f149f) / 2);
                break;
            case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                i5 = ((getPaddingTop() + i4) - i2) - this.f149f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m225b(i7);
            if (b == null) {
                i8 += m231d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0796a c0796a = (C0796a) b.getLayoutParams();
                i5 = c0796a.f1710h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (C0522f.m2290a(i5, ah.m1941h(this)) & 7) {
                    case C1373c.View_android_focusable /*1*/:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + c0796a.leftMargin) - c0796a.rightMargin;
                        break;
                    case C1373c.Toolbar_contentInsetStart /*5*/:
                        i9 = (paddingRight - measuredWidth) - c0796a.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + c0796a.leftMargin;
                        break;
                }
                int i10 = (m230c(i7) ? this.f156m + i8 : i8) + c0796a.topMargin;
                m212a(b, i9, i10 + m215a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((c0796a.bottomMargin + measuredHeight) + m222b(b));
                i5 = m216a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m219a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m225b(i);
            if (!(b == null || b.getVisibility() == 8 || !m230c(i))) {
                m220a(canvas, (b.getTop() - ((C0796a) b.getLayoutParams()).topMargin) - this.f156m);
            }
            i++;
        }
        if (m230c(virtualChildCount)) {
            int height;
            View b2 = m225b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f156m;
            } else {
                C0796a c0796a = (C0796a) b2.getLayoutParams();
                height = c0796a.bottomMargin + b2.getBottom();
            }
            m220a(canvas, height);
        }
    }

    void m220a(Canvas canvas, int i) {
        this.f154k.setBounds(getPaddingLeft() + this.f158o, i, (getWidth() - getPaddingRight()) - this.f158o, this.f156m + i);
        this.f154k.draw(canvas);
    }

    void m221a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m222b(View view) {
        return 0;
    }

    public C0796a m223b(AttributeSet attributeSet) {
        return new C0796a(getContext(), attributeSet);
    }

    protected C0796a m224b(LayoutParams layoutParams) {
        return new C0796a(layoutParams);
    }

    View m225b(int i) {
        return getChildAt(i);
    }

    void m226b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        C0796a c0796a;
        this.f149f = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        if (this.f152i == null || this.f153j == null) {
            this.f152i = new int[4];
            this.f153j = new int[4];
        }
        int[] iArr = this.f152i;
        int[] iArr2 = this.f153j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f144a;
        boolean z2 = this.f151h;
        Object obj4 = mode == 1073741824 ? 1 : null;
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj5;
            Object obj6;
            int i12;
            View b = m225b(i11);
            if (b == null) {
                this.f149f += m231d(i11);
                i3 = i10;
                obj5 = obj3;
                obj6 = obj;
                i4 = i7;
                i12 = i6;
            } else if (b.getVisibility() == 8) {
                i11 += m216a(b, i11);
                i3 = i10;
                obj5 = obj3;
                obj6 = obj;
                i4 = i7;
                i12 = i6;
            } else {
                Object obj7;
                if (m230c(i11)) {
                    this.f149f += this.f155l;
                }
                C0796a c0796a2 = (C0796a) b.getLayoutParams();
                float f2 = f + c0796a2.f1709g;
                if (mode == 1073741824 && c0796a2.width == 0 && c0796a2.f1709g > 0.0f) {
                    if (obj4 != null) {
                        this.f149f += c0796a2.leftMargin + c0796a2.rightMargin;
                    } else {
                        i3 = this.f149f;
                        this.f149f = Math.max(i3, (c0796a2.leftMargin + i3) + c0796a2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj3 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0796a2.width == 0 && c0796a2.f1709g > 0.0f) {
                        i3 = 0;
                        c0796a2.width = -2;
                    }
                    int i13 = i3;
                    m221a(b, i11, i, f2 == 0.0f ? this.f149f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        c0796a2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj4 != null) {
                        this.f149f += ((c0796a2.leftMargin + i3) + c0796a2.rightMargin) + m222b(b);
                    } else {
                        int i14 = this.f149f;
                        this.f149f = Math.max(i14, (((i14 + i3) + c0796a2.leftMargin) + c0796a2.rightMargin) + m222b(b));
                    }
                    if (z2) {
                        i10 = Math.max(i3, i10);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || c0796a2.height != -1) {
                    obj7 = obj2;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i4 = c0796a2.bottomMargin + c0796a2.topMargin;
                i12 = b.getMeasuredHeight() + i4;
                int a = bj.m4865a(i7, ah.m1943j(b));
                if (z) {
                    i7 = b.getBaseline();
                    if (i7 != -1) {
                        int i15 = ((((c0796a2.f1710h < 0 ? this.f148e : c0796a2.f1710h) & C1373c.AppCompatTheme_spinnerStyle) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i7);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i7);
                    }
                }
                i7 = Math.max(i6, i12);
                obj6 = (obj == null || c0796a2.height != -1) ? null : 1;
                if (c0796a2.f1709g > 0.0f) {
                    i3 = Math.max(i9, obj8 != null ? i4 : i12);
                    i4 = i8;
                } else {
                    if (obj8 == null) {
                        i4 = i12;
                    }
                    i4 = Math.max(i8, i4);
                    i3 = i9;
                }
                i11 += m216a(b, i11);
                obj5 = obj3;
                i9 = i3;
                i8 = i4;
                i12 = i7;
                i3 = i10;
                i4 = a;
                obj2 = obj7;
                f = f2;
            }
            i11++;
            i10 = i3;
            obj3 = obj5;
            obj = obj6;
            i7 = i4;
            i6 = i12;
        }
        if (this.f149f > 0 && m230c(virtualChildCount)) {
            this.f149f += this.f155l;
        }
        i11 = (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) ? i6 : Math.max(i6, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f149f = 0;
            i5 = 0;
            while (i5 < virtualChildCount) {
                View b2 = m225b(i5);
                if (b2 == null) {
                    this.f149f += m231d(i5);
                    i3 = i5;
                } else if (b2.getVisibility() == 8) {
                    i3 = m216a(b2, i5) + i5;
                } else {
                    c0796a = (C0796a) b2.getLayoutParams();
                    if (obj4 != null) {
                        this.f149f = ((c0796a.rightMargin + (c0796a.leftMargin + i10)) + m222b(b2)) + this.f149f;
                        i3 = i5;
                    } else {
                        i4 = this.f149f;
                        this.f149f = Math.max(i4, (c0796a.rightMargin + ((i4 + i10) + c0796a.leftMargin)) + m222b(b2));
                        i3 = i5;
                    }
                }
                i5 = i3 + 1;
            }
        }
        this.f149f += getPaddingLeft() + getPaddingRight();
        int a2 = ah.m1906a(Math.max(this.f149f, getSuggestedMinimumWidth()), i, 0);
        i5 = (16777215 & a2) - this.f149f;
        int i16;
        if (obj3 != null || (i5 != 0 && f > 0.0f)) {
            if (this.f150g > 0.0f) {
                f = this.f150g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f149f = 0;
            i10 = 0;
            float f3 = f;
            Object obj9 = obj;
            i16 = i8;
            i15 = i7;
            i14 = i5;
            i8 = -1;
            while (i10 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m225b(i10);
                if (b3 == null) {
                    f4 = f3;
                    i5 = i14;
                    i4 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i5 = i14;
                    i4 = i8;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    c0796a = (C0796a) b3.getLayoutParams();
                    float f6 = c0796a.f1709g;
                    if (f6 > 0.0f) {
                        i5 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i4 = i14 - i5;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0796a.topMargin) + c0796a.bottomMargin, c0796a.height);
                        if (c0796a.width == 0 && mode == 1073741824) {
                            if (i5 <= 0) {
                                i5 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        } else {
                            i5 += b3.getMeasuredWidth();
                            if (i5 < 0) {
                                i5 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i5, 1073741824), i14);
                        }
                        i9 = bj.m4865a(i15, ah.m1943j(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i4 = i14;
                        i9 = i15;
                        f5 = f3;
                    }
                    if (obj4 != null) {
                        this.f149f += ((b3.getMeasuredWidth() + c0796a.leftMargin) + c0796a.rightMargin) + m222b(b3);
                    } else {
                        i5 = this.f149f;
                        this.f149f = Math.max(i5, (((b3.getMeasuredWidth() + i5) + c0796a.leftMargin) + c0796a.rightMargin) + m222b(b3));
                    }
                    obj5 = (mode2 == 1073741824 || c0796a.height != -1) ? null : 1;
                    i11 = c0796a.topMargin + c0796a.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i11;
                    i8 = Math.max(i8, i14);
                    i11 = Math.max(i16, obj5 != null ? i11 : i14);
                    obj5 = (obj9 == null || c0796a.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((c0796a.f1710h < 0 ? this.f148e : c0796a.f1710h) & C1373c.AppCompatTheme_spinnerStyle) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i11;
                    obj10 = obj5;
                    i15 = i9;
                    i5 = i4;
                    i4 = i8;
                }
                i10++;
                i16 = i14;
                i8 = i4;
                obj9 = obj10;
                i14 = i5;
                f3 = f4;
            }
            this.f149f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i8 = Math.max(i8, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj = obj9;
            i3 = i16;
            i7 = i15;
            i5 = i8;
        } else {
            i16 = Math.max(i8, i9);
            if (z2 && mode != 1073741824) {
                for (i5 = 0; i5 < virtualChildCount; i5++) {
                    View b4 = m225b(i5);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0796a) b4.getLayoutParams()).f1709g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i10, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i5 = i11;
        }
        if (obj != null || mode2 == 1073741824) {
            i3 = i5;
        }
        setMeasuredDimension((-16777216 & i7) | a2, ah.m1906a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i7 << 16));
        if (obj2 != null) {
            m214d(virtualChildCount, i);
        }
    }

    void m227b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = bj.m4867a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f148e & 8388615;
        int i8 = this.f148e & C1373c.AppCompatTheme_spinnerStyle;
        boolean z = this.f144a;
        int[] iArr = this.f152i;
        int[] iArr2 = this.f153j;
        switch (C0522f.m2290a(i7, ah.m1941h(this))) {
            case C1373c.View_android_focusable /*1*/:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f149f) / 2);
                break;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f149f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m225b(i10);
            if (b == null) {
                paddingLeft += m231d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0796a c0796a = (C0796a) b.getLayoutParams();
                i7 = (!z || c0796a.height == -1) ? -1 : b.getBaseline();
                int i12 = c0796a.f1710h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & C1373c.AppCompatTheme_spinnerStyle) {
                    case C1373c.Toolbar_titleMarginEnd /*16*/:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0796a.topMargin) - c0796a.bottomMargin;
                        break;
                    case C1373c.AppCompatTheme_spinnerDropDownItemStyle /*48*/:
                        i11 = paddingTop + c0796a.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                        i11 = (paddingBottom - measuredHeight) - c0796a.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                paddingLeft = (m230c(i10) ? this.f155l + paddingLeft : paddingLeft) + c0796a.leftMargin;
                m212a(b, paddingLeft + m215a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (c0796a.rightMargin + measuredWidth) + m222b(b);
                i7 = m216a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    void m228b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = bj.m4867a(this);
        int i = 0;
        while (i < virtualChildCount) {
            View b = m225b(i);
            if (!(b == null || b.getVisibility() == 8 || !m230c(i))) {
                C0796a c0796a = (C0796a) b.getLayoutParams();
                m229b(canvas, a ? c0796a.rightMargin + b.getRight() : (b.getLeft() - c0796a.leftMargin) - this.f155l);
            }
            i++;
        }
        if (m230c(virtualChildCount)) {
            int paddingLeft;
            View b2 = m225b(virtualChildCount - 1);
            if (b2 == null) {
                paddingLeft = a ? getPaddingLeft() : (getWidth() - getPaddingRight()) - this.f155l;
            } else {
                c0796a = (C0796a) b2.getLayoutParams();
                paddingLeft = a ? (b2.getLeft() - c0796a.leftMargin) - this.f155l : c0796a.rightMargin + b2.getRight();
            }
            m229b(canvas, paddingLeft);
        }
    }

    void m229b(Canvas canvas, int i) {
        this.f154k.setBounds(i, getPaddingTop() + this.f158o, this.f155l + i, (getHeight() - getPaddingBottom()) - this.f158o);
        this.f154k.draw(canvas);
    }

    protected boolean m230c(int i) {
        if (i == 0) {
            return (this.f157n & 1) != 0;
        } else {
            if (i == getChildCount()) {
                return (this.f157n & 4) != 0;
            } else {
                if ((this.f157n & 2) == 0) {
                    return false;
                }
                for (int i2 = i - 1; i2 >= 0; i2--) {
                    if (getChildAt(i2).getVisibility() != 8) {
                        return true;
                    }
                }
                return false;
            }
        }
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0796a;
    }

    int m231d(int i) {
        return 0;
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m232j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m223b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m224b(layoutParams);
    }

    public int getBaseline() {
        if (this.f145b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f145b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f145b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f146c;
            if (this.f147d == 1) {
                i = this.f148e & C1373c.AppCompatTheme_spinnerStyle;
                if (i != 48) {
                    switch (i) {
                        case C1373c.Toolbar_titleMarginEnd /*16*/:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f149f) / 2);
                            break;
                        case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f149f;
                            break;
                    }
                }
            }
            i = i2;
            return (((C0796a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f145b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f145b;
    }

    public Drawable getDividerDrawable() {
        return this.f154k;
    }

    public int getDividerPadding() {
        return this.f158o;
    }

    public int getDividerWidth() {
        return this.f155l;
    }

    public int getOrientation() {
        return this.f147d;
    }

    public int getShowDividers() {
        return this.f157n;
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f150g;
    }

    protected C0796a m232j() {
        return this.f147d == 0 ? new C0796a(-2, -2) : this.f147d == 1 ? new C0796a(-1, -2) : null;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f154k != null) {
            if (this.f147d == 1) {
                m219a(canvas);
            } else {
                m228b(canvas);
            }
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(ak.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(ak.class.getName());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f147d == 1) {
            m218a(i, i2, i3, i4);
        } else {
            m227b(i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (this.f147d == 1) {
            m217a(i, i2);
        } else {
            m226b(i, i2);
        }
    }

    public void setBaselineAligned(boolean z) {
        this.f144a = z;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f145b = i;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f154k) {
            this.f154k = drawable;
            if (drawable != null) {
                this.f155l = drawable.getIntrinsicWidth();
                this.f156m = drawable.getIntrinsicHeight();
            } else {
                this.f155l = 0;
                this.f156m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f158o = i;
    }

    public void setGravity(int i) {
        if (this.f148e != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & C1373c.AppCompatTheme_spinnerStyle) == 0) {
                i2 |= 48;
            }
            this.f148e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f148e & 8388615) != i2) {
            this.f148e = i2 | (this.f148e & -8388616);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f151h = z;
    }

    public void setOrientation(int i) {
        if (this.f147d != i) {
            this.f147d = i;
            requestLayout();
        }
    }

    public void setShowDividers(int i) {
        if (i != this.f157n) {
            requestLayout();
        }
        this.f157n = i;
    }

    public void setVerticalGravity(int i) {
        int i2 = i & C1373c.AppCompatTheme_spinnerStyle;
        if ((this.f148e & C1373c.AppCompatTheme_spinnerStyle) != i2) {
            this.f148e = i2 | (this.f148e & -113);
            requestLayout();
        }
    }

    public void setWeightSum(float f) {
        this.f150g = Math.max(0.0f, f);
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }
}
