package com.p045c.p046a.p058h.p069b;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p045c.p046a.p058h.p073a.C1261c;
import com.p045c.p046a.p058h.p073a.C1261c.C1263a;

/* renamed from: com.c.a.h.b.e */
public abstract class C1272e<Z> extends C1271k<ImageView, Z> implements C1263a {
    public C1272e(ImageView imageView) {
        super(imageView);
    }

    public void m6019a(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    protected abstract void m6020a(Z z);

    public Drawable m6021b() {
        return ((ImageView) this.a).getDrawable();
    }

    public void onLoadCleared(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public void onLoadFailed(Exception exception, Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public void onLoadStarted(Drawable drawable) {
        ((ImageView) this.a).setImageDrawable(drawable);
    }

    public void onResourceReady(Z z, C1261c<? super Z> c1261c) {
        if (c1261c == null || !c1261c.m5967a(z, this)) {
            m6020a((Object) z);
        }
    }
}
