package com.simplemobiletools.gallery.fragments;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer.OnVideoSizeChangedListener;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import com.simplemobiletools.gallery.C1333R;
import com.simplemobiletools.gallery.extensions.ActivityKt;
import com.simplemobiletools.gallery.extensions.ResourcesKt;
import com.simplemobiletools.gallery.helpers.Config;
import com.simplemobiletools.gallery.helpers.ConstantsKt;
import com.simplemobiletools.gallery.models.Medium;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import p000a.C0027d;
import p000a.p005e.p007b.C0036f;
import p000a.p005e.p007b.C0045k;

public final class VideoFragment extends ViewPagerFragment implements OnCompletionListener, OnPreparedListener, OnVideoSizeChangedListener, Callback, OnClickListener, OnSeekBarChangeListener {
    public static final Companion Companion;
    private static final String PROGRESS;
    private static final String TAG;
    private HashMap _$_findViewCache;
    private int mCurrTime;
    private TextView mCurrTimeView;
    private int mDuration;
    private boolean mIsDragged;
    private boolean mIsFragmentVisible;
    private boolean mIsFullscreen;
    private boolean mIsPlaying;
    private MediaPlayer mMediaPlayer;
    public Medium mMedium;
    private SeekBar mSeekBar;
    private SurfaceHolder mSurfaceHolder;
    private SurfaceView mSurfaceView;
    private View mTimeHolder;
    private Handler mTimerHandler;
    public View mView;

    public static final class Companion {
        private Companion() {
        }

        private final String getPROGRESS() {
            return VideoFragment.PROGRESS;
        }

        private final String getTAG() {
            return VideoFragment.TAG;
        }
    }

    static {
        Companion = new Companion();
        TAG = VideoFragment.class.getSimpleName();
        PROGRESS = PROGRESS;
    }

