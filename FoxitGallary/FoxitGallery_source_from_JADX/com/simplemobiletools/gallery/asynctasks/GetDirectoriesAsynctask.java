package com.simplemobiletools.gallery.asynctasks;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.MediaStore.Images.Media;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import com.simplemobiletools.gallery.models.Directory;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;

public final class GetDirectoriesAsynctask extends AsyncTask<Void, Void, ArrayList<Directory>> {
    private final C0029b<ArrayList<Directory>, C0055f> callback;
    private final Context context;
    private final boolean isPickImage;
    private final boolean isPickVideo;
    public Config mConfig;
    private final List<String> mToBeDeleted;

    public GetDirectoriesAsynctask(Context context, boolean z, boolean z2, List<String> list, C0029b<? super ArrayList<Directory>, C0055f> c0029b) {
        C0036f.m62b(context, "context");
        C0036f.m62b(list, "mToBeDeleted");
        C0036f.m62b(c0029b, "callback");
        this.context = context;
        this.isPickVideo = z;
        this.isPickImage = z2;
        this.mToBeDeleted = list;
        this.callback = c0029b;
    }

    private final void filterDirectories(List<Directory> list) {
        Config config = this.mConfig;
        if (config == null) {
            C0036f.m63b("mConfig");
        }
        if (!config.getShowHiddenFolders()) {
            removeHiddenFolders(list);
        }
        removeNoMediaFolders(list);
    }

    private final String getSortOrder() {
        Config config = this.mConfig;
        if (config == null) {
            C0036f.m63b("mConfig");
        }
        int directorySorting = config.getDirectorySorting();
        String str = Media.DATE_MODIFIED;
        if ((ConstantsKt.getSORT_BY_NAME() & directorySorting) != 0) {
            str = Media.DATA;
        }
        return (directorySorting & ConstantsKt.getSORT_DESCENDING()) != 0 ? str + " DESC" : str;
    }

    private final java.util.ArrayList<com.simplemobiletools.gallery.models.Directory> movePinnedToFront(java.util.ArrayList<com.simplemobiletools.gallery.models.Directory> r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.asynctasks.GetDirectoriesAsynctask.movePinnedToFront(java.util.ArrayList):java.util.ArrayList<com.simplemobiletools.gallery.models.Directory>
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
        r1 = new java.util.ArrayList;
        r1.<init>();
        r0 = r5.mConfig;
        if (r0 != 0) goto L_0x000e;
    L_0x0009:
        r2 = "mConfig";
        p000a.p005e.p007b.C0036f.m63b(r2);
    L_0x000e:
        r2 = r0.getPinnedFolders();
        r0 = r6;
        r0 = (java.lang.Iterable) r0;
        r3 = r0.iterator();
        r0 = r3.hasNext();
        if (r0 == 0) goto L_0x0035;
    L_0x0020:
        r0 = r3.next();
        r0 = (com.simplemobiletools.gallery.models.Directory) r0;
        r4 = r0.getPath();
        r4 = r2.contains(r4);
        if (r4 == 0) goto L_0x0033;
    L_0x0030:
        r1.add(r0);
        goto L_0x001a;
    L_0x0035:
        r0 = r1;
        r0 = (java.util.Collection) r0;
        r6.removeAll(r0);
        r0 = 0;
        r1 = (java.util.Collection) r1;
        r6.addAll(r0, r1);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.asynctasks.GetDirectoriesAsynctask.movePinnedToFront(java.util.ArrayList):java.util.ArrayList<com.simplemobiletools.gallery.models.Directory>");
    }

    private final void removeHiddenFolders(List<Directory> list) {
        Config config = this.mConfig;
        if (config == null) {
            C0036f.m63b("mConfig");
        }
        Set hiddenFolders = config.getHiddenFolders();
        Collection arrayList = new ArrayList();
        for (Object next : list) {
            if (hiddenFolders.contains(((Directory) next).getPath())) {
                arrayList.add(next);
            }
        }
        list.removeAll((List) arrayList);
    }

    private final void removeNoMediaFolders(List<Directory> list) {
        ArrayList arrayList = new ArrayList();
        for (Directory directory : list) {
            File file = new File(directory.getPath());
            if (file.exists() && file.isDirectory()) {
                Object valueOf;
                String[] list2 = file.list(GetDirectoriesAsynctask$removeNoMediaFolders$res$1.INSTANCE);
                if (list2 != null) {
                    valueOf = Boolean.valueOf(!(((Object[]) list2).length == 0));
                } else {
                    valueOf = null;
                }
                if (C0036f.m61a(valueOf, Boolean.valueOf(true))) {
                    arrayList.add(directory);
                }
            }
        }
        list.removeAll(arrayList);
    }

