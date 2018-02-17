package android.support.v4.p021b;

import android.os.Bundle;
import android.support.v4.p021b.ab.C0233a;
import android.support.v4.p022c.C0316h;
import android.support.v4.p022c.C0316h.C0234a;
import android.support.v4.p022c.C0316h.C0235b;
import android.support.v4.p030j.C0382c;
import android.support.v4.p030j.C0395k;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

/* renamed from: android.support.v4.b.ac */
class ac extends ab {
    static boolean f517a;
    final C0395k<C0236a> f518b;
    final C0395k<C0236a> f519c;
    final String f520d;
    boolean f521e;
    boolean f522f;
    private C0276s f523g;

    /* renamed from: android.support.v4.b.ac.a */
    final class C0236a implements C0234a<Object>, C0235b<Object> {
        final int f502a;
        final Bundle f503b;
        C0233a<Object> f504c;
        C0316h<Object> f505d;
        boolean f506e;
        boolean f507f;
        Object f508g;
        boolean f509h;
        boolean f510i;
        boolean f511j;
        boolean f512k;
        boolean f513l;
        boolean f514m;
        C0236a f515n;
        final /* synthetic */ ac f516o;

        void m853a() {
            if (this.f510i && this.f511j) {
                this.f509h = true;
            } else if (!this.f509h) {
                this.f509h = true;
                if (ac.f517a) {
                    Log.v("LoaderManager", "  Starting: " + this);
                }
                if (this.f505d == null && this.f504c != null) {
                    this.f505d = this.f504c.m849a(this.f502a, this.f503b);
                }
                if (this.f505d == null) {
                    return;
                }
                if (!this.f505d.getClass().isMemberClass() || Modifier.isStatic(this.f505d.getClass().getModifiers())) {
                    if (!this.f514m) {
                        this.f505d.m1192a(this.f502a, this);
                        this.f505d.m1193a((C0234a) this);
                        this.f514m = true;
                    }
                    this.f505d.m1191a();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.f505d);
            }
        }

        void m854a(C0316h<Object> c0316h, Object obj) {
            String str;
            if (this.f504c != null) {
                if (this.f516o.f523g != null) {
                    String str2 = this.f516o.f523g.f602d.f647v;
                    this.f516o.f523g.f602d.f647v = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (ac.f517a) {
                        Log.v("LoaderManager", "  onLoadFinished in " + c0316h + ": " + c0316h.m1190a(obj));
                    }
                    this.f504c.m851a((C0316h) c0316h, obj);
                    this.f507f = true;
                } finally {
                    if (this.f516o.f523g != null) {
                        this.f516o.f523g.f602d.f647v = str;
                    }
                }
            }
        }

