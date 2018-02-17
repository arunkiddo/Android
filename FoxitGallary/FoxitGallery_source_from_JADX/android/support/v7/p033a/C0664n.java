package android.support.v7.p033a;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.view.C0716b;
import android.support.v7.view.C0716b.C0694a;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

/* renamed from: android.support.v7.a.n */
public class C0664n extends Dialog implements C0663f {
    private C0667g f1179a;

    public C0664n(Context context, int i) {
        super(context, C0664n.m2889a(context, i));
        m2890a().m2904a(null);
        m2890a().m2921i();
    }

    private static int m2889a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0720a.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public C0667g m2890a() {
        if (this.f1179a == null) {
            this.f1179a = C0667g.m2896a((Dialog) this, (C0663f) this);
        }
        return this.f1179a;
    }

    public boolean m2891a(int i) {
        return m2890a().m2915c(i);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m2890a().m2912b(view, layoutParams);
    }

    public View findViewById(int i) {
        return m2890a().m2902a(i);
    }

    public void invalidateOptionsMenu() {
        m2890a().m2917e();
    }

    protected void onCreate(Bundle bundle) {
        m2890a().m2920h();
        super.onCreate(bundle);
        m2890a().m2904a(bundle);
    }

    protected void onStop() {
        super.onStop();
        m2890a().m2913c();
    }

    public void onSupportActionModeFinished(C0716b c0716b) {
    }

    public void onSupportActionModeStarted(C0716b c0716b) {
    }

    public C0716b onWindowStartingSupportActionMode(C0694a c0694a) {
        return null;
    }

    public void setContentView(int i) {
        m2890a().m2910b(i);
    }

    public void setContentView(View view) {
        m2890a().m2906a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m2890a().m2907a(view, layoutParams);
    }

    public void setTitle(int i) {
        super.setTitle(i);
        m2890a().m2908a(getContext().getString(i));
    }

    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        m2890a().m2908a(charSequence);
    }
}
