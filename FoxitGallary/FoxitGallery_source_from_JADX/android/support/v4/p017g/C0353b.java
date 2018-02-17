package android.support.v4.p017g;

import android.os.AsyncTask;

/* renamed from: android.support.v4.g.b */
class C0353b {
    static <Params, Progress, Result> void m1327a(AsyncTask<Params, Progress, Result> asyncTask, Params... paramsArr) {
        asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, paramsArr);
    }
}
