package android.support.v4.p021b;

import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.p016k.C0534j;
import android.support.v4.p030j.C0379j;
import android.support.v4.p030j.C0382c;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* renamed from: android.support.v4.b.o */
public class C0274o implements ComponentCallbacks, OnCreateContextMenuListener {
    static final int ACTIVITY_CREATED = 2;
    static final int CREATED = 1;
    static final int INITIALIZING = 0;
    static final int RESUMED = 5;
    static final int STARTED = 4;
    static final int STOPPED = 3;
    static final Object USE_DEFAULT_TRANSITION;
    private static final C0379j<String, Class<?>> sClassMap;
    boolean mAdded;
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mCalled;
    boolean mCheckedForLoaderManager;
    C0289u mChildFragmentManager;
    C0290v mChildNonConfig;
    ViewGroup mContainer;
    int mContainerId;
    boolean mDeferStart;
    boolean mDetached;
    Object mEnterTransition;
    ag mEnterTransitionCallback;
    Object mExitTransition;
    ag mExitTransitionCallback;
    int mFragmentId;
    C0289u mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    C0276s mHost;
    boolean mInLayout;
    int mIndex;
    View mInnerView;
    ac mLoaderManager;
    boolean mLoadersStarted;
    boolean mMenuVisible;
    int mNextAnim;
    C0274o mParentFragment;
    Object mReenterTransition;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetaining;
    Object mReturnTransition;
    Bundle mSavedFragmentState;
    SparseArray<Parcelable> mSavedViewState;
    Object mSharedElementEnterTransition;
    Object mSharedElementReturnTransition;
    int mState;
    int mStateAfterAnimating;
    String mTag;
    C0274o mTarget;
    int mTargetIndex;
    int mTargetRequestCode;
    boolean mUserVisibleHint;
    View mView;
    String mWho;

    /* renamed from: android.support.v4.b.o.1 */
    class C02701 extends C0269q {
        final /* synthetic */ C0274o f596a;

        C02701(C0274o c0274o) {
            this.f596a = c0274o;
        }

        public View m989a(int i) {
            if (this.f596a.mView != null) {
                return this.f596a.mView.findViewById(i);
            }
            throw new IllegalStateException("Fragment does not have a view");
        }

        public boolean m990a() {
            return this.f596a.mView != null;
        }
    }

    /* renamed from: android.support.v4.b.o.a */
    public static class C0271a extends RuntimeException {
        public C0271a(String str, Exception exception) {
            super(str, exception);
        }
    }

    /* renamed from: android.support.v4.b.o.b */
    public static class C0273b implements Parcelable {
        public static final Creator<C0273b> CREATOR;
        final Bundle f597a;

        /* renamed from: android.support.v4.b.o.b.1 */
        static class C02721 implements Creator<C0273b> {
            C02721() {
            }

            public C0273b m991a(Parcel parcel) {
                return new C0273b(parcel, null);
            }

            public C0273b[] m992a(int i) {
                return new C0273b[i];
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m991a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m992a(i);
            }
        }

        static {
            CREATOR = new C02721();
        }

        C0273b(Bundle bundle) {
            this.f597a = bundle;
        }

        C0273b(Parcel parcel, ClassLoader classLoader) {
            this.f597a = parcel.readBundle();
            if (classLoader != null && this.f597a != null) {
                this.f597a.setClassLoader(classLoader);
            }
        }

        public int describeContents() {
            return C0274o.INITIALIZING;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeBundle(this.f597a);
        }
    }

    static {
        sClassMap = new C0379j();
        USE_DEFAULT_TRANSITION = new Object();
    }

    public C0274o() {
        this.mState = INITIALIZING;
        this.mIndex = -1;
        this.mTargetIndex = -1;
        this.mMenuVisible = true;
        this.mUserVisibleHint = true;
        this.mEnterTransition = null;
        this.mReturnTransition = USE_DEFAULT_TRANSITION;
        this.mExitTransition = null;
        this.mReenterTransition = USE_DEFAULT_TRANSITION;
        this.mSharedElementEnterTransition = null;
        this.mSharedElementReturnTransition = USE_DEFAULT_TRANSITION;
        this.mEnterTransitionCallback = null;
        this.mExitTransitionCallback = null;
    }

    public static C0274o instantiate(Context context, String str) {
        return C0274o.instantiate(context, str, null);
    }

