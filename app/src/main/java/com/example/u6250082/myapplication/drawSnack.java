package com.example.u6250082.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;


//u6250082
public class drawSnack extends View {

    Gameinit.Board[] ondraw;

    public drawSnack(Context c, AttributeSet a) {
        super(c, a);
    }

    public void putinWhatToDraw(Gameinit.Board[] b){this.ondraw = b;}


    Paint p = new Paint();
    @Override // Path,Edge,Head,Body,Bean
    protected void onDraw(Canvas c) {
        super.onDraw(c);
        for(int i = 0; i<ondraw.length ;i++){
            if(ondraw[i]==Gameinit.Board.Path){
            p.setColor(Color.WHITE);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}

            if(ondraw[i]==Gameinit.Board.Edge){
                p.setColor(Color.BLUE);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}

            if(ondraw[i]==Gameinit.Board.Head){
                p.setColor(Color.GREEN);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}

            if(ondraw[i]==Gameinit.Board.Body){
                p.setColor(Color.RED);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}

            if(ondraw[i]==Gameinit.Board.Bean){
                p.setColor(Color.YELLOW);
                c.drawRect(new Rect((i%18)*(c.getWidth()/18), ((int)Math.ceil(i/18)-1)*(c.getHeight()/27), (i%18)*(c.getWidth()/18)+c.getWidth()/18, ((int)Math.ceil(i/18)-1)*(c.getHeight()/27)+c.getHeight()/27), p);}
        }

    }
}
