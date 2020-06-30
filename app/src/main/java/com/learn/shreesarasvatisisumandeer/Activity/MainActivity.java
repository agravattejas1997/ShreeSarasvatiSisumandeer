package com.learn.shreesarasvatisisumandeer.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.learn.shreesarasvatisisumandeer.R;

public class MainActivity extends AppCompatActivity {


    //Load animation
    Animation slide_down;

    Animation slide_up;

    LinearLayout mLinearLayoutLogo;
    private static int SPLASH_SCREEN_TIME_OUT=2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        slide_down = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_down);
        slide_up =AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.slide_up);


        mLinearLayoutLogo = findViewById(R.id.linear_logo);


        mLinearLayoutLogo.startAnimation(slide_down);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(
                        MainActivity.this,
                        HomeActivity.class));

                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }
}
