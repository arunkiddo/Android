package android.support.v4.p030j;

import android.util.Log;
import java.io.Writer;

/* renamed from: android.support.v4.j.d */
public class C0383d extends Writer {
    private final String f725a;
    private StringBuilder f726b;

    public C0383d(String str) {
        this.f726b = new StringBuilder(128);
        this.f725a = str;
    }

    private void m1433a() {
        if (this.f726b.length() > 0) {
            Log.d(this.f725a, this.f726b.toString());
            this.f726b.delete(0, this.f726b.length());
        }
    }

    public void close() {
        m1433a();
    }

    public void flush() {
        m1433a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m1433a();
            } else {
                this.f726b.append(c);
            }
        }
    }
}
