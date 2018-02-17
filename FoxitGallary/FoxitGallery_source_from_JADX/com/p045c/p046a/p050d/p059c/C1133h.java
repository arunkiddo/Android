package com.p045c.p046a.p050d.p059c;

import android.os.ParcelFileDescriptor;
import com.p045c.p046a.p050d.C1092b;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.c.a.d.c.h */
public class C1133h implements C1092b<C1132g> {
    private final C1092b<InputStream> f2921a;
    private final C1092b<ParcelFileDescriptor> f2922b;
    private String f2923c;

    public C1133h(C1092b<InputStream> c1092b, C1092b<ParcelFileDescriptor> c1092b2) {
        this.f2921a = c1092b;
        this.f2922b = c1092b2;
    }

    public String m5598a() {
        if (this.f2923c == null) {
            this.f2923c = this.f2921a.m5525a() + this.f2922b.m5525a();
        }
        return this.f2923c;
    }

    public boolean m5599a(C1132g c1132g, OutputStream outputStream) {
        return c1132g.m5596a() != null ? this.f2921a.m5526a(c1132g.m5596a(), outputStream) : this.f2922b.m5526a(c1132g.m5597b(), outputStream);
    }
}
