package com.example.android.starwarsquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Illó István Gábor on 26/01/2018.
 */

public class SeventhQuestion extends AppCompatActivity {
    //global variables
    ImageView questionImage;
    TextView question, solution;
    EditText editTxtAnswer;
    Button checkButton, next;
    public int total;
    public int QuestionNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_boxes);
//sent score as intent
        Bundle extras = getIntent().getExtras();
        total = extras.getInt("total");
        QuestionNumber = extras.getInt("QuestionNumber");

        //which seventh question global variables
        questionImage = findViewById(R.id.questionImage);
        question = findViewById(R.id.question);
        solution = findViewById(R.id.solution);
        editTxtAnswer = findViewById(R.id.txtAnswer);
        checkButton = findViewById(R.id.submit_button);
        next = findViewById(R.id.next);
        questionImage.setImageResource(R.drawable.question7);
        question.setText(R.string.seventh_q);
    }

    //submitButton click
    public void submitButton(View view) {
        String answer = editTxtAnswer.getText().toString().toLowerCase().trim();
        //if answer is correct
        if (answer.equals("dooku")) {
            total += 1;
            solution.setText(getString(R.string.correct));

        }
        //if answer is not  correct
        else {
            solution.setText(getString(R.string.wrong_solution) + " " + (getString(R.string.good_answer2)));
        }
        //change button
        checkButton.setVisibility(View.INVISIBLE);
        next.setVisibility(View.VISIBLE);

    }

    //checkButton click
    public void next(View view) {
        QuestionNumber += 1;
        Intent nextQuestion = (new Intent(SeventhQuestion.this, EighthQuestion.class));
        nextQuestion.putExtra("total", total);
        nextQuestion.putExtra("QuestionNumber", QuestionNumber);
        startActivity(nextQuestion);


    }

}