        public void m855a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f502a);
            printWriter.print(" mArgs=");
            printWriter.println(this.f503b);
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f504c);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f505d);
            if (this.f505d != null) {
                this.f505d.m1195a(str + "  ", fileDescriptor, printWriter, strArr);
            }
            if (this.f506e || this.f507f) {
                printWriter.print(str);
                printWriter.print("mHaveData=");
                printWriter.print(this.f506e);
                printWriter.print("  mDeliveredData=");
                printWriter.println(this.f507f);
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(this.f508g);
            }
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f509h);
            printWriter.print(" mReportNextStart=");
            printWriter.print(this.f512k);
            printWriter.print(" mDestroyed=");
            printWriter.println(this.f513l);
            printWriter.print(str);
            printWriter.print("mRetaining=");
            printWriter.print(this.f510i);
            printWriter.print(" mRetainingStarted=");
            printWriter.print(this.f511j);
            printWriter.print(" mListenerRegistered=");
            printWriter.println(this.f514m);
            if (this.f515n != null) {
                printWriter.print(str);
                printWriter.println("Pending Loader ");
                printWriter.print(this.f515n);
                printWriter.println(":");
                this.f515n.m855a(str + "  ", fileDescriptor, printWriter, strArr);
            }
        }

        void m856b() {
            if (ac.f517a) {
                Log.v("LoaderManager", "  Retaining: " + this);
            }
            this.f510i = true;
            this.f511j = this.f509h;
            this.f509h = false;
            this.f504c = null;
        }

        void m857c() {
            if (this.f510i) {
                if (ac.f517a) {
                    Log.v("LoaderManager", "  Finished Retaining: " + this);
                }
                this.f510i = false;
                if (!(this.f509h == this.f511j || this.f509h)) {
                    m859e();
                }
            }
            if (this.f509h && this.f506e && !this.f512k) {
                m854a(this.f505d, this.f508g);
            }
        }

        void m858d() {
            if (this.f509h && this.f512k) {
                this.f512k = false;
                if (this.f506e && !this.f510i) {
                    m854a(this.f505d, this.f508g);
                }
            }
        }

        void m859e() {
            if (ac.f517a) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f509h = false;
            if (!this.f510i && this.f505d != null && this.f514m) {
                this.f514m = false;
                this.f505d.m1194a((C0235b) this);
                this.f505d.m1197b(this);
                this.f505d.m1198c();
            }
        }

        void m860f() {
            String str;
            C0233a c0233a = null;
            if (ac.f517a) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f513l = true;
            boolean z = this.f507f;
            this.f507f = false;
            if (this.f504c != null && this.f505d != null && this.f506e && z) {
                if (ac.f517a) {
                    Log.v("LoaderManager", "  Reseting: " + this);
                }
                if (this.f516o.f523g != null) {
                    String str2 = this.f516o.f523g.f602d.f647v;
                    this.f516o.f523g.f602d.f647v = "onLoaderReset";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    this.f504c.m850a(this.f505d);
                } finally {
                    c0233a = this.f516o.f523g;
                    if (c0233a != null) {
                        c0233a = this.f516o.f523g.f602d;
                        c0233a.f647v = str;
                    }
                }
            }
            this.f504c = c0233a;
            this.f508g = c0233a;
            this.f506e = false;
            if (this.f505d != null) {
                if (this.f514m) {
                    this.f514m = false;
                    this.f505d.m1194a((C0235b) this);
                    this.f505d.m1197b(this);
                }
                this.f505d.m1200e();
            }
            if (this.f515n != null) {
                this.f515n.m860f();
            }
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.f502a);
            stringBuilder.append(" : ");
            C0382c.m1432a(this.f505d, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }
    }

    static {
        f517a = false;
    }

    ac(String str, C0276s c0276s, boolean z) {
        this.f518b = new C0395k();
        this.f519c = new C0395k();
        this.f520d = str;
        this.f523g = c0276s;
        this.f521e = z;
    }

    void m862a(C0276s c0276s) {
        this.f523g = c0276s;
    }

    public void m863a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.f518b.m1464b() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.f518b.m1464b(); i2++) {
                C0236a c0236a = (C0236a) this.f518b.m1470e(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f518b.m1469d(i2));
                printWriter.print(": ");
                printWriter.println(c0236a.toString());
                c0236a.m855a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.f519c.m1464b() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.f519c.m1464b()) {
                c0236a = (C0236a) this.f519c.m1470e(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f519c.m1469d(i));
                printWriter.print(": ");
                printWriter.println(c0236a.toString());
                c0236a.m855a(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public boolean m864a() {
        int b = this.f518b.m1464b();
        boolean z = false;
        for (int i = 0; i < b; i++) {
            C0236a c0236a = (C0236a) this.f518b.m1470e(i);
            int i2 = (!c0236a.f509h || c0236a.f507f) ? 0 : 1;
            z |= i2;
        }
        return z;
    }

    void m865b() {
        if (f517a) {
            Log.v("LoaderManager", "Starting in " + this);
        }
        if (this.f521e) {
            Throwable runtimeException = new RuntimeException("here");
            runtimeException.fillInStackTrace();
            Log.w("LoaderManager", "Called doStart when already started: " + this, runtimeException);
            return;
        }
        this.f521e = true;
        for (int b = this.f518b.m1464b() - 1; b >= 0; b--) {
            ((C0236a) this.f518b.m1470e(b)).m853a();
        }
    }

    void m866c() {
        if (f517a) {
            Log.v("LoaderManager", "Stopping in " + this);
        }
        if (this.f521e) {
            for (int b = this.f518b.m1464b() - 1; b >= 0; b--) {
                ((C0236a) this.f518b.m1470e(b)).m859e();
            }
            this.f521e = false;
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doStop when not started: " + this, runtimeException);
    }

    void m867d() {
        if (f517a) {
            Log.v("LoaderManager", "Retaining in " + this);
        }
        if (this.f521e) {
            this.f522f = true;
            this.f521e = false;
            for (int b = this.f518b.m1464b() - 1; b >= 0; b--) {
                ((C0236a) this.f518b.m1470e(b)).m856b();
            }
            return;
        }
        Throwable runtimeException = new RuntimeException("here");
        runtimeException.fillInStackTrace();
        Log.w("LoaderManager", "Called doRetain when not started: " + this, runtimeException);
    }

    void m868e() {
        if (this.f522f) {
            if (f517a) {
                Log.v("LoaderManager", "Finished Retaining in " + this);
            }
            this.f522f = false;
            for (int b = this.f518b.m1464b() - 1; b >= 0; b--) {
                ((C0236a) this.f518b.m1470e(b)).m857c();
            }
        }
    }

    void m869f() {
        for (int b = this.f518b.m1464b() - 1; b >= 0; b--) {
            ((C0236a) this.f518b.m1470e(b)).f512k = true;
        }
    }

    void m870g() {
        for (int b = this.f518b.m1464b() - 1; b >= 0; b--) {
            ((C0236a) this.f518b.m1470e(b)).m858d();
        }
    }

    void m871h() {
        int b;
        if (!this.f522f) {
            if (f517a) {
                Log.v("LoaderManager", "Destroying Active in " + this);
            }
            for (b = this.f518b.m1464b() - 1; b >= 0; b--) {
                ((C0236a) this.f518b.m1470e(b)).m860f();
            }
            this.f518b.m1467c();
        }
        if (f517a) {
            Log.v("LoaderManager", "Destroying Inactive in " + this);
        }
        for (b = this.f519c.m1464b() - 1; b >= 0; b--) {
            ((C0236a) this.f519c.m1470e(b)).m860f();
        }
        this.f519c.m1467c();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        C0382c.m1432a(this.f523g, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }
}
