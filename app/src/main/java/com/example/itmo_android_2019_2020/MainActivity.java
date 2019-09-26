package com.example.itmo_android_2019_2020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView textView;
    private ExpressionParser expressionParser;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonMultiply;
    private Button buttonDivide;
    private Button buttonDelete;
    private Button buttonEquals;
    private Button buttonOpenBracket;
    private Button buttonCloseBracket;
    private Button buttonDot;
    private Button buttonDeleteAll;

    String expression = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expressionParser = new ExpressionParser();
        textView = findViewById(R.id.textView);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.buttonplus);
        buttonMinus = findViewById(R.id.buttonminus);
        buttonMultiply = findViewById(R.id.buttonmultiply);
        buttonDivide = findViewById(R.id.buttondivide);
        buttonDelete = findViewById(R.id.buttondelete);
        buttonEquals = findViewById(R.id.buttonequals);
        buttonOpenBracket = findViewById(R.id.buttonopenbracket);
        buttonCloseBracket = findViewById(R.id.buttonclosebracket);
        buttonDot = findViewById(R.id.buttondot);
        buttonDeleteAll = findViewById(R.id.buttondeleteall);

        textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setTextIsSelectable(true);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        buttonOpenBracket.setOnClickListener(this);
        buttonCloseBracket.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonDeleteAll.setOnClickListener(this);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString("ex", expression);
        super.onSaveInstanceState(outState);

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        expression = savedInstanceState.getString("ex");
        textView.setText(expression);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                expression += "0";
                textView.setText(expression);
                break;
            case R.id.button1:
                expression += "1";
                textView.setText(expression);
                break;
            case R.id.button2:
                expression += "2";
                textView.setText(expression);
                break;
            case R.id.button3:
                expression += "3";
                textView.setText(expression);
                break;
            case R.id.button4:
                expression += "4";
                textView.setText(expression);
                break;
            case R.id.button5:
                expression += "5";
                textView.setText(expression);
                break;
            case R.id.button6:
                expression += "6";
                textView.setText(expression);
                break;
            case R.id.button7:
                expression += "7";
                textView.setText(expression);
                break;
            case R.id.button8:
                expression += "8";
                textView.setText(expression);
                break;
            case R.id.button9:
                expression += "9";
                textView.setText(expression);
                break;
            case R.id.buttonplus:
                expression += "+";
                textView.setText(expression);
                break;
            case R.id.buttonminus:
                expression += "-";
                textView.setText(expression);
                break;
            case R.id.buttonmultiply:
                expression += "*";
                textView.setText(expression);
                break;
            case R.id.buttondivide:
                expression += "/";
                textView.setText(expression);
                break;
            case R.id.buttonequals:
                expression = "" + expressionParser.parse(expression).evaluate(0.0);
                if (expression.charAt(expression.length() - 1) == '0' && expression.charAt(expression.length() - 2) == '.'){
                    expression = expression.substring(0, expression.length() - 2);
                }
                textView.setText(expression);
                break;
            case R.id.buttondelete:
                if (expression.length() > 0) {
                    expression = expression.substring(0, expression.length() - 1);
                }
                textView.setText(expression);
                break;
            case R.id.buttonopenbracket:
                expression += "(";
                textView.setText(expression);
                break;
            case R.id.buttonclosebracket:
                expression += ")";
                textView.setText(expression);
                break;
            case R.id.buttondot:
                expression += ".";
                textView.setText(expression);
                break;
            default:
                expression = "";
                textView.setText(expression);
        }

    }
}