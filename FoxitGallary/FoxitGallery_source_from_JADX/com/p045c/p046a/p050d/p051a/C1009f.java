package com.p045c.p046a.p050d.p051a;

import android.text.TextUtils;
import android.util.Log;
import com.p045c.p046a.C1298k;
import com.p045c.p046a.p050d.p059c.C1127d;
import com.p045c.p046a.p055j.C1290b;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;

/* renamed from: com.c.a.d.a.f */
public class C1009f implements C1000c<InputStream> {
    private static final C1007b f2718a;
    private final C1127d f2719b;
    private final C1007b f2720c;
    private HttpURLConnection f2721d;
    private InputStream f2722e;
    private volatile boolean f2723f;

    /* renamed from: com.c.a.d.a.f.b */
    interface C1007b {
        HttpURLConnection m5294a(URL url);
    }

    /* renamed from: com.c.a.d.a.f.a */
    private static class C1008a implements C1007b {
        private C1008a() {
        }

        public HttpURLConnection m5295a(URL url) {
            return (HttpURLConnection) url.openConnection();
        }
    }

    static {
        f2718a = new C1008a();
    }

    public C1009f(C1127d c1127d) {
        this(c1127d, f2718a);
    }

    C1009f(C1127d c1127d, C1007b c1007b) {
        this.f2719b = c1127d;
        this.f2720c = c1007b;
    }

    private InputStream m5296a(HttpURLConnection httpURLConnection) {
        if (TextUtils.isEmpty(httpURLConnection.getContentEncoding())) {
            this.f2722e = C1290b.m6096a(httpURLConnection.getInputStream(), (long) httpURLConnection.getContentLength());
        } else {
            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection.getContentEncoding());
            }
            this.f2722e = httpURLConnection.getInputStream();
        }
        return this.f2722e;
    }

    private InputStream m5297a(URL url, int i, URL url2, Map<String, String> map) {
        if (i >= 5) {
            throw new IOException("Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new IOException("In re-direct loop");
                }
            } catch (URISyntaxException e) {
            }
        }
        this.f2721d = this.f2720c.m5294a(url);
        for (Entry entry : map.entrySet()) {
            this.f2721d.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
        this.f2721d.setConnectTimeout(2500);
        this.f2721d.setReadTimeout(2500);
        this.f2721d.setUseCaches(false);
        this.f2721d.setDoInput(true);
        this.f2721d.connect();
        if (this.f2723f) {
            return null;
        }
        int responseCode = this.f2721d.getResponseCode();
        if (responseCode / 100 == 2) {
            return m5296a(this.f2721d);
        }
        if (responseCode / 100 == 3) {
            Object headerField = this.f2721d.getHeaderField("Location");
            if (!TextUtils.isEmpty(headerField)) {
                return m5297a(new URL(url, headerField), i + 1, url, map);
            }
            throw new IOException("Received empty or null redirect url");
        } else if (responseCode == -1) {
            throw new IOException("Unable to retrieve response code from HttpUrlConnection.");
        } else {
            throw new IOException("Request failed " + responseCode + ": " + this.f2721d.getResponseMessage());
        }
    }

    public /* synthetic */ Object m5298a(C1298k c1298k) {
        return m5300b(c1298k);
    }

    public void m5299a() {
        if (this.f2722e != null) {
            try {
                this.f2722e.close();
            } catch (IOException e) {
            }
        }
        if (this.f2721d != null) {
            this.f2721d.disconnect();
        }
    }

    public InputStream m5300b(C1298k c1298k) {
        return m5297a(this.f2719b.m5585a(), 0, null, this.f2719b.m5586b());
    }

    public String m5301b() {
        return this.f2719b.m5587c();
    }

    public void m5302c() {
        this.f2723f = true;
    }
}
