package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.support.v4.p017g.C0352a;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlSerializer;

/* renamed from: android.support.v7.widget.e */
class C0938e extends DataSetObservable {
    private static final String f2420a;
    private static final Object f2421b;
    private static final Map<String, C0938e> f2422c;
    private final Object f2423d;
    private final List<C0933a> f2424e;
    private final List<C0935c> f2425f;
    private final Context f2426g;
    private final String f2427h;
    private Intent f2428i;
    private C0934b f2429j;
    private int f2430k;
    private boolean f2431l;
    private boolean f2432m;
    private boolean f2433n;
    private boolean f2434o;
    private C0936d f2435p;

    /* renamed from: android.support.v7.widget.e.a */
    public final class C0933a implements Comparable<C0933a> {
        public final ResolveInfo f2413a;
        public float f2414b;
        final /* synthetic */ C0938e f2415c;

        public C0933a(C0938e c0938e, ResolveInfo resolveInfo) {
            this.f2415c = c0938e;
            this.f2413a = resolveInfo;
        }

        public int m4916a(C0933a c0933a) {
            return Float.floatToIntBits(c0933a.f2414b) - Float.floatToIntBits(this.f2414b);
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m4916a((C0933a) obj);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            return Float.floatToIntBits(this.f2414b) == Float.floatToIntBits(((C0933a) obj).f2414b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f2414b) + 31;
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("resolveInfo:").append(this.f2413a.toString());
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2414b));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v7.widget.e.b */
    public interface C0934b {
        void m4917a(Intent intent, List<C0933a> list, List<C0935c> list2);
    }

    /* renamed from: android.support.v7.widget.e.c */
    public static final class C0935c {
        public final ComponentName f2416a;
        public final long f2417b;
        public final float f2418c;

        public C0935c(ComponentName componentName, long j, float f) {
            this.f2416a = componentName;
            this.f2417b = j;
            this.f2418c = f;
        }

        public C0935c(String str, long j, float f) {
            this(ComponentName.unflattenFromString(str), j, f);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            C0935c c0935c = (C0935c) obj;
            if (this.f2416a == null) {
                if (c0935c.f2416a != null) {
                    return false;
                }
            } else if (!this.f2416a.equals(c0935c.f2416a)) {
                return false;
            }
            return this.f2417b != c0935c.f2417b ? false : Float.floatToIntBits(this.f2418c) == Float.floatToIntBits(c0935c.f2418c);
        }

        public int hashCode() {
            return (((((this.f2416a == null ? 0 : this.f2416a.hashCode()) + 31) * 31) + ((int) (this.f2417b ^ (this.f2417b >>> 32)))) * 31) + Float.floatToIntBits(this.f2418c);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            stringBuilder.append("; activity:").append(this.f2416a);
            stringBuilder.append("; time:").append(this.f2417b);
            stringBuilder.append("; weight:").append(new BigDecimal((double) this.f2418c));
            stringBuilder.append("]");
            return stringBuilder.toString();
        }
    }

    /* renamed from: android.support.v7.widget.e.d */
    public interface C0936d {
        boolean m4918a(C0938e c0938e, Intent intent);
    }

    /* renamed from: android.support.v7.widget.e.e */
    private final class C0937e extends AsyncTask<Object, Void, Void> {
        final /* synthetic */ C0938e f2419a;

        private C0937e(C0938e c0938e) {
            this.f2419a = c0938e;
        }

