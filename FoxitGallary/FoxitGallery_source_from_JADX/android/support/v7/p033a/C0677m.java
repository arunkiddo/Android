package android.support.v7.p033a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p016k.C0288n;
import android.support.v4.p016k.C0534j;
import android.support.v4.p016k.ab;
import android.support.v4.p016k.ah;
import android.support.v4.p016k.at;
import android.support.v4.p016k.az;
import android.support.v4.p016k.be;
import android.support.v4.p016k.bg;
import android.support.v4.p021b.ad;
import android.support.v4.widget.C0622q;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0722c;
import android.support.v7.p034b.C0730a.C0725f;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.p034b.C0730a.C0728i;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.C0716b;
import android.support.v7.view.C0716b.C0694a;
import android.support.v7.view.C0741d;
import android.support.v7.view.C0742e;
import android.support.v7.view.menu.C0114p;
import android.support.v7.view.menu.C0755o.C0691a;
import android.support.v7.view.menu.C0767f;
import android.support.v7.view.menu.C0769h;
import android.support.v7.view.menu.C0769h.C0676a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.C0951m;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.C0686a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.ac;
import android.support.v7.widget.ah.C0684a;
import android.support.v7.widget.bh;
import android.support.v7.widget.bj;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

/* renamed from: android.support.v7.a.m */
class C0677m extends C0672h implements C0288n, C0676a {
    private boolean f1204A;
    private C0697d[] f1205B;
    private C0697d f1206C;
    private boolean f1207D;
    private boolean f1208E;
    private int f1209F;
    private final Runnable f1210G;
    private boolean f1211H;
    private Rect f1212I;
    private Rect f1213J;
    private C0700o f1214K;
    C0716b f1215m;
    ActionBarContextView f1216n;
    PopupWindow f1217o;
    Runnable f1218p;
    az f1219q;
    private ac f1220r;
    private C0692a f1221s;
    private C0698e f1222t;
    private boolean f1223u;
    private ViewGroup f1224v;
    private TextView f1225w;
    private View f1226x;
    private boolean f1227y;
    private boolean f1228z;

    /* renamed from: android.support.v7.a.m.1 */
    class C06821 implements Runnable {
        final /* synthetic */ C0677m f1234a;

        C06821(C0677m c0677m) {
            this.f1234a = c0677m;
        }

        public void run() {
            if ((this.f1234a.f1209F & 1) != 0) {
                this.f1234a.m2974f(0);
            }
            if ((this.f1234a.f1209F & 4096) != 0) {
                this.f1234a.m2974f(C1373c.AppCompatTheme_ratingBarStyle);
            }
            this.f1234a.f1208E = false;
            this.f1234a.f1209F = 0;
        }
    }

    /* renamed from: android.support.v7.a.m.2 */
    class C06832 implements ab {
        final /* synthetic */ C0677m f1235a;

        C06832(C0677m c0677m) {
            this.f1235a = c0677m;
        }

        public bg m3029a(View view, bg bgVar) {
            int b = bgVar.m2248b();
            int c = this.f1235a.m2975g(b);
            if (b != c) {
                bgVar = bgVar.m2247a(bgVar.m2246a(), c, bgVar.m2249c(), bgVar.m2250d());
            }
            return ah.m1908a(view, bgVar);
        }
    }

    /* renamed from: android.support.v7.a.m.3 */
    class C06853 implements C0684a {
        final /* synthetic */ C0677m f1236a;

        C06853(C0677m c0677m) {
            this.f1236a = c0677m;
        }

        public void m3031a(Rect rect) {
            rect.top = this.f1236a.m2975g(rect.top);
        }
    }

    /* renamed from: android.support.v7.a.m.4 */
    class C06874 implements C0686a {
        final /* synthetic */ C0677m f1237a;

        C06874(C0677m c0677m) {
            this.f1237a = c0677m;
        }

        public void m3034a() {
        }

        public void m3035b() {
            this.f1237a.m2982z();
        }
    }

    /* renamed from: android.support.v7.a.m.5 */
    class C06895 implements Runnable {
        final /* synthetic */ C0677m f1239a;

        /* renamed from: android.support.v7.a.m.5.1 */
        class C06881 extends be {
            final /* synthetic */ C06895 f1238a;

            C06881(C06895 c06895) {
                this.f1238a = c06895;
            }

            public void m3036a(View view) {
                this.f1238a.f1239a.f1216n.setVisibility(0);
            }

            public void m3037b(View view) {
                ah.m1927c(this.f1238a.f1239a.f1216n, 1.0f);
                this.f1238a.f1239a.f1219q.m2159a(null);
                this.f1238a.f1239a.f1219q = null;
            }
        }

