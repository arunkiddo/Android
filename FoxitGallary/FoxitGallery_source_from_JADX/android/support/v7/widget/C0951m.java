package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.support.p012a.p013a.C0088b;
import android.support.p012a.p013a.C0102f;
import android.support.v4.p014d.C0346a;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.p022c.C0225a;
import android.support.v4.p030j.C0380a;
import android.support.v4.p030j.C0384e;
import android.support.v4.p030j.C0385f;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0722c;
import android.support.v7.p034b.C0730a.C0724e;
import android.support.v7.p035c.p036a.C0733b;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v7.widget.m */
public final class C0951m {
    private static final Mode f2468a;
    private static C0951m f2469b;
    private static final C0949b f2470c;
    private static final int[] f2471d;
    private static final int[] f2472e;
    private static final int[] f2473f;
    private static final int[] f2474g;
    private static final int[] f2475h;
    private static final int[] f2476i;
    private WeakHashMap<Context, SparseArray<ColorStateList>> f2477j;
    private C0380a<String, C0947c> f2478k;
    private SparseArray<String> f2479l;
    private final Object f2480m;
    private final WeakHashMap<Context, C0384e<WeakReference<ConstantState>>> f2481n;
    private TypedValue f2482o;
    private boolean f2483p;

    /* renamed from: android.support.v7.widget.m.c */
    private interface C0947c {
        Drawable m4983a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);
    }

    /* renamed from: android.support.v7.widget.m.a */
    private static class C0948a implements C0947c {
        private C0948a() {
        }

        public Drawable m4984a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0088b.m141a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* renamed from: android.support.v7.widget.m.b */
    private static class C0949b extends C0385f<Integer, PorterDuffColorFilter> {
        public C0949b(int i) {
            super(i);
        }

        private static int m4985b(int i, Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter m4986a(int i, Mode mode) {
            return (PorterDuffColorFilter) m1446a((Object) Integer.valueOf(C0949b.m4985b(i, mode)));
        }

        PorterDuffColorFilter m4987a(int i, Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) m1447a(Integer.valueOf(C0949b.m4985b(i, mode)), porterDuffColorFilter);
        }
    }

    /* renamed from: android.support.v7.widget.m.d */
    private static class C0950d implements C0947c {
        private C0950d() {
        }

        public Drawable m4988a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            try {
                return C0102f.m204a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Throwable e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    static {
        f2468a = Mode.SRC_IN;
        f2470c = new C0949b(6);
        f2471d = new int[]{C0724e.abc_textfield_search_default_mtrl_alpha, C0724e.abc_textfield_default_mtrl_alpha, C0724e.abc_ab_share_pack_mtrl_alpha};
        f2472e = new int[]{C0724e.abc_ic_commit_search_api_mtrl_alpha, C0724e.abc_seekbar_tick_mark_material, C0724e.abc_ic_menu_share_mtrl_alpha, C0724e.abc_ic_menu_copy_mtrl_am_alpha, C0724e.abc_ic_menu_cut_mtrl_alpha, C0724e.abc_ic_menu_selectall_mtrl_alpha, C0724e.abc_ic_menu_paste_mtrl_am_alpha};
        f2473f = new int[]{C0724e.abc_textfield_activated_mtrl_alpha, C0724e.abc_textfield_search_activated_mtrl_alpha, C0724e.abc_cab_background_top_mtrl_alpha, C0724e.abc_text_cursor_material};
        f2474g = new int[]{C0724e.abc_popup_background_mtrl_mult, C0724e.abc_cab_background_internal_bg, C0724e.abc_menu_hardkey_panel_mtrl_mult};
        f2475h = new int[]{C0724e.abc_tab_indicator_material, C0724e.abc_textfield_search_material};
        f2476i = new int[]{C0724e.abc_btn_check_material, C0724e.abc_btn_radio_material};
    }

    public C0951m() {
        this.f2480m = new Object();
        this.f2481n = new WeakHashMap(0);
    }

    private static long m4989a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private ColorStateList m4990a(Context context) {
        return m5011f(context, ba.m4762a(context, C0720a.colorButtonNormal));
    }

    public static PorterDuffColorFilter m4991a(int i, Mode mode) {
        PorterDuffColorFilter a = f2470c.m4986a(i, mode);
        if (a != null) {
            return a;
        }
        a = new PorterDuffColorFilter(i, mode);
        f2470c.m4987a(i, mode, a);
        return a;
    }

    private static PorterDuffColorFilter m4992a(ColorStateList colorStateList, Mode mode, int[] iArr) {
        return (colorStateList == null || mode == null) ? null : C0951m.m4991a(colorStateList.getColorForState(iArr, 0), mode);
    }

    private Drawable m4993a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = m5016b(context, i);
        if (b != null) {
            if (af.m4627c(drawable)) {
                drawable = drawable.mutate();
            }
            drawable = C0326a.m1272f(drawable);
            C0326a.m1262a(drawable, b);
            Mode a = m5012a(i);
            if (a == null) {
                return drawable;
            }
            C0326a.m1265a(drawable, a);
            return drawable;
        } else if (i == C0724e.abc_seekbar_track_material) {
            r0 = (LayerDrawable) drawable;
            C0951m.m4997a(r0.findDrawableByLayerId(16908288), ba.m4762a(context, C0720a.colorControlNormal), f2468a);
            C0951m.m4997a(r0.findDrawableByLayerId(16908303), ba.m4762a(context, C0720a.colorControlNormal), f2468a);
            C0951m.m4997a(r0.findDrawableByLayerId(16908301), ba.m4762a(context, C0720a.colorControlActivated), f2468a);
            return drawable;
        } else if (i != C0724e.abc_ratingbar_material && i != C0724e.abc_ratingbar_indicator_material && i != C0724e.abc_ratingbar_small_material) {
            return (C0951m.m5001a(context, i, drawable) || !z) ? drawable : null;
        } else {
            r0 = (LayerDrawable) drawable;
            C0951m.m4997a(r0.findDrawableByLayerId(16908288), ba.m4766c(context, C0720a.colorControlNormal), f2468a);
            C0951m.m4997a(r0.findDrawableByLayerId(16908303), ba.m4762a(context, C0720a.colorControlActivated), f2468a);
            C0951m.m4997a(r0.findDrawableByLayerId(16908301), ba.m4762a(context, C0720a.colorControlActivated), f2468a);
            return drawable;
        }
    }

    private Drawable m4994a(Context context, long j) {
        synchronized (this.f2480m) {
            C0384e c0384e = (C0384e) this.f2481n.get(context);
            if (c0384e == null) {
                return null;
            }
            WeakReference weakReference = (WeakReference) c0384e.m1436a(j);
            if (weakReference != null) {
                ConstantState constantState = (ConstantState) weakReference.get();
                if (constantState != null) {
                    Drawable newDrawable = constantState.newDrawable(context.getResources());
                    return newDrawable;
                }
                c0384e.m1441b(j);
            }
            return null;
        }
    }

    public static C0951m m4995a() {
        if (f2469b == null) {
            f2469b = new C0951m();
            C0951m.m4999a(f2469b);
        }
        return f2469b;
    }

    private void m4996a(Context context, int i, ColorStateList colorStateList) {
        if (this.f2477j == null) {
            this.f2477j = new WeakHashMap();
        }
        SparseArray sparseArray = (SparseArray) this.f2477j.get(context);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            this.f2477j.put(context, sparseArray);
        }
        sparseArray.append(i, colorStateList);
    }

    private static void m4997a(Drawable drawable, int i, Mode mode) {
        if (af.m4627c(drawable)) {
            drawable = drawable.mutate();
        }
        if (mode == null) {
            mode = f2468a;
        }
        drawable.setColorFilter(C0951m.m4991a(i, mode));
    }

    public static void m4998a(Drawable drawable, bd bdVar, int[] iArr) {
        if (!af.m4627c(drawable) || drawable.mutate() == drawable) {
            if (bdVar.f2345d || bdVar.f2344c) {
                drawable.setColorFilter(C0951m.m4992a(bdVar.f2345d ? bdVar.f2342a : null, bdVar.f2344c ? bdVar.f2343b : f2468a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("AppCompatDrawableManager", "Mutated drawable is not the same instance as the input.");
    }

    private static void m4999a(C0951m c0951m) {
        int i = VERSION.SDK_INT;
        if (i < 23) {
            c0951m.m5000a("vector", new C0950d());
            if (i >= 11) {
                c0951m.m5000a("animated-vector", new C0948a());
            }
        }
    }

    private void m5000a(String str, C0947c c0947c) {
        if (this.f2478k == null) {
            this.f2478k = new C0380a();
        }
        this.f2478k.put(str, c0947c);
    }

    static boolean m5001a(Context context, int i, Drawable drawable) {
        int i2;
        Mode mode;
        boolean z;
        int i3;
        Mode mode2 = f2468a;
        if (C0951m.m5004a(f2471d, i)) {
            i2 = C0720a.colorControlNormal;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0951m.m5004a(f2473f, i)) {
            i2 = C0720a.colorControlActivated;
            mode = mode2;
            z = true;
            i3 = -1;
        } else if (C0951m.m5004a(f2474g, i)) {
            z = true;
            mode = Mode.MULTIPLY;
            i2 = 16842801;
            i3 = -1;
        } else if (i == C0724e.abc_list_divider_mtrl_alpha) {
            i2 = 16842800;
            i3 = Math.round(40.8f);
            mode = mode2;
            z = true;
        } else if (i == C0724e.abc_dialog_material_background) {
            i2 = 16842801;
            mode = mode2;
            z = true;
            i3 = -1;
        } else {
            i3 = -1;
            i2 = 0;
            mode = mode2;
            z = false;
        }
        if (!z) {
            return false;
        }
        if (af.m4627c(drawable)) {
            drawable = drawable.mutate();
        }
        drawable.setColorFilter(C0951m.m4991a(ba.m4762a(context, i2), mode));
        if (i3 == -1) {
            return true;
        }
        drawable.setAlpha(i3);
        return true;
    }

    private boolean m5002a(Context context, long j, Drawable drawable) {
        ConstantState constantState = drawable.getConstantState();
        if (constantState == null) {
            return false;
        }
        synchronized (this.f2480m) {
            C0384e c0384e = (C0384e) this.f2481n.get(context);
            if (c0384e == null) {
                c0384e = new C0384e();
                this.f2481n.put(context, c0384e);
            }
            c0384e.m1442b(j, new WeakReference(constantState));
        }
        return true;
    }

    private static boolean m5003a(Drawable drawable) {
        return (drawable instanceof C0102f) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private static boolean m5004a(int[] iArr, int i) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private ColorStateList m5005b(Context context) {
        return m5011f(context, 0);
    }

    private ColorStateList m5006c(Context context) {
        return m5011f(context, ba.m4762a(context, C0720a.colorAccent));
    }

    private Drawable m5007c(Context context, int i) {
        if (this.f2482o == null) {
            this.f2482o = new TypedValue();
        }
        TypedValue typedValue = this.f2482o;
        context.getResources().getValue(i, typedValue, true);
        long a = C0951m.m4989a(typedValue);
        Drawable a2 = m4994a(context, a);
        if (a2 == null) {
            if (i == C0724e.abc_cab_background_top_material) {
                a2 = new LayerDrawable(new Drawable[]{m5013a(context, C0724e.abc_cab_background_internal_bg), m5013a(context, C0724e.abc_cab_background_top_mtrl_alpha)});
            }
            if (a2 != null) {
                a2.setChangingConfigurations(typedValue.changingConfigurations);
                m5002a(context, a, a2);
            }
        }
        return a2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m5008d(android.content.Context r10, int r11) {
        /*
        r9 = this;
        r1 = 0;
        r8 = 2;
        r7 = 1;
        r0 = r9.f2478k;
        if (r0 == 0) goto L_0x00bf;
    L_0x0007:
        r0 = r9.f2478k;
        r0 = r0.isEmpty();
        if (r0 != 0) goto L_0x00bf;
    L_0x000f:
        r0 = r9.f2479l;
        if (r0 == 0) goto L_0x002f;
    L_0x0013:
        r0 = r9.f2479l;
        r0 = r0.get(r11);
        r0 = (java.lang.String) r0;
        r2 = "appcompat_skip_skip";
        r2 = r2.equals(r0);
        if (r2 != 0) goto L_0x002d;
    L_0x0023:
        if (r0 == 0) goto L_0x0036;
    L_0x0025:
        r2 = r9.f2478k;
        r0 = r2.get(r0);
        if (r0 != 0) goto L_0x0036;
    L_0x002d:
        r0 = r1;
    L_0x002e:
        return r0;
    L_0x002f:
        r0 = new android.util.SparseArray;
        r0.<init>();
        r9.f2479l = r0;
    L_0x0036:
        r0 = r9.f2482o;
        if (r0 != 0) goto L_0x0041;
    L_0x003a:
        r0 = new android.util.TypedValue;
        r0.<init>();
        r9.f2482o = r0;
    L_0x0041:
        r2 = r9.f2482o;
        r0 = r10.getResources();
        r0.getValue(r11, r2, r7);
        r4 = android.support.v7.widget.C0951m.m4989a(r2);
        r1 = r9.m4994a(r10, r4);
        if (r1 == 0) goto L_0x0056;
    L_0x0054:
        r0 = r1;
        goto L_0x002e;
    L_0x0056:
        r3 = r2.string;
        if (r3 == 0) goto L_0x008a;
    L_0x005a:
        r3 = r2.string;
        r3 = r3.toString();
        r6 = ".xml";
        r3 = r3.endsWith(r6);
        if (r3 == 0) goto L_0x008a;
    L_0x0068:
        r3 = r0.getXml(r11);	 Catch:{ Exception -> 0x0082 }
        r6 = android.util.Xml.asAttributeSet(r3);	 Catch:{ Exception -> 0x0082 }
    L_0x0070:
        r0 = r3.next();	 Catch:{ Exception -> 0x0082 }
        if (r0 == r8) goto L_0x0078;
    L_0x0076:
        if (r0 != r7) goto L_0x0070;
    L_0x0078:
        if (r0 == r8) goto L_0x0095;
    L_0x007a:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ Exception -> 0x0082 }
        r2 = "No start tag found";
        r0.<init>(r2);	 Catch:{ Exception -> 0x0082 }
        throw r0;	 Catch:{ Exception -> 0x0082 }
    L_0x0082:
        r0 = move-exception;
        r2 = "AppCompatDrawableManager";
        r3 = "Exception while inflating drawable";
        android.util.Log.e(r2, r3, r0);
    L_0x008a:
        r0 = r1;
    L_0x008b:
        if (r0 != 0) goto L_0x002e;
    L_0x008d:
        r1 = r9.f2479l;
        r2 = "appcompat_skip_skip";
        r1.append(r11, r2);
        goto L_0x002e;
    L_0x0095:
        r0 = r3.getName();	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2479l;	 Catch:{ Exception -> 0x0082 }
        r7.append(r11, r0);	 Catch:{ Exception -> 0x0082 }
        r7 = r9.f2478k;	 Catch:{ Exception -> 0x0082 }
        r0 = r7.get(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = (android.support.v7.widget.C0951m.C0947c) r0;	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00b0;
    L_0x00a8:
        r7 = r10.getTheme();	 Catch:{ Exception -> 0x0082 }
        r1 = r0.m4983a(r10, r3, r6, r7);	 Catch:{ Exception -> 0x0082 }
    L_0x00b0:
        if (r1 == 0) goto L_0x00bd;
    L_0x00b2:
        r0 = r2.changingConfigurations;	 Catch:{ Exception -> 0x0082 }
        r1.setChangingConfigurations(r0);	 Catch:{ Exception -> 0x0082 }
        r0 = r9.m5002a(r10, r4, r1);	 Catch:{ Exception -> 0x0082 }
        if (r0 == 0) goto L_0x00bd;
    L_0x00bd:
        r0 = r1;
        goto L_0x008b;
    L_0x00bf:
        r0 = r1;
        goto L_0x002e;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.m.d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private void m5009d(Context context) {
        if (!this.f2483p) {
            this.f2483p = true;
            Drawable a = m5013a(context, C0724e.abc_ic_ab_back_material);
            if (a == null || !C0951m.m5003a(a)) {
                this.f2483p = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private ColorStateList m5010e(Context context, int i) {
        if (this.f2477j == null) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.f2477j.get(context);
        return sparseArray != null ? (ColorStateList) sparseArray.get(i) : null;
    }

    private ColorStateList m5011f(Context context, int i) {
        r0 = new int[4][];
        r1 = new int[4];
        int a = ba.m4762a(context, C0720a.colorControlHighlight);
        r0[0] = ba.f2329a;
        r1[0] = ba.m4766c(context, C0720a.colorButtonNormal);
        r0[1] = ba.f2332d;
        r1[1] = C0346a.m1317a(a, i);
        r0[2] = ba.f2330b;
        r1[2] = C0346a.m1317a(a, i);
        r0[3] = ba.f2336h;
        r1[3] = i;
        return new ColorStateList(r0, r1);
    }

    final Mode m5012a(int i) {
        return i == C0724e.abc_switch_thumb_material ? Mode.MULTIPLY : null;
    }

    public Drawable m5013a(Context context, int i) {
        return m5014a(context, i, false);
    }

    public Drawable m5014a(Context context, int i, boolean z) {
        m5009d(context);
        Drawable d = m5008d(context, i);
        if (d == null) {
            d = m5007c(context, i);
        }
        if (d == null) {
            d = C0225a.m808a(context, i);
        }
        if (d != null) {
            d = m4993a(context, i, z, d);
        }
        if (d != null) {
            af.m4626b(d);
        }
        return d;
    }

    public final Drawable m5015a(Context context, bh bhVar, int i) {
        Drawable d = m5008d(context, i);
        if (d == null) {
            d = bhVar.m4844a(i);
        }
        return d != null ? m4993a(context, i, false, d) : null;
    }

    public final ColorStateList m5016b(Context context, int i) {
        ColorStateList e = m5010e(context, i);
        if (e == null) {
            if (i == C0724e.abc_edit_text_material) {
                e = C0733b.m3202a(context, C0722c.abc_tint_edittext);
            } else if (i == C0724e.abc_switch_track_mtrl_alpha) {
                e = C0733b.m3202a(context, C0722c.abc_tint_switch_track);
            } else if (i == C0724e.abc_switch_thumb_material) {
                e = C0733b.m3202a(context, C0722c.abc_tint_switch_thumb);
            } else if (i == C0724e.abc_btn_default_mtrl_shape) {
                e = m4990a(context);
            } else if (i == C0724e.abc_btn_borderless_material) {
                e = m5005b(context);
            } else if (i == C0724e.abc_btn_colored_material) {
                e = m5006c(context);
            } else if (i == C0724e.abc_spinner_mtrl_am_alpha || i == C0724e.abc_spinner_textfield_background_material) {
                e = C0733b.m3202a(context, C0722c.abc_tint_spinner);
            } else if (C0951m.m5004a(f2472e, i)) {
                e = ba.m4765b(context, C0720a.colorControlNormal);
            } else if (C0951m.m5004a(f2475h, i)) {
                e = C0733b.m3202a(context, C0722c.abc_tint_default);
            } else if (C0951m.m5004a(f2476i, i)) {
                e = C0733b.m3202a(context, C0722c.abc_tint_btn_checkable);
            } else if (i == C0724e.abc_seekbar_thumb_material) {
                e = C0733b.m3202a(context, C0722c.abc_tint_seek_thumb);
            }
            if (e != null) {
                m4996a(context, i, e);
            }
        }
        return e;
    }
}
