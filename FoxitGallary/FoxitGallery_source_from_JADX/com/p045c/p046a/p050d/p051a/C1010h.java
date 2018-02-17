package com.p045c.p046a.p050d.p051a;

import android.content.res.AssetManager;
import java.io.InputStream;

/* renamed from: com.c.a.d.a.h */
public class C1010h extends C1001a<InputStream> {
    public C1010h(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    protected /* synthetic */ Object m5303a(AssetManager assetManager, String str) {
        return m5306b(assetManager, str);
    }

    protected void m5304a(InputStream inputStream) {
        inputStream.close();
    }

    protected InputStream m5306b(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
