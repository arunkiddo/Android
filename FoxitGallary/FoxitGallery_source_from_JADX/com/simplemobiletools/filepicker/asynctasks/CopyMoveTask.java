package com.simplemobiletools.filepicker.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.p030j.C0391h;
import android.util.Log;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.FileKt;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.p005e.p007b.C0034d;
import p000a.p005e.p007b.C0036f;

public final class CopyMoveTask extends AsyncTask<C0391h<ArrayList<File>, File>, Void, Boolean> {
    private final String TAG;
    private final Context context;
    private final boolean copyMediaOnly;
    private final boolean deleteAfterCopy;
    public ArrayList<File> mFiles;
    private WeakReference<CopyMoveListener> mListener;
    private ArrayList<File> mMovedFiles;
    private final String treeUri;

    public interface CopyMoveListener {
        void copyFailed();

        void copySucceeded(boolean z, boolean z2);
    }

    public CopyMoveTask(Context context, boolean z, String str, boolean z2, CopyMoveListener copyMoveListener) {
        C0036f.m62b(context, "context");
        C0036f.m62b(str, "treeUri");
        C0036f.m62b(copyMoveListener, "listener");
        this.context = context;
        this.deleteAfterCopy = z;
        this.treeUri = str;
        this.copyMediaOnly = z2;
        this.TAG = CopyMoveTask.class.getSimpleName();
        this.mMovedFiles = new ArrayList();
        this.mListener = new WeakReference(copyMoveListener);
    }

    public /* synthetic */ CopyMoveTask(Context context, boolean z, String str, boolean z2, CopyMoveListener copyMoveListener, int i, C0034d c0034d) {
        this(context, (i & 2) != 0 ? false : z, (i & 4) != 0 ? BuildConfig.FLAVOR : str, z2, copyMoveListener);
    }

    private final void copy(File file, File file2) {
        if (file.isDirectory()) {
            copyDirectory(file, file2);
        } else {
            copyFile(file, file2);
        }
    }

    private final void copyDirectory(File file, File file2) {
        if (!file2.exists()) {
            Context context = this.context;
            Object absolutePath = file2.getAbsolutePath();
            C0036f.m59a(absolutePath, "destination.absolutePath");
            if (ContextKt.needsStupidWritePermissions(context, absolutePath)) {
                context = this.context;
                absolutePath = file2.getAbsolutePath();
                C0036f.m59a(absolutePath, "destination.absolutePath");
                ContextKt.getFileDocument(context, absolutePath, this.treeUri).m1337a(file2.getName());
            } else if (!file2.mkdirs()) {
                throw new IOException("Could not create dir " + file2.getAbsolutePath());
            }
        }
        String[] list = file.list();
        for (String str : list) {
            File file3 = new File(file2, str);
            if (!file3.exists()) {
                File file4 = new File(file, str);
                Context context2 = this.context;
                Object absolutePath2 = file2.getAbsolutePath();
                C0036f.m59a(absolutePath2, "destination.absolutePath");
                if (!ContextKt.needsStupidWritePermissions(context2, absolutePath2)) {
                    copy(file4, file3);
                } else if (file3.isDirectory()) {
                    copyDirectory(file4, file3);
                } else {
                    copyFile(file4, file3);
                }
            }
        }
    }

    private final void copyFile(File file, File file2) {
        if (!this.copyMediaOnly || FileKt.isImageVideoGif(file)) {
            File parentFile = file2.getParentFile();
            if (parentFile.exists() || parentFile.mkdirs()) {
                OutputStream openOutputStream;
                FileInputStream fileInputStream = new FileInputStream(file);
                Context context = this.context;
                Object absolutePath = file2.getAbsolutePath();
                C0036f.m59a(absolutePath, "destination.absolutePath");
                if (ContextKt.needsStupidWritePermissions(context, absolutePath)) {
                    context = this.context;
                    absolutePath = file2.getAbsolutePath();
                    C0036f.m59a(absolutePath, "destination.absolutePath");
                    Object a = ContextKt.getFileDocument(context, absolutePath, this.treeUri).m1338a(BuildConfig.FLAVOR, file2.getName());
                    C0036f.m59a(a, "document.createFile(\"\", destination.name)");
                    openOutputStream = this.context.getContentResolver().openOutputStream(a.m1336a());
                } else {
                    openOutputStream = new FileOutputStream(file2);
                }
                copyStream(fileInputStream, openOutputStream);
                ContextKt.scanFile(this.context, file2, CopyMoveTask$copyFile$1.INSTANCE);
                this.mMovedFiles.add(file);
                return;
            }
            throw new IOException("Could not create dir " + parentFile.getAbsolutePath());
        }
    }

