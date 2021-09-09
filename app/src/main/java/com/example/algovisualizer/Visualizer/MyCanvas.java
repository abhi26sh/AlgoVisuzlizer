package com.example.algovisualizer.Visualizer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Region;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/*
public class MyCanvas extends View {

    Paint paint,highlightPaint,highlightPaintTrace,textPaint;

    int[] array;
    int highlightPosition =-1;
    List<Integer> highlightPositions = new ArrayList<>();
    int highlightPositionTrace = -1;
    int lineStrokeWidth = 10;


    public MyCanvas(Context context) {
        super(context);
       initialize();
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
    */
/*drawLine(float startX, float startY, float stopX, float stopY, Paint paint)
      Draw a line segment with the specified start and stop x,y coordinates, using the specified paint.*//*

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(array!=null)
        {
            int totalLines= array.length;
            float margin = (getWidth() - (20 * totalLines))/(totalLines+1);
            float xPos = margin + 20;
            for (int value : array) {
                */
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
                }*//*

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
*/






public class MyCanvas extends View {

    Paint mPaint, otherPaint, outerPaint, mTextPaint;
    RectF mRectF;
    int mPadding;

    float arcLeft, arcTop, arcRight, arcBottom;

    Path mPath;


    public MyCanvas(Context context) {
        super(context);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(5);


        mTextPaint = new Paint(Paint.LINEAR_TEXT_FLAG | Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(Color.BLACK);
        mTextPaint.setTextSize(pxFromDp(context, 24));

        otherPaint = new Paint();

        outerPaint = new Paint();
        outerPaint.setStyle(Paint.Style.FILL);
        outerPaint.setColor(Color.YELLOW);

        mPadding = 100;


        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);


        int screenWidth = displayMetrics.widthPixels;
        int screenHeight = displayMetrics.heightPixels;

        arcLeft = pxFromDp(context, 20);
        arcTop = pxFromDp(context, 20);
        arcRight = pxFromDp(context, 100);
        arcBottom = pxFromDp(context, 100);


        Point p1 = new Point((int) pxFromDp(context, 80) + (screenWidth / 2), (int) pxFromDp(context, 40));
        Point p2 = new Point((int) pxFromDp(context, 40) + (screenWidth / 2), (int) pxFromDp(context, 80));
        Point p3 = new Point((int) pxFromDp(context, 120) + (screenWidth / 2), (int) pxFromDp(context, 80));

        mPath = new Path();
        mPath.moveTo(p1.x, p1.y);
        mPath.lineTo(p2.x, p2.y);
        mPath.lineTo(p3.x, p3.y);
        mPath.close();

        mRectF = new RectF(screenWidth / 4, screenHeight / 3, screenWidth / 6, screenHeight / 2);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRoundRect(mRectF, 10, 10, otherPaint);
        canvas.clipRect(mRectF, Region.Op.DIFFERENCE);
        canvas.drawPaint(outerPaint);

        canvas.drawLine(250, 250, 400, 400, mPaint);
        canvas.drawRect(mPadding, mPadding, getWidth() - mPadding, getHeight() - mPadding, mPaint);
        canvas.drawArc(arcLeft, arcTop, arcRight, arcBottom, 75, 45, true, mPaint);


        otherPaint.setColor(Color.GREEN);
        otherPaint.setStyle(Paint.Style.FILL);

        canvas.drawRect(
                getLeft() + (getRight() - getLeft()) / 3,
                getTop() + (getBottom() - getTop()) / 3,
                getRight() - (getRight() - getLeft()) / 3,
                getBottom() - (getBottom() - getTop()) / 3, otherPaint);




        canvas.drawPath(mPath, mPaint);
        otherPaint.setColor(Color.BLACK);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, arcLeft, otherPaint);

        canvas.drawText("Canvas basics", (float) (getWidth() * 0.3), (float) (getHeight() * 0.8), mTextPaint);

    }


    public static float pxFromDp(final Context context, final float dp) {
        return dp * context.getResources().getDisplayMetrics().density;
    }

}