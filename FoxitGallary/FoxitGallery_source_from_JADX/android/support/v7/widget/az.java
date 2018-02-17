package android.support.v7.widget;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.support.v4.p022c.C0225a;
import android.support.v4.widget.C0627v;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0725f;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.simplemobiletools.gallery.BuildConfig;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

class az extends C0627v implements OnClickListener {
    private final SearchManager f2313j;
    private final SearchView f2314k;
    private final SearchableInfo f2315l;
    private final Context f2316m;
    private final WeakHashMap<String, ConstantState> f2317n;
    private final int f2318o;
    private boolean f2319p;
    private int f2320q;
    private ColorStateList f2321r;
    private int f2322s;
    private int f2323t;
    private int f2324u;
    private int f2325v;
    private int f2326w;
    private int f2327x;

    /* renamed from: android.support.v7.widget.az.a */
    private static final class C0916a {
        public final TextView f2308a;
        public final TextView f2309b;
        public final ImageView f2310c;
        public final ImageView f2311d;
        public final ImageView f2312e;

        public C0916a(View view) {
            this.f2308a = (TextView) view.findViewById(16908308);
            this.f2309b = (TextView) view.findViewById(16908309);
            this.f2310c = (ImageView) view.findViewById(16908295);
            this.f2311d = (ImageView) view.findViewById(16908296);
            this.f2312e = (ImageView) view.findViewById(C0725f.edit_query);
        }
    }

    public az(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f2319p = false;
        this.f2320q = 1;
        this.f2322s = -1;
        this.f2323t = -1;
        this.f2324u = -1;
        this.f2325v = -1;
        this.f2326w = -1;
        this.f2327x = -1;
        this.f2313j = (SearchManager) this.d.getSystemService("search");
        this.f2314k = searchView;
        this.f2315l = searchableInfo;
        this.f2318o = searchView.getSuggestionCommitIconResId();
        this.f2316m = context;
        this.f2317n = weakHashMap;
    }

    private Drawable m4739a(ComponentName componentName) {
        Object obj = null;
        String flattenToShortString = componentName.flattenToShortString();
        if (this.f2317n.containsKey(flattenToShortString)) {
            ConstantState constantState = (ConstantState) this.f2317n.get(flattenToShortString);
            return constantState == null ? null : constantState.newDrawable(this.f2316m.getResources());
        } else {
            Drawable b = m4746b(componentName);
            if (b != null) {
                obj = b.getConstantState();
            }
            this.f2317n.put(flattenToShortString, obj);
            return b;
        }
    }

    private Drawable m4740a(String str) {
        if (str == null || str.length() == 0 || "0".equals(str)) {
            return null;
        }
        Drawable b;
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f2316m.getPackageName() + "/" + parseInt;
            b = m4748b(str2);
            if (b != null) {
                return b;
            }
            b = C0225a.m808a(this.f2316m, parseInt);
            m4745a(str2, b);
            return b;
        } catch (NumberFormatException e) {
            b = m4748b(str);
            if (b != null) {
                return b;
            }
            b = m4747b(Uri.parse(str));
            m4745a(str, b);
            return b;
        } catch (NotFoundException e2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    private static String m4741a(Cursor cursor, int i) {
        String str = null;
        if (i != -1) {
            try {
                str = cursor.getString(i);
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            }
        }
        return str;
    }

    public static String m4742a(Cursor cursor, String str) {
        return m4741a(cursor, cursor.getColumnIndex(str));
    }

    private void m4743a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    private void m4744a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }

