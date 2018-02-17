package android.support.p012a.p013a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.support.v4.p014d.p015a.C0326a;
import android.support.v4.p030j.C0380a;
import android.util.AttributeSet;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

@TargetApi(21)
/* renamed from: android.support.a.a.b */
public class C0088b extends C0087e implements Animatable {
    private C0084a f68b;
    private Context f69c;
    private ArgbEvaluator f70d;
    private final Callback f71e;

    /* renamed from: android.support.a.a.b.1 */
    class C00831 implements Callback {
        final /* synthetic */ C0088b f61a;

        C00831(C0088b c0088b) {
            this.f61a = c0088b;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f61a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f61a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f61a.unscheduleSelf(runnable);
        }
    }

    /* renamed from: android.support.a.a.b.a */
    private static class C0084a extends ConstantState {
        int f62a;
        C0102f f63b;
        ArrayList<Animator> f64c;
        C0380a<Animator, String> f65d;

        public C0084a(Context context, C0084a c0084a, Callback callback, Resources resources) {
            int i = 0;
            if (c0084a != null) {
                this.f62a = c0084a.f62a;
                if (c0084a.f63b != null) {
                    ConstantState constantState = c0084a.f63b.getConstantState();
                    if (resources != null) {
                        this.f63b = (C0102f) constantState.newDrawable(resources);
                    } else {
                        this.f63b = (C0102f) constantState.newDrawable();
                    }
                    this.f63b = (C0102f) this.f63b.mutate();
                    this.f63b.setCallback(callback);
                    this.f63b.setBounds(c0084a.f63b.getBounds());
                    this.f63b.m211a(false);
                }
                if (c0084a.f64c != null) {
                    int size = c0084a.f64c.size();
                    this.f64c = new ArrayList(size);
                    this.f65d = new C0380a(size);
                    while (i < size) {
                        Animator animator = (Animator) c0084a.f64c.get(i);
                        Animator clone = animator.clone();
                        String str = (String) c0084a.f65d.get(animator);
                        clone.setTarget(this.f63b.m210a(str));
                        this.f64c.add(clone);
                        this.f65d.put(clone, str);
                        i++;
                    }
                }
            }
        }

        public int getChangingConfigurations() {
            return this.f62a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 23.");
        }
    }

    /* renamed from: android.support.a.a.b.b */
    private static class C0085b extends ConstantState {
        private final ConstantState f66a;

        public C0085b(ConstantState constantState) {
            this.f66a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f66a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f66a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            C0088b c0088b = new C0088b();
            c0088b.a = this.f66a.newDrawable();
            c0088b.a.setCallback(c0088b.f71e);
            return c0088b;
        }

        public Drawable newDrawable(Resources resources) {
            C0088b c0088b = new C0088b();
            c0088b.a = this.f66a.newDrawable(resources);
            c0088b.a.setCallback(c0088b.f71e);
            return c0088b;
        }

        public Drawable newDrawable(Resources resources, Theme theme) {
            C0088b c0088b = new C0088b();
            c0088b.a = this.f66a.newDrawable(resources, theme);
            c0088b.a.setCallback(c0088b.f71e);
            return c0088b;
        }
    }

    private C0088b() {
        this(null, null, null);
    }

    private C0088b(Context context) {
        this(context, null, null);
    }

    private C0088b(Context context, C0084a c0084a, Resources resources) {
        this.f70d = null;
        this.f71e = new C00831(this);
        this.f69c = context;
        if (c0084a != null) {
            this.f68b = c0084a;
        } else {
            this.f68b = new C0084a(context, c0084a, this.f71e, resources);
        }
    }

    static TypedArray m139a(Resources resources, Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static C0088b m141a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        C0088b c0088b = new C0088b(context);
        c0088b.inflate(resources, xmlPullParser, attributeSet, theme);
        return c0088b;
    }

