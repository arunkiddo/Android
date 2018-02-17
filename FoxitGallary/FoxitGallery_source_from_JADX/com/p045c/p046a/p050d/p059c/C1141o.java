package com.p045c.p046a.p050d.p059c;

import android.util.Log;
import com.p045c.p046a.p050d.C1092b;
import com.p045c.p046a.p055j.C1289a;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.InputStream;
import java.io.OutputStream;

/* renamed from: com.c.a.d.c.o */
public class C1141o implements C1092b<InputStream> {
    public String m5613a() {
        return BuildConfig.FLAVOR;
    }

    public boolean m5614a(InputStream inputStream, OutputStream outputStream) {
        byte[] b = C1289a.m6092a().m6094b();
        while (true) {
            try {
                int read = inputStream.read(b);
                if (read != -1) {
                    outputStream.write(b, 0, read);
                } else {
                    C1289a.m6092a().m6093a(b);
                    return true;
                }
            } catch (Throwable e) {
                if (Log.isLoggable("StreamEncoder", 3)) {
                    Log.d("StreamEncoder", "Failed to encode data onto the OutputStream", e);
                }
                C1289a.m6092a().m6093a(b);
                return false;
            } catch (Throwable th) {
                C1289a.m6092a().m6093a(b);
            }
        }
    }
}
