package com.p045c.p046a.p055j;

import android.util.Log;
import java.util.Queue;

/* renamed from: com.c.a.j.a */
public final class C1289a {
    private static final C1289a f3238b;
    private final Queue<byte[]> f3239a;

    static {
        f3238b = new C1289a();
    }

    private C1289a() {
        this.f3239a = C1296h.m6112a(0);
    }

    public static C1289a m6092a() {
        return f3238b;
    }

    public boolean m6093a(byte[] bArr) {
        boolean z = false;
        if (bArr.length == 65536) {
            synchronized (this.f3239a) {
                if (this.f3239a.size() < 32) {
                    z = true;
                    this.f3239a.offer(bArr);
                }
            }
        }
        return z;
    }

    public byte[] m6094b() {
        byte[] bArr;
        synchronized (this.f3239a) {
            bArr = (byte[]) this.f3239a.poll();
        }
        if (bArr == null) {
            bArr = new byte[65536];
            if (Log.isLoggable("ByteArrayPool", 3)) {
                Log.d("ByteArrayPool", "Created temp bytes");
            }
        }
        return bArr;
    }
}
