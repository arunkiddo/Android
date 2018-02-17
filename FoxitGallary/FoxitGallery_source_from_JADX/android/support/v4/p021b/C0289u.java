package android.support.v4.p021b;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.p016k.C0288n;
import android.support.v4.p016k.ah;
import android.support.v4.p017g.C0354c;
import android.support.v4.p021b.C0274o.C0273b;
import android.support.v4.p021b.C0282t.C0281a;
import android.support.v4.p030j.C0382c;
import android.support.v4.p030j.C0383d;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: android.support.v4.b.u */
final class C0289u extends C0282t implements C0288n {
    static final Interpolator f622A;
    static final Interpolator f623B;
    static final Interpolator f624C;
    static final Interpolator f625D;
    static boolean f626a;
    static final boolean f627b;
    static Field f628r;
    ArrayList<Runnable> f629c;
    Runnable[] f630d;
    boolean f631e;
    ArrayList<C0274o> f632f;
    ArrayList<C0274o> f633g;
    ArrayList<Integer> f634h;
    ArrayList<C0262i> f635i;
    ArrayList<C0274o> f636j;
    ArrayList<C0262i> f637k;
    ArrayList<Integer> f638l;
    ArrayList<C0281a> f639m;
    int f640n;
    C0276s f641o;
    C0269q f642p;
    C0274o f643q;
    boolean f644s;
    boolean f645t;
    boolean f646u;
    String f647v;
    boolean f648w;
    Bundle f649x;
    SparseArray<Parcelable> f650y;
    Runnable f651z;

    /* renamed from: android.support.v4.b.u.1 */
    class C02831 implements Runnable {
        final /* synthetic */ C0289u f614a;

        C02831(C0289u c0289u) {
            this.f614a = c0289u;
        }

        public void run() {
            this.f614a.m1135e();
        }
    }

    /* renamed from: android.support.v4.b.u.a */
    static class C0284a implements AnimationListener {
        private AnimationListener f615a;
        private boolean f616b;
        private View f617c;

        /* renamed from: android.support.v4.b.u.a.1 */
        class C02861 implements Runnable {
            final /* synthetic */ C0284a f620a;

            C02861(C0284a c0284a) {
                this.f620a = c0284a;
            }

            public void run() {
                ah.m1912a(this.f620a.f617c, 0, null);
            }
        }

        public C0284a(View view, Animation animation) {
            if (view != null && animation != null) {
                this.f617c = view;
            }
        }

        public C0284a(View view, Animation animation, AnimationListener animationListener) {
            if (view != null && animation != null) {
                this.f615a = animationListener;
                this.f617c = view;
                this.f616b = true;
            }
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f617c != null && this.f616b) {
                if (ah.m1903F(this.f617c) || C0354c.m1328a()) {
                    this.f617c.post(new C02861(this));
                } else {
                    ah.m1912a(this.f617c, 0, null);
                }
            }
            if (this.f615a != null) {
                this.f615a.onAnimationEnd(animation);
            }
        }

        public void onAnimationRepeat(Animation animation) {
            if (this.f615a != null) {
                this.f615a.onAnimationRepeat(animation);
            }
        }

