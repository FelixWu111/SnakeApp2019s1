package com.example.u6250082.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

//u6250082
public class drawSnack extends View {
    Paint p = new Paint();
    Board[] ondraw;

    public drawSnack(Context c, @Nullable AttributeSet a) {
        super(c, a);
    }

    public void putinWhatToDraw(Board[] b){this.ondraw = b;}

    @Override // Path,Edge,Head,Body,Bean
    protected void onDraw(Canvas c) {
        super.onDraw(c);

        for(int i = 0; i<ondraw.length ;i++){
            if(ondraw[i]==Board.Path){
            Paint p = new Paint();
            p.setColor(Color.WHITE);
            c.drawRect(new Rect((i%18)*(c.getWidth()/36)+c.getWidth()/36, (27-i%27)*(c.getHeight()/27)+c.getHeight()/54, c.getWidth()/18, c.getHeight()/27), p);}

            if(ondraw[i]==Board.Edge){
                Paint p = new Paint();
                p.setColor(Color.BLACK);
                c.drawRect(new Rect((i%18)*(c.getWidth()/36)+c.getWidth()/36, (27-i%27)*(c.getHeight()/27)+c.getHeight()/54, c.getWidth()/18, c.getHeight()/27), p);}

            if(ondraw[i]==Board.Head){
                Paint p = new Paint();
                p.setColor(Color.GREEN);
                c.drawRect(new Rect((i%18)*(c.getWidth()/36)+c.getWidth()/36, (27-i%27)*(c.getHeight()/27)+c.getHeight()/54, c.getWidth()/18, c.getHeight()/27), p);}

            if(ondraw[i]==Board.Body){
                Paint p = new Paint();
                p.setColor(Color.BLUE);
                c.drawRect(new Rect((i%18)*(c.getWidth()/36)+c.getWidth()/36, (27-i%27)*(c.getHeight()/27)+c.getHeight()/54, c.getWidth()/18, c.getHeight()/27), p);}

            if(ondraw[i]==Board.Bean){
                Paint p = new Paint();
                p.setColor(Color.YELLOW);
                c.drawRect(new Rect((i%18)*(c.getWidth()/36)+c.getWidth()/36, (27-i%27)*(c.getHeight()/27)+c.getHeight()/54, c.getWidth()/18, c.getHeight()/27), p);}



        }

    }
}
