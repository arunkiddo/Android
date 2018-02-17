package android.support.v7.p033a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.p033a.C0661c.C0658a;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListAdapter;

/* renamed from: android.support.v7.a.d */
public class C0665d extends C0664n implements DialogInterface {
    private final C0661c f1180a;

    /* renamed from: android.support.v7.a.d.a */
    public static class C0662a {
        private final C0658a f1177a;
        private final int f1178b;

        public C0662a(Context context) {
            this(context, C0665d.m2894b(context, 0));
        }

        public C0662a(Context context, int i) {
            this.f1177a = new C0658a(new ContextThemeWrapper(context, C0665d.m2894b(context, i)));
            this.f1178b = i;
        }

        public Context m2882a() {
            return this.f1177a.f1110a;
        }

        public C0662a m2883a(OnKeyListener onKeyListener) {
            this.f1177a.f1127r = onKeyListener;
            return this;
        }

        public C0662a m2884a(Drawable drawable) {
            this.f1177a.f1113d = drawable;
            return this;
        }

        public C0662a m2885a(View view) {
            this.f1177a.f1116g = view;
            return this;
        }

        public C0662a m2886a(ListAdapter listAdapter, OnClickListener onClickListener) {
            this.f1177a.f1129t = listAdapter;
            this.f1177a.f1130u = onClickListener;
            return this;
        }

        public C0662a m2887a(CharSequence charSequence) {
            this.f1177a.f1115f = charSequence;
            return this;
        }

        public C0665d m2888b() {
            C0665d c0665d = new C0665d(this.f1177a.f1110a, this.f1178b);
            this.f1177a.m2840a(c0665d.f1180a);
            c0665d.setCancelable(this.f1177a.f1124o);
            if (this.f1177a.f1124o) {
                c0665d.setCanceledOnTouchOutside(true);
            }
            c0665d.setOnCancelListener(this.f1177a.f1125p);
            c0665d.setOnDismissListener(this.f1177a.f1126q);
            if (this.f1177a.f1127r != null) {
                c0665d.setOnKeyListener(this.f1177a.f1127r);
            }
            return c0665d;
        }
    }

    protected C0665d(Context context, int i) {
        super(context, C0665d.m2894b(context, i));
        this.f1180a = new C0661c(getContext(), this, getWindow());
    }

    private static int m2894b(Context context, int i) {
        if (i >= 16777216) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0720a.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f1180a.m2869a();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.f1180a.m2875a(i, keyEvent) ? true : super.onKeyDown(i, keyEvent);
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return this.f1180a.m2879b(i, keyEvent) ? true : super.onKeyUp(i, keyEvent);
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f1180a.m2874a(charSequence);
    }
}
