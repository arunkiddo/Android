package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.design.C0110a.C0103a;
import android.support.design.C0110a.C0105c;
import android.support.design.C0110a.C0106d;
import android.support.design.C0110a.C0107e;
import android.support.design.C0110a.C0109g;
import android.support.design.widget.C0192n.C0154a;
import android.support.design.widget.CoordinatorLayout.C0122b;
import android.support.design.widget.CoordinatorLayout.C0138e;
import android.support.design.widget.SwipeDismissBehavior.C0156a;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.be;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public final class Snackbar {
    private static final Handler f335a;
    private final ViewGroup f336b;
    private final Context f337c;
    private final SnackbarLayout f338d;
    private int f339e;
    private C0166b f340f;
    private final AccessibilityManager f341g;
    private final C0154a f342h;

    /* renamed from: android.support.design.widget.Snackbar.10 */
    class AnonymousClass10 extends be {
        final /* synthetic */ int f305a;
        final /* synthetic */ Snackbar f306b;

        AnonymousClass10(Snackbar snackbar, int i) {
            this.f306b = snackbar;
            this.f305a = i;
        }

        public void m542a(View view) {
            this.f306b.f338d.m563b(0, 180);
        }

        public void m543b(View view) {
            this.f306b.m600f(this.f305a);
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.1 */
    static class C01511 implements Callback {
        C01511() {
        }

        public boolean handleMessage(Message message) {
            switch (message.what) {
                case C1373c.View_android_theme /*0*/:
                    ((Snackbar) message.obj).m613e();
                    return true;
                case C1373c.View_android_focusable /*1*/:
                    ((Snackbar) message.obj).m610c(message.arg1);
                    return true;
                default:
                    return false;
            }
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.2 */
    class C01522 implements AnimationListener {
        final /* synthetic */ int f307a;
        final /* synthetic */ Snackbar f308b;

        C01522(Snackbar snackbar, int i) {
            this.f308b = snackbar;
            this.f307a = i;
        }

        public void onAnimationEnd(Animation animation) {
            this.f308b.m600f(this.f307a);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.3 */
    class C01533 implements OnClickListener {
        final /* synthetic */ OnClickListener f309a;
        final /* synthetic */ Snackbar f310b;

        C01533(Snackbar snackbar, OnClickListener onClickListener) {
            this.f310b = snackbar;
            this.f309a = onClickListener;
        }

        public void onClick(View view) {
            this.f309a.onClick(view);
            this.f310b.m595d(1);
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.4 */
    class C01554 implements C0154a {
        final /* synthetic */ Snackbar f311a;

        C01554(Snackbar snackbar) {
            this.f311a = snackbar;
        }

        public void m546a() {
            Snackbar.f335a.sendMessage(Snackbar.f335a.obtainMessage(0, this.f311a));
        }

        public void m547a(int i) {
            Snackbar.f335a.sendMessage(Snackbar.f335a.obtainMessage(1, i, 0, this.f311a));
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.5 */
    class C01575 implements C0156a {
        final /* synthetic */ Snackbar f312a;

        C01575(Snackbar snackbar) {
            this.f312a = snackbar;
        }

        public void m550a(int i) {
            switch (i) {
                case C1373c.View_android_theme /*0*/:
                    C0192n.m700a().m713d(this.f312a.f342h);
                case C1373c.View_android_focusable /*1*/:
                case C1373c.View_paddingStart /*2*/:
                    C0192n.m700a().m712c(this.f312a.f342h);
                default:
            }
        }

        public void m551a(View view) {
            view.setVisibility(8);
            this.f312a.m595d(0);
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.6 */
    class C01606 implements C0159a {
        final /* synthetic */ Snackbar f314a;

        /* renamed from: android.support.design.widget.Snackbar.6.1 */
        class C01581 implements Runnable {
            final /* synthetic */ C01606 f313a;

            C01581(C01606 c01606) {
                this.f313a = c01606;
            }

            public void run() {
                this.f313a.f314a.m600f(3);
            }
        }

        C01606(Snackbar snackbar) {
            this.f314a = snackbar;
        }

        public void m554a(View view) {
        }

        public void m555b(View view) {
            if (this.f314a.m612d()) {
                Snackbar.f335a.post(new C01581(this));
            }
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.7 */
    class C01627 implements C0161b {
        final /* synthetic */ Snackbar f315a;

        C01627(Snackbar snackbar) {
            this.f315a = snackbar;
        }

        public void m557a(View view, int i, int i2, int i3, int i4) {
            this.f315a.f338d.setOnLayoutChangeListener(null);
            if (this.f315a.m603i()) {
                this.f315a.m601g();
            } else {
                this.f315a.m602h();
            }
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.8 */
    class C01638 extends be {
        final /* synthetic */ Snackbar f316a;

        C01638(Snackbar snackbar) {
            this.f316a = snackbar;
        }

        public void m558a(View view) {
            this.f316a.f338d.m562a(70, 180);
        }

        public void m559b(View view) {
            this.f316a.m602h();
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.9 */
    class C01649 implements AnimationListener {
        final /* synthetic */ Snackbar f317a;

        C01649(Snackbar snackbar) {
            this.f317a = snackbar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f317a.m602h();
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static class SnackbarLayout extends LinearLayout {
        private TextView f318a;
        private Button f319b;
        private int f320c;
        private int f321d;
        private C0161b f322e;
        private C0159a f323f;

        /* renamed from: android.support.design.widget.Snackbar.SnackbarLayout.a */
        interface C0159a {
            void m552a(View view);

            void m553b(View view);
        }

        /* renamed from: android.support.design.widget.Snackbar.SnackbarLayout.b */
        interface C0161b {
            void m556a(View view, int i, int i2, int i3, int i4);
        }

        public SnackbarLayout(Context context) {
            this(context, null);
        }

        public SnackbarLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0109g.SnackbarLayout);
            this.f320c = obtainStyledAttributes.getDimensionPixelSize(C0109g.SnackbarLayout_android_maxWidth, -1);
            this.f321d = obtainStyledAttributes.getDimensionPixelSize(C0109g.SnackbarLayout_maxActionInlineWidth, -1);
            if (obtainStyledAttributes.hasValue(C0109g.SnackbarLayout_elevation)) {
                ah.m1938f((View) this, (float) obtainStyledAttributes.getDimensionPixelSize(C0109g.SnackbarLayout_elevation, 0));
            }
            obtainStyledAttributes.recycle();
            setClickable(true);
            LayoutInflater.from(context).inflate(C0107e.design_layout_snackbar_include, this);
            ah.m1933d((View) this, 1);
            ah.m1928c((View) this, 1);
        }

        private static void m560a(View view, int i, int i2) {
            if (ah.m1958y(view)) {
                ah.m1911a(view, ah.m1944k(view), i, ah.m1945l(view), i2);
            } else {
                view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
            }
        }

        private boolean m561a(int i, int i2, int i3) {
            boolean z = false;
            if (i != getOrientation()) {
                setOrientation(i);
                z = true;
            }
            if (this.f318a.getPaddingTop() == i2 && this.f318a.getPaddingBottom() == i3) {
                return z;
            }
            m560a(this.f318a, i2, i3);
            return true;
        }

        void m562a(int i, int i2) {
            ah.m1927c(this.f318a, 0.0f);
            ah.m1951r(this.f318a).m2157a(1.0f).m2158a((long) i2).m2163b((long) i).m2166c();
            if (this.f319b.getVisibility() == 0) {
                ah.m1927c(this.f319b, 0.0f);
                ah.m1951r(this.f319b).m2157a(1.0f).m2158a((long) i2).m2163b((long) i).m2166c();
            }
        }

        void m563b(int i, int i2) {
            ah.m1927c(this.f318a, 1.0f);
            ah.m1951r(this.f318a).m2157a(0.0f).m2158a((long) i2).m2163b((long) i).m2166c();
            if (this.f319b.getVisibility() == 0) {
                ah.m1927c(this.f319b, 1.0f);
                ah.m1951r(this.f319b).m2157a(0.0f).m2158a((long) i2).m2163b((long) i).m2166c();
            }
        }

        Button getActionView() {
            return this.f319b;
        }

        TextView getMessageView() {
            return this.f318a;
        }

        protected void onAttachedToWindow() {
            super.onAttachedToWindow();
            if (this.f323f != null) {
                this.f323f.m552a(this);
            }
        }

        protected void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            if (this.f323f != null) {
                this.f323f.m553b(this);
            }
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            this.f318a = (TextView) findViewById(C0106d.snackbar_text);
            this.f319b = (Button) findViewById(C0106d.snackbar_action);
        }

        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (this.f322e != null) {
                this.f322e.m556a(this, i, i2, i3, i4);
            }
        }

        protected void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.f320c > 0 && getMeasuredWidth() > this.f320c) {
                i = MeasureSpec.makeMeasureSpec(this.f320c, 1073741824);
                super.onMeasure(i, i2);
            }
            int dimensionPixelSize = getResources().getDimensionPixelSize(C0105c.design_snackbar_padding_vertical_2lines);
            int dimensionPixelSize2 = getResources().getDimensionPixelSize(C0105c.design_snackbar_padding_vertical);
            int i3 = this.f318a.getLayout().getLineCount() > 1 ? 1 : 0;
            if (i3 == 0 || this.f321d <= 0 || this.f319b.getMeasuredWidth() <= this.f321d) {
                if (i3 == 0) {
                    dimensionPixelSize = dimensionPixelSize2;
                }
                if (m561a(0, dimensionPixelSize, dimensionPixelSize)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            } else {
                if (m561a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
                    dimensionPixelSize = 1;
                }
                dimensionPixelSize = 0;
            }
            if (dimensionPixelSize != 0) {
                super.onMeasure(i, i2);
            }
        }

        void setOnAttachStateChangeListener(C0159a c0159a) {
            this.f323f = c0159a;
        }

        void setOnLayoutChangeListener(C0161b c0161b) {
            this.f322e = c0161b;
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.a */
    final class C0165a extends SwipeDismissBehavior<SnackbarLayout> {
        final /* synthetic */ Snackbar f334a;

        C0165a(Snackbar snackbar) {
            this.f334a = snackbar;
        }

        public boolean m583a(CoordinatorLayout coordinatorLayout, SnackbarLayout snackbarLayout, MotionEvent motionEvent) {
            if (coordinatorLayout.m482a((View) snackbarLayout, (int) motionEvent.getX(), (int) motionEvent.getY())) {
                switch (motionEvent.getActionMasked()) {
                    case C1373c.View_android_theme /*0*/:
                        C0192n.m700a().m712c(this.f334a.f342h);
                        break;
                    case C1373c.View_android_focusable /*1*/:
                    case C1373c.View_paddingEnd /*3*/:
                        C0192n.m700a().m713d(this.f334a.f342h);
                        break;
                }
            }
            return super.m579a(coordinatorLayout, (View) snackbarLayout, motionEvent);
        }

        public boolean m585a(View view) {
            return view instanceof SnackbarLayout;
        }
    }

    /* renamed from: android.support.design.widget.Snackbar.b */
    public static abstract class C0166b {
        public void m586a(Snackbar snackbar) {
        }

        public void m587a(Snackbar snackbar, int i) {
        }
    }

    static {
        f335a = new Handler(Looper.getMainLooper(), new C01511());
    }

    private Snackbar(ViewGroup viewGroup) {
        this.f342h = new C01554(this);
        this.f336b = viewGroup;
        this.f337c = viewGroup.getContext();
        C0196p.m726a(this.f337c);
        this.f338d = (SnackbarLayout) LayoutInflater.from(this.f337c).inflate(C0107e.design_layout_snackbar, this.f336b, false);
        this.f341g = (AccessibilityManager) this.f337c.getSystemService("accessibility");
    }

    public static Snackbar m588a(View view, CharSequence charSequence, int i) {
        Snackbar snackbar = new Snackbar(m590a(view));
        snackbar.m605a(charSequence);
        snackbar.m608b(i);
        return snackbar;
    }

    private static ViewGroup m590a(View view) {
        ViewGroup viewGroup = null;
        View view2 = view;
        while (!(view2 instanceof CoordinatorLayout)) {
            if (view2 instanceof FrameLayout) {
                if (view2.getId() == 16908290) {
                    return (ViewGroup) view2;
                }
                viewGroup = (ViewGroup) view2;
            }
            if (view2 != null) {
                ViewParent parent = view2.getParent();
                if (parent instanceof View) {
                    view2 = (View) parent;
                    continue;
                } else {
                    view2 = null;
                    continue;
                }
            }
            if (view2 == null) {
                return viewGroup;
            }
        }
        return (ViewGroup) view2;
    }

    private void m595d(int i) {
        C0192n.m700a().m710a(this.f342h, i);
    }

    private void m597e(int i) {
        if (VERSION.SDK_INT >= 14) {
            ah.m1951r(this.f338d).m2165c((float) this.f338d.getHeight()).m2161a(C0170a.f350b).m2158a(250).m2159a(new AnonymousClass10(this, i)).m2166c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f338d.getContext(), C0103a.design_snackbar_out);
        loadAnimation.setInterpolator(C0170a.f350b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C01522(this, i));
        this.f338d.startAnimation(loadAnimation);
    }

    private void m600f(int i) {
        C0192n.m700a().m709a(this.f342h);
        if (this.f340f != null) {
            this.f340f.m587a(this, i);
        }
        ViewParent parent = this.f338d.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.f338d);
        }
    }

    private void m601g() {
        if (VERSION.SDK_INT >= 14) {
            ah.m1923b(this.f338d, (float) this.f338d.getHeight());
            ah.m1951r(this.f338d).m2165c(0.0f).m2161a(C0170a.f350b).m2158a(250).m2159a(new C01638(this)).m2166c();
            return;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.f338d.getContext(), C0103a.design_snackbar_in);
        loadAnimation.setInterpolator(C0170a.f350b);
        loadAnimation.setDuration(250);
        loadAnimation.setAnimationListener(new C01649(this));
        this.f338d.startAnimation(loadAnimation);
    }

    private void m602h() {
        C0192n.m700a().m711b(this.f342h);
        if (this.f340f != null) {
            this.f340f.m586a(this);
        }
    }

    private boolean m603i() {
        return !this.f341g.isEnabled();
    }

    public Snackbar m604a(int i) {
        this.f338d.getActionView().setTextColor(i);
        return this;
    }

    public Snackbar m605a(CharSequence charSequence) {
        this.f338d.getMessageView().setText(charSequence);
        return this;
    }

    public Snackbar m606a(CharSequence charSequence, OnClickListener onClickListener) {
        TextView actionView = this.f338d.getActionView();
        if (TextUtils.isEmpty(charSequence) || onClickListener == null) {
            actionView.setVisibility(8);
            actionView.setOnClickListener(null);
        } else {
            actionView.setVisibility(0);
            actionView.setText(charSequence);
            actionView.setOnClickListener(new C01533(this, onClickListener));
        }
        return this;
    }

    public void m607a() {
        C0192n.m700a().m708a(this.f339e, this.f342h);
    }

    public Snackbar m608b(int i) {
        this.f339e = i;
        return this;
    }

    public void m609b() {
        m595d(3);
    }

    final void m610c(int i) {
        if (m603i() && this.f338d.getVisibility() == 0) {
            m597e(i);
        } else {
            m600f(i);
        }
    }

    public boolean m611c() {
        return C0192n.m700a().m714e(this.f342h);
    }

    public boolean m612d() {
        return C0192n.m700a().m715f(this.f342h);
    }

    final void m613e() {
        if (this.f338d.getParent() == null) {
            LayoutParams layoutParams = this.f338d.getLayoutParams();
            if (layoutParams instanceof C0138e) {
                C0122b c0165a = new C0165a(this);
                c0165a.m576a(0.1f);
                c0165a.m581b(0.6f);
                c0165a.m577a(0);
                c0165a.m578a(new C01575(this));
                ((C0138e) layoutParams).m435a(c0165a);
            }
            this.f336b.addView(this.f338d);
        }
        this.f338d.setOnAttachStateChangeListener(new C01606(this));
        if (!ah.m1901D(this.f338d)) {
            this.f338d.setOnLayoutChangeListener(new C01627(this));
        } else if (m603i()) {
            m601g();
        } else {
            m602h();
        }
    }
}
