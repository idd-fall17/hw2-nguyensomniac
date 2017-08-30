package com.example.androidthings.myproject;

import com.google.android.things.pio.Gpio;

/**
 * Created by bjoern on 8/30/17.
 */

public class MyButtonApp extends SimplePicoPro {
    /* Mapping of buttons and LEDs to GPIO pins */
    Gpio buttonA = GPIO_174;
    Gpio ledA = GPIO_34;

    @Override
    public void setup() {
        pinMode(buttonA,Gpio.DIRECTION_IN);
        pinMode(ledA,Gpio.DIRECTION_OUT_INITIALLY_LOW);
    }

    @Override
    public void loop() {
        boolean state = digitalRead(buttonA);
        digitalWrite(ledA,state);
    }
}