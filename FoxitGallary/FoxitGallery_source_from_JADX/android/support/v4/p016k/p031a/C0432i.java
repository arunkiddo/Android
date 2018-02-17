package android.support.v4.p016k.p031a;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.List;

/* renamed from: android.support.v4.k.a.i */
class C0432i {

    /* renamed from: android.support.v4.k.a.i.a */
    interface C0423a {
        Object m1621a(int i);

        List<Object> m1622a(String str, int i);

        boolean m1623a(int i, int i2, Bundle bundle);
    }

    /* renamed from: android.support.v4.k.a.i.1 */
    static class C04311 extends AccessibilityNodeProvider {
        final /* synthetic */ C0423a f772a;

        C04311(C0423a c0423a) {
            this.f772a = c0423a;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            return (AccessibilityNodeInfo) this.f772a.m1621a(i);
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i) {
            return this.f772a.m1622a(str, i);
        }

        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f772a.m1623a(i, i2, bundle);
        }
    }

    public static Object m1643a(C0423a c0423a) {
        return new C04311(c0423a);
    }
}
