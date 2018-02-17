package android.support.v7.widget;

import android.support.v4.p016k.ah;
import android.support.v4.p016k.az;
import android.support.v4.p016k.bd;
import android.support.v4.p020a.C0217a;
import android.support.v7.widget.RecyclerView.C0853v;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ae extends ay {
    private ArrayList<C0853v> f2219b;
    private ArrayList<C0853v> f2220c;
    private ArrayList<C0894b> f2221d;
    private ArrayList<C0893a> f2222e;
    private ArrayList<ArrayList<C0853v>> f2223f;
    private ArrayList<ArrayList<C0894b>> f2224g;
    private ArrayList<ArrayList<C0893a>> f2225h;
    private ArrayList<C0853v> f2226i;
    private ArrayList<C0853v> f2227j;
    private ArrayList<C0853v> f2228k;
    private ArrayList<C0853v> f2229l;

    /* renamed from: android.support.v7.widget.ae.1 */
    class C08841 implements Runnable {
        final /* synthetic */ ArrayList f2183a;
        final /* synthetic */ ae f2184b;

        C08841(ae aeVar, ArrayList arrayList) {
            this.f2184b = aeVar;
            this.f2183a = arrayList;
        }

        public void run() {
            Iterator it = this.f2183a.iterator();
            while (it.hasNext()) {
                C0894b c0894b = (C0894b) it.next();
                this.f2184b.m4602b(c0894b.f2213a, c0894b.f2214b, c0894b.f2215c, c0894b.f2216d, c0894b.f2217e);
            }
            this.f2183a.clear();
            this.f2184b.f2224g.remove(this.f2183a);
        }
    }

    /* renamed from: android.support.v7.widget.ae.2 */
    class C08852 implements Runnable {
        final /* synthetic */ ArrayList f2185a;
        final /* synthetic */ ae f2186b;

        C08852(ae aeVar, ArrayList arrayList) {
            this.f2186b = aeVar;
            this.f2185a = arrayList;
        }

        public void run() {
            Iterator it = this.f2185a.iterator();
            while (it.hasNext()) {
                this.f2186b.m4595a((C0893a) it.next());
            }
            this.f2185a.clear();
            this.f2186b.f2225h.remove(this.f2185a);
        }
    }

    /* renamed from: android.support.v7.widget.ae.3 */
    class C08863 implements Runnable {
        final /* synthetic */ ArrayList f2187a;
        final /* synthetic */ ae f2188b;

        C08863(ae aeVar, ArrayList arrayList) {
            this.f2188b = aeVar;
            this.f2187a = arrayList;
        }

        public void run() {
            Iterator it = this.f2187a.iterator();
            while (it.hasNext()) {
                this.f2188b.m4612u((C0853v) it.next());
            }
            this.f2187a.clear();
            this.f2188b.f2223f.remove(this.f2187a);
        }
    }

    /* renamed from: android.support.v7.widget.ae.c */
    private static class C0887c implements bd {
        private C0887c() {
        }

        public void m4554a(View view) {
        }

        public void m4555b(View view) {
        }

        public void m4556c(View view) {
        }
    }

    /* renamed from: android.support.v7.widget.ae.4 */
    class C08884 extends C0887c {
        final /* synthetic */ C0853v f2189a;
        final /* synthetic */ az f2190b;
        final /* synthetic */ ae f2191c;

        C08884(ae aeVar, C0853v c0853v, az azVar) {
            this.f2191c = aeVar;
            this.f2189a = c0853v;
            this.f2190b = azVar;
            super();
        }

        public void m4557a(View view) {
            this.f2191c.m4585k(this.f2189a);
        }

        public void m4558b(View view) {
            this.f2190b.m2159a(null);
            ah.m1927c(view, 1.0f);
            this.f2191c.m4582h(this.f2189a);
            this.f2191c.f2228k.remove(this.f2189a);
            this.f2191c.m4610j();
        }
    }

    /* renamed from: android.support.v7.widget.ae.5 */
    class C08895 extends C0887c {
        final /* synthetic */ C0853v f2192a;
        final /* synthetic */ az f2193b;
        final /* synthetic */ ae f2194c;

        C08895(ae aeVar, C0853v c0853v, az azVar) {
            this.f2194c = aeVar;
            this.f2192a = c0853v;
            this.f2193b = azVar;
            super();
        }

        public void m4559a(View view) {
            this.f2194c.m4587m(this.f2192a);
        }

        public void m4560b(View view) {
            this.f2193b.m2159a(null);
            this.f2194c.m4584j(this.f2192a);
            this.f2194c.f2226i.remove(this.f2192a);
            this.f2194c.m4610j();
        }

        public void m4561c(View view) {
            ah.m1927c(view, 1.0f);
        }
    }

    /* renamed from: android.support.v7.widget.ae.6 */
    class C08906 extends C0887c {
        final /* synthetic */ C0853v f2195a;
        final /* synthetic */ int f2196b;
        final /* synthetic */ int f2197c;
        final /* synthetic */ az f2198d;
        final /* synthetic */ ae f2199e;

        C08906(ae aeVar, C0853v c0853v, int i, int i2, az azVar) {
            this.f2199e = aeVar;
            this.f2195a = c0853v;
            this.f2196b = i;
            this.f2197c = i2;
            this.f2198d = azVar;
            super();
        }

        public void m4562a(View view) {
            this.f2199e.m4586l(this.f2195a);
        }

        public void m4563b(View view) {
            this.f2198d.m2159a(null);
            this.f2199e.m4583i(this.f2195a);
            this.f2199e.f2227j.remove(this.f2195a);
            this.f2199e.m4610j();
        }

        public void m4564c(View view) {
            if (this.f2196b != 0) {
                ah.m1909a(view, 0.0f);
            }
            if (this.f2197c != 0) {
                ah.m1923b(view, 0.0f);
            }
        }
    }

    /* renamed from: android.support.v7.widget.ae.7 */
    class C08917 extends C0887c {
        final /* synthetic */ C0893a f2200a;
        final /* synthetic */ az f2201b;
        final /* synthetic */ ae f2202c;

        C08917(ae aeVar, C0893a c0893a, az azVar) {
            this.f2202c = aeVar;
            this.f2200a = c0893a;
            this.f2201b = azVar;
            super();
        }

        public void m4565a(View view) {
            this.f2202c.m4575b(this.f2200a.f2207a, true);
        }

        public void m4566b(View view) {
            this.f2201b.m2159a(null);
            ah.m1927c(view, 1.0f);
            ah.m1909a(view, 0.0f);
            ah.m1923b(view, 0.0f);
            this.f2202c.m4569a(this.f2200a.f2207a, true);
            this.f2202c.f2229l.remove(this.f2200a.f2207a);
            this.f2202c.m4610j();
        }
    }

    /* renamed from: android.support.v7.widget.ae.8 */
    class C08928 extends C0887c {
        final /* synthetic */ C0893a f2203a;
        final /* synthetic */ az f2204b;
        final /* synthetic */ View f2205c;
        final /* synthetic */ ae f2206d;

        C08928(ae aeVar, C0893a c0893a, az azVar, View view) {
            this.f2206d = aeVar;
            this.f2203a = c0893a;
            this.f2204b = azVar;
            this.f2205c = view;
            super();
        }

        public void m4567a(View view) {
            this.f2206d.m4575b(this.f2203a.f2208b, false);
        }

        public void m4568b(View view) {
            this.f2204b.m2159a(null);
            ah.m1927c(this.f2205c, 1.0f);
            ah.m1909a(this.f2205c, 0.0f);
            ah.m1923b(this.f2205c, 0.0f);
            this.f2206d.m4569a(this.f2203a.f2208b, false);
            this.f2206d.f2229l.remove(this.f2203a.f2208b);
            this.f2206d.m4610j();
        }
    }

    /* renamed from: android.support.v7.widget.ae.a */
    private static class C0893a {
        public C0853v f2207a;
        public C0853v f2208b;
        public int f2209c;
        public int f2210d;
        public int f2211e;
        public int f2212f;

        private C0893a(C0853v c0853v, C0853v c0853v2) {
            this.f2207a = c0853v;
            this.f2208b = c0853v2;
        }

        private C0893a(C0853v c0853v, C0853v c0853v2, int i, int i2, int i3, int i4) {
            this(c0853v, c0853v2);
            this.f2209c = i;
            this.f2210d = i2;
            this.f2211e = i3;
            this.f2212f = i4;
        }

        public String toString() {
            return "ChangeInfo{oldHolder=" + this.f2207a + ", newHolder=" + this.f2208b + ", fromX=" + this.f2209c + ", fromY=" + this.f2210d + ", toX=" + this.f2211e + ", toY=" + this.f2212f + '}';
        }
    }

    /* renamed from: android.support.v7.widget.ae.b */
    private static class C0894b {
        public C0853v f2213a;
        public int f2214b;
        public int f2215c;
        public int f2216d;
        public int f2217e;

        private C0894b(C0853v c0853v, int i, int i2, int i3, int i4) {
            this.f2213a = c0853v;
            this.f2214b = i;
            this.f2215c = i2;
            this.f2216d = i3;
            this.f2217e = i4;
        }
    }

    public ae() {
        this.f2219b = new ArrayList();
        this.f2220c = new ArrayList();
        this.f2221d = new ArrayList();
        this.f2222e = new ArrayList();
        this.f2223f = new ArrayList();
        this.f2224g = new ArrayList();
        this.f2225h = new ArrayList();
        this.f2226i = new ArrayList();
        this.f2227j = new ArrayList();
        this.f2228k = new ArrayList();
        this.f2229l = new ArrayList();
    }

    private void m4595a(C0893a c0893a) {
        View view = null;
        C0853v c0853v = c0893a.f2207a;
        View view2 = c0853v == null ? null : c0853v.itemView;
        C0853v c0853v2 = c0893a.f2208b;
        if (c0853v2 != null) {
            view = c0853v2.itemView;
        }
        if (view2 != null) {
            az a = ah.m1951r(view2).m2158a(m4124g());
            this.f2229l.add(c0893a.f2207a);
            a.m2162b((float) (c0893a.f2211e - c0893a.f2209c));
            a.m2165c((float) (c0893a.f2212f - c0893a.f2210d));
            a.m2157a(0.0f).m2159a(new C08917(this, c0893a, a)).m2166c();
        }
        if (view != null) {
            a = ah.m1951r(view);
            this.f2229l.add(c0893a.f2208b);
            a.m2162b(0.0f).m2165c(0.0f).m2158a(m4124g()).m2157a(1.0f).m2159a(new C08928(this, c0893a, a, view)).m2166c();
        }
    }

    private void m4599a(List<C0893a> list, C0853v c0853v) {
        for (int size = list.size() - 1; size >= 0; size--) {
            C0893a c0893a = (C0893a) list.get(size);
            if (m4600a(c0893a, c0853v) && c0893a.f2207a == null && c0893a.f2208b == null) {
                list.remove(c0893a);
            }
        }
    }

    private boolean m4600a(C0893a c0893a, C0853v c0853v) {
        boolean z = false;
        if (c0893a.f2208b == c0853v) {
            c0893a.f2208b = null;
        } else if (c0893a.f2207a != c0853v) {
            return false;
        } else {
            c0893a.f2207a = null;
            z = true;
        }
        ah.m1927c(c0853v.itemView, 1.0f);
        ah.m1909a(c0853v.itemView, 0.0f);
        ah.m1923b(c0853v.itemView, 0.0f);
        m4569a(c0853v, z);
        return true;
    }

    private void m4602b(C0853v c0853v, int i, int i2, int i3, int i4) {
        View view = c0853v.itemView;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        if (i5 != 0) {
            ah.m1951r(view).m2162b(0.0f);
        }
        if (i6 != 0) {
            ah.m1951r(view).m2165c(0.0f);
        }
        az r = ah.m1951r(view);
        this.f2227j.add(c0853v);
        r.m2158a(m4119d()).m2159a(new C08906(this, c0853v, i5, i6, r)).m2166c();
    }

    private void m4603b(C0893a c0893a) {
        if (c0893a.f2207a != null) {
            m4600a(c0893a, c0893a.f2207a);
        }
        if (c0893a.f2208b != null) {
            m4600a(c0893a, c0893a.f2208b);
        }
    }

    private void m4610j() {
        if (!m4620b()) {
            m4126h();
        }
    }

    private void m4611t(C0853v c0853v) {
        az r = ah.m1951r(c0853v.itemView);
        this.f2228k.add(c0853v);
        r.m2158a(m4122f()).m2157a(0.0f).m2159a(new C08884(this, c0853v, r)).m2166c();
    }

    private void m4612u(C0853v c0853v) {
        az r = ah.m1951r(c0853v.itemView);
        this.f2226i.add(c0853v);
        r.m2157a(1.0f).m2158a(m4120e()).m2159a(new C08895(this, c0853v, r)).m2166c();
    }

    private void m4613v(C0853v c0853v) {
        C0217a.m791a(c0853v.itemView);
        m4623c(c0853v);
    }

    public void m4614a() {
        int i = !this.f2219b.isEmpty() ? 1 : 0;
        int i2 = !this.f2221d.isEmpty() ? 1 : 0;
        int i3 = !this.f2222e.isEmpty() ? 1 : 0;
        int i4 = !this.f2220c.isEmpty() ? 1 : 0;
        if (i != 0 || i2 != 0 || i4 != 0 || i3 != 0) {
            ArrayList arrayList;
            Runnable c08841;
            Iterator it = this.f2219b.iterator();
            while (it.hasNext()) {
                m4611t((C0853v) it.next());
            }
            this.f2219b.clear();
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2221d);
                this.f2224g.add(arrayList);
                this.f2221d.clear();
                c08841 = new C08841(this, arrayList);
                if (i != 0) {
                    ah.m1918a(((C0894b) arrayList.get(0)).f2213a.itemView, c08841, m4122f());
                } else {
                    c08841.run();
                }
            }
            if (i3 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.f2222e);
                this.f2225h.add(arrayList);
                this.f2222e.clear();
                c08841 = new C08852(this, arrayList);
                if (i != 0) {
                    ah.m1918a(((C0893a) arrayList.get(0)).f2207a.itemView, c08841, m4122f());
                } else {
                    c08841.run();
                }
            }
            if (i4 != 0) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.f2220c);
                this.f2223f.add(arrayList2);
                this.f2220c.clear();
                Runnable c08863 = new C08863(this, arrayList2);
                if (i == 0 && i2 == 0 && i3 == 0) {
                    c08863.run();
                } else {
                    ah.m1918a(((C0853v) arrayList2.get(0)).itemView, c08863, (i != 0 ? m4122f() : 0) + Math.max(i2 != 0 ? m4119d() : 0, i3 != 0 ? m4124g() : 0));
                }
            }
        }
    }

    void m4615a(List<C0853v> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            ah.m1951r(((C0853v) list.get(size)).itemView).m2164b();
        }
    }

    public boolean m4616a(C0853v c0853v) {
        m4613v(c0853v);
        this.f2219b.add(c0853v);
        return true;
    }

    public boolean m4617a(C0853v c0853v, int i, int i2, int i3, int i4) {
        View view = c0853v.itemView;
        int m = (int) (((float) i) + ah.m1946m(c0853v.itemView));
        int n = (int) (((float) i2) + ah.m1947n(c0853v.itemView));
        m4613v(c0853v);
        int i5 = i3 - m;
        int i6 = i4 - n;
        if (i5 == 0 && i6 == 0) {
            m4583i(c0853v);
            return false;
        }
        if (i5 != 0) {
            ah.m1909a(view, (float) (-i5));
        }
        if (i6 != 0) {
            ah.m1923b(view, (float) (-i6));
        }
        this.f2221d.add(new C0894b(m, n, i3, i4, null));
        return true;
    }

    public boolean m4618a(C0853v c0853v, C0853v c0853v2, int i, int i2, int i3, int i4) {
        if (c0853v == c0853v2) {
            return m4617a(c0853v, i, i2, i3, i4);
        }
        float m = ah.m1946m(c0853v.itemView);
        float n = ah.m1947n(c0853v.itemView);
        float f = ah.m1937f(c0853v.itemView);
        m4613v(c0853v);
        int i5 = (int) (((float) (i3 - i)) - m);
        int i6 = (int) (((float) (i4 - i2)) - n);
        ah.m1909a(c0853v.itemView, m);
        ah.m1923b(c0853v.itemView, n);
        ah.m1927c(c0853v.itemView, f);
        if (c0853v2 != null) {
            m4613v(c0853v2);
            ah.m1909a(c0853v2.itemView, (float) (-i5));
            ah.m1923b(c0853v2.itemView, (float) (-i6));
            ah.m1927c(c0853v2.itemView, 0.0f);
        }
        this.f2222e.add(new C0893a(c0853v2, i, i2, i3, i4, null));
        return true;
    }

    public boolean m4619a(C0853v c0853v, List<Object> list) {
        return !list.isEmpty() || super.m4113a(c0853v, (List) list);
    }

    public boolean m4620b() {
        return (this.f2220c.isEmpty() && this.f2222e.isEmpty() && this.f2221d.isEmpty() && this.f2219b.isEmpty() && this.f2227j.isEmpty() && this.f2228k.isEmpty() && this.f2226i.isEmpty() && this.f2229l.isEmpty() && this.f2224g.isEmpty() && this.f2223f.isEmpty() && this.f2225h.isEmpty()) ? false : true;
    }

    public boolean m4621b(C0853v c0853v) {
        m4613v(c0853v);
        ah.m1927c(c0853v.itemView, 0.0f);
        this.f2220c.add(c0853v);
        return true;
    }

    public void m4622c() {
        int size;
        for (size = this.f2221d.size() - 1; size >= 0; size--) {
            C0894b c0894b = (C0894b) this.f2221d.get(size);
            View view = c0894b.f2213a.itemView;
            ah.m1923b(view, 0.0f);
            ah.m1909a(view, 0.0f);
            m4583i(c0894b.f2213a);
            this.f2221d.remove(size);
        }
        for (size = this.f2219b.size() - 1; size >= 0; size--) {
            m4582h((C0853v) this.f2219b.get(size));
            this.f2219b.remove(size);
        }
        for (size = this.f2220c.size() - 1; size >= 0; size--) {
            C0853v c0853v = (C0853v) this.f2220c.get(size);
            ah.m1927c(c0853v.itemView, 1.0f);
            m4584j(c0853v);
            this.f2220c.remove(size);
        }
        for (size = this.f2222e.size() - 1; size >= 0; size--) {
            m4603b((C0893a) this.f2222e.get(size));
        }
        this.f2222e.clear();
        if (m4620b()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.f2224g.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2224g.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0894b c0894b2 = (C0894b) arrayList.get(size3);
                    View view2 = c0894b2.f2213a.itemView;
                    ah.m1923b(view2, 0.0f);
                    ah.m1909a(view2, 0.0f);
                    m4583i(c0894b2.f2213a);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2224g.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2223f.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2223f.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    C0853v c0853v2 = (C0853v) arrayList.get(size3);
                    ah.m1927c(c0853v2.itemView, 1.0f);
                    m4584j(c0853v2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2223f.remove(arrayList);
                    }
                }
            }
            for (size2 = this.f2225h.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.f2225h.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    m4603b((C0893a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.f2225h.remove(arrayList);
                    }
                }
            }
            m4615a(this.f2228k);
            m4615a(this.f2227j);
            m4615a(this.f2226i);
            m4615a(this.f2229l);
            m4126h();
        }
    }

    public void m4623c(C0853v c0853v) {
        int size;
        View view = c0853v.itemView;
        ah.m1951r(view).m2164b();
        for (size = this.f2221d.size() - 1; size >= 0; size--) {
            if (((C0894b) this.f2221d.get(size)).f2213a == c0853v) {
                ah.m1923b(view, 0.0f);
                ah.m1909a(view, 0.0f);
                m4583i(c0853v);
                this.f2221d.remove(size);
            }
        }
        m4599a(this.f2222e, c0853v);
        if (this.f2219b.remove(c0853v)) {
            ah.m1927c(view, 1.0f);
            m4582h(c0853v);
        }
        if (this.f2220c.remove(c0853v)) {
            ah.m1927c(view, 1.0f);
            m4584j(c0853v);
        }
        for (size = this.f2225h.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.f2225h.get(size);
            m4599a(list, c0853v);
            if (list.isEmpty()) {
                this.f2225h.remove(size);
            }
        }
        for (int size2 = this.f2224g.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.f2224g.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((C0894b) arrayList.get(size3)).f2213a == c0853v) {
                    ah.m1923b(view, 0.0f);
                    ah.m1909a(view, 0.0f);
                    m4583i(c0853v);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.f2224g.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.f2223f.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.f2223f.get(size);
            if (arrayList.remove(c0853v)) {
                ah.m1927c(view, 1.0f);
                m4584j(c0853v);
                if (arrayList.isEmpty()) {
                    this.f2223f.remove(size);
                }
            }
        }
        if (this.f2228k.remove(c0853v)) {
        }
        if (this.f2226i.remove(c0853v)) {
        }
        if (this.f2229l.remove(c0853v)) {
        }
        if (this.f2227j.remove(c0853v)) {
            m4610j();
        } else {
            m4610j();
        }
    }
}
