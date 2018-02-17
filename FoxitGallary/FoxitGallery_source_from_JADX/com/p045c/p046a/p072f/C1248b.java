package com.p045c.p046a.p072f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.c.a.f.b */
public final class C1248b {
    private final Context f3131a;

    public C1248b(Context context) {
        this.f3131a = context;
    }

    private static C1247a m5902a(String str) {
        try {
            Object newInstance;
            try {
                newInstance = Class.forName(str).newInstance();
                if (newInstance instanceof C1247a) {
                    return (C1247a) newInstance;
                }
                throw new RuntimeException("Expected instanceof GlideModule, but found: " + newInstance);
            } catch (Throwable e) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e);
            } catch (Throwable e2) {
                throw new RuntimeException("Unable to instantiate GlideModule implementation for " + newInstance, e2);
            }
        } catch (Throwable e3) {
            throw new IllegalArgumentException("Unable to find GlideModule implementation", e3);
        }
    }

    public List<C1247a> m5903a() {
        List<C1247a> arrayList = new ArrayList();
        try {
            ApplicationInfo applicationInfo = this.f3131a.getPackageManager().getApplicationInfo(this.f3131a.getPackageName(), 128);
            if (applicationInfo.metaData != null) {
                for (String str : applicationInfo.metaData.keySet()) {
                    if ("GlideModule".equals(applicationInfo.metaData.get(str))) {
                        arrayList.add(C1248b.m5902a(str));
                    }
                }
            }
            return arrayList;
        } catch (Throwable e) {
            throw new RuntimeException("Unable to find metadata to parse GlideModules", e);
        }
    }
}
