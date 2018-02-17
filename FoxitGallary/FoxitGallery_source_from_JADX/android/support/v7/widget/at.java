package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.p016k.C0473b;
import android.support.v4.p016k.p031a.C0416c;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public class at extends C0473b {
    final RecyclerView f2277b;
    final C0473b f2278c;

    /* renamed from: android.support.v7.widget.at.1 */
    class C09111 extends C0473b {
        final /* synthetic */ at f2276b;

        C09111(at atVar) {
            this.f2276b = atVar;
        }

        public void m4710a(View view, C0416c c0416c) {
            super.m2056a(view, c0416c);
            if (!this.f2276b.m4713c() && this.f2276b.f2277b.getLayoutManager() != null) {
                this.f2276b.f2277b.getLayoutManager().m3796a(view, c0416c);
            }
        }

        public boolean m4711a(View view, int i, Bundle bundle) {
            return super.m2058a(view, i, bundle) ? true : (this.f2276b.m4713c() || this.f2276b.f2277b.getLayoutManager() == null) ? false : this.f2276b.f2277b.getLayoutManager().m3810a(view, i, bundle);
        }
    }

    public at(RecyclerView recyclerView) {
        this.f2278c = new C09111(this);
        this.f2277b = recyclerView;
    }

    private boolean m4713c() {
        return this.f2277b.hasPendingAdapterUpdates();
    }

    public void m4714a(View view, C0416c c0416c) {
        super.m2056a(view, c0416c);
        c0416c.m1572a(RecyclerView.class.getName());
        if (!m4713c() && this.f2277b.getLayoutManager() != null) {
            this.f2277b.getLayoutManager().m3775a(c0416c);
        }
    }

    public boolean m4715a(View view, int i, Bundle bundle) {
        return super.m2058a(view, i, bundle) ? true : (m4713c() || this.f2277b.getLayoutManager() == null) ? false : this.f2277b.getLayoutManager().m3801a(i, bundle);
    }

    public C0473b m4716b() {
        return this.f2278c;
    }

    public void m4717d(View view, AccessibilityEvent accessibilityEvent) {
        super.m2062d(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !m4713c()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getLayoutManager() != null) {
                recyclerView.getLayoutManager().m3799a(accessibilityEvent);
            }
        }
    }
}
