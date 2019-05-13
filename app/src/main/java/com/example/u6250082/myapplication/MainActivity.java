package com.example.u6250082.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
                    h.postDelayed(this,180);//set the time of game delay
                }
                if (gi.getnowState()== Gameinit.state.dead){
                    gi.setState(Gameinit.state.alive);
                    gi.setOri(Gameinit.orientate.right);
                    gi.firstStep();
                    ds = (drawSnack)findViewById(R.id.drawSnack);
                    ds.putinWhatToDraw(gi.getboardState());
                    ds.invalidate();
                    refreshHandler();
                }
                ds.putinWhatToDraw(gi.getboardState());
                ds.invalidate();
            }
        },180);
    }


    //u6250866
    public void left(View v){  //create the function left
        if (gi.getnowOri()!= Gameinit.orientate.right) {
            gi.setOri(Gameinit.orientate.left);
        }
    }
    public void right(View v){  //create the function right
        if (gi.getnowOri()!= Gameinit.orientate.left) {
            gi.setOri(Gameinit.orientate.right);
        }
    }
    public void down(View v){  //create the function down
        if (gi.getnowOri()!= Gameinit.orientate.up) {
            gi.setOri(Gameinit.orientate.down);
        }
    }
    public void up(View v){  //create the function up
        if (gi.getnowOri()!= Gameinit.orientate.down) {
            gi.setOri(Gameinit.orientate.up);
        }
    }
    public void restart(View v){  //create the function restart
        gi.setState(Gameinit.state.alive);
        gi.setOri(Gameinit.orientate.right);
        gi.firstStep();
    }

}
