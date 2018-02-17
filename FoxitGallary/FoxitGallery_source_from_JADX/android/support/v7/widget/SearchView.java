package android.support.v7.widget;

import android.annotation.TargetApi;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.ResultReceiver;
import android.support.v4.p016k.C0120a;
import android.support.v4.p017g.C0118e;
import android.support.v4.p017g.C0356d;
import android.support.v4.p022c.p023a.C0301a;
import android.support.v4.widget.C0598g;
import android.support.v7.p034b.C0730a.C0720a;
import android.support.v7.p034b.C0730a.C0723d;
import android.support.v7.view.C0740c;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.simplemobiletools.gallery.BuildConfig;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

public class SearchView extends ak implements C0740c {
    static final C0855a f1974a;
    private static final boolean f1975b;
    private boolean f1976A;
    private boolean f1977B;
    private C0598g f1978C;
    private boolean f1979D;
    private CharSequence f1980E;
    private boolean f1981F;
    private boolean f1982G;
    private int f1983H;
    private boolean f1984I;
    private CharSequence f1985J;
    private boolean f1986K;
    private int f1987L;
    private SearchableInfo f1988M;
    private Bundle f1989N;
    private Runnable f1990O;
    private final Runnable f1991P;
    private Runnable f1992Q;
    private final WeakHashMap<String, ConstantState> f1993R;
    private final SearchAutoComplete f1994c;
    private final View f1995d;
    private final View f1996e;
    private final ImageView f1997f;
    private final ImageView f1998g;
    private final ImageView f1999h;
    private final ImageView f2000i;
    private C0861f f2001j;
    private Rect f2002k;
    private Rect f2003l;
    private int[] f2004m;
    private int[] f2005n;
    private final ImageView f2006o;
    private final Drawable f2007p;
    private final int f2008q;
    private final int f2009r;
    private final Intent f2010s;
    private final Intent f2011t;
    private final CharSequence f2012u;
    private C0857c f2013v;
    private C0856b f2014w;
    private OnFocusChangeListener f2015x;
    private C0858d f2016y;
    private OnClickListener f2017z;

    public static class SearchAutoComplete extends C0854g {
        private int f1961a;
        private SearchView f1962b;

        public SearchAutoComplete(Context context) {
            this(context, null);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            this(context, attributeSet, C0720a.autoCompleteTextViewStyle);
        }

        public SearchAutoComplete(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f1961a = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int b = C0301a.m1171b(getResources());
            int a = C0301a.m1170a(getResources());
            return (b < 960 || a < 720 || configuration.orientation != 2) ? (b >= 600 || (b >= 640 && a >= 480)) ? 192 : 160 : 256;
        }

        public boolean enoughToFilter() {
            return this.f1961a <= 0 || super.enoughToFilter();
        }

        protected void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, (float) getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        protected void onFocusChanged(boolean z, int i, Rect rect) {
            super.onFocusChanged(z, i, rect);
            this.f1962b.m4271d();
        }

