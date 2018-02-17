package com.p040a.p041a.p042a;

import android.support.v7.widget.as;
import android.view.View;

/* renamed from: com.a.a.a.c */
public abstract class C0968c extends as implements C0967e {
    private final C0966b mMultiSelector;

    public C0968c(View view, C0966b c0966b) {
        super(view);
        this.mMultiSelector = c0966b;
    }

    protected void onRebind() {
        this.mMultiSelector.m5045a((C0967e) this, getAdapterPosition(), getItemId());
    }
}
