package com.simplemobiletools.filepicker.views;

import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.simplemobiletools.filepicker.C1328R;
import com.simplemobiletools.filepicker.extensions.ContextKt;
import com.simplemobiletools.filepicker.extensions.StringKt;
import com.simplemobiletools.filepicker.models.FileDirItem;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import p000a.C0027d;
import p000a.p001a.C0006h;
import p000a.p001a.C0011m;
import p000a.p005e.p007b.C0036f;
import p000a.p011i.C0069f;
import p000a.p011i.C0078o;

public final class Breadcrumbs extends LinearLayout implements OnClickListener {
    private HashMap _$_findViewCache;
    private int mDeviceWidth;
    private LayoutInflater mInflater;
    private BreadcrumbsListener mListener;

    public interface BreadcrumbsListener {
        void breadcrumbClicked(int i);
    }

    public Breadcrumbs(Context context, AttributeSet attributeSet) {
        C0036f.m62b(context, "context");
        C0036f.m62b(attributeSet, "attrs");
        super(context, attributeSet);
        Object systemService = context.getSystemService("layout_inflater");
        if (systemService == null) {
            throw new C0027d("null cannot be cast to non-null type android.view.LayoutInflater");
        }
        this.mInflater = (LayoutInflater) systemService;
        this.mDeviceWidth = getDeviceWidth();
    }

    private final void addBreadcrumb(FileDirItem fileDirItem, boolean z) {
        View inflate = this.mInflater.inflate(C1328R.layout.smtfp_breadcrumb_item, (ViewGroup) null, false);
        String name = fileDirItem.getName();
        if (z) {
            name = " -> " + name;
        }
        ((TextView) inflate.findViewById(C1328R.id.breadcrumb_text)).setText(name);
        addView(inflate);
        inflate.setOnClickListener(this);
        inflate.setTag(fileDirItem);
    }

    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        view = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    public final int getDeviceWidth() {
        Object systemService = getContext().getSystemService("window");
        if (systemService == null) {
            throw new C0027d("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    public final FileDirItem getLastItem() {
        Object tag = getChildAt(getChildCount() - 1).getTag();
        if (tag != null) {
            return (FileDirItem) tag;
        }
        throw new C0027d("null cannot be cast to non-null type com.simplemobiletools.filepicker.models.FileDirItem");
    }

    public void onClick(android.view.View r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.filepicker.views.Breadcrumbs.onClick(android.view.View):void
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
        r0 = "v";
        p000a.p005e.p007b.C0036f.m62b(r4, r0);
        r1 = r3.getChildCount();
        r0 = 0;
        r1 = r1 + -1;
        if (r0 > r1) goto L_0x002b;
    L_0x000e:
        r2 = r3.getChildAt(r0);
        if (r2 == 0) goto L_0x0026;
    L_0x0014:
        r2 = r3.getChildAt(r0);
        r2 = p000a.p005e.p007b.C0036f.m61a(r2, r4);
        if (r2 == 0) goto L_0x0026;
    L_0x001e:
        r2 = r3.mListener;
        if (r2 == 0) goto L_0x0025;
    L_0x0022:
        r2.breadcrumbClicked(r0);
    L_0x0026:
        if (r0 == r1) goto L_0x002b;
        r0 = r0 + 1;
        goto L_0x000e;
    L_0x002b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.filepicker.views.Breadcrumbs.onClick(android.view.View):void");
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth() - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingBottom()) - getPaddingTop();
        int paddingLeft = (this.mDeviceWidth - getPaddingLeft()) - getPaddingRight();
        int i5 = 0;
        int paddingLeft2 = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        int childCount = getChildCount() - 1;
        if (0 <= childCount) {
            while (true) {
                View childAt = getChildAt(i6);
                childAt.measure(MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(measuredHeight, Integer.MIN_VALUE));
                int measuredWidth2 = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                if (paddingLeft2 + measuredWidth2 >= measuredWidth) {
                    paddingLeft2 = getPaddingLeft();
                    paddingTop += i5;
                    i5 = 0;
                }
                childAt.layout(paddingLeft2, paddingTop, paddingLeft2 + measuredWidth2, paddingTop + measuredHeight2);
                if (i5 < measuredHeight2) {
                    i5 = measuredHeight2;
                }
                paddingLeft2 += measuredWidth2;
                if (i6 != childCount) {
                    i6++;
                } else {
                    return;
                }
            }
        }
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        int paddingLeft = (this.mDeviceWidth - getPaddingLeft()) - getPaddingRight();
        int i4 = 1;
        int childCount = getChildCount() - 1;
        if (0 <= childCount) {
            int measuredHeight;
            int i5 = 0;
            while (true) {
                View childAt = getChildAt(i3);
                measureChild(childAt, i, i2);
                i5 += childAt.getMeasuredWidth();
                measuredHeight = childAt.getMeasuredHeight();
                if (i5 / paddingLeft > 0) {
                    i4++;
                    i5 = childAt.getMeasuredWidth();
                }
                if (i3 == childCount) {
                    break;
                }
                i3++;
            }
            i3 = measuredHeight;
        }
        setMeasuredDimension(MeasureSpec.getSize(i), (i3 * i4) + (getPaddingTop() + getPaddingBottom()));
    }

    public final void removeBreadcrumb() {
        removeView(getChildAt(getChildCount() - 1));
    }

    public final void setBreadcrumb(String str) {
        C0036f.m62b(str, "fullPath");
        Object context = getContext();
        C0036f.m59a(context, "context");
        String basePath = StringKt.getBasePath(str, context);
        String humanizePath = ContextKt.humanizePath(getContext(), str);
        removeAllViewsInLayout();
        CharSequence charSequence = humanizePath;
        C0069f c0069f = new C0069f("/");
        if (null != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: split");
        }
        List a = c0069f.m94a(charSequence, 0);
        if (!a.isEmpty()) {
            ListIterator listIterator = a.listIterator(a.size());
            while (listIterator.hasPrevious()) {
                boolean z;
                if (((String) listIterator.previous()).length() == 0) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (!z) {
                    a = C0011m.m25b(a, listIterator.nextIndex() + 1);
                    break;
                }
            }
        }
        a = C0006h.m10a();
        Collection collection = a;
        if (collection == null) {
            throw new C0027d("null cannot be cast to non-null type java.util.Collection<T>");
        }
        collection = collection;
        Object[] toArray = collection.toArray(new String[collection.size()]);
        if (toArray == null) {
            throw new C0027d("null cannot be cast to non-null type kotlin.Array<T>");
        }
        String[] strArr = (String[]) toArray;
        int length = strArr.length - 1;
        if (0 <= length) {
            int i = 0;
            String str2 = basePath;
            while (true) {
                String str3 = strArr[i];
                basePath = i > 0 ? str2 + str3 + "/" : str2;
                if (!(((CharSequence) str3).length() == 0)) {
                    if (!C0078o.m125a((CharSequence) basePath, '/', false, 2, null)) {
                        basePath = basePath + "/";
                    }
                    addBreadcrumb(new FileDirItem(basePath, str3, true, 0, 0), i > 0);
                }
                if (i != length) {
                    i++;
                    str2 = basePath;
                } else {
                    return;
                }
            }
        }
    }

    public final void setListener(BreadcrumbsListener breadcrumbsListener) {
        C0036f.m62b(breadcrumbsListener, "listener");
        this.mListener = breadcrumbsListener;
    }
}
