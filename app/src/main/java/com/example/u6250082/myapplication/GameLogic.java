package com.example.u6250082.myapplication;

import java.util.ArrayList;
import java.util.Random;

public class GameLogic {
    /*u6250082
      Xuguang Song*/

    /* 0, 1, 2,.. 17
     *  18, 19,.. 35
     *  36, 37,......
     *  468........ 485*/
    public static final int xboard =18;
    public static final int yboard =27;

    /*u6250866
     YuWu*/

    // what is the snack's direction
    public enum orientate{
        up,down,left,right
    }

    // what is each position's class
    public enum Board {
        Path,Edge,Head,Body,Bean
    }

    private orientate action = orientate.right; // initial orientation for the snack

    /*u6250082
      XuguangSong*/
    private boolean snackAlive = true; // snack dead or not

    ArrayList<Integer> outside = new ArrayList<>(); // the position array for outside
    ArrayList<Integer> player = new ArrayList<>(); // the position array for the snack

    ArrayList<Integer> bean = new ArrayList<>(); // the position for the bean, I set it to array because may be we want more beans for some extensions
    public GameLogic(){} // just keep the constructer if we need further extensions

    /*u6250082
      XuguangSong*/

    public void builds(){
        player.clear();
        int[] snake = chooseSnakePosition();// set the start position
        for (int i :snake){
        player.add(i);}
    }

    /*u6250082
    Xuguang Song*/

    public void buildw(){
        int[] wall  = chooseWallPosition();
        for (int i = 0;i<80;i++){
            outside.add(wall[i]);
        }
    }

    /*u6250082
     Xuguang Song*/

    public void buildb(){
        bean.add(0,chooseBeanPosition(outside,player));
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
                snackAlive=false;
            }

        if(player.get(0).equals(bean.get(0))){
            player.add(player.get(player.size()-1));
            bean.set(0,chooseBeanPosition(outside,player));
        }

        for(int y =1; y<player.size()-1;y++)
        if(player.get(0).equals(player.get(y))){
            snackAlive=false;
            }

        }
    }

    /*u6250082
      Xuguang Song*/
    public static Integer chooseBeanPosition(ArrayList<Integer> o, ArrayList<Integer> p) {
        Random rand = new Random();
        Integer b = rand.nextInt(396);
        while (o.contains(b)||p.contains(b)||b<36) {
            b=rand.nextInt(396);
        }
        return b;
    }

    /*u6250866
          YuWu*/
    public static int[] chooseSnakePosition() {
        int[] init = {80,79,78,77,76};
        return init;
    }

    /*u6250866
          YuWu*/
    public static int[] chooseWallPosition() {
        int[] wall = new int[81];
        ArrayList<Integer> wall0 = new ArrayList<>();
        for (int i =0;i<xboard;i++){
            if (i==0){
                for(int j=0; j<yboard-3;j++){ //for left wall
                    wall0.add(j*18);
                }
            }else if (i == xboard-1){
                for(int l=0; l<yboard-3;l++){//for right wall
                    wall0.add(l*18+17);
                }
            }else {
                wall0.add(18+i); //THE TOP WALL STARTS FROM INDEX 1!
                wall0.add(414+i);
            }
        }
        for (int i = 0;i<80;i++){
            int a = wall0.get(i);
            wall[i] = a;
        }
        return wall;
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
    public boolean getnowState(){
        return snackAlive;
    } // return the situation of the snack.
    public orientate getnowOri(){
        return action;
    }// return what direction of the snake.
    public void setOri(orientate o ){ action=o; } // change the snake direction.
    public void setState(boolean b) {snackAlive=b;}// change the situation of the snack.

    public static void main(String[] args) {
        int[] init = {80,79,78,77,76};
        int[] a =chooseWallPosition();
        String a0 = "";
        for (int i = 0;i<5;i++){
            a0 += init[i] + ",";
        }
        String test = "80,79,78,77,76,";
        System.out.println(a0.equals(test));
    }
}
