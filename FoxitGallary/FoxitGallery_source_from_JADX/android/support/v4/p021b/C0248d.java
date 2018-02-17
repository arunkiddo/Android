package android.support.v4.p021b;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;

/* renamed from: android.support.v4.b.d */
class C0248d {
    public static void m919a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        activity.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }
}
