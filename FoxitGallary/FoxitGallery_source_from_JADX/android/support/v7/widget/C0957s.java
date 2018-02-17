package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.widget.C0622q;
import android.support.v7.p034b.C0730a.C0729j;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import android.widget.PopupWindow;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/* renamed from: android.support.v7.widget.s */
class C0957s extends PopupWindow {
    private static final boolean f2498a;
    private boolean f2499b;

    /* renamed from: android.support.v7.widget.s.1 */
    static class C09561 implements OnScrollChangedListener {
        final /* synthetic */ Field f2495a;
        final /* synthetic */ PopupWindow f2496b;
        final /* synthetic */ OnScrollChangedListener f2497c;

        C09561(Field field, PopupWindow popupWindow, OnScrollChangedListener onScrollChangedListener) {
            this.f2495a = field;
            this.f2496b = popupWindow;
            this.f2497c = onScrollChangedListener;
        }

        public void onScrollChanged() {
            try {
                WeakReference weakReference = (WeakReference) this.f2495a.get(this.f2496b);
                if (weakReference != null && weakReference.get() != null) {
                    this.f2497c.onScrollChanged();
                }
            } catch (IllegalAccessException e) {
            }
        }
    }

    static {
        f2498a = VERSION.SDK_INT < 21;
    }

    public C0957s(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5020a(context, attributeSet, i, 0);
    }

    @TargetApi(11)
    public C0957s(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m5020a(context, attributeSet, i, i2);
    }

    private void m5020a(Context context, AttributeSet attributeSet, int i, int i2) {
        bf a = bf.m4774a(context, attributeSet, C0729j.PopupWindow, i, i2);
        if (a.m4791g(C0729j.PopupWindow_overlapAnchor)) {
            m5022a(a.m4779a(C0729j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a.m4777a(C0729j.PopupWindow_android_popupBackground));
        int i3 = VERSION.SDK_INT;
        if (i2 != 0 && i3 < 11 && i3 >= 9 && a.m4791g(C0729j.PopupWindow_android_popupAnimationStyle)) {
            setAnimationStyle(a.m4790g(C0729j.PopupWindow_android_popupAnimationStyle, -1));
        }
        a.m4778a();
        if (VERSION.SDK_INT < 14) {
            C0957s.m5021a((PopupWindow) this);
        }
    }

    private static void m5021a(PopupWindow popupWindow) {
        try {
            Field declaredField = PopupWindow.class.getDeclaredField("mAnchor");
            declaredField.setAccessible(true);
            Field declaredField2 = PopupWindow.class.getDeclaredField("mOnScrollChangedListener");
            declaredField2.setAccessible(true);
            declaredField2.set(popupWindow, new C09561(declaredField, popupWindow, (OnScrollChangedListener) declaredField2.get(popupWindow)));
        } catch (Throwable e) {
            Log.d("AppCompatPopupWindow", "Exception while installing workaround OnScrollChangedListener", e);
        }
    }

    public void m5022a(boolean z) {
        if (f2498a) {
            this.f2499b = z;
        } else {
            C0622q.m2725a((PopupWindow) this, z);
        }
    }

    public void showAsDropDown(View view, int i, int i2) {
        if (f2498a && this.f2499b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @TargetApi(19)
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2498a && this.f2499b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    public void update(View view, int i, int i2, int i3, int i4) {
        int height = (f2498a && this.f2499b) ? i2 - view.getHeight() : i2;
        super.update(view, i, height, i3, i4);
    }
}
