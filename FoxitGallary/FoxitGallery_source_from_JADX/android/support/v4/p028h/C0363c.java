package android.support.v4.p028h;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.provider.DocumentsContract;
import android.util.Log;
import java.util.ArrayList;

/* renamed from: android.support.v4.h.c */
class C0363c {
    public static Uri m1355a(Context context, Uri uri, String str) {
        return C0363c.m1356a(context, uri, "vnd.android.document/directory", str);
    }

    public static Uri m1356a(Context context, Uri uri, String str, String str2) {
        return DocumentsContract.createDocument(context.getContentResolver(), uri, str, str2);
    }

    public static Uri m1357a(Uri uri) {
        return DocumentsContract.buildDocumentUriUsingTree(uri, DocumentsContract.getTreeDocumentId(uri));
    }

    private static void m1358a(AutoCloseable autoCloseable) {
        if (autoCloseable != null) {
            try {
                autoCloseable.close();
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
            }
        }
    }

    public static Uri[] m1359a(Context context, Uri uri) {
        AutoCloseable query;
        Object e;
        Throwable th;
        ContentResolver contentResolver = context.getContentResolver();
        Uri buildChildDocumentsUriUsingTree = DocumentsContract.buildChildDocumentsUriUsingTree(uri, DocumentsContract.getDocumentId(uri));
        ArrayList arrayList = new ArrayList();
        try {
            query = contentResolver.query(buildChildDocumentsUriUsingTree, new String[]{"document_id"}, null, null, null);
            while (query.moveToNext()) {
                try {
                    arrayList.add(DocumentsContract.buildDocumentUriUsingTree(uri, query.getString(0)));
                } catch (Exception e2) {
                    e = e2;
                }
            }
            C0363c.m1358a(query);
        } catch (Exception e3) {
            e = e3;
            query = null;
            try {
                Log.w("DocumentFile", "Failed query: " + e);
                C0363c.m1358a(query);
                return (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
            } catch (Throwable th2) {
                th = th2;
                C0363c.m1358a(query);
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            query = null;
            C0363c.m1358a(query);
            throw th;
        }
        return (Uri[]) arrayList.toArray(new Uri[arrayList.size()]);
    }

    public static Uri m1360b(Context context, Uri uri, String str) {
        return DocumentsContract.renameDocument(context.getContentResolver(), uri, str);
    }
}
