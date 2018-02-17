package com.davemorrissey.labs.subscaleview;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLongClickListener;
import android.view.ViewParent;
import com.davemorrissey.labs.subscaleview.C1327c.C1326a;
import com.davemorrissey.labs.subscaleview.p075a.C1318b;
import com.davemorrissey.labs.subscaleview.p075a.C1319a;
import com.davemorrissey.labs.subscaleview.p075a.C1320c;
import com.davemorrissey.labs.subscaleview.p075a.C1321d;
import com.davemorrissey.labs.subscaleview.p075a.C1322e;
import com.davemorrissey.labs.subscaleview.p075a.C1323f;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executor;

public class SubsamplingScaleImageView extends View {
    public static int f3337a;
    private static final String f3338b;
    private static final List<Integer> f3339c;
    private static final List<Integer> f3340d;
    private static final List<Integer> f3341e;
    private static final List<Integer> f3342f;
    private static final List<Integer> f3343g;
    private float f3344A;
    private int f3345B;
    private int f3346C;
    private float f3347D;
    private float f3348E;
    private PointF f3349F;
    private PointF f3350G;
    private PointF f3351H;
    private Float f3352I;
    private PointF f3353J;
    private PointF f3354K;
    private int f3355L;
    private int f3356M;
    private int f3357N;
    private Rect f3358O;
    private Rect f3359P;
    private boolean f3360Q;
    private boolean f3361R;
    private boolean f3362S;
    private int f3363T;
    private GestureDetector f3364U;
    private C1321d f3365V;
    private final Object f3366W;
    private C1318b<? extends C1320c> aa;
    private C1318b<? extends C1321d> ab;
    private PointF ac;
    private float ad;
    private final float ae;
    private float af;
    private boolean ag;
    private PointF ah;
    private PointF ai;
    private PointF aj;
    private C1308a ak;
    private boolean al;
    private boolean am;
    private C1312e an;
    private C1313f ao;
    private OnLongClickListener ap;
    private Handler aq;
    private Paint ar;
    private Paint as;
    private Paint at;
    private C1314g au;
    private Matrix av;
    private RectF aw;
    private float[] ax;
    private float[] ay;
    private float az;
    private Bitmap f3367h;
    private boolean f3368i;
    private boolean f3369j;
    private Uri f3370k;
    private int f3371l;
    private Map<Integer, List<C1315h>> f3372m;
    private boolean f3373n;
    private int f3374o;
    private float f3375p;
    private float f3376q;
    private int f3377r;
    private int f3378s;
    private int f3379t;
    private int f3380u;
    private int f3381v;
    private boolean f3382w;
    private boolean f3383x;
    private boolean f3384y;
    private boolean f3385z;

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.1 */
    class C13061 implements Callback {
        final /* synthetic */ SubsamplingScaleImageView f3285a;

        C13061(SubsamplingScaleImageView subsamplingScaleImageView) {
            this.f3285a = subsamplingScaleImageView;
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1 && this.f3285a.ap != null) {
                this.f3285a.f3363T = 0;
                super.setOnLongClickListener(this.f3285a.ap);
                this.f3285a.performLongClick();
                super.setOnLongClickListener(null);
            }
            return true;
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.2 */
    class C13072 extends SimpleOnGestureListener {
        final /* synthetic */ Context f3286a;
        final /* synthetic */ SubsamplingScaleImageView f3287b;

