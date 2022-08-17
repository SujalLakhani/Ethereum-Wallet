package com.example.blockchainwallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class NotificationScreen extends AppCompatActivity {

    MediaPlayer bell;
    TextView message;
    Animation down,inup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_screen);

        bell = MediaPlayer.create(NotificationScreen.this,R.raw.bell);
        message = findViewById(R.id.message);
        down = AnimationUtils.loadAnimation(NotificationScreen.this,R.anim.down);
        inup = AnimationUtils.loadAnimation(NotificationScreen.this,R.anim.inup);

        message.setText(getIntent().getStringExtra("message"));
        message.startAnimation(inup);
        bell.start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(NotificationScreen.this, HomeScreen.class));
                finish();
            }
        },1800);
    }

    @Override
    protected void onPause() {
        super.onPause();
        bell.release();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bell.release();
    }

}