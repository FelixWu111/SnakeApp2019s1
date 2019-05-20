package com.example.u6250082.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    GameLogic gi;
    drawSnake ds;

    /*u6250866
      YuWu*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gi = new GameLogic();
        gi.builds();
        gi.buildw(); //initialize the game's basic builds i.e. walls and the snack
        gi.buildb(); //add in the random bean
        ds = (drawSnake)findViewById(R.id.drawSnack);
        ds.putinWhatToDraw(gi.getboardState());
        ds.invalidate();//draw the current state

        refreshHandler();//delay and refresh the game situation
    }

    /*u6250866
      YuWu*/
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
        gi.builds();
        gi.buildw(); //add all the features
    }

    /*u6250866
      YuWu*/
    static long difficulty=180; //normal 180, hard 80, easy 280
    final Handler h =new Handler();

    private void refreshHandler(){//The idea of delay 180ms in our MainActivity refreshHander
                                  // "postDelayed(new Runnable())" is from Marcell Elek (2016)'s youtube video: https://www.youtube.com/watch?v=s9MZwZ--6G4
                                  //  because we countered a bug that if you don't delay, the snack will teleport.
       Runnable eachFrame = new Runnable() { // determine what will happen in next frame
            @Override
            public void run() {
                /*u6250866
                  YuWu*/
                gi.refreshState();
                if (gi.getnowState()== GameLogic.state.alive){h.postDelayed(this,difficulty);} //keep refreshing frames
                if (gi.getnowState()== GameLogic.state.dead){ // reset the frame to initial state
                    gi.setState(GameLogic.state.alive);
                    gi.setOri(GameLogic.orientate.right);
                    gi.builds();
                    gi.buildw(); //the bean will update itself, no need to add in refresh handler

                    ds = (drawSnake)findViewById(R.id.drawSnack);
                    ds.putinWhatToDraw(gi.getboardState());
                    ds.invalidate();
                    refreshHandler();
                }

                ds.putinWhatToDraw(gi.getboardState());
                ds.invalidate();

            }
       };

        h.postDelayed(eachFrame,difficulty);
    }

//Qingzheng Xu
//u6174243
    public void menu(View v) { //Button menu
        Intent i = new Intent(MainActivity.this, StartActivity.class);
        startActivity(i);
    }

 /*u6250082
   Xuguang Song*/
   public static void hard() { //hard
     difficulty=80;
    }

   public static void normal() { //normal
     difficulty=180;
    }

   public static void easy() { //easy
      difficulty=280;
    }
}
