package android.support.v4.p016k;

import android.os.Bundle;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;

/* renamed from: android.support.v4.k.d */
class C0515d {

    /* renamed from: android.support.v4.k.d.a */
    public interface C0502a {
        Object m2212a(View view);

        void m2213a(View view, int i);

        void m2214a(View view, Object obj);

        boolean m2215a(View view, int i, Bundle bundle);

        boolean m2216a(View view, AccessibilityEvent accessibilityEvent);

        boolean m2217a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m2218b(View view, AccessibilityEvent accessibilityEvent);

        void m2219c(View view, AccessibilityEvent accessibilityEvent);

        void m2220d(View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.k.d.1 */
    static class C05141 extends AccessibilityDelegate {
        final /* synthetic */ C0502a f843a;

        C05141(C0502a c0502a) {
            this.f843a = c0502a;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f843a.m2216a(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            return (AccessibilityNodeProvider) this.f843a.m2212a(view);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f843a.m2218b(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f843a.m2214a(view, (Object) accessibilityNodeInfo);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f843a.m2219c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f843a.m2217a(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            return this.f843a.m2215a(view, i, bundle);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f843a.m2213a(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f843a.m2220d(view, accessibilityEvent);
        }
    }

    public static Object m2268a(C0502a c0502a) {
        return new C05141(c0502a);
    }

    public static Object m2269a(Object obj, View view) {
        return ((AccessibilityDelegate) obj).getAccessibilityNodeProvider(view);
    }

    public static boolean m2270a(Object obj, View view, int i, Bundle bundle) {
        return ((AccessibilityDelegate) obj).performAccessibilityAction(view, i, bundle);
    }
}
