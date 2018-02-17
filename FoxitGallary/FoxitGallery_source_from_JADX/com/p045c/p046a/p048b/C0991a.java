package com.p045c.p046a.p048b;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* renamed from: com.c.a.b.a */
public class C0991a {
    private static final String f2608a;
    private static final Config f2609b;
    private int[] f2610c;
    private ByteBuffer f2611d;
    private final byte[] f2612e;
    private short[] f2613f;
    private byte[] f2614g;
    private byte[] f2615h;
    private byte[] f2616i;
    private int[] f2617j;
    private int f2618k;
    private byte[] f2619l;
    private C0993c f2620m;
    private C0990a f2621n;
    private Bitmap f2622o;
    private boolean f2623p;
    private int f2624q;

    /* renamed from: com.c.a.b.a.a */
    public interface C0990a {
        Bitmap m5164a(int i, int i2, Config config);

        void m5165a(Bitmap bitmap);
    }

    static {
        f2608a = C0991a.class.getSimpleName();
        f2609b = Config.ARGB_8888;
    }

    public C0991a(C0990a c0990a) {
        this.f2612e = new byte[256];
        this.f2621n = c0990a;
        this.f2620m = new C0993c();
    }

    private Bitmap m5166a(C0992b c0992b, C0992b c0992b2) {
        int i;
        int i2 = this.f2620m.f2641f;
        int i3 = this.f2620m.f2642g;
        int[] iArr = this.f2617j;
        if (c0992b2 != null && c0992b2.f2631g > 0) {
            if (c0992b2.f2631g == 2) {
                i = 0;
                if (!c0992b.f2630f) {
                    i = this.f2620m.f2647l;
                }
                Arrays.fill(iArr, i);
            } else if (c0992b2.f2631g == 3 && this.f2622o != null) {
                this.f2622o.getPixels(iArr, 0, i2, 0, 0, i2, i3);
            }
        }
        m5168a(c0992b);
        int i4 = 1;
        int i5 = 8;
        int i6 = 0;
        for (i = 0; i < c0992b.f2628d; i++) {
            int i7;
            if (c0992b.f2629e) {
                if (i6 >= c0992b.f2628d) {
                    i4++;
                    switch (i4) {
                        case C1373c.View_paddingStart /*2*/:
                            i6 = 4;
                            break;
                        case C1373c.View_paddingEnd /*3*/:
                            i6 = 2;
                            i5 = 4;
                            break;
                        case C1373c.View_theme /*4*/:
                            i6 = 1;
                            i5 = 2;
                            break;
                    }
                }
                int i8 = i6;
                i6 += i5;
                i7 = i8;
            } else {
                i7 = i;
            }
            i7 += c0992b.f2626b;
            if (i7 < this.f2620m.f2642g) {
                int i9 = this.f2620m.f2641f * i7;
                int i10 = i9 + c0992b.f2625a;
                i7 = c0992b.f2627c + i10;
                if (this.f2620m.f2641f + i9 < i7) {
                    i7 = this.f2620m.f2641f + i9;
                }
                i9 = c0992b.f2627c * i;
                int i11 = i10;
                while (i11 < i7) {
                    i10 = i9 + 1;
                    i9 = this.f2610c[this.f2616i[i9] & 255];
                    if (i9 != 0) {
                        iArr[i11] = i9;
                    }
                    i11++;
                    i9 = i10;
                }
            }
        }
        if (this.f2623p && (c0992b.f2631g == 0 || c0992b.f2631g == 1)) {
            if (this.f2622o == null) {
                this.f2622o = m5171j();
            }
            this.f2622o.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        }
        Bitmap j = m5171j();
        j.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        return j;
    }

    @TargetApi(12)
    private static void m5167a(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }

