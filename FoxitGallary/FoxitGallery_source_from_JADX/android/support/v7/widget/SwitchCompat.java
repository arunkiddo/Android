package android.support.v7.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region.Op;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.p016k.C0560t;
import android.support.v4.p016k.ah;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0729j;
import android.support.v7.p038f.C0737a;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.CompoundButton;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;

public class SwitchCompat extends CompoundButton {
    private static final int[] f2079N;
    private int f2080A;
    private int f2081B;
    private int f2082C;
    private int f2083D;
    private int f2084E;
    private TextPaint f2085F;
    private ColorStateList f2086G;
    private Layout f2087H;
    private Layout f2088I;
    private TransformationMethod f2089J;
    private C0873a f2090K;
    private final Rect f2091L;
    private final C0951m f2092M;
    private Drawable f2093a;
    private ColorStateList f2094b;
    private Mode f2095c;
    private boolean f2096d;
    private boolean f2097e;
    private Drawable f2098f;
    private ColorStateList f2099g;
    private Mode f2100h;
    private boolean f2101i;
    private boolean f2102j;
    private int f2103k;
    private int f2104l;
    private int f2105m;
    private boolean f2106n;
    private CharSequence f2107o;
    private CharSequence f2108p;
    private boolean f2109q;
    private int f2110r;
    private int f2111s;
    private float f2112t;
    private float f2113u;
    private VelocityTracker f2114v;
    private int f2115w;
    private float f2116x;
    private int f2117y;
    private int f2118z;

    /* renamed from: android.support.v7.widget.SwitchCompat.1 */
    class C08721 implements AnimationListener {
        final /* synthetic */ boolean f2073a;
        final /* synthetic */ SwitchCompat f2074b;

