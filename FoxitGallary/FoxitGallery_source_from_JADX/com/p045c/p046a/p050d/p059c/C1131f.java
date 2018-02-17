package com.p045c.p046a.p050d.p059c;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.p045c.p046a.C1298k;
import com.p045c.p046a.p050d.p051a.C1000c;
import java.io.InputStream;

/* renamed from: com.c.a.d.c.f */
public class C1131f<A> implements C1095l<A, C1132g> {
    private final C1095l<A, InputStream> f2917a;
    private final C1095l<A, ParcelFileDescriptor> f2918b;

    /* renamed from: com.c.a.d.c.f.a */
    static class C1130a implements C1000c<C1132g> {
        private final C1000c<InputStream> f2915a;
        private final C1000c<ParcelFileDescriptor> f2916b;

        public C1130a(C1000c<InputStream> c1000c, C1000c<ParcelFileDescriptor> c1000c2) {
            this.f2915a = c1000c;
            this.f2916b = c1000c2;
        }

        public /* synthetic */ Object m5590a(C1298k c1298k) {
            return m5592b(c1298k);
        }

        public void m5591a() {
            if (this.f2915a != null) {
                this.f2915a.m5266a();
            }
            if (this.f2916b != null) {
                this.f2916b.m5266a();
            }
        }

        public C1132g m5592b(C1298k c1298k) {
            InputStream inputStream;
            ParcelFileDescriptor parcelFileDescriptor = null;
            if (this.f2915a != null) {
                try {
                    inputStream = (InputStream) this.f2915a.m5265a(c1298k);
                } catch (Throwable e) {
                    if (Log.isLoggable("IVML", 2)) {
                        Log.v("IVML", "Exception fetching input stream, trying ParcelFileDescriptor", e);
                    }
                    if (this.f2916b == null) {
                        throw e;
                    }
                }
                if (this.f2916b != null) {
                    try {
                        parcelFileDescriptor = (ParcelFileDescriptor) this.f2916b.m5265a(c1298k);
                    } catch (Throwable e2) {
                        if (Log.isLoggable("IVML", 2)) {
                            Log.v("IVML", "Exception fetching ParcelFileDescriptor", e2);
                        }
                        if (inputStream == null) {
                            throw e2;
                        }
                    }
                }
                return new C1132g(inputStream, parcelFileDescriptor);
            }
            inputStream = null;
            if (this.f2916b != null) {
                parcelFileDescriptor = (ParcelFileDescriptor) this.f2916b.m5265a(c1298k);
            }
            return new C1132g(inputStream, parcelFileDescriptor);
        }

        public String m5593b() {
            return this.f2915a != null ? this.f2915a.m5267b() : this.f2916b.m5267b();
        }

        public void m5594c() {
            if (this.f2915a != null) {
                this.f2915a.m5268c();
            }
            if (this.f2916b != null) {
                this.f2916b.m5268c();
            }
        }
    }

    public C1131f(C1095l<A, InputStream> c1095l, C1095l<A, ParcelFileDescriptor> c1095l2) {
        if (c1095l == null && c1095l2 == null) {
            throw new NullPointerException("At least one of streamLoader and fileDescriptorLoader must be non null");
        }
        this.f2917a = c1095l;
        this.f2918b = c1095l2;
    }

    public C1000c<C1132g> m5595a(A a, int i, int i2) {
        C1000c a2 = this.f2917a != null ? this.f2917a.m5531a(a, i, i2) : null;
        C1000c a3 = this.f2918b != null ? this.f2918b.m5531a(a, i, i2) : null;
        return (a2 == null && a3 == null) ? null : new C1130a(a2, a3);
    }
}
