package android.support.v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.widget.b */
class C0917b extends Drawable {
    final ActionBarContainer f2328a;

    public C0917b(ActionBarContainer actionBarContainer) {
        this.f2328a = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.f2328a.f1649d) {
            if (this.f2328a.f1646a != null) {
                this.f2328a.f1646a.draw(canvas);
            }
            if (this.f2328a.f1647b != null && this.f2328a.f1650e) {
                this.f2328a.f1647b.draw(canvas);
            }
        } else if (this.f2328a.f1648c != null) {
            this.f2328a.f1648c.draw(canvas);
        }
    }

    public int getOpacity() {
        return 0;
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }
}
