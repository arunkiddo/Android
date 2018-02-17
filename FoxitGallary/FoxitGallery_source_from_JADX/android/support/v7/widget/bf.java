package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.p035c.p036a.C0733b;
import android.util.AttributeSet;

public class bf {
    private final Context f2347a;
    private final TypedArray f2348b;

    private bf(Context context, TypedArray typedArray) {
        this.f2347a = context;
        this.f2348b = typedArray;
    }

    public static bf m4772a(Context context, int i, int[] iArr) {
        return new bf(context, context.obtainStyledAttributes(i, iArr));
    }

    public static bf m4773a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new bf(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    public static bf m4774a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new bf(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    public float m4775a(int i, float f) {
        return this.f2348b.getFloat(i, f);
    }

    public int m4776a(int i, int i2) {
        return this.f2348b.getInt(i, i2);
    }

    public Drawable m4777a(int i) {
        if (this.f2348b.hasValue(i)) {
            int resourceId = this.f2348b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0951m.m4995a().m5013a(this.f2347a, resourceId);
            }
        }
        return this.f2348b.getDrawable(i);
    }

    public void m4778a() {
        this.f2348b.recycle();
    }

    public boolean m4779a(int i, boolean z) {
        return this.f2348b.getBoolean(i, z);
    }

    public int m4780b(int i, int i2) {
        return this.f2348b.getColor(i, i2);
    }

    public Drawable m4781b(int i) {
        if (this.f2348b.hasValue(i)) {
            int resourceId = this.f2348b.getResourceId(i, 0);
            if (resourceId != 0) {
                return C0951m.m4995a().m5014a(this.f2347a, resourceId, true);
            }
        }
        return null;
    }

    public int m4782c(int i, int i2) {
        return this.f2348b.getInteger(i, i2);
    }

    public CharSequence m4783c(int i) {
        return this.f2348b.getText(i);
    }

    public int m4784d(int i, int i2) {
        return this.f2348b.getDimensionPixelOffset(i, i2);
    }

    public String m4785d(int i) {
        return this.f2348b.getString(i);
    }

    public int m4786e(int i, int i2) {
        return this.f2348b.getDimensionPixelSize(i, i2);
    }

    public ColorStateList m4787e(int i) {
        if (this.f2348b.hasValue(i)) {
            int resourceId = this.f2348b.getResourceId(i, 0);
            if (resourceId != 0) {
                ColorStateList a = C0733b.m3202a(this.f2347a, resourceId);
                if (a != null) {
                    return a;
                }
            }
        }
        return this.f2348b.getColorStateList(i);
    }

    public int m4788f(int i, int i2) {
        return this.f2348b.getLayoutDimension(i, i2);
    }

    public CharSequence[] m4789f(int i) {
        return this.f2348b.getTextArray(i);
    }

    public int m4790g(int i, int i2) {
        return this.f2348b.getResourceId(i, i2);
    }

    public boolean m4791g(int i) {
        return this.f2348b.hasValue(i);
    }
}
