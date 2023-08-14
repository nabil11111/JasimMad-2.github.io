package com.example.mathsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity3 extends AppCompatActivity {



    TextView textQNum005;
    TextView textRAns005;
    TextView textQuestion005;


    Button button005;

    Button button006;

    Button button007;

    int level = 0;
    int great = 0;
    int rightAnswer = 0;
    String realOperation = "";


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        textQNum005 = findViewById(R.id.textQNum005);
        textRAns005 = findViewById(R.id.textRAns005);
        textQuestion005 = findViewById(R.id.textQuestion005);

        button005 = findViewById(R.id.button005);
        button006 = findViewById(R.id.button006);
        button007 = findViewById(R.id.button007);

        textQNum005.setText("Question : " + level + " / 10");
        textRAns005.setText("SCORE " + great + " / 10");

        if (level < 10) {
            getARandomQuestion();
        }


    }
    private int getARandomQuestion() {

        button005.setBackgroundResource(R.drawable.buttons_option_bg);
        button006.setBackgroundResource(R.drawable.buttons_option_bg);
        button007.setBackgroundResource(R.drawable.buttons_option_bg);



        // get random number for question

        int firstNumber = new Random().nextInt(12)+1;
        int secondNumber = new Random().nextInt(12)+1;


        // get random operation (+ , - , *)

        int operation = new Random().nextInt(3) + 1;

        // get two options

        int optionA = new Random().nextInt(100);
        int optionB = new Random().nextInt(100);

        if (operation == 1) {
            realOperation = "+";
            rightAnswer = firstNumber + secondNumber;
            textQuestion005.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
        } else {
            if (operation == 2) {
                realOperation = "*";
                rightAnswer = firstNumber * secondNumber;
                textQuestion005.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
            } else {
                if (operation == 3) {
                    realOperation = "-";

                    if (firstNumber < secondNumber) {
                        rightAnswer = secondNumber - firstNumber;
                        textQuestion005.setText(secondNumber + " " + realOperation + " " + firstNumber + " = ?");
                    } else {
                        rightAnswer = firstNumber - secondNumber;
                        textQuestion005.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");

                    }

                }
            }

        }


        // get random position of right answer

        int position = new Random().nextInt(3) + 1; // 1 or 2 or 3 position

        if (position == 1) {
            button005.setText("" + rightAnswer);
            button006.setText("" + optionA);
            button007.setText("" + optionB);
        } else {
            button005.setText("" + optionA);
            if (position == 2) {
                button006.setText("" + rightAnswer);
                button007.setText("" + optionB);
            } else {
                button006.setText("" + optionB);
                button007.setText("" + rightAnswer);

            }
        }

        button005.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (button005.getText().equals("" + rightAnswer)) {
                    button005.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1; // Increment score only when the answer is correct
                } else {
                    button005.setBackgroundResource(R.drawable.wrong_answer_bg);
                }
                level = level + 1;
                textQNum005.setText("Question : " + level + " / 10");
                textRAns005.setText("SCORE : " + great + " / 10");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                            intent.putExtra("RA", great);
                            startActivity(intent);
                            finish();
                        }
                    }
                }, 1000); // 1 sec
            }
        });

// Similarly, update the onClick listeners for buttonOp14 and buttonOp15




        button006.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textQuestion005.setText(firstNumber + realOperation + secondNumber + "=" + rightAnswer);

                if (button006.getText().equals("" + rightAnswer)) {
                    button006.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textQNum005.setText("Question : " + level + " / 10");
                    textRAns005.setText("SCORE : " + great + " / 10");
                } else {
                    level = level + 1;
                    textQNum005.setText("Question : " + level + " / 10");
                    button006.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                            intent.putExtra("RA", great);
                            startActivity(intent);
                            finish();
                        }

                    }
                }, 1000); // 1 sec
            }
        });

        button007.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textQuestion005.setText(firstNumber + realOperation + secondNumber + "=" + rightAnswer);

                if (button007.getText().equals("" + rightAnswer)) {
                    button007.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textQNum005.setText("Question : " + level + " / 10");
                    textRAns005.setText("SCORE : " + great + " / 10");
                } else {
                    level = level + 1;
                    textQNum005.setText("Question : " + level + " / 10");
                    button007.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                            intent.putExtra("RA", great);
                            startActivity(intent);
                            finish();
                        }

                    }
                }, 1000); // 1 sec
            }
        });




        return firstNumber;
    }






}