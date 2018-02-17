package android.support.v4.p014d.p015a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.v4.d.a.a */
public final class C0326a {
    static final C0318b f679a;

    /* renamed from: android.support.v4.d.a.a.b */
    interface C0318b {
        void m1204a(Drawable drawable);

        void m1205a(Drawable drawable, float f, float f2);

        void m1206a(Drawable drawable, int i);

        void m1207a(Drawable drawable, int i, int i2, int i3, int i4);

        void m1208a(Drawable drawable, ColorStateList colorStateList);

        void m1209a(Drawable drawable, Theme theme);

        void m1210a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);

        void m1211a(Drawable drawable, Mode mode);

        void m1212a(Drawable drawable, boolean z);

        boolean m1213b(Drawable drawable);

        boolean m1214b(Drawable drawable, int i);

        Drawable m1215c(Drawable drawable);

        int m1216d(Drawable drawable);

        int m1217e(Drawable drawable);

        boolean m1218f(Drawable drawable);

        ColorFilter m1219g(Drawable drawable);
    }

    /* renamed from: android.support.v4.d.a.a.a */
    static class C0319a implements C0318b {
        C0319a() {
        }

        public void m1220a(Drawable drawable) {
        }

        public void m1221a(Drawable drawable, float f, float f2) {
        }

        public void m1222a(Drawable drawable, int i) {
            C0328c.m1278a(drawable, i);
        }

        public void m1223a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void m1224a(Drawable drawable, ColorStateList colorStateList) {
            C0328c.m1279a(drawable, colorStateList);
        }

        public void m1225a(Drawable drawable, Theme theme) {
        }

        public void m1226a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0328c.m1280a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        public void m1227a(Drawable drawable, Mode mode) {
            C0328c.m1281a(drawable, mode);
        }

        public void m1228a(Drawable drawable, boolean z) {
        }

        public boolean m1229b(Drawable drawable) {
            return false;
        }

        public boolean m1230b(Drawable drawable, int i) {
            return false;
        }

        public Drawable m1231c(Drawable drawable) {
            return C0328c.m1277a(drawable);
        }

        public int m1232d(Drawable drawable) {
            return 0;
        }

        public int m1233e(Drawable drawable) {
            return 0;
        }

        public boolean m1234f(Drawable drawable) {
            return false;
        }

        public ColorFilter m1235g(Drawable drawable) {
            return null;
        }
    }

    /* renamed from: android.support.v4.d.a.a.c */
    static class C0320c extends C0319a {
        C0320c() {
        }

        public Drawable m1236c(Drawable drawable) {
            return C0329d.m1282a(drawable);
        }
    }

    /* renamed from: android.support.v4.d.a.a.d */
    static class C0321d extends C0320c {
        C0321d() {
        }

        public void m1237a(Drawable drawable) {
            C0330e.m1283a(drawable);
        }

        public Drawable m1238c(Drawable drawable) {
            return C0330e.m1284b(drawable);
        }
    }

    /* renamed from: android.support.v4.d.a.a.e */
    static class C0322e extends C0321d {
        C0322e() {
        }

        public boolean m1239b(Drawable drawable, int i) {
            return C0331f.m1286a(drawable, i);
        }

        public int m1240d(Drawable drawable) {
            int a = C0331f.m1285a(drawable);
            return a >= 0 ? a : 0;
        }
    }

    /* renamed from: android.support.v4.d.a.a.f */
    static class C0323f extends C0322e {
        C0323f() {
        }

        public void m1241a(Drawable drawable, boolean z) {
            C0332g.m1287a(drawable, z);
        }

        public boolean m1242b(Drawable drawable) {
            return C0332g.m1288a(drawable);
        }

        public Drawable m1243c(Drawable drawable) {
            return C0332g.m1289b(drawable);
        }

        public int m1244e(Drawable drawable) {
            return C0332g.m1290c(drawable);
        }
    }

    /* renamed from: android.support.v4.d.a.a.g */
    static class C0324g extends C0323f {
        C0324g() {
        }

        public void m1245a(Drawable drawable, float f, float f2) {
            C0333h.m1292a(drawable, f, f2);
        }

        public void m1246a(Drawable drawable, int i) {
            C0333h.m1293a(drawable, i);
        }

        public void m1247a(Drawable drawable, int i, int i2, int i3, int i4) {
            C0333h.m1294a(drawable, i, i2, i3, i4);
        }

        public void m1248a(Drawable drawable, ColorStateList colorStateList) {
            C0333h.m1295a(drawable, colorStateList);
        }

        public void m1249a(Drawable drawable, Theme theme) {
            C0333h.m1296a(drawable, theme);
        }

        public void m1250a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0333h.m1297a(drawable, resources, xmlPullParser, attributeSet, theme);
        }

        public void m1251a(Drawable drawable, Mode mode) {
            C0333h.m1298a(drawable, mode);
        }

        public Drawable m1252c(Drawable drawable) {
            return C0333h.m1291a(drawable);
        }

        public boolean m1253f(Drawable drawable) {
            return C0333h.m1299b(drawable);
        }

        public ColorFilter m1254g(Drawable drawable) {
            return C0333h.m1300c(drawable);
        }
    }

    /* renamed from: android.support.v4.d.a.a.h */
    static class C0325h extends C0324g {
        C0325h() {
        }

        public boolean m1255b(Drawable drawable, int i) {
            return C0327b.m1276a(drawable, i);
        }

        public Drawable m1256c(Drawable drawable) {
            return drawable;
        }

        public int m1257d(Drawable drawable) {
            return C0327b.m1275a(drawable);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f679a = new C0325h();
        } else if (i >= 21) {
            f679a = new C0324g();
        } else if (i >= 19) {
            f679a = new C0323f();
        } else if (i >= 17) {
            f679a = new C0322e();
        } else if (i >= 11) {
            f679a = new C0321d();
        } else if (i >= 5) {
            f679a = new C0320c();
        } else {
            f679a = new C0319a();
        }
    }

    public static void m1258a(Drawable drawable) {
        f679a.m1204a(drawable);
    }

    public static void m1259a(Drawable drawable, float f, float f2) {
        f679a.m1205a(drawable, f, f2);
    }

    public static void m1260a(Drawable drawable, int i) {
        f679a.m1206a(drawable, i);
    }

    public static void m1261a(Drawable drawable, int i, int i2, int i3, int i4) {
        f679a.m1207a(drawable, i, i2, i3, i4);
    }

    public static void m1262a(Drawable drawable, ColorStateList colorStateList) {
        f679a.m1208a(drawable, colorStateList);
    }

    public static void m1263a(Drawable drawable, Theme theme) {
        f679a.m1209a(drawable, theme);
    }

    public static void m1264a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f679a.m1210a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static void m1265a(Drawable drawable, Mode mode) {
        f679a.m1211a(drawable, mode);
    }

    public static void m1266a(Drawable drawable, boolean z) {
        f679a.m1212a(drawable, z);
    }

    public static boolean m1267b(Drawable drawable) {
        return f679a.m1213b(drawable);
    }

    public static boolean m1268b(Drawable drawable, int i) {
        return f679a.m1214b(drawable, i);
    }

    public static int m1269c(Drawable drawable) {
        return f679a.m1217e(drawable);
    }

    public static boolean m1270d(Drawable drawable) {
        return f679a.m1218f(drawable);
    }

    public static ColorFilter m1271e(Drawable drawable) {
        return f679a.m1219g(drawable);
    }

    public static Drawable m1272f(Drawable drawable) {
        return f679a.m1215c(drawable);
    }

    public static <T extends Drawable> T m1273g(Drawable drawable) {
        return drawable instanceof C0334i ? ((C0334i) drawable).m1301a() : drawable;
    }

    public static int m1274h(Drawable drawable) {
        return f679a.m1216d(drawable);
    }
}