        public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
            if (i == 4) {
                DispatcherState keyDispatcherState;
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState == null) {
                        return true;
                    }
                    keyDispatcherState.startTracking(keyEvent, this);
                    return true;
                } else if (keyEvent.getAction() == 1) {
                    keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.f1962b.clearFocus();
                        this.f1962b.setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i, keyEvent);
        }

        public void onWindowFocusChanged(boolean z) {
            super.onWindowFocusChanged(z);
            if (z && this.f1962b.hasFocus() && getVisibility() == 0) {
                ((InputMethodManager) getContext().getSystemService("input_method")).showSoftInput(this, 0);
                if (SearchView.m4250a(getContext())) {
                    SearchView.f1974a.m4236a(this, true);
                }
            }
        }

        public void performCompletion() {
        }

        protected void replaceText(CharSequence charSequence) {
        }

        void setSearchView(SearchView searchView) {
            this.f1962b = searchView;
        }

        public void setThreshold(int i) {
            super.setThreshold(i);
            this.f1961a = i;
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.a */
    private static class C0855a {
        private Method f1963a;
        private Method f1964b;
        private Method f1965c;
        private Method f1966d;

        C0855a() {
            try {
                this.f1963a = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
                this.f1963a.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            try {
                this.f1964b = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
                this.f1964b.setAccessible(true);
            } catch (NoSuchMethodException e2) {
            }
            try {
                this.f1965c = AutoCompleteTextView.class.getMethod("ensureImeVisible", new Class[]{Boolean.TYPE});
                this.f1965c.setAccessible(true);
            } catch (NoSuchMethodException e3) {
            }
            try {
                this.f1966d = InputMethodManager.class.getMethod("showSoftInputUnchecked", new Class[]{Integer.TYPE, ResultReceiver.class});
                this.f1966d.setAccessible(true);
            } catch (NoSuchMethodException e4) {
            }
        }

        void m4235a(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1963a != null) {
                try {
                    this.f1963a.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }

        void m4236a(AutoCompleteTextView autoCompleteTextView, boolean z) {
            if (this.f1965c != null) {
                try {
                    this.f1965c.invoke(autoCompleteTextView, new Object[]{Boolean.valueOf(z)});
                } catch (Exception e) {
                }
            }
        }

        void m4237b(AutoCompleteTextView autoCompleteTextView) {
            if (this.f1964b != null) {
                try {
                    this.f1964b.invoke(autoCompleteTextView, new Object[0]);
                } catch (Exception e) {
                }
            }
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.b */
    public interface C0856b {
        boolean m4238a();
    }

    /* renamed from: android.support.v7.widget.SearchView.c */
    public interface C0857c {
        boolean m4239a(String str);
    }

    /* renamed from: android.support.v7.widget.SearchView.d */
    public interface C0858d {
    }

    /* renamed from: android.support.v7.widget.SearchView.e */
    static class C0860e extends C0120a {
        public static final Creator<C0860e> CREATOR;
        boolean f1967a;

        /* renamed from: android.support.v7.widget.SearchView.e.1 */
        static class C08591 implements C0118e<C0860e> {
            C08591() {
            }

            public C0860e m4240a(Parcel parcel, ClassLoader classLoader) {
                return new C0860e(parcel, classLoader);
            }

            public C0860e[] m4241a(int i) {
                return new C0860e[i];
            }

            public /* synthetic */ Object m4242b(Parcel parcel, ClassLoader classLoader) {
                return m4240a(parcel, classLoader);
            }

            public /* synthetic */ Object[] m4243b(int i) {
                return m4241a(i);
            }
        }

        static {
            CREATOR = C0356d.m1329a(new C08591());
        }

        public C0860e(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f1967a = ((Boolean) parcel.readValue(null)).booleanValue();
        }

        C0860e(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "SearchView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " isIconified=" + this.f1967a + "}";
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeValue(Boolean.valueOf(this.f1967a));
        }
    }

    /* renamed from: android.support.v7.widget.SearchView.f */
    private static class C0861f extends TouchDelegate {
        private final View f1968a;
        private final Rect f1969b;
        private final Rect f1970c;
        private final Rect f1971d;
        private final int f1972e;
        private boolean f1973f;

        public C0861f(Rect rect, Rect rect2, View view) {
            super(rect, view);
            this.f1972e = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1969b = new Rect();
            this.f1971d = new Rect();
            this.f1970c = new Rect();
            m4244a(rect, rect2);
            this.f1968a = view;
        }

        public void m4244a(Rect rect, Rect rect2) {
            this.f1969b.set(rect);
            this.f1971d.set(rect);
            this.f1971d.inset(-this.f1972e, -this.f1972e);
            this.f1970c.set(rect2);
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean onTouchEvent(android.view.MotionEvent r7) {
            /*
            r6 = this;
            r1 = 1;
            r0 = 0;
            r2 = r7.getX();
            r3 = (int) r2;
            r2 = r7.getY();
            r4 = (int) r2;
            r2 = r7.getAction();
            switch(r2) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0048;
                case 2: goto L_0x0048;
                case 3: goto L_0x0056;
                default: goto L_0x0013;
            };
        L_0x0013:
            r2 = r0;
        L_0x0014:
            if (r2 == 0) goto L_0x003b;
        L_0x0016:
            if (r1 == 0) goto L_0x005b;
        L_0x0018:
            r0 = r6.f1970c;
            r0 = r0.contains(r3, r4);
            if (r0 != 0) goto L_0x005b;
        L_0x0020:
            r0 = r6.f1968a;
            r0 = r0.getWidth();
            r0 = r0 / 2;
            r0 = (float) r0;
            r1 = r6.f1968a;
            r1 = r1.getHeight();
            r1 = r1 / 2;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
        L_0x0035:
            r0 = r6.f1968a;
            r0 = r0.dispatchTouchEvent(r7);
        L_0x003b:
            return r0;
        L_0x003c:
            r2 = r6.f1969b;
            r2 = r2.contains(r3, r4);
            if (r2 == 0) goto L_0x0013;
        L_0x0044:
            r6.f1973f = r1;
            r2 = r1;
            goto L_0x0014;
        L_0x0048:
            r2 = r6.f1973f;
            if (r2 == 0) goto L_0x0014;
        L_0x004c:
            r5 = r6.f1971d;
            r5 = r5.contains(r3, r4);
            if (r5 != 0) goto L_0x0014;
        L_0x0054:
            r1 = r0;
            goto L_0x0014;
        L_0x0056:
            r2 = r6.f1973f;
            r6.f1973f = r0;
            goto L_0x0014;
        L_0x005b:
            r0 = r6.f1970c;
            r0 = r0.left;
            r0 = r3 - r0;
            r0 = (float) r0;
            r1 = r6.f1970c;
            r1 = r1.top;
            r1 = r4 - r1;
            r1 = (float) r1;
            r7.setLocation(r0, r1);
            goto L_0x0035;
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.SearchView.f.onTouchEvent(android.view.MotionEvent):boolean");
        }
    }

    static {
        f1975b = VERSION.SDK_INT >= 8;
        f1974a = new C0855a();
    }

    private Intent m4245a(String str, Uri uri, String str2, String str3, int i, String str4) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f1985J);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        if (this.f1989N != null) {
            intent.putExtra("app_data", this.f1989N);
        }
        if (i != 0) {
            intent.putExtra("action_key", i);
            intent.putExtra("action_msg", str4);
        }
        if (f1975b) {
            intent.setComponent(this.f1988M.getSearchActivity());
        }
        return intent;
    }

    private void m4246a(int i, String str, String str2) {
        getContext().startActivity(m4245a("android.intent.action.SEARCH", null, null, str2, i, str));
    }

    private void m4248a(View view, Rect rect) {
        view.getLocationInWindow(this.f2004m);
        getLocationInWindow(this.f2005n);
        int i = this.f2004m[1] - this.f2005n[1];
        int i2 = this.f2004m[0] - this.f2005n[0];
        rect.set(i2, i, view.getWidth() + i2, view.getHeight() + i);
    }

    private void m4249a(boolean z) {
        boolean z2 = true;
        int i = 8;
        this.f1977B = z;
        int i2 = z ? 0 : 8;
        boolean z3 = !TextUtils.isEmpty(this.f1994c.getText());
        this.f1997f.setVisibility(i2);
        m4252b(z3);
        this.f1995d.setVisibility(z ? 8 : 0);
        if (!(this.f2006o.getDrawable() == null || this.f1976A)) {
            i = 0;
        }
        this.f2006o.setVisibility(i);
        m4257h();
        if (z3) {
            z2 = false;
        }
        m4253c(z2);
        m4256g();
    }

    static boolean m4250a(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    private CharSequence m4251b(CharSequence charSequence) {
        if (!this.f1976A || this.f2007p == null) {
            return charSequence;
        }
        int textSize = (int) (((double) this.f1994c.getTextSize()) * 1.25d);
        this.f2007p.setBounds(0, 0, textSize, textSize);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
        spannableStringBuilder.setSpan(new ImageSpan(this.f2007p), 1, 2, 33);
        spannableStringBuilder.append(charSequence);
        return spannableStringBuilder;
    }

    private void m4252b(boolean z) {
        int i = 8;
        if (this.f1979D && m4255f() && hasFocus() && (z || !this.f1984I)) {
            i = 0;
        }
        this.f1998g.setVisibility(i);
    }

    private void m4253c(boolean z) {
        int i;
        if (this.f1984I && !m4270c() && z) {
            i = 0;
            this.f1998g.setVisibility(8);
        } else {
            i = 8;
        }
        this.f2000i.setVisibility(i);
    }

    @TargetApi(8)
    private boolean m4254e() {
        if (this.f1988M == null || !this.f1988M.getVoiceSearchEnabled()) {
            return false;
        }
        Intent intent = null;
        if (this.f1988M.getVoiceSearchLaunchWebSearch()) {
            intent = this.f2010s;
        } else if (this.f1988M.getVoiceSearchLaunchRecognizer()) {
            intent = this.f2011t;
        }
        return (intent == null || getContext().getPackageManager().resolveActivity(intent, 65536) == null) ? false : true;
    }

    private boolean m4255f() {
        return (this.f1979D || this.f1984I) && !m4270c();
    }

    private void m4256g() {
        int i = 8;
        if (m4255f() && (this.f1998g.getVisibility() == 0 || this.f2000i.getVisibility() == 0)) {
            i = 0;
        }
        this.f1996e.setVisibility(i);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(C0723d.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(C0723d.abc_search_view_preferred_width);
    }

    private void m4257h() {
        int i = 1;
        int i2 = 0;
        int i3 = !TextUtils.isEmpty(this.f1994c.getText()) ? 1 : 0;
        if (i3 == 0 && (!this.f1976A || this.f1986K)) {
            i = 0;
        }
        ImageView imageView = this.f1999h;
        if (i == 0) {
            i2 = 8;
        }
        imageView.setVisibility(i2);
        Drawable drawable = this.f1999h.getDrawable();
        if (drawable != null) {
            drawable.setState(i3 != 0 ? ENABLED_STATE_SET : EMPTY_STATE_SET);
        }
    }

    private void m4258i() {
        post(this.f1991P);
    }

    private void m4259k() {
        CharSequence queryHint = getQueryHint();
        SearchAutoComplete searchAutoComplete = this.f1994c;
        if (queryHint == null) {
            queryHint = BuildConfig.FLAVOR;
        }
        searchAutoComplete.setHint(m4251b(queryHint));
    }

    @TargetApi(8)
    private void m4260l() {
        int i = 1;
        this.f1994c.setThreshold(this.f1988M.getSuggestThreshold());
        this.f1994c.setImeOptions(this.f1988M.getImeOptions());
        int inputType = this.f1988M.getInputType();
        if ((inputType & 15) == 1) {
            inputType &= -65537;
            if (this.f1988M.getSuggestAuthority() != null) {
                inputType = (inputType | 65536) | 524288;
            }
        }
        this.f1994c.setInputType(inputType);
        if (this.f1978C != null) {
            this.f1978C.m2603a(null);
        }
        if (this.f1988M.getSuggestAuthority() != null) {
            this.f1978C = new az(getContext(), this, this.f1988M, this.f1993R);
            this.f1994c.setAdapter(this.f1978C);
            az azVar = (az) this.f1978C;
            if (this.f1981F) {
                i = 2;
            }
            azVar.m4758a(i);
        }
    }

    private void m4261m() {
        CharSequence text = this.f1994c.getText();
        if (text != null && TextUtils.getTrimmedLength(text) > 0) {
            if (this.f2013v == null || !this.f2013v.m4239a(text.toString())) {
                if (this.f1988M != null) {
                    m4246a(0, null, text.toString());
                }
                setImeVisibility(false);
                m4262n();
            }
        }
    }

    private void m4262n() {
        this.f1994c.dismissDropDown();
    }

    private void m4263o() {
        if (!TextUtils.isEmpty(this.f1994c.getText())) {
            this.f1994c.setText(BuildConfig.FLAVOR);
            this.f1994c.requestFocus();
            setImeVisibility(true);
        } else if (!this.f1976A) {
        } else {
            if (this.f2014w == null || !this.f2014w.m4238a()) {
                clearFocus();
                m4249a(true);
            }
        }
    }

    private void m4264p() {
        m4249a(false);
        this.f1994c.requestFocus();
        setImeVisibility(true);
        if (this.f2017z != null) {
            this.f2017z.onClick(this);
        }
    }

    private void m4265q() {
        f1974a.m4235a(this.f1994c);
        f1974a.m4237b(this.f1994c);
    }

    private void setImeVisibility(boolean z) {
        if (z) {
            post(this.f1990O);
            return;
        }
        removeCallbacks(this.f1990O);
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
        }
    }

    private void setQuery(CharSequence charSequence) {
        this.f1994c.setText(charSequence);
        this.f1994c.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    public void m4266a() {
        if (!this.f1986K) {
            this.f1986K = true;
            this.f1987L = this.f1994c.getImeOptions();
            this.f1994c.setImeOptions(this.f1987L | 33554432);
            this.f1994c.setText(BuildConfig.FLAVOR);
            setIconified(false);
        }
    }

    void m4267a(CharSequence charSequence) {
        setQuery(charSequence);
    }

    public void m4268a(CharSequence charSequence, boolean z) {
        this.f1994c.setText(charSequence);
        if (charSequence != null) {
            this.f1994c.setSelection(this.f1994c.length());
            this.f1985J = charSequence;
        }
        if (z && !TextUtils.isEmpty(charSequence)) {
            m4261m();
        }
    }

    public void m4269b() {
        m4268a(BuildConfig.FLAVOR, false);
        clearFocus();
        m4249a(true);
        this.f1994c.setImeOptions(this.f1987L);
        this.f1986K = false;
    }

    public boolean m4270c() {
        return this.f1977B;
    }

    public void clearFocus() {
        this.f1982G = true;
        setImeVisibility(false);
        super.clearFocus();
        this.f1994c.clearFocus();
        this.f1982G = false;
    }

    void m4271d() {
        m4249a(m4270c());
        m4258i();
        if (this.f1994c.hasFocus()) {
            m4265q();
        }
    }

    public int getImeOptions() {
        return this.f1994c.getImeOptions();
    }

    public int getInputType() {
        return this.f1994c.getInputType();
    }

    public int getMaxWidth() {
        return this.f1983H;
    }

    public CharSequence getQuery() {
        return this.f1994c.getText();
    }

    public CharSequence getQueryHint() {
        return this.f1980E != null ? this.f1980E : (!f1975b || this.f1988M == null || this.f1988M.getHintId() == 0) ? this.f2012u : getContext().getText(this.f1988M.getHintId());
    }

    int getSuggestionCommitIconResId() {
        return this.f2009r;
    }

    int getSuggestionRowLayout() {
        return this.f2008q;
    }

    public C0598g getSuggestionsAdapter() {
        return this.f1978C;
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.f1991P);
        post(this.f1992Q);
        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            m4248a(this.f1994c, this.f2002k);
            this.f2003l.set(this.f2002k.left, 0, this.f2002k.right, i4 - i2);
            if (this.f2001j == null) {
                this.f2001j = new C0861f(this.f2003l, this.f2002k, this.f1994c);
                setTouchDelegate(this.f2001j);
                return;
            }
            this.f2001j.m4244a(this.f2003l, this.f2002k);
        }
    }

    protected void onMeasure(int i, int i2) {
        if (m4270c()) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = MeasureSpec.getMode(i);
        int size = MeasureSpec.getSize(i);
        switch (mode) {
            case Integer.MIN_VALUE:
                if (this.f1983H <= 0) {
                    size = Math.min(getPreferredWidth(), size);
                    break;
                } else {
                    size = Math.min(this.f1983H, size);
                    break;
                }
            case C1373c.View_android_theme /*0*/:
                if (this.f1983H <= 0) {
                    size = getPreferredWidth();
                    break;
                } else {
                    size = this.f1983H;
                    break;
                }
            case 1073741824:
                if (this.f1983H > 0) {
                    size = Math.min(this.f1983H, size);
                    break;
                }
                break;
        }
        int mode2 = MeasureSpec.getMode(i2);
        mode = MeasureSpec.getSize(i2);
        switch (mode2) {
            case Integer.MIN_VALUE:
            case C1373c.View_android_theme /*0*/:
                mode = Math.min(getPreferredHeight(), mode);
                break;
        }
        super.onMeasure(MeasureSpec.makeMeasureSpec(size, 1073741824), MeasureSpec.makeMeasureSpec(mode, 1073741824));
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof C0860e) {
            C0860e c0860e = (C0860e) parcelable;
            super.onRestoreInstanceState(c0860e.m249a());
            m4249a(c0860e.f1967a);
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable c0860e = new C0860e(super.onSaveInstanceState());
        c0860e.f1967a = m4270c();
        return c0860e;
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        m4258i();
    }

    public boolean requestFocus(int i, Rect rect) {
        if (this.f1982G || !isFocusable()) {
            return false;
        }
        if (m4270c()) {
            return super.requestFocus(i, rect);
        }
        boolean requestFocus = this.f1994c.requestFocus(i, rect);
        if (requestFocus) {
            m4249a(false);
        }
        return requestFocus;
    }

    public void setAppSearchData(Bundle bundle) {
        this.f1989N = bundle;
    }

    public void setIconified(boolean z) {
        if (z) {
            m4263o();
        } else {
            m4264p();
        }
    }

    public void setIconifiedByDefault(boolean z) {
        if (this.f1976A != z) {
            this.f1976A = z;
            m4249a(z);
            m4259k();
        }
    }

    public void setImeOptions(int i) {
        this.f1994c.setImeOptions(i);
    }

    public void setInputType(int i) {
        this.f1994c.setInputType(i);
    }

    public void setMaxWidth(int i) {
        this.f1983H = i;
        requestLayout();
    }

    public void setOnCloseListener(C0856b c0856b) {
        this.f2014w = c0856b;
    }

    public void setOnQueryTextFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f2015x = onFocusChangeListener;
    }

    public void setOnQueryTextListener(C0857c c0857c) {
        this.f2013v = c0857c;
    }

    public void setOnSearchClickListener(OnClickListener onClickListener) {
        this.f2017z = onClickListener;
    }

    public void setOnSuggestionListener(C0858d c0858d) {
        this.f2016y = c0858d;
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f1980E = charSequence;
        m4259k();
    }

    public void setQueryRefinementEnabled(boolean z) {
        this.f1981F = z;
        if (this.f1978C instanceof az) {
            ((az) this.f1978C).m4758a(z ? 2 : 1);
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f1988M = searchableInfo;
        if (this.f1988M != null) {
            if (f1975b) {
                m4260l();
            }
            m4259k();
        }
        boolean z = f1975b && m4254e();
        this.f1984I = z;
        if (this.f1984I) {
            this.f1994c.setPrivateImeOptions("nm");
        }
        m4249a(m4270c());
    }

    public void setSubmitButtonEnabled(boolean z) {
        this.f1979D = z;
        m4249a(m4270c());
    }

    public void setSuggestionsAdapter(C0598g c0598g) {
        this.f1978C = c0598g;
        this.f1994c.setAdapter(this.f1978C);
    }
}
