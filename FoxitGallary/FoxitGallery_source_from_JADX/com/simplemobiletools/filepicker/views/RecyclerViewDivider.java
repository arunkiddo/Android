package com.simplemobiletools.filepicker.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.C0810i;
import android.support.v7.widget.RecyclerView.C0838g;
import android.support.v7.widget.RecyclerView.C0850s;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.simplemobiletools.filepicker.C1328R;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;

public final class RecyclerViewDivider extends C0838g {
    private final Drawable mDivider;

    public RecyclerViewDivider(Context context) {
        C0036f.m62b(context, "context");
        Object drawable = context.getResources().getDrawable(C1328R.drawable.smtfp_divider);
        C0036f.m59a(drawable, "context.resources.getDra\u2026R.drawable.smtfp_divider)");
        this.mDivider = drawable;
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, C0850s c0850s) {
        C0036f.m62b(canvas, "c");
        C0036f.m62b(recyclerView, "parent");
        C0036f.m62b(c0850s, "state");
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount() - 1;
        if (0 <= childCount) {
            int i = 0;
            while (true) {
                View childAt = recyclerView.getChildAt(i);
                LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams == null) {
                    break;
                }
                C0810i c0810i = (C0810i) layoutParams;
                int bottom = c0810i.bottomMargin + childAt.getBottom();
                this.mDivider.setBounds(paddingLeft, bottom, width, this.mDivider.getIntrinsicHeight() + bottom);
                this.mDivider.draw(canvas);
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
            throw new C0027d("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
        }
    }
}
