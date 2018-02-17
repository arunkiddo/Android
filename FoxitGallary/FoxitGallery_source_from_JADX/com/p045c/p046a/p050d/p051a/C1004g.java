package com.p045c.p046a.p050d.p051a;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.p045c.p046a.C1298k;

/* renamed from: com.c.a.d.a.g */
public abstract class C1004g<T> implements C1000c<T> {
    private final Uri f2715a;
    private final Context f2716b;
    private T f2717c;

    public C1004g(Context context, Uri uri) {
        this.f2716b = context.getApplicationContext();
        this.f2715a = uri;
    }

    public final T m5284a(C1298k c1298k) {
        this.f2717c = m5287b(this.f2715a, this.f2716b.getContentResolver());
        return this.f2717c;
    }

    public void m5285a() {
        if (this.f2717c != null) {
            try {
                m5286a(this.f2717c);
            } catch (Throwable e) {
                if (Log.isLoggable("LocalUriFetcher", 2)) {
                    Log.v("LocalUriFetcher", "failed to close data", e);
                }
            }
        }
    }

    protected abstract void m5286a(T t);

    protected abstract T m5287b(Uri uri, ContentResolver contentResolver);

    public String m5288b() {
        return this.f2715a.toString();
    }

    public void m5289c() {
    }
}
