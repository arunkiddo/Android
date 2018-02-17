package android.support.v4.p016k;

import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.os.Build.VERSION;
import android.support.v4.p017g.C0354c;
import android.view.View;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.util.WeakHashMap;

/* renamed from: android.support.v4.k.ah */
public class ah {
    static final C0446n f782a;

    /* renamed from: android.support.v4.k.ah.n */
    interface C0446n {
        boolean m1698A(View view);

        boolean m1699B(View view);

        ColorStateList m1700C(View view);

        Mode m1701D(View view);

        void m1702E(View view);

        boolean m1703F(View view);

        float m1704G(View view);

        boolean m1705H(View view);

        boolean m1706I(View view);

        int m1707a(int i, int i2);

        int m1708a(int i, int i2, int i3);

        int m1709a(View view);

        bg m1710a(View view, bg bgVar);

        void m1711a(View view, float f);

        void m1712a(View view, int i, int i2);

        void m1713a(View view, int i, int i2, int i3, int i4);

        void m1714a(View view, int i, Paint paint);

        void m1715a(View view, ColorStateList colorStateList);

        void m1716a(View view, Mode mode);

        void m1717a(View view, ab abVar);

        void m1718a(View view, C0473b c0473b);

        void m1719a(View view, Runnable runnable);

        void m1720a(View view, Runnable runnable, long j);

        void m1721a(View view, boolean z);

        void m1722a(ViewGroup viewGroup, boolean z);

        boolean m1723a(View view, int i);

        bg m1724b(View view, bg bgVar);

        void m1725b(View view, float f);

        void m1726b(View view, boolean z);

        boolean m1727b(View view);

        boolean m1728b(View view, int i);

        void m1729c(View view, float f);

        void m1730c(View view, int i);

        void m1731c(View view, boolean z);

        boolean m1732c(View view);

        void m1733d(View view);

        void m1734d(View view, float f);

        void m1735d(View view, int i);

        int m1736e(View view);

        void m1737e(View view, float f);

        void m1738e(View view, int i);

        float m1739f(View view);

        void m1740f(View view, float f);

        void m1741f(View view, int i);

        int m1742g(View view);

        int m1743h(View view);

        int m1744i(View view);

        int m1745j(View view);

        int m1746k(View view);

        int m1747l(View view);

        boolean m1748m(View view);

        float m1749n(View view);

        float m1750o(View view);

        float m1751p(View view);

        Matrix m1752q(View view);

        int m1753r(View view);

        int m1754s(View view);

        az m1755t(View view);

        int m1756u(View view);

        void m1757v(View view);

        boolean m1758y(View view);

        void m1759z(View view);
    }

    /* renamed from: android.support.v4.k.ah.b */
    static class C0447b implements C0446n {
        WeakHashMap<View, az> f779a;

        C0447b() {
            this.f779a = null;
        }

        private boolean m1760a(ad adVar, int i) {
            int computeHorizontalScrollOffset = adVar.computeHorizontalScrollOffset();
            int computeHorizontalScrollRange = adVar.computeHorizontalScrollRange() - adVar.computeHorizontalScrollExtent();
            return computeHorizontalScrollRange == 0 ? false : i < 0 ? computeHorizontalScrollOffset > 0 : computeHorizontalScrollOffset < computeHorizontalScrollRange + -1;
        }

        private boolean m1761b(ad adVar, int i) {
            int computeVerticalScrollOffset = adVar.computeVerticalScrollOffset();
            int computeVerticalScrollRange = adVar.computeVerticalScrollRange() - adVar.computeVerticalScrollExtent();
            return computeVerticalScrollRange == 0 ? false : i < 0 ? computeVerticalScrollOffset > 0 : computeVerticalScrollOffset < computeVerticalScrollRange + -1;
        }

        public boolean m1762A(View view) {
            return false;
        }

        public boolean m1763B(View view) {
            return view instanceof C0113x ? ((C0113x) view).isNestedScrollingEnabled() : false;
        }

        public ColorStateList m1764C(View view) {
            return ai.m1960a(view);
        }

        public Mode m1765D(View view) {
            return ai.m1964b(view);
        }

        public void m1766E(View view) {
            if (view instanceof C0113x) {
                ((C0113x) view).stopNestedScroll();
            }
        }

        public boolean m1767F(View view) {
            return ai.m1966c(view);
        }

        public float m1768G(View view) {
            return m1824x(view) + m1823w(view);
        }

        public boolean m1769H(View view) {
            return ai.m1969f(view);
        }

        public boolean m1770I(View view) {
            return false;
        }

