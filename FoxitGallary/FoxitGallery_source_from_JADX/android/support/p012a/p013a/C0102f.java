package android.support.p012a.p013a;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.VectorDrawable;
import android.os.Build.VERSION;
import android.support.p012a.p013a.C0092c.C0091b;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.p022c.p023a.C0304d;
import android.support.v4.p030j.C0380a;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.util.ArrayList;
import java.util.Stack;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@TargetApi(21)
/* renamed from: android.support.a.a.f */
public class C0102f extends C0087e {
    static final Mode f134b;
    private C0100f f135c;
    private PorterDuffColorFilter f136d;
    private ColorFilter f137e;
    private boolean f138f;
    private boolean f139g;
    private ConstantState f140h;
    private final float[] f141i;
    private final Matrix f142j;
    private final Rect f143k;

    /* renamed from: android.support.a.a.f.d */
    private static class C0095d {
        protected C0091b[] f76m;
        String f77n;
        int f78o;

        public C0095d() {
            this.f76m = null;
        }

        public C0095d(C0095d c0095d) {
            this.f76m = null;
            this.f77n = c0095d.f77n;
            this.f78o = c0095d.f78o;
            this.f76m = C0092c.m154a(c0095d.f76m);
        }

        public void m162a(Path path) {
            path.reset();
            if (this.f76m != null) {
                C0091b.m148a(this.f76m, path);
            }
        }

        public boolean m163a() {
            return false;
        }

        public String m164b() {
            return this.f77n;
        }
    }

    /* renamed from: android.support.a.a.f.a */
    private static class C0096a extends C0095d {
        public C0096a(C0096a c0096a) {
            super(c0096a);
        }

