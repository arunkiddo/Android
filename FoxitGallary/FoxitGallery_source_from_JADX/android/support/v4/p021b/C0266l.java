package android.support.v4.p021b;

import android.content.Intent;
import android.content.IntentSender;

/* renamed from: android.support.v4.b.l */
abstract class C0266l extends C0265k {
    boolean mStartedIntentSenderFromFragment;

    C0266l() {
    }

    static void checkForValidRequestCode(int i) {
        if ((-65536 & i) != 0) {
            throw new IllegalArgumentException("Can only use lower 16 bits for requestCode");
        }
    }

    void onBackPressedNotHandled() {
        super.onBackPressed();
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        if (!(this.mStartedIntentSenderFromFragment || i == -1)) {
            C0266l.checkForValidRequestCode(i);
        }
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }
}
