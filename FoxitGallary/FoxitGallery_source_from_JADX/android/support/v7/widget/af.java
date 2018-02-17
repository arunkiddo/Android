package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.p014d.p015a.C0334i;
import android.support.v7.p018d.p019a.C0188a;
import android.util.Log;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.reflect.Field;

public class af {
    public static final Rect f2230a;
    private static Class<?> f2231b;

    static {
        f2230a = new Rect();
        if (VERSION.SDK_INT >= 18) {
            try {
                f2231b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    static Mode m4624a(int i, Mode mode) {
        switch (i) {
            case C1373c.View_paddingEnd /*3*/:
                return Mode.SRC_OVER;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                return Mode.SRC_IN;
            case C1373c.Toolbar_contentInsetStartWithNavigation /*9*/:
                return Mode.SRC_ATOP;
            case C1373c.Toolbar_titleMargin /*14*/:
                return Mode.MULTIPLY;
            case C1373c.Toolbar_titleMarginStart /*15*/:
                return Mode.SCREEN;
            case C1373c.Toolbar_titleMarginEnd /*16*/:
                return VERSION.SDK_INT >= 11 ? Mode.valueOf("ADD") : mode;
            default:
                return mode;
        }
    }

    public static Rect m4625a(Drawable drawable) {
        if (f2231b != null) {
            try {
                Drawable g = C0326a.m1273g(drawable);
                Object invoke = g.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(g, new Object[0]);
                if (invoke != null) {
                    Rect rect = new Rect();
                    for (Field field : f2231b.getFields()) {
                        String name = field.getName();
                        Object obj = -1;
                        switch (name.hashCode()) {
                            case -1383228885:
                                if (name.equals("bottom")) {
                                    obj = 3;
                                    break;
                                }
                                break;
                            case 115029:
                                if (name.equals("top")) {
                                    obj = 1;
                                    break;
                                }
                                break;
                            case 3317767:
                                if (name.equals("left")) {
                                    obj = null;
                                    break;
                                }
                                break;
                            case 108511772:
                                if (name.equals("right")) {
                                    obj = 2;
                                    break;
                                }
                                break;
                        }
                        switch (obj) {
                            case C1373c.View_android_theme /*0*/:
                                rect.left = field.getInt(invoke);
                                break;
                            case C1373c.View_android_focusable /*1*/:
                                rect.top = field.getInt(invoke);
                                break;
                            case C1373c.View_paddingStart /*2*/:
                                rect.right = field.getInt(invoke);
                                break;
                            case C1373c.View_paddingEnd /*3*/:
                                rect.bottom = field.getInt(invoke);
                                break;
                            default:
                                break;
                        }
                    }
                    return rect;
                }
            } catch (Exception e) {
                Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
            }
        }
        return f2230a;
    }

    static void m4626b(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m4628d(drawable);
        }
    }

    public static boolean m4627c(Drawable drawable) {
        if (VERSION.SDK_INT < 8 && (drawable instanceof StateListDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (constantState instanceof DrawableContainerState) {
                for (Drawable c : ((DrawableContainerState) constantState).getChildren()) {
                    if (!m4627c(c)) {
                        return false;
                    }
                }
            }
        } else if (drawable instanceof C0334i) {
            return m4627c(((C0334i) drawable).m1301a());
        } else {
            if (drawable instanceof C0188a) {
                return m4627c(((C0188a) drawable).m685b());
            }
            if (drawable instanceof ScaleDrawable) {
                return m4627c(((ScaleDrawable) drawable).getDrawable());
            }
        }
        return true;
    }

    private static void m4628d(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(ba.f2333e);
        } else {
            drawable.setState(ba.f2336h);
        }
        drawable.setState(state);
    }
}
