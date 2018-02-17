package com.simplemobiletools.gallery.adapters;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v7.view.C0716b;
import android.support.v7.widget.RecyclerView.C0829a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.p040a.p041a.p042a.C0965a;
import com.p040a.p041a.p042a.C0966b;
import com.p040a.p041a.p042a.C0972f;
import com.simplemobiletools.filepicker.dialogs.ConfirmationDialog;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.FileKt;
import com.simplemobiletools.fileproperties.dialogs.PropertiesDialog;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.activities.SimpleActivity;
import com.simplemobiletools.gallery.dialogs.CopyDialog;
import com.simplemobiletools.gallery.dialogs.RenameDirectoryDialog;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.models.Directory;
import com.simplemobiletools.gallery.views.MyImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;

public final class DirectoryAdapter extends C0829a<ViewHolder> {
    public static final Companion Companion;
    private static C0716b actMode;
    private static final HashSet<Integer> markedItems;
    private final SimpleActivity activity;
    private final Config config;
    private final List<Directory> dirs;
    private final C0029b<Directory, C0055f> itemClick;
    private final DirOperationsListener listener;
    private final C0966b multiSelector;
    private final C0965a multiSelectorMode;
    private Set<String> pinnedFolders;
    private final ArrayList<View> views;

    public interface DirOperationsListener {
        void prepareForDeleting(ArrayList<String> arrayList);

