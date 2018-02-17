package com.p043b.p044a;

import android.content.Context;
import android.database.DataSetObserver;
import android.support.v4.p016k.ac;
import android.support.v4.p016k.aw;
import android.support.v4.p016k.aw.C0476f;
import android.support.v4.p029i.C0375d;
import android.support.v4.p030j.C0380a;
import android.util.AttributeSet;
import android.view.ViewGroup;
import java.util.Map;

/* renamed from: com.b.a.b */
public class C0979b extends aw {
    private DataSetObserver dataSetObserver;
    private final Map<C0476f, C0978c> reverseOnPageChangeListeners;
    private boolean suppressOnPageChangeListeners;

    /* renamed from: com.b.a.b.a */
    private static class C0976a extends DataSetObserver {
        private final C0977b f2528a;

        private C0976a(C0977b c0977b) {
            this.f2528a = c0977b;
        }

        public void onChanged() {
            super.onChanged();
            this.f2528a.m5058b();
        }
    }

    /* renamed from: com.b.a.b.b */
    private class C0977b extends C0974a {
        final /* synthetic */ C0979b f2529a;
        private int f2530b;

        public C0977b(C0979b c0979b, ac acVar) {
            this.f2529a = c0979b;
            super(acVar);
            this.f2530b = acVar.getCount();
        }

        private int m5056a(int i) {
            return (getCount() - i) - 1;
        }

        private void m5058b() {
            int count = getCount();
            if (count != this.f2530b) {
                this.f2529a.setCurrentItemWithoutNotification(Math.max(0, this.f2530b - 1));
                this.f2530b = count;
            }
        }

        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            super.destroyItem(viewGroup, m5056a(i), obj);
        }

        public int getItemPosition(Object obj) {
            int itemPosition = super.getItemPosition(obj);
            return itemPosition < 0 ? itemPosition : m5056a(itemPosition);
        }

        public CharSequence getPageTitle(int i) {
            return super.getPageTitle(m5056a(i));
        }

        public float getPageWidth(int i) {
            return super.getPageWidth(m5056a(i));
        }

        public Object instantiateItem(ViewGroup viewGroup, int i) {
            return super.instantiateItem(viewGroup, m5056a(i));
        }

        public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
            super.setPrimaryItem(viewGroup, (this.f2530b - i) - 1, obj);
        }
    }

    /* renamed from: com.b.a.b.c */
    private class C0978c implements C0476f {
        final /* synthetic */ C0979b f2531a;
        private final C0476f f2532b;
        private int f2533c;

        private C0978c(C0979b c0979b, C0476f c0476f) {
            this.f2531a = c0979b;
            this.f2532b = c0476f;
            this.f2533c = -1;
        }

        private int m5059a(int i) {
            ac adapter = this.f2531a.getAdapter();
            return adapter == null ? i : (adapter.getCount() - i) - 1;
        }

        public void onPageScrollStateChanged(int i) {
            if (!this.f2531a.suppressOnPageChangeListeners) {
                this.f2532b.onPageScrollStateChanged(i);
            }
        }

        public void onPageScrolled(int i, float f, int i2) {
            if (!this.f2531a.suppressOnPageChangeListeners) {
                if (f == 0.0f && i2 == 0) {
                    this.f2533c = m5059a(i);
                } else {
                    this.f2533c = m5059a(i + 1);
                }
                C0476f c0476f = this.f2532b;
                int i3 = this.f2533c;
                if (f > 0.0f) {
                    f = 1.0f - f;
                }
                c0476f.onPageScrolled(i3, f, i2);
            }
        }

        public void onPageSelected(int i) {
            if (!this.f2531a.suppressOnPageChangeListeners) {
                this.f2532b.onPageSelected(m5059a(i));
            }
        }
    }

    public C0979b(Context context) {
        super(context);
        this.reverseOnPageChangeListeners = new C0380a(1);
    }

    public C0979b(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.reverseOnPageChangeListeners = new C0380a(1);
    }

    private int convert(int i) {
        return (i < 0 || !isRtl()) ? i : getAdapter() == null ? 0 : (getAdapter().getCount() - i) - 1;
    }

    private void registerRtlDataSetObserver(ac acVar) {
        if ((acVar instanceof C0977b) && this.dataSetObserver == null) {
            this.dataSetObserver = new C0976a(null);
            acVar.registerDataSetObserver(this.dataSetObserver);
            ((C0977b) acVar).m5058b();
        }
    }

    private void setCurrentItemWithoutNotification(int i) {
        this.suppressOnPageChangeListeners = true;
        setCurrentItem(i, false);
        this.suppressOnPageChangeListeners = false;
    }

    private void unregisterRtlDataSetObserver() {
        ac adapter = super.getAdapter();
        if ((adapter instanceof C0977b) && this.dataSetObserver != null) {
            adapter.unregisterDataSetObserver(this.dataSetObserver);
            this.dataSetObserver = null;
        }
    }

    public void addOnPageChangeListener(C0476f c0476f) {
        if (isRtl()) {
            C0978c c0978c = new C0978c(c0476f, null);
            this.reverseOnPageChangeListeners.put(c0476f, c0978c);
            c0476f = c0978c;
        }
        super.addOnPageChangeListener(c0476f);
    }

    public void fakeDragBy(float f) {
        if (!isRtl()) {
            f = -f;
        }
        super.fakeDragBy(f);
    }

    public ac getAdapter() {
        ac adapter = super.getAdapter();
        return adapter instanceof C0977b ? ((C0977b) adapter).m5055a() : adapter;
    }

    public int getCurrentItem() {
        return convert(super.getCurrentItem());
    }

    protected boolean isRtl() {
        return C0375d.m1382a(getContext().getResources().getConfiguration().locale) == 1;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        registerRtlDataSetObserver(super.getAdapter());
    }

    protected void onDetachedFromWindow() {
        unregisterRtlDataSetObserver();
        super.onDetachedFromWindow();
    }

    public void removeOnPageChangeListener(C0476f c0476f) {
        super.removeOnPageChangeListener(isRtl() ? (C0476f) this.reverseOnPageChangeListeners.remove(c0476f) : c0476f);
    }

    public void setAdapter(ac acVar) {
        unregisterRtlDataSetObserver();
        int i = (acVar == null || !isRtl()) ? 0 : 1;
        if (i != 0) {
            ac c0977b = new C0977b(this, acVar);
            registerRtlDataSetObserver(c0977b);
            acVar = c0977b;
        }
        super.setAdapter(acVar);
        if (i != 0) {
            setCurrentItemWithoutNotification(0);
        }
    }

    public void setCurrentItem(int i) {
        super.setCurrentItem(convert(i));
    }

    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(convert(i), z);
    }
}
