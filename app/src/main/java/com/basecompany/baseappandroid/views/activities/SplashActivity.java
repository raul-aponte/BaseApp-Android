package com.basecompany.baseappandroid.views.activities;

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

public class SplashActivity extends Activity implements MediaPlayer.OnCompletionListener {
    private VideoView videoView;

    public static Intent newIntent(Context context) {
        return new Intent(context, SplashActivity.class);
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

    private void splashCompleted() {
        Intent intent;
        if (Settings.getToken() == null) {
            intent = LoginActivity.newIntent(this);
        } else {
            intent = DashboardActivity.newIntent(this);
        }
        startActivity(intent);
    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        splashCompleted();
    }
}