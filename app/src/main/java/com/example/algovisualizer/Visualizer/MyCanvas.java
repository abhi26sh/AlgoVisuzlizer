package com.example.algovisualizer.Visualizer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MyCanvas extends View {

    Paint paint;
    Paint highlightPaint;
    Paint highlightPaintTrace;
    Paint textPaint;

    int[] array;
    int highlightPosition =-1;
    List<Integer> highlightPositions = new ArrayList<>();
    int highlightPositionTrace = -1;
    int lineStrokeWidth = 10;


    public MyCanvas(Context context) {
        super(context);
//        initialize();
    }

    //Created a Paint object to use methods inside Paint class
    // initialised the paint object and given the properties
    private void initialize() {
        paint = new Paint();
        paint.setColor(Color.parseColor("#3f000f"));
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(30);

        highlightPaint = new Paint();
        highlightPaint.setColor(Color.MAGENTA);
        highlightPaint.setStyle(Paint.Style.FILL);
        highlightPaint.setStrokeWidth(20);

        textPaint = new TextPaint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(12);
    }

    @Override
    //OnDraw method is overrided from canvas class here will can drwaw any shape using this
    // we will draw lines equals to length of array given by the user
    // for each array element fill the line and give the margin for better gui
    /*drawLine(float startX, float startY, float stopX, float stopY, Paint paint)
      Draw a line segment with the specified start and stop x,y coordinates, using the specified paint.*/
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(array!=null)
        {
            int totalLines= array.length;
            float margin = (getWidth() - (20 * totalLines))/(totalLines+1);
            float xPos = margin + 20;
            for (int value : array) {
                /*if (highlightPositions.contains(i)) {
                    if (highlightPositionTrace != -1 && highlightPositionTrace == i) {
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), highlightPaintTrace);
                    } else
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), highlightPaint);
                } else {
                    if (highlightPositionTrace != -1 && highlightPositionTrace == i) {
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), highlightPaintTrace);
                    } else
                        canvas.drawLine(xPos, getHeight() - (float) ((array[i] / 110.0) * getHeight()), xPos, getHeight(), paint);
                }*/
                canvas.drawLine(xPos, getHeight() - (float) ((value / 110.0) * getHeight()), xPos, getHeight(), paint);
                //canvas.drawText(String.valueOf(array[i]), xPos - lineStrokeWidth / 1.7f, getHeight() - (float) ((array[i] / 110.0) * getHeight()) - 30, textPaint);
                xPos += margin + 20;
            }
            highlightPositions.clear();
            highlightPositionTrace = -1;
        }

    }

    public void setData(int[] integers)
    {
        this.array = integers;
    }

    public void start()
    {
        invalidate();
    }


    public void highlight(int position) {
        this.highlightPositionTrace = position;
        invalidate();
    }
    public void highlight(List<Integer> positions) {
        this.highlightPositions.clear();
        this.highlightPositions.addAll(positions);
        invalidate();
    }

}
