package android.support.p012a.p013a;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.p014d.p015a.C0086o;
import android.support.v4.p014d.p015a.C0326a;
import android.util.AttributeSet;

@TargetApi(21)
/* renamed from: android.support.a.a.e */
abstract class C0087e extends Drawable implements C0086o {
    Drawable f67a;

    C0087e() {
    }

    static TypedArray m138b(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public void applyTheme(Theme theme) {
        if (this.f67a != null) {
            C0326a.m1263a(this.f67a, theme);
        }
    }

    public void clearColorFilter() {
        if (this.f67a != null) {
            this.f67a.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    public ColorFilter getColorFilter() {
        return this.f67a != null ? C0326a.m1271e(this.f67a) : null;
    }

    public Drawable getCurrent() {
        return this.f67a != null ? this.f67a.getCurrent() : super.getCurrent();
    }

    public int getLayoutDirection() {
        if (this.f67a != null) {
            C0326a.m1274h(this.f67a);
        }
        return 0;
    }

    public int getMinimumHeight() {
        return this.f67a != null ? this.f67a.getMinimumHeight() : super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f67a != null ? this.f67a.getMinimumWidth() : super.getMinimumWidth();
    }

    public boolean getPadding(Rect rect) {
        return this.f67a != null ? this.f67a.getPadding(rect) : super.getPadding(rect);
    }

    public int[] getState() {
        return this.f67a != null ? this.f67a.getState() : super.getState();
    }

    public Region getTransparentRegion() {
        return this.f67a != null ? this.f67a.getTransparentRegion() : super.getTransparentRegion();
    }

    public boolean isAutoMirrored() {
        if (this.f67a != null) {
            C0326a.m1267b(this.f67a);
        }
        return false;
    }

    public void jumpToCurrentState() {
        if (this.f67a != null) {
            C0326a.m1258a(this.f67a);
        }
    }

    protected void onBoundsChange(Rect rect) {
        if (this.f67a != null) {
            this.f67a.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.f67a != null ? this.f67a.setLevel(i) : super.onLevelChange(i);
    }

    public void setAutoMirrored(boolean z) {
        if (this.f67a != null) {
            C0326a.m1266a(this.f67a, z);
        }
    }

    public void setChangingConfigurations(int i) {
        if (this.f67a != null) {
            this.f67a.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    public void setColorFilter(int i, Mode mode) {
        if (this.f67a != null) {
            this.f67a.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    public void setFilterBitmap(boolean z) {
        if (this.f67a != null) {
            this.f67a.setFilterBitmap(z);
        }
    }

    public void setHotspot(float f, float f2) {
        if (this.f67a != null) {
            C0326a.m1259a(this.f67a, f, f2);
        }
    }

    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f67a != null) {
            C0326a.m1261a(this.f67a, i, i2, i3, i4);
        }
    }

    public boolean setState(int[] iArr) {
        return this.f67a != null ? this.f67a.setState(iArr) : super.setState(iArr);
    }
}
