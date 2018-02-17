package android.support.v4.widget;

import android.content.Context;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.af;
import android.support.v4.p016k.ah;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.Arrays;

public class ad {
    private static final Interpolator f971v;
    private int f972a;
    private int f973b;
    private int f974c;
    private float[] f975d;
    private float[] f976e;
    private float[] f977f;
    private float[] f978g;
    private int[] f979h;
    private int[] f980i;
    private int[] f981j;
    private int f982k;
    private VelocityTracker f983l;
    private float f984m;
    private float f985n;
    private int f986o;
    private int f987p;
    private C0632w f988q;
    private final C0128a f989r;
    private View f990s;
    private boolean f991t;
    private final ViewGroup f992u;
    private final Runnable f993w;

    /* renamed from: android.support.v4.widget.ad.a */
    public static abstract class C0128a {
        public int m370a(View view) {
            return 0;
        }

        public int m371a(View view, int i, int i2) {
            return 0;
        }

        public void m372a(int i) {
        }

        public void m373a(int i, int i2) {
        }

        public void m374a(View view, float f, float f2) {
        }

        public void m375a(View view, int i, int i2, int i3, int i4) {
        }

        public abstract boolean m376a(View view, int i);

        public int m377b(View view) {
            return 0;
        }

        public int m378b(View view, int i, int i2) {
            return 0;
        }

        public void m379b(int i, int i2) {
        }

        public void m380b(View view, int i) {
        }

        public boolean m381b(int i) {
            return false;
        }

        public int m382c(int i) {
            return i;
        }
    }

    /* renamed from: android.support.v4.widget.ad.1 */
    static class C05821 implements Interpolator {
        C05821() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    /* renamed from: android.support.v4.widget.ad.2 */
    class C05832 implements Runnable {
        final /* synthetic */ ad f970a;

        C05832(ad adVar) {
            this.f970a = adVar;
        }

        public void run() {
            this.f970a.m2567b(0);
        }
    }

    static {
        f971v = new C05821();
    }

    private ad(Context context, ViewGroup viewGroup, C0128a c0128a) {
        this.f974c = -1;
        this.f993w = new C05832(this);
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        } else if (c0128a == null) {
            throw new IllegalArgumentException("Callback may not be null");
        } else {
            this.f992u = viewGroup;
            this.f989r = c0128a;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            this.f986o = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
            this.f973b = viewConfiguration.getScaledTouchSlop();
            this.f984m = (float) viewConfiguration.getScaledMaximumFlingVelocity();
            this.f985n = (float) viewConfiguration.getScaledMinimumFlingVelocity();
            this.f988q = C0632w.m2777a(context, f971v);
        }
    }

    private float m2538a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    private float m2539a(float f, float f2, float f3) {
        float abs = Math.abs(f);
        return abs < f2 ? 0.0f : abs > f3 ? f <= 0.0f ? -f3 : f3 : f;
    }

    private int m2540a(int i, int i2, int i3) {
        if (i == 0) {
            return 0;
        }
        int width = this.f992u.getWidth();
        int i4 = width / 2;
        float a = (m2538a(Math.min(1.0f, ((float) Math.abs(i)) / ((float) width))) * ((float) i4)) + ((float) i4);
        i4 = Math.abs(i2);
        return Math.min(i4 > 0 ? Math.round(Math.abs(a / ((float) i4)) * 1000.0f) * 4 : (int) (((((float) Math.abs(i)) / ((float) i3)) + 1.0f) * 256.0f), 600);
    }

    private int m2541a(View view, int i, int i2, int i3, int i4) {
        int b = m2549b(i3, (int) this.f985n, (int) this.f984m);
        int b2 = m2549b(i4, (int) this.f985n, (int) this.f984m);
        int abs = Math.abs(i);
        int abs2 = Math.abs(i2);
        int abs3 = Math.abs(b);
        int abs4 = Math.abs(b2);
        int i5 = abs3 + abs4;
        int i6 = abs + abs2;
        return (int) (((b2 != 0 ? ((float) abs4) / ((float) i5) : ((float) abs2) / ((float) i6)) * ((float) m2540a(i2, b2, this.f989r.m370a(view)))) + ((b != 0 ? ((float) abs3) / ((float) i5) : ((float) abs) / ((float) i6)) * ((float) m2540a(i, b, this.f989r.m377b(view)))));
    }

