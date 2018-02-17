package android.support.v4.p021b;

import android.os.Build.VERSION;
import android.support.v4.p021b.aa.C0231a;
import android.support.v4.p021b.aa.C0232b;
import android.support.v4.p030j.C0380a;
import android.support.v4.p030j.C0383d;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: android.support.v4.b.i */
final class C0262i extends C0261z implements Runnable {
    static final boolean f563a;
    final C0289u f564b;
    C0259a f565c;
    C0259a f566d;
    int f567e;
    int f568f;
    int f569g;
    int f570h;
    int f571i;
    int f572j;
    int f573k;
    boolean f574l;
    boolean f575m;
    String f576n;
    boolean f577o;
    int f578p;
    int f579q;
    CharSequence f580r;
    int f581s;
    CharSequence f582t;
    ArrayList<String> f583u;
    ArrayList<String> f584v;

    /* renamed from: android.support.v4.b.i.1 */
    class C02561 implements C0232b {
        final /* synthetic */ C0274o f532a;
        final /* synthetic */ C0262i f533b;

        C02561(C0262i c0262i, C0274o c0274o) {
            this.f533b = c0262i;
            this.f532a = c0274o;
        }

        public View m932a() {
            return this.f532a.getView();
        }
    }

    /* renamed from: android.support.v4.b.i.2 */
    class C02572 implements OnPreDrawListener {
        final /* synthetic */ View f534a;
        final /* synthetic */ Object f535b;
        final /* synthetic */ ArrayList f536c;
        final /* synthetic */ C0260b f537d;
        final /* synthetic */ Object f538e;
        final /* synthetic */ Object f539f;
        final /* synthetic */ boolean f540g;
        final /* synthetic */ C0274o f541h;
        final /* synthetic */ C0274o f542i;
        final /* synthetic */ C0262i f543j;

        C02572(C0262i c0262i, View view, Object obj, ArrayList arrayList, C0260b c0260b, Object obj2, Object obj3, boolean z, C0274o c0274o, C0274o c0274o2) {
            this.f543j = c0262i;
            this.f534a = view;
            this.f535b = obj;
            this.f536c = arrayList;
            this.f537d = c0260b;
            this.f538e = obj2;
            this.f539f = obj3;
            this.f540g = z;
            this.f541h = c0274o;
            this.f542i = c0274o2;
        }

        public boolean onPreDraw() {
            this.f534a.getViewTreeObserver().removeOnPreDrawListener(this);
            aa.m836a(this.f535b, this.f536c);
            this.f536c.remove(this.f537d.f561d);
            aa.m835a(this.f538e, this.f539f, this.f535b, this.f536c, false);
            this.f536c.clear();
            C0380a a = this.f543j.m942a(this.f537d, this.f540g, this.f541h);
            aa.m832a(this.f535b, this.f537d.f561d, (Map) a, this.f536c);
            this.f543j.m957a(a, this.f537d);
            this.f543j.m950a(this.f537d, this.f541h, this.f542i, this.f540g, a);
            aa.m835a(this.f538e, this.f539f, this.f535b, this.f536c, true);
            return true;
        }
    }

    /* renamed from: android.support.v4.b.i.3 */
    class C02583 implements OnPreDrawListener {
        final /* synthetic */ View f544a;
        final /* synthetic */ C0260b f545b;
        final /* synthetic */ int f546c;
        final /* synthetic */ Object f547d;
        final /* synthetic */ C0262i f548e;

        C02583(C0262i c0262i, View view, C0260b c0260b, int i, Object obj) {
            this.f548e = c0262i;
            this.f544a = view;
            this.f545b = c0260b;
            this.f546c = i;
            this.f547d = obj;
        }

        public boolean onPreDraw() {
            this.f544a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f548e.m949a(this.f545b, this.f546c, this.f547d);
            return true;
        }
    }

    /* renamed from: android.support.v4.b.i.a */
    static final class C0259a {
        C0259a f549a;
        C0259a f550b;
        int f551c;
        C0274o f552d;
        int f553e;
        int f554f;
        int f555g;
        int f556h;
        ArrayList<C0274o> f557i;

        C0259a() {
        }
    }

    /* renamed from: android.support.v4.b.i.b */
    public class C0260b {
        public C0380a<String, String> f558a;
        public ArrayList<View> f559b;
        public C0231a f560c;
        public View f561d;
        final /* synthetic */ C0262i f562e;

        public C0260b(C0262i c0262i) {
            this.f562e = c0262i;
            this.f558a = new C0380a();
            this.f559b = new ArrayList();
            this.f560c = new C0231a();
        }
    }

    static {
        f563a = VERSION.SDK_INT >= 21;
    }

