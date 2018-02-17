package com.p045c.p046a.p049c;

/* renamed from: com.c.a.c.c */
class C0998c {
    protected int f2701a;
    protected byte[] f2702b;
    protected int f2703c;
    protected int f2704d;
    protected int[][] f2705e;
    protected int[] f2706f;
    protected int[] f2707g;
    protected int[] f2708h;
    protected int[] f2709i;

    public C0998c(byte[] bArr, int i, int i2) {
        this.f2706f = new int[256];
        this.f2707g = new int[256];
        this.f2708h = new int[256];
        this.f2709i = new int[32];
        this.f2702b = bArr;
        this.f2703c = i;
        this.f2704d = i2;
        this.f2705e = new int[256][];
        for (int i3 = 0; i3 < 256; i3++) {
            this.f2705e[i3] = new int[4];
            int[] iArr = this.f2705e[i3];
            int i4 = (i3 << 12) / 256;
            iArr[2] = i4;
            iArr[1] = i4;
            iArr[0] = i4;
            this.f2708h[i3] = 256;
            this.f2707g[i3] = 0;
        }
    }

    public int m5226a(int i, int i2, int i3) {
        int i4 = this.f2706f[i2];
        int i5 = -1;
        int i6 = 1000;
        int i7 = i4 - 1;
        int i8 = i4;
        while (true) {
            if (i8 >= 256 && i7 < 0) {
                return i5;
            }
            int[] iArr;
            int i9;
            if (i8 < 256) {
                iArr = this.f2705e[i8];
                i9 = iArr[1] - i2;
                if (i9 >= i6) {
                    i8 = i6;
                    i4 = 256;
                    i6 = i5;
                } else {
                    i4 = i8 + 1;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    i8 = iArr[0] - i;
                    if (i8 < 0) {
                        i8 = -i8;
                    }
                    i8 += i9;
                    if (i8 < i6) {
                        i9 = iArr[2] - i3;
                        if (i9 < 0) {
                            i9 = -i9;
                        }
                        i8 += i9;
                        if (i8 < i6) {
                            i6 = iArr[3];
                        }
                    }
                    i8 = i6;
                    i6 = i5;
                }
            } else {
                i4 = i8;
                i8 = i6;
                i6 = i5;
            }
            if (i7 >= 0) {
                iArr = this.f2705e[i7];
                i9 = i2 - iArr[1];
                if (i9 >= i8) {
                    i5 = i6;
                    i7 = -1;
                    i6 = i8;
                    i8 = i4;
                } else {
                    i7--;
                    if (i9 < 0) {
                        i9 = -i9;
                    }
                    i5 = iArr[0] - i;
                    if (i5 < 0) {
                        i5 = -i5;
                    }
                    i5 += i9;
                    if (i5 < i8) {
                        i9 = iArr[2] - i3;
                        if (i9 < 0) {
                            i9 = -i9;
                        }
                        i9 += i5;
                        if (i9 < i8) {
                            i5 = iArr[3];
                            i8 = i4;
                            i6 = i9;
                        }
                    }
                }
            }
            i5 = i6;
            i6 = i8;
            i8 = i4;
        }
    }

