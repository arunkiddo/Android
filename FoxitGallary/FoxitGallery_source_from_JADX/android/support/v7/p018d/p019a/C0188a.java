package android.support.v7.p018d.p019a;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.v4.p014d.p015a.C0326a;

/* renamed from: android.support.v7.d.a.a */
public class C0188a extends Drawable implements Callback {
    private Drawable f407a;

    public C0188a(Drawable drawable) {
        m684a(drawable);
    }

    public void m684a(Drawable drawable) {
        if (this.f407a != null) {
            this.f407a.setCallback(null);
        }
        this.f407a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
    }

    public Drawable m685b() {
        return this.f407a;
    }

    public void draw(Canvas canvas) {
        this.f407a.draw(canvas);
    }

    public int getChangingConfigurations() {
        return this.f407a.getChangingConfigurations();
    }

    public Drawable getCurrent() {
        return this.f407a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f407a.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f407a.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return this.f407a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f407a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f407a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f407a.getPadding(rect);
    }

    public int[] getState() {
        return this.f407a.getState();
    }

    public Region getTransparentRegion() {
        return this.f407a.getTransparentRegion();
    }

    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    public boolean isAutoMirrored() {
        return C0326a.m1267b(this.f407a);
    }

    public boolean isStateful() {
        return this.f407a.isStateful();
    }

    public void jumpToCurrentState() {
        C0326a.m1258a(this.f407a);
    }

    protected void onBoundsChange(Rect rect) {
        this.f407a.setBounds(rect);
    }

    protected boolean onLevelChange(int i) {
        return this.f407a.setLevel(i);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f407a.setAlpha(i);
    }

    public void setAutoMirrored(boolean z) {
        C0326a.m1266a(this.f407a, z);
    }

    public void setChangingConfigurations(int i) {
        this.f407a.setChangingConfigurations(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f407a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f407a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f407a.setFilterBitmap(z);
    }

    public void setHotspot(float f, float f2) {
        C0326a.m1259a(this.f407a, f, f2);
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        C0326a.m1261a(this.f407a, i, i2, i3, i4);
    }

    public boolean setState(int[] iArr) {
        return this.f407a.setState(iArr);
    }

    public void setTint(int i) {
        C0326a.m1260a(this.f407a, i);
    }

    public void setTintList(ColorStateList colorStateList) {
        C0326a.m1262a(this.f407a, colorStateList);
    }

    public void setTintMode(Mode mode) {
        C0326a.m1265a(this.f407a, mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.f407a.setVisible(z, z2);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
