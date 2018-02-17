package android.support.v4.p016k;

import android.view.MotionEvent;

/* renamed from: android.support.v4.k.u */
class C0561u {
    public static int m2401a(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int m2402a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m2403b(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m2404c(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }

    public static float m2405d(MotionEvent motionEvent, int i) {
        return motionEvent.getY(i);
    }
}
