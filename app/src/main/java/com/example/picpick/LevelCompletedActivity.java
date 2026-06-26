package com.example.picpick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LevelCompletedActivity extends AppCompatActivity {

    private TextView tvLevelCompleted;
    private TextView tvScore;
    private TextView tvMessage;
    private Button btnNextLevel;
    private ImageView ivLevelComplete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_completed);

        // Get data from intent
        int correctAnswers = getIntent().getIntExtra("CORRECT_ANSWERS", 0);
        int totalQuestions = getIntent().getIntExtra("TOTAL_QUESTIONS", 1);
        String userName = getIntent().getStringExtra("USER_NAME");
        int completedLevel = getIntent().getIntExtra("LEVEL", 1);
        int nextLevel = getIntent().getIntExtra("NEXT_LEVEL", 2);

        // Initialize views
        tvLevelCompleted = findViewById(R.id.tvLevelCompleted);
        tvScore = findViewById(R.id.tvScore);
        tvMessage = findViewById(R.id.tvMessage);
        btnNextLevel = findViewById(R.id.btnNextLevel);
        ivLevelComplete = findViewById(R.id.ivLevelComplete);

        // Use a trophy icon instead of level_complete
        ivLevelComplete.setImageResource(R.drawable.trophy);

        // Set level completed text
        tvLevelCompleted.setText("Level " + completedLevel + " Completed!");

        // Set score
        tvScore.setText(correctAnswers + "/" + totalQuestions);

        // Set message
        tvMessage.setText("Congratulations " + userName + "! You've passed this level. " +
                "Get ready for Level " + nextLevel + "!");

        // Set click listener for next level button
        btnNextLevel.setOnClickListener(v -> {
            Intent intent = new Intent(LevelCompletedActivity.this, QuestionActivity.class);
            intent.putExtra("LEVEL", nextLevel);
            intent.putExtra("USER_NAME", userName);
            startActivity(intent);
            finish();
        });
    }
}