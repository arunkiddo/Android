package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p016k.ae;
import android.support.v4.p016k.ah;
import android.support.v4.p022c.C0225a;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0726g;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.C0741d;
import android.support.v7.view.menu.C0763s;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;

public class AppCompatSpinner extends Spinner implements ae {
    private static final boolean f1801a;
    private static final boolean f1802b;
    private static final int[] f1803c;
    private C0951m f1804d;
    private C0941h f1805e;
    private Context f1806f;
    private ai f1807g;
    private SpinnerAdapter f1808h;
    private boolean f1809i;
    private C0807b f1810j;
    private int f1811k;
    private final Rect f1812l;

    /* renamed from: android.support.v7.widget.AppCompatSpinner.1 */
    class C08021 extends ai {
        final /* synthetic */ C0807b f1754a;
        final /* synthetic */ AppCompatSpinner f1755b;

        C08021(AppCompatSpinner appCompatSpinner, View view, C0807b c0807b) {
            this.f1755b = appCompatSpinner;
            this.f1754a = c0807b;
            super(view);
        }

        public C0763s m3673a() {
            return this.f1754a;
        }

        public boolean m3674b() {
            if (!this.f1755b.f1810j.m3696d()) {
                this.f1755b.f1810j.m3715a();
            }
            return true;
        }
    }

    /* renamed from: android.support.v7.widget.AppCompatSpinner.a */
    private static class C0803a implements ListAdapter, SpinnerAdapter {
        private SpinnerAdapter f1756a;
        private ListAdapter f1757b;

