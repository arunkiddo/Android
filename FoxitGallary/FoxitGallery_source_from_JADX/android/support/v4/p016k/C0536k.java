package android.support.v4.p016k;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

/* renamed from: android.support.v4.k.k */
class C0536k {

    /* renamed from: android.support.v4.k.k.a */
    static class C0535a implements Factory {
        final C0288n f850a;

        C0535a(C0288n c0288n) {
            this.f850a = c0288n;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f850a.m1081a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f850a + "}";
        }
    }

    static C0288n m2321a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        return factory instanceof C0535a ? ((C0535a) factory).f850a : null;
    }

    static void m2322a(LayoutInflater layoutInflater, C0288n c0288n) {
        layoutInflater.setFactory(c0288n != null ? new C0535a(c0288n) : null);
    }
}
