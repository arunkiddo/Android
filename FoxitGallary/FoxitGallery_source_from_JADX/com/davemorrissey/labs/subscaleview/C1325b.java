package com.davemorrissey.labs.subscaleview;

import android.graphics.PointF;
import java.io.Serializable;

/* renamed from: com.davemorrissey.labs.subscaleview.b */
public class C1325b implements Serializable {
    private float f3397a;
    private float f3398b;
    private float f3399c;
    private int f3400d;

    public C1325b(float f, PointF pointF, int i) {
        this.f3397a = f;
        this.f3398b = pointF.x;
        this.f3399c = pointF.y;
        this.f3400d = i;
    }

    public float m6334a() {
        return this.f3397a;
    }

    public PointF m6335b() {
        return new PointF(this.f3398b, this.f3399c);
    }

    public int m6336c() {
        return this.f3400d;
    }
}
