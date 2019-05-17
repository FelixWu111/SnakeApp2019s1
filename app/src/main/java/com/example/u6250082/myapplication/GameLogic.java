package com.example.u6250082.myapplication;

import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    public static final int xboard =18;
    public static final int yboard =27;

    /*u6250866
     YuWu*/
    public enum orientate{
        up,down,left,right
    }
    public enum Board {
        Path,Edge,Head,Body,Bean
    }
    public enum state{
        alive,dead,start
    }

    ArrayList<Integer> outside = new ArrayList<>();
    ArrayList<Integer> player = new ArrayList<>();
    ArrayList<Integer> bean = new ArrayList<>();

    private orientate action = orientate.right;
    private state situation = state.alive;

    public GameLogic(){} // just keep the constructer if we need further extensions

    public void firstStep(){
        builds();
        buildw();
    }
    /*u6250866 YuWu and
      u6250082 XuguangSong*/
    /* 0, 1, 2,.. 17
    *  18, 19,.. 35
    *  36, 37,......
    *  468........ 485*/

    public void builds(){
        player.clear();
        int[] init = {80,79,78,77,76};// set the start position
        for (int i :init){
        player.add(i);}
    }
    /*u6250082
    Xuguang Song*/
    public void buildw(){
        for (int i =0;i<xboard;i++){
            if (i==0){
                for(int j=0; j<yboard-3;j++){ //for left wall
                    outside.add(j*18);
                }
            }else if (i == xboard-1){
                for(int l=0; l<yboard-3;l++){//for right wall
                    outside.add(l*18+17);
                }
            }else {
                outside.add(i+18); //THE TOP WALL STARTS FROM INDEX 1!
                outside.add(414+i);
            }
        }
    }
    /*u6250082
     Xuguang Song*/
    public void buildb(){
        Random rand = new Random();
        Integer b = rand.nextInt(396);
        while (outside.contains(b)||player.contains(b)||b<36) {
            b=rand.nextInt(396);
        }
        bean.add(0,b);
    }

    /*u6250866
      YuWu*/
    public Board[] getboardState(){
        int index = xboard*yboard;
        Board[] boardState = new Board[index];

        for (int z = 0;z<xboard*yboard;z++){
            boardState[z]= Board.Path; //build all the path.
        }

        for (Integer p: outside ){
            boardState[p]= Board.Edge;//we list all points in the points to edge.
        }

        for (Integer s:player){
            boardState[s] = Board.Body;// build the snake's body.
        }

        for (Integer b:bean){
            boardState[b] = Board.Bean;// build the bean.
        }

        boardState[player.get(0)] = Board.Head;
        return boardState;
    }

    /*u6250082
      Xuguang Song*/
    public void refreshState(){
        if (action==orientate.up){
            refreshPlayer(-18);
        }else if (action==orientate.down){
            refreshPlayer(18);
        }else if (action==orientate.right){
            refreshPlayer(1);
        }else if (action==orientate.left){
            refreshPlayer(-1);
        }

        for(Integer p:outside){
            if (player.get(0).equals(p)){
                situation=state.dead;
            }

        if(player.get(0).equals(bean.get(0))){
            player.add(player.get(player.size()-1));
            Random rand = new Random();
            Integer b = rand.nextInt(396);
            while (outside.contains(b)||player.contains(b)||b<36) {
                b=rand.nextInt(396);
            }
            bean.set(0,b);
        }

        for(int y =1; y<player.size()-1;y++)
        if(player.get(0).equals(player.get(y))){
            situation=state.dead;
            }

        }
    }

    /*u6250866
      YuWu*/
    public void refreshPlayer(int change){
        for(int n=player.size()-1;n>=0;n--){
            if (n==0){
                player.set(0,(player.get(0)+change)); //refresh the head of snake
            }else {
              player.set(n,player.get(n-1)); // refresh the body of snake
            }
        }
    }

    /*u6250866
      YuWu*/
    public state getnowState(){
        return situation;
    } // return the situation of game.
    public orientate getnowOri(){
        return action;
    }// return what direction of the snake.
    public void setOri(orientate o ){ action=o; } // change the snake direction.
    public void setState(state s) {situation=s;}// change the situation of game.
}