        public int m1771a(int i, int i2) {
            return i | i2;
        }

        public int m1772a(int i, int i2, int i3) {
            return View.resolveSize(i, i2);
        }

        public int m1773a(View view) {
            return 2;
        }

        long m1774a() {
            return 10;
        }

        public bg m1775a(View view, bg bgVar) {
            return bgVar;
        }

        public void m1776a(View view, float f) {
        }

        public void m1777a(View view, int i, int i2) {
        }

        public void m1778a(View view, int i, int i2, int i3, int i4) {
            view.setPadding(i, i2, i3, i4);
        }

        public void m1779a(View view, int i, Paint paint) {
        }

        public void m1780a(View view, ColorStateList colorStateList) {
            ai.m1962a(view, colorStateList);
        }

        public void m1781a(View view, Mode mode) {
            ai.m1963a(view, mode);
        }

        public void m1782a(View view, ab abVar) {
        }

        public void m1783a(View view, C0473b c0473b) {
        }

        public void m1784a(View view, Runnable runnable) {
            view.postDelayed(runnable, m1774a());
        }

        public void m1785a(View view, Runnable runnable, long j) {
            view.postDelayed(runnable, m1774a() + j);
        }

        public void m1786a(View view, boolean z) {
        }

        public void m1787a(ViewGroup viewGroup, boolean z) {
        }

        public boolean m1788a(View view, int i) {
            return (view instanceof ad) && m1760a((ad) view, i);
        }

        public bg m1789b(View view, bg bgVar) {
            return bgVar;
        }

        public void m1790b(View view, float f) {
        }

        public void m1791b(View view, boolean z) {
        }

        public boolean m1792b(View view) {
            return false;
        }

        public boolean m1793b(View view, int i) {
            return (view instanceof ad) && m1761b((ad) view, i);
        }

        public void m1794c(View view, float f) {
        }

        public void m1795c(View view, int i) {
        }

        public void m1796c(View view, boolean z) {
        }

        public boolean m1797c(View view) {
            return false;
        }

        public void m1798d(View view) {
            view.invalidate();
        }

        public void m1799d(View view, float f) {
        }

        public void m1800d(View view, int i) {
        }

        public int m1801e(View view) {
            return 0;
        }

        public void m1802e(View view, float f) {
        }

        public void m1803e(View view, int i) {
            ai.m1965b(view, i);
        }

        public float m1804f(View view) {
            return 1.0f;
        }

        public void m1805f(View view, float f) {
        }

        public void m1806f(View view, int i) {
            ai.m1961a(view, i);
        }

        public int m1807g(View view) {
            return 0;
        }

        public int m1808h(View view) {
            return 0;
        }

        public int m1809i(View view) {
            return view.getMeasuredWidth();
        }

        public int m1810j(View view) {
            return 0;
        }

        public int m1811k(View view) {
            return view.getPaddingLeft();
        }

        public int m1812l(View view) {
            return view.getPaddingRight();
        }

        public boolean m1813m(View view) {
            return true;
        }

        public float m1814n(View view) {
            return 0.0f;
        }

        public float m1815o(View view) {
            return 0.0f;
        }

        public float m1816p(View view) {
            return 0.0f;
        }

        public Matrix m1817q(View view) {
            return null;
        }

        public int m1818r(View view) {
            return ai.m1967d(view);
        }

        public int m1819s(View view) {
            return ai.m1968e(view);
        }

        public az m1820t(View view) {
            return new az(view);
        }

        public int m1821u(View view) {
            return 0;
        }

        public void m1822v(View view) {
        }

        public float m1823w(View view) {
            return 0.0f;
        }

        public float m1824x(View view) {
            return 0.0f;
        }

        public boolean m1825y(View view) {
            return false;
        }

        public void m1826z(View view) {
        }
    }

    /* renamed from: android.support.v4.k.ah.c */
    static class C0448c extends C0447b {
        C0448c() {
        }

        public void m1827a(ViewGroup viewGroup, boolean z) {
            aj.m1970a(viewGroup, z);
        }
    }

    /* renamed from: android.support.v4.k.ah.d */
    static class C0449d extends C0448c {
        C0449d() {
        }

        public int m1828a(View view) {
            return ak.m1971a(view);
        }
    }

    /* renamed from: android.support.v4.k.ah.e */
    static class C0450e extends C0449d {
        C0450e() {
        }

        public int m1829a(int i, int i2) {
            return al.m1973a(i, i2);
        }

        public int m1830a(int i, int i2, int i3) {
            return al.m1974a(i, i2, i3);
        }

        long m1831a() {
            return al.m1975a();
        }

