package android.support.v7.p033a;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.p022c.C0317i;
import android.util.Log;
import java.util.Calendar;

/* renamed from: android.support.v7.a.r */
class C0712r {
    private static final C0711a f1309a;
    private final Context f1310b;
    private final LocationManager f1311c;

    /* renamed from: android.support.v7.a.r.a */
    private static class C0711a {
        boolean f1303a;
        long f1304b;
        long f1305c;
        long f1306d;
        long f1307e;
        long f1308f;

        private C0711a() {
        }
    }

    static {
        f1309a = new C0711a();
    }

    C0712r(Context context) {
        this.f1310b = context;
        this.f1311c = (LocationManager) context.getSystemService("location");
    }

    private Location m3099a(String str) {
        if (this.f1311c != null) {
            try {
                if (this.f1311c.isProviderEnabled(str)) {
                    return this.f1311c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private void m3100a(Location location) {
        long j;
        C0711a c0711a = f1309a;
        long currentTimeMillis = System.currentTimeMillis();
        C0709q a = C0709q.m3097a();
        a.m3098a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f1300a;
        a.m3098a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f1302c == 1;
        long j3 = a.f1301b;
        long j4 = a.f1300a;
        a.m3098a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f1301b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            j = currentTimeMillis > j4 ? 0 + j5 : currentTimeMillis > j3 ? 0 + j4 : 0 + j3;
            j += 60000;
        }
        c0711a.f1303a = z;
        c0711a.f1304b = j2;
        c0711a.f1305c = j3;
        c0711a.f1306d = j4;
        c0711a.f1307e = j5;
        c0711a.f1308f = j;
    }

    private boolean m3101a(C0711a c0711a) {
        return c0711a != null && c0711a.f1308f > System.currentTimeMillis();
    }

    private Location m3102b() {
        Location location = null;
        Location a = C0317i.m1202a(this.f1310b, "android.permission.ACCESS_COARSE_LOCATION") == 0 ? m3099a("network") : null;
        if (C0317i.m1202a(this.f1310b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m3099a("gps");
        }
        if (location != null && a != null) {
            return location.getTime() > a.getTime() ? location : a;
        } else {
            if (location == null) {
                location = a;
            }
            return location;
        }
    }

    boolean m3103a() {
        C0711a c0711a = f1309a;
        if (m3101a(c0711a)) {
            return c0711a.f1303a;
        }
        Location b = m3102b();
        if (b != null) {
            m3100a(b);
            return c0711a.f1303a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }
}
