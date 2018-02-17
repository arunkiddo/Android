package android.support.v4.p021b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.p030j.C0379j;
import android.view.LayoutInflater;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.b.s */
public abstract class C0276s<E> extends C0269q {
    private final Activity f599a;
    final Context f600b;
    final int f601c;
    final C0289u f602d;
    private final Handler f603e;
    private C0379j<String, ab> f604f;
    private boolean f605g;
    private ac f606h;
    private boolean f607i;
    private boolean f608j;

    C0276s(Activity activity, Context context, Handler handler, int i) {
        this.f602d = new C0289u();
        this.f599a = activity;
        this.f600b = context;
        this.f603e = handler;
        this.f601c = i;
    }

    C0276s(C0279p c0279p) {
        this(c0279p, c0279p, c0279p.mHandler, 0);
    }

    ac m993a(String str, boolean z, boolean z2) {
        if (this.f604f == null) {
            this.f604f = new C0379j();
        }
        ac acVar = (ac) this.f604f.get(str);
        if (acVar != null) {
            acVar.m862a(this);
            return acVar;
        } else if (!z2) {
            return acVar;
        } else {
            acVar = new ac(str, this, z);
            this.f604f.put(str, acVar);
            return acVar;
        }
    }

    public View m994a(int i) {
        return null;
    }

    public void m995a(C0274o c0274o, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        this.f600b.startActivity(intent);
    }

    public void m996a(C0274o c0274o, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        C0226a.m814a(this.f599a, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void m997a(C0274o c0274o, String[] strArr, int i) {
    }

    void m998a(C0379j<String, ab> c0379j) {
        this.f604f = c0379j;
    }

    public void m999a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    void m1000a(boolean z) {
        this.f605g = z;
        if (this.f606h != null && this.f608j) {
            this.f608j = false;
            if (z) {
                this.f606h.m867d();
            } else {
                this.f606h.m866c();
            }
        }
    }

    public boolean m1001a() {
        return true;
    }

    public boolean m1002a(C0274o c0274o) {
        return true;
    }

    public boolean m1003a(String str) {
        return false;
    }

    public LayoutInflater m1004b() {
        return (LayoutInflater) this.f600b.getSystemService("layout_inflater");
    }

    void m1005b(C0274o c0274o) {
    }

    void m1006b(String str) {
        if (this.f604f != null) {
            ac acVar = (ac) this.f604f.get(str);
            if (acVar != null && !acVar.f522f) {
                acVar.m871h();
                this.f604f.remove(str);
            }
        }
    }

    void m1007b(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mLoadersStarted=");
        printWriter.println(this.f608j);
        if (this.f606h != null) {
            printWriter.print(str);
            printWriter.print("Loader Manager ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this.f606h)));
            printWriter.println(":");
            this.f606h.m863a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public void m1008d() {
    }

    public boolean m1009e() {
        return true;
    }

    public int m1010f() {
        return this.f601c;
    }

    public abstract E m1011g();

    Activity m1012h() {
        return this.f599a;
    }

    Context m1013i() {
        return this.f600b;
    }

    Handler m1014j() {
        return this.f603e;
    }

    C0289u m1015k() {
        return this.f602d;
    }

    ac m1016l() {
        if (this.f606h != null) {
            return this.f606h;
        }
        this.f607i = true;
        this.f606h = m993a("(root)", this.f608j, true);
        return this.f606h;
    }

    boolean m1017m() {
        return this.f605g;
    }

    void m1018n() {
        if (!this.f608j) {
            this.f608j = true;
            if (this.f606h != null) {
                this.f606h.m865b();
            } else if (!this.f607i) {
                this.f606h = m993a("(root)", this.f608j, false);
                if (!(this.f606h == null || this.f606h.f521e)) {
                    this.f606h.m865b();
                }
            }
            this.f607i = true;
        }
    }

    void m1019o() {
        if (this.f606h != null) {
            this.f606h.m871h();
        }
    }

    void m1020p() {
        if (this.f604f != null) {
            int size = this.f604f.size();
            ac[] acVarArr = new ac[size];
            for (int i = size - 1; i >= 0; i--) {
                acVarArr[i] = (ac) this.f604f.m1422c(i);
            }
            for (int i2 = 0; i2 < size; i2++) {
                ac acVar = acVarArr[i2];
                acVar.m868e();
                acVar.m870g();
            }
        }
    }

    C0379j<String, ab> m1021q() {
        int i;
        int i2 = 0;
        if (this.f604f != null) {
            int size = this.f604f.size();
            ac[] acVarArr = new ac[size];
            for (int i3 = size - 1; i3 >= 0; i3--) {
                acVarArr[i3] = (ac) this.f604f.m1422c(i3);
            }
            boolean m = m1017m();
            i = 0;
            while (i2 < size) {
                ac acVar = acVarArr[i2];
                if (!acVar.f522f && m) {
                    if (!acVar.f521e) {
                        acVar.m865b();
                    }
                    acVar.m867d();
                }
                if (acVar.f522f) {
                    i = 1;
                } else {
                    acVar.m871h();
                    this.f604f.remove(acVar.f520d);
                }
                i2++;
            }
        } else {
            i = 0;
        }
        return i != 0 ? this.f604f : null;
    }
}