        private void m165a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.n = string;
            }
            string = typedArray.getString(1);
            if (string != null) {
                this.m = C0092c.m153a(string);
            }
        }

        public void m166a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            if (C0093d.m160a(xmlPullParser, "pathData")) {
                TypedArray b = C0087e.m138b(resources, theme, attributeSet, C0082a.f58d);
                m165a(b);
                b.recycle();
            }
        }

        public boolean m167a() {
            return true;
        }
    }

    /* renamed from: android.support.a.a.f.b */
    private static class C0097b extends C0095d {
        int f79a;
        float f80b;
        int f81c;
        float f82d;
        int f83e;
        float f84f;
        float f85g;
        float f86h;
        float f87i;
        Cap f88j;
        Join f89k;
        float f90l;
        private int[] f91p;

        public C0097b() {
            this.f79a = 0;
            this.f80b = 0.0f;
            this.f81c = 0;
            this.f82d = 1.0f;
            this.f84f = 1.0f;
            this.f85g = 0.0f;
            this.f86h = 1.0f;
            this.f87i = 0.0f;
            this.f88j = Cap.BUTT;
            this.f89k = Join.MITER;
            this.f90l = 4.0f;
        }

        public C0097b(C0097b c0097b) {
            super(c0097b);
            this.f79a = 0;
            this.f80b = 0.0f;
            this.f81c = 0;
            this.f82d = 1.0f;
            this.f84f = 1.0f;
            this.f85g = 0.0f;
            this.f86h = 1.0f;
            this.f87i = 0.0f;
            this.f88j = Cap.BUTT;
            this.f89k = Join.MITER;
            this.f90l = 4.0f;
            this.f91p = c0097b.f91p;
            this.f79a = c0097b.f79a;
            this.f80b = c0097b.f80b;
            this.f82d = c0097b.f82d;
            this.f81c = c0097b.f81c;
            this.f83e = c0097b.f83e;
            this.f84f = c0097b.f84f;
            this.f85g = c0097b.f85g;
            this.f86h = c0097b.f86h;
            this.f87i = c0097b.f87i;
            this.f88j = c0097b.f88j;
            this.f89k = c0097b.f89k;
            this.f90l = c0097b.f90l;
        }

        private Cap m168a(int i, Cap cap) {
            switch (i) {
                case C1373c.View_android_theme /*0*/:
                    return Cap.BUTT;
                case C1373c.View_android_focusable /*1*/:
                    return Cap.ROUND;
                case C1373c.View_paddingStart /*2*/:
                    return Cap.SQUARE;
                default:
                    return cap;
            }
        }

        private Join m169a(int i, Join join) {
            switch (i) {
                case C1373c.View_android_theme /*0*/:
                    return Join.MITER;
                case C1373c.View_android_focusable /*1*/:
                    return Join.ROUND;
                case C1373c.View_paddingStart /*2*/:
                    return Join.BEVEL;
                default:
                    return join;
            }
        }

        private void m170a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f91p = null;
            if (C0093d.m160a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.n = string;
                }
                string = typedArray.getString(2);
                if (string != null) {
                    this.m = C0092c.m153a(string);
                }
                this.f81c = C0093d.m161b(typedArray, xmlPullParser, "fillColor", 1, this.f81c);
                this.f84f = C0093d.m157a(typedArray, xmlPullParser, "fillAlpha", 12, this.f84f);
                this.f88j = m168a(C0093d.m158a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f88j);
                this.f89k = m169a(C0093d.m158a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f89k);
                this.f90l = C0093d.m157a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f90l);
                this.f79a = C0093d.m161b(typedArray, xmlPullParser, "strokeColor", 3, this.f79a);
                this.f82d = C0093d.m157a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f82d);
                this.f80b = C0093d.m157a(typedArray, xmlPullParser, "strokeWidth", 4, this.f80b);
                this.f86h = C0093d.m157a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f86h);
                this.f87i = C0093d.m157a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f87i);
                this.f85g = C0093d.m157a(typedArray, xmlPullParser, "trimPathStart", 5, this.f85g);
            }
        }

        public void m171a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0087e.m138b(resources, theme, attributeSet, C0082a.f57c);
            m170a(b, xmlPullParser);
            b.recycle();
        }
    }

    /* renamed from: android.support.a.a.f.c */
    private static class C0098c {
        final ArrayList<Object> f92a;
        private final Matrix f93b;
        private float f94c;
        private float f95d;
        private float f96e;
        private float f97f;
        private float f98g;
        private float f99h;
        private float f100i;
        private final Matrix f101j;
        private int f102k;
        private int[] f103l;
        private String f104m;

        public C0098c() {
            this.f93b = new Matrix();
            this.f92a = new ArrayList();
            this.f94c = 0.0f;
            this.f95d = 0.0f;
            this.f96e = 0.0f;
            this.f97f = 1.0f;
            this.f98g = 1.0f;
            this.f99h = 0.0f;
            this.f100i = 0.0f;
            this.f101j = new Matrix();
            this.f104m = null;
        }

        public C0098c(C0098c c0098c, C0380a<String, Object> c0380a) {
            this.f93b = new Matrix();
            this.f92a = new ArrayList();
            this.f94c = 0.0f;
            this.f95d = 0.0f;
            this.f96e = 0.0f;
            this.f97f = 1.0f;
            this.f98g = 1.0f;
            this.f99h = 0.0f;
            this.f100i = 0.0f;
            this.f101j = new Matrix();
            this.f104m = null;
            this.f94c = c0098c.f94c;
            this.f95d = c0098c.f95d;
            this.f96e = c0098c.f96e;
            this.f97f = c0098c.f97f;
            this.f98g = c0098c.f98g;
            this.f99h = c0098c.f99h;
            this.f100i = c0098c.f100i;
            this.f103l = c0098c.f103l;
            this.f104m = c0098c.f104m;
            this.f102k = c0098c.f102k;
            if (this.f104m != null) {
                c0380a.put(this.f104m, this);
            }
            this.f101j.set(c0098c.f101j);
            ArrayList arrayList = c0098c.f92a;
            for (int i = 0; i < arrayList.size(); i++) {
                Object obj = arrayList.get(i);
                if (obj instanceof C0098c) {
                    this.f92a.add(new C0098c((C0098c) obj, c0380a));
                } else {
                    C0095d c0097b;
                    if (obj instanceof C0097b) {
                        c0097b = new C0097b((C0097b) obj);
                    } else if (obj instanceof C0096a) {
                        c0097b = new C0096a((C0096a) obj);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f92a.add(c0097b);
                    if (c0097b.f77n != null) {
                        c0380a.put(c0097b.f77n, c0097b);
                    }
                }
            }
        }

        private void m173a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f103l = null;
            this.f94c = C0093d.m157a(typedArray, xmlPullParser, "rotation", 5, this.f94c);
            this.f95d = typedArray.getFloat(1, this.f95d);
            this.f96e = typedArray.getFloat(2, this.f96e);
            this.f97f = C0093d.m157a(typedArray, xmlPullParser, "scaleX", 3, this.f97f);
            this.f98g = C0093d.m157a(typedArray, xmlPullParser, "scaleY", 4, this.f98g);
            this.f99h = C0093d.m157a(typedArray, xmlPullParser, "translateX", 6, this.f99h);
            this.f100i = C0093d.m157a(typedArray, xmlPullParser, "translateY", 7, this.f100i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f104m = string;
            }
            m175b();
        }

        private void m175b() {
            this.f101j.reset();
            this.f101j.postTranslate(-this.f95d, -this.f96e);
            this.f101j.postScale(this.f97f, this.f98g);
            this.f101j.postRotate(this.f94c, 0.0f, 0.0f);
            this.f101j.postTranslate(this.f99h + this.f95d, this.f100i + this.f96e);
        }

        public String m177a() {
            return this.f104m;
        }

        public void m178a(Resources resources, AttributeSet attributeSet, Theme theme, XmlPullParser xmlPullParser) {
            TypedArray b = C0087e.m138b(resources, theme, attributeSet, C0082a.f56b);
            m173a(b, xmlPullParser);
            b.recycle();
        }
    }

    /* renamed from: android.support.a.a.f.e */
    private static class C0099e {
        private static final Matrix f105j;
        float f106a;
        float f107b;
        float f108c;
        float f109d;
        int f110e;
        String f111f;
        final C0380a<String, Object> f112g;
        private final Path f113h;
        private final Path f114i;
        private final Matrix f115k;
        private Paint f116l;
        private Paint f117m;
        private PathMeasure f118n;
        private int f119o;
        private final C0098c f120p;

        static {
            f105j = new Matrix();
        }

        public C0099e() {
            this.f115k = new Matrix();
            this.f106a = 0.0f;
            this.f107b = 0.0f;
            this.f108c = 0.0f;
            this.f109d = 0.0f;
            this.f110e = 255;
            this.f111f = null;
            this.f112g = new C0380a();
            this.f120p = new C0098c();
            this.f113h = new Path();
            this.f114i = new Path();
        }

        public C0099e(C0099e c0099e) {
            this.f115k = new Matrix();
            this.f106a = 0.0f;
            this.f107b = 0.0f;
            this.f108c = 0.0f;
            this.f109d = 0.0f;
            this.f110e = 255;
            this.f111f = null;
            this.f112g = new C0380a();
            this.f120p = new C0098c(c0099e.f120p, this.f112g);
            this.f113h = new Path(c0099e.f113h);
            this.f114i = new Path(c0099e.f114i);
            this.f106a = c0099e.f106a;
            this.f107b = c0099e.f107b;
            this.f108c = c0099e.f108c;
            this.f109d = c0099e.f109d;
            this.f119o = c0099e.f119o;
            this.f110e = c0099e.f110e;
            this.f111f = c0099e.f111f;
            if (c0099e.f111f != null) {
                this.f112g.put(c0099e.f111f, this);
            }
        }

        private static float m179a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        private float m180a(Matrix matrix) {
            float[] fArr = new float[]{0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot((double) fArr[0], (double) fArr[1]);
            float hypot2 = (float) Math.hypot((double) fArr[2], (double) fArr[3]);
            float a = C0099e.m179a(fArr[0], fArr[1], fArr[2], fArr[3]);
            hypot = Math.max(hypot, hypot2);
            return hypot > 0.0f ? Math.abs(a) / hypot : 0.0f;
        }

        private void m183a(C0098c c0098c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0098c.f93b.set(matrix);
            c0098c.f93b.preConcat(c0098c.f101j);
            for (int i3 = 0; i3 < c0098c.f92a.size(); i3++) {
                Object obj = c0098c.f92a.get(i3);
                if (obj instanceof C0098c) {
                    m183a((C0098c) obj, c0098c.f93b, canvas, i, i2, colorFilter);
                } else if (obj instanceof C0095d) {
                    m184a(c0098c, (C0095d) obj, canvas, i, i2, colorFilter);
                }
            }
        }

        private void m184a(C0098c c0098c, C0095d c0095d, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f108c;
            float f2 = ((float) i2) / this.f109d;
            float min = Math.min(f, f2);
            Matrix b = c0098c.f93b;
            this.f115k.set(b);
            this.f115k.postScale(f, f2);
            f = m180a(b);
            if (f != 0.0f) {
                c0095d.m162a(this.f113h);
                Path path = this.f113h;
                this.f114i.reset();
                if (c0095d.m163a()) {
                    this.f114i.addPath(path, this.f115k);
                    canvas.clipPath(this.f114i, Op.REPLACE);
                    return;
                }
                Paint paint;
                C0097b c0097b = (C0097b) c0095d;
                if (!(c0097b.f85g == 0.0f && c0097b.f86h == 1.0f)) {
                    float f3 = (c0097b.f85g + c0097b.f87i) % 1.0f;
                    float f4 = (c0097b.f86h + c0097b.f87i) % 1.0f;
                    if (this.f118n == null) {
                        this.f118n = new PathMeasure();
                    }
                    this.f118n.setPath(this.f113h, false);
                    float length = this.f118n.getLength();
                    f3 *= length;
                    f4 *= length;
                    path.reset();
                    if (f3 > f4) {
                        this.f118n.getSegment(f3, length, path, true);
                        this.f118n.getSegment(0.0f, f4, path, true);
                    } else {
                        this.f118n.getSegment(f3, f4, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f114i.addPath(path, this.f115k);
                if (c0097b.f81c != 0) {
                    if (this.f117m == null) {
                        this.f117m = new Paint();
                        this.f117m.setStyle(Style.FILL);
                        this.f117m.setAntiAlias(true);
                    }
                    paint = this.f117m;
                    paint.setColor(C0102f.m207b(c0097b.f81c, c0097b.f84f));
                    paint.setColorFilter(colorFilter);
                    canvas.drawPath(this.f114i, paint);
                }
                if (c0097b.f79a != 0) {
                    if (this.f116l == null) {
                        this.f116l = new Paint();
                        this.f116l.setStyle(Style.STROKE);
                        this.f116l.setAntiAlias(true);
                    }
                    paint = this.f116l;
                    if (c0097b.f89k != null) {
                        paint.setStrokeJoin(c0097b.f89k);
                    }
                    if (c0097b.f88j != null) {
                        paint.setStrokeCap(c0097b.f88j);
                    }
                    paint.setStrokeMiter(c0097b.f90l);
                    paint.setColor(C0102f.m207b(c0097b.f79a, c0097b.f82d));
                    paint.setColorFilter(colorFilter);
                    paint.setStrokeWidth((f * min) * c0097b.f80b);
                    canvas.drawPath(this.f114i, paint);
                }
            }
        }

        public int m188a() {
            return this.f110e;
        }

        public void m189a(float f) {
            m190a((int) (255.0f * f));
        }

        public void m190a(int i) {
            this.f110e = i;
        }

        public void m191a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m183a(this.f120p, f105j, canvas, i, i2, colorFilter);
        }

        public float m192b() {
            return ((float) m188a()) / 255.0f;
        }
    }

    /* renamed from: android.support.a.a.f.f */
    private static class C0100f extends ConstantState {
        int f121a;
        C0099e f122b;
        ColorStateList f123c;
        Mode f124d;
        boolean f125e;
        Bitmap f126f;
        ColorStateList f127g;
        Mode f128h;
        int f129i;
        boolean f130j;
        boolean f131k;
        Paint f132l;

        public C0100f() {
            this.f123c = null;
            this.f124d = C0102f.f134b;
            this.f122b = new C0099e();
        }

        public C0100f(C0100f c0100f) {
            this.f123c = null;
            this.f124d = C0102f.f134b;
            if (c0100f != null) {
                this.f121a = c0100f.f121a;
                this.f122b = new C0099e(c0100f.f122b);
                if (c0100f.f122b.f117m != null) {
                    this.f122b.f117m = new Paint(c0100f.f122b.f117m);
                }
                if (c0100f.f122b.f116l != null) {
                    this.f122b.f116l = new Paint(c0100f.f122b.f116l);
                }
                this.f123c = c0100f.f123c;
                this.f124d = c0100f.f124d;
                this.f125e = c0100f.f125e;
            }
        }

        public Paint m193a(ColorFilter colorFilter) {
            if (!m196a() && colorFilter == null) {
                return null;
            }
            if (this.f132l == null) {
                this.f132l = new Paint();
                this.f132l.setFilterBitmap(true);
            }
            this.f132l.setAlpha(this.f122b.m188a());
            this.f132l.setColorFilter(colorFilter);
            return this.f132l;
        }

        public void m194a(int i, int i2) {
            this.f126f.eraseColor(0);
            this.f122b.m191a(new Canvas(this.f126f), i, i2, null);
        }

        public void m195a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f126f, null, rect, m193a(colorFilter));
        }

        public boolean m196a() {
            return this.f122b.m188a() < 255;
        }

        public void m197b(int i, int i2) {
            if (this.f126f == null || !m200c(i, i2)) {
                this.f126f = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
                this.f131k = true;
            }
        }

        public boolean m198b() {
            return !this.f131k && this.f127g == this.f123c && this.f128h == this.f124d && this.f130j == this.f125e && this.f129i == this.f122b.m188a();
        }

        public void m199c() {
            this.f127g = this.f123c;
            this.f128h = this.f124d;
            this.f129i = this.f122b.m188a();
            this.f130j = this.f125e;
            this.f131k = false;
        }

        public boolean m200c(int i, int i2) {
            return i == this.f126f.getWidth() && i2 == this.f126f.getHeight();
        }

        public int getChangingConfigurations() {
            return this.f121a;
        }

        public Drawable newDrawable() {
            return new C0102f();
        }

        public Drawable newDrawable(Resources resources) {
            return new C0102f();
        }
    }

    /* renamed from: android.support.a.a.f.g */
    private static class C0101g extends ConstantState {
        private final ConstantState f133a;

        public C0101g(ConstantState constantState) {
            this.f133a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f133a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f133a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            Drawable c0102f = new C0102f();
            c0102f.a = (VectorDrawable) this.f133a.newDrawable();
            return c0102f;
        }

        public Drawable newDrawable(Resources resources) {
            Drawable c0102f = new C0102f();
            c0102f.a = (VectorDrawable) this.f133a.newDrawable(resources);
            return c0102f;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            Drawable c0102f = new C0102f();
            c0102f.a = (VectorDrawable) this.f133a.newDrawable(resources, theme);
            return c0102f;
        }
    }

    static {
        f134b = Mode.SRC_IN;
    }

    private C0102f() {
        this.f139g = true;
        this.f141i = new float[9];
        this.f142j = new Matrix();
        this.f143k = new Rect();
        this.f135c = new C0100f();
    }

    private C0102f(C0100f c0100f) {
        this.f139g = true;
        this.f141i = new float[9];
        this.f142j = new Matrix();
        this.f143k = new Rect();
        this.f135c = c0100f;
        this.f136d = m209a(this.f136d, c0100f.f123c, c0100f.f124d);
    }

    private static Mode m202a(int i, Mode mode) {
        switch (i) {
            case C1373c.View_paddingEnd /*3*/:
                return Mode.SRC_OVER;
            case C1373c.Toolbar_contentInsetStart /*5*/:
                return Mode.SRC_IN;
            case C1373c.Toolbar_contentInsetStartWithNavigation /*9*/:
                return Mode.SRC_ATOP;
            case C1373c.Toolbar_titleMargin /*14*/:
                return Mode.MULTIPLY;
            case C1373c.Toolbar_titleMarginStart /*15*/:
                return Mode.SCREEN;
            case C1373c.Toolbar_titleMarginEnd /*16*/:
                return Mode.ADD;
            default:
                return mode;
        }
    }

    public static C0102f m203a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 23) {
            C0102f c0102f = new C0102f();
            c0102f.a = C0304d.m1179a(resources, i, theme);
            c0102f.f140h = new C0101g(c0102f.a.getConstantState());
            return c0102f;
        }
        try {
            int next;
            XmlPullParser xml = resources.getXml(i);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return C0102f.m204a(resources, xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (Throwable e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (Throwable e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    public static C0102f m204a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0102f c0102f = new C0102f();
        c0102f.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0102f;
    }

    private void m205a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0100f c0100f = this.f135c;
        C0099e c0099e = c0100f.f122b;
        c0100f.f124d = C0102f.m202a(C0093d.m158a(typedArray, xmlPullParser, "tintMode", 6, -1), Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0100f.f123c = colorStateList;
        }
        c0100f.f125e = C0093d.m159a(typedArray, xmlPullParser, "autoMirrored", 5, c0100f.f125e);
        c0099e.f108c = C0093d.m157a(typedArray, xmlPullParser, "viewportWidth", 7, c0099e.f108c);
        c0099e.f109d = C0093d.m157a(typedArray, xmlPullParser, "viewportHeight", 8, c0099e.f109d);
        if (c0099e.f108c <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (c0099e.f109d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        } else {
            c0099e.f106a = typedArray.getDimension(3, c0099e.f106a);
            c0099e.f107b = typedArray.getDimension(2, c0099e.f107b);
            if (c0099e.f106a <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (c0099e.f107b <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            } else {
                c0099e.m189a(C0093d.m157a(typedArray, xmlPullParser, "alpha", 4, c0099e.m192b()));
                String string = typedArray.getString(0);
                if (string != null) {
                    c0099e.f111f = string;
                    c0099e.f112g.put(string, c0099e);
                }
            }
        }
    }

    private boolean m206a() {
        return false;
    }

    private static int m207b(int i, float f) {
        return (((int) (((float) Color.alpha(i)) * f)) << 24) | (16777215 & i);
    }

    private void m208b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0100f c0100f = this.f135c;
        C0099e c0099e = c0100f.f122b;
        Stack stack = new Stack();
        stack.push(c0099e.f120p);
        int eventType = xmlPullParser.getEventType();
        Object obj = 1;
        while (eventType != 1) {
            if (eventType == 2) {
                Object obj2;
                String name = xmlPullParser.getName();
                C0098c c0098c = (C0098c) stack.peek();
                if ("path".equals(name)) {
                    C0097b c0097b = new C0097b();
                    c0097b.m171a(resources, attributeSet, theme, xmlPullParser);
                    c0098c.f92a.add(c0097b);
                    if (c0097b.m164b() != null) {
                        c0099e.f112g.put(c0097b.m164b(), c0097b);
                    }
                    obj2 = null;
                    c0100f.f121a = c0097b.o | c0100f.f121a;
                } else if ("clip-path".equals(name)) {
                    C0096a c0096a = new C0096a();
                    c0096a.m166a(resources, attributeSet, theme, xmlPullParser);
                    c0098c.f92a.add(c0096a);
                    if (c0096a.m164b() != null) {
                        c0099e.f112g.put(c0096a.m164b(), c0096a);
                    }
                    c0100f.f121a |= c0096a.o;
                    obj2 = obj;
                } else {
                    if ("group".equals(name)) {
                        C0098c c0098c2 = new C0098c();
                        c0098c2.m178a(resources, attributeSet, theme, xmlPullParser);
                        c0098c.f92a.add(c0098c2);
                        stack.push(c0098c2);
                        if (c0098c2.m177a() != null) {
                            c0099e.f112g.put(c0098c2.m177a(), c0098c2);
                        }
                        c0100f.f121a |= c0098c2.f102k;
                    }
                    obj2 = obj;
                }
                obj = obj2;
            } else if (eventType == 3) {
                if ("group".equals(xmlPullParser.getName())) {
                    stack.pop();
                }
            }
            eventType = xmlPullParser.next();
        }
        if (obj != null) {
            StringBuffer stringBuffer = new StringBuffer();
            if (stringBuffer.length() > 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append("path");
            throw new XmlPullParserException("no " + stringBuffer + " defined");
        }
    }

    PorterDuffColorFilter m209a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, Mode mode) {
        return (colorStateList == null || mode == null) ? null : new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    Object m210a(String str) {
        return this.f135c.f122b.f112g.get(str);
    }

    void m211a(boolean z) {
        this.f139g = z;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        if (this.a != null) {
            C0326a.m1270d(this.a);
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        copyBounds(this.f143k);
        if (this.f143k.width() > 0 && this.f143k.height() > 0) {
            ColorFilter colorFilter = this.f137e == null ? this.f136d : this.f137e;
            canvas.getMatrix(this.f142j);
            this.f142j.getValues(this.f141i);
            float abs = Math.abs(this.f141i[0]);
            float abs2 = Math.abs(this.f141i[4]);
            float abs3 = Math.abs(this.f141i[1]);
            float abs4 = Math.abs(this.f141i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs2 = 1.0f;
                abs = 1.0f;
            }
            int height = (int) (abs2 * ((float) this.f143k.height()));
            int min = Math.min(2048, (int) (abs * ((float) this.f143k.width())));
            height = Math.min(2048, height);
            if (min > 0 && height > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f143k.left, (float) this.f143k.top);
                if (m206a()) {
                    canvas.translate((float) this.f143k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f143k.offsetTo(0, 0);
                this.f135c.m197b(min, height);
                if (!this.f139g) {
                    this.f135c.m194a(min, height);
                } else if (!this.f135c.m198b()) {
                    this.f135c.m194a(min, height);
                    this.f135c.m199c();
                }
                this.f135c.m195a(canvas, colorFilter, this.f143k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.a != null ? C0326a.m1269c(this.a) : this.f135c.f122b.m188a();
    }

    public int getChangingConfigurations() {
        return this.a != null ? this.a.getChangingConfigurations() : super.getChangingConfigurations() | this.f135c.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        if (this.a != null) {
            return new C0101g(this.a.getConstantState());
        }
        this.f135c.f121a = getChangingConfigurations();
        return this.f135c;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.a != null ? this.a.getIntrinsicHeight() : (int) this.f135c.f122b.f107b;
    }

    public int getIntrinsicWidth() {
        return this.a != null ? this.a.getIntrinsicWidth() : (int) this.f135c.f122b.f106a;
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a != null ? this.a.getOpacity() : -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.a != null) {
            this.a.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            C0326a.m1264a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0100f c0100f = this.f135c;
        c0100f.f122b = new C0099e();
        TypedArray b = C0087e.m138b(resources, theme, attributeSet, C0082a.f55a);
        m205a(b, xmlPullParser);
        b.recycle();
        c0100f.f121a = getChangingConfigurations();
        c0100f.f131k = true;
        m208b(resources, xmlPullParser, attributeSet, theme);
        this.f136d = m209a(this.f136d, c0100f.f123c, c0100f.f124d);
    }

    public void invalidateSelf() {
        if (this.a != null) {
            this.a.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return this.a != null ? this.a.isStateful() : super.isStateful() || !(this.f135c == null || this.f135c.f123c == null || !this.f135c.f123c.isStateful());
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
        } else if (!this.f138f && super.mutate() == this) {
            this.f135c = new C0100f(this.f135c);
            this.f138f = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        }
    }

    protected boolean onStateChange(int[] iArr) {
        if (this.a != null) {
            return this.a.setState(iArr);
        }
        C0100f c0100f = this.f135c;
        if (c0100f.f123c == null || c0100f.f124d == null) {
            return false;
        }
        this.f136d = m209a(this.f136d, c0100f.f123c, c0100f.f124d);
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.a != null) {
            this.a.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else if (this.f135c.f122b.m188a() != i) {
            this.f135c.f122b.m190a(i);
            invalidateSelf();
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
            return;
        }
        this.f137e = colorFilter;
        invalidateSelf();
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.a != null) {
            C0326a.m1260a(this.a, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            C0326a.m1262a(this.a, colorStateList);
            return;
        }
        C0100f c0100f = this.f135c;
        if (c0100f.f123c != colorStateList) {
            c0100f.f123c = colorStateList;
            this.f136d = m209a(this.f136d, colorStateList, c0100f.f124d);
            invalidateSelf();
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            C0326a.m1265a(this.a, mode);
            return;
        }
        C0100f c0100f = this.f135c;
        if (c0100f.f124d != mode) {
            c0100f.f124d = mode;
            this.f136d = m209a(this.f136d, c0100f.f123c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.a != null ? this.a.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.a != null) {
            this.a.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
