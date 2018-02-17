package android.support.v7.p033a;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.p033a.C0672h.C0671b;
import android.support.v7.view.C0716b;
import android.support.v7.view.C0716b.C0694a;
import android.support.v7.view.C0744f.C0743a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

/* renamed from: android.support.v7.a.k */
class C0679k extends C0678j {
    private static C0712r f1229r;
    private int f1230s;
    private boolean f1231t;
    private boolean f1232u;

    /* renamed from: android.support.v7.a.k.a */
    class C0673a extends C0671b {
        final /* synthetic */ C0679k f1201c;

        C0673a(C0679k c0679k, Callback callback) {
            this.f1201c = c0679k;
            super(c0679k, callback);
        }

        final ActionMode m2943a(ActionMode.Callback callback) {
            Object c0743a = new C0743a(this.f1201c.a, callback);
            C0716b a = this.f1201c.m2984a((C0694a) c0743a);
            return a != null ? c0743a.m3242a(a) : null;
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return this.f1201c.m3025o() ? m2943a(callback) : super.onWindowStartingActionMode(callback);
        }
    }

    C0679k(Context context, Window window, C0663f c0663f) {
        super(context, window, c0663f);
        this.f1230s = -100;
        this.f1232u = true;
    }

    private boolean m3018e(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    private C0712r m3019u() {
        if (f1229r == null) {
            f1229r = new C0712r(this.a.getApplicationContext());
        }
        return f1229r;
    }

    Callback m3020a(Callback callback) {
        return new C0673a(this, callback);
    }

    public void m3021a(Bundle bundle) {
        super.m2989a(bundle);
        if (bundle != null && this.f1230s == -100) {
            this.f1230s = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    public void m3022c(Bundle bundle) {
        super.m2932c(bundle);
        if (this.f1230s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f1230s);
        }
    }

    int m3023d(int i) {
        switch (i) {
            case -100:
                return -1;
            case C1373c.View_android_theme /*0*/:
                return m3019u().m3103a() ? 2 : 1;
            default:
                return i;
        }
    }

    public boolean m3024i() {
        this.f1231t = true;
        int d = m3023d(this.f1230s == -100 ? C0667g.m2898j() : this.f1230s);
        return d != -1 ? m3018e(d) : false;
    }

    public boolean m3025o() {
        return this.f1232u;
    }
}