        C13072(SubsamplingScaleImageView subsamplingScaleImageView, Context context) {
            this.f3287b = subsamplingScaleImageView;
            this.f3286a = context;
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (!this.f3287b.f3384y || !this.f3287b.al || this.f3287b.f3349F == null) {
                return super.onDoubleTapEvent(motionEvent);
            }
            this.f3287b.setGestureDetector(this.f3286a);
            if (this.f3287b.f3385z) {
                this.f3287b.ac = new PointF(motionEvent.getX(), motionEvent.getY());
                this.f3287b.f3350G = new PointF(this.f3287b.f3349F.x, this.f3287b.f3349F.y);
                this.f3287b.f3348E = this.f3287b.f3347D;
                this.f3287b.f3362S = true;
                this.f3287b.f3360Q = true;
                this.f3287b.af = -1.0f;
                this.f3287b.ai = this.f3287b.m6301a(this.f3287b.ac);
                this.f3287b.aj = new PointF(motionEvent.getX(), motionEvent.getY());
                this.f3287b.ah = new PointF(this.f3287b.ai.x, this.f3287b.ai.y);
                this.f3287b.ag = false;
                return false;
            }
            this.f3287b.m6233a(this.f3287b.m6301a(new PointF(motionEvent.getX(), motionEvent.getY())), new PointF(motionEvent.getX(), motionEvent.getY()));
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (!this.f3287b.f3383x || !this.f3287b.al || this.f3287b.f3349F == null || motionEvent == null || motionEvent2 == null || ((Math.abs(motionEvent.getX() - motionEvent2.getX()) <= 50.0f && Math.abs(motionEvent.getY() - motionEvent2.getY()) <= 50.0f) || ((Math.abs(f) <= 500.0f && Math.abs(f2) <= 500.0f) || this.f3287b.f3360Q))) {
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }
            PointF pointF = new PointF(this.f3287b.f3349F.x + (f * 0.25f), this.f3287b.f3349F.y + (0.25f * f2));
            new C1309b(new PointF((((float) (this.f3287b.getWidth() / 2)) - pointF.x) / this.f3287b.f3347D, (((float) (this.f3287b.getHeight() / 2)) - pointF.y) / this.f3287b.f3347D), null).m6176a(1).m6175b(false).m6174b(3).m6179a();
            return true;
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            this.f3287b.performClick();
            return true;
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.a */
    private static class C1308a {
        private float f3288a;
        private float f3289b;
        private PointF f3290c;
        private PointF f3291d;
        private PointF f3292e;
        private PointF f3293f;
        private PointF f3294g;
        private long f3295h;
        private boolean f3296i;
        private int f3297j;
        private int f3298k;
        private long f3299l;
        private C1311d f3300m;

        private C1308a() {
            this.f3295h = 500;
            this.f3296i = true;
            this.f3297j = 2;
            this.f3298k = 1;
            this.f3299l = System.currentTimeMillis();
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.b */
    public final class C1309b {
        final /* synthetic */ SubsamplingScaleImageView f3301a;
        private final float f3302b;
        private final PointF f3303c;
        private final PointF f3304d;
        private long f3305e;
        private int f3306f;
        private int f3307g;
        private boolean f3308h;
        private boolean f3309i;
        private C1311d f3310j;

        private C1309b(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF) {
            this.f3301a = subsamplingScaleImageView;
            this.f3305e = 500;
            this.f3306f = 2;
            this.f3307g = 1;
            this.f3308h = true;
            this.f3309i = true;
            this.f3302b = f;
            this.f3303c = pointF;
            this.f3304d = null;
        }

        private C1309b(SubsamplingScaleImageView subsamplingScaleImageView, float f, PointF pointF, PointF pointF2) {
            this.f3301a = subsamplingScaleImageView;
            this.f3305e = 500;
            this.f3306f = 2;
            this.f3307g = 1;
            this.f3308h = true;
            this.f3309i = true;
            this.f3302b = f;
            this.f3303c = pointF;
            this.f3304d = pointF2;
        }

        private C1309b(SubsamplingScaleImageView subsamplingScaleImageView, PointF pointF) {
            this.f3301a = subsamplingScaleImageView;
            this.f3305e = 500;
            this.f3306f = 2;
            this.f3307g = 1;
            this.f3308h = true;
            this.f3309i = true;
            this.f3302b = subsamplingScaleImageView.f3347D;
            this.f3303c = pointF;
            this.f3304d = null;
        }

        private C1309b m6174b(int i) {
            this.f3307g = i;
            return this;
        }

        private C1309b m6175b(boolean z) {
            this.f3309i = z;
            return this;
        }

        public C1309b m6176a(int i) {
            if (SubsamplingScaleImageView.f3341e.contains(Integer.valueOf(i))) {
                this.f3306f = i;
                return this;
            }
            throw new IllegalArgumentException("Unknown easing type: " + i);
        }

        public C1309b m6177a(long j) {
            this.f3305e = j;
            return this;
        }

        public C1309b m6178a(boolean z) {
            this.f3308h = z;
            return this;
        }

        public void m6179a() {
            if (!(this.f3301a.ak == null || this.f3301a.ak.f3300m == null)) {
                try {
                    this.f3301a.ak.f3300m.m6184c();
                } catch (Throwable e) {
                    Log.w(SubsamplingScaleImageView.f3338b, "Error thrown by animation listener", e);
                }
            }
            int width = (((this.f3301a.getWidth() - this.f3301a.getPaddingRight()) - this.f3301a.getPaddingLeft()) / 2) + this.f3301a.getPaddingLeft();
            int height = (((this.f3301a.getHeight() - this.f3301a.getPaddingBottom()) - this.f3301a.getPaddingTop()) / 2) + this.f3301a.getPaddingTop();
            float c = this.f3301a.m6279f(this.f3302b);
            PointF a = this.f3309i ? this.f3301a.m6224a(this.f3303c.x, this.f3303c.y, c, new PointF()) : this.f3303c;
            this.f3301a.ak = new C1308a();
            this.f3301a.ak.f3288a = this.f3301a.f3347D;
            this.f3301a.ak.f3289b = c;
            this.f3301a.ak.f3299l = System.currentTimeMillis();
            this.f3301a.ak.f3292e = a;
            this.f3301a.ak.f3290c = this.f3301a.getCenter();
            this.f3301a.ak.f3291d = a;
            this.f3301a.ak.f3293f = this.f3301a.m6306b(a);
            this.f3301a.ak.f3294g = new PointF((float) width, (float) height);
            this.f3301a.ak.f3295h = this.f3305e;
            this.f3301a.ak.f3296i = this.f3308h;
            this.f3301a.ak.f3297j = this.f3306f;
            this.f3301a.ak.f3298k = this.f3307g;
            this.f3301a.ak.f3299l = System.currentTimeMillis();
            this.f3301a.ak.f3300m = this.f3310j;
            if (this.f3304d != null) {
                float f = this.f3304d.x - (this.f3301a.ak.f3290c.x * c);
                float f2 = this.f3304d.y - (this.f3301a.ak.f3290c.y * c);
                C1314g c1314g = new C1314g(new PointF(f, f2), null);
                this.f3301a.m6249a(true, c1314g);
                this.f3301a.ak.f3294g = new PointF((c1314g.f3319b.x - f) + this.f3304d.x, (c1314g.f3319b.y - f2) + this.f3304d.y);
            }
            this.f3301a.invalidate();
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.c */
    private static class C1310c extends AsyncTask<Void, Void, Integer> {
        private final WeakReference<SubsamplingScaleImageView> f3311a;
        private final WeakReference<Context> f3312b;
        private final WeakReference<C1318b<? extends C1320c>> f3313c;
        private final Uri f3314d;
        private final boolean f3315e;
        private Bitmap f3316f;
        private Exception f3317g;

        C1310c(SubsamplingScaleImageView subsamplingScaleImageView, Context context, C1318b<? extends C1320c> c1318b, Uri uri, boolean z) {
            this.f3311a = new WeakReference(subsamplingScaleImageView);
            this.f3312b = new WeakReference(context);
            this.f3313c = new WeakReference(c1318b);
            this.f3314d = uri;
            this.f3315e = z;
        }

        protected Integer m6180a(Void... voidArr) {
            try {
                String uri = this.f3314d.toString();
                Context context = (Context) this.f3312b.get();
                C1318b c1318b = (C1318b) this.f3313c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3311a.get();
                if (!(context == null || c1318b == null || subsamplingScaleImageView == null)) {
                    subsamplingScaleImageView.m6247a("BitmapLoadTask.doInBackground", new Object[0]);
                    this.f3316f = ((C1320c) c1318b.m6309a()).m6311a(context, this.f3314d);
                    return Integer.valueOf(subsamplingScaleImageView.m6219a(context, uri));
                }
            } catch (Throwable e) {
                Log.e(SubsamplingScaleImageView.f3338b, "Failed to load bitmap", e);
                this.f3317g = e;
            } catch (Throwable e2) {
                Log.e(SubsamplingScaleImageView.f3338b, "Failed to load bitmap - OutOfMemoryError", e2);
                this.f3317g = new RuntimeException(e2);
            }
            return null;
        }

        protected void m6181a(Integer num) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3311a.get();
            if (subsamplingScaleImageView == null) {
                return;
            }
            if (this.f3316f == null || num == null) {
                if (this.f3317g != null && subsamplingScaleImageView.an != null) {
                    if (this.f3315e) {
                        subsamplingScaleImageView.an.m6186a(this.f3317g);
                    } else {
                        subsamplingScaleImageView.an.m6188b(this.f3317g);
                    }
                }
            } else if (this.f3315e) {
                subsamplingScaleImageView.m6230a(this.f3316f);
            } else {
                subsamplingScaleImageView.m6231a(this.f3316f, num.intValue(), false);
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6180a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6181a((Integer) obj);
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.d */
    public interface C1311d {
        void m6182a();

        void m6183b();

        void m6184c();
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.e */
    public interface C1312e {
        void m6185a();

        void m6186a(Exception exception);

        void m6187b();

        void m6188b(Exception exception);

        void m6189c();

        void m6190c(Exception exception);
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.f */
    public interface C1313f {
        void m6191a(float f, int i);

        void m6192a(PointF pointF, int i);
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.g */
    private static class C1314g {
        private float f3318a;
        private PointF f3319b;

        private C1314g(float f, PointF pointF) {
            this.f3318a = f;
            this.f3319b = pointF;
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.h */
    private static class C1315h {
        private Rect f3320a;
        private int f3321b;
        private Bitmap f3322c;
        private boolean f3323d;
        private boolean f3324e;
        private Rect f3325f;
        private Rect f3326g;

        private C1315h() {
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.i */
    private static class C1316i extends AsyncTask<Void, Void, Bitmap> {
        private final WeakReference<SubsamplingScaleImageView> f3327a;
        private final WeakReference<C1321d> f3328b;
        private final WeakReference<C1315h> f3329c;
        private Exception f3330d;

        C1316i(SubsamplingScaleImageView subsamplingScaleImageView, C1321d c1321d, C1315h c1315h) {
            this.f3327a = new WeakReference(subsamplingScaleImageView);
            this.f3328b = new WeakReference(c1321d);
            this.f3329c = new WeakReference(c1315h);
            c1315h.f3323d = true;
        }

        protected Bitmap m6210a(Void... voidArr) {
            try {
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3327a.get();
                C1321d c1321d = (C1321d) this.f3328b.get();
                C1315h c1315h = (C1315h) this.f3329c.get();
                if (c1321d == null || c1315h == null || subsamplingScaleImageView == null || !c1321d.m6314a() || !c1315h.f3324e) {
                    if (c1315h != null) {
                        c1315h.f3323d = false;
                    }
                    return null;
                }
                Bitmap a;
                subsamplingScaleImageView.m6247a("TileLoadTask.doInBackground, tile.sRect=%s, tile.sampleSize=%d", c1315h.f3320a, Integer.valueOf(c1315h.f3321b));
                synchronized (subsamplingScaleImageView.f3366W) {
                    subsamplingScaleImageView.m6234a(c1315h.f3320a, c1315h.f3326g);
                    if (subsamplingScaleImageView.f3358O != null) {
                        c1315h.f3326g.offset(subsamplingScaleImageView.f3358O.left, subsamplingScaleImageView.f3358O.top);
                    }
                    a = c1321d.m6312a(c1315h.f3326g, c1315h.f3321b);
                }
                return a;
            } catch (Throwable e) {
                Log.e(SubsamplingScaleImageView.f3338b, "Failed to decode tile", e);
                this.f3330d = e;
            } catch (Throwable e2) {
                Log.e(SubsamplingScaleImageView.f3338b, "Failed to decode tile - OutOfMemoryError", e2);
                this.f3330d = new RuntimeException(e2);
            }
        }

        protected void m6211a(Bitmap bitmap) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3327a.get();
            C1315h c1315h = (C1315h) this.f3329c.get();
            if (subsamplingScaleImageView != null && c1315h != null) {
                if (bitmap != null) {
                    c1315h.f3322c = bitmap;
                    c1315h.f3323d = false;
                    subsamplingScaleImageView.m6291k();
                } else if (this.f3330d != null && subsamplingScaleImageView.an != null) {
                    subsamplingScaleImageView.an.m6190c(this.f3330d);
                }
            }
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6210a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6211a((Bitmap) obj);
        }
    }

    /* renamed from: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.j */
    private static class C1317j extends AsyncTask<Void, Void, int[]> {
        private final WeakReference<SubsamplingScaleImageView> f3331a;
        private final WeakReference<Context> f3332b;
        private final WeakReference<C1318b<? extends C1321d>> f3333c;
        private final Uri f3334d;
        private C1321d f3335e;
        private Exception f3336f;

        C1317j(SubsamplingScaleImageView subsamplingScaleImageView, Context context, C1318b<? extends C1321d> c1318b, Uri uri) {
            this.f3331a = new WeakReference(subsamplingScaleImageView);
            this.f3332b = new WeakReference(context);
            this.f3333c = new WeakReference(c1318b);
            this.f3334d = uri;
        }

        protected void m6212a(int[] iArr) {
            SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3331a.get();
            if (subsamplingScaleImageView == null) {
                return;
            }
            if (this.f3335e != null && iArr != null && iArr.length == 3) {
                subsamplingScaleImageView.m6245a(this.f3335e, iArr[0], iArr[1], iArr[2]);
            } else if (this.f3336f != null && subsamplingScaleImageView.an != null) {
                subsamplingScaleImageView.an.m6188b(this.f3336f);
            }
        }

        protected int[] m6213a(Void... voidArr) {
            try {
                String uri = this.f3334d.toString();
                Context context = (Context) this.f3332b.get();
                C1318b c1318b = (C1318b) this.f3333c.get();
                SubsamplingScaleImageView subsamplingScaleImageView = (SubsamplingScaleImageView) this.f3331a.get();
                if (!(context == null || c1318b == null || subsamplingScaleImageView == null)) {
                    int width;
                    subsamplingScaleImageView.m6247a("TilesInitTask.doInBackground", new Object[0]);
                    this.f3335e = (C1321d) c1318b.m6309a();
                    Point a = this.f3335e.m6313a(context, this.f3334d);
                    int i = a.x;
                    int i2 = a.y;
                    int a2 = subsamplingScaleImageView.m6219a(context, uri);
                    if (subsamplingScaleImageView.f3358O != null) {
                        width = subsamplingScaleImageView.f3358O.width();
                        i2 = subsamplingScaleImageView.f3358O.height();
                    } else {
                        width = i;
                    }
                    return new int[]{width, i2, a2};
                }
            } catch (Throwable e) {
                Log.e(SubsamplingScaleImageView.f3338b, "Failed to initialise bitmap decoder", e);
                this.f3336f = e;
            }
            return null;
        }

        protected /* synthetic */ Object doInBackground(Object[] objArr) {
            return m6213a((Void[]) objArr);
        }

        protected /* synthetic */ void onPostExecute(Object obj) {
            m6212a((int[]) obj);
        }
    }

    static {
        f3338b = SubsamplingScaleImageView.class.getSimpleName();
        f3339c = Arrays.asList(new Integer[]{Integer.valueOf(0), Integer.valueOf(90), Integer.valueOf(180), Integer.valueOf(270), Integer.valueOf(-1)});
        f3340d = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});
        f3341e = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1)});
        f3342f = Arrays.asList(new Integer[]{Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3)});
        f3343g = Arrays.asList(new Integer[]{Integer.valueOf(2), Integer.valueOf(1), Integer.valueOf(3)});
        f3337a = Integer.MAX_VALUE;
    }

    public SubsamplingScaleImageView(Context context) {
        this(context, null);
    }

    public SubsamplingScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3374o = 0;
        this.f3375p = 2.0f;
        this.f3376q = m6296n();
        this.f3377r = -1;
        this.f3378s = 1;
        this.f3379t = 1;
        this.f3380u = f3337a;
        this.f3381v = f3337a;
        this.f3383x = true;
        this.f3384y = true;
        this.f3385z = true;
        this.f3344A = 1.0f;
        this.f3345B = 1;
        this.f3346C = 500;
        this.f3366W = new Object();
        this.aa = new C1319a(C1322e.class);
        this.ab = new C1319a(C1323f.class);
        this.ax = new float[8];
        this.ay = new float[8];
        this.az = getResources().getDisplayMetrics().density;
        setMinimumDpi(160);
        setDoubleTapZoomDpi(160);
        setGestureDetector(context);
        this.aq = new Handler(new C13061(this));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C1326a.SubsamplingScaleImageView);
            if (obtainStyledAttributes.hasValue(C1326a.SubsamplingScaleImageView_assetName)) {
                String string = obtainStyledAttributes.getString(C1326a.SubsamplingScaleImageView_assetName);
                if (string != null && string.length() > 0) {
                    setImage(C1324a.m6322a(string).m6324a());
                }
            }
            if (obtainStyledAttributes.hasValue(C1326a.SubsamplingScaleImageView_src)) {
                int resourceId = obtainStyledAttributes.getResourceId(C1326a.SubsamplingScaleImageView_src, 0);
                if (resourceId > 0) {
                    setImage(C1324a.m6321a(resourceId).m6324a());
                }
            }
            if (obtainStyledAttributes.hasValue(C1326a.SubsamplingScaleImageView_panEnabled)) {
                setPanEnabled(obtainStyledAttributes.getBoolean(C1326a.SubsamplingScaleImageView_panEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(C1326a.SubsamplingScaleImageView_zoomEnabled)) {
                setZoomEnabled(obtainStyledAttributes.getBoolean(C1326a.SubsamplingScaleImageView_zoomEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(C1326a.SubsamplingScaleImageView_quickScaleEnabled)) {
                setQuickScaleEnabled(obtainStyledAttributes.getBoolean(C1326a.SubsamplingScaleImageView_quickScaleEnabled, true));
            }
            if (obtainStyledAttributes.hasValue(C1326a.SubsamplingScaleImageView_tileBackgroundColor)) {
                setTileBackgroundColor(obtainStyledAttributes.getColor(C1326a.SubsamplingScaleImageView_tileBackgroundColor, Color.argb(0, 0, 0, 0)));
            }
            obtainStyledAttributes.recycle();
        }
        this.ae = TypedValue.applyDimension(1, 20.0f, context.getResources().getDisplayMetrics());
    }

    private float m6214a(float f, float f2, float f3, float f4) {
        float f5 = f - f2;
        float f6 = f3 - f4;
        return (float) Math.sqrt((double) ((f5 * f5) + (f6 * f6)));
    }

    private float m6215a(int i, long j, float f, float f2, long j2) {
        switch (i) {
            case C1373c.View_android_focusable /*1*/:
                return m6216a(j, f, f2, j2);
            case C1373c.View_paddingStart /*2*/:
                return m6255b(j, f, f2, j2);
            default:
                throw new IllegalStateException("Unexpected easing type: " + i);
        }
    }

    private float m6216a(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / ((float) j2);
        return ((f3 - 2.0f) * ((-f2) * f3)) + f;
    }

    private int m6218a(float f) {
        if (this.f3377r > 0) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            f *= ((float) this.f3377r) / ((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f);
        }
        int l = (int) (((float) m6292l()) * f);
        int m = (int) (((float) m6294m()) * f);
        if (l == 0 || m == 0) {
            return 32;
        }
        if (m6294m() > m || m6292l() > l) {
            m = Math.round(((float) m6294m()) / ((float) m));
            l = Math.round(((float) m6292l()) / ((float) l));
            if (m >= l) {
                m = l;
            }
        } else {
            m = 1;
        }
        l = 1;
        while (l * 2 < m) {
            l *= 2;
        }
        return l;
    }

    private int m6219a(Context context, String str) {
        Cursor query;
        Cursor cursor;
        Throwable th;
        int i;
        if (str.startsWith("content")) {
            try {
                query = context.getContentResolver().query(Uri.parse(str), new String[]{"orientation"}, null, null, null);
                if (query != null) {
                    try {
                        if (query.moveToFirst()) {
                            i = query.getInt(0);
                            if (!f3339c.contains(Integer.valueOf(i)) || i == -1) {
                                Log.w(f3338b, "Unsupported orientation: " + i);
                            }
                            if (query != null) {
                                query.close();
                            }
                            return i;
                        }
                    } catch (Exception e) {
                        cursor = query;
                        try {
                            Log.w(f3338b, "Could not get orientation of image from media store");
                            if (cursor == null) {
                                cursor.close();
                                i = 0;
                            } else {
                                i = 0;
                            }
                            return i;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            query = cursor;
                            th = th3;
                            if (query != null) {
                                query.close();
                            }
                            throw th;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        if (query != null) {
                            query.close();
                        }
                        throw th;
                    }
                }
                i = 0;
                if (query != null) {
                    query.close();
                }
            } catch (Exception e2) {
                cursor = null;
                Log.w(f3338b, "Could not get orientation of image from media store");
                if (cursor == null) {
                    i = 0;
                } else {
                    cursor.close();
                    i = 0;
                }
                return i;
            } catch (Throwable th5) {
                th = th5;
                query = null;
                if (query != null) {
                    query.close();
                }
                throw th;
            }
            return i;
        } else if (!str.startsWith("file:///") || str.startsWith("file:///android_asset/")) {
            return 0;
        } else {
            try {
                i = new ExifInterface(str.substring("file:///".length() - 1)).getAttributeInt("Orientation", 1);
                if (i == 1 || i == 0) {
                    return 0;
                }
                if (i == 6) {
                    return 90;
                }
                if (i == 3) {
                    return 180;
                }
                if (i == 8) {
                    return 270;
                }
                Log.w(f3338b, "Unsupported EXIF orientation: " + i);
                return 0;
            } catch (Exception e3) {
                Log.w(f3338b, "Could not get EXIF orientation of image");
                return 0;
            }
        }
    }

    private Point m6222a(Canvas canvas) {
        int intValue;
        int i = 2048;
        if (VERSION.SDK_INT >= 14) {
            try {
                int intValue2 = ((Integer) Canvas.class.getMethod("getMaximumBitmapWidth", new Class[0]).invoke(canvas, new Object[0])).intValue();
                try {
                    intValue = ((Integer) Canvas.class.getMethod("getMaximumBitmapHeight", new Class[0]).invoke(canvas, new Object[0])).intValue();
                    i = intValue2;
                } catch (Exception e) {
                    intValue = intValue2;
                    i = intValue;
                    intValue = 2048;
                    return new Point(Math.min(i, this.f3380u), Math.min(intValue, this.f3381v));
                }
            } catch (Exception e2) {
                intValue = 2048;
                i = intValue;
                intValue = 2048;
                return new Point(Math.min(i, this.f3380u), Math.min(intValue, this.f3381v));
            }
        }
        intValue = 2048;
        return new Point(Math.min(i, this.f3380u), Math.min(intValue, this.f3381v));
    }

    private PointF m6223a(float f, float f2, float f3) {
        int paddingLeft = getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2);
        int paddingTop = getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2);
        if (this.au == null) {
            this.au = new C1314g(new PointF(0.0f, 0.0f), null);
        }
        this.au.f3318a = f3;
        this.au.f3319b.set(((float) paddingLeft) - (f * f3), ((float) paddingTop) - (f2 * f3));
        m6249a(true, this.au);
        return this.au.f3319b;
    }

    private PointF m6224a(float f, float f2, float f3, PointF pointF) {
        PointF a = m6223a(f, f2, f3);
        pointF.set((((float) (getPaddingLeft() + (((getWidth() - getPaddingRight()) - getPaddingLeft()) / 2))) - a.x) / f3, (((float) (getPaddingTop() + (((getHeight() - getPaddingBottom()) - getPaddingTop()) / 2))) - a.y) / f3);
        return pointF;
    }

    private void m6229a(float f, PointF pointF, int i) {
        if (this.ao != null) {
            if (this.f3347D != f) {
                this.ao.m6191a(this.f3347D, i);
            }
            if (!this.f3349F.equals(pointF)) {
                this.ao.m6192a(getCenter(), i);
            }
        }
    }

    private synchronized void m6230a(Bitmap bitmap) {
        m6247a("onPreviewLoaded", new Object[0]);
        if (this.f3367h != null || this.am) {
            bitmap.recycle();
        } else {
            if (this.f3359P != null) {
                this.f3367h = Bitmap.createBitmap(bitmap, this.f3359P.left, this.f3359P.top, this.f3359P.width(), this.f3359P.height());
            } else {
                this.f3367h = bitmap;
            }
            this.f3368i = true;
            if (m6282g()) {
                invalidate();
                requestLayout();
            }
        }
    }

    private synchronized void m6231a(Bitmap bitmap, int i, boolean z) {
        m6247a("onImageLoaded", new Object[0]);
        if (this.f3355L > 0 && this.f3356M > 0 && !(this.f3355L == bitmap.getWidth() && this.f3356M == bitmap.getHeight())) {
            m6248a(false);
        }
        if (!(this.f3367h == null || this.f3369j)) {
            this.f3367h.recycle();
        }
        if (!(this.f3367h == null || !this.f3369j || this.an == null)) {
            this.an.m6189c();
        }
        this.f3368i = false;
        this.f3369j = z;
        this.f3367h = bitmap;
        this.f3355L = bitmap.getWidth();
        this.f3356M = bitmap.getHeight();
        this.f3357N = i;
        boolean g = m6282g();
        boolean h = m6284h();
        if (g || h) {
            invalidate();
            requestLayout();
        }
    }

    private synchronized void m6232a(Point point) {
        m6247a("initialiseBaseLayer maxTileDimensions=%dx%d", Integer.valueOf(point.x), Integer.valueOf(point.y));
        this.au = new C1314g(new PointF(0.0f, 0.0f), null);
        m6249a(true, this.au);
        this.f3371l = m6218a(this.au.f3318a);
        if (this.f3371l > 1) {
            this.f3371l /= 2;
        }
        if (this.f3371l != 1 || this.f3358O != null || m6292l() >= point.x || m6294m() >= point.y) {
            m6259b(point);
            for (C1315h c1316i : (List) this.f3372m.get(Integer.valueOf(this.f3371l))) {
                m6235a(new C1316i(this, this.f3365V, c1316i));
            }
            m6267c(true);
        } else {
            this.f3365V.m6315b();
            this.f3365V = null;
            m6235a(new C1310c(this, getContext(), this.aa, this.f3370k, false));
        }
    }

    private void m6233a(PointF pointF, PointF pointF2) {
        if (!this.f3383x) {
            if (this.f3354K != null) {
                pointF.x = this.f3354K.x;
                pointF.y = this.f3354K.y;
            } else {
                pointF.x = (float) (m6292l() / 2);
                pointF.y = (float) (m6294m() / 2);
            }
        }
        float min = Math.min(this.f3375p, this.f3344A);
        Object obj = ((double) this.f3347D) <= ((double) min) * 0.9d ? 1 : null;
        if (obj == null) {
            min = m6296n();
        }
        if (this.f3345B == 3) {
            m6302a(min, pointF);
        } else if (this.f3345B == 2 || obj == null || !this.f3383x) {
            new C1309b(min, pointF, null).m6178a(false).m6177a((long) this.f3346C).m6174b(4).m6179a();
        } else if (this.f3345B == 1) {
            new C1309b(min, pointF, pointF2, null).m6178a(false).m6177a((long) this.f3346C).m6174b(4).m6179a();
        }
        invalidate();
    }

    private void m6234a(Rect rect, Rect rect2) {
        if (getRequiredRotation() == 0) {
            rect2.set(rect);
        } else if (getRequiredRotation() == 90) {
            rect2.set(rect.top, this.f3356M - rect.right, rect.bottom, this.f3356M - rect.left);
        } else if (getRequiredRotation() == 180) {
            rect2.set(this.f3355L - rect.right, this.f3356M - rect.bottom, this.f3355L - rect.left, this.f3356M - rect.top);
        } else {
            rect2.set(this.f3355L - rect.bottom, rect.left, this.f3355L - rect.top, rect.right);
        }
    }

    private void m6235a(AsyncTask<Void, Void, ?> asyncTask) {
        if (this.f3382w && VERSION.SDK_INT >= 11) {
            try {
                Executor executor = (Executor) AsyncTask.class.getField("THREAD_POOL_EXECUTOR").get(null);
                AsyncTask.class.getMethod("executeOnExecutor", new Class[]{Executor.class, Object[].class}).invoke(asyncTask, new Object[]{executor, null});
                return;
            } catch (Throwable e) {
                Log.i(f3338b, "Failed to execute AsyncTask on thread pool executor, falling back to single threaded executor", e);
            }
        }
        asyncTask.execute(new Void[0]);
    }

    private synchronized void m6245a(C1321d c1321d, int i, int i2, int i3) {
        m6247a("onTilesInited sWidth=%d, sHeight=%d, sOrientation=%d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(this.f3374o));
        if (this.f3355L > 0 && this.f3356M > 0 && !(this.f3355L == i && this.f3356M == i2)) {
            m6248a(false);
            if (this.f3367h != null) {
                if (!this.f3369j) {
                    this.f3367h.recycle();
                }
                this.f3367h = null;
                if (this.an != null && this.f3369j) {
                    this.an.m6189c();
                }
                this.f3368i = false;
                this.f3369j = false;
            }
        }
        this.f3365V = c1321d;
        this.f3355L = i;
        this.f3356M = i2;
        this.f3357N = i3;
        m6282g();
        if (!m6284h() && this.f3380u > 0 && this.f3380u != f3337a && this.f3381v > 0 && this.f3381v != f3337a && getWidth() > 0 && getHeight() > 0) {
            m6232a(new Point(this.f3380u, this.f3381v));
        }
        invalidate();
        requestLayout();
    }

    private void m6246a(C1325b c1325b) {
        if (c1325b != null && c1325b.m6335b() != null && f3339c.contains(Integer.valueOf(c1325b.m6336c()))) {
            this.f3374o = c1325b.m6336c();
            this.f3352I = Float.valueOf(c1325b.m6334a());
            this.f3353J = c1325b.m6335b();
            invalidate();
        }
    }

    private void m6247a(String str, Object... objArr) {
        if (this.f3373n) {
            Log.d(f3338b, String.format(str, objArr));
        }
    }

    private void m6248a(boolean z) {
        m6247a("reset newImage=" + z, new Object[0]);
        this.f3347D = 0.0f;
        this.f3348E = 0.0f;
        this.f3349F = null;
        this.f3350G = null;
        this.f3351H = null;
        this.f3352I = Float.valueOf(0.0f);
        this.f3353J = null;
        this.f3354K = null;
        this.f3360Q = false;
        this.f3361R = false;
        this.f3362S = false;
        this.f3363T = 0;
        this.f3371l = 0;
        this.ac = null;
        this.ad = 0.0f;
        this.af = 0.0f;
        this.ag = false;
        this.ai = null;
        this.ah = null;
        this.aj = null;
        this.ak = null;
        this.au = null;
        this.av = null;
        this.aw = null;
        if (z) {
            this.f3370k = null;
            if (this.f3365V != null) {
                synchronized (this.f3366W) {
                    this.f3365V.m6315b();
                    this.f3365V = null;
                }
            }
            if (!(this.f3367h == null || this.f3369j)) {
                this.f3367h.recycle();
            }
            if (!(this.f3367h == null || !this.f3369j || this.an == null)) {
                this.an.m6189c();
            }
            this.f3355L = 0;
            this.f3356M = 0;
            this.f3357N = 0;
            this.f3358O = null;
            this.f3359P = null;
            this.al = false;
            this.am = false;
            this.f3367h = null;
            this.f3368i = false;
            this.f3369j = false;
        }
        if (this.f3372m != null) {
            for (Entry value : this.f3372m.entrySet()) {
                for (C1315h c1315h : (List) value.getValue()) {
                    c1315h.f3324e = false;
                    if (c1315h.f3322c != null) {
                        c1315h.f3322c.recycle();
                        c1315h.f3322c = null;
                    }
                }
            }
            this.f3372m = null;
        }
        setGestureDetector(getContext());
    }

    private void m6249a(boolean z, C1314g c1314g) {
        float max;
        float f = 0.5f;
        if (this.f3378s == 2 && m6304a()) {
            z = false;
        }
        PointF b = c1314g.f3319b;
        float f2 = m6279f(c1314g.f3318a);
        float l = f2 * ((float) m6292l());
        float m = f2 * ((float) m6294m());
        if (this.f3378s == 3 && m6304a()) {
            b.x = Math.max(b.x, ((float) (getWidth() / 2)) - l);
            b.y = Math.max(b.y, ((float) (getHeight() / 2)) - m);
        } else if (z) {
            b.x = Math.max(b.x, ((float) getWidth()) - l);
            b.y = Math.max(b.y, ((float) getHeight()) - m);
        } else {
            b.x = Math.max(b.x, -l);
            b.y = Math.max(b.y, -m);
        }
        float paddingLeft = (getPaddingLeft() > 0 || getPaddingRight() > 0) ? ((float) getPaddingLeft()) / ((float) (getPaddingLeft() + getPaddingRight())) : 0.5f;
        if (getPaddingTop() > 0 || getPaddingBottom() > 0) {
            f = ((float) getPaddingTop()) / ((float) (getPaddingTop() + getPaddingBottom()));
        }
        if (this.f3378s == 3 && m6304a()) {
            paddingLeft = (float) Math.max(0, getWidth() / 2);
            max = (float) Math.max(0, getHeight() / 2);
        } else if (z) {
            paddingLeft = Math.max(0.0f, (((float) getWidth()) - l) * paddingLeft);
            max = Math.max(0.0f, (((float) getHeight()) - m) * f);
        } else {
            paddingLeft = (float) Math.max(0, getWidth());
            max = (float) Math.max(0, getHeight());
        }
        b.x = Math.min(b.x, paddingLeft);
        b.y = Math.min(b.y, max);
        c1314g.f3318a = f2;
    }

    private void m6250a(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        fArr[0] = f;
        fArr[1] = f2;
        fArr[2] = f3;
        fArr[3] = f4;
        fArr[4] = f5;
        fArr[5] = f6;
        fArr[6] = f7;
        fArr[7] = f8;
    }

    private boolean m6251a(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float a;
        switch (motionEvent.getAction()) {
            case C1373c.View_android_theme /*0*/:
            case C1373c.Toolbar_contentInsetStart /*5*/:
            case 261:
                this.ak = null;
                m6261b(true);
                this.f3363T = Math.max(this.f3363T, pointerCount);
                if (pointerCount >= 2) {
                    if (this.f3384y) {
                        a = m6214a(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                        this.f3348E = this.f3347D;
                        this.ad = a;
                        this.f3350G.set(this.f3349F.x, this.f3349F.y);
                        this.ac.set((motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f, (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f);
                    } else {
                        this.f3363T = 0;
                    }
                    this.aq.removeMessages(1);
                    return true;
                } else if (this.f3362S) {
                    return true;
                } else {
                    this.f3350G.set(this.f3349F.x, this.f3349F.y);
                    this.ac.set(motionEvent.getX(), motionEvent.getY());
                    this.aq.sendEmptyMessageDelayed(1, 600);
                    return true;
                }
            case C1373c.View_android_focusable /*1*/:
            case C1373c.Toolbar_contentInsetEnd /*6*/:
            case 262:
                this.aq.removeMessages(1);
                if (this.f3362S) {
                    this.f3362S = false;
                    if (!this.ag) {
                        m6233a(this.ai, this.ac);
                    }
                }
                if (this.f3363T > 0 && (this.f3360Q || this.f3361R)) {
                    if (this.f3360Q && pointerCount == 2) {
                        this.f3361R = true;
                        this.f3350G.set(this.f3349F.x, this.f3349F.y);
                        if (motionEvent.getActionIndex() == 1) {
                            this.ac.set(motionEvent.getX(0), motionEvent.getY(0));
                        } else {
                            this.ac.set(motionEvent.getX(1), motionEvent.getY(1));
                        }
                    }
                    if (pointerCount < 3) {
                        this.f3360Q = false;
                    }
                    if (pointerCount < 2) {
                        this.f3361R = false;
                        this.f3363T = 0;
                    }
                    m6267c(true);
                    return true;
                } else if (pointerCount != 1) {
                    return true;
                } else {
                    this.f3360Q = false;
                    this.f3361R = false;
                    this.f3363T = 0;
                    return true;
                }
            case C1373c.View_paddingStart /*2*/:
                boolean z;
                if (this.f3363T > 0) {
                    float x;
                    float y;
                    double d;
                    if (pointerCount >= 2) {
                        a = m6214a(motionEvent.getX(0), motionEvent.getX(1), motionEvent.getY(0), motionEvent.getY(1));
                        x = (motionEvent.getX(0) + motionEvent.getX(1)) / 2.0f;
                        y = (motionEvent.getY(0) + motionEvent.getY(1)) / 2.0f;
                        if (this.f3384y && (m6214a(this.ac.x, x, this.ac.y, y) > 5.0f || Math.abs(a - this.ad) > 5.0f || this.f3361R)) {
                            this.f3360Q = true;
                            this.f3361R = true;
                            d = (double) this.f3347D;
                            this.f3347D = Math.min(this.f3375p, (a / this.ad) * this.f3348E);
                            if (this.f3347D <= m6296n()) {
                                this.ad = a;
                                this.f3348E = m6296n();
                                this.ac.set(x, y);
                                this.f3350G.set(this.f3349F);
                            } else if (this.f3383x) {
                                float f = (this.ac.y - this.f3350G.y) * (this.f3347D / this.f3348E);
                                this.f3349F.x = x - ((this.ac.x - this.f3350G.x) * (this.f3347D / this.f3348E));
                                this.f3349F.y = y - f;
                                if ((((double) m6294m()) * d < ((double) getHeight()) && this.f3347D * ((float) m6294m()) >= ((float) getHeight())) || (d * ((double) m6292l()) < ((double) getWidth()) && this.f3347D * ((float) m6292l()) >= ((float) getWidth()))) {
                                    m6274d(true);
                                    this.ac.set(x, y);
                                    this.f3350G.set(this.f3349F);
                                    this.f3348E = this.f3347D;
                                    this.ad = a;
                                }
                            } else if (this.f3354K != null) {
                                this.f3349F.x = ((float) (getWidth() / 2)) - (this.f3347D * this.f3354K.x);
                                this.f3349F.y = ((float) (getHeight() / 2)) - (this.f3347D * this.f3354K.y);
                            } else {
                                this.f3349F.x = ((float) (getWidth() / 2)) - (this.f3347D * ((float) (m6292l() / 2)));
                                this.f3349F.y = ((float) (getHeight() / 2)) - (this.f3347D * ((float) (m6294m() / 2)));
                            }
                            m6274d(true);
                            m6267c(false);
                        }
                    } else if (this.f3362S) {
                        y = this.ae + (Math.abs(this.aj.y - motionEvent.getY()) * 2.0f);
                        if (this.af == -1.0f) {
                            this.af = y;
                        }
                        z = motionEvent.getY() > this.ah.y;
                        this.ah.set(0.0f, motionEvent.getY());
                        r5 = Math.abs(1.0f - (y / this.af)) * 0.5f;
                        if (r5 > 0.03f || this.ag) {
                            this.ag = true;
                            a = this.af > 0.0f ? z ? 1.0f + r5 : 1.0f - r5 : 1.0f;
                            d = (double) this.f3347D;
                            this.f3347D = Math.max(m6296n(), Math.min(this.f3375p, a * this.f3347D));
                            if (this.f3383x) {
                                x = (this.ac.y - this.f3350G.y) * (this.f3347D / this.f3348E);
                                this.f3349F.x = this.ac.x - ((this.ac.x - this.f3350G.x) * (this.f3347D / this.f3348E));
                                this.f3349F.y = this.ac.y - x;
                                if ((((double) m6294m()) * d >= ((double) getHeight()) || this.f3347D * ((float) m6294m()) < ((float) getHeight())) && (d * ((double) m6292l()) >= ((double) getWidth()) || this.f3347D * ((float) m6292l()) < ((float) getWidth()))) {
                                    a = y;
                                } else {
                                    m6274d(true);
                                    this.ac.set(m6306b(this.ai));
                                    this.f3350G.set(this.f3349F);
                                    this.f3348E = this.f3347D;
                                    a = 0.0f;
                                }
                                y = a;
                            } else if (this.f3354K != null) {
                                this.f3349F.x = ((float) (getWidth() / 2)) - (this.f3347D * this.f3354K.x);
                                this.f3349F.y = ((float) (getHeight() / 2)) - (this.f3347D * this.f3354K.y);
                            } else {
                                this.f3349F.x = ((float) (getWidth() / 2)) - (this.f3347D * ((float) (m6292l() / 2)));
                                this.f3349F.y = ((float) (getHeight() / 2)) - (this.f3347D * ((float) (m6294m() / 2)));
                            }
                        }
                        this.af = y;
                        m6274d(true);
                        m6267c(false);
                        z = true;
                        if (z) {
                            this.aq.removeMessages(1);
                            invalidate();
                            return true;
                        }
                    } else if (!this.f3360Q) {
                        r5 = Math.abs(motionEvent.getX() - this.ac.x);
                        x = Math.abs(motionEvent.getY() - this.ac.y);
                        float f2 = this.az * 5.0f;
                        if (r5 > f2 || x > f2 || this.f3361R) {
                            this.f3349F.x = this.f3350G.x + (motionEvent.getX() - this.ac.x);
                            this.f3349F.y = this.f3350G.y + (motionEvent.getY() - this.ac.y);
                            a = this.f3349F.x;
                            float f3 = this.f3349F.y;
                            m6274d(true);
                            boolean z2 = a != this.f3349F.x;
                            z = z2 && r5 > x && !this.f3361R;
                            boolean z3 = f3 == this.f3349F.y && x > 3.0f * f2;
                            if (!z && (!z2 || z3 || this.f3361R)) {
                                this.f3361R = true;
                            } else if (r5 > f2) {
                                this.f3363T = 0;
                                this.aq.removeMessages(1);
                                m6261b(false);
                            }
                            if (!this.f3383x) {
                                this.f3349F.x = this.f3350G.x;
                                this.f3349F.y = this.f3350G.y;
                                m6261b(false);
                            }
                            m6267c(false);
                        }
                    }
                    z = true;
                    if (z) {
                        this.aq.removeMessages(1);
                        invalidate();
                        return true;
                    }
                }
                z = false;
                if (z) {
                    this.aq.removeMessages(1);
                    invalidate();
                    return true;
                }
                break;
        }
        return false;
    }

    private boolean m6252a(C1315h c1315h) {
        return m6254b(0.0f) <= ((float) c1315h.f3320a.right) && ((float) c1315h.f3320a.left) <= m6254b((float) getWidth()) && m6264c(0.0f) <= ((float) c1315h.f3320a.bottom) && ((float) c1315h.f3320a.top) <= m6264c((float) getHeight());
    }

    private float m6254b(float f) {
        return this.f3349F == null ? Float.NaN : (f - this.f3349F.x) / this.f3347D;
    }

    private float m6255b(long j, float f, float f2, long j2) {
        float f3 = ((float) j) / (((float) j2) / 2.0f);
        if (f3 < 1.0f) {
            return (f3 * ((f2 / 2.0f) * f3)) + f;
        }
        f3 -= 1.0f;
        return (((f3 * (f3 - 2.0f)) - 1.0f) * ((-f2) / 2.0f)) + f;
    }

    private Rect m6258b(Rect rect, Rect rect2) {
        rect2.set((int) m6270d((float) rect.left), (int) m6275e((float) rect.top), (int) m6270d((float) rect.right), (int) m6275e((float) rect.bottom));
        return rect2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6259b(android.graphics.Point r18) {
        /*
        r17 = this;
        r2 = "initialiseTileMap maxTileDimensions=%dx%d";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = 0;
        r0 = r18;
        r5 = r0.x;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r4 = 1;
        r0 = r18;
        r5 = r0.y;
        r5 = java.lang.Integer.valueOf(r5);
        r3[r4] = r5;
        r0 = r17;
        r0.m6247a(r2, r3);
        r2 = new java.util.LinkedHashMap;
        r2.<init>();
        r0 = r17;
        r0.f3372m = r2;
        r0 = r17;
        r4 = r0.f3371l;
        r3 = 1;
        r2 = 1;
    L_0x002f:
        r5 = r17.m6292l();
        r6 = r5 / r3;
        r5 = r17.m6294m();
        r8 = r5 / r2;
        r5 = r6 / r4;
        r7 = r8 / r4;
    L_0x003f:
        r9 = r5 + r3;
        r9 = r9 + 1;
        r0 = r18;
        r10 = r0.x;
        if (r9 > r10) goto L_0x005c;
    L_0x0049:
        r10 = (double) r5;
        r5 = r17.getWidth();
        r12 = (double) r5;
        r14 = 4608308318706860032; // 0x3ff4000000000000 float:0.0 double:1.25;
        r12 = r12 * r14;
        r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r5 <= 0) goto L_0x011b;
    L_0x0056:
        r0 = r17;
        r5 = r0.f3371l;
        if (r4 >= r5) goto L_0x011b;
    L_0x005c:
        r6 = r3 + 1;
        r3 = r17.m6292l();
        r5 = r3 / r6;
        r3 = r5 / r4;
        r16 = r3;
        r3 = r6;
        r6 = r5;
        r5 = r16;
        goto L_0x003f;
    L_0x006d:
        r8 = r5 + r2;
        r8 = r8 + 1;
        r0 = r18;
        r9 = r0.y;
        if (r8 > r9) goto L_0x008a;
    L_0x0077:
        r8 = (double) r5;
        r5 = r17.getHeight();
        r10 = (double) r5;
        r12 = 4608308318706860032; // 0x3ff4000000000000 float:0.0 double:1.25;
        r10 = r10 * r12;
        r5 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
        if (r5 <= 0) goto L_0x009b;
    L_0x0084:
        r0 = r17;
        r5 = r0.f3371l;
        if (r4 >= r5) goto L_0x009b;
    L_0x008a:
        r7 = r2 + 1;
        r2 = r17.m6294m();
        r5 = r2 / r7;
        r2 = r5 / r4;
        r16 = r2;
        r2 = r7;
        r7 = r5;
        r5 = r16;
        goto L_0x006d;
    L_0x009b:
        r11 = new java.util.ArrayList;
        r5 = r3 * r2;
        r11.<init>(r5);
        r5 = 0;
        r10 = r5;
    L_0x00a4:
        if (r10 >= r3) goto L_0x0108;
    L_0x00a6:
        r5 = 0;
        r9 = r5;
    L_0x00a8:
        if (r9 >= r2) goto L_0x0104;
    L_0x00aa:
        r12 = new com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView$h;
        r5 = 0;
        r12.<init>();
        r12.f3321b = r4;
        r0 = r17;
        r5 = r0.f3371l;
        if (r4 != r5) goto L_0x00f9;
    L_0x00b9:
        r5 = 1;
    L_0x00ba:
        r12.f3324e = r5;
        r13 = new android.graphics.Rect;
        r14 = r10 * r6;
        r15 = r9 * r7;
        r5 = r3 + -1;
        if (r10 != r5) goto L_0x00fb;
    L_0x00c7:
        r5 = r17.m6292l();
        r8 = r5;
    L_0x00cc:
        r5 = r2 + -1;
        if (r9 != r5) goto L_0x0100;
    L_0x00d0:
        r5 = r17.m6294m();
    L_0x00d4:
        r13.<init>(r14, r15, r8, r5);
        r12.f3320a = r13;
        r5 = new android.graphics.Rect;
        r8 = 0;
        r13 = 0;
        r14 = 0;
        r15 = 0;
        r5.<init>(r8, r13, r14, r15);
        r12.f3325f = r5;
        r5 = new android.graphics.Rect;
        r8 = r12.f3320a;
        r5.<init>(r8);
        r12.f3326g = r5;
        r11.add(r12);
        r5 = r9 + 1;
        r9 = r5;
        goto L_0x00a8;
    L_0x00f9:
        r5 = 0;
        goto L_0x00ba;
    L_0x00fb:
        r5 = r10 + 1;
        r5 = r5 * r6;
        r8 = r5;
        goto L_0x00cc;
    L_0x0100:
        r5 = r9 + 1;
        r5 = r5 * r7;
        goto L_0x00d4;
    L_0x0104:
        r5 = r10 + 1;
        r10 = r5;
        goto L_0x00a4;
    L_0x0108:
        r0 = r17;
        r5 = r0.f3372m;
        r6 = java.lang.Integer.valueOf(r4);
        r5.put(r6, r11);
        r5 = 1;
        if (r4 != r5) goto L_0x0117;
    L_0x0116:
        return;
    L_0x0117:
        r4 = r4 / 2;
        goto L_0x002f;
    L_0x011b:
        r5 = r7;
        r7 = r8;
        goto L_0x006d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView.b(android.graphics.Point):void");
    }

    private void m6261b(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private float m6264c(float f) {
        return this.f3349F == null ? Float.NaN : (f - this.f3349F.y) / this.f3347D;
    }

    private void m6267c(boolean z) {
        if (this.f3365V != null && this.f3372m != null) {
            int min = Math.min(this.f3371l, m6218a(this.f3347D));
            for (Entry value : this.f3372m.entrySet()) {
                for (C1315h c1315h : (List) value.getValue()) {
                    if (c1315h.f3321b < min || (c1315h.f3321b > min && c1315h.f3321b != this.f3371l)) {
                        c1315h.f3324e = false;
                        if (c1315h.f3322c != null) {
                            c1315h.f3322c.recycle();
                            c1315h.f3322c = null;
                        }
                    }
                    if (c1315h.f3321b == min) {
                        if (m6252a(c1315h)) {
                            c1315h.f3324e = true;
                            if (!c1315h.f3323d && c1315h.f3322c == null && z) {
                                m6235a(new C1316i(this, this.f3365V, c1315h));
                            }
                        } else if (c1315h.f3321b != this.f3371l) {
                            c1315h.f3324e = false;
                            if (c1315h.f3322c != null) {
                                c1315h.f3322c.recycle();
                                c1315h.f3322c = null;
                            }
                        }
                    } else if (c1315h.f3321b == this.f3371l) {
                        c1315h.f3324e = true;
                    }
                }
            }
        }
    }

    private float m6270d(float f) {
        return this.f3349F == null ? Float.NaN : (this.f3347D * f) + this.f3349F.x;
    }

    private void m6274d(boolean z) {
        Object obj = null;
        if (this.f3349F == null) {
            obj = 1;
            this.f3349F = new PointF(0.0f, 0.0f);
        }
        if (this.au == null) {
            this.au = new C1314g(new PointF(0.0f, 0.0f), null);
        }
        this.au.f3318a = this.f3347D;
        this.au.f3319b.set(this.f3349F);
        m6249a(z, this.au);
        this.f3347D = this.au.f3318a;
        this.f3349F.set(this.au.f3319b);
        if (obj != null) {
            this.f3349F.set(m6223a((float) (m6292l() / 2), (float) (m6294m() / 2), this.f3347D));
        }
    }

    private float m6275e(float f) {
        return this.f3349F == null ? Float.NaN : (this.f3347D * f) + this.f3349F.y;
    }

    private float m6279f(float f) {
        return Math.min(this.f3375p, Math.max(m6296n(), f));
    }

    private boolean m6281f() {
        if (this.f3367h != null && !this.f3368i) {
            return true;
        }
        if (this.f3372m == null) {
            return false;
        }
        boolean z = true;
        for (Entry entry : this.f3372m.entrySet()) {
            if (((Integer) entry.getKey()).intValue() == this.f3371l) {
                for (C1315h c1315h : (List) entry.getValue()) {
                    if (c1315h.f3323d || c1315h.f3322c == null) {
                        z = false;
                    }
                }
            }
            z = z;
        }
        return z;
    }

    private boolean m6282g() {
        boolean z = getWidth() > 0 && getHeight() > 0 && this.f3355L > 0 && this.f3356M > 0 && (this.f3367h != null || m6281f());
        if (!this.al && z) {
            m6289j();
            this.al = true;
            m6307b();
            if (this.an != null) {
                this.an.m6185a();
            }
        }
        return z;
    }

    private int getRequiredRotation() {
        return this.f3374o == -1 ? this.f3357N : this.f3374o;
    }

    private boolean m6284h() {
        boolean f = m6281f();
        if (!this.am && f) {
            m6289j();
            this.am = true;
            m6308c();
            if (this.an != null) {
                this.an.m6187b();
            }
        }
        return f;
    }

    private void m6287i() {
        if (this.ar == null) {
            this.ar = new Paint();
            this.ar.setAntiAlias(true);
            this.ar.setFilterBitmap(true);
            this.ar.setDither(true);
        }
        if (this.as == null && this.f3373n) {
            this.as = new Paint();
            this.as.setTextSize(18.0f);
            this.as.setColor(-65281);
            this.as.setStyle(Style.STROKE);
        }
    }

    private void m6289j() {
        if (getWidth() != 0 && getHeight() != 0 && this.f3355L > 0 && this.f3356M > 0) {
            if (!(this.f3353J == null || this.f3352I == null)) {
                this.f3347D = this.f3352I.floatValue();
                if (this.f3349F == null) {
                    this.f3349F = new PointF();
                }
                this.f3349F.x = ((float) (getWidth() / 2)) - (this.f3347D * this.f3353J.x);
                this.f3349F.y = ((float) (getHeight() / 2)) - (this.f3347D * this.f3353J.y);
                this.f3353J = null;
                this.f3352I = null;
                m6274d(true);
                m6267c(true);
            }
            m6274d(false);
        }
    }

    private synchronized void m6291k() {
        m6247a("onTileLoaded", new Object[0]);
        m6282g();
        m6284h();
        if (m6281f() && this.f3367h != null) {
            if (!this.f3369j) {
                this.f3367h.recycle();
            }
            this.f3367h = null;
            if (this.an != null && this.f3369j) {
                this.an.m6189c();
            }
            this.f3368i = false;
            this.f3369j = false;
        }
        invalidate();
    }

    private int m6292l() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.f3356M : this.f3355L;
    }

    private int m6294m() {
        int requiredRotation = getRequiredRotation();
        return (requiredRotation == 90 || requiredRotation == 270) ? this.f3355L : this.f3356M;
    }

    private float m6296n() {
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        return this.f3379t == 2 ? Math.max(((float) (getWidth() - paddingLeft)) / ((float) m6292l()), ((float) (getHeight() - paddingBottom)) / ((float) m6294m())) : (this.f3379t != 3 || this.f3376q <= 0.0f) ? Math.min(((float) (getWidth() - paddingLeft)) / ((float) m6292l()), ((float) (getHeight() - paddingBottom)) / ((float) m6294m())) : this.f3376q;
    }

    private void setGestureDetector(Context context) {
        this.f3364U = new GestureDetector(context, new C13072(this, context));
    }

    public final PointF m6299a(float f, float f2) {
        return m6300a(f, f2, new PointF());
    }

    public final PointF m6300a(float f, float f2, PointF pointF) {
        if (this.f3349F == null) {
            return null;
        }
        pointF.set(m6254b(f), m6264c(f2));
        return pointF;
    }

    public final PointF m6301a(PointF pointF) {
        return m6300a(pointF.x, pointF.y, new PointF());
    }

    public final void m6302a(float f, PointF pointF) {
        this.ak = null;
        this.f3352I = Float.valueOf(f);
        this.f3353J = pointF;
        this.f3354K = pointF;
        invalidate();
    }

    public final void m6303a(C1324a c1324a, C1324a c1324a2, C1325b c1325b) {
        if (c1324a == null) {
            throw new NullPointerException("imageSource must not be null");
        }
        m6248a(true);
        if (c1325b != null) {
            m6246a(c1325b);
        }
        if (c1324a2 != null) {
            if (c1324a.m6327c() != null) {
                throw new IllegalArgumentException("Preview image cannot be used when a bitmap is provided for the main image");
            } else if (c1324a.m6330f() <= 0 || c1324a.m6331g() <= 0) {
                throw new IllegalArgumentException("Preview image cannot be used unless dimensions are provided for the main image");
            } else {
                this.f3355L = c1324a.m6330f();
                this.f3356M = c1324a.m6331g();
                this.f3359P = c1324a2.m6332h();
                if (c1324a2.m6327c() != null) {
                    this.f3369j = c1324a2.m6333i();
                    m6230a(c1324a2.m6327c());
                } else {
                    Uri b = c1324a2.m6326b();
                    if (b == null && c1324a2.m6328d() != null) {
                        b = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + c1324a2.m6328d());
                    }
                    m6235a(new C1310c(this, getContext(), this.aa, b, true));
                }
            }
        }
        if (c1324a.m6327c() != null && c1324a.m6332h() != null) {
            m6231a(Bitmap.createBitmap(c1324a.m6327c(), c1324a.m6332h().left, c1324a.m6332h().top, c1324a.m6332h().width(), c1324a.m6332h().height()), 0, false);
        } else if (c1324a.m6327c() != null) {
            m6231a(c1324a.m6327c(), 0, c1324a.m6333i());
        } else {
            this.f3358O = c1324a.m6332h();
            this.f3370k = c1324a.m6326b();
            if (this.f3370k == null && c1324a.m6328d() != null) {
                this.f3370k = Uri.parse("android.resource://" + getContext().getPackageName() + "/" + c1324a.m6328d());
            }
            if (c1324a.m6329e() || this.f3358O != null) {
                m6235a(new C1317j(this, getContext(), this.ab, this.f3370k));
            } else {
                m6235a(new C1310c(this, getContext(), this.aa, this.f3370k, false));
            }
        }
    }

    public final boolean m6304a() {
        return this.al;
    }

    public final PointF m6305b(float f, float f2, PointF pointF) {
        if (this.f3349F == null) {
            return null;
        }
        pointF.set(m6270d(f), m6275e(f2));
        return pointF;
    }

    public final PointF m6306b(PointF pointF) {
        return m6305b(pointF.x, pointF.y, new PointF());
    }

    protected void m6307b() {
    }

    protected void m6308c() {
    }

    public final int getAppliedOrientation() {
        return getRequiredRotation();
    }

    public final PointF getCenter() {
        return m6299a((float) (getWidth() / 2), (float) (getHeight() / 2));
    }

    public float getMaxScale() {
        return this.f3375p;
    }

    public final float getMinScale() {
        return m6296n();
    }

    public final int getOrientation() {
        return this.f3374o;
    }

    public final int getSHeight() {
        return this.f3356M;
    }

    public final int getSWidth() {
        return this.f3355L;
    }

    public final float getScale() {
        return this.f3347D;
    }

    public final C1325b getState() {
        return (this.f3349F == null || this.f3355L <= 0 || this.f3356M <= 0) ? null : new C1325b(getScale(), getCenter(), getOrientation());
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m6287i();
        if (this.f3355L != 0 && this.f3356M != 0 && getWidth() != 0 && getHeight() != 0) {
            if (this.f3372m == null && this.f3365V != null) {
                m6232a(m6222a(canvas));
            }
            if (m6282g()) {
                float a;
                PointF pointF;
                m6289j();
                if (this.ak != null) {
                    float f = this.f3347D;
                    if (this.f3351H == null) {
                        this.f3351H = new PointF(0.0f, 0.0f);
                    }
                    this.f3351H.set(this.f3349F);
                    long currentTimeMillis = System.currentTimeMillis() - this.ak.f3299l;
                    boolean z = currentTimeMillis > this.ak.f3295h;
                    currentTimeMillis = Math.min(currentTimeMillis, this.ak.f3295h);
                    this.f3347D = m6215a(this.ak.f3297j, currentTimeMillis, this.ak.f3288a, this.ak.f3289b - this.ak.f3288a, this.ak.f3295h);
                    float a2 = m6215a(this.ak.f3297j, currentTimeMillis, this.ak.f3293f.x, this.ak.f3294g.x - this.ak.f3293f.x, this.ak.f3295h);
                    a = m6215a(this.ak.f3297j, currentTimeMillis, this.ak.f3293f.y, this.ak.f3294g.y - this.ak.f3293f.y, this.ak.f3295h);
                    pointF = this.f3349F;
                    pointF.x -= m6270d(this.ak.f3291d.x) - a2;
                    pointF = this.f3349F;
                    pointF.y -= m6275e(this.ak.f3291d.y) - a;
                    boolean z2 = z || this.ak.f3288a == this.ak.f3289b;
                    m6274d(z2);
                    m6229a(f, this.f3351H, this.ak.f3298k);
                    m6267c(z);
                    if (z) {
                        if (this.ak.f3300m != null) {
                            try {
                                this.ak.f3300m.m6182a();
                            } catch (Throwable e) {
                                Log.w(f3338b, "Error thrown by animation listener", e);
                            }
                        }
                        this.ak = null;
                    }
                    invalidate();
                }
                if (this.f3372m != null && m6281f()) {
                    int min = Math.min(this.f3371l, m6218a(this.f3347D));
                    Object obj = null;
                    for (Entry entry : this.f3372m.entrySet()) {
                        if (((Integer) entry.getKey()).intValue() == min) {
                            for (C1315h c1315h : (List) entry.getValue()) {
                                if (c1315h.f3324e && (c1315h.f3323d || c1315h.f3322c == null)) {
                                    obj = 1;
                                }
                            }
                        }
                        obj = obj;
                    }
                    for (Entry entry2 : this.f3372m.entrySet()) {
                        if (((Integer) entry2.getKey()).intValue() == min || r13 != null) {
                            for (C1315h c1315h2 : (List) entry2.getValue()) {
                                m6258b(c1315h2.f3320a, c1315h2.f3325f);
                                if (!c1315h2.f3323d && c1315h2.f3322c != null) {
                                    if (this.at != null) {
                                        canvas.drawRect(c1315h2.f3325f, this.at);
                                    }
                                    if (this.av == null) {
                                        this.av = new Matrix();
                                    }
                                    this.av.reset();
                                    m6250a(this.ax, 0.0f, 0.0f, (float) c1315h2.f3322c.getWidth(), 0.0f, (float) c1315h2.f3322c.getWidth(), (float) c1315h2.f3322c.getHeight(), 0.0f, (float) c1315h2.f3322c.getHeight());
                                    if (getRequiredRotation() == 0) {
                                        m6250a(this.ay, (float) c1315h2.f3325f.left, (float) c1315h2.f3325f.top, (float) c1315h2.f3325f.right, (float) c1315h2.f3325f.top, (float) c1315h2.f3325f.right, (float) c1315h2.f3325f.bottom, (float) c1315h2.f3325f.left, (float) c1315h2.f3325f.bottom);
                                    } else if (getRequiredRotation() == 90) {
                                        m6250a(this.ay, (float) c1315h2.f3325f.right, (float) c1315h2.f3325f.top, (float) c1315h2.f3325f.right, (float) c1315h2.f3325f.bottom, (float) c1315h2.f3325f.left, (float) c1315h2.f3325f.bottom, (float) c1315h2.f3325f.left, (float) c1315h2.f3325f.top);
                                    } else if (getRequiredRotation() == 180) {
                                        m6250a(this.ay, (float) c1315h2.f3325f.right, (float) c1315h2.f3325f.bottom, (float) c1315h2.f3325f.left, (float) c1315h2.f3325f.bottom, (float) c1315h2.f3325f.left, (float) c1315h2.f3325f.top, (float) c1315h2.f3325f.right, (float) c1315h2.f3325f.top);
                                    } else if (getRequiredRotation() == 270) {
                                        m6250a(this.ay, (float) c1315h2.f3325f.left, (float) c1315h2.f3325f.bottom, (float) c1315h2.f3325f.left, (float) c1315h2.f3325f.top, (float) c1315h2.f3325f.right, (float) c1315h2.f3325f.top, (float) c1315h2.f3325f.right, (float) c1315h2.f3325f.bottom);
                                    }
                                    this.av.setPolyToPoly(this.ax, 0, this.ay, 0, 4);
                                    canvas.drawBitmap(c1315h2.f3322c, this.av, this.ar);
                                    if (this.f3373n) {
                                        canvas.drawRect(c1315h2.f3325f, this.as);
                                    }
                                } else if (c1315h2.f3323d && this.f3373n) {
                                    canvas.drawText("LOADING", (float) (c1315h2.f3325f.left + 5), (float) (c1315h2.f3325f.top + 35), this.as);
                                }
                                if (c1315h2.f3324e && this.f3373n) {
                                    canvas.drawText("ISS " + c1315h2.f3321b + " RECT " + c1315h2.f3320a.top + "," + c1315h2.f3320a.left + "," + c1315h2.f3320a.bottom + "," + c1315h2.f3320a.right, (float) (c1315h2.f3325f.left + 5), (float) (c1315h2.f3325f.top + 15), this.as);
                                }
                            }
                        }
                    }
                } else if (this.f3367h != null) {
                    float f2 = this.f3347D;
                    a = this.f3347D;
                    if (this.f3368i) {
                        f2 = (((float) this.f3355L) / ((float) this.f3367h.getWidth())) * this.f3347D;
                        a = this.f3347D * (((float) this.f3356M) / ((float) this.f3367h.getHeight()));
                    }
                    if (this.av == null) {
                        this.av = new Matrix();
                    }
                    this.av.reset();
                    this.av.postScale(f2, a);
                    this.av.postRotate((float) getRequiredRotation());
                    this.av.postTranslate(this.f3349F.x, this.f3349F.y);
                    if (getRequiredRotation() == 180) {
                        this.av.postTranslate(this.f3347D * ((float) this.f3355L), this.f3347D * ((float) this.f3356M));
                    } else if (getRequiredRotation() == 90) {
                        this.av.postTranslate(this.f3347D * ((float) this.f3356M), 0.0f);
                    } else if (getRequiredRotation() == 270) {
                        this.av.postTranslate(0.0f, this.f3347D * ((float) this.f3355L));
                    }
                    if (this.at != null) {
                        if (this.aw == null) {
                            this.aw = new RectF();
                        }
                        this.aw.set(0.0f, 0.0f, this.f3368i ? (float) this.f3367h.getWidth() : (float) this.f3355L, this.f3368i ? (float) this.f3367h.getHeight() : (float) this.f3356M);
                        this.av.mapRect(this.aw);
                        canvas.drawRect(this.aw, this.at);
                    }
                    canvas.drawBitmap(this.f3367h, this.av, this.ar);
                }
                if (this.f3373n) {
                    canvas.drawText("Scale: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.f3347D)}), 5.0f, 15.0f, this.as);
                    canvas.drawText("Translate: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.f3349F.x)}) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(this.f3349F.y)}), 5.0f, 35.0f, this.as);
                    PointF center = getCenter();
                    canvas.drawText("Source center: " + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.x)}) + ":" + String.format(Locale.ENGLISH, "%.2f", new Object[]{Float.valueOf(center.y)}), 5.0f, 55.0f, this.as);
                    this.as.setStrokeWidth(2.0f);
                    if (this.ak != null) {
                        center = m6306b(this.ak.f3290c);
                        pointF = m6306b(this.ak.f3292e);
                        PointF b = m6306b(this.ak.f3291d);
                        canvas.drawCircle(center.x, center.y, 10.0f, this.as);
                        this.as.setColor(-65536);
                        canvas.drawCircle(pointF.x, pointF.y, 20.0f, this.as);
                        this.as.setColor(-16776961);
                        canvas.drawCircle(b.x, b.y, 25.0f, this.as);
                        this.as.setColor(-16711681);
                        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), 30.0f, this.as);
                    }
                    if (this.ac != null) {
                        this.as.setColor(-65536);
                        canvas.drawCircle(this.ac.x, this.ac.y, 20.0f, this.as);
                    }
                    if (this.ai != null) {
                        this.as.setColor(-16776961);
                        canvas.drawCircle(m6270d(this.ai.x), m6275e(this.ai.y), 35.0f, this.as);
                    }
                    if (this.aj != null) {
                        this.as.setColor(-16711681);
                        canvas.drawCircle(this.aj.x, this.aj.y, 30.0f, this.as);
                    }
                    this.as.setColor(-65281);
                    this.as.setStrokeWidth(1.0f);
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int m;
        int i3;
        Object obj = 1;
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        Object obj2 = mode != 1073741824 ? 1 : null;
        if (mode2 == 1073741824) {
            obj = null;
        }
        if (this.f3355L > 0 && this.f3356M > 0) {
            if (obj2 == null || obj == null) {
                if (obj != null) {
                    m = (int) ((((double) m6294m()) / ((double) m6292l())) * ((double) size));
                    i3 = size;
                } else if (obj2 != null) {
                    i3 = (int) ((((double) m6292l()) / ((double) m6294m())) * ((double) size2));
                    m = size2;
                }
                setMeasuredDimension(Math.max(i3, getSuggestedMinimumWidth()), Math.max(m, getSuggestedMinimumHeight()));
            }
            i3 = m6292l();
            m = m6294m();
            setMeasuredDimension(Math.max(i3, getSuggestedMinimumWidth()), Math.max(m, getSuggestedMinimumHeight()));
        }
        m = size2;
        i3 = size;
        setMeasuredDimension(Math.max(i3, getSuggestedMinimumWidth()), Math.max(m, getSuggestedMinimumHeight()));
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        m6247a("onSizeChanged %dx%d -> %dx%d", Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2));
        PointF center = getCenter();
        if (this.al && center != null) {
            this.ak = null;
            this.f3352I = Float.valueOf(this.f3347D);
            this.f3353J = center;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.ak == null || this.ak.f3296i) {
            if (!(this.ak == null || this.ak.f3300m == null)) {
                try {
                    this.ak.f3300m.m6183b();
                } catch (Throwable e) {
                    Log.w(f3338b, "Error thrown by animation listener", e);
                }
            }
            this.ak = null;
            if (this.f3349F == null) {
                return true;
            }
            if (this.f3362S || !(this.f3364U == null || this.f3364U.onTouchEvent(motionEvent))) {
                if (this.f3350G == null) {
                    this.f3350G = new PointF(0.0f, 0.0f);
                }
                if (this.f3351H == null) {
                    this.f3351H = new PointF(0.0f, 0.0f);
                }
                if (this.ac == null) {
                    this.ac = new PointF(0.0f, 0.0f);
                }
                float f = this.f3347D;
                this.f3351H.set(this.f3349F);
                boolean a = m6251a(motionEvent);
                m6229a(f, this.f3351H, 2);
                if (a || super.onTouchEvent(motionEvent)) {
                    z = true;
                }
                return z;
            }
            this.f3360Q = false;
            this.f3361R = false;
            this.f3363T = 0;
            return true;
        }
        m6261b(true);
        return true;
    }

    public final void setBitmapDecoderClass(Class<? extends C1320c> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.aa = new C1319a(cls);
    }

    public final void setBitmapDecoderFactory(C1318b<? extends C1320c> c1318b) {
        if (c1318b == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.aa = c1318b;
    }

    public final void setDebug(boolean z) {
        this.f3373n = z;
    }

    public final void setDoubleTapZoomDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setDoubleTapZoomScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
    }

    public final void setDoubleTapZoomDuration(int i) {
        this.f3346C = Math.max(0, i);
    }

    public final void setDoubleTapZoomScale(float f) {
        this.f3344A = f;
    }

    public final void setDoubleTapZoomStyle(int i) {
        if (f3340d.contains(Integer.valueOf(i))) {
            this.f3345B = i;
            return;
        }
        throw new IllegalArgumentException("Invalid zoom style: " + i);
    }

    public final void setImage(C1324a c1324a) {
        m6303a(c1324a, null, null);
    }

    public final void setMaxScale(float f) {
        this.f3375p = f;
    }

    public void setMaxTileSize(int i) {
        this.f3380u = i;
        this.f3381v = i;
    }

    public final void setMaximumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMinScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
    }

    public final void setMinScale(float f) {
        this.f3376q = f;
    }

    public final void setMinimumDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        setMaxScale(((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f) / ((float) i));
    }

    public final void setMinimumScaleType(int i) {
        if (f3343g.contains(Integer.valueOf(i))) {
            this.f3379t = i;
            if (m6304a()) {
                m6274d(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid scale type: " + i);
    }

    public void setMinimumTileDpi(int i) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f3377r = (int) Math.min((displayMetrics.ydpi + displayMetrics.xdpi) / 2.0f, (float) i);
        if (m6304a()) {
            m6248a(false);
            invalidate();
        }
    }

    public void setOnImageEventListener(C1312e c1312e) {
        this.an = c1312e;
    }

    public void setOnLongClickListener(OnLongClickListener onLongClickListener) {
        this.ap = onLongClickListener;
    }

    public void setOnStateChangedListener(C1313f c1313f) {
        this.ao = c1313f;
    }

    public final void setOrientation(int i) {
        if (f3339c.contains(Integer.valueOf(i))) {
            this.f3374o = i;
            m6248a(false);
            invalidate();
            requestLayout();
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i);
    }

    public final void setPanEnabled(boolean z) {
        this.f3383x = z;
        if (!z && this.f3349F != null) {
            this.f3349F.x = ((float) (getWidth() / 2)) - (this.f3347D * ((float) (m6292l() / 2)));
            this.f3349F.y = ((float) (getHeight() / 2)) - (this.f3347D * ((float) (m6294m() / 2)));
            if (m6304a()) {
                m6267c(true);
                invalidate();
            }
        }
    }

    public final void setPanLimit(int i) {
        if (f3342f.contains(Integer.valueOf(i))) {
            this.f3378s = i;
            if (m6304a()) {
                m6274d(true);
                invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Invalid pan limit: " + i);
    }

    public void setParallelLoadingEnabled(boolean z) {
        this.f3382w = z;
    }

    public final void setQuickScaleEnabled(boolean z) {
        this.f3385z = z;
    }

    public final void setRegionDecoderClass(Class<? extends C1321d> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("Decoder class cannot be set to null");
        }
        this.ab = new C1319a(cls);
    }

    public final void setRegionDecoderFactory(C1318b<? extends C1321d> c1318b) {
        if (c1318b == null) {
            throw new IllegalArgumentException("Decoder factory cannot be set to null");
        }
        this.ab = c1318b;
    }

    public final void setTileBackgroundColor(int i) {
        if (Color.alpha(i) == 0) {
            this.at = null;
        } else {
            this.at = new Paint();
            this.at.setStyle(Style.FILL);
            this.at.setColor(i);
        }
        invalidate();
    }

    public final void setZoomEnabled(boolean z) {
        this.f3384y = z;
    }
}
