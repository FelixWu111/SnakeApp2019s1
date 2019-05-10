package com.example.u6250082.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Gameinit gi;
    drawSnack ds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gi = new Gameinit();
        gi.firstStep();

        ds = findViewById(R.id.drawSnack);
        ds.putinWhatToDraw(gi.getboardState());
        ds.invalidate();

    }


}
