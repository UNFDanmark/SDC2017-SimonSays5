package com.example.deltager.simonsays5;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.NumberPicker;

/**
 * Created by deltager on 09-07-17.
 */


public class TimeSettings extends Activity {

    NumberPicker np;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_settings);

        np = (NumberPicker) findViewById(R.id.numberPicker1);
        np.setMaxValue(999);
        np.setMinValue(1);
        np.setValue(60);
    }
}
