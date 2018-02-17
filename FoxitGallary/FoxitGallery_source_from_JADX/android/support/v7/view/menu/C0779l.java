package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p016k.C0518e.C0517b;
import android.support.v4.p024e.p025a.C0348b;
import android.support.v7.view.menu.C0777k.C0773a;
import android.view.ActionProvider;
import android.view.ActionProvider.VisibilityListener;
import android.view.MenuItem;
import android.view.View;

@TargetApi(16)
/* renamed from: android.support.v7.view.menu.l */
class C0779l extends C0777k {

    /* renamed from: android.support.v7.view.menu.l.a */
    class C0778a extends C0773a implements VisibilityListener {
        C0517b f1609c;
        final /* synthetic */ C0779l f1610d;

        public C0778a(C0779l c0779l, Context context, ActionProvider actionProvider) {
            this.f1610d = c0779l;
            super(c0779l, context, actionProvider);
        }

        public View m3517a(MenuItem menuItem) {
            return this.a.onCreateActionView(menuItem);
        }

        public void m3518a(C0517b c0517b) {
            VisibilityListener visibilityListener;
            this.f1609c = c0517b;
            ActionProvider actionProvider = this.a;
            if (c0517b == null) {
                visibilityListener = null;
            }
            actionProvider.setVisibilityListener(visibilityListener);
        }

        public boolean m3519b() {
            return this.a.overridesItemVisibility();
        }

        public boolean m3520c() {
            return this.a.isVisible();
        }

        public void onActionProviderVisibilityChanged(boolean z) {
            if (this.f1609c != null) {
                this.f1609c.m2272a(z);
            }
        }
    }

    C0779l(Context context, C0348b c0348b) {
        super(context, c0348b);
    }

    C0773a m3521a(ActionProvider actionProvider) {
        return new C0778a(this, this.a, actionProvider);
    }
}
