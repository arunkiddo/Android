package com.p045c.p046a.p050d.p059c.p060a;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1096b;
import com.p045c.p046a.p050d.p059c.C1126c;
import java.io.File;

/* renamed from: com.c.a.d.c.a.a */
public class C1098a extends C1096b<ParcelFileDescriptor> implements C1097b<File> {

    /* renamed from: com.c.a.d.c.a.a.a */
    public static class C1094a implements C1093m<File, ParcelFileDescriptor> {
        public C1095l<File, ParcelFileDescriptor> m5529a(Context context, C1126c c1126c) {
            return new C1098a(c1126c.m5581a(Uri.class, ParcelFileDescriptor.class));
        }

        public void m5530a() {
        }
    }

    public C1098a(C1095l<Uri, ParcelFileDescriptor> c1095l) {
        super(c1095l);
    }
}
