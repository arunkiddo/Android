package android.support.v4.p014d.p015a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;

/* renamed from: android.support.v4.d.a.j */
class C0337j extends Drawable implements Callback, C0334i, C0086o {
    static final Mode f688a;
    C0335a f689b;
    Drawable f690c;
    private int f691d;
    private Mode f692e;
    private boolean f693f;
    private boolean f694g;

    /* renamed from: android.support.v4.d.a.j.a */
    protected static abstract class C0335a extends ConstantState {
        int f684a;
        ConstantState f685b;
        ColorStateList f686c;
        Mode f687d;

        C0335a(C0335a c0335a, Resources resources) {
            this.f686c = null;
            this.f687d = C0337j.f688a;
            if (c0335a != null) {
                this.f684a = c0335a.f684a;
                this.f685b = c0335a.f685b;
                this.f686c = c0335a.f686c;
                this.f687d = c0335a.f687d;
            }
        }

        boolean m1303a() {
            return this.f685b != null;
        }

        public int getChangingConfigurations() {
            return (this.f685b != null ? this.f685b.getChangingConfigurations() : 0) | this.f684a;
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public abstract Drawable newDrawable(Resources resources);
    }

    /* renamed from: android.support.v4.d.a.j.b */
    private static class C0336b extends C0335a {
        C0336b(C0335a c0335a, Resources resources) {
            super(c0335a, resources);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0337j(this, resources);
        }
    }

    static {
        f688a = Mode.SRC_IN;
    }

    C0337j(Drawable drawable) {
        this.f689b = m1309b();
        m1308a(drawable);
    }

    C0337j(C0335a c0335a, Resources resources) {
        this.f689b = c0335a;
        m1304a(resources);
    }

    private void m1304a(Resources resources) {
        if (this.f689b != null && this.f689b.f685b != null) {
            m1308a(m1307a(this.f689b.f685b, resources));
        }
    }

    private boolean m1305a(int[] iArr) {
        if (!m1310c()) {
            return false;
        }
        ColorStateList colorStateList = this.f689b.f686c;
        Mode mode = this.f689b.f687d;
        if (colorStateList == null || mode == null) {
            this.f693f = false;
            clearColorFilter();
            return false;
        }
        int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
        if (this.f693f && colorForState == this.f691d && mode == this.f692e) {
            return false;
        }
        setColorFilter(colorForState, mode);
        this.f691d = colorForState;
        this.f692e = mode;
        this.f693f = true;
        return true;
    }

    public final Drawable m1306a() {
        return this.f690c;
    }

    protected Drawable m1307a(ConstantState constantState, Resources resources) {
        return constantState.newDrawable();
    }

    public final void m1308a(Drawable drawable) {
        if (this.f690c != null) {
            this.f690c.setCallback(null);
        }
        this.f690c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            drawable.setVisible(isVisible(), true);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (this.f689b != null) {
                this.f689b.f685b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    C0335a m1309b() {
        return new C0336b(this.f689b, null);
    }

    protected boolean m1310c() {
        return true;
    }

    public void draw(Canvas canvas) {
        this.f690c.draw(canvas);
    }

    public int getChangingConfigurations() {
        return ((this.f689b != null ? this.f689b.getChangingConfigurations() : 0) | super.getChangingConfigurations()) | this.f690c.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        if (this.f689b == null || !this.f689b.m1303a()) {
            return null;
        }
        this.f689b.f684a = getChangingConfigurations();
        return this.f689b;
    }

    public Drawable getCurrent() {
        return this.f690c.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f690c.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f690c.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f690c.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f690c.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f690c.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f690c.getPadding(rect);
    }

    public int[] getState() {
        return this.f690c.getState();
    }

    public Region getTransparentRegion() {
        return this.f690c.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isStateful() {
        ColorStateList colorStateList = (!m1310c() || this.f689b == null) ? null : this.f689b.f686c;
        return (colorStateList != null && colorStateList.isStateful()) || this.f690c.isStateful();
    }

    public Drawable mutate() {
        if (!this.f694g && super.mutate() == this) {
            this.f689b = m1309b();
            if (this.f690c != null) {
                this.f690c.mutate();
            }
            if (this.f689b != null) {
                this.f689b.f685b = this.f690c != null ? this.f690c.getConstantState() : null;
            }
            this.f694g = true;
        }
        return this;
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f690c != null) {
            this.f690c.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f690c.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f690c.setAlpha(i);
    }

    public void setChangingConfigurations(int i) {
        this.f690c.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f690c.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f690c.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f690c.setFilterBitmap(z);
    }

    public boolean setState(int[] iArr) {
        return m1305a(iArr) || this.f690c.setState(iArr);
    }

    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    public void setTintList(ColorStateList colorStateList) {
        this.f689b.f686c = colorStateList;
        m1305a(getState());
    }

    public void setTintMode(Mode mode) {
        this.f689b.f687d = mode;
        m1305a(getState());
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f690c.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
