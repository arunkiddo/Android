package android.support.v7.p033a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p017g.C0354c;
import android.support.v7.p033a.C0647b.C0646a;
import android.support.v7.view.C0716b;
import android.support.v7.view.C0716b.C0694a;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;

/* renamed from: android.support.v7.a.g */
public abstract class C0667g {
    private static int f1181a;
    private static boolean f1182b;

    static {
        f1181a = -1;
        f1182b = false;
    }

    C0667g() {
    }

    public static C0667g m2895a(Activity activity, C0663f c0663f) {
        return C0667g.m2897a(activity, activity.getWindow(), c0663f);
    }

    public static C0667g m2896a(Dialog dialog, C0663f c0663f) {
        return C0667g.m2897a(dialog.getContext(), dialog.getWindow(), c0663f);
    }

    private static C0667g m2897a(Context context, Window window, C0663f c0663f) {
        int i = VERSION.SDK_INT;
        return C0354c.m1328a() ? new C0681i(context, window, c0663f) : i >= 23 ? new C0680l(context, window, c0663f) : i >= 14 ? new C0679k(context, window, c0663f) : i >= 11 ? new C0678j(context, window, c0663f) : new C0677m(context, window, c0663f);
    }

    public static int m2898j() {
        return f1181a;
    }

    public static boolean m2899k() {
        return f1182b;
    }

    public abstract C0645a m2900a();

    public abstract C0716b m2901a(C0694a c0694a);

    public abstract View m2902a(int i);

    public abstract void m2903a(Configuration configuration);

    public abstract void m2904a(Bundle bundle);

    public abstract void m2905a(Toolbar toolbar);

    public abstract void m2906a(View view);

    public abstract void m2907a(View view, LayoutParams layoutParams);

    public abstract void m2908a(CharSequence charSequence);

    public abstract MenuInflater m2909b();

    public abstract void m2910b(int i);

    public abstract void m2911b(Bundle bundle);

    public abstract void m2912b(View view, LayoutParams layoutParams);

    public abstract void m2913c();

    public abstract void m2914c(Bundle bundle);

    public abstract boolean m2915c(int i);

    public abstract void m2916d();

    public abstract void m2917e();

    public abstract void m2918f();

    public abstract C0646a m2919g();

    public abstract void m2920h();

    public abstract boolean m2921i();
}
