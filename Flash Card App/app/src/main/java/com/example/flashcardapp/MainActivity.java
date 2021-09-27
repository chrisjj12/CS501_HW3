package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int op1_min = 10;
        int op1_max = 144;

        int op2_min = 0;
        int op2_max = 12;

        int mult_answer = 0;
        int div_answer = 0;

        count_mult = 0;
        count_div = 0;
        count_correct = 0;

        //Generate random int value from 50 to 100
        int random_op1 = (int)Math.floor(Math.random()*(op1_max-op1_min+1)+op1_min);
        int random_op2 = (int)Math.floor(Math.random()*(op2_max-op2_min+1)+op2_min);

        for (int i = 0; i <= 10; i++){
            if (operation == multiplication){
                while (count_mult < 6){
                    mult_answer = random_op1 * random_op2;
                    if (user_answer == mult_answer) {
                        print in text view
                        count_correct++;
                    }
                }
            }
            else if(operation == division){
                while (count_div < 6){
                    if (random_op2 != 0){
                        if (random_op1 % random_op2 == 0) {
                            if (user_answer == mult_answer) {
                                count_correct++;
                                print in text view
                            }
                        }
                    }
                }
            }
        }

        print in text view count_correct / 10
    }
}