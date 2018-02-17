package com.simplemobiletools.gallery.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.models.Medium;
import java.util.ArrayList;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0034d;
import p000a.p005e.p007b.C0036f;

public final class GetMediaAsynctask extends AsyncTask<Void, Void, ArrayList<Medium>> {
    private final C0029b<ArrayList<Medium>, C0055f> callback;
    private final Context context;
    private final boolean isPickImage;
    private final boolean isPickVideo;
    public Config mConfig;
    private final String mPath;
    private final boolean showAll;

    public GetMediaAsynctask(Context context, String str, boolean z, boolean z2, boolean z3, C0029b<? super ArrayList<Medium>, C0055f> c0029b) {
        C0036f.m62b(context, "context");
        C0036f.m62b(str, "mPath");
        C0036f.m62b(c0029b, "callback");
        this.context = context;
        this.mPath = str;
        this.isPickVideo = z;
        this.isPickImage = z2;
        this.showAll = z3;
        this.callback = c0029b;
    }

    public /* synthetic */ GetMediaAsynctask(Context context, String str, boolean z, boolean z2, boolean z3, C0029b c0029b, int i, C0034d c0034d) {
        boolean z4 = false;
        boolean z5 = (i & 4) != 0 ? false : z;
        if ((i & 8) == 0) {
            z4 = z2;
        }
        this(context, str, z5, z4, z3, c0029b);
    }

    protected java.util.ArrayList<com.simplemobiletools.gallery.models.Medium> doInBackground(java.lang.Void... r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.asynctasks.GetMediaAsynctask.doInBackground(java.lang.Void[]):java.util.ArrayList<com.simplemobiletools.gallery.models.Medium>
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.ProcessClass.process(ProcessClass.java:34)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:281)
	at jadx.api.JavaClass.decompile(JavaClass.java:59)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:161)
Caused by: java.lang.NullPointerException
	at jadx.core.dex.nodes.MethodNode.addJump(MethodNode.java:367)
	at jadx.core.dex.nodes.MethodNode.initJumps(MethodNode.java:353)
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:103)
	... 7 more