    public static C0274o instantiate(Context context, String str, Bundle bundle) {
        try {
            Class cls = (Class) sClassMap.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                sClassMap.put(str, cls);
            }
            C0274o c0274o = (C0274o) cls.newInstance();
            if (bundle != null) {
                bundle.setClassLoader(c0274o.getClass().getClassLoader());
                c0274o.mArguments = bundle;
            }
            return c0274o;
        } catch (Exception e) {
            throw new C0271a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e);
        } catch (Exception e2) {
            throw new C0271a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e2);
        } catch (Exception e22) {
            throw new C0271a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an" + " empty constructor that is public", e22);
        }
    }

    static boolean isSupportFragmentClass(Context context, String str) {
        try {
            Class cls = (Class) sClassMap.get(str);
            if (cls == null) {
                cls = context.getClassLoader().loadClass(str);
                sClassMap.put(str, cls);
            }
            return C0274o.class.isAssignableFrom(cls);
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mIndex=");
        printWriter.print(this.mIndex);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mRetaining=");
        printWriter.print(this.mRetaining);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mTarget != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(this.mTarget);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        if (this.mNextAnim != 0) {
            printWriter.print(str);
            printWriter.print("mNextAnim=");
            printWriter.println(this.mNextAnim);
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (this.mInnerView != null) {
            printWriter.print(str);
            printWriter.print("mInnerView=");
            printWriter.println(this.mView);
        }
        if (this.mAnimatingAway != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(this.mAnimatingAway);
            printWriter.print(str);
            printWriter.print("mStateAfterAnimating=");
            printWriter.println(this.mStateAfterAnimating);
        }
        if (this.mLoaderManager != null) {
            printWriter.print(str);
            printWriter.println("Loader Manager:");
            this.mLoaderManager.m863a(str + "  ", fileDescriptor, printWriter, strArr);
        }
        if (this.mChildFragmentManager != null) {
            printWriter.print(str);
            printWriter.println("Child " + this.mChildFragmentManager + ":");
            this.mChildFragmentManager.m1109a(str + "  ", fileDescriptor, printWriter, strArr);
        }
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    C0274o findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager != null ? this.mChildFragmentManager.m1117b(str) : null;
    }

    public final C0279p getActivity() {
        return this.mHost == null ? null : (C0279p) this.mHost.m1012h();
    }

    public boolean getAllowEnterTransitionOverlap() {
        return this.mAllowEnterTransitionOverlap == null ? true : this.mAllowEnterTransitionOverlap.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        return this.mAllowReturnTransitionOverlap == null ? true : this.mAllowReturnTransitionOverlap.booleanValue();
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final C0282t getChildFragmentManager() {
        if (this.mChildFragmentManager == null) {
            instantiateChildFragmentManager();
            if (this.mState >= RESUMED) {
                this.mChildFragmentManager.m1146n();
            } else if (this.mState >= STARTED) {
                this.mChildFragmentManager.m1145m();
            } else if (this.mState >= ACTIVITY_CREATED) {
                this.mChildFragmentManager.m1144l();
            } else if (this.mState >= CREATED) {
                this.mChildFragmentManager.m1143k();
            }
        }
        return this.mChildFragmentManager;
    }

    public Context getContext() {
        return this.mHost == null ? null : this.mHost.m1013i();
    }

    public Object getEnterTransition() {
        return this.mEnterTransition;
    }

    public Object getExitTransition() {
        return this.mExitTransition;
    }

    public final C0282t getFragmentManager() {
        return this.mFragmentManager;
    }

    public final Object getHost() {
        return this.mHost == null ? null : this.mHost.m1011g();
    }

    public final int getId() {
        return this.mFragmentId;
    }

    public LayoutInflater getLayoutInflater(Bundle bundle) {
        LayoutInflater b = this.mHost.m1004b();
        getChildFragmentManager();
        C0534j.m2320a(b, this.mChildFragmentManager.m1153u());
        return b;
    }

    public ab getLoaderManager() {
        if (this.mLoaderManager != null) {
            return this.mLoaderManager;
        }
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mCheckedForLoaderManager = true;
        this.mLoaderManager = this.mHost.m993a(this.mWho, this.mLoadersStarted, true);
        return this.mLoaderManager;
    }

    public final C0274o getParentFragment() {
        return this.mParentFragment;
    }

    public Object getReenterTransition() {
        return this.mReenterTransition == USE_DEFAULT_TRANSITION ? getExitTransition() : this.mReenterTransition;
    }

    public final Resources getResources() {
        if (this.mHost != null) {
            return this.mHost.m1013i().getResources();
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    public final boolean getRetainInstance() {
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        return this.mReturnTransition == USE_DEFAULT_TRANSITION ? getEnterTransition() : this.mReturnTransition;
    }

    public Object getSharedElementEnterTransition() {
        return this.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        return this.mSharedElementReturnTransition == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : this.mSharedElementReturnTransition;
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String getString(int i, Object... objArr) {
        return getResources().getString(i, objArr);
    }

    public final String getTag() {
        return this.mTag;
    }

    public final C0274o getTargetFragment() {
        return this.mTarget;
    }

    public final int getTargetRequestCode() {
        return this.mTargetRequestCode;
    }

    public final CharSequence getText(int i) {
        return getResources().getText(i);
    }

    public boolean getUserVisibleHint() {
        return this.mUserVisibleHint;
    }

    public View getView() {
        return this.mView;
    }

    public final boolean hasOptionsMenu() {
        return this.mHasMenu;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    void initState() {
        this.mIndex = -1;
        this.mWho = null;
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = INITIALIZING;
        this.mFragmentManager = null;
        this.mChildFragmentManager = null;
        this.mHost = null;
        this.mFragmentId = INITIALIZING;
        this.mContainerId = INITIALIZING;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
        this.mRetaining = false;
        this.mLoaderManager = null;
        this.mLoadersStarted = false;
        this.mCheckedForLoaderManager = false;
    }

    void instantiateChildFragmentManager() {
        this.mChildFragmentManager = new C0289u();
        this.mChildFragmentManager.m1107a(this.mHost, new C02701(this), this);
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isDetached() {
        return this.mDetached;
    }

    public final boolean isHidden() {
        return this.mHidden;
    }

    final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isInLayout() {
        return this.mInLayout;
    }

    public final boolean isMenuVisible() {
        return this.mMenuVisible;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= RESUMED;
    }

    public final boolean isVisible() {
        return (!isAdded() || isHidden() || this.mView == null || this.mView.getWindowToken() == null || this.mView.getVisibility() != 0) ? false : true;
    }

    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        Activity h = this.mHost == null ? null : this.mHost.m1012h();
        if (h != null) {
            this.mCalled = false;
            onAttach(h);
        }
    }

    public void onAttachFragment(C0274o c0274o) {
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager != null && !this.mChildFragmentManager.m1111a((int) CREATED)) {
            this.mChildFragmentManager.m1143k();
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        return null;
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        getActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
        if (!this.mCheckedForLoaderManager) {
            this.mCheckedForLoaderManager = true;
            this.mLoaderManager = this.mHost.m993a(this.mWho, this.mLoadersStarted, false);
        }
        if (this.mLoaderManager != null) {
            this.mLoaderManager.m871h();
        }
    }

    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public void onHiddenChanged(boolean z) {
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        Activity h = this.mHost == null ? null : this.mHost.m1012h();
        if (h != null) {
            this.mCalled = false;
            onInflate(h, attributeSet, bundle);
        }
    }

    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z) {
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z) {
    }

    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
        if (!this.mLoadersStarted) {
            this.mLoadersStarted = true;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.m993a(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.m865b();
            }
        }
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    void performActivityCreated(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1142j();
        }
        this.mState = ACTIVITY_CREATED;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (!this.mCalled) {
            throw new ah("Fragment " + this + " did not call through to super.onActivityCreated()");
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1144l();
        }
    }

    void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1101a(configuration);
        }
    }

    boolean performContextItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (onContextItemSelected(menuItem)) {
                return true;
            }
            if (this.mChildFragmentManager != null && this.mChildFragmentManager.m1125b(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void performCreate(Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1142j();
        }
        this.mState = CREATED;
        this.mCalled = false;
        onCreate(bundle);
        if (!this.mCalled) {
            throw new ah("Fragment " + this + " did not call through to super.onCreate()");
        }
    }

    boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onCreateOptionsMenu(menu, menuInflater);
        }
        return this.mChildFragmentManager != null ? z | this.mChildFragmentManager.m1114a(menu, menuInflater) : z;
    }

    View performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1142j();
        }
        return onCreateView(layoutInflater, viewGroup, bundle);
    }

    void performDestroy() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1151s();
        }
        this.mState = INITIALIZING;
        this.mCalled = false;
        onDestroy();
        if (this.mCalled) {
            this.mChildFragmentManager = null;
            return;
        }
        throw new ah("Fragment " + this + " did not call through to super.onDestroy()");
    }

    void performDestroyView() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1150r();
        }
        this.mState = CREATED;
        this.mCalled = false;
        onDestroyView();
        if (!this.mCalled) {
            throw new ah("Fragment " + this + " did not call through to super.onDestroyView()");
        } else if (this.mLoaderManager != null) {
            this.mLoaderManager.m869f();
        }
    }

    void performDetach() {
        this.mCalled = false;
        onDetach();
        if (!this.mCalled) {
            throw new ah("Fragment " + this + " did not call through to super.onDetach()");
        } else if (this.mChildFragmentManager == null) {
        } else {
            if (this.mRetaining) {
                this.mChildFragmentManager.m1151s();
                this.mChildFragmentManager = null;
                return;
            }
            throw new IllegalStateException("Child FragmentManager of " + this + " was not " + " destroyed and this fragment is not retaining instance");
        }
    }

    void performLowMemory() {
        onLowMemory();
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1152t();
        }
    }

    void performMultiWindowModeChanged(boolean z) {
        onMultiWindowModeChanged(z);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1110a(z);
        }
    }

    boolean performOptionsItemSelected(MenuItem menuItem) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
                return true;
            }
            if (this.mChildFragmentManager != null && this.mChildFragmentManager.m1115a(menuItem)) {
                return true;
            }
        }
        return false;
    }

    void performOptionsMenuClosed(Menu menu) {
        if (!this.mHidden) {
            if (this.mHasMenu && this.mMenuVisible) {
                onOptionsMenuClosed(menu);
            }
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m1121b(menu);
            }
        }
    }

    void performPause() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1147o();
        }
        this.mState = STARTED;
        this.mCalled = false;
        onPause();
        if (!this.mCalled) {
            throw new ah("Fragment " + this + " did not call through to super.onPause()");
        }
    }

    void performPictureInPictureModeChanged(boolean z) {
        onPictureInPictureModeChanged(z);
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1123b(z);
        }
    }

    boolean performPrepareOptionsMenu(Menu menu) {
        boolean z = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            z = true;
            onPrepareOptionsMenu(menu);
        }
        return this.mChildFragmentManager != null ? z | this.mChildFragmentManager.m1113a(menu) : z;
    }

    void performReallyStop() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1149q();
        }
        this.mState = ACTIVITY_CREATED;
        if (this.mLoadersStarted) {
            this.mLoadersStarted = false;
            if (!this.mCheckedForLoaderManager) {
                this.mCheckedForLoaderManager = true;
                this.mLoaderManager = this.mHost.m993a(this.mWho, this.mLoadersStarted, false);
            }
            if (this.mLoaderManager == null) {
                return;
            }
            if (this.mHost.m1017m()) {
                this.mLoaderManager.m867d();
            } else {
                this.mLoaderManager.m866c();
            }
        }
    }

    void performResume() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1142j();
            this.mChildFragmentManager.m1135e();
        }
        this.mState = RESUMED;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new ah("Fragment " + this + " did not call through to super.onResume()");
        } else if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1146n();
            this.mChildFragmentManager.m1135e();
        }
    }

    void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        if (this.mChildFragmentManager != null) {
            Parcelable i = this.mChildFragmentManager.m1141i();
            if (i != null) {
                bundle.putParcelable("android:support:fragments", i);
            }
        }
    }

    void performStart() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1142j();
            this.mChildFragmentManager.m1135e();
        }
        this.mState = STARTED;
        this.mCalled = false;
        onStart();
        if (this.mCalled) {
            if (this.mChildFragmentManager != null) {
                this.mChildFragmentManager.m1145m();
            }
            if (this.mLoaderManager != null) {
                this.mLoaderManager.m870g();
                return;
            }
            return;
        }
        throw new ah("Fragment " + this + " did not call through to super.onStart()");
    }

    void performStop() {
        if (this.mChildFragmentManager != null) {
            this.mChildFragmentManager.m1148p();
        }
        this.mState = STOPPED;
        this.mCalled = false;
        onStop();
        if (!this.mCalled) {
            throw new ah("Fragment " + this + " did not call through to super.onStop()");
        }
    }

    public void registerForContextMenu(View view) {
        view.setOnCreateContextMenuListener(this);
    }

    public final void requestPermissions(String[] strArr, int i) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.m997a(this, strArr, i);
    }

    void restoreChildFragmentState(Bundle bundle) {
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("android:support:fragments");
            if (parcelable != null) {
                if (this.mChildFragmentManager == null) {
                    instantiateChildFragmentManager();
                }
                this.mChildFragmentManager.m1103a(parcelable, this.mChildNonConfig);
                this.mChildNonConfig = null;
                this.mChildFragmentManager.m1143k();
            }
        }
    }

    final void restoreViewState(Bundle bundle) {
        if (this.mSavedViewState != null) {
            this.mInnerView.restoreHierarchyState(this.mSavedViewState);
            this.mSavedViewState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (!this.mCalled) {
            throw new ah("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    public void setAllowEnterTransitionOverlap(boolean z) {
        this.mAllowEnterTransitionOverlap = Boolean.valueOf(z);
    }

    public void setAllowReturnTransitionOverlap(boolean z) {
        this.mAllowReturnTransitionOverlap = Boolean.valueOf(z);
    }

    public void setArguments(Bundle bundle) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        this.mArguments = bundle;
    }

    public void setEnterSharedElementCallback(ag agVar) {
        this.mEnterTransitionCallback = agVar;
    }

    public void setEnterTransition(Object obj) {
        this.mEnterTransition = obj;
    }

    public void setExitSharedElementCallback(ag agVar) {
        this.mExitTransitionCallback = agVar;
    }

    public void setExitTransition(Object obj) {
        this.mExitTransition = obj;
    }

    public void setHasOptionsMenu(boolean z) {
        if (this.mHasMenu != z) {
            this.mHasMenu = z;
            if (isAdded() && !isHidden()) {
                this.mHost.m1008d();
            }
        }
    }

    final void setIndex(int i, C0274o c0274o) {
        this.mIndex = i;
        if (c0274o != null) {
            this.mWho = c0274o.mWho + ":" + this.mIndex;
        } else {
            this.mWho = "android:fragment:" + this.mIndex;
        }
    }

    public void setInitialSavedState(C0273b c0273b) {
        if (this.mIndex >= 0) {
            throw new IllegalStateException("Fragment already active");
        }
        Bundle bundle = (c0273b == null || c0273b.f597a == null) ? null : c0273b.f597a;
        this.mSavedFragmentState = bundle;
    }

    public void setMenuVisibility(boolean z) {
        if (this.mMenuVisible != z) {
            this.mMenuVisible = z;
            if (this.mHasMenu && isAdded() && !isHidden()) {
                this.mHost.m1008d();
            }
        }
    }

    public void setReenterTransition(Object obj) {
        this.mReenterTransition = obj;
    }

    public void setRetainInstance(boolean z) {
        this.mRetainInstance = z;
    }

    public void setReturnTransition(Object obj) {
        this.mReturnTransition = obj;
    }

    public void setSharedElementEnterTransition(Object obj) {
        this.mSharedElementEnterTransition = obj;
    }

    public void setSharedElementReturnTransition(Object obj) {
        this.mSharedElementReturnTransition = obj;
    }

    public void setTargetFragment(C0274o c0274o, int i) {
        this.mTarget = c0274o;
        this.mTargetRequestCode = i;
    }

    public void setUserVisibleHint(boolean z) {
        if (!this.mUserVisibleHint && z && this.mState < STARTED && this.mFragmentManager != null && isAdded()) {
            this.mFragmentManager.m1119b(this);
        }
        this.mUserVisibleHint = z;
        boolean z2 = this.mState < STARTED && !z;
        this.mDeferStart = z2;
    }

    public boolean shouldShowRequestPermissionRationale(String str) {
        return this.mHost != null ? this.mHost.m1003a(str) : false;
    }

    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    public void startActivity(Intent intent, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.m995a(this, intent, -1, bundle);
    }

    public void startActivityForResult(Intent intent, int i) {
        startActivityForResult(intent, i, null);
    }

    public void startActivityForResult(Intent intent, int i, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.m995a(this, intent, i, bundle);
    }

    public void startIntentSenderForResult(IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (this.mHost == null) {
            throw new IllegalStateException("Fragment " + this + " not attached to Activity");
        }
        this.mHost.m996a(this, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(128);
        C0382c.m1432a(this, stringBuilder);
        if (this.mIndex >= 0) {
            stringBuilder.append(" #");
            stringBuilder.append(this.mIndex);
        }
        if (this.mFragmentId != 0) {
            stringBuilder.append(" id=0x");
            stringBuilder.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            stringBuilder.append(" ");
            stringBuilder.append(this.mTag);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public void unregisterForContextMenu(View view) {
        view.setOnCreateContextMenuListener(null);
    }
}
