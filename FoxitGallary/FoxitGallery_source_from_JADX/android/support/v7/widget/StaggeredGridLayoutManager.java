package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p016k.p031a.C0402a;
import android.support.v4.p016k.p031a.C0416c;
import android.support.v4.p016k.p031a.C0416c.C0415l;
import android.support.v4.p016k.p031a.C0440k;
import android.support.v7.widget.RecyclerView.C0810i;
import android.support.v7.widget.RecyclerView.C0812h;
import android.support.v7.widget.RecyclerView.C0812h.C0839a;
import android.support.v7.widget.RecyclerView.C0813r;
import android.support.v7.widget.RecyclerView.C0844n;
import android.support.v7.widget.RecyclerView.C0850s;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class StaggeredGridLayoutManager extends C0812h {
    private final Runnable f2050A;
    ar f2051a;
    ar f2052b;
    boolean f2053c;
    int f2054d;
    int f2055e;
    C0868c f2056f;
    private int f2057g;
    private C0871e[] f2058h;
    private int f2059i;
    private int f2060j;
    private final aj f2061k;
    private boolean f2062l;
    private BitSet f2063m;
    private int f2064n;
    private boolean f2065o;
    private boolean f2066t;
    private C0870d f2067u;
    private int f2068v;
    private final Rect f2069w;
    private final C0864a f2070x;
    private boolean f2071y;
    private boolean f2072z;

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.1 */
    class C08621 implements Runnable {
        final /* synthetic */ StaggeredGridLayoutManager f2018a;

        C08621(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f2018a = staggeredGridLayoutManager;
        }

        public void run() {
            this.f2018a.m4353n();
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.2 */
    class C08632 extends al {
        final /* synthetic */ StaggeredGridLayoutManager f2019a;

        C08632(StaggeredGridLayoutManager staggeredGridLayoutManager, Context context) {
            this.f2019a = staggeredGridLayoutManager;
            super(context);
        }

        public PointF m4272a(int i) {
            int a = this.f2019a.m4361t(i);
            return a == 0 ? null : this.f2019a.f2059i == 0 ? new PointF((float) a, 0.0f) : new PointF(0.0f, (float) a);
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.a */
    class C0864a {
        int f2020a;
        int f2021b;
        boolean f2022c;
        boolean f2023d;
        boolean f2024e;
        final /* synthetic */ StaggeredGridLayoutManager f2025f;

        public C0864a(StaggeredGridLayoutManager staggeredGridLayoutManager) {
            this.f2025f = staggeredGridLayoutManager;
            m4273a();
        }

        void m4273a() {
            this.f2020a = -1;
            this.f2021b = Integer.MIN_VALUE;
            this.f2022c = false;
            this.f2023d = false;
            this.f2024e = false;
        }

        void m4274a(int i) {
            if (this.f2022c) {
                this.f2021b = this.f2025f.f2051a.m4673d() - i;
            } else {
                this.f2021b = this.f2025f.f2051a.m4671c() + i;
            }
        }

        void m4275b() {
            this.f2021b = this.f2022c ? this.f2025f.f2051a.m4673d() : this.f2025f.f2051a.m4671c();
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.b */
    public static class C0865b extends C0810i {
        C0871e f2026e;
        boolean f2027f;

        public C0865b(int i, int i2) {
            super(i, i2);
        }

        public C0865b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0865b(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0865b(MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public boolean m4276a() {
            return this.f2027f;
        }

        public final int m4277b() {
            return this.f2026e == null ? -1 : this.f2026e.f2047d;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.c */
    static class C0868c {
        int[] f2032a;
        List<C0867a> f2033b;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.c.a */
        static class C0867a implements Parcelable {
            public static final Creator<C0867a> CREATOR;
            int f2028a;
            int f2029b;
            int[] f2030c;
            boolean f2031d;

            /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.c.a.1 */
            static class C08661 implements Creator<C0867a> {
                C08661() {
                }

                public C0867a m4278a(Parcel parcel) {
                    return new C0867a(parcel);
                }

                public C0867a[] m4279a(int i) {
                    return new C0867a[i];
                }

                public /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return m4278a(parcel);
                }

                public /* synthetic */ Object[] newArray(int i) {
                    return m4279a(i);
                }
            }

            static {
                CREATOR = new C08661();
            }

            public C0867a(Parcel parcel) {
                boolean z = true;
                this.f2028a = parcel.readInt();
                this.f2029b = parcel.readInt();
                if (parcel.readInt() != 1) {
                    z = false;
                }
                this.f2031d = z;
                int readInt = parcel.readInt();
                if (readInt > 0) {
                    this.f2030c = new int[readInt];
                    parcel.readIntArray(this.f2030c);
                }
            }

            int m4280a(int i) {
                return this.f2030c == null ? 0 : this.f2030c[i];
            }

            public int describeContents() {
                return 0;
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f2028a + ", mGapDir=" + this.f2029b + ", mHasUnwantedGapAfter=" + this.f2031d + ", mGapPerSpan=" + Arrays.toString(this.f2030c) + '}';
            }

            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f2028a);
                parcel.writeInt(this.f2029b);
                parcel.writeInt(this.f2031d ? 1 : 0);
                if (this.f2030c == null || this.f2030c.length <= 0) {
                    parcel.writeInt(0);
                    return;
                }
                parcel.writeInt(this.f2030c.length);
                parcel.writeIntArray(this.f2030c);
            }
        }

        C0868c() {
        }

        private void m4281c(int i, int i2) {
            if (this.f2033b != null) {
                int i3 = i + i2;
                for (int size = this.f2033b.size() - 1; size >= 0; size--) {
                    C0867a c0867a = (C0867a) this.f2033b.get(size);
                    if (c0867a.f2028a >= i) {
                        if (c0867a.f2028a < i3) {
                            this.f2033b.remove(size);
                        } else {
                            c0867a.f2028a -= i2;
                        }
                    }
                }
            }
        }

        private void m4282d(int i, int i2) {
            if (this.f2033b != null) {
                for (int size = this.f2033b.size() - 1; size >= 0; size--) {
                    C0867a c0867a = (C0867a) this.f2033b.get(size);
                    if (c0867a.f2028a >= i) {
                        c0867a.f2028a += i2;
                    }
                }
            }
        }

        private int m4283g(int i) {
            if (this.f2033b == null) {
                return -1;
            }
            C0867a f = m4295f(i);
            if (f != null) {
                this.f2033b.remove(f);
            }
            int size = this.f2033b.size();
            int i2 = 0;
            while (i2 < size) {
                if (((C0867a) this.f2033b.get(i2)).f2028a >= i) {
                    break;
                }
                i2++;
            }
            i2 = -1;
            if (i2 == -1) {
                return -1;
            }
            f = (C0867a) this.f2033b.get(i2);
            this.f2033b.remove(i2);
            return f.f2028a;
        }

        int m4284a(int i) {
            if (this.f2033b != null) {
                for (int size = this.f2033b.size() - 1; size >= 0; size--) {
                    if (((C0867a) this.f2033b.get(size)).f2028a >= i) {
                        this.f2033b.remove(size);
                    }
                }
            }
            return m4290b(i);
        }

        public C0867a m4285a(int i, int i2, int i3, boolean z) {
            if (this.f2033b == null) {
                return null;
            }
            int size = this.f2033b.size();
            for (int i4 = 0; i4 < size; i4++) {
                C0867a c0867a = (C0867a) this.f2033b.get(i4);
                if (c0867a.f2028a >= i2) {
                    return null;
                }
                if (c0867a.f2028a >= i) {
                    if (i3 == 0 || c0867a.f2029b == i3) {
                        return c0867a;
                    }
                    if (z && c0867a.f2031d) {
                        return c0867a;
                    }
                }
            }
            return null;
        }

        void m4286a() {
            if (this.f2032a != null) {
                Arrays.fill(this.f2032a, -1);
            }
            this.f2033b = null;
        }

        void m4287a(int i, int i2) {
            if (this.f2032a != null && i < this.f2032a.length) {
                m4294e(i + i2);
                System.arraycopy(this.f2032a, i + i2, this.f2032a, i, (this.f2032a.length - i) - i2);
                Arrays.fill(this.f2032a, this.f2032a.length - i2, this.f2032a.length, -1);
                m4281c(i, i2);
            }
        }

        void m4288a(int i, C0871e c0871e) {
            m4294e(i);
            this.f2032a[i] = c0871e.f2047d;
        }

        public void m4289a(C0867a c0867a) {
            if (this.f2033b == null) {
                this.f2033b = new ArrayList();
            }
            int size = this.f2033b.size();
            for (int i = 0; i < size; i++) {
                C0867a c0867a2 = (C0867a) this.f2033b.get(i);
                if (c0867a2.f2028a == c0867a.f2028a) {
                    this.f2033b.remove(i);
                }
                if (c0867a2.f2028a >= c0867a.f2028a) {
                    this.f2033b.add(i, c0867a);
                    return;
                }
            }
            this.f2033b.add(c0867a);
        }

        int m4290b(int i) {
            if (this.f2032a == null || i >= this.f2032a.length) {
                return -1;
            }
            int g = m4283g(i);
            if (g == -1) {
                Arrays.fill(this.f2032a, i, this.f2032a.length, -1);
                return this.f2032a.length;
            }
            Arrays.fill(this.f2032a, i, g + 1, -1);
            return g + 1;
        }

        void m4291b(int i, int i2) {
            if (this.f2032a != null && i < this.f2032a.length) {
                m4294e(i + i2);
                System.arraycopy(this.f2032a, i, this.f2032a, i + i2, (this.f2032a.length - i) - i2);
                Arrays.fill(this.f2032a, i, i + i2, -1);
                m4282d(i, i2);
            }
        }

        int m4292c(int i) {
            return (this.f2032a == null || i >= this.f2032a.length) ? -1 : this.f2032a[i];
        }

        int m4293d(int i) {
            int length = this.f2032a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        void m4294e(int i) {
            if (this.f2032a == null) {
                this.f2032a = new int[(Math.max(i, 10) + 1)];
                Arrays.fill(this.f2032a, -1);
            } else if (i >= this.f2032a.length) {
                Object obj = this.f2032a;
                this.f2032a = new int[m4293d(i)];
                System.arraycopy(obj, 0, this.f2032a, 0, obj.length);
                Arrays.fill(this.f2032a, obj.length, this.f2032a.length, -1);
            }
        }

        public C0867a m4295f(int i) {
            if (this.f2033b == null) {
                return null;
            }
            for (int size = this.f2033b.size() - 1; size >= 0; size--) {
                C0867a c0867a = (C0867a) this.f2033b.get(size);
                if (c0867a.f2028a == i) {
                    return c0867a;
                }
            }
            return null;
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.d */
    public static class C0870d implements Parcelable {
        public static final Creator<C0870d> CREATOR;
        int f2034a;
        int f2035b;
        int f2036c;
        int[] f2037d;
        int f2038e;
        int[] f2039f;
        List<C0867a> f2040g;
        boolean f2041h;
        boolean f2042i;
        boolean f2043j;

        /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.d.1 */
        static class C08691 implements Creator<C0870d> {
            C08691() {
            }

            public C0870d m4296a(Parcel parcel) {
                return new C0870d(parcel);
            }

            public C0870d[] m4297a(int i) {
                return new C0870d[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m4296a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m4297a(i);
            }
        }

        static {
            CREATOR = new C08691();
        }

        C0870d(Parcel parcel) {
            boolean z = true;
            this.f2034a = parcel.readInt();
            this.f2035b = parcel.readInt();
            this.f2036c = parcel.readInt();
            if (this.f2036c > 0) {
                this.f2037d = new int[this.f2036c];
                parcel.readIntArray(this.f2037d);
            }
            this.f2038e = parcel.readInt();
            if (this.f2038e > 0) {
                this.f2039f = new int[this.f2038e];
                parcel.readIntArray(this.f2039f);
            }
            this.f2041h = parcel.readInt() == 1;
            this.f2042i = parcel.readInt() == 1;
            if (parcel.readInt() != 1) {
                z = false;
            }
            this.f2043j = z;
            this.f2040g = parcel.readArrayList(C0867a.class.getClassLoader());
        }

        public C0870d(C0870d c0870d) {
            this.f2036c = c0870d.f2036c;
            this.f2034a = c0870d.f2034a;
            this.f2035b = c0870d.f2035b;
            this.f2037d = c0870d.f2037d;
            this.f2038e = c0870d.f2038e;
            this.f2039f = c0870d.f2039f;
            this.f2041h = c0870d.f2041h;
            this.f2042i = c0870d.f2042i;
            this.f2043j = c0870d.f2043j;
            this.f2040g = c0870d.f2040g;
        }

        void m4298a() {
            this.f2037d = null;
            this.f2036c = 0;
            this.f2038e = 0;
            this.f2039f = null;
            this.f2040g = null;
        }

        void m4299b() {
            this.f2037d = null;
            this.f2036c = 0;
            this.f2034a = -1;
            this.f2035b = -1;
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2 = 1;
            parcel.writeInt(this.f2034a);
            parcel.writeInt(this.f2035b);
            parcel.writeInt(this.f2036c);
            if (this.f2036c > 0) {
                parcel.writeIntArray(this.f2037d);
            }
            parcel.writeInt(this.f2038e);
            if (this.f2038e > 0) {
                parcel.writeIntArray(this.f2039f);
            }
            parcel.writeInt(this.f2041h ? 1 : 0);
            parcel.writeInt(this.f2042i ? 1 : 0);
            if (!this.f2043j) {
                i2 = 0;
            }
            parcel.writeInt(i2);
            parcel.writeList(this.f2040g);
        }
    }

    /* renamed from: android.support.v7.widget.StaggeredGridLayoutManager.e */
    class C0871e {
        int f2044a;
        int f2045b;
        int f2046c;
        final int f2047d;
        final /* synthetic */ StaggeredGridLayoutManager f2048e;
        private ArrayList<View> f2049f;

        private C0871e(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
            this.f2048e = staggeredGridLayoutManager;
            this.f2049f = new ArrayList();
            this.f2044a = Integer.MIN_VALUE;
            this.f2045b = Integer.MIN_VALUE;
            this.f2046c = 0;
            this.f2047d = i;
        }

        int m4301a(int i) {
            if (this.f2044a != Integer.MIN_VALUE) {
                return this.f2044a;
            }
            if (this.f2049f.size() == 0) {
                return i;
            }
            m4303a();
            return this.f2044a;
        }

        public View m4302a(int i, int i2) {
            View view = null;
            int size;
            View view2;
            if (i2 == -1) {
                size = this.f2049f.size();
                int i3 = 0;
                while (i3 < size) {
                    view2 = (View) this.f2049f.get(i3);
                    if (!view2.isFocusable()) {
                        break;
                    }
                    if ((this.f2048e.m3836d(view2) > i) != this.f2048e.f2062l) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
                return view;
            }
            size = this.f2049f.size() - 1;
            while (size >= 0) {
                view2 = (View) this.f2049f.get(size);
                if (!view2.isFocusable()) {
                    break;
                }
                if ((this.f2048e.m3836d(view2) > i ? 1 : null) != (!this.f2048e.f2062l ? 1 : null)) {
                    break;
                }
                size--;
                view = view2;
            }
            return view;
        }

        void m4303a() {
            View view = (View) this.f2049f.get(0);
            C0865b c = m4309c(view);
            this.f2044a = this.f2048e.f2051a.m4666a(view);
            if (c.f2027f) {
                C0867a f = this.f2048e.f2056f.m4295f(c.m3737e());
                if (f != null && f.f2029b == -1) {
                    this.f2044a -= f.m4280a(this.f2047d);
                }
            }
        }

        void m4304a(View view) {
            C0865b c = m4309c(view);
            c.f2026e = this;
            this.f2049f.add(0, view);
            this.f2044a = Integer.MIN_VALUE;
            if (this.f2049f.size() == 1) {
                this.f2045b = Integer.MIN_VALUE;
            }
            if (c.m3735c() || c.m3736d()) {
                this.f2046c += this.f2048e.f2051a.m4676e(view);
            }
        }

        void m4305a(boolean z, int i) {
            int b = z ? m4307b(Integer.MIN_VALUE) : m4301a(Integer.MIN_VALUE);
            m4314e();
            if (b != Integer.MIN_VALUE) {
                if (z && b < this.f2048e.f2051a.m4673d()) {
                    return;
                }
                if (z || b <= this.f2048e.f2051a.m4671c()) {
                    if (i != Integer.MIN_VALUE) {
                        b += i;
                    }
                    this.f2045b = b;
                    this.f2044a = b;
                }
            }
        }

        int m4306b() {
            if (this.f2044a != Integer.MIN_VALUE) {
                return this.f2044a;
            }
            m4303a();
            return this.f2044a;
        }

        int m4307b(int i) {
            if (this.f2045b != Integer.MIN_VALUE) {
                return this.f2045b;
            }
            if (this.f2049f.size() == 0) {
                return i;
            }
            m4310c();
            return this.f2045b;
        }

        void m4308b(View view) {
            C0865b c = m4309c(view);
            c.f2026e = this;
            this.f2049f.add(view);
            this.f2045b = Integer.MIN_VALUE;
            if (this.f2049f.size() == 1) {
                this.f2044a = Integer.MIN_VALUE;
            }
            if (c.m3735c() || c.m3736d()) {
                this.f2046c += this.f2048e.f2051a.m4676e(view);
            }
        }

        C0865b m4309c(View view) {
            return (C0865b) view.getLayoutParams();
        }

        void m4310c() {
            View view = (View) this.f2049f.get(this.f2049f.size() - 1);
            C0865b c = m4309c(view);
            this.f2045b = this.f2048e.f2051a.m4670b(view);
            if (c.f2027f) {
                C0867a f = this.f2048e.f2056f.m4295f(c.m3737e());
                if (f != null && f.f2029b == 1) {
                    this.f2045b = f.m4280a(this.f2047d) + this.f2045b;
                }
            }
        }

        void m4311c(int i) {
            this.f2044a = i;
            this.f2045b = i;
        }

        int m4312d() {
            if (this.f2045b != Integer.MIN_VALUE) {
                return this.f2045b;
            }
            m4310c();
            return this.f2045b;
        }

        void m4313d(int i) {
            if (this.f2044a != Integer.MIN_VALUE) {
                this.f2044a += i;
            }
            if (this.f2045b != Integer.MIN_VALUE) {
                this.f2045b += i;
            }
        }

        void m4314e() {
            this.f2049f.clear();
            m4315f();
            this.f2046c = 0;
        }

        void m4315f() {
            this.f2044a = Integer.MIN_VALUE;
            this.f2045b = Integer.MIN_VALUE;
        }

        void m4316g() {
            int size = this.f2049f.size();
            View view = (View) this.f2049f.remove(size - 1);
            C0865b c = m4309c(view);
            c.f2026e = null;
            if (c.m3735c() || c.m3736d()) {
                this.f2046c -= this.f2048e.f2051a.m4676e(view);
            }
            if (size == 1) {
                this.f2044a = Integer.MIN_VALUE;
            }
            this.f2045b = Integer.MIN_VALUE;
        }

        void m4317h() {
            View view = (View) this.f2049f.remove(0);
            C0865b c = m4309c(view);
            c.f2026e = null;
            if (this.f2049f.size() == 0) {
                this.f2045b = Integer.MIN_VALUE;
            }
            if (c.m3735c() || c.m3736d()) {
                this.f2046c -= this.f2048e.f2051a.m4676e(view);
            }
            this.f2044a = Integer.MIN_VALUE;
        }

        public int m4318i() {
            return this.f2046c;
        }
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        boolean z = true;
        this.f2057g = -1;
        this.f2062l = false;
        this.f2053c = false;
        this.f2054d = -1;
        this.f2055e = Integer.MIN_VALUE;
        this.f2056f = new C0868c();
        this.f2064n = 2;
        this.f2069w = new Rect();
        this.f2070x = new C0864a(this);
        this.f2071y = false;
        this.f2072z = true;
        this.f2050A = new C08621(this);
        this.f2059i = i2;
        m4372a(i);
        if (this.f2064n == 0) {
            z = false;
        }
        m3832c(z);
        this.f2061k = new aj();
        m4351m();
    }

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        boolean z = true;
        this.f2057g = -1;
        this.f2062l = false;
        this.f2053c = false;
        this.f2054d = -1;
        this.f2055e = Integer.MIN_VALUE;
        this.f2056f = new C0868c();
        this.f2064n = 2;
        this.f2069w = new Rect();
        this.f2070x = new C0864a(this);
        this.f2071y = false;
        this.f2072z = true;
        this.f2050A = new C08621(this);
        C0839a a = C0812h.m3746a(context, attributeSet, i, i2);
        m4392b(a.f1911a);
        m4372a(a.f1912b);
        m4386a(a.f1913c);
        if (this.f2064n == 0) {
            z = false;
        }
        m3832c(z);
        this.f2061k = new aj();
        m4351m();
    }

    private void m4319J() {
        boolean z = true;
        if (this.f2059i == 1 || !m4410h()) {
            this.f2053c = this.f2062l;
            return;
        }
        if (this.f2062l) {
            z = false;
        }
        this.f2053c = z;
    }

    private void m4320K() {
        if (this.f2052b.m4680h() != 1073741824) {
            float f = 0.0f;
            int u = m3875u();
            int i = 0;
            while (i < u) {
                float f2;
                View i2 = m3858i(i);
                float e = (float) this.f2052b.m4676e(i2);
                if (e < f) {
                    f2 = f;
                } else {
                    f2 = Math.max(f, ((C0865b) i2.getLayoutParams()).m4276a() ? (1.0f * e) / ((float) this.f2057g) : e);
                }
                i++;
                f = f2;
            }
            i = this.f2060j;
            int round = Math.round(((float) this.f2057g) * f);
            if (this.f2052b.m4680h() == Integer.MIN_VALUE) {
                round = Math.min(round, this.f2052b.m4677f());
            }
            m4401d(round);
            if (this.f2060j != i) {
                for (int i3 = 0; i3 < u; i3++) {
                    View i4 = m3858i(i3);
                    C0865b c0865b = (C0865b) i4.getLayoutParams();
                    if (!c0865b.f2027f) {
                        if (m4410h() && this.f2059i == 1) {
                            i4.offsetLeftAndRight(((-((this.f2057g - 1) - c0865b.f2026e.f2047d)) * this.f2060j) - ((-((this.f2057g - 1) - c0865b.f2026e.f2047d)) * i));
                        } else {
                            int i5 = c0865b.f2026e.f2047d * this.f2060j;
                            round = c0865b.f2026e.f2047d * i;
                            if (this.f2059i == 1) {
                                i4.offsetLeftAndRight(i5 - round);
                            } else {
                                i4.offsetTopAndBottom(i5 - round);
                            }
                        }
                    }
                }
            }
        }
    }

    private int m4321L() {
        int u = m3875u();
        return u == 0 ? 0 : m3836d(m3858i(u - 1));
    }

    private int m4322M() {
        return m3875u() == 0 ? 0 : m3836d(m3858i(0));
    }

    private int m4323a(C0844n c0844n, aj ajVar, C0850s c0850s) {
        int q;
        this.f2063m.set(0, this.f2057g, true);
        int i = this.f2061k.f2256i ? ajVar.f2252e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : ajVar.f2252e == 1 ? ajVar.f2254g + ajVar.f2249b : ajVar.f2253f - ajVar.f2249b;
        m4346e(ajVar.f2252e, i);
        int d = this.f2053c ? this.f2051a.m4673d() : this.f2051a.m4671c();
        Object obj = null;
        while (ajVar.m4643a(c0850s) && (this.f2061k.f2256i || !this.f2063m.isEmpty())) {
            C0871e c0871e;
            int e;
            int e2;
            View a = ajVar.m4642a(c0844n);
            C0865b c0865b = (C0865b) a.getLayoutParams();
            int e3 = c0865b.m3737e();
            int c = this.f2056f.m4292c(e3);
            Object obj2 = c == -1 ? 1 : null;
            if (obj2 != null) {
                C0871e a2 = c0865b.f2027f ? this.f2058h[0] : m4325a(ajVar);
                this.f2056f.m4288a(e3, a2);
                c0871e = a2;
            } else {
                c0871e = this.f2058h[c];
            }
            c0865b.f2026e = c0871e;
            if (ajVar.f2252e == 1) {
                m3819b(a);
            } else {
                m3820b(a, 0);
            }
            m4334a(a, c0865b, false);
            if (ajVar.f2252e == 1) {
                q = c0865b.f2027f ? m4357q(d) : c0871e.m4307b(d);
                e = q + this.f2051a.m4676e(a);
                if (obj2 == null || !c0865b.f2027f) {
                    c = q;
                } else {
                    C0867a m = m4350m(q);
                    m.f2029b = -1;
                    m.f2028a = e3;
                    this.f2056f.m4289a(m);
                    c = q;
                }
            } else {
                q = c0865b.f2027f ? m4355p(d) : c0871e.m4301a(d);
                c = q - this.f2051a.m4676e(a);
                if (obj2 != null && c0865b.f2027f) {
                    C0867a n = m4352n(q);
                    n.f2029b = 1;
                    n.f2028a = e3;
                    this.f2056f.m4289a(n);
                }
                e = q;
            }
            if (c0865b.f2027f && ajVar.f2251d == -1) {
                if (obj2 != null) {
                    this.f2071y = true;
                } else {
                    obj = ajVar.f2252e == 1 ? !m4413j() ? 1 : null : !m4415k() ? 1 : null;
                    if (obj != null) {
                        C0867a f = this.f2056f.m4295f(e3);
                        if (f != null) {
                            f.f2031d = true;
                        }
                        this.f2071y = true;
                    }
                }
            }
            m4333a(a, c0865b, ajVar);
            if (m4410h() && this.f2059i == 1) {
                q = c0865b.f2027f ? this.f2052b.m4673d() : this.f2052b.m4673d() - (((this.f2057g - 1) - c0871e.f2047d) * this.f2060j);
                e2 = q - this.f2052b.m4676e(a);
                e3 = q;
            } else {
                q = c0865b.f2027f ? this.f2052b.m4671c() : (c0871e.f2047d * this.f2060j) + this.f2052b.m4671c();
                e3 = q + this.f2052b.m4676e(a);
                e2 = q;
            }
            if (this.f2059i == 1) {
                m3793a(a, e2, c, e3, e);
            } else {
                m3793a(a, c, e2, e, e3);
            }
            if (c0865b.f2027f) {
                m4346e(this.f2061k.f2252e, i);
            } else {
                m4331a(c0871e, this.f2061k.f2252e, i);
            }
            m4329a(c0844n, this.f2061k);
            if (this.f2061k.f2255h && a.isFocusable()) {
                if (c0865b.f2027f) {
                    this.f2063m.clear();
                } else {
                    this.f2063m.set(c0871e.f2047d, false);
                }
            }
            obj = 1;
        }
        if (obj == null) {
            m4329a(c0844n, this.f2061k);
        }
        q = this.f2061k.f2252e == -1 ? this.f2051a.m4671c() - m4355p(this.f2051a.m4671c()) : m4357q(this.f2051a.m4673d()) - this.f2051a.m4673d();
        return q > 0 ? Math.min(ajVar.f2249b, q) : 0;
    }

    private C0871e m4325a(aj ajVar) {
        int i;
        int i2;
        C0871e c0871e = null;
        int i3 = -1;
        if (m4360s(ajVar.f2252e)) {
            i = this.f2057g - 1;
            i2 = -1;
        } else {
            i = 0;
            i2 = this.f2057g;
            i3 = 1;
        }
        int c;
        int i4;
        C0871e c0871e2;
        int b;
        C0871e c0871e3;
        if (ajVar.f2252e == 1) {
            c = this.f2051a.m4671c();
            i4 = i;
            i = Integer.MAX_VALUE;
            while (i4 != i2) {
                c0871e2 = this.f2058h[i4];
                b = c0871e2.m4307b(c);
                if (b < i) {
                    c0871e3 = c0871e2;
                } else {
                    b = i;
                    c0871e3 = c0871e;
                }
                i4 += i3;
                c0871e = c0871e3;
                i = b;
            }
        } else {
            c = this.f2051a.m4673d();
            i4 = i;
            i = Integer.MIN_VALUE;
            while (i4 != i2) {
                c0871e2 = this.f2058h[i4];
                b = c0871e2.m4301a(c);
                if (b > i) {
                    c0871e3 = c0871e2;
                } else {
                    b = i;
                    c0871e3 = c0871e;
                }
                i4 += i3;
                c0871e = c0871e3;
                i = b;
            }
        }
        return c0871e;
    }

    private void m4326a(int i, C0850s c0850s) {
        int c;
        int i2;
        aj ajVar;
        boolean z = false;
        this.f2061k.f2249b = 0;
        this.f2061k.f2250c = i;
        if (m3872r()) {
            c = c0850s.m4220c();
            if (c != -1) {
                if (this.f2053c == (c < i)) {
                    c = this.f2051a.m4677f();
                    i2 = 0;
                } else {
                    i2 = this.f2051a.m4677f();
                    c = 0;
                }
                if (m3871q()) {
                    this.f2061k.f2254g = c + this.f2051a.m4675e();
                    this.f2061k.f2253f = -i2;
                } else {
                    this.f2061k.f2253f = this.f2051a.m4671c() - i2;
                    this.f2061k.f2254g = c + this.f2051a.m4673d();
                }
                this.f2061k.f2255h = false;
                this.f2061k.f2248a = true;
                ajVar = this.f2061k;
                if (this.f2051a.m4680h() == 0 && this.f2051a.m4675e() == 0) {
                    z = true;
                }
                ajVar.f2256i = z;
            }
        }
        c = 0;
        i2 = 0;
        if (m3871q()) {
            this.f2061k.f2254g = c + this.f2051a.m4675e();
            this.f2061k.f2253f = -i2;
        } else {
            this.f2061k.f2253f = this.f2051a.m4671c() - i2;
            this.f2061k.f2254g = c + this.f2051a.m4673d();
        }
        this.f2061k.f2255h = false;
        this.f2061k.f2248a = true;
        ajVar = this.f2061k;
        z = true;
        ajVar.f2256i = z;
    }

    private void m4327a(C0844n c0844n, int i) {
        while (m3875u() > 0) {
            View i2 = m3858i(0);
            if (this.f2051a.m4670b(i2) <= i && this.f2051a.m4672c(i2) <= i) {
                C0865b c0865b = (C0865b) i2.getLayoutParams();
                if (c0865b.f2027f) {
                    int i3 = 0;
                    while (i3 < this.f2057g) {
                        if (this.f2058h[i3].f2049f.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (i3 = 0; i3 < this.f2057g; i3++) {
                        this.f2058h[i3].m4317h();
                    }
                } else if (c0865b.f2026e.f2049f.size() != 1) {
                    c0865b.f2026e.m4317h();
                } else {
                    return;
                }
                m3797a(i2, c0844n);
            } else {
                return;
            }
        }
    }

    private void m4328a(C0844n c0844n, C0850s c0850s, boolean z) {
        C0864a c0864a = this.f2070x;
        if (!(this.f2067u == null && this.f2054d == -1) && c0850s.m4222e() == 0) {
            m3826c(c0844n);
            c0864a.m4273a();
            return;
        }
        boolean z2;
        if (!(c0864a.f2024e && this.f2054d == -1 && this.f2067u == null)) {
            c0864a.m4273a();
            if (this.f2067u != null) {
                m4330a(c0864a);
            } else {
                m4319J();
                c0864a.f2022c = this.f2053c;
            }
            m4377a(c0850s, c0864a);
            c0864a.f2024e = true;
        }
        if (this.f2067u == null && this.f2054d == -1 && !(c0864a.f2022c == this.f2065o && m4410h() == this.f2066t)) {
            this.f2056f.m4286a();
            c0864a.f2023d = true;
        }
        if (m3875u() > 0 && (this.f2067u == null || this.f2067u.f2036c < 1)) {
            int i;
            if (c0864a.f2023d) {
                for (i = 0; i < this.f2057g; i++) {
                    this.f2058h[i].m4314e();
                    if (c0864a.f2021b != Integer.MIN_VALUE) {
                        this.f2058h[i].m4311c(c0864a.f2021b);
                    }
                }
            } else {
                for (i = 0; i < this.f2057g; i++) {
                    this.f2058h[i].m4305a(this.f2053c, c0864a.f2021b);
                }
            }
        }
        m3777a(c0844n);
        this.f2061k.f2248a = false;
        this.f2071y = false;
        m4401d(this.f2052b.m4677f());
        m4326a(c0864a.f2020a, c0850s);
        if (c0864a.f2022c) {
            m4347f(-1);
            m4323a(c0844n, this.f2061k, c0850s);
            m4347f(1);
            this.f2061k.f2250c = c0864a.f2020a + this.f2061k.f2251d;
            m4323a(c0844n, this.f2061k, c0850s);
        } else {
            m4347f(1);
            m4323a(c0844n, this.f2061k, c0850s);
            m4347f(-1);
            this.f2061k.f2250c = c0864a.f2020a + this.f2061k.f2251d;
            m4323a(c0844n, this.f2061k, c0850s);
        }
        m4320K();
        if (m3875u() > 0) {
            if (this.f2053c) {
                m4341b(c0844n, c0850s, true);
                m4343c(c0844n, c0850s, false);
            } else {
                m4343c(c0844n, c0850s, true);
                m4341b(c0844n, c0850s, false);
            }
        }
        if (z && !c0850s.m4218a()) {
            z2 = this.f2064n != 0 && m3875u() > 0 && (this.f2071y || m4390b() != null);
            if (z2) {
                m3811a(this.f2050A);
                if (m4353n()) {
                    z2 = true;
                    if (c0850s.m4218a()) {
                        this.f2070x.m4273a();
                    }
                    this.f2065o = c0864a.f2022c;
                    this.f2066t = m4410h();
                    if (z2) {
                        this.f2070x.m4273a();
                        m4328a(c0844n, c0850s, false);
                    }
                }
            }
        }
        z2 = false;
        if (c0850s.m4218a()) {
            this.f2070x.m4273a();
        }
        this.f2065o = c0864a.f2022c;
        this.f2066t = m4410h();
        if (z2) {
            this.f2070x.m4273a();
            m4328a(c0844n, c0850s, false);
        }
    }

    private void m4329a(C0844n c0844n, aj ajVar) {
        if (ajVar.f2248a && !ajVar.f2256i) {
            if (ajVar.f2249b == 0) {
                if (ajVar.f2252e == -1) {
                    m4340b(c0844n, ajVar.f2254g);
                } else {
                    m4327a(c0844n, ajVar.f2253f);
                }
            } else if (ajVar.f2252e == -1) {
                r0 = ajVar.f2253f - m4354o(ajVar.f2253f);
                m4340b(c0844n, r0 < 0 ? ajVar.f2254g : ajVar.f2254g - Math.min(r0, ajVar.f2249b));
            } else {
                r0 = m4359r(ajVar.f2254g) - ajVar.f2254g;
                m4327a(c0844n, r0 < 0 ? ajVar.f2253f : Math.min(r0, ajVar.f2249b) + ajVar.f2253f);
            }
        }
    }

    private void m4330a(C0864a c0864a) {
        if (this.f2067u.f2036c > 0) {
            if (this.f2067u.f2036c == this.f2057g) {
                for (int i = 0; i < this.f2057g; i++) {
                    this.f2058h[i].m4314e();
                    int i2 = this.f2067u.f2037d[i];
                    if (i2 != Integer.MIN_VALUE) {
                        i2 = this.f2067u.f2042i ? i2 + this.f2051a.m4673d() : i2 + this.f2051a.m4671c();
                    }
                    this.f2058h[i].m4311c(i2);
                }
            } else {
                this.f2067u.m4298a();
                this.f2067u.f2034a = this.f2067u.f2035b;
            }
        }
        this.f2066t = this.f2067u.f2043j;
        m4386a(this.f2067u.f2041h);
        m4319J();
        if (this.f2067u.f2034a != -1) {
            this.f2054d = this.f2067u.f2034a;
            c0864a.f2022c = this.f2067u.f2042i;
        } else {
            c0864a.f2022c = this.f2053c;
        }
        if (this.f2067u.f2038e > 1) {
            this.f2056f.f2032a = this.f2067u.f2039f;
            this.f2056f.f2033b = this.f2067u.f2040g;
        }
    }

    private void m4331a(C0871e c0871e, int i, int i2) {
        int i3 = c0871e.m4318i();
        if (i == -1) {
            if (i3 + c0871e.m4306b() <= i2) {
                this.f2063m.set(c0871e.f2047d, false);
            }
        } else if (c0871e.m4312d() - i3 >= i2) {
            this.f2063m.set(c0871e.f2047d, false);
        }
    }

    private void m4332a(View view, int i, int i2, boolean z) {
        m3821b(view, this.f2069w);
        C0865b c0865b = (C0865b) view.getLayoutParams();
        int b = m4337b(i, c0865b.leftMargin + this.f2069w.left, c0865b.rightMargin + this.f2069w.right);
        int b2 = m4337b(i2, c0865b.topMargin + this.f2069w.top, c0865b.bottomMargin + this.f2069w.bottom);
        if (z ? m3809a(view, b, b2, (C0810i) c0865b) : m3822b(view, b, b2, c0865b)) {
            view.measure(b, b2);
        }
    }

    private void m4333a(View view, C0865b c0865b, aj ajVar) {
        if (ajVar.f2252e == 1) {
            if (c0865b.f2027f) {
                m4356p(view);
            } else {
                c0865b.f2026e.m4308b(view);
            }
        } else if (c0865b.f2027f) {
            m4358q(view);
        } else {
            c0865b.f2026e.m4304a(view);
        }
    }

    private void m4334a(View view, C0865b c0865b, boolean z) {
        if (c0865b.f2027f) {
            if (this.f2059i == 1) {
                m4332a(view, this.f2068v, C0812h.m3745a(m3879y(), m3877w(), 0, c0865b.height, true), z);
            } else {
                m4332a(view, C0812h.m3745a(m3878x(), m3876v(), 0, c0865b.width, true), this.f2068v, z);
            }
        } else if (this.f2059i == 1) {
            m4332a(view, C0812h.m3745a(this.f2060j, m3876v(), 0, c0865b.width, false), C0812h.m3745a(m3879y(), m3877w(), 0, c0865b.height, true), z);
        } else {
            m4332a(view, C0812h.m3745a(m3878x(), m3876v(), 0, c0865b.width, true), C0812h.m3745a(this.f2060j, m3877w(), 0, c0865b.height, false), z);
        }
    }

    private boolean m4335a(C0871e c0871e) {
        boolean z = true;
        if (this.f2053c) {
            if (c0871e.m4312d() < this.f2051a.m4673d()) {
                return !c0871e.m4309c((View) c0871e.f2049f.get(c0871e.f2049f.size() + -1)).f2027f;
            }
        } else if (c0871e.m4306b() > this.f2051a.m4671c()) {
            if (c0871e.m4309c((View) c0871e.f2049f.get(0)).f2027f) {
                z = false;
            }
            return z;
        }
        return false;
    }

    private int m4337b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? MeasureSpec.makeMeasureSpec(Math.max(0, (MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    private int m4338b(C0850s c0850s) {
        boolean z = false;
        if (m3875u() == 0) {
            return 0;
        }
        ar arVar = this.f2051a;
        View a = m4371a(!this.f2072z, true);
        if (!this.f2072z) {
            z = true;
        }
        return aw.m4726a(c0850s, arVar, a, m4391b(z, true), this, this.f2072z, this.f2053c);
    }

    private void m4340b(C0844n c0844n, int i) {
        int u = m3875u() - 1;
        while (u >= 0) {
            View i2 = m3858i(u);
            if (this.f2051a.m4666a(i2) >= i && this.f2051a.m4674d(i2) >= i) {
                C0865b c0865b = (C0865b) i2.getLayoutParams();
                if (c0865b.f2027f) {
                    int i3 = 0;
                    while (i3 < this.f2057g) {
                        if (this.f2058h[i3].f2049f.size() != 1) {
                            i3++;
                        } else {
                            return;
                        }
                    }
                    for (i3 = 0; i3 < this.f2057g; i3++) {
                        this.f2058h[i3].m4316g();
                    }
                } else if (c0865b.f2026e.f2049f.size() != 1) {
                    c0865b.f2026e.m4316g();
                } else {
                    return;
                }
                m3797a(i2, c0844n);
                u--;
            } else {
                return;
            }
        }
    }

    private void m4341b(C0844n c0844n, C0850s c0850s, boolean z) {
        int q = m4357q(Integer.MIN_VALUE);
        if (q != Integer.MIN_VALUE) {
            q = this.f2051a.m4673d() - q;
            if (q > 0) {
                q -= -m4395c(-q, c0844n, c0850s);
                if (z && q > 0) {
                    this.f2051a.m4668a(q);
                }
            }
        }
    }

    private void m4342c(int i, int i2, int i3) {
        int i4;
        int i5;
        int L = this.f2053c ? m4321L() : m4322M();
        if (i3 != 8) {
            i4 = i + i2;
            i5 = i;
        } else if (i < i2) {
            i4 = i2 + 1;
            i5 = i;
        } else {
            i4 = i + 1;
            i5 = i2;
        }
        this.f2056f.m4290b(i5);
        switch (i3) {
            case C1373c.View_android_focusable /*1*/:
                this.f2056f.m4291b(i, i2);
                break;
            case C1373c.View_paddingStart /*2*/:
                this.f2056f.m4287a(i, i2);
                break;
            case C1373c.Toolbar_contentInsetRight /*8*/:
                this.f2056f.m4287a(i, 1);
                this.f2056f.m4291b(i2, 1);
                break;
        }
        if (i4 > L) {
            if (i5 <= (this.f2053c ? m4322M() : m4321L())) {
                m3869o();
            }
        }
    }

    private void m4343c(C0844n c0844n, C0850s c0850s, boolean z) {
        int p = m4355p(Integer.MAX_VALUE);
        if (p != Integer.MAX_VALUE) {
            p -= this.f2051a.m4671c();
            if (p > 0) {
                p -= m4395c(p, c0844n, c0850s);
                if (z && p > 0) {
                    this.f2051a.m4668a(-p);
                }
            }
        }
    }

    private boolean m4344c(C0850s c0850s, C0864a c0864a) {
        c0864a.f2020a = this.f2065o ? m4363v(c0850s.m4222e()) : m4362u(c0850s.m4222e());
        c0864a.f2021b = Integer.MIN_VALUE;
        return true;
    }

    private void m4346e(int i, int i2) {
        for (int i3 = 0; i3 < this.f2057g; i3++) {
            if (!this.f2058h[i3].f2049f.isEmpty()) {
                m4331a(this.f2058h[i3], i, i2);
            }
        }
    }

    private void m4347f(int i) {
        int i2 = 1;
        this.f2061k.f2252e = i;
        aj ajVar = this.f2061k;
        if (this.f2053c != (i == -1)) {
            i2 = -1;
        }
        ajVar.f2251d = i2;
    }

    private int m4348i(C0850s c0850s) {
        boolean z = false;
        if (m3875u() == 0) {
            return 0;
        }
        ar arVar = this.f2051a;
        View a = m4371a(!this.f2072z, true);
        if (!this.f2072z) {
            z = true;
        }
        return aw.m4725a(c0850s, arVar, a, m4391b(z, true), this, this.f2072z);
    }

    private int m4349j(C0850s c0850s) {
        boolean z = false;
        if (m3875u() == 0) {
            return 0;
        }
        ar arVar = this.f2051a;
        View a = m4371a(!this.f2072z, true);
        if (!this.f2072z) {
            z = true;
        }
        return aw.m4727b(c0850s, arVar, a, m4391b(z, true), this, this.f2072z);
    }

    private C0867a m4350m(int i) {
        C0867a c0867a = new C0867a();
        c0867a.f2030c = new int[this.f2057g];
        for (int i2 = 0; i2 < this.f2057g; i2++) {
            c0867a.f2030c[i2] = i - this.f2058h[i2].m4307b(i);
        }
        return c0867a;
    }

    private void m4351m() {
        this.f2051a = ar.m4664a(this, this.f2059i);
        this.f2052b = ar.m4664a(this, 1 - this.f2059i);
    }

    private C0867a m4352n(int i) {
        C0867a c0867a = new C0867a();
        c0867a.f2030c = new int[this.f2057g];
        for (int i2 = 0; i2 < this.f2057g; i2++) {
            c0867a.f2030c[i2] = this.f2058h[i2].m4301a(i) - i;
        }
        return c0867a;
    }

    private boolean m4353n() {
        if (m3875u() == 0 || this.f2064n == 0 || !m3870p()) {
            return false;
        }
        int L;
        int M;
        if (this.f2053c) {
            L = m4321L();
            M = m4322M();
        } else {
            L = m4322M();
            M = m4321L();
        }
        if (L == 0 && m4390b() != null) {
            this.f2056f.m4286a();
            m3763H();
            m3869o();
            return true;
        } else if (!this.f2071y) {
            return false;
        } else {
            int i = this.f2053c ? -1 : 1;
            C0867a a = this.f2056f.m4285a(L, M + 1, i, true);
            if (a == null) {
                this.f2071y = false;
                this.f2056f.m4284a(M + 1);
                return false;
            }
            C0867a a2 = this.f2056f.m4285a(L, a.f2028a, i * -1, true);
            if (a2 == null) {
                this.f2056f.m4284a(a.f2028a);
            } else {
                this.f2056f.m4284a(a2.f2028a + 1);
            }
            m3763H();
            m3869o();
            return true;
        }
    }

    private int m4354o(int i) {
        int a = this.f2058h[0].m4301a(i);
        for (int i2 = 1; i2 < this.f2057g; i2++) {
            int a2 = this.f2058h[i2].m4301a(i);
            if (a2 > a) {
                a = a2;
            }
        }
        return a;
    }

    private int m4355p(int i) {
        int a = this.f2058h[0].m4301a(i);
        for (int i2 = 1; i2 < this.f2057g; i2++) {
            int a2 = this.f2058h[i2].m4301a(i);
            if (a2 < a) {
                a = a2;
            }
        }
        return a;
    }

    private void m4356p(View view) {
        for (int i = this.f2057g - 1; i >= 0; i--) {
            this.f2058h[i].m4308b(view);
        }
    }

    private int m4357q(int i) {
        int b = this.f2058h[0].m4307b(i);
        for (int i2 = 1; i2 < this.f2057g; i2++) {
            int b2 = this.f2058h[i2].m4307b(i);
            if (b2 > b) {
                b = b2;
            }
        }
        return b;
    }

    private void m4358q(View view) {
        for (int i = this.f2057g - 1; i >= 0; i--) {
            this.f2058h[i].m4304a(view);
        }
    }

    private int m4359r(int i) {
        int b = this.f2058h[0].m4307b(i);
        for (int i2 = 1; i2 < this.f2057g; i2++) {
            int b2 = this.f2058h[i2].m4307b(i);
            if (b2 < b) {
                b = b2;
            }
        }
        return b;
    }

    private boolean m4360s(int i) {
        if (this.f2059i == 0) {
            return (i == -1) != this.f2053c;
        } else {
            return ((i == -1) == this.f2053c) == m4410h();
        }
    }

    private int m4361t(int i) {
        int i2 = -1;
        if (m3875u() == 0) {
            return this.f2053c ? 1 : -1;
        } else {
            if ((i < m4322M()) == this.f2053c) {
                i2 = 1;
            }
            return i2;
        }
    }

    private int m4362u(int i) {
        int u = m3875u();
        for (int i2 = 0; i2 < u; i2++) {
            int d = m3836d(m3858i(i2));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m4363v(int i) {
        for (int u = m3875u() - 1; u >= 0; u--) {
            int d = m3836d(m3858i(u));
            if (d >= 0 && d < i) {
                return d;
            }
        }
        return 0;
    }

    private int m4364w(int i) {
        int i2 = Integer.MIN_VALUE;
        int i3 = 1;
        switch (i) {
            case C1373c.View_android_focusable /*1*/:
                return (this.f2059i == 1 || !m4410h()) ? -1 : 1;
            case C1373c.View_paddingStart /*2*/:
                return this.f2059i == 1 ? 1 : !m4410h() ? 1 : -1;
            case C1373c.Toolbar_titleMarginTop /*17*/:
                return this.f2059i != 0 ? Integer.MIN_VALUE : -1;
            case C1373c.AppCompatTheme_actionModeCopyDrawable /*33*/:
                return this.f2059i != 1 ? Integer.MIN_VALUE : -1;
            case C1373c.AppCompatTheme_textAppearanceSearchResultTitle /*66*/:
                if (this.f2059i != 0) {
                    i3 = Integer.MIN_VALUE;
                }
                return i3;
            case 130:
                if (this.f2059i == 1) {
                    i2 = 1;
                }
                return i2;
            default:
                return Integer.MIN_VALUE;
        }
    }

    public int m4365a(int i, C0844n c0844n, C0850s c0850s) {
        return m4395c(i, c0844n, c0850s);
    }

    public int m4366a(C0844n c0844n, C0850s c0850s) {
        return this.f2059i == 0 ? this.f2057g : super.m3766a(c0844n, c0850s);
    }

    public C0810i m4367a() {
        return this.f2059i == 0 ? new C0865b(-2, -1) : new C0865b(-1, -2);
    }

    public C0810i m4368a(Context context, AttributeSet attributeSet) {
        return new C0865b(context, attributeSet);
    }

    public C0810i m4369a(LayoutParams layoutParams) {
        return layoutParams instanceof MarginLayoutParams ? new C0865b((MarginLayoutParams) layoutParams) : new C0865b(layoutParams);
    }

    public View m4370a(View view, int i, C0844n c0844n, C0850s c0850s) {
        int i2 = 0;
        if (m3875u() == 0) {
            return null;
        }
        View e = m3842e(view);
        if (e == null) {
            return null;
        }
        m4319J();
        int w = m4364w(i);
        if (w == Integer.MIN_VALUE) {
            return null;
        }
        View a;
        C0865b c0865b = (C0865b) e.getLayoutParams();
        boolean z = c0865b.f2027f;
        C0871e c0871e = c0865b.f2026e;
        int L = w == 1 ? m4321L() : m4322M();
        m4326a(L, c0850s);
        m4347f(w);
        this.f2061k.f2250c = this.f2061k.f2251d + L;
        this.f2061k.f2249b = (int) (0.33333334f * ((float) this.f2051a.m4677f()));
        this.f2061k.f2255h = true;
        this.f2061k.f2248a = false;
        m4323a(c0844n, this.f2061k, c0850s);
        this.f2065o = this.f2053c;
        if (!z) {
            a = c0871e.m4302a(L, w);
            if (!(a == null || a == e)) {
                return a;
            }
        }
        if (m4360s(w)) {
            for (int i3 = this.f2057g - 1; i3 >= 0; i3--) {
                View a2 = this.f2058h[i3].m4302a(L, w);
                if (a2 != null && a2 != e) {
                    return a2;
                }
            }
        } else {
            while (i2 < this.f2057g) {
                a = this.f2058h[i2].m4302a(L, w);
                if (a != null && a != e) {
                    return a;
                }
                i2++;
            }
        }
        return null;
    }

    View m4371a(boolean z, boolean z2) {
        int c = this.f2051a.m4671c();
        int d = this.f2051a.m4673d();
        int u = m3875u();
        View view = null;
        for (int i = 0; i < u; i++) {
            View i2 = m3858i(i);
            int a = this.f2051a.m4666a(i2);
            if (this.f2051a.m4670b(i2) > c && a < d) {
                if (a >= c || !z) {
                    return i2;
                }
                if (z2 && view == null) {
                    view = i2;
                }
            }
        }
        return view;
    }

    public void m4372a(int i) {
        m4385a(null);
        if (i != this.f2057g) {
            m4408g();
            this.f2057g = i;
            this.f2063m = new BitSet(this.f2057g);
            this.f2058h = new C0871e[this.f2057g];
            for (int i2 = 0; i2 < this.f2057g; i2++) {
                this.f2058h[i2] = new C0871e(i2, null);
            }
            m3869o();
        }
    }

    public void m4373a(Rect rect, int i, int i2) {
        int B = m3757B() + m3880z();
        int A = m3756A() + m3758C();
        if (this.f2059i == 1) {
            A = C0812h.m3744a(i2, A + rect.height(), m3761F());
            B = C0812h.m3744a(i, B + (this.f2060j * this.f2057g), m3760E());
        } else {
            B = C0812h.m3744a(i, B + rect.width(), m3760E());
            A = C0812h.m3744a(i2, A + (this.f2060j * this.f2057g), m3761F());
        }
        m3839d(B, A);
    }

    public void m4374a(Parcelable parcelable) {
        if (parcelable instanceof C0870d) {
            this.f2067u = (C0870d) parcelable;
            m3869o();
        }
    }

    public void m4375a(C0844n c0844n, C0850s c0850s, View view, C0416c c0416c) {
        LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof C0865b) {
            C0865b c0865b = (C0865b) layoutParams;
            if (this.f2059i == 0) {
                c0416c.m1577b(C0415l.m1565a(c0865b.m4277b(), c0865b.f2027f ? this.f2057g : 1, -1, -1, c0865b.f2027f, false));
                return;
            } else {
                c0416c.m1577b(C0415l.m1565a(-1, -1, c0865b.m4277b(), c0865b.f2027f ? this.f2057g : 1, c0865b.f2027f, false));
                return;
            }
        }
        super.m3796a(view, c0416c);
    }

    public void m4376a(C0850s c0850s) {
        super.m3783a(c0850s);
        this.f2054d = -1;
        this.f2055e = Integer.MIN_VALUE;
        this.f2067u = null;
        this.f2070x.m4273a();
    }

    void m4377a(C0850s c0850s, C0864a c0864a) {
        if (!m4394b(c0850s, c0864a) && !m4344c(c0850s, c0864a)) {
            c0864a.m4275b();
            c0864a.f2020a = 0;
        }
    }

    public void m4378a(RecyclerView recyclerView) {
        this.f2056f.m4286a();
        m3869o();
    }

    public void m4379a(RecyclerView recyclerView, int i, int i2) {
        m4342c(i, i2, 1);
    }

    public void m4380a(RecyclerView recyclerView, int i, int i2, int i3) {
        m4342c(i, i2, 8);
    }

    public void m4381a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m4342c(i, i2, 4);
    }

    public void m4382a(RecyclerView recyclerView, C0844n c0844n) {
        m3811a(this.f2050A);
        for (int i = 0; i < this.f2057g; i++) {
            this.f2058h[i].m4314e();
        }
        recyclerView.requestLayout();
    }

    public void m4383a(RecyclerView recyclerView, C0850s c0850s, int i) {
        C0813r c08632 = new C08632(this, recyclerView.getContext());
        c08632.m4000d(i);
        m3782a(c08632);
    }

    public void m4384a(AccessibilityEvent accessibilityEvent) {
        super.m3799a(accessibilityEvent);
        if (m3875u() > 0) {
            C0440k a = C0402a.m1482a(accessibilityEvent);
            View a2 = m4371a(false, true);
            View b = m4391b(false, true);
            if (a2 != null && b != null) {
                int d = m3836d(a2);
                int d2 = m3836d(b);
                if (d < d2) {
                    a.m1671b(d);
                    a.m1672c(d2);
                    return;
                }
                a.m1671b(d2);
                a.m1672c(d);
            }
        }
    }

    public void m4385a(String str) {
        if (this.f2067u == null) {
            super.m3800a(str);
        }
    }

    public void m4386a(boolean z) {
        m4385a(null);
        if (!(this.f2067u == null || this.f2067u.f2041h == z)) {
            this.f2067u.f2041h = z;
        }
        this.f2062l = z;
        m3869o();
    }

    public boolean m4387a(C0810i c0810i) {
        return c0810i instanceof C0865b;
    }

    public int m4388b(int i, C0844n c0844n, C0850s c0850s) {
        return m4395c(i, c0844n, c0850s);
    }

    public int m4389b(C0844n c0844n, C0850s c0850s) {
        return this.f2059i == 1 ? this.f2057g : super.m3813b(c0844n, c0850s);
    }

    View m4390b() {
        int i;
        int u = m3875u() - 1;
        BitSet bitSet = new BitSet(this.f2057g);
        bitSet.set(0, this.f2057g, true);
        boolean z = (this.f2059i == 1 && m4410h()) ? true : true;
        if (this.f2053c) {
            i = -1;
        } else {
            i = u + 1;
            u = 0;
        }
        int i2 = u < i ? 1 : -1;
        int i3 = u;
        while (i3 != i) {
            View i4 = m3858i(i3);
            C0865b c0865b = (C0865b) i4.getLayoutParams();
            if (bitSet.get(c0865b.f2026e.f2047d)) {
                if (m4335a(c0865b.f2026e)) {
                    return i4;
                }
                bitSet.clear(c0865b.f2026e.f2047d);
            }
            if (!(c0865b.f2027f || i3 + i2 == i)) {
                boolean z2;
                View i5 = m3858i(i3 + i2);
                int b;
                if (this.f2053c) {
                    u = this.f2051a.m4670b(i4);
                    b = this.f2051a.m4670b(i5);
                    if (u < b) {
                        return i4;
                    }
                    if (u == b) {
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    u = this.f2051a.m4666a(i4);
                    b = this.f2051a.m4666a(i5);
                    if (u > b) {
                        return i4;
                    }
                    if (u == b) {
                        z2 = true;
                    }
                    z2 = false;
                }
                if (z2) {
                    if ((c0865b.f2026e.f2047d - ((C0865b) i5.getLayoutParams()).f2026e.f2047d < 0) != (z >= false)) {
                        return i4;
                    }
                } else {
                    continue;
                }
            }
            i3 += i2;
        }
        return null;
    }

    View m4391b(boolean z, boolean z2) {
        int c = this.f2051a.m4671c();
        int d = this.f2051a.m4673d();
        View view = null;
        for (int u = m3875u() - 1; u >= 0; u--) {
            View i = m3858i(u);
            int a = this.f2051a.m4666a(i);
            int b = this.f2051a.m4670b(i);
            if (b > c && a < d) {
                if (b <= d || !z) {
                    return i;
                }
                if (z2 && view == null) {
                    view = i;
                }
            }
        }
        return view;
    }

    public void m4392b(int i) {
        if (i == 0 || i == 1) {
            m4385a(null);
            if (i != this.f2059i) {
                this.f2059i = i;
                ar arVar = this.f2051a;
                this.f2051a = this.f2052b;
                this.f2052b = arVar;
                m3869o();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("invalid orientation.");
    }

    public void m4393b(RecyclerView recyclerView, int i, int i2) {
        m4342c(i, i2, 2);
    }

    boolean m4394b(C0850s c0850s, C0864a c0864a) {
        boolean z = false;
        if (c0850s.m4218a() || this.f2054d == -1) {
            return false;
        }
        if (this.f2054d < 0 || this.f2054d >= c0850s.m4222e()) {
            this.f2054d = -1;
            this.f2055e = Integer.MIN_VALUE;
            return false;
        } else if (this.f2067u == null || this.f2067u.f2034a == -1 || this.f2067u.f2036c < 1) {
            View c = m3824c(this.f2054d);
            if (c != null) {
                c0864a.f2020a = this.f2053c ? m4321L() : m4322M();
                if (this.f2055e != Integer.MIN_VALUE) {
                    if (c0864a.f2022c) {
                        c0864a.f2021b = (this.f2051a.m4673d() - this.f2055e) - this.f2051a.m4670b(c);
                        return true;
                    }
                    c0864a.f2021b = (this.f2051a.m4671c() + this.f2055e) - this.f2051a.m4666a(c);
                    return true;
                } else if (this.f2051a.m4676e(c) > this.f2051a.m4677f()) {
                    c0864a.f2021b = c0864a.f2022c ? this.f2051a.m4673d() : this.f2051a.m4671c();
                    return true;
                } else {
                    int a = this.f2051a.m4666a(c) - this.f2051a.m4671c();
                    if (a < 0) {
                        c0864a.f2021b = -a;
                        return true;
                    }
                    a = this.f2051a.m4673d() - this.f2051a.m4670b(c);
                    if (a < 0) {
                        c0864a.f2021b = a;
                        return true;
                    }
                    c0864a.f2021b = Integer.MIN_VALUE;
                    return true;
                }
            }
            c0864a.f2020a = this.f2054d;
            if (this.f2055e == Integer.MIN_VALUE) {
                if (m4361t(c0864a.f2020a) == 1) {
                    z = true;
                }
                c0864a.f2022c = z;
                c0864a.m4275b();
            } else {
                c0864a.m4274a(this.f2055e);
            }
            c0864a.f2023d = true;
            return true;
        } else {
            c0864a.f2021b = Integer.MIN_VALUE;
            c0864a.f2020a = this.f2054d;
            return true;
        }
    }

    int m4395c(int i, C0844n c0844n, C0850s c0850s) {
        int L;
        int i2;
        if (i > 0) {
            L = m4321L();
            i2 = 1;
        } else {
            i2 = -1;
            L = m4322M();
        }
        this.f2061k.f2248a = true;
        m4326a(L, c0850s);
        m4347f(i2);
        this.f2061k.f2250c = this.f2061k.f2251d + L;
        int abs = Math.abs(i);
        this.f2061k.f2249b = abs;
        i2 = m4323a(c0844n, this.f2061k, c0850s);
        if (abs >= i2) {
            i = i < 0 ? -i2 : i2;
        }
        this.f2051a.m4668a(-i);
        this.f2065o = this.f2053c;
        return i;
    }

    public int m4396c(C0850s c0850s) {
        return m4338b(c0850s);
    }

    public void m4397c(C0844n c0844n, C0850s c0850s) {
        m4328a(c0844n, c0850s, true);
    }

    public boolean m4398c() {
        return this.f2067u == null;
    }

    public int m4399d(C0850s c0850s) {
        return m4338b(c0850s);
    }

    public Parcelable m4400d() {
        if (this.f2067u != null) {
            return new C0870d(this.f2067u);
        }
        C0870d c0870d = new C0870d();
        c0870d.f2041h = this.f2062l;
        c0870d.f2042i = this.f2065o;
        c0870d.f2043j = this.f2066t;
        if (this.f2056f == null || this.f2056f.f2032a == null) {
            c0870d.f2038e = 0;
        } else {
            c0870d.f2039f = this.f2056f.f2032a;
            c0870d.f2038e = c0870d.f2039f.length;
            c0870d.f2040g = this.f2056f.f2033b;
        }
        if (m3875u() > 0) {
            c0870d.f2034a = this.f2065o ? m4321L() : m4322M();
            c0870d.f2035b = m4411i();
            c0870d.f2036c = this.f2057g;
            c0870d.f2037d = new int[this.f2057g];
            for (int i = 0; i < this.f2057g; i++) {
                int b;
                if (this.f2065o) {
                    b = this.f2058h[i].m4307b(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f2051a.m4673d();
                    }
                } else {
                    b = this.f2058h[i].m4301a(Integer.MIN_VALUE);
                    if (b != Integer.MIN_VALUE) {
                        b -= this.f2051a.m4671c();
                    }
                }
                c0870d.f2037d[i] = b;
            }
        } else {
            c0870d.f2034a = -1;
            c0870d.f2035b = -1;
            c0870d.f2036c = 0;
        }
        return c0870d;
    }

    void m4401d(int i) {
        this.f2060j = i / this.f2057g;
        this.f2068v = MeasureSpec.makeMeasureSpec(i, this.f2052b.m4680h());
    }

    public int m4402e(C0850s c0850s) {
        return m4348i(c0850s);
    }

    public void m4403e(int i) {
        if (!(this.f2067u == null || this.f2067u.f2034a == i)) {
            this.f2067u.m4299b();
        }
        this.f2054d = i;
        this.f2055e = Integer.MIN_VALUE;
        m3869o();
    }

    public boolean m4404e() {
        return this.f2059i == 0;
    }

    public int m4405f(C0850s c0850s) {
        return m4348i(c0850s);
    }

    public boolean m4406f() {
        return this.f2059i == 1;
    }

    public int m4407g(C0850s c0850s) {
        return m4349j(c0850s);
    }

    public void m4408g() {
        this.f2056f.m4286a();
        m3869o();
    }

    public int m4409h(C0850s c0850s) {
        return m4349j(c0850s);
    }

    boolean m4410h() {
        return m3873s() == 1;
    }

    int m4411i() {
        View b = this.f2053c ? m4391b(true, true) : m4371a(true, true);
        return b == null ? -1 : m3836d(b);
    }

    public void m4412j(int i) {
        super.m3860j(i);
        for (int i2 = 0; i2 < this.f2057g; i2++) {
            this.f2058h[i2].m4313d(i);
        }
    }

    boolean m4413j() {
        int b = this.f2058h[0].m4307b(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2057g; i++) {
            if (this.f2058h[i].m4307b(Integer.MIN_VALUE) != b) {
                return false;
            }
        }
        return true;
    }

    public void m4414k(int i) {
        super.m3862k(i);
        for (int i2 = 0; i2 < this.f2057g; i2++) {
            this.f2058h[i2].m4313d(i);
        }
    }

    boolean m4415k() {
        int a = this.f2058h[0].m4301a(Integer.MIN_VALUE);
        for (int i = 1; i < this.f2057g; i++) {
            if (this.f2058h[i].m4301a(Integer.MIN_VALUE) != a) {
                return false;
            }
        }
        return true;
    }

    public void m4416l(int i) {
        if (i == 0) {
            m4353n();
        }
    }
}
