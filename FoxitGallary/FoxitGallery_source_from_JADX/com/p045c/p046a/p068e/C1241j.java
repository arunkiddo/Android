package com.p045c.p046a.p068e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import com.p045c.p046a.C1305l;
import java.util.HashSet;

@TargetApi(11)
/* renamed from: com.c.a.e.j */
public class C1241j extends Fragment {
    private final C1229a f3112a;
    private final C1236l f3113b;
    private C1305l f3114c;
    private final HashSet<C1241j> f3115d;
    private C1241j f3116e;

    /* renamed from: com.c.a.e.j.a */
    private class C1240a implements C1236l {
        final /* synthetic */ C1241j f3111a;

        private C1240a(C1241j c1241j) {
            this.f3111a = c1241j;
        }
    }

    public C1241j() {
        this(new C1229a());
    }

    @SuppressLint({"ValidFragment"})
    C1241j(C1229a c1229a) {
        this.f3113b = new C1240a();
        this.f3115d = new HashSet();
        this.f3112a = c1229a;
    }

    private void m5872a(C1241j c1241j) {
        this.f3115d.add(c1241j);
    }

    private void m5873b(C1241j c1241j) {
        this.f3115d.remove(c1241j);
    }

    C1229a m5874a() {
        return this.f3112a;
    }

    public void m5875a(C1305l c1305l) {
        this.f3114c = c1305l;
    }

    public C1305l m5876b() {
        return this.f3114c;
    }

    public C1236l m5877c() {
        return this.f3113b;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f3116e = C1242k.m5878a().m5881a(getActivity().getFragmentManager());
        if (this.f3116e != this) {
            this.f3116e.m5872a(this);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f3112a.m5861c();
    }

    public void onDetach() {
        super.onDetach();
        if (this.f3116e != null) {
            this.f3116e.m5873b(this);
            this.f3116e = null;
        }
    }

    public void onLowMemory() {
        if (this.f3114c != null) {
            this.f3114c.m6139a();
        }
    }

    public void onStart() {
        super.onStart();
        this.f3112a.m5858a();
    }

    public void onStop() {
        super.onStop();
        this.f3112a.m5860b();
    }

    public void onTrimMemory(int i) {
        if (this.f3114c != null) {
            this.f3114c.m6140a(i);
        }
    }
}
