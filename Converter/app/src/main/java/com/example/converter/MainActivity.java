package com.example.converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.Activity;
import android.widget.SeekBar;
import android.widget.TextView;

import java.time.temporal.Temporal;

public class MainActivity extends AppCompatActivity {
    private SeekBar seekBarC;
    private SeekBar seekBarF;
    private TextView textViewC;
    private TextView textViewTempC;
    private TextView textViewF;
    private TextView textViewTempF;
    private int newtempC;
    private int newtempF;

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
                newtempF = (int) (Integer.valueOf(String.valueOf(tempC))*1.8 + 32);
                textViewTempC.setText(String.valueOf(tempC));
                textViewTempF.setText(String.valueOf(newtempF));


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarF.setProgress(newtempF);
            }
        });

        seekBarF.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int tempF, boolean b) {
                newtempC = (int) ((Integer.valueOf(String.valueOf(tempF))-32) * .5556);
                textViewTempF.setText(String.valueOf(tempF));
                //textViewTempC.setText(String.valueOf((Integer.valueOf(String.valueOf(tempF))-32) * .5556));
                textViewTempC.setText(String.valueOf(newtempC));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                seekBarC.setProgress(newtempC);
            }
        });
    }
}