    private void m142a(Animator animator) {
        if (animator instanceof AnimatorSet) {
            List childAnimations = ((AnimatorSet) animator).getChildAnimations();
            if (childAnimations != null) {
                for (int i = 0; i < childAnimations.size(); i++) {
                    m142a((Animator) childAnimations.get(i));
                }
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f70d == null) {
                    this.f70d = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f70d);
            }
        }
    }

    private void m143a(String str, Animator animator) {
        animator.setTarget(this.f68b.f63b.m210a(str));
        if (VERSION.SDK_INT < 21) {
            m142a(animator);
        }
        if (this.f68b.f64c == null) {
            this.f68b.f64c = new ArrayList();
            this.f68b.f65d = new C0380a();
        }
        this.f68b.f64c.add(animator);
        this.f68b.f65d.put(animator, str);
    }

    private boolean m144a() {
        ArrayList arrayList = this.f68b.f64c;
        if (arrayList == null) {
            return false;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public void applyTheme(Theme theme) {
        if (this.a != null) {
            C0326a.m1263a(this.a, theme);
        }
    }

    public boolean canApplyTheme() {
        return this.a != null ? C0326a.m1270d(this.a) : false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.a != null) {
            this.a.draw(canvas);
            return;
        }
        this.f68b.f63b.draw(canvas);
        if (m144a()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.a != null ? C0326a.m1269c(this.a) : this.f68b.f63b.getAlpha();
    }

    public int getChangingConfigurations() {
        return this.a != null ? this.a.getChangingConfigurations() : super.getChangingConfigurations() | this.f68b.f62a;
    }

    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    public ConstantState getConstantState() {
        return this.a != null ? new C0085b(this.a.getConstantState()) : null;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.a != null ? this.a.getIntrinsicHeight() : this.f68b.f63b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.a != null ? this.a.getIntrinsicWidth() : this.f68b.f63b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getLayoutDirection() {
        return super.getLayoutDirection();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.a != null ? this.a.getOpacity() : this.f68b.f63b.getOpacity();
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        if (this.a != null) {
            C0326a.m1264a(this.a, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        while (eventType != 1) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                TypedArray a;
                if ("animated-vector".equals(name)) {
                    a = C0088b.m139a(resources, theme, attributeSet, C0082a.f59e);
                    int resourceId = a.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0102f a2 = C0102f.m203a(resources, resourceId, theme);
                        a2.m211a(false);
                        a2.setCallback(this.f71e);
                        if (this.f68b.f63b != null) {
                            this.f68b.f63b.setCallback(null);
                        }
                        this.f68b.f63b = a2;
                    }
                    a.recycle();
                } else if ("target".equals(name)) {
                    a = resources.obtainAttributes(attributeSet, C0082a.f60f);
                    String string = a.getString(0);
                    int resourceId2 = a.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f69c != null) {
                            m143a(string, AnimatorInflater.loadAnimator(this.f69c, resourceId2));
                        } else {
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    a.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isRunning() {
        if (this.a != null) {
            return ((AnimatedVectorDrawable) this.a).isRunning();
        }
        ArrayList arrayList = this.f68b.f64c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (((Animator) arrayList.get(i)).isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStateful() {
        return this.a != null ? this.a.isStateful() : this.f68b.f63b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.a != null) {
            this.a.mutate();
            return this;
        }
        throw new IllegalStateException("Mutate() is not supported for older platform");
    }

    protected void onBoundsChange(Rect rect) {
        if (this.a != null) {
            this.a.setBounds(rect);
        } else {
            this.f68b.f63b.setBounds(rect);
        }
    }

    protected boolean onLevelChange(int i) {
        return this.a != null ? this.a.setLevel(i) : this.f68b.f63b.setLevel(i);
    }

    protected boolean onStateChange(int[] iArr) {
        return this.a != null ? this.a.setState(iArr) : this.f68b.f63b.setState(iArr);
    }

    public void setAlpha(int i) {
        if (this.a != null) {
            this.a.setAlpha(i);
        } else {
            this.f68b.f63b.setAlpha(i);
        }
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.a != null) {
            this.a.setColorFilter(colorFilter);
        } else {
            this.f68b.f63b.setColorFilter(colorFilter);
        }
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.a != null) {
            C0326a.m1260a(this.a, i);
        } else {
            this.f68b.f63b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.a != null) {
            C0326a.m1262a(this.a, colorStateList);
        } else {
            this.f68b.f63b.setTintList(colorStateList);
        }
    }

    public void setTintMode(Mode mode) {
        if (this.a != null) {
            C0326a.m1265a(this.a, mode);
        } else {
            this.f68b.f63b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.a != null) {
            return this.a.setVisible(z, z2);
        }
        this.f68b.f63b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).start();
        } else if (!m144a()) {
            ArrayList arrayList = this.f68b.f64c;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((Animator) arrayList.get(i)).start();
            }
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.a != null) {
            ((AnimatedVectorDrawable) this.a).stop();
            return;
        }
        ArrayList arrayList = this.f68b.f64c;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((Animator) arrayList.get(i)).end();
        }
    }
}