        public Void m4919a(Object... objArr) {
            int i = 0;
            List list = (List) objArr[0];
            String str = (String) objArr[1];
            try {
                OutputStream openFileOutput = this.f2419a.f2426g.openFileOutput(str, 0);
                XmlSerializer newSerializer = Xml.newSerializer();
                try {
                    newSerializer.setOutput(openFileOutput, null);
                    newSerializer.startDocument("UTF-8", Boolean.valueOf(true));
                    newSerializer.startTag(null, "historical-records");
                    int size = list.size();
                    while (i < size) {
                        C0935c c0935c = (C0935c) list.remove(0);
                        newSerializer.startTag(null, "historical-record");
                        newSerializer.attribute(null, "activity", c0935c.f2416a.flattenToString());
                        newSerializer.attribute(null, "time", String.valueOf(c0935c.f2417b));
                        newSerializer.attribute(null, "weight", String.valueOf(c0935c.f2418c));
                        newSerializer.endTag(null, "historical-record");
                        i++;
                    }
                    newSerializer.endTag(null, "historical-records");
                    newSerializer.endDocument();
                    this.f2419a.f2431l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (Throwable e2) {
                    Log.e(C0938e.f2420a, "Error writing historical recrod file: " + this.f2419a.f2427h, e2);
                    this.f2419a.f2431l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e3) {
                        }
                    }
                } catch (Throwable e22) {
                    Log.e(C0938e.f2420a, "Error writing historical recrod file: " + this.f2419a.f2427h, e22);
                    this.f2419a.f2431l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e4) {
                        }
                    }
                } catch (Throwable e222) {
                    Log.e(C0938e.f2420a, "Error writing historical recrod file: " + this.f2419a.f2427h, e222);
                    this.f2419a.f2431l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e5) {
                        }
                    }
                } catch (Throwable th) {
                    this.f2419a.f2431l = true;
                    if (openFileOutput != null) {
                        try {
                            openFileOutput.close();
                        } catch (IOException e6) {
                        }
                    }
                }
            } catch (Throwable e2222) {
                Log.e(C0938e.f2420a, "Error writing historical recrod file: " + str, e2222);
            }
            return null;
        }

        public /* synthetic */ Object doInBackground(Object[] objArr) {
            return m4919a(objArr);
        }
    }

    static {
        f2420a = C0938e.class.getSimpleName();
        f2421b = new Object();
        f2422c = new HashMap();
    }

    private boolean m4921a(C0935c c0935c) {
        boolean add = this.f2425f.add(c0935c);
        if (add) {
            this.f2433n = true;
            m4930i();
            m4925d();
            m4927f();
            notifyChanged();
        }
        return add;
    }

    private void m4925d() {
        if (!this.f2432m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f2433n) {
            this.f2433n = false;
            if (!TextUtils.isEmpty(this.f2427h)) {
                C0352a.m1326a(new C0937e(), new ArrayList(this.f2425f), this.f2427h);
            }
        }
    }

    private void m4926e() {
        int g = m4928g() | m4929h();
        m4930i();
        if (g != 0) {
            m4927f();
            notifyChanged();
        }
    }

    private boolean m4927f() {
        if (this.f2429j == null || this.f2428i == null || this.f2424e.isEmpty() || this.f2425f.isEmpty()) {
            return false;
        }
        this.f2429j.m4917a(this.f2428i, this.f2424e, Collections.unmodifiableList(this.f2425f));
        return true;
    }

    private boolean m4928g() {
        if (!this.f2434o || this.f2428i == null) {
            return false;
        }
        this.f2434o = false;
        this.f2424e.clear();
        List queryIntentActivities = this.f2426g.getPackageManager().queryIntentActivities(this.f2428i, 0);
        int size = queryIntentActivities.size();
        for (int i = 0; i < size; i++) {
            this.f2424e.add(new C0933a(this, (ResolveInfo) queryIntentActivities.get(i)));
        }
        return true;
    }

    private boolean m4929h() {
        if (!this.f2431l || !this.f2433n || TextUtils.isEmpty(this.f2427h)) {
            return false;
        }
        this.f2431l = false;
        this.f2432m = true;
        m4931j();
        return true;
    }

    private void m4930i() {
        int size = this.f2425f.size() - this.f2430k;
        if (size > 0) {
            this.f2433n = true;
            for (int i = 0; i < size; i++) {
                C0935c c0935c = (C0935c) this.f2425f.remove(0);
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m4931j() {
        /*
        r9 = this;
        r8 = 1;
        r0 = r9.f2426g;	 Catch:{ FileNotFoundException -> 0x00d3 }
        r1 = r9.f2427h;	 Catch:{ FileNotFoundException -> 0x00d3 }
        r1 = r0.openFileInput(r1);	 Catch:{ FileNotFoundException -> 0x00d3 }
        r2 = android.util.Xml.newPullParser();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0 = "UTF-8";
        r2.setInput(r1, r0);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0 = 0;
    L_0x0013:
        if (r0 == r8) goto L_0x001d;
    L_0x0015:
        r3 = 2;
        if (r0 == r3) goto L_0x001d;
    L_0x0018:
        r0 = r2.next();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        goto L_0x0013;
    L_0x001d:
        r0 = "historical-records";
        r3 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0 = r0.equals(r3);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        if (r0 != 0) goto L_0x0052;
    L_0x0029:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r2 = "Share records file does not start with historical-records tag.";
        r0.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        throw r0;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
    L_0x0031:
        r0 = move-exception;
        r2 = f2420a;	 Catch:{ all -> 0x00c8 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r3.<init>();	 Catch:{ all -> 0x00c8 }
        r4 = "Error reading historical recrod file: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r9.f2427h;	 Catch:{ all -> 0x00c8 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c8 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x0051;
    L_0x004e:
        r1.close();	 Catch:{ IOException -> 0x00cf }
    L_0x0051:
        return;
    L_0x0052:
        r0 = r9.f2425f;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0.clear();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
    L_0x0057:
        r3 = r2.next();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        if (r3 != r8) goto L_0x0065;
    L_0x005d:
        if (r1 == 0) goto L_0x0051;
    L_0x005f:
        r1.close();	 Catch:{ IOException -> 0x0063 }
        goto L_0x0051;
    L_0x0063:
        r0 = move-exception;
        goto L_0x0051;
    L_0x0065:
        r4 = 3;
        if (r3 == r4) goto L_0x0057;
    L_0x0068:
        r4 = 4;
        if (r3 == r4) goto L_0x0057;
    L_0x006b:
        r3 = r2.getName();	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r4 = "historical-record";
        r3 = r4.equals(r3);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        if (r3 != 0) goto L_0x00a2;
    L_0x0077:
        r0 = new org.xmlpull.v1.XmlPullParserException;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r2 = "Share records file not well-formed.";
        r0.<init>(r2);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        throw r0;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
    L_0x007f:
        r0 = move-exception;
        r2 = f2420a;	 Catch:{ all -> 0x00c8 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c8 }
        r3.<init>();	 Catch:{ all -> 0x00c8 }
        r4 = "Error reading historical recrod file: ";
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r4 = r9.f2427h;	 Catch:{ all -> 0x00c8 }
        r3 = r3.append(r4);	 Catch:{ all -> 0x00c8 }
        r3 = r3.toString();	 Catch:{ all -> 0x00c8 }
        android.util.Log.e(r2, r3, r0);	 Catch:{ all -> 0x00c8 }
        if (r1 == 0) goto L_0x0051;
    L_0x009c:
        r1.close();	 Catch:{ IOException -> 0x00a0 }
        goto L_0x0051;
    L_0x00a0:
        r0 = move-exception;
        goto L_0x0051;
    L_0x00a2:
        r3 = 0;
        r4 = "activity";
        r3 = r2.getAttributeValue(r3, r4);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r4 = 0;
        r5 = "time";
        r4 = r2.getAttributeValue(r4, r5);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r4 = java.lang.Long.parseLong(r4);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r6 = 0;
        r7 = "weight";
        r6 = r2.getAttributeValue(r6, r7);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r6 = java.lang.Float.parseFloat(r6);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r7 = new android.support.v7.widget.e$c;	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r7.<init>(r3, r4, r6);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        r0.add(r7);	 Catch:{ XmlPullParserException -> 0x0031, IOException -> 0x007f }
        goto L_0x0057;
    L_0x00c8:
        r0 = move-exception;
        if (r1 == 0) goto L_0x00ce;
    L_0x00cb:
        r1.close();	 Catch:{ IOException -> 0x00d1 }
    L_0x00ce:
        throw r0;
    L_0x00cf:
        r0 = move-exception;
        goto L_0x0051;
    L_0x00d1:
        r1 = move-exception;
        goto L_0x00ce;
    L_0x00d3:
        r0 = move-exception;
        goto L_0x0051;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.e.j():void");
    }

    public int m4932a() {
        int size;
        synchronized (this.f2423d) {
            m4926e();
            size = this.f2424e.size();
        }
        return size;
    }

    public int m4933a(ResolveInfo resolveInfo) {
        synchronized (this.f2423d) {
            m4926e();
            List list = this.f2424e;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (((C0933a) list.get(i)).f2413a == resolveInfo) {
                    return i;
                }
            }
            return -1;
        }
    }

    public ResolveInfo m4934a(int i) {
        ResolveInfo resolveInfo;
        synchronized (this.f2423d) {
            m4926e();
            resolveInfo = ((C0933a) this.f2424e.get(i)).f2413a;
        }
        return resolveInfo;
    }

    public Intent m4935b(int i) {
        synchronized (this.f2423d) {
            if (this.f2428i == null) {
                return null;
            }
            m4926e();
            C0933a c0933a = (C0933a) this.f2424e.get(i);
            ComponentName componentName = new ComponentName(c0933a.f2413a.activityInfo.packageName, c0933a.f2413a.activityInfo.name);
            Intent intent = new Intent(this.f2428i);
            intent.setComponent(componentName);
            if (this.f2435p != null) {
                if (this.f2435p.m4918a(this, new Intent(intent))) {
                    return null;
                }
            }
            m4921a(new C0935c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo m4936b() {
        synchronized (this.f2423d) {
            m4926e();
            if (this.f2424e.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = ((C0933a) this.f2424e.get(0)).f2413a;
            return resolveInfo;
        }
    }

    public void m4937c(int i) {
        synchronized (this.f2423d) {
            m4926e();
            C0933a c0933a = (C0933a) this.f2424e.get(i);
            C0933a c0933a2 = (C0933a) this.f2424e.get(0);
            m4921a(new C0935c(new ComponentName(c0933a.f2413a.activityInfo.packageName, c0933a.f2413a.activityInfo.name), System.currentTimeMillis(), c0933a2 != null ? (c0933a2.f2414b - c0933a.f2414b) + 5.0f : 1.0f));
        }
    }
}
