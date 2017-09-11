package com.example.androidthings.myproject;

import android.app.Activity;
import android.util.Log;
import android.widget.TextView;


import static android.content.ContentValues.TAG;

/**
 * Created by lily on 9/10/17.
 * Component for an editable string.
 */

class CharList {
    private StringBuilder word;
    private static final char SPACE_TEMP = '_';
    CharList() {
        word = new StringBuilder();
        word.append(SPACE_TEMP);
    }

    public void advanceChar() {
        if (word.length() == 0) { word.append(SPACE_TEMP); return; }
        char lastChar = word.charAt(word.length() - 1);
        if (lastChar == SPACE_TEMP) { word.replace(word.length() - 1, word.length(), " "); }
        word.append(SPACE_TEMP);
    }

    public void incrementLastChar() {
        if (word.length() == 0) { return; }
        int lastChar = (int) word.charAt(word.length() - 1);
        int modifiedLastChar;
        // if last char in string is space, next char is a
        if (lastChar == (int) SPACE_TEMP) { modifiedLastChar = 97; }
        // if last char is z, next char is space
        else if (lastChar == 122) { modifiedLastChar = (int) SPACE_TEMP; }
        else { modifiedLastChar = lastChar + 1; }
        word.replace(word.length() - 1, word.length(), String.valueOf((char) modifiedLastChar));
    }

    public void decrementLastChar() {
        if (word.length() == 0) { return; }
        int lastChar = (int) word.charAt(word.length() - 1);
        int modifiedLastChar;
        // if last char in string is space, next char is z
        if (lastChar == (int) SPACE_TEMP) { modifiedLastChar = 122; }
        // if last char is a, next char is space
        else if (lastChar == 97) { modifiedLastChar = (int) SPACE_TEMP; }
        else { modifiedLastChar = lastChar - 1; }
        word.replace(word.length() - 1, word.length(), String.valueOf((char) modifiedLastChar));
    }

    public String getString() {
        return word.toString();
    }

}
