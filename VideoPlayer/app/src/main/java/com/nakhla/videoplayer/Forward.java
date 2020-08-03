package com.nakhla.videoplayer;

import android.widget.VideoView;

public class Forward implements Functionalities {

    private int seekForwardTime = 3 * 1000; // default 5 second
    private int seekBackwardTime = 3 * 1000; // default 5 second

    @Override
    public void actions(String s, VideoView videoView) {

        if (videoView != null) {
            int currentPosition = videoView.getCurrentPosition();
            if (currentPosition + seekForwardTime <= videoView.getDuration()) {
                videoView.seekTo(currentPosition + seekForwardTime);
            } else {
                videoView.seekTo(videoView.getDuration());
            }
        }

    }
}
