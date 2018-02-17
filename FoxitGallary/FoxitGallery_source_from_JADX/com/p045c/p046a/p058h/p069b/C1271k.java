package com.p045c.p046a.p058h.p069b;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.WindowManager;
import com.p045c.p046a.p058h.C1268b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.c.a.h.b.k */
public abstract class C1271k<T extends View, Z> extends C1196a<Z> {
    private static boolean f3199b;
    private static Integer f3200c;
    protected final T f3201a;
    private final C1280a f3202d;

    /* renamed from: com.c.a.h.b.k.a */
    private static class C1280a {
        private final View f3211a;
        private final List<C1269h> f3212b;
        private C1279a f3213c;
        private Point f3214d;

        /* renamed from: com.c.a.h.b.k.a.a */
        private static class C1279a implements OnPreDrawListener {
            private final WeakReference<C1280a> f3210a;

            public C1279a(C1280a c1280a) {
                this.f3210a = new WeakReference(c1280a);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called listener=" + this);
                }
                C1280a c1280a = (C1280a) this.f3210a.get();
                if (c1280a != null) {
                    c1280a.m6035a();
                }
                return true;
            }
        }

        public C1280a(View view) {
            this.f3212b = new ArrayList();
            this.f3211a = view;
        }

        private int m6034a(int i, boolean z) {
            if (i != -2) {
                return i;
            }
            Point d = m6041d();
            return z ? d.y : d.x;
        }

        private void m6035a() {
            if (!this.f3212b.isEmpty()) {
                int c = m6040c();
                int b = m6039b();
                if (m6038a(c) && m6038a(b)) {
                    m6036a(c, b);
                    ViewTreeObserver viewTreeObserver = this.f3211a.getViewTreeObserver();
                    if (viewTreeObserver.isAlive()) {
                        viewTreeObserver.removeOnPreDrawListener(this.f3213c);
                    }
                    this.f3213c = null;
                }
            }
        }

        private void m6036a(int i, int i2) {
            for (C1269h a : this.f3212b) {
                a.m5988a(i, i2);
            }
            this.f3212b.clear();
        }

        private boolean m6038a(int i) {
            return i > 0 || i == -2;
        }

        private int m6039b() {
            LayoutParams layoutParams = this.f3211a.getLayoutParams();
            return m6038a(this.f3211a.getHeight()) ? this.f3211a.getHeight() : layoutParams != null ? m6034a(layoutParams.height, true) : 0;
        }

        private int m6040c() {
            LayoutParams layoutParams = this.f3211a.getLayoutParams();
            return m6038a(this.f3211a.getWidth()) ? this.f3211a.getWidth() : layoutParams != null ? m6034a(layoutParams.width, false) : 0;
        }

        @TargetApi(13)
        private Point m6041d() {
            if (this.f3214d != null) {
                return this.f3214d;
            }
            Display defaultDisplay = ((WindowManager) this.f3211a.getContext().getSystemService("window")).getDefaultDisplay();
            if (VERSION.SDK_INT >= 13) {
                this.f3214d = new Point();
                defaultDisplay.getSize(this.f3214d);
            } else {
                this.f3214d = new Point(defaultDisplay.getWidth(), defaultDisplay.getHeight());
            }
            return this.f3214d;
        }

        public void m6042a(C1269h c1269h) {
            int c = m6040c();
            int b = m6039b();
            if (m6038a(c) && m6038a(b)) {
                c1269h.m5988a(c, b);
                return;
            }
            if (!this.f3212b.contains(c1269h)) {
                this.f3212b.add(c1269h);
            }
            if (this.f3213c == null) {
                ViewTreeObserver viewTreeObserver = this.f3211a.getViewTreeObserver();
                this.f3213c = new C1279a(this);
                viewTreeObserver.addOnPreDrawListener(this.f3213c);
            }
        }
    }

    static {
        f3199b = false;
        f3200c = null;
    }

    public C1271k(T t) {
        if (t == null) {
            throw new NullPointerException("View must not be null!");
        }
        this.f3201a = t;
        this.f3202d = new C1280a(t);
    }

    private void m6016a(Object obj) {
        if (f3200c == null) {
            f3199b = true;
            this.f3201a.setTag(obj);
            return;
        }
        this.f3201a.setTag(f3200c.intValue(), obj);
    }

    private Object m6017c() {
        return f3200c == null ? this.f3201a.getTag() : this.f3201a.getTag(f3200c.intValue());
    }

    public T m6018a() {
        return this.f3201a;
    }

    public C1268b getRequest() {
        Object c = m6017c();
        if (c == null) {
            return null;
        }
        if (c instanceof C1268b) {
            return (C1268b) c;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void getSize(C1269h c1269h) {
        this.f3202d.m6042a(c1269h);
    }

    public void setRequest(C1268b c1268b) {
        m6016a(c1268b);
    }

    public String toString() {
        return "Target for: " + this.f3201a;
    }
}
