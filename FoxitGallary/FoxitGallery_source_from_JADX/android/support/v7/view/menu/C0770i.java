package android.support.v7.view.menu;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.os.IBinder;
import android.support.v7.p033a.C0665d;
import android.support.v7.p033a.C0665d.C0662a;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.view.menu.C0755o.C0691a;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

/* renamed from: android.support.v7.view.menu.i */
class C0770i implements OnClickListener, OnDismissListener, OnKeyListener, C0691a {
    C0767f f1572a;
    private C0769h f1573b;
    private C0665d f1574c;
    private C0691a f1575d;

    public C0770i(C0769h c0769h) {
        this.f1573b = c0769h;
    }

    public void m3473a() {
        if (this.f1574c != null) {
            this.f1574c.dismiss();
        }
    }

    public void m3474a(IBinder iBinder) {
        C0769h c0769h = this.f1573b;
        C0662a c0662a = new C0662a(c0769h.m3458e());
        this.f1572a = new C0767f(c0662a.m2882a(), C0726g.abc_list_menu_item_layout);
        this.f1572a.m3408a((C0691a) this);
        this.f1573b.m3437a(this.f1572a);
        c0662a.m2886a(this.f1572a.m3405a(), this);
        View o = c0769h.m3469o();
        if (o != null) {
            c0662a.m2885a(o);
        } else {
            c0662a.m2884a(c0769h.m3468n()).m2887a(c0769h.m3467m());
        }
        c0662a.m2883a((OnKeyListener) this);
        this.f1574c = c0662a.m2888b();
        this.f1574c.setOnDismissListener(this);
        LayoutParams attributes = this.f1574c.getWindow().getAttributes();
        attributes.type = 1003;
        if (iBinder != null) {
            attributes.token = iBinder;
        }
        attributes.flags |= 131072;
        this.f1574c.show();
    }

    public void m3475a(C0769h c0769h, boolean z) {
        if (z || c0769h == this.f1573b) {
            m3473a();
        }
        if (this.f1575d != null) {
            this.f1575d.m3040a(c0769h, z);
        }
    }

    public boolean m3476a(C0769h c0769h) {
        return this.f1575d != null ? this.f1575d.m3041a(c0769h) : false;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f1573b.m3443a((C0772j) this.f1572a.m3405a().getItem(i), 0);
    }

    public void onDismiss(DialogInterface dialogInterface) {
        this.f1572a.m3407a(this.f1573b, true);
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        if (i == 82 || i == 4) {
            Window window;
            View decorView;
            DispatcherState keyDispatcherState;
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                window = this.f1574c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null) {
                            keyDispatcherState.startTracking(keyEvent, this);
                            return true;
                        }
                    }
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled()) {
                window = this.f1574c.getWindow();
                if (window != null) {
                    decorView = window.getDecorView();
                    if (decorView != null) {
                        keyDispatcherState = decorView.getKeyDispatcherState();
                        if (keyDispatcherState != null && keyDispatcherState.isTracking(keyEvent)) {
                            this.f1573b.m3441a(true);
                            dialogInterface.dismiss();
                            return true;
                        }
                    }
                }
            }
        }
        return this.f1573b.performShortcut(i, keyEvent, 0);
    }
}
