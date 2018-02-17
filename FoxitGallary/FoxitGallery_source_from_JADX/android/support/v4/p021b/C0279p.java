package android.support.v4.p021b;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.support.v4.p021b.C0226a.C0222a;
import android.support.v4.p021b.C0247c.C0246a;
import android.support.v4.p026f.p027a.C0351a;
import android.support.v4.p030j.C0379j;
import android.support.v4.p030j.C0395k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.theartofdev.edmodo.cropper.C1374h.C1373c;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.b.p */
public class C0279p extends C0268n implements C0222a, C0246a {
    static final String ALLOCATED_REQUEST_INDICIES_TAG = "android:support:request_indicies";
    static final String FRAGMENTS_TAG = "android:support:fragments";
    private static final int HONEYCOMB = 11;
    static final int MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS = 65534;
    static final int MSG_REALLY_STOPPED = 1;
    static final int MSG_RESUME_PENDING = 2;
    static final String NEXT_CANDIDATE_REQUEST_INDEX_TAG = "android:support:next_request_index";
    static final String REQUEST_FRAGMENT_WHO_TAG = "android:support:request_fragment_who";
    private static final String TAG = "FragmentActivity";
    boolean mCreated;
    final C0280r mFragments;
    final Handler mHandler;
    C0351a mMediaController;
    int mNextCandidateRequestIndex;
    boolean mOptionsMenuInvalidated;
    C0395k<String> mPendingFragmentActivityResults;
    boolean mReallyStopped;
    boolean mRequestedPermissionsFromFragment;
    boolean mResumed;
    boolean mRetaining;
    boolean mStopped;

    /* renamed from: android.support.v4.b.p.1 */
    class C02751 extends Handler {
        final /* synthetic */ C0279p f598a;

