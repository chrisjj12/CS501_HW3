package com.example.flashcardapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

public class Flashcards extends AppCompatActivity {

    private TextView text_OP1;
    private TextView text_OP2;
    private TextView operator;
    private TextView txtUserinfo;
    private Button btnStartGame;
    private Button btnSubmitAnswer;
    private EditText editTextNumber;

    final int op1_min = 10;
    final int op1_max = 144;

    final int op2_min = 0;
    final int op2_max = 12;

    int countMul = 0; //counter of multiplication problems
    int countDiv = 0; //counter of division problems
    int countCorrect = 0; //counter of correct questions
    int buttonclicked = 0;

    int result = 0;

    //Generate random int value from 50 to 100

    /*
    * Logic:
    * onCreate early binds
    * no numbers yet
    * btnStartGame starts a game -> generates legit operand numbers and operator
    * user enters editTextNumber
    * pressing btnSubmitAnswer checks if the problem answer == editTextNumber
    * && moves onto next problem up until 10 problems
    * must check if mult < 6 and div < 6
    */

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
                buttonclicked = 0;
                countMul = 0;
                countDiv = 0;
                countCorrect = 0;
                game();
            }
        });
        btnSubmitAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // generate problem again upon click
                //until counter equals 9
                Integer USERANSWER = Integer.parseInt(editTextNumber.getText().toString());
                if (buttonclicked < 9) {
                    answerChecker(USERANSWER);
                    game();
                }
//                else if (buttonclicked > 0 && buttonclicked < 9){
//                    Integer USERANSWER = Integer.parseInt(editTextNumber.getText().toString());
//                    answerChecker(USERANSWER);
//                    game();
//                    Toast.makeText(getApplicationContext(), "You got " + Integer.toString(countCorrect) + " out of 10 correct.", Toast.LENGTH_LONG).show();
//                }
                else if (buttonclicked == 9){
                    answerChecker(USERANSWER);
                    Toast.makeText(getApplicationContext(), "You got " + Integer.toString(countCorrect) + " out of 10 correct.", Toast.LENGTH_LONG).show();
                }
                buttonclicked++;
                editTextNumber.setText("");
            }
        });
    }

    /* choosing operator: 0 is multiplication; 1 is division */
    private int choose_operator() {
        int randomNum = ThreadLocalRandom.current().nextInt(0, 2);
        return randomNum;
    }

    /* displays operators for multiplication question */
    private void mult() {
        int random1 = (int)Math.floor(Math.random()*(op1_max-op1_min+1)+op1_min);
        int random2 = (int)Math.floor(Math.random()*(op2_max-op2_min+1)+op2_min);

        text_OP1.setText(String.valueOf(random1));
        text_OP2.setText(String.valueOf(random2));
        operator.setText("×");

        result = random1 * random2;
    }

    /* displays operators for division question */
    private void div() {
        int random1;
        int random2;

        // error checking for divisible question with int answer AND no divide by zero
        do {
            random1 = (int)Math.floor(Math.random()*(op1_max-op1_min+1)+op1_min);
            random2 = (int)Math.floor(Math.random()*(op2_max-op2_min+1)+op2_min);
        } while ((random1 % random2 != 0) || (random2 == 0));

        text_OP1.setText(String.valueOf(random1));
        text_OP2.setText(String.valueOf(random2));
        operator.setText("÷");

        result = random1 / random2;
    }

    private void game(){

        int operChoose = choose_operator();

        if ((operChoose == 0) && (countMul < 5)) { //case where we get multiplication and it's not full
            mult();
            countMul++;
        } else if ((operChoose == 0) && (countMul == 5)) { //case where we get multiplication but it's full
            div();
            countDiv++;
        } else if ((operChoose == 1) && (countDiv < 5)) { //case where we get division and it's not full
            div();
            countDiv++;
        } else if ((operChoose == 1) && (countDiv == 5)) { //case where get division and it's full
            mult();
            countMul++;
        }
    }

    private void answerChecker(Integer USERANSWER) {
        if (USERANSWER == result) {
            countCorrect++;
            txtUserinfo.setText("Good job! Onto the next.");
        } else if (USERANSWER != result) {
            txtUserinfo.setText("Incorrect!");
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("Op1", text_OP1.getText().toString());
        outState.putString("Op2", text_OP2.getText().toString());
        outState.putString("Operator", operator.getText().toString());
        outState.putString("userinput", editTextNumber.getText().toString());

        outState.putInt("countMul", countMul);
        outState.putInt("countDiv", countDiv);
        outState.putInt("countCorrect", countCorrect);
        outState.putInt("buttonClicked", buttonclicked);
        outState.putInt("result", result);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String Saved_op1;
        Saved_op1 = savedInstanceState.getString("Op1");
        text_OP1.setText(Saved_op1);

        String Saved_op2;
        Saved_op2 = savedInstanceState.getString("Op2");
        text_OP2.setText(Saved_op2);

        String Saved_operator;
        Saved_operator = savedInstanceState.getString("Operator");
        operator.setText(Saved_operator);

        String Saved_userinput;
        Saved_userinput = savedInstanceState.getString("userinput");
        editTextNumber.setText(Saved_userinput);

        int Saved_countmul;
        Saved_countmul = savedInstanceState.getInt("countMul");
        countMul = Saved_countmul;

        int Saved_countdiv;
        Saved_countdiv = savedInstanceState.getInt("countDiv");
        countDiv = Saved_countdiv;

        int Saved_countcorrect;
        Saved_countcorrect = savedInstanceState.getInt("countCorrect");
        countCorrect = Saved_countcorrect;

        int Saved_buttonclicked;
        Saved_buttonclicked = savedInstanceState.getInt("buttonClicked");
        buttonclicked = Saved_buttonclicked;

        int Saved_result;
        Saved_result = savedInstanceState.getInt("result");
        result = Saved_result;
    }
}

// user generates game -> game generates random op1 and op2 -> user input will check the answer