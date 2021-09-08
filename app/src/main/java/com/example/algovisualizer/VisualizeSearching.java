package com.example.algovisualizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.example.algovisualizer.Visualizer.MyCanvas;

public class VisualizeSearching extends AppCompatActivity {

    MyCanvas myCanvas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();

            try {
                int size = Integer.parseInt(intent.getStringExtra("array size"));
            }
            catch (NumberFormatException e)
            {
               e.printStackTrace();
            }

        String algo = intent.getStringExtra("algorithm selected");
        myCanvas = new MyCanvas(this);
         /*   myCanvas.setData(DataUtils.createRandomArray(size));
            myCanvas.start();*/
        myCanvas.setBackgroundColor(Color.RED);
        setContentView(myCanvas);
    }
}