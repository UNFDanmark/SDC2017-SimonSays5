package com.example.deltager.simonsays5;

import android.os.CountDownTimer;
import android.view.View;

/**
 * Created by deltager on 07-07-17.
 */

public class simonSaysButton {
    private int onColor;
    private int offColor;
    private View btn;
    private int onColorTime = 500;

    public simonSaysButton (int onColor, int offColor, View btn){
        this.onColor = onColor;
        this.offColor = offColor;
        this.btn = btn;
    }

    public void btnBlink() {
        final int startColor = offColor;
        btn.setBackgroundColor(onColor);

        new CountDownTimer(onColorTime, onColorTime) {
            public void onTick(long millisUntilFinished){
            }

            public void onFinish() {
                btn.setBackgroundColor(startColor);
            }
        }.start();
    }
}
