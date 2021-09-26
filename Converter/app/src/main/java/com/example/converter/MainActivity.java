package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.widget.SeekBar;
import android.widget.TextView;

import java.time.temporal.Temporal;

public class MainActivity extends AppCompatActivity {
    SeekBar seekBarC;
    SeekBar seekBarF;
    TextView textViewC;
    TextView textViewTempC;
    TextView textViewF;
    TextView textViewTempF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarC = (SeekBar)findViewById(R.id.seekBarC);
        seekBarF = (SeekBar)findViewById(R.id.seekBarF);

        textViewC = (TextView)findViewById(R.id.textViewC);
        textViewTempC = (TextView)findViewById(R.id.textViewTempC);

        textViewF = (TextView)findViewById(R.id.textViewF);
        textViewTempF = (TextView)findViewById(R.id.textViewTempF);

        seekBarC.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int tempC, boolean b) {
                textViewTempC.setText(String.valueOf(tempC));
                textViewTempF.setText(String.valueOf((Integer.valueOf(String.valueOf(tempC))*1.8 + 32)));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekBarF.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int tempF, boolean b) {
                textViewTempF.setText(String.valueOf(tempF));
                textViewTempC.setText(String.valueOf((Integer.valueOf(String.valueOf(tempF))-32) * .5556));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}