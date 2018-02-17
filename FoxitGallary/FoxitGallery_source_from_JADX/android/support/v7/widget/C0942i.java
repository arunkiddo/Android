package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.p016k.ae;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

/* renamed from: android.support.v7.widget.i */
public class C0942i extends Button implements ae {
    private final C0951m f2453a;
    private final C0941h f2454b;
    private final C0963y f2455c;

    public C0942i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.buttonStyle);
    }

    public C0942i(Context context, AttributeSet attributeSet, int i) {
        super(bc.m4769a(context), attributeSet, i);
        this.f2453a = C0951m.m4995a();
        this.f2454b = new C0941h(this, this.f2453a);
        this.f2454b.m4971a(attributeSet, i);
        this.f2455c = C0963y.m5035a((TextView) this);
        this.f2455c.m5039a(attributeSet, i);
        this.f2455c.m5036a();
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2454b != null) {
            this.f2454b.m4974c();
        }
        if (this.f2455c != null) {
            this.f2455c.m5036a();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2454b != null ? this.f2454b.m4966a() : null;
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2454b != null ? this.f2454b.m4972b() : null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2454b != null) {
            this.f2454b.m4970a(drawable);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2454b != null) {
            this.f2454b.m4967a(i);
        }
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f2455c != null) {
            this.f2455c.m5040a(z);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2454b != null) {
            this.f2454b.m4968a(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2454b != null) {
            this.f2454b.m4969a(mode);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2455c != null) {
            this.f2455c.m5037a(context, i);
        }
    }
}