        C08721(SwitchCompat switchCompat, boolean z) {
            this.f2074b = switchCompat;
            this.f2073a = z;
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f2074b.f2090K == animation) {
                this.f2074b.setThumbPosition(this.f2073a ? 1.0f : 0.0f);
                this.f2074b.f2090K = null;
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: android.support.v7.widget.SwitchCompat.a */
    private class C0873a extends Animation {
        final float f2075a;
        final float f2076b;
        final float f2077c;
        final /* synthetic */ SwitchCompat f2078d;

        private C0873a(SwitchCompat switchCompat, float f, float f2) {
            this.f2078d = switchCompat;
            this.f2075a = f;
            this.f2076b = f2;
            this.f2077c = f2 - f;
        }

        protected void applyTransformation(float f, Transformation transformation) {
            this.f2078d.setThumbPosition(this.f2075a + (this.f2077c * f));
        }
    }

    static {
        f2079N = new int[]{16842912};
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2094b = null;
        this.f2095c = null;
        this.f2096d = false;
        this.f2097e = false;
        this.f2099g = null;
        this.f2100h = null;
        this.f2101i = false;
        this.f2102j = false;
        this.f2114v = VelocityTracker.obtain();
        this.f2091L = new Rect();
        this.f2085F = new TextPaint(1);
        Resources resources = getResources();
        this.f2085F.density = resources.getDisplayMetrics().density;
        bf a = bf.m4774a(context, attributeSet, C0729j.SwitchCompat, i, 0);
        this.f2093a = a.m4777a(C0729j.SwitchCompat_android_thumb);
        if (this.f2093a != null) {
            this.f2093a.setCallback(this);
        }
        this.f2098f = a.m4777a(C0729j.SwitchCompat_track);
        if (this.f2098f != null) {
            this.f2098f.setCallback(this);
        }
        this.f2107o = a.m4783c(C0729j.SwitchCompat_android_textOn);
        this.f2108p = a.m4783c(C0729j.SwitchCompat_android_textOff);
        this.f2109q = a.m4779a(C0729j.SwitchCompat_showText, true);
        this.f2103k = a.m4786e(C0729j.SwitchCompat_thumbTextPadding, 0);
        this.f2104l = a.m4786e(C0729j.SwitchCompat_switchMinWidth, 0);
        this.f2105m = a.m4786e(C0729j.SwitchCompat_switchPadding, 0);
        this.f2106n = a.m4779a(C0729j.SwitchCompat_splitTrack, false);
        ColorStateList e = a.m4787e(C0729j.SwitchCompat_thumbTint);
        if (e != null) {
            this.f2094b = e;
            this.f2096d = true;
        }
        Mode a2 = af.m4624a(a.m4776a(C0729j.SwitchCompat_thumbTintMode, -1), null);
        if (this.f2095c != a2) {
            this.f2095c = a2;
            this.f2097e = true;
        }
        if (this.f2096d || this.f2097e) {
            m4427b();
        }
        e = a.m4787e(C0729j.SwitchCompat_trackTint);
        if (e != null) {
            this.f2099g = e;
            this.f2101i = true;
        }
        a2 = af.m4624a(a.m4776a(C0729j.SwitchCompat_trackTintMode, -1), null);
        if (this.f2100h != a2) {
            this.f2100h = a2;
            this.f2102j = true;
        }
        if (this.f2101i || this.f2102j) {
            m4421a();
        }
        int g = a.m4790g(C0729j.SwitchCompat_switchTextAppearance, 0);
        if (g != 0) {
            m4430a(context, g);
        }
        this.f2092M = C0951m.m4995a();
        a.m4778a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f2111s = viewConfiguration.getScaledTouchSlop();
        this.f2115w = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    private static float m4417a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    private Layout m4420a(CharSequence charSequence) {
        CharSequence transformation = this.f2089J != null ? this.f2089J.getTransformation(charSequence, this) : charSequence;
        return new StaticLayout(transformation, this.f2085F, transformation != null ? (int) Math.ceil((double) Layout.getDesiredWidth(transformation, this.f2085F)) : 0, Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    private void m4421a() {
        if (this.f2098f == null) {
            return;
        }
        if (this.f2101i || this.f2102j) {
            this.f2098f = this.f2098f.mutate();
            if (this.f2101i) {
                C0326a.m1262a(this.f2098f, this.f2099g);
            }
            if (this.f2102j) {
                C0326a.m1265a(this.f2098f, this.f2100h);
            }
            if (this.f2098f.isStateful()) {
                this.f2098f.setState(getDrawableState());
            }
        }
    }

    private void m4422a(int i, int i2) {
        Typeface typeface = null;
        switch (i) {
            case C1373c.View_android_focusable /*1*/:
                typeface = Typeface.SANS_SERIF;
                break;
            case C1373c.View_paddingStart /*2*/:
                typeface = Typeface.SERIF;
                break;
            case C1373c.View_paddingEnd /*3*/:
                typeface = Typeface.MONOSPACE;
                break;
        }
        m4431a(typeface, i2);
    }

    private void m4424a(MotionEvent motionEvent) {
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setAction(3);
        super.onTouchEvent(obtain);
        obtain.recycle();
    }

    private void m4425a(boolean z) {
        if (this.f2090K != null) {
            m4429c();
        }
        this.f2090K = new C0873a(this.f2116x, z ? 1.0f : 0.0f, null);
        this.f2090K.setDuration(250);
        this.f2090K.setAnimationListener(new C08721(this, z));
        startAnimation(this.f2090K);
    }

    private boolean m4426a(float f, float f2) {
        if (this.f2093a == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f2093a.getPadding(this.f2091L);
        thumbOffset = (thumbOffset + this.f2081B) - this.f2111s;
        return f > ((float) thumbOffset) && f < ((float) ((((this.f2080A + thumbOffset) + this.f2091L.left) + this.f2091L.right) + this.f2111s)) && f2 > ((float) (this.f2082C - this.f2111s)) && f2 < ((float) (this.f2084E + this.f2111s));
    }

    private void m4427b() {
        if (this.f2093a == null) {
            return;
        }
        if (this.f2096d || this.f2097e) {
            this.f2093a = this.f2093a.mutate();
            if (this.f2096d) {
                C0326a.m1262a(this.f2093a, this.f2094b);
            }
            if (this.f2097e) {
                C0326a.m1265a(this.f2093a, this.f2095c);
            }
            if (this.f2093a.isStateful()) {
                this.f2093a.setState(getDrawableState());
            }
        }
    }

    private void m4428b(MotionEvent motionEvent) {
        boolean z = true;
        this.f2110r = 0;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean isChecked = isChecked();
        if (z2) {
            this.f2114v.computeCurrentVelocity(1000);
            float xVelocity = this.f2114v.getXVelocity();
            if (Math.abs(xVelocity) <= ((float) this.f2115w)) {
                z = getTargetCheckedState();
            } else if (bj.m4867a(this)) {
                if (xVelocity >= 0.0f) {
                    z = false;
                }
            } else if (xVelocity <= 0.0f) {
                z = false;
            }
        } else {
            z = isChecked;
        }
        if (z != isChecked) {
            playSoundEffect(0);
        }
        setChecked(z);
        m4424a(motionEvent);
    }

    private void m4429c() {
        if (this.f2090K != null) {
            clearAnimation();
            this.f2090K = null;
        }
    }

    private boolean getTargetCheckedState() {
        return this.f2116x > 0.5f;
    }

    private int getThumbOffset() {
        return (int) (((bj.m4867a(this) ? 1.0f - this.f2116x : this.f2116x) * ((float) getThumbScrollRange())) + 0.5f);
    }

    private int getThumbScrollRange() {
        if (this.f2098f == null) {
            return 0;
        }
        Rect rect = this.f2091L;
        this.f2098f.getPadding(rect);
        Rect a = this.f2093a != null ? af.m4625a(this.f2093a) : af.f2230a;
        return ((((this.f2117y - this.f2080A) - rect.left) - rect.right) - a.left) - a.right;
    }

    private void setThumbPosition(float f) {
        this.f2116x = f;
        invalidate();
    }

    public void m4430a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, C0729j.TextAppearance);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(C0729j.TextAppearance_android_textColor);
        if (colorStateList != null) {
            this.f2086G = colorStateList;
        } else {
            this.f2086G = getTextColors();
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0729j.TextAppearance_android_textSize, 0);
        if (!(dimensionPixelSize == 0 || ((float) dimensionPixelSize) == this.f2085F.getTextSize())) {
            this.f2085F.setTextSize((float) dimensionPixelSize);
            requestLayout();
        }
        m4422a(obtainStyledAttributes.getInt(C0729j.TextAppearance_android_typeface, -1), obtainStyledAttributes.getInt(C0729j.TextAppearance_android_textStyle, -1));
        if (obtainStyledAttributes.getBoolean(C0729j.TextAppearance_textAllCaps, false)) {
            this.f2089J = new C0737a(getContext());
        } else {
            this.f2089J = null;
        }
        obtainStyledAttributes.recycle();
    }

    public void m4431a(Typeface typeface, int i) {
        boolean z = false;
        if (i > 0) {
            Typeface defaultFromStyle = typeface == null ? Typeface.defaultFromStyle(i) : Typeface.create(typeface, i);
            setSwitchTypeface(defaultFromStyle);
            int style = ((defaultFromStyle != null ? defaultFromStyle.getStyle() : 0) ^ -1) & i;
            TextPaint textPaint = this.f2085F;
            if ((style & 1) != 0) {
                z = true;
            }
            textPaint.setFakeBoldText(z);
            this.f2085F.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.f2085F.setFakeBoldText(false);
        this.f2085F.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void draw(Canvas canvas) {
        int i;
        Rect rect = this.f2091L;
        int i2 = this.f2081B;
        int i3 = this.f2082C;
        int i4 = this.f2083D;
        int i5 = this.f2084E;
        int thumbOffset = i2 + getThumbOffset();
        Rect a = this.f2093a != null ? af.m4625a(this.f2093a) : af.f2230a;
        if (this.f2098f != null) {
            this.f2098f.getPadding(rect);
            int i6 = rect.left + thumbOffset;
            if (a != null) {
                if (a.left > rect.left) {
                    i2 += a.left - rect.left;
                }
                thumbOffset = a.top > rect.top ? (a.top - rect.top) + i3 : i3;
                if (a.right > rect.right) {
                    i4 -= a.right - rect.right;
                }
                i = a.bottom > rect.bottom ? i5 - (a.bottom - rect.bottom) : i5;
            } else {
                i = i5;
                thumbOffset = i3;
            }
            this.f2098f.setBounds(i2, thumbOffset, i4, i);
            i = i6;
        } else {
            i = thumbOffset;
        }
        if (this.f2093a != null) {
            this.f2093a.getPadding(rect);
            i2 = i - rect.left;
            i = (i + this.f2080A) + rect.right;
            this.f2093a.setBounds(i2, i3, i, i5);
            Drawable background = getBackground();
            if (background != null) {
                C0326a.m1261a(background, i2, i3, i, i5);
            }
        }
        super.draw(canvas);
    }

    public void drawableHotspotChanged(float f, float f2) {
        if (VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f2093a != null) {
            C0326a.m1259a(this.f2093a, f, f2);
        }
        if (this.f2098f != null) {
            C0326a.m1259a(this.f2098f, f, f2);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        int i = 0;
        Drawable drawable = this.f2093a;
        if (drawable != null && drawable.isStateful()) {
            i = 0 | drawable.setState(drawableState);
        }
        drawable = this.f2098f;
        if (drawable != null && drawable.isStateful()) {
            i |= drawable.setState(drawableState);
        }
        if (i != 0) {
            invalidate();
        }
    }

    public int getCompoundPaddingLeft() {
        if (!bj.m4867a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f2117y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f2105m : compoundPaddingLeft;
    }

    public int getCompoundPaddingRight() {
        if (bj.m4867a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f2117y;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f2105m : compoundPaddingRight;
    }

    public boolean getShowText() {
        return this.f2109q;
    }

    public boolean getSplitTrack() {
        return this.f2106n;
    }

    public int getSwitchMinWidth() {
        return this.f2104l;
    }

    public int getSwitchPadding() {
        return this.f2105m;
    }

    public CharSequence getTextOff() {
        return this.f2108p;
    }

    public CharSequence getTextOn() {
        return this.f2107o;
    }

    public Drawable getThumbDrawable() {
        return this.f2093a;
    }

    public int getThumbTextPadding() {
        return this.f2103k;
    }

    public ColorStateList getThumbTintList() {
        return this.f2094b;
    }

    public Mode getThumbTintMode() {
        return this.f2095c;
    }

    public Drawable getTrackDrawable() {
        return this.f2098f;
    }

    public ColorStateList getTrackTintList() {
        return this.f2099g;
    }

    public Mode getTrackTintMode() {
        return this.f2100h;
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f2093a != null) {
                this.f2093a.jumpToCurrentState();
            }
            if (this.f2098f != null) {
                this.f2098f.jumpToCurrentState();
            }
            m4429c();
            setThumbPosition(isChecked() ? 1.0f : 0.0f);
        }
    }

    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, f2079N);
        }
        return onCreateDrawableState;
    }

    protected void onDraw(Canvas canvas) {
        int save;
        super.onDraw(canvas);
        Rect rect = this.f2091L;
        Drawable drawable = this.f2098f;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f2082C + rect.top;
        int i2 = this.f2084E - rect.bottom;
        Drawable drawable2 = this.f2093a;
        if (drawable != null) {
            if (!this.f2106n || drawable2 == null) {
                drawable.draw(canvas);
            } else {
                Rect a = af.m4625a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += a.left;
                rect.right -= a.right;
                save = canvas.save();
                canvas.clipRect(rect, Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(save);
            }
        }
        save = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f2087H : this.f2088I;
        if (layout != null) {
            int i3;
            int[] drawableState = getDrawableState();
            if (this.f2086G != null) {
                this.f2085F.setColor(this.f2086G.getColorForState(drawableState, 0));
            }
            this.f2085F.drawableState = drawableState;
            if (drawable2 != null) {
                rect = drawable2.getBounds();
                i3 = rect.right + rect.left;
            } else {
                i3 = getWidth();
            }
            canvas.translate((float) ((i3 / 2) - (layout.getWidth() / 2)), (float) (((i + i2) / 2) - (layout.getHeight() / 2)));
            layout.draw(canvas);
        }
        canvas.restoreToCount(save);
    }

    @TargetApi(14)
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("android.widget.Switch");
            CharSequence charSequence = isChecked() ? this.f2107o : this.f2108p;
            if (!TextUtils.isEmpty(charSequence)) {
                CharSequence text = accessibilityNodeInfo.getText();
                if (TextUtils.isEmpty(text)) {
                    accessibilityNodeInfo.setText(charSequence);
                    return;
                }
                CharSequence stringBuilder = new StringBuilder();
                stringBuilder.append(text).append(' ').append(charSequence);
                accessibilityNodeInfo.setText(stringBuilder);
            }
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int max;
        int paddingLeft;
        int paddingTop;
        int i5 = 0;
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2093a != null) {
            Rect rect = this.f2091L;
            if (this.f2098f != null) {
                this.f2098f.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect a = af.m4625a(this.f2093a);
            max = Math.max(0, a.left - rect.left);
            i5 = Math.max(0, a.right - rect.right);
        } else {
            max = 0;
        }
        if (bj.m4867a(this)) {
            paddingLeft = getPaddingLeft() + max;
            max = ((this.f2117y + paddingLeft) - max) - i5;
            i5 = paddingLeft;
        } else {
            paddingLeft = (getWidth() - getPaddingRight()) - i5;
            i5 += max + (paddingLeft - this.f2117y);
            max = paddingLeft;
        }
        switch (getGravity() & C1373c.AppCompatTheme_spinnerStyle) {
            case C1373c.Toolbar_titleMarginEnd /*16*/:
                paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f2118z / 2);
                paddingLeft = this.f2118z + paddingTop;
                break;
            case C1373c.AppCompatTheme_panelMenuListWidth /*80*/:
                paddingLeft = getHeight() - getPaddingBottom();
                paddingTop = paddingLeft - this.f2118z;
                break;
            default:
                paddingTop = getPaddingTop();
                paddingLeft = this.f2118z + paddingTop;
                break;
        }
        this.f2081B = i5;
        this.f2082C = paddingTop;
        this.f2084E = paddingLeft;
        this.f2083D = max;
    }

    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        int i3 = 0;
        if (this.f2109q) {
            if (this.f2087H == null) {
                this.f2087H = m4420a(this.f2107o);
            }
            if (this.f2088I == null) {
                this.f2088I = m4420a(this.f2108p);
            }
        }
        Rect rect = this.f2091L;
        if (this.f2093a != null) {
            this.f2093a.getPadding(rect);
            intrinsicWidth = (this.f2093a.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f2093a.getIntrinsicHeight();
        } else {
            intrinsicHeight = 0;
            intrinsicWidth = 0;
        }
        this.f2080A = Math.max(this.f2109q ? Math.max(this.f2087H.getWidth(), this.f2088I.getWidth()) + (this.f2103k * 2) : 0, intrinsicWidth);
        if (this.f2098f != null) {
            this.f2098f.getPadding(rect);
            i3 = this.f2098f.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int i4 = rect.left;
        intrinsicWidth = rect.right;
        if (this.f2093a != null) {
            rect = af.m4625a(this.f2093a);
            i4 = Math.max(i4, rect.left);
            intrinsicWidth = Math.max(intrinsicWidth, rect.right);
        }
        intrinsicWidth = Math.max(this.f2104l, intrinsicWidth + (i4 + (this.f2080A * 2)));
        intrinsicHeight = Math.max(i3, intrinsicHeight);
        this.f2117y = intrinsicWidth;
        this.f2118z = intrinsicHeight;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < intrinsicHeight) {
            setMeasuredDimension(ah.m1942i(this), intrinsicHeight);
        }
    }

    @TargetApi(14)
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        Object obj = isChecked() ? this.f2107o : this.f2108p;
        if (obj != null) {
            accessibilityEvent.getText().add(obj);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f2114v.addMovement(motionEvent);
        float x;
        float y;
        switch (C0560t.m2392a(motionEvent)) {
            case C1373c.View_android_theme /*0*/:
                x = motionEvent.getX();
                y = motionEvent.getY();
                if (isEnabled() && m4426a(x, y)) {
                    this.f2110r = 1;
                    this.f2112t = x;
                    this.f2113u = y;
                    break;
                }
            case C1373c.View_android_focusable /*1*/:
            case C1373c.View_paddingEnd /*3*/:
                if (this.f2110r != 2) {
                    this.f2110r = 0;
                    this.f2114v.clear();
                    break;
                }
                m4428b(motionEvent);
                super.onTouchEvent(motionEvent);
                return true;
            case C1373c.View_paddingStart /*2*/:
                switch (this.f2110r) {
                    case C1373c.View_android_theme /*0*/:
                        break;
                    case C1373c.View_android_focusable /*1*/:
                        x = motionEvent.getX();
                        y = motionEvent.getY();
                        if (Math.abs(x - this.f2112t) > ((float) this.f2111s) || Math.abs(y - this.f2113u) > ((float) this.f2111s)) {
                            this.f2110r = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f2112t = x;
                            this.f2113u = y;
                            return true;
                        }
                    case C1373c.View_paddingStart /*2*/:
                        float x2 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x2 - this.f2112t;
                        x = thumbScrollRange != 0 ? f / ((float) thumbScrollRange) : f > 0.0f ? 1.0f : -1.0f;
                        if (bj.m4867a(this)) {
                            x = -x;
                        }
                        x = m4417a(x + this.f2116x, 0.0f, 1.0f);
                        if (x != this.f2116x) {
                            this.f2112t = x2;
                            setThumbPosition(x);
                        }
                        return true;
                    default:
                        break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean isChecked = isChecked();
        if (getWindowToken() != null && ah.m1901D(this) && isShown()) {
            m4425a(isChecked);
            return;
        }
        m4429c();
        setThumbPosition(isChecked ? 1.0f : 0.0f);
    }

    public void setShowText(boolean z) {
        if (this.f2109q != z) {
            this.f2109q = z;
            requestLayout();
        }
    }

    public void setSplitTrack(boolean z) {
        this.f2106n = z;
        invalidate();
    }

    public void setSwitchMinWidth(int i) {
        this.f2104l = i;
        requestLayout();
    }

    public void setSwitchPadding(int i) {
        this.f2105m = i;
        requestLayout();
    }

    public void setSwitchTypeface(Typeface typeface) {
        if (this.f2085F.getTypeface() != typeface) {
            this.f2085F.setTypeface(typeface);
            requestLayout();
            invalidate();
        }
    }

    public void setTextOff(CharSequence charSequence) {
        this.f2108p = charSequence;
        requestLayout();
    }

    public void setTextOn(CharSequence charSequence) {
        this.f2107o = charSequence;
        requestLayout();
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.f2093a != null) {
            this.f2093a.setCallback(null);
        }
        this.f2093a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(this.f2092M.m5013a(getContext(), i));
    }

    public void setThumbTextPadding(int i) {
        this.f2103k = i;
        requestLayout();
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f2094b = colorStateList;
        this.f2096d = true;
        m4427b();
    }

    public void setThumbTintMode(Mode mode) {
        this.f2095c = mode;
        this.f2097e = true;
        m4427b();
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.f2098f != null) {
            this.f2098f.setCallback(null);
        }
        this.f2098f = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(this.f2092M.m5013a(getContext(), i));
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f2099g = colorStateList;
        this.f2101i = true;
        m4421a();
    }

    public void setTrackTintMode(Mode mode) {
        this.f2100h = mode;
        this.f2102j = true;
        m4421a();
    }

    public void toggle() {
        setChecked(!isChecked());
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f2093a || drawable == this.f2098f;
    }
}
