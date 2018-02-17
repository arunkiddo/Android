package com.p045c.p046a;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.p021b.C0279p;
import android.util.Log;
import android.widget.ImageView;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.p052b.C1073c;
import com.p045c.p046a.p050d.p052b.p053b.C1049h;
import com.p045c.p046a.p050d.p052b.p054a.C1023c;
import com.p045c.p046a.p050d.p052b.p057d.C1077a;
import com.p045c.p046a.p050d.p059c.C1093m;
import com.p045c.p046a.p050d.p059c.C1095l;
import com.p045c.p046a.p050d.p059c.C1126c;
import com.p045c.p046a.p050d.p059c.C1127d;
import com.p045c.p046a.p050d.p059c.C1132g;
import com.p045c.p046a.p050d.p059c.p060a.C1098a.C1094a;
import com.p045c.p046a.p050d.p059c.p060a.C1101c.C1099a;
import com.p045c.p046a.p050d.p059c.p060a.C1104d.C1102a;
import com.p045c.p046a.p050d.p059c.p060a.C1107e.C1105a;
import com.p045c.p046a.p050d.p059c.p061b.C1110a.C1109a;
import com.p045c.p046a.p050d.p059c.p061b.C1113b.C1111a;
import com.p045c.p046a.p050d.p059c.p061b.C1115c.C1114a;
import com.p045c.p046a.p050d.p059c.p061b.C1117e.C1116a;
import com.p045c.p046a.p050d.p059c.p061b.C1119f.C1118a;
import com.p045c.p046a.p050d.p059c.p061b.C1121g.C1120a;
import com.p045c.p046a.p050d.p059c.p061b.C1124h.C1122a;
import com.p045c.p046a.p050d.p062d.p063a.C1148e;
import com.p045c.p046a.p050d.p062d.p063a.C1154g;
import com.p045c.p046a.p050d.p062d.p063a.C1157i;
import com.p045c.p046a.p050d.p062d.p063a.C1160j;
import com.p045c.p046a.p050d.p062d.p063a.C1168n;
import com.p045c.p046a.p050d.p062d.p063a.C1171p;
import com.p045c.p046a.p050d.p062d.p065b.C1159b;
import com.p045c.p046a.p050d.p062d.p066c.C1185d;
import com.p045c.p046a.p050d.p062d.p067d.C1189b;
import com.p045c.p046a.p050d.p062d.p067d.C1190c;
import com.p045c.p046a.p050d.p062d.p070e.C1211a;
import com.p045c.p046a.p050d.p062d.p070e.C1218f;
import com.p045c.p046a.p050d.p062d.p070e.C1219g;
import com.p045c.p046a.p050d.p062d.p071f.C1220c;
import com.p045c.p046a.p050d.p062d.p071f.C1221a;
import com.p045c.p046a.p050d.p062d.p071f.C1222b;
import com.p045c.p046a.p050d.p062d.p071f.C1223d;
import com.p045c.p046a.p055j.C1296h;
import com.p045c.p046a.p058h.C1268b;
import com.p045c.p046a.p058h.p069b.C1195j;
import com.p045c.p046a.p058h.p069b.C1276f;
import com.p045c.p046a.p064g.C1153b;
import com.p045c.p046a.p064g.C1252c;
import com.p045c.p046a.p068e.C1242k;
import com.p045c.p046a.p072f.C1247a;
import com.p045c.p046a.p072f.C1248b;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

/* renamed from: com.c.a.i */
public class C1288i {
    private static volatile C1288i f3223a;
    private final C1126c f3224b;
    private final C1073c f3225c;
    private final C1023c f3226d;
    private final C1049h f3227e;
    private final C1012a f3228f;
    private final C1276f f3229g;
    private final C1223d f3230h;
    private final C1252c f3231i;
    private final C1148e f3232j;
    private final C1218f f3233k;
    private final C1157i f3234l;
    private final C1218f f3235m;
    private final Handler f3236n;
    private final C1077a f3237o;

