package com.nakhla.videoplayer;

import android.widget.VideoView;

public class PlayPause implements Functionalities{

    private int seekForwardTime = 3 * 1000; // default 5 second
    private int seekBackwardTime = 3 * 1000; // default 5 second

    @Override
    public void actions(String s, VideoView videoView) {
        if(videoView.isPlaying())
        {
            videoView.pause();
        }
        else{
            videoView.start();
        }
    }
}
