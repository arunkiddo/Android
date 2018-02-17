package android.support.v4.p016k;

import android.content.Context;
import android.support.v4.p016k.C0536k.C0535a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: android.support.v4.k.l */
class C0538l {
    private static Field f851a;
    private static boolean f852b;

    /* renamed from: android.support.v4.k.l.a */
    static class C0537a extends C0535a implements Factory2 {
        C0537a(C0288n c0288n) {
            super(c0288n);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.m1081a(view, str, context, attributeSet);
        }
    }

    static void m2323a(LayoutInflater layoutInflater, C0288n c0288n) {
        Factory2 c0537a = c0288n != null ? new C0537a(c0288n) : null;
        layoutInflater.setFactory2(c0537a);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            C0538l.m2324a(layoutInflater, (Factory2) factory);
        } else {
            C0538l.m2324a(layoutInflater, c0537a);
        }
    }

    static void m2324a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f852b) {
            try {
                f851a = LayoutInflater.class.getDeclaredField("mFactory2");
                f851a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f852b = true;
        }
        if (f851a != null) {
            try {
                f851a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