        C02751(C0279p c0279p) {
            this.f598a = c0279p;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case C0279p.MSG_REALLY_STOPPED /*1*/:
                    if (this.f598a.mStopped) {
                        this.f598a.doReallyStop(false);
                    }
                case C0279p.MSG_RESUME_PENDING /*2*/:
                    this.f598a.onResumeFragments();
                    this.f598a.mFragments.m1067o();
                default:
                    super.handleMessage(message);
            }
        }
    }

    /* renamed from: android.support.v4.b.p.a */
    class C0277a extends C0276s<C0279p> {
        final /* synthetic */ C0279p f609a;

        public C0277a(C0279p c0279p) {
            this.f609a = c0279p;
            super(c0279p);
        }

        public View m1022a(int i) {
            return this.f609a.findViewById(i);
        }

        public void m1023a(C0274o c0274o, Intent intent, int i, Bundle bundle) {
            this.f609a.startActivityFromFragment(c0274o, intent, i, bundle);
        }

        public void m1024a(C0274o c0274o, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
            this.f609a.startIntentSenderFromFragment(c0274o, intentSender, i, intent, i2, i3, i4, bundle);
        }

        public void m1025a(C0274o c0274o, String[] strArr, int i) {
            this.f609a.requestPermissionsFromFragment(c0274o, strArr, i);
        }

        public void m1026a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            this.f609a.dump(str, fileDescriptor, printWriter, strArr);
        }

        public boolean m1027a() {
            Window window = this.f609a.getWindow();
            return (window == null || window.peekDecorView() == null) ? false : true;
        }

        public boolean m1028a(C0274o c0274o) {
            return !this.f609a.isFinishing();
        }

        public boolean m1029a(String str) {
            return C0226a.m817a(this.f609a, str);
        }

        public LayoutInflater m1030b() {
            return this.f609a.getLayoutInflater().cloneInContext(this.f609a);
        }

        public void m1031b(C0274o c0274o) {
            this.f609a.onAttachFragment(c0274o);
        }

        public C0279p m1032c() {
            return this.f609a;
        }

        public void m1033d() {
            this.f609a.supportInvalidateOptionsMenu();
        }

        public boolean m1034e() {
            return this.f609a.getWindow() != null;
        }

        public int m1035f() {
            Window window = this.f609a.getWindow();
            return window == null ? 0 : window.getAttributes().windowAnimations;
        }

        public /* synthetic */ Object m1036g() {
            return m1032c();
        }
    }

    /* renamed from: android.support.v4.b.p.b */
    static final class C0278b {
        Object f610a;
        C0290v f611b;
        C0379j<String, ab> f612c;

        C0278b() {
        }
    }

    public C0279p() {
        this.mHandler = new C02751(this);
        this.mFragments = C0280r.m1037a(new C0277a(this));
    }

    private int allocateRequestIndex(C0274o c0274o) {
        if (this.mPendingFragmentActivityResults.m1464b() >= MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS) {
            throw new IllegalStateException("Too many pending Fragment activity results.");
        }
        while (this.mPendingFragmentActivityResults.m1471f(this.mNextCandidateRequestIndex) >= 0) {
            this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + MSG_REALLY_STOPPED) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        }
        int i = this.mNextCandidateRequestIndex;
        this.mPendingFragmentActivityResults.m1466b(i, c0274o.mWho);
        this.mNextCandidateRequestIndex = (this.mNextCandidateRequestIndex + MSG_REALLY_STOPPED) % MAX_NUM_PENDING_FRAGMENT_ACTIVITY_RESULTS;
        return i;
    }

    private void dumpViewHierarchy(String str, PrintWriter printWriter, View view) {
        printWriter.print(str);
        if (view == null) {
            printWriter.println("null");
            return;
        }
        printWriter.println(C0279p.viewToString(view));
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount > 0) {
                String str2 = str + "  ";
                for (int i = 0; i < childCount; i += MSG_REALLY_STOPPED) {
                    dumpViewHierarchy(str2, printWriter, viewGroup.getChildAt(i));
                }
            }
        }
    }

    private void requestPermissionsFromFragment(C0274o c0274o, String[] strArr, int i) {
        if (i == -1) {
            C0226a.m816a(this, strArr, i);
            return;
        }
        C0266l.checkForValidRequestCode(i);
        try {
            this.mRequestedPermissionsFromFragment = true;
            C0226a.m816a(this, strArr, ((allocateRequestIndex(c0274o) + MSG_REALLY_STOPPED) << 16) + (65535 & i));
        } finally {
            this.mRequestedPermissionsFromFragment = false;
        }
    }

    private static String viewToString(View view) {
        char c = 'F';
        char c2 = '.';
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append(view.getClass().getName());
        stringBuilder.append('{');
        stringBuilder.append(Integer.toHexString(System.identityHashCode(view)));
        stringBuilder.append(' ');
        switch (view.getVisibility()) {
            case C1373c.View_android_theme /*0*/:
                stringBuilder.append('V');
                break;
            case C1373c.View_theme /*4*/:
                stringBuilder.append('I');
                break;
            case C1373c.Toolbar_contentInsetRight /*8*/:
                stringBuilder.append('G');
                break;
            default:
                stringBuilder.append('.');
                break;
        }
        stringBuilder.append(view.isFocusable() ? 'F' : '.');
        stringBuilder.append(view.isEnabled() ? 'E' : '.');
        stringBuilder.append(view.willNotDraw() ? '.' : 'D');
        stringBuilder.append(view.isHorizontalScrollBarEnabled() ? 'H' : '.');
        stringBuilder.append(view.isVerticalScrollBarEnabled() ? 'V' : '.');
        stringBuilder.append(view.isClickable() ? 'C' : '.');
        stringBuilder.append(view.isLongClickable() ? 'L' : '.');
        stringBuilder.append(' ');
        if (!view.isFocused()) {
            c = '.';
        }
        stringBuilder.append(c);
        stringBuilder.append(view.isSelected() ? 'S' : '.');
        if (view.isPressed()) {
            c2 = 'P';
        }
        stringBuilder.append(c2);
        stringBuilder.append(' ');
        stringBuilder.append(view.getLeft());
        stringBuilder.append(',');
        stringBuilder.append(view.getTop());
        stringBuilder.append('-');
        stringBuilder.append(view.getRight());
        stringBuilder.append(',');
        stringBuilder.append(view.getBottom());
        int id = view.getId();
        if (id != -1) {
            stringBuilder.append(" #");
            stringBuilder.append(Integer.toHexString(id));
            Resources resources = view.getResources();
            if (!(id == 0 || resources == null)) {
                String str;
                switch (-16777216 & id) {
                    case 16777216:
                        str = "android";
                        break;
                    case 2130706432:
                        str = "app";
                        break;
                    default:
                        try {
                            str = resources.getResourcePackageName(id);
                            break;
                        } catch (NotFoundException e) {
                            break;
                        }
                }
                String resourceTypeName = resources.getResourceTypeName(id);
                String resourceEntryName = resources.getResourceEntryName(id);
                stringBuilder.append(" ");
                stringBuilder.append(str);
                stringBuilder.append(":");
                stringBuilder.append(resourceTypeName);
                stringBuilder.append("/");
                stringBuilder.append(resourceEntryName);
            }
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    final View dispatchFragmentsOnCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return this.mFragments.m1040a(view, str, context, attributeSet);
    }

    void doReallyStop(boolean z) {
        if (!this.mReallyStopped) {
            this.mReallyStopped = true;
            this.mRetaining = z;
            this.mHandler.removeMessages(MSG_REALLY_STOPPED);
            onReallyStop();
        } else if (z) {
            this.mFragments.m1068p();
            this.mFragments.m1055c(true);
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String str2;
        if (VERSION.SDK_INT >= HONEYCOMB) {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print("mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.mReallyStopped);
            this.mFragments.m1045a(str2, fileDescriptor, printWriter, strArr);
            this.mFragments.m1039a().m1078a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            dumpViewHierarchy(str + "  ", printWriter, getWindow().getDecorView());
        } else {
            printWriter.print(str);
            printWriter.print("Local FragmentActivity ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(" State:");
            str2 = str + "  ";
            printWriter.print(str2);
            printWriter.print("mCreated=");
            printWriter.print(this.mCreated);
            printWriter.print("mResumed=");
            printWriter.print(this.mResumed);
            printWriter.print(" mStopped=");
            printWriter.print(this.mStopped);
            printWriter.print(" mReallyStopped=");
            printWriter.println(this.mReallyStopped);
            this.mFragments.m1045a(str2, fileDescriptor, printWriter, strArr);
            this.mFragments.m1039a().m1078a(str, fileDescriptor, printWriter, strArr);
            printWriter.print(str);
            printWriter.println("View Hierarchy:");
            dumpViewHierarchy(str + "  ", printWriter, getWindow().getDecorView());
        }
    }

    public Object getLastCustomNonConfigurationInstance() {
        C0278b c0278b = (C0278b) getLastNonConfigurationInstance();
        return c0278b != null ? c0278b.f610a : null;
    }

    public C0282t getSupportFragmentManager() {
        return this.mFragments.m1039a();
    }

    public ab getSupportLoaderManager() {
        return this.mFragments.m1050b();
    }

    public final C0351a getSupportMediaController() {
        return this.mMediaController;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        this.mFragments.m1054c();
        int i3 = i >> 16;
        if (i3 != 0) {
            int i4 = i3 - 1;
            String str = (String) this.mPendingFragmentActivityResults.m1462a(i4);
            this.mPendingFragmentActivityResults.m1468c(i4);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C0274o a = this.mFragments.m1038a(str);
            if (a == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + str);
                return;
            } else {
                a.onActivityResult(65535 & i, i2, intent);
                return;
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    public void onAttachFragment(C0274o c0274o) {
    }

    public void onBackPressed() {
        if (!this.mFragments.m1039a().m1079b()) {
            onBackPressedNotHandled();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.mFragments.m1041a(configuration);
    }

    protected void onCreate(Bundle bundle) {
        this.mFragments.m1043a(null);
        super.onCreate(bundle);
        C0278b c0278b = (C0278b) getLastNonConfigurationInstance();
        if (c0278b != null) {
            this.mFragments.m1044a(c0278b.f612c);
        }
        if (bundle != null) {
            this.mFragments.m1042a(bundle.getParcelable(FRAGMENTS_TAG), c0278b != null ? c0278b.f611b : null);
            if (bundle.containsKey(NEXT_CANDIDATE_REQUEST_INDEX_TAG)) {
                this.mNextCandidateRequestIndex = bundle.getInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG);
                int[] intArray = bundle.getIntArray(ALLOCATED_REQUEST_INDICIES_TAG);
                String[] stringArray = bundle.getStringArray(REQUEST_FRAGMENT_WHO_TAG);
                if (intArray == null || stringArray == null || intArray.length != stringArray.length) {
                    Log.w(TAG, "Invalid requestCode mapping in savedInstanceState.");
                } else {
                    this.mPendingFragmentActivityResults = new C0395k(intArray.length);
                    for (int i = 0; i < intArray.length; i += MSG_REALLY_STOPPED) {
                        this.mPendingFragmentActivityResults.m1466b(intArray[i], stringArray[i]);
                    }
                }
            }
        }
        if (this.mPendingFragmentActivityResults == null) {
            this.mPendingFragmentActivityResults = new C0395k();
            this.mNextCandidateRequestIndex = 0;
        }
        this.mFragments.m1058f();
    }

    public boolean onCreatePanelMenu(int i, Menu menu) {
        if (i != 0) {
            return super.onCreatePanelMenu(i, menu);
        }
        return VERSION.SDK_INT >= HONEYCOMB ? super.onCreatePanelMenu(i, menu) | this.mFragments.m1048a(menu, getMenuInflater()) : true;
    }

    public /* bridge */ /* synthetic */ View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(view, str, context, attributeSet);
    }

    public /* bridge */ /* synthetic */ View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return super.onCreateView(str, context, attributeSet);
    }

    protected void onDestroy() {
        super.onDestroy();
        doReallyStop(false);
        this.mFragments.m1065m();
        this.mFragments.m1069q();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (VERSION.SDK_INT >= 5 || i != 4 || keyEvent.getRepeatCount() != 0) {
            return super.onKeyDown(i, keyEvent);
        }
        onBackPressed();
        return true;
    }

    public void onLowMemory() {
        super.onLowMemory();
        this.mFragments.m1066n();
    }

    public boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        switch (i) {
            case C1373c.View_android_theme /*0*/:
                return this.mFragments.m1049a(menuItem);
            case C1373c.Toolbar_contentInsetEnd /*6*/:
                return this.mFragments.m1053b(menuItem);
            default:
                return false;
        }
    }

    public void onMultiWindowModeChanged(boolean z) {
        this.mFragments.m1046a(z);
    }

    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mFragments.m1054c();
    }

    public void onPanelClosed(int i, Menu menu) {
        switch (i) {
            case C1373c.View_android_theme /*0*/:
                this.mFragments.m1051b(menu);
                break;
        }
        super.onPanelClosed(i, menu);
    }

    protected void onPause() {
        super.onPause();
        this.mResumed = false;
        if (this.mHandler.hasMessages(MSG_RESUME_PENDING)) {
            this.mHandler.removeMessages(MSG_RESUME_PENDING);
            onResumeFragments();
        }
        this.mFragments.m1062j();
    }

    public void onPictureInPictureModeChanged(boolean z) {
        this.mFragments.m1052b(z);
    }

    protected void onPostResume() {
        super.onPostResume();
        this.mHandler.removeMessages(MSG_RESUME_PENDING);
        onResumeFragments();
        this.mFragments.m1067o();
    }

    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        return super.onPreparePanel(0, view, menu);
    }

    public boolean onPreparePanel(int i, View view, Menu menu) {
        if (i != 0 || menu == null) {
            return super.onPreparePanel(i, view, menu);
        }
        if (this.mOptionsMenuInvalidated) {
            this.mOptionsMenuInvalidated = false;
            menu.clear();
            onCreatePanelMenu(i, menu);
        }
        return onPrepareOptionsPanel(view, menu) | this.mFragments.m1047a(menu);
    }

    void onReallyStop() {
        this.mFragments.m1055c(this.mRetaining);
        this.mFragments.m1064l();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        int i2 = (i >> 16) & 65535;
        if (i2 != 0) {
            int i3 = i2 - 1;
            String str = (String) this.mPendingFragmentActivityResults.m1462a(i3);
            this.mPendingFragmentActivityResults.m1468c(i3);
            if (str == null) {
                Log.w(TAG, "Activity result delivered for unknown Fragment.");
                return;
            }
            C0274o a = this.mFragments.m1038a(str);
            if (a == null) {
                Log.w(TAG, "Activity result no fragment exists for who: " + str);
            } else {
                a.onRequestPermissionsResult(i & 65535, strArr, iArr);
            }
        }
    }

    protected void onResume() {
        super.onResume();
        this.mHandler.sendEmptyMessage(MSG_RESUME_PENDING);
        this.mResumed = true;
        this.mFragments.m1067o();
    }

    protected void onResumeFragments() {
        this.mFragments.m1061i();
    }

    public Object onRetainCustomNonConfigurationInstance() {
        return null;
    }

    public final Object onRetainNonConfigurationInstance() {
        if (this.mStopped) {
            doReallyStop(true);
        }
        Object onRetainCustomNonConfigurationInstance = onRetainCustomNonConfigurationInstance();
        C0290v e = this.mFragments.m1057e();
        C0379j s = this.mFragments.m1071s();
        if (e == null && s == null && onRetainCustomNonConfigurationInstance == null) {
            return null;
        }
        C0278b c0278b = new C0278b();
        c0278b.f610a = onRetainCustomNonConfigurationInstance;
        c0278b.f611b = e;
        c0278b.f612c = s;
        return c0278b;
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        Parcelable d = this.mFragments.m1056d();
        if (d != null) {
            bundle.putParcelable(FRAGMENTS_TAG, d);
        }
        if (this.mPendingFragmentActivityResults.m1464b() > 0) {
            bundle.putInt(NEXT_CANDIDATE_REQUEST_INDEX_TAG, this.mNextCandidateRequestIndex);
            int[] iArr = new int[this.mPendingFragmentActivityResults.m1464b()];
            String[] strArr = new String[this.mPendingFragmentActivityResults.m1464b()];
            for (int i = 0; i < this.mPendingFragmentActivityResults.m1464b(); i += MSG_REALLY_STOPPED) {
                iArr[i] = this.mPendingFragmentActivityResults.m1469d(i);
                strArr[i] = (String) this.mPendingFragmentActivityResults.m1470e(i);
            }
            bundle.putIntArray(ALLOCATED_REQUEST_INDICIES_TAG, iArr);
            bundle.putStringArray(REQUEST_FRAGMENT_WHO_TAG, strArr);
        }
    }

    protected void onStart() {
        super.onStart();
        this.mStopped = false;
        this.mReallyStopped = false;
        this.mHandler.removeMessages(MSG_REALLY_STOPPED);
        if (!this.mCreated) {
            this.mCreated = true;
            this.mFragments.m1059g();
        }
        this.mFragments.m1054c();
        this.mFragments.m1067o();
        this.mFragments.m1068p();
        this.mFragments.m1060h();
        this.mFragments.m1070r();
    }

    public void onStateNotSaved() {
        this.mFragments.m1054c();
    }

    protected void onStop() {
        super.onStop();
        this.mStopped = true;
        this.mHandler.sendEmptyMessage(MSG_REALLY_STOPPED);
        this.mFragments.m1063k();
    }

    public void setEnterSharedElementCallback(ag agVar) {
        C0226a.m815a((Activity) this, agVar);
    }

    public void setExitSharedElementCallback(ag agVar) {
        C0226a.m819b(this, agVar);
    }

    public final void setSupportMediaController(C0351a c0351a) {
        this.mMediaController = c0351a;
        if (VERSION.SDK_INT >= 21) {
            C0245b.m913a((Activity) this, c0351a.m1325a());
        }
    }

    public void startActivityForResult(Intent intent, int i) {
        if (!(this.mStartedActivityFromFragment || i == -1)) {
            C0266l.checkForValidRequestCode(i);
        }
        super.startActivityForResult(intent, i);
    }

    public /* bridge */ /* synthetic */ void startActivityForResult(Intent intent, int i, Bundle bundle) {
        super.startActivityForResult(intent, i, bundle);
    }

    public void startActivityFromFragment(C0274o c0274o, Intent intent, int i) {
        startActivityFromFragment(c0274o, intent, i, null);
    }

    public void startActivityFromFragment(C0274o c0274o, Intent intent, int i, Bundle bundle) {
        this.mStartedActivityFromFragment = true;
        if (i == -1) {
            try {
                C0226a.m813a(this, intent, -1, bundle);
            } finally {
                this.mStartedActivityFromFragment = false;
            }
        } else {
            C0266l.checkForValidRequestCode(i);
            C0226a.m813a(this, intent, ((allocateRequestIndex(c0274o) + MSG_REALLY_STOPPED) << 16) + (65535 & i), bundle);
            this.mStartedActivityFromFragment = false;
        }
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        super.startIntentSenderForResult(intentSender, i, intent, i2, i3, i4, bundle);
    }

    public void startIntentSenderFromFragment(C0274o c0274o, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        this.mStartedIntentSenderFromFragment = true;
        if (i == -1) {
            try {
                C0226a.m814a(this, intentSender, i, intent, i2, i3, i4, bundle);
            } finally {
                this.mStartedIntentSenderFromFragment = false;
            }
        } else {
            C0266l.checkForValidRequestCode(i);
            C0226a.m814a(this, intentSender, ((allocateRequestIndex(c0274o) + MSG_REALLY_STOPPED) << 16) + (65535 & i), intent, i2, i3, i4, bundle);
            this.mStartedIntentSenderFromFragment = false;
        }
    }

    public void supportFinishAfterTransition() {
        C0226a.m818b(this);
    }

    public void supportInvalidateOptionsMenu() {
        if (VERSION.SDK_INT >= HONEYCOMB) {
            C0249e.m920a(this);
        } else {
            this.mOptionsMenuInvalidated = true;
        }
    }

    public void supportPostponeEnterTransition() {
        C0226a.m820c(this);
    }

    public void supportStartPostponedEnterTransition() {
        C0226a.m821d(this);
    }

    public final void validateRequestPermissionsRequestCode(int i) {
        if (!this.mRequestedPermissionsFromFragment && i != -1) {
            C0266l.checkForValidRequestCode(i);
        }
    }
}
