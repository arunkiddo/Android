package android.support.v4.p016k;

import android.view.KeyEvent;

/* renamed from: android.support.v4.k.i */
class C0529i {
    public static int m2309a(int i) {
        return KeyEvent.normalizeMetaState(i);
    }

    public static boolean m2310a(int i, int i2) {
        return KeyEvent.metaStateHasModifiers(i, i2);
    }

    public static boolean m2311a(KeyEvent keyEvent) {
        return keyEvent.isCtrlPressed();
    }

    public static boolean m2312b(int i) {
        return KeyEvent.metaStateHasNoModifiers(i);
    }
}
