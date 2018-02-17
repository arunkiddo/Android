package com.simplemobiletools.filepicker.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Environment;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.simplemobiletools.filepicker.C1328R;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.StringKt;
import com.simplemobiletools.filepicker.models.FileDirItem;
import com.simplemobiletools.filepicker.views.Breadcrumbs;
import com.simplemobiletools.filepicker.views.Breadcrumbs.BreadcrumbsListener;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import p000a.C0027d;
import p000a.p005e.p007b.C0034d;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0078o;

public final class FilePickerDialog implements BreadcrumbsListener {
    private final Context context;
    private String currPath;
    private final OnFilePickerListener listener;
    public AlertDialog mDialog;
    public View mDialogView;
    private boolean mFirstUpdate;
    private String mPrevPath;
    private HashMap<String, Parcelable> mScrollStates;
    private final boolean pickFile;
    private final boolean showHidden;

    /* renamed from: com.simplemobiletools.filepicker.dialogs.FilePickerDialog.1 */
    public static final class C13291 implements OnGlobalLayoutListener {
        final /* synthetic */ FilePickerDialog this$0;

        C13291(FilePickerDialog filePickerDialog) {
            this.this$0 = filePickerDialog;
        }

        public void onGlobalLayout() {
            C13291 c13291 = this;
            Rect rect = new Rect();
            RecyclerView recyclerView = (RecyclerView) this.this$0.getMDialogView().findViewById(C1328R.id.directory_picker_list);
            recyclerView.getGlobalVisibleRect(rect);
            recyclerView.getLayoutParams().height = rect.bottom - rect.top;
            recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(c13291);
        }
    }

    /* renamed from: com.simplemobiletools.filepicker.dialogs.FilePickerDialog.2 */
    static final class C13302 implements OnClickListener {
        final /* synthetic */ FilePickerDialog this$0;

        C13302(FilePickerDialog filePickerDialog) {
            this.this$0 = filePickerDialog;
        }

        public final void onClick(View view) {
            this.this$0.verifyPath();
        }
    }

    public enum FilePickerResult {
    }

    public interface OnFilePickerListener {
        void onFail(FilePickerResult filePickerResult);

        void onSuccess(String str);
    }

    public FilePickerDialog(Context context, String str, boolean z, boolean z2, OnFilePickerListener onFilePickerListener) {
        C0036f.m62b(context, "context");
        C0036f.m62b(str, "currPath");
        C0036f.m62b(onFilePickerListener, "listener");
        this.context = context;
        this.currPath = str;
        this.pickFile = z;
        this.showHidden = z2;
        this.listener = onFilePickerListener;
        this.mFirstUpdate = true;
        this.mPrevPath = BuildConfig.FLAVOR;
        this.mScrollStates = new HashMap();
        if (ContextKt.hasStoragePermission(this.context)) {
            if (!new File(this.currPath).exists()) {
                this.currPath = ContextKt.getInternalStoragePath(this.context);
            }
            Object inflate = LayoutInflater.from(this.context).inflate(C1328R.layout.smtfp_directory_picker, (ViewGroup) null);
            C0036f.m59a(inflate, "LayoutInflater.from(cont\u2026p_directory_picker, null)");
            this.mDialogView = inflate;
            updateItems();
            setupBreadcrumbs();
            View view = this.mDialogView;
            if (view == null) {
                C0036f.m63b("mDialogView");
            }
            ((RecyclerView) view.findViewById(C1328R.id.directory_picker_list)).getViewTreeObserver().addOnGlobalLayoutListener(new C13291(this));
            Builder title = new Builder(this.context).setTitle(getTitle());
            View view2 = this.mDialogView;
            if (view2 == null) {
                C0036f.m63b("mDialogView");
            }
            title = title.setView(view2).setNegativeButton(C1328R.string.smtfp_cancel, new FilePickerDialog$builder$1(this)).setOnCancelListener(new FilePickerDialog$builder$2(this)).setOnKeyListener(new FilePickerDialog$builder$3(this));
            if (!this.pickFile) {
                title.setPositiveButton(C1328R.string.smtfp_ok, (DialogInterface.OnClickListener) null);
            }
            inflate = title.create();
            C0036f.m59a(inflate, "builder.create()");
            this.mDialog = inflate;
            AlertDialog alertDialog = this.mDialog;
            if (alertDialog == null) {
                C0036f.m63b("mDialog");
            }
            alertDialog.setCanceledOnTouchOutside(true);
            alertDialog = this.mDialog;
            if (alertDialog == null) {
                C0036f.m63b("mDialog");
            }
            alertDialog.show();
            if (!this.pickFile) {
                alertDialog = this.mDialog;
                if (alertDialog == null) {
                    C0036f.m63b("mDialog");
                }
                alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new C13302(this));
                return;
            }
            return;
        }
        this.listener.onFail(FilePickerResult.NO_PERMISSION);
    }

    public /* synthetic */ FilePickerDialog(Context context, String str, boolean z, boolean z2, OnFilePickerListener onFilePickerListener, int i, C0034d c0034d) {
        String file;
        if ((i & 2) != 0) {
            file = Environment.getExternalStorageDirectory().toString();
            C0036f.m59a((Object) file, "Environment.getExternalS\u2026ageDirectory().toString()");
        } else {
            file = str;
        }
        this(context, file, (i & 4) != 0 ? true : z, (i & 8) != 0 ? false : z2, onFilePickerListener);
    }

    private final boolean containsDirectory(List<FileDirItem> list) {
        for (FileDirItem isDirectory : list) {
            if (isDirectory.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    private final void dialogDismissed() {
        this.listener.onFail(FilePickerResult.DISMISS);
    }

    private final int getChildren(File file) {
        if (file.listFiles() == null || !file.isDirectory()) {
            return 0;
        }
        Object[] objArr = (Object[]) file.listFiles();
        Collection arrayList = new ArrayList();
        for (Object obj : objArr) {
            File file2 = (File) obj;
            int i = (!file2.isHidden() || (file2.isHidden() && this.showHidden)) ? 1 : 0;
            if (i != 0) {
                arrayList.add(obj);
            }
        }
        return ((List) arrayList).size();
    }

    private final List<FileDirItem> getItems(String str) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return arrayList;
        }
        for (Object obj : listFiles) {
            if (this.showHidden || !obj.isHidden()) {
                Object absolutePath = obj.getAbsolutePath();
                String filenameFromPath = StringKt.getFilenameFromPath(absolutePath);
                long length = obj.length();
                C0036f.m59a(absolutePath, "curPath");
                boolean isDirectory = obj.isDirectory();
                C0036f.m59a(obj, "file");
                arrayList.add(new FileDirItem(absolutePath, filenameFromPath, isDirectory, getChildren(obj), length));
            }
        }
        return arrayList;
    }

    private final String getTitle() {
        return this.context.getResources().getString(this.pickFile ? C1328R.string.smtfp_select_file : C1328R.string.smtfp_select_folder);
    }

    private final void sendSuccess() {
        this.listener.onSuccess(this.currPath);
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog == null) {
            C0036f.m63b("mDialog");
        }
        alertDialog.dismiss();
    }

    private final void setupBreadcrumbs() {
        View view = this.mDialogView;
        if (view == null) {
            C0036f.m63b("mDialogView");
        }
        ((Breadcrumbs) view.findViewById(C1328R.id.directory_picker_breadcrumbs)).setListener(this);
    }

    private final void updateItems() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.filepicker.dialogs.FilePickerDialog.updateItems():void
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
        r9 = 47;
        r8 = 1;
        r7 = 0;
        r0 = r10.currPath;
        r0 = r10.getItems(r0);
        r1 = r10.containsDirectory(r0);
        if (r1 != 0) goto L_0x001c;
    L_0x0010:
        r1 = r10.mFirstUpdate;
        if (r1 != 0) goto L_0x001c;
    L_0x0014:
        r1 = r10.pickFile;
        if (r1 != 0) goto L_0x001c;
    L_0x0018:
        r10.verifyPath();
        return;
    L_0x001c:
        r0 = (java.lang.Iterable) r0;
        r1 = 2;
        r2 = new p000a.p005e.p006a.C0029b[r1];
        r1 = com.simplemobiletools.filepicker.dialogs.FilePickerDialog$updateItems$1.INSTANCE;
        r1 = (p000a.p005e.p006a.C0029b) r1;
        r2[r7] = r1;
        r1 = com.simplemobiletools.filepicker.dialogs.FilePickerDialog$updateItems$2.INSTANCE;
        r1 = (p000a.p005e.p006a.C0029b) r1;
        r2[r8] = r1;
        r1 = p000a.p002b.C0018a.m42a(r2);
        r1 = p000a.p001a.C0011m.m22a(r0, r1);
        r4 = new com.simplemobiletools.filepicker.adapters.ItemsAdapter;
        r2 = r10.context;
        r0 = new com.simplemobiletools.filepicker.dialogs.FilePickerDialog$updateItems$adapter$1;
        r0.<init>(r10);
        r0 = (p000a.p005e.p006a.C0029b) r0;
        r4.<init>(r2, r1, r0);
        r0 = r10.mDialogView;
        if (r0 != 0) goto L_0x004c;
    L_0x0047:
        r1 = "mDialogView";
        p000a.p005e.p007b.C0036f.m63b(r1);
    L_0x004c:
        r1 = com.simplemobiletools.filepicker.C1328R.id.directory_picker_list;
        r0 = r0.findViewById(r1);
        r0 = (android.support.v7.widget.RecyclerView) r0;
        r0 = r0.getLayoutManager();
        if (r0 != 0) goto L_0x0062;
    L_0x005a:
        r0 = new a.d;
        r1 = "null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager";
        r0.<init>(r1);
        throw r0;
    L_0x0062:
        r0 = (android.support.v7.widget.LinearLayoutManager) r0;
        r1 = r10.mScrollStates;
        r2 = r10.mPrevPath;
        r3 = new char[r8];
        r3[r7] = r9;
        r2 = p000a.p011i.C0078o.m121a(r2, r3);
        r3 = r0.m3934d();
        r1.put(r2, r3);
        r1 = r10.mDialogView;
        if (r1 != 0) goto L_0x0080;
    L_0x007b:
        r2 = "mDialogView";
        p000a.p005e.p007b.C0036f.m63b(r2);
        r1 = (android.view.View) r1;
        r2 = com.simplemobiletools.filepicker.C1328R.id.directory_picker_list;
        r2 = r1.findViewById(r2);
        r2 = (android.support.v7.widget.RecyclerView) r2;
        r2 = r2.getAdapter();
        if (r2 != 0) goto L_0x00ac;
        r2 = com.simplemobiletools.filepicker.C1328R.id.directory_picker_list;
        r2 = r1.findViewById(r2);
        r2 = (android.support.v7.widget.RecyclerView) r2;
        r3 = new com.simplemobiletools.filepicker.views.RecyclerViewDivider;
        r5 = r1.getContext();
        r6 = "context";
        p000a.p005e.p007b.C0036f.m59a(r5, r6);
        r3.<init>(r5);
        r3 = (android.support.v7.widget.RecyclerView.C0838g) r3;
        r2.addItemDecoration(r3);
        r2 = com.simplemobiletools.filepicker.C1328R.id.directory_picker_list;
        r2 = r1.findViewById(r2);
        r2 = (android.support.v7.widget.RecyclerView) r2;
        r3 = r4;
        r3 = (android.support.v7.widget.RecyclerView.C0829a) r3;
        r2.setAdapter(r3);
        r2 = com.simplemobiletools.filepicker.C1328R.id.directory_picker_breadcrumbs;
        r1 = r1.findViewById(r2);
        r1 = (com.simplemobiletools.filepicker.views.Breadcrumbs) r1;
        r2 = r10.currPath;
        r1.setBreadcrumb(r2);
        r1 = r10.mScrollStates;
        r2 = r10.currPath;
        r3 = new char[r8];
        r3[r7] = r9;
        r2 = p000a.p011i.C0078o.m121a(r2, r3);
        r1 = r1.get(r2);
        r1 = (android.os.Parcelable) r1;
        r0.m3914a(r1);
        r10.mFirstUpdate = r7;
        r0 = r10.currPath;
        r10.mPrevPath = r0;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.filepicker.dialogs.FilePickerDialog.updateItems():void");
    }

    private final void verifyPath() {
        File file = new File(this.currPath);
        if ((this.pickFile && file.isFile()) || (!this.pickFile && file.isDirectory())) {
            sendSuccess();
        }
    }

    public void breadcrumbClicked(int i) {
        if (i == 0) {
            StoragePickerDialog storagePickerDialog = new StoragePickerDialog(this.context, this.currPath, new FilePickerDialog$breadcrumbClicked$1(this));
            return;
        }
        View view = this.mDialogView;
        if (view == null) {
            C0036f.m63b("mDialogView");
        }
        Object tag = ((Breadcrumbs) view.findViewById(C1328R.id.directory_picker_breadcrumbs)).getChildAt(i).getTag();
        if (tag == null) {
            throw new C0027d("null cannot be cast to non-null type com.simplemobiletools.filepicker.models.FileDirItem");
        }
        FileDirItem fileDirItem = (FileDirItem) tag;
        if ((C0036f.m61a(this.currPath, C0078o.m121a(fileDirItem.getPath(), '/')) ^ 1) != 0) {
            this.currPath = fileDirItem.getPath();
            updateItems();
        }
    }

    public final Context getContext() {
        return this.context;
    }

    public final String getCurrPath() {
        return this.currPath;
    }

    public final OnFilePickerListener getListener() {
        return this.listener;
    }

    public final AlertDialog getMDialog() {
        AlertDialog alertDialog = this.mDialog;
        if (alertDialog == null) {
            C0036f.m63b("mDialog");
        }
        return alertDialog;
    }

    public final View getMDialogView() {
        View view = this.mDialogView;
        if (view == null) {
            C0036f.m63b("mDialogView");
        }
        return view;
    }

    public final boolean getMFirstUpdate() {
        return this.mFirstUpdate;
    }

    public final String getMPrevPath() {
        return this.mPrevPath;
    }

    public final HashMap<String, Parcelable> getMScrollStates() {
        return this.mScrollStates;
    }

    public final boolean getPickFile() {
        return this.pickFile;
    }

    public final boolean getShowHidden() {
        return this.showHidden;
    }

    public final void setCurrPath(String str) {
        C0036f.m62b(str, "<set-?>");
        this.currPath = str;
    }

    public final void setMDialog(AlertDialog alertDialog) {
        C0036f.m62b(alertDialog, "<set-?>");
        this.mDialog = alertDialog;
    }

    public final void setMDialogView(View view) {
        C0036f.m62b(view, "<set-?>");
        this.mDialogView = view;
    }

    public final void setMFirstUpdate(boolean z) {
        this.mFirstUpdate = z;
    }

    public final void setMPrevPath(String str) {
        C0036f.m62b(str, "<set-?>");
        this.mPrevPath = str;
    }

    public final void setMScrollStates(HashMap<String, Parcelable> hashMap) {
        C0036f.m62b(hashMap, "<set-?>");
        this.mScrollStates = hashMap;
    }
}
