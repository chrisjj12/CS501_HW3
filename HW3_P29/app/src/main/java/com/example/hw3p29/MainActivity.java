package com.example.hw3p29;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity<Int> extends AppCompatActivity {

    private TextView totalCalories, mealItems, servingSize, bruschetta, salad, pasta, pizza, coke;
    private EditText serving1, serving2, serving3, serving4, serving5;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalCalories = (TextView) findViewById(R.id.totalCalories);
        calculateButton = (Button) findViewById(R.id.calculateButton);
//        mealItems = (TextView) findViewById(R.id.mealItems);
//        servingSize = (TextView) findViewById(R.id.servingSize);
//        bruschetta = (TextView) findViewById(R.id.bruschetta);
//        salad = (TextView) findViewById(R.id.salad);
//        pasta = (TextView) findViewById(R.id.pasta);
//        pizza = (TextView) findViewById(R.id.pizza);
//        coke = (TextView) findViewById(R.id.coke);

        serving1 = (EditText) findViewById(R.id.serving1);
        serving2 = (EditText) findViewById(R.id.serving2);
        serving3 = (EditText) findViewById(R.id.serving3);
        serving4 = (EditText) findViewById(R.id.serving4);
        serving5 = (EditText) findViewById(R.id.serving5);


        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int food1, food2, food3, food4, food5;

                if (serving1.getText().toString().equals("")){
                    food1 = 0;
                } else{
                    food1 = Integer.parseInt(serving1.getText().toString());
                }

                if (serving2.getText().toString().equals("")){
                    food2  = 0;
                } else{
                    food2 = Integer.parseInt(serving2.getText().toString());
                }

                if (serving3.getText().toString().equals("")){
                    food3  = 0;
                } else{
                    food3 = Integer.parseInt(serving3.getText().toString());
                }

                if (serving4.getText().toString().equals("")){
                    food4 = 0;
                } else{
                    food4 = Integer.parseInt(serving4.getText().toString());
                }

                if (serving5.getText().toString().equals("")){
                    food5 = 0;
                } else{
                    food5 = Integer.parseInt(serving5.getText().toString());
                }

                calculate(food1, food2, food3, food4, food5);

            }
        });

    }

    private void calculate(int f1, int f2, int f3, int f4, int f5){
        int finalCalories = (f1 * 50) + (f2 * 95) + (f3 * 310) + (f4 * 285) + (f5 * 140);
        totalCalories.setText(String.valueOf(finalCalories));

    }


}