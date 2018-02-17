package com.simplemobiletools.gallery.adapters;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p021b.C0279p;
import android.support.v7.view.C0716b;
import android.support.v7.widget.RecyclerView.C0829a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.p040a.p041a.p042a.C0965a;
import com.p040a.p041a.p042a.C0966b;
import com.p040a.p041a.p042a.C0972f;
import com.p045c.p046a.C1288i;
import com.p045c.p046a.p050d.C1012a;
import com.p045c.p046a.p050d.C1081c;
import com.p045c.p046a.p050d.p052b.C1056b;
import com.p045c.p046a.p074i.C1287c;
import com.simplemobiletools.filepicker.dialogs.ConfirmationDialog;
import com.simplemobiletools.fileproperties.dialogs.PropertiesDialog;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.activities.SimpleActivity;
import com.simplemobiletools.gallery.dialogs.CopyDialog;
import com.simplemobiletools.gallery.dialogs.RenameFileDialog;
import com.simplemobiletools.gallery.extensions.ActivityKt;
import com.simplemobiletools.gallery.extensions.ViewKt;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.models.Medium;
import com.simplemobiletools.gallery.views.MyImageView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import p000a.C0055f;
import p000a.p005e.p006a.C0029b;
import p000a.p005e.p007b.C0036f;

public final class MediaAdapter extends C0829a<ViewHolder> {
    public static final Companion Companion;
    private static C0716b actMode;
    private static boolean displayFilenames;
    private static final HashSet<Integer> markedItems;
    private final SimpleActivity activity;
    private final Config config;
    private final C0029b<Medium, C0055f> itemClick;
    private final MediaOperationsListener listener;
    private List<Medium> media;
    private final C0966b multiSelector;
    private final C0965a multiSelectorMode;
    private final ArrayList<View> views;

    public interface MediaOperationsListener {
        void deleteFiles(ArrayList<File> arrayList);

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
            return MediaAdapter.actMode;
        }

        public final boolean getDisplayFilenames() {
            return MediaAdapter.displayFilenames;
        }

        public final HashSet<Integer> getMarkedItems() {
            return MediaAdapter.markedItems;
        }

        public final void setActMode(C0716b c0716b) {
            MediaAdapter.actMode = c0716b;
        }

        public final void setDisplayFilenames(boolean z) {
            MediaAdapter.displayFilenames = z;
        }

