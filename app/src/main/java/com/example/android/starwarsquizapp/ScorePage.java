package com.example.android.starwarsquizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Illó István Gábor on 26/01/2018.
 */

public class ScorePage extends AppCompatActivity {
    public int total = 0;
    public int QuestionNumber;
    TextView scoreView, sumView;
    ImageView scoreImage;
    TextView resultText;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores_at_the_end);
        Bundle extras = getIntent().getExtras();
        //display score
        scoreView = findViewById(R.id.right);
        total = extras.getInt("total");
        scoreView.setText(String.valueOf(total));
        sumView = findViewById(R.id.sum);
        QuestionNumber = extras.getInt("QuestionNumber");
        sumView.setText(String.valueOf(QuestionNumber));
        scoreImage = findViewById(R.id.ScoreImage);
        resultText = findViewById(R.id.result_text);


            if (total <5) {
                //if score is below 5 points
                resultText.setText(getString(R.string.result_padawan));
                scoreImage.setImageResource(R.drawable.scorepadawan);

            } else if (total >8) {
                //if score is above 8 points
                resultText.setText(getString(R.string.result_master));
                scoreImage.setImageResource(R.drawable.scoremaster);

            } else {
                //if score is between 5 and 8 points
                resultText.setText(getString(R.string.result_jedi));
                scoreImage.setImageResource(R.drawable.scorejedi);
            }


    }

    public void restartButton(View view) {
        finish();
        Intent intent = new Intent(ScorePage.this, MainActivity.class);
        startActivity(intent);

    }


}