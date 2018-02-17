package com.p045c.p046a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p050d.C1146g;
import com.p045c.p046a.p050d.C1155e;
import com.p045c.p046a.p050d.C1225d;
import com.p045c.p046a.p050d.p052b.C1056b;
import com.p045c.p046a.p050d.p062d.C1210d;
import com.p045c.p046a.p055j.C1296h;
import com.p045c.p046a.p058h.C1268b;
import com.p045c.p046a.p058h.C1270a;
import com.p045c.p046a.p058h.C1281c;
import com.p045c.p046a.p058h.C1282d;
import com.p045c.p046a.p058h.C1283f;
import com.p045c.p046a.p058h.p069b.C1195j;
import com.p045c.p046a.p058h.p073a.C1259d;
import com.p045c.p046a.p058h.p073a.C1265e;
import com.p045c.p046a.p064g.C1250f;
import com.p045c.p046a.p064g.C1251a;
import com.p045c.p046a.p068e.C1228g;
import com.p045c.p046a.p068e.C1243m;
import com.p045c.p046a.p074i.C1286b;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.io.File;

/* renamed from: com.c.a.e */
public class C0988e<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private boolean f2574A;
    private Drawable f2575B;
    private int f2576C;
    protected final Class<ModelType> f2577a;
    protected final Context f2578b;
    protected final C1288i f2579c;
    protected final Class<TranscodeType> f2580d;
    protected final C1243m f2581e;
    protected final C1228g f2582f;
    private C1251a<ModelType, DataType, ResourceType, TranscodeType> f2583g;
    private ModelType f2584h;
    private C1081c f2585i;
    private boolean f2586j;
    private int f2587k;
    private int f2588l;
    private C1282d<? super ModelType, TranscodeType> f2589m;
    private Float f2590n;
    private C0988e<?, ?, ?, TranscodeType> f2591o;
    private Float f2592p;
    private Drawable f2593q;
    private Drawable f2594r;
    private C1298k f2595s;
    private boolean f2596t;
    private C1259d<TranscodeType> f2597u;
    private int f2598v;
    private int f2599w;
    private C1056b f2600x;
    private C1146g<ResourceType> f2601y;
    private boolean f2602z;

    /* renamed from: com.c.a.e.1 */
    static /* synthetic */ class C12271 {
        static final /* synthetic */ int[] f3101a;

        static {
            f3101a = new int[ScaleType.values().length];
            try {
                f3101a[ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3101a[ScaleType.FIT_CENTER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f3101a[ScaleType.FIT_START.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f3101a[ScaleType.FIT_END.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    C0988e(Context context, Class<ModelType> cls, C1250f<ModelType, DataType, ResourceType, TranscodeType> c1250f, Class<TranscodeType> cls2, C1288i c1288i, C1243m c1243m, C1228g c1228g) {
        C1251a c1251a = null;
        this.f2585i = C1286b.m6068a();
        this.f2592p = Float.valueOf(1.0f);
        this.f2595s = null;
        this.f2596t = true;
        this.f2597u = C1265e.m5974a();
        this.f2598v = -1;
        this.f2599w = -1;
        this.f2600x = C1056b.RESULT;
        this.f2601y = C1210d.m5810b();
        this.f2578b = context;
        this.f2577a = cls;
        this.f2580d = cls2;
        this.f2579c = c1288i;
        this.f2581e = c1243m;
        this.f2582f = c1228g;
        if (c1250f != null) {
            c1251a = new C1251a(c1250f);
        }
        this.f2583g = c1251a;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        } else if (cls != null && c1250f == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    C0988e(C1250f<ModelType, DataType, ResourceType, TranscodeType> c1250f, Class<TranscodeType> cls, C0988e<ModelType, ?, ?, ?> c0988e) {
        this(c0988e.f2578b, c0988e.f2577a, c1250f, cls, c0988e.f2579c, c0988e.f2581e, c0988e.f2582f);
        this.f2584h = c0988e.f2584h;
        this.f2586j = c0988e.f2586j;
        this.f2585i = c0988e.f2585i;
        this.f2600x = c0988e.f2600x;
        this.f2596t = c0988e.f2596t;
    }

    private C1268b m5112a(C1195j<TranscodeType> c1195j, float f, C1298k c1298k, C1281c c1281c) {
        return C1270a.m5989a(this.f2583g, this.f2584h, this.f2585i, this.f2578b, c1298k, c1195j, f, this.f2593q, this.f2587k, this.f2594r, this.f2588l, this.f2575B, this.f2576C, this.f2589m, c1281c, this.f2579c.m6084b(), this.f2601y, this.f2580d, this.f2596t, this.f2597u, this.f2599w, this.f2598v, this.f2600x);
    }

    private C1268b m5113a(C1195j<TranscodeType> c1195j, C1283f c1283f) {
        C1268b c1283f2;
        if (this.f2591o != null) {
            if (this.f2574A) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.f2591o.f2597u.equals(C1265e.m5974a())) {
                this.f2591o.f2597u = this.f2597u;
            }
            if (this.f2591o.f2595s == null) {
                this.f2591o.f2595s = m5114a();
            }
            if (C1296h.m6114a(this.f2599w, this.f2598v) && !C1296h.m6114a(this.f2591o.f2599w, this.f2591o.f2598v)) {
                this.f2591o.m5119b(this.f2599w, this.f2598v);
            }
            c1283f2 = new C1283f(c1283f);
            C1268b a = m5112a(c1195j, this.f2592p.floatValue(), this.f2595s, c1283f2);
            this.f2574A = true;
            C1268b a2 = this.f2591o.m5113a(c1195j, c1283f2);
            this.f2574A = false;
            c1283f2.m6053a(a, a2);
            return c1283f2;
        } else if (this.f2590n == null) {
            return m5112a(c1195j, this.f2592p.floatValue(), this.f2595s, c1283f);
        } else {
            c1283f2 = new C1283f(c1283f);
            c1283f2.m6053a(m5112a(c1195j, this.f2592p.floatValue(), this.f2595s, c1283f2), m5112a(c1195j, this.f2590n.floatValue(), m5114a(), c1283f2));
            return c1283f2;
        }
    }

    private C1298k m5114a() {
        return this.f2595s == C1298k.LOW ? C1298k.NORMAL : this.f2595s == C1298k.NORMAL ? C1298k.HIGH : C1298k.IMMEDIATE;
    }

    private C1268b m5115b(C1195j<TranscodeType> c1195j) {
        if (this.f2595s == null) {
            this.f2595s = C1298k.NORMAL;
        }
        return m5113a(c1195j, null);
    }

    C0988e<ModelType, DataType, ResourceType, TranscodeType> m5116a(C1259d<TranscodeType> c1259d) {
        if (c1259d == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.f2597u = c1259d;
        return this;
    }

    public C1195j<TranscodeType> m5117a(ImageView imageView) {
        C1296h.m6113a();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!(this.f2602z || imageView.getScaleType() == null)) {
            switch (C12271.f3101a[imageView.getScaleType().ordinal()]) {
                case C1373c.View_android_focusable /*1*/:
                    m5131e();
                    break;
                case C1373c.View_paddingStart /*2*/:
                case C1373c.View_paddingEnd /*3*/:
                case C1373c.View_theme /*4*/:
                    m5130d();
                    break;
            }
        }
        return m5118a(this.f2579c.m6081a(imageView, this.f2580d));
    }

    public <Y extends C1195j<TranscodeType>> Y m5118a(Y y) {
        C1296h.m6113a();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        } else if (this.f2586j) {
            C1268b request = y.getRequest();
            if (request != null) {
                request.m5982d();
                this.f2581e.m5891b(request);
                request.m5980a();
            }
            request = m5115b((C1195j) y);
            y.setRequest(request);
            this.f2582f.m5857a(y);
            this.f2581e.m5889a(request);
            return y;
        } else {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5119b(int i, int i2) {
        if (C1296h.m6114a(i, i2)) {
            this.f2599w = i;
            this.f2598v = i2;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5120b(C1056b c1056b) {
        this.f2600x = c1056b;
        return this;
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5121b(C1092b<DataType> c1092b) {
        if (this.f2583g != null) {
            this.f2583g.m5908a((C1092b) c1092b);
        }
        return this;
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5122b(C1081c c1081c) {
        if (c1081c == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.f2585i = c1081c;
        return this;
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5123b(ModelType modelType) {
        this.f2584h = modelType;
        this.f2586j = true;
        return this;
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5124b(boolean z) {
        this.f2596t = !z;
        return this;
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5125b(C1146g<ResourceType>... c1146gArr) {
        this.f2602z = true;
        if (c1146gArr.length == 1) {
            this.f2601y = c1146gArr[0];
        } else {
            this.f2601y = new C1225d(c1146gArr);
        }
        return this;
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5126c(int i) {
        this.f2588l = i;
        return this;
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5127c(C1155e<File, ResourceType> c1155e) {
        if (this.f2583g != null) {
            this.f2583g.m5909a((C1155e) c1155e);
        }
        return this;
    }

    public /* synthetic */ Object clone() {
        return m5132f();
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5128d(int i) {
        this.f2587k = i;
        return this;
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5129d(C1155e<DataType, ResourceType> c1155e) {
        if (this.f2583g != null) {
            this.f2583g.m5911b(c1155e);
        }
        return this;
    }

    void m5130d() {
    }

    void m5131e() {
    }

    public C0988e<ModelType, DataType, ResourceType, TranscodeType> m5132f() {
        try {
            C0988e<ModelType, DataType, ResourceType, TranscodeType> c0988e = (C0988e) super.clone();
            c0988e.f2583g = this.f2583g != null ? this.f2583g.m5916g() : null;
            return c0988e;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
