package com.example.hw3p29;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity<Int> extends AppCompatActivity {

    private TextView totalCalories, mealItems, servingSize, bruschetta, salad, pasta, pizza, coke;
    private EditText serving1, serving2, serving3, serving4, serving5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalCalories = (TextView) findViewById(R.id.totalCalories);
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

        serving1.addTextChangedListener(textWatcher);
        serving2.addTextChangedListener(textWatcher);
        serving3.addTextChangedListener(textWatcher);
        serving4.addTextChangedListener(textWatcher);
        serving5.addTextChangedListener(textWatcher);

    }

    private final TextWatcher textWatcher= new TextWatcher() {
        int finalCalories = 0;
        String calories;
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {
            //get the changed serving size amounts for each food item
            // multiply each serving size with the corresponding amount of calories and add it to the total calorie amount
            if (!serving1.getText().toString().isEmpty()) {
                calories = serving1.getText().toString();

            } else{
                calories = "0";
            }
            finalCalories += Integer.parseInt(calories) * 50;

            if (!serving2.getText().toString().isEmpty()) {
                calories = serving2.getText().toString();

            } else{
                calories = "0";
            }
            finalCalories += Integer.parseInt(calories) * 95;

            if (!serving3.getText().toString().isEmpty()) {
                calories = serving3.getText().toString();

            } else{
                calories = "0";
            }
            finalCalories += Integer.parseInt(calories) * 310;

            if (!serving4.getText().toString().isEmpty()) {
                calories = serving4.getText().toString();

            } else{
                calories = "0";
            }
            finalCalories += Integer.parseInt(calories) * 285;

            if (!serving5.getText().toString().isEmpty()) {
                calories = serving5.getText().toString();

            } else{
                calories = "0";
            }
            finalCalories += Integer.parseInt(calories) * 140;

            totalCalories.setText(String.valueOf(finalCalories));

        }
    };


}