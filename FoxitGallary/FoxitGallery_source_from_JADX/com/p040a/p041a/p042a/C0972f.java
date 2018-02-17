package com.p040a.p041a.p042a;

import android.animation.AnimatorInflater;
import android.animation.StateListAnimator;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.View;
import com.p040a.p041a.p042a.C0971d.C0969a;
import com.p040a.p041a.p042a.C0971d.C0970b;

/* renamed from: com.a.a.a.f */
public class C0972f extends C0968c implements C0967e {
    private Drawable mDefaultModeBackgroundDrawable;
    private StateListAnimator mDefaultModeStateListAnimator;
    private boolean mIsSelectable;
    private C0966b mMultiSelector;
    private Drawable mSelectionModeBackgroundDrawable;
    private StateListAnimator mSelectionModeStateListAnimator;

    public C0972f(View view) {
        this(view, null);
    }

    public C0972f(View view, C0966b c0966b) {
        super(view, c0966b);
        this.mIsSelectable = false;
        this.mMultiSelector = c0966b;
        if (VERSION.SDK_INT >= 21) {
            setSelectionModeStateListAnimator(C0972f.getRaiseStateListAnimator(view.getContext()));
            setDefaultModeStateListAnimator(view.getStateListAnimator());
        }
        setSelectionModeBackgroundDrawable(C0972f.getAccentStateDrawable(view.getContext()));
        setDefaultModeBackgroundDrawable(view.getBackground());
    }

    private static Drawable getAccentStateDrawable(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(C0970b.colorAccent, typedValue, true);
        Drawable colorDrawable = new ColorDrawable(typedValue.data);
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16843518}, colorDrawable);
        stateListDrawable.addState(StateSet.WILD_CARD, null);
        return stateListDrawable;
    }

    private static StateListAnimator getRaiseStateListAnimator(Context context) {
        return VERSION.SDK_INT >= 21 ? AnimatorInflater.loadStateListAnimator(context, C0969a.raise) : null;
    }

    private void refreshChrome() {
        Drawable drawable = this.mIsSelectable ? this.mSelectionModeBackgroundDrawable : this.mDefaultModeBackgroundDrawable;
        this.itemView.setBackgroundDrawable(drawable);
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
        if (VERSION.SDK_INT >= 21) {
            StateListAnimator stateListAnimator = this.mIsSelectable ? this.mSelectionModeStateListAnimator : this.mDefaultModeStateListAnimator;
            this.itemView.setStateListAnimator(stateListAnimator);
            if (stateListAnimator != null) {
                stateListAnimator.jumpToCurrentState();
            }
        }
    }

    public Drawable getDefaultModeBackgroundDrawable() {
        return this.mDefaultModeBackgroundDrawable;
    }

    public StateListAnimator getDefaultModeStateListAnimator() {
        return this.mDefaultModeStateListAnimator;
    }

    public Drawable getSelectionModeBackgroundDrawable() {
        return this.mSelectionModeBackgroundDrawable;
    }

    public StateListAnimator getSelectionModeStateListAnimator() {
        return this.mSelectionModeStateListAnimator;
    }

    public boolean isActivated() {
        return this.itemView.isActivated();
    }

    public boolean isSelectable() {
        return this.mIsSelectable;
    }

    public void setActivated(boolean z) {
        this.itemView.setActivated(z);
    }

    public void setDefaultModeBackgroundDrawable(Drawable drawable) {
        this.mDefaultModeBackgroundDrawable = drawable;
        if (!this.mIsSelectable) {
            this.itemView.setBackgroundDrawable(this.mDefaultModeBackgroundDrawable);
        }
    }

    public void setDefaultModeStateListAnimator(int i) {
        if (VERSION.SDK_INT >= 21) {
            setDefaultModeStateListAnimator(AnimatorInflater.loadStateListAnimator(this.itemView.getContext(), i));
        }
    }

    public void setDefaultModeStateListAnimator(StateListAnimator stateListAnimator) {
        this.mDefaultModeStateListAnimator = stateListAnimator;
    }

    public void setSelectable(boolean z) {
        Object obj = z != this.mIsSelectable ? 1 : null;
        this.mIsSelectable = z;
        if (obj != null) {
            refreshChrome();
        }
    }

    public void setSelectionModeBackgroundDrawable(Drawable drawable) {
        this.mSelectionModeBackgroundDrawable = drawable;
        if (this.mIsSelectable) {
            this.itemView.setBackgroundDrawable(drawable);
        }
    }

    public void setSelectionModeStateListAnimator(int i) {
        if (VERSION.SDK_INT >= 21) {
            setSelectionModeStateListAnimator(AnimatorInflater.loadStateListAnimator(this.itemView.getContext(), i));
        }
    }

    public void setSelectionModeStateListAnimator(StateListAnimator stateListAnimator) {
        this.mSelectionModeStateListAnimator = stateListAnimator;
    }
}
