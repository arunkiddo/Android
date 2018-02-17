package android.support.v4.p016k.p031a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.k.a.j */
class C0434j {

    /* renamed from: android.support.v4.k.a.j.a */
    interface C0427a {
        Object m1629a(int i);

        List<Object> m1630a(String str, int i);

        boolean m1631a(int i, int i2, Bundle bundle);

        Object m1632b(int i);
    }

    /* renamed from: android.support.v4.k.a.j.1 */
    static class C04331 extends AccessibilityNodeProvider {
        final /* synthetic */ C0427a f773a;

        C04331(C0427a c0427a) {
            this.f773a = c0427a;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return (AccessibilityNodeInfo) this.f773a.m1629a(i);
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.f773a.m1630a(str, i);
        }

        public AccessibilityNodeInfo findFocus(int i) {
            return (AccessibilityNodeInfo) this.f773a.m1632b(i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f773a.m1631a(i, i2, bundle);
        }
    }

    public static Object m1644a(C0427a c0427a) {
        return new C04331(c0427a);
    }
}
