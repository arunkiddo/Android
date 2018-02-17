package com.p045c.p046a.p068e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.p045c.p046a.p068e.C1232c.C1231a;

/* renamed from: com.c.a.e.e */
class C1235e implements C1232c {
    private final Context f3106a;
    private final C1231a f3107b;
    private boolean f3108c;
    private boolean f3109d;
    private final BroadcastReceiver f3110e;

    /* renamed from: com.c.a.e.e.1 */
    class C12341 extends BroadcastReceiver {
        final /* synthetic */ C1235e f3105a;

        C12341(C1235e c1235e) {
            this.f3105a = c1235e;
        }

        public void onReceive(Context context, Intent intent) {
            boolean a = this.f3105a.f3108c;
            this.f3105a.f3108c = this.f3105a.m5866a(context);
            if (a != this.f3105a.f3108c) {
                this.f3105a.f3107b.m5863a(this.f3105a.f3108c);
            }
        }
    }

    public C1235e(Context context, C1231a c1231a) {
        this.f3110e = new C12341(this);
        this.f3106a = context.getApplicationContext();
        this.f3107b = c1231a;
    }

    private void m5865a() {
        if (!this.f3109d) {
            this.f3108c = m5866a(this.f3106a);
            this.f3106a.registerReceiver(this.f3110e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f3109d = true;
        }
    }

    private boolean m5866a(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    private void m5871b() {
        if (this.f3109d) {
            this.f3106a.unregisterReceiver(this.f3110e);
            this.f3109d = false;
        }
    }

    public void onDestroy() {
    }

    public void onStart() {
        m5865a();
    }

    public void onStop() {
        m5871b();
    }
}
