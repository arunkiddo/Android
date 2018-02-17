package com.p045c.p046a.p050d.p052b.p053b;

import android.content.Context;
import com.p045c.p046a.p050d.p052b.p053b.C1044d.C1043a;
import java.io.File;

/* renamed from: com.c.a.d.b.b.f */
public final class C1047f extends C1044d {

    /* renamed from: com.c.a.d.b.b.f.1 */
    class C10461 implements C1043a {
        final /* synthetic */ Context f2793a;
        final /* synthetic */ String f2794b;

        C10461(Context context, String str) {
            this.f2793a = context;
            this.f2794b = str;
        }

        public File m5425a() {
            File cacheDir = this.f2793a.getCacheDir();
            return cacheDir == null ? null : this.f2794b != null ? new File(cacheDir, this.f2794b) : cacheDir;
        }
    }

    public C1047f(Context context) {
        this(context, "image_manager_disk_cache", 262144000);
    }

    public C1047f(Context context, String str, int i) {
        super(new C10461(context, str), i);
    }
}
