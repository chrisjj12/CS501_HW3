package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText billAmount;
    private TextView tipPercentage, idTip, idTotal, tipAmount, totalAmount;
    private SeekBar selectTip;

    // make dollar signs appear and make sure # of decimals is 2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        billAmount = (EditText) findViewById(R.id.billAmount);

        tipPercentage = (TextView) findViewById(R.id.tipPercentage);
        idTip = (TextView) findViewById(R.id.idTip);
        idTotal = (TextView) findViewById(R.id.idTotal);
        tipAmount = (TextView) findViewById(R.id.tipAmount);
        totalAmount = (TextView) findViewById(R.id.totalAmount);

        selectTip = (SeekBar) findViewById(R.id.selectTip);

        //String dollar = getResources().getString(R.string.dollar);

        selectTip.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int percent = i;
                tipPercentage.setText(String.valueOf(percent));
                calculate();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        billAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                calculate();
            }
        });
    }

    private void calculate(){
        if (billAmount.length() == 0){
            billAmount.setError("Enter Amount");
        } else{
            double amount = Double.parseDouble(billAmount.getText().toString());
            int percent = selectTip.getProgress();
            double tip = amount * percent / 100;
            double total = amount + tip;
            tipAmount.setText(String.valueOf(tip));
            totalAmount.setText(String.valueOf(total));
        }
    }


}