        C06895(C0677m c0677m) {
            this.f1239a = c0677m;
        }

        public void run() {
            this.f1239a.f1217o.showAtLocation(this.f1239a.f1216n, 55, 0, 0);
            this.f1239a.m2980x();
            if (this.f1239a.m3015s()) {
                ah.m1927c(this.f1239a.f1216n, 0.0f);
                this.f1239a.f1219q = ah.m1951r(this.f1239a.f1216n).m2157a(1.0f);
                this.f1239a.f1219q.m2159a(new C06881(this));
                return;
            }
            ah.m1927c(this.f1239a.f1216n, 1.0f);
            this.f1239a.f1216n.setVisibility(0);
        }
    }

    /* renamed from: android.support.v7.a.m.6 */
    class C06906 extends be {
        final /* synthetic */ C0677m f1240a;

        C06906(C0677m c0677m) {
            this.f1240a = c0677m;
        }

        public void m3038a(View view) {
            this.f1240a.f1216n.setVisibility(0);
            this.f1240a.f1216n.sendAccessibilityEvent(32);
            if (this.f1240a.f1216n.getParent() != null) {
                ah.m1954u((View) this.f1240a.f1216n.getParent());
            }
        }

        public void m3039b(View view) {
            ah.m1927c(this.f1240a.f1216n, 1.0f);
            this.f1240a.f1219q.m2159a(null);
            this.f1240a.f1219q = null;
        }
    }

    /* renamed from: android.support.v7.a.m.a */
    private final class C0692a implements C0691a {
        final /* synthetic */ C0677m f1241a;

        private C0692a(C0677m c0677m) {
            this.f1241a = c0677m;
        }

        public void m3042a(C0769h c0769h, boolean z) {
            this.f1241a.m2963b(c0769h);
        }

        public boolean m3043a(C0769h c0769h) {
            Callback q = this.f1241a.m2941q();
            if (q != null) {
                q.onMenuOpened(C1373c.AppCompatTheme_ratingBarStyle, c0769h);
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.a.m.b */
    class C0695b implements C0694a {
        final /* synthetic */ C0677m f1243a;
        private C0694a f1244b;

        /* renamed from: android.support.v7.a.m.b.1 */
        class C06931 extends be {
            final /* synthetic */ C0695b f1242a;

            C06931(C0695b c0695b) {
                this.f1242a = c0695b;
            }

            public void m3044b(View view) {
                this.f1242a.f1243a.f1216n.setVisibility(8);
                if (this.f1242a.f1243a.f1217o != null) {
                    this.f1242a.f1243a.f1217o.dismiss();
                } else if (this.f1242a.f1243a.f1216n.getParent() instanceof View) {
                    ah.m1954u((View) this.f1242a.f1243a.f1216n.getParent());
                }
                this.f1242a.f1243a.f1216n.removeAllViews();
                this.f1242a.f1243a.f1219q.m2159a(null);
                this.f1242a.f1243a.f1219q = null;
            }
        }

        public C0695b(C0677m c0677m, C0694a c0694a) {
            this.f1243a = c0677m;
            this.f1244b = c0694a;
        }

        public boolean onActionItemClicked(C0716b c0716b, MenuItem menuItem) {
            return this.f1244b.onActionItemClicked(c0716b, menuItem);
        }

        public boolean onCreateActionMode(C0716b c0716b, Menu menu) {
            return this.f1244b.onCreateActionMode(c0716b, menu);
        }

        public void onDestroyActionMode(C0716b c0716b) {
            this.f1244b.onDestroyActionMode(c0716b);
            if (this.f1243a.f1217o != null) {
                this.f1243a.b.getDecorView().removeCallbacks(this.f1243a.f1218p);
            }
            if (this.f1243a.f1216n != null) {
                this.f1243a.m2980x();
                this.f1243a.f1219q = ah.m1951r(this.f1243a.f1216n).m2157a(0.0f);
                this.f1243a.f1219q.m2159a(new C06931(this));
            }
            if (this.f1243a.e != null) {
                this.f1243a.e.onSupportActionModeFinished(this.f1243a.f1215m);
            }
            this.f1243a.f1215m = null;
        }

        public boolean onPrepareActionMode(C0716b c0716b, Menu menu) {
            return this.f1244b.onPrepareActionMode(c0716b, menu);
        }
    }

    /* renamed from: android.support.v7.a.m.c */
    private class C0696c extends ContentFrameLayout {
        final /* synthetic */ C0677m f1253a;

        public C0696c(C0677m c0677m, Context context) {
            this.f1253a = c0677m;
            super(context);
        }

        private boolean m3047a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1253a.m2997a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m3047a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f1253a.m2969d(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0951m.m4995a().m5013a(getContext(), i));
        }
    }

    /* renamed from: android.support.v7.a.m.d */
    protected static final class C0697d {
        int f1254a;
        int f1255b;
        int f1256c;
        int f1257d;
        int f1258e;
        int f1259f;
        ViewGroup f1260g;
        View f1261h;
        View f1262i;
        C0769h f1263j;
        C0767f f1264k;
        Context f1265l;
        boolean f1266m;
        boolean f1267n;
        boolean f1268o;
        public boolean f1269p;
        boolean f1270q;
        boolean f1271r;
        Bundle f1272s;

        C0697d(int i) {
            this.f1254a = i;
            this.f1270q = false;
        }

        C0114p m3048a(C0691a c0691a) {
            if (this.f1263j == null) {
                return null;
            }
            if (this.f1264k == null) {
                this.f1264k = new C0767f(this.f1265l, C0726g.abc_list_menu_item_layout);
                this.f1264k.m3408a(c0691a);
                this.f1263j.m3437a(this.f1264k);
            }
            return this.f1264k.m3404a(this.f1260g);
        }

        void m3049a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0720a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0720a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0728i.Theme_AppCompat_CompactMenu, true);
            }
            Context c0741d = new C0741d(context, 0);
            c0741d.getTheme().setTo(newTheme);
            this.f1265l = c0741d;
            TypedArray obtainStyledAttributes = c0741d.obtainStyledAttributes(C0729j.AppCompatTheme);
            this.f1255b = obtainStyledAttributes.getResourceId(C0729j.AppCompatTheme_panelBackground, 0);
            this.f1259f = obtainStyledAttributes.getResourceId(C0729j.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void m3050a(C0769h c0769h) {
            if (c0769h != this.f1263j) {
                if (this.f1263j != null) {
                    this.f1263j.m3448b(this.f1264k);
                }
                this.f1263j = c0769h;
                if (c0769h != null && this.f1264k != null) {
                    c0769h.m3437a(this.f1264k);
                }
            }
        }

        public boolean m3051a() {
            return this.f1261h == null ? false : this.f1262i != null || this.f1264k.m3405a().getCount() > 0;
        }
    }

