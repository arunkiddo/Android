package android.support.design.widget;

import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.support.design.C0110a.C0104b;
import android.view.View;

/* renamed from: android.support.design.widget.y */
class C0216y {
    private static final int[] f470a;

    static {
        f470a = new int[]{16843848};
    }

    static void m790a(View view, float f) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(new int[]{16842766, C0104b.state_collapsible, C0104b.state_collapsed}, ObjectAnimator.ofFloat(view, "elevation", new float[]{f}));
        stateListAnimator.addState(new int[]{16842766, C0104b.state_collapsible, -C0104b.state_collapsed}, ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}));
        stateListAnimator.addState(new int[]{16842766, -C0104b.state_collapsible}, ObjectAnimator.ofFloat(view, "elevation", new float[]{f}));
        stateListAnimator.addState(new int[0], ObjectAnimator.ofFloat(view, "elevation", new float[]{0.0f}));
        view.setStateListAnimator(stateListAnimator);
    }
}
