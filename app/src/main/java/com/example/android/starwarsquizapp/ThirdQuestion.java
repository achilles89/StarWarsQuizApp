package com.example.android.starwarsquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Illó István Gábor on 26/01/2018.
 */

public class ThirdQuestion extends AppCompatActivity {
    //These are the global variables
    ImageView image1;
    TextView question;
    RadioGroup g1group;
    RadioButton q1_aButton, q1_bButton, q1_cButton, q1_dButton;
    TextView solution2 = null;
    Button submitButton;
    Button next = null;
    public int total = 0;
    public int QuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_buttons);

        //Sent score as intent
        Bundle extras = getIntent().getExtras();
        total = extras.getInt("total");
        QuestionNumber = extras.getInt("QuestionNumber");

        //Wiring the xlm elements to the variables
        image1 = findViewById(R.id.questionImage);
        question = findViewById(R.id.question);
        g1group = findViewById(R.id.answers_2);
        q1_aButton = findViewById(R.id.answer_2_a);
        q1_bButton = findViewById(R.id.answer_2_b);
        q1_cButton = findViewById(R.id.answer_2_c);
        q1_dButton = findViewById(R.id.answer_2_d);
        solution2 = findViewById(R.id.solution);
        submitButton = findViewById(R.id.submit_button);
        next = findViewById(R.id.next);
        image1.setImageResource(R.drawable.question3);
        question.setText(R.string.third_q);
        q1_aButton.setText(R.string.q_3_a);
        q1_bButton.setText(R.string.q_3_b);
        q1_cButton.setText(R.string.q_3_c);
        q1_dButton.setText(R.string.q_3_d);

    }

    //This happens when clicking on submitButton
    public void submitButton(View view) {
        // if there is an answer
        if (q1_aButton.isChecked() || q1_bButton.isChecked() || q1_cButton.isChecked() || q1_dButton.isChecked()) {

            if (q1_cButton.isChecked()) {
                //if answer is correct
                q1_cButton.setTextColor(ContextCompat.getColor(ThirdQuestion.this, R.color.colorGreen));
                solution2.setText(getString(R.string.correct));
                total += 1;
            } else {
                //if answer is not  correct
                q1_aButton.setTextColor(ContextCompat.getColor(ThirdQuestion.this, R.color.colorRed));
                q1_bButton.setTextColor(ContextCompat.getColor(ThirdQuestion.this, R.color.colorRed));
                q1_dButton.setTextColor(ContextCompat.getColor(ThirdQuestion.this, R.color.colorRed));
                solution2.setText(getString(R.string.wrong_solution) + " " + (getString(R.string.q_3_c)));
            }
            //change button from Submit to Next
            submitButton.setVisibility(View.INVISIBLE);
            next.setVisibility(View.VISIBLE);
        } else
        //if there is not an answer
        {
            Toast ToastMessage = Toast.makeText(getApplicationContext(), (R.string.no_selection), Toast.LENGTH_SHORT);
            View toastView = ToastMessage.getView();
            toastView.setBackgroundColor(ContextCompat.getColor(ThirdQuestion.this, R.color.colorBlack));
            ToastMessage.show();
        }

    }

    ////This happens when clicking on Next button; starting the next activity.
    public void next(View view) {
        QuestionNumber += 1;
        Intent nextQuestion = (new Intent(ThirdQuestion.this, FourthQuestion.class));
        nextQuestion.putExtra("total", total);
        nextQuestion.putExtra("QuestionNumber", QuestionNumber);
        startActivity(nextQuestion);

    }
}


