package com.example.deltager.simonsays5;

import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;

/**
 * Created by deltager on 07-07-17.
 */

public class simonSaysButton {
    private int onColor;
    private int offColor;
    private View btn;
    private int onColorTime = 500;
    private boolean doIBlink;

    public simonSaysButton (int onColor, int offColor, View btn){
        this.onColor = onColor;
        this.offColor = offColor;
        this.btn = btn;

        btn.setSoundEffectsEnabled(false);
    }

    public void btnBlink() {
        final int startColor = offColor;
        changeToOn();

        new CountDownTimer(onColorTime, onColorTime) {
            public void onTick(long millisUntilFinished){
            }

            public void onFinish() {
                changeToOff();
            }
        }.start();
    }

    public boolean getDoIBlink(){
        return doIBlink;
    }

    public void startBlinking(){
        doIBlink = true;
        new CountDownTimer(onColorTime, onColorTime){
            public void onTick (long millisUntilFinished){
                btnBlink();
            }
            public void onFinish(){
                if(doIBlink ==true){
                    start();
                }
            }
        }.start();
    }

    public void changeToOn(){
        btn.setBackgroundColor(onColor);
    }

    public void changeToOff(){
        btn.setBackgroundColor(offColor);
    }

    public void stopBlinking(){
        doIBlink = false;
    }

    public int getOnColorTime(){
        return onColorTime;
    }
}
