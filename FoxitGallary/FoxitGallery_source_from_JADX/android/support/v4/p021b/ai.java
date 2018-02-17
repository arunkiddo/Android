package android.support.v4.p021b;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.p022c.C0225a;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.b.ai */
public final class ai implements Iterable<Intent> {
    private static final C0241b f527a;
    private final ArrayList<Intent> f528b;
    private final Context f529c;

    /* renamed from: android.support.v4.b.ai.a */
    public interface C0240a {
        Intent getSupportParentActivityIntent();
    }

    /* renamed from: android.support.v4.b.ai.b */
    interface C0241b {
    }

    /* renamed from: android.support.v4.b.ai.c */
    static class C0242c implements C0241b {
        C0242c() {
        }
    }

    /* renamed from: android.support.v4.b.ai.d */
    static class C0243d implements C0241b {
        C0243d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 11) {
            f527a = new C0243d();
        } else {
            f527a = new C0242c();
        }
    }

    private ai(Context context) {
        this.f528b = new ArrayList();
        this.f529c = context;
    }

    public static ai m903a(Context context) {
        return new ai(context);
    }

    public ai m904a(Activity activity) {
        Intent intent = null;
        if (activity instanceof C0240a) {
            intent = ((C0240a) activity).getSupportParentActivityIntent();
        }
        Intent a = intent == null ? ad.m885a(activity) : intent;
        if (a != null) {
            ComponentName component = a.getComponent();
            if (component == null) {
                component = a.resolveActivity(this.f529c.getPackageManager());
            }
            m905a(component);
            m906a(a);
        }
        return this;
    }

    public ai m905a(ComponentName componentName) {
        int size = this.f528b.size();
        try {
            Intent a = ad.m886a(this.f529c, componentName);
            while (a != null) {
                this.f528b.add(size, a);
                a = ad.m886a(this.f529c, a.getComponent());
            }
            return this;
        } catch (Throwable e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public ai m906a(Intent intent) {
        this.f528b.add(intent);
        return this;
    }

    public void m907a() {
        m908a(null);
    }

    public void m908a(Bundle bundle) {
        if (this.f528b.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        Intent[] intentArr = (Intent[]) this.f528b.toArray(new Intent[this.f528b.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (!C0225a.m809a(this.f529c, intentArr, bundle)) {
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f529c.startActivity(intent);
        }
    }

    public ai m909b(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component == null) {
            component = intent.resolveActivity(this.f529c.getPackageManager());
        }
        if (component != null) {
            m905a(component);
        }
        m906a(intent);
        return this;
    }

    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f528b.iterator();
    }
}
