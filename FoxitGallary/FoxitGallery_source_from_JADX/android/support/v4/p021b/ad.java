package android.support.v4.p021b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.support.v4.p022c.C0314f;
import android.util.Log;

/* renamed from: android.support.v4.b.ad */
public final class ad {
    private static final C0237a f524a;

    /* renamed from: android.support.v4.b.ad.a */
    interface C0237a {
        Intent m872a(Activity activity);

        String m873a(Context context, ActivityInfo activityInfo);

        boolean m874a(Activity activity, Intent intent);

        void m875b(Activity activity, Intent intent);
    }

    /* renamed from: android.support.v4.b.ad.b */
    static class C0238b implements C0237a {
        C0238b() {
        }

        public Intent m876a(Activity activity) {
            String b = ad.m888b(activity);
            if (b == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, b);
            try {
                return ad.m889b((Context) activity, componentName) == null ? C0314f.m1188a(componentName) : new Intent().setComponent(componentName);
            } catch (NameNotFoundException e) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + b + "' in manifest");
                return null;
            }
        }

        public String m877a(Context context, ActivityInfo activityInfo) {
            if (activityInfo.metaData == null) {
                return null;
            }
            String string = activityInfo.metaData.getString("android.support.PARENT_ACTIVITY");
            return string == null ? null : string.charAt(0) == '.' ? context.getPackageName() + string : string;
        }

        public boolean m878a(Activity activity, Intent intent) {
            String action = activity.getIntent().getAction();
            return (action == null || action.equals("android.intent.action.MAIN")) ? false : true;
        }

        public void m879b(Activity activity, Intent intent) {
            intent.addFlags(67108864);
            activity.startActivity(intent);
            activity.finish();
        }
    }

    /* renamed from: android.support.v4.b.ad.c */
    static class C0239c extends C0238b {
        C0239c() {
        }

        public Intent m880a(Activity activity) {
            Intent a = ae.m891a(activity);
            return a == null ? m883b(activity) : a;
        }

        public String m881a(Context context, ActivityInfo activityInfo) {
            String a = ae.m892a(activityInfo);
            return a == null ? super.m877a(context, activityInfo) : a;
        }

        public boolean m882a(Activity activity, Intent intent) {
            return ae.m893a(activity, intent);
        }

        Intent m883b(Activity activity) {
            return super.m876a(activity);
        }

        public void m884b(Activity activity, Intent intent) {
            ae.m894b(activity, intent);
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f524a = new C0239c();
        } else {
            f524a = new C0238b();
        }
    }

    public static Intent m885a(Activity activity) {
        return f524a.m872a(activity);
    }

    public static Intent m886a(Context context, ComponentName componentName) {
        String b = ad.m889b(context, componentName);
        if (b == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), b);
        return ad.m889b(context, componentName2) == null ? C0314f.m1188a(componentName2) : new Intent().setComponent(componentName2);
    }

    public static boolean m887a(Activity activity, Intent intent) {
        return f524a.m874a(activity, intent);
    }

    public static String m888b(Activity activity) {
        try {
            return ad.m889b((Context) activity, activity.getComponentName());
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String m889b(Context context, ComponentName componentName) {
        return f524a.m873a(context, context.getPackageManager().getActivityInfo(componentName, 128));
    }

    public static void m890b(Activity activity, Intent intent) {
        f524a.m875b(activity, intent);
    }
}
