package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.C0110a.C0109g;
import android.support.v7.widget.ak;
import android.util.AttributeSet;
import android.view.Gravity;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

/* renamed from: android.support.design.internal.a */
public class C0111a extends ak {
    protected boolean f159a;
    boolean f160b;
    private Drawable f161c;
    private final Rect f162d;
    private final Rect f163e;
    private int f164f;

    public C0111a(Context context) {
        this(context, null);
    }

    public C0111a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public C0111a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f162d = new Rect();
        this.f163e = new Rect();
        this.f164f = 119;
        this.f159a = true;
        this.f160b = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0109g.ForegroundLinearLayout, i, 0);
        this.f164f = obtainStyledAttributes.getInt(C0109g.ForegroundLinearLayout_android_foregroundGravity, this.f164f);
        Drawable drawable = obtainStyledAttributes.getDrawable(C0109g.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.f159a = obtainStyledAttributes.getBoolean(C0109g.ForegroundLinearLayout_foregroundInsidePadding, true);
        obtainStyledAttributes.recycle();
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f161c != null) {
            Drawable drawable = this.f161c;
            if (this.f160b) {
                this.f160b = false;
                Rect rect = this.f162d;
                Rect rect2 = this.f163e;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                if (this.f159a) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                Gravity.apply(this.f164f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    public void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        if (this.f161c != null) {
            this.f161c.setHotspot(f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f161c != null && this.f161c.isStateful()) {
            this.f161c.setState(getDrawableState());
        }
    }

    public Drawable getForeground() {
        return this.f161c;
    }

    public int getForegroundGravity() {
        return this.f164f;
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f161c != null) {
            this.f161c.jumpToCurrentState();
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f160b |= z;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f160b = true;
    }

    public void setForeground(Drawable drawable) {
        if (this.f161c != drawable) {
            if (this.f161c != null) {
                this.f161c.setCallback(null);
                unscheduleDrawable(this.f161c);
            }
            this.f161c = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.f164f == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    public void setForegroundGravity(int i) {
        if (this.f164f != i) {
            int i2 = (8388615 & i) == 0 ? 8388611 | i : i;
            if ((i2 & C1373c.AppCompatTheme_spinnerStyle) == 0) {
                i2 |= 48;
            }
            this.f164f = i2;
            if (this.f164f == 119 && this.f161c != null) {
                this.f161c.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f161c;
    }
}
