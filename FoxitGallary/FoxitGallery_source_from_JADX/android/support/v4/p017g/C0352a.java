package android.support.v4.p017g;

import android.os.AsyncTask;
import android.os.Build.VERSION;

/* renamed from: android.support.v4.g.a */
public final class C0352a {
    public static <Params, Progress, Result> AsyncTask<Params, Progress, Result> m1326a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        if (asyncTask == null) {
            throw new IllegalArgumentException("task can not be null");
        }
        if (VERSION.SDK_INT >= 11) {
            C0353b.m1327a(asyncTask, paramsArr);
        } else {
            asyncTask.execute(paramsArr);
        }
        return asyncTask;
    }
}
