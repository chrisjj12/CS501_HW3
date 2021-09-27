package com.example.hw3p23;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private TextView light;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        light = (TextView) findViewById(R.id.light);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (counter == 0){
                    light.setBackgroundColor(getResources().getColor(R.color.green));
                    //light.setText("Green!");
                    counter++;
                } else if (counter == 1){
                    light.setBackgroundColor(getResources().getColor(R.color.yellow));
                    //light.setText("Yellow!");
                    counter++;
                } else if (counter == 2){
                    light.setBackgroundColor(getResources().getColor(R.color.red));
                    //light.setText("Red!");
                    counter = 0;
                }

            }
        });

    }
}