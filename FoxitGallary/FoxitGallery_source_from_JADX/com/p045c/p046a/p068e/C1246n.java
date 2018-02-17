package com.p045c.p046a.p068e;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.p021b.C0274o;
import com.p045c.p046a.C1305l;
import java.util.HashSet;

/* renamed from: com.c.a.e.n */
public class C1246n extends C0274o {
    private C1305l f3126a;
    private final C1229a f3127b;
    private final C1236l f3128c;
    private final HashSet<C1246n> f3129d;
    private C1246n f3130e;

    /* renamed from: com.c.a.e.n.a */
    private class C1245a implements C1236l {
        final /* synthetic */ C1246n f3125a;

        private C1245a(C1246n c1246n) {
            this.f3125a = c1246n;
        }
    }

    public C1246n() {
        this(new C1229a());
    }

    @SuppressLint({"ValidFragment"})
    public C1246n(C1229a c1229a) {
        this.f3128c = new C1245a();
        this.f3129d = new HashSet();
        this.f3127b = c1229a;
    }

    private void m5894a(C1246n c1246n) {
        this.f3129d.add(c1246n);
    }

    private void m5895b(C1246n c1246n) {
        this.f3129d.remove(c1246n);
    }

    C1229a m5896a() {
        return this.f3127b;
    }

    public void m5897a(C1305l c1305l) {
        this.f3126a = c1305l;
    }

    public C1305l m5898b() {
        return this.f3126a;
    }

    public C1236l m5899c() {
        return this.f3128c;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3130e = C1242k.m5878a().m5882a(getActivity().getSupportFragmentManager());
        if (this.f3130e != this) {
            this.f3130e.m5894a(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f3127b.m5861c();
    }

    public void onDetach() {
        super.onDetach();
        if (this.f3130e != null) {
            this.f3130e.m5895b(this);
            this.f3130e = null;
        }
    }

    public void onLowMemory() {
        super.onLowMemory();
        if (this.f3126a != null) {
            this.f3126a.m6139a();
        }
    }

    public void onStart() {
        super.onStart();
        this.f3127b.m5858a();
    }

    public void onStop() {
        super.onStop();
        this.f3127b.m5860b();
    }
}
