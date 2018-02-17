package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.C0853v;
import android.view.View;

public abstract class as extends C0853v {
    public as(View view) {
        super(view);
    }

    private void checkFlags(int i) {
        if (isRelevantFlagSet(i)) {
            onRebind();
        }
    }

    private static boolean isRelevantFlagSet(int i) {
        for (int valueOf : new int[]{1, 64, 2, 32}) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            if ((valueOf2.intValue() & i) == valueOf2.intValue()) {
                return true;
            }
        }
        return false;
    }

    void addFlags(int i) {
        super.addFlags(i);
        checkFlags(i);
    }

    void offsetPosition(int i, boolean z) {
        super.offsetPosition(i, z);
        onRebind();
    }

    protected abstract void onRebind();

    void setFlags(int i, int i2) {
        super.setFlags(i, i2);
        checkFlags(i2 & i);
    }
}