*/
        /*
        r0 = this;
        r2 = "params";
        r0 = r19;
        p000a.p005e.p007b.C0036f.m62b(r0, r2);
        r12 = new java.util.ArrayList;
        r12.<init>();
        r15 = new java.util.ArrayList;
        r15.<init>();
        r0 = r18;
        r2 = r0.mConfig;
        if (r2 != 0) goto L_0x001c;
    L_0x0017:
        r3 = "mConfig";
        p000a.p005e.p007b.C0036f.m63b(r3);
    L_0x001c:
        r16 = r2.getShowMedia();
        r2 = 0;
        r17 = 1;
        r14 = r2;
    L_0x0024:
        if (r14 != 0) goto L_0x003c;
    L_0x0026:
        r0 = r18;
        r2 = r0.isPickVideo;
        if (r2 != 0) goto L_0x0034;
    L_0x002c:
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getVIDEOS();
        r0 = r16;
        if (r0 != r2) goto L_0x003c;
    L_0x0034:
        r0 = r17;
        if (r14 == r0) goto L_0x0151;
    L_0x0038:
        r2 = r14 + 1;
        r14 = r2;
        goto L_0x0024;
    L_0x003c:
        r3 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r2 = 1;
        if (r14 != r2) goto L_0x0051;
    L_0x0041:
        r0 = r18;
        r2 = r0.isPickImage;
        if (r2 != 0) goto L_0x0034;
    L_0x0047:
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getIMAGES();
        r0 = r16;
        if (r0 == r2) goto L_0x0034;
    L_0x004f:
        r3 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    L_0x0051:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r4 = android.provider.MediaStore.Images.Media.DATA;
        r2 = r2.append(r4);
        r4 = " LIKE ?";
        r2 = r2.append(r4);
        r5 = r2.toString();
        r0 = r18;
        r2 = r0.showAll;
        if (r2 == 0) goto L_0x00f0;
    L_0x006c:
        r2 = "%";
        r4 = r2;
        r2 = 1;
        r2 = new java.lang.String[r2];
        r6 = 0;
        r2[r6] = r4;
        r2 = (java.lang.Object[]) r2;
        r6 = r2;
        r6 = (java.lang.String[]) r6;
        r2 = 5;
        r2 = new java.lang.String[r2];
        r4 = 0;
        r7 = android.provider.MediaStore.Images.Media.DATA;
        r2[r4] = r7;
        r4 = 1;
        r7 = android.provider.MediaStore.Images.Media.DISPLAY_NAME;
        r2[r4] = r7;
        r4 = 2;
        r7 = android.provider.MediaStore.Images.Media.DATE_MODIFIED;
        r2[r4] = r7;
        r4 = 3;
        r7 = android.provider.MediaStore.Images.Media.DATE_TAKEN;
        r2[r4] = r7;
        r4 = 4;
        r7 = android.provider.MediaStore.Images.Media.SIZE;
        r2[r4] = r7;
        r2 = (java.lang.Object[]) r2;
        r4 = r2;
        r4 = (java.lang.String[]) r4;
        r2 = 0;
        r8 = r2;
        r8 = (android.database.Cursor) r8;
        r0 = r18;	 Catch:{ all -> 0x0177 }
        r2 = r0.context;	 Catch:{ all -> 0x0177 }
        r2 = r2.getContentResolver();	 Catch:{ all -> 0x0177 }
        r7 = 0;	 Catch:{ all -> 0x0177 }
        r7 = (java.lang.String) r7;	 Catch:{ all -> 0x0177 }
        r13 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x0177 }
        if (r13 == 0) goto L_0x010a;
    L_0x00b3:
        r2 = r13.moveToFirst();	 Catch:{ all -> 0x0143 }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ all -> 0x0143 }
        r3 = 1;	 Catch:{ all -> 0x0143 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x0143 }
        r2 = p000a.p005e.p007b.C0036f.m61a(r2, r3);	 Catch:{ all -> 0x0143 }
        if (r2 == 0) goto L_0x00e8;	 Catch:{ all -> 0x0143 }
    L_0x00c6:
        r2 = android.provider.MediaStore.Images.Media.DATA;	 Catch:{ all -> 0x0143 }
        r4 = com.simplemobiletools.gallery.extensions.CursorKt.getStringValue(r13, r2);	 Catch:{ all -> 0x0143 }
        if (r4 == 0) goto L_0x00e2;	 Catch:{ all -> 0x0143 }
    L_0x00ce:
        r2 = new java.io.File;	 Catch:{ all -> 0x0143 }
        r2.<init>(r4);	 Catch:{ all -> 0x0143 }
        r3 = android.provider.MediaStore.Images.Media.SIZE;	 Catch:{ all -> 0x0143 }
        r10 = com.simplemobiletools.gallery.extensions.CursorKt.getLongValue(r13, r3);	 Catch:{ all -> 0x0143 }
        r6 = 0;	 Catch:{ all -> 0x0143 }
        r3 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1));	 Catch:{ all -> 0x0143 }
        if (r3 != 0) goto L_0x010c;	 Catch:{ all -> 0x0143 }
    L_0x00df:
        r15.add(r2);	 Catch:{ all -> 0x0143 }
    L_0x00e2:
        r2 = r13.moveToNext();	 Catch:{ all -> 0x0143 }
        if (r2 != 0) goto L_0x00c6;
    L_0x00e8:
        if (r13 == 0) goto L_0x00ed;
    L_0x00ea:
        r13.close();
        goto L_0x0034;
    L_0x00f0:
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r0 = r18;
        r4 = r0.mPath;
        r2 = r2.append(r4);
        r4 = "%";
        r2 = r2.append(r4);
        r2 = r2.toString();
        r4 = r2;
        goto L_0x006f;
    L_0x010a:
        r2 = 0;
        goto L_0x00bb;
    L_0x010c:
        r0 = r18;	 Catch:{ all -> 0x0143 }
        r3 = r0.showAll;	 Catch:{ all -> 0x0143 }
        if (r3 != 0) goto L_0x0122;	 Catch:{ all -> 0x0143 }
        r2 = r2.getParent();	 Catch:{ all -> 0x0143 }
        r0 = r18;	 Catch:{ all -> 0x0143 }
        r3 = r0.mPath;	 Catch:{ all -> 0x0143 }
        r2 = p000a.p005e.p007b.C0036f.m61a(r2, r3);	 Catch:{ all -> 0x0143 }
        r2 = r2 ^ 1;	 Catch:{ all -> 0x0143 }
        if (r2 != 0) goto L_0x00e2;	 Catch:{ all -> 0x0143 }
        r2 = android.provider.MediaStore.Images.Media.DISPLAY_NAME;	 Catch:{ all -> 0x0143 }
        r3 = com.simplemobiletools.gallery.extensions.CursorKt.getStringValue(r13, r2);	 Catch:{ all -> 0x0143 }
        if (r3 == 0) goto L_0x014c;	 Catch:{ all -> 0x0143 }
        r2 = android.provider.MediaStore.Images.Media.DATE_MODIFIED;	 Catch:{ all -> 0x0143 }
        r6 = com.simplemobiletools.gallery.extensions.CursorKt.getLongValue(r13, r2);	 Catch:{ all -> 0x0143 }
        r2 = android.provider.MediaStore.Images.Media.DATE_TAKEN;	 Catch:{ all -> 0x0143 }
        r8 = com.simplemobiletools.gallery.extensions.CursorKt.getLongValue(r13, r2);	 Catch:{ all -> 0x0143 }
        r2 = new com.simplemobiletools.gallery.models.Medium;	 Catch:{ all -> 0x0143 }
        r5 = 1;	 Catch:{ all -> 0x0143 }
        if (r14 != r5) goto L_0x014f;	 Catch:{ all -> 0x0143 }
        r5 = 1;	 Catch:{ all -> 0x0143 }
        r2.<init>(r3, r4, r5, r6, r8, r10);	 Catch:{ all -> 0x0143 }
        r12.add(r2);	 Catch:{ all -> 0x0143 }
        goto L_0x00e2;
    L_0x0143:
        r2 = move-exception;
        r8 = r13;
        if (r8 == 0) goto L_0x014a;
        r8.close();
        throw r2;
        r3 = "";	 Catch:{ all -> 0x0143 }
        goto L_0x012a;
        r5 = 0;
        goto L_0x013c;
    L_0x0151:
        r0 = r18;
        r3 = r0.context;
        r2 = com.simplemobiletools.gallery.asynctasks.GetMediaAsynctask$doInBackground$1.INSTANCE;
        r2 = (p000a.p005e.p006a.C0028a) r2;
        com.simplemobiletools.filepicker.extensions.ContextKt.scanFiles(r3, r15, r2);
        r2 = com.simplemobiletools.gallery.models.Medium.Companion;
        r0 = r18;
        r3 = r0.mConfig;
        if (r3 != 0) goto L_0x0169;
        r4 = "mConfig";
        p000a.p005e.p007b.C0036f.m63b(r4);
        r3 = r3.getSorting();
        r2.setSorting(r3);
        r2 = r12;
        r2 = (java.util.List) r2;
        p000a.p001a.C0009k.m19b(r2);
        return r12;
    L_0x0177:
        r2 = move-exception;
        goto L_0x0145;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.asynctasks.GetMediaAsynctask.doInBackground(java.lang.Void[]):java.util.ArrayList<com.simplemobiletools.gallery.models.Medium>");
    }

    public final C0029b<ArrayList<Medium>, C0055f> getCallback() {
        return this.callback;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Config getMConfig() {
        Config config = this.mConfig;
        if (config == null) {
            C0036f.m63b("mConfig");
        }
        return config;
    }

    public final String getMPath() {
        return this.mPath;
    }

    public final boolean getShowAll() {
        return this.showAll;
    }

    public final boolean isPickImage() {
        return this.isPickImage;
    }

    public final boolean isPickVideo() {
        return this.isPickVideo;
    }

    protected void onPostExecute(ArrayList<Medium> arrayList) {
        C0036f.m62b(arrayList, "media");
        super.onPostExecute(arrayList);
        this.callback.invoke(arrayList);
    }

    protected void onPreExecute() {
        super.onPreExecute();
        this.mConfig = Config.Companion.newInstance(this.context);
    }

    public final void setMConfig(Config config) {
        C0036f.m62b(config, "<set-?>");
        this.mConfig = config;
    }
}
