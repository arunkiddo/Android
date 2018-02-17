package com.p045c.p046a.p058h.p069b;

import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import com.p045c.p046a.p050d.p062d.p065b.C1159b;

/* renamed from: com.c.a.h.b.i */
public class C1278i extends C1159b {
    private C1159b f3207a;
    private C1277a f3208b;
    private boolean f3209c;

    /* renamed from: com.c.a.h.b.i.a */
    static class C1277a extends ConstantState {
        private final ConstantState f3205a;
        private final int f3206b;

        C1277a(ConstantState constantState, int i) {
            this.f3205a = constantState;
            this.f3206b = i;
        }

        C1277a(C1277a c1277a) {
            this(c1277a.f3205a, c1277a.f3206b);
        }

        public int getChangingConfigurations() {
            return 0;
        }

        public Drawable newDrawable() {
            return newDrawable(null);
        }

        public Drawable newDrawable(Resources resources) {
            return new C1278i(this, null, resources);
        }
    }

    public C1278i(C1159b c1159b, int i) {
        this(new C1277a(c1159b.getConstantState(), i), c1159b, null);
    }

    C1278i(C1277a c1277a, C1159b c1159b, Resources resources) {
        this.f3208b = c1277a;
        if (c1159b != null) {
            this.f3207a = c1159b;
        } else if (resources != null) {
            this.f3207a = (C1159b) c1277a.f3205a.newDrawable(resources);
        } else {
            this.f3207a = (C1159b) c1277a.f3205a.newDrawable();
        }
    }

    public void m6032a(int i) {
        this.f3207a.m5668a(i);
    }

    public boolean m6033a() {
        return this.f3207a.m5669a();
    }

    public void clearColorFilter() {
        this.f3207a.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        this.f3207a.draw(canvas);
    }

    @TargetApi(19)
    public int getAlpha() {
        return this.f3207a.getAlpha();
    }

    @TargetApi(11)
    public Callback getCallback() {
        return this.f3207a.getCallback();
    }

    public int getChangingConfigurations() {
        return this.f3207a.getChangingConfigurations();
    }

    public ConstantState getConstantState() {
        return this.f3208b;
    }

    public Drawable getCurrent() {
        return this.f3207a.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f3208b.f3206b;
    }

    public int getIntrinsicWidth() {
        return this.f3208b.f3206b;
    }

    public int getMinimumHeight() {
        return this.f3207a.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return this.f3207a.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f3207a.getOpacity();
    }

    public boolean getPadding(Rect rect) {
        return this.f3207a.getPadding(rect);
    }

    public void invalidateSelf() {
        super.invalidateSelf();
        this.f3207a.invalidateSelf();
    }

    public boolean isRunning() {
        return this.f3207a.isRunning();
    }

    public Drawable mutate() {
        if (!this.f3209c && super.mutate() == this) {
            this.f3207a = (C1159b) this.f3207a.mutate();
            this.f3208b = new C1277a(this.f3208b);
            this.f3209c = true;
        }
        return this;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        super.scheduleSelf(runnable, j);
        this.f3207a.scheduleSelf(runnable, j);
    }

    public void setAlpha(int i) {
        this.f3207a.setAlpha(i);
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.f3207a.setBounds(i, i2, i3, i4);
    }

    public void setBounds(Rect rect) {
        super.setBounds(rect);
        this.f3207a.setBounds(rect);
    }

    public void setChangingConfigurations(int i) {
        this.f3207a.setChangingConfigurations(i);
    }

    public void setColorFilter(int i, Mode mode) {
        this.f3207a.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f3207a.setColorFilter(colorFilter);
    }

    public void setDither(boolean z) {
        this.f3207a.setDither(z);
    }

    public void setFilterBitmap(boolean z) {
        this.f3207a.setFilterBitmap(z);
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.f3207a.setVisible(z, z2);
    }

    public void start() {
        this.f3207a.start();
    }

    public void stop() {
        this.f3207a.stop();
    }

    public void unscheduleSelf(Runnable runnable) {
        super.unscheduleSelf(runnable);
        this.f3207a.unscheduleSelf(runnable);
    }
}
