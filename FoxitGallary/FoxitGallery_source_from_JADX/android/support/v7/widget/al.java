package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v4.p016k.ac;
import android.support.v7.widget.RecyclerView.C0810i;
import android.support.v7.widget.RecyclerView.C0812h;
import android.support.v7.widget.RecyclerView.C0813r;
import android.support.v7.widget.RecyclerView.C0813r.C0849a;
import android.support.v7.widget.RecyclerView.C0850s;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public abstract class al extends C0813r {
    private final float f1864a;
    protected final LinearInterpolator f1865b;
    protected final DecelerateInterpolator f1866c;
    protected PointF f1867d;
    protected int f1868e;
    protected int f1869f;

    public al(Context context) {
        this.f1865b = new LinearInterpolator();
        this.f1866c = new DecelerateInterpolator();
        this.f1868e = 0;
        this.f1869f = 0;
        this.f1864a = m4009a(context.getResources().getDisplayMetrics());
    }

    private int m4008a(int i, int i2) {
        int i3 = i - i2;
        return i * i3 <= 0 ? 0 : i3;
    }

    protected float m4009a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    public int m4010a(int i, int i2, int i3, int i4, int i5) {
        switch (i5) {
            case ac.POSITION_UNCHANGED /*-1*/:
                return i3 - i;
            case C1373c.View_android_theme /*0*/:
                int i6 = i3 - i;
                if (i6 > 0) {
                    return i6;
                }
                i6 = i4 - i2;
                return i6 >= 0 ? 0 : i6;
            case C1373c.View_android_focusable /*1*/:
                return i4 - i2;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int m4011a(View view, int i) {
        C0812h e = m4001e();
        if (e == null || !e.m3850f()) {
            return 0;
        }
        C0810i c0810i = (C0810i) view.getLayoutParams();
        return m4010a(e.m3857i(view) - c0810i.topMargin, e.m3861k(view) + c0810i.bottomMargin, e.m3756A(), e.m3879y() - e.m3758C(), i);
    }

    public abstract PointF m4012a(int i);

    protected void m4013a() {
    }

    protected void m4014a(int i, int i2, C0850s c0850s, C0849a c0849a) {
        if (m4007j() == 0) {
            m4003f();
            return;
        }
        this.f1868e = m4008a(this.f1868e, i);
        this.f1869f = m4008a(this.f1869f, i2);
        if (this.f1868e == 0 && this.f1869f == 0) {
            m4015a(c0849a);
        }
    }

    protected void m4015a(C0849a c0849a) {
        PointF a = m4012a(m4006i());
        if (a == null || (a.x == 0.0f && a.y == 0.0f)) {
            Log.e("LinearSmoothScroller", "To support smooth scrolling, you should override \nLayoutManager#computeScrollVectorForPosition.\nFalling back to instant scroll");
            c0849a.m4197a(m4006i());
            m4003f();
            return;
        }
        m3995a(a);
        this.f1867d = a;
        this.f1868e = (int) (a.x * 10000.0f);
        this.f1869f = (int) (a.y * 10000.0f);
        c0849a.m4198a((int) (((float) this.f1868e) * 1.2f), (int) (((float) this.f1869f) * 1.2f), (int) (((float) m4021c(10000)) * 1.2f), this.f1865b);
    }

    protected void m4016a(View view, C0850s c0850s, C0849a c0849a) {
        int b = m4018b(view, m4020c());
        int a = m4011a(view, m4022d());
        int b2 = m4017b((int) Math.sqrt((double) ((b * b) + (a * a))));
        if (b2 > 0) {
            c0849a.m4198a(-b, -a, b2, this.f1866c);
        }
    }

    protected int m4017b(int i) {
        return (int) Math.ceil(((double) m4021c(i)) / 0.3356d);
    }

    public int m4018b(View view, int i) {
        C0812h e = m4001e();
        if (e == null || !e.m3845e()) {
            return 0;
        }
        C0810i c0810i = (C0810i) view.getLayoutParams();
        return m4010a(e.m3855h(view) - c0810i.leftMargin, e.m3859j(view) + c0810i.rightMargin, e.m3880z(), e.m3878x() - e.m3757B(), i);
    }

    protected void m4019b() {
        this.f1869f = 0;
        this.f1868e = 0;
        this.f1867d = null;
    }

    protected int m4020c() {
        return (this.f1867d == null || this.f1867d.x == 0.0f) ? 0 : this.f1867d.x > 0.0f ? 1 : -1;
    }

    protected int m4021c(int i) {
        return (int) Math.ceil((double) (((float) Math.abs(i)) * this.f1864a));
    }

    protected int m4022d() {
        return (this.f1867d == null || this.f1867d.y == 0.0f) ? 0 : this.f1867d.y > 0.0f ? 1 : -1;
    }
}