    private void m5168a(C0992b c0992b) {
        int i;
        if (c0992b != null) {
            this.f2611d.position(c0992b.f2634j);
        }
        int i2 = c0992b == null ? this.f2620m.f2641f * this.f2620m.f2642g : c0992b.f2627c * c0992b.f2628d;
        if (this.f2616i == null || this.f2616i.length < i2) {
            this.f2616i = new byte[i2];
        }
        if (this.f2613f == null) {
            this.f2613f = new short[4096];
        }
        if (this.f2614g == null) {
            this.f2614g = new byte[4096];
        }
        if (this.f2615h == null) {
            this.f2615h = new byte[4097];
        }
        int h = m5169h();
        int i3 = 1 << h;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        int i6 = -1;
        int i7 = h + 1;
        int i8 = (1 << i7) - 1;
        for (i = 0; i < i3; i++) {
            this.f2613f[i] = (short) 0;
            this.f2614g[i] = (byte) i;
        }
        i = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = i7;
        int i14 = i8;
        int i15 = i5;
        i7 = 0;
        i8 = 0;
        i5 = 0;
        while (i9 < i2) {
            if (i8 == 0) {
                i8 = m5170i();
                if (i8 <= 0) {
                    this.f2624q = 3;
                    break;
                }
                i7 = 0;
            }
            i += (this.f2612e[i7] & 255) << i12;
            int i16 = i7 + 1;
            int i17 = i8 - 1;
            i7 = i13;
            i8 = i14;
            i13 = i11;
            int i18 = i12 + 8;
            i12 = i;
            i = i5;
            i5 = i15;
            i15 = i18;
            while (i15 >= i7) {
                i11 = i12 & i8;
                i14 = i12 >> i7;
                i15 -= i7;
                if (i11 == i3) {
                    i7 = h + 1;
                    i8 = (1 << i7) - 1;
                    i5 = i3 + 2;
                    i12 = i14;
                    i6 = -1;
                } else if (i11 > i5) {
                    this.f2624q = 3;
                    i11 = i13;
                    i12 = i15;
                    i13 = i7;
                    i15 = i5;
                    i7 = i16;
                    i5 = i;
                    i = i14;
                    i14 = i8;
                    i8 = i17;
                    break;
                } else if (i11 == i4) {
                    i11 = i13;
                    i12 = i15;
                    i13 = i7;
                    i15 = i5;
                    i7 = i16;
                    i5 = i;
                    i = i14;
                    i14 = i8;
                    i8 = i17;
                    break;
                } else if (i6 == -1) {
                    i12 = i10 + 1;
                    this.f2615h[i10] = this.f2614g[i11];
                    i10 = i12;
                    i13 = i11;
                    i6 = i11;
                    i12 = i14;
                } else {
                    if (i11 >= i5) {
                        i12 = i10 + 1;
                        this.f2615h[i10] = (byte) i13;
                        i10 = i12;
                        i13 = i6;
                    } else {
                        i13 = i11;
                    }
                    while (i13 >= i3) {
                        i12 = i10 + 1;
                        this.f2615h[i10] = this.f2614g[i13];
                        short s = this.f2613f[i13];
                        i10 = i12;
                    }
                    i13 = this.f2614g[i13] & 255;
                    i12 = i10 + 1;
                    this.f2615h[i10] = (byte) i13;
                    if (i5 < 4096) {
                        this.f2613f[i5] = (short) i6;
                        this.f2614g[i5] = (byte) i13;
                        i5++;
                        if ((i5 & i8) == 0 && i5 < 4096) {
                            i7++;
                            i8 += i5;
                        }
                    }
                    i10 = i9;
                    while (i12 > 0) {
                        i9 = i12 - 1;
                        i12 = i + 1;
                        this.f2616i[i] = this.f2615h[i9];
                        i10++;
                        i = i12;
                        i12 = i9;
                    }
                    i9 = i10;
                    i6 = i11;
                    i10 = i12;
                    i12 = i14;
                }
            }
            i11 = i13;
            i14 = i8;
            i8 = i17;
            i13 = i7;
            i7 = i16;
            i18 = i15;
            i15 = i5;
            i5 = i;
            i = i12;
            i12 = i18;
        }
        for (i7 = i5; i7 < i2; i7++) {
            this.f2616i[i7] = (byte) 0;
        }
    }

    private int m5169h() {
        int i = 0;
        try {
            return this.f2611d.get() & 255;
        } catch (Exception e) {
            this.f2624q = 1;
            return i;
        }
    }

