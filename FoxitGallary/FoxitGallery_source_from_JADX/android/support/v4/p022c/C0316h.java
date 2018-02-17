package android.support.v4.p022c;

import android.support.v4.p030j.C0382c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.c.h */
public class C0316h<D> {
    int f671a;
    C0235b<D> f672b;
    C0234a<D> f673c;
    boolean f674d;
    boolean f675e;
    boolean f676f;
    boolean f677g;
    boolean f678h;

    /* renamed from: android.support.v4.c.h.a */
    public interface C0234a<D> {
    }

    /* renamed from: android.support.v4.c.h.b */
    public interface C0235b<D> {
    }

    public String m1190a(D d) {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0382c.m1432a(d, stringBuilder);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final void m1191a() {
        this.f674d = true;
        this.f676f = false;
        this.f675e = false;
        m1196b();
    }

    public void m1192a(int i, C0235b<D> c0235b) {
        if (this.f672b != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f672b = c0235b;
        this.f671a = i;
    }

    public void m1193a(C0234a<D> c0234a) {
        if (this.f673c != null) {
            throw new IllegalStateException("There is already a listener registered");
        }
        this.f673c = c0234a;
    }

    public void m1194a(C0235b<D> c0235b) {
        if (this.f672b == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f672b != c0235b) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f672b = null;
        }
    }

    public void m1195a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mId=");
        printWriter.print(this.f671a);
        printWriter.print(" mListener=");
        printWriter.println(this.f672b);
        if (this.f674d || this.f677g || this.f678h) {
            printWriter.print(str);
            printWriter.print("mStarted=");
            printWriter.print(this.f674d);
            printWriter.print(" mContentChanged=");
            printWriter.print(this.f677g);
            printWriter.print(" mProcessingChange=");
            printWriter.println(this.f678h);
        }
        if (this.f675e || this.f676f) {
            printWriter.print(str);
            printWriter.print("mAbandoned=");
            printWriter.print(this.f675e);
            printWriter.print(" mReset=");
            printWriter.println(this.f676f);
        }
    }

    protected void m1196b() {
    }

    public void m1197b(C0234a<D> c0234a) {
        if (this.f673c == null) {
            throw new IllegalStateException("No listener register");
        } else if (this.f673c != c0234a) {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else {
            this.f673c = null;
        }
    }

    public void m1198c() {
        this.f674d = false;
        m1199d();
    }

    protected void m1199d() {
    }

    public void m1200e() {
        m1201f();
        this.f676f = true;
        this.f674d = false;
        this.f675e = false;
        this.f677g = false;
        this.f678h = false;
    }

    protected void m1201f() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(64);
        C0382c.m1432a(this, stringBuilder);
        stringBuilder.append(" id=");
        stringBuilder.append(this.f671a);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
