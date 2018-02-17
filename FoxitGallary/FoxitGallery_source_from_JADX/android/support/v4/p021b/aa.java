package android.support.v4.p021b;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: android.support.v4.b.aa */
class aa {

    /* renamed from: android.support.v4.b.aa.1 */
    static class C02271 extends EpicenterCallback {
        final /* synthetic */ Rect f479a;

        C02271(Rect rect) {
            this.f479a = rect;
        }

        public Rect onGetEpicenter(Transition transition) {
            return this.f479a;
        }
    }

    /* renamed from: android.support.v4.b.aa.2 */
    static class C02282 implements OnPreDrawListener {
        final /* synthetic */ View f480a;
        final /* synthetic */ Transition f481b;
        final /* synthetic */ View f482c;
        final /* synthetic */ C0232b f483d;
        final /* synthetic */ Map f484e;
        final /* synthetic */ Map f485f;
        final /* synthetic */ ArrayList f486g;
        final /* synthetic */ Transition f487h;

        C02282(View view, Transition transition, View view2, C0232b c0232b, Map map, Map map2, ArrayList arrayList, Transition transition2) {
            this.f480a = view;
            this.f481b = transition;
            this.f482c = view2;
            this.f483d = c0232b;
            this.f484e = map;
            this.f485f = map2;
            this.f486g = arrayList;
            this.f487h = transition2;
        }

