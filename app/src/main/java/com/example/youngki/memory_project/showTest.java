package com.example.youngki.memory_project;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.HashMap;


public class showTest extends AppCompatActivity {

    String[] keys = {"A", "B", "C", "D", "E", "F"};
    Integer[] values = {0, 1, 2, 3, 4, 5};
    String showThis = this.keys[0];
    int count = 0;
    HashMap<String, Integer> correct = new HashMap<>();
    //String [] correct;

    public void showResultsNow(){
        Intent resultsWindowOpener = new Intent(this,showResults.class);
        //resultsWindowOpener.putExtra("correct", correct);
        startActivity(resultsWindowOpener);
    }

    public void getNextLetter(){
        this.count = this.count + 1;
        if (count < keys.length){
            this.showThis = this.keys[this.count];
            TextView tv = (TextView) findViewById(R.id.textView3);
            tv.setText(showThis);
            ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
            pb.incrementProgressBy(1);
        }
        else{
            showResultsNow();
        }
    }

    public void onOneClicked(View view){
        if (values[count] == 1){
            correct.put(keys[count], values[count]);
        }
        getNextLetter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    //    setMemoryMap(memoryMap);
        TextView tv = (TextView) findViewById(R.id.textView3);
    //    this.showThis = this.keys[3];
        tv.setText(this.showThis);
        ProgressBar pb = (ProgressBar) findViewById(R.id.progressBar);
        pb.setMax(keys.length);
    }
}
