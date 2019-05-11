package com.example.u6250082.myapplication;

import java.util.ArrayList;

public class Gameinit {
    public static final int xboard =18;
    public static final int yboard =27;

    ArrayList<Point> outside = new ArrayList<>();

    public Gameinit(){ }

    public void firstStep(){
        buildw();
    }
    //u6250866
    void buildw(){
        for (int i =0;i<xboard;i++){
            if (i==0){
                for(int j=0; j<yboard;j++){ //for left wall
                    outside.add(new Point(0,j));
                }
            }else if (i == xboard-1){
                for(int l=0; l<yboard;l++){//for right wall
                    outside.add(new Point(xboard-1,l));
                }
            }else {
                outside.add(new Point(i,1)); //THE TOP WALL STARTS FROM INDEX 1!
                outside.add(new Point(i,yboard-1));
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

        for (Point p: outside ){
            boardState[p.getj()*18+p.geti()]= Board.Edge;//we list all points in the points to edge.
        }
        return boardState;
    }


}