        public void m1832a(View view, float f) {
            al.m1976a(view, f);
        }

        public void m1833a(View view, int i, Paint paint) {
            al.m1978a(view, i, paint);
        }

        public void m1834b(View view, float f) {
            al.m1981b(view, f);
        }

        public void m1835b(View view, boolean z) {
            al.m1979a(view, z);
        }

        public void m1836c(View view, float f) {
            al.m1985c(view, f);
        }

        public void m1837c(View view, boolean z) {
            al.m1983b(view, z);
        }

        public void m1838d(View view, float f) {
            al.m1987d(view, f);
        }

        public void m1839e(View view, float f) {
            al.m1989e(view, f);
        }

        public void m1840e(View view, int i) {
            al.m1982b(view, i);
        }

        public float m1841f(View view) {
            return al.m1972a(view);
        }

        public void m1842f(View view, int i) {
            al.m1977a(view, i);
        }

        public int m1843g(View view) {
            return al.m1980b(view);
        }

        public int m1844i(View view) {
            return al.m1984c(view);
        }

        public int m1845j(View view) {
            return al.m1986d(view);
        }

        public float m1846n(View view) {
            return al.m1988e(view);
        }

        public float m1847o(View view) {
            return al.m1990f(view);
        }

        public float m1848p(View view) {
            return al.m1991g(view);
        }

        public Matrix m1849q(View view) {
            return al.m1992h(view);
        }

        public void m1850z(View view) {
            al.m1993i(view);
        }
    }

    /* renamed from: android.support.v4.k.ah.g */
    static class C0451g extends C0450e {
        static Field f780b;
        static boolean f781c;

        static {
            f781c = false;
        }

        C0451g() {
        }

        public void m1851a(View view, C0473b c0473b) {
            am.m1995a(view, c0473b == null ? null : c0473b.m2054a());
        }

        public void m1852a(View view, boolean z) {
            am.m1996a(view, z);
        }

        public boolean m1853a(View view, int i) {
            return am.m1997a(view, i);
        }

        public boolean m1854b(View view) {
            boolean z = true;
            if (f781c) {
                return false;
            }
            if (f780b == null) {
                try {
                    f780b = View.class.getDeclaredField("mAccessibilityDelegate");
                    f780b.setAccessible(true);
                } catch (Throwable th) {
                    f781c = true;
                    return false;
                }
            }
            try {
                if (f780b.get(view) == null) {
                    z = false;
                }
                return z;
            } catch (Throwable th2) {
                f781c = true;
                return false;
            }
        }

        public boolean m1855b(View view, int i) {
            return am.m1998b(view, i);
        }

        public az m1856t(View view) {
            if (this.a == null) {
                this.a = new WeakHashMap();
            }
            az azVar = (az) this.a.get(view);
            if (azVar != null) {
                return azVar;
            }
            azVar = new az(view);
            this.a.put(view, azVar);
            return azVar;
        }
    }

    /* renamed from: android.support.v4.k.ah.f */
    static class C0452f extends C0451g {
        C0452f() {
        }

        public boolean m1857I(View view) {
            return an.m1999a(view);
        }
    }

    /* renamed from: android.support.v4.k.ah.h */
    static class C0453h extends C0452f {
        C0453h() {
        }

        public void m1858a(View view, Runnable runnable) {
            ao.m2001a(view, runnable);
        }

        public void m1859a(View view, Runnable runnable, long j) {
            ao.m2002a(view, runnable, j);
        }

        public void m1860c(View view, int i) {
            if (i == 4) {
                i = 2;
            }
            ao.m2000a(view, i);
        }

        public boolean m1861c(View view) {
            return ao.m2003a(view);
        }

        public void m1862d(View view) {
            ao.m2004b(view);
        }

        public int m1863e(View view) {
            return ao.m2005c(view);
        }

        public boolean m1864m(View view) {
            return ao.m2010h(view);
        }

        public int m1865r(View view) {
            return ao.m2006d(view);
        }

        public int m1866s(View view) {
            return ao.m2007e(view);
        }

        public void m1867v(View view) {
            ao.m2008f(view);
        }

        public boolean m1868y(View view) {
            return ao.m2009g(view);
        }
    }

    /* renamed from: android.support.v4.k.ah.i */
    static class C0454i extends C0453h {
        C0454i() {
        }

        public boolean m1869A(View view) {
            return ap.m2016e(view);
        }

        public void m1870a(View view, int i, int i2, int i3, int i4) {
            ap.m2012a(view, i, i2, i3, i4);
        }

        public int m1871h(View view) {
            return ap.m2011a(view);
        }

