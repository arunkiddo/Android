package android.support.v7.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* renamed from: android.support.v7.widget.w */
public class C0961w extends SeekBar {
    private C0962x f2508a;
    private C0951m f2509b;

    public C0961w(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.seekBarStyle);
    }

    public C0961w(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2509b = C0951m.m4995a();
        this.f2508a = new C0962x(this, this.f2509b);
        this.f2508a.m5031a(attributeSet, i);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.f2508a.m5033c();
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        this.f2508a.m5032b();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f2508a.m5029a(canvas);
    }
}