    public static ad m2542a(ViewGroup viewGroup, float f, C0128a c0128a) {
        ad a = m2543a(viewGroup, c0128a);
        a.f973b = (int) (((float) a.f973b) * (1.0f / f));
        return a;
    }

    public static ad m2543a(ViewGroup viewGroup, C0128a c0128a) {
        return new ad(viewGroup.getContext(), viewGroup, c0128a);
    }

    private void m2544a(float f, float f2) {
        this.f991t = true;
        this.f989r.m374a(this.f990s, f, f2);
        this.f991t = false;
        if (this.f972a == 1) {
            m2567b(0);
        }
    }

    private void m2545a(float f, float f2, int i) {
        m2557d(i);
        float[] fArr = this.f975d;
        this.f977f[i] = f;
        fArr[i] = f;
        fArr = this.f976e;
        this.f978g[i] = f2;
        fArr[i] = f2;
        this.f979h[i] = m2555d((int) f, (int) f2);
        this.f982k |= 1 << i;
    }

    private boolean m2546a(float f, float f2, int i, int i2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if ((this.f979h[i] & i2) != i2 || (this.f987p & i2) == 0 || (this.f981j[i] & i2) == i2 || (this.f980i[i] & i2) == i2) {
            return false;
        }
        if (abs <= ((float) this.f973b) && abs2 <= ((float) this.f973b)) {
            return false;
        }
        if (abs >= abs2 * 0.5f || !this.f989r.m381b(i2)) {
            return (this.f980i[i] & i2) == 0 && abs > ((float) this.f973b);
        } else {
            int[] iArr = this.f981j;
            iArr[i] = iArr[i] | i2;
            return false;
        }
    }