        void refreshItems();
    }

    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void toggleItemSelection$default(Companion companion, View view, boolean z, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: toggleItemSelection");
            }
            if ((i2 & 4) != 0) {
                i = -1;
            }
            companion.toggleItemSelection(view, z, i);
        }

        public final C0716b getActMode() {
            return DirectoryAdapter.actMode;
        }

        public final HashSet<Integer> getMarkedItems() {
            return DirectoryAdapter.markedItems;
        }

        public final void setActMode(C0716b c0716b) {
            DirectoryAdapter.actMode = c0716b;
        }

        public final void toggleItemSelection(View view, boolean z, int i) {
            C0036f.m62b(view, "itemView");
            if (VERSION.SDK_INT < 23) {
                ((FrameLayout) view.findViewById(C1333R.id.dir_frame)).setSelected(z);
            } else {
                ((MyImageView) view.findViewById(C1333R.id.dir_thumbnail)).setSelected(z);
            }
            if (i != -1) {
                if (z) {
                    getMarkedItems().add(Integer.valueOf(i));
                } else {
                    getMarkedItems().remove(Integer.valueOf(i));
                }
            }
        }
    }

    public static final class ViewHolder extends C0972f {
        private final C0029b<Directory, C0055f> itemClick;

        public ViewHolder(View view, C0029b<? super Directory, C0055f> c0029b) {
            C0036f.m62b(view, "view");
            C0036f.m62b(c0029b, "itemClick");
            super(view, new C0966b());
            this.itemClick = c0029b;
        }

        public final android.view.View bindView(com.simplemobiletools.gallery.activities.SimpleActivity r1, com.p040a.p041a.p042a.C0965a r2, com.p040a.p041a.p042a.C0966b r3, com.simplemobiletools.gallery.models.Directory r4, int r5, boolean r6) {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter.ViewHolder.bindView(com.simplemobiletools.gallery.activities.SimpleActivity, com.a.a.a.a, com.a.a.a.b, com.simplemobiletools.gallery.models.Directory, int, boolean):android.view.View
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:263)
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
	... 8 more
*/
            /*
            r0 = this;
            r8 = 0;
            r7 = 2;
            r6 = 2131558479; // 0x7f0d004f float:1.8742275E38 double:1.0531298166E-314;
            r3 = 0;
            r0 = "activity";
            p000a.p005e.p007b.C0036f.m62b(r10, r0);
            r0 = "multiSelectorCallback";
            p000a.p005e.p007b.C0036f.m62b(r11, r0);
            r0 = "multiSelector";
            p000a.p005e.p007b.C0036f.m62b(r12, r0);
            r0 = "directory";
            p000a.p005e.p007b.C0036f.m62b(r13, r0);
            r0 = r9.itemView;
            r1 = com.simplemobiletools.gallery.C1333R.id.dir_name;
            r0 = r0.findViewById(r1);
            r0 = (android.widget.TextView) r0;
            r1 = r13.getName();
            r1 = (java.lang.CharSequence) r1;
            r0.setText(r1);
            r0 = r9.itemView;
            r1 = com.simplemobiletools.gallery.C1333R.id.photo_cnt;
            r0 = r0.findViewById(r1);
            r0 = (android.widget.TextView) r0;
            r1 = r13.getMediaCnt();
            r1 = java.lang.String.valueOf(r1);
            r1 = (java.lang.CharSequence) r1;
            r0.setText(r1);
            r0 = r9.itemView;
            r1 = com.simplemobiletools.gallery.C1333R.id.dir_pin;
            r0 = r0.findViewById(r1);
            r0 = (android.widget.ImageView) r0;
            if (r15 == 0) goto L_0x008a;
        L_0x0050:
            r1 = r3;
        L_0x0051:
            r0.setVisibility(r1);
            r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
            r1 = r9.itemView;
            r2 = "itemView";
            p000a.p005e.p007b.C0036f.m59a(r1, r2);
            r2 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
            r2 = r2.getMarkedItems();
            r4 = java.lang.Integer.valueOf(r14);
            r2 = r2.contains(r4);
            r0.toggleItemSelection(r1, r2, r14);
            r1 = r13.getThumbnail();
            r2 = new com.c.a.i.c;
            r4 = r13.getDate_modified();
            r0 = java.lang.String.valueOf(r4);
            r2.<init>(r0);
            if (r1 != 0) goto L_0x008d;
        L_0x0082:
            r0 = new a.d;
            r1 = "null cannot be cast to non-null type java.lang.String";
            r0.<init>(r1);
            throw r0;
        L_0x008a:
            r1 = 8;
            goto L_0x0051;
        L_0x008d:
            r0 = r1;
            r0 = (java.lang.String) r0;
            r0 = r0.toLowerCase();
            r4 = "(this as java.lang.String).toLowerCase()";
            p000a.p005e.p007b.C0036f.m59a(r0, r4);
            r4 = ".gif";
            r0 = p000a.p011i.C0077n.m104b(r0, r4, r3, r7, r8);
            if (r0 == 0) goto L_0x00fb;
        L_0x00a1:
            r0 = r10;
            r0 = (android.support.v4.p021b.C0279p) r0;
            r0 = com.p045c.p046a.C1288i.m6074a(r0);
            r0 = r0.m6137a(r1);
            r0 = r0.m5856i();
            r1 = com.p045c.p046a.p050d.p052b.C1056b.NONE;
            r1 = r0.m5934a(r1);
            r0 = r2;
            r0 = (com.p045c.p046a.p050d.C1081c) r0;
            r0 = r1.m5936a(r0);
            r0 = r0.m5932a(r6);
            r0 = r0.m5931a();
            r1 = r0.m5954c();
            r0 = r9.itemView;
            r2 = com.simplemobiletools.gallery.C1333R.id.dir_thumbnail;
            r0 = r0.findViewById(r2);
            r0 = (com.simplemobiletools.gallery.views.MyImageView) r0;
            r1.m5117a(r0);
            r1 = r9.itemView;
            r0 = new com.simplemobiletools.gallery.adapters.DirectoryAdapter$ViewHolder$bindView$1;
            r0.<init>(r9, r12, r13, r14);
            r0 = (android.view.View.OnClickListener) r0;
            r1.setOnClickListener(r0);
            r6 = r9.itemView;
            r0 = new com.simplemobiletools.gallery.adapters.DirectoryAdapter$ViewHolder$bindView$2;
            r1 = r9;
            r2 = r12;
            r3 = r10;
            r4 = r11;
            r5 = r14;
            r0.<init>(r1, r2, r3, r4, r5);
            r0 = (android.view.View.OnLongClickListener) r0;
            r6.setOnLongClickListener(r0);
            r0 = r9.itemView;
            r1 = "itemView";
            p000a.p005e.p007b.C0036f.m59a(r0, r1);
            return r0;
            if (r1 != 0) goto L_0x0106;
            r0 = new a.d;
            r1 = "null cannot be cast to non-null type java.lang.String";
            r0.<init>(r1);
            throw r0;
            r0 = r1;
            r0 = (java.lang.String) r0;
            r0 = r0.toLowerCase();
            r4 = "(this as java.lang.String).toLowerCase()";
            p000a.p005e.p007b.C0036f.m59a(r0, r4);
            r4 = ".png";
            r0 = p000a.p011i.C0077n.m104b(r0, r4, r3, r7, r8);
            if (r0 == 0) goto L_0x0151;
            r0 = r10;
            r0 = (android.support.v4.p021b.C0279p) r0;
            r0 = com.p045c.p046a.C1288i.m6074a(r0);
            r0 = r0.m6137a(r1);
            r0 = r0.m5855h();
            r1 = com.p045c.p046a.p050d.C1012a.PREFER_ARGB_8888;
            r0 = r0.m5136a(r1);
            r1 = com.p045c.p046a.p050d.p052b.C1056b.RESULT;
            r0 = r0.m5137a(r1);
            r2 = (com.p045c.p046a.p050d.C1081c) r2;
            r0 = r0.m5139a(r2);
            r0 = r0.m5134a(r6);
            r1 = r0.m5133a();
            r0 = r9.itemView;
            r2 = com.simplemobiletools.gallery.C1333R.id.dir_thumbnail;
            r0 = r0.findViewById(r2);
            r0 = (com.simplemobiletools.gallery.views.MyImageView) r0;
            r1.m5145a(r0);
            goto L_0x00d6;
            r0 = r10;
            r0 = (android.support.v4.p021b.C0279p) r0;
            r0 = com.p045c.p046a.C1288i.m6074a(r0);
            r0 = r0.m6137a(r1);
            r1 = com.p045c.p046a.p050d.p052b.C1056b.RESULT;
            r0 = r0.m5238a(r1);
            r2 = (com.p045c.p046a.p050d.C1081c) r2;
            r0 = r0.m5240a(r2);
            r0 = r0.m5236a(r6);
            r0 = r0.m5235a();
            r1 = r0.m5256c();
            r0 = r9.itemView;
            r2 = com.simplemobiletools.gallery.C1333R.id.dir_thumbnail;
            r0 = r0.findViewById(r2);
            r0 = (com.simplemobiletools.gallery.views.MyImageView) r0;
            r1.m5245a(r0);
            goto L_0x00d6;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter.ViewHolder.bindView(com.simplemobiletools.gallery.activities.SimpleActivity, com.a.a.a.a, com.a.a.a.b, com.simplemobiletools.gallery.models.Directory, int, boolean):android.view.View");
        }

        public final C0029b<Directory, C0055f> getItemClick() {
            return this.itemClick;
        }

        public final void viewClicked(com.p040a.p041a.p042a.C0966b r1, com.simplemobiletools.gallery.models.Directory r2, int r3) {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter.ViewHolder.viewClicked(com.a.a.a.b, com.simplemobiletools.gallery.models.Directory, int):void
	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:113)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:256)
	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:263)
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
	... 8 more
*/
            /*
            r0 = this;
            r2 = 1;
            r3 = 0;
            r0 = "multiSelector";
            p000a.p005e.p007b.C0036f.m62b(r7, r0);
            r0 = "directory";
            p000a.p005e.p007b.C0036f.m62b(r8, r0);
            r0 = r7.m5048a();
            if (r0 == 0) goto L_0x0072;
        L_0x0012:
            r0 = r7.m5050c();
            r1 = r6.getLayoutPosition();
            r1 = java.lang.Integer.valueOf(r1);
            r4 = r0.contains(r1);
            r0 = r6;
            r0 = (com.p040a.p041a.p042a.C0967e) r0;
            if (r4 != 0) goto L_0x005c;
        L_0x0027:
            r1 = r2;
            r7.m5046a(r0, r1);
            r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
            r1 = r6.itemView;
            r5 = "itemView";
            p000a.p005e.p007b.C0036f.m59a(r1, r5);
            if (r4 != 0) goto L_0x005e;
        L_0x0036:
            r0.toggleItemSelection(r1, r2, r9);
            r0 = r7.m5050c();
            r0 = r0.size();
            if (r0 != 0) goto L_0x0060;
        L_0x0043:
            r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
            r0 = r0.getActMode();
            if (r0 == 0) goto L_0x004e;
        L_0x004b:
            r0.m3116c();
            r0 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
            r0 = r0.getActMode();
            if (r0 == 0) goto L_0x005a;
            r0.m3117d();
            return;
        L_0x005c:
            r1 = r3;
            goto L_0x0028;
        L_0x005e:
            r2 = r3;
            goto L_0x0036;
        L_0x0060:
            r1 = com.simplemobiletools.gallery.adapters.DirectoryAdapter.Companion;
            r1 = r1.getActMode();
            if (r1 == 0) goto L_0x004f;
            r0 = java.lang.String.valueOf(r0);
            r0 = (java.lang.CharSequence) r0;
            r1.m3115b(r0);
            goto L_0x004f;
        L_0x0072:
            r0 = r6.itemClick;
            r0.invoke(r8);
            goto L_0x005b;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter.ViewHolder.viewClicked(com.a.a.a.b, com.simplemobiletools.gallery.models.Directory, int):void");
        }
    }

    static {
        Companion = new Companion();
        markedItems = new HashSet();
    }

    public DirectoryAdapter(SimpleActivity simpleActivity, List<Directory> list, DirOperationsListener dirOperationsListener, C0029b<? super Directory, C0055f> c0029b) {
        C0036f.m62b(simpleActivity, "activity");
        C0036f.m62b(list, "dirs");
        C0036f.m62b(c0029b, "itemClick");
        this.activity = simpleActivity;
        this.dirs = list;
        this.listener = dirOperationsListener;
        this.itemClick = c0029b;
        this.multiSelector = new C0966b();
        this.views = new ArrayList();
        this.config = Config.Companion.newInstance(this.activity);
        this.pinnedFolders = this.config.getPinnedFolders();
        this.multiSelectorMode = new DirectoryAdapter$multiSelectorMode$1(this, this.multiSelector);
    }

    private final void askConfirmDelete() {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog(this.activity, null, 0, 0, 0, new DirectoryAdapter$askConfirmDelete$1(this), 30, null);
    }

    private final void displayCopyDialog() {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : this.multiSelector.m5050c()) {
            Object[] objArr = (Object[]) new File(((Directory) this.dirs.get(intValue.intValue())).getPath()).listFiles();
            Collection arrayList2 = new ArrayList();
            for (Object obj : objArr) {
                File file = (File) obj;
                Object obj2 = (file.isFile() && FileKt.isImageVideoGif(file)) ? 1 : null;
                if (obj2 != null) {
                    arrayList2.add(obj);
                }
            }
            arrayList.addAll((List) arrayList2);
        }
        CopyDialog copyDialog = new CopyDialog(this.activity, arrayList, new DirectoryAdapter$displayCopyDialog$2(this));
    }

    private final HashSet<String> getSelectedPaths() {
        List<Integer> c = this.multiSelector.m5050c();
        HashSet<String> hashSet = new HashSet(c.size());
        for (Integer intValue : c) {
            hashSet.add(((Directory) this.dirs.get(intValue.intValue())).getPath());
        }
        return hashSet;
    }

    private final void hideFolders() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter.hideFolders():void
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
        r1 = r2.config;
        r0 = r2.getSelectedPaths();
        r0 = (java.util.Set) r0;
        r1.addHiddenFolders(r0);
        r0 = r2.listener;
        if (r0 == 0) goto L_0x0012;
    L_0x000f:
        r0.refreshItems();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter.hideFolders():void");
    }

    private final void pinFolder() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter.pinFolder():void
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
        r1 = r2.config;
        r0 = r2.getSelectedPaths();
        r0 = (java.util.Set) r0;
        r1.addPinnedFolders(r0);
        r0 = r2.config;
        r0 = r0.getPinnedFolders();
        r2.pinnedFolders = r0;
        r0 = r2.listener;
        if (r0 == 0) goto L_0x001a;
    L_0x0017:
        r0.refreshItems();
        r2.notifyDataSetChanged();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter.pinFolder():void");
    }

    private final void prepareForDeleting() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter.prepareForDeleting():void
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
        r0 = r6.multiSelector;
        r0 = r0.m5050c();
        r3 = new java.util.ArrayList;
        r1 = r0.size();
        r3.<init>(r1);
        r2 = new java.util.ArrayList;
        r1 = r0.size();
        r2.<init>(r1);
        p000a.p001a.C0011m.m30e(r0);
        r0 = (java.lang.Iterable) r0;
        r4 = r0.iterator();
    L_0x0022:
        r0 = r4.hasNext();
        if (r0 == 0) goto L_0x004d;
    L_0x0028:
        r0 = r4.next();
        r0 = (java.lang.Integer) r0;
        r1 = r6.dirs;
        r5 = r0.intValue();
        r1 = r1.get(r5);
        r1 = (com.simplemobiletools.gallery.models.Directory) r1;
        r5 = r1.getPath();
        r3.add(r5);
        r2.add(r1);
        r0 = r0.intValue();
        r6.notifyItemRemoved(r0);
        goto L_0x0022;
    L_0x004d:
        r1 = r6.dirs;
        r0 = r2;
        r0 = (java.util.Collection) r0;
        r1.removeAll(r0);
        r0 = r6.listener;
        if (r0 == 0) goto L_0x005c;
    L_0x0059:
        r0.prepareForDeleting(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter.prepareForDeleting():void");
    }

    private final void renameDir() {
        File file = new File(((Directory) this.dirs.get(((Number) this.multiSelector.m5050c().get(0)).intValue())).getPath());
        Context context = this.activity;
        Object absolutePath = file.getAbsolutePath();
        C0036f.m59a(absolutePath, "dir.absolutePath");
        if (ContextKt.isAStorageRootFolder(context, absolutePath)) {
            ContextKt.toast$default((Context) this.activity, (int) C1333R.string.rename_folder_root, 0, 2, null);
        } else {
            RenameDirectoryDialog renameDirectoryDialog = new RenameDirectoryDialog(this.activity, file, new DirectoryAdapter$renameDir$1(this));
        }
    }

    private final void showProperties() {
        List<Integer> c = this.multiSelector.m5050c();
        if (c.size() <= 1) {
            PropertiesDialog propertiesDialog = new PropertiesDialog((Context) this.activity, ((Directory) this.dirs.get(((Number) c.get(0)).intValue())).getPath(), this.config.getShowHiddenFolders());
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : c) {
            arrayList.add(((Directory) this.dirs.get(intValue.intValue())).getPath());
        }
        PropertiesDialog propertiesDialog2 = new PropertiesDialog((Context) this.activity, (List) arrayList, this.config.getShowHiddenFolders());
    }

    private final void unhideFolders() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter.unhideFolders():void
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
        r1 = r2.config;
        r0 = r2.getSelectedPaths();
        r0 = (java.util.Set) r0;
        r1.removeHiddenFolders(r0);
        r0 = r2.listener;
        if (r0 == 0) goto L_0x0012;
    L_0x000f:
        r0.refreshItems();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter.unhideFolders():void");
    }

    private final void unpinFolder() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.DirectoryAdapter.unpinFolder():void
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
        r1 = r2.config;
        r0 = r2.getSelectedPaths();
        r0 = (java.util.Set) r0;
        r1.removePinnedFolders(r0);
        r0 = r2.config;
        r0 = r0.getPinnedFolders();
        r2.pinnedFolders = r0;
        r0 = r2.listener;
        if (r0 == 0) goto L_0x001a;
    L_0x0017:
        r0.refreshItems();
        r2.notifyDataSetChanged();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.DirectoryAdapter.unpinFolder():void");
    }

    public final SimpleActivity getActivity() {
        return this.activity;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final List<Directory> getDirs() {
        return this.dirs;
    }

    public final C0029b<Directory, C0055f> getItemClick() {
        return this.itemClick;
    }

    public int getItemCount() {
        return this.dirs.size();
    }

    public final DirOperationsListener getListener() {
        return this.listener;
    }

    public final C0966b getMultiSelector() {
        return this.multiSelector;
    }

    public final C0965a getMultiSelectorMode() {
        return this.multiSelectorMode;
    }

    public final Set<String> getPinnedFolders() {
        return this.pinnedFolders;
    }

    public final ArrayList<View> getViews() {
        return this.views;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0036f.m62b(viewHolder, "holder");
        Directory directory = (Directory) this.dirs.get(i);
        this.views.add(viewHolder.bindView(this.activity, this.multiSelectorMode, this.multiSelector, directory, i, this.pinnedFolders.contains(directory.getPath())));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Object inflate = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null).inflate(C1333R.layout.directory_item, viewGroup, false);
        C0036f.m59a(inflate, "view");
        return new ViewHolder(inflate, this.itemClick);
    }

    public final void setPinnedFolders(Set<String> set) {
        C0036f.m62b(set, "<set-?>");
        this.pinnedFolders = set;
    }
}
