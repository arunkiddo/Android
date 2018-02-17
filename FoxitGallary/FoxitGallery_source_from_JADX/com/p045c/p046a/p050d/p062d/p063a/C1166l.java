package com.p045c.p046a.p050d.p062d.p063a;

import android.util.Log;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* renamed from: com.c.a.d.d.a.l */
public class C1166l {
    private static final byte[] f2977a;
    private static final int[] f2978b;
    private final C1165c f2979c;

    /* renamed from: com.c.a.d.d.a.l.a */
    public enum C1163a {
        GIF(true),
        JPEG(false),
        PNG_A(true),
        PNG(false),
        UNKNOWN(false);
        
        private final boolean f2974f;

        private C1163a(boolean z) {
            this.f2974f = z;
        }

        public boolean m5677a() {
            return this.f2974f;
        }
    }

    /* renamed from: com.c.a.d.d.a.l.b */
    private static class C1164b {
        private final ByteBuffer f2975a;

        public C1164b(byte[] bArr) {
            this.f2975a = ByteBuffer.wrap(bArr);
            this.f2975a.order(ByteOrder.BIG_ENDIAN);
        }

        public int m5678a() {
            return this.f2975a.array().length;
        }

        public int m5679a(int i) {
            return this.f2975a.getInt(i);
        }

        public void m5680a(ByteOrder byteOrder) {
            this.f2975a.order(byteOrder);
        }

        public short m5681b(int i) {
            return this.f2975a.getShort(i);
        }
    }

    /* renamed from: com.c.a.d.d.a.l.c */
    private static class C1165c {
        private final InputStream f2976a;

        public C1165c(InputStream inputStream) {
            this.f2976a = inputStream;
        }

        public int m5682a() {
            return ((this.f2976a.read() << 8) & 65280) | (this.f2976a.read() & 255);
        }

        public int m5683a(byte[] bArr) {
            int length = bArr.length;
            while (length > 0) {
                int read = this.f2976a.read(bArr, bArr.length - length, length);
                if (read == -1) {
                    break;
                }
                length -= read;
            }
            return bArr.length - length;
        }

        public long m5684a(long j) {
            if (j < 0) {
                return 0;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.f2976a.skip(j2);
                if (skip > 0) {
                    j2 -= skip;
                } else if (this.f2976a.read() == -1) {
                    break;
                } else {
                    j2--;
                }
            }
            return j - j2;
        }

        public short m5685b() {
            return (short) (this.f2976a.read() & 255);
        }

        public int m5686c() {
            return this.f2976a.read();
        }
    }

    static {
        f2978b = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
        byte[] bArr = new byte[0];
        try {
            bArr = "Exif\u0000\u0000".getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        f2977a = bArr;
    }

    public C1166l(InputStream inputStream) {
        this.f2979c = new C1165c(inputStream);
    }

    private static int m5687a(int i, int i2) {
        return (i + 2) + (i2 * 12);
    }

    private static int m5688a(C1164b c1164b) {
        ByteOrder byteOrder;
        int length = "Exif\u0000\u0000".length();
        short b = c1164b.m5681b(length);
        if (b == (short) 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (b == (short) 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + b);
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        c1164b.m5680a(byteOrder);
        length += c1164b.m5679a(length + 4);
        short b2 = c1164b.m5681b(length);
        for (b = (short) 0; b < b2; b++) {
            int a = C1166l.m5687a(length, b);
            short b3 = c1164b.m5681b(a);
            if (b3 == (short) 274) {
                short b4 = c1164b.m5681b(a + 2);
                if (b4 >= (short) 1 && b4 <= (short) 12) {
                    int a2 = c1164b.m5679a(a + 4);
                    if (a2 >= 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + b + " tagType=" + b3 + " formatCode=" + b4 + " componentCount=" + a2);
                        }
                        a2 += f2978b[b4];
                        if (a2 <= 4) {
                            a += 8;
                            if (a < 0 || a > c1164b.m5678a()) {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + a + " tagType=" + b3);
                                }
                            } else if (a2 >= 0 && a + a2 <= c1164b.m5678a()) {
                                return c1164b.m5681b(a);
                            } else {
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + b3);
                                }
                            }
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + b4);
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code=" + b4);
                }
            }
        }
        return -1;
    }

    private static boolean m5689a(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private byte[] m5690d() {
        long a;
        int a2;
        do {
            short b;
            short b2 = this.f2979c.m5685b();
            if (b2 == (short) 255) {
                b = this.f2979c.m5685b();
                if (b == (short) 218) {
                    return null;
                }
                if (b != (short) 217) {
                    a2 = this.f2979c.m5682a() - 2;
                    if (b != (short) 225) {
                        a = this.f2979c.m5684a((long) a2);
                    } else {
                        byte[] bArr = new byte[a2];
                        int a3 = this.f2979c.m5683a(bArr);
                        if (a3 == a2) {
                            return bArr;
                        }
                        if (!Log.isLoggable("ImageHeaderParser", 3)) {
                            return null;
                        }
                        Log.d("ImageHeaderParser", "Unable to read segment data, type: " + b + ", length: " + a2 + ", actually read: " + a3);
                        return null;
                    }
                } else if (!Log.isLoggable("ImageHeaderParser", 3)) {
                    return null;
                } else {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                    return null;
                }
            } else if (!Log.isLoggable("ImageHeaderParser", 3)) {
                return null;
            } else {
                Log.d("ImageHeaderParser", "Unknown segmentId=" + b2);
                return null;
            }
        } while (a == ((long) a2));
        if (!Log.isLoggable("ImageHeaderParser", 3)) {
            return null;
        }
        Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + b + ", wanted to skip: " + a2 + ", but actually skipped: " + a);
        return null;
    }

    public boolean m5691a() {
        return m5692b().m5677a();
    }

    public C1163a m5692b() {
        int a = this.f2979c.m5682a();
        if (a == 65496) {
            return C1163a.JPEG;
        }
        a = ((a << 16) & -65536) | (this.f2979c.m5682a() & 65535);
        if (a != -1991225785) {
            return (a >> 8) == 4671814 ? C1163a.GIF : C1163a.UNKNOWN;
        } else {
            this.f2979c.m5684a(21);
            return this.f2979c.m5686c() >= 3 ? C1163a.PNG_A : C1163a.PNG;
        }
    }

    public int m5693c() {
        Object obj = null;
        if (!C1166l.m5689a(this.f2979c.m5682a())) {
            return -1;
        }
        byte[] d = m5690d();
        Object obj2 = (d == null || d.length <= f2977a.length) ? null : 1;
        if (obj2 != null) {
            for (int i = 0; i < f2977a.length; i++) {
                if (d[i] != f2977a[i]) {
                    break;
                }
            }
        }
        obj = obj2;
        return obj != null ? C1166l.m5688a(new C1164b(d)) : -1;
    }
}
