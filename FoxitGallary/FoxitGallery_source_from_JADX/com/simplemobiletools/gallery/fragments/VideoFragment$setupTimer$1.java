package com.simplemobiletools.gallery.fragments;

import android.media.MediaPlayer;
import android.os.Handler;
import android.widget.SeekBar;
import android.widget.TextView;
import p000a.p005e.p007b.C0036f;

public final class VideoFragment$setupTimer$1 implements Runnable {
    final /* synthetic */ VideoFragment this$0;

    VideoFragment$setupTimer$1(VideoFragment videoFragment) {
        this.this$0 = videoFragment;
    }

    public void run() {
        if (!(this.this$0.mMediaPlayer == null || this.this$0.mIsDragged || !this.this$0.mIsPlaying)) {
            VideoFragment videoFragment = this.this$0;
            MediaPlayer access$getMMediaPlayer$p = this.this$0.mMediaPlayer;
            if (access$getMMediaPlayer$p == null) {
                C0036f.m58a();
            }
            videoFragment.mCurrTime = access$getMMediaPlayer$p.getCurrentPosition() / 1000;
            SeekBar access$getMSeekBar$p = this.this$0.mSeekBar;
            if (access$getMSeekBar$p == null) {
                C0036f.m58a();
            }
            access$getMSeekBar$p.setProgress(this.this$0.mCurrTime);
            TextView access$getMCurrTimeView$p = this.this$0.mCurrTimeView;
            if (access$getMCurrTimeView$p == null) {
                C0036f.m58a();
            }
            access$getMCurrTimeView$p.setText(this.this$0.getTimeString(this.this$0.mCurrTime));
        }
        Handler access$getMTimerHandler$p = this.this$0.mTimerHandler;
        if (access$getMTimerHandler$p == null) {
            C0036f.m58a();
        }
        access$getMTimerHandler$p.postDelayed(this, 1000);
    }
}
