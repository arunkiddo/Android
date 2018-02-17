package com.p045c.p046a.p048b;

import android.util.Log;
import com.simplemobiletools.gallery.BuildConfig;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.c.a.b.d */
public class C0994d {
    private final byte[] f2649a;
    private ByteBuffer f2650b;
    private C0993c f2651c;
    private int f2652d;

    public C0994d() {
        this.f2649a = new byte[256];
        this.f2652d = 0;
    }

    private int[] m5183a(int i) {
        int[] iArr;
        Throwable e;
        int i2 = 0;
        byte[] bArr = new byte[(i * 3)];
        try {
            this.f2650b.get(bArr);
            iArr = new int[256];
            int i3 = 0;
            while (i2 < i) {
                int i4 = i3 + 1;
                try {
                    int i5 = bArr[i3] & 255;
                    int i6 = i4 + 1;
                    int i7 = bArr[i4] & 255;
                    i3 = i6 + 1;
                    i4 = i2 + 1;
                    iArr[i2] = (((i5 << 16) | -16777216) | (i7 << 8)) | (bArr[i6] & 255);
                    i2 = i4;
                } catch (BufferUnderflowException e2) {
                    e = e2;
                }
            }
        } catch (Throwable e3) {
            Throwable th = e3;
            iArr = null;
            e = th;
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e);
            }
            this.f2651c.f2637b = 1;
            return iArr;
        }
        return iArr;
    }

    private void m5184c() {
        this.f2650b = null;
        Arrays.fill(this.f2649a, (byte) 0);
        this.f2651c = new C0993c();
        this.f2652d = 0;
    }

    private void m5185d() {
        int i = 0;
        while (i == 0 && !m5196o()) {
            switch (m5194m()) {
                case C1373c.AppCompatTheme_actionModeCopyDrawable /*33*/:
                    switch (m5194m()) {
                        case C1373c.View_android_focusable /*1*/:
                            m5192k();
                            break;
                        case 249:
                            this.f2651c.f2639d = new C0992b();
                            m5186e();
                            break;
                        case 254:
                            m5192k();
                            break;
                        case 255:
                            m5193l();
                            String str = BuildConfig.FLAVOR;
                            for (int i2 = 0; i2 < 11; i2++) {
                                str = str + ((char) this.f2649a[i2]);
                            }
                            if (!str.equals("NETSCAPE2.0")) {
                                m5192k();
                                break;
                            } else {
                                m5188g();
                                break;
                            }
                        default:
                            m5192k();
                            break;
                    }
                case C1373c.AppCompatTheme_dialogPreferredPadding /*44*/:
                    if (this.f2651c.f2639d == null) {
                        this.f2651c.f2639d = new C0992b();
                    }
                    m5187f();
                    break;
                case C1373c.AppCompatTheme_toolbarStyle /*59*/:
                    i = 1;
                    break;
                default:
                    this.f2651c.f2637b = 1;
                    break;
            }
        }
    }

    private void m5186e() {
        boolean z = true;
        m5194m();
        int m = m5194m();
        this.f2651c.f2639d.f2631g = (m & 28) >> 2;
        if (this.f2651c.f2639d.f2631g == 0) {
            this.f2651c.f2639d.f2631g = 1;
        }
        C0992b c0992b = this.f2651c.f2639d;
        if ((m & 1) == 0) {
            z = false;
        }
        c0992b.f2630f = z;
        int n = m5195n();
        if (n < 3) {
            n = 10;
        }
        this.f2651c.f2639d.f2633i = n * 10;
        this.f2651c.f2639d.f2632h = m5194m();
        m5194m();
    }

    private void m5187f() {
        boolean z = true;
        this.f2651c.f2639d.f2625a = m5195n();
        this.f2651c.f2639d.f2626b = m5195n();
        this.f2651c.f2639d.f2627c = m5195n();
        this.f2651c.f2639d.f2628d = m5195n();
        int m = m5194m();
        boolean z2 = (m & 128) != 0;
        int pow = (int) Math.pow(2.0d, (double) ((m & 7) + 1));
        C0992b c0992b = this.f2651c.f2639d;
        if ((m & 64) == 0) {
            z = false;
        }
        c0992b.f2629e = z;
        if (z2) {
            this.f2651c.f2639d.f2635k = m5183a(pow);
        } else {
            this.f2651c.f2639d.f2635k = null;
        }
        this.f2651c.f2639d.f2634j = this.f2650b.position();
        m5191j();
        if (!m5196o()) {
            C0993c c0993c = this.f2651c;
            c0993c.f2638c++;
            this.f2651c.f2640e.add(this.f2651c.f2639d);
        }
    }

    private void m5188g() {
        do {
            m5193l();
            if (this.f2649a[0] == (byte) 1) {
                this.f2651c.f2648m = (this.f2649a[1] & 255) | ((this.f2649a[2] & 255) << 8);
            }
            if (this.f2652d <= 0) {
                return;
            }
        } while (!m5196o());
    }

    private void m5189h() {
        String str = BuildConfig.FLAVOR;
        for (int i = 0; i < 6; i++) {
            str = str + ((char) m5194m());
        }
        if (str.startsWith("GIF")) {
            m5190i();
            if (this.f2651c.f2643h && !m5196o()) {
                this.f2651c.f2636a = m5183a(this.f2651c.f2644i);
                this.f2651c.f2647l = this.f2651c.f2636a[this.f2651c.f2645j];
                return;
            }
            return;
        }
        this.f2651c.f2637b = 1;
    }

    private void m5190i() {
        this.f2651c.f2641f = m5195n();
        this.f2651c.f2642g = m5195n();
        int m = m5194m();
        this.f2651c.f2643h = (m & 128) != 0;
        this.f2651c.f2644i = 2 << (m & 7);
        this.f2651c.f2645j = m5194m();
        this.f2651c.f2646k = m5194m();
    }

    private void m5191j() {
        m5194m();
        m5192k();
    }

    private void m5192k() {
        int m;
        do {
            m = m5194m();
            this.f2650b.position(this.f2650b.position() + m);
        } while (m > 0);
    }

    private int m5193l() {
        int i = 0;
        this.f2652d = m5194m();
        if (this.f2652d > 0) {
            int i2 = 0;
            while (i < this.f2652d) {
                try {
                    i2 = this.f2652d - i;
                    this.f2650b.get(this.f2649a, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    if (Log.isLoggable("GifHeaderParser", 3)) {
                        Log.d("GifHeaderParser", "Error Reading Block n: " + i + " count: " + i2 + " blockSize: " + this.f2652d, e);
                    }
                    this.f2651c.f2637b = 1;
                }
            }
        }
        return i;
    }

    private int m5194m() {
        int i = 0;
        try {
            return this.f2650b.get() & 255;
        } catch (Exception e) {
            this.f2651c.f2637b = 1;
            return i;
        }
    }

    private int m5195n() {
        return this.f2650b.getShort();
    }

    private boolean m5196o() {
        return this.f2651c.f2637b != 0;
    }

    public C0994d m5197a(byte[] bArr) {
        m5184c();
        if (bArr != null) {
            this.f2650b = ByteBuffer.wrap(bArr);
            this.f2650b.rewind();
            this.f2650b.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.f2650b = null;
            this.f2651c.f2637b = 2;
        }
        return this;
    }

    public void m5198a() {
        this.f2650b = null;
        this.f2651c = null;
    }

    public C0993c m5199b() {
        if (this.f2650b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (m5196o()) {
            return this.f2651c;
        } else {
            m5189h();
            if (!m5196o()) {
                m5185d();
                if (this.f2651c.f2638c < 0) {
                    this.f2651c.f2637b = 1;
                }
            }
            return this.f2651c;
        }
    }
}
