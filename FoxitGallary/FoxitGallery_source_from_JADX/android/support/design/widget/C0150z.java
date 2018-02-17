package android.support.design.widget;

import android.widget.ImageButton;

/* renamed from: android.support.design.widget.z */
class C0150z extends ImageButton {
    private int f293a;

    final void m521a(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f293a = i;
        }
    }

    final int getUserSetVisibility() {
        return this.f293a;
    }

    public void setVisibility(int i) {
        m521a(i, true);
    }
}
