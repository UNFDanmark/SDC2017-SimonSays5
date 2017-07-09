package com.example.deltager.simonsays5;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.NumberPicker;

/**
 * Created by deltager on 09-07-17.
 */


public class TimeSettings extends Activity {

    NumberPicker np1;
    NumberPicker np2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_settings);

        np1 = (NumberPicker) findViewById(R.id.numberPicker1);
        np1.setMaxValue(999);
        np1.setMinValue(1);
        np1.setValue(60);
        np1.setWrapSelectorWheel(false);

        np2 = (NumberPicker) findViewById(R.id.numberPicker2);
        np2.setMaxValue(999);
        np2.setMinValue(1);
        np2.setValue(60);
        np2.setWrapSelectorWheel(false);



    }
}