        public final void toggleItemSelection(View view, boolean z, int i) {
            C0036f.m62b(view, "itemView");
            if (VERSION.SDK_INT < 23) {
                ((FrameLayout) view.findViewById(C1333R.id.medium_thumbnail_holder)).setSelected(z);
            } else {
                ((MyImageView) view.findViewById(C1333R.id.medium_thumbnail)).setSelected(z);
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
        private final C0029b<Medium, C0055f> itemClick;

        public ViewHolder(View view, C0029b<? super Medium, C0055f> c0029b) {
            C0036f.m62b(view, "view");
            C0036f.m62b(c0029b, "itemClick");
            super(view, new C0966b());
            this.itemClick = c0029b;
        }

        public final View bindView(SimpleActivity simpleActivity, C0965a c0965a, C0966b c0966b, Medium medium, int i) {
            C0036f.m62b(simpleActivity, "activity");
            C0036f.m62b(c0965a, "multiSelectorCallback");
            C0036f.m62b(c0966b, "multiSelector");
            C0036f.m62b(medium, "medium");
            ((ImageView) this.itemView.findViewById(C1333R.id.play_outline)).setVisibility(medium.isVideo() ? 0 : 8);
            ViewKt.beVisibleIf((TextView) this.itemView.findViewById(C1333R.id.file_name), MediaAdapter.Companion.getDisplayFilenames());
            ((TextView) this.itemView.findViewById(C1333R.id.file_name)).setText(medium.getName());
            Companion companion = MediaAdapter.Companion;
            Object obj = this.itemView;
            C0036f.m59a(obj, "itemView");
            companion.toggleItemSelection(obj, MediaAdapter.Companion.getMarkedItems().contains(Integer.valueOf(i)), i);
            String path = medium.getPath();
            C1287c c1287c = new C1287c(String.valueOf(medium.getDate_modified()));
            if (medium.isGif()) {
                C1288i.m6074a((C0279p) simpleActivity).m6137a(path).m5856i().m5934a(C1056b.NONE).m5936a((C1081c) c1287c).m5117a((ImageView) (MyImageView) this.itemView.findViewById(C1333R.id.medium_thumbnail));
            } else if (medium.isPng()) {
                C1288i.m6074a((C0279p) simpleActivity).m6137a(path).m5855h().m5136a(C1012a.PREFER_ARGB_8888).m5137a(C1056b.RESULT).m5139a((C1081c) c1287c).m5134a((int) C1333R.color.tmb_background).m5133a().m5145a((MyImageView) this.itemView.findViewById(C1333R.id.medium_thumbnail));
            } else {
                C1288i.m6074a((C0279p) simpleActivity).m6137a(path).m5238a(C1056b.RESULT).m5240a((C1081c) c1287c).m5236a((int) C1333R.color.tmb_background).m5235a().m5256c().m5245a((MyImageView) this.itemView.findViewById(C1333R.id.medium_thumbnail));
            }
            this.itemView.setOnClickListener(new MediaAdapter$ViewHolder$bindView$1(this, c0966b, medium, i));
            this.itemView.setOnLongClickListener(new MediaAdapter$ViewHolder$bindView$2(this, c0966b, simpleActivity, c0965a, i));
            Object obj2 = this.itemView;
            C0036f.m59a(obj2, "itemView");
            return obj2;
        }

        public final C0029b<Medium, C0055f> getItemClick() {
            return this.itemClick;
        }

        public final void viewClicked(com.p040a.p041a.p042a.C0966b r1, com.simplemobiletools.gallery.models.Medium r2, int r3) {
            /* JADX: method processing error */
/*
            Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.MediaAdapter.ViewHolder.viewClicked(com.a.a.a.b, com.simplemobiletools.gallery.models.Medium, int):void
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
            r0 = "medium";
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
            r0 = com.simplemobiletools.gallery.adapters.MediaAdapter.Companion;
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
            r0 = com.simplemobiletools.gallery.adapters.MediaAdapter.Companion;
            r0 = r0.getActMode();
            if (r0 == 0) goto L_0x004e;
        L_0x004b:
            r0.m3116c();
            r0 = com.simplemobiletools.gallery.adapters.MediaAdapter.Companion;
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
            r1 = com.simplemobiletools.gallery.adapters.MediaAdapter.Companion;
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
            throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.MediaAdapter.ViewHolder.viewClicked(com.a.a.a.b, com.simplemobiletools.gallery.models.Medium, int):void");
        }
    }

    static {
        Companion = new Companion();
        markedItems = new HashSet();
    }

    public MediaAdapter(SimpleActivity simpleActivity, List<Medium> list, MediaOperationsListener mediaOperationsListener, C0029b<? super Medium, C0055f> c0029b) {
        C0036f.m62b(simpleActivity, "activity");
        C0036f.m62b(list, "media");
        C0036f.m62b(c0029b, "itemClick");
        this.activity = simpleActivity;
        this.media = list;
        this.listener = mediaOperationsListener;
        this.itemClick = c0029b;
        this.multiSelector = new C0966b();
        this.views = new ArrayList();
        this.config = Config.Companion.newInstance(this.activity);
        this.multiSelectorMode = new MediaAdapter$multiSelectorMode$1(this, this.multiSelector);
    }

    private final void askConfirmDelete() {
        ConfirmationDialog confirmationDialog = new ConfirmationDialog(this.activity, null, 0, 0, 0, new MediaAdapter$askConfirmDelete$1(this), 30, null);
    }

    private final void deleteFiles() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.MediaAdapter.deleteFiles():void
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
        r0 = r7.multiSelector;
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
        if (r0 == 0) goto L_0x0052;
    L_0x0028:
        r0 = r4.next();
        r0 = (java.lang.Integer) r0;
        r1 = r7.media;
        r5 = r0.intValue();
        r1 = r1.get(r5);
        r1 = (com.simplemobiletools.gallery.models.Medium) r1;
        r5 = new java.io.File;
        r6 = r1.getPath();
        r5.<init>(r6);
        r3.add(r5);
        r2.add(r1);
        r0 = r0.intValue();
        r7.notifyItemRemoved(r0);
        goto L_0x0022;
    L_0x0052:
        r1 = r7.media;
        r0 = r2;
        r0 = (java.util.Collection) r0;
        r1.removeAll(r0);
        r0 = r7.listener;
        if (r0 == 0) goto L_0x0061;
    L_0x005e:
        r0.deleteFiles(r3);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.MediaAdapter.deleteFiles():void");
    }

    private final void displayCopyDialog() {
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : this.multiSelector.m5050c()) {
            arrayList.add(new File(((Medium) this.media.get(intValue.intValue())).getPath()));
        }
        CopyDialog copyDialog = new CopyDialog(this.activity, arrayList, new MediaAdapter$displayCopyDialog$2(this));
    }

    private final void editFile() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.MediaAdapter.editFile():void
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
        r0 = r2.activity;
        r0 = (android.app.Activity) r0;
        r1 = r2.getCurrentFile();
        com.simplemobiletools.gallery.extensions.ActivityKt.openEditor(r0, r1);
        r0 = Companion;
        r0 = r0.getActMode();
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r0.m3116c();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.MediaAdapter.editFile():void");
    }

    private final File getCurrentFile() {
        return new File(((Medium) this.media.get(((Number) this.multiSelector.m5050c().get(0)).intValue())).getPath());
    }

    private final List<Medium> getSelectedMedia() {
        List<Integer> c = this.multiSelector.m5050c();
        ArrayList arrayList = new ArrayList(c.size());
        for (Integer intValue : c) {
            arrayList.add(this.media.get(intValue.intValue()));
        }
        return arrayList;
    }

    private final void renameFile() {
        RenameFileDialog renameFileDialog = new RenameFileDialog(this.activity, getCurrentFile(), new MediaAdapter$renameFile$1(this));
    }

    private final void shareMedia() {
        if (this.multiSelector.m5050c().size() <= 1) {
            ActivityKt.shareMedium(this.activity, (Medium) getSelectedMedia().get(0));
        } else {
            ActivityKt.shareMedia(this.activity, getSelectedMedia());
        }
    }

    private final void showProperties() {
        List<Integer> c = this.multiSelector.m5050c();
        if (c.size() <= 1) {
            PropertiesDialog propertiesDialog = new PropertiesDialog((Context) this.activity, ((Medium) this.media.get(((Number) c.get(0)).intValue())).getPath(), this.config.getShowHiddenFolders());
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer intValue : c) {
            arrayList.add(((Medium) this.media.get(intValue.intValue())).getPath());
        }
        PropertiesDialog propertiesDialog2 = new PropertiesDialog((Context) this.activity, (List) arrayList, this.config.getShowHiddenFolders());
    }

    public final SimpleActivity getActivity() {
        return this.activity;
    }

    public final Config getConfig() {
        return this.config;
    }

    public final C0029b<Medium, C0055f> getItemClick() {
        return this.itemClick;
    }

    public int getItemCount() {
        return this.media.size();
    }

    public final MediaOperationsListener getListener() {
        return this.listener;
    }

    public final List<Medium> getMedia() {
        return this.media;
    }

    public final C0966b getMultiSelector() {
        return this.multiSelector;
    }

    public final C0965a getMultiSelectorMode() {
        return this.multiSelectorMode;
    }

    public final ArrayList<View> getViews() {
        return this.views;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        C0036f.m62b(viewHolder, "holder");
        this.views.add(viewHolder.bindView(this.activity, this.multiSelectorMode, this.multiSelector, (Medium) this.media.get(i), i));
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Object inflate = LayoutInflater.from(viewGroup != null ? viewGroup.getContext() : null).inflate(C1333R.layout.photo_video_item, viewGroup, false);
        C0036f.m59a(inflate, "view");
        return new ViewHolder(inflate, this.itemClick);
    }

    public final void selectAll() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.adapters.MediaAdapter.selectAll():void
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
        r0 = r7.media;
        r1 = r0.size();
        r0 = 0;
        r2 = r1 + -1;
        if (r0 > r2) goto L_0x0028;
    L_0x000b:
        r3 = Companion;
        r3 = r3.getMarkedItems();
        r4 = java.lang.Integer.valueOf(r0);
        r3.add(r4);
        r3 = r7.multiSelector;
        r4 = 0;
        r6 = 1;
        r3.m5044a(r0, r4, r6);
        r7.notifyItemChanged(r0);
        if (r0 == r2) goto L_0x0028;
    L_0x0025:
        r0 = r0 + 1;
        goto L_0x000b;
    L_0x0028:
        r0 = Companion;
        r2 = r0.getActMode();
        if (r2 == 0) goto L_0x0039;
    L_0x0030:
        r0 = java.lang.String.valueOf(r1);
        r0 = (java.lang.CharSequence) r0;
        r2.m3115b(r0);
    L_0x0039:
        r0 = Companion;
        r0 = r0.getActMode();
        if (r0 == 0) goto L_0x0044;
    L_0x0041:
        r0.m3117d();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.adapters.MediaAdapter.selectAll():void");
    }

    public final void setMedia(List<Medium> list) {
        C0036f.m62b(list, "<set-?>");
        this.media = list;
    }

    public final void updateDisplayFilenames(boolean z) {
        Companion.setDisplayFilenames(z);
        notifyDataSetChanged();
    }

    public final void updateMedia(ArrayList<Medium> arrayList) {
        C0036f.m62b(arrayList, "newMedia");
        this.media = arrayList;
        notifyDataSetChanged();
    }
}