    protected void m5227a(int i, int i2, int i3, int i4, int i5) {
        int i6 = i2 - i;
        int i7 = i6 < -1 ? -1 : i6;
        i6 = i2 + i;
        if (i6 > 256) {
            i6 = 256;
        }
        int i8 = 1;
        int i9 = i2 - 1;
        int i10 = i2 + 1;
        while (true) {
            if (i10 < i6 || i9 > i7) {
                int i11 = i8 + 1;
                int i12 = this.f2709i[i8];
                if (i10 < i6) {
                    i8 = i10 + 1;
                    int[] iArr = this.f2705e[i10];
                    try {
                        iArr[0] = iArr[0] - (((iArr[0] - i3) * i12) / 262144);
                        iArr[1] = iArr[1] - (((iArr[1] - i4) * i12) / 262144);
                        iArr[2] = iArr[2] - (((iArr[2] - i5) * i12) / 262144);
                    } catch (Exception e) {
                    }
                } else {
                    i8 = i10;
                }
                if (i9 > i7) {
                    i10 = i9 - 1;
                    int[] iArr2 = this.f2705e[i9];
                    try {
                        iArr2[0] = iArr2[0] - (((iArr2[0] - i3) * i12) / 262144);
                        iArr2[1] = iArr2[1] - (((iArr2[1] - i4) * i12) / 262144);
                        iArr2[2] = iArr2[2] - ((i12 * (iArr2[2] - i5)) / 262144);
                        i9 = i10;
                        i10 = i8;
                        i8 = i11;
                    } catch (Exception e2) {
                        i9 = i10;
                        i10 = i8;
                        i8 = i11;
                    }
                } else {
                    i10 = i8;
                    i8 = i11;
                }
            } else {
                return;
            }
        }
    }

    public byte[] m5228a() {
        int i;
        byte[] bArr = new byte[768];
        int[] iArr = new int[256];
        for (i = 0; i < 256; i++) {
            iArr[this.f2705e[i][3]] = i;
        }
        int i2 = 0;
        for (i = 0; i < 256; i++) {
            int i3 = iArr[i];
            int i4 = i2 + 1;
            bArr[i2] = (byte) this.f2705e[i3][0];
            int i5 = i4 + 1;
            bArr[i4] = (byte) this.f2705e[i3][1];
            i2 = i5 + 1;
            bArr[i5] = (byte) this.f2705e[i3][2];
        }
        return bArr;
    }

    protected int m5229b(int i, int i2, int i3) {
        int i4 = Integer.MAX_VALUE;
        int i5 = -1;
        int i6 = Integer.MAX_VALUE;
        int i7 = -1;
        int i8 = 0;
        while (i8 < 256) {
            int[] iArr = this.f2705e[i8];
            int i9 = iArr[0] - i;
            if (i9 < 0) {
                i9 = -i9;
            }
            int i10 = iArr[1] - i2;
            if (i10 < 0) {
                i10 = -i10;
            }
            i10 += i9;
            i9 = iArr[2] - i3;
            if (i9 < 0) {
                i9 = -i9;
            }
            i10 += i9;
            if (i10 < i6) {
                i9 = i10;
                i6 = i8;
            } else {
                i9 = i6;
                i6 = i7;
            }
            i10 -= this.f2707g[i8] >> 12;
            if (i10 < i4) {
                i7 = i8;
            } else {
                i10 = i4;
                i7 = i5;
            }
            i4 = this.f2708h[i8] >> 10;
            int[] iArr2 = this.f2708h;
            iArr2[i8] = iArr2[i8] - i4;
            iArr2 = this.f2707g;
            iArr2[i8] = (i4 << 10) + iArr2[i8];
            i8++;
            i4 = i10;
            i5 = i7;
            i7 = i6;
            i6 = i9;
        }
        int[] iArr3 = this.f2708h;
        iArr3[i7] = iArr3[i7] + 64;
        iArr3 = this.f2707g;
        iArr3[i7] = iArr3[i7] - 65536;
        return i5;
    }