        public int m1872k(View view) {
            return ap.m2013b(view);
        }

        public int m1873l(View view) {
            return ap.m2014c(view);
        }

        public int m1874u(View view) {
            return ap.m2015d(view);
        }
    }

    /* renamed from: android.support.v4.k.ah.j */
    static class C0455j extends C0454i {
        C0455j() {
        }
    }

    /* renamed from: android.support.v4.k.ah.k */
    static class C0456k extends C0455j {
        C0456k() {
        }

        public boolean m1875F(View view) {
            return aq.m2018a(view);
        }

        public boolean m1876H(View view) {
            return aq.m2019b(view);
        }

        public void m1877c(View view, int i) {
            ao.m2000a(view, i);
        }

        public void m1878d(View view, int i) {
            aq.m2017a(view, i);
        }
    }

    /* renamed from: android.support.v4.k.ah.l */
    static class C0457l extends C0456k {
        C0457l() {
        }

        public boolean m1879B(View view) {
            return ar.m2034f(view);
        }

        public ColorStateList m1880C(View view) {
            return ar.m2032d(view);
        }

        public Mode m1881D(View view) {
            return ar.m2033e(view);
        }

        public void m1882E(View view) {
            ar.m2035g(view);
        }

        public float m1883G(View view) {
            return ar.m2036h(view);
        }

        public bg m1884a(View view, bg bgVar) {
            return ar.m2021a(view, bgVar);
        }

        public void m1885a(View view, ColorStateList colorStateList) {
            ar.m2025a(view, colorStateList);
        }

        public void m1886a(View view, Mode mode) {
            ar.m2026a(view, mode);
        }

        public void m1887a(View view, ab abVar) {
            ar.m2027a(view, abVar);
        }

        public bg m1888b(View view, bg bgVar) {
            return ar.m2029b(view, bgVar);
        }

        public void m1889e(View view, int i) {
            ar.m2030b(view, i);
        }

        public void m1890f(View view, float f) {
            ar.m2023a(view, f);
        }

        public void m1891f(View view, int i) {
            ar.m2024a(view, i);
        }

        public void m1892v(View view) {
            ar.m2022a(view);
        }

        public float m1893w(View view) {
            return ar.m2028b(view);
        }

        public float m1894x(View view) {
            return ar.m2031c(view);
        }
    }

    /* renamed from: android.support.v4.k.ah.m */
    static class C0458m extends C0457l {
        C0458m() {
        }

        public void m1895a(View view, int i, int i2) {
            as.m2038a(view, i, i2);
        }

        public void m1896e(View view, int i) {
            as.m2039b(view, i);
        }

        public void m1897f(View view, int i) {
            as.m2037a(view, i);
        }
    }

    /* renamed from: android.support.v4.k.ah.a */
    static class C0459a extends C0458m {
        C0459a() {
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (C0354c.m1328a()) {
            f782a = new C0459a();
        } else if (i >= 23) {
            f782a = new C0458m();
        } else if (i >= 21) {
            f782a = new C0457l();
        } else if (i >= 19) {
            f782a = new C0456k();
        } else if (i >= 18) {
            f782a = new C0455j();
        } else if (i >= 17) {
            f782a = new C0454i();
        } else if (i >= 16) {
            f782a = new C0453h();
        } else if (i >= 15) {
            f782a = new C0452f();
        } else if (i >= 14) {
            f782a = new C0451g();
        } else if (i >= 11) {
            f782a = new C0450e();
        } else if (i >= 9) {
            f782a = new C0449d();
        } else if (i >= 7) {
            f782a = new C0448c();
        } else {
            f782a = new C0447b();
        }
    }

    public static Mode m1898A(View view) {
        return f782a.m1701D(view);
    }

    public static boolean m1899B(View view) {
        return f782a.m1699B(view);
    }

    public static void m1900C(View view) {
        f782a.m1702E(view);
    }

    public static boolean m1901D(View view) {
        return f782a.m1703F(view);
    }

    public static float m1902E(View view) {
        return f782a.m1704G(view);
    }

    public static boolean m1903F(View view) {
        return f782a.m1705H(view);
    }

    public static boolean m1904G(View view) {
        return f782a.m1706I(view);
    }

    public static int m1905a(int i, int i2) {
        return f782a.m1707a(i, i2);
    }

    public static int m1906a(int i, int i2, int i3) {
        return f782a.m1708a(i, i2, i3);
    }

    public static int m1907a(View view) {
        return f782a.m1709a(view);
    }

    public static bg m1908a(View view, bg bgVar) {
        return f782a.m1710a(view, bgVar);
    }

