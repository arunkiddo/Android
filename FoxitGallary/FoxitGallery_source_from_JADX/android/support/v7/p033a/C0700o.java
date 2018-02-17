package android.support.v7.p033a;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.p016k.ah;
import android.support.v4.p030j.C0380a;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.C0741d;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.C0854g;
import android.support.v7.widget.C0927q;
import android.support.v7.widget.C0942i;
import android.support.v7.widget.C0943j;
import android.support.v7.widget.C0944k;
import android.support.v7.widget.C0952n;
import android.support.v7.widget.C0953o;
import android.support.v7.widget.C0955r;
import android.support.v7.widget.C0959u;
import android.support.v7.widget.C0960v;
import android.support.v7.widget.C0961w;
import android.support.v7.widget.aa;
import android.support.v7.widget.bc;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import com.simplemobiletools.gallery.BuildConfig;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;

/* renamed from: android.support.v7.a.o */
class C0700o {
    private static final Class<?>[] f1278a;
    private static final int[] f1279b;
    private static final String[] f1280c;
    private static final Map<String, Constructor<? extends View>> f1281d;
    private final Object[] f1282e;

    /* renamed from: android.support.v7.a.o.a */
    private static class C0699a implements OnClickListener {
        private final View f1274a;
        private final String f1275b;
        private Method f1276c;
        private Context f1277d;

        public C0699a(View view, String str) {
            this.f1274a = view;
            this.f1275b = str;
        }

        private void m3054a(Context context, String str) {
            for (Context context2 = context; context2 != null; context2 = context2 instanceof ContextWrapper ? ((ContextWrapper) context2).getBaseContext() : null) {
                try {
                    if (!context2.isRestricted()) {
                        Method method = context2.getClass().getMethod(this.f1275b, new Class[]{View.class});
                        if (method != null) {
                            this.f1276c = method;
                            this.f1277d = context2;
                            return;
                        }
                    }
                } catch (NoSuchMethodException e) {
                }
            }
            int id = this.f1274a.getId();
            throw new IllegalStateException("Could not find method " + this.f1275b + "(View) in a parent or ancestor Context for android:onClick " + "attribute defined on view " + this.f1274a.getClass() + (id == -1 ? BuildConfig.FLAVOR : " with id '" + this.f1274a.getContext().getResources().getResourceEntryName(id) + "'"));
        }