        public boolean onPreDraw() {
            this.f480a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f481b != null) {
                this.f481b.removeTarget(this.f482c);
            }
            if (this.f483d != null) {
                View a = this.f483d.m822a();
                if (a != null) {
                    if (!this.f484e.isEmpty()) {
                        aa.m839a(this.f485f, a);
                        this.f485f.keySet().retainAll(this.f484e.values());
                        for (Entry entry : this.f484e.entrySet()) {
                            View view = (View) this.f485f.get((String) entry.getValue());
                            if (view != null) {
                                view.setTransitionName((String) entry.getKey());
                            }
                        }
                    }
                    if (this.f481b != null) {
                        aa.m847b(this.f486g, a);
                        this.f486g.removeAll(this.f485f.values());
                        this.f486g.add(this.f482c);
                        aa.m846b(this.f481b, this.f486g);
                    }
                }
            }
            aa.m845b(this.f487h, this.f481b, this.f486g, true);
            return true;
        }
    }

    /* renamed from: android.support.v4.b.aa.3 */
    static class C02293 extends EpicenterCallback {
        final /* synthetic */ C0231a f488a;
        private Rect f489b;

        C02293(C0231a c0231a) {
            this.f488a = c0231a;
        }

        public Rect onGetEpicenter(Transition transition) {
            if (this.f489b == null && this.f488a.f501a != null) {
                this.f489b = aa.m848c(this.f488a.f501a);
            }
            return this.f489b;
        }
    }

    /* renamed from: android.support.v4.b.aa.4 */
    static class C02304 implements OnPreDrawListener {
        final /* synthetic */ View f490a;
        final /* synthetic */ Transition f491b;
        final /* synthetic */ ArrayList f492c;
        final /* synthetic */ Transition f493d;
        final /* synthetic */ ArrayList f494e;
        final /* synthetic */ Transition f495f;
        final /* synthetic */ ArrayList f496g;
        final /* synthetic */ Map f497h;
        final /* synthetic */ ArrayList f498i;
        final /* synthetic */ Transition f499j;
        final /* synthetic */ View f500k;

        C02304(View view, Transition transition, ArrayList arrayList, Transition transition2, ArrayList arrayList2, Transition transition3, ArrayList arrayList3, Map map, ArrayList arrayList4, Transition transition4, View view2) {
            this.f490a = view;
            this.f491b = transition;
            this.f492c = arrayList;
            this.f493d = transition2;
            this.f494e = arrayList2;
            this.f495f = transition3;
            this.f496g = arrayList3;
            this.f497h = map;
            this.f498i = arrayList4;
            this.f499j = transition4;
            this.f500k = view2;
        }

        public boolean onPreDraw() {
            this.f490a.getViewTreeObserver().removeOnPreDrawListener(this);
            if (this.f491b != null) {
                aa.m836a(this.f491b, this.f492c);
                aa.m845b(this.f491b, this.f493d, this.f494e, false);
                aa.m845b(this.f491b, this.f495f, this.f496g, false);
            }
            if (this.f493d != null) {
                aa.m836a(this.f493d, this.f494e);
                aa.m845b(this.f493d, this.f491b, this.f492c, false);
                aa.m845b(this.f493d, this.f495f, this.f496g, false);
            }
            if (this.f495f != null) {
                aa.m836a(this.f495f, this.f496g);
            }
            for (Entry entry : this.f497h.entrySet()) {
                ((View) entry.getValue()).setTransitionName((String) entry.getKey());
            }
            int size = this.f498i.size();
            for (int i = 0; i < size; i++) {
                this.f499j.excludeTarget((View) this.f498i.get(i), false);
            }
            this.f499j.excludeTarget(this.f500k, false);
            return true;
        }
    }

    /* renamed from: android.support.v4.b.aa.a */
    public static class C0231a {
        public View f501a;
    }

    /* renamed from: android.support.v4.b.aa.b */
    public interface C0232b {
        View m822a();
    }

    public static Object m823a(Object obj) {
        return obj != null ? ((Transition) obj).clone() : obj;
    }

    public static Object m824a(Object obj, View view, ArrayList<View> arrayList, Map<String, View> map, View view2) {
        if (obj == null) {
            return obj;
        }
        aa.m847b((ArrayList) arrayList, view);
        if (map != null) {
            arrayList.removeAll(map.values());
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        arrayList.add(view2);
        aa.m846b((Transition) obj, (ArrayList) arrayList);
        return obj;
    }

    public static Object m825a(Object obj, Object obj2, Object obj3, boolean z) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition == null || transition2 == null) {
            z = true;
        }
        TransitionSet transitionSet;
        if (z) {
            transitionSet = new TransitionSet();
            if (transition != null) {
                transitionSet.addTransition(transition);
            }
            if (transition2 != null) {
                transitionSet.addTransition(transition2);
            }
            if (transition3 == null) {
                return transitionSet;
            }
            transitionSet.addTransition(transition3);
            return transitionSet;
        }
        Transition transition4 = null;
        if (transition2 != null && transition != null) {
            transition4 = new TransitionSet().addTransition(transition2).addTransition(transition).setOrdering(1);
        } else if (transition2 != null) {
            transition4 = transition2;
        } else if (transition != null) {
            transition4 = transition;
        }
        if (transition3 == null) {
            return transition4;
        }
        transitionSet = new TransitionSet();
        if (transition4 != null) {
            transitionSet.addTransition(transition4);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public static String m826a(View view) {
        return view.getTransitionName();
    }

    private static void m827a(Transition transition, C0231a c0231a) {
        if (transition != null) {
            transition.setEpicenterCallback(new C02293(c0231a));
        }
    }

    public static void m829a(View view, View view2, Object obj, ArrayList<View> arrayList, Object obj2, ArrayList<View> arrayList2, Object obj3, ArrayList<View> arrayList3, Object obj4, ArrayList<View> arrayList4, Map<String, View> map) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        Transition transition4 = (Transition) obj4;
        if (transition4 != null) {
            view.getViewTreeObserver().addOnPreDrawListener(new C02304(view, transition, arrayList, transition2, arrayList2, transition3, arrayList3, map, arrayList4, transition4, view2));
        }
    }

    public static void m830a(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public static void m831a(Object obj, View view) {
        ((Transition) obj).setEpicenterCallback(new C02271(aa.m848c(view)));
    }

    public static void m832a(Object obj, View view, Map<String, View> map, ArrayList<View> arrayList) {
        obj = (TransitionSet) obj;
        arrayList.clear();
        arrayList.addAll(map.values());
        List targets = obj.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            aa.m838a(targets, (View) arrayList.get(i));
        }
        arrayList.add(view);
        aa.m846b(obj, (ArrayList) arrayList);
    }

    public static void m833a(Object obj, View view, boolean z) {
        ((Transition) obj).excludeTarget(view, z);
    }

    public static void m834a(Object obj, Object obj2, Object obj3, View view, C0232b c0232b, View view2, C0231a c0231a, Map<String, String> map, ArrayList<View> arrayList, ArrayList<View> arrayList2, Map<String, View> map2, Map<String, View> map3, ArrayList<View> arrayList3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj3;
        Object obj4 = (Transition) obj2;
        aa.m845b(transition, transition2, arrayList2, true);
        if (obj != null || obj2 != null) {
            if (transition != null) {
                transition.addTarget(view2);
            }
            if (obj2 != null) {
                aa.m832a(obj4, view2, (Map) map2, (ArrayList) arrayList3);
                aa.m845b(transition, obj4, arrayList3, true);
                aa.m845b(transition2, obj4, arrayList3, true);
            }
            view.getViewTreeObserver().addOnPreDrawListener(new C02282(view, transition, view2, c0232b, map, map3, arrayList, transition2));
            aa.m827a(transition, c0231a);
        }
    }

    public static void m835a(Object obj, Object obj2, Object obj3, ArrayList<View> arrayList, boolean z) {
        Transition transition = (Transition) obj2;
        Transition transition2 = (Transition) obj3;
        aa.m845b((Transition) obj, transition2, arrayList, z);
        aa.m845b(transition, transition2, arrayList, z);
    }

    public static void m836a(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            for (int i = 0; i < transitionCount; i++) {
                aa.m836a(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
            }
        } else if (!aa.m840a(transition)) {
            List targets = transition.getTargets();
            if (targets != null && targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                for (transitionCount = arrayList.size() - 1; transitionCount >= 0; transitionCount--) {
                    transition.removeTarget((View) arrayList.get(transitionCount));
                }
            }
        }
    }

    private static void m838a(List<View> list, View view) {
        int size = list.size();
        if (!aa.m842a((List) list, view, size)) {
            list.add(view);
            for (int i = size; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                if (view2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view2;
                    int childCount = viewGroup.getChildCount();
                    for (int i2 = 0; i2 < childCount; i2++) {
                        View childAt = viewGroup.getChildAt(i2);
                        if (!aa.m842a((List) list, childAt, size)) {
                            list.add(childAt);
                        }
                    }
                }
            }
        }
    }

    public static void m839a(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String transitionName = view.getTransitionName();
            if (transitionName != null) {
                map.put(transitionName, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    aa.m839a((Map) map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    private static boolean m840a(Transition transition) {
        return (aa.m841a(transition.getTargetIds()) && aa.m841a(transition.getTargetNames()) && aa.m841a(transition.getTargetTypes())) ? false : true;
    }

    private static boolean m841a(List list) {
        return list == null || list.isEmpty();
    }

    private static boolean m842a(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    public static Object m844b(Object obj) {
        if (obj == null) {
            return null;
        }
        Transition transition = (Transition) obj;
        if (transition == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition(transition);
        return transitionSet;
    }

    private static void m845b(Transition transition, Transition transition2, ArrayList<View> arrayList, boolean z) {
        if (transition != null) {
            int size = transition2 == null ? 0 : arrayList.size();
            for (int i = 0; i < size; i++) {
                transition.excludeTarget((View) arrayList.get(i), z);
            }
        }
    }

    public static void m846b(Object obj, ArrayList<View> arrayList) {
        int i = 0;
        Transition transition = (Transition) obj;
        int transitionCount;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            transitionCount = transitionSet.getTransitionCount();
            while (i < transitionCount) {
                aa.m846b(transitionSet.getTransitionAt(i), (ArrayList) arrayList);
                i++;
            }
        } else if (!aa.m840a(transition) && aa.m841a(transition.getTargets())) {
            int size = arrayList.size();
            for (transitionCount = 0; transitionCount < size; transitionCount++) {
                transition.addTarget((View) arrayList.get(transitionCount));
            }
        }
    }

    private static void m847b(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.isTransitionGroup()) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                aa.m847b((ArrayList) arrayList, viewGroup.getChildAt(i));
            }
            return;
        }
        arrayList.add(view);
    }

    private static Rect m848c(View view) {
        Rect rect = new Rect();
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
        return rect;
    }
}
