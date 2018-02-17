package com.p045c.p046a.p049c;

import java.io.OutputStream;

/* renamed from: com.c.a.c.b */
class C0997b {
    int f2678a;
    int f2679b;
    int f2680c;
    int f2681d;
    int[] f2682e;
    int[] f2683f;
    int f2684g;
    int f2685h;
    boolean f2686i;
    int f2687j;
    int f2688k;
    int f2689l;
    int f2690m;
    int f2691n;
    int[] f2692o;
    int f2693p;
    byte[] f2694q;
    private int f2695r;
    private int f2696s;
    private byte[] f2697t;
    private int f2698u;
    private int f2699v;
    private int f2700w;

    C0997b(int i, int i2, byte[] bArr, int i3) {
        this.f2679b = 12;
        this.f2681d = 4096;
        this.f2682e = new int[5003];
        this.f2683f = new int[5003];
        this.f2684g = 5003;
        this.f2685h = 0;
        this.f2686i = false;
        this.f2690m = 0;
        this.f2691n = 0;
        this.f2692o = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, 65535};
        this.f2694q = new byte[256];
        this.f2695r = i;
        this.f2696s = i2;
        this.f2697t = bArr;
        this.f2698u = Math.max(2, i3);
    }

    private int m5217a() {
        if (this.f2699v == 0) {
            return -1;
        }
        this.f2699v--;
        byte[] bArr = this.f2697t;
        int i = this.f2700w;
        this.f2700w = i + 1;
        return bArr[i] & 255;
    }

    void m5218a(byte b, OutputStream outputStream) {
        byte[] bArr = this.f2694q;
        int i = this.f2693p;
        this.f2693p = i + 1;
        bArr[i] = b;
        if (this.f2693p >= 254) {
            m5225c(outputStream);
        }
    }

    void m5219a(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            this.f2682e[i2] = -1;
        }
    }

    void m5220a(int i, OutputStream outputStream) {
        int i2;
        int i3 = 0;
        this.f2687j = i;
        this.f2686i = false;
        this.f2678a = this.f2687j;
        this.f2680c = m5222b(this.f2678a);
        this.f2688k = 1 << (i - 1);
        this.f2689l = this.f2688k + 1;
        this.f2685h = this.f2688k + 2;
        this.f2693p = 0;
        int a = m5217a();
        for (i2 = this.f2684g; i2 < 65536; i2 *= 2) {
            i3++;
        }
        int i4 = 8 - i3;
        int i5 = this.f2684g;
        m5219a(i5);
        m5223b(this.f2688k, outputStream);
        while (true) {
            i3 = m5217a();
            if (i3 != -1) {
                int i6 = (i3 << this.f2679b) + a;
                i2 = (i3 << i4) ^ a;
                if (this.f2682e[i2] == i6) {
                    a = this.f2683f[i2];
                } else if (this.f2682e[i2] >= 0) {
                    r3 = i5 - i2;
                    if (i2 == 0) {
                        r3 = 1;
                    }
                    do {
                        i2 -= r3;
                        if (i2 < 0) {
                            i2 += i5;
                        }
                        if (this.f2682e[i2] == i6) {
                            a = this.f2683f[i2];
                            break;
                        }
                    } while (this.f2682e[i2] >= 0);
                    m5223b(a, outputStream);
                    if (this.f2685h >= this.f2681d) {
                        r0 = this.f2683f;
                        r3 = this.f2685h;
                        this.f2685h = r3 + 1;
                        r0[i2] = r3;
                        this.f2682e[i2] = i6;
                        a = i3;
                    } else {
                        m5221a(outputStream);
                        a = i3;
                    }
                } else {
                    m5223b(a, outputStream);
                    if (this.f2685h >= this.f2681d) {
                        m5221a(outputStream);
                        a = i3;
                    } else {
                        r0 = this.f2683f;
                        r3 = this.f2685h;
                        this.f2685h = r3 + 1;
                        r0[i2] = r3;
                        this.f2682e[i2] = i6;
                        a = i3;
                    }
                }
            } else {
                m5223b(a, outputStream);
                m5223b(this.f2689l, outputStream);
                return;
            }
        }
    }

    void m5221a(OutputStream outputStream) {
        m5219a(this.f2684g);
        this.f2685h = this.f2688k + 2;
        this.f2686i = true;
        m5223b(this.f2688k, outputStream);
    }

    final int m5222b(int i) {
        return (1 << i) - 1;
    }

    void m5223b(int i, OutputStream outputStream) {
        this.f2690m &= this.f2692o[this.f2691n];
        if (this.f2691n > 0) {
            this.f2690m |= i << this.f2691n;
        } else {
            this.f2690m = i;
        }
        this.f2691n += this.f2678a;
        while (this.f2691n >= 8) {
            m5218a((byte) (this.f2690m & 255), outputStream);
            this.f2690m >>= 8;
            this.f2691n -= 8;
        }
        if (this.f2685h > this.f2680c || this.f2686i) {
            if (this.f2686i) {
                int i2 = this.f2687j;
                this.f2678a = i2;
                this.f2680c = m5222b(i2);
                this.f2686i = false;
            } else {
                this.f2678a++;
                if (this.f2678a == this.f2679b) {
                    this.f2680c = this.f2681d;
                } else {
                    this.f2680c = m5222b(this.f2678a);
                }
            }
        }
        if (i == this.f2689l) {
            while (this.f2691n > 0) {
                m5218a((byte) (this.f2690m & 255), outputStream);
                this.f2690m >>= 8;
                this.f2691n -= 8;
            }
            m5225c(outputStream);
        }
    }

    void m5224b(OutputStream outputStream) {
        outputStream.write(this.f2698u);
        this.f2699v = this.f2695r * this.f2696s;
        this.f2700w = 0;
        m5220a(this.f2698u + 1, outputStream);
        outputStream.write(0);
    }

    void m5225c(OutputStream outputStream) {
        if (this.f2693p > 0) {
            outputStream.write(this.f2693p);
            outputStream.write(this.f2694q, 0, this.f2693p);
            this.f2693p = 0;
        }
    }
}
