package android.support.v4.p021b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.p021b.C0245b.C0223a;
import android.support.v4.p022c.C0225a;
import android.view.View;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.b.a */
public class C0226a extends C0225a {

    /* renamed from: android.support.v4.b.a.1 */
    static class C02211 implements Runnable {
        final /* synthetic */ String[] f473a;
        final /* synthetic */ Activity f474b;
        final /* synthetic */ int f475c;

        C02211(String[] strArr, Activity activity, int i) {
            this.f473a = strArr;
            this.f474b = activity;
            this.f475c = i;
        }

        public void run() {
            int[] iArr = new int[this.f473a.length];
            PackageManager packageManager = this.f474b.getPackageManager();
            String packageName = this.f474b.getPackageName();
            int length = this.f473a.length;
            for (int i = 0; i < length; i++) {
                iArr[i] = packageManager.checkPermission(this.f473a[i], packageName);
            }
            ((C0222a) this.f474b).onRequestPermissionsResult(this.f475c, this.f473a, iArr);
        }
    }

    /* renamed from: android.support.v4.b.a.a */
    public interface C0222a {
        void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);
    }

    /* renamed from: android.support.v4.b.a.b */
    private static class C0224b extends C0223a {
        private ag f476a;

        public C0224b(ag agVar) {
            this.f476a = agVar;
        }

        public Parcelable m801a(View view, Matrix matrix, RectF rectF) {
            return this.f476a.m897a(view, matrix, rectF);
        }

        public View m802a(Context context, Parcelable parcelable) {
            return this.f476a.m898a(context, parcelable);
        }

        public void m803a(List<View> list) {
            this.f476a.m899a((List) list);
        }

        public void m804a(List<String> list, List<View> list2, List<View> list3) {
            this.f476a.m900a((List) list, (List) list2, (List) list3);
        }

        public void m805a(List<String> list, Map<String, View> map) {
            this.f476a.m901a((List) list, (Map) map);
        }

        public void m806b(List<String> list, List<View> list2, List<View> list3) {
            this.f476a.m902b(list, list2, list3);
        }
    }

    private static C0223a m811a(ag agVar) {
        return agVar != null ? new C0224b(agVar) : null;
    }

    public static void m812a(Activity activity) {
        if (VERSION.SDK_INT >= 16) {
            C0250f.m921a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m813a(Activity activity, Intent intent, int i, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0250f.m922a(activity, intent, i, bundle);
        } else {
            activity.startActivityForResult(intent, i);
        }
    }

    public static void m814a(Activity activity, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (VERSION.SDK_INT >= 16) {
            C0250f.m923a(activity, intentSender, i, intent, i2, i3, i4, bundle);
        } else if (VERSION.SDK_INT >= 5) {
            C0248d.m919a(activity, intentSender, i, intent, i2, i3, i4);
        }
    }

    public static void m815a(Activity activity, ag agVar) {
        if (VERSION.SDK_INT >= 21) {
            C0245b.m912a(activity, C0226a.m811a(agVar));
        }
    }

    public static void m816a(Activity activity, String[] strArr, int i) {
        if (VERSION.SDK_INT >= 23) {
            C0247c.m917a(activity, strArr, i);
        } else if (activity instanceof C0222a) {
            new Handler(Looper.getMainLooper()).post(new C02211(strArr, activity, i));
        }
    }

    public static boolean m817a(Activity activity, String str) {
        return VERSION.SDK_INT >= 23 ? C0247c.m918a(activity, str) : false;
    }

    public static void m818b(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0245b.m911a(activity);
        } else {
            activity.finish();
        }
    }

    public static void m819b(Activity activity, ag agVar) {
        if (VERSION.SDK_INT >= 21) {
            C0245b.m915b(activity, C0226a.m811a(agVar));
        }
    }

    public static void m820c(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0245b.m914b(activity);
        }
    }

    public static void m821d(Activity activity) {
        if (VERSION.SDK_INT >= 21) {
            C0245b.m916c(activity);
        }
    }
}
