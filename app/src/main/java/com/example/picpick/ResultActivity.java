package com.example.picpick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView tvScore;
    private TextView tvMessage;
    private TextView tvCongratulations;
    private ImageView ivResult;
    private Button btnBackToHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        // Get data from intent
        int correctAnswers = getIntent().getIntExtra("CORRECT_ANSWERS", 0);
        int totalQuestions = getIntent().getIntExtra("TOTAL_QUESTIONS", 1);
        String userName = getIntent().getStringExtra("USER_NAME");
        boolean allLevelsCompleted = getIntent().getBooleanExtra("ALL_LEVELS_COMPLETED", false);
        boolean levelPassed = getIntent().getBooleanExtra("LEVEL_PASSED", correctAnswers == 1);

        // Initialize views
        tvCongratulations = findViewById(R.id.tvCongratulations);
        tvScore = findViewById(R.id.tvScore);
        tvMessage = findViewById(R.id.tvMessage);
        ivResult = findViewById(R.id.ivResult);
        btnBackToHome = findViewById(R.id.btnBackToHome);

        // Set score
        tvScore.setText(correctAnswers + "/" + totalQuestions);

        // Configure UI based on result
        if (allLevelsCompleted && levelPassed) {
            // All levels completed successfully
            tvCongratulations.setText("Congratulations!");
            tvMessage.setText("You have completed all levels successfully!");
            ivResult.setImageResource(R.drawable.trophy);
        } else if (levelPassed) {
            // Level passed but not all levels completed
            tvCongratulations.setText("You are Great!");
            tvMessage.setText("You passed this level!");
            ivResult.setImageResource(R.drawable.trophy);
        } else {
            // Level failed - use question_mark_logo instead of failure
            tvCongratulations.setText("Try Again");
            tvMessage.setText("You answered incorrectly. Don't give up!");
            ivResult.setImageResource(R.drawable.question_mark_logo);
        }

        // Set click listener for back to home button
        btnBackToHome.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, LevelSelectionActivity.class);
            intent.putExtra("USER_NAME", userName);
            startActivity(intent);
            finish();
        });
    }
}