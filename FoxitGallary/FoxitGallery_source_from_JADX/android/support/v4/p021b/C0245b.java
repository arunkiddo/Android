package android.support.v4.p021b;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.media.session.MediaController;
import android.os.Parcelable;
import android.view.View;
import java.util.List;
import java.util.Map;

/* renamed from: android.support.v4.b.b */
class C0245b {

    /* renamed from: android.support.v4.b.b.a */
    public static abstract class C0223a {
        public abstract Parcelable m795a(View view, Matrix matrix, RectF rectF);

        public abstract View m796a(Context context, Parcelable parcelable);

        public abstract void m797a(List<View> list);

        public abstract void m798a(List<String> list, List<View> list2, List<View> list3);

        public abstract void m799a(List<String> list, Map<String, View> map);

        public abstract void m800b(List<String> list, List<View> list2, List<View> list3);
    }

    /* renamed from: android.support.v4.b.b.b */
    private static class C0244b extends SharedElementCallback {
        private C0223a f530a;

        public C0244b(C0223a c0223a) {
            this.f530a = c0223a;
        }

        public Parcelable onCaptureSharedElementSnapshot(View view, Matrix matrix, RectF rectF) {
            return this.f530a.m795a(view, matrix, rectF);
        }

        public View onCreateSnapshotView(Context context, Parcelable parcelable) {
            return this.f530a.m796a(context, parcelable);
        }

        public void onMapSharedElements(List<String> list, Map<String, View> map) {
            this.f530a.m799a((List) list, (Map) map);
        }

        public void onRejectSharedElements(List<View> list) {
            this.f530a.m797a(list);
        }

        public void onSharedElementEnd(List<String> list, List<View> list2, List<View> list3) {
            this.f530a.m800b(list, list2, list3);
        }

        public void onSharedElementStart(List<String> list, List<View> list2, List<View> list3) {
            this.f530a.m798a((List) list, (List) list2, (List) list3);
        }
    }

    private static SharedElementCallback m910a(C0223a c0223a) {
        return c0223a != null ? new C0244b(c0223a) : null;
    }

    public static void m911a(Activity activity) {
        activity.finishAfterTransition();
    }

    public static void m912a(Activity activity, C0223a c0223a) {
        activity.setEnterSharedElementCallback(C0245b.m910a(c0223a));
    }

    public static void m913a(Activity activity, Object obj) {
        activity.setMediaController((MediaController) obj);
    }

    public static void m914b(Activity activity) {
        activity.postponeEnterTransition();
    }

    public static void m915b(Activity activity, C0223a c0223a) {
        activity.setExitSharedElementCallback(C0245b.m910a(c0223a));
    }

    public static void m916c(Activity activity) {
        activity.startPostponedEnterTransition();
    }
}
