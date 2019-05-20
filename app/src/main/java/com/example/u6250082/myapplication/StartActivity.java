package com.example.u6250082.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

//Qingzheng XU
//u6174243
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
    }

    public void starthard(View v) {//Start game
        MainActivity.hard();
        Intent i = new Intent(StartActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void startnormal(View v) {//Start game
        MainActivity.normal();
        Intent i = new Intent(StartActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void starteasy(View v) {//Start game
        MainActivity.easy();
        Intent i = new Intent(StartActivity.this, MainActivity.class);
        startActivity(i);
    }

    public void help(View v){//Open the instruction
        findViewById(R.id.instruction).setVisibility(View.VISIBLE);
        findViewById(R.id.back).setVisibility(View.VISIBLE);
    }

    public void back(View v){//Close the instruction
        final Animation out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(3000); // fade animation
        findViewById(R.id.instruction).startAnimation(out);
        findViewById(R.id.back).startAnimation(out);
        findViewById(R.id.instruction).setVisibility(View.INVISIBLE);
        findViewById(R.id.back).setVisibility(View.INVISIBLE);
    }
}
