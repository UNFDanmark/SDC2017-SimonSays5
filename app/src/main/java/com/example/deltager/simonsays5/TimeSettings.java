package com.example.deltager.simonsays5;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.ToggleButton;

/**
 * Created by deltager on 09-07-17.
 */


public class TimeSettings extends Activity {

    private NumberPicker np1;
    private NumberPicker np2;

    private ToggleButton p1Toggle;
    private ToggleButton p2Toggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_settings);

        p1Toggle = (ToggleButton) findViewById(R.id.ready1Btn);
        p2Toggle = (ToggleButton) findViewById(R.id.ready2Btn);

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

    @Override
    protected void onRestart() {
        super.onRestart();
        restartActivity();
    }


    public void ready1OnClick(View view) {

        checkStartGame();
    }

    public void ready2OnClick(View view) {
        checkStartGame();
    }

    private void checkStartGame() {
        if (p1Toggle.isChecked() && p2Toggle.isChecked()) {
            Intent intent = new Intent(this, TwoPlayerActivity.class);
            intent.putExtra("player1Timer", np1.getValue());
            intent.putExtra("player2Timer", np2.getValue());
            startActivity(intent);
        }
    }

    private void restartActivity() {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}
