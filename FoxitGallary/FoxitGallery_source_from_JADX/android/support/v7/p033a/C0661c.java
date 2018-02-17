package android.support.v7.p033a;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.support.v4.p016k.ac;
import android.support.v4.p016k.ah;
import android.support.v4.widget.NestedScrollView;
import android.support.v4.widget.NestedScrollView.C0566b;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0725f;
import android.support.v7.p034b.C0730a.C0729j;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.ref.WeakReference;

/* renamed from: android.support.v7.a.c */
class C0661c {
    private TextView f1137A;
    private TextView f1138B;
    private View f1139C;
    private ListAdapter f1140D;
    private int f1141E;
    private int f1142F;
    private int f1143G;
    private int f1144H;
    private int f1145I;
    private int f1146J;
    private int f1147K;
    private int f1148L;
    private Handler f1149M;
    private final OnClickListener f1150N;
    private final Context f1151a;
    private final C0664n f1152b;
    private final Window f1153c;
    private CharSequence f1154d;
    private CharSequence f1155e;
    private ListView f1156f;
    private View f1157g;
    private int f1158h;
    private int f1159i;
    private int f1160j;
    private int f1161k;
    private int f1162l;
    private boolean f1163m;
    private Button f1164n;
    private CharSequence f1165o;
    private Message f1166p;
    private Button f1167q;
    private CharSequence f1168r;
    private Message f1169s;
    private Button f1170t;
    private CharSequence f1171u;
    private Message f1172v;
    private NestedScrollView f1173w;
    private int f1174x;
    private Drawable f1175y;
    private ImageView f1176z;

    /* renamed from: android.support.v7.a.c.1 */
    class C06481 implements OnClickListener {
        final /* synthetic */ C0661c f1072a;

        C06481(C0661c c0661c) {
            this.f1072a = c0661c;
        }

        public void onClick(View view) {
            Message obtain = (view != this.f1072a.f1164n || this.f1072a.f1166p == null) ? (view != this.f1072a.f1167q || this.f1072a.f1169s == null) ? (view != this.f1072a.f1170t || this.f1072a.f1172v == null) ? null : Message.obtain(this.f1072a.f1172v) : Message.obtain(this.f1072a.f1169s) : Message.obtain(this.f1072a.f1166p);
            if (obtain != null) {
                obtain.sendToTarget();
            }
            this.f1072a.f1149M.obtainMessage(1, this.f1072a.f1152b).sendToTarget();
        }
    }

    /* renamed from: android.support.v7.a.c.2 */
    class C06492 implements C0566b {
        final /* synthetic */ View f1073a;
        final /* synthetic */ View f1074b;
        final /* synthetic */ C0661c f1075c;

        C06492(C0661c c0661c, View view, View view2) {
            this.f1075c = c0661c;
            this.f1073a = view;
            this.f1074b = view2;
        }

