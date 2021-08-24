package com.peerbitskuldeep.quizappdemo

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_que"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>
    {

        var questionsList = ArrayList<Question>()

        var q1 = Question(
            1,
            "Which animal is it?",
            R.drawable.lion,
            "Lion",
            "Panda",
            "Tiger",
            "Monkey",
            1
        )

        questionsList.add(q1)

        var q2 = Question(
            2,
            "Which animal is it?",
            R.drawable.cat,
            "Lion",
            "Panda",
            "Tiger",
            "Cat",
            4
        )
        questionsList.add(q2)

        var q3 = Question(
            3,
            "Which animal is it?",
            R.drawable.dog,
            "Lion",
            "Dog",
            "Tiger",
            "Whale",
            2
        )
        questionsList.add(q3)

        var q4 = Question(
            4,
            "Which animal is it?",
            R.drawable.elephant,
            "Lion",
            "Elephant",
            "Tiger",
            "Horse",
            2
        )
        questionsList.add(q4)

        var q5 = Question(
            5,
            "Which animal is it?",
            R.drawable.leopard,
            "Leopard",
            "Panda",
            "Tiger",
            "Cat",
            1
        )
        questionsList.add(q5)

        var q6 = Question(
            6,
            "Which animal is it?",
            R.drawable.panda,
            "Lion",
            "Panda",
            "Tiger",
            "Cat",
            2
        )
        questionsList.add(q6)

        return questionsList

    }

}