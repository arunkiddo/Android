package android.support.v4.p021b;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.p016k.ac;
import android.support.v4.p021b.C0274o.C0273b;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* renamed from: android.support.v4.b.y */
public abstract class C0295y extends ac {
    private static final boolean DEBUG = false;
    private static final String TAG = "FragmentStatePagerAdapter";
    private C0261z mCurTransaction;
    private C0274o mCurrentPrimaryItem;
    private final C0282t mFragmentManager;
    private ArrayList<C0274o> mFragments;
    private ArrayList<C0273b> mSavedState;

    public C0295y(C0282t c0282t) {
        this.mCurTransaction = null;
        this.mSavedState = new ArrayList();
        this.mFragments = new ArrayList();
        this.mCurrentPrimaryItem = null;
        this.mFragmentManager = c0282t;
    }

    public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
        C0274o c0274o = (C0274o) obj;
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.m1076a();
        }
        while (this.mSavedState.size() <= i) {
            this.mSavedState.add(null);
        }
        this.mSavedState.set(i, c0274o.isAdded() ? this.mFragmentManager.m1073a(c0274o) : null);
        this.mFragments.set(i, null);
        this.mCurTransaction.m934a(c0274o);
    }

    public void finishUpdate(ViewGroup viewGroup) {
        if (this.mCurTransaction != null) {
            this.mCurTransaction.m939d();
            this.mCurTransaction = null;
        }
    }

    public abstract C0274o getItem(int i);

    public Object instantiateItem(ViewGroup viewGroup, int i) {
        if (this.mFragments.size() > i) {
            C0274o c0274o = (C0274o) this.mFragments.get(i);
            if (c0274o != null) {
                return c0274o;
            }
        }
        if (this.mCurTransaction == null) {
            this.mCurTransaction = this.mFragmentManager.m1076a();
        }
        C0274o item = getItem(i);
        if (this.mSavedState.size() > i) {
            C0273b c0273b = (C0273b) this.mSavedState.get(i);
            if (c0273b != null) {
                item.setInitialSavedState(c0273b);
            }
        }
        while (this.mFragments.size() <= i) {
            this.mFragments.add(null);
        }
        item.setMenuVisibility(DEBUG);
        item.setUserVisibleHint(DEBUG);
        this.mFragments.set(i, item);
        this.mCurTransaction.m933a(viewGroup.getId(), item);
        return item;
    }

    public boolean isViewFromObject(View view, Object obj) {
        return ((C0274o) obj).getView() == view ? true : DEBUG;
    }

    public void restoreState(Parcelable parcelable, ClassLoader classLoader) {
        if (parcelable != null) {
            Bundle bundle = (Bundle) parcelable;
            bundle.setClassLoader(classLoader);
            Parcelable[] parcelableArray = bundle.getParcelableArray("states");
            this.mSavedState.clear();
            this.mFragments.clear();
            if (parcelableArray != null) {
                for (Parcelable parcelable2 : parcelableArray) {
                    this.mSavedState.add((C0273b) parcelable2);
                }
            }
            for (String str : bundle.keySet()) {
                if (str.startsWith("f")) {
                    int parseInt = Integer.parseInt(str.substring(1));
                    C0274o a = this.mFragmentManager.m1074a(bundle, str);
                    if (a != null) {
                        while (this.mFragments.size() <= parseInt) {
                            this.mFragments.add(null);
                        }
                        a.setMenuVisibility(DEBUG);
                        this.mFragments.set(parseInt, a);
                    } else {
                        Log.w(TAG, "Bad fragment at key " + str);
                    }
                }
            }
        }
    }

    public Parcelable saveState() {
        Bundle bundle = null;
        if (this.mSavedState.size() > 0) {
            bundle = new Bundle();
            Parcelable[] parcelableArr = new C0273b[this.mSavedState.size()];
            this.mSavedState.toArray(parcelableArr);
            bundle.putParcelableArray("states", parcelableArr);
        }
        Parcelable parcelable = bundle;
        for (int i = 0; i < this.mFragments.size(); i++) {
            C0274o c0274o = (C0274o) this.mFragments.get(i);
            if (c0274o != null && c0274o.isAdded()) {
                if (parcelable == null) {
                    parcelable = new Bundle();
                }
                this.mFragmentManager.m1077a(parcelable, "f" + i, c0274o);
            }
        }
        return parcelable;
    }

    public void setPrimaryItem(ViewGroup viewGroup, int i, Object obj) {
        C0274o c0274o = (C0274o) obj;
        if (c0274o != this.mCurrentPrimaryItem) {
            if (this.mCurrentPrimaryItem != null) {
                this.mCurrentPrimaryItem.setMenuVisibility(DEBUG);
                this.mCurrentPrimaryItem.setUserVisibleHint(DEBUG);
            }
            if (c0274o != null) {
                c0274o.setMenuVisibility(true);
                c0274o.setUserVisibleHint(true);
            }
            this.mCurrentPrimaryItem = c0274o;
        }
    }

    public void startUpdate(ViewGroup viewGroup) {
        if (viewGroup.getId() == -1) {
            throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
        }
    }
}
