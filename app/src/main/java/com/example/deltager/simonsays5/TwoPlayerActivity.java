package com.example.deltager.simonsays5;

import android.app.Activity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

/**
 * Created by deltager on 06-07-17.
 */

public class TwoPlayerActivity extends Activity{

    private GameController gameController;
    private Player player1, player2;

    //player 1; knapper
    public simonSaysButton p1RødKnap, p1BlåKnap, p1GrønKnap, p1GulKnap;

    //player 2; knapper
    public simonSaysButton p2RødKnap, p2BlåKnap, p2GrønKnap, p2GulKnap;

    private boolean P1BtnIsBlinking, P1BtnIsOn;
    private boolean P2BtnIsBlinking, P2BtnIsOn;

    private int blinkingInterval = 300;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player2);

        gameController = new GameController(this);
        player1 = new Player(1, gameController);
        player2 = new Player(2, gameController);

        p1RødKnap = new simonSaysButton(0xFFFF5F51, 0xFFEA4335, findViewById(R.id.RedP1Btn));
        p1BlåKnap = new simonSaysButton(0xFF6694FF, 0xFF4285F4, findViewById(R.id.BlueP1Bnt));
        p1GrønKnap = new simonSaysButton(0xFF2EEB74, 0xFF34A853, findViewById(R.id.GreenP1Bnt));
        p1GulKnap = new simonSaysButton(0xFFFFCE4F, 0xFFFBBC05, findViewById(R.id.yellowP1Btn));

        p2RødKnap = new simonSaysButton(0xFFFF5F51, 0xFFEA4335, findViewById(R.id.redP2Btn));
        p2BlåKnap = new simonSaysButton(0xFF6694FF, 0xFF4285F4, findViewById(R.id.blueP2Btn));
        p2GrønKnap = new simonSaysButton(0xFF47E571, 0xFF34A853, findViewById(R.id.greenP2Btn));
        p2GulKnap = new simonSaysButton(0xFFFFCE4F, 0xFFFBBC05, findViewById(R.id.yellowP2Btn));

    }

    public void P1BtnStartBlinking(){
        P1BtnIsBlinking = true;

        new CountDownTimer(blinkingInterval, blinkingInterval){
            public void onTick (long millisUntilFinished){
                if(P1BtnIsOn == true){
                    p1RødKnap.changeToOff();
                    p1BlåKnap.changeToOff();
                    p1GrønKnap.changeToOff();
                    p1GulKnap.changeToOff();
                    P1BtnIsOn = false;
                }
                else if(P1BtnIsOn == false){
                    p1RødKnap.changeToOn();
                    p1BlåKnap.changeToOn();
                    p1GrønKnap.changeToOn();
                    p1GulKnap.changeToOn();
                    P1BtnIsOn = true;
                }
            }
            public void onFinish(){
                if(P1BtnIsBlinking ==true){
                    start();
                }
            }
        }.start();
    }

    public void P1BtnStopBlinking(){
        P1BtnIsBlinking = false;
    }

    public void P2BtnStartBlinking(){
        P2BtnIsBlinking = true;

        new CountDownTimer(blinkingInterval, blinkingInterval){
            public void onTick (long millisUntilFinished){
                if(P2BtnIsOn == true){
                    p2RødKnap.changeToOff();
                    p2BlåKnap.changeToOff();
                    p2GrønKnap.changeToOff();
                    p2GulKnap.changeToOff();
                    P2BtnIsOn = false;
                }
                else if(P2BtnIsOn == false){
                    p2RødKnap.changeToOn();
                    p2BlåKnap.changeToOn();
                    p2GrønKnap.changeToOn();
                    p2GulKnap.changeToOn();
                    P2BtnIsOn = true;
                }

            }
            public void onFinish(){
                if(P2BtnIsBlinking ==true){
                    start();
                }
            }
        }.start();

    }

    public void P2BtnStopBlinking(){
        P2BtnIsBlinking = false;

    }

    public void playerLost (int activePlayer){
         if (activePlayer == 1) {

         }
         else if (activePlayer == 0) {

         }
    }

    private void P2TrykkedePåenFarve(char farve){
        player2.TrykkedePåEnFarve(farve);
    }

    public void P2TrykkedePåRød(View view){
        P2TrykkedePåenFarve('R');
    }

    public void P2TrykkedePåGrøn(View view){
        P2TrykkedePåenFarve('G');
    }

    public void P2TrykkedePåBlå(View view){
        P2TrykkedePåenFarve('B');
    }

    public void P2TrykkedePåGul(View view){
        P2TrykkedePåenFarve('Y');
    }

    private void P1TrykkedePåenFarve(char farve){
        player1.TrykkedePåEnFarve(farve);
    }

    public void P1TrykkedePåRød(View view){
        P1TrykkedePåenFarve('R');
    }

    public void P1TrykkedePåGrøn(View view){
        P1TrykkedePåenFarve('G');
    }

    public void P1TrykkedePåBlå(View view){
        P1TrykkedePåenFarve('B');
    }

    public void P1TrykkedePåGul(View view){
        P1TrykkedePåenFarve('Y');
    }

    public void setMiddleText(String nyText){
        ((TextView)findViewById(R.id.MiddelText1)).setText(nyText);
        ((TextView)findViewById(R.id.MiddelText2)).setText(nyText);
    }
}
