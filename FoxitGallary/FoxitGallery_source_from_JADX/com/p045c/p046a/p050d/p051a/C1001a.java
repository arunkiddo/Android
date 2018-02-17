package com.p045c.p046a.p050d.p051a;

import android.content.res.AssetManager;
import android.util.Log;
import com.p045c.p046a.C1298k;

/* renamed from: com.c.a.d.a.a */
public abstract class C1001a<T> implements C1000c<T> {
    private final String f2710a;
    private final AssetManager f2711b;
    private T f2712c;

    public C1001a(AssetManager assetManager, String str) {
        this.f2711b = assetManager;
        this.f2710a = str;
    }

    protected abstract T m5269a(AssetManager assetManager, String str);

    public T m5270a(C1298k c1298k) {
        this.f2712c = m5269a(this.f2711b, this.f2710a);
        return this.f2712c;
    }

    public void m5271a() {
        if (this.f2712c != null) {
            try {
                m5272a(this.f2712c);
            } catch (Throwable e) {
                if (Log.isLoggable("AssetUriFetcher", 2)) {
                    Log.v("AssetUriFetcher", "Failed to close data", e);
                }
            }
        }
    }

    protected abstract void m5272a(T t);

    public String m5273b() {
        return this.f2710a;
    }

    public void m5274c() {
    }
}
