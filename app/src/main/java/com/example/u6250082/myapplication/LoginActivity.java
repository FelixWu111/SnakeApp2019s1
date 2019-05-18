package com.example.u6250082.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
//Qingzheng XU
//u6174243
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void start(View v) {//Start tourist mode
        Intent i = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(i);
    }
}
