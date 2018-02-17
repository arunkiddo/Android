package com.p045c.p046a.p050d.p059c.p060a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1100n;
import com.p045c.p046a.p050d.p059c.C1126c;

/* renamed from: com.c.a.d.c.a.c */
public class C1101c extends C1100n<ParcelFileDescriptor> implements C1097b<Integer> {

    /* renamed from: com.c.a.d.c.a.c.a */
    public static class C1099a implements C1093m<Integer, ParcelFileDescriptor> {
        public C1095l<Integer, ParcelFileDescriptor> m5534a(Context context, C1126c c1126c) {
            return new C1101c(context, c1126c.m5581a(Uri.class, ParcelFileDescriptor.class));
        }

        public void m5535a() {
        }
    }

    public C1101c(Context context, C1095l<Uri, ParcelFileDescriptor> c1095l) {
        super(context, (C1095l) c1095l);
    }
}