    private final void addPreviewImage() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            C0036f.m58a();
        }
        mediaPlayer.start();
        mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            C0036f.m58a();
        }
        mediaPlayer.pause();
    }

    private final void checkFullscreen() {
        int i;
        SeekBar seekBar;
        if (this.mIsFullscreen) {
            seekBar = this.mSeekBar;
            if (seekBar == null) {
                C0036f.m58a();
            }
            seekBar.setOnSeekBarChangeListener((OnSeekBarChangeListener) null);
            i = C1333R.anim.fade_out;
        } else {
            seekBar = this.mSeekBar;
            if (seekBar == null) {
                C0036f.m58a();
            }
            seekBar.setOnSeekBarChangeListener(this);
            i = C1333R.anim.fade_in;
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), i);
        View view = this.mTimeHolder;
        if (view == null) {
            C0036f.m58a();
        }
        view.startAnimation(loadAnimation);
    }

    private final void cleanup() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.fragments.VideoFragment.cleanup():void
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
        r1 = 0;
        r3 = 0;
        r4.pauseVideo();
        r2 = r4.mCurrTimeView;
        if (r2 == 0) goto L_0x0012;
    L_0x0009:
        r0 = r4.getTimeString(r3);
        r0 = (java.lang.CharSequence) r0;
        r2.setText(r0);
    L_0x0012:
        r0 = r4.mMediaPlayer;
        if (r0 == 0) goto L_0x0019;
    L_0x0016:
        r0.release();
        r0 = r1;
        r0 = (android.media.MediaPlayer) r0;
        r4.mMediaPlayer = r0;
        r0 = r4.mSeekBar;
        if (r0 == 0) goto L_0x0026;
        r0.setProgress(r3);
        r0 = r4.mTimerHandler;
        if (r0 == 0) goto L_0x002d;
        r0.removeCallbacksAndMessages(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.fragments.VideoFragment.cleanup():void");
    }

    private final String getTimeString(int i) {
        Object obj;
        Object format;
        StringBuilder stringBuilder = new StringBuilder(8);
        int i2 = i / 3600;
        int i3 = (i % 3600) / 60;
        int i4 = (i % 3600) % 60;
        if (i > 3600) {
            C0045k c0045k = C0045k.f16a;
            obj = Locale.getDefault();
            C0036f.m59a(obj, "Locale.getDefault()");
            Object[] objArr = new Object[]{Integer.valueOf(i2)};
            format = String.format(obj, "%02d", Arrays.copyOf(objArr, objArr.length));
            C0036f.m59a(format, "java.lang.String.format(locale, format, *args)");
            stringBuilder.append(format).append(":");
        }
        C0045k c0045k2 = C0045k.f16a;
        obj = Locale.getDefault();
        C0036f.m59a(obj, "Locale.getDefault()");
        Object[] objArr2 = new Object[]{Integer.valueOf(i3)};
        format = String.format(obj, "%02d", Arrays.copyOf(objArr2, objArr2.length));
        C0036f.m59a(format, "java.lang.String.format(locale, format, *args)");
        stringBuilder.append(format);
        StringBuilder append = stringBuilder.append(":");
        c0045k2 = C0045k.f16a;
        obj = Locale.getDefault();
        C0036f.m59a(obj, "Locale.getDefault()");
        objArr2 = new Object[]{Integer.valueOf(i4)};
        format = String.format(obj, "%02d", Arrays.copyOf(objArr2, objArr2.length));
        C0036f.m59a(format, "java.lang.String.format(locale, format, *args)");
        append.append(format);
        format = stringBuilder.toString();
        C0036f.m59a(format, "sb.toString()");
        return format;
    }

    private final void initMediaPlayer() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.fragments.VideoFragment.initMediaPlayer():void
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
        r1 = r6.mMediaPlayer;
        if (r1 == 0) goto L_0x0005;
    L_0x0004:
        return;
        r2 = new android.media.MediaPlayer;	 Catch:{ IOException -> 0x0050 }
        r2.<init>();	 Catch:{ IOException -> 0x0050 }
        r0 = r2;	 Catch:{ IOException -> 0x0050 }
        r0 = (android.media.MediaPlayer) r0;	 Catch:{ IOException -> 0x0050 }
        r1 = r0;	 Catch:{ IOException -> 0x0050 }
        r3 = r6.getContext();	 Catch:{ IOException -> 0x0050 }
        r4 = r6.mMedium;	 Catch:{ IOException -> 0x0050 }
        if (r4 != 0) goto L_0x001d;	 Catch:{ IOException -> 0x0050 }
        r5 = "mMedium";	 Catch:{ IOException -> 0x0050 }
        p000a.p005e.p007b.C0036f.m63b(r5);	 Catch:{ IOException -> 0x0050 }
        r4 = r4.getPath();	 Catch:{ IOException -> 0x0050 }
        r4 = android.net.Uri.parse(r4);	 Catch:{ IOException -> 0x0050 }
        r1.setDataSource(r3, r4);	 Catch:{ IOException -> 0x0050 }
        r3 = r6.mSurfaceHolder;	 Catch:{ IOException -> 0x0050 }
        r1.setDisplay(r3);	 Catch:{ IOException -> 0x0050 }
        r0 = r6;	 Catch:{ IOException -> 0x0050 }
        r0 = (android.media.MediaPlayer.OnCompletionListener) r0;	 Catch:{ IOException -> 0x0050 }
        r3 = r0;	 Catch:{ IOException -> 0x0050 }
        r1.setOnCompletionListener(r3);	 Catch:{ IOException -> 0x0050 }
        r0 = r6;	 Catch:{ IOException -> 0x0050 }
        r0 = (android.media.MediaPlayer.OnVideoSizeChangedListener) r0;	 Catch:{ IOException -> 0x0050 }
        r3 = r0;	 Catch:{ IOException -> 0x0050 }
        r1.setOnVideoSizeChangedListener(r3);	 Catch:{ IOException -> 0x0050 }
        r0 = r6;	 Catch:{ IOException -> 0x0050 }
        r0 = (android.media.MediaPlayer.OnPreparedListener) r0;	 Catch:{ IOException -> 0x0050 }
        r3 = r0;	 Catch:{ IOException -> 0x0050 }
        r1.setOnPreparedListener(r3);	 Catch:{ IOException -> 0x0050 }
        r3 = 3;	 Catch:{ IOException -> 0x0050 }
        r1.setAudioStreamType(r3);	 Catch:{ IOException -> 0x0050 }
        r1.prepareAsync();	 Catch:{ IOException -> 0x0050 }
        r2 = (android.media.MediaPlayer) r2;	 Catch:{ IOException -> 0x0050 }
        r6.mMediaPlayer = r2;	 Catch:{ IOException -> 0x0050 }
        goto L_0x0004;
    L_0x0050:
        r1 = move-exception;
        r2 = Companion;
        r2 = r2.getTAG();
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = "init media player failed ";
        r3 = r3.append(r4);
        r1 = r3.append(r1);
        r1 = r1.toString();
        android.util.Log.e(r2, r1);
        goto L_0x0004;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.fragments.VideoFragment.initMediaPlayer():void");
    }

    private final void initTimeHolder() {
        View view = this.mView;
        if (view == null) {
            C0036f.m63b("mView");
        }
        this.mTimeHolder = (RelativeLayout) view.findViewById(C1333R.id.video_time_holder);
        Resources resources = getResources();
        int navBarHeight = ResourcesKt.getNavBarHeight(resources);
        view = this.mTimeHolder;
        if (view == null) {
            C0036f.m58a();
        }
        int paddingLeft = view.getPaddingLeft();
        view = this.mTimeHolder;
        if (view == null) {
            C0036f.m58a();
        }
        int paddingTop = view.getPaddingTop();
        int dimension = (int) resources.getDimension(C1333R.dimen.timer_padding);
        if (ActivityKt.hasNavBar(getActivity())) {
            int i;
            int i2;
            if (resources.getConfiguration().orientation == 1) {
                i = 0 + navBarHeight;
                i2 = dimension;
            } else {
                i2 = dimension + navBarHeight;
                i = 0;
            }
            View view2 = this.mTimeHolder;
            if (view2 == null) {
                C0036f.m58a();
            }
            view2.setPadding(paddingLeft, paddingTop, i2, i);
        }
        view = this.mView;
        if (view == null) {
            C0036f.m63b("mView");
        }
        this.mCurrTimeView = (TextView) view.findViewById(C1333R.id.video_curr_time);
        view = this.mView;
        if (view == null) {
            C0036f.m63b("mView");
        }
        this.mSeekBar = (SeekBar) view.findViewById(C1333R.id.video_seekbar);
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            C0036f.m58a();
        }
        seekBar.setOnSeekBarChangeListener(this);
        if (this.mIsFullscreen) {
            view = this.mTimeHolder;
            if (view == null) {
                C0036f.m58a();
            }
            view.setVisibility(4);
        }
    }

    private final void pauseVideo() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.fragments.VideoFragment.pauseVideo():void
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
        r0 = 0;
        r3.mIsPlaying = r0;
        r0 = r3.mMediaPlayer;
        if (r0 == 0) goto L_0x000a;
    L_0x0007:
        r0.pause();
        r0 = r3.mView;
        if (r0 != 0) goto L_0x0014;
        r1 = "mView";
        p000a.p005e.p007b.C0036f.m63b(r1);
        r1 = com.simplemobiletools.gallery.C1333R.id.video_play_outline;
        r0 = r0.findViewById(r1);
        r0 = (android.widget.ImageView) r0;
        r1 = r3.getResources();
        r2 = 2130903052; // 0x7f03000c float:1.7412911E38 double:1.0528059926E-314;
        r1 = r1.getDrawable(r2);
        r0.setImageDrawable(r1);
        r0 = r3.getActivity();
        r0 = r0.getWindow();
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0.clearFlags(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.fragments.VideoFragment.pauseVideo():void");
    }

    private final void playVideo() {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.fragments.VideoFragment.playVideo():void
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
        r0 = 1;
        r2.mIsPlaying = r0;
        r0 = r2.mMediaPlayer;
        if (r0 == 0) goto L_0x000a;
    L_0x0007:
        r0.start();
        r0 = r2.mView;
        if (r0 != 0) goto L_0x0014;
        r1 = "mView";
        p000a.p005e.p007b.C0036f.m63b(r1);
        r1 = com.simplemobiletools.gallery.C1333R.id.video_play_outline;
        r0 = r0.findViewById(r1);
        r0 = (android.widget.ImageView) r0;
        r1 = 0;
        r1 = (android.graphics.drawable.Drawable) r1;
        r0.setImageDrawable(r1);
        r0 = r2.getActivity();
        r0 = r0.getWindow();
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r0.addFlags(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.fragments.VideoFragment.playVideo():void");
    }

    private final void setProgress(int i) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            C0036f.m58a();
        }
        mediaPlayer.seekTo(i * 1000);
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            C0036f.m58a();
        }
        seekBar.setProgress(i);
        TextView textView = this.mCurrTimeView;
        if (textView == null) {
            C0036f.m58a();
        }
        textView.setText(getTimeString(i));
    }

    private final void setVideoSize() {
        if (getActivity() != null) {
            int i;
            int i2;
            initMediaPlayer();
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null) {
                C0036f.m58a();
            }
            float videoWidth = (float) mediaPlayer.getVideoWidth();
            MediaPlayer mediaPlayer2 = this.mMediaPlayer;
            if (mediaPlayer2 == null) {
                C0036f.m58a();
            }
            float videoHeight = videoWidth / ((float) mediaPlayer2.getVideoHeight());
            Display defaultDisplay = getActivity().getWindowManager().getDefaultDisplay();
            if (VERSION.SDK_INT >= 17) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                defaultDisplay.getRealMetrics(displayMetrics);
                i = displayMetrics.widthPixels;
                int i3 = displayMetrics.heightPixels;
                i2 = i;
                i = i3;
            } else {
                i2 = defaultDisplay.getWidth();
                i = defaultDisplay.getHeight();
            }
            float f = ((float) i2) / ((float) i);
            SurfaceView surfaceView = this.mSurfaceView;
            if (surfaceView == null) {
                C0036f.m58a();
            }
            LayoutParams layoutParams = surfaceView.getLayoutParams();
            if (videoHeight > f) {
                layoutParams.width = i2;
                layoutParams.height = (int) (((float) i2) / videoHeight);
            } else {
                layoutParams.width = (int) (((float) i) * videoHeight);
                layoutParams.height = i;
            }
            SurfaceView surfaceView2 = this.mSurfaceView;
            if (surfaceView2 == null) {
                C0036f.m58a();
            }
            surfaceView2.setLayoutParams(layoutParams);
        }
    }

    private final void setupPlayer() {
        if (getActivity() != null) {
            View view = this.mView;
            if (view == null) {
                C0036f.m63b("mView");
            }
            ((ImageView) view.findViewById(C1333R.id.video_play_outline)).setOnClickListener(this);
            view = this.mView;
            if (view == null) {
                C0036f.m63b("mView");
            }
            this.mSurfaceView = (SurfaceView) view.findViewById(C1333R.id.video_surface);
            SurfaceView surfaceView = this.mSurfaceView;
            if (surfaceView == null) {
                C0036f.m58a();
            }
            surfaceView.setOnClickListener(this);
            SurfaceView surfaceView2 = this.mSurfaceView;
            if (surfaceView2 == null) {
                C0036f.m58a();
            }
            this.mSurfaceHolder = surfaceView2.getHolder();
            SurfaceHolder surfaceHolder = this.mSurfaceHolder;
            if (surfaceHolder == null) {
                C0036f.m58a();
            }
            surfaceHolder.addCallback(this);
            initTimeHolder();
        }
    }

    private final void setupTimeHolder() {
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            C0036f.m58a();
        }
        seekBar.setMax(this.mDuration);
        View view = this.mView;
        if (view == null) {
            C0036f.m63b("mView");
        }
        ((TextView) view.findViewById(C1333R.id.video_duration)).setText(getTimeString(this.mDuration));
        this.mTimerHandler = new Handler();
        setupTimer();
    }

    private final void setupTimer() {
        getActivity().runOnUiThread(new VideoFragment$setupTimer$1(this));
    }

    private final void togglePlayPause() {
        if (getActivity() != null && isAdded()) {
            this.mIsPlaying = !this.mIsPlaying;
            if (this.mIsPlaying) {
                playVideo();
            } else {
                pauseVideo();
            }
        }
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
        view = getView();
        if (view == null) {
            return null;
        }
        view = view.findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), view);
        return view;
    }

    public final Medium getMMedium() {
        Medium medium = this.mMedium;
        if (medium == null) {
            C0036f.m63b("mMedium");
        }
        return medium;
    }

    public final View getMView() {
        View view = this.mView;
        if (view == null) {
            C0036f.m63b("mView");
        }
        return view;
    }

    public void itemDragged() {
        pauseVideo();
    }

    public void onClick(android.view.View r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.fragments.VideoFragment.onClick(android.view.View):void
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
        p000a.p005e.p007b.C0036f.m62b(r3, r0);
        r0 = r3.getId();
        switch(r0) {
            case 2131624171: goto L_0x002a;
            default: goto L_0x000c;
        };
    L_0x000c:
        r0 = r2.mIsFullscreen;
        if (r0 != 0) goto L_0x002e;
    L_0x0010:
        r0 = 1;
    L_0x0011:
        r2.mIsFullscreen = r0;
        r2.checkFullscreen();
        r0 = r2.getListener();
        if (r0 != 0) goto L_0x0035;
    L_0x001c:
        r0 = r2.getActivity();
        if (r0 != 0) goto L_0x0030;
    L_0x0022:
        r0 = new a.d;
        r1 = "null cannot be cast to non-null type com.simplemobiletools.gallery.fragments.ViewPagerFragment.FragmentClickListener";
        r0.<init>(r1);
        throw r0;
    L_0x002a:
        r2.togglePlayPause();
        return;
    L_0x002e:
        r0 = 0;
        goto L_0x0011;
    L_0x0030:
        r0 = (com.simplemobiletools.gallery.fragments.ViewPagerFragment.FragmentClickListener) r0;
        r2.setListener(r0);
    L_0x0035:
        r0 = r2.getListener();
        if (r0 == 0) goto L_0x003e;
    L_0x003b:
        r0.fragmentClicked();
        goto L_0x002d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.fragments.VideoFragment.onClick(android.view.View):void");
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        C0036f.m62b(mediaPlayer, "mp");
        SeekBar seekBar = this.mSeekBar;
        if (seekBar == null) {
            C0036f.m58a();
        }
        SeekBar seekBar2 = this.mSeekBar;
        if (seekBar2 == null) {
            C0036f.m58a();
        }
        seekBar.setProgress(seekBar2.getMax());
        TextView textView = this.mCurrTimeView;
        if (textView == null) {
            C0036f.m58a();
        }
        textView.setText(getTimeString(this.mDuration));
        pauseVideo();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        C0036f.m62b(layoutInflater, "inflater");
        Object inflate = layoutInflater.inflate(C1333R.layout.pager_video_item, viewGroup, false);
        C0036f.m59a(inflate, "inflater.inflate(R.layou\u2026o_item, container, false)");
        this.mView = inflate;
        Serializable serializable = getArguments().getSerializable(ConstantsKt.getMEDIUM());
        if (serializable == null) {
            throw new C0027d("null cannot be cast to non-null type com.simplemobiletools.gallery.models.Medium");
        }
        this.mMedium = (Medium) serializable;
        if (bundle != null) {
            this.mCurrTime = bundle.getInt(Companion.getPROGRESS());
        }
        this.mIsFullscreen = (getActivity().getWindow().getDecorView().getSystemUiVisibility() & 4) == 4;
        setupPlayer();
        View view = this.mView;
        if (view == null) {
            C0036f.m63b("mView");
        }
        view.setOnClickListener(this);
        View view2 = this.mView;
        if (view2 == null) {
            C0036f.m63b("mView");
        }
        return view2;
    }

    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null && !getActivity().isChangingConfigurations()) {
            cleanup();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    public void onPause() {
        super.onPause();
        pauseVideo();
        this.mIsFragmentVisible = false;
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        C0036f.m62b(mediaPlayer, "mp");
        this.mDuration = mediaPlayer.getDuration() / 1000;
        addPreviewImage();
        setupTimeHolder();
        setProgress(this.mCurrTime);
        if (this.mIsFragmentVisible) {
            com.simplemobiletools.gallery.helpers.Config.Companion companion = Config.Companion;
            Object context = getContext();
            C0036f.m59a(context, "context");
            if (companion.newInstance(context).getAutoplayVideos()) {
                playVideo();
            }
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        C0036f.m62b(seekBar, "seekBar");
        if (this.mMediaPlayer != null && z) {
            setProgress(i);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        C0036f.m62b(bundle, "outState");
        super.onSaveInstanceState(bundle);
        bundle.putInt(Companion.getPROGRESS(), this.mCurrTime);
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        C0036f.m62b(seekBar, "seekBar");
        initMediaPlayer();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer == null) {
            C0036f.m58a();
        }
        mediaPlayer.pause();
        this.mIsDragged = true;
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        C0036f.m62b(seekBar, "seekBar");
        if (this.mIsPlaying) {
            MediaPlayer mediaPlayer = this.mMediaPlayer;
            if (mediaPlayer == null) {
                C0036f.m58a();
            }
            mediaPlayer.start();
        } else {
            togglePlayPause();
        }
        this.mIsDragged = false;
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        C0036f.m62b(mediaPlayer, "mp");
        setVideoSize();
    }

    public final void setMMedium(Medium medium) {
        C0036f.m62b(medium, "<set-?>");
        this.mMedium = medium;
    }

    public final void setMView(View view) {
        C0036f.m62b(view, "<set-?>");
        this.mView = view;
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
        this.mIsFragmentVisible = z;
        if (z && getContext() != null) {
            com.simplemobiletools.gallery.helpers.Config.Companion companion = Config.Companion;
            Object context = getContext();
            C0036f.m59a(context, "context");
            if (companion.newInstance(context).getAutoplayVideos()) {
                playVideo();
            }
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        C0036f.m62b(surfaceHolder, "holder");
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        C0036f.m62b(surfaceHolder, "holder");
        initMediaPlayer();
    }

    public void surfaceDestroyed(android.view.SurfaceHolder r1) {
        /* JADX: method processing error */
/*
        Error: jadx.core.utils.exceptions.DecodeException: Load method exception in method: com.simplemobiletools.gallery.fragments.VideoFragment.surfaceDestroyed(android.view.SurfaceHolder):void
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
        r0 = "holder";
        p000a.p005e.p007b.C0036f.m62b(r2, r0);
        r0 = r1.mMediaPlayer;
        if (r0 == 0) goto L_0x000c;
    L_0x0009:
        r0.release();
        r0 = 0;
        r0 = (android.media.MediaPlayer) r0;
        r1.mMediaPlayer = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.simplemobiletools.gallery.fragments.VideoFragment.surfaceDestroyed(android.view.SurfaceHolder):void");
    }

    public void systemUiVisibilityChanged(boolean z) {
        if (this.mIsFullscreen != z) {
            this.mIsFullscreen = z;
            checkFullscreen();
        }
    }

    public void updateItem() {
        setVideoSize();
        initTimeHolder();
    }
}
