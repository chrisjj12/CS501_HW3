package com.example.flashcardapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView loginTitle;
    private TextView loginTitleUser;
    private TextView loginTitlePass;
    private EditText loginUser;
    private EditText loginPass;
    private Button btnLoginSubmit;
    private TextView loginCreds;
    private TextView loginVerification;

    /* these are the usernames and passwords for this app */
    private String USERNAME = "username";
    private String PASSWORD = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginTitle = (TextView) findViewById(R.id.loginTitle);
        loginTitleUser = (TextView) findViewById(R.id.loginTitleUser);
        loginTitlePass = (TextView) findViewById(R.id.loginTitlePass);
        loginUser = (EditText) findViewById(R.id.loginUser);
        loginPass = (EditText) findViewById(R.id.loginPass);
        btnLoginSubmit = (Button) findViewById(R.id.btnLoginSubmit);
        loginCreds = (TextView) findViewById(R.id.loginCreds);
        loginVerification = (TextView) findViewById(R.id.loginVerification);

        /* setting the text values */
        loginTitle.setText("Flashcardz");
        loginTitleUser.setText("Username:");
        loginTitlePass.setText("Password:");
        btnLoginSubmit.setText("LOGIN");
        loginCreds.setText("Username = username, Password = password");

        btnLoginSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* getting user inputted login user and pass */
                final String LOGINUSERNAME = loginUser.getText().toString();
                final String LOGINPASSWORD = loginPass.getText().toString();
                boolean isGood = loginCredsFun(LOGINUSERNAME, LOGINPASSWORD);
                if (isGood) {
                    Intent flashCardsActivity = new Intent(getApplicationContext(), Flashcards.class);
                    startActivity(flashCardsActivity);
                }
            }
        });
    }

    private boolean loginCredsFun(String user, String pass) {
        if ((user.equals(USERNAME)) && (pass.equals(PASSWORD))) {
            loginVerification.setText("Valid credentials.");
            return true;
        } else {
            loginVerification.setText("Invalid credentials.");
            return false;
        }
    }
}