    C1288i(C1073c c1073c, C1049h c1049h, C1023c c1023c, Context context, C1012a c1012a) {
        this.f3229g = new C1276f();
        this.f3230h = new C1223d();
        this.f3225c = c1073c;
        this.f3226d = c1023c;
        this.f3227e = c1049h;
        this.f3228f = c1012a;
        this.f3224b = new C1126c(context);
        this.f3236n = new Handler(Looper.getMainLooper());
        this.f3237o = new C1077a(c1049h, c1023c, c1012a);
        this.f3231i = new C1252c();
        C1153b c1171p = new C1171p(c1023c, c1012a);
        this.f3231i.m5918a(InputStream.class, Bitmap.class, c1171p);
        C1153b c1154g = new C1154g(c1023c, c1012a);
        this.f3231i.m5918a(ParcelFileDescriptor.class, Bitmap.class, c1154g);
        C1153b c1168n = new C1168n(c1171p, c1154g);
        this.f3231i.m5918a(C1132g.class, Bitmap.class, c1168n);
        c1171p = new C1190c(context, c1023c);
        this.f3231i.m5918a(InputStream.class, C1189b.class, c1171p);
        this.f3231i.m5918a(C1132g.class, C1211a.class, new C1219g(c1168n, c1171p, c1023c));
        this.f3231i.m5918a(InputStream.class, File.class, new C1185d());
        m6083a(File.class, ParcelFileDescriptor.class, new C1094a());
        m6083a(File.class, InputStream.class, new C1114a());
        m6083a(Integer.TYPE, ParcelFileDescriptor.class, new C1099a());
        m6083a(Integer.TYPE, InputStream.class, new C1116a());
        m6083a(Integer.class, ParcelFileDescriptor.class, new C1099a());
        m6083a(Integer.class, InputStream.class, new C1116a());
        m6083a(String.class, ParcelFileDescriptor.class, new C1102a());
        m6083a(String.class, InputStream.class, new C1118a());
        m6083a(Uri.class, ParcelFileDescriptor.class, new C1105a());
        m6083a(Uri.class, InputStream.class, new C1120a());
        m6083a(URL.class, InputStream.class, new C1122a());
        m6083a(C1127d.class, InputStream.class, new C1109a());
        m6083a(byte[].class, InputStream.class, new C1111a());
        this.f3230h.m5848a(Bitmap.class, C1160j.class, new C1222b(context.getResources(), c1023c));
        this.f3230h.m5848a(C1211a.class, C1159b.class, new C1221a(new C1222b(context.getResources(), c1023c)));
        this.f3232j = new C1148e(c1023c);
        this.f3233k = new C1218f(c1023c, this.f3232j);
        this.f3234l = new C1157i(c1023c);
        this.f3235m = new C1218f(c1023c, this.f3234l);
    }

    public static <T> C1095l<T, InputStream> m6071a(Class<T> cls, Context context) {
        return C1288i.m6072a((Class) cls, InputStream.class, context);
    }

    public static <T, Y> C1095l<T, Y> m6072a(Class<T> cls, Class<Y> cls2, Context context) {
        if (cls != null) {
            return C1288i.m6073a(context).m6078i().m5581a(cls, cls2);
        }
        if (Log.isLoggable("Glide", 3)) {
            Log.d("Glide", "Unable to load null model, setting placeholder only");
        }
        return null;
    }

    public static C1288i m6073a(Context context) {
        if (f3223a == null) {
            synchronized (C1288i.class) {
                if (f3223a == null) {
                    Context applicationContext = context.getApplicationContext();
                    List<C1247a> a = new C1248b(applicationContext).m5903a();
                    C1297j c1297j = new C1297j(applicationContext);
                    for (C1247a a2 : a) {
                        a2.m5901a(applicationContext, c1297j);
                    }
                    f3223a = c1297j.m6118a();
                    for (C1247a a22 : a) {
                        a22.m5900a(applicationContext, f3223a);
                    }
                }
            }
        }
        return f3223a;
    }

    public static C1305l m6074a(C0279p c0279p) {
        return C1242k.m5878a().m5887a(c0279p);
    }

    public static void m6075a(C1195j<?> c1195j) {
        C1296h.m6113a();
        C1268b request = c1195j.getRequest();
        if (request != null) {
            request.m5982d();
            c1195j.setRequest(null);
        }
    }

    public static <T> C1095l<T, ParcelFileDescriptor> m6076b(Class<T> cls, Context context) {
        return C1288i.m6072a((Class) cls, ParcelFileDescriptor.class, context);
    }

    public static C1305l m6077b(Context context) {
        return C1242k.m5878a().m5884a(context);
    }

    private C1126c m6078i() {
        return this.f3224b;
    }

    public C1023c m6079a() {
        return this.f3226d;
    }

    <Z, R> C1220c<Z, R> m6080a(Class<Z> cls, Class<R> cls2) {
        return this.f3230h.m5847a(cls, cls2);
    }

    <R> C1195j<R> m6081a(ImageView imageView, Class<R> cls) {
        return this.f3229g.m6029a(imageView, cls);
    }

    public void m6082a(int i) {
        C1296h.m6113a();
        this.f3227e.m5437a(i);
        this.f3226d.m5341a(i);
    }

    public <T, Y> void m6083a(Class<T> cls, Class<Y> cls2, C1093m<T, Y> c1093m) {
        C1093m a = this.f3224b.m5582a((Class) cls, (Class) cls2, (C1093m) c1093m);
        if (a != null) {
            a.m5528a();
        }
    }

    C1073c m6084b() {
        return this.f3225c;
    }

    <T, Z> C1153b<T, Z> m6085b(Class<T> cls, Class<Z> cls2) {
        return this.f3231i.m5917a(cls, cls2);
    }

    C1148e m6086c() {
        return this.f3232j;
    }

    C1157i m6087d() {
        return this.f3234l;
    }

    C1218f m6088e() {
        return this.f3233k;
    }

    C1218f m6089f() {
        return this.f3235m;
    }

    C1012a m6090g() {
        return this.f3228f;
    }

    public void m6091h() {
        C1296h.m6113a();
        this.f3227e.m5436a();
        this.f3226d.m5340a();
    }
}