    private void m4745a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f2317n.put(str, drawable.getConstantState());
        }
    }

    private Drawable m4746b(ComponentName componentName) {
        PackageManager packageManager = this.d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    private Drawable m4747b(Uri uri) {
        InputStream openInputStream;
        try {
            if ("android.resource".equals(uri.getScheme())) {
                return m4756a(uri);
            }
            openInputStream = this.f2316m.getContentResolver().openInputStream(uri);
            if (openInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            Drawable createFromStream = Drawable.createFromStream(openInputStream, null);
            try {
                openInputStream.close();
                return createFromStream;
            } catch (Throwable e) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                return createFromStream;
            }
        } catch (NotFoundException e2) {
            throw new FileNotFoundException("Resource does not exist: " + uri);
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        } catch (Throwable th) {
            try {
                openInputStream.close();
            } catch (Throwable e4) {
                Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e4);
            }
        }
    }

    private Drawable m4748b(String str) {
        ConstantState constantState = (ConstantState) this.f2317n.get(str);
        return constantState == null ? null : constantState.newDrawable();
    }

    private CharSequence m4749b(CharSequence charSequence) {
        if (this.f2321r == null) {
            TypedValue typedValue = new TypedValue();
            this.d.getTheme().resolveAttribute(C0720a.textColorSearchUrl, typedValue, true);
            this.f2321r = this.d.getResources().getColorStateList(typedValue.resourceId);
        }
        CharSequence spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.f2321r, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    private void m4750d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras != null && !extras.getBoolean("in_progress")) {
        }
    }

    private Drawable m4751e(Cursor cursor) {
        if (this.f2325v == -1) {
            return null;
        }
        Drawable a = m4740a(cursor.getString(this.f2325v));
        return a == null ? m4753g(cursor) : a;
    }

    private Drawable m4752f(Cursor cursor) {
        return this.f2326w == -1 ? null : m4740a(cursor.getString(this.f2326w));
    }

    private Drawable m4753g(Cursor cursor) {
        Drawable a = m4739a(this.f2315l.getSearchActivity());
        return a != null ? a : this.d.getPackageManager().getDefaultActivityIcon();
    }

    Cursor m4754a(SearchableInfo searchableInfo, String str, int i) {
        if (searchableInfo == null) {
            return null;
        }
        String suggestAuthority = searchableInfo.getSuggestAuthority();
        if (suggestAuthority == null) {
            return null;
        }
        String[] strArr;
        Builder fragment = new Builder().scheme("content").authority(suggestAuthority).query(BuildConfig.FLAVOR).fragment(BuildConfig.FLAVOR);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
            strArr = null;
        }
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.d.getContentResolver().query(fragment.build(), null, suggestSelection, strArr, null);
    }

    public Cursor m4755a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? BuildConfig.FLAVOR : charSequence.toString();
        if (this.f2314k.getVisibility() != 0 || this.f2314k.getWindowVisibility() != 0) {
            return null;
        }
        try {
            Cursor a = m4754a(this.f2315l, charSequence2, 50);
            if (a != null) {
                a.getCount();
                return a;
            }
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
        }
        return null;
    }

    Drawable m4756a(Uri uri) {
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.d.getPackageManager().getResourcesForApplication(authority);
            List pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    size = Integer.parseInt((String) pathSegments.get(0));
                } catch (NumberFormatException e) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else if (size == 2) {
                size = resourcesForApplication.getIdentifier((String) pathSegments.get(1), (String) pathSegments.get(0), authority);
            } else {
                throw new FileNotFoundException("More than two path segments: " + uri);
            }
            if (size != 0) {
                return resourcesForApplication.getDrawable(size);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (NameNotFoundException e2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public View m4757a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.m2731a(context, cursor, viewGroup);
        a.setTag(new C0916a(a));
        ((ImageView) a.findViewById(C0725f.edit_query)).setImageResource(this.f2318o);
        return a;
    }

    public void m4758a(int i) {
        this.f2320q = i;
    }

    public void m4759a(Cursor cursor) {
        if (this.f2319p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.m2603a(cursor);
            if (cursor != null) {
                this.f2322s = cursor.getColumnIndex("suggest_text_1");
                this.f2323t = cursor.getColumnIndex("suggest_text_2");
                this.f2324u = cursor.getColumnIndex("suggest_text_2_url");
                this.f2325v = cursor.getColumnIndex("suggest_icon_1");
                this.f2326w = cursor.getColumnIndex("suggest_icon_2");
                this.f2327x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Throwable e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public void m4760a(View view, Context context, Cursor cursor) {
        C0916a c0916a = (C0916a) view.getTag();
        int i = this.f2327x != -1 ? cursor.getInt(this.f2327x) : 0;
        if (c0916a.f2308a != null) {
            m4744a(c0916a.f2308a, m4741a(cursor, this.f2322s));
        }
        if (c0916a.f2309b != null) {
            CharSequence a = m4741a(cursor, this.f2324u);
            a = a != null ? m4749b(a) : m4741a(cursor, this.f2323t);
            if (TextUtils.isEmpty(a)) {
                if (c0916a.f2308a != null) {
                    c0916a.f2308a.setSingleLine(false);
                    c0916a.f2308a.setMaxLines(2);
                }
            } else if (c0916a.f2308a != null) {
                c0916a.f2308a.setSingleLine(true);
                c0916a.f2308a.setMaxLines(1);
            }
            m4744a(c0916a.f2309b, a);
        }
        if (c0916a.f2310c != null) {
            m4743a(c0916a.f2310c, m4751e(cursor), 4);
        }
        if (c0916a.f2311d != null) {
            m4743a(c0916a.f2311d, m4752f(cursor), 8);
        }
        if (this.f2320q == 2 || (this.f2320q == 1 && (i & 1) != 0)) {
            c0916a.f2312e.setVisibility(0);
            c0916a.f2312e.setTag(c0916a.f2308a.getText());
            c0916a.f2312e.setOnClickListener(this);
            return;
        }
        c0916a.f2312e.setVisibility(8);
    }

    public CharSequence m4761c(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        String a = m4742a(cursor, "suggest_intent_query");
        if (a != null) {
            return a;
        }
        if (this.f2315l.shouldRewriteQueryFromData()) {
            a = m4742a(cursor, "suggest_intent_data");
            if (a != null) {
                return a;
            }
        }
        if (!this.f2315l.shouldRewriteQueryFromText()) {
            return null;
        }
        a = m4742a(cursor, "suggest_text_1");
        return a != null ? a : null;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (Throwable e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = m4757a(this.d, this.c, viewGroup);
            if (a != null) {
                ((C0916a) a.getTag()).f2308a.setText(e.toString());
            }
            return a;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m4750d(m2599a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m4750d(m2599a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f2314k.m4267a((CharSequence) tag);
        }
    }
}