    public C0262i(C0289u c0289u) {
        this.f575m = true;
        this.f578p = -1;
        this.f564b = c0289u;
    }

    private C0260b m940a(SparseArray<C0274o> sparseArray, SparseArray<C0274o> sparseArray2, boolean z) {
        int i = 0;
        C0260b c0260b = new C0260b(this);
        c0260b.f561d = new View(this.f564b.f641o.m1013i());
        int i2 = 0;
        int i3 = 0;
        while (i2 < sparseArray.size()) {
            int i4 = m961a(sparseArray.keyAt(i2), c0260b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2) ? 1 : i3;
            i2++;
            i3 = i4;
        }
        while (i < sparseArray2.size()) {
            i4 = sparseArray2.keyAt(i);
            if (sparseArray.get(i4) == null && m961a(i4, c0260b, z, (SparseArray) sparseArray, (SparseArray) sparseArray2)) {
                i3 = 1;
            }
            i++;
        }
        return i3 == 0 ? null : c0260b;
    }

    private C0380a<String, View> m941a(C0260b c0260b, C0274o c0274o, boolean z) {
        C0380a c0380a = new C0380a();
        if (this.f583u != null) {
            aa.m839a((Map) c0380a, c0274o.getView());
            if (z) {
                c0380a.m1425a(this.f584v);
            } else {
                c0380a = C0262i.m944a(this.f583u, this.f584v, c0380a);
            }
        }
        if (z) {
            if (c0274o.mEnterTransitionCallback != null) {
                c0274o.mEnterTransitionCallback.m901a(this.f584v, (Map) c0380a);
            }
            m951a(c0260b, c0380a, false);
        } else {
            if (c0274o.mExitTransitionCallback != null) {
                c0274o.mExitTransitionCallback.m901a(this.f584v, (Map) c0380a);
            }
            m964b(c0260b, c0380a, false);
        }
        return c0380a;
    }

    private C0380a<String, View> m942a(C0260b c0260b, boolean z, C0274o c0274o) {
        C0380a b = m962b(c0260b, c0274o, z);
        if (z) {
            if (c0274o.mExitTransitionCallback != null) {
                c0274o.mExitTransitionCallback.m901a(this.f584v, (Map) b);
            }
            m951a(c0260b, b, true);
        } else {
            if (c0274o.mEnterTransitionCallback != null) {
                c0274o.mEnterTransitionCallback.m901a(this.f584v, (Map) b);
            }
            m964b(c0260b, b, true);
        }
        return b;
    }

