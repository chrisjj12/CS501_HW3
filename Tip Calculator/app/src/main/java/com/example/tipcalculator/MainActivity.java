package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    private double calculateBillAmount = 0.0;
    private double percent = 0.15;
    private TextView viewBillAmount, tipPercentage, idTip, idTotal, tipAmount, totalAmount;
    private SeekBar selectTip;
    private EditText billAmount;

    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percentFormat = NumberFormat.getPercentInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewBillAmount = (TextView) findViewById(R.id.viewBillAmount);
        tipPercentage = (TextView) findViewById(R.id.tipPercentage);
        idTip = (TextView) findViewById(R.id.idTip);
        idTotal = (TextView) findViewById(R.id.idTotal);
        tipAmount = (TextView) findViewById(R.id.tipAmount);
        totalAmount = (TextView) findViewById(R.id.totalAmount);

        tipAmount.setText(currencyFormat.format(0));
        totalAmount.setText(currencyFormat.format(0));

        billAmount = (EditText) findViewById(R.id.billAmount);
        billAmount.addTextChangedListener(billAmountTextWatcher);


        selectTip = (SeekBar) findViewById(R.id.selectTip);
        selectTip.setOnSeekBarChangeListener(selectTipSeekBarListener);
    }


    private void calculate(){

        tipPercentage.setText(percentFormat.format(percent));

        // calculate the tip and total
        double tip = calculateBillAmount * percent;
        double total = calculateBillAmount + tip;

        // display the tip and total that is formatted as currency
        tipAmount.setText(currencyFormat.format(tip));
        totalAmount.setText(currencyFormat.format(total));

    }

    private final OnSeekBarChangeListener selectTipSeekBarListener = new OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
            percent = i / 100.0;
            calculate();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {}

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {}
    };


    private final TextWatcher billAmountTextWatcher= new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            try {
                calculateBillAmount = Double.parseDouble(charSequence.toString()) / 100.0;
                viewBillAmount.setText(currencyFormat.format(calculateBillAmount));
            } catch (NumberFormatException e) {
                viewBillAmount.setText("");
                calculateBillAmount = 0.0;
            }

            calculate();
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    };

}