package com.simplemobiletools.filepicker.extensions;

import android.widget.EditText;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0078o;

public final class EditTextKt {
    public static final String getValue(EditText editText) {
        C0036f.m62b(editText, "$receiver");
        String obj = editText.getText().toString();
        if (obj != null) {
            return C0078o.m116a(obj).toString();
        }
        throw new C0027d("null cannot be cast to non-null type kotlin.CharSequence");
    }
}
