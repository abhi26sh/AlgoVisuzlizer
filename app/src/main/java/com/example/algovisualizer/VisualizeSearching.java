package com.example.algovisualizer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.algovisualizer.Visualizer.MyCanvas;

public class VisualizeSearching extends AppCompatActivity {

    MyCanvas myCanvas;
    LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualize_searching);
        linearLayout=findViewById(R.id.linear_layout);
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
        linearLayout.addView(myCanvas);

    }
}