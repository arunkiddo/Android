package com.p040a.p041a.p042a;

import android.util.SparseBooleanArray;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.a.a.a.b */
public class C0966b {
    private SparseBooleanArray f2523a;
    private C0973g f2524b;
    private boolean f2525c;

    public C0966b() {
        this.f2523a = new SparseBooleanArray();
        this.f2524b = new C0973g();
    }

    private void m5043a(C0967e c0967e) {
        if (c0967e != null) {
            c0967e.setSelectable(this.f2525c);
            c0967e.setActivated(this.f2523a.get(c0967e.getAdapterPosition()));
        }
    }

    public void m5044a(int i, long j, boolean z) {
        this.f2523a.put(i, z);
        m5043a(this.f2524b.m5052a(i));
    }

    public void m5045a(C0967e c0967e, int i, long j) {
        this.f2524b.m5054a(c0967e, i);
        m5043a(c0967e);
    }

    public void m5046a(C0967e c0967e, boolean z) {
        m5044a(c0967e.getAdapterPosition(), c0967e.getItemId(), z);
    }

    public void m5047a(boolean z) {
        this.f2525c = z;
        m5051d();
    }

    public boolean m5048a() {
        return this.f2525c;
    }

    public void m5049b() {
        this.f2523a.clear();
        m5051d();
    }

    public List<Integer> m5050c() {
        List<Integer> arrayList = new ArrayList();
        for (int i = 0; i < this.f2523a.size(); i++) {
            if (this.f2523a.valueAt(i)) {
                arrayList.add(Integer.valueOf(this.f2523a.keyAt(i)));
            }
        }
        return arrayList;
    }

    public void m5051d() {
        for (C0967e a : this.f2524b.m5053a()) {
            m5043a(a);
        }
    }
}