    protected java.util.ArrayList<com.simplemobiletools.gallery.models.Directory> doInBackground(java.lang.Void... r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.asynctasks.GetDirectoriesAsynctask.doInBackground(java.lang.Void[]):java.util.ArrayList<com.simplemobiletools.gallery.models.Directory>
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
        r0 = r21;
        p000a.p005e.p007b.C0036f.m62b(r0, r2);
        r16 = new java.util.LinkedHashMap;
        r16.<init>();
        r17 = new java.util.ArrayList;
        r17.<init>();
        r0 = r20;
        r2 = r0.mConfig;
        if (r2 != 0) goto L_0x001c;
    L_0x0017:
        r3 = "mConfig";
        p000a.p005e.p007b.C0036f.m63b(r3);
    L_0x001c:
        r18 = r2.getShowMedia();
        r2 = 0;
        r19 = 1;
        r15 = r2;
    L_0x0024:
        if (r15 != 0) goto L_0x003c;
    L_0x0026:
        r0 = r20;
        r2 = r0.isPickVideo;
        if (r2 != 0) goto L_0x0034;
    L_0x002c:
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getVIDEOS();
        r0 = r18;
        if (r0 != r2) goto L_0x003c;
    L_0x0034:
        r0 = r19;
        if (r15 == r0) goto L_0x0179;
    L_0x0038:
        r2 = r15 + 1;
        r15 = r2;
        goto L_0x0024;
    L_0x003c:
        r3 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        r2 = 1;
        if (r15 != r2) goto L_0x0051;
    L_0x0041:
        r0 = r20;
        r2 = r0.isPickImage;
        if (r2 != 0) goto L_0x0034;
    L_0x0047:
        r2 = com.simplemobiletools.gallery.helpers.ConstantsKt.getIMAGES();
        r0 = r18;
        if (r0 == r2) goto L_0x0034;
    L_0x004f:
        r3 = android.provider.MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    L_0x0051:
        r2 = 4;
        r2 = new java.lang.String[r2];
        r4 = 0;
        r5 = android.provider.MediaStore.Images.Media.DATA;
        r2[r4] = r5;
        r4 = 1;
        r5 = android.provider.MediaStore.Images.Media.DATE_MODIFIED;
        r2[r4] = r5;
        r4 = 2;
        r5 = android.provider.MediaStore.Images.Media.DATE_TAKEN;
        r2[r4] = r5;
        r4 = 3;
        r5 = android.provider.MediaStore.Images.Media.SIZE;
        r2[r4] = r5;
        r2 = (java.lang.Object[]) r2;
        r4 = r2;
        r4 = (java.lang.String[]) r4;
        r7 = r20.getSortOrder();
        r2 = 0;
        r8 = r2;
        r8 = (android.database.Cursor) r8;
        r0 = r20;	 Catch:{ all -> 0x01eb }
        r2 = r0.context;	 Catch:{ all -> 0x01eb }
        r2 = r2.getContentResolver();	 Catch:{ all -> 0x01eb }
        r5 = 0;	 Catch:{ all -> 0x01eb }
        r5 = (java.lang.String) r5;	 Catch:{ all -> 0x01eb }
        r6 = 0;	 Catch:{ all -> 0x01eb }
        r6 = (java.lang.String[]) r6;	 Catch:{ all -> 0x01eb }
        r14 = r2.query(r3, r4, r5, r6, r7);	 Catch:{ all -> 0x01eb }
        if (r14 == 0) goto L_0x00ca;
    L_0x008b:
        r2 = r14.moveToFirst();	 Catch:{ all -> 0x00f2 }
        r2 = java.lang.Boolean.valueOf(r2);	 Catch:{ all -> 0x00f2 }
        r3 = 1;	 Catch:{ all -> 0x00f2 }
        r3 = java.lang.Boolean.valueOf(r3);	 Catch:{ all -> 0x00f2 }
        r2 = p000a.p005e.p007b.C0036f.m61a(r2, r3);	 Catch:{ all -> 0x00f2 }
        if (r2 == 0) goto L_0x00c2;	 Catch:{ all -> 0x00f2 }
    L_0x009e:
        r2 = android.provider.MediaStore.Images.Media.DATA;	 Catch:{ all -> 0x00f2 }
        r5 = com.simplemobiletools.gallery.extensions.CursorKt.getStringValue(r14, r2);	 Catch:{ all -> 0x00f2 }
        if (r5 == 0) goto L_0x00bc;	 Catch:{ all -> 0x00f2 }
    L_0x00a6:
        r2 = new java.io.File;	 Catch:{ all -> 0x00f2 }
        r2.<init>(r5);	 Catch:{ all -> 0x00f2 }
        r3 = android.provider.MediaStore.Images.Media.SIZE;	 Catch:{ all -> 0x00f2 }
        r12 = com.simplemobiletools.gallery.extensions.CursorKt.getLongValue(r14, r3);	 Catch:{ all -> 0x00f2 }
        r6 = 0;	 Catch:{ all -> 0x00f2 }
        r3 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1));	 Catch:{ all -> 0x00f2 }
        if (r3 != 0) goto L_0x00cc;	 Catch:{ all -> 0x00f2 }
    L_0x00b7:
        r0 = r17;	 Catch:{ all -> 0x00f2 }
        r0.add(r2);	 Catch:{ all -> 0x00f2 }
    L_0x00bc:
        r2 = r14.moveToNext();	 Catch:{ all -> 0x00f2 }
        if (r2 != 0) goto L_0x009e;
    L_0x00c2:
        if (r14 == 0) goto L_0x00c7;
    L_0x00c4:
        r14.close();
        goto L_0x0034;
    L_0x00ca:
        r2 = 0;
        goto L_0x0093;
    L_0x00cc:
        r4 = r2.getParent();	 Catch:{ all -> 0x00f2 }
        r0 = r16;	 Catch:{ all -> 0x00f2 }
        r2 = r0.containsKey(r4);	 Catch:{ all -> 0x00f2 }
        if (r2 == 0) goto L_0x00fb;	 Catch:{ all -> 0x00f2 }
        r0 = r16;	 Catch:{ all -> 0x00f2 }
        r2 = r0.get(r4);	 Catch:{ all -> 0x00f2 }
        if (r2 != 0) goto L_0x00e3;	 Catch:{ all -> 0x00f2 }
        p000a.p005e.p007b.C0036f.m58a();	 Catch:{ all -> 0x00f2 }
        r2 = (com.simplemobiletools.gallery.models.Directory) r2;	 Catch:{ all -> 0x00f2 }
        r3 = r2.getMediaCnt();	 Catch:{ all -> 0x00f2 }
        r3 = r3 + 1;	 Catch:{ all -> 0x00f2 }
        r2.setMediaCnt(r3);	 Catch:{ all -> 0x00f2 }
        r2.addSize(r12);	 Catch:{ all -> 0x00f2 }
        goto L_0x00bc;
    L_0x00f2:
        r2 = move-exception;
        r8 = r14;
        if (r8 == 0) goto L_0x00f9;
        r8.close();
        throw r2;
        r0 = r20;	 Catch:{ all -> 0x00f2 }
        r2 = r0.mToBeDeleted;	 Catch:{ all -> 0x00f2 }
        r2 = r2.contains(r4);	 Catch:{ all -> 0x00f2 }
        if (r2 != 0) goto L_0x00bc;	 Catch:{ all -> 0x00f2 }
        r0 = r20;	 Catch:{ all -> 0x00f2 }
        r2 = r0.context;	 Catch:{ all -> 0x00f2 }
        r3 = "parentDir";	 Catch:{ all -> 0x00f2 }
        p000a.p005e.p007b.C0036f.m59a(r4, r3);	 Catch:{ all -> 0x00f2 }
        r6 = com.simplemobiletools.gallery.extensions.ContextKt.getHumanizedFilename(r2, r4);	 Catch:{ all -> 0x00f2 }
        r0 = r20;	 Catch:{ all -> 0x00f2 }
        r2 = r0.mConfig;	 Catch:{ all -> 0x00f2 }
        if (r2 != 0) goto L_0x011d;	 Catch:{ all -> 0x00f2 }
        r3 = "mConfig";	 Catch:{ all -> 0x00f2 }
        p000a.p005e.p007b.C0036f.m63b(r3);	 Catch:{ all -> 0x00f2 }
        r3 = "parentDir";	 Catch:{ all -> 0x00f2 }
        p000a.p005e.p007b.C0036f.m59a(r4, r3);	 Catch:{ all -> 0x00f2 }
        r2 = r2.getIsFolderHidden(r4);	 Catch:{ all -> 0x00f2 }
        if (r2 == 0) goto L_0x015b;	 Catch:{ all -> 0x00f2 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f2 }
        r2.<init>();	 Catch:{ all -> 0x00f2 }
        r2 = r2.append(r6);	 Catch:{ all -> 0x00f2 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00f2 }
        r3.<init>();	 Catch:{ all -> 0x00f2 }
        r6 = " ";	 Catch:{ all -> 0x00f2 }
        r3 = r3.append(r6);	 Catch:{ all -> 0x00f2 }
        r0 = r20;	 Catch:{ all -> 0x00f2 }
        r6 = r0.context;	 Catch:{ all -> 0x00f2 }
        r6 = r6.getResources();	 Catch:{ all -> 0x00f2 }
        r7 = 2131099713; // 0x7f060041 float:1.7811787E38 double:1.052903156E-314;	 Catch:{ all -> 0x00f2 }
        r6 = r6.getString(r7);	 Catch:{ all -> 0x00f2 }
        r3 = r3.append(r6);	 Catch:{ all -> 0x00f2 }
        r3 = r3.toString();	 Catch:{ all -> 0x00f2 }
        r2 = r2.append(r3);	 Catch:{ all -> 0x00f2 }
        r6 = r2.toString();	 Catch:{ all -> 0x00f2 }
        r2 = android.provider.MediaStore.Images.Media.DATE_MODIFIED;	 Catch:{ all -> 0x00f2 }
        r8 = com.simplemobiletools.gallery.extensions.CursorKt.getLongValue(r14, r2);	 Catch:{ all -> 0x00f2 }
        r2 = android.provider.MediaStore.Images.Media.DATE_TAKEN;	 Catch:{ all -> 0x00f2 }
        r10 = com.simplemobiletools.gallery.extensions.CursorKt.getLongValue(r14, r2);	 Catch:{ all -> 0x00f2 }
        r3 = new com.simplemobiletools.gallery.models.Directory;	 Catch:{ all -> 0x00f2 }
        r2 = "parentDir";	 Catch:{ all -> 0x00f2 }
        p000a.p005e.p007b.C0036f.m59a(r4, r2);	 Catch:{ all -> 0x00f2 }
        r7 = 1;	 Catch:{ all -> 0x00f2 }
        r3.<init>(r4, r5, r6, r7, r8, r10, r12);	 Catch:{ all -> 0x00f2 }
        r0 = r16;	 Catch:{ all -> 0x00f2 }
        r0.put(r4, r3);	 Catch:{ all -> 0x00f2 }
        goto L_0x00bc;
    L_0x0179:
        r0 = r20;
        r3 = r0.context;
        r2 = com.simplemobiletools.gallery.asynctasks.GetDirectoriesAsynctask$doInBackground$1.INSTANCE;
        r2 = (p000a.p005e.p006a.C0028a) r2;
        r0 = r17;
        com.simplemobiletools.filepicker.extensions.ContextKt.scanFiles(r3, r0, r2);
        r5 = new java.util.ArrayList;
        r2 = r16.values();
        r2 = (java.lang.Iterable) r2;
        r3 = new java.util.ArrayList;
        r3.<init>();
        r3 = (java.util.Collection) r3;
        r6 = r2.iterator();
        r2 = r6.hasNext();
        if (r2 == 0) goto L_0x01bb;
        r4 = r6.next();
        r2 = r4;
        r2 = (com.simplemobiletools.gallery.models.Directory) r2;
        r7 = new java.io.File;
        r2 = r2.getPath();
        r7.<init>(r2);
        r2 = r7.exists();
        if (r2 == 0) goto L_0x019b;
        r3.add(r4);
        goto L_0x019b;
        r3 = (java.util.List) r3;
        r3 = (java.util.Collection) r3;
        r5.<init>(r3);
        r2 = r5;
        r2 = (java.util.List) r2;
        r0 = r20;
        r0.filterDirectories(r2);
        r2 = com.simplemobiletools.gallery.models.Directory.Companion;
        r0 = r20;
        r3 = r0.mConfig;
        if (r3 != 0) goto L_0x01d7;
        r4 = "mConfig";
        p000a.p005e.p007b.C0036f.m63b(r4);
        r3 = r3.getDirectorySorting();
        r2.setSorting(r3);
        r2 = r5;
        r2 = (java.util.List) r2;
        p000a.p001a.C0009k.m19b(r2);
        r0 = r20;
        r2 = r0.movePinnedToFront(r5);
        return r2;
    L_0x01eb:
        r2 = move-exception;
        goto L_0x00f4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.asynctasks.GetDirectoriesAsynctask.doInBackground(java.lang.Void[]):java.util.ArrayList<com.simplemobiletools.gallery.models.Directory>");
    }

    public final C0029b<ArrayList<Directory>, C0055f> getCallback() {
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

    public final List<String> getMToBeDeleted() {
        return this.mToBeDeleted;
    }

    public final boolean isPickImage() {
        return this.isPickImage;
    }

    public final boolean isPickVideo() {
        return this.isPickVideo;
    }

    protected void onPostExecute(ArrayList<Directory> arrayList) {
        C0036f.m62b(arrayList, "dirs");
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
