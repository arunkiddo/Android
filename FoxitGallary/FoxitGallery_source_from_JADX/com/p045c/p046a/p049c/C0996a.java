package com.p045c.p046a.p049c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.c.a.c.a */
public class C0996a {
    private int f2657a;
    private int f2658b;
    private Integer f2659c;
    private int f2660d;
    private int f2661e;
    private int f2662f;
    private boolean f2663g;
    private OutputStream f2664h;
    private Bitmap f2665i;
    private byte[] f2666j;
    private byte[] f2667k;
    private int f2668l;
    private byte[] f2669m;
    private boolean[] f2670n;
    private int f2671o;
    private int f2672p;
    private boolean f2673q;
    private boolean f2674r;
    private boolean f2675s;
    private int f2676t;
    private boolean f2677u;

    public C0996a() {
        this.f2659c = null;
        this.f2661e = -1;
        this.f2662f = 0;
        this.f2663g = false;
        this.f2670n = new boolean[256];
        this.f2671o = 7;
        this.f2672p = -1;
        this.f2673q = false;
        this.f2674r = true;
        this.f2675s = false;
        this.f2676t = 10;
    }

    private void m5201a(String str) {
        for (int i = 0; i < str.length(); i++) {
            this.f2664h.write((byte) str.charAt(i));
        }
    }