        public C0803a(SpinnerAdapter spinnerAdapter, Theme theme) {
            this.f1756a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f1757b = (ListAdapter) spinnerAdapter;
            }
            if (theme == null) {
                return;
            }
            if (AppCompatSpinner.f1801a && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                    themedSpinnerAdapter.setDropDownViewTheme(theme);
                }
            } else if (spinnerAdapter instanceof bb) {
                bb bbVar = (bb) spinnerAdapter;
                if (bbVar.m4767a() == null) {
                    bbVar.m4768a(theme);
                }
            }
        }

        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f1757b;
            return listAdapter != null ? listAdapter.areAllItemsEnabled() : true;
        }

        public int getCount() {
            return this.f1756a == null ? 0 : this.f1756a.getCount();
        }

        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            return this.f1756a == null ? null : this.f1756a.getDropDownView(i, view, viewGroup);
        }

        public Object getItem(int i) {
            return this.f1756a == null ? null : this.f1756a.getItem(i);
        }

        public long getItemId(int i) {
            return this.f1756a == null ? -1 : this.f1756a.getItemId(i);
        }

        public int getItemViewType(int i) {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        public int getViewTypeCount() {
            return 1;
        }

        public boolean hasStableIds() {
            return this.f1756a != null && this.f1756a.hasStableIds();
        }

        public boolean isEmpty() {
            return getCount() == 0;
        }

        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f1757b;
            return listAdapter != null ? listAdapter.isEnabled(i) : true;
        }

        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1756a != null) {
                this.f1756a.registerDataSetObserver(dataSetObserver);
            }
        }

        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f1756a != null) {
                this.f1756a.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* renamed from: android.support.v7.widget.AppCompatSpinner.b */
    private class C0807b extends am {
        final /* synthetic */ AppCompatSpinner f1797a;
        private CharSequence f1798d;
        private ListAdapter f1799e;
        private final Rect f1800f;

        /* renamed from: android.support.v7.widget.AppCompatSpinner.b.1 */
        class C08041 implements OnItemClickListener {
            final /* synthetic */ AppCompatSpinner f1758a;
            final /* synthetic */ C0807b f1759b;

            C08041(C0807b c0807b, AppCompatSpinner appCompatSpinner) {
                this.f1759b = c0807b;
                this.f1758a = appCompatSpinner;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.f1759b.f1797a.setSelection(i);
                if (this.f1759b.f1797a.getOnItemClickListener() != null) {
                    this.f1759b.f1797a.performItemClick(view, i, this.f1759b.f1799e.getItemId(i));
                }
                this.f1759b.m3693c();
            }
        }

        /* renamed from: android.support.v7.widget.AppCompatSpinner.b.2 */
        class C08052 implements OnGlobalLayoutListener {
            final /* synthetic */ C0807b f1760a;

            C08052(C0807b c0807b) {
                this.f1760a = c0807b;
            }

            public void onGlobalLayout() {
                if (this.f1760a.m3714b(this.f1760a.f1797a)) {
                    this.f1760a.m3719f();
                    super.m3683a();
                    return;
                }
                this.f1760a.m3693c();
            }
        }

        /* renamed from: android.support.v7.widget.AppCompatSpinner.b.3 */
        class C08063 implements OnDismissListener {
            final /* synthetic */ OnGlobalLayoutListener f1761a;
            final /* synthetic */ C0807b f1762b;

            C08063(C0807b c0807b, OnGlobalLayoutListener onGlobalLayoutListener) {
                this.f1762b = c0807b;
                this.f1761a = onGlobalLayoutListener;
            }

            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = this.f1762b.f1797a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.f1761a);
                }
            }
        }

        public C0807b(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i) {
            this.f1797a = appCompatSpinner;
            super(context, attributeSet, i);
            this.f1800f = new Rect();
            m3687a((View) appCompatSpinner);
            m3691a(true);
            m3684a(0);
            m3688a(new C08041(this, appCompatSpinner));
        }

        private boolean m3714b(View view) {
            return ah.m1903F(view) && view.getGlobalVisibleRect(this.f1800f);
        }

        public void m3715a() {
            boolean d = m3696d();
            m3719f();
            m3703h(2);
            super.m3683a();
            m3697e().setChoiceMode(1);
            m3705i(this.f1797a.getSelectedItemPosition());
            if (!d) {
                ViewTreeObserver viewTreeObserver = this.f1797a.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    OnGlobalLayoutListener c08052 = new C08052(this);
                    viewTreeObserver.addOnGlobalLayoutListener(c08052);
                    m3690a(new C08063(this, c08052));
                }
            }
        }

        public void m3716a(ListAdapter listAdapter) {
            super.m3689a(listAdapter);
            this.f1799e = listAdapter;
        }

        public void m3717a(CharSequence charSequence) {
            this.f1798d = charSequence;
        }

        public CharSequence m3718b() {
            return this.f1798d;
        }

        void m3719f() {
            int i;
            Drawable h = m3702h();
            if (h != null) {
                h.getPadding(this.f1797a.f1812l);
                i = bj.m4867a(this.f1797a) ? this.f1797a.f1812l.right : -this.f1797a.f1812l.left;
            } else {
                Rect b = this.f1797a.f1812l;
                this.f1797a.f1812l.right = 0;
                b.left = 0;
                i = 0;
            }
            int paddingLeft = this.f1797a.getPaddingLeft();
            int paddingRight = this.f1797a.getPaddingRight();
            int width = this.f1797a.getWidth();
            if (this.f1797a.f1811k == -2) {
                int a = this.f1797a.m3721a((SpinnerAdapter) this.f1799e, m3702h());
                int i2 = (this.f1797a.getContext().getResources().getDisplayMetrics().widthPixels - this.f1797a.f1812l.left) - this.f1797a.f1812l.right;
                if (a <= i2) {
                    i2 = a;
                }
                m3700g(Math.max(i2, (width - paddingLeft) - paddingRight));
            } else if (this.f1797a.f1811k == -1) {
                m3700g((width - paddingLeft) - paddingRight);
            } else {
                m3700g(this.f1797a.f1811k);
            }
            m3694c(bj.m4867a(this.f1797a) ? ((width - paddingRight) - m3708l()) + i : i + paddingLeft);
        }
    }

    static {
        f1801a = VERSION.SDK_INT >= 23;
        f1802b = VERSION.SDK_INT >= 16;
        f1803c = new int[]{16843505};
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public AppCompatSpinner(Context context, int i) {
        this(context, null, C0720a.spinnerStyle, i);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2, Theme theme) {
        TypedArray obtainStyledAttributes;
        Throwable e;
        C0807b c0807b;
        bf a;
        CharSequence[] f;
        SpinnerAdapter arrayAdapter;
        super(context, attributeSet, i);
        this.f1812l = new Rect();
        bf a2 = bf.m4774a(context, attributeSet, C0729j.Spinner, i, 0);
        this.f1804d = C0951m.m4995a();
        this.f1805e = new C0941h(this, this.f1804d);
        if (theme != null) {
            this.f1806f = new C0741d(context, theme);
        } else {
            int g = a2.m4790g(C0729j.Spinner_popupTheme, 0);
            if (g != 0) {
                this.f1806f = new C0741d(context, g);
            } else {
                this.f1806f = !f1801a ? context : null;
            }
        }
        if (this.f1806f != null) {
            if (i2 == -1) {
                if (VERSION.SDK_INT >= 11) {
                    try {
                        obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1803c, i, 0);
                        try {
                            if (obtainStyledAttributes.hasValue(0)) {
                                i2 = obtainStyledAttributes.getInt(0, 0);
                            }
                            if (obtainStyledAttributes != null) {
                                obtainStyledAttributes.recycle();
                            }
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                if (i2 == 1) {
                                    c0807b = new C0807b(this, this.f1806f, attributeSet, i);
                                    a = bf.m4774a(this.f1806f, attributeSet, C0729j.Spinner, i, 0);
                                    this.f1811k = a.m4788f(C0729j.Spinner_android_dropDownWidth, -2);
                                    c0807b.m3686a(a.m4777a(C0729j.Spinner_android_popupBackground));
                                    c0807b.m3717a(a2.m4785d(C0729j.Spinner_android_prompt));
                                    a.m4778a();
                                    this.f1810j = c0807b;
                                    this.f1807g = new C08021(this, this, c0807b);
                                }
                                f = a2.m4789f(C0729j.Spinner_android_entries);
                                if (f != null) {
                                    arrayAdapter = new ArrayAdapter(context, 17367048, f);
                                    arrayAdapter.setDropDownViewResource(C0726g.support_simple_spinner_dropdown_item);
                                    setAdapter(arrayAdapter);
                                }
                                a2.m4778a();
                                this.f1809i = true;
                                if (this.f1808h != null) {
                                    setAdapter(this.f1808h);
                                    this.f1808h = null;
                                }
                                this.f1805e.m4971a(attributeSet, i);
                            } catch (Throwable th) {
                                e = th;
                                if (obtainStyledAttributes != null) {
                                    obtainStyledAttributes.recycle();
                                }
                                throw e;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        obtainStyledAttributes = null;
                        Log.i("AppCompatSpinner", "Could not read android:spinnerMode", e);
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        if (i2 == 1) {
                            c0807b = new C0807b(this, this.f1806f, attributeSet, i);
                            a = bf.m4774a(this.f1806f, attributeSet, C0729j.Spinner, i, 0);
                            this.f1811k = a.m4788f(C0729j.Spinner_android_dropDownWidth, -2);
                            c0807b.m3686a(a.m4777a(C0729j.Spinner_android_popupBackground));
                            c0807b.m3717a(a2.m4785d(C0729j.Spinner_android_prompt));
                            a.m4778a();
                            this.f1810j = c0807b;
                            this.f1807g = new C08021(this, this, c0807b);
                        }
                        f = a2.m4789f(C0729j.Spinner_android_entries);
                        if (f != null) {
                            arrayAdapter = new ArrayAdapter(context, 17367048, f);
                            arrayAdapter.setDropDownViewResource(C0726g.support_simple_spinner_dropdown_item);
                            setAdapter(arrayAdapter);
                        }
                        a2.m4778a();
                        this.f1809i = true;
                        if (this.f1808h != null) {
                            setAdapter(this.f1808h);
                            this.f1808h = null;
                        }
                        this.f1805e.m4971a(attributeSet, i);
                    } catch (Throwable th2) {
                        e = th2;
                        obtainStyledAttributes = null;
                        if (obtainStyledAttributes != null) {
                            obtainStyledAttributes.recycle();
                        }
                        throw e;
                    }
                }
                i2 = 1;
            }
            if (i2 == 1) {
                c0807b = new C0807b(this, this.f1806f, attributeSet, i);
                a = bf.m4774a(this.f1806f, attributeSet, C0729j.Spinner, i, 0);
                this.f1811k = a.m4788f(C0729j.Spinner_android_dropDownWidth, -2);
                c0807b.m3686a(a.m4777a(C0729j.Spinner_android_popupBackground));
                c0807b.m3717a(a2.m4785d(C0729j.Spinner_android_prompt));
                a.m4778a();
                this.f1810j = c0807b;
                this.f1807g = new C08021(this, this, c0807b);
            }
        }
        f = a2.m4789f(C0729j.Spinner_android_entries);
        if (f != null) {
            arrayAdapter = new ArrayAdapter(context, 17367048, f);
            arrayAdapter.setDropDownViewResource(C0726g.support_simple_spinner_dropdown_item);
            setAdapter(arrayAdapter);
        }
        a2.m4778a();
        this.f1809i = true;
        if (this.f1808h != null) {
            setAdapter(this.f1808h);
            this.f1808h = null;
        }
        this.f1805e.m4971a(attributeSet, i);
    }

    private int m3721a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int max2 = Math.max(0, max - (15 - (min - max)));
        View view = null;
        int i = 0;
        max = 0;
        while (max2 < min) {
            View view2;
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != max) {
                view2 = null;
            } else {
                itemViewType = max;
                view2 = view;
            }
            view = spinnerAdapter.getView(max2, view2, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i = Math.max(i, view.getMeasuredWidth());
            max2++;
            max = itemViewType;
        }
        if (drawable == null) {
            return i;
        }
        drawable.getPadding(this.f1812l);
        return (this.f1812l.left + this.f1812l.right) + i;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1805e != null) {
            this.f1805e.m4974c();
        }
    }

    public int getDropDownHorizontalOffset() {
        return this.f1810j != null ? this.f1810j.m3706j() : f1802b ? super.getDropDownHorizontalOffset() : 0;
    }

    public int getDropDownVerticalOffset() {
        return this.f1810j != null ? this.f1810j.m3707k() : f1802b ? super.getDropDownVerticalOffset() : 0;
    }

    public int getDropDownWidth() {
        return this.f1810j != null ? this.f1811k : f1802b ? super.getDropDownWidth() : 0;
    }

    public Drawable getPopupBackground() {
        return this.f1810j != null ? this.f1810j.m3702h() : f1802b ? super.getPopupBackground() : null;
    }

    public Context getPopupContext() {
        return this.f1810j != null ? this.f1806f : f1801a ? super.getPopupContext() : null;
    }

    public CharSequence getPrompt() {
        return this.f1810j != null ? this.f1810j.m3718b() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1805e != null ? this.f1805e.m4966a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1805e != null ? this.f1805e.m4972b() : null;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f1810j != null && this.f1810j.m3696d()) {
            this.f1810j.m3693c();
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1810j != null && MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
            setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m3721a(getAdapter(), getBackground())), MeasureSpec.getSize(i)), getMeasuredHeight());
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f1807g == null || !this.f1807g.onTouch(this, motionEvent)) ? super.onTouchEvent(motionEvent) : true;
    }

    public boolean performClick() {
        if (this.f1810j == null) {
            return super.performClick();
        }
        if (!this.f1810j.m3696d()) {
            this.f1810j.m3715a();
        }
        return true;
    }

    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (this.f1809i) {
            super.setAdapter(spinnerAdapter);
            if (this.f1810j != null) {
                this.f1810j.m3716a(new C0803a(spinnerAdapter, (this.f1806f == null ? getContext() : this.f1806f).getTheme()));
                return;
            }
            return;
        }
        this.f1808h = spinnerAdapter;
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1805e != null) {
            this.f1805e.m4970a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1805e != null) {
            this.f1805e.m4967a(i);
        }
    }

    public void setDropDownHorizontalOffset(int i) {
        if (this.f1810j != null) {
            this.f1810j.m3694c(i);
        } else if (f1802b) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    public void setDropDownVerticalOffset(int i) {
        if (this.f1810j != null) {
            this.f1810j.m3695d(i);
        } else if (f1802b) {
            super.setDropDownVerticalOffset(i);
        }
    }

    public void setDropDownWidth(int i) {
        if (this.f1810j != null) {
            this.f1811k = i;
        } else if (f1802b) {
            super.setDropDownWidth(i);
        }
    }

    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f1810j != null) {
            this.f1810j.m3686a(drawable);
        } else if (f1802b) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C0225a.m808a(getPopupContext(), i));
    }

    public void setPrompt(CharSequence charSequence) {
        if (this.f1810j != null) {
            this.f1810j.m3717a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1805e != null) {
            this.f1805e.m4968a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1805e != null) {
            this.f1805e.m4969a(mode);
        }
    }
}
