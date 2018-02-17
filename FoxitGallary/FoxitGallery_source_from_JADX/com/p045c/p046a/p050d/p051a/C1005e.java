package com.p045c.p046a.p050d.p051a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

/* renamed from: com.c.a.d.a.e */
public class C1005e extends C1004g<ParcelFileDescriptor> {
    public C1005e(Context context, Uri uri) {
        super(context, uri);
    }

    protected ParcelFileDescriptor m5290a(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openAssetFileDescriptor(uri, "r").getParcelFileDescriptor();
    }

    protected void m5291a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    protected /* synthetic */ Object m5293b(Uri uri, ContentResolver contentResolver) {
        return m5290a(uri, contentResolver);
    }
}