    private final void copyStream(java.io.InputStream r1, java.io.OutputStream r2) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.filepicker.asynctasks.CopyMoveTask.copyStream(java.io.InputStream, java.io.OutputStream):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 5 more
*/
        /*
        r0 = this;
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r0 = new byte[r0];
        r1 = r4.read(r0);
        if (r1 > 0) goto L_0x000b;
    L_0x000a:
        return;
    L_0x000b:
        if (r5 == 0) goto L_0x0011;
    L_0x000d:
        r2 = 0;
        r5.write(r0, r2, r1);
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.filepicker.asynctasks.CopyMoveTask.copyStream(java.io.InputStream, java.io.OutputStream):void");
    }

    protected Boolean doInBackground(C0391h<ArrayList<File>, File>... c0391hArr) {
        C0036f.m62b(c0391hArr, "params");
        C0391h c0391h = c0391hArr[0];
        Object obj = c0391h.f752a;
        C0036f.m59a(obj, "pair.first");
        this.mFiles = (ArrayList) obj;
        ArrayList arrayList = this.mFiles;
        if (arrayList == null) {
            C0036f.m63b("mFiles");
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            obj = (File) it.next();
            try {
                File file = new File((File) c0391h.f753b, obj.getName());
                if (!file.exists()) {
                    C0036f.m59a(obj, "file");
                    copy(obj, file);
                }
            } catch (Exception e) {
                Log.e(this.TAG, "copy " + e);
                return Boolean.valueOf(false);
            }
        }
        if (this.deleteAfterCopy) {
            Iterator it2 = this.mMovedFiles.iterator();
            while (it2.hasNext()) {
                File file2 = (File) it2.next();
                Context context = this.context;
                Object absolutePath = file2.getAbsolutePath();
                C0036f.m59a(absolutePath, "file.absolutePath");
                if (ContextKt.needsStupidWritePermissions(context, absolutePath)) {
                    context = this.context;
                    obj = file2.getAbsolutePath();
                    C0036f.m59a(obj, "file.absolutePath");
                    ContextKt.getFileDocument(context, obj, this.treeUri).m1344e();
                } else {
                    file2.delete();
                }
            }
        }
        Context context2 = this.context;
        ArrayList arrayList2 = this.mFiles;
        if (arrayList2 == null) {
            C0036f.m63b("mFiles");
        }
        ContextKt.scanFiles(context2, arrayList2, CopyMoveTask$doInBackground$1.INSTANCE);
        ContextKt.scanFiles(this.context, this.mMovedFiles, CopyMoveTask$doInBackground$2.INSTANCE);
        return Boolean.valueOf(true);
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean getCopyMediaOnly() {
        return this.copyMediaOnly;
    }

    public final boolean getDeleteAfterCopy() {
        return this.deleteAfterCopy;
    }

    public final ArrayList<File> getMFiles() {
        ArrayList<File> arrayList = this.mFiles;
        if (arrayList == null) {
            C0036f.m63b("mFiles");
        }
        return arrayList;
    }

    public final String getTreeUri() {
        return this.treeUri;
    }

    public /* synthetic */ void onPostExecute(Object obj) {
        onPostExecute(((Boolean) obj).booleanValue());
    }

    protected void onPostExecute(boolean z) {
        WeakReference weakReference = this.mListener;
        if (weakReference != null) {
            CopyMoveListener copyMoveListener = (CopyMoveListener) weakReference.get();
            if (copyMoveListener == null) {
                return;
            }
            if (z) {
                boolean z2 = this.deleteAfterCopy;
                ArrayList arrayList = this.mFiles;
                if (arrayList == null) {
                    C0036f.m63b("mFiles");
                }
                copyMoveListener.copySucceeded(z2, arrayList.size() == this.mMovedFiles.size());
                return;
            }
            copyMoveListener.copyFailed();
        }
    }

    public final void setMFiles(ArrayList<File> arrayList) {
        C0036f.m62b(arrayList, "<set-?>");
        this.mFiles = arrayList;
    }
}
