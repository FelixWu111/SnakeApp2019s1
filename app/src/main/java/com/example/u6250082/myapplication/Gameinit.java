package com.example.u6250082.myapplication;

import java.util.ArrayList;

public class Gameinit {
    public static final int xboard =18;
    public static final int yboard =27;

    ArrayList<Point> points = new ArrayList<>();

    public Gameinit(){ }

    public void firstStep(){
        buildw();
    }

    void buildw(){
        for (int i =0;i<xboard;i++){
            if (i==0){
                for(int j=0; j<yboard;j++){ //for left wall
                    points.add(new Point(0,j));
                }
            }else if (i == xboard-1){
                for(int l=0; l<yboard;l++){//for right wall
                    points.add(new Point(0,l));
                }
            }else {
                points.add(new Point(i,0));
                points.add(new Point(i,yboard-1));
            }
        }
    }

    public Board[] getboardState(){
        int index = xboard*yboard;
        Board[] boardState = new Board[index];
        for (Point p: points ){
            boardState[p.getj()*18+p.geti()+1]= Board.Edge;//we list all points in the points to edge.
        }
        return boardState;
    }


}
