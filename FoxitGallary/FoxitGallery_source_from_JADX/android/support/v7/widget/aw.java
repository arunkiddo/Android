package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0812h;
import android.support.v7.widget.RecyclerView.C0850s;
import android.view.View;

class aw {
    static int m4725a(C0850s c0850s, ar arVar, View view, View view2, C0812h c0812h, boolean z) {
        if (c0812h.m3875u() == 0 || c0850s.m4222e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(c0812h.m3836d(view) - c0812h.m3836d(view2)) + 1;
        }
        return Math.min(arVar.m4677f(), arVar.m4670b(view2) - arVar.m4666a(view));
    }

    static int m4726a(C0850s c0850s, ar arVar, View view, View view2, C0812h c0812h, boolean z, boolean z2) {
        if (c0812h.m3875u() == 0 || c0850s.m4222e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int max = z2 ? Math.max(0, (c0850s.m4222e() - Math.max(c0812h.m3836d(view), c0812h.m3836d(view2))) - 1) : Math.max(0, Math.min(c0812h.m3836d(view), c0812h.m3836d(view2)));
        if (!z) {
            return max;
        }
        return Math.round((((float) max) * (((float) Math.abs(arVar.m4670b(view2) - arVar.m4666a(view))) / ((float) (Math.abs(c0812h.m3836d(view) - c0812h.m3836d(view2)) + 1)))) + ((float) (arVar.m4671c() - arVar.m4666a(view))));
    }

    static int m4727b(C0850s c0850s, ar arVar, View view, View view2, C0812h c0812h, boolean z) {
        if (c0812h.m3875u() == 0 || c0850s.m4222e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0850s.m4222e();
        }
        return (int) ((((float) (arVar.m4670b(view2) - arVar.m4666a(view))) / ((float) (Math.abs(c0812h.m3836d(view) - c0812h.m3836d(view2)) + 1))) * ((float) c0850s.m4222e()));
    }
}
