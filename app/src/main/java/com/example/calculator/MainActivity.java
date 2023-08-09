package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button plus;
    private Button minus;
    private Button divide;
    private Button multiply;
    private Button result;
    private Button decimal;
    private Button clear;
    private Button backspace;
    private TextView viewResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        one=findViewById(R.id.button1);
        two=findViewById(R.id.button2);
        three=findViewById(R.id.button3);
        four=findViewById(R.id.button4);
        five=findViewById(R.id.button5);
        six=findViewById(R.id.button6);
        seven=findViewById(R.id.button7);
        eight=findViewById(R.id.button8);
        nine=findViewById(R.id.button9);
        zero=findViewById(R.id.button0);
        plus=findViewById(R.id.buttonPlus);
        minus=findViewById(R.id.buttonMinus);
        divide=findViewById(R.id.buttonDivide);
        multiply=findViewById(R.id.buttonMultiply);
        result=findViewById(R.id.buttonResult);
        decimal=findViewById(R.id.buttonDecimal);
        clear=findViewById(R.id.buttonClear);
        backspace=findViewById(R.id.buttonBack);
        viewResult=findViewById(R.id.resultTextView);

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("0");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("+");
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("-");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("*");
            }
        });
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateResultTextView("/");
            }
        });
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showOutput(viewResult.getText().toString());
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearing(viewResult.getText().toString());
            }
        });
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BackSpace(viewResult.getText().toString());
            }
        });
    }
    private  void BackSpace(String str){
        if (!str.isEmpty()) {
            // Remove the last character
            String updatedText = str.substring(0, str.length() - 1);
            viewResult.setText(updatedText);
        }
    }
    private  void clearing(String str){
        String s="";
        viewResult.setText(s);
    }
    private void updateResultTextView(String newText) {

        String currentText =viewResult.getText().toString();
        String updatedText = currentText + newText;
        viewResult.setText(updatedText);
    }
    private void showOutput(String input){
        if (input.contains("*")) {
            performCalculation(input, "\\*"); // Escape the '*' with double backslashes
        } else if (input.contains("/")) {
            performCalculation(input, "/");
        } else if (input.contains("+")) {
            performCalculation(input, "\\+");
        } else if (input.contains("-")) {
            performCalculation(input, "-");
        }
    }
    private void performCalculation(String input, String operator){
        String[] parts = input.split(operator);

        if (parts.length == 2) {
            try {
                double num1 = Integer.parseInt(parts[0]);
                double num2 = Integer.parseInt(parts[1]);
                double result;

                if (operator.equals("-")) {
                    result = num1 - num2;
                } else if (operator.equals("/")) {
                    result = num1 / num2;
                } else if (operator.equals("\\+")) {
                    result = num1 + num2;
                } else {
                    result = num1 * num2;
                }

                // Display the result in the TextView
                viewResult.setText(String.valueOf(result));
            } catch (NumberFormatException | ArithmeticException e) {
                // Handle parsing error or division by zero
                viewResult.setText("Error");
            }
        } else {
            // Handle invalid input
            viewResult.setText("Invalid input");
        }
    }
}