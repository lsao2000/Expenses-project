package com.example.contrrolyourmoney;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.InflateException;
import android.widget.TextView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.content.Intent;
import android.os.Handler;
import android.view.WindowManager;
public class Intro extends AppCompatActivity {
    private TextView brand, brandDescription;
    private Intent nextAcitvity;
    private Animation brandAnimation, infoBrandAniamtion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_intro);
        // Get animation for to implement it in the brand name and the description of the brand.
        brandAnimation     = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.brand_animation);
        infoBrandAniamtion = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.info_brand_animation);

        brandDescription = findViewById(R.id.control_you);
        brand            = findViewById(R.id.cym);

        // set the animtion to the text.
        brandDescription.setAnimation(infoBrandAniamtion);
        brand.setAnimation(brandAnimation);
        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent moveToNextActivity = new Intent(getApplicationContext(), About.class);
                startActivity(moveToNextActivity);
            }
        }, 2000);
    }
}