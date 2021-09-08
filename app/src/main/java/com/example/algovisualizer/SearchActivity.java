package com.example.algovisualizer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class SearchActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String algoSelectedfromSpinner;
    SeekBar seekBar;
    TextView textViewForArraySize;
    Spinner spinner;
    Button visualizeButton;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        seekBar=findViewById(R.id.seekbar);
        textViewForArraySize=findViewById(R.id.Array_size);
        visualizeButton=findViewById(R.id.visualize_button);

        //setting up button click listener
        visualizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(algoSelectedfromSpinner==null)
                {
                   Toast.makeText(v.getContext(),"Please select an algorithm",Toast.LENGTH_SHORT).show();
                }
                else if(algoSelectedfromSpinner.equals("Select an algorithm:"))
                {
                    Toast.makeText(v.getContext(),"Please select an algorithm",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent intent=new Intent(v.getContext(),VisualizeSearching.class);
                    intent.putExtra("array size",textViewForArraySize.toString());
                    intent.putExtra("algorithm selected",algoSelectedfromSpinner);
                    startActivity(intent);
                }

            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Spinner_items, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewForArraySize.setText(progress+"/"+"20");
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    @Override
    protected void onResume() {
        algoSelectedfromSpinner=null;
        super.onResume();
    }

    @Override
    protected void onRestart() {
        algoSelectedfromSpinner=null;
        super.onRestart();
    }

    @Override
    protected void onPause() {
        seekBar.setProgress(0);
        super.onPause();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getItemAtPosition(position).toString().equals("Select an algorithm:"))
        {
            Toast.makeText(this,"Please select an algorithm",Toast.LENGTH_SHORT).show();
        }
        else if(parent.getItemAtPosition(position).toString().equals("LINEAR SEARCH"))
        {
            Toast.makeText(this,"Linear search selected",Toast.LENGTH_SHORT).show();
            algoSelectedfromSpinner = parent.getItemAtPosition(position).toString();
        }
        else
        {
            Toast.makeText(this,"Binary search selected",Toast.LENGTH_SHORT).show();
            algoSelectedfromSpinner = parent.getItemAtPosition(position).toString();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
