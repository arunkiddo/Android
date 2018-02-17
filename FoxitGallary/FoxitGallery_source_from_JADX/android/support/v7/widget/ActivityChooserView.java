package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.C0518e;
import android.support.v4.p016k.ah;
import android.support.v7.p034b.C0730a.C0725f;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.p034b.C0730a.C0727h;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public class ActivityChooserView extends ViewGroup {
    C0518e f1738a;
    private final C0800a f1739b;
    private final C0801b f1740c;
    private final ak f1741d;
    private final FrameLayout f1742e;
    private final ImageView f1743f;
    private final FrameLayout f1744g;
    private final int f1745h;
    private final DataSetObserver f1746i;
    private final OnGlobalLayoutListener f1747j;
    private am f1748k;
    private OnDismissListener f1749l;
    private boolean f1750m;
    private int f1751n;
    private boolean f1752o;
    private int f1753p;

    public static class InnerLayout extends ak {
        private static final int[] f1730a;

        static {
            f1730a = new int[]{16842964};
        }

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            bf a = bf.m4773a(context, attributeSet, f1730a);
            setBackgroundDrawable(a.m4777a(0));
            a.m4778a();
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView.a */
    private class C0800a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView f1731a;
        private C0938e f1732b;
        private int f1733c;
        private boolean f1734d;
        private boolean f1735e;
        private boolean f1736f;

        public int m3650a() {
            int i = 0;
            int i2 = this.f1733c;
            this.f1733c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.f1733c = i2;
            return i3;
        }

        public void m3651a(int i) {
            if (this.f1733c != i) {
                this.f1733c = i;
                notifyDataSetChanged();
            }
        }

        public void m3652a(C0938e c0938e) {
            C0938e d = this.f1731a.f1739b.m3657d();
            if (d != null && this.f1731a.isShown()) {
                d.unregisterObserver(this.f1731a.f1746i);
            }
            this.f1732b = c0938e;
            if (c0938e != null && this.f1731a.isShown()) {
                c0938e.registerObserver(this.f1731a.f1746i);
            }
            notifyDataSetChanged();
        }

        public void m3653a(boolean z) {
            if (this.f1736f != z) {
                this.f1736f = z;
                notifyDataSetChanged();
            }
        }

        public void m3654a(boolean z, boolean z2) {
            if (this.f1734d != z || this.f1735e != z2) {
                this.f1734d = z;
                this.f1735e = z2;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo m3655b() {
            return this.f1732b.m4936b();
        }

        public int m3656c() {
            return this.f1732b.m4932a();
        }

        public C0938e m3657d() {
            return this.f1732b;
        }

        public boolean m3658e() {
            return this.f1734d;
        }

        public int getCount() {
            int a = this.f1732b.m4932a();
            if (!(this.f1734d || this.f1732b.m4936b() == null)) {
                a--;
            }
            a = Math.min(a, this.f1733c);
            return this.f1736f ? a + 1 : a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case C1373c.View_android_theme /*0*/:
                    if (!(this.f1734d || this.f1732b.m4936b() == null)) {
                        i++;
                    }
                    return this.f1732b.m4934a(i);
                case C1373c.View_android_focusable /*1*/:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public int getItemViewType(int i) {
            return (this.f1736f && i == getCount() - 1) ? 1 : 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case C1373c.View_android_theme /*0*/:
                    if (view == null || view.getId() != C0725f.list_item) {
                        view = LayoutInflater.from(this.f1731a.getContext()).inflate(C0726g.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1731a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0725f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0725f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1734d && i == 0 && this.f1735e) {
                        ah.m1929c(view, true);
                        return view;
                    }
                    ah.m1929c(view, false);
                    return view;
                case C1373c.View_android_focusable /*1*/:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.f1731a.getContext()).inflate(C0726g.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(C0725f.title)).setText(this.f1731a.getContext().getString(C0727h.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int getViewTypeCount() {
            return 3;
        }
    }

    /* renamed from: android.support.v7.widget.ActivityChooserView.b */
    private class C0801b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView f1737a;

        private void m3659a() {
            if (this.f1737a.f1749l != null) {
                this.f1737a.f1749l.onDismiss();
            }
        }

        public void onClick(View view) {
            if (view == this.f1737a.f1744g) {
                this.f1737a.m3671b();
                Intent b = this.f1737a.f1739b.m3657d().m4935b(this.f1737a.f1739b.m3657d().m4933a(this.f1737a.f1739b.m3655b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.f1737a.getContext().startActivity(b);
                }
            } else if (view == this.f1737a.f1742e) {
                this.f1737a.f1750m = false;
                this.f1737a.m3661a(this.f1737a.f1751n);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public void onDismiss() {
            m3659a();
            if (this.f1737a.f1738a != null) {
                this.f1737a.f1738a.m2278a(false);
            }
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0800a) adapterView.getAdapter()).getItemViewType(i)) {
                case C1373c.View_android_theme /*0*/:
                    this.f1737a.m3671b();
                    if (!this.f1737a.f1750m) {
                        if (!this.f1737a.f1739b.m3658e()) {
                            i++;
                        }
                        Intent b = this.f1737a.f1739b.m3657d().m4935b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.f1737a.getContext().startActivity(b);
                        }
                    } else if (i > 0) {
                        this.f1737a.f1739b.m3657d().m4937c(i);
                    }
                case C1373c.View_android_focusable /*1*/:
                    this.f1737a.m3661a(Integer.MAX_VALUE);
                default:
                    throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f1737a.f1744g) {
                if (this.f1737a.f1739b.getCount() > 0) {
                    this.f1737a.f1750m = true;
                    this.f1737a.m3661a(this.f1737a.f1751n);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }
    }

    private void m3661a(int i) {
        if (this.f1739b.m3657d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1747j);
        boolean z = this.f1744g.getVisibility() == 0;
        int c = this.f1739b.m3656c();
        int i2 = z ? 1 : 0;
        if (i == Integer.MAX_VALUE || c <= i2 + i) {
            this.f1739b.m3653a(false);
            this.f1739b.m3651a(i);
        } else {
            this.f1739b.m3653a(true);
            this.f1739b.m3651a(i - 1);
        }
        am listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.m3696d()) {
            if (this.f1750m || !z) {
                this.f1739b.m3654a(true, z);
            } else {
                this.f1739b.m3654a(false, false);
            }
            listPopupWindow.m3700g(Math.min(this.f1739b.m3650a(), this.f1745h));
            listPopupWindow.m3683a();
            if (this.f1738a != null) {
                this.f1738a.m2278a(true);
            }
            listPopupWindow.m3697e().setContentDescription(getContext().getString(C0727h.abc_activitychooserview_choose_application));
        }
    }

    private am getListPopupWindow() {
        if (this.f1748k == null) {
            this.f1748k = new am(getContext());
            this.f1748k.m3689a(this.f1739b);
            this.f1748k.m3687a((View) this);
            this.f1748k.m3691a(true);
            this.f1748k.m3688a(this.f1740c);
            this.f1748k.m3690a(this.f1740c);
        }
        return this.f1748k;
    }

    public boolean m3670a() {
        if (m3672c() || !this.f1752o) {
            return false;
        }
        this.f1750m = false;
        m3661a(this.f1751n);
        return true;
    }

    public boolean m3671b() {
        if (m3672c()) {
            getListPopupWindow().m3693c();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1747j);
            }
        }
        return true;
    }

    public boolean m3672c() {
        return getListPopupWindow().m3696d();
    }

    public C0938e getDataModel() {
        return this.f1739b.m3657d();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0938e d = this.f1739b.m3657d();
        if (d != null) {
            d.registerObserver(this.f1746i);
        }
        this.f1752o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0938e d = this.f1739b.m3657d();
        if (d != null) {
            d.unregisterObserver(this.f1746i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1747j);
        }
        if (m3672c()) {
            m3671b();
        }
        this.f1752o = false;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1741d.layout(0, 0, i3 - i, i4 - i2);
        if (!m3672c()) {
            m3671b();
        }
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1741d;
        if (this.f1744g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    public void setActivityChooserModel(C0938e c0938e) {
        this.f1739b.m3652a(c0938e);
        if (m3672c()) {
            m3671b();
            m3670a();
        }
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1753p = i;
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1743f.setContentDescription(getContext().getString(i));
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1743f.setImageDrawable(drawable);
    }

    public void setInitialActivityCount(int i) {
        this.f1751n = i;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1749l = onDismissListener;
    }

    public void setProvider(C0518e c0518e) {
        this.f1738a = c0518e;
    }
}
