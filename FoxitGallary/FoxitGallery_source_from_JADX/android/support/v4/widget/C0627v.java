package android.support.v4.widget;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: android.support.v4.widget.v */
public abstract class C0627v extends C0598g {
    private int f1065j;
    private int f1066k;
    private LayoutInflater f1067l;

    @Deprecated
    public C0627v(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.f1066k = i;
        this.f1065j = i;
        this.f1067l = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public View m2731a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1067l.inflate(this.f1065j, viewGroup, false);
    }

    public View m2732b(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.f1067l.inflate(this.f1066k, viewGroup, false);
    }
}
