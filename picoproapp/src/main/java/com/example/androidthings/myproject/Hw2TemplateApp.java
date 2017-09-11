package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * Template for IDD Fall 2017 HW2 (text entry device)
 * Created by bjoern on 9/5/17.
 */

public class Hw2TemplateApp extends SimplePicoPro {

    private final Gpio INCREMENT_PIN = GPIO_128;
    private final Gpio DECREMENT_PIN = GPIO_39;
    private final Gpio ADVANCE_PIN = GPIO_10;
    private PongView pongView;

    @Override
    public void setup() {
        //set two GPIOs to input
        pinMode(INCREMENT_PIN,Gpio.DIRECTION_IN);
        setEdgeTrigger(INCREMENT_PIN,Gpio.EDGE_BOTH);

        pinMode(DECREMENT_PIN,Gpio.DIRECTION_IN);
        setEdgeTrigger(DECREMENT_PIN,Gpio.EDGE_BOTH);

        pinMode(ADVANCE_PIN,Gpio.DIRECTION_IN);
        setEdgeTrigger(ADVANCE_PIN,Gpio.EDGE_BOTH);

        pongView = (PongView) activity.findViewById(R.id.pongGame);
    }

    @Override
    public void loop() {
        //nothing to do here

    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        println("digitalEdgeEvent"+pin+", "+value);
        // when 128 goes from LOW to HIGH
        // this is on button button release for pull-up resistors
        if(pin==INCREMENT_PIN && value==HIGH) {
            pongView.reactivateGame();
            pongView.movePaddleUp();

        }
        //when 39 goes from HIGH to HIGH
        else if (pin==DECREMENT_PIN && value==HIGH) {
            pongView.reactivateGame();
            pongView.movePaddleDown();
        }
        else if (pin==ADVANCE_PIN && value==HIGH) {
            pongView.reactivateGame();
            pongView.advanceScore();
        }
    }
}