    /* renamed from: android.support.v7.a.m.e */
    private final class C0698e implements C0691a {
        final /* synthetic */ C0677m f1273a;

        private C0698e(C0677m c0677m) {
            this.f1273a = c0677m;
        }

        public void m3052a(C0769h c0769h, boolean z) {
            Menu menu;
            Menu p = c0769h.m3470p();
            boolean z2 = p != c0769h;
            C0677m c0677m = this.f1273a;
            if (z2) {
                menu = p;
            }
            C0697d a = c0677m.m2948a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.f1273a.m2949a(a.f1254a, a, p);
                this.f1273a.m2951a(a, true);
                return;
            }
            this.f1273a.m2951a(a, z);
        }

        public boolean m3053a(C0769h c0769h) {
            if (c0769h == null && this.f1273a.h) {
                Callback q = this.f1273a.m2941q();
                if (!(q == null || this.f1273a.m2940p())) {
                    q.onMenuOpened(C1373c.AppCompatTheme_ratingBarStyle, c0769h);
                }
            }
            return true;
        }
    }

    C0677m(Context context, Window window, C0663f c0663f) {
        super(context, window, c0663f);
        this.f1219q = null;
        this.f1210G = new C06821(this);
    }

    private C0697d m2948a(Menu menu) {
        C0697d[] c0697dArr = this.f1205B;
        int length = c0697dArr != null ? c0697dArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0697d c0697d = c0697dArr[i];
            if (c0697d != null && c0697d.f1263j == menu) {
                return c0697d;
            }
        }
        return null;
    }

    private void m2949a(int i, C0697d c0697d, Menu menu) {
        if (menu == null) {
            if (c0697d == null && i >= 0 && i < this.f1205B.length) {
                c0697d = this.f1205B[i];
            }
            if (c0697d != null) {
                menu = c0697d.f1263j;
            }
        }
        if ((c0697d == null || c0697d.f1268o) && !m2940p()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2950a(android.support.v7.p033a.C0677m.C0697d r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f1268o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m2940p();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f1254a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m2941q();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f1254a;
        r5 = r11.f1263j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m2951a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m2965b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f1260g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f1270q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f1260g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m2957a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f1260g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m2968c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m3051a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f1261h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f1255b;
        r4 = r11.f1260g;
        r4.setBackgroundResource(r0);
        r0 = r11.f1261h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f1261h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f1260g;
        r4 = r11.f1261h;
        r0.addView(r4, r1);
        r0 = r11.f1261h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f1261h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f1267n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f1257d;
        r4 = r11.f1258e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f1256c;
        r0.gravity = r1;
        r1 = r11.f1259f;
        r0.windowAnimations = r1;
        r1 = r11.f1260g;
        r8.addView(r1, r0);
        r11.f1268o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f1270q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f1260g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f1260g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f1262i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f1262i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.a.m.a(android.support.v7.a.m$d, android.view.KeyEvent):void");
    }

    private void m2951a(C0697d c0697d, boolean z) {
        if (z && c0697d.f1254a == 0 && this.f1220r != null && this.f1220r.m3590e()) {
            m2963b(c0697d.f1263j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !c0697d.f1268o || c0697d.f1260g == null)) {
            windowManager.removeView(c0697d.f1260g);
            if (z) {
                m2949a(c0697d.f1254a, c0697d, null);
            }
        }
        c0697d.f1266m = false;
        c0697d.f1267n = false;
        c0697d.f1268o = false;
        c0697d.f1261h = null;
        c0697d.f1270q = true;
        if (this.f1206C == c0697d) {
            this.f1206C = null;
        }
    }

    private void m2956a(C0769h c0769h, boolean z) {
        if (this.f1220r == null || !this.f1220r.m3589d() || (at.m2048b(ViewConfiguration.get(this.a)) && !this.f1220r.m3591f())) {
            C0697d a = m2983a(0, true);
            a.f1270q = true;
            m2951a(a, false);
            m2950a(a, null);
            return;
        }
        Callback q = m2941q();
        if (this.f1220r.m3590e() && z) {
            this.f1220r.m3593h();
            if (!m2940p()) {
                q.onPanelClosed(C1373c.AppCompatTheme_ratingBarStyle, m2983a(0, true).f1263j);
            }
        } else if (q != null && !m2940p()) {
            if (this.f1208E && (this.f1209F & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.f1210G);
                this.f1210G.run();
            }
            C0697d a2 = m2983a(0, true);
            if (a2.f1263j != null && !a2.f1271r && q.onPreparePanel(0, a2.f1262i, a2.f1263j)) {
                q.onMenuOpened(C1373c.AppCompatTheme_ratingBarStyle, a2.f1263j);
                this.f1220r.m3592g();
            }
        }
    }

    private boolean m2957a(C0697d c0697d) {
        c0697d.m3049a(m2938n());
        c0697d.f1260g = new C0696c(this, c0697d.f1265l);
        c0697d.f1256c = 81;
        return true;
    }

    private boolean m2958a(C0697d c0697d, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((c0697d.f1266m || m2965b(c0697d, keyEvent)) && c0697d.f1263j != null) {
                z = c0697d.f1263j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f1220r == null) {
                m2951a(c0697d, true);
            }
        }
        return z;
    }

    private boolean m2960a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || ah.m1903F((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    private void m2963b(C0769h c0769h) {
        if (!this.f1204A) {
            this.f1204A = true;
            this.f1220r.m3595j();
            Callback q = m2941q();
            if (!(q == null || m2940p())) {
                q.onPanelClosed(C1373c.AppCompatTheme_ratingBarStyle, c0769h);
            }
            this.f1204A = false;
        }
    }

    private boolean m2964b(C0697d c0697d) {
        Context c0741d;
        C0769h c0769h;
        Context context = this.a;
        if ((c0697d.f1254a == 0 || c0697d.f1254a == C1373c.AppCompatTheme_ratingBarStyle) && this.f1220r != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0720a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0720a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0720a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0741d = new C0741d(context, 0);
                c0741d.getTheme().setTo(theme3);
                c0769h = new C0769h(c0741d);
                c0769h.m3435a((C0676a) this);
                c0697d.m3050a(c0769h);
                return true;
            }
        }
        c0741d = context;
        c0769h = new C0769h(c0741d);
        c0769h.m3435a((C0676a) this);
        c0697d.m3050a(c0769h);
        return true;
    }

    private boolean m2965b(C0697d c0697d, KeyEvent keyEvent) {
        if (m2940p()) {
            return false;
        }
        if (c0697d.f1266m) {
            return true;
        }
        if (!(this.f1206C == null || this.f1206C == c0697d)) {
            m2951a(this.f1206C, false);
        }
        Callback q = m2941q();
        if (q != null) {
            c0697d.f1262i = q.onCreatePanelView(c0697d.f1254a);
        }
        boolean z = c0697d.f1254a == 0 || c0697d.f1254a == C1373c.AppCompatTheme_ratingBarStyle;
        if (z && this.f1220r != null) {
            this.f1220r.m3594i();
        }
        if (c0697d.f1262i == null && !(z && (m2937m() instanceof C0708p))) {
            if (c0697d.f1263j == null || c0697d.f1271r) {
                if (c0697d.f1263j == null && (!m2964b(c0697d) || c0697d.f1263j == null)) {
                    return false;
                }
                if (z && this.f1220r != null) {
                    if (this.f1221s == null) {
                        this.f1221s = new C0692a();
                    }
                    this.f1220r.m3588a(c0697d.f1263j, this.f1221s);
                }
                c0697d.f1263j.m3461g();
                if (q.onCreatePanelMenu(c0697d.f1254a, c0697d.f1263j)) {
                    c0697d.f1271r = false;
                } else {
                    c0697d.m3050a(null);
                    if (!z || this.f1220r == null) {
                        return false;
                    }
                    this.f1220r.m3588a(null, this.f1221s);
                    return false;
                }
            }
            c0697d.f1263j.m3461g();
            if (c0697d.f1272s != null) {
                c0697d.f1263j.m3446b(c0697d.f1272s);
                c0697d.f1272s = null;
            }
            if (q.onPreparePanel(0, c0697d.f1262i, c0697d.f1263j)) {
                c0697d.f1269p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
                c0697d.f1263j.setQwertyMode(c0697d.f1269p);
                c0697d.f1263j.m3462h();
            } else {
                if (z && this.f1220r != null) {
                    this.f1220r.m3588a(null, this.f1221s);
                }
                c0697d.f1263j.m3462h();
                return false;
            }
        }
        c0697d.f1266m = true;
        c0697d.f1267n = false;
        this.f1206C = c0697d;
        return true;
    }

    private boolean m2968c(C0697d c0697d) {
        if (c0697d.f1262i != null) {
            c0697d.f1261h = c0697d.f1262i;
            return true;
        } else if (c0697d.f1263j == null) {
            return false;
        } else {
            if (this.f1222t == null) {
                this.f1222t = new C0698e();
            }
            c0697d.f1261h = (View) c0697d.m3048a(this.f1222t);
            return c0697d.f1261h != null;
        }
    }

    private void m2969d(int i) {
        m2951a(m2983a(i, true), true);
    }

    private boolean m2971d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0697d a = m2983a(i, true);
            if (!a.f1268o) {
                return m2965b(a, keyEvent);
            }
        }
        return false;
    }

    private void m2972e(int i) {
        this.f1209F |= 1 << i;
        if (!this.f1208E) {
            ah.m1917a(this.b.getDecorView(), this.f1210G);
            this.f1208E = true;
        }
    }

    private boolean m2973e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f1215m != null) {
            return false;
        }
        C0697d a = m2983a(i, true);
        if (i != 0 || this.f1220r == null || !this.f1220r.m3589d() || at.m2048b(ViewConfiguration.get(this.a))) {
            boolean z2;
            if (a.f1268o || a.f1267n) {
                z2 = a.f1268o;
                m2951a(a, true);
                z = z2;
            } else {
                if (a.f1266m) {
                    if (a.f1271r) {
                        a.f1266m = false;
                        z2 = m2965b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m2950a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f1220r.m3590e()) {
            z = this.f1220r.m3593h();
        } else {
            if (!m2940p() && m2965b(a, keyEvent)) {
                z = this.f1220r.m3592g();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private void m2974f(int i) {
        C0697d a = m2983a(i, true);
        if (a.f1263j != null) {
            Bundle bundle = new Bundle();
            a.f1263j.m3434a(bundle);
            if (bundle.size() > 0) {
                a.f1272s = bundle;
            }
            a.f1263j.m3461g();
            a.f1263j.clear();
        }
        a.f1271r = true;
        a.f1270q = true;
        if ((i == C1373c.AppCompatTheme_ratingBarStyle || i == 0) && this.f1220r != null) {
            a = m2983a(0, false);
            if (a != null) {
                a.f1266m = false;
                m2965b(a, null);
            }
        }
    }

    private int m2975g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f1216n == null || !(this.f1216n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1216n.getLayoutParams();
            if (this.f1216n.isShown()) {
                if (this.f1212I == null) {
                    this.f1212I = new Rect();
                    this.f1213J = new Rect();
                }
                Rect rect = this.f1212I;
                Rect rect2 = this.f1213J;
                rect.set(0, i, 0, 0);
                bj.m4866a(this.f1224v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f1226x == null) {
                        this.f1226x = new View(this.a);
                        this.f1226x.setBackgroundColor(this.a.getResources().getColor(C0722c.abc_input_method_navigation_guard));
                        this.f1224v.addView(this.f1226x, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f1226x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1226x.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f1226x == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f1216n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f1226x != null) {
            View view = this.f1226x;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private int m2976h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return C1373c.AppCompatTheme_ratingBarStyle;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return C1373c.AppCompatTheme_ratingBarStyleIndicator;
        }
    }

    private void m2977u() {
        if (!this.f1223u) {
            this.f1224v = m2978v();
            CharSequence r = m2942r();
            if (!TextUtils.isEmpty(r)) {
                m3003b(r);
            }
            m2979w();
            m2994a(this.f1224v);
            this.f1223u = true;
            C0697d a = m2983a(0, false);
            if (!m2940p()) {
                if (a == null || a.f1263j == null) {
                    m2972e(C1373c.AppCompatTheme_ratingBarStyle);
                }
            }
        }
    }

    private ViewGroup m2978v() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0729j.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0729j.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0729j.AppCompatTheme_windowNoTitle, false)) {
                m3008c(1);
            } else if (obtainStyledAttributes.getBoolean(C0729j.AppCompatTheme_windowActionBar, false)) {
                m3008c((int) C1373c.AppCompatTheme_ratingBarStyle);
            }
            if (obtainStyledAttributes.getBoolean(C0729j.AppCompatTheme_windowActionBarOverlay, false)) {
                m3008c((int) C1373c.AppCompatTheme_ratingBarStyleIndicator);
            }
            if (obtainStyledAttributes.getBoolean(C0729j.AppCompatTheme_windowActionModeOverlay, false)) {
                m3008c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0729j.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2 = this.j ? (ViewGroup) from.inflate(C0726g.abc_screen_simple_overlay_action_mode, null) : (ViewGroup) from.inflate(C0726g.abc_screen_simple, null);
                if (VERSION.SDK_INT >= 21) {
                    ah.m1915a(view2, new C06832(this));
                    view = view2;
                } else {
                    ((android.support.v7.widget.ah) view2).setOnFitSystemWindowsListener(new C06853(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(C0726g.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0720a.actionBarTheme, typedValue, true);
                r0 = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new C0741d(this.a, typedValue.resourceId) : this.a).inflate(C0726g.abc_screen_toolbar, null);
                this.f1220r = (ac) r0.findViewById(C0725f.decor_content_parent);
                this.f1220r.setWindowCallback(m2941q());
                if (this.i) {
                    this.f1220r.m3587a(C1373c.AppCompatTheme_ratingBarStyleIndicator);
                }
                if (this.f1227y) {
                    this.f1220r.m3587a(2);
                }
                if (this.f1228z) {
                    this.f1220r.m3587a(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f1220r == null) {
                this.f1225w = (TextView) view.findViewById(C0725f.title);
            }
            bj.m4868b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0725f.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new C06874(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    private void m2979w() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1224v.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m3045a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0729j.AppCompatTheme);
        obtainStyledAttributes.getValue(C0729j.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0729j.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0729j.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0729j.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0729j.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0729j.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0729j.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0729j.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0729j.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0729j.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private void m2980x() {
        if (this.f1219q != null) {
            this.f1219q.m2164b();
        }
    }

    private void m2981y() {
        if (this.f1223u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private void m2982z() {
        if (this.f1220r != null) {
            this.f1220r.m3595j();
        }
        if (this.f1217o != null) {
            this.b.getDecorView().removeCallbacks(this.f1218p);
            if (this.f1217o.isShowing()) {
                try {
                    this.f1217o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f1217o = null;
        }
        m2980x();
        C0697d a = m2983a(0, false);
        if (a != null && a.f1263j != null) {
            a.f1263j.close();
        }
    }

    protected C0697d m2983a(int i, boolean z) {
        Object obj = this.f1205B;
        if (obj == null || obj.length <= i) {
            Object obj2 = new C0697d[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f1205B = obj2;
            obj = obj2;
        }
        C0697d c0697d = obj[i];
        if (c0697d != null) {
            return c0697d;
        }
        c0697d = new C0697d(i);
        obj[i] = c0697d;
        return c0697d;
    }

    public C0716b m2984a(C0694a c0694a) {
        if (c0694a == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f1215m != null) {
            this.f1215m.m3116c();
        }
        C0694a c0695b = new C0695b(this, c0694a);
        C0645a a = m2922a();
        if (a != null) {
            this.f1215m = a.m2817a(c0695b);
            if (!(this.f1215m == null || this.e == null)) {
                this.e.onSupportActionModeStarted(this.f1215m);
            }
        }
        if (this.f1215m == null) {
            this.f1215m = m2998b(c0695b);
        }
        return this.f1215m;
    }

    public View m2985a(int i) {
        m2977u();
        return this.b.findViewById(i);
    }

    public final View m2986a(View view, String str, Context context, AttributeSet attributeSet) {
        View b = m2999b(view, str, context, attributeSet);
        return b != null ? b : m3006c(view, str, context, attributeSet);
    }

    void m2987a(int i, Menu menu) {
        if (i == C1373c.AppCompatTheme_ratingBarStyle) {
            C0645a a = m2922a();
            if (a != null) {
                a.m2832f(false);
            }
        } else if (i == 0) {
            C0697d a2 = m2983a(i, true);
            if (a2.f1268o) {
                m2951a(a2, false);
            }
        }
    }

    public void m2988a(Configuration configuration) {
        if (this.h && this.f1223u) {
            C0645a a = m2922a();
            if (a != null) {
                a.m2819a(configuration);
            }
        }
        m2935i();
    }

    public void m2989a(Bundle bundle) {
        if ((this.c instanceof Activity) && ad.m888b((Activity) this.c) != null) {
            C0645a m = m2937m();
            if (m == null) {
                this.f1211H = true;
            } else {
                m.m2827d(true);
            }
        }
    }

    public void m2990a(C0769h c0769h) {
        m2956a(c0769h, true);
    }

    public void m2991a(Toolbar toolbar) {
        if (this.c instanceof Activity) {
            C0645a a = m2922a();
            if (a instanceof C0719s) {
                throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
            }
            this.g = null;
            if (a != null) {
                a.m2836j();
            }
            if (toolbar != null) {
                C0645a c0708p = new C0708p(toolbar, ((Activity) this.a).getTitle(), this.d);
                this.f = c0708p;
                this.b.setCallback(c0708p.m3095k());
            } else {
                this.f = null;
                this.b.setCallback(this.d);
            }
            m3011e();
        }
    }

    public void m2992a(View view) {
        m2977u();
        ViewGroup viewGroup = (ViewGroup) this.f1224v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void m2993a(View view, LayoutParams layoutParams) {
        m2977u();
        ViewGroup viewGroup = (ViewGroup) this.f1224v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m2994a(ViewGroup viewGroup) {
    }

    boolean m2995a(int i, KeyEvent keyEvent) {
        C0645a a = m2922a();
        if (a != null && a.m2822a(i, keyEvent)) {
            return true;
        }
        if (this.f1206C == null || !m2958a(this.f1206C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f1206C == null) {
                C0697d a2 = m2983a(0, true);
                m2965b(a2, keyEvent);
                boolean a3 = m2958a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f1266m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f1206C == null) {
            return true;
        } else {
            this.f1206C.f1267n = true;
            return true;
        }
    }

    public boolean m2996a(C0769h c0769h, MenuItem menuItem) {
        Callback q = m2941q();
        if (!(q == null || m2940p())) {
            C0697d a = m2948a(c0769h.m3470p());
            if (a != null) {
                return q.onMenuItemSelected(a.f1254a, menuItem);
            }
        }
        return false;
    }

    boolean m2997a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m3009c(keyCode, keyEvent) : m3004b(keyCode, keyEvent);
    }

    C0716b m2998b(C0694a c0694a) {
        C0716b c0716b;
        m2980x();
        if (this.f1215m != null) {
            this.f1215m.m3116c();
        }
        if (!(c0694a instanceof C0695b)) {
            c0694a = new C0695b(this, c0694a);
        }
        if (this.e == null || m2940p()) {
            c0716b = null;
        } else {
            try {
                c0716b = this.e.onWindowStartingSupportActionMode(c0694a);
            } catch (AbstractMethodError e) {
                c0716b = null;
            }
        }
        if (c0716b != null) {
            this.f1215m = c0716b;
        } else {
            if (this.f1216n == null) {
                if (this.k) {
                    Context c0741d;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0720a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0741d = new C0741d(this.a, 0);
                        c0741d.getTheme().setTo(newTheme);
                    } else {
                        c0741d = this.a;
                    }
                    this.f1216n = new ActionBarContextView(c0741d);
                    this.f1217o = new PopupWindow(c0741d, null, C0720a.actionModePopupWindowStyle);
                    C0622q.m2723a(this.f1217o, 2);
                    this.f1217o.setContentView(this.f1216n);
                    this.f1217o.setWidth(-1);
                    c0741d.getTheme().resolveAttribute(C0720a.actionBarSize, typedValue, true);
                    this.f1216n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0741d.getResources().getDisplayMetrics()));
                    this.f1217o.setHeight(-2);
                    this.f1218p = new C06895(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1224v.findViewById(C0725f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m2938n()));
                        this.f1216n = (ActionBarContextView) viewStubCompat.m4490a();
                    }
                }
            }
            if (this.f1216n != null) {
                m2980x();
                this.f1216n.m3583c();
                C0716b c0742e = new C0742e(this.f1216n.getContext(), this.f1216n, c0694a, this.f1217o == null);
                if (c0694a.onCreateActionMode(c0742e, c0742e.m3113b())) {
                    c0742e.m3117d();
                    this.f1216n.m3580a(c0742e);
                    this.f1215m = c0742e;
                    if (m3015s()) {
                        ah.m1927c(this.f1216n, 0.0f);
                        this.f1219q = ah.m1951r(this.f1216n).m2157a(1.0f);
                        this.f1219q.m2159a(new C06906(this));
                    } else {
                        ah.m1927c(this.f1216n, 1.0f);
                        this.f1216n.setVisibility(0);
                        this.f1216n.sendAccessibilityEvent(32);
                        if (this.f1216n.getParent() != null) {
                            ah.m1954u((View) this.f1216n.getParent());
                        }
                    }
                    if (this.f1217o != null) {
                        this.b.getDecorView().post(this.f1218p);
                    }
                } else {
                    this.f1215m = null;
                }
            }
        }
        if (!(this.f1215m == null || this.e == null)) {
            this.e.onSupportActionModeStarted(this.f1215m);
        }
        return this.f1215m;
    }

    View m2999b(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    public void m3000b(int i) {
        m2977u();
        ViewGroup viewGroup = (ViewGroup) this.f1224v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void m3001b(Bundle bundle) {
        m2977u();
    }

    public void m3002b(View view, LayoutParams layoutParams) {
        m2977u();
        ((ViewGroup) this.f1224v.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    void m3003b(CharSequence charSequence) {
        if (this.f1220r != null) {
            this.f1220r.setWindowTitle(charSequence);
        } else if (m2937m() != null) {
            m2937m().m2820a(charSequence);
        } else if (this.f1225w != null) {
            this.f1225w.setText(charSequence);
        }
    }

    boolean m3004b(int i, KeyEvent keyEvent) {
        switch (i) {
            case C1373c.View_theme /*4*/:
                boolean z = this.f1207D;
                this.f1207D = false;
                C0697d a = m2983a(0, false);
                if (a == null || !a.f1268o) {
                    if (m3016t()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m2951a(a, true);
                    return true;
                }
                break;
            case C1373c.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                m2973e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean m3005b(int i, Menu menu) {
        if (i != C1373c.AppCompatTheme_ratingBarStyle) {
            return false;
        }
        C0645a a = m2922a();
        if (a == null) {
            return true;
        }
        a.m2832f(true);
        return true;
    }

    public View m3006c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z = VERSION.SDK_INT < 21;
        if (this.f1214K == null) {
            this.f1214K = new C0700o();
        }
        boolean z2 = z && m2960a((ViewParent) view);
        return this.f1214K.m3059a(view, str, context, attributeSet, z2, z, true, bh.m4843a());
    }

    public void m3007c() {
        C0645a a = m2922a();
        if (a != null) {
            a.m2830e(false);
        }
    }

    public boolean m3008c(int i) {
        int h = m2976h(i);
        if (this.l && h == C1373c.AppCompatTheme_ratingBarStyle) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case C1373c.View_android_focusable /*1*/:
                m2981y();
                this.l = true;
                return true;
            case C1373c.View_paddingStart /*2*/:
                m2981y();
                this.f1227y = true;
                return true;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                m2981y();
                this.f1228z = true;
                return true;
            case C1373c.Toolbar_contentInsetEndWithActions /*10*/:
                m2981y();
                this.j = true;
                return true;
            case C1373c.AppCompatTheme_ratingBarStyle /*108*/:
                m2981y();
                this.h = true;
                return true;
            case C1373c.AppCompatTheme_ratingBarStyleIndicator /*109*/:
                m2981y();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    boolean m3009c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case C1373c.View_theme /*4*/:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f1207D = z;
                break;
            case C1373c.AppCompatTheme_listChoiceBackgroundIndicator /*82*/:
                m2971d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            m2995a(i, keyEvent);
        }
        return false;
    }

    public void m3010d() {
        C0645a a = m2922a();
        if (a != null) {
            a.m2830e(true);
        }
    }

    public void m3011e() {
        C0645a a = m2922a();
        if (a == null || !a.m2833g()) {
            m2972e(0);
        }
    }

    public void m3012f() {
        super.m2933f();
        if (this.f != null) {
            this.f.m2836j();
        }
    }

    public void m3013h() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            C0534j.m2320a(from, this);
        } else if (!(C0534j.m2319a(from) instanceof C0677m)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public void m3014l() {
        m2977u();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new C0719s((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new C0719s((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.m2827d(this.f1211H);
            }
        }
    }

    final boolean m3015s() {
        return this.f1223u && this.f1224v != null && ah.m1901D(this.f1224v);
    }

    boolean m3016t() {
        if (this.f1215m != null) {
            this.f1215m.m3116c();
            return true;
        }
        C0645a a = m2922a();
        return a != null && a.m2834h();
    }
}
