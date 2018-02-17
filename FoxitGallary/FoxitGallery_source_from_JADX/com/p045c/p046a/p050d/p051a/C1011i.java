package com.p045c.p046a.p050d.p051a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import java.io.InputStream;

/* renamed from: com.c.a.d.a.i */
public class C1011i extends C1004g<InputStream> {
    public C1011i(Context context, Uri uri) {
        super(context, uri);
    }

    protected InputStream m5307a(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openInputStream(uri);
    }

    protected void m5308a(InputStream inputStream) {
        inputStream.close();
    }

    protected /* synthetic */ Object m5310b(Uri uri, ContentResolver contentResolver) {
        return m5307a(uri, contentResolver);
    }
}