        public void onAnimationStart(Animation animation) {
            if (this.f615a != null) {
                this.f615a.onAnimationStart(animation);
            }
        }
    }

    /* renamed from: android.support.v4.b.u.2 */
    class C02852 extends C0284a {
        final /* synthetic */ C0274o f618a;
        final /* synthetic */ C0289u f619b;

        C02852(C0289u c0289u, View view, Animation animation, C0274o c0274o) {
            this.f619b = c0289u;
            this.f618a = c0274o;
            super(view, animation);
        }

        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            if (this.f618a.mAnimatingAway != null) {
                this.f618a.mAnimatingAway = null;
                this.f619b.m1105a(this.f618a, this.f618a.mStateAfterAnimating, 0, 0, false);
            }
        }
    }

    /* renamed from: android.support.v4.b.u.b */
    static class C0287b {
        public static final int[] f621a;

        static {
            f621a = new int[]{16842755, 16842960, 16842961};
        }
    }

    static {
        boolean z = false;
        f626a = false;
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        f627b = z;
        f628r = null;
        f622A = new DecelerateInterpolator(2.5f);
        f623B = new DecelerateInterpolator(1.5f);
        f624C = new AccelerateInterpolator(2.5f);
        f625D = new AccelerateInterpolator(1.5f);
    }

    C0289u() {
        this.f640n = 0;
        this.f649x = null;
        this.f650y = null;
        this.f651z = new C02831(this);
    }

    static Animation m1082a(Context context, float f, float f2) {
        Animation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f623B);
        alphaAnimation.setDuration(220);
        return alphaAnimation;
    }

    static Animation m1083a(Context context, float f, float f2, float f3, float f4) {
        Animation animationSet = new AnimationSet(false);
        Animation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f622A);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        scaleAnimation = new AlphaAnimation(f3, f4);
        scaleAnimation.setInterpolator(f623B);
        scaleAnimation.setDuration(220);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private void m1084a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new C0383d("FragmentManager"));
        if (this.f641o != null) {
            try {
                this.f641o.m999a("  ", null, printWriter, new String[0]);
            } catch (Throwable e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                m1109a("  ", null, printWriter, new String[0]);
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    static boolean m1085a(View view, Animation animation) {
        return VERSION.SDK_INT >= 19 && ah.m1940g(view) == 0 && ah.m1957x(view) && C0289u.m1086a(animation);
    }

    static boolean m1086a(Animation animation) {
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (!(animation instanceof AnimationSet)) {
            return false;
        }
        List animations = ((AnimationSet) animation).getAnimations();
        for (int i = 0; i < animations.size(); i++) {
            if (animations.get(i) instanceof AlphaAnimation) {
                return true;
            }
        }
        return false;
    }

    public static int m1087b(int i, boolean z) {
        switch (i) {
            case 4097:
                return z ? 1 : 2;
            case 4099:
                return z ? 5 : 6;
            case 8194:
                return z ? 3 : 4;
            default:
                return -1;
        }
    }

    private void m1088b(View view, Animation animation) {
        if (view != null && animation != null && C0289u.m1085a(view, animation)) {
            AnimationListener animationListener;
            try {
                if (f628r == null) {
                    f628r = Animation.class.getDeclaredField("mListener");
                    f628r.setAccessible(true);
                }
                animationListener = (AnimationListener) f628r.get(animation);
            } catch (Throwable e) {
                Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e);
                animationListener = null;
            } catch (Throwable e2) {
                Log.e("FragmentManager", "Cannot access Animation's mListener field", e2);
                animationListener = null;
            }
            ah.m1912a(view, 2, null);
            animation.setAnimationListener(new C0284a(view, animation, animationListener));
        }
    }

    public static int m1089d(int i) {
        switch (i) {
            case 4097:
                return 8194;
            case 4099:
                return 4099;
            case 8194:
                return 4097;
            default:
                return 0;
        }
    }

    private void m1090v() {
        if (this.f645t) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        } else if (this.f647v != null) {
            throw new IllegalStateException("Can not perform this action inside of " + this.f647v);
        }
    }

    public int m1091a(C0262i c0262i) {
        int size;
        synchronized (this) {
            if (this.f638l == null || this.f638l.size() <= 0) {
                if (this.f637k == null) {
                    this.f637k = new ArrayList();
                }
                size = this.f637k.size();
                if (f626a) {
                    Log.v("FragmentManager", "Setting back stack index " + size + " to " + c0262i);
                }
                this.f637k.add(c0262i);
            } else {
                size = ((Integer) this.f638l.remove(this.f638l.size() - 1)).intValue();
                if (f626a) {
                    Log.v("FragmentManager", "Adding back stack index " + size + " with " + c0262i);
                }
                this.f637k.set(size, c0262i);
            }
        }
        return size;
    }

    public C0273b m1092a(C0274o c0274o) {
        if (c0274o.mIndex < 0) {
            m1084a(new IllegalStateException("Fragment " + c0274o + " is not currently in the FragmentManager"));
        }
        if (c0274o.mState <= 0) {
            return null;
        }
        Bundle g = m1138g(c0274o);
        return g != null ? new C0273b(g) : null;
    }

    public C0274o m1093a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        if (i >= this.f632f.size()) {
            m1084a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        }
        C0274o c0274o = (C0274o) this.f632f.get(i);
        if (c0274o != null) {
            return c0274o;
        }
        m1084a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        return c0274o;
    }

    public C0274o m1094a(String str) {
        int size;
        C0274o c0274o;
        if (!(this.f633g == null || str == null)) {
            for (size = this.f633g.size() - 1; size >= 0; size--) {
                c0274o = (C0274o) this.f633g.get(size);
                if (c0274o != null && str.equals(c0274o.mTag)) {
                    return c0274o;
                }
            }
        }
        if (!(this.f632f == null || str == null)) {
            for (size = this.f632f.size() - 1; size >= 0; size--) {
                c0274o = (C0274o) this.f632f.get(size);
                if (c0274o != null && str.equals(c0274o.mTag)) {
                    return c0274o;
                }
            }
        }
        return null;
    }

    public C0261z m1095a() {
        return new C0262i(this);
    }

    public View m1096a(View view, String str, Context context, AttributeSet attributeSet) {
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0287b.f621a);
        String string = attributeValue == null ? obtainStyledAttributes.getString(0) : attributeValue;
        int resourceId = obtainStyledAttributes.getResourceId(1, -1);
        String string2 = obtainStyledAttributes.getString(2);
        obtainStyledAttributes.recycle();
        if (!C0274o.isSupportFragmentClass(this.f641o.m1013i(), string)) {
            return null;
        }
        int id = view != null ? view.getId() : 0;
        if (id == -1 && resourceId == -1 && string2 == null) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + string);
        }
        C0274o c0274o;
        C0274o b = resourceId != -1 ? m1116b(resourceId) : null;
        if (b == null && string2 != null) {
            b = m1094a(string2);
        }
        if (b == null && id != -1) {
            b = m1116b(id);
        }
        if (f626a) {
            Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + string + " existing=" + b);
        }
        if (b == null) {
            C0274o instantiate = C0274o.instantiate(context, string);
            instantiate.mFromLayout = true;
            instantiate.mFragmentId = resourceId != 0 ? resourceId : id;
            instantiate.mContainerId = id;
            instantiate.mTag = string2;
            instantiate.mInLayout = true;
            instantiate.mFragmentManager = this;
            instantiate.mHost = this.f641o;
            instantiate.onInflate(this.f641o.m1013i(), attributeSet, instantiate.mSavedFragmentState);
            m1106a(instantiate, true);
            c0274o = instantiate;
        } else if (b.mInLayout) {
            throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + string);
        } else {
            b.mInLayout = true;
            b.mHost = this.f641o;
            if (!b.mRetaining) {
                b.onInflate(this.f641o.m1013i(), attributeSet, b.mSavedFragmentState);
            }
            c0274o = b;
        }
        if (this.f640n >= 1 || !c0274o.mFromLayout) {
            m1127c(c0274o);
        } else {
            m1105a(c0274o, 1, 0, 0, false);
        }
        if (c0274o.mView == null) {
            throw new IllegalStateException("Fragment " + string + " did not create a view.");
        }
        if (resourceId != 0) {
            c0274o.mView.setId(resourceId);
        }
        if (c0274o.mView.getTag() == null) {
            c0274o.mView.setTag(string2);
        }
        return c0274o.mView;
    }

    Animation m1097a(C0274o c0274o, int i, boolean z, int i2) {
        Animation onCreateAnimation = c0274o.onCreateAnimation(i, z, c0274o.mNextAnim);
        if (onCreateAnimation != null) {
            return onCreateAnimation;
        }
        if (c0274o.mNextAnim != 0) {
            onCreateAnimation = AnimationUtils.loadAnimation(this.f641o.m1013i(), c0274o.mNextAnim);
            if (onCreateAnimation != null) {
                return onCreateAnimation;
            }
        }
        if (i == 0) {
            return null;
        }
        int b = C0289u.m1087b(i, z);
        if (b < 0) {
            return null;
        }
        switch (b) {
            case C1373c.View_android_focusable /*1*/:
                return C0289u.m1083a(this.f641o.m1013i(), 1.125f, 1.0f, 0.0f, 1.0f);
            case C1373c.View_paddingStart /*2*/:
                return C0289u.m1083a(this.f641o.m1013i(), 1.0f, 0.975f, 1.0f, 0.0f);
            case C1373c.View_paddingEnd /*3*/:
                return C0289u.m1083a(this.f641o.m1013i(), 0.975f, 1.0f, 0.0f, 1.0f);
            case C1373c.View_theme /*4*/:
                return C0289u.m1083a(this.f641o.m1013i(), 1.0f, 1.075f, 1.0f, 0.0f);
            case C1373c.Toolbar_contentInsetStart /*5*/:
                return C0289u.m1082a(this.f641o.m1013i(), 0.0f, 1.0f);
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                return C0289u.m1082a(this.f641o.m1013i(), 1.0f, 0.0f);
            default:
                if (i2 == 0 && this.f641o.m1009e()) {
                    i2 = this.f641o.m1010f();
                }
                return i2 == 0 ? null : null;
        }
    }

    void m1098a(int i, int i2, int i3, boolean z) {
        if (this.f641o == null && i != 0) {
            throw new IllegalStateException("No host");
        } else if (z || this.f640n != i) {
            this.f640n = i;
            if (this.f632f != null) {
                int i4 = 0;
                int i5 = 0;
                while (i4 < this.f632f.size()) {
                    int a;
                    C0274o c0274o = (C0274o) this.f632f.get(i4);
                    if (c0274o != null) {
                        m1105a(c0274o, i, i2, i3, false);
                        if (c0274o.mLoaderManager != null) {
                            a = i5 | c0274o.mLoaderManager.m864a();
                            i4++;
                            i5 = a;
                        }
                    }
                    a = i5;
                    i4++;
                    i5 = a;
                }
                if (i5 == 0) {
                    m1130d();
                }
                if (this.f644s && this.f641o != null && this.f640n == 5) {
                    this.f641o.m1008d();
                    this.f644s = false;
                }
            }
        }
    }

    public void m1099a(int i, C0262i c0262i) {
        synchronized (this) {
            if (this.f637k == null) {
                this.f637k = new ArrayList();
            }
            int size = this.f637k.size();
            if (i < size) {
                if (f626a) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + c0262i);
                }
                this.f637k.set(i, c0262i);
            } else {
                while (size < i) {
                    this.f637k.add(null);
                    if (this.f638l == null) {
                        this.f638l = new ArrayList();
                    }
                    if (f626a) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f638l.add(Integer.valueOf(size));
                    size++;
                }
                if (f626a) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + c0262i);
                }
                this.f637k.add(c0262i);
            }
        }
    }

    void m1100a(int i, boolean z) {
        m1098a(i, 0, 0, z);
    }

    public void m1101a(Configuration configuration) {
        if (this.f633g != null) {
            for (int i = 0; i < this.f633g.size(); i++) {
                C0274o c0274o = (C0274o) this.f633g.get(i);
                if (c0274o != null) {
                    c0274o.performConfigurationChanged(configuration);
                }
            }
        }
    }

    public void m1102a(Bundle bundle, String str, C0274o c0274o) {
        if (c0274o.mIndex < 0) {
            m1084a(new IllegalStateException("Fragment " + c0274o + " is not currently in the FragmentManager"));
        }
        bundle.putInt(str, c0274o.mIndex);
    }

    void m1103a(Parcelable parcelable, C0290v c0290v) {
        if (parcelable != null) {
            C0292w c0292w = (C0292w) parcelable;
            if (c0292w.f654a != null) {
                List a;
                int size;
                int i;
                C0274o c0274o;
                List list;
                if (c0290v != null) {
                    a = c0290v.m1154a();
                    List b = c0290v.m1155b();
                    if (a != null) {
                        size = a.size();
                    } else {
                        boolean z = false;
                    }
                    for (i = 0; i < size; i++) {
                        c0274o = (C0274o) a.get(i);
                        if (f626a) {
                            Log.v("FragmentManager", "restoreAllState: re-attaching retained " + c0274o);
                        }
                        C0294x c0294x = c0292w.f654a[c0274o.mIndex];
                        c0294x.f668l = c0274o;
                        c0274o.mSavedViewState = null;
                        c0274o.mBackStackNesting = 0;
                        c0274o.mInLayout = false;
                        c0274o.mAdded = false;
                        c0274o.mTarget = null;
                        if (c0294x.f667k != null) {
                            c0294x.f667k.setClassLoader(this.f641o.m1013i().getClassLoader());
                            c0274o.mSavedViewState = c0294x.f667k.getSparseParcelableArray("android:view_state");
                            c0274o.mSavedFragmentState = c0294x.f667k;
                        }
                    }
                    list = b;
                } else {
                    list = null;
                }
                this.f632f = new ArrayList(c0292w.f654a.length);
                if (this.f634h != null) {
                    this.f634h.clear();
                }
                int i2 = 0;
                while (i2 < c0292w.f654a.length) {
                    C0294x c0294x2 = c0292w.f654a[i2];
                    if (c0294x2 != null) {
                        C0290v c0290v2 = (list == null || i2 >= list.size()) ? null : (C0290v) list.get(i2);
                        c0274o = c0294x2.m1160a(this.f641o, this.f643q, c0290v2);
                        if (f626a) {
                            Log.v("FragmentManager", "restoreAllState: active #" + i2 + ": " + c0274o);
                        }
                        this.f632f.add(c0274o);
                        c0294x2.f668l = null;
                    } else {
                        this.f632f.add(null);
                        if (this.f634h == null) {
                            this.f634h = new ArrayList();
                        }
                        if (f626a) {
                            Log.v("FragmentManager", "restoreAllState: avail #" + i2);
                        }
                        this.f634h.add(Integer.valueOf(i2));
                    }
                    i2++;
                }
                if (c0290v != null) {
                    a = c0290v.m1154a();
                    if (a != null) {
                        i2 = a.size();
                    } else {
                        boolean z2 = false;
                    }
                    for (i = 0; i < i2; i++) {
                        c0274o = (C0274o) a.get(i);
                        if (c0274o.mTargetIndex >= 0) {
                            if (c0274o.mTargetIndex < this.f632f.size()) {
                                c0274o.mTarget = (C0274o) this.f632f.get(c0274o.mTargetIndex);
                            } else {
                                Log.w("FragmentManager", "Re-attaching retained fragment " + c0274o + " target no longer exists: " + c0274o.mTargetIndex);
                                c0274o.mTarget = null;
                            }
                        }
                    }
                }
                if (c0292w.f655b != null) {
                    this.f633g = new ArrayList(c0292w.f655b.length);
                    for (size = 0; size < c0292w.f655b.length; size++) {
                        c0274o = (C0274o) this.f632f.get(c0292w.f655b[size]);
                        if (c0274o == null) {
                            m1084a(new IllegalStateException("No instantiated fragment for index #" + c0292w.f655b[size]));
                        }
                        c0274o.mAdded = true;
                        if (f626a) {
                            Log.v("FragmentManager", "restoreAllState: added #" + size + ": " + c0274o);
                        }
                        if (this.f633g.contains(c0274o)) {
                            throw new IllegalStateException("Already added!");
                        }
                        this.f633g.add(c0274o);
                    }
                } else {
                    this.f633g = null;
                }
                if (c0292w.f656c != null) {
                    this.f635i = new ArrayList(c0292w.f656c.length);
                    for (int i3 = 0; i3 < c0292w.f656c.length; i3++) {
                        C0262i a2 = c0292w.f656c[i3].m986a(this);
                        if (f626a) {
                            Log.v("FragmentManager", "restoreAllState: back stack #" + i3 + " (index " + a2.f578p + "): " + a2);
                            a2.m978a("  ", new PrintWriter(new C0383d("FragmentManager")), false);
                        }
                        this.f635i.add(a2);
                        if (a2.f578p >= 0) {
                            m1099a(a2.f578p, a2);
                        }
                    }
                    return;
                }
                this.f635i = null;
            }
        }
    }

    public void m1104a(C0274o c0274o, int i, int i2) {
        if (f626a) {
            Log.v("FragmentManager", "remove: " + c0274o + " nesting=" + c0274o.mBackStackNesting);
        }
        boolean z = !c0274o.isInBackStack();
        if (!c0274o.mDetached || z) {
            if (this.f633g != null) {
                this.f633g.remove(c0274o);
            }
            if (c0274o.mHasMenu && c0274o.mMenuVisible) {
                this.f644s = true;
            }
            c0274o.mAdded = false;
            c0274o.mRemoving = true;
            m1105a(c0274o, z ? 0 : 1, i, i2, false);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1105a(android.support.v4.p021b.C0274o r11, int r12, int r13, int r14, boolean r15) {
        /*
        r10 = this;
        r9 = 4;
        r6 = 3;
        r3 = 0;
        r5 = 1;
        r7 = 0;
        r0 = r11.mAdded;
        if (r0 == 0) goto L_0x000d;
    L_0x0009:
        r0 = r11.mDetached;
        if (r0 == 0) goto L_0x0010;
    L_0x000d:
        if (r12 <= r5) goto L_0x0010;
    L_0x000f:
        r12 = r5;
    L_0x0010:
        r0 = r11.mRemoving;
        if (r0 == 0) goto L_0x001a;
    L_0x0014:
        r0 = r11.mState;
        if (r12 <= r0) goto L_0x001a;
    L_0x0018:
        r12 = r11.mState;
    L_0x001a:
        r0 = r11.mDeferStart;
        if (r0 == 0) goto L_0x0025;
    L_0x001e:
        r0 = r11.mState;
        if (r0 >= r9) goto L_0x0025;
    L_0x0022:
        if (r12 <= r6) goto L_0x0025;
    L_0x0024:
        r12 = r6;
    L_0x0025:
        r0 = r11.mState;
        if (r0 >= r12) goto L_0x02eb;
    L_0x0029:
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r11.mInLayout;
        if (r0 != 0) goto L_0x0032;
    L_0x0031:
        return;
    L_0x0032:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x0040;
    L_0x0036:
        r11.mAnimatingAway = r7;
        r2 = r11.mStateAfterAnimating;
        r0 = r10;
        r1 = r11;
        r4 = r3;
        r0.m1105a(r1, r2, r3, r4, r5);
    L_0x0040:
        r0 = r11.mState;
        switch(r0) {
            case 0: goto L_0x0080;
            case 1: goto L_0x0176;
            case 2: goto L_0x026d;
            case 3: goto L_0x0272;
            case 4: goto L_0x0293;
            default: goto L_0x0045;
        };
    L_0x0045:
        r0 = r11.mState;
        if (r0 == r12) goto L_0x0031;
    L_0x0049:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveToState: Fragment state for ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " not updated inline; ";
        r1 = r1.append(r2);
        r2 = "expected state ";
        r1 = r1.append(r2);
        r1 = r1.append(r12);
        r2 = " found ";
        r1 = r1.append(r2);
        r2 = r11.mState;
        r1 = r1.append(r2);
        r1 = r1.toString();
        android.util.Log.w(r0, r1);
        r11.mState = r12;
        goto L_0x0031;
    L_0x0080:
        r0 = f626a;
        if (r0 == 0) goto L_0x009c;
    L_0x0084:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x009c:
        r0 = r11.mSavedFragmentState;
        if (r0 == 0) goto L_0x00e4;
    L_0x00a0:
        r0 = r11.mSavedFragmentState;
        r1 = r10.f641o;
        r1 = r1.m1013i();
        r1 = r1.getClassLoader();
        r0.setClassLoader(r1);
        r0 = r11.mSavedFragmentState;
        r1 = "android:view_state";
        r0 = r0.getSparseParcelableArray(r1);
        r11.mSavedViewState = r0;
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_state";
        r0 = r10.m1093a(r0, r1);
        r11.mTarget = r0;
        r0 = r11.mTarget;
        if (r0 == 0) goto L_0x00d1;
    L_0x00c7:
        r0 = r11.mSavedFragmentState;
        r1 = "android:target_req_state";
        r0 = r0.getInt(r1, r3);
        r11.mTargetRequestCode = r0;
    L_0x00d1:
        r0 = r11.mSavedFragmentState;
        r1 = "android:user_visible_hint";
        r0 = r0.getBoolean(r1, r5);
        r11.mUserVisibleHint = r0;
        r0 = r11.mUserVisibleHint;
        if (r0 != 0) goto L_0x00e4;
    L_0x00df:
        r11.mDeferStart = r5;
        if (r12 <= r6) goto L_0x00e4;
    L_0x00e3:
        r12 = r6;
    L_0x00e4:
        r0 = r10.f641o;
        r11.mHost = r0;
        r0 = r10.f643q;
        r11.mParentFragment = r0;
        r0 = r10.f643q;
        if (r0 == 0) goto L_0x0124;
    L_0x00f0:
        r0 = r10.f643q;
        r0 = r0.mChildFragmentManager;
    L_0x00f4:
        r11.mFragmentManager = r0;
        r11.mCalled = r3;
        r0 = r10.f641o;
        r0 = r0.m1013i();
        r11.onAttach(r0);
        r0 = r11.mCalled;
        if (r0 != 0) goto L_0x012b;
    L_0x0105:
        r0 = new android.support.v4.b.ah;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " did not call through to super.onAttach()";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        throw r0;
    L_0x0124:
        r0 = r10.f641o;
        r0 = r0.m1015k();
        goto L_0x00f4;
    L_0x012b:
        r0 = r11.mParentFragment;
        if (r0 != 0) goto L_0x02ba;
    L_0x012f:
        r0 = r10.f641o;
        r0.m1005b(r11);
    L_0x0134:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x02c1;
    L_0x0138:
        r0 = r11.mSavedFragmentState;
        r11.performCreate(r0);
    L_0x013d:
        r11.mRetaining = r3;
        r0 = r11.mFromLayout;
        if (r0 == 0) goto L_0x0176;
    L_0x0143:
        r0 = r11.mSavedFragmentState;
        r0 = r11.getLayoutInflater(r0);
        r1 = r11.mSavedFragmentState;
        r0 = r11.performCreateView(r0, r7, r1);
        r11.mView = r0;
        r0 = r11.mView;
        if (r0 == 0) goto L_0x02d4;
    L_0x0155:
        r0 = r11.mView;
        r11.mInnerView = r0;
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 < r1) goto L_0x02ca;
    L_0x015f:
        r0 = r11.mView;
        android.support.v4.p016k.ah.m1924b(r0, r3);
    L_0x0164:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x016f;
    L_0x0168:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x016f:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
    L_0x0176:
        if (r12 <= r5) goto L_0x026d;
    L_0x0178:
        r0 = f626a;
        if (r0 == 0) goto L_0x0194;
    L_0x017c:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0194:
        r0 = r11.mFromLayout;
        if (r0 != 0) goto L_0x025d;
    L_0x0198:
        r0 = r11.mContainerId;
        if (r0 == 0) goto L_0x0421;
    L_0x019c:
        r0 = r11.mContainerId;
        r1 = -1;
        if (r0 != r1) goto L_0x01c2;
    L_0x01a1:
        r0 = new java.lang.IllegalArgumentException;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "Cannot create fragment ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r2 = " for a container view with no id";
        r1 = r1.append(r2);
        r1 = r1.toString();
        r0.<init>(r1);
        r10.m1084a(r0);
    L_0x01c2:
        r0 = r10.f642p;
        r1 = r11.mContainerId;
        r0 = r0.m987a(r1);
        r0 = (android.view.ViewGroup) r0;
        if (r0 != 0) goto L_0x0211;
    L_0x01ce:
        r1 = r11.mRestored;
        if (r1 != 0) goto L_0x0211;
    L_0x01d2:
        r1 = r11.getResources();	 Catch:{ NotFoundException -> 0x02d8 }
        r2 = r11.mContainerId;	 Catch:{ NotFoundException -> 0x02d8 }
        r1 = r1.getResourceName(r2);	 Catch:{ NotFoundException -> 0x02d8 }
    L_0x01dc:
        r2 = new java.lang.IllegalArgumentException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r8 = "No view found for id 0x";
        r4 = r4.append(r8);
        r8 = r11.mContainerId;
        r8 = java.lang.Integer.toHexString(r8);
        r4 = r4.append(r8);
        r8 = " (";
        r4 = r4.append(r8);
        r1 = r4.append(r1);
        r4 = ") for fragment ";
        r1 = r1.append(r4);
        r1 = r1.append(r11);
        r1 = r1.toString();
        r2.<init>(r1);
        r10.m1084a(r2);
    L_0x0211:
        r11.mContainer = r0;
        r1 = r11.mSavedFragmentState;
        r1 = r11.getLayoutInflater(r1);
        r2 = r11.mSavedFragmentState;
        r1 = r11.performCreateView(r1, r0, r2);
        r11.mView = r1;
        r1 = r11.mView;
        if (r1 == 0) goto L_0x02e7;
    L_0x0225:
        r1 = r11.mView;
        r11.mInnerView = r1;
        r1 = android.os.Build.VERSION.SDK_INT;
        r2 = 11;
        if (r1 < r2) goto L_0x02dd;
    L_0x022f:
        r1 = r11.mView;
        android.support.v4.p016k.ah.m1924b(r1, r3);
    L_0x0234:
        if (r0 == 0) goto L_0x024b;
    L_0x0236:
        r1 = r10.m1097a(r11, r13, r5, r14);
        if (r1 == 0) goto L_0x0246;
    L_0x023c:
        r2 = r11.mView;
        r10.m1088b(r2, r1);
        r2 = r11.mView;
        r2.startAnimation(r1);
    L_0x0246:
        r1 = r11.mView;
        r0.addView(r1);
    L_0x024b:
        r0 = r11.mHidden;
        if (r0 == 0) goto L_0x0256;
    L_0x024f:
        r0 = r11.mView;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0256:
        r0 = r11.mView;
        r1 = r11.mSavedFragmentState;
        r11.onViewCreated(r0, r1);
    L_0x025d:
        r0 = r11.mSavedFragmentState;
        r11.performActivityCreated(r0);
        r0 = r11.mView;
        if (r0 == 0) goto L_0x026b;
    L_0x0266:
        r0 = r11.mSavedFragmentState;
        r11.restoreViewState(r0);
    L_0x026b:
        r11.mSavedFragmentState = r7;
    L_0x026d:
        r0 = 2;
        if (r12 <= r0) goto L_0x0272;
    L_0x0270:
        r11.mState = r6;
    L_0x0272:
        if (r12 <= r6) goto L_0x0293;
    L_0x0274:
        r0 = f626a;
        if (r0 == 0) goto L_0x0290;
    L_0x0278:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0290:
        r11.performStart();
    L_0x0293:
        if (r12 <= r9) goto L_0x0045;
    L_0x0295:
        r0 = f626a;
        if (r0 == 0) goto L_0x02b1;
    L_0x0299:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "moveto RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x02b1:
        r11.performResume();
        r11.mSavedFragmentState = r7;
        r11.mSavedViewState = r7;
        goto L_0x0045;
    L_0x02ba:
        r0 = r11.mParentFragment;
        r0.onAttachFragment(r11);
        goto L_0x0134;
    L_0x02c1:
        r0 = r11.mSavedFragmentState;
        r11.restoreChildFragmentState(r0);
        r11.mState = r5;
        goto L_0x013d;
    L_0x02ca:
        r0 = r11.mView;
        r0 = android.support.v4.p021b.af.m895a(r0);
        r11.mView = r0;
        goto L_0x0164;
    L_0x02d4:
        r11.mInnerView = r7;
        goto L_0x0176;
    L_0x02d8:
        r1 = move-exception;
        r1 = "unknown";
        goto L_0x01dc;
    L_0x02dd:
        r1 = r11.mView;
        r1 = android.support.v4.p021b.af.m895a(r1);
        r11.mView = r1;
        goto L_0x0234;
    L_0x02e7:
        r11.mInnerView = r7;
        goto L_0x025d;
    L_0x02eb:
        r0 = r11.mState;
        if (r0 <= r12) goto L_0x0045;
    L_0x02ef:
        r0 = r11.mState;
        switch(r0) {
            case 1: goto L_0x02f6;
            case 2: goto L_0x0374;
            case 3: goto L_0x0353;
            case 4: goto L_0x0332;
            case 5: goto L_0x0310;
            default: goto L_0x02f4;
        };
    L_0x02f4:
        goto L_0x0045;
    L_0x02f6:
        if (r12 >= r5) goto L_0x0045;
    L_0x02f8:
        r0 = r10.f646u;
        if (r0 == 0) goto L_0x0307;
    L_0x02fc:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x0307;
    L_0x0300:
        r0 = r11.mAnimatingAway;
        r11.mAnimatingAway = r7;
        r0.clearAnimation();
    L_0x0307:
        r0 = r11.mAnimatingAway;
        if (r0 == 0) goto L_0x03e3;
    L_0x030b:
        r11.mStateAfterAnimating = r12;
        r12 = r5;
        goto L_0x0045;
    L_0x0310:
        r0 = 5;
        if (r12 >= r0) goto L_0x0332;
    L_0x0313:
        r0 = f626a;
        if (r0 == 0) goto L_0x032f;
    L_0x0317:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom RESUMED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x032f:
        r11.performPause();
    L_0x0332:
        if (r12 >= r9) goto L_0x0353;
    L_0x0334:
        r0 = f626a;
        if (r0 == 0) goto L_0x0350;
    L_0x0338:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STARTED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0350:
        r11.performStop();
    L_0x0353:
        if (r12 >= r6) goto L_0x0374;
    L_0x0355:
        r0 = f626a;
        if (r0 == 0) goto L_0x0371;
    L_0x0359:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom STOPPED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0371:
        r11.performReallyStop();
    L_0x0374:
        r0 = 2;
        if (r12 >= r0) goto L_0x02f6;
    L_0x0377:
        r0 = f626a;
        if (r0 == 0) goto L_0x0393;
    L_0x037b:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom ACTIVITY_CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x0393:
        r0 = r11.mView;
        if (r0 == 0) goto L_0x03a6;
    L_0x0397:
        r0 = r10.f641o;
        r0 = r0.m1002a(r11);
        if (r0 == 0) goto L_0x03a6;
    L_0x039f:
        r0 = r11.mSavedViewState;
        if (r0 != 0) goto L_0x03a6;
    L_0x03a3:
        r10.m1137f(r11);
    L_0x03a6:
        r11.performDestroyView();
        r0 = r11.mView;
        if (r0 == 0) goto L_0x03db;
    L_0x03ad:
        r0 = r11.mContainer;
        if (r0 == 0) goto L_0x03db;
    L_0x03b1:
        r0 = r10.f640n;
        if (r0 <= 0) goto L_0x041f;
    L_0x03b5:
        r0 = r10.f646u;
        if (r0 != 0) goto L_0x041f;
    L_0x03b9:
        r0 = r10.m1097a(r11, r13, r3, r14);
    L_0x03bd:
        if (r0 == 0) goto L_0x03d4;
    L_0x03bf:
        r1 = r11.mView;
        r11.mAnimatingAway = r1;
        r11.mStateAfterAnimating = r12;
        r1 = r11.mView;
        r2 = new android.support.v4.b.u$2;
        r2.<init>(r10, r1, r0, r11);
        r0.setAnimationListener(r2);
        r1 = r11.mView;
        r1.startAnimation(r0);
    L_0x03d4:
        r0 = r11.mContainer;
        r1 = r11.mView;
        r0.removeView(r1);
    L_0x03db:
        r11.mContainer = r7;
        r11.mView = r7;
        r11.mInnerView = r7;
        goto L_0x02f6;
    L_0x03e3:
        r0 = f626a;
        if (r0 == 0) goto L_0x03ff;
    L_0x03e7:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "movefrom CREATED: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x03ff:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0414;
    L_0x0403:
        r11.performDestroy();
    L_0x0406:
        r11.performDetach();
        if (r15 != 0) goto L_0x0045;
    L_0x040b:
        r0 = r11.mRetaining;
        if (r0 != 0) goto L_0x0417;
    L_0x040f:
        r10.m1133e(r11);
        goto L_0x0045;
    L_0x0414:
        r11.mState = r3;
        goto L_0x0406;
    L_0x0417:
        r11.mHost = r7;
        r11.mParentFragment = r7;
        r11.mFragmentManager = r7;
        goto L_0x0045;
    L_0x041f:
        r0 = r7;
        goto L_0x03bd;
    L_0x0421:
        r0 = r7;
        goto L_0x0211;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.u.a(android.support.v4.b.o, int, int, int, boolean):void");
    }

    public void m1106a(C0274o c0274o, boolean z) {
        if (this.f633g == null) {
            this.f633g = new ArrayList();
        }
        if (f626a) {
            Log.v("FragmentManager", "add: " + c0274o);
        }
        m1131d(c0274o);
        if (!c0274o.mDetached) {
            if (this.f633g.contains(c0274o)) {
                throw new IllegalStateException("Fragment already added: " + c0274o);
            }
            this.f633g.add(c0274o);
            c0274o.mAdded = true;
            c0274o.mRemoving = false;
            if (c0274o.mHasMenu && c0274o.mMenuVisible) {
                this.f644s = true;
            }
            if (z) {
                m1127c(c0274o);
            }
        }
    }

    public void m1107a(C0276s c0276s, C0269q c0269q, C0274o c0274o) {
        if (this.f641o != null) {
            throw new IllegalStateException("Already attached");
        }
        this.f641o = c0276s;
        this.f642p = c0269q;
        this.f643q = c0274o;
    }

    public void m1108a(Runnable runnable, boolean z) {
        if (!z) {
            m1090v();
        }
        synchronized (this) {
            if (this.f646u || this.f641o == null) {
                throw new IllegalStateException("Activity has been destroyed");
            }
            if (this.f629c == null) {
                this.f629c = new ArrayList();
            }
            this.f629c.add(runnable);
            if (this.f629c.size() == 1) {
                this.f641o.m1014j().removeCallbacks(this.f651z);
                this.f641o.m1014j().post(this.f651z);
            }
        }
    }

    public void m1109a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int i;
        C0274o c0274o;
        int i2 = 0;
        String str2 = str + "    ";
        if (this.f632f != null) {
            size = this.f632f.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.print("Active Fragments in ");
                printWriter.print(Integer.toHexString(System.identityHashCode(this)));
                printWriter.println(":");
                for (i = 0; i < size; i++) {
                    c0274o = (C0274o) this.f632f.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0274o);
                    if (c0274o != null) {
                        c0274o.dump(str2, fileDescriptor, printWriter, strArr);
                    }
                }
            }
        }
        if (this.f633g != null) {
            size = this.f633g.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Added Fragments:");
                for (i = 0; i < size; i++) {
                    c0274o = (C0274o) this.f633g.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0274o.toString());
                }
            }
        }
        if (this.f636j != null) {
            size = this.f636j.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Fragments Created Menus:");
                for (i = 0; i < size; i++) {
                    c0274o = (C0274o) this.f636j.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0274o.toString());
                }
            }
        }
        if (this.f635i != null) {
            size = this.f635i.size();
            if (size > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack:");
                for (i = 0; i < size; i++) {
                    C0262i c0262i = (C0262i) this.f635i.get(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i);
                    printWriter.print(": ");
                    printWriter.println(c0262i.toString());
                    c0262i.m977a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        synchronized (this) {
            if (this.f637k != null) {
                int size2 = this.f637k.size();
                if (size2 > 0) {
                    printWriter.print(str);
                    printWriter.println("Back Stack Indices:");
                    for (i = 0; i < size2; i++) {
                        c0262i = (C0262i) this.f637k.get(i);
                        printWriter.print(str);
                        printWriter.print("  #");
                        printWriter.print(i);
                        printWriter.print(": ");
                        printWriter.println(c0262i);
                    }
                }
            }
            if (this.f638l != null && this.f638l.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f638l.toArray()));
            }
        }
        if (this.f629c != null) {
            i = this.f629c.size();
            if (i > 0) {
                printWriter.print(str);
                printWriter.println("Pending Actions:");
                while (i2 < i) {
                    Runnable runnable = (Runnable) this.f629c.get(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i2);
                    printWriter.print(": ");
                    printWriter.println(runnable);
                    i2++;
                }
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f641o);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f642p);
        if (this.f643q != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f643q);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f640n);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f645t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f646u);
        if (this.f644s) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f644s);
        }
        if (this.f647v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f647v);
        }
        if (this.f634h != null && this.f634h.size() > 0) {
            printWriter.print(str);
            printWriter.print("  mAvailIndices: ");
            printWriter.println(Arrays.toString(this.f634h.toArray()));
        }
    }

    public void m1110a(boolean z) {
        if (this.f633g != null) {
            for (int size = this.f633g.size() - 1; size >= 0; size--) {
                C0274o c0274o = (C0274o) this.f633g.get(size);
                if (c0274o != null) {
                    c0274o.performMultiWindowModeChanged(z);
                }
            }
        }
    }

    boolean m1111a(int i) {
        return this.f640n >= i;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean m1112a(android.os.Handler r12, java.lang.String r13, int r14, int r15) {
        /*
        r11 = this;
        r4 = 0;
        r2 = 1;
        r3 = 0;
        r0 = r11.f635i;
        if (r0 != 0) goto L_0x0008;
    L_0x0007:
        return r3;
    L_0x0008:
        if (r13 != 0) goto L_0x003b;
    L_0x000a:
        if (r14 >= 0) goto L_0x003b;
    L_0x000c:
        r0 = r15 & 1;
        if (r0 != 0) goto L_0x003b;
    L_0x0010:
        r0 = r11.f635i;
        r0 = r0.size();
        r0 = r0 + -1;
        if (r0 < 0) goto L_0x0007;
    L_0x001a:
        r1 = r11.f635i;
        r0 = r1.remove(r0);
        r0 = (android.support.v4.p021b.C0262i) r0;
        r1 = new android.util.SparseArray;
        r1.<init>();
        r3 = new android.util.SparseArray;
        r3.<init>();
        r5 = r11.f640n;
        if (r5 < r2) goto L_0x0033;
    L_0x0030:
        r0.m976a(r1, r3);
    L_0x0033:
        r0.m968a(r2, r4, r1, r3);
        r11.m1139g();
    L_0x0039:
        r3 = r2;
        goto L_0x0007;
    L_0x003b:
        r0 = -1;
        if (r13 != 0) goto L_0x0040;
    L_0x003e:
        if (r14 < 0) goto L_0x008f;
    L_0x0040:
        r0 = r11.f635i;
        r0 = r0.size();
        r1 = r0 + -1;
    L_0x0048:
        if (r1 < 0) goto L_0x005e;
    L_0x004a:
        r0 = r11.f635i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.p021b.C0262i) r0;
        if (r13 == 0) goto L_0x0085;
    L_0x0054:
        r5 = r0.m983e();
        r5 = r13.equals(r5);
        if (r5 == 0) goto L_0x0085;
    L_0x005e:
        if (r1 < 0) goto L_0x0007;
    L_0x0060:
        r0 = r15 & 1;
        if (r0 == 0) goto L_0x008e;
    L_0x0064:
        r1 = r1 + -1;
    L_0x0066:
        if (r1 < 0) goto L_0x008e;
    L_0x0068:
        r0 = r11.f635i;
        r0 = r0.get(r1);
        r0 = (android.support.v4.p021b.C0262i) r0;
        if (r13 == 0) goto L_0x007c;
    L_0x0072:
        r5 = r0.m983e();
        r5 = r13.equals(r5);
        if (r5 != 0) goto L_0x0082;
    L_0x007c:
        if (r14 < 0) goto L_0x008e;
    L_0x007e:
        r0 = r0.f578p;
        if (r14 != r0) goto L_0x008e;
    L_0x0082:
        r1 = r1 + -1;
        goto L_0x0066;
    L_0x0085:
        if (r14 < 0) goto L_0x008b;
    L_0x0087:
        r0 = r0.f578p;
        if (r14 == r0) goto L_0x005e;
    L_0x008b:
        r1 = r1 + -1;
        goto L_0x0048;
    L_0x008e:
        r0 = r1;
    L_0x008f:
        r1 = r11.f635i;
        r1 = r1.size();
        r1 = r1 + -1;
        if (r0 == r1) goto L_0x0007;
    L_0x0099:
        r6 = new java.util.ArrayList;
        r6.<init>();
        r1 = r11.f635i;
        r1 = r1.size();
        r1 = r1 + -1;
    L_0x00a6:
        if (r1 <= r0) goto L_0x00b4;
    L_0x00a8:
        r5 = r11.f635i;
        r5 = r5.remove(r1);
        r6.add(r5);
        r1 = r1 + -1;
        goto L_0x00a6;
    L_0x00b4:
        r0 = r6.size();
        r7 = r0 + -1;
        r8 = new android.util.SparseArray;
        r8.<init>();
        r9 = new android.util.SparseArray;
        r9.<init>();
        r0 = r11.f640n;
        if (r0 < r2) goto L_0x00d8;
    L_0x00c8:
        r1 = r3;
    L_0x00c9:
        if (r1 > r7) goto L_0x00d8;
    L_0x00cb:
        r0 = r6.get(r1);
        r0 = (android.support.v4.p021b.C0262i) r0;
        r0.m976a(r8, r9);
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00c9;
    L_0x00d8:
        r5 = r4;
        r4 = r3;
    L_0x00da:
        if (r4 > r7) goto L_0x0110;
    L_0x00dc:
        r0 = f626a;
        if (r0 == 0) goto L_0x00fc;
    L_0x00e0:
        r0 = "FragmentManager";
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r10 = "Popping back stack state: ";
        r1 = r1.append(r10);
        r10 = r6.get(r4);
        r1 = r1.append(r10);
        r1 = r1.toString();
        android.util.Log.v(r0, r1);
    L_0x00fc:
        r0 = r6.get(r4);
        r0 = (android.support.v4.p021b.C0262i) r0;
        if (r4 != r7) goto L_0x010e;
    L_0x0104:
        r1 = r2;
    L_0x0105:
        r1 = r0.m968a(r1, r5, r8, r9);
        r0 = r4 + 1;
        r4 = r0;
        r5 = r1;
        goto L_0x00da;
    L_0x010e:
        r1 = r3;
        goto L_0x0105;
    L_0x0110:
        r11.m1139g();
        goto L_0x0039;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.u.a(android.os.Handler, java.lang.String, int, int):boolean");
    }

    public boolean m1113a(Menu menu) {
        if (this.f633g == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f633g.size(); i++) {
            C0274o c0274o = (C0274o) this.f633g.get(i);
            if (c0274o != null && c0274o.performPrepareOptionsMenu(menu)) {
                z = true;
            }
        }
        return z;
    }

    public boolean m1114a(Menu menu, MenuInflater menuInflater) {
        boolean z;
        C0274o c0274o;
        int i = 0;
        ArrayList arrayList = null;
        if (this.f633g != null) {
            int i2 = 0;
            z = false;
            while (i2 < this.f633g.size()) {
                c0274o = (C0274o) this.f633g.get(i2);
                if (c0274o != null && c0274o.performCreateOptionsMenu(menu, menuInflater)) {
                    z = true;
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(c0274o);
                }
                i2++;
                z = z;
            }
        } else {
            z = false;
        }
        if (this.f636j != null) {
            while (i < this.f636j.size()) {
                c0274o = (C0274o) this.f636j.get(i);
                if (arrayList == null || !arrayList.contains(c0274o)) {
                    c0274o.onDestroyOptionsMenu();
                }
                i++;
            }
        }
        this.f636j = arrayList;
        return z;
    }

    public boolean m1115a(MenuItem menuItem) {
        if (this.f633g == null) {
            return false;
        }
        for (int i = 0; i < this.f633g.size(); i++) {
            C0274o c0274o = (C0274o) this.f633g.get(i);
            if (c0274o != null && c0274o.performOptionsItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public C0274o m1116b(int i) {
        int size;
        C0274o c0274o;
        if (this.f633g != null) {
            for (size = this.f633g.size() - 1; size >= 0; size--) {
                c0274o = (C0274o) this.f633g.get(size);
                if (c0274o != null && c0274o.mFragmentId == i) {
                    return c0274o;
                }
            }
        }
        if (this.f632f != null) {
            for (size = this.f632f.size() - 1; size >= 0; size--) {
                c0274o = (C0274o) this.f632f.get(size);
                if (c0274o != null && c0274o.mFragmentId == i) {
                    return c0274o;
                }
            }
        }
        return null;
    }

    public C0274o m1117b(String str) {
        if (!(this.f632f == null || str == null)) {
            for (int size = this.f632f.size() - 1; size >= 0; size--) {
                C0274o c0274o = (C0274o) this.f632f.get(size);
                if (c0274o != null) {
                    c0274o = c0274o.findFragmentByWho(str);
                    if (c0274o != null) {
                        return c0274o;
                    }
                }
            }
        }
        return null;
    }

    void m1118b(C0262i c0262i) {
        if (this.f635i == null) {
            this.f635i = new ArrayList();
        }
        this.f635i.add(c0262i);
        m1139g();
    }

    public void m1119b(C0274o c0274o) {
        if (!c0274o.mDeferStart) {
            return;
        }
        if (this.f631e) {
            this.f648w = true;
            return;
        }
        c0274o.mDeferStart = false;
        m1105a(c0274o, this.f640n, 0, 0, false);
    }

    public void m1120b(C0274o c0274o, int i, int i2) {
        if (f626a) {
            Log.v("FragmentManager", "hide: " + c0274o);
        }
        if (!c0274o.mHidden) {
            c0274o.mHidden = true;
            if (c0274o.mView != null) {
                Animation a = m1097a(c0274o, i, false, i2);
                if (a != null) {
                    m1088b(c0274o.mView, a);
                    c0274o.mView.startAnimation(a);
                }
                c0274o.mView.setVisibility(8);
            }
            if (c0274o.mAdded && c0274o.mHasMenu && c0274o.mMenuVisible) {
                this.f644s = true;
            }
            c0274o.onHiddenChanged(true);
        }
    }

    public void m1121b(Menu menu) {
        if (this.f633g != null) {
            for (int i = 0; i < this.f633g.size(); i++) {
                C0274o c0274o = (C0274o) this.f633g.get(i);
                if (c0274o != null) {
                    c0274o.performOptionsMenuClosed(menu);
                }
            }
        }
    }

    public void m1122b(Runnable runnable, boolean z) {
        if (this.f631e) {
            throw new IllegalStateException("FragmentManager is already executing transactions");
        } else if (Looper.myLooper() != this.f641o.m1014j().getLooper()) {
            throw new IllegalStateException("Must be called from main thread of fragment host");
        } else {
            if (!z) {
                m1090v();
            }
            this.f631e = true;
            runnable.run();
            this.f631e = false;
            m1136f();
        }
    }

    public void m1123b(boolean z) {
        if (this.f633g != null) {
            for (int size = this.f633g.size() - 1; size >= 0; size--) {
                C0274o c0274o = (C0274o) this.f633g.get(size);
                if (c0274o != null) {
                    c0274o.performPictureInPictureModeChanged(z);
                }
            }
        }
    }

    public boolean m1124b() {
        m1090v();
        m1129c();
        return m1112a(this.f641o.m1014j(), null, -1, 0);
    }

    public boolean m1125b(MenuItem menuItem) {
        if (this.f633g == null) {
            return false;
        }
        for (int i = 0; i < this.f633g.size(); i++) {
            C0274o c0274o = (C0274o) this.f633g.get(i);
            if (c0274o != null && c0274o.performContextItemSelected(menuItem)) {
                return true;
            }
        }
        return false;
    }

    public void m1126c(int i) {
        synchronized (this) {
            this.f637k.set(i, null);
            if (this.f638l == null) {
                this.f638l = new ArrayList();
            }
            if (f626a) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f638l.add(Integer.valueOf(i));
        }
    }

    void m1127c(C0274o c0274o) {
        m1105a(c0274o, this.f640n, 0, 0, false);
    }

    public void m1128c(C0274o c0274o, int i, int i2) {
        if (f626a) {
            Log.v("FragmentManager", "show: " + c0274o);
        }
        if (c0274o.mHidden) {
            c0274o.mHidden = false;
            if (c0274o.mView != null) {
                Animation a = m1097a(c0274o, i, true, i2);
                if (a != null) {
                    m1088b(c0274o.mView, a);
                    c0274o.mView.startAnimation(a);
                }
                c0274o.mView.setVisibility(0);
            }
            if (c0274o.mAdded && c0274o.mHasMenu && c0274o.mMenuVisible) {
                this.f644s = true;
            }
            c0274o.onHiddenChanged(false);
        }
    }

    public boolean m1129c() {
        return m1135e();
    }

    void m1130d() {
        if (this.f632f != null) {
            for (int i = 0; i < this.f632f.size(); i++) {
                C0274o c0274o = (C0274o) this.f632f.get(i);
                if (c0274o != null) {
                    m1119b(c0274o);
                }
            }
        }
    }

    void m1131d(C0274o c0274o) {
        if (c0274o.mIndex < 0) {
            if (this.f634h == null || this.f634h.size() <= 0) {
                if (this.f632f == null) {
                    this.f632f = new ArrayList();
                }
                c0274o.setIndex(this.f632f.size(), this.f643q);
                this.f632f.add(c0274o);
            } else {
                c0274o.setIndex(((Integer) this.f634h.remove(this.f634h.size() - 1)).intValue(), this.f643q);
                this.f632f.set(c0274o.mIndex, c0274o);
            }
            if (f626a) {
                Log.v("FragmentManager", "Allocated fragment index " + c0274o);
            }
        }
    }

    public void m1132d(C0274o c0274o, int i, int i2) {
        if (f626a) {
            Log.v("FragmentManager", "detach: " + c0274o);
        }
        if (!c0274o.mDetached) {
            c0274o.mDetached = true;
            if (c0274o.mAdded) {
                if (this.f633g != null) {
                    if (f626a) {
                        Log.v("FragmentManager", "remove from detach: " + c0274o);
                    }
                    this.f633g.remove(c0274o);
                }
                if (c0274o.mHasMenu && c0274o.mMenuVisible) {
                    this.f644s = true;
                }
                c0274o.mAdded = false;
                m1105a(c0274o, 1, i, i2, false);
            }
        }
    }

    void m1133e(C0274o c0274o) {
        if (c0274o.mIndex >= 0) {
            if (f626a) {
                Log.v("FragmentManager", "Freeing fragment index " + c0274o);
            }
            this.f632f.set(c0274o.mIndex, null);
            if (this.f634h == null) {
                this.f634h = new ArrayList();
            }
            this.f634h.add(Integer.valueOf(c0274o.mIndex));
            this.f641o.m1006b(c0274o.mWho);
            c0274o.initState();
        }
    }

    public void m1134e(C0274o c0274o, int i, int i2) {
        if (f626a) {
            Log.v("FragmentManager", "attach: " + c0274o);
        }
        if (c0274o.mDetached) {
            c0274o.mDetached = false;
            if (!c0274o.mAdded) {
                if (this.f633g == null) {
                    this.f633g = new ArrayList();
                }
                if (this.f633g.contains(c0274o)) {
                    throw new IllegalStateException("Fragment already added: " + c0274o);
                }
                if (f626a) {
                    Log.v("FragmentManager", "add from attach: " + c0274o);
                }
                this.f633g.add(c0274o);
                c0274o.mAdded = true;
                if (c0274o.mHasMenu && c0274o.mMenuVisible) {
                    this.f644s = true;
                }
                m1105a(c0274o, this.f640n, i, i2, false);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean m1135e() {
        /*
        r6 = this;
        r2 = 1;
        r1 = 0;
        r0 = r6.f631e;
        if (r0 == 0) goto L_0x000e;
    L_0x0006:
        r0 = new java.lang.IllegalStateException;
        r1 = "FragmentManager is already executing transactions";
        r0.<init>(r1);
        throw r0;
    L_0x000e:
        r0 = android.os.Looper.myLooper();
        r3 = r6.f641o;
        r3 = r3.m1014j();
        r3 = r3.getLooper();
        if (r0 == r3) goto L_0x0026;
    L_0x001e:
        r0 = new java.lang.IllegalStateException;
        r1 = "Must be called from main thread of fragment host";
        r0.<init>(r1);
        throw r0;
    L_0x0026:
        r0 = r1;
    L_0x0027:
        monitor-enter(r6);
        r3 = r6.f629c;	 Catch:{ all -> 0x0078 }
        if (r3 == 0) goto L_0x0034;
    L_0x002c:
        r3 = r6.f629c;	 Catch:{ all -> 0x0078 }
        r3 = r3.size();	 Catch:{ all -> 0x0078 }
        if (r3 != 0) goto L_0x0039;
    L_0x0034:
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.m1136f();
        return r0;
    L_0x0039:
        r0 = r6.f629c;	 Catch:{ all -> 0x0078 }
        r3 = r0.size();	 Catch:{ all -> 0x0078 }
        r0 = r6.f630d;	 Catch:{ all -> 0x0078 }
        if (r0 == 0) goto L_0x0048;
    L_0x0043:
        r0 = r6.f630d;	 Catch:{ all -> 0x0078 }
        r0 = r0.length;	 Catch:{ all -> 0x0078 }
        if (r0 >= r3) goto L_0x004c;
    L_0x0048:
        r0 = new java.lang.Runnable[r3];	 Catch:{ all -> 0x0078 }
        r6.f630d = r0;	 Catch:{ all -> 0x0078 }
    L_0x004c:
        r0 = r6.f629c;	 Catch:{ all -> 0x0078 }
        r4 = r6.f630d;	 Catch:{ all -> 0x0078 }
        r0.toArray(r4);	 Catch:{ all -> 0x0078 }
        r0 = r6.f629c;	 Catch:{ all -> 0x0078 }
        r0.clear();	 Catch:{ all -> 0x0078 }
        r0 = r6.f641o;	 Catch:{ all -> 0x0078 }
        r0 = r0.m1014j();	 Catch:{ all -> 0x0078 }
        r4 = r6.f651z;	 Catch:{ all -> 0x0078 }
        r0.removeCallbacks(r4);	 Catch:{ all -> 0x0078 }
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        r6.f631e = r2;
        r0 = r1;
    L_0x0067:
        if (r0 >= r3) goto L_0x007b;
    L_0x0069:
        r4 = r6.f630d;
        r4 = r4[r0];
        r4.run();
        r4 = r6.f630d;
        r5 = 0;
        r4[r0] = r5;
        r0 = r0 + 1;
        goto L_0x0067;
    L_0x0078:
        r0 = move-exception;
        monitor-exit(r6);	 Catch:{ all -> 0x0078 }
        throw r0;
    L_0x007b:
        r6.f631e = r1;
        r0 = r2;
        goto L_0x0027;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.b.u.e():boolean");
    }

    void m1136f() {
        if (this.f648w) {
            int i = 0;
            for (int i2 = 0; i2 < this.f632f.size(); i2++) {
                C0274o c0274o = (C0274o) this.f632f.get(i2);
                if (!(c0274o == null || c0274o.mLoaderManager == null)) {
                    i |= c0274o.mLoaderManager.m864a();
                }
            }
            if (i == 0) {
                this.f648w = false;
                m1130d();
            }
        }
    }

    void m1137f(C0274o c0274o) {
        if (c0274o.mInnerView != null) {
            if (this.f650y == null) {
                this.f650y = new SparseArray();
            } else {
                this.f650y.clear();
            }
            c0274o.mInnerView.saveHierarchyState(this.f650y);
            if (this.f650y.size() > 0) {
                c0274o.mSavedViewState = this.f650y;
                this.f650y = null;
            }
        }
    }

    Bundle m1138g(C0274o c0274o) {
        Bundle bundle;
        if (this.f649x == null) {
            this.f649x = new Bundle();
        }
        c0274o.performSaveInstanceState(this.f649x);
        if (this.f649x.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f649x;
            this.f649x = null;
        }
        if (c0274o.mView != null) {
            m1137f(c0274o);
        }
        if (c0274o.mSavedViewState != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", c0274o.mSavedViewState);
        }
        if (!c0274o.mUserVisibleHint) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", c0274o.mUserVisibleHint);
        }
        return bundle;
    }

    void m1139g() {
        if (this.f639m != null) {
            for (int i = 0; i < this.f639m.size(); i++) {
                ((C0281a) this.f639m.get(i)).m1072a();
            }
        }
    }

    C0290v m1140h() {
        List list;
        List list2;
        if (this.f632f != null) {
            int i = 0;
            list = null;
            list2 = null;
            while (i < this.f632f.size()) {
                ArrayList arrayList;
                C0274o c0274o = (C0274o) this.f632f.get(i);
                if (c0274o != null) {
                    boolean z;
                    if (c0274o.mRetainInstance) {
                        if (list2 == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(c0274o);
                        c0274o.mRetaining = true;
                        c0274o.mTargetIndex = c0274o.mTarget != null ? c0274o.mTarget.mIndex : -1;
                        if (f626a) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + c0274o);
                        }
                    }
                    if (c0274o.mChildFragmentManager != null) {
                        C0290v h = c0274o.mChildFragmentManager.m1140h();
                        if (h != null) {
                            ArrayList arrayList2;
                            if (list == null) {
                                arrayList2 = new ArrayList();
                                for (int i2 = 0; i2 < i; i2++) {
                                    arrayList2.add(null);
                                }
                            } else {
                                arrayList2 = list;
                            }
                            arrayList2.add(h);
                            list = arrayList2;
                            z = true;
                            if (!(list == null || r0)) {
                                list.add(null);
                            }
                        }
                    }
                    z = false;
                    list.add(null);
                }
                i++;
                Object obj = arrayList;
            }
        } else {
            list = null;
            list2 = null;
        }
        return (list2 == null && list == null) ? null : new C0290v(list2, list);
    }

    Parcelable m1141i() {
        C0264j[] c0264jArr = null;
        m1135e();
        if (f627b) {
            this.f645t = true;
        }
        if (this.f632f == null || this.f632f.size() <= 0) {
            return null;
        }
        int size = this.f632f.size();
        C0294x[] c0294xArr = new C0294x[size];
        int i = 0;
        boolean z = false;
        while (i < size) {
            boolean z2;
            C0274o c0274o = (C0274o) this.f632f.get(i);
            if (c0274o != null) {
                if (c0274o.mIndex < 0) {
                    m1084a(new IllegalStateException("Failure saving state: active " + c0274o + " has cleared index: " + c0274o.mIndex));
                }
                C0294x c0294x = new C0294x(c0274o);
                c0294xArr[i] = c0294x;
                if (c0274o.mState <= 0 || c0294x.f667k != null) {
                    c0294x.f667k = c0274o.mSavedFragmentState;
                } else {
                    c0294x.f667k = m1138g(c0274o);
                    if (c0274o.mTarget != null) {
                        if (c0274o.mTarget.mIndex < 0) {
                            m1084a(new IllegalStateException("Failure saving state: " + c0274o + " has target not in fragment manager: " + c0274o.mTarget));
                        }
                        if (c0294x.f667k == null) {
                            c0294x.f667k = new Bundle();
                        }
                        m1102a(c0294x.f667k, "android:target_state", c0274o.mTarget);
                        if (c0274o.mTargetRequestCode != 0) {
                            c0294x.f667k.putInt("android:target_req_state", c0274o.mTargetRequestCode);
                        }
                    }
                }
                if (f626a) {
                    Log.v("FragmentManager", "Saved state of " + c0274o + ": " + c0294x.f667k);
                }
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        if (z) {
            int[] iArr;
            int i2;
            C0292w c0292w;
            if (this.f633g != null) {
                i = this.f633g.size();
                if (i > 0) {
                    iArr = new int[i];
                    for (i2 = 0; i2 < i; i2++) {
                        iArr[i2] = ((C0274o) this.f633g.get(i2)).mIndex;
                        if (iArr[i2] < 0) {
                            m1084a(new IllegalStateException("Failure saving state: active " + this.f633g.get(i2) + " has cleared index: " + iArr[i2]));
                        }
                        if (f626a) {
                            Log.v("FragmentManager", "saveAllState: adding fragment #" + i2 + ": " + this.f633g.get(i2));
                        }
                    }
                    if (this.f635i != null) {
                        i = this.f635i.size();
                        if (i > 0) {
                            c0264jArr = new C0264j[i];
                            for (i2 = 0; i2 < i; i2++) {
                                c0264jArr[i2] = new C0264j((C0262i) this.f635i.get(i2));
                                if (f626a) {
                                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f635i.get(i2));
                                }
                            }
                        }
                    }
                    c0292w = new C0292w();
                    c0292w.f654a = c0294xArr;
                    c0292w.f655b = iArr;
                    c0292w.f656c = c0264jArr;
                    return c0292w;
                }
            }
            iArr = null;
            if (this.f635i != null) {
                i = this.f635i.size();
                if (i > 0) {
                    c0264jArr = new C0264j[i];
                    for (i2 = 0; i2 < i; i2++) {
                        c0264jArr[i2] = new C0264j((C0262i) this.f635i.get(i2));
                        if (f626a) {
                            Log.v("FragmentManager", "saveAllState: adding back stack #" + i2 + ": " + this.f635i.get(i2));
                        }
                    }
                }
            }
            c0292w = new C0292w();
            c0292w.f654a = c0294xArr;
            c0292w.f655b = iArr;
            c0292w.f656c = c0264jArr;
            return c0292w;
        } else if (!f626a) {
            return null;
        } else {
            Log.v("FragmentManager", "saveAllState: no fragments!");
            return null;
        }
    }

    public void m1142j() {
        this.f645t = false;
    }

    public void m1143k() {
        this.f645t = false;
        m1100a(1, false);
    }

    public void m1144l() {
        this.f645t = false;
        m1100a(2, false);
    }

    public void m1145m() {
        this.f645t = false;
        m1100a(4, false);
    }

    public void m1146n() {
        this.f645t = false;
        m1100a(5, false);
    }

    public void m1147o() {
        m1100a(4, false);
    }

    public void m1148p() {
        this.f645t = true;
        m1100a(3, false);
    }

    public void m1149q() {
        m1100a(2, false);
    }

    public void m1150r() {
        m1100a(1, false);
    }

    public void m1151s() {
        this.f646u = true;
        m1135e();
        m1100a(0, false);
        this.f641o = null;
        this.f642p = null;
        this.f643q = null;
    }

    public void m1152t() {
        if (this.f633g != null) {
            for (int i = 0; i < this.f633g.size(); i++) {
                C0274o c0274o = (C0274o) this.f633g.get(i);
                if (c0274o != null) {
                    c0274o.performLowMemory();
                }
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("FragmentManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        if (this.f643q != null) {
            C0382c.m1432a(this.f643q, stringBuilder);
        } else {
            C0382c.m1432a(this.f641o, stringBuilder);
        }
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    C0288n m1153u() {
        return this;
    }
}
