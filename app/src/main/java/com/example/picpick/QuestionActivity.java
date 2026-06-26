package com.example.picpick;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;
import java.util.Random;

public class QuestionActivity extends AppCompatActivity {

    private TextView tvQuestionNumber;
    private TextView tvQuestion;
    private ImageView ivOption1;
    private ImageView ivOption2;
    private RadioButton rbOption1;
    private RadioButton rbOption2;
    private RadioGroup rgOptions;
    private Button btnNext;
    private TextView tvFeedback;

    private List<Question> questions;
    private int randomQuestionIndex;
    private int level;
    private String userName;
    private boolean questionAnswered = false;
    private boolean answerCorrect = false;
    private UserProgressManager progressManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        // Get level and user name from intent
        level = getIntent().getIntExtra("LEVEL", 1);
        userName = getIntent().getStringExtra("USER_NAME");
        progressManager = new UserProgressManager(this);

        // Initialize views
        tvQuestionNumber = findViewById(R.id.tvQuestionNumber);
        tvQuestion = findViewById(R.id.tvQuestion);
        ivOption1 = findViewById(R.id.ivOption1);
        ivOption2 = findViewById(R.id.ivOption2);
        rbOption1 = findViewById(R.id.rbOption1);
        rbOption2 = findViewById(R.id.rbOption2);
        rgOptions = findViewById(R.id.rgOptions);
        btnNext = findViewById(R.id.btnNext);
        tvFeedback = findViewById(R.id.tvFeedback);

        // Load questions based on level
        loadQuestions();

        // Select a random question
        Random random = new Random();
        randomQuestionIndex = random.nextInt(questions.size());

        // Display the random question
        displayQuestion();

        // Set click listeners for radio buttons
        rbOption1.setOnClickListener(v -> {
            if (!questionAnswered) {
                selectOption(0);
            }
        });

        rbOption2.setOnClickListener(v -> {
            if (!questionAnswered) {
                selectOption(1);
            }
        });

        btnNext.setOnClickListener(v -> {
            if (!questionAnswered) {
                Toast.makeText(this, "Please select an answer first", Toast.LENGTH_SHORT).show();
                return;
            }

            if (answerCorrect) {
                // If answer is correct, proceed to next level or completion
                if (level < 4) {
                    // Update progress and move to next level
                    progressManager.setHighestLevel(userName, level + 1);
                    Intent intent = new Intent(QuestionActivity.this, LevelCompletedActivity.class);
                    intent.putExtra("CORRECT_ANSWERS", 1);
                    intent.putExtra("TOTAL_QUESTIONS", 1);
                    intent.putExtra("USER_NAME", userName);
                    intent.putExtra("LEVEL", level);
                    intent.putExtra("NEXT_LEVEL", level + 1);
                    startActivity(intent);
                } else {
                    // Completed all levels
                    Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                    intent.putExtra("CORRECT_ANSWERS", 1);
                    intent.putExtra("TOTAL_QUESTIONS", 1);
                    intent.putExtra("USER_NAME", userName);
                    intent.putExtra("LEVEL", level);
                    intent.putExtra("ALL_LEVELS_COMPLETED", true);
                    intent.putExtra("LEVEL_PASSED", true);
                    startActivity(intent);
                }
            } else {
                // If answer is incorrect, go to result screen
                Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
                intent.putExtra("CORRECT_ANSWERS", 0);
                intent.putExtra("TOTAL_QUESTIONS", 1);
                intent.putExtra("USER_NAME", userName);
                intent.putExtra("LEVEL", level);
                intent.putExtra("ALL_LEVELS_COMPLETED", false);
                intent.putExtra("LEVEL_PASSED", false);
                startActivity(intent);
            }
            finish();
        });
    }

    private void loadQuestions() {
        switch (level) {
            case 1:
                questions = QuestionBank.getDrinksQuestions();
                break;
            case 2:
                questions = QuestionBank.getFoodQuestions();
                break;
            case 3:
                questions = QuestionBank.getAnimalQuestions();
                break;
            case 4:
                questions = QuestionBank.getMathQuestions();
                break;
            default:
                questions = QuestionBank.getDrinksQuestions();
                break;
        }
    }

    private void displayQuestion() {
        Question currentQuestion = questions.get(randomQuestionIndex);

        tvQuestionNumber.setText("1/1");
        tvQuestion.setText(currentQuestion.getQuestionText());

        ivOption1.setImageResource(currentQuestion.getOption1ImageResId());
        rbOption1.setText(currentQuestion.getOption1Text());

        ivOption2.setImageResource(currentQuestion.getOption2ImageResId());
        rbOption2.setText(currentQuestion.getOption2Text());

        // Reset radio buttons
        rbOption1.setChecked(false);
        rbOption2.setChecked(false);

        // Hide feedback initially
        tvFeedback.setVisibility(View.INVISIBLE);
    }

    private void selectOption(int selectedOption) {
        Question currentQuestion = questions.get(randomQuestionIndex);
        int correctOption = currentQuestion.getCorrectOptionIndex();

        // Mark this question as answered
        questionAnswered = true;

        // Disable radio buttons to prevent changing answer
        rbOption1.setEnabled(false);
        rbOption2.setEnabled(false);

        // Check if answer is correct
        answerCorrect = (selectedOption == correctOption);

        if (answerCorrect) {
            tvFeedback.setText("Correct!");
            tvFeedback.setTextColor(getResources().getColor(R.color.green));
        } else {
            tvFeedback.setText("Incorrect! The correct answer was " +
                    (correctOption == 0 ? currentQuestion.getOption1Text() : currentQuestion.getOption2Text()));
            tvFeedback.setTextColor(getResources().getColor(R.color.red));
        }

        tvFeedback.setVisibility(View.VISIBLE);
    }
}