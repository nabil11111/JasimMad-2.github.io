package com.example.mathsapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity4 extends AppCompatActivity {

    TextView timer;
    TextView textLevel5;
    TextView textRightAnswered5;
    TextView textQuestion5;


    Button buttonOP13;

    Button buttonOP14;

    Button buttonOP15;

    int level = 0;
    int great = 0;
    int rightAnswer = 0;
    String realOperation = "";
    CountDownTimer countDownTimer;
    private boolean isTimerRunning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        timer=findViewById(R.id.timertxt);

        textLevel5 = findViewById(R.id.textQuestionNumber5);
        textRightAnswered5 = findViewById(R.id.textRightAnswered5);
        textQuestion5 = findViewById(R.id.textQuestion5);





        buttonOP13 = findViewById(R.id.buttonOP13);
        buttonOP14 = findViewById(R.id.buttonOP14);
        buttonOP15 = findViewById(R.id.buttonOP15);

        textLevel5.setText("Question : " + level + " / 10");
        textRightAnswered5.setText("SCORE " + great + " / 10");




        if (level < 10) {
            getARandomQuestion();
    }
}
    private int getARandomQuestion() {
        isTimerRunning = true;
        buttonOP13.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOP14.setBackgroundResource(R.drawable.buttons_option_bg);
        buttonOP15.setBackgroundResource(R.drawable.buttons_option_bg);
        timer(20000);


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
            realOperation = "+";
            rightAnswer = firstNumber + secondNumber;
            textQuestion5.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
        } else {
            if (operation == 2) {
                realOperation = "*";
                rightAnswer = firstNumber * secondNumber;
                textQuestion5.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");
            } else {
                if (operation == 3) {
                    realOperation = "-";

                    if (firstNumber < secondNumber) {
                        rightAnswer = secondNumber - firstNumber;
                        textQuestion5.setText(secondNumber + " " + realOperation + " " + firstNumber + " = ?");
                    } else {
                        rightAnswer = firstNumber - secondNumber;
                        textQuestion5.setText(firstNumber + " " + realOperation + " " + secondNumber + " = ?");

                    }

                }
            }

        }


        // get random position of right answer

        int position = new Random().nextInt(3) + 1; // 1 or 2 or 3 position

        if (position == 1) {
            buttonOP13.setText("" + rightAnswer);
            buttonOP14.setText("" + optionA);
            buttonOP15.setText("" + optionB);
        } else {
            buttonOP13.setText("" + optionA);
            if (position == 2) {
                buttonOP14.setText("" + rightAnswer);
                buttonOP15.setText("" + optionB);
            } else {
                buttonOP14.setText("" + optionB);
                buttonOP15.setText("" + rightAnswer);

            }
        }

        buttonOP13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                countDownTimer.cancel();
                if (buttonOP13.getText().equals("" + rightAnswer)) {
                    buttonOP13.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1; // Increment score only when the answer is correct
                } else {
                    buttonOP13.setBackgroundResource(R.drawable.wrong_answer_bg);
                }
                level = level + 1;
                textLevel5.setText("Question : " + level + " / 10");
                textRightAnswered5.setText("SCORE : " + great + " / 10");

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                            intent.putExtra("RA", great);
                            startActivity(intent);
                            finish();
                        }
                    }
                }, 1000); // 1 sec
            }
        });

// Similarly, update the onClick listeners for buttonOp14 and buttonOp15




        buttonOP14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textQuestion5.setText(firstNumber + realOperation + secondNumber + "=" + rightAnswer);
                countDownTimer.cancel();
                if (buttonOP14.getText().equals("" + rightAnswer)) {
                    buttonOP14.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel5.setText("Question : " + level + " / 10");
                    textRightAnswered5.setText("SCORE : " + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel5.setText("Question : " + level + " / 10");
                    buttonOP14.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                            intent.putExtra("RA", great);
                            startActivity(intent);
                            finish();
                        }

                    }
                }, 1000); // 1 sec
            }
        });

        buttonOP15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textQuestion5.setText(firstNumber + realOperation + secondNumber + "=" + rightAnswer);
                countDownTimer.cancel();
                if (buttonOP15.getText().equals("" + rightAnswer)) {
                    buttonOP15.setBackgroundResource(R.drawable.right_answer_bg);
                    great = great + 1;
                    level = level + 1;
                    textLevel5.setText("Question : " + level + " / 10");
                    textRightAnswered5.setText("SCORE : " + great + " / 10");
                } else {
                    level = level + 1;
                    textLevel5.setText("Question : " + level + " / 10");
                    buttonOP15.setBackgroundResource(R.drawable.wrong_answer_bg);
                }

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (level < 10) {
                            getARandomQuestion();
                        } else {
                            Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
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
    public void timer(long time) {
        countDownTimer = new CountDownTimer(time, 1000) {
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

            countDownTimer.cancel();

            // Check if any of the buttons have the correct answer and highlight them
            if (buttonOP13.getText().equals("" + rightAnswer)) {
                buttonOP13.setBackgroundResource(R.drawable.right_answer_bg);
            } else if (buttonOP14.getText().equals("" + rightAnswer)) {
                buttonOP14.setBackgroundResource(R.drawable.right_answer_bg);
            } else if (buttonOP15.getText().equals("" + rightAnswer)) {
                buttonOP15.setBackgroundResource(R.drawable.right_answer_bg);
            }

            level = level + 1;
            textLevel5.setText("Question : " + level + " / 10");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (level < 10) {
                        getARandomQuestion();
                    } else {
                        Intent intent = new Intent(MainActivity4.this, MainActivity2.class);
                        intent.putExtra("RA", great);
                        startActivity(intent);
                        finish();
                    }
                }
            }, 1000); // 1 sec
        }
    }




}