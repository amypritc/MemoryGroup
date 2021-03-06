package com.youngki.memory_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.graphics.drawable.Icon;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Color;
import android.widget.Button;
import android.widget.ImageView;

import com.google.gson.Gson;
import java.util.HashMap;

public class matchingTest extends AppCompatActivity {

    private MapWrapper memMapWrap;
    String[] keys;
    Integer[] values;
    Boolean A0 = Boolean.FALSE;
    Boolean B0 = Boolean.FALSE;
    Boolean C0 = Boolean.FALSE;
    Boolean D0 = Boolean.FALSE;
    Boolean submitted = Boolean.FALSE;
    Boolean done = Boolean.FALSE;
    Button a1, b1, c1, d1;
    String sA, sB, sC, sD;
    int iA, iB, iC, iD;
    int iCount = 0;
    int visible = 4; //can be 1-4
    int answerA, answerB, answerC, answerD;
    int length;
    Boolean submit = Boolean.FALSE;
    HashMap<String, Integer> result = new HashMap<>();
    int currentColor = Color.rgb(202,201,201);
    HashMap<String, Integer> correct = new HashMap<>();
    HashMap<String, Integer> streakMap = new HashMap<>();
    HashMap<String, Integer> timesCorrectMap = new HashMap<>();
    HashMap<String, Integer> totalAttemptsMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Gson gson = new Gson();
        SharedPreferences prefs = getSharedPreferences("MyPref", MODE_PRIVATE);
        String wrapperStr = prefs.getString("memMap", null);
        MapWrapper wrapper = gson.fromJson(wrapperStr, MapWrapper.class);
        this.keys = wrapper.getKeys();
        this.values = wrapper.getValues(keys);
        length = keys.length;

        String streakStr = prefs.getString("streakMap", null);
        MapWrapper streakWrapper = gson.fromJson(streakStr, MapWrapper.class);
        this.streakMap = streakWrapper.getMap();

        String correctStr = prefs.getString("timesCorrectMap", null);
        MapWrapper correctWrapper = gson.fromJson(correctStr, MapWrapper.class);
        this.timesCorrectMap = correctWrapper.getMap();

