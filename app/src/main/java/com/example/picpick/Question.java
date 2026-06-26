package com.example.picpick;

public class Question {
    private String questionText;
    private int option1ImageResId;
    private String option1Text;
    private int option2ImageResId;
    private String option2Text;
    private int correctOptionIndex; // 0 for option1, 1 for option2

    public Question(String questionText, int option1ImageResId, String option1Text,
                    int option2ImageResId, String option2Text, int correctOptionIndex) {
        this.questionText = questionText;
        this.option1ImageResId = option1ImageResId;
        this.option1Text = option1Text;
        this.option2ImageResId = option2ImageResId;
        this.option2Text = option2Text;
        this.correctOptionIndex = correctOptionIndex;
    }

    public String getQuestionText() {
        return questionText;
    }

    public int getOption1ImageResId() {
        return option1ImageResId;
    }

    public String getOption1Text() {
        return option1Text;
    }

    public int getOption2ImageResId() {
        return option2ImageResId;
    }

    public String getOption2Text() {
        return option2Text;
    }

    public int getCorrectOptionIndex() {
        return correctOptionIndex;
    }
}