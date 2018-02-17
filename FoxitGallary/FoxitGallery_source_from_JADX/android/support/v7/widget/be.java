package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

class be extends au {
    private final WeakReference<Context> f2346a;

    public be(Context context, Resources resources) {
        super(resources);
        this.f2346a = new WeakReference(context);
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        Context context = (Context) this.f2346a.get();
        if (!(drawable == null || context == null)) {
            C0951m.m4995a();
            C0951m.m5001a(context, i, drawable);
        }
        return drawable;
    }
}
