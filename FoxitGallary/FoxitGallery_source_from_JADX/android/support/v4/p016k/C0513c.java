package android.support.v4.p016k;

import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

/* renamed from: android.support.v4.k.c */
class C0513c {

    /* renamed from: android.support.v4.k.c.a */
    public interface C0497a {
        void m2167a(View view, int i);

        void m2168a(View view, Object obj);

        boolean m2169a(View view, AccessibilityEvent accessibilityEvent);

        boolean m2170a(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent);

        void m2171b(View view, AccessibilityEvent accessibilityEvent);

        void m2172c(View view, AccessibilityEvent accessibilityEvent);

        void m2173d(View view, AccessibilityEvent accessibilityEvent);
    }

    /* renamed from: android.support.v4.k.c.1 */
    static class C05121 extends AccessibilityDelegate {
        final /* synthetic */ C0497a f842a;

        C05121(C0497a c0497a) {
            this.f842a = c0497a;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f842a.m2169a(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f842a.m2171b(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            this.f842a.m2168a(view, (Object) accessibilityNodeInfo);
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f842a.m2172c(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f842a.m2170a(viewGroup, view, accessibilityEvent);
        }

        public void sendAccessibilityEvent(View view, int i) {
            this.f842a.m2167a(view, i);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f842a.m2173d(view, accessibilityEvent);
        }
    }

    public static Object m2259a() {
        return new AccessibilityDelegate();
    }

    public static Object m2260a(C0497a c0497a) {
        return new C05121(c0497a);
    }

    public static void m2261a(Object obj, View view, int i) {
        ((AccessibilityDelegate) obj).sendAccessibilityEvent(view, i);
    }

    public static void m2262a(Object obj, View view, Object obj2) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityNodeInfo(view, (AccessibilityNodeInfo) obj2);
    }

    public static boolean m2263a(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static boolean m2264a(Object obj, ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return ((AccessibilityDelegate) obj).onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public static void m2265b(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public static void m2266c(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public static void m2267d(Object obj, View view, AccessibilityEvent accessibilityEvent) {
        ((AccessibilityDelegate) obj).sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }
}
