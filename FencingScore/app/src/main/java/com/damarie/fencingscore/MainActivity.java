package com.damarie.fencingscore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreFencerOne = 0;
    int scoreFencerTwo = 0;
    int yellowCardOne = 0;
    int yellowCardTwo = 0;
    int redCardOne = 0;
    int redCardTwo = 0;
    int blackCardOne = 0;
    int blackCardTwo = 0;
    int group3One = 0;
    int group3Two = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForFencerOne(0);
        displayForFencerTwo(0);
    }

    public void resetScore(View view) {
        scoreFencerOne = 0;
        scoreFencerTwo = 0;
        yellowCardOne = 0;
        yellowCardTwo = 0;
        redCardOne = 0;
        redCardTwo = 0;
        blackCardOne = 0;
        blackCardTwo = 0;
        group3One = 0;
        group3Two = 0;
        displayForFencerOne(scoreFencerOne);
        displayForFencerTwo(scoreFencerTwo);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForFencerOne(int score) {
        TextView scoreView = (TextView) findViewById(R.id.fencer_one_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForFencerTwo(int score) {
        TextView scoreView = (TextView) findViewById(R.id.fencer_two_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Adds a group 1 offense to the designated fencer.
     */
    public void addGroup1One(View view) {
        yellowCardOne = yellowCardOne + 1;
        if(yellowCardOne > 1) {
            redCardOne = redCardOne + 1;
            yellowCardOne = 1;
            scoreFencerTwo = scoreFencerTwo + 1;
            displayForFencerTwo(scoreFencerTwo);
        }
    }

    public void addGroup1Two(View view) {
        yellowCardTwo = yellowCardTwo + 1;
        if (yellowCardTwo > 1) {
            redCardTwo = redCardTwo + 1;
            yellowCardTwo = 1;
            scoreFencerOne = scoreFencerOne + 1;
            displayForFencerOne(scoreFencerOne);
        }
    }

    /**
     * Adds a Group 2 Offense to the selected player
     * @param view
     */
    public void addGroup2One(View view) {
        redCardOne = redCardOne + 1;
        scoreFencerTwo = scoreFencerTwo + 1;
        displayForFencerTwo(scoreFencerTwo);
    }

    public void addGroup2Two(View view) {
        redCardTwo = redCardTwo + 1;
        scoreFencerOne = scoreFencerOne + 1;
        displayForFencerOne(scoreFencerOne);
    }

    /**
     * Adds a Group 3 offenses to the player
     * @param view
     */
    public void addGroup3One(View view) {
        redCardOne = redCardOne + 1;
        scoreFencerTwo = scoreFencerTwo + 1;
        displayForFencerTwo(scoreFencerTwo);
        group3One = group3One + 1;
        if (group3One > 1) {
            blackCardOne = 1;
            resetScore(view);
        }
    }

    public void addGroup3Two(View view) {
        redCardTwo = redCardTwo + 1;
        scoreFencerOne = scoreFencerOne + 1;
        displayForFencerOne(scoreFencerOne);
        group3Two = group3Two + 1;
        if (group3Two > 1) {
            blackCardTwo = 1;
            resetScore(view);
         }
    }

    public void addGroup4One(View view) {
        displayForFencerOne(scoreFencerOne);
        resetScore(view);
    }

    public void addGroup4Two(View view) {
        displayForFencerTwo(scoreFencerTwo);
        resetScore(view);
    }

    public void addTouchOne(View view) {
        scoreFencerOne = scoreFencerOne + 1;
        displayForFencerOne(scoreFencerOne);
    }

    public void addTouchTwo(View view) {
        scoreFencerTwo = scoreFencerTwo + 1;
        displayForFencerTwo(scoreFencerTwo);
    }
}
