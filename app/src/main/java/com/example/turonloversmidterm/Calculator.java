package com.example.turonloversmidterm;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Calculator extends AppCompatActivity {

    //The TextView class is a user interface component in Android that is used to display text on the screen.
    //By importing the TextView class, a developer can use its functionality to create and manipulate text-based UI elements in their Android application.

    TextView workingsTV;
    TextView resultsTV;

    String workings = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        initTextViews();
    }

    //newly created method
    private void initTextViews(){
        workingsTV = (TextView)findViewById(R.id.calcNumber);
        resultsTV = (TextView)findViewById(R.id.calcResult);
    }

    private void setWorkings(String givenValue){
        workings = workings + givenValue;
        workingsTV.setText(workings);
    }

    public void equalsOnClick(View view) {
        Double result = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            result = (double)engine.eval(workings);
        } catch (ScriptException e){
            Toast.makeText(this, "Invalid Input", Toast.LENGTH_SHORT).show();
        }

        if(result != null)
            resultsTV.setText(String.valueOf(result.doubleValue()));
    }

    public void clearOnClick(View view) {
        workingsTV.setText("");
        workings = "";
        resultsTV.setText("");
    }

    public void deleteOnClick(View view) {
    }

    public void divideOnClick(View view) {
        setWorkings("/");
    }

    public void sevenOnClick(View view) {
        setWorkings("7");
    }

    public void eightOnClick(View view) {
        setWorkings("8");
    }

    public void nineOnClick(View view) {
        setWorkings("9");
    }

    public void multiplyOnClick(View view) {
        setWorkings("*");
    }

    public void fourOnClick(View view) {
        setWorkings("4");
    }

    public void fiveOnClick(View view) {
        setWorkings("5");
    }

    public void sixOnClick(View view) {
        setWorkings("6");
    }

    public void subtractOnClick(View view) {
        setWorkings("-");
    }

    public void oneOnClick(View view) {
        setWorkings("1");
    }

    public void twoOnClick(View view) {
        setWorkings("2");
    }

    public void threeOnClick(View view) {
        setWorkings("3");
    }

    public void additionOnClick(View view) {
        setWorkings("+");
    }

    public void pointOnClick(View view) {
        setWorkings(".");
    }

    public void zeroOnClick(View view) {
        setWorkings("0");
    }


}