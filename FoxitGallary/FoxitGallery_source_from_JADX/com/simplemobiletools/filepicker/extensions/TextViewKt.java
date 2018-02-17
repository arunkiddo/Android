package com.simplemobiletools.filepicker.extensions;

import android.widget.TextView;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0078o;

public final class TextViewKt {
    public static final String getValue(TextView textView) {
        C0036f.m62b(textView, "$receiver");
        String obj = textView.getText().toString();
        if (obj != null) {
            return C0078o.m116a(obj).toString();
        }
        throw new C0027d("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