        String attemptsStr = prefs.getString("totalAttemptsMap", null);
        MapWrapper attemptsWrapper = gson.fromJson(attemptsStr, MapWrapper.class);
        this.totalAttemptsMap = attemptsWrapper.getMap();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_test);
        Typeface type = Typeface.createFromAsset(getAssets(),"fonts/orange juice 2.0.ttf");
        Button button = (Button)findViewById(R.id.buttonSubmit);
        button.setTypeface(type);
        button = (Button)findViewById(R.id.buttonNext);
        button.setTypeface(type);
        setNumbersLetters();
    }

    public void onSubmitClicked(View v){
        if(A0 & B0 & C0 & D0){
            Button submit = (Button) findViewById(R.id.buttonSubmit);
            submit.setAlpha(0);
            Button next = (Button) findViewById(R.id.buttonNext);
            next.setAlpha(1);
            submitted = Boolean.TRUE;
            getResult();
        }
    }

    public void getResult(){
        int i = visible;
        switch (i){
            case 4:
                if (answerD == iA){
                    streakMap.put(sD, streakMap.get(sD)+1);
                    timesCorrectMap.put(sD, timesCorrectMap.get(sD)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewD);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sD, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewD);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sD, totalAttemptsMap.get(sD)+1);
                if (answerC == iB){
                    streakMap.put(sC, streakMap.get(sC)+1);
                    timesCorrectMap.put(sC, timesCorrectMap.get(sC)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewC);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sC, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewC);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sC, totalAttemptsMap.get(sC)+1);
                if (answerB == iD){
                    streakMap.put(sB, streakMap.get(sB)+1);
                    timesCorrectMap.put(sB, timesCorrectMap.get(sB)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewB);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sB, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewB);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sB, totalAttemptsMap.get(sB)+1);
                if (answerA == iC){
                    streakMap.put(sA, streakMap.get(sA)+1);
                    timesCorrectMap.put(sA, timesCorrectMap.get(sA)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewA);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sA, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewA);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sA, totalAttemptsMap.get(sA)+1);
                break;
            case 3:
                if (answerC == iA){
                    streakMap.put(sC, streakMap.get(sC)+1);
                    timesCorrectMap.put(sC, timesCorrectMap.get(sC)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewC);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sC, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewC);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sC, totalAttemptsMap.get(sC)+1);
                if (answerB == iC){
                    streakMap.put(sB, streakMap.get(sB)+1);
                    timesCorrectMap.put(sB, timesCorrectMap.get(sB)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewB);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sB, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewB);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sB, totalAttemptsMap.get(sB)+1);
                if (answerA == iB){
                    streakMap.put(sA, streakMap.get(sA)+1);
                    timesCorrectMap.put(sA, timesCorrectMap.get(sA)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewA);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sA, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewA);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sA, totalAttemptsMap.get(sA)+1);
                break;
            case 2:
                if (answerB == iA){
                    streakMap.put(sB, streakMap.get(sB)+1);
                    timesCorrectMap.put(sB, timesCorrectMap.get(sB)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewB);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sB, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewB);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sB, totalAttemptsMap.get(sB)+1);
                if (answerA == iB){
                    streakMap.put(sA, streakMap.get(sA)+1);
                    timesCorrectMap.put(sA, timesCorrectMap.get(sA)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewA);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sA, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewA);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sA, totalAttemptsMap.get(sA)+1);
                break;
            case 1:
                if (answerA == iA){
                    streakMap.put(sA, streakMap.get(sA)+1);
                    timesCorrectMap.put(sA, timesCorrectMap.get(sA)+1);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewA);
                    iv.setAlpha(0f);
                }
                else{
                    streakMap.put(sA, 0);
                    ImageView iv = (ImageView) findViewById(R.id.imageViewA);
                    iv.setAlpha(1f);
                }
                totalAttemptsMap.put(sA, totalAttemptsMap.get(sA)+1);
                break;
        }
    }

    public void onPause(){
        //save the data onpause
        super.onPause();

        Gson gson = new Gson();
        SharedPreferences.Editor editor = getSharedPreferences("MyPref", MODE_PRIVATE).edit();

        MapWrapper streakWrap = new MapWrapper();
        streakWrap.setMap(streakMap);
        String serializedStreak = gson.toJson(streakWrap);
        editor.putString("streakMap", serializedStreak);

        MapWrapper correctWrap = new MapWrapper();
        correctWrap.setMap(timesCorrectMap);
        String serializedCorrect = gson.toJson(correctWrap);
        editor.putString("timesCorrectMap", serializedCorrect);

        MapWrapper attemptsWrap = new MapWrapper();
        attemptsWrap.setMap(totalAttemptsMap);
        String serializedAttempts = gson.toJson(attemptsWrap);
        editor.putString("totalAttemptsMap", serializedAttempts);

        editor.apply(); //persist the values
    }

    public void onNextClicked(View view){
        if (submitted) {
            Button next = (Button) findViewById(R.id.buttonNext);
            next.setAlpha(0);
            submitted = Boolean.FALSE;
            if (done) {
                Intent resultsWindowOpener = new Intent(this,showResultsOpt2.class);
                //Intent resultsWindowOpener = new Intent(this, showResults.class);
                startActivity(resultsWindowOpener);
            } else {
                Button submit = (Button) findViewById(R.id.buttonSubmit);
                A0 = Boolean.FALSE;
                B0 = Boolean.FALSE;
                C0 = Boolean.FALSE;
                D0 = Boolean.FALSE;
                submit.setAlpha(1);
                clearA0Lines();
                clearB0Lines();
                clearC0Lines();
                clearD0Lines();
                clearColors();
                ImageView iv = (ImageView) findViewById(R.id.imageViewD);
                iv.setAlpha(0f);
                iv = (ImageView) findViewById(R.id.imageViewC);
                iv.setAlpha(0f);
                iv = (ImageView) findViewById(R.id.imageViewB);
                iv.setAlpha(0f);
                iv = (ImageView) findViewById(R.id.imageViewA);
                iv.setAlpha(0f);
                setNumbersLetters();
            }
        }
    }

    public void setNumbersLetters(){
        if (iCount+4<=length){
            iA = values[iCount+2];
            setButton(R.id.buttonA1, iA);
            iB = values[iCount];
            setButton(R.id.buttonB1, iB);
            iC = values[iCount+3];
            setButton(R.id.buttonC1, iC);
            iD = values[iCount+1];
            setButton(R.id.buttonD1, iD);
            sA = keys[iCount+3];
            setLetterButton(R.id.buttonA0, sA);
            sB = keys[iCount+1];
            setLetterButton(R.id.buttonB0, sB);
            sC = keys[iCount];
            setLetterButton(R.id.buttonC0, sC);
            sD = keys[iCount+2];
            setLetterButton(R.id.buttonD0, sD);
            iCount = iCount + 4;
            if (iCount == length){
                done = Boolean.TRUE;
            }
        }
        else if ((iCount+3)<=length){
            iA = values[iCount+2];
            setButton(R.id.buttonA1, iA);
            iB = values[iCount];
            setButton(R.id.buttonB1, iB);
            iC = values[iCount+1];
            setButton(R.id.buttonC1, iC);
            sA = keys[iCount];
            setLetterButton(R.id.buttonA0, sA);
            sB = keys[iCount+1];
            setLetterButton(R.id.buttonB0, sB);
            sC = keys[iCount+2];
            setLetterButton(R.id.buttonC0, sC);
            Button b = (Button) findViewById(R.id.buttonD1);
            b.setAlpha(0);
            b = (Button) findViewById(R.id.buttonD0);
            b.setAlpha(0);
            visible = 3;
            D0 = Boolean.TRUE;
            done = Boolean.TRUE;
        }
        else if ((iCount+2)<=length){
            iA = values[iCount+1];
            setButton(R.id.buttonA1, iA);
            iB = values[iCount];
            setButton(R.id.buttonB1, iB);
            sA = keys[iCount];
            setLetterButton(R.id.buttonA0, sA);
            sB = keys[iCount+1];
            setLetterButton(R.id.buttonB0, sB);
            Button b = (Button) findViewById(R.id.buttonC1);
            b.setAlpha(0);
            b = (Button) findViewById(R.id.buttonC0);
            b.setAlpha(0);
            b = (Button) findViewById(R.id.buttonD1);
            b.setAlpha(0);
            b = (Button) findViewById(R.id.buttonD0);
            b.setAlpha(0);
            visible = 2;
            D0 = Boolean.TRUE;
            C0 = Boolean.TRUE;
            done = Boolean.TRUE;
        }
        else if ((iCount+1)<=length){
            iA = values[iCount];
            setButton(R.id.buttonA1, iA);
            sA = keys[iCount];
            setLetterButton(R.id.buttonA0, sA);
            Button b = (Button) findViewById(R.id.buttonB1);
            b.setAlpha(0);
            b = (Button) findViewById(R.id.buttonC1);
            b.setAlpha(0);
            b = (Button) findViewById(R.id.buttonD1);
            b.setAlpha(0);
            b = (Button) findViewById(R.id.buttonB0);
            b.setAlpha(0);
            b = (Button) findViewById(R.id.buttonC0);
            b.setAlpha(0);
            b = (Button) findViewById(R.id.buttonD0);
            b.setAlpha(0);
            visible = 1;
            D0 = Boolean.TRUE;
            C0 = Boolean.TRUE;
            B0 = Boolean.TRUE;
            done = Boolean.TRUE;
        }
    }

    public void setButton(int id, int i){
        Button b = (Button) findViewById(id);

        switch (i){
            case 0:
                b.setText(R.string._0);
                break;
            case 1:
                b.setText(R.string._1);
                break;
            case 2:
                b.setText(R.string._2);
                break;
            case 3:
                b.setText(R.string._3);
                break;
            case 4:
                b.setText(R.string._4);
                break;
            case 5:
                b.setText(R.string._5);
                break;
            case 6:
                b.setText(R.string._6);
                break;
            case 7:
                b.setText(R.string._7);
                break;
            case 8:
                b.setText(R.string._8);
                break;
            case 9:
                b.setText(R.string._9);
                break;
        }
    }

    public void setLetterButton(int id, String s){
        Button b = (Button) findViewById(id);
        switch (s) {
            case "A":
                b.setText(R.string._A);
                break;
            case "B":
                b.setText(R.string._B);
                break;
            case "C":
                b.setText(R.string._C);
                break;
            case "D":
                b.setText(R.string._D);
                break;
            case "E":
                b.setText(R.string._E);
                break;
            case "F":
                b.setText(R.string._F);
                break;
            case "G":
                b.setText(R.string._G);
                break;
            case "H":
                b.setText(R.string._H);
                break;
            case "I":
                b.setText(R.string._I);
                break;
            case "J":
                b.setText(R.string._J);
                break;
            case "K":
                b.setText(R.string._K);
                break;
            case "L":
                b.setText(R.string._L);
                break;
            case "M":
                b.setText(R.string._M);
                break;
            case "N":
                b.setText(R.string._N);
                break;
            case "O":
                b.setText(R.string._O);
                break;
            case "P":
                b.setText(R.string._P);
                break;
            case "Q":
                b.setText(R.string._Q);
                break;
            case "R":
                b.setText(R.string._R);
                break;
            case "S":
                b.setText(R.string._S);
                break;
            case "T":
                b.setText(R.string._T);
                break;
            case "U":
                b.setText(R.string._U);
                break;
            case "V":
                b.setText(R.string._V);
                break;
            case "W":
                b.setText(R.string._W);
                break;
            case "X":
                b.setText(R.string._X);
                break;
            case "Y":
                b.setText(R.string._Y);
                break;
            case "Z":
                b.setText(R.string._Z);
                break;
        }
    }

    public void clearA0Lines(){
        View v = findViewById(R.id.lineA1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1A0);
        v.setAlpha(0);
    }

    public void clearB0Lines(){
        View v = findViewById(R.id.lineA1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1B0);
        v.setAlpha(0);
    }

    public void clearC0Lines(){
        View v  = findViewById(R.id.lineA1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1C0);
        v.setAlpha(0);
    }

    public void clearD0Lines(){
        View v= findViewById(R.id.lineA1D0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1D0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1D0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1D0);
        v.setAlpha(0);
    }

    public void clearA1Lines(){
        View v = findViewById(R.id.lineA1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineA1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineA1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineA1D0);
        v.setAlpha(0);
    }

    public void clearB1Lines(){
        View v = findViewById(R.id.lineB1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineB1D0);
        v.setAlpha(0);
    }

    public void clearC1Lines(){
        View v  = findViewById(R.id.lineC1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineC1D0);
        v.setAlpha(0);
    }

    public void clearD1Lines(){
        View v= findViewById(R.id.lineD1A0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1B0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1C0);
        v.setAlpha(0);
        v = findViewById(R.id.lineD1D0);
        v.setAlpha(0);
    }

    public void clearColors(){
        currentColor = Color.rgb(202,201,201);
        Button b = (Button) findViewById(R.id.buttonA0);
        b.setBackgroundColor(currentColor);
        b = (Button) findViewById(R.id.buttonB0);
        b.setBackgroundColor(currentColor);
        b = (Button) findViewById(R.id.buttonC0);
        b.setBackgroundColor(currentColor);
        b = (Button) findViewById(R.id.buttonD0);
        b.setBackgroundColor(currentColor);
    }

    public void clearButtonRefs(Button b){
        if (a1 == b){
            a1 = null;
        }
        else if (b1 == b){
            b1 = null;
        }
        else if (c1 == b){
            c1 = null;
        }
        else if (d1 == b){
            d1 = null;
        }
    }

    public void onNumberClick(View v){
        int id = v.getId();
        if (id == R.id.buttonA1){
            currentColor = Color.rgb(142,197,235);
        }
        else if (id == R.id.buttonB1) {
            if (visible > 1){
                currentColor = Color.rgb(111, 197, 128);
            }
        }
        else if (id == R.id.buttonC1){
            if (visible > 2){
                currentColor = Color.rgb(220,94,90);

            }
        }
        else if (id == R.id.buttonD1){
            if (visible == 4) {
                currentColor = Color.rgb(175, 134, 204);
            }
        }
    }

    public void onA0Click(View view) {
        if (submitted == Boolean.FALSE) {
            clearA0Lines();
            A0 = Boolean.TRUE;
            Button b = (Button) findViewById(R.id.buttonA0);
            clearButtonRefs(b);
            if (currentColor == Color.rgb(142, 197, 235)) {
                View v = findViewById(R.id.lineA1A0);
                if (a1 != null) {
                    a1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                clearA1Lines();
                v.setAlpha(1);
                a1 = b;
                answerA = iA;
            } else if (currentColor == Color.rgb(111, 197, 128)) {
                View v = findViewById(R.id.lineB1A0);
                if (b1 != null) {
                    b1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                clearB1Lines();
                v.setAlpha(1);
                b1 = b;
                answerA = iB;
            } else if (currentColor == Color.rgb(220, 94, 90)) {
                View v = findViewById(R.id.lineC1A0);
                clearC1Lines();
                v.setAlpha(1);
                if (c1 != null) {
                    c1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                c1 = b;
                answerA = iC;
            } else if (currentColor == Color.rgb(175, 134, 204)) {
                View v = findViewById(R.id.lineD1A0);
                clearD1Lines();
                v.setAlpha(1);
                if (d1 != null) {
                    d1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                d1 = b;
                answerA = iD;
            }
            b.setBackgroundColor(currentColor);
        }
    }

    public void onB0Click(View view) {
        if ((submitted == Boolean.FALSE) & (visible > 1)) {
            clearB0Lines();
            B0 = Boolean.TRUE;
            Button b = (Button) findViewById(R.id.buttonB0);
            clearButtonRefs(b);
            if (currentColor == Color.rgb(142, 197, 235)) {
                View v = findViewById(R.id.lineA1B0);
                clearA1Lines();
                v.setAlpha(1);
                if (a1 != null) {
                    a1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                a1 = b;
                answerB = iA;
            } else if (currentColor == Color.rgb(111, 197, 128)) {
                View v = findViewById(R.id.lineB1B0);
                clearB1Lines();
                v.setAlpha(1);
                if (b1 != null) {
                    b1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                b1 = b;
                answerB = iB;
            } else if (currentColor == Color.rgb(220, 94, 90)) {
                View v = findViewById(R.id.lineC1B0);
                clearC1Lines();
                v.setAlpha(1);
                if (c1 != null) {
                    c1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                c1 = b;
                answerB = iC;
            } else if (currentColor == Color.rgb(175, 134, 204)) {
                View v = findViewById(R.id.lineD1B0);
                clearD1Lines();
                v.setAlpha(1);
                if (d1 != null) {
                    d1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                d1 = b;
                answerB = iD;
            }
            b.setBackgroundColor(currentColor);
        }
    }

    public void onC0Click(View view) {
        if ((submitted == Boolean.FALSE) & (visible > 2)) {
            clearC0Lines();
            C0 = Boolean.TRUE;
            Button b = (Button) findViewById(R.id.buttonC0);
            clearButtonRefs(b);
            if (currentColor == Color.rgb(142, 197, 235)) {
                View v = findViewById(R.id.lineA1C0);
                clearA1Lines();
                v.setAlpha(1);
                if (a1 != null) {
                    a1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                a1 = b;
                answerC = iA;
            } else if (currentColor == Color.rgb(111, 197, 128)) {
                View v = findViewById(R.id.lineB1C0);
                clearB1Lines();
                v.setAlpha(1);
                if (b1 != null) {
                    b1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                b1 = b;
                answerC = iB;
            } else if (currentColor == Color.rgb(220, 94, 90)) {
                View v = findViewById(R.id.lineC1C0);
                clearC1Lines();
                v.setAlpha(1);
                if (c1 != null) {
                    c1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                c1 = b;
                answerC = iC;
            } else if (currentColor == Color.rgb(175, 134, 204)) {
                View v = findViewById(R.id.lineD1C0);
                clearD1Lines();
                v.setAlpha(1);
                if (d1 != null) {
                    d1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                d1 = b;
                answerC = iD;
            }
            b.setBackgroundColor(currentColor);
        }
    }

    public void onD0Click(View view) {
        if ((submitted == Boolean.FALSE) & (visible == 4)) {
            clearD0Lines();
            D0 = Boolean.TRUE;
            Button b = (Button) findViewById(R.id.buttonD0);
            clearButtonRefs(b);
            if (currentColor == Color.rgb(142, 197, 235)) {
                View v = findViewById(R.id.lineA1D0);
                clearA1Lines();
                v.setAlpha(1);
                if (a1 != null) {
                    a1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                a1 = b;
                answerD = iA;
            } else if (currentColor == Color.rgb(111, 197, 128)) {
                View v = findViewById(R.id.lineB1D0);
                clearB1Lines();
                v.setAlpha(1);
                if (b1 != null) {
                    b1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                b1 = b;
                answerD = iB;
            } else if (currentColor == Color.rgb(220, 94, 90)) {
                View v = findViewById(R.id.lineC1D0);
                clearC1Lines();
                v.setAlpha(1);
                if (c1 != null) {
                    c1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                c1 = b;
                answerD = iC;
            } else if (currentColor == Color.rgb(175, 134, 204)) {
                View v = findViewById(R.id.lineD1D0);
                clearD1Lines();
                v.setAlpha(1);
                if (d1 != null) {
                    d1.setBackgroundColor(Color.rgb(202, 201, 201));
                }
                d1 = b;
                answerD = iD;
            }
            b.setBackgroundColor(currentColor);
        }
    }
}
