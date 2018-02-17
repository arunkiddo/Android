package android.support.v4.p016k.p031a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p016k.p031a.C0432i.C0423a;
import android.support.v4.p016k.p031a.C0434j.C0427a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.k.a.h */
public class C0430h {
    private static final C0422a f770a;
    private final Object f771b;

    /* renamed from: android.support.v4.k.a.h.a */
    interface C0422a {
        Object m1620a(C0430h c0430h);
    }

    /* renamed from: android.support.v4.k.a.h.d */
    static class C0425d implements C0422a {
        C0425d() {
        }

        public Object m1627a(C0430h c0430h) {
            return null;
        }
    }

    /* renamed from: android.support.v4.k.a.h.b */
    private static class C0426b extends C0425d {

        /* renamed from: android.support.v4.k.a.h.b.1 */
        class C04241 implements C0423a {
            final /* synthetic */ C0430h f766a;
            final /* synthetic */ C0426b f767b;

            C04241(C0426b c0426b, C0430h c0430h) {
                this.f767b = c0426b;
                this.f766a = c0430h;
            }

            public Object m1624a(int i) {
                C0416c a = this.f766a.m1638a(i);
                return a == null ? null : a.m1569a();
            }

            public List<Object> m1625a(String str, int i) {
                List a = this.f766a.m1640a(str, i);
                if (a == null) {
                    return null;
                }
                List<Object> arrayList = new ArrayList();
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(((C0416c) a.get(i2)).m1569a());
                }
                return arrayList;
            }

            public boolean m1626a(int i, int i2, Bundle bundle) {
                return this.f766a.m1641a(i, i2, bundle);
            }
        }

        private C0426b() {
        }

        public Object m1628a(C0430h c0430h) {
            return C0432i.m1643a(new C04241(this, c0430h));
        }
    }

    /* renamed from: android.support.v4.k.a.h.c */
    private static class C0429c extends C0425d {

        /* renamed from: android.support.v4.k.a.h.c.1 */
        class C04281 implements C0427a {
            final /* synthetic */ C0430h f768a;
            final /* synthetic */ C0429c f769b;

            C04281(C0429c c0429c, C0430h c0430h) {
                this.f769b = c0429c;
                this.f768a = c0430h;
            }

            public Object m1633a(int i) {
                C0416c a = this.f768a.m1638a(i);
                return a == null ? null : a.m1569a();
            }

            public List<Object> m1634a(String str, int i) {
                List a = this.f768a.m1640a(str, i);
                if (a == null) {
                    return null;
                }
                List<Object> arrayList = new ArrayList();
                int size = a.size();
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(((C0416c) a.get(i2)).m1569a());
                }
                return arrayList;
            }

            public boolean m1635a(int i, int i2, Bundle bundle) {
                return this.f768a.m1641a(i, i2, bundle);
            }

            public Object m1636b(int i) {
                C0416c b = this.f768a.m1642b(i);
                return b == null ? null : b.m1569a();
            }
        }

        private C0429c() {
        }

        public Object m1637a(C0430h c0430h) {
            return C0434j.m1644a(new C04281(this, c0430h));
        }
    }

    static {
        if (VERSION.SDK_INT >= 19) {
            f770a = new C0429c();
        } else if (VERSION.SDK_INT >= 16) {
            f770a = new C0426b();
        } else {
            f770a = new C0425d();
        }
    }

    public C0430h() {
        this.f771b = f770a.m1620a(this);
    }

    public C0430h(Object obj) {
        this.f771b = obj;
    }

    public C0416c m1638a(int i) {
        return null;
    }

    public Object m1639a() {
        return this.f771b;
    }

    public List<C0416c> m1640a(String str, int i) {
        return null;
    }

    public boolean m1641a(int i, int i2, Bundle bundle) {
        return false;
    }

    public C0416c m1642b(int i) {
        return null;
    }
}
