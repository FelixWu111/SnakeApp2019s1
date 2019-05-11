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

    Board[] ondraw;

    public drawSnack(Context c, @Nullable AttributeSet a) {
        super(c, a);
    }

    public void putinWhatToDraw(Board[] b){this.ondraw = b;}


    Paint p = new Paint();
    @Override // Path,Edge,Head,Body,Bean
    protected void onDraw(Canvas c) {
        super.onDraw(c);

        for(int i = 0; i<ondraw.length ;i++){
            if(ondraw[i]==Board.Path){
            p.setColor(Color.WHITE);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}

            if(ondraw[i]==Board.Edge){
                p.setColor(Color.BLUE);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}

            if(ondraw[i]==Board.Head){
                p.setColor(Color.GREEN);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}

            if(ondraw[i]==Board.Body){
                p.setColor(Color.RED);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}

            if(ondraw[i]==Board.Bean){
                p.setColor(Color.YELLOW);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}



        }

    }
}
