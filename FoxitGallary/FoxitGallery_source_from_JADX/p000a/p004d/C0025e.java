package p000a.p004d;

import com.simplemobiletools.gallery.BuildConfig;
import java.io.File;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0078o;

/* renamed from: a.d.e */
class C0025e extends C0024d {
    public static final String m51a(File file) {
        C0036f.m62b(file, "$receiver");
        return C0078o.m120a(file.getName(), '.', BuildConfig.FLAVOR);
    }
}
