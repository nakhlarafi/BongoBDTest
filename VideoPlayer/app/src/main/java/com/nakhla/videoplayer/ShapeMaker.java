package com.nakhla.videoplayer;

import android.graphics.drawable.shapes.Shape;
import android.widget.VideoView;

import androidx.constraintlayout.solver.widgets.Rectangle;

public class ShapeMaker {
    private Functionalities playPause;
    private Functionalities forward;
    private Functionalities rewind;

    public ShapeMaker() {
        playPause = new PlayPause();
        forward = new Forward();
        rewind = new Rewind();
    }

    public void setplayPause(String s, VideoView videoView){
        playPause.actions(s, videoView);
    }
    public void setRewind(String s, VideoView videoView){
        rewind.actions(s, videoView);
    }
    public void setForward(String s, VideoView videoView){
        forward.actions(s, videoView);
    }
}
