package com.p045c.p046a.p050d.p052b.p054a;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.p045c.p046a.p055j.C1296h;
import com.simplemobiletools.gallery.BuildConfig;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

@TargetApi(19)
/* renamed from: com.c.a.d.b.a.i */
public class C1034i implements C1021g {
    private static final Config[] f2760a;
    private static final Config[] f2761b;
    private static final Config[] f2762c;
    private static final Config[] f2763d;
    private final C1033b f2764e;
    private final C1026e<C1032a, Bitmap> f2765f;
    private final Map<Config, NavigableMap<Integer, Integer>> f2766g;

    /* renamed from: com.c.a.d.b.a.i.1 */
    static /* synthetic */ class C10311 {
        static final /* synthetic */ int[] f2756a;

        static {
            f2756a = new int[Config.values().length];
            try {
                f2756a[Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2756a[Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2756a[Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2756a[Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* renamed from: com.c.a.d.b.a.i.a */
    static final class C1032a implements C1017h {
        private final C1033b f2757a;
        private int f2758b;
        private Config f2759c;

        public C1032a(C1033b c1033b) {
            this.f2757a = c1033b;
        }

        public void m5376a() {
            this.f2757a.m5318a(this);
        }

        public void m5377a(int i, Config config) {
            this.f2758b = i;
            this.f2759c = config;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1032a)) {
                return false;
            }
            C1032a c1032a = (C1032a) obj;
            if (this.f2758b != c1032a.f2758b) {
                return false;
            }
            if (this.f2759c == null) {
                if (c1032a.f2759c != null) {
                    return false;
                }
            } else if (!this.f2759c.equals(c1032a.f2759c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.f2759c != null ? this.f2759c.hashCode() : 0) + (this.f2758b * 31);
        }

        public String toString() {
            return C1034i.m5385b(this.f2758b, this.f2759c);
        }
    }

    /* renamed from: com.c.a.d.b.a.i.b */
    static class C1033b extends C1019b<C1032a> {
        C1033b() {
        }

        protected C1032a m5378a() {
            return new C1032a(this);
        }

        public C1032a m5379a(int i, Config config) {
            C1032a c1032a = (C1032a) m5320c();
            c1032a.m5377a(i, config);
            return c1032a;
        }

        protected /* synthetic */ C1017h m5380b() {
            return m5378a();
        }
    }

    static {
        f2760a = new Config[]{Config.ARGB_8888, null};
        f2761b = new Config[]{Config.RGB_565};
        f2762c = new Config[]{Config.ARGB_4444};
        f2763d = new Config[]{Config.ALPHA_8};
    }

    public C1034i() {
        this.f2764e = new C1033b();
        this.f2765f = new C1026e();
        this.f2766g = new HashMap();
    }

    private C1032a m5381a(C1032a c1032a, int i, Config config) {
        Config[] b = C1034i.m5386b(config);
        int length = b.length;
        int i2 = 0;
        while (i2 < length) {
            Config config2 = b[i2];
            Integer num = (Integer) m5383a(config2).ceilingKey(Integer.valueOf(i));
            if (num == null || num.intValue() > i * 8) {
                i2++;
            } else {
                if (num.intValue() == i) {
                    if (config2 == null) {
                        if (config == null) {
                            return c1032a;
                        }
                    } else if (config2.equals(config)) {
                        return c1032a;
                    }
                }
                this.f2764e.m5318a(c1032a);
                return this.f2764e.m5379a(num.intValue(), config2);
            }
        }
        return c1032a;
    }

    private NavigableMap<Integer, Integer> m5383a(Config config) {
        NavigableMap<Integer, Integer> navigableMap = (NavigableMap) this.f2766g.get(config);
        if (navigableMap != null) {
            return navigableMap;
        }
        NavigableMap treeMap = new TreeMap();
        this.f2766g.put(config, treeMap);
        return treeMap;
    }

    private void m5384a(Integer num, Config config) {
        NavigableMap a = m5383a(config);
        Integer num2 = (Integer) a.get(num);
        if (num2.intValue() == 1) {
            a.remove(num);
        } else {
            a.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    private static String m5385b(int i, Config config) {
        return "[" + i + "](" + config + ")";
    }

    private static Config[] m5386b(Config config) {
        switch (C10311.f2756a[config.ordinal()]) {
            case C1373c.View_android_focusable /*1*/:
                return f2760a;
            case C1373c.View_paddingStart /*2*/:
                return f2761b;
            case C1373c.View_paddingEnd /*3*/:
                return f2762c;
            case C1373c.View_theme /*4*/:
                return f2763d;
            default:
                return new Config[]{config};
        }
    }

    public Bitmap m5387a() {
        Bitmap bitmap = (Bitmap) this.f2765f.m5357a();
        if (bitmap != null) {
            m5384a(Integer.valueOf(C1296h.m6108a(bitmap)), bitmap.getConfig());
        }
        return bitmap;
    }

    public Bitmap m5388a(int i, int i2, Config config) {
        int a = C1296h.m6106a(i, i2, config);
        Bitmap bitmap = (Bitmap) this.f2765f.m5358a(m5381a(this.f2764e.m5379a(a, config), a, config));
        if (bitmap != null) {
            m5384a(Integer.valueOf(C1296h.m6108a(bitmap)), bitmap.getConfig());
            bitmap.reconfigure(i, i2, bitmap.getConfig() != null ? bitmap.getConfig() : Config.ARGB_8888);
        }
        return bitmap;
    }

    public void m5389a(Bitmap bitmap) {
        C1032a a = this.f2764e.m5379a(C1296h.m6108a(bitmap), bitmap.getConfig());
        this.f2765f.m5359a(a, bitmap);
        NavigableMap a2 = m5383a(bitmap.getConfig());
        Integer num = (Integer) a2.get(Integer.valueOf(a.f2758b));
        a2.put(Integer.valueOf(a.f2758b), Integer.valueOf(num == null ? 1 : num.intValue() + 1));
    }

    public String m5390b(int i, int i2, Config config) {
        return C1034i.m5385b(C1296h.m6106a(i, i2, config), config);
    }

    public String m5391b(Bitmap bitmap) {
        return C1034i.m5385b(C1296h.m6108a(bitmap), bitmap.getConfig());
    }

    public int m5392c(Bitmap bitmap) {
        return C1296h.m6108a(bitmap);
    }

    public String toString() {
        StringBuilder append = new StringBuilder().append("SizeConfigStrategy{groupedMap=").append(this.f2765f).append(", sortedSizes=(");
        for (Entry entry : this.f2766g.entrySet()) {
            append.append(entry.getKey()).append('[').append(entry.getValue()).append("], ");
        }
        if (!this.f2766g.isEmpty()) {
            append.replace(append.length() - 2, append.length(), BuildConfig.FLAVOR);
        }
        return append.append(")}").toString();
    }
}
