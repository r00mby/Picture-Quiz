package com.example.picpick;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    // Level 1: Drinks questions
    public static List<Question> getDrinksQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Which drink contains milk?",
                R.drawable.cappuccino, "Cappuccino",
                R.drawable.espresso, "Espresso",
                0)); // Cappuccino contains milk

        questions.add(new Question(
                "Which is a carbonated drink?",
                R.drawable.orange_juice, "Orange Juice",
                R.drawable.cola, "Cola",
                1)); // Cola is carbonated

        questions.add(new Question(
                "Which drink is typically served hot?",
                R.drawable.iced_tea, "Iced Tea",
                R.drawable.hot_chocolate, "Hot Chocolate",
                1)); // Hot chocolate is served hot

        questions.add(new Question(
                "What is the drink that never expires?",
                R.drawable.honey, "Honey",
                R.drawable.water, "Water",
                0)); // Wine is made from fermented grapes

        questions.add(new Question(
                "Which drink contains caffeine?",
                R.drawable.milk, "Milk",
                R.drawable.coffee, "Coffee",
                1)); // Coffee contains caffeine

        return questions;
    }

    // Level 2: Food questions
    public static List<Question> getFoodQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Which food contains cheese?",
                R.drawable.pizza, "Pizza",
                R.drawable.fruit_salad, "Fruit Salad",
                0)); // Pizza contains cheese

        questions.add(new Question(
                "Which is a vegetable?",
                R.drawable.apple, "Apple",
                R.drawable.carrot, "Carrot",
                1)); // Carrot is a vegetable

        questions.add(new Question(
                "Which food is typically eaten for breakfast?",
                R.drawable.cereal, "Cereal",
                R.drawable.steak, "Steak",
                0)); // Cereal is typically eaten for breakfast

        questions.add(new Question(
                "Which food is a dessert?",
                R.drawable.ice_cream, "Ice Cream",
                R.drawable.sandwich, "Sandwich",
                0)); // Ice cream is a dessert

        questions.add(new Question(
                "Which food is made from wheat flour?",
                R.drawable.rice, "Rice",
                R.drawable.bread, "Bread",
                1)); // Bread is made from wheat flour

        return questions;
    }

    // Level 3: Animal questions
    public static List<Question> getAnimalQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "Which animal can fly?",
                R.drawable.eagle, "Eagle",
                R.drawable.lion, "Lion",
                0)); // Eagle can fly

        questions.add(new Question(
                "Which animal lives in water?",
                R.drawable.elephant, "Elephant",
                R.drawable.fish, "Fish",
                1)); // Fish lives in water

        questions.add(new Question(
                "Which animal is a mammal?",
                R.drawable.snake, "Snake",
                R.drawable.dolphin, "Dolphin",
                1)); // Dolphin is a mammal

        questions.add(new Question(
                "Which animal is nocturnal?",
                R.drawable.owl, "Owl",
                R.drawable.rabbit, "Rabbit",
                0)); // Owl is nocturnal

        questions.add(new Question(
                "Which animal is the fastest land animal?",
                R.drawable.cheetah, "Cheetah",
                R.drawable.turtle, "Turtle",
                0)); // Cheetah is the fastest land animal

        return questions;
    }

    // Level 4: Math questions (without images, with smarter questions)
    public static List<Question> getMathQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question(
                "If x + 15 = 23, what is the value of x?",
                0, "x = 8",
                0, "x = 7",
                0)); // Answer: x = 8

        questions.add(new Question(
                "Solve for y: 3y - 6 = 15",
                0, "y = 7",
                0, "y = 9",
                0)); // Answer: y = 7

        questions.add(new Question(
                "Which is the solution to 2(x + 3) = 14?",
                0, "x = 4",
                0, "x = 5",
                0)); // Answer: x = 4

        questions.add(new Question(
                "If a rectangle has a length of 12 cm and a width of 5 cm, what is its area?",
                0, "60 square cm",
                0, "34 square cm",
                0)); // Answer: 60 square cm

        questions.add(new Question(
                "What is the value of 3² + 4²?",
                0, "25",
                0, "49",
                0)); // Answer: 25 (9 + 16 = 25)

        return questions;
    }
}