    private int m5170i() {
        int h = m5169h();
        int i = 0;
        if (h > 0) {
            while (i < h) {
                int i2 = h - i;
                try {
                    this.f2611d.get(this.f2612e, i, i2);
                    i += i2;
                } catch (Throwable e) {
                    Log.w(f2608a, "Error Reading Block", e);
                    this.f2624q = 1;
                }
            }
        }
        return i;
    }

    private Bitmap m5171j() {
        Bitmap a = this.f2621n.m5164a(this.f2620m.f2641f, this.f2620m.f2642g, f2609b);
        if (a == null) {
            a = Bitmap.createBitmap(this.f2620m.f2641f, this.f2620m.f2642g, f2609b);
        }
        C0991a.m5167a(a);
        return a;
    }

    public int m5172a(int i) {
        return (i < 0 || i >= this.f2620m.f2638c) ? -1 : ((C0992b) this.f2620m.f2640e.get(i)).f2633i;
    }

    public void m5173a() {
        this.f2618k = (this.f2618k + 1) % this.f2620m.f2638c;
    }

    public void m5174a(C0993c c0993c, byte[] bArr) {
        this.f2620m = c0993c;
        this.f2619l = bArr;
        this.f2624q = 0;
        this.f2618k = -1;
        this.f2611d = ByteBuffer.wrap(bArr);
        this.f2611d.rewind();
        this.f2611d.order(ByteOrder.LITTLE_ENDIAN);
        this.f2623p = false;
        for (C0992b c0992b : c0993c.f2640e) {
            if (c0992b.f2631g == 3) {
                this.f2623p = true;
                break;
            }
        }
        this.f2616i = new byte[(c0993c.f2641f * c0993c.f2642g)];
        this.f2617j = new int[(c0993c.f2641f * c0993c.f2642g)];
    }

    public int m5175b() {
        return (this.f2620m.f2638c <= 0 || this.f2618k < 0) ? -1 : m5172a(this.f2618k);
    }

    public int m5176c() {
        return this.f2620m.f2638c;
    }

    public int m5177d() {
        return this.f2618k;
    }

    public int m5178e() {
        return this.f2620m.f2648m;
    }

    public synchronized Bitmap m5179f() {
        Bitmap bitmap;
        int i = 0;
        synchronized (this) {
            if (this.f2620m.f2638c <= 0 || this.f2618k < 0) {
                if (Log.isLoggable(f2608a, 3)) {
                    Log.d(f2608a, "unable to decode frame, frameCount=" + this.f2620m.f2638c + " framePointer=" + this.f2618k);
                }
                this.f2624q = 1;
            }
            if (this.f2624q == 1 || this.f2624q == 2) {
                if (Log.isLoggable(f2608a, 3)) {
                    Log.d(f2608a, "Unable to decode frame, status=" + this.f2624q);
                }
                bitmap = null;
            } else {
                this.f2624q = 0;
                C0992b c0992b = (C0992b) this.f2620m.f2640e.get(this.f2618k);
                int i2 = this.f2618k - 1;
                C0992b c0992b2 = i2 >= 0 ? (C0992b) this.f2620m.f2640e.get(i2) : null;
                if (c0992b.f2635k == null) {
                    this.f2610c = this.f2620m.f2636a;
                } else {
                    this.f2610c = c0992b.f2635k;
                    if (this.f2620m.f2645j == c0992b.f2632h) {
                        this.f2620m.f2647l = 0;
                    }
                }
                if (c0992b.f2630f) {
                    i2 = this.f2610c[c0992b.f2632h];
                    this.f2610c[c0992b.f2632h] = 0;
                    i = i2;
                }
                if (this.f2610c == null) {
                    if (Log.isLoggable(f2608a, 3)) {
                        Log.d(f2608a, "No Valid Color Table");
                    }
                    this.f2624q = 1;
                    bitmap = null;
                } else {
                    Bitmap a = m5166a(c0992b, c0992b2);
                    if (c0992b.f2630f) {
                        this.f2610c[c0992b.f2632h] = i;
                    }
                    bitmap = a;
                }
            }
        }
        return bitmap;
    }

    public void m5180g() {
        this.f2620m = null;
        this.f2619l = null;
        this.f2616i = null;
        this.f2617j = null;
        if (this.f2622o != null) {
            this.f2621n.m5165a(this.f2622o);
        }
        this.f2622o = null;
        this.f2611d = null;
    }
}