    private static C0380a<String, View> m944a(ArrayList<String> arrayList, ArrayList<String> arrayList2, C0380a<String, View> c0380a) {
        if (c0380a.isEmpty()) {
            return c0380a;
        }
        C0380a<String, View> c0380a2 = new C0380a();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) c0380a.get(arrayList.get(i));
            if (view != null) {
                c0380a2.put(arrayList2.get(i), view);
            }
        }
        return c0380a2;
    }

    private static Object m945a(C0274o c0274o, C0274o c0274o2, boolean z) {
        if (c0274o == null || c0274o2 == null) {
            return null;
        }
        return aa.m844b(z ? c0274o2.getSharedElementReturnTransition() : c0274o.getSharedElementEnterTransition());
    }

    private static Object m946a(C0274o c0274o, boolean z) {
        if (c0274o == null) {
            return null;
        }
        return aa.m823a(z ? c0274o.getReenterTransition() : c0274o.getEnterTransition());
    }

    private static Object m947a(Object obj, C0274o c0274o, ArrayList<View> arrayList, C0380a<String, View> c0380a, View view) {
        return obj != null ? aa.m824a(obj, c0274o.getView(), (ArrayList) arrayList, (Map) c0380a, view) : obj;
    }

    private void m948a(int i, C0274o c0274o, String str, int i2) {
        c0274o.mFragmentManager = this.f564b;
        if (str != null) {
            if (c0274o.mTag == null || str.equals(c0274o.mTag)) {
                c0274o.mTag = str;
            } else {
                throw new IllegalStateException("Can't change tag of fragment " + c0274o + ": was " + c0274o.mTag + " now " + str);
            }
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + c0274o + " with tag " + str + " to container view with no id");
            } else if (c0274o.mFragmentId == 0 || c0274o.mFragmentId == i) {
                c0274o.mFragmentId = i;
                c0274o.mContainerId = i;
            } else {
                throw new IllegalStateException("Can't change container ID of fragment " + c0274o + ": was " + c0274o.mFragmentId + " now " + i);
            }
        }
        C0259a c0259a = new C0259a();
        c0259a.f551c = i2;
        c0259a.f552d = c0274o;
        m975a(c0259a);
    }

    private void m949a(C0260b c0260b, int i, Object obj) {
        if (this.f564b.f633g != null) {
            for (int i2 = 0; i2 < this.f564b.f633g.size(); i2++) {
                C0274o c0274o = (C0274o) this.f564b.f633g.get(i2);
                if (!(c0274o.mView == null || c0274o.mContainer == null || c0274o.mContainerId != i)) {
                    if (!c0274o.mHidden) {
                        aa.m833a(obj, c0274o.mView, false);
                        c0260b.f559b.remove(c0274o.mView);
                    } else if (!c0260b.f559b.contains(c0274o.mView)) {
                        aa.m833a(obj, c0274o.mView, true);
                        c0260b.f559b.add(c0274o.mView);
                    }
                }
            }
        }
    }

    private void m950a(C0260b c0260b, C0274o c0274o, C0274o c0274o2, boolean z, C0380a<String, View> c0380a) {
        ag agVar = z ? c0274o2.mEnterTransitionCallback : c0274o.mEnterTransitionCallback;
        if (agVar != null) {
            agVar.m902b(new ArrayList(c0380a.keySet()), new ArrayList(c0380a.values()), null);
        }
    }

    private void m951a(C0260b c0260b, C0380a<String, View> c0380a, boolean z) {
        int size = this.f584v == null ? 0 : this.f584v.size();
        for (int i = 0; i < size; i++) {
            String str = (String) this.f583u.get(i);
            View view = (View) c0380a.get((String) this.f584v.get(i));
            if (view != null) {
                String a = aa.m826a(view);
                if (z) {
                    C0262i.m958a(c0260b.f558a, str, a);
                } else {
                    C0262i.m958a(c0260b.f558a, a, str);
                }
            }
        }
    }

    private void m952a(C0260b c0260b, View view, Object obj, C0274o c0274o, C0274o c0274o2, boolean z, ArrayList<View> arrayList, Object obj2, Object obj3) {
        if (obj != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new C02572(this, view, obj, arrayList, c0260b, obj2, obj3, z, c0274o, c0274o2));
        }
    }

    private static void m953a(C0260b c0260b, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        if (arrayList != null) {
            for (int i = 0; i < arrayList.size(); i++) {
                C0262i.m958a(c0260b.f558a, (String) arrayList.get(i), (String) arrayList2.get(i));
            }
        }
    }

    private void m957a(C0380a<String, View> c0380a, C0260b c0260b) {
        if (this.f584v != null && !c0380a.isEmpty()) {
            View view = (View) c0380a.get(this.f584v.get(0));
            if (view != null) {
                c0260b.f560c.f501a = view;
            }
        }
    }

    private static void m958a(C0380a<String, String> c0380a, String str, String str2) {
        if (str != null && str2 != null) {
            for (int i = 0; i < c0380a.size(); i++) {
                if (str.equals(c0380a.m1422c(i))) {
                    c0380a.m1418a(i, (Object) str2);
                    return;
                }
            }
            c0380a.put(str, str2);
        }
    }

    private static void m959a(SparseArray<C0274o> sparseArray, SparseArray<C0274o> sparseArray2, C0274o c0274o) {
        if (c0274o != null) {
            int i = c0274o.mContainerId;
            if (i != 0 && !c0274o.isHidden()) {
                if (c0274o.isAdded() && c0274o.getView() != null && sparseArray.get(i) == null) {
                    sparseArray.put(i, c0274o);
                }
                if (sparseArray2.get(i) == c0274o) {
                    sparseArray2.remove(i);
                }
            }
        }
    }

    private void m960a(View view, C0260b c0260b, int i, Object obj) {
        view.getViewTreeObserver().addOnPreDrawListener(new C02583(this, view, c0260b, i, obj));
    }

    private boolean m961a(int i, C0260b c0260b, boolean z, SparseArray<C0274o> sparseArray, SparseArray<C0274o> sparseArray2) {
        View view = (ViewGroup) this.f564b.f642p.m987a(i);
        if (view == null) {
            return false;
        }
        Object obj;
        ArrayList arrayList;
        Object a;
        View view2;
        C0232b c02561;
        ArrayList arrayList2;
        Map c0380a;
        boolean z2;
        Object a2;
        C0274o c0274o = (C0274o) sparseArray2.get(i);
        C0274o c0274o2 = (C0274o) sparseArray.get(i);
        Object a3 = C0262i.m946a(c0274o, z);
        Object a4 = C0262i.m945a(c0274o, c0274o2, z);
        Object b = C0262i.m963b(c0274o2, z);
        Map map = null;
        ArrayList arrayList3 = new ArrayList();
        if (a4 != null) {
            map = m941a(c0260b, c0274o2, z);
            if (map.isEmpty()) {
                map = null;
                obj = null;
                if (a3 != null && obj == null && b == null) {
                    return false;
                }
                arrayList = new ArrayList();
                a = C0262i.m947a(b, c0274o2, arrayList, (C0380a) map, c0260b.f561d);
                if (!(this.f584v == null || map == null)) {
                    view2 = (View) map.get(this.f584v.get(0));
                    if (view2 != null) {
                        if (a != null) {
                            aa.m831a(a, view2);
                        }
                        if (obj != null) {
                            aa.m831a(obj, view2);
                        }
                    }
                }
                c02561 = new C02561(this, c0274o);
                arrayList2 = new ArrayList();
                c0380a = new C0380a();
                z2 = true;
                if (c0274o != null) {
                    z2 = z ? c0274o.getAllowReturnTransitionOverlap() : c0274o.getAllowEnterTransitionOverlap();
                }
                a2 = aa.m825a(a3, a, obj, z2);
                if (a2 != null) {
                    aa.m834a(a3, obj, a, view, c02561, c0260b.f561d, c0260b.f560c, c0260b.f558a, arrayList2, arrayList, map, c0380a, arrayList3);
                    m960a(view, c0260b, i, a2);
                    aa.m833a(a2, c0260b.f561d, true);
                    m949a(c0260b, i, a2);
                    aa.m830a((ViewGroup) view, a2);
                    aa.m829a(view, c0260b.f561d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0260b.f559b, c0380a);
                }
                return a2 == null;
            } else {
                ag agVar = z ? c0274o2.mEnterTransitionCallback : c0274o.mEnterTransitionCallback;
                if (agVar != null) {
                    agVar.m900a(new ArrayList(map.keySet()), new ArrayList(map.values()), null);
                }
                m952a(c0260b, view, a4, c0274o, c0274o2, z, arrayList3, a3, b);
            }
        }
        obj = a4;
        if (a3 != null) {
        }
        arrayList = new ArrayList();
        a = C0262i.m947a(b, c0274o2, arrayList, (C0380a) map, c0260b.f561d);
        view2 = (View) map.get(this.f584v.get(0));
        if (view2 != null) {
            if (a != null) {
                aa.m831a(a, view2);
            }
            if (obj != null) {
                aa.m831a(obj, view2);
            }
        }
        c02561 = new C02561(this, c0274o);
        arrayList2 = new ArrayList();
        c0380a = new C0380a();
        z2 = true;
        if (c0274o != null) {
            if (z) {
            }
        }
        a2 = aa.m825a(a3, a, obj, z2);
        if (a2 != null) {
            aa.m834a(a3, obj, a, view, c02561, c0260b.f561d, c0260b.f560c, c0260b.f558a, arrayList2, arrayList, map, c0380a, arrayList3);
            m960a(view, c0260b, i, a2);
            aa.m833a(a2, c0260b.f561d, true);
            m949a(c0260b, i, a2);
            aa.m830a((ViewGroup) view, a2);
            aa.m829a(view, c0260b.f561d, a3, arrayList2, a, arrayList, obj, arrayList3, a2, c0260b.f559b, c0380a);
        }
        if (a2 == null) {
        }
    }

    private C0380a<String, View> m962b(C0260b c0260b, C0274o c0274o, boolean z) {
        C0380a c0380a = new C0380a();
        View view = c0274o.getView();
        if (view == null || this.f583u == null) {
            return c0380a;
        }
        aa.m839a((Map) c0380a, view);
        if (z) {
            return C0262i.m944a(this.f583u, this.f584v, c0380a);
        }
        c0380a.m1425a(this.f584v);
        return c0380a;
    }

    private static Object m963b(C0274o c0274o, boolean z) {
        if (c0274o == null) {
            return null;
        }
        return aa.m823a(z ? c0274o.getReturnTransition() : c0274o.getExitTransition());
    }

    private void m964b(C0260b c0260b, C0380a<String, View> c0380a, boolean z) {
        int size = c0380a.size();
        for (int i = 0; i < size; i++) {
            String str = (String) c0380a.m1421b(i);
            String a = aa.m826a((View) c0380a.m1422c(i));
            if (z) {
                C0262i.m958a(c0260b.f558a, str, a);
            } else {
                C0262i.m958a(c0260b.f558a, a, str);
            }
        }
    }

    private void m965b(SparseArray<C0274o> sparseArray, SparseArray<C0274o> sparseArray2) {
        if (this.f564b.f642p.m988a()) {
            for (C0259a c0259a = this.f565c; c0259a != null; c0259a = c0259a.f549a) {
                switch (c0259a.f551c) {
                    case C1373c.View_android_focusable /*1*/:
                        m966b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.View_paddingStart /*2*/:
                        C0274o c0274o = c0259a.f552d;
                        if (this.f564b.f633g != null) {
                            C0274o c0274o2 = c0274o;
                            for (int i = 0; i < this.f564b.f633g.size(); i++) {
                                C0274o c0274o3 = (C0274o) this.f564b.f633g.get(i);
                                if (c0274o2 == null || c0274o3.mContainerId == c0274o2.mContainerId) {
                                    if (c0274o3 == c0274o2) {
                                        c0274o2 = null;
                                        sparseArray2.remove(c0274o3.mContainerId);
                                    } else {
                                        C0262i.m959a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0274o3);
                                    }
                                }
                            }
                        }
                        m966b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.View_paddingEnd /*3*/:
                        C0262i.m959a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.View_theme /*4*/:
                        C0262i.m959a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.Toolbar_contentInsetStart /*5*/:
                        m966b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.Toolbar_contentInsetEnd /*6*/:
                        C0262i.m959a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.Toolbar_contentInsetLeft /*7*/:
                        m966b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private void m966b(SparseArray<C0274o> sparseArray, SparseArray<C0274o> sparseArray2, C0274o c0274o) {
        if (c0274o != null) {
            int i = c0274o.mContainerId;
            if (i != 0) {
                if (!c0274o.isAdded()) {
                    sparseArray2.put(i, c0274o);
                }
                if (sparseArray.get(i) == c0274o) {
                    sparseArray.remove(i);
                }
            }
            if (c0274o.mState < 1 && this.f564b.f640n >= 1) {
                this.f564b.m1131d(c0274o);
                this.f564b.m1105a(c0274o, 1, 0, 0, false);
            }
        }
    }

    int m967a(boolean z) {
        if (this.f577o) {
            throw new IllegalStateException("commit already called");
        }
        if (C0289u.f626a) {
            Log.v("FragmentManager", "Commit: " + this);
            m977a("  ", null, new PrintWriter(new C0383d("FragmentManager")), null);
        }
        this.f577o = true;
        if (this.f574l) {
            this.f578p = this.f564b.m1091a(this);
        } else {
            this.f578p = -1;
        }
        this.f564b.m1108a((Runnable) this, z);
        return this.f578p;
    }

    public C0260b m968a(boolean z, C0260b c0260b, SparseArray<C0274o> sparseArray, SparseArray<C0274o> sparseArray2) {
        if (C0289u.f626a) {
            Log.v("FragmentManager", "popFromBackStack: " + this);
            m977a("  ", null, new PrintWriter(new C0383d("FragmentManager")), null);
        }
        if (f563a && this.f564b.f640n >= 1) {
            if (c0260b == null) {
                if (!(sparseArray.size() == 0 && sparseArray2.size() == 0)) {
                    c0260b = m940a((SparseArray) sparseArray, (SparseArray) sparseArray2, true);
                }
            } else if (!z) {
                C0262i.m953a(c0260b, this.f584v, this.f583u);
            }
        }
        m974a(-1);
        int i = c0260b != null ? 0 : this.f573k;
        int i2 = c0260b != null ? 0 : this.f572j;
        C0259a c0259a = this.f566d;
        while (c0259a != null) {
            int i3 = c0260b != null ? 0 : c0259a.f555g;
            int i4 = c0260b != null ? 0 : c0259a.f556h;
            C0274o c0274o;
            C0274o c0274o2;
            switch (c0259a.f551c) {
                case C1373c.View_android_focusable /*1*/:
                    c0274o = c0259a.f552d;
                    c0274o.mNextAnim = i4;
                    this.f564b.m1104a(c0274o, C0289u.m1089d(i2), i);
                    break;
                case C1373c.View_paddingStart /*2*/:
                    c0274o = c0259a.f552d;
                    if (c0274o != null) {
                        c0274o.mNextAnim = i4;
                        this.f564b.m1104a(c0274o, C0289u.m1089d(i2), i);
                    }
                    if (c0259a.f557i == null) {
                        break;
                    }
                    for (int i5 = 0; i5 < c0259a.f557i.size(); i5++) {
                        c0274o2 = (C0274o) c0259a.f557i.get(i5);
                        c0274o2.mNextAnim = i3;
                        this.f564b.m1106a(c0274o2, false);
                    }
                    break;
                case C1373c.View_paddingEnd /*3*/:
                    c0274o2 = c0259a.f552d;
                    c0274o2.mNextAnim = i3;
                    this.f564b.m1106a(c0274o2, false);
                    break;
                case C1373c.View_theme /*4*/:
                    c0274o2 = c0259a.f552d;
                    c0274o2.mNextAnim = i3;
                    this.f564b.m1128c(c0274o2, C0289u.m1089d(i2), i);
                    break;
                case C1373c.Toolbar_contentInsetStart /*5*/:
                    c0274o = c0259a.f552d;
                    c0274o.mNextAnim = i4;
                    this.f564b.m1120b(c0274o, C0289u.m1089d(i2), i);
                    break;
                case C1373c.Toolbar_contentInsetEnd /*6*/:
                    c0274o2 = c0259a.f552d;
                    c0274o2.mNextAnim = i3;
                    this.f564b.m1134e(c0274o2, C0289u.m1089d(i2), i);
                    break;
                case C1373c.Toolbar_contentInsetLeft /*7*/:
                    c0274o2 = c0259a.f552d;
                    c0274o2.mNextAnim = i3;
                    this.f564b.m1132d(c0274o2, C0289u.m1089d(i2), i);
                    break;
                default:
                    throw new IllegalArgumentException("Unknown cmd: " + c0259a.f551c);
            }
            c0259a = c0259a.f550b;
        }
        if (z) {
            this.f564b.m1098a(this.f564b.f640n, C0289u.m1089d(i2), i, true);
            c0260b = null;
        }
        if (this.f578p >= 0) {
            this.f564b.m1126c(this.f578p);
            this.f578p = -1;
        }
        return c0260b;
    }

    public C0261z m969a() {
        if (this.f574l) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f575m = false;
        return this;
    }

    public C0261z m970a(int i, C0274o c0274o) {
        m948a(i, c0274o, null, 1);
        return this;
    }

    public C0261z m971a(int i, C0274o c0274o, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        m948a(i, c0274o, str, 2);
        return this;
    }

    public C0261z m972a(C0274o c0274o) {
        C0259a c0259a = new C0259a();
        c0259a.f551c = 3;
        c0259a.f552d = c0274o;
        m975a(c0259a);
        return this;
    }

    public C0261z m973a(C0274o c0274o, String str) {
        m948a(0, c0274o, str, 1);
        return this;
    }

    void m974a(int i) {
        if (this.f574l) {
            if (C0289u.f626a) {
                Log.v("FragmentManager", "Bump nesting in " + this + " by " + i);
            }
            for (C0259a c0259a = this.f565c; c0259a != null; c0259a = c0259a.f549a) {
                C0274o c0274o;
                if (c0259a.f552d != null) {
                    c0274o = c0259a.f552d;
                    c0274o.mBackStackNesting += i;
                    if (C0289u.f626a) {
                        Log.v("FragmentManager", "Bump nesting of " + c0259a.f552d + " to " + c0259a.f552d.mBackStackNesting);
                    }
                }
                if (c0259a.f557i != null) {
                    for (int size = c0259a.f557i.size() - 1; size >= 0; size--) {
                        c0274o = (C0274o) c0259a.f557i.get(size);
                        c0274o.mBackStackNesting += i;
                        if (C0289u.f626a) {
                            Log.v("FragmentManager", "Bump nesting of " + c0274o + " to " + c0274o.mBackStackNesting);
                        }
                    }
                }
            }
        }
    }

    void m975a(C0259a c0259a) {
        if (this.f565c == null) {
            this.f566d = c0259a;
            this.f565c = c0259a;
        } else {
            c0259a.f550b = this.f566d;
            this.f566d.f549a = c0259a;
            this.f566d = c0259a;
        }
        c0259a.f553e = this.f568f;
        c0259a.f554f = this.f569g;
        c0259a.f555g = this.f570h;
        c0259a.f556h = this.f571i;
        this.f567e++;
    }

    public void m976a(SparseArray<C0274o> sparseArray, SparseArray<C0274o> sparseArray2) {
        if (this.f564b.f642p.m988a()) {
            for (C0259a c0259a = this.f566d; c0259a != null; c0259a = c0259a.f550b) {
                switch (c0259a.f551c) {
                    case C1373c.View_android_focusable /*1*/:
                        C0262i.m959a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.View_paddingStart /*2*/:
                        if (c0259a.f557i != null) {
                            for (int size = c0259a.f557i.size() - 1; size >= 0; size--) {
                                m966b((SparseArray) sparseArray, (SparseArray) sparseArray2, (C0274o) c0259a.f557i.get(size));
                            }
                        }
                        C0262i.m959a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.View_paddingEnd /*3*/:
                        m966b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.View_theme /*4*/:
                        m966b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.Toolbar_contentInsetStart /*5*/:
                        C0262i.m959a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.Toolbar_contentInsetEnd /*6*/:
                        m966b((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    case C1373c.Toolbar_contentInsetLeft /*7*/:
                        C0262i.m959a((SparseArray) sparseArray, (SparseArray) sparseArray2, c0259a.f552d);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void m977a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        m978a(str, printWriter, true);
    }

    public void m978a(String str, PrintWriter printWriter, boolean z) {
        if (z) {
            printWriter.print(str);
            printWriter.print("mName=");
            printWriter.print(this.f576n);
            printWriter.print(" mIndex=");
            printWriter.print(this.f578p);
            printWriter.print(" mCommitted=");
            printWriter.println(this.f577o);
            if (this.f572j != 0) {
                printWriter.print(str);
                printWriter.print("mTransition=#");
                printWriter.print(Integer.toHexString(this.f572j));
                printWriter.print(" mTransitionStyle=#");
                printWriter.println(Integer.toHexString(this.f573k));
            }
            if (!(this.f568f == 0 && this.f569g == 0)) {
                printWriter.print(str);
                printWriter.print("mEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f568f));
                printWriter.print(" mExitAnim=#");
                printWriter.println(Integer.toHexString(this.f569g));
            }
            if (!(this.f570h == 0 && this.f571i == 0)) {
                printWriter.print(str);
                printWriter.print("mPopEnterAnim=#");
                printWriter.print(Integer.toHexString(this.f570h));
                printWriter.print(" mPopExitAnim=#");
                printWriter.println(Integer.toHexString(this.f571i));
            }
            if (!(this.f579q == 0 && this.f580r == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbTitleRes=#");
                printWriter.print(Integer.toHexString(this.f579q));
                printWriter.print(" mBreadCrumbTitleText=");
                printWriter.println(this.f580r);
            }
            if (!(this.f581s == 0 && this.f582t == null)) {
                printWriter.print(str);
                printWriter.print("mBreadCrumbShortTitleRes=#");
                printWriter.print(Integer.toHexString(this.f581s));
                printWriter.print(" mBreadCrumbShortTitleText=");
                printWriter.println(this.f582t);
            }
        }
        if (this.f565c != null) {
            printWriter.print(str);
            printWriter.println("Operations:");
            String str2 = str + "    ";
            int i = 0;
            C0259a c0259a = this.f565c;
            while (c0259a != null) {
                String str3;
                switch (c0259a.f551c) {
                    case C1373c.View_android_theme /*0*/:
                        str3 = "NULL";
                        break;
                    case C1373c.View_android_focusable /*1*/:
                        str3 = "ADD";
                        break;
                    case C1373c.View_paddingStart /*2*/:
                        str3 = "REPLACE";
                        break;
                    case C1373c.View_paddingEnd /*3*/:
                        str3 = "REMOVE";
                        break;
                    case C1373c.View_theme /*4*/:
                        str3 = "HIDE";
                        break;
                    case C1373c.Toolbar_contentInsetStart /*5*/:
                        str3 = "SHOW";
                        break;
                    case C1373c.Toolbar_contentInsetEnd /*6*/:
                        str3 = "DETACH";
                        break;
                    case C1373c.Toolbar_contentInsetLeft /*7*/:
                        str3 = "ATTACH";
                        break;
                    default:
                        str3 = "cmd=" + c0259a.f551c;
                        break;
                }
                printWriter.print(str);
                printWriter.print("  Op #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.print(str3);
                printWriter.print(" ");
                printWriter.println(c0259a.f552d);
                if (z) {
                    if (!(c0259a.f553e == 0 && c0259a.f554f == 0)) {
                        printWriter.print(str);
                        printWriter.print("enterAnim=#");
                        printWriter.print(Integer.toHexString(c0259a.f553e));
                        printWriter.print(" exitAnim=#");
                        printWriter.println(Integer.toHexString(c0259a.f554f));
                    }
                    if (!(c0259a.f555g == 0 && c0259a.f556h == 0)) {
                        printWriter.print(str);
                        printWriter.print("popEnterAnim=#");
                        printWriter.print(Integer.toHexString(c0259a.f555g));
                        printWriter.print(" popExitAnim=#");
                        printWriter.println(Integer.toHexString(c0259a.f556h));
                    }
                }
                if (c0259a.f557i != null && c0259a.f557i.size() > 0) {
                    for (int i2 = 0; i2 < c0259a.f557i.size(); i2++) {
                        printWriter.print(str2);
                        if (c0259a.f557i.size() == 1) {
                            printWriter.print("Removed: ");
                        } else {
                            if (i2 == 0) {
                                printWriter.println("Removed:");
                            }
                            printWriter.print(str2);
                            printWriter.print("  #");
                            printWriter.print(i2);
                            printWriter.print(": ");
                        }
                        printWriter.println(c0259a.f557i.get(i2));
                    }
                }
                c0259a = c0259a.f549a;
                i++;
            }
        }
    }

    public int m979b() {
        return m967a(false);
    }

    public C0261z m980b(int i, C0274o c0274o) {
        return m971a(i, c0274o, null);
    }

    public int m981c() {
        return m967a(true);
    }

    public void m982d() {
        m969a();
        this.f564b.m1122b((Runnable) this, true);
    }

    public String m983e() {
        return this.f576n;
    }

    public void run() {
        if (C0289u.f626a) {
            Log.v("FragmentManager", "Run: " + this);
        }
        if (!this.f574l || this.f578p >= 0) {
            C0260b c0260b;
            m974a(1);
            if (!f563a || this.f564b.f640n < 1) {
                c0260b = null;
            } else {
                SparseArray sparseArray = new SparseArray();
                SparseArray sparseArray2 = new SparseArray();
                m965b(sparseArray, sparseArray2);
                c0260b = m940a(sparseArray, sparseArray2, false);
            }
            int i = c0260b != null ? 0 : this.f573k;
            int i2 = c0260b != null ? 0 : this.f572j;
            C0259a c0259a = this.f565c;
            while (c0259a != null) {
                int i3 = c0260b != null ? 0 : c0259a.f553e;
                int i4 = c0260b != null ? 0 : c0259a.f554f;
                C0274o c0274o;
                switch (c0259a.f551c) {
                    case C1373c.View_android_focusable /*1*/:
                        c0274o = c0259a.f552d;
                        c0274o.mNextAnim = i3;
                        this.f564b.m1106a(c0274o, false);
                        break;
                    case C1373c.View_paddingStart /*2*/:
                        C0274o c0274o2 = c0259a.f552d;
                        int i5 = c0274o2.mContainerId;
                        if (this.f564b.f633g != null) {
                            int size = this.f564b.f633g.size() - 1;
                            while (size >= 0) {
                                c0274o = (C0274o) this.f564b.f633g.get(size);
                                if (C0289u.f626a) {
                                    Log.v("FragmentManager", "OP_REPLACE: adding=" + c0274o2 + " old=" + c0274o);
                                }
                                if (c0274o.mContainerId == i5) {
                                    if (c0274o == c0274o2) {
                                        c0274o = null;
                                        c0259a.f552d = null;
                                        size--;
                                        c0274o2 = c0274o;
                                    } else {
                                        if (c0259a.f557i == null) {
                                            c0259a.f557i = new ArrayList();
                                        }
                                        c0259a.f557i.add(c0274o);
                                        c0274o.mNextAnim = i4;
                                        if (this.f574l) {
                                            c0274o.mBackStackNesting++;
                                            if (C0289u.f626a) {
                                                Log.v("FragmentManager", "Bump nesting of " + c0274o + " to " + c0274o.mBackStackNesting);
                                            }
                                        }
                                        this.f564b.m1104a(c0274o, i2, i);
                                    }
                                }
                                c0274o = c0274o2;
                                size--;
                                c0274o2 = c0274o;
                            }
                        }
                        if (c0274o2 == null) {
                            break;
                        }
                        c0274o2.mNextAnim = i3;
                        this.f564b.m1106a(c0274o2, false);
                        break;
                    case C1373c.View_paddingEnd /*3*/:
                        c0274o = c0259a.f552d;
                        c0274o.mNextAnim = i4;
                        this.f564b.m1104a(c0274o, i2, i);
                        break;
                    case C1373c.View_theme /*4*/:
                        c0274o = c0259a.f552d;
                        c0274o.mNextAnim = i4;
                        this.f564b.m1120b(c0274o, i2, i);
                        break;
                    case C1373c.Toolbar_contentInsetStart /*5*/:
                        c0274o = c0259a.f552d;
                        c0274o.mNextAnim = i3;
                        this.f564b.m1128c(c0274o, i2, i);
                        break;
                    case C1373c.Toolbar_contentInsetEnd /*6*/:
                        c0274o = c0259a.f552d;
                        c0274o.mNextAnim = i4;
                        this.f564b.m1132d(c0274o, i2, i);
                        break;
                    case C1373c.Toolbar_contentInsetLeft /*7*/:
                        c0274o = c0259a.f552d;
                        c0274o.mNextAnim = i3;
                        this.f564b.m1134e(c0274o, i2, i);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown cmd: " + c0259a.f551c);
                }
                c0259a = c0259a.f549a;
            }
            this.f564b.m1098a(this.f564b.f640n, i2, i, true);
            if (this.f574l) {
                this.f564b.m1118b(this);
                return;
            }
            return;
        }
        throw new IllegalStateException("addToBackStack() called after commit()");
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("BackStackEntry{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        if (this.f578p >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.f578p);
        }
        if (this.f576n != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.f576n);
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
