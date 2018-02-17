package com.p043b.p044a;

import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.p016k.ac;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.b.a.a */
class C0974a extends ac {
    private final ac f2527a;

    protected C0974a(ac acVar) {
        this.f2527a = acVar;
    }

    public ac m5055a() {
        return this.f2527a;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        this.f2527a.destroyItem(viewGroup, i, obj);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        this.f2527a.finishUpdate(viewGroup);
    }

    public int getCount() {
        return this.f2527a.getCount();
    }

    public int getItemPosition(Object obj) {
        return this.f2527a.getItemPosition(obj);
    }

    public CharSequence getPageTitle(int i) {
        return this.f2527a.getPageTitle(i);
    }

    public float getPageWidth(int i) {
        return this.f2527a.getPageWidth(i);
    }

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        return this.f2527a.instantiateItem(viewGroup, i);
    }

    public boolean isViewFromObject(View view, Object obj) {
        return this.f2527a.isViewFromObject(view, obj);
    }

    public void notifyDataSetChanged() {
        this.f2527a.notifyDataSetChanged();
    }

    public void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.f2527a.registerDataSetObserver(dataSetObserver);
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        this.f2527a.restoreState(parcelable, classLoader);
    }

    public Parcelable saveState() {
        return this.f2527a.saveState();
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        this.f2527a.setPrimaryItem(viewGroup, i, obj);
    }

    public void startUpdate(ViewGroup viewGroup) {
        this.f2527a.startUpdate(viewGroup);
    }

    public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.f2527a.unregisterDataSetObserver(dataSetObserver);
    }
}
