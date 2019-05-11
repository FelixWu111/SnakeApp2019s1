package com.example.u6250082.myapplication;

import java.util.ArrayList;

public class Gameinit {
    public static final int xboard =18;
    public static final int yboard =27;

    ArrayList<Position> outside = new ArrayList<>();

    public Gameinit(){ }

    public void firstStep(){
        buildw();
    }
    //u6250866 and u6250082
    /* 0, 1, 2,.. 17
    *  18, 19,.. 35
    *  36, 37,......
    *  468........ 485*/
    void buildw(){
        for (int i =0;i<xboard;i++){
            if (i==0){
                for(int j=0; j<yboard;j++){ //for left wall
                    outside.add(new Position(j*18));
                }
            }else if (i == xboard-1){
                for(int l=0; l<yboard;l++){//for right wall
                    outside.add(new Position(l*18+17));
                }
            }else {
                outside.add(new Position(i+18)); //THE TOP WALL STARTS FROM INDEX 1!
                outside.add(new Position(468+i));
            }
        }
    }

    //u6250866
    public Board[] getboardState(){
        int index = xboard*yboard;
        Board[] boardState = new Board[index];

        for (int z = 0;z<xboard*yboard;z++){
            boardState[z]= Board.Path;
        }

        for (Position p: outside ){
            boardState[p.geti()]= Board.Edge;//we list all points in the points to edge.
        }
        return boardState;
    }


}
