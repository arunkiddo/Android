package com.p045c.p046a.p050d.p059c;

import android.text.TextUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.c.a.d.c.j */
public final class C1137j implements C1128e {
    private final Map<String, List<C1134i>> f2931c;
    private volatile Map<String, String> f2932d;

    /* renamed from: com.c.a.d.c.j.a */
    public static final class C1135a {
        private static final String f2924a;
        private static final Map<String, List<C1134i>> f2925b;
        private boolean f2926c;
        private Map<String, List<C1134i>> f2927d;
        private boolean f2928e;
        private boolean f2929f;

        static {
            f2924a = System.getProperty("http.agent");
            Map hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(f2924a)) {
                hashMap.put("User-Agent", Collections.singletonList(new C1136b(f2924a)));
            }
            hashMap.put("Accept-Encoding", Collections.singletonList(new C1136b("identity")));
            f2925b = Collections.unmodifiableMap(hashMap);
        }

        public C1135a() {
            this.f2926c = true;
            this.f2927d = f2925b;
            this.f2928e = true;
            this.f2929f = true;
        }

        public C1137j m5602a() {
            this.f2926c = true;
            return new C1137j(this.f2927d);
        }
    }

    /* renamed from: com.c.a.d.c.j.b */
    static final class C1136b implements C1134i {
        private final String f2930a;

        C1136b(String str) {
            this.f2930a = str;
        }

        public String m5603a() {
            return this.f2930a;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C1136b)) {
                return false;
            }
            return this.f2930a.equals(((C1136b) obj).f2930a);
        }

        public int hashCode() {
            return this.f2930a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f2930a + '\'' + '}';
        }
    }

    C1137j(Map<String, List<C1134i>> map) {
        this.f2931c = Collections.unmodifiableMap(map);
    }

    private Map<String, String> m5604b() {
        Map<String, String> hashMap = new HashMap();
        for (Entry entry : this.f2931c.entrySet()) {
            StringBuilder stringBuilder = new StringBuilder();
            List list = (List) entry.getValue();
            for (int i = 0; i < list.size(); i++) {
                stringBuilder.append(((C1134i) list.get(i)).m5601a());
                if (i != list.size() - 1) {
                    stringBuilder.append(',');
                }
            }
            hashMap.put(entry.getKey(), stringBuilder.toString());
        }
        return hashMap;
    }

    public Map<String, String> m5605a() {
        if (this.f2932d == null) {
            synchronized (this) {
                if (this.f2932d == null) {
                    this.f2932d = Collections.unmodifiableMap(m5604b());
                }
            }
        }
        return this.f2932d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1137j)) {
            return false;
        }
        return this.f2931c.equals(((C1137j) obj).f2931c);
    }

    public int hashCode() {
        return this.f2931c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.f2931c + '}';
    }
}
