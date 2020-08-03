package com.nakhla.videoplayer;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.SeekBar;
import android.widget.VideoView;

public class CustomPlayer extends AppCompatActivity {

    private VideoView videoView;
    private SeekBar seekBar;
    int position;
    private String MEDIA_PATH = "";
    private int seekForwardTime = 3 * 1000; // default 5 second
    private int seekBackwardTime = 3 * 1000; // default 5 second

    ShapeMaker shapeMaker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_player);

        Intent intent = getIntent();
        position = intent.getIntExtra("position", -1);
        MEDIA_PATH = String.valueOf(MainActivity.fileArrayList.get(position));

        videoView = (VideoView) findViewById(R.id.custom_video_view);
        seekBar = (SeekBar) findViewById(R.id.seek_bar);

        videoView.setVideoPath(MEDIA_PATH);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {

                seekBar.setMax(videoView.getDuration());
                seekBar.postDelayed(onEverySecond, 1000);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {

                if(fromUser) {
                    // this is when actually seekbar has been seeked to a new position
                    videoView.seekTo(progress);
                }
            }
        });

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoView.setVideoPath(String.valueOf(MainActivity.fileArrayList.get(++position)));
                videoView.start();
            }
        });

        shapeMaker = new ShapeMaker();


        PlayButton(null);

    }
    private Runnable onEverySecond=new Runnable() {

        @Override
        public void run() {

            if(seekBar != null) {
                seekBar.setProgress(videoView.getCurrentPosition());
            }

            if(videoView.isPlaying()) {
                seekBar.postDelayed(onEverySecond, 1000);
            }

        }
    };

    /**
     * Plays the video
     * @param view
     */
    public void PlayButton(View view){

        /*if(videoView.isPlaying())
        {
            videoView.pause();
        }
        else{
            videoView.start();
        }*/

        shapeMaker.setplayPause(MEDIA_PATH, videoView);

    }

    /*public void PauseButton(View view){
        videoView.pause();

    }*/

    /**
     * Forwards the video
     * @param view
     */
    public void ForwardButton(View view){
//        videoView.stopPlayback();
//        videoView.setVideoPath(MEDIA_PATH);
//        videoView.start();
        /*if (videoView != null) {
            int currentPosition = videoView.getCurrentPosition();
            if (currentPosition + seekForwardTime <= videoView.getDuration()) {
                videoView.seekTo(currentPosition + seekForwardTime);
            } else {
                videoView.seekTo(videoView.getDuration());
            }
        }*/

        shapeMaker.setForward(MEDIA_PATH, videoView);
    }

    /**
     * Rewinds the video
     * @param view
     */
    public void RewindButton(View view){
        //videoView.stopPlayback();
        //videoView.setVideoPath(MEDIA_PATH);
        /*if (videoView != null) {
            int currentPosition = videoView.getCurrentPosition();
            if (currentPosition - seekBackwardTime >= 0) {
                videoView.seekTo(currentPosition - seekBackwardTime);
            } else {
                videoView.seekTo(0);
            }
        }*/
        shapeMaker.setRewind(MEDIA_PATH, videoView);
    }

}