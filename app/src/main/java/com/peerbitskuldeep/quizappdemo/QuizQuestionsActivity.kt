package com.peerbitskuldeep.quizappdemo

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.AdaptiveIconDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Question>? = null
    private var mSelectedOptionsPosition: Int = 0
    private var mCorrectAns: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()
//        Log.d("TAG", "onCreate: ${questionsList.size}")

        /* var currentPosition = 1
        val question: Question? = questionsList[currentPosition-1]*/

      /*  progressBar.progress = currentPosition
        tvProgress.text = "$currentPosition"+"/"+ progressBar.max

        tvQuestion.text = question!!.question
        img.setImageResource(question.image)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour

        btnSubmit.setOnClickListener {

            currentPosition++
            questionsList[currentPosition]

        }
*/

        setQuestion()

        tvOptionOne.setOnClickListener(this)
        tvOptionTwo.setOnClickListener(this)
        tvOptionThree.setOnClickListener(this)
        tvOptionFour.setOnClickListener(this)
        btnSubmit.setOnClickListener(this)

    }

    private fun setQuestion()
    {
//        mCurrentPosition = 1
        val question = mQuestionsList?.get(mCurrentPosition-1)

        defaultOptionsView()


        if (mCurrentPosition == mQuestionsList!!.size)
        {
            btnSubmit.text = "FINISH"
        }
        else{
            btnSubmit.text = "Submit"
        }

        progressBar.progress = mCurrentPosition
        tvProgress.text = "$mCurrentPosition" + "/" + progressBar.max

        tvQuestion.text = question!!.question
        img.setImageResource(question.image)
        tvOptionOne.text = question.optionOne
        tvOptionTwo.text = question.optionTwo
        tvOptionThree.text = question.optionThree
        tvOptionFour.text = question.optionFour

    }

    private fun defaultOptionsView()
    {

        val options = ArrayList<TextView>()
        options.add(0, tvOptionOne)
        options.add(1, tvOptionTwo)
        options.add(2, tvOptionThree)
        options.add(3, tvOptionFour)

        for (option in options)
        {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.background = ContextCompat.getDrawable(this,
                R.drawable.tv_bg)
            option.typeface = Typeface.DEFAULT
        }
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.tvOptionOne -> selectedOptionsView(tvOptionOne,1)
            R.id.tvOptionTwo -> selectedOptionsView(tvOptionTwo,2)
            R.id.tvOptionThree -> selectedOptionsView(tvOptionThree,3)
            R.id.tvOptionFour -> selectedOptionsView(tvOptionFour,4)

            R.id.btnSubmit -> {

                if (mSelectedOptionsPosition == 0)
                {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else ->{

                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAns)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)

                        }
                    }
                }
                else
                {
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if (question?.correctAns != mSelectedOptionsPosition)
                    {
                        answerView(mSelectedOptionsPosition, R.drawable.wrong_tv_option_bg)
                    }
                    else
                    {
                        mCorrectAns++
                    }
                    answerView(question!!.correctAns, R.drawable.correct_tv_option_bg)

                    if (mCurrentPosition == mQuestionsList!!.size)
                    {
                        btnSubmit.text = "FINISH"
                    }
                    else{
                        btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionsPosition = 0
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int)
    {
        when(answer)
        {
            1->{
                tvOptionOne.background = ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            2->{
                tvOptionTwo.background =ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            3->{
                tvOptionThree.background =ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }

            4->{
                tvOptionFour.background =ContextCompat.getDrawable(
                    this,
                    drawableView
                )
            }
        }

    }

    private fun selectedOptionsView(tv: TextView,
                    selectedOptionNum: Int)
    {
        defaultOptionsView()

        mSelectedOptionsPosition = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.selected_tv_option_bg)
    }

}