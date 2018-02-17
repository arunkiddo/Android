package com.p040a.p041a.p042a;

import android.support.v7.view.C0716b;
import android.support.v7.view.C0716b.C0694a;
import android.view.Menu;

/* renamed from: com.a.a.a.a */
public abstract class C0965a implements C0694a {
    private static final String TAG = "modalMultiSelectorCallback";
    private boolean mClearOnPrepare;
    private C0966b mMultiSelector;

    public C0965a(C0966b c0966b) {
        this.mClearOnPrepare = true;
        this.mMultiSelector = c0966b;
    }

    public C0966b getMultiSelector() {
        return this.mMultiSelector;
    }

    public boolean onCreateActionMode(C0716b c0716b, Menu menu) {
        if (this.mClearOnPrepare) {
            this.mMultiSelector.m5049b();
        }
        this.mMultiSelector.m5047a(true);
        return false;
    }

    public void onDestroyActionMode(C0716b c0716b) {
        this.mMultiSelector.m5047a(false);
    }

    public boolean onPrepareActionMode(C0716b c0716b, Menu menu) {
        return false;
    }

    public void setClearOnPrepare(boolean z) {
        this.mClearOnPrepare = z;
    }

    public void setMultiSelector(C0966b c0966b) {
        this.mMultiSelector = c0966b;
    }

    public boolean shouldClearOnPrepare() {
        return this.mClearOnPrepare;
    }
}
