package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.util.concurrent.ThreadLocalRandom;

public class Flashcards extends AppCompatActivity {

    private TextView text_OP1;
    private TextView text_OP2;
    private TextView operator;
    private TextView txtUserinfo;
    private Button btnStartGame;
    private Button btnSubmitAnswer;
    private EditText editTextNumber;

    int op1_min = 10;
    int op1_max = 144;

    int op2_min = 0;
    int op2_max = 12;

    int mult_answer = 0;
    int div_answer = 0;

    int count_mult = 0;
    int count_div = 0;
    int count_correct = 0;

    //Generate random int value from 50 to 100


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashcards);

        text_OP1 = (TextView) findViewById(R.id.text_OP1);
        text_OP2 = (TextView) findViewById(R.id.text_OP2);
        operator = (TextView) findViewById(R.id.operator);
        txtUserinfo = (TextView) findViewById(R.id.txtUserInfo);
        btnStartGame = (Button) findViewById(R.id.btnStartGame);
        btnSubmitAnswer = (Button) findViewById(R.id.btnSubmitAnswer);
        editTextNumber = (EditText) findViewById(R.id.editTextNumber);



        btnStartGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // generate the problem upon click

            }
        });
        btnSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // generate probelm again upon click
                //until counter equals 9
            }
        });






        print in text view count_correct / 10
    }
    private int choose_operator() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        return randomNum;
    }

    private void mult (Integer Answer, int Rand1, int Rand2){
        mult_answer = Rand1 * Rand2;
        if (Answer == mult_answer) {
            txtUserinfo.setText("Correct!");
            count_correct++;
        } else {
            txtUserinfo.setText("Incorrect!");
        }
        count_mult++;
    }

    private void div (Integer Answer, int Rand1, int Rand2) {
        int random1;
        int random2;
        while ((Rand2 != 0) || (Rand1 % Rand2 != 0)) {
            random1 = (int)Math.floor(Math.random()*(op1_max-op1_min+1)+op1_min);
            random2 = (int)Math.floor(Math.random()*(op2_max-op2_min+1)+op2_min);
        }
        if (Rand2 != 0) {
            while ((Rand1 % Rand2 != 0) || Rand2 !=0) {
                if (Answer == mult_answer) {
                    txtUserinfo.setText("Correct!");
                    count_correct++;

                } else {
                    txtUserinfo.setText("Incorrect!");
                }
                count_div++;
            }
        }

    }

    private void game (){
        final Integer USERANSWER = Integer.parseInt(editTextNumber.getText().toString());
        for (int i = 0; i <= 10; i++){
            int random_op1 = (int)Math.floor(Math.random()*(op1_max-op1_min+1)+op1_min);
            int random_op2 = (int)Math.floor(Math.random()*(op2_max-op2_min+1)+op2_min);

            int operChoose = choose_operator();

            if (operChoose == 0) {
                if (count_mult > 5) {
                    div(USERANSWER, random_op1, random_op2);
                }
                else {
                    mult(USERANSWER, random_op1, random_op2);
                }
            }


            else if(operChoose == 1) {
                if (count_div > 5) {
                    mult(USERANSWER, random_op1, random_op2);
                }
                else {
                    div(USERANSWER, random_op1, random_op2);
                }
            }
        }
    }
}

// user generates game -> game generates random op1 and op2 -> user input will check the answer