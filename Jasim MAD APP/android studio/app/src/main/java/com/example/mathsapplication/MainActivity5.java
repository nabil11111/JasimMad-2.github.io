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

public class MainActivity5 extends AppCompatActivity {

    TextView timer;
    TextView textLevel2;
    TextView textRightAnswered2;
    TextView textQuestion2;


    Button buttonOp3;
    Button buttonOp4;
    Button buttonOp5;

    int level2 = 0;
    int great2 = 0;
    int rightAnswer2 = 0;
    String realOperation2 = "";
    CountDownTimer countDownTimer2;
    private boolean isTimerRunning = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        timer=findViewById(R.id.timertxt);

        textLevel2 = findViewById(R.id.textQuestionNumber2);
        textRightAnswered2 = findViewById(R.id.textRightAnswered2);
        textQuestion2 = findViewById(R.id.textQuestion2);





        buttonOp3 = findViewById(R.id.buttonOption3);
        buttonOp4 = findViewById(R.id.buttonOption4);
        buttonOp5 = findViewById(R.id.buttonOption5);

        textLevel2.setText("Question : " + level2 + " / 10");
        textRightAnswered2.setText("SCORE " + great2 + " / 10");




        if (level2 < 10) {
            getARandomQuestion();

        }
    }
    private int getARandomQuestion() {
        isTimerRunning = true;
        buttonOp3.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOp4.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOp5.setBackgroundResource(R.drawable.buttons_option_bg);
        timer(10000);


        // get random number for question

        int firstNumber = new Random().nextInt(10);
        int secondNumber = new Random().nextInt(10);


        // get random operation (+ , - , *)

        int operation = new Random().nextInt(3) + 1;

        // get two options

        int optionA = new Random().nextInt(100); // max number 10 , 10 * 10 = 100 then we add 100 as a max number
        int optionB = new Random().nextInt(100);
        int optionc = -1;
        if (operation == 1) {
            realOperation2 = "+";
            rightAnswer2 = firstNumber + secondNumber;
            textQuestion2.setText(firstNumber + " " + realOperation2 + " " + secondNumber + " = ?");
        } else {
            if (operation == 2) {
                realOperation2 = "*";
                rightAnswer2 = firstNumber * secondNumber;
                textQuestion2.setText(firstNumber + " " + realOperation2 + " " + secondNumber + " = ?");
            } else {
                if (operation == 3) {
                    realOperation2 = "-";

                    if (firstNumber < secondNumber) {
                        rightAnswer2 = secondNumber - firstNumber;
                        textQuestion2.setText(secondNumber + " " + realOperation2 + " " + firstNumber + " = ?");
                    } else {
                        rightAnswer2 = firstNumber - secondNumber;
                        textQuestion2.setText(firstNumber + " " + realOperation2 + " " + secondNumber + " = ?");

                    }

                }
            }

        }


        // get random position of right answer

        int position = new Random().nextInt(3) + 1; // 1 or 2 or 3 position

        if (position == 1) {
            buttonOp3.setText("" + rightAnswer2);
            buttonOp4.setText("" + optionA);
            buttonOp5.setText("" + optionB);
        } else {
            buttonOp3.setText("" + optionA);
            if (position == 2) {
                buttonOp4.setText("" + rightAnswer2);
                buttonOp5.setText("" + optionB);
            } else {
                buttonOp4.setText("" + optionB);
                buttonOp5.setText("" + rightAnswer2);

            }
        }

        buttonOp3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer2.cancel();
                if (buttonOp3.getText().equals("" + rightAnswer2)) {
                    buttonOp3.setBackgroundResource(R.drawable.right_answer_bg);
                    great2 = great2 + 1; // Increment score only when the answer is correct
                } else {
                    buttonOp3.setBackgroundResource(R.drawable.wrong_answer_bg);
                }
                level2 = level2 + 1;
                textLevel2.setText("Question : " + level2 + " / 10");
                textRightAnswered2.setText("SCORE : " + great2 + " / 10");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level2 < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                            intent.putExtra("RA", great2);
                            startActivity(intent);
                            finish();
                        }
                    }
                }, 1000); // 1 sec

            }

        });


// Similarly, update the onClick listeners for buttonOp14 and buttonOp15




        buttonOp4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textQuestion2.setText(firstNumber + realOperation2 + secondNumber + "=" + rightAnswer2);
                countDownTimer2.cancel();
                if (buttonOp4.getText().equals("" + rightAnswer2)) {
                    buttonOp4.setBackgroundResource(R.drawable.right_answer_bg);
                    great2 = great2 + 1;
                    level2 = level2 + 1;
                    textLevel2.setText("Question : " + level2 + " / 10");
                    textRightAnswered2.setText("SCORE : " + great2 + " / 10");
                } else {
                    level2 = level2 + 1;
                    textLevel2.setText("Question : " + level2 + " / 10");
                    buttonOp4.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level2 < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                            intent.putExtra("RA", great2);
                            startActivity(intent);
                            finish();
                        }

                    }
                }, 1000); // 1 sec

            }
        });

        buttonOp5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textQuestion2.setText(firstNumber + realOperation2 + secondNumber + "=" + rightAnswer2);
                countDownTimer2.cancel();
                if (buttonOp5.getText().equals("" + rightAnswer2)) {
                    buttonOp5.setBackgroundResource(R.drawable.right_answer_bg);
                    great2 = great2 + 1;
                    level2 = level2 + 1;
                    textLevel2.setText("Question : " + level2 + " / 10");
                    textRightAnswered2.setText("SCORE : " + great2 + " / 10");
                } else {
                    level2 = level2 + 1;
                    textLevel2.setText("Question : " + level2 + " / 10");
                    buttonOp5.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level2 < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                            intent.putExtra("RA", great2);
                            startActivity(intent);
                            finish();
                        }

                    }
                }, 1000); // 1 sec
            }
        });




        return firstNumber;
    }
    public void timer(long time) {
        countDownTimer2 = new CountDownTimer(time, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(millisUntilFinished / 1000) + "s");

                if (millisUntilFinished < 5000) {
                    timer.setTextColor(Color.YELLOW);
                } else {
                    timer.setTextColor(Color.BLACK);
                }
            }

            @Override
            public void onFinish() {
                timer.setText("Time over!");
                isTimerRunning = false;
                timeout();
            }
        }.start();


    }

    public void timeout() {
        if (isTimerRunning) {
            // The timer is still running.
        } else {
            // The timer has stopped.

            countDownTimer2.cancel();

            // Check if any of the buttons have the correct answer and highlight them
            if (buttonOp3.getText().equals("" + rightAnswer2)) {
                buttonOp3.setBackgroundResource(R.drawable.right_answer_bg);
            } else if (buttonOp4.getText().equals("" + rightAnswer2)) {
                buttonOp4.setBackgroundResource(R.drawable.right_answer_bg);
            } else if (buttonOp5.getText().equals("" + rightAnswer2)) {
                buttonOp5.setBackgroundResource(R.drawable.right_answer_bg);
            }

            level2 = level2 + 1;
            textLevel2.setText("Question : " + level2 + " / 10");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (level2 < 10) {
                        getARandomQuestion();
                    } else {
                        Intent intent = new Intent(MainActivity5.this, MainActivity2.class);
                        intent.putExtra("RA", great2);
                        startActivity(intent);
                        finish();
                    }
                }
            }, 1000); // 1 sec
        }
    }


}