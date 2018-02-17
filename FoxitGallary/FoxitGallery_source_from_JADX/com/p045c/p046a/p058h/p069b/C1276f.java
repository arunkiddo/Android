package com.p045c.p046a.p058h.p069b;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.p045c.p046a.p050d.p062d.p065b.C1159b;

/* renamed from: com.c.a.h.b.f */
public class C1276f {
    public <Z> C1195j<Z> m6029a(ImageView imageView, Class<Z> cls) {
        if (C1159b.class.isAssignableFrom(cls)) {
            return new C1275d(imageView);
        }
        if (Bitmap.class.equals(cls)) {
            return new C1273b(imageView);
        }
        if (Drawable.class.isAssignableFrom(cls)) {
            return new C1274c(imageView);
        }
        throw new IllegalArgumentException("Unhandled class: " + cls + ", try .as*(Class).transcode(ResourceTranscoder)");
    }
}
