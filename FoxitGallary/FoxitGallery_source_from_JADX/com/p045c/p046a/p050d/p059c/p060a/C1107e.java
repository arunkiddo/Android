package com.p045c.p046a.p050d.p059c.p060a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.p050d.p051a.C1000c;
import com.p045c.p046a.p050d.p051a.C1003d;
import com.p045c.p046a.p050d.p051a.C1005e;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1106q;
import com.p045c.p046a.p050d.p059c.C1126c;
import com.p045c.p046a.p050d.p059c.C1127d;

/* renamed from: com.c.a.d.c.a.e */
public class C1107e extends C1106q<ParcelFileDescriptor> implements C1097b<Uri> {

    /* renamed from: com.c.a.d.c.a.e.a */
    public static class C1105a implements C1093m<Uri, ParcelFileDescriptor> {
        public C1095l<Uri, ParcelFileDescriptor> m5543a(Context context, C1126c c1126c) {
            return new C1107e(context, c1126c.m5581a(C1127d.class, ParcelFileDescriptor.class));
        }

        public void m5544a() {
        }
    }

    public C1107e(Context context, C1095l<C1127d, ParcelFileDescriptor> c1095l) {
        super(context, c1095l);
    }

    protected C1000c<ParcelFileDescriptor> m5550a(Context context, Uri uri) {
        return new C1005e(context, uri);
    }

    protected C1000c<ParcelFileDescriptor> m5551a(Context context, String str) {
        return new C1003d(context.getApplicationContext().getAssets(), str);
    }
}