    public static void m1909a(View view, float f) {
        f782a.m1711a(view, f);
    }

    public static void m1910a(View view, int i, int i2) {
        f782a.m1712a(view, i, i2);
    }

    public static void m1911a(View view, int i, int i2, int i3, int i4) {
        f782a.m1713a(view, i, i2, i3, i4);
    }

    public static void m1912a(View view, int i, Paint paint) {
        f782a.m1714a(view, i, paint);
    }

    public static void m1913a(View view, ColorStateList colorStateList) {
        f782a.m1715a(view, colorStateList);
    }

    public static void m1914a(View view, Mode mode) {
        f782a.m1716a(view, mode);
    }

    public static void m1915a(View view, ab abVar) {
        f782a.m1717a(view, abVar);
    }

    public static void m1916a(View view, C0473b c0473b) {
        f782a.m1718a(view, c0473b);
    }

    public static void m1917a(View view, Runnable runnable) {
        f782a.m1719a(view, runnable);
    }

    public static void m1918a(View view, Runnable runnable, long j) {
        f782a.m1720a(view, runnable, j);
    }

    public static void m1919a(View view, boolean z) {
        f782a.m1721a(view, z);
    }

    public static void m1920a(ViewGroup viewGroup, boolean z) {
        f782a.m1722a(viewGroup, z);
    }

    public static boolean m1921a(View view, int i) {
        return f782a.m1723a(view, i);
    }

    public static bg m1922b(View view, bg bgVar) {
        return f782a.m1724b(view, bgVar);
    }

    public static void m1923b(View view, float f) {
        f782a.m1725b(view, f);
    }

    public static void m1924b(View view, boolean z) {
        f782a.m1726b(view, z);
    }

    public static boolean m1925b(View view) {
        return f782a.m1727b(view);
    }

    public static boolean m1926b(View view, int i) {
        return f782a.m1728b(view, i);
    }

    public static void m1927c(View view, float f) {
        f782a.m1729c(view, f);
    }

    public static void m1928c(View view, int i) {
        f782a.m1730c(view, i);
    }

    public static void m1929c(View view, boolean z) {
        f782a.m1731c(view, z);
    }

    public static boolean m1930c(View view) {
        return f782a.m1732c(view);
    }

    public static void m1931d(View view) {
        f782a.m1733d(view);
    }

    public static void m1932d(View view, float f) {
        f782a.m1734d(view, f);
    }

    public static void m1933d(View view, int i) {
        f782a.m1735d(view, i);
    }

    public static int m1934e(View view) {
        return f782a.m1736e(view);
    }

    public static void m1935e(View view, float f) {
        f782a.m1737e(view, f);
    }

    public static void m1936e(View view, int i) {
        f782a.m1741f(view, i);
    }

    public static float m1937f(View view) {
        return f782a.m1739f(view);
    }

    public static void m1938f(View view, float f) {
        f782a.m1740f(view, f);
    }

    public static void m1939f(View view, int i) {
        f782a.m1738e(view, i);
    }

    public static int m1940g(View view) {
        return f782a.m1742g(view);
    }

    public static int m1941h(View view) {
        return f782a.m1743h(view);
    }

    public static int m1942i(View view) {
        return f782a.m1744i(view);
    }

    public static int m1943j(View view) {
        return f782a.m1745j(view);
    }

    public static int m1944k(View view) {
        return f782a.m1746k(view);
    }

    public static int m1945l(View view) {
        return f782a.m1747l(view);
    }

    public static float m1946m(View view) {
        return f782a.m1749n(view);
    }

    public static float m1947n(View view) {
        return f782a.m1750o(view);
    }

    public static Matrix m1948o(View view) {
        return f782a.m1752q(view);
    }

    public static int m1949p(View view) {
        return f782a.m1753r(view);
    }

    public static int m1950q(View view) {
        return f782a.m1754s(view);
    }

    public static az m1951r(View view) {
        return f782a.m1755t(view);
    }

    public static float m1952s(View view) {
        return f782a.m1751p(view);
    }

    public static int m1953t(View view) {
        return f782a.m1756u(view);
    }

    public static void m1954u(View view) {
        f782a.m1757v(view);
    }

    public static boolean m1955v(View view) {
        return f782a.m1758y(view);
    }

    public static void m1956w(View view) {
        f782a.m1759z(view);
    }

    public static boolean m1957x(View view) {
        return f782a.m1748m(view);
    }

    public static boolean m1958y(View view) {
        return f782a.m1698A(view);
    }

    public static ColorStateList m1959z(View view) {
        return f782a.m1700C(view);
    }
}
