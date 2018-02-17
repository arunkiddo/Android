package com.p045c.p046a.p058h.p069b;

import android.widget.ImageView;
import com.p045c.p046a.p050d.p062d.p065b.C1159b;
import com.p045c.p046a.p058h.p073a.C1261c;

/* renamed from: com.c.a.h.b.d */
public class C1275d extends C1272e<C1159b> {
    private int f3203b;
    private C1159b f3204c;

    public C1275d(ImageView imageView) {
        this(imageView, -1);
    }

    public C1275d(ImageView imageView, int i) {
        super(imageView);
        this.f3203b = i;
    }

    protected void m6026a(C1159b c1159b) {
        ((ImageView) this.a).setImageDrawable(c1159b);
    }

    public void m6027a(C1159b c1159b, C1261c<? super C1159b> c1261c) {
        if (!c1159b.m5669a()) {
            float intrinsicWidth = ((float) c1159b.getIntrinsicWidth()) / ((float) c1159b.getIntrinsicHeight());
            if (Math.abs((((float) ((ImageView) this.a).getWidth()) / ((float) ((ImageView) this.a).getHeight())) - 1.0f) <= 0.05f && Math.abs(intrinsicWidth - 1.0f) <= 0.05f) {
                c1159b = new C1278i(c1159b, ((ImageView) this.a).getWidth());
            }
        }
        super.onResourceReady(c1159b, c1261c);
        this.f3204c = c1159b;
        c1159b.m5668a(this.f3203b);
        c1159b.start();
    }

    public /* synthetic */ void onResourceReady(Object obj, C1261c c1261c) {
        m6027a((C1159b) obj, c1261c);
    }

    public void onStart() {
        if (this.f3204c != null) {
            this.f3204c.start();
        }
    }

    public void onStop() {
        if (this.f3204c != null) {
            this.f3204c.stop();
        }
    }
}
