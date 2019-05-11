package com.example.u6250082.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Gameinit gi;
    drawSnack ds;
    final Handler h =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gi = new Gameinit();
        gi.firstStep();

        ds = (drawSnack)findViewById(R.id.drawSnack);
        ds.putinWhatToDraw(gi.getboardState());
        ds.invalidate();
        refreshHandler();
    }
    private void refreshHandler(){
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                gi.refreshState();
                if (gi.getnowState()== Gameinit.state.alive){
                    h.postDelayed(this,80);
                }
                if (gi.getnowState()== Gameinit.state.dead){

                }
                ds.putinWhatToDraw(gi.getboardState());
                ds.invalidate();
            }
        },80);
    }


}
