package com.p045c.p046a.p050d.p059c;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.util.Log;
import com.p045c.p046a.p050d.p051a.C1000c;

/* renamed from: com.c.a.d.c.n */
public class C1100n<T> implements C1095l<Integer, T> {
    private final C1095l<Uri, T> f2894a;
    private final Resources f2895b;

    public C1100n(Context context, C1095l<Uri, T> c1095l) {
        this(context.getResources(), (C1095l) c1095l);
    }

    public C1100n(Resources resources, C1095l<Uri, T> c1095l) {
        this.f2895b = resources;
        this.f2894a = c1095l;
    }

    public C1000c<T> m5536a(Integer num, int i, int i2) {
        Object parse;
        try {
            parse = Uri.parse("android.resource://" + this.f2895b.getResourcePackageName(num.intValue()) + '/' + this.f2895b.getResourceTypeName(num.intValue()) + '/' + this.f2895b.getResourceEntryName(num.intValue()));
        } catch (Throwable e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            parse = null;
        }
        return parse != null ? this.f2894a.m5531a(parse, i, i2) : null;
    }
}
