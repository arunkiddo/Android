package com.p045c.p046a.p050d.p051a;

import android.content.res.AssetManager;
import android.os.ParcelFileDescriptor;

/* renamed from: com.c.a.d.a.d */
public class C1003d extends C1001a<ParcelFileDescriptor> {
    public C1003d(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    protected /* synthetic */ Object m5280a(AssetManager assetManager, String str) {
        return m5283b(assetManager, str);
    }

    protected void m5281a(ParcelFileDescriptor parcelFileDescriptor) {
        parcelFileDescriptor.close();
    }

    protected ParcelFileDescriptor m5283b(AssetManager assetManager, String str) {
        return assetManager.openFd(str).getParcelFileDescriptor();
    }
}
