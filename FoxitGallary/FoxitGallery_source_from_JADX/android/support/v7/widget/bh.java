package android.support.v7.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p033a.C0667g;
import java.lang.ref.WeakReference;

public class bh extends Resources {
    private final WeakReference<Context> f2372a;

    public bh(Context context, Resources resources) {
        super(resources.getAssets(), resources.getDisplayMetrics(), resources.getConfiguration());
        this.f2372a = new WeakReference(context);
    }

    public static boolean m4843a() {
        return C0667g.m2899k() && VERSION.SDK_INT <= 20;
    }

    final Drawable m4844a(int i) {
        return super.getDrawable(i);
    }

    public Drawable getDrawable(int i) {
        Context context = (Context) this.f2372a.get();
        return context != null ? C0951m.m4995a().m5015a(context, this, i) : super.getDrawable(i);
    }
}