        public void m2837a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4) {
            C0661c.m2852b(nestedScrollView, this.f1073a, this.f1074b);
        }
    }

    /* renamed from: android.support.v7.a.c.3 */
    class C06503 implements Runnable {
        final /* synthetic */ View f1076a;
        final /* synthetic */ View f1077b;
        final /* synthetic */ C0661c f1078c;

        C06503(C0661c c0661c, View view, View view2) {
            this.f1078c = c0661c;
            this.f1076a = view;
            this.f1077b = view2;
        }

        public void run() {
            C0661c.m2852b(this.f1078c.f1173w, this.f1076a, this.f1077b);
        }
    }

    /* renamed from: android.support.v7.a.c.4 */
    class C06514 implements OnScrollListener {
        final /* synthetic */ View f1079a;
        final /* synthetic */ View f1080b;
        final /* synthetic */ C0661c f1081c;

        C06514(C0661c c0661c, View view, View view2) {
            this.f1081c = c0661c;
            this.f1079a = view;
            this.f1080b = view2;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            C0661c.m2852b(absListView, this.f1079a, this.f1080b);
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }
    }

    /* renamed from: android.support.v7.a.c.5 */
    class C06525 implements Runnable {
        final /* synthetic */ View f1082a;
        final /* synthetic */ View f1083b;
        final /* synthetic */ C0661c f1084c;

        C06525(C0661c c0661c, View view, View view2) {
            this.f1084c = c0661c;
            this.f1082a = view;
            this.f1083b = view2;
        }

        public void run() {
            C0661c.m2852b(this.f1084c.f1156f, this.f1082a, this.f1083b);
        }
    }

    /* renamed from: android.support.v7.a.c.a */
    public static class C0658a {
        public int f1097A;
        public boolean f1098B;
        public boolean[] f1099C;
        public boolean f1100D;
        public boolean f1101E;
        public int f1102F;
        public OnMultiChoiceClickListener f1103G;
        public Cursor f1104H;
        public String f1105I;
        public String f1106J;
        public OnItemSelectedListener f1107K;
        public C0657a f1108L;
        public boolean f1109M;
        public final Context f1110a;
        public final LayoutInflater f1111b;
        public int f1112c;
        public Drawable f1113d;
        public int f1114e;
        public CharSequence f1115f;
        public View f1116g;
        public CharSequence f1117h;
        public CharSequence f1118i;
        public DialogInterface.OnClickListener f1119j;
        public CharSequence f1120k;
        public DialogInterface.OnClickListener f1121l;
        public CharSequence f1122m;
        public DialogInterface.OnClickListener f1123n;
        public boolean f1124o;
        public OnCancelListener f1125p;
        public OnDismissListener f1126q;
        public OnKeyListener f1127r;
        public CharSequence[] f1128s;
        public ListAdapter f1129t;
        public DialogInterface.OnClickListener f1130u;
        public int f1131v;
        public View f1132w;
        public int f1133x;
        public int f1134y;
        public int f1135z;

        /* renamed from: android.support.v7.a.c.a.1 */
        class C06531 extends ArrayAdapter<CharSequence> {
            final /* synthetic */ ListView f1085a;
            final /* synthetic */ C0658a f1086b;

            C06531(C0658a c0658a, Context context, int i, int i2, CharSequence[] charSequenceArr, ListView listView) {
                this.f1086b = c0658a;
                this.f1085a = listView;
                super(context, i, i2, charSequenceArr);
            }

            public View getView(int i, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i, view, viewGroup);
                if (this.f1086b.f1099C != null && this.f1086b.f1099C[i]) {
                    this.f1085a.setItemChecked(i, true);
                }
                return view2;
            }
        }

        /* renamed from: android.support.v7.a.c.a.2 */
        class C06542 extends CursorAdapter {
            final /* synthetic */ ListView f1087a;
            final /* synthetic */ C0661c f1088b;
            final /* synthetic */ C0658a f1089c;
            private final int f1090d;
            private final int f1091e;

            C06542(C0658a c0658a, Context context, Cursor cursor, boolean z, ListView listView, C0661c c0661c) {
                this.f1089c = c0658a;
                this.f1087a = listView;
                this.f1088b = c0661c;
                super(context, cursor, z);
                Cursor cursor2 = getCursor();
                this.f1090d = cursor2.getColumnIndexOrThrow(this.f1089c.f1105I);
                this.f1091e = cursor2.getColumnIndexOrThrow(this.f1089c.f1106J);
            }

            public void bindView(View view, Context context, Cursor cursor) {
                ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.f1090d));
                this.f1087a.setItemChecked(cursor.getPosition(), cursor.getInt(this.f1091e) == 1);
            }

            public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
                return this.f1089c.f1111b.inflate(this.f1088b.f1145I, viewGroup, false);
            }
        }

        /* renamed from: android.support.v7.a.c.a.3 */
        class C06553 implements OnItemClickListener {
            final /* synthetic */ C0661c f1092a;
            final /* synthetic */ C0658a f1093b;

            C06553(C0658a c0658a, C0661c c0661c) {
                this.f1093b = c0658a;
                this.f1092a = c0661c;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                this.f1093b.f1130u.onClick(this.f1092a.f1152b, i);
                if (!this.f1093b.f1101E) {
                    this.f1092a.f1152b.dismiss();
                }
            }
        }

        /* renamed from: android.support.v7.a.c.a.4 */
        class C06564 implements OnItemClickListener {
            final /* synthetic */ ListView f1094a;
            final /* synthetic */ C0661c f1095b;
            final /* synthetic */ C0658a f1096c;

            C06564(C0658a c0658a, ListView listView, C0661c c0661c) {
                this.f1096c = c0658a;
                this.f1094a = listView;
                this.f1095b = c0661c;
            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (this.f1096c.f1099C != null) {
                    this.f1096c.f1099C[i] = this.f1094a.isItemChecked(i);
                }
                this.f1096c.f1103G.onClick(this.f1095b.f1152b, i, this.f1094a.isItemChecked(i));
            }
        }

        /* renamed from: android.support.v7.a.c.a.a */
        public interface C0657a {
            void m2838a(ListView listView);
        }

        public C0658a(Context context) {
            this.f1112c = 0;
            this.f1114e = 0;
            this.f1098B = false;
            this.f1102F = -1;
            this.f1109M = true;
            this.f1110a = context;
            this.f1124o = true;
            this.f1111b = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        private void m2839b(C0661c c0661c) {
            ListAdapter simpleCursorAdapter;
            ListView listView = (ListView) this.f1111b.inflate(c0661c.f1144H, null);
            if (!this.f1100D) {
                int m = this.f1101E ? c0661c.f1146J : c0661c.f1147K;
                simpleCursorAdapter = this.f1104H != null ? new SimpleCursorAdapter(this.f1110a, m, this.f1104H, new String[]{this.f1105I}, new int[]{16908308}) : this.f1129t != null ? this.f1129t : new C0660c(this.f1110a, m, 16908308, this.f1128s);
            } else if (this.f1104H == null) {
                simpleCursorAdapter = new C06531(this, this.f1110a, c0661c.f1145I, 16908308, this.f1128s, listView);
            } else {
                Object c06542 = new C06542(this, this.f1110a, this.f1104H, false, listView, c0661c);
            }
            if (this.f1108L != null) {
                this.f1108L.m2838a(listView);
            }
            c0661c.f1140D = simpleCursorAdapter;
            c0661c.f1141E = this.f1102F;
            if (this.f1130u != null) {
                listView.setOnItemClickListener(new C06553(this, c0661c));
            } else if (this.f1103G != null) {
                listView.setOnItemClickListener(new C06564(this, listView, c0661c));
            }
            if (this.f1107K != null) {
                listView.setOnItemSelectedListener(this.f1107K);
            }
            if (this.f1101E) {
                listView.setChoiceMode(1);
            } else if (this.f1100D) {
                listView.setChoiceMode(2);
            }
            c0661c.f1156f = listView;
        }

        public void m2840a(C0661c c0661c) {
            if (this.f1116g != null) {
                c0661c.m2877b(this.f1116g);
            } else {
                if (this.f1115f != null) {
                    c0661c.m2874a(this.f1115f);
                }
                if (this.f1113d != null) {
                    c0661c.m2872a(this.f1113d);
                }
                if (this.f1112c != 0) {
                    c0661c.m2876b(this.f1112c);
                }
                if (this.f1114e != 0) {
                    c0661c.m2876b(c0661c.m2880c(this.f1114e));
                }
            }
            if (this.f1117h != null) {
                c0661c.m2878b(this.f1117h);
            }
            if (this.f1118i != null) {
                c0661c.m2871a(-1, this.f1118i, this.f1119j, null);
            }
            if (this.f1120k != null) {
                c0661c.m2871a(-2, this.f1120k, this.f1121l, null);
            }
            if (this.f1122m != null) {
                c0661c.m2871a(-3, this.f1122m, this.f1123n, null);
            }
            if (!(this.f1128s == null && this.f1104H == null && this.f1129t == null)) {
                m2839b(c0661c);
            }
            if (this.f1132w != null) {
                if (this.f1098B) {
                    c0661c.m2873a(this.f1132w, this.f1133x, this.f1134y, this.f1135z, this.f1097A);
                    return;
                }
                c0661c.m2881c(this.f1132w);
            } else if (this.f1131v != 0) {
                c0661c.m2870a(this.f1131v);
            }
        }
    }

    /* renamed from: android.support.v7.a.c.b */
    private static final class C0659b extends Handler {
        private WeakReference<DialogInterface> f1136a;

        public C0659b(DialogInterface dialogInterface) {
            this.f1136a = new WeakReference(dialogInterface);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case -3:
                case ac.POSITION_NONE /*-2*/:
                case ac.POSITION_UNCHANGED /*-1*/:
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) this.f1136a.get(), message.what);
                case C1373c.View_android_focusable /*1*/:
                    ((DialogInterface) message.obj).dismiss();
                default:
            }
        }
    }

    /* renamed from: android.support.v7.a.c.c */
    private static class C0660c extends ArrayAdapter<CharSequence> {
        public C0660c(Context context, int i, int i2, CharSequence[] charSequenceArr) {
            super(context, i, i2, charSequenceArr);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }
    }

    public C0661c(Context context, C0664n c0664n, Window window) {
        this.f1163m = false;
        this.f1174x = 0;
        this.f1141E = -1;
        this.f1148L = 0;
        this.f1150N = new C06481(this);
        this.f1151a = context;
        this.f1152b = c0664n;
        this.f1153c = window;
        this.f1149M = new C0659b(c0664n);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, C0729j.AlertDialog, C0720a.alertDialogStyle, 0);
        this.f1142F = obtainStyledAttributes.getResourceId(C0729j.AlertDialog_android_layout, 0);
        this.f1143G = obtainStyledAttributes.getResourceId(C0729j.AlertDialog_buttonPanelSideLayout, 0);
        this.f1144H = obtainStyledAttributes.getResourceId(C0729j.AlertDialog_listLayout, 0);
        this.f1145I = obtainStyledAttributes.getResourceId(C0729j.AlertDialog_multiChoiceItemLayout, 0);
        this.f1146J = obtainStyledAttributes.getResourceId(C0729j.AlertDialog_singleChoiceItemLayout, 0);
        this.f1147K = obtainStyledAttributes.getResourceId(C0729j.AlertDialog_listItemLayout, 0);
        obtainStyledAttributes.recycle();
        c0664n.m2891a(1);
    }

    private ViewGroup m2842a(View view, View view2) {
        if (view == null) {
            return (ViewGroup) (view2 instanceof ViewStub ? ((ViewStub) view2).inflate() : view2);
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        return (ViewGroup) (view instanceof ViewStub ? ((ViewStub) view).inflate() : view);
    }

    private void m2847a(ViewGroup viewGroup) {
        boolean z = false;
        View inflate = this.f1157g != null ? this.f1157g : this.f1158h != 0 ? LayoutInflater.from(this.f1151a).inflate(this.f1158h, viewGroup, false) : null;
        if (inflate != null) {
            z = true;
        }
        if (!(z && C0661c.m2849a(inflate))) {
            this.f1153c.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) this.f1153c.findViewById(C0725f.custom);
            frameLayout.addView(inflate, new LayoutParams(-1, -1));
            if (this.f1163m) {
                frameLayout.setPadding(this.f1159i, this.f1160j, this.f1161k, this.f1162l);
            }
            if (this.f1156f != null) {
                ((LinearLayout.LayoutParams) viewGroup.getLayoutParams()).weight = 0.0f;
                return;
            }
            return;
        }
        viewGroup.setVisibility(8);
    }

    private void m2848a(ViewGroup viewGroup, View view, int i, int i2) {
        View view2 = null;
        View findViewById = this.f1153c.findViewById(C0725f.scrollIndicatorUp);
        View findViewById2 = this.f1153c.findViewById(C0725f.scrollIndicatorDown);
        if (VERSION.SDK_INT >= 23) {
            ah.m1910a(view, i, i2);
            if (findViewById != null) {
                viewGroup.removeView(findViewById);
            }
            if (findViewById2 != null) {
                viewGroup.removeView(findViewById2);
                return;
            }
            return;
        }
        if (findViewById != null && (i & 1) == 0) {
            viewGroup.removeView(findViewById);
            findViewById = null;
        }
        if (findViewById2 == null || (i & 2) != 0) {
            view2 = findViewById2;
        } else {
            viewGroup.removeView(findViewById2);
        }
        if (findViewById != null || view2 != null) {
            if (this.f1155e != null) {
                this.f1173w.setOnScrollChangeListener(new C06492(this, findViewById, view2));
                this.f1173w.post(new C06503(this, findViewById, view2));
            } else if (this.f1156f != null) {
                this.f1156f.setOnScrollListener(new C06514(this, findViewById, view2));
                this.f1156f.post(new C06525(this, findViewById, view2));
            } else {
                if (findViewById != null) {
                    viewGroup.removeView(findViewById);
                }
                if (view2 != null) {
                    viewGroup.removeView(view2);
                }
            }
        }
    }

    static boolean m2849a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (C0661c.m2849a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    private int m2850b() {
        return this.f1143G == 0 ? this.f1142F : this.f1148L == 1 ? this.f1143G : this.f1142F;
    }

    private static void m2852b(View view, View view2, View view3) {
        int i = 0;
        if (view2 != null) {
            view2.setVisibility(ah.m1926b(view, -1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!ah.m1926b(view, 1)) {
                i = 4;
            }
            view3.setVisibility(i);
        }
    }

    private void m2853b(ViewGroup viewGroup) {
        if (this.f1139C != null) {
            viewGroup.addView(this.f1139C, 0, new LayoutParams(-1, -2));
            this.f1153c.findViewById(C0725f.title_template).setVisibility(8);
            return;
        }
        this.f1176z = (ImageView) this.f1153c.findViewById(16908294);
        if ((!TextUtils.isEmpty(this.f1154d) ? 1 : 0) != 0) {
            this.f1137A = (TextView) this.f1153c.findViewById(C0725f.alertTitle);
            this.f1137A.setText(this.f1154d);
            if (this.f1174x != 0) {
                this.f1176z.setImageResource(this.f1174x);
                return;
            } else if (this.f1175y != null) {
                this.f1176z.setImageDrawable(this.f1175y);
                return;
            } else {
                this.f1137A.setPadding(this.f1176z.getPaddingLeft(), this.f1176z.getPaddingTop(), this.f1176z.getPaddingRight(), this.f1176z.getPaddingBottom());
                this.f1176z.setVisibility(8);
                return;
            }
        }
        this.f1153c.findViewById(C0725f.title_template).setVisibility(8);
        this.f1176z.setVisibility(8);
        viewGroup.setVisibility(8);
    }

    private void m2855c() {
        View findViewById = this.f1153c.findViewById(C0725f.parentPanel);
        View findViewById2 = findViewById.findViewById(C0725f.topPanel);
        View findViewById3 = findViewById.findViewById(C0725f.contentPanel);
        View findViewById4 = findViewById.findViewById(C0725f.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) findViewById.findViewById(C0725f.customPanel);
        m2847a(viewGroup);
        View findViewById5 = viewGroup.findViewById(C0725f.topPanel);
        View findViewById6 = viewGroup.findViewById(C0725f.contentPanel);
        View findViewById7 = viewGroup.findViewById(C0725f.buttonPanel);
        ViewGroup a = m2842a(findViewById5, findViewById2);
        ViewGroup a2 = m2842a(findViewById6, findViewById3);
        ViewGroup a3 = m2842a(findViewById7, findViewById4);
        m2856c(a2);
        m2858d(a3);
        m2853b(a);
        boolean z = (viewGroup == null || viewGroup.getVisibility() == 8) ? false : true;
        boolean z2 = (a == null || a.getVisibility() == 8) ? false : true;
        boolean z3 = (a3 == null || a3.getVisibility() == 8) ? false : true;
        if (!(z3 || a2 == null)) {
            findViewById3 = a2.findViewById(C0725f.textSpacerNoButtons);
            if (findViewById3 != null) {
                findViewById3.setVisibility(0);
            }
        }
        if (z2 && this.f1173w != null) {
            this.f1173w.setClipToPadding(true);
        }
        if (!z) {
            findViewById3 = this.f1156f != null ? this.f1156f : this.f1173w;
            if (findViewById3 != null) {
                m2848a(a2, findViewById3, (z3 ? 2 : 0) | (z2 ? 1 : 0), 3);
            }
        }
        ListView listView = this.f1156f;
        if (listView != null && this.f1140D != null) {
            listView.setAdapter(this.f1140D);
            int i = this.f1141E;
            if (i > -1) {
                listView.setItemChecked(i, true);
                listView.setSelection(i);
            }
        }
    }

    private void m2856c(ViewGroup viewGroup) {
        this.f1173w = (NestedScrollView) this.f1153c.findViewById(C0725f.scrollView);
        this.f1173w.setFocusable(false);
        this.f1173w.setNestedScrollingEnabled(false);
        this.f1138B = (TextView) viewGroup.findViewById(16908299);
        if (this.f1138B != null) {
            if (this.f1155e != null) {
                this.f1138B.setText(this.f1155e);
                return;
            }
            this.f1138B.setVisibility(8);
            this.f1173w.removeView(this.f1138B);
            if (this.f1156f != null) {
                ViewGroup viewGroup2 = (ViewGroup) this.f1173w.getParent();
                int indexOfChild = viewGroup2.indexOfChild(this.f1173w);
                viewGroup2.removeViewAt(indexOfChild);
                viewGroup2.addView(this.f1156f, indexOfChild, new LayoutParams(-1, -1));
                return;
            }
            viewGroup.setVisibility(8);
        }
    }

    private void m2858d(ViewGroup viewGroup) {
        int i;
        int i2 = 1;
        this.f1164n = (Button) viewGroup.findViewById(16908313);
        this.f1164n.setOnClickListener(this.f1150N);
        if (TextUtils.isEmpty(this.f1165o)) {
            this.f1164n.setVisibility(8);
            i = 0;
        } else {
            this.f1164n.setText(this.f1165o);
            this.f1164n.setVisibility(0);
            i = 1;
        }
        this.f1167q = (Button) viewGroup.findViewById(16908314);
        this.f1167q.setOnClickListener(this.f1150N);
        if (TextUtils.isEmpty(this.f1168r)) {
            this.f1167q.setVisibility(8);
        } else {
            this.f1167q.setText(this.f1168r);
            this.f1167q.setVisibility(0);
            i |= 2;
        }
        this.f1170t = (Button) viewGroup.findViewById(16908315);
        this.f1170t.setOnClickListener(this.f1150N);
        if (TextUtils.isEmpty(this.f1171u)) {
            this.f1170t.setVisibility(8);
        } else {
            this.f1170t.setText(this.f1171u);
            this.f1170t.setVisibility(0);
            i |= 4;
        }
        if (i == 0) {
            i2 = 0;
        }
        if (i2 == 0) {
            viewGroup.setVisibility(8);
        }
    }

    public void m2869a() {
        this.f1152b.setContentView(m2850b());
        m2855c();
    }

    public void m2870a(int i) {
        this.f1157g = null;
        this.f1158h = i;
        this.f1163m = false;
    }

    public void m2871a(int i, CharSequence charSequence, DialogInterface.OnClickListener onClickListener, Message message) {
        if (message == null && onClickListener != null) {
            message = this.f1149M.obtainMessage(i, onClickListener);
        }
        switch (i) {
            case -3:
                this.f1171u = charSequence;
                this.f1172v = message;
            case ac.POSITION_NONE /*-2*/:
                this.f1168r = charSequence;
                this.f1169s = message;
            case ac.POSITION_UNCHANGED /*-1*/:
                this.f1165o = charSequence;
                this.f1166p = message;
            default:
                throw new IllegalArgumentException("Button does not exist");
        }
    }

    public void m2872a(Drawable drawable) {
        this.f1175y = drawable;
        this.f1174x = 0;
        if (this.f1176z == null) {
            return;
        }
        if (drawable != null) {
            this.f1176z.setVisibility(0);
            this.f1176z.setImageDrawable(drawable);
            return;
        }
        this.f1176z.setVisibility(8);
    }

    public void m2873a(View view, int i, int i2, int i3, int i4) {
        this.f1157g = view;
        this.f1158h = 0;
        this.f1163m = true;
        this.f1159i = i;
        this.f1160j = i2;
        this.f1161k = i3;
        this.f1162l = i4;
    }

    public void m2874a(CharSequence charSequence) {
        this.f1154d = charSequence;
        if (this.f1137A != null) {
            this.f1137A.setText(charSequence);
        }
    }

    public boolean m2875a(int i, KeyEvent keyEvent) {
        return this.f1173w != null && this.f1173w.m2447a(keyEvent);
    }

    public void m2876b(int i) {
        this.f1175y = null;
        this.f1174x = i;
        if (this.f1176z == null) {
            return;
        }
        if (i != 0) {
            this.f1176z.setVisibility(0);
            this.f1176z.setImageResource(this.f1174x);
            return;
        }
        this.f1176z.setVisibility(8);
    }

    public void m2877b(View view) {
        this.f1139C = view;
    }

    public void m2878b(CharSequence charSequence) {
        this.f1155e = charSequence;
        if (this.f1138B != null) {
            this.f1138B.setText(charSequence);
        }
    }

    public boolean m2879b(int i, KeyEvent keyEvent) {
        return this.f1173w != null && this.f1173w.m2447a(keyEvent);
    }

    public int m2880c(int i) {
        TypedValue typedValue = new TypedValue();
        this.f1151a.getTheme().resolveAttribute(i, typedValue, true);
        return typedValue.resourceId;
    }

    public void m2881c(View view) {
        this.f1157g = view;
        this.f1158h = 0;
        this.f1163m = false;
    }
}
