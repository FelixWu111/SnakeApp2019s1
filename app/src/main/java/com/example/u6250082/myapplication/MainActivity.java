package com.example.u6250082.myapplication;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    GameLogic gi;
    drawSnack ds;
    final Handler h =new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gi = new GameLogic();
        gi.firstStep();
        gi.buildb();

        ds = (drawSnack)findViewById(R.id.drawSnack);

        ds.putinWhatToDraw(gi.getboardState());
        ds.invalidate();
        refreshHandler();
    }
    private void refreshHandler(){//The idea of delay 80ms in our MainActivity refreshHander
                                  // "postDelayed(new Runnable())" is from Marcell Elek (2016)'s youtube video: https://www.youtube.com/watch?v=s9MZwZ--6G4
                                  //  because we countered a bug that if you don't delay, the snack will teleport.
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                gi.refreshState();
                if (gi.getnowState()== GameLogic.state.alive){
                    h.postDelayed(this,180);//set the time of game delay
                }
                if (gi.getnowState()== GameLogic.state.dead){
                    gi.setState(GameLogic.state.alive);
                    gi.setOri(GameLogic.orientate.right);
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


    //u6250866 YuWu
    public void left(View v){  //create the function left
        if (gi.getnowOri()!= GameLogic.orientate.right) {
            gi.setOri(GameLogic.orientate.left);
        }
    }
    public void right(View v){  //create the function right
        if (gi.getnowOri()!= GameLogic.orientate.left) {
            gi.setOri(GameLogic.orientate.right);
        }
    }
    public void down(View v){  //create the function down
        if (gi.getnowOri()!= GameLogic.orientate.up) {
            gi.setOri(GameLogic.orientate.down);
        }
    }
    public void up(View v){  //create the function up
        if (gi.getnowOri()!= GameLogic.orientate.down) {
            gi.setOri(GameLogic.orientate.up);
        }
    }
    public void restart(View v){  //create the function restart
        gi.setState(GameLogic.state.alive);
        gi.setOri(GameLogic.orientate.right);
        gi.firstStep();
    }

}
