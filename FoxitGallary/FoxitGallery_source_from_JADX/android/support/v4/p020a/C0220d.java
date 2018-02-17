package android.support.v4.p020a;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;

/* renamed from: android.support.v4.a.d */
class C0220d implements C0218b {
    private TimeInterpolator f472a;

    C0220d() {
    }

    public void m794a(View view) {
        if (this.f472a == null) {
            this.f472a = new ValueAnimator().getInterpolator();
        }
        view.animate().setInterpolator(this.f472a);
    }
}
