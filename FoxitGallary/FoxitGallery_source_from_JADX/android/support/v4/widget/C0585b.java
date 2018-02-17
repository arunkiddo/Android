package android.support.v4.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Build.VERSION;
import android.support.v4.p016k.ah;
import android.view.View;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/* renamed from: android.support.v4.widget.b */
class C0585b extends ImageView {
    private AnimationListener f998a;
    private int f999b;

    /* renamed from: android.support.v4.widget.b.a */
    private class C0584a extends OvalShape {
        final /* synthetic */ C0585b f994a;
        private RadialGradient f995b;
        private Paint f996c;
        private int f997d;

        public C0584a(C0585b c0585b, int i, int i2) {
            this.f994a = c0585b;
            this.f996c = new Paint();
            c0585b.f999b = i;
            this.f997d = i2;
            this.f995b = new RadialGradient((float) (this.f997d / 2), (float) (this.f997d / 2), (float) c0585b.f999b, new int[]{1023410176, 0}, null, TileMode.CLAMP);
            this.f996c.setShader(this.f995b);
        }

        public void draw(Canvas canvas, Paint paint) {
            int width = this.f994a.getWidth();
            int height = this.f994a.getHeight();
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) ((this.f997d / 2) + this.f994a.f999b), this.f996c);
            canvas.drawCircle((float) (width / 2), (float) (height / 2), (float) (this.f997d / 2), paint);
        }
    }

    public C0585b(Context context, int i, float f) {
        Drawable shapeDrawable;
        super(context);
        float f2 = getContext().getResources().getDisplayMetrics().density;
        int i2 = (int) ((f * f2) * 2.0f);
        int i3 = (int) (1.75f * f2);
        int i4 = (int) (0.0f * f2);
        this.f999b = (int) (3.5f * f2);
        if (m2575a()) {
            shapeDrawable = new ShapeDrawable(new OvalShape());
            ah.m1938f((View) this, f2 * 4.0f);
        } else {
            shapeDrawable = new ShapeDrawable(new C0584a(this, this.f999b, i2));
            ah.m1912a((View) this, 1, shapeDrawable.getPaint());
            shapeDrawable.getPaint().setShadowLayer((float) this.f999b, (float) i4, (float) i3, 503316480);
            int i5 = this.f999b;
            setPadding(i5, i5, i5, i5);
        }
        shapeDrawable.getPaint().setColor(i);
        setBackgroundDrawable(shapeDrawable);
    }

    private boolean m2575a() {
        return VERSION.SDK_INT >= 21;
    }

    public void m2576a(AnimationListener animationListener) {
        this.f998a = animationListener;
    }

    public void onAnimationEnd() {
        super.onAnimationEnd();
        if (this.f998a != null) {
            this.f998a.onAnimationEnd(getAnimation());
        }
    }

    public void onAnimationStart() {
        super.onAnimationStart();
        if (this.f998a != null) {
            this.f998a.onAnimationStart(getAnimation());
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (!m2575a()) {
            setMeasuredDimension(getMeasuredWidth() + (this.f999b * 2), getMeasuredHeight() + (this.f999b * 2));
        }
    }

    public void setBackgroundColor(int i) {
        if (getBackground() instanceof ShapeDrawable) {
            ((ShapeDrawable) getBackground()).getPaint().setColor(i);
        }
    }
}