    private boolean m2547a(int i, int i2, int i3, int i4) {
        int left = this.f990s.getLeft();
        int top = this.f990s.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.f988q.m2790h();
            m2567b(0);
            return false;
        }
        this.f988q.m2779a(left, top, i5, i6, m2541a(this.f990s, i5, i6, i3, i4));
        m2567b(2);
        return true;
    }

    private boolean m2548a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        boolean z = this.f989r.m377b(view) > 0;
        boolean z2 = this.f989r.m370a(view) > 0;
        return (z && z2) ? (f * f) + (f2 * f2) > ((float) (this.f973b * this.f973b)) : z ? Math.abs(f) > ((float) this.f973b) : z2 ? Math.abs(f2) > ((float) this.f973b) : false;
    }

    private int m2549b(int i, int i2, int i3) {
        int abs = Math.abs(i);
        return abs < i2 ? 0 : abs > i3 ? i <= 0 ? -i3 : i3 : i;
    }

    private void m2550b(float f, float f2, int i) {
        int i2 = 1;
        if (!m2546a(f, f2, i, 1)) {
            i2 = 0;
        }
        if (m2546a(f2, f, i, 4)) {
            i2 |= 4;
        }
        if (m2546a(f, f2, i, 2)) {
            i2 |= 2;
        }
        if (m2546a(f2, f, i, 8)) {
            i2 |= 8;
        }
        if (i2 != 0) {
            int[] iArr = this.f980i;
            iArr[i] = iArr[i] | i2;
            this.f989r.m379b(i2, i);
        }
    }

    private void m2551b(int i, int i2, int i3, int i4) {
        int b;
        int a;
        int left = this.f990s.getLeft();
        int top = this.f990s.getTop();
        if (i3 != 0) {
            b = this.f989r.m378b(this.f990s, i, i3);
            ah.m1939f(this.f990s, b - left);
        } else {
            b = i;
        }
        if (i4 != 0) {
            a = this.f989r.m371a(this.f990s, i2, i4);
            ah.m1936e(this.f990s, a - top);
        } else {
            a = i2;
        }
        if (i3 != 0 || i4 != 0) {
            this.f989r.m375a(this.f990s, b, a, b - left, a - top);
        }
    }

    private void m2552c() {
        if (this.f975d != null) {
            Arrays.fill(this.f975d, 0.0f);
            Arrays.fill(this.f976e, 0.0f);
            Arrays.fill(this.f977f, 0.0f);
            Arrays.fill(this.f978g, 0.0f);
            Arrays.fill(this.f979h, 0);
            Arrays.fill(this.f980i, 0);
            Arrays.fill(this.f981j, 0);
            this.f982k = 0;
        }
    }

    private void m2553c(int i) {
        if (this.f975d != null && m2561a(i)) {
            this.f975d[i] = 0.0f;
            this.f976e[i] = 0.0f;
            this.f977f[i] = 0.0f;
            this.f978g[i] = 0.0f;
            this.f979h[i] = 0;
            this.f980i[i] = 0;
            this.f981j[i] = 0;
            this.f982k &= (1 << i) ^ -1;
        }
    }

    private void m2554c(MotionEvent motionEvent) {
        int c = C0560t.m2397c(motionEvent);
        for (int i = 0; i < c; i++) {
            int b = C0560t.m2395b(motionEvent, i);
            if (m2558e(b)) {
                float c2 = C0560t.m2396c(motionEvent, i);
                float d = C0560t.m2398d(motionEvent, i);
                this.f977f[b] = c2;
                this.f978g[b] = d;
            }
        }
    }

    private int m2555d(int i, int i2) {
        int i3 = 0;
        if (i < this.f992u.getLeft() + this.f986o) {
            i3 = 1;
        }
        if (i2 < this.f992u.getTop() + this.f986o) {
            i3 |= 4;
        }
        if (i > this.f992u.getRight() - this.f986o) {
            i3 |= 2;
        }
        return i2 > this.f992u.getBottom() - this.f986o ? i3 | 8 : i3;
    }

    private void m2556d() {
        this.f983l.computeCurrentVelocity(1000, this.f984m);
        m2544a(m2539a(af.m1694a(this.f983l, this.f974c), this.f985n, this.f984m), m2539a(af.m1695b(this.f983l, this.f974c), this.f985n, this.f984m));
    }

    private void m2557d(int i) {
        if (this.f975d == null || this.f975d.length <= i) {
            Object obj = new float[(i + 1)];
            Object obj2 = new float[(i + 1)];
            Object obj3 = new float[(i + 1)];
            Object obj4 = new float[(i + 1)];
            Object obj5 = new int[(i + 1)];
            Object obj6 = new int[(i + 1)];
            Object obj7 = new int[(i + 1)];
            if (this.f975d != null) {
                System.arraycopy(this.f975d, 0, obj, 0, this.f975d.length);
                System.arraycopy(this.f976e, 0, obj2, 0, this.f976e.length);
                System.arraycopy(this.f977f, 0, obj3, 0, this.f977f.length);
                System.arraycopy(this.f978g, 0, obj4, 0, this.f978g.length);
                System.arraycopy(this.f979h, 0, obj5, 0, this.f979h.length);
                System.arraycopy(this.f980i, 0, obj6, 0, this.f980i.length);
                System.arraycopy(this.f981j, 0, obj7, 0, this.f981j.length);
            }
            this.f975d = obj;
            this.f976e = obj2;
            this.f977f = obj3;
            this.f978g = obj4;
            this.f979h = obj5;
            this.f980i = obj6;
            this.f981j = obj7;
        }
    }

    private boolean m2558e(int i) {
        if (m2561a(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received " + "for this pointer before ACTION_MOVE. It likely happened because " + " ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    public int m2559a() {
        return this.f973b;
    }

    public void m2560a(View view, int i) {
        if (view.getParent() != this.f992u) {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.f992u + ")");
        }
        this.f990s = view;
        this.f974c = i;
        this.f989r.m380b(view, i);
        m2567b(1);
    }

    public boolean m2561a(int i) {
        return (this.f982k & (1 << i)) != 0;
    }

    public boolean m2562a(int i, int i2) {
        if (this.f991t) {
            return m2547a(i, i2, (int) af.m1694a(this.f983l, this.f974c), (int) af.m1695b(this.f983l, this.f974c));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m2563a(android.view.MotionEvent r14) {
        /*
        r13 = this;
        r0 = android.support.v4.p016k.C0560t.m2392a(r14);
        r1 = android.support.v4.p016k.C0560t.m2394b(r14);
        if (r0 != 0) goto L_0x000d;
    L_0x000a:
        r13.m2566b();
    L_0x000d:
        r2 = r13.f983l;
        if (r2 != 0) goto L_0x0017;
    L_0x0011:
        r2 = android.view.VelocityTracker.obtain();
        r13.f983l = r2;
    L_0x0017:
        r2 = r13.f983l;
        r2.addMovement(r14);
        switch(r0) {
            case 0: goto L_0x0026;
            case 1: goto L_0x0128;
            case 2: goto L_0x0092;
            case 3: goto L_0x0128;
            case 4: goto L_0x001f;
            case 5: goto L_0x005a;
            case 6: goto L_0x011f;
            default: goto L_0x001f;
        };
    L_0x001f:
        r0 = r13.f972a;
        r1 = 1;
        if (r0 != r1) goto L_0x012d;
    L_0x0024:
        r0 = 1;
    L_0x0025:
        return r0;
    L_0x0026:
        r0 = r14.getX();
        r1 = r14.getY();
        r2 = 0;
        r2 = android.support.v4.p016k.C0560t.m2395b(r14, r2);
        r13.m2545a(r0, r1, r2);
        r0 = (int) r0;
        r1 = (int) r1;
        r0 = r13.m2572c(r0, r1);
        r1 = r13.f990s;
        if (r0 != r1) goto L_0x0048;
    L_0x0040:
        r1 = r13.f972a;
        r3 = 2;
        if (r1 != r3) goto L_0x0048;
    L_0x0045:
        r13.m2570b(r0, r2);
    L_0x0048:
        r0 = r13.f979h;
        r0 = r0[r2];
        r1 = r13.f987p;
        r1 = r1 & r0;
        if (r1 == 0) goto L_0x001f;
    L_0x0051:
        r1 = r13.f989r;
        r3 = r13.f987p;
        r0 = r0 & r3;
        r1.m373a(r0, r2);
        goto L_0x001f;
    L_0x005a:
        r0 = android.support.v4.p016k.C0560t.m2395b(r14, r1);
        r2 = android.support.v4.p016k.C0560t.m2396c(r14, r1);
        r1 = android.support.v4.p016k.C0560t.m2398d(r14, r1);
        r13.m2545a(r2, r1, r0);
        r3 = r13.f972a;
        if (r3 != 0) goto L_0x007f;
    L_0x006d:
        r1 = r13.f979h;
        r1 = r1[r0];
        r2 = r13.f987p;
        r2 = r2 & r1;
        if (r2 == 0) goto L_0x001f;
    L_0x0076:
        r2 = r13.f989r;
        r3 = r13.f987p;
        r1 = r1 & r3;
        r2.m373a(r1, r0);
        goto L_0x001f;
    L_0x007f:
        r3 = r13.f972a;
        r4 = 2;
        if (r3 != r4) goto L_0x001f;
    L_0x0084:
        r2 = (int) r2;
        r1 = (int) r1;
        r1 = r13.m2572c(r2, r1);
        r2 = r13.f990s;
        if (r1 != r2) goto L_0x001f;
    L_0x008e:
        r13.m2570b(r1, r0);
        goto L_0x001f;
    L_0x0092:
        r0 = r13.f975d;
        if (r0 == 0) goto L_0x001f;
    L_0x0096:
        r0 = r13.f976e;
        if (r0 == 0) goto L_0x001f;
    L_0x009a:
        r2 = android.support.v4.p016k.C0560t.m2397c(r14);
        r0 = 0;
        r1 = r0;
    L_0x00a0:
        if (r1 >= r2) goto L_0x0107;
    L_0x00a2:
        r3 = android.support.v4.p016k.C0560t.m2395b(r14, r1);
        r0 = r13.m2558e(r3);
        if (r0 != 0) goto L_0x00b0;
    L_0x00ac:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00a0;
    L_0x00b0:
        r0 = android.support.v4.p016k.C0560t.m2396c(r14, r1);
        r4 = android.support.v4.p016k.C0560t.m2398d(r14, r1);
        r5 = r13.f975d;
        r5 = r5[r3];
        r5 = r0 - r5;
        r6 = r13.f976e;
        r6 = r6[r3];
        r6 = r4 - r6;
        r0 = (int) r0;
        r4 = (int) r4;
        r4 = r13.m2572c(r0, r4);
        if (r4 == 0) goto L_0x010c;
    L_0x00cc:
        r0 = r13.m2548a(r4, r5, r6);
        if (r0 == 0) goto L_0x010c;
    L_0x00d2:
        r0 = 1;
    L_0x00d3:
        if (r0 == 0) goto L_0x010e;
    L_0x00d5:
        r7 = r4.getLeft();
        r8 = (int) r5;
        r8 = r8 + r7;
        r9 = r13.f989r;
        r10 = (int) r5;
        r8 = r9.m378b(r4, r8, r10);
        r9 = r4.getTop();
        r10 = (int) r6;
        r10 = r10 + r9;
        r11 = r13.f989r;
        r12 = (int) r6;
        r10 = r11.m371a(r4, r10, r12);
        r11 = r13.f989r;
        r11 = r11.m377b(r4);
        r12 = r13.f989r;
        r12 = r12.m370a(r4);
        if (r11 == 0) goto L_0x0101;
    L_0x00fd:
        if (r11 <= 0) goto L_0x010e;
    L_0x00ff:
        if (r8 != r7) goto L_0x010e;
    L_0x0101:
        if (r12 == 0) goto L_0x0107;
    L_0x0103:
        if (r12 <= 0) goto L_0x010e;
    L_0x0105:
        if (r10 != r9) goto L_0x010e;
    L_0x0107:
        r13.m2554c(r14);
        goto L_0x001f;
    L_0x010c:
        r0 = 0;
        goto L_0x00d3;
    L_0x010e:
        r13.m2550b(r5, r6, r3);
        r5 = r13.f972a;
        r6 = 1;
        if (r5 == r6) goto L_0x0107;
    L_0x0116:
        if (r0 == 0) goto L_0x00ac;
    L_0x0118:
        r0 = r13.m2570b(r4, r3);
        if (r0 == 0) goto L_0x00ac;
    L_0x011e:
        goto L_0x0107;
    L_0x011f:
        r0 = android.support.v4.p016k.C0560t.m2395b(r14, r1);
        r13.m2553c(r0);
        goto L_0x001f;
    L_0x0128:
        r13.m2566b();
        goto L_0x001f;
    L_0x012d:
        r0 = 0;
        goto L_0x0025;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.widget.ad.a(android.view.MotionEvent):boolean");
    }

    public boolean m2564a(View view, int i, int i2) {
        this.f990s = view;
        this.f974c = -1;
        boolean a = m2547a(i, i2, 0, 0);
        if (!(a || this.f972a != 0 || this.f990s == null)) {
            this.f990s = null;
        }
        return a;
    }

    public boolean m2565a(boolean z) {
        if (this.f972a == 2) {
            int i;
            boolean g = this.f988q.m2789g();
            int b = this.f988q.m2784b();
            int c = this.f988q.m2785c();
            int left = b - this.f990s.getLeft();
            int top = c - this.f990s.getTop();
            if (left != 0) {
                ah.m1939f(this.f990s, left);
            }
            if (top != 0) {
                ah.m1936e(this.f990s, top);
            }
            if (!(left == 0 && top == 0)) {
                this.f989r.m375a(this.f990s, b, c, left, top);
            }
            if (g && b == this.f988q.m2786d() && c == this.f988q.m2787e()) {
                this.f988q.m2790h();
                i = 0;
            } else {
                boolean z2 = g;
            }
            if (i == 0) {
                if (z) {
                    this.f992u.post(this.f993w);
                } else {
                    m2567b(0);
                }
            }
        }
        return this.f972a == 2;
    }

    public void m2566b() {
        this.f974c = -1;
        m2552c();
        if (this.f983l != null) {
            this.f983l.recycle();
            this.f983l = null;
        }
    }

    void m2567b(int i) {
        this.f992u.removeCallbacks(this.f993w);
        if (this.f972a != i) {
            this.f972a = i;
            this.f989r.m372a(i);
            if (this.f972a == 0) {
                this.f990s = null;
            }
        }
    }

    public void m2568b(MotionEvent motionEvent) {
        int i = 0;
        int a = C0560t.m2392a(motionEvent);
        int b = C0560t.m2394b(motionEvent);
        if (a == 0) {
            m2566b();
        }
        if (this.f983l == null) {
            this.f983l = VelocityTracker.obtain();
        }
        this.f983l.addMovement(motionEvent);
        float x;
        float y;
        View c;
        int i2;
        switch (a) {
            case C1373c.View_android_theme /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                i = C0560t.m2395b(motionEvent, 0);
                c = m2572c((int) x, (int) y);
                m2545a(x, y, i);
                m2570b(c, i);
                i2 = this.f979h[i];
                if ((this.f987p & i2) != 0) {
                    this.f989r.m373a(i2 & this.f987p, i);
                }
            case C1373c.View_android_focusable /*1*/:
                if (this.f972a == 1) {
                    m2556d();
                }
                m2566b();
            case C1373c.View_paddingStart /*2*/:
                if (this.f972a != 1) {
                    i2 = C0560t.m2397c(motionEvent);
                    while (i < i2) {
                        a = C0560t.m2395b(motionEvent, i);
                        if (m2558e(a)) {
                            float c2 = C0560t.m2396c(motionEvent, i);
                            float d = C0560t.m2398d(motionEvent, i);
                            float f = c2 - this.f975d[a];
                            float f2 = d - this.f976e[a];
                            m2550b(f, f2, a);
                            if (this.f972a != 1) {
                                c = m2572c((int) c2, (int) d);
                                if (m2548a(c, f, f2) && m2570b(c, a)) {
                                }
                            }
                            m2554c(motionEvent);
                        }
                        i++;
                    }
                    m2554c(motionEvent);
                } else if (m2558e(this.f974c)) {
                    i = C0560t.m2393a(motionEvent, this.f974c);
                    x = C0560t.m2396c(motionEvent, i);
                    i2 = (int) (x - this.f977f[this.f974c]);
                    i = (int) (C0560t.m2398d(motionEvent, i) - this.f978g[this.f974c]);
                    m2551b(this.f990s.getLeft() + i2, this.f990s.getTop() + i, i2, i);
                    m2554c(motionEvent);
                }
            case C1373c.View_paddingEnd /*3*/:
                if (this.f972a == 1) {
                    m2544a(0.0f, 0.0f);
                }
                m2566b();
            case C1373c.Toolbar_contentInsetStart /*5*/:
                i = C0560t.m2395b(motionEvent, b);
                x = C0560t.m2396c(motionEvent, b);
                y = C0560t.m2398d(motionEvent, b);
                m2545a(x, y, i);
                if (this.f972a == 0) {
                    m2570b(m2572c((int) x, (int) y), i);
                    i2 = this.f979h[i];
                    if ((this.f987p & i2) != 0) {
                        this.f989r.m373a(i2 & this.f987p, i);
                    }
                } else if (m2569b((int) x, (int) y)) {
                    m2570b(this.f990s, i);
                }
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                a = C0560t.m2395b(motionEvent, b);
                if (this.f972a == 1 && a == this.f974c) {
                    b = C0560t.m2397c(motionEvent);
                    while (i < b) {
                        int b2 = C0560t.m2395b(motionEvent, i);
                        if (b2 != this.f974c) {
                            if (m2572c((int) C0560t.m2396c(motionEvent, i), (int) C0560t.m2398d(motionEvent, i)) == this.f990s && m2570b(this.f990s, b2)) {
                                i = this.f974c;
                                if (i == -1) {
                                    m2556d();
                                }
                            }
                        }
                        i++;
                    }
                    i = -1;
                    if (i == -1) {
                        m2556d();
                    }
                }
                m2553c(a);
            default:
        }
    }

    public boolean m2569b(int i, int i2) {
        return m2571b(this.f990s, i, i2);
    }

    boolean m2570b(View view, int i) {
        if (view == this.f990s && this.f974c == i) {
            return true;
        }
        if (view == null || !this.f989r.m376a(view, i)) {
            return false;
        }
        this.f974c = i;
        m2560a(view, i);
        return true;
    }

    public boolean m2571b(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    public View m2572c(int i, int i2) {
        for (int childCount = this.f992u.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.f992u.getChildAt(this.f989r.m382c(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }
}
