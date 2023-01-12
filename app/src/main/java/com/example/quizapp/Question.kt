package com.example.quizapp

data class Question(
    val id: Int,
    val question: String,
    val drawable: Int,
    val optionOne: String,
    val optionTwo: String,
    val optionThree: String,
    val optionFourth: String,
    val correctAnswer: Int,
)
