package com.p045c.p046a.p068e;

import android.content.Context;
import com.p045c.p046a.p068e.C1232c.C1231a;

/* renamed from: com.c.a.e.d */
public class C1233d {
    public C1232c m5864a(Context context, C1231a c1231a) {
        return (context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0 ? 1 : null) != null ? new C1235e(context, c1231a) : new C1238i();
    }
}
