package com.p045c.p046a.p068e;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.p021b.C0274o;
import android.support.v4.p021b.C0279p;
import android.support.v4.p021b.C0282t;
import android.util.Log;
import com.p045c.p046a.C1305l;
import com.p045c.p046a.p055j.C1296h;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.c.a.e.k */
public class C1242k implements Callback {
    private static final C1242k f3117c;
    final Map<FragmentManager, C1241j> f3118a;
    final Map<C0282t, C1246n> f3119b;
    private volatile C1305l f3120d;
    private final Handler f3121e;

    static {
        f3117c = new C1242k();
    }

    C1242k() {
        this.f3118a = new HashMap();
        this.f3119b = new HashMap();
        this.f3121e = new Handler(Looper.getMainLooper(), this);
    }

    public static C1242k m5878a() {
        return f3117c;
    }

    private C1305l m5879b(Context context) {
        if (this.f3120d == null) {
            synchronized (this) {
                if (this.f3120d == null) {
                    this.f3120d = new C1305l(context.getApplicationContext(), new C1230b(), new C1237f());
                }
            }
        }
        return this.f3120d;
    }

    @TargetApi(17)
    private static void m5880b(Activity activity) {
        if (VERSION.SDK_INT >= 17 && activity.isDestroyed()) {
            throw new IllegalArgumentException("You cannot start a load for a destroyed activity");
        }
    }

    @TargetApi(17)
    C1241j m5881a(FragmentManager fragmentManager) {
        C1241j c1241j = (C1241j) fragmentManager.findFragmentByTag("com.bumptech.glide.manager");
        if (c1241j != null) {
            return c1241j;
        }
        c1241j = (C1241j) this.f3118a.get(fragmentManager);
        if (c1241j != null) {
            return c1241j;
        }
        Fragment c1241j2 = new C1241j();
        this.f3118a.put(fragmentManager, c1241j2);
        fragmentManager.beginTransaction().add(c1241j2, "com.bumptech.glide.manager").commitAllowingStateLoss();
        this.f3121e.obtainMessage(1, fragmentManager).sendToTarget();
        return c1241j2;
    }

    C1246n m5882a(C0282t c0282t) {
        C1246n c1246n = (C1246n) c0282t.m1075a("com.bumptech.glide.manager");
        if (c1246n != null) {
            return c1246n;
        }
        c1246n = (C1246n) this.f3119b.get(c0282t);
        if (c1246n != null) {
            return c1246n;
        }
        C0274o c1246n2 = new C1246n();
        this.f3119b.put(c0282t, c1246n2);
        c0282t.m1076a().m935a(c1246n2, "com.bumptech.glide.manager").m938c();
        this.f3121e.obtainMessage(2, c0282t).sendToTarget();
        return c1246n2;
    }

    @TargetApi(11)
    public C1305l m5883a(Activity activity) {
        if (C1296h.m6117c() || VERSION.SDK_INT < 11) {
            return m5884a(activity.getApplicationContext());
        }
        C1242k.m5880b(activity);
        return m5885a((Context) activity, activity.getFragmentManager());
    }

    public C1305l m5884a(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("You cannot start a load on a null Context");
        }
        if (C1296h.m6115b() && !(context instanceof Application)) {
            if (context instanceof C0279p) {
                return m5887a((C0279p) context);
            }
            if (context instanceof Activity) {
                return m5883a((Activity) context);
            }
            if (context instanceof ContextWrapper) {
                return m5884a(((ContextWrapper) context).getBaseContext());
            }
        }
        return m5879b(context);
    }

    @TargetApi(11)
    C1305l m5885a(Context context, FragmentManager fragmentManager) {
        C1241j a = m5881a(fragmentManager);
        C1305l b = a.m5876b();
        if (b != null) {
            return b;
        }
        b = new C1305l(context, a.m5874a(), a.m5877c());
        a.m5875a(b);
        return b;
    }

    C1305l m5886a(Context context, C0282t c0282t) {
        C1246n a = m5882a(c0282t);
        C1305l b = a.m5898b();
        if (b != null) {
            return b;
        }
        b = new C1305l(context, a.m5896a(), a.m5899c());
        a.m5897a(b);
        return b;
    }

    public C1305l m5887a(C0279p c0279p) {
        if (C1296h.m6117c()) {
            return m5884a(c0279p.getApplicationContext());
        }
        C1242k.m5880b((Activity) c0279p);
        return m5886a((Context) c0279p, c0279p.getSupportFragmentManager());
    }

    public boolean handleMessage(Message message) {
        Object obj = null;
        boolean z = true;
        Object remove;
        switch (message.what) {
            case C1373c.View_android_focusable /*1*/:
                FragmentManager fragmentManager = (FragmentManager) message.obj;
                remove = this.f3118a.remove(fragmentManager);
                break;
            case C1373c.View_paddingStart /*2*/:
                C0282t c0282t = (C0282t) message.obj;
                remove = this.f3119b.remove(c0282t);
                break;
            default:
                z = false;
                remove = null;
                break;
        }
        if (z && r1 == null && Log.isLoggable("RMRetriever", 5)) {
            Log.w("RMRetriever", "Failed to remove expected request manager fragment, manager: " + obj);
        }
        return z;
    }
}
