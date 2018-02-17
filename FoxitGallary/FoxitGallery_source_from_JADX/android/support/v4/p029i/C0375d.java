package android.support.v4.p029i;

import android.os.Build.VERSION;
import com.simplemobiletools.gallery.BuildConfig;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.Locale;

/* renamed from: android.support.v4.i.d */
public final class C0375d {
    public static final Locale f706a;
    private static final C0373a f707b;
    private static String f708c;
    private static String f709d;

    /* renamed from: android.support.v4.i.d.a */
    private static class C0373a {
        private C0373a() {
        }

        private static int m1379b(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case C1373c.View_android_focusable /*1*/:
                case C1373c.View_paddingStart /*2*/:
                    return 1;
                default:
                    return 0;
            }
        }

        public int m1380a(Locale locale) {
            if (!(locale == null || locale.equals(C0375d.f706a))) {
                String a = C0369a.m1374a(locale);
                if (a == null) {
                    return C0373a.m1379b(locale);
                }
                if (a.equalsIgnoreCase(C0375d.f708c) || a.equalsIgnoreCase(C0375d.f709d)) {
                    return 1;
                }
            }
            return 0;
        }
    }

    /* renamed from: android.support.v4.i.d.b */
    private static class C0374b extends C0373a {
        private C0374b() {
            super();
        }

        public int m1381a(Locale locale) {
            return C0376e.m1385a(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f707b = new C0374b();
        } else {
            f707b = new C0373a();
        }
        f706a = new Locale(BuildConfig.FLAVOR, BuildConfig.FLAVOR);
        f708c = "Arab";
        f709d = "Hebr";
    }

    public static int m1382a(Locale locale) {
        return f707b.m1380a(locale);
    }
}