    public void m5230b() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i3 < 256) {
            int[] iArr = this.f2705e[i3];
            int i4 = iArr[1];
            int i5 = i3;
            for (int i6 = i3 + 1; i6 < 256; i6++) {
                int[] iArr2 = this.f2705e[i6];
                if (iArr2[1] < i4) {
                    i4 = iArr2[1];
                    i5 = i6;
                }
            }
            int[] iArr3 = this.f2705e[i5];
            if (i3 != i5) {
                i5 = iArr3[0];
                iArr3[0] = iArr[0];
                iArr[0] = i5;
                i5 = iArr3[1];
                iArr3[1] = iArr[1];
                iArr[1] = i5;
                i5 = iArr3[2];
                iArr3[2] = iArr[2];
                iArr[2] = i5;
                i5 = iArr3[3];
                iArr3[3] = iArr[3];
                iArr[3] = i5;
            }
            if (i4 != i2) {
                this.f2706f[i2] = (i + i3) >> 1;
                for (i5 = i2 + 1; i5 < i4; i5++) {
                    this.f2706f[i5] = i3;
                }
                i5 = i4;
                i4 = i3;
            } else {
                i4 = i;
                i5 = i2;
            }
            i3++;
            i = i4;
            i2 = i5;
        }
        this.f2706f[i2] = (i + 255) >> 1;
        for (i4 = i2 + 1; i4 < 256; i4++) {
            this.f2706f[i4] = 255;
        }
    }

    protected void m5231b(int i, int i2, int i3, int i4, int i5) {
        int[] iArr = this.f2705e[i2];
        iArr[0] = iArr[0] - (((iArr[0] - i3) * i) / 1024);
        iArr[1] = iArr[1] - (((iArr[1] - i4) * i) / 1024);
        iArr[2] = iArr[2] - (((iArr[2] - i5) * i) / 1024);
    }

    public void m5232c() {
        int i;
        if (this.f2703c < 1509) {
            this.f2704d = 1;
        }
        this.f2701a = ((this.f2704d - 1) / 3) + 30;
        byte[] bArr = this.f2702b;
        int i2 = this.f2703c;
        int i3 = this.f2703c / (this.f2704d * 3);
        int i4 = i3 / 100;
        for (i = 0; i < 32; i++) {
            this.f2709i[i] = (((1024 - (i * i)) * 256) / 1024) * 1024;
        }
        int i5 = this.f2703c < 1509 ? 3 : this.f2703c % 499 != 0 ? 1497 : this.f2703c % 491 != 0 ? 1473 : this.f2703c % 487 != 0 ? 1461 : 1509;
        int i6 = 0;
        int i7 = 32;
        int i8 = 2048;
        int i9 = 0;
        i = 1024;
        while (i9 < i3) {
            int i10 = (bArr[i6 + 0] & 255) << 4;
            int i11 = (bArr[i6 + 1] & 255) << 4;
            int i12 = (bArr[i6 + 2] & 255) << 4;
            int b = m5229b(i10, i11, i12);
            m5231b(i, b, i10, i11, i12);
            if (i7 != 0) {
                m5227a(i7, b, i10, i11, i12);
            }
            int i13 = i6 + i5;
            i10 = i13 >= i2 ? i13 - this.f2703c : i13;
            int i14 = i9 + 1;
            i13 = i4 == 0 ? 1 : i4;
            if (i14 % i13 == 0) {
                i11 = i - (i / this.f2701a);
                i12 = i8 - (i8 / 30);
                i = i12 >> 6;
                if (i <= 1) {
                    i = 0;
                }
                for (b = 0; b < i; b++) {
                    this.f2709i[b] = ((((i * i) - (b * b)) * 256) / (i * i)) * i11;
                }
                i6 = i10;
                i4 = i13;
                i7 = i;
                i8 = i12;
                i9 = i14;
                i = i11;
            } else {
                i6 = i10;
                i4 = i13;
                i9 = i14;
            }
        }
    }

    public byte[] m5233d() {
        m5232c();
        m5234e();
        m5230b();
        return m5228a();
    }

    public void m5234e() {
        for (int i = 0; i < 256; i++) {
            int[] iArr = this.f2705e[i];
            iArr[0] = iArr[0] >> 4;
            iArr = this.f2705e[i];
            iArr[1] = iArr[1] >> 4;
            iArr = this.f2705e[i];
            iArr[2] = iArr[2] >> 4;
            this.f2705e[i][3] = i;
        }
    }
}