        public void onClick(View view) {
            if (this.f1276c == null) {
                m3054a(this.f1274a.getContext(), this.f1275b);
            }
            try {
                this.f1276c.invoke(this.f1277d, new Object[]{view});
            } catch (Throwable e) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
            } catch (Throwable e2) {
                throw new IllegalStateException("Could not execute method for android:onClick", e2);
            }
        }
    }

    static {
        f1278a = new Class[]{Context.class, AttributeSet.class};
        f1279b = new int[]{16843375};
        f1280c = new String[]{"android.widget.", "android.view.", "android.webkit."};
        f1281d = new C0380a();
    }

    C0700o() {
        this.f1282e = new Object[2];
    }

    private static Context m3055a(Context context, AttributeSet attributeSet, boolean z, boolean z2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0729j.View, 0, 0);
        int resourceId = z ? obtainStyledAttributes.getResourceId(C0729j.View_android_theme, 0) : 0;
        if (z2 && resourceId == 0) {
            resourceId = obtainStyledAttributes.getResourceId(C0729j.View_theme, 0);
            if (resourceId != 0) {
                Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
            }
        }
        int i = resourceId;
        obtainStyledAttributes.recycle();
        return i != 0 ? ((context instanceof C0741d) && ((C0741d) context).m3223a() == i) ? context : new C0741d(context, i) : context;
    }

    private View m3056a(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            this.f1282e[0] = context;
            this.f1282e[1] = attributeSet;
            View a;
            if (-1 == str.indexOf(46)) {
                for (String a2 : f1280c) {
                    a = m3057a(context, str, a2);
                    if (a != null) {
                        return a;
                    }
                }
                this.f1282e[0] = null;
                this.f1282e[1] = null;
                return null;
            }
            a = m3057a(context, str, null);
            this.f1282e[0] = null;
            this.f1282e[1] = null;
            return a;
        } catch (Exception e) {
            return null;
        } finally {
            this.f1282e[0] = null;
            this.f1282e[1] = null;
        }
    }

    private View m3057a(Context context, String str, String str2) {
        Constructor constructor = (Constructor) f1281d.get(str);
        if (constructor == null) {
            try {
                constructor = context.getClassLoader().loadClass(str2 != null ? str2 + str : str).asSubclass(View.class).getConstructor(f1278a);
                f1281d.put(str, constructor);
            } catch (Exception e) {
                return null;
            }
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f1282e);
    }

    private void m3058a(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if (!(context instanceof ContextWrapper)) {
            return;
        }
        if (VERSION.SDK_INT < 15 || ah.m1904G(view)) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1279b);
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new C0699a(view, string));
            }
            obtainStyledAttributes.recycle();
        }
    }

    public final View m3059a(View view, String str, Context context, AttributeSet attributeSet, boolean z, boolean z2, boolean z3, boolean z4) {
        Context context2 = (!z || view == null) ? context : view.getContext();
        if (z2 || z3) {
            context2 = C0700o.m3055a(context2, attributeSet, z2, z3);
        }
        if (z4) {
            context2 = bc.m4769a(context2);
        }
        View view2 = null;
        Object obj = -1;
        switch (str.hashCode()) {
            case -1946472170:
                if (str.equals("RatingBar")) {
                    obj = 11;
                    break;
                }
                break;
            case -1455429095:
                if (str.equals("CheckedTextView")) {
                    obj = 8;
                    break;
                }
                break;
            case -1346021293:
                if (str.equals("MultiAutoCompleteTextView")) {
                    obj = 10;
                    break;
                }
                break;
            case -938935918:
                if (str.equals("TextView")) {
                    obj = null;
                    break;
                }
                break;
            case -937446323:
                if (str.equals("ImageButton")) {
                    obj = 5;
                    break;
                }
                break;
            case -658531749:
                if (str.equals("SeekBar")) {
                    obj = 12;
                    break;
                }
                break;
            case -339785223:
                if (str.equals("Spinner")) {
                    obj = 4;
                    break;
                }
                break;
            case 776382189:
                if (str.equals("RadioButton")) {
                    obj = 7;
                    break;
                }
                break;
            case 1125864064:
                if (str.equals("ImageView")) {
                    obj = 1;
                    break;
                }
                break;
            case 1413872058:
                if (str.equals("AutoCompleteTextView")) {
                    obj = 9;
                    break;
                }
                break;
            case 1601505219:
                if (str.equals("CheckBox")) {
                    obj = 6;
                    break;
                }
                break;
            case 1666676343:
                if (str.equals("EditText")) {
                    obj = 3;
                    break;
                }
                break;
            case 2001146706:
                if (str.equals("Button")) {
                    obj = 2;
                    break;
                }
                break;
        }
        switch (obj) {
            case C1373c.View_android_theme /*0*/:
                view2 = new aa(context2, attributeSet);
                break;
            case C1373c.View_android_focusable /*1*/:
                view2 = new C0927q(context2, attributeSet);
                break;
            case C1373c.View_paddingStart /*2*/:
                view2 = new C0942i(context2, attributeSet);
                break;
            case C1373c.View_paddingEnd /*3*/:
                view2 = new C0952n(context2, attributeSet);
                break;
            case C1373c.View_theme /*4*/:
                view2 = new AppCompatSpinner(context2, attributeSet);
                break;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                view2 = new C0953o(context2, attributeSet);
                break;
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                view2 = new C0943j(context2, attributeSet);
                break;
            case C1373c.Toolbar_contentInsetLeft /*7*/:
                view2 = new C0959u(context2, attributeSet);
                break;
            case C1373c.Toolbar_contentInsetRight /*8*/:
                view2 = new C0944k(context2, attributeSet);
                break;
            case C1373c.Toolbar_contentInsetStartWithNavigation /*9*/:
                view2 = new C0854g(context2, attributeSet);
                break;
            case C1373c.Toolbar_contentInsetEndWithActions /*10*/:
                view2 = new C0955r(context2, attributeSet);
                break;
            case C1373c.Toolbar_popupTheme /*11*/:
                view2 = new C0960v(context2, attributeSet);
                break;
            case C1373c.Toolbar_titleTextAppearance /*12*/:
                view2 = new C0961w(context2, attributeSet);
                break;
        }
        View a = (view2 != null || context == context2) ? view2 : m3056a(context2, str, attributeSet);
        if (a != null) {
            m3058a(a, attributeSet);
        }
        return a;
    }
}