    private int m5202b(int i) {
        int i2 = 0;
        if (this.f2669m == null) {
            return -1;
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        int i3 = 16777216;
        int length = this.f2669m.length;
        int i4 = 0;
        while (i2 < length) {
            int i5 = i2 + 1;
            i2 = red - (this.f2669m[i2] & 255);
            int i6 = i5 + 1;
            int i7 = green - (this.f2669m[i5] & 255);
            i5 = blue - (this.f2669m[i6] & 255);
            i2 = ((i2 * i2) + (i7 * i7)) + (i5 * i5);
            i7 = i6 / 3;
            if (!this.f2670n[i7] || i2 >= i3) {
                i2 = i3;
                i3 = i4;
            } else {
                i3 = i7;
            }
            i4 = i3;
            i3 = i2;
            i2 = i6 + 1;
        }
        return i4;
    }

    private void m5203b() {
        int length = this.f2666j.length;
        int i = length / 3;
        this.f2667k = new byte[i];
        C0998c c0998c = new C0998c(this.f2666j, length, this.f2676t);
        this.f2669m = c0998c.m5233d();
        for (length = 0; length < this.f2669m.length; length += 3) {
            byte b = this.f2669m[length];
            this.f2669m[length] = this.f2669m[length + 2];
            this.f2669m[length + 2] = b;
            this.f2670n[length / 3] = false;
        }
        int i2 = 0;
        for (length = 0; length < i; length++) {
            int i3 = i2 + 1;
            int i4 = i3 + 1;
            i2 = i4 + 1;
            int a = c0998c.m5226a(this.f2666j[i2] & 255, this.f2666j[i3] & 255, this.f2666j[i4] & 255);
            this.f2670n[a] = true;
            this.f2667k[length] = (byte) a;
        }
        this.f2666j = null;
        this.f2668l = 8;
        this.f2671o = 7;
        if (this.f2659c != null) {
            this.f2660d = m5202b(this.f2659c.intValue());
        } else if (this.f2677u) {
            this.f2660d = m5202b(0);
        }
    }

    private void m5204c() {
        boolean z = false;
        int width = this.f2665i.getWidth();
        int height = this.f2665i.getHeight();
        if (!(width == this.f2657a && height == this.f2658b)) {
            Bitmap createBitmap = Bitmap.createBitmap(this.f2657a, this.f2658b, Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, null);
            this.f2665i = createBitmap;
        }
        int[] iArr = new int[(width * height)];
        this.f2665i.getPixels(iArr, 0, width, 0, 0, width, height);
        this.f2666j = new byte[(iArr.length * 3)];
        this.f2677u = false;
        int i = 0;
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 == 0) {
                i++;
            }
            int i4 = i2 + 1;
            this.f2666j[i2] = (byte) (i3 & 255);
            height = i4 + 1;
            this.f2666j[i4] = (byte) ((i3 >> 8) & 255);
            i2 = height + 1;
            this.f2666j[height] = (byte) ((i3 >> 16) & 255);
        }
        double length = ((double) (i * 100)) / ((double) iArr.length);
        if (length > 4.0d) {
            z = true;
        }
        this.f2677u = z;
        if (Log.isLoggable("AnimatedGifEncoder", 3)) {
            Log.d("AnimatedGifEncoder", "got pixels for frame with " + length + "% transparent pixels");
        }
    }

    private void m5205c(int i) {
        this.f2664h.write(i & 255);
        this.f2664h.write((i >> 8) & 255);
    }

    private void m5206d() {
        int i;
        int i2;
        this.f2664h.write(33);
        this.f2664h.write(249);
        this.f2664h.write(4);
        if (this.f2659c != null || this.f2677u) {
            i = 1;
            i2 = 2;
        } else {
            i2 = 0;
            i = 0;
        }
        if (this.f2672p >= 0) {
            i2 = this.f2672p & 7;
        }
        this.f2664h.write((((i2 << 2) | 0) | 0) | i);
        m5205c(this.f2662f);
        this.f2664h.write(this.f2660d);
        this.f2664h.write(0);
    }

    private void m5207e() {
        this.f2664h.write(44);
        m5205c(0);
        m5205c(0);
        m5205c(this.f2657a);
        m5205c(this.f2658b);
        if (this.f2674r) {
            this.f2664h.write(0);
        } else {
            this.f2664h.write(this.f2671o | 128);
        }
    }

    private void m5208f() {
        m5205c(this.f2657a);
        m5205c(this.f2658b);
        this.f2664h.write(this.f2671o | 240);
        this.f2664h.write(0);
        this.f2664h.write(0);
    }

    private void m5209g() {
        this.f2664h.write(33);
        this.f2664h.write(255);
        this.f2664h.write(11);
        m5201a("NETSCAPE2.0");
        this.f2664h.write(3);
        this.f2664h.write(1);
        m5205c(this.f2661e);
        this.f2664h.write(0);
    }

    private void m5210h() {
        this.f2664h.write(this.f2669m, 0, this.f2669m.length);
        int length = 768 - this.f2669m.length;
        for (int i = 0; i < length; i++) {
            this.f2664h.write(0);
        }
    }

    private void m5211i() {
        new C0997b(this.f2657a, this.f2658b, this.f2667k, this.f2668l).m5224b(this.f2664h);
    }

    public void m5212a(int i) {
        this.f2662f = Math.round(((float) i) / 10.0f);
    }

    public void m5213a(int i, int i2) {
        if (!this.f2663g || this.f2674r) {
            this.f2657a = i;
            this.f2658b = i2;
            if (this.f2657a < 1) {
                this.f2657a = 320;
            }
            if (this.f2658b < 1) {
                this.f2658b = 240;
            }
            this.f2675s = true;
        }
    }

    public boolean m5214a() {
        if (!this.f2663g) {
            return false;
        }
        boolean z;
        this.f2663g = false;
        try {
            this.f2664h.write(59);
            this.f2664h.flush();
            if (this.f2673q) {
                this.f2664h.close();
            }
            z = true;
        } catch (IOException e) {
            z = false;
        }
        this.f2660d = 0;
        this.f2664h = null;
        this.f2665i = null;
        this.f2666j = null;
        this.f2667k = null;
        this.f2669m = null;
        this.f2673q = false;
        this.f2674r = true;
        return z;
    }

    public boolean m5215a(Bitmap bitmap) {
        if (bitmap == null || !this.f2663g) {
            return false;
        }
        try {
            if (!this.f2675s) {
                m5213a(bitmap.getWidth(), bitmap.getHeight());
            }
            this.f2665i = bitmap;
            m5204c();
            m5203b();
            if (this.f2674r) {
                m5208f();
                m5210h();
                if (this.f2661e >= 0) {
                    m5209g();
                }
            }
            m5206d();
            m5207e();
            if (!this.f2674r) {
                m5210h();
            }
            m5211i();
            this.f2674r = false;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean m5216a(OutputStream outputStream) {
        if (outputStream == null) {
            return false;
        }
        boolean z = true;
        this.f2673q = false;
        this.f2664h = outputStream;
        try {
            m5201a("GIF89a");
        } catch (IOException e) {
            z = false;
        }
        this.f2663g = z;
        return z;
    }
}
