package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

/* renamed from: android.support.v4.widget.m */
public final class C0608m {
    public static void m2657a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            C0610o.m2659a(listView, i);
        } else {
            C0609n.m2658a(listView, i);
        }
    }
}
