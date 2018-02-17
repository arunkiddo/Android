package com.p045c.p046a.p050d.p059c.p060a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1103p;
import com.p045c.p046a.p050d.p059c.C1126c;

/* renamed from: com.c.a.d.c.a.d */
public class C1104d extends C1103p<ParcelFileDescriptor> implements C1097b<String> {

    /* renamed from: com.c.a.d.c.a.d.a */
    public static class C1102a implements C1093m<String, ParcelFileDescriptor> {
        public C1095l<String, ParcelFileDescriptor> m5538a(Context context, C1126c c1126c) {
            return new C1104d(c1126c.m5581a(Uri.class, ParcelFileDescriptor.class));
        }

        public void m5539a() {
        }
    }

    public C1104d(C1095l<Uri, ParcelFileDescriptor> c1095l) {
        super(c1095l);
    }
}
