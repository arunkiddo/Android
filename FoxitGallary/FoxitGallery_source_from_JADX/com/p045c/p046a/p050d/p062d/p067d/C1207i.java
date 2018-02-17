package com.p045c.p046a.p050d.p062d.p067d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.p045c.p046a.p048b.C0991a;
import com.p045c.p046a.p048b.C0991a.C0990a;
import com.p045c.p046a.p048b.C0993c;
import com.p045c.p046a.p048b.C0994d;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p062d.C1210d;
import com.p045c.p046a.p055j.C1296h;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Queue;

/* renamed from: com.c.a.d.d.d.i */
public class C1207i implements C1155e<InputStream, C1189b> {
    private static final C1206b f3057a;
    private static final C1205a f3058b;
    private final Context f3059c;
    private final C1206b f3060d;
    private final C1023c f3061e;
    private final C1205a f3062f;
    private final C1186a f3063g;

    /* renamed from: com.c.a.d.d.d.i.a */
    static class C1205a {
        private final Queue<C0991a> f3055a;

        C1205a() {
            this.f3055a = C1296h.m6112a(0);
        }

        public synchronized C0991a m5790a(C0990a c0990a) {
            C0991a c0991a;
            c0991a = (C0991a) this.f3055a.poll();
            if (c0991a == null) {
                c0991a = new C0991a(c0990a);
            }
            return c0991a;
        }

        public synchronized void m5791a(C0991a c0991a) {
            c0991a.m5180g();
            this.f3055a.offer(c0991a);
        }
    }

    /* renamed from: com.c.a.d.d.d.i.b */
    static class C1206b {
        private final Queue<C0994d> f3056a;

        C1206b() {
            this.f3056a = C1296h.m6112a(0);
        }

        public synchronized C0994d m5792a(byte[] bArr) {
            C0994d c0994d;
            c0994d = (C0994d) this.f3056a.poll();
            if (c0994d == null) {
                c0994d = new C0994d();
            }
            return c0994d.m5197a(bArr);
        }

        public synchronized void m5793a(C0994d c0994d) {
            c0994d.m5198a();
            this.f3056a.offer(c0994d);
        }
    }

    static {
        f3057a = new C1206b();
        f3058b = new C1205a();
    }

    public C1207i(Context context, C1023c c1023c) {
        this(context, c1023c, f3057a, f3058b);
    }

    C1207i(Context context, C1023c c1023c, C1206b c1206b, C1205a c1205a) {
        this.f3059c = context;
        this.f3061e = c1023c;
        this.f3062f = c1205a;
        this.f3063g = new C1186a(c1023c);
        this.f3060d = c1206b;
    }

    private Bitmap m5794a(C0991a c0991a, C0993c c0993c, byte[] bArr) {
        c0991a.m5174a(c0993c, bArr);
        c0991a.m5173a();
        return c0991a.m5179f();
    }

    private C1191d m5795a(byte[] bArr, int i, int i2, C0994d c0994d, C0991a c0991a) {
        C0993c b = c0994d.m5199b();
        if (b.m5181a() <= 0 || b.m5182b() != 0) {
            return null;
        }
        Bitmap a = m5794a(c0991a, b, bArr);
        if (a == null) {
            return null;
        }
        return new C1191d(new C1189b(this.f3059c, this.f3063g, this.f3061e, C1210d.m5810b(), i, i2, b, bArr, a));
    }

    private static byte[] m5796a(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.flush();
        } catch (Throwable e) {
            Log.w("GifResourceDecoder", "Error reading data from stream", e);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public C1191d m5798a(InputStream inputStream, int i, int i2) {
        byte[] a = C1207i.m5796a(inputStream);
        C0994d a2 = this.f3060d.m5792a(a);
        C0991a a3 = this.f3062f.m5790a(this.f3063g);
        try {
            C1191d a4 = m5795a(a, i, i2, a2, a3);
            return a4;
        } finally {
            this.f3060d.m5793a(a2);
            this.f3062f.m5791a(a3);
        }
    }

    public String m5799a() {
        return BuildConfig.FLAVOR;
    }
}
