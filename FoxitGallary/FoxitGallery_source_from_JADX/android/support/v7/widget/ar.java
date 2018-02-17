package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView.C0810i;
import android.support.v7.widget.RecyclerView.C0812h;
import android.view.View;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public abstract class ar {
    protected final C0812h f2273a;
    final Rect f2274b;
    private int f2275c;

    /* renamed from: android.support.v7.widget.ar.1 */
    static class C09091 extends ar {
        C09091(C0812h c0812h) {
            super(null);
        }

        public int m4682a(View view) {
            return this.a.m3855h(view) - ((C0810i) view.getLayoutParams()).leftMargin;
        }

        public void m4683a(int i) {
            this.a.m3860j(i);
        }

        public int m4684b(View view) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            return c0810i.rightMargin + this.a.m3859j(view);
        }

        public int m4685c() {
            return this.a.m3880z();
        }

        public int m4686c(View view) {
            this.a.m3798a(view, true, this.b);
            return this.b.right;
        }

        public int m4687d() {
            return this.a.m3878x() - this.a.m3757B();
        }

        public int m4688d(View view) {
            this.a.m3798a(view, true, this.b);
            return this.b.left;
        }

        public int m4689e() {
            return this.a.m3878x();
        }

        public int m4690e(View view) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            return c0810i.rightMargin + (this.a.m3848f(view) + c0810i.leftMargin);
        }

        public int m4691f() {
            return (this.a.m3878x() - this.a.m3880z()) - this.a.m3757B();
        }

        public int m4692f(View view) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            return c0810i.bottomMargin + (this.a.m3852g(view) + c0810i.topMargin);
        }

        public int m4693g() {
            return this.a.m3757B();
        }

        public int m4694h() {
            return this.a.m3876v();
        }

        public int m4695i() {
            return this.a.m3877w();
        }
    }

    /* renamed from: android.support.v7.widget.ar.2 */
    static class C09102 extends ar {
        C09102(C0812h c0812h) {
            super(null);
        }

        public int m4696a(View view) {
            return this.a.m3857i(view) - ((C0810i) view.getLayoutParams()).topMargin;
        }

        public void m4697a(int i) {
            this.a.m3862k(i);
        }

        public int m4698b(View view) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            return c0810i.bottomMargin + this.a.m3861k(view);
        }

        public int m4699c() {
            return this.a.m3756A();
        }

        public int m4700c(View view) {
            this.a.m3798a(view, true, this.b);
            return this.b.bottom;
        }

        public int m4701d() {
            return this.a.m3879y() - this.a.m3758C();
        }

        public int m4702d(View view) {
            this.a.m3798a(view, true, this.b);
            return this.b.top;
        }

        public int m4703e() {
            return this.a.m3879y();
        }

        public int m4704e(View view) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            return c0810i.bottomMargin + (this.a.m3852g(view) + c0810i.topMargin);
        }

        public int m4705f() {
            return (this.a.m3879y() - this.a.m3756A()) - this.a.m3758C();
        }

        public int m4706f(View view) {
            C0810i c0810i = (C0810i) view.getLayoutParams();
            return c0810i.rightMargin + (this.a.m3848f(view) + c0810i.leftMargin);
        }

        public int m4707g() {
            return this.a.m3758C();
        }

        public int m4708h() {
            return this.a.m3877w();
        }

        public int m4709i() {
            return this.a.m3876v();
        }
    }

    private ar(C0812h c0812h) {
        this.f2275c = Integer.MIN_VALUE;
        this.f2274b = new Rect();
        this.f2273a = c0812h;
    }

    public static ar m4663a(C0812h c0812h) {
        return new C09091(c0812h);
    }

    public static ar m4664a(C0812h c0812h, int i) {
        switch (i) {
            case C1373c.View_android_theme /*0*/:
                return m4663a(c0812h);
            case C1373c.View_android_focusable /*1*/:
                return m4665b(c0812h);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static ar m4665b(C0812h c0812h) {
        return new C09102(c0812h);
    }

    public abstract int m4666a(View view);

    public void m4667a() {
        this.f2275c = m4677f();
    }

    public abstract void m4668a(int i);

    public int m4669b() {
        return Integer.MIN_VALUE == this.f2275c ? 0 : m4677f() - this.f2275c;
    }

    public abstract int m4670b(View view);

    public abstract int m4671c();

    public abstract int m4672c(View view);

    public abstract int m4673d();

    public abstract int m4674d(View view);

    public abstract int m4675e();

    public abstract int m4676e(View view);

    public abstract int m4677f();

    public abstract int m4678f(View view);

    public abstract int m4679g();

    public abstract int m4680h();

    public abstract int m4681i();
}
