package android.support.v4.p028h;

import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.text.TextUtils;
import android.util.Log;

/* renamed from: android.support.v4.h.b */
class C0362b {
    private static int m1346a(Context context, Uri uri, String str, int i) {
        return (int) C0362b.m1347a(context, uri, str, (long) i);
    }

    private static long m1347a(Context context, Uri uri, String str, long j) {
        Object e;
        Throwable th;
        AutoCloseable query;
        try {
            query = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                if (!query.moveToFirst() || query.isNull(0)) {
                    C0362b.m1350a(query);
                    return j;
                }
                j = query.getLong(0);
                C0362b.m1350a(query);
                return j;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.w("DocumentFile", "Failed query: " + e);
                    C0362b.m1350a(query);
                    return j;
                } catch (Throwable th2) {
                    th = th2;
                    C0362b.m1350a(query);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.w("DocumentFile", "Failed query: " + e);
            C0362b.m1350a(query);
            return j;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            C0362b.m1350a(query);
            throw th;
        }
    }

    public static String m1348a(Context context, Uri uri) {
        return C0362b.m1349a(context, uri, "_display_name", null);
    }

    private static String m1349a(Context context, Uri uri, String str, String str2) {
        AutoCloseable query;
        Object e;
        Throwable th;
        try {
            query = context.getContentResolver().query(uri, new String[]{str}, null, null, null);
            try {
                if (!query.moveToFirst() || query.isNull(0)) {
                    C0362b.m1350a(query);
                    return str2;
                }
                str2 = query.getString(0);
                C0362b.m1350a(query);
                return str2;
            } catch (Exception e2) {
                e = e2;
                try {
                    Log.w("DocumentFile", "Failed query: " + e);
                    C0362b.m1350a(query);
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    C0362b.m1350a(query);
                    throw th;
                }
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            Log.w("DocumentFile", "Failed query: " + e);
            C0362b.m1350a(query);
            return str2;
        } catch (Throwable th3) {
            th = th3;
            query = null;
            C0362b.m1350a(query);
            throw th;
        }
    }

    private static void m1350a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static boolean m1351b(Context context, Uri uri) {
        return "vnd.android.document/directory".equals(C0362b.m1354e(context, uri));
    }

    public static boolean m1352c(Context context, Uri uri) {
        if (context.checkCallingOrSelfUriPermission(uri, 2) != 0) {
            return false;
        }
        CharSequence e = C0362b.m1354e(context, uri);
        int a = C0362b.m1346a(context, uri, "flags", 0);
        return !TextUtils.isEmpty(e) ? (a & 4) != 0 ? true : (!"vnd.android.document/directory".equals(e) || (a & 8) == 0) ? (TextUtils.isEmpty(e) || (a & 2) == 0) ? false : true : true : false;
    }

    public static boolean m1353d(Context context, Uri uri) {
        return DocumentsContract.deleteDocument(context.getContentResolver(), uri);
    }

    private static String m1354e(Context context, Uri uri) {
        return C0362b.m1349a(context, uri, "mime_type", null);
    }
}
