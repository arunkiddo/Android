package android.support.v7.widget;

import android.graphics.Outline;

/* renamed from: android.support.v7.widget.c */
class C0921c extends C0917b {
    public C0921c(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public void getOutline(Outline outline) {
        if (this.a.f1649d) {
            if (this.a.f1648c != null) {
                this.a.f1648c.getOutline(outline);
            }
        } else if (this.a.f1646a != null) {
            this.a.f1646a.getOutline(outline);
        }
    }
}
