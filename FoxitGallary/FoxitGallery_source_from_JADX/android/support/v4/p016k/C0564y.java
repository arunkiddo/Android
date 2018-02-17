package android.support.v4.p016k;

import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.v4.k.y */
public class C0564y {
    private final View f856a;
    private ViewParent f857b;
    private boolean f858c;
    private int[] f859d;

    public C0564y(View view) {
        this.f856a = view;
    }

    public void m2408a(boolean z) {
        if (this.f858c) {
            ah.m1900C(this.f856a);
        }
        this.f858c = z;
    }

    public boolean m2409a() {
        return this.f858c;
    }

    public boolean m2410a(float f, float f2) {
        return (!m2409a() || this.f857b == null) ? false : ax.m2098a(this.f857b, this.f856a, f, f2);
    }

    public boolean m2411a(float f, float f2, boolean z) {
        return (!m2409a() || this.f857b == null) ? false : ax.m2099a(this.f857b, this.f856a, f, f2, z);
    }

    public boolean m2412a(int i) {
        if (m2415b()) {
            return true;
        }
        if (m2409a()) {
            View view = this.f856a;
            for (ViewParent parent = this.f856a.getParent(); parent != null; parent = parent.getParent()) {
                if (ax.m2100a(parent, view, this.f856a, i)) {
                    this.f857b = parent;
                    ax.m2101b(parent, view, this.f856a, i);
                    return true;
                }
                if (parent instanceof View) {
                    view = (View) parent;
                }
            }
        }
        return false;
    }

    public boolean m2413a(int i, int i2, int i3, int i4, int[] iArr) {
        if (!m2409a() || this.f857b == null) {
            return false;
        }
        if (i != 0 || i2 != 0 || i3 != 0 || i4 != 0) {
            int i5;
            int i6;
            if (iArr != null) {
                this.f856a.getLocationInWindow(iArr);
                int i7 = iArr[0];
                i5 = iArr[1];
                i6 = i7;
            } else {
                i5 = 0;
                i6 = 0;
            }
            ax.m2096a(this.f857b, this.f856a, i, i2, i3, i4);
            if (iArr != null) {
                this.f856a.getLocationInWindow(iArr);
                iArr[0] = iArr[0] - i6;
                iArr[1] = iArr[1] - i5;
            }
            return true;
        } else if (iArr == null) {
            return false;
        } else {
            iArr[0] = 0;
            iArr[1] = 0;
            return false;
        }
    }

    public boolean m2414a(int i, int i2, int[] iArr, int[] iArr2) {
        if (!m2409a() || this.f857b == null) {
            return false;
        }
        if (i != 0 || i2 != 0) {
            int i3;
            int i4;
            if (iArr2 != null) {
                this.f856a.getLocationInWindow(iArr2);
                i3 = iArr2[0];
                i4 = iArr2[1];
            } else {
                i4 = 0;
                i3 = 0;
            }
            if (iArr == null) {
                if (this.f859d == null) {
                    this.f859d = new int[2];
                }
                iArr = this.f859d;
            }
            iArr[0] = 0;
            iArr[1] = 0;
            ax.m2097a(this.f857b, this.f856a, i, i2, iArr);
            if (iArr2 != null) {
                this.f856a.getLocationInWindow(iArr2);
                iArr2[0] = iArr2[0] - i3;
                iArr2[1] = iArr2[1] - i4;
            }
            return (iArr[0] == 0 && iArr[1] == 0) ? false : true;
        } else if (iArr2 == null) {
            return false;
        } else {
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
    }

    public boolean m2415b() {
        return this.f857b != null;
    }

    public void m2416c() {
        if (this.f857b != null) {
            ax.m2095a(this.f857b, this.f856a);
            this.f857b = null;
        }
    }
}
