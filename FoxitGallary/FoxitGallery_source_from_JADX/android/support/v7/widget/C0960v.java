package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.p016k.ah;
import android.support.v7.p034b.C0730a.C0720a;
import android.util.AttributeSet;
import android.widget.RatingBar;

/* renamed from: android.support.v7.widget.v */
public class C0960v extends RatingBar {
    private C0958t f2506a;
    private C0951m f2507b;

    public C0960v(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0720a.ratingBarStyle);
    }

    public C0960v(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2507b = C0951m.m4995a();
        this.f2506a = new C0958t(this, this.f2507b);
        this.f2506a.m5027a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f2506a.m5026a();
        if (a != null) {
            setMeasuredDimension(ah.m1906a(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
