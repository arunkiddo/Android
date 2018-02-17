package com.p040a.p041a.p042a;

import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.a.a.a.g */
class C0973g {
    private SparseArray<WeakReference<C0967e>> f2526a;

    C0973g() {
        this.f2526a = new SparseArray();
    }

    public C0967e m5052a(int i) {
        WeakReference weakReference = (WeakReference) this.f2526a.get(i);
        if (weakReference == null) {
            return null;
        }
        C0967e c0967e = (C0967e) weakReference.get();
        if (c0967e != null && c0967e.getAdapterPosition() == i) {
            return c0967e;
        }
        this.f2526a.remove(i);
        return null;
    }

    public List<C0967e> m5053a() {
        List<C0967e> arrayList = new ArrayList();
        for (int i = 0; i < this.f2526a.size(); i++) {
            C0967e a = m5052a(this.f2526a.keyAt(i));
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    public void m5054a(C0967e c0967e, int i) {
        this.f2526a.put(i, new WeakReference(c0967e));
    }
}
