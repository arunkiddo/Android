package com.p045c.p046a.p058h.p069b;

import android.graphics.drawable.Drawable;
import com.p045c.p046a.p058h.C1268b;
import com.p045c.p046a.p058h.p073a.C1261c;
import com.p045c.p046a.p068e.C1194h;

/* renamed from: com.c.a.h.b.j */
public interface C1195j<R> extends C1194h {
    C1268b getRequest();

    void getSize(C1269h c1269h);

    void onLoadCleared(Drawable drawable);

    void onLoadFailed(Exception exception, Drawable drawable);

    void onLoadStarted(Drawable drawable);

    void onResourceReady(R r, C1261c<? super R> c1261c);

    void setRequest(C1268b c1268b);
}
