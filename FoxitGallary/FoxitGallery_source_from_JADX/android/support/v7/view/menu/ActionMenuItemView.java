package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.support.v4.p016k.ah;
import android.support.v4.p022c.p023a.C0301a;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.view.menu.C0114p.C0112a;
import android.support.v7.view.menu.C0769h.C0753b;
import android.support.v7.widget.ActionMenuView.C0752a;
import android.support.v7.widget.aa;
import android.support.v7.widget.ai;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Toast;

public class ActionMenuItemView extends aa implements C0112a, C0752a, OnClickListener, OnLongClickListener {
    private C0772j f1438a;
    private CharSequence f1439b;
    private Drawable f1440c;
    private C0753b f1441d;
    private ai f1442e;
    private C0751b f1443f;
    private boolean f1444g;
    private boolean f1445h;
    private int f1446i;
    private int f1447j;
    private int f1448k;

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView.a */
    private class C0750a extends ai {
        final /* synthetic */ ActionMenuItemView f1434a;

        public C0750a(ActionMenuItemView actionMenuItemView) {
            this.f1434a = actionMenuItemView;
            super(actionMenuItemView);
        }

        public C0763s m3288a() {
            return this.f1434a.f1443f != null ? this.f1434a.f1443f.m3290a() : null;
        }

        protected boolean m3289b() {
            if (this.f1434a.f1441d == null || !this.f1434a.f1441d.m3303a(this.f1434a.f1438a)) {
                return false;
            }
            C0763s a = m3288a();
            return a != null && a.m3355d();
        }
    }

    /* renamed from: android.support.v7.view.menu.ActionMenuItemView.b */
    public static abstract class C0751b {
        public abstract C0763s m3290a();
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f1444g = m3296e();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0729j.ActionMenuItemView, i, 0);
        this.f1446i = obtainStyledAttributes.getDimensionPixelSize(C0729j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f1448k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        setOnLongClickListener(this);
        this.f1447j = -1;
        setSaveEnabled(false);
    }

    private boolean m3296e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int b = C0301a.m1171b(getResources());
        return b >= 480 || ((b >= 640 && C0301a.m1170a(getResources()) >= 480) || configuration.orientation == 2);
    }

    private void m3297f() {
        int i = 0;
        int i2 = !TextUtils.isEmpty(this.f1439b) ? 1 : 0;
        if (this.f1440c == null || (this.f1438a.m3504m() && (this.f1444g || this.f1445h))) {
            i = 1;
        }
        setText((i2 & i) != 0 ? this.f1439b : null);
    }

    public void m3298a(C0772j c0772j, int i) {
        this.f1438a = c0772j;
        setIcon(c0772j.getIcon());
        setTitle(c0772j.m3484a((C0112a) this));
        setId(c0772j.getItemId());
        setVisibility(c0772j.isVisible() ? 0 : 8);
        setEnabled(c0772j.isEnabled());
        if (c0772j.hasSubMenu() && this.f1442e == null) {
            this.f1442e = new C0750a(this);
        }
    }

    public boolean m3299a() {
        return true;
    }

    public boolean m3300b() {
        return !TextUtils.isEmpty(getText());
    }

    public boolean m3301c() {
        return m3300b() && this.f1438a.getIcon() == null;
    }

    public boolean m3302d() {
        return m3300b();
    }

    public C0772j getItemData() {
        return this.f1438a;
    }

    public void onClick(View view) {
        if (this.f1441d != null) {
            this.f1441d.m3303a(this.f1438a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        this.f1444g = m3296e();
        m3297f();
    }

    public boolean onLongClick(View view) {
        if (m3300b()) {
            return false;
        }
        int[] iArr = new int[2];
        Rect rect = new Rect();
        getLocationOnScreen(iArr);
        getWindowVisibleDisplayFrame(rect);
        Context context = getContext();
        int width = getWidth();
        int height = getHeight();
        int i = iArr[1] + (height / 2);
        width = (width / 2) + iArr[0];
        if (ah.m1941h(view) == 0) {
            width = context.getResources().getDisplayMetrics().widthPixels - width;
        }
        Toast makeText = Toast.makeText(context, this.f1438a.getTitle(), 0);
        if (i < rect.height()) {
            makeText.setGravity(8388661, width, (iArr[1] + height) - rect.top);
        } else {
            makeText.setGravity(81, 0, height);
        }
        makeText.show();
        return true;
    }

    protected void onMeasure(int i, int i2) {
        boolean b = m3300b();
        if (b && this.f1447j >= 0) {
            super.setPadding(this.f1447j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        size = mode == Integer.MIN_VALUE ? Math.min(size, this.f1446i) : this.f1446i;
        if (mode != 1073741824 && this.f1446i > 0 && measuredWidth < size) {
            super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), i2);
        }
        if (!b && this.f1440c != null) {
            super.setPadding((getMeasuredWidth() - this.f1440c.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.f1438a.hasSubMenu() && this.f1442e != null && this.f1442e.onTouch(this, motionEvent)) ? true : super.onTouchEvent(motionEvent);
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f1445h != z) {
            this.f1445h = z;
            if (this.f1438a != null) {
                this.f1438a.m3499h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f1440c = drawable;
        if (drawable != null) {
            float f;
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f1448k) {
                f = ((float) this.f1448k) / ((float) intrinsicWidth);
                intrinsicWidth = this.f1448k;
                intrinsicHeight = (int) (((float) intrinsicHeight) * f);
            }
            if (intrinsicHeight > this.f1448k) {
                f = ((float) this.f1448k) / ((float) intrinsicHeight);
                intrinsicHeight = this.f1448k;
                intrinsicWidth = (int) (((float) intrinsicWidth) * f);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m3297f();
    }

    public void setItemInvoker(C0753b c0753b) {
        this.f1441d = c0753b;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f1447j = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(C0751b c0751b) {
        this.f1443f = c0751b;
    }

    public void setTitle(CharSequence charSequence) {
        this.f1439b = charSequence;
        setContentDescription(this.f1439b);
        m3297f();
    }
}
