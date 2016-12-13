package com.basecompany.baseappandroid.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.VideoView;

import com.basecompany.baseappandroid.R;
import com.basecompany.baseappandroid.utils.Settings;

/**
 * Created by Raul Aponte on 07/12/16.
 */
public class SplashActivity extends Activity implements MediaPlayer.OnCompletionListener {
    private VideoView videoView;

    public static void start(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        videoView = (VideoView) findViewById(R.id.asp_vid_splash);
        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                videoView.stopPlayback();
                splashCompleted();
                return false;
            }
        });

        playSplash();
    }

    private void playSplash() {
        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.splash);
        videoView.setVideoURI(video);
        videoView.requestFocus();
        videoView.setOnCompletionListener(this);
        videoView.start();
    }

    private void splashCompleted(){
        if (Settings.getToken()==null) {
            LoginActivity.start(this);
        } else {
            DashboardActivity.start(this);
        }
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        splashCompleted();
    }
}
