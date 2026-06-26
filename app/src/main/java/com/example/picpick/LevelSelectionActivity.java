package com.example.picpick;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LevelSelectionActivity extends AppCompatActivity {

    private TextView tvWelcome;
    private Button btnLevel1;
    private Button btnLevel2;
    private Button btnLevel3;
    private Button btnLevel4;
    private ImageView homeIcon;
    private String userName;
    private UserProgressManager progressManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);

        // Get the user name from the intent
        userName = getIntent().getStringExtra("USER_NAME");
        if (userName == null) {
            userName = "User"; // Default name if none provided
        }

        progressManager = new UserProgressManager(this);
        int highestLevel = progressManager.getHighestLevel(userName);

        tvWelcome = findViewById(R.id.tvWelcome);
        btnLevel1 = findViewById(R.id.btnLevel1);
        btnLevel2 = findViewById(R.id.btnLevel2);
        btnLevel3 = findViewById(R.id.btnLevel3);
        btnLevel4 = findViewById(R.id.btnLevel4);
        homeIcon = findViewById(R.id.homeIcon);

        // Set welcome message with user name
        tvWelcome.setText("Hello, " + userName);

        // Configure level buttons based on user progress
        setupLevelButtons(highestLevel);

        // Set click listener for home icon
        homeIcon.setOnClickListener(v -> {
            // Navigate to RegisterActivity
            Intent intent = new Intent(LevelSelectionActivity.this, RegisterActivity.class);
            startActivity(intent);
            finish(); // Close the current activity
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Refresh button states when returning to this activity
        int highestLevel = progressManager.getHighestLevel(userName);
        setupLevelButtons(highestLevel);
    }

    private void setupLevelButtons(int highestLevel) {
        // Level 1 is always enabled
        btnLevel1.setOnClickListener(v -> startQuiz(1));
        btnLevel1.setBackgroundResource(R.drawable.option_button_background);

        // Configure Level 2
        if (highestLevel >= 2) {
            btnLevel2.setEnabled(true);
            btnLevel2.setOnClickListener(v -> startQuiz(2));
            btnLevel2.setBackgroundResource(R.drawable.option_button_background);
        } else {
            btnLevel2.setEnabled(false);
            btnLevel2.setBackgroundColor(Color.GRAY);
        }

        // Configure Level 3
        if (highestLevel >= 3) {
            btnLevel3.setEnabled(true);
            btnLevel3.setOnClickListener(v -> startQuiz(3));
            btnLevel3.setBackgroundResource(R.drawable.option_button_background);
        } else {
            btnLevel3.setEnabled(false);
            btnLevel3.setBackgroundColor(Color.GRAY);
        }

        // Configure Level 4
        if (highestLevel >= 4) {
            btnLevel4.setEnabled(true);
            btnLevel4.setOnClickListener(v -> startQuiz(4));
            btnLevel4.setBackgroundResource(R.drawable.option_button_background);
        } else {
            btnLevel4.setEnabled(false);
            btnLevel4.setBackgroundColor(Color.GRAY);
        }

        // Highlight the current focus level
        highlightCurrentLevel(highestLevel);
    }

    private void highlightCurrentLevel(int currentLevel) {
        // Reset all buttons to default style
        btnLevel1.setTextColor(getResources().getColor(R.color.black));
        btnLevel2.setTextColor(getResources().getColor(R.color.black));
        btnLevel3.setTextColor(getResources().getColor(R.color.black));
        btnLevel4.setTextColor(getResources().getColor(R.color.black));

        // Highlight the current level
        switch (currentLevel) {
            case 1:
                btnLevel1.setTextColor(getResources().getColor(R.color.white));
                btnLevel1.setBackgroundResource(R.drawable.highlighted_button_background);
                break;
            case 2:
                btnLevel2.setTextColor(getResources().getColor(R.color.white));
                btnLevel2.setBackgroundResource(R.drawable.highlighted_button_background);
                break;
            case 3:
                btnLevel3.setTextColor(getResources().getColor(R.color.white));
                btnLevel3.setBackgroundResource(R.drawable.highlighted_button_background);
                break;
            case 4:
                btnLevel4.setTextColor(getResources().getColor(R.color.white));
                btnLevel4.setBackgroundResource(R.drawable.highlighted_button_background);
                break;
        }
    }

    private void startQuiz(int level) {
        Intent intent = new Intent(LevelSelectionActivity.this, QuestionActivity.class);
        intent.putExtra("LEVEL", level);
        intent.putExtra("USER_NAME", userName);
        startActivity(intent);
    }
}