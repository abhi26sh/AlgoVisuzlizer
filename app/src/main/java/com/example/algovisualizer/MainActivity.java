package com.example.algovisualizer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView searching = (CardView)findViewById(R.id.searching_card_view);
        searching.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent searchingIntent= new Intent(MainActivity.this,SearchActivity.class);
                startActivity(searchingIntent);
            }
        });

    }
}