package com.simplemobiletools.fileproperties.dialogs;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.simplemobiletools.filepicker.extensions.FileKt;
import com.simplemobiletools.fileproperties.C1332R;
import com.simplemobiletools.fileproperties.extensions.LongKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import p000a.C0027d;
import p000a.p005e.p007b.C0034d;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0042h.C0040c;

public final class PropertiesDialog {
    private boolean mCountHiddenItems;
    private int mFilesCnt;
    public LayoutInflater mInflater;
    public ViewGroup mPropertyView;
    public Resources mResources;

    public PropertiesDialog(Context context, String str, boolean z) {
        C0036f.m62b(context, "context");
        C0036f.m62b(str, "path");
        this();
        this.mCountHiddenItems = z;
        Object from = LayoutInflater.from(context);
        C0036f.m59a(from, "LayoutInflater.from(context)");
        this.mInflater = from;
        from = context.getResources();
        C0036f.m59a(from, "context.resources");
        this.mResources = from;
        LayoutInflater layoutInflater = this.mInflater;
        if (layoutInflater == null) {
            C0036f.m63b("mInflater");
        }
        View inflate = layoutInflater.inflate(C1332R.layout.smtpr_item_properties, (ViewGroup) null);
        if (inflate == null) {
            throw new C0027d("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup = (ViewGroup) inflate;
        Object obj = (LinearLayout) viewGroup.findViewById(C1332R.id.smtpr_properties_holder);
        C0036f.m59a(obj, "view.smtpr_properties_holder");
        this.mPropertyView = (ViewGroup) obj;
        File file = new File(str);
        addProperty(C1332R.string.smtpr_name, file.getName());
        addProperty(C1332R.string.smtpr_path, file.getParent());
        addProperty(C1332R.string.smtpr_size, LongKt.formatSize(getItemSize(file)));
        addProperty(C1332R.string.smtpr_last_modified, LongKt.formatLastModified(file.lastModified()));
        if (file.isDirectory()) {
            addProperty(C1332R.string.smtpr_direct_children_count, getDirectChildrenCount(file, z));
            addProperty(C1332R.string.smtpr_files_count, String.valueOf(this.mFilesCnt));
        } else if (FileKt.isImageSlow(file)) {
            addProperty(C1332R.string.smtpr_resolution, com.simplemobiletools.fileproperties.extensions.FileKt.getImageResolution(file));
        } else if (FileKt.isAudioSlow(file)) {
            addProperty(C1332R.string.smtpr_duration, com.simplemobiletools.fileproperties.extensions.FileKt.getDuration(file));
            addProperty(C1332R.string.smtpr_artist, com.simplemobiletools.fileproperties.extensions.FileKt.getArtist(file));
            addProperty(C1332R.string.smtpr_album, com.simplemobiletools.fileproperties.extensions.FileKt.getAlbum(file));
        } else if (FileKt.isVideoSlow(file)) {
            addProperty(C1332R.string.smtpr_duration, com.simplemobiletools.fileproperties.extensions.FileKt.getDuration(file));
            addProperty(C1332R.string.smtpr_resolution, com.simplemobiletools.fileproperties.extensions.FileKt.getVideoResolution(file));
            addProperty(C1332R.string.smtpr_artist, com.simplemobiletools.fileproperties.extensions.FileKt.getArtist(file));
            addProperty(C1332R.string.smtpr_album, com.simplemobiletools.fileproperties.extensions.FileKt.getAlbum(file));
        }
        Builder builder = new Builder(context);
        Resources resources = this.mResources;
        if (resources == null) {
            C0036f.m63b("mResources");
        }
        AlertDialog create = builder.setTitle(resources.getString(C1332R.string.smtpr_properties)).setView(viewGroup).setPositiveButton(C1332R.string.smtpr_ok, (OnClickListener) null).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    public /* synthetic */ PropertiesDialog(Context context, String str, boolean z, int i, C0034d c0034d) {
        if ((i & 4) != 0) {
            z = false;
        }
        this(context, str, z);
    }

    public PropertiesDialog(Context context, List<String> list, boolean z) {
        C0036f.m62b(context, "context");
        C0036f.m62b(list, "paths");
        this();
        this.mCountHiddenItems = z;
        Object from = LayoutInflater.from(context);
        C0036f.m59a(from, "LayoutInflater.from(context)");
        this.mInflater = from;
        from = context.getResources();
        C0036f.m59a(from, "context.resources");
        this.mResources = from;
        LayoutInflater layoutInflater = this.mInflater;
        if (layoutInflater == null) {
            C0036f.m63b("mInflater");
        }
        View inflate = layoutInflater.inflate(C1332R.layout.smtpr_item_properties, (ViewGroup) null);
        if (inflate == null) {
            throw new C0027d("null cannot be cast to non-null type android.view.ViewGroup");
        }
        ViewGroup viewGroup = (ViewGroup) inflate;
        Object obj = (LinearLayout) viewGroup.findViewById(C1332R.id.smtpr_properties_holder);
        C0036f.m59a(obj, "view.smtpr_properties_holder");
        this.mPropertyView = (ViewGroup) obj;
        ArrayList arrayList = new ArrayList(list.size());
        for (String file : list) {
            arrayList.add(new File(file));
        }
        boolean isSameParent = isSameParent(arrayList);
        addProperty(C1332R.string.smtpr_items_selected, String.valueOf(list.size()));
        if (isSameParent) {
            addProperty(C1332R.string.smtpr_path, ((File) arrayList.get(0)).getParent());
        }
        addProperty(C1332R.string.smtpr_size, LongKt.formatSize(getItemsSize(arrayList)));
        addProperty(C1332R.string.smtpr_files_count, String.valueOf(this.mFilesCnt));
        Builder builder = new Builder(context);
        Resources resources = this.mResources;
        if (resources == null) {
            C0036f.m63b("mResources");
        }
        AlertDialog create = builder.setTitle(resources.getString(C1332R.string.smtpr_properties)).setView(viewGroup).setPositiveButton(C1332R.string.smtpr_ok, (OnClickListener) null).create();
        create.setCanceledOnTouchOutside(true);
        create.show();
    }

    public /* synthetic */ PropertiesDialog(Context context, List list, boolean z, int i, C0034d c0034d) {
        if ((i & 4) != 0) {
            z = false;
        }
        this(context, list, z);
    }

    private final void addProperty(int i, String str) {
        if (str != null) {
            LayoutInflater layoutInflater = this.mInflater;
            if (layoutInflater == null) {
                C0036f.m63b("mInflater");
            }
            int i2 = C1332R.layout.smtpr_property_item;
            ViewGroup viewGroup = this.mPropertyView;
            if (viewGroup == null) {
                C0036f.m63b("mPropertyView");
            }
            View inflate = layoutInflater.inflate(i2, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(C1332R.id.property_label);
            Resources resources = this.mResources;
            if (resources == null) {
                C0036f.m63b("mResources");
            }
            textView.setText(resources.getString(i));
            ((TextView) inflate.findViewById(C1332R.id.property_value)).setText(str);
            ViewGroup viewGroup2 = this.mPropertyView;
            if (viewGroup2 == null) {
                C0036f.m63b("mPropertyView");
            }
            ((LinearLayout) viewGroup2.findViewById(C1332R.id.smtpr_properties_holder)).addView(inflate);
        }
    }

    private final String getDirectChildrenCount(File file, boolean z) {
        Object[] objArr = (Object[]) file.listFiles();
        Collection arrayList = new ArrayList();
        for (Object obj : objArr) {
            File file2 = (File) obj;
            Object obj2 = (!file2.isHidden() || (file2.isHidden() && z)) ? 1 : null;
            if (obj2 != null) {
                arrayList.add(obj);
            }
        }
        return String.valueOf(((List) arrayList).size());
    }

    private final long getDirectorySize(File file) {
        long j = 0;
        if (file.exists()) {
            File[] listFiles = file.listFiles();
            int i = 0;
            int length = listFiles.length - 1;
            if (0 <= length) {
                while (true) {
                    if (listFiles[i].isDirectory()) {
                        Object obj = listFiles[i];
                        C0036f.m59a(obj, "files[i]");
                        j += getDirectorySize(obj);
                    } else if (!(listFiles[i].isHidden() || file.isHidden()) || this.mCountHiddenItems) {
                        this.mFilesCnt++;
                        j += listFiles[i].length();
                    }
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        }
        return j;
    }

    private final long getItemSize(File file) {
        if (file.isDirectory()) {
            return getDirectorySize(new File(file.getPath()));
        }
        this.mFilesCnt++;
        return file.length();
    }

    private final long getItemsSize(ArrayList<File> arrayList) {
        C0040c c0040c = new C0040c();
        c0040c.f12a = 0;
        for (File itemSize : arrayList) {
            c0040c.f12a += getItemSize(itemSize);
        }
        return c0040c.f12a;
    }

    private final boolean isSameParent(List<? extends File> list) {
        String parent = ((File) list.get(0)).getParent();
        Object obj = parent;
        for (File parent2 : list) {
            Object parent3 = parent2.getParent();
            if ((C0036f.m61a(parent3, obj) ^ 1) != 0) {
                return false;
            }
            obj = parent3;
        }
        return true;
    }

    public final LayoutInflater getMInflater() {
        LayoutInflater layoutInflater = this.mInflater;
        if (layoutInflater == null) {
            C0036f.m63b("mInflater");
        }
        return layoutInflater;
    }

    public final ViewGroup getMPropertyView() {
        ViewGroup viewGroup = this.mPropertyView;
        if (viewGroup == null) {
            C0036f.m63b("mPropertyView");
        }
        return viewGroup;
    }

    public final Resources getMResources() {
        Resources resources = this.mResources;
        if (resources == null) {
            C0036f.m63b("mResources");
        }
        return resources;
    }

    public final void setMInflater(LayoutInflater layoutInflater) {
        C0036f.m62b(layoutInflater, "<set-?>");
        this.mInflater = layoutInflater;
    }

    public final void setMPropertyView(ViewGroup viewGroup) {
        C0036f.m62b(viewGroup, "<set-?>");
        this.mPropertyView = viewGroup;
    }

    public final void setMResources(Resources resources) {
        C0036f.m62b(resources, "<set-?>");
        this.mResources = resources;
    }
}
