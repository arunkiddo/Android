package android.support.v7.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.support.v7.p033a.C0667g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class bc extends ContextWrapper {
    private static final ArrayList<WeakReference<bc>> f2339a;
    private final Resources f2340b;
    private final Theme f2341c;

    static {
        f2339a = new ArrayList();
    }

    private bc(Context context) {
        super(context);
        if (bh.m4843a()) {
            this.f2340b = new bh(this, context.getResources());
            this.f2341c = this.f2340b.newTheme();
            this.f2341c.setTo(context.getTheme());
            return;
        }
        this.f2340b = new be(this, context.getResources());
        this.f2341c = null;
    }

    public static Context m4769a(Context context) {
        if (!m4770b(context)) {
            return context;
        }
        Context context2;
        int size = f2339a.size();
        for (int i = 0; i < size; i++) {
            WeakReference weakReference = (WeakReference) f2339a.get(i);
            context2 = weakReference != null ? (bc) weakReference.get() : null;
            if (context2 != null && context2.getBaseContext() == context) {
                return context2;
            }
        }
        context2 = new bc(context);
        f2339a.add(new WeakReference(context2));
        return context2;
    }

    private static boolean m4770b(Context context) {
        return ((context instanceof bc) || (context.getResources() instanceof be) || (context.getResources() instanceof bh)) ? false : !C0667g.m2899k() || VERSION.SDK_INT <= 20;
    }

    public Resources getResources() {
        return this.f2340b;
    }

    public Theme getTheme() {
        return this.f2341c == null ? super.getTheme() : this.f2341c;
    }

    public void setTheme(int i) {
        if (this.f2341c == null) {
            super.setTheme(i);
        } else {
            this.f2341c.applyStyle(i, true);
        }
